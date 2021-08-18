package cdm.event.common.functions;

import cdm.event.common.PrimitiveEvent;
import cdm.event.common.PrimitiveEvent.PrimitiveEventBuilder;
import cdm.event.common.QuantityChangePrimitive;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(NewQuantityChangePrimitiveEvent.NewQuantityChangePrimitiveEventDefault.class)
public abstract class NewQuantityChangePrimitiveEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantityChangePrimitive 
	* @return primitiveEvent 
	*/
	public PrimitiveEvent evaluate(QuantityChangePrimitive quantityChangePrimitive) {
		
		PrimitiveEvent.PrimitiveEventBuilder primitiveEventHolder = doEvaluate(quantityChangePrimitive);
		PrimitiveEvent.PrimitiveEventBuilder primitiveEvent = assignOutput(primitiveEventHolder, quantityChangePrimitive);
		
		if (primitiveEvent!=null) objectValidator.validateAndFailOnErorr(PrimitiveEvent.class, primitiveEvent);
		return primitiveEvent;
	}
	
	private PrimitiveEvent.PrimitiveEventBuilder assignOutput(PrimitiveEvent.PrimitiveEventBuilder primitiveEvent, QuantityChangePrimitive quantityChangePrimitive) {
		primitiveEvent
			.setQuantityChange(MapperS.of(quantityChangePrimitive).get())
		;
		return primitiveEvent;
	}

	protected abstract PrimitiveEvent.PrimitiveEventBuilder doEvaluate(QuantityChangePrimitive quantityChangePrimitive);
	
	public static final class NewQuantityChangePrimitiveEventDefault extends NewQuantityChangePrimitiveEvent {
		@Override
		protected  PrimitiveEvent.PrimitiveEventBuilder doEvaluate(QuantityChangePrimitive quantityChangePrimitive) {
			return PrimitiveEvent.builder();
		}
	}
}
