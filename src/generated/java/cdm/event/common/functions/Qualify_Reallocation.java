package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.State;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.legalagreement.common.ClosedState;
import cdm.legalagreement.common.ClosedStateEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_Reallocation.Qualify_ReallocationDefault.class)
public abstract class Qualify_Reallocation implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {

	/**
	* @param businessEvent 
	* @return is_event 
	*/
	public Boolean evaluate(BusinessEvent businessEvent) {
		
		Boolean is_eventHolder = doEvaluate(businessEvent);
		Boolean is_event = assignOutput(is_eventHolder, businessEvent);
		
		return is_event;
	}
	
	private Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
		is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<SplitPrimitive>map("getSplit", _primitiveEvent -> _primitiveEvent.getSplit()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(areEqual(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<SplitPrimitive>map("getSplit", _primitiveEvent -> _primitiveEvent.getSplit()).<ReferenceWithMetaTradeState>map("getBefore", _splitPrimitive -> _splitPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<State>map("getState", _tradeState -> _tradeState.getState()).<ClosedState>map("getClosedState", _state -> _state.getClosedState()).<ClosedStateEnum>map("getState", _closedState -> _closedState.getState()), MapperS.of(ClosedStateEnum.ALLOCATED), CardinalityOperator.All)).and(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()))).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	public static final class Qualify_ReallocationDefault extends Qualify_Reallocation {
		@Override
		protected  Boolean doEvaluate(BusinessEvent businessEvent) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
