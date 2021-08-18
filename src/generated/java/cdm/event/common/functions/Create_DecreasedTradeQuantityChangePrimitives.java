package cdm.event.common.functions;

import cdm.event.common.DecreasedTrade;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.PrimitiveEvent.PrimitiveEventBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_DecreasedTradeQuantityChangePrimitives.Create_DecreasedTradeQuantityChangePrimitivesDefault.class)
public abstract class Create_DecreasedTradeQuantityChangePrimitives implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param decrease 
	* @return primitives 
	*/
	public List<? extends PrimitiveEvent> evaluate(List<? extends DecreasedTrade> decrease) {
		
		List<PrimitiveEvent.PrimitiveEventBuilder> primitivesHolder = doEvaluate(decrease);
		List<PrimitiveEvent.PrimitiveEventBuilder> primitives = assignOutput(primitivesHolder, decrease);
		
		if (primitives!=null) objectValidator.validateAndFailOnErorr(PrimitiveEvent.class, primitives);
		return primitives;
	}
	
	private List<PrimitiveEvent.PrimitiveEventBuilder> assignOutput(List<PrimitiveEvent.PrimitiveEventBuilder> primitives, List<? extends DecreasedTrade> decrease) {
		return primitives;
	}

	protected abstract List<PrimitiveEvent.PrimitiveEventBuilder> doEvaluate(List<? extends DecreasedTrade> decrease);
	
	public static final class Create_DecreasedTradeQuantityChangePrimitivesDefault extends Create_DecreasedTradeQuantityChangePrimitives {
		@Override
		protected  List<PrimitiveEvent.PrimitiveEventBuilder> doEvaluate(List<? extends DecreasedTrade> decrease) {
			return Arrays.asList();
		}
	}
}
