package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.Reset;
import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.functions.EquityCashSettlementAmount;
import cdm.event.common.functions.InterestCashSettlementAmount;
import cdm.event.common.functions.SecurityFinanceCashSettlementAmount;
import cdm.observable.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolveCashflow.ResolveCashflowDefault.class)
public abstract class ResolveCashflow implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EquityCashSettlementAmount equityCashSettlementAmount;
	@Inject protected InterestCashSettlementAmount interestCashSettlementAmount;
	@Inject protected SecurityFinanceCashSettlementAmount securityFinanceCashSettlementAmount;

	/**
	* @param tradeState Represents the trade and associated state on which to construct the Transfer data type.
	* @param instruction 
	* @param date Specifies the date the cashflow is to take place.
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @return cashflow 
	*/
	public Cashflow evaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		
		Cashflow.CashflowBuilder cashflowHolder = doEvaluate(tradeState, instruction, date, quantity);
		Cashflow.CashflowBuilder cashflow = assignOutput(cashflowHolder, tradeState, instruction, date, quantity);
		
		if (cashflow!=null) objectValidator.validateAndFailOnErorr(Cashflow.class, cashflow);
		return cashflow;
	}
	
	private Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder cashflow, TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		cashflow = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(payout(tradeState, instruction, date, quantity).get()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout())).get()) {
					return MapperS.of(securityFinanceCashSettlementAmount.evaluate(MapperS.of(tradeState).get(), MapperS.of(date).get(), MapperS.of(quantity).get(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", _transferInstruction -> _transferInstruction.getPayerReceiver()).get()));
				}
				else if (exists(MapperS.of(payout(tradeState, instruction, date, quantity).get()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout())).get()) {
					return MapperS.of(equityCashSettlementAmount.evaluate(MapperS.of(tradeState).get(), MapperS.of(date).get()));
				}
				else if (exists(MapperS.of(payout(tradeState, instruction, date, quantity).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate())).or(exists(MapperS.of(payout(tradeState, instruction, date, quantity).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()))).get()) {
					return MapperS.of(interestCashSettlementAmount.evaluate(MapperS.of(tradeState).get(), MapperS.of(MapperS.of(payout(tradeState, instruction, date, quantity).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).get(), MapperS.of(instruction).<Reset>mapC("getResets", _transferInstruction -> _transferInstruction.getResets()).getMulti(), MapperS.of(date).get()));
				}
				else {
					return MapperS.ofNull();
				}
		}).get())
		;
		return cashflow;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity);
	
	
	protected Mapper<? extends Payout> payout(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue());
	}
	public static final class ResolveCashflowDefault extends ResolveCashflow {
		@Override
		protected  Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
			return Cashflow.builder();
		}
	}
}
