package cdm.event.common.functions;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.observable.asset.Price;
import cdm.observable.event.Observation;
import cdm.product.template.EquityPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ResolveEquityReset.ResolveEquityResetDefault.class)
public abstract class ResolveEquityReset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param equityPayout Represents the EquityPayout to which the reset will apply.
	* @param observation Represents the observation that will be used to compute the reset value.
	* @param date Specifies the date of the reset.
	* @return reset 
	*/
	public Reset evaluate(EquityPayout equityPayout, Observation observation, Date date) {
		
		Reset.ResetBuilder resetHolder = doEvaluate(equityPayout, observation, date);
		Reset.ResetBuilder reset = assignOutput(resetHolder, equityPayout, observation, date);
		
		if (reset!=null) objectValidator.validateAndFailOnErorr(Reset.class, reset);
		return reset;
	}
	
	private Reset.ResetBuilder assignOutput(Reset.ResetBuilder reset, EquityPayout equityPayout, Observation observation, Date date) {
		reset
			.setResetValue(MapperS.of(observation).<Price>map("getObservedValue", _observation -> _observation.getObservedValue()).get())
		;
		reset
			.setResetDate(MapperS.of(date).get())
		;
		reset
			.addObservationsValue(MapperS.of(observation).get())
		;
		return reset;
	}

	protected abstract Reset.ResetBuilder doEvaluate(EquityPayout equityPayout, Observation observation, Date date);
	
	public static final class ResolveEquityResetDefault extends ResolveEquityReset {
		@Override
		protected  Reset.ResetBuilder doEvaluate(EquityPayout equityPayout, Observation observation, Date date) {
			return Reset.builder();
		}
	}
}
