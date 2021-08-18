package cdm.event.common.functions;

import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.PrimitiveEvent.PrimitiveEventBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(NewContractFormationPrimitiveEvent.NewContractFormationPrimitiveEventDefault.class)
public abstract class NewContractFormationPrimitiveEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param contractFormation 
	* @return primitiveEvent 
	*/
	public PrimitiveEvent evaluate(ContractFormationPrimitive contractFormation) {
		
		PrimitiveEvent.PrimitiveEventBuilder primitiveEventHolder = doEvaluate(contractFormation);
		PrimitiveEvent.PrimitiveEventBuilder primitiveEvent = assignOutput(primitiveEventHolder, contractFormation);
		
		if (primitiveEvent!=null) objectValidator.validateAndFailOnErorr(PrimitiveEvent.class, primitiveEvent);
		return primitiveEvent;
	}
	
	private PrimitiveEvent.PrimitiveEventBuilder assignOutput(PrimitiveEvent.PrimitiveEventBuilder primitiveEvent, ContractFormationPrimitive contractFormation) {
		primitiveEvent
			.setContractFormation(MapperS.of(contractFormation).get())
		;
		return primitiveEvent;
	}

	protected abstract PrimitiveEvent.PrimitiveEventBuilder doEvaluate(ContractFormationPrimitive contractFormation);
	
	public static final class NewContractFormationPrimitiveEventDefault extends NewContractFormationPrimitiveEvent {
		@Override
		protected  PrimitiveEvent.PrimitiveEventBuilder doEvaluate(ContractFormationPrimitive contractFormation) {
			return PrimitiveEvent.builder();
		}
	}
}
