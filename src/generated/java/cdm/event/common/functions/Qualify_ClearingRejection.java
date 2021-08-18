package cdm.event.common.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractDetails;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.NoQuantityChange;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.workflow.WorkflowStatusEnum;
import cdm.event.workflow.WorkflowStepState;
import cdm.legalagreement.contract.PartyContractInformation;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_ClearingRejection.Qualify_ClearingRejectionDefault.class)
public abstract class Qualify_ClearingRejection implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NoQuantityChange noQuantityChange;

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
		is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()))).and(contains(MapperS.of(businessEvent).<WorkflowStepState>map("getWorkflowEventState", _businessEvent -> _businessEvent.getWorkflowEventState()).<WorkflowStatusEnum>mapC("getWorkflowStatus", _workflowStepState -> _workflowStepState.getWorkflowStatus()), MapperS.of(WorkflowStatusEnum.REJECTED))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole())).or(notEqual(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION), CardinalityOperator.All))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<PartyContractInformation>mapC("getPartyContractInformation", _contractDetails -> _contractDetails.getPartyContractInformation()).<RelatedParty>map("getRelatedParty", _partyContractInformation -> _partyContractInformation.getRelatedParty()).<PartyRoleEnum>map("getRole", _relatedParty -> _relatedParty.getRole())).or(notEqual(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<PartyContractInformation>mapC("getPartyContractInformation", _contractDetails -> _contractDetails.getPartyContractInformation()).<RelatedParty>map("getRelatedParty", _partyContractInformation -> _partyContractInformation.getRelatedParty()).<PartyRoleEnum>map("getRole", _relatedParty -> _relatedParty.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION), CardinalityOperator.All))).and(contains(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<TradeState>map("getAfter", _termsChangePrimitive -> _termsChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION)).or(contains(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<TradeState>map("getAfter", _termsChangePrimitive -> _termsChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<PartyContractInformation>mapC("getPartyContractInformation", _contractDetails -> _contractDetails.getPartyContractInformation()).<RelatedParty>map("getRelatedParty", _partyContractInformation -> _partyContractInformation.getRelatedParty()).<PartyRoleEnum>map("getRole", _relatedParty -> _relatedParty.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION)))).and(areEqual(MapperS.of(noQuantityChange.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).getMulti())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	public static final class Qualify_ClearingRejectionDefault extends Qualify_ClearingRejection {
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
