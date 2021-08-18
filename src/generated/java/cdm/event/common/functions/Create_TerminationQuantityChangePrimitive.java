package cdm.event.common.functions;

import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.QuantityChangePrimitive.QuantityChangePrimitiveBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.functions.CloseTrade;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedStateEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_TerminationQuantityChangePrimitive.Create_TerminationQuantityChangePrimitiveDefault.class)
public abstract class Create_TerminationQuantityChangePrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CloseTrade closeTrade;

	/**
	* @param contract 
	* @return quantityChangePrimitive 
	*/
	public QuantityChangePrimitive evaluate(TradeState contract) {
		
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitiveHolder = doEvaluate(contract);
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive = assignOutput(quantityChangePrimitiveHolder, contract);
		
		if (quantityChangePrimitive!=null) objectValidator.validateAndFailOnErorr(QuantityChangePrimitive.class, quantityChangePrimitive);
		return quantityChangePrimitive;
	}
	
	private QuantityChangePrimitive.QuantityChangePrimitiveBuilder assignOutput(QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive, TradeState contract) {
		quantityChangePrimitive
			.setBeforeValue(MapperS.of(contract).get())
		;
		quantityChangePrimitive
			.setAfter(MapperS.of(closeTrade.evaluate(MapperS.of(contract).get(), MapperS.of(ClosedStateEnum.TERMINATED).get(), MapperS.of(PositionStatusEnum.CLOSED).get())).get())
		;
		return quantityChangePrimitive;
	}

	protected abstract QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(TradeState contract);
	
	public static final class Create_TerminationQuantityChangePrimitiveDefault extends Create_TerminationQuantityChangePrimitive {
		@Override
		protected  QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(TradeState contract) {
			return QuantityChangePrimitive.builder();
		}
	}
}
