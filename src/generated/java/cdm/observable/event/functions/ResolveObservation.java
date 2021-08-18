package cdm.observable.event.functions;

import cdm.base.math.AveragingMethodEnum;
import cdm.observable.event.Observation;
import cdm.observable.event.Observation.ObservationBuilder;
import cdm.observable.event.ObservationIdentifier;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ResolveObservation.ResolveObservationDefault.class)
public abstract class ResolveObservation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param identifiers 
	* @param averagingMethod 
	* @return observation 
	*/
	public Observation evaluate(List<? extends ObservationIdentifier> identifiers, AveragingMethodEnum averagingMethod) {
		
		Observation.ObservationBuilder observationHolder = doEvaluate(identifiers, averagingMethod);
		Observation.ObservationBuilder observation = assignOutput(observationHolder, identifiers, averagingMethod);
		
		if (observation!=null) objectValidator.validateAndFailOnErorr(Observation.class, observation);
		return observation;
	}
	
	private Observation.ObservationBuilder assignOutput(Observation.ObservationBuilder observation, List<? extends ObservationIdentifier> identifiers, AveragingMethodEnum averagingMethod) {
		return observation;
	}

	protected abstract Observation.ObservationBuilder doEvaluate(List<? extends ObservationIdentifier> identifiers, AveragingMethodEnum averagingMethod);
	
	public static final class ResolveObservationDefault extends ResolveObservation {
		@Override
		protected  Observation.ObservationBuilder doEvaluate(List<? extends ObservationIdentifier> identifiers, AveragingMethodEnum averagingMethod) {
			return Observation.builder();
		}
	}
}
