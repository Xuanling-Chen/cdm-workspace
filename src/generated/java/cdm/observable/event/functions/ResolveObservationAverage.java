package cdm.observable.event.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.event.Observation;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ResolveObservationAverage.ResolveObservationAverageDefault.class)
public abstract class ResolveObservationAverage implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param observations 
	* @return resetValue 
	*/
	public Price evaluate(List<? extends Observation> observations) {
		
		Price.PriceBuilder resetValueHolder = doEvaluate(observations);
		Price.PriceBuilder resetValue = assignOutput(resetValueHolder, observations);
		
		if (resetValue!=null) objectValidator.validateAndFailOnErorr(Price.class, resetValue);
		return resetValue;
	}
	
	private Price.PriceBuilder assignOutput(Price.PriceBuilder resetValue, List<? extends Observation> observations) {
		return resetValue;
	}

	protected abstract Price.PriceBuilder doEvaluate(List<? extends Observation> observations);
	
	public static final class ResolveObservationAverageDefault extends ResolveObservationAverage {
		@Override
		protected  Price.PriceBuilder doEvaluate(List<? extends Observation> observations) {
			return Price.builder();
		}
	}
}
