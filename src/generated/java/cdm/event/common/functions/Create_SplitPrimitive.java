package cdm.event.common.functions;

import cdm.event.common.AllocationBreakdown;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.SplitPrimitive.SplitPrimitiveBuilder;
import cdm.event.common.State;
import cdm.event.common.TradeState;
import cdm.event.common.functions.CloseTrade;
import cdm.event.common.functions.Create_SplitTrades;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedState;
import cdm.legalagreement.common.ClosedStateEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(Create_SplitPrimitive.Create_SplitPrimitiveDefault.class)
public abstract class Create_SplitPrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CloseTrade closeTrade;
	@Inject protected Create_SplitTrades create_SplitTrades;

	/**
	* @param singleTrade Represents the single trade, to be split.
	* @param splitBreakdowns Represents how the single trade is to be split.
	* @param closedState Represents the reason for the trade&#39;s closure. The input is optional as not all splits will result in a trade closure, for example in the case of a partial allocation.
	* @param positionStatus Represents the change to the position status.
	* @return primitive Split primitive containing both the original block trade (with the status set to Split) and the set of split trades.
	*/
	public SplitPrimitive evaluate(TradeState singleTrade, List<? extends AllocationBreakdown> splitBreakdowns, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
		
		SplitPrimitive.SplitPrimitiveBuilder primitiveHolder = doEvaluate(singleTrade, splitBreakdowns, closedState, positionStatus);
		SplitPrimitive.SplitPrimitiveBuilder primitive = assignOutput(primitiveHolder, singleTrade, splitBreakdowns, closedState, positionStatus);
		
		// post-conditions

		assert
			com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(closedState)).get()) {
						return contains(MapperS.of(primitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<State>map("getState", _tradeState -> _tradeState.getState()).<ClosedState>map("getClosedState", _state -> _state.getClosedState()).<ClosedStateEnum>map("getState", _closedState -> _closedState.getState()), MapperS.of(closedState));
					}
			else {
						return MapperS.ofNull();
					}
			})).get()
			: "Checks the closed state has been set.";

		assert
			contains(MapperS.of(primitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<State>map("getState", _tradeState -> _tradeState.getState()).<PositionStatusEnum>map("getPositionState", _state -> _state.getPositionState()), MapperS.of(positionStatus)).get()
			: "Checks the position status has been set.";
		if (primitive!=null) objectValidator.validateAndFailOnErorr(SplitPrimitive.class, primitive);
		return primitive;
	}
	
	private SplitPrimitive.SplitPrimitiveBuilder assignOutput(SplitPrimitive.SplitPrimitiveBuilder primitive, TradeState singleTrade, List<? extends AllocationBreakdown> splitBreakdowns, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
		primitive
			.setBeforeValue(MapperS.of(singleTrade).get())
		;
		primitive
			.addAfter(MapperS.of(closeTrade.evaluate(MapperS.of(singleTrade).get(), MapperS.of(closedState).get(), MapperS.of(positionStatus).get())).get())
		;
		primitive
			.addAfter(MapperC.of(create_SplitTrades.evaluate(MapperS.of(singleTrade).get(), MapperC.of(splitBreakdowns).getMulti())).getMulti())
		;
		return primitive;
	}

	protected abstract SplitPrimitive.SplitPrimitiveBuilder doEvaluate(TradeState singleTrade, List<? extends AllocationBreakdown> splitBreakdowns, ClosedStateEnum closedState, PositionStatusEnum positionStatus);
	
	public static final class Create_SplitPrimitiveDefault extends Create_SplitPrimitive {
		@Override
		protected  SplitPrimitive.SplitPrimitiveBuilder doEvaluate(TradeState singleTrade, List<? extends AllocationBreakdown> splitBreakdowns, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
			return SplitPrimitive.builder();
		}
	}
}
