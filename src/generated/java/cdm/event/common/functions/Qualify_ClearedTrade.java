package cdm.event.common.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.QuantityDecreasedToZero;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(Qualify_ClearedTrade.Qualify_ClearedTradeDefault.class)
public abstract class Qualify_ClearedTrade implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityDecreasedToZero quantityDecreasedToZero;

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
		is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).resultCount()), MapperS.of(Integer.valueOf(5)), CardinalityOperator.All).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(areEqual(MapperS.of(quantityDecreasedToZero.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).getMulti())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ExecutionPrimitive>map("getExecution", _primitiveEvent -> _primitiveEvent.getExecution()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ExecutionPrimitive>map("getExecution", _primitiveEvent -> _primitiveEvent.getExecution()).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter()), MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<ReferenceWithMetaTradeState>map("getBefore", _contractFormationPrimitive -> _contractFormationPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).and(contains(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION))).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	public static final class Qualify_ClearedTradeDefault extends Qualify_ClearedTrade {
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
