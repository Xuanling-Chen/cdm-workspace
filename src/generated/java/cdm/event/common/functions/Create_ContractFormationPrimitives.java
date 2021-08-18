package cdm.event.common.functions;

import cdm.event.common.PrimitiveEvent;
import cdm.event.common.PrimitiveEvent.PrimitiveEventBuilder;
import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_ContractFormationPrimitives.Create_ContractFormationPrimitivesDefault.class)
public abstract class Create_ContractFormationPrimitives implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState Represents the list of trades to be formed into contracts.
	* @return primitives List of contract formation primitives.
	*/
	public List<? extends PrimitiveEvent> evaluate(List<? extends TradeState> tradeState) {
		
		List<PrimitiveEvent.PrimitiveEventBuilder> primitivesHolder = doEvaluate(tradeState);
		List<PrimitiveEvent.PrimitiveEventBuilder> primitives = assignOutput(primitivesHolder, tradeState);
		
		if (primitives!=null) objectValidator.validateAndFailOnErorr(PrimitiveEvent.class, primitives);
		return primitives;
	}
	
	private List<PrimitiveEvent.PrimitiveEventBuilder> assignOutput(List<PrimitiveEvent.PrimitiveEventBuilder> primitives, List<? extends TradeState> tradeState) {
		return primitives;
	}

	protected abstract List<PrimitiveEvent.PrimitiveEventBuilder> doEvaluate(List<? extends TradeState> tradeState);
	
	public static final class Create_ContractFormationPrimitivesDefault extends Create_ContractFormationPrimitives {
		@Override
		protected  List<PrimitiveEvent.PrimitiveEventBuilder> doEvaluate(List<? extends TradeState> tradeState) {
			return Arrays.asList();
		}
	}
}
