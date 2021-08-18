package cdm.event.common.functions;

import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.PrimitiveEvent.PrimitiveEventBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(NewExecutionPrimitiveEvent.NewExecutionPrimitiveEventDefault.class)
public abstract class NewExecutionPrimitiveEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param executionPrimitive 
	* @return primitiveEvent 
	*/
	public PrimitiveEvent evaluate(ExecutionPrimitive executionPrimitive) {
		
		PrimitiveEvent.PrimitiveEventBuilder primitiveEventHolder = doEvaluate(executionPrimitive);
		PrimitiveEvent.PrimitiveEventBuilder primitiveEvent = assignOutput(primitiveEventHolder, executionPrimitive);
		
		if (primitiveEvent!=null) objectValidator.validateAndFailOnErorr(PrimitiveEvent.class, primitiveEvent);
		return primitiveEvent;
	}
	
	private PrimitiveEvent.PrimitiveEventBuilder assignOutput(PrimitiveEvent.PrimitiveEventBuilder primitiveEvent, ExecutionPrimitive executionPrimitive) {
		primitiveEvent
			.setExecution(MapperS.of(executionPrimitive).get())
		;
		return primitiveEvent;
	}

	protected abstract PrimitiveEvent.PrimitiveEventBuilder doEvaluate(ExecutionPrimitive executionPrimitive);
	
	public static final class NewExecutionPrimitiveEventDefault extends NewExecutionPrimitiveEvent {
		@Override
		protected  PrimitiveEvent.PrimitiveEventBuilder doEvaluate(ExecutionPrimitive executionPrimitive) {
			return PrimitiveEvent.builder();
		}
	}
}
