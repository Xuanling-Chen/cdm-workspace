package cdm.event.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.RateSchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.Reset;
import cdm.event.common.TradeState;
import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.functions.FixedAmount;
import cdm.product.asset.functions.FloatingAmount;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(InterestCashSettlementAmount.InterestCashSettlementAmountDefault.class)
public abstract class InterestCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedAmount fixedAmount;
	@Inject protected FloatingAmount floatingAmount;

	/**
	* @param tradeState 
	* @param interestRatePayout 
	* @param resets 
	* @param date 
	* @return cashflow 
	*/
	public Cashflow evaluate(TradeState tradeState, InterestRatePayout interestRatePayout, List<? extends Reset> resets, Date date) {
		
		Cashflow.CashflowBuilder cashflowHolder = doEvaluate(tradeState, interestRatePayout, resets, date);
		Cashflow.CashflowBuilder cashflow = assignOutput(cashflowHolder, tradeState, interestRatePayout, resets, date);
		
		if (cashflow!=null) objectValidator.validateAndFailOnErorr(Cashflow.class, cashflow);
		return cashflow;
	}
	
	private Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder cashflow, TradeState tradeState, InterestRatePayout interestRatePayout, List<? extends Reset> resets, Date date) {
		cashflow
			.getOrCreateCashflowAmount()
			.setAmount(MapperS.of(performance(tradeState, interestRatePayout, resets, date).get()).get())
		;
		cashflow
			.getOrCreateCashflowAmount()
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get())
		;
		cashflow
			.getOrCreatePayerReceiver()
			.setPayer(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(performance(tradeState, interestRatePayout, resets, date).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			else {
						return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			}).get())
		;
		cashflow
			.getOrCreatePayerReceiver()
			.setReceiver(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(performance(tradeState, interestRatePayout, resets, date).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			else {
						return MapperS.of(interestRatePayout).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			}).get())
		;
		cashflow
			.getOrCreateCashflowDate()
			.setAdjustedDateValue(MapperS.of(date).get())
		;
		return cashflow;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, InterestRatePayout interestRatePayout, List<? extends Reset> resets, Date date);
	
	
	protected Mapper<BigDecimal> performance(TradeState tradeState, InterestRatePayout interestRatePayout, List<? extends Reset> resets, Date date) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate())).get()) {
					return MapperS.of(fixedAmount.evaluate(MapperS.of(interestRatePayout).get(), MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).<RateSchedule>map("getRateSchedule", _fixedRateSpecification -> _fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPrice>map("getInitialValue", _rateSchedule -> _rateSchedule.getInitialValue()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).get(), MapperS.of(date).get(), null));
				}
				else if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate())).get()) {
					return MapperS.of(floatingAmount.evaluate(MapperS.of(interestRatePayout).get(), MapperS.of(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).<SpreadSchedule>mapC("getSpreadSchedule", _floatingRate -> _floatingRate.getSpreadSchedule()).get()).<ReferenceWithMetaPrice>map("getInitialValue", _rateSchedule -> _rateSchedule.getInitialValue()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperC.of(resets).<Price>map("getResetValue", _reset -> _reset.getResetValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get(), MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).get(), MapperS.of(date).get(), null));
				}
				else {
					return MapperS.ofNull();
				}
		});
	}
	public static final class InterestCashSettlementAmountDefault extends InterestCashSettlementAmount {
		@Override
		protected  Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, InterestRatePayout interestRatePayout, List<? extends Reset> resets, Date date) {
			return Cashflow.builder();
		}
	}
}
