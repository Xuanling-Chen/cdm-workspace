package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ContractDetails;
import cdm.event.common.ContractFormationInstruction;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.EventEffect;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.State;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.functions.Create_ContractFormationPrimitive;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTransferPrimitive;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.LegalAgreement;
import cdm.product.template.ContractualProduct;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Create_ContractFormation.Create_ContractFormationDefault.class)
public abstract class Create_ContractFormation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractFormationPrimitive create_ContractFormationPrimitive;

	/**
	* @param contractFormationInstruction Specifies the Contract Formation instructions to be applied.
	* @param contractFormationDate Specifies the event date of the contract formation.
	* @return contractFormationEvent Qualified contract formation business event.
	*/
	public BusinessEvent evaluate(ContractFormationInstruction contractFormationInstruction, Date contractFormationDate) {
		// pre-conditions
		
			assert
				exists(MapperS.of(execution(contractFormationInstruction, contractFormationDate).get())).and(exists(MapperS.of(execution(contractFormationInstruction, contractFormationDate).get()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()))).and(notExists(MapperS.of(execution(contractFormationInstruction, contractFormationDate).get()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()))).and(areEqual(MapperS.of(execution(contractFormationInstruction, contractFormationDate).get()).<State>map("getState", _tradeState -> _tradeState.getState()).<PositionStatusEnum>map("getPositionState", _state -> _state.getPositionState()), MapperS.of(PositionStatusEnum.EXECUTED), CardinalityOperator.All)).get()
				: "Input event must be an execution must be on a contractual product.";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(contractFormationInstruction).<LegalAgreement>mapC("getLegalAgreement", _contractFormationInstruction -> _contractFormationInstruction.getLegalAgreement())).get()) {
							return contains(MapperS.of(contractFormationInstruction).<LegalAgreement>mapC("getLegalAgreement", _contractFormationInstruction -> _contractFormationInstruction.getLegalAgreement()).<ReferenceWithMetaParty>mapC("getContractualParty", _legalAgreementBase -> _legalAgreementBase.getContractualParty()).<Party>map("getValue", _f->_f.getValue()), MapperS.of(execution(contractFormationInstruction, contractFormationDate).get()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Party>mapC("getParty", _trade -> _trade.getParty()));
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "Ensures that parties to the Contract are defined in the Legal Agreement, if one is provided.";
		
		BusinessEvent.BusinessEventBuilder contractFormationEventHolder = doEvaluate(contractFormationInstruction, contractFormationDate);
		BusinessEvent.BusinessEventBuilder contractFormationEvent = assignOutput(contractFormationEventHolder, contractFormationInstruction, contractFormationDate);
		
		// post-conditions

		assert
			notExists(MapperS.of(contractFormationEvent).<EventEffect>map("getEventEffect", _businessEvent -> _businessEvent.getEventEffect()).<ReferenceWithMetaProductIdentifier>mapC("getProductIdentifier", _eventEffect -> _eventEffect.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue())).and(notExists(MapperS.of(contractFormationEvent).<EventEffect>map("getEventEffect", _businessEvent -> _businessEvent.getEventEffect()).<ReferenceWithMetaTransferPrimitive>mapC("getTransfer", _eventEffect -> _eventEffect.getTransfer()).<TransferPrimitive>map("getValue", _f->_f.getValue()))).get()
			: "Event effect must point to the new execution and contract, and exclude other effects.";
		if (contractFormationEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, contractFormationEvent);
		return contractFormationEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder contractFormationEvent, ContractFormationInstruction contractFormationInstruction, Date contractFormationDate) {
		contractFormationEvent
			.getOrCreatePrimitives(0)
			.setContractFormation(MapperS.of(create_ContractFormationPrimitive.evaluate(MapperS.of(contractFormationInstruction).<TradeState>map("getExecution", _contractFormationInstruction -> _contractFormationInstruction.getExecution()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), MapperS.of(contractFormationInstruction).<LegalAgreement>mapC("getLegalAgreement", _contractFormationInstruction -> _contractFormationInstruction.getLegalAgreement()).getMulti())).get())
		;
		contractFormationEvent
			.getOrCreateEventEffect()
			.addTradeValue(MapperS.of(contractFormationEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter()).getMulti())
		;
		contractFormationEvent
			.getOrCreateEventEffect()
			.addEffectedTradeValue(MapperS.of(contractFormationEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<ReferenceWithMetaTradeState>map("getBefore", _contractFormationPrimitive -> _contractFormationPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).getMulti())
		;
		contractFormationEvent
			.setEventDate(MapperS.of(contractFormationDate).get())
		;
		return contractFormationEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(ContractFormationInstruction contractFormationInstruction, Date contractFormationDate);
	
	
	protected Mapper<? extends TradeState> execution(ContractFormationInstruction contractFormationInstruction, Date contractFormationDate) {
		return MapperS.of(contractFormationInstruction).<TradeState>map("getExecution", _contractFormationInstruction -> _contractFormationInstruction.getExecution());
	}
	public static final class Create_ContractFormationDefault extends Create_ContractFormation {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(ContractFormationInstruction contractFormationInstruction, Date contractFormationDate) {
			return BusinessEvent.builder();
		}
	}
}
