package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.EventEffect;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.functions.Create_TransferPrimitive;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Create_Transfer.Create_TransferDefault.class)
public abstract class Create_Transfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TransferPrimitive create_TransferPrimitive;

	/**
	* @param tradeState Represents the trade and associated state, including the history of reset values and transfers.
	* @param instruction 
	* @param date 
	* @return transferEvent 
	*/
	public BusinessEvent evaluate(TradeState tradeState, TransferInstruction instruction, Date date) {
		
		BusinessEvent.BusinessEventBuilder transferEventHolder = doEvaluate(tradeState, instruction, date);
		BusinessEvent.BusinessEventBuilder transferEvent = assignOutput(transferEventHolder, tradeState, instruction, date);
		
		// post-conditions

		assert
			onlyExists(Arrays.asList(MapperS.of(transferEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()))).get()
			: "Event must contain a transfer primitive populated with the cashflow, and no other primitive.";

		assert
			notExists(MapperS.of(transferEvent).<EventEffect>map("getEventEffect", _businessEvent -> _businessEvent.getEventEffect()).<ReferenceWithMetaProductIdentifier>mapC("getProductIdentifier", _eventEffect -> _eventEffect.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue())).get()
			: "Event effect must include the contract generating the cashflow.";
		if (transferEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, transferEvent);
		return transferEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder transferEvent, TradeState tradeState, TransferInstruction instruction, Date date) {
		transferEvent
			.getOrCreatePrimitives(0)
			.setTransfer(MapperS.of(create_TransferPrimitive.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get(), MapperS.of(date).get())).get())
		;
		transferEvent
			.getOrCreateEventEffect()
			.addEffectedTradeValue(MapperS.of(tradeState).get())
		;
		transferEvent
			.setEventDate(MapperS.of(date).get())
		;
		return transferEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date);
	
	public static final class Create_TransferDefault extends Create_Transfer {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date) {
			return BusinessEvent.builder();
		}
	}
}
