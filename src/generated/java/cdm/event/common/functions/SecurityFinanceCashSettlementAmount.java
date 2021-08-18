package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.legalagreement.csa.CollateralValuationTreatment;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.template.CollateralProvisions;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SecurityFinanceLeg;
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

@ImplementedBy(SecurityFinanceCashSettlementAmount.SecurityFinanceCashSettlementAmountDefault.class)
public abstract class SecurityFinanceCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPrice filterPrice;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param tradeState 
	* @param date 
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @param payerReceiver 
	* @return securityFinanceCashSettlementAmount 
	*/
	public Cashflow evaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		// pre-conditions
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(quantity)).get()) {
							return areEqual(MapperS.of(quantity).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FinancialUnitEnum>map("getFinancialUnit", _unitType -> _unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All);
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "";
		
			assert
				areEqual(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaProductIdentifier>mapC("getProductIdentifier", _observable -> _observable.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()), MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<Product>map("getSecurityInformation", _securityFinancePayout -> _securityFinancePayout.getSecurityInformation()).<Security>map("getSecurity", _product -> _product.getSecurity()).<ReferenceWithMetaProductIdentifier>mapC("getProductIdentifier", _productBase -> _productBase.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()), CardinalityOperator.All).get()
				: "";
		
		Cashflow.CashflowBuilder securityFinanceCashSettlementAmountHolder = doEvaluate(tradeState, date, quantity, payerReceiver);
		Cashflow.CashflowBuilder securityFinanceCashSettlementAmount = assignOutput(securityFinanceCashSettlementAmountHolder, tradeState, date, quantity, payerReceiver);
		
		if (securityFinanceCashSettlementAmount!=null) objectValidator.validateAndFailOnErorr(Cashflow.class, securityFinanceCashSettlementAmount);
		return securityFinanceCashSettlementAmount;
	}
	
	private Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder securityFinanceCashSettlementAmount, TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		securityFinanceCashSettlementAmount
			.getOrCreateCashflowAmount()
			.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(securityPrice(tradeState, date, quantity, payerReceiver).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(securityQuantity(tradeState, date, quantity, payerReceiver).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())), MapperS.of(marginRatio(tradeState, date, quantity, payerReceiver).get())).get())
		;
		securityFinanceCashSettlementAmount
			.getOrCreateCashflowAmount()
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(securityPrice(tradeState, date, quantity, payerReceiver).get()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get())
		;
		securityFinanceCashSettlementAmount
			.getOrCreatePayerReceiver()
			.setPayer(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(payerReceiver)).get()) {
						return MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			else {
						return MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			}).get())
		;
		securityFinanceCashSettlementAmount
			.getOrCreatePayerReceiver()
			.setReceiver(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(payerReceiver)).get()) {
						return MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			else {
						return MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			}).get())
		;
		securityFinanceCashSettlementAmount
			.getOrCreateCashflowDate()
			.setAdjustedDateValue(MapperS.of(date).get())
		;
		return securityFinanceCashSettlementAmount;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);
	
	
	protected Mapper<? extends SecurityFinancePayout> securityFinancePayout(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
	}
	
	protected Mapper<? extends SecurityFinanceLeg> securityFinanceLeg(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return MapperS.of(MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<SecurityFinanceLeg>mapC("getSecurityFinanceLeg", _securityFinancePayout -> _securityFinancePayout.getSecurityFinanceLeg()).get());
	}
	
	protected Mapper<? extends Quantity> securityQuantity(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(quantity)).get()) {
					return MapperS.of(quantity);
				}
		else {
					return MapperS.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(FinancialUnitEnum.SHARE).get()));
				}
		});
	}
	
	protected Mapper<? extends Price> securityPrice(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return MapperS.of(filterPrice.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(PriceTypeEnum.NET_PRICE).get()));
	}
	
	protected Mapper<BigDecimal> haircutPercentage(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(BigDecimal.valueOf(1.0)), MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getHaircutPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getHaircutPercentage()));
	}
	
	protected Mapper<BigDecimal> valuationPercentage(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return MapperMaths.<BigDecimal, Integer, BigDecimal>divide(MapperS.of(Integer.valueOf(1)), MapperS.of(haircutPercentage(tradeState, date, quantity, payerReceiver).get()));
	}
	
	protected Mapper<BigDecimal> marginRatio(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getHaircutPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getHaircutPercentage())).get()) {
					return MapperS.of(valuationPercentage(tradeState, date, quantity, payerReceiver).get());
				}
				else if (exists(MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage())).get()) {
					return MapperS.of(securityFinancePayout(tradeState, date, quantity, payerReceiver).get()).<CollateralProvisions>map("getCollateralProvisions", _securityFinancePayout -> _securityFinancePayout.getCollateralProvisions()).<CollateralValuationTreatment>map("getMarginPercentage", _collateralProvisions -> _collateralProvisions.getMarginPercentage()).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage());
				}
				else {
					return MapperS.of(BigDecimal.valueOf(1.0));
				}
		});
	}
	public static final class SecurityFinanceCashSettlementAmountDefault extends SecurityFinanceCashSettlementAmount {
		@Override
		protected  Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			return Cashflow.builder();
		}
	}
}
