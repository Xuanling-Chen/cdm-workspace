package cdm.event.common.functions;

import cdm.event.common.ResetInstruction;
import cdm.event.common.ResetPrimitive;
import cdm.event.common.ResetPrimitive.ResetPrimitiveBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.functions.ResolveEquityObservationIdentifiers;
import cdm.event.common.functions.ResolveEquityReset;
import cdm.event.common.functions.ResolveInterestRateObservationIdentifiers;
import cdm.event.common.functions.ResolveInterestRateReset;
import cdm.observable.event.Observation;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.functions.ResolveObservation;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_ResetPrimitive.Create_ResetPrimitiveDefault.class)
public abstract class Create_ResetPrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ResolveEquityObservationIdentifiers resolveEquityObservationIdentifiers;
	@Inject protected ResolveEquityReset resolveEquityReset;
	@Inject protected ResolveInterestRateObservationIdentifiers resolveInterestRateObservationIdentifiers;
	@Inject protected ResolveInterestRateReset resolveInterestRateReset;
	@Inject protected ResolveObservation resolveObservation;

	/**
	* @param tradeState Specifies the trade that is resetting.
	* @param instruction Specifies the reset instructions.
	* @param resetDate Specifies the date on which the reset is occuring.
	* @return resetPrimitive 
	*/
	public ResetPrimitive evaluate(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		
		ResetPrimitive.ResetPrimitiveBuilder resetPrimitiveHolder = doEvaluate(tradeState, instruction, resetDate);
		ResetPrimitive.ResetPrimitiveBuilder resetPrimitive = assignOutput(resetPrimitiveHolder, tradeState, instruction, resetDate);
		
		if (resetPrimitive!=null) objectValidator.validateAndFailOnErorr(ResetPrimitive.class, resetPrimitive);
		return resetPrimitive;
	}
	
	private ResetPrimitive.ResetPrimitiveBuilder assignOutput(ResetPrimitive.ResetPrimitiveBuilder resetPrimitive, TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		resetPrimitive
			.setBeforeValue(MapperS.of(tradeState).get())
		;
		resetPrimitive
			.setAfter(MapperS.of(tradeState).get())
		;
		resetPrimitive
			.getOrCreateAfter()
			.addResetHistory(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (areEqual(MapperS.of(MapperS.of(payout(tradeState, instruction, resetDate).get()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).get()) {
						return MapperS.of(resolveEquityReset.evaluate(MapperS.of(MapperS.of(payout(tradeState, instruction, resetDate).get()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).get(), MapperS.of(observation(tradeState, instruction, resetDate).get()).get(), MapperS.of(resetDate).get()));
					}
					else if (exists(MapperS.of(payout(tradeState, instruction, resetDate).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())).get()) {
						return MapperS.of(resolveInterestRateReset.evaluate(MapperS.of(payout(tradeState, instruction, resetDate).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).getMulti(), MapperS.of(observation(tradeState, instruction, resetDate).get()).get(), MapperS.of(resetDate).get(), MapperS.of(instruction).<Date>map("getRateRecordDate", _resetInstruction -> _resetInstruction.getRateRecordDate()).get()));
					}
					else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return resetPrimitive;
	}

	protected abstract ResetPrimitive.ResetPrimitiveBuilder doEvaluate(TradeState tradeState, ResetInstruction instruction, Date resetDate);
	
	
	protected Mapper<? extends Payout> payout(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		return MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _resetInstruction -> _resetInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue());
	}
	
	protected Mapper<Date> observationDate(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(instruction).<Date>map("getRateRecordDate", _resetInstruction -> _resetInstruction.getRateRecordDate())).get()) {
					return MapperS.of(instruction).<Date>map("getRateRecordDate", _resetInstruction -> _resetInstruction.getRateRecordDate());
				}
		else {
					return MapperS.of(resetDate);
				}
		});
	}
	
	protected Mapper<? extends ObservationIdentifier> observationIdentifiers(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(MapperS.of(payout(tradeState, instruction, resetDate).get()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).get()) {
					return MapperS.of(resolveEquityObservationIdentifiers.evaluate(MapperS.of(MapperS.of(payout(tradeState, instruction, resetDate).get()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).get(), MapperS.of(resetDate).get()));
				}
				else if (exists(MapperS.of(payout(tradeState, instruction, resetDate).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())).get()) {
					return MapperS.of(resolveInterestRateObservationIdentifiers.evaluate(MapperS.of(MapperS.of(payout(tradeState, instruction, resetDate).get()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).get(), MapperS.of(observationDate(tradeState, instruction, resetDate).get()).get()));
				}
				else {
					return MapperS.ofNull();
				}
		});
	}
	
	protected Mapper<? extends Observation> observation(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
		return MapperS.of(resolveObservation.evaluate(MapperC.of(MapperS.of(observationIdentifiers(tradeState, instruction, resetDate).get())).getMulti(), null));
	}
	public static final class Create_ResetPrimitiveDefault extends Create_ResetPrimitive {
		@Override
		protected  ResetPrimitive.ResetPrimitiveBuilder doEvaluate(TradeState tradeState, ResetInstruction instruction, Date resetDate) {
			return ResetPrimitive.builder();
		}
	}
}
