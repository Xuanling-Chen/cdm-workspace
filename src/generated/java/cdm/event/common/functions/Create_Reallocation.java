package cdm.event.common.functions;

import cdm.event.common.AllocationBreakdown;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.DecreasedTrade;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.ReallocationInstruction;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_ContractFormationPrimitives;
import cdm.event.common.functions.Create_DecreasedTradeQuantityChangePrimitives;
import cdm.event.common.functions.Create_SplitTrades;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_Reallocation.Create_ReallocationDefault.class)
public abstract class Create_Reallocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractFormationPrimitives create_ContractFormationPrimitives;
	@Inject protected Create_DecreasedTradeQuantityChangePrimitives create_DecreasedTradeQuantityChangePrimitives;
	@Inject protected Create_SplitTrades create_SplitTrades;

	/**
	* @param originalBlock Represents the block trade being reallocated and should be taken from the before state of the allocation business event
	* @param reallocationInstruction 
	* @return reallocationEvent Produces the business event composed of primitive events describing the decreases, increases and splits, as a result of the input reallocation instruction.
	*/
	public BusinessEvent evaluate(TradeState originalBlock, ReallocationInstruction reallocationInstruction) {
		
		BusinessEvent.BusinessEventBuilder reallocationEventHolder = doEvaluate(originalBlock, reallocationInstruction);
		BusinessEvent.BusinessEventBuilder reallocationEvent = assignOutput(reallocationEventHolder, originalBlock, reallocationInstruction);
		
		if (reallocationEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, reallocationEvent);
		return reallocationEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder reallocationEvent, TradeState originalBlock, ReallocationInstruction reallocationInstruction) {
		reallocationEvent
			.getOrCreatePrimitives(0)
			.getOrCreateSplit()
			.setBeforeValue(MapperS.of(originalBlock).get())
		;
		reallocationEvent
			.getOrCreatePrimitives(0)
			.getOrCreateSplit()
			.addAfter(MapperS.of(newAllocations(originalBlock, reallocationInstruction).get()).getMulti())
		;
		reallocationEvent
			.addPrimitives(MapperS.of(decreases(originalBlock, reallocationInstruction).get()).getMulti())
		;
		reallocationEvent
			.addPrimitives(MapperC.of(create_ContractFormationPrimitives.evaluate(MapperS.of(newAllocations(originalBlock, reallocationInstruction).get()).getMulti())).getMulti())
		;
		return reallocationEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState originalBlock, ReallocationInstruction reallocationInstruction);
	
	
	protected Mapper<? extends TradeState> newAllocations(TradeState originalBlock, ReallocationInstruction reallocationInstruction) {
		return MapperC.of(create_SplitTrades.evaluate(MapperS.of(originalBlock).get(), MapperS.of(reallocationInstruction).<AllocationBreakdown>mapC("getBreakdowns", _reallocationInstruction -> _reallocationInstruction.getBreakdowns()).getMulti()));
	}
	
	protected Mapper<? extends PrimitiveEvent> decreases(TradeState originalBlock, ReallocationInstruction reallocationInstruction) {
		return MapperC.of(create_DecreasedTradeQuantityChangePrimitives.evaluate(MapperS.of(reallocationInstruction).<DecreasedTrade>mapC("getDecrease", _reallocationInstruction -> _reallocationInstruction.getDecrease()).getMulti()));
	}
	public static final class Create_ReallocationDefault extends Create_Reallocation {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState originalBlock, ReallocationInstruction reallocationInstruction) {
			return BusinessEvent.builder();
		}
	}
}
