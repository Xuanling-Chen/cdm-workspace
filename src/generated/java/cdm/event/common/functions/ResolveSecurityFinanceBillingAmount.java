package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.RateSchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.Create_Quantity;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Reset;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.legalagreement.csa.CollateralValuationTreatment;
import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.functions.FixedAmount;
import cdm.product.asset.functions.FloatingAmount;
import cdm.product.common.TradeLot;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.functions.CalculationPeriodRange;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.template.CollateralProvisions;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolveSecurityFinanceBillingAmount.ResolveSecurityFinanceBillingAmountDefault.class)
public abstract class ResolveSecurityFinanceBillingAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodRange calculationPeriodRange;
	@Inject protected Create_Quantity create_Quantity;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;
	@Inject protected FixedAmount fixedAmount;
	@Inject protected FloatingAmount floatingAmount;

	/**
	* @param tradeState 
	* @param reset 
	* @param recordStartDate 
	* @param recordEndDate 
	* @param transferDate 
	* @return transfer 
	*/
	public Transfer evaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		
		Transfer.TransferBuilder transferHolder = doEvaluate(tradeState, reset, recordStartDate, recordEndDate, transferDate);
		Transfer.TransferBuilder transfer = assignOutput(transferHolder, tradeState, reset, recordStartDate, recordEndDate, transferDate);
		
		if (transfer!=null) objectValidator.validateAndFailOnErorr(Transfer.class, transfer);
		return transfer;
	}
	
	private Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		transfer
			.getOrCreateQuantity()
			.setAmount(MapperS.of(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get())
		;
		transfer
			.getOrCreateQuantity()
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setPayerPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", _payerReceiver -> _payerReceiver.getPayerPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", _payerReceiver -> _payerReceiver.getReceiverPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			}).get())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setReceiverPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(performance(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", _payerReceiver -> _payerReceiver.getReceiverPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", _payerReceiver -> _payerReceiver.getPayerPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			}).get())
		;
		transfer
			.getOrCreateSettlementDate()
			.setAdjustedDateValue(MapperS.of(transferDate).get())
		;
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate);
	
	
	protected Mapper<? extends Quantity> securityQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperS.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(FinancialUnitEnum.SHARE).get()));
	}
	
	protected Mapper<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get());
	}
	
	protected Mapper<? extends SecurityFinancePayout> securityFinancePayout(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
	}
	
	protected Mapper<BigDecimal> haircutPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(BigDecimal.valueOf(1.0)), MapperS.of(securityFinancePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getHaircutPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getHaircutPercentage()));
	}
	
	protected Mapper<BigDecimal> valuationPercentage(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperMaths.<BigDecimal, Integer, BigDecimal>divide(MapperS.of(Integer.valueOf(1)), MapperS.of(haircutPercentage(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()));
	}
	
	protected Mapper<BigDecimal> marginRatio(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(securityFinancePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getHaircutPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getHaircutPercentage())).get()) {
					return MapperS.of(valuationPercentage(tradeState, reset, recordStartDate, recordEndDate, transferDate).get());
				}
				else if (exists(MapperS.of(securityFinancePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage())).get()) {
					return MapperS.of(securityFinancePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage());
				}
				else {
					return MapperS.of(BigDecimal.valueOf(1.0));
				}
		});
	}
	
	protected Mapper<? extends Quantity> billingQuantity(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperS.of(create_Quantity.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(reset).<Price>map("getResetValue", _reset -> _reset.getResetValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(securityQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())), MapperS.of(marginRatio(tradeState, reset, recordStartDate, recordEndDate, transferDate).get())).get(), null));
	}
	
	protected Mapper<? extends CalculationPeriodData> calculationPeriodRange(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return MapperS.of(calculationPeriodRange.evaluate(MapperS.of(recordStartDate).get(), MapperS.of(recordEndDate).get(), null));
	}
	
	protected Mapper<BigDecimal> performance(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate())).get()) {
					return MapperS.of(fixedAmount.evaluate(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get(), MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).<RateSchedule>map("getRateSchedule", _fixedRateSpecification -> _fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPrice>map("getInitialValue", _rateSchedule -> _rateSchedule.getInitialValue()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperS.of(billingQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get(), MapperS.of(recordEndDate).get(), MapperS.of(calculationPeriodRange(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get()));
				}
				else if (exists(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate())).get()) {
					return MapperS.of(floatingAmount.evaluate(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get(), MapperS.of(MapperS.of(interestRatePayout(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).<SpreadSchedule>mapC("getSpreadSchedule", _floatingRate -> _floatingRate.getSpreadSchedule()).get()).<ReferenceWithMetaPrice>map("getInitialValue", _rateSchedule -> _rateSchedule.getInitialValue()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperS.of(reset).<Price>map("getResetValue", _reset -> _reset.getResetValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperS.of(billingQuantity(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get(), MapperS.of(recordEndDate).get(), MapperS.of(calculationPeriodRange(tradeState, reset, recordStartDate, recordEndDate, transferDate).get()).get()));
				}
				else {
					return MapperS.ofNull();
				}
		});
	}
	public static final class ResolveSecurityFinanceBillingAmountDefault extends ResolveSecurityFinanceBillingAmount {
		@Override
		protected  Transfer.TransferBuilder doEvaluate(TradeState tradeState, Reset reset, Date recordStartDate, Date recordEndDate, Date transferDate) {
			return Transfer.builder();
		}
	}
}
