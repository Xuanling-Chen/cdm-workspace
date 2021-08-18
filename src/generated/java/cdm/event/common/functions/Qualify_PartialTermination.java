package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.IntentEnum;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.State;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.functions.QuantityDecreased;
import cdm.event.common.functions.TransfersForDate;
import cdm.legalagreement.common.ClosedState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_PartialTermination.Qualify_PartialTerminationDefault.class)
public abstract class Qualify_PartialTermination implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityDecreased quantityDecreased;
	@Inject protected TransfersForDate transfersForDate;

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
		is_event = notExists(MapperS.of(businessEvent).<IntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent())).or(areEqual(MapperS.of(businessEvent).<IntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), MapperS.of(IntentEnum.PARTIAL_TERMINATION), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()))).or(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange())).and(exists(MapperS.of(transfers(businessEvent).get()))))).and(areEqual(MapperS.of(quantityDecreased.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).getMulti())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).<TradeState>map("getAfter", _quantityChangePrimitive -> _quantityChangePrimitive.getAfter()).<State>map("getState", _tradeState -> _tradeState.getState()).<ClosedState>map("getClosedState", _state -> _state.getClosedState()))).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends Transfer> transfers(BusinessEvent businessEvent) {
		return MapperS.of(transfersForDate.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).getMulti(), MapperS.of(businessEvent).<Date>map("getEventDate", _businessEvent -> _businessEvent.getEventDate()).get())).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers());
	}
	public static final class Qualify_PartialTerminationDefault extends Qualify_PartialTermination {
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
