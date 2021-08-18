package cdm.event.common.functions;

import cdm.event.common.AllocationBreakdown;
import cdm.event.common.AllocationInstruction;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_ContractFormationPrimitives;
import cdm.event.common.functions.Create_SplitPrimitive;
import cdm.event.common.functions.FilterOpenTradeStates;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedStateEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_Allocation.Create_AllocationDefault.class)
public abstract class Create_Allocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractFormationPrimitives create_ContractFormationPrimitives;
	@Inject protected Create_SplitPrimitive create_SplitPrimitive;
	@Inject protected FilterOpenTradeStates filterOpenTradeStates;

	/**
	* @param tradeState Represents the block trade to be allocated.
	* @param allocationInstruction Represents the allocation instructions to be applied.
	* @return businessEvent Represents the Allocation Business Event containing both the original block trade (with it&#39;s status set to Allocated) and the set of breakdown trades.
	*/
	public BusinessEvent evaluate(TradeState tradeState, AllocationInstruction allocationInstruction) {
		
		BusinessEvent.BusinessEventBuilder businessEventHolder = doEvaluate(tradeState, allocationInstruction);
		BusinessEvent.BusinessEventBuilder businessEvent = assignOutput(businessEventHolder, tradeState, allocationInstruction);
		
		// post-conditions

		assert
			areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).resultCount()), MapperS.of(MapperS.of(allocationInstruction).<AllocationBreakdown>mapC("getBreakdowns", _allocationInstruction -> _allocationInstruction.getBreakdowns()).resultCount()), CardinalityOperator.All).get()
			: "Checks the number of ContractFormationPrimitives should equal the number of breakdowns in the instructions.";
		if (businessEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, businessEvent);
		return businessEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder businessEvent, TradeState tradeState, AllocationInstruction allocationInstruction) {
		businessEvent
			.getOrCreatePrimitives(0)
			.setSplit(MapperS.of(splitPrimitive(tradeState, allocationInstruction).get()).get())
		;
		businessEvent
			.addPrimitives(MapperC.of(create_ContractFormationPrimitives.evaluate(MapperC.of(filterOpenTradeStates.evaluate(MapperS.of(splitPrimitive(tradeState, allocationInstruction).get()).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).getMulti())).getMulti())).getMulti())
		;
		return businessEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, AllocationInstruction allocationInstruction);
	
	
	protected Mapper<? extends SplitPrimitive> splitPrimitive(TradeState tradeState, AllocationInstruction allocationInstruction) {
		return MapperS.of(create_SplitPrimitive.evaluate(MapperS.of(tradeState).get(), MapperS.of(allocationInstruction).<AllocationBreakdown>mapC("getBreakdowns", _allocationInstruction -> _allocationInstruction.getBreakdowns()).getMulti(), MapperS.of(ClosedStateEnum.ALLOCATED).get(), MapperS.of(PositionStatusEnum.CLOSED).get()));
	}
	public static final class Create_AllocationDefault extends Create_Allocation {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, AllocationInstruction allocationInstruction) {
			return BusinessEvent.builder();
		}
	}
}
