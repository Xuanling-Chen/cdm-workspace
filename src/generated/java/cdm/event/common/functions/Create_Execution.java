package cdm.event.common.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_ExecutionPrimitive;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_Execution.Create_ExecutionDefault.class)
public abstract class Create_Execution implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ExecutionPrimitive create_ExecutionPrimitive;

	/**
	* @param executionInstruction Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
	* @return executionEvent Qualified execution business event containing a single execution primitive event, and no other primitive event.
	*/
	public BusinessEvent evaluate(ExecutionInstruction executionInstruction) {
		
		BusinessEvent.BusinessEventBuilder executionEventHolder = doEvaluate(executionInstruction);
		BusinessEvent.BusinessEventBuilder executionEvent = assignOutput(executionEventHolder, executionInstruction);
		
		if (executionEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, executionEvent);
		return executionEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder executionEvent, ExecutionInstruction executionInstruction) {
		executionEvent
			.getOrCreatePrimitives(0)
			.setExecution(MapperS.of(create_ExecutionPrimitive.evaluate(MapperS.of(executionInstruction).<Product>map("getProduct", _executionInstruction -> _executionInstruction.getProduct()).get(), MapperS.of(executionInstruction).<PriceQuantity>mapC("getPriceQuantity", _executionInstruction -> _executionInstruction.getPriceQuantity()).getMulti(), MapperS.of(executionInstruction).<Counterparty>mapC("getCounterparty", _executionInstruction -> _executionInstruction.getCounterparty()).getMulti(), MapperS.of(executionInstruction).<AncillaryParty>mapC("getAncillaryParty", _executionInstruction -> _executionInstruction.getAncillaryParty()).getMulti(), MapperS.of(executionInstruction).<Party>mapC("getParties", _executionInstruction -> _executionInstruction.getParties()).getMulti(), MapperS.of(executionInstruction).<PartyRole>mapC("getPartyRoles", _executionInstruction -> _executionInstruction.getPartyRoles()).getMulti(), MapperS.of(executionInstruction).<SettlementInstructions>mapC("getSettlementInstructions", _executionInstruction -> _executionInstruction.getSettlementInstructions()).getMulti(), MapperS.of(executionInstruction).<ExecutionDetails>map("getExecutionDetails", _executionInstruction -> _executionInstruction.getExecutionDetails()).get(), MapperS.of(executionInstruction).<Date>map("getTradeDate", _executionInstruction -> _executionInstruction.getTradeDate()).get(), MapperS.of(executionInstruction).<Identifier>mapC("getTradeIdentifier", _executionInstruction -> _executionInstruction.getTradeIdentifier()).getMulti())).get())
		;
		executionEvent
			.getOrCreateEventEffect()
			.addTradeValue(MapperS.of(executionEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ExecutionPrimitive>map("getExecution", _primitiveEvent -> _primitiveEvent.getExecution()).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter()).getMulti())
		;
		return executionEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(ExecutionInstruction executionInstruction);
	
	public static final class Create_ExecutionDefault extends Create_Execution {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(ExecutionInstruction executionInstruction) {
			return BusinessEvent.builder();
		}
	}
}
