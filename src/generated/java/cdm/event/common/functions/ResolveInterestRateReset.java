package cdm.event.common.functions;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.observable.asset.Price;
import cdm.observable.event.Observation;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ResolveInterestRateReset.ResolveInterestRateResetDefault.class)
public abstract class ResolveInterestRateReset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payouts 
	* @param observation 
	* @param resetDate 
	* @param rateRecordDate 
	* @return reset 
	*/
	public Reset evaluate(List<? extends InterestRatePayout> payouts, Observation observation, Date resetDate, Date rateRecordDate) {
		
		Reset.ResetBuilder resetHolder = doEvaluate(payouts, observation, resetDate, rateRecordDate);
		Reset.ResetBuilder reset = assignOutput(resetHolder, payouts, observation, resetDate, rateRecordDate);
		
		if (reset!=null) objectValidator.validateAndFailOnErorr(Reset.class, reset);
		return reset;
	}
	
	private Reset.ResetBuilder assignOutput(Reset.ResetBuilder reset, List<? extends InterestRatePayout> payouts, Observation observation, Date resetDate, Date rateRecordDate) {
		reset
			.setResetValue(MapperS.of(observation).<Price>map("getObservedValue", _observation -> _observation.getObservedValue()).get())
		;
		reset
			.setResetDate(MapperS.of(resetDate).get())
		;
		reset
			.setRateRecordDate(MapperS.of(rateRecordDate).get())
		;
		reset
			.addObservationsValue(MapperS.of(observation).get())
		;
		return reset;
	}

	protected abstract Reset.ResetBuilder doEvaluate(List<? extends InterestRatePayout> payouts, Observation observation, Date resetDate, Date rateRecordDate);
	
	public static final class ResolveInterestRateResetDefault extends ResolveInterestRateReset {
		@Override
		protected  Reset.ResetBuilder doEvaluate(List<? extends InterestRatePayout> payouts, Observation observation, Date resetDate, Date rateRecordDate) {
			return Reset.builder();
		}
	}
}
