package cdm.event.common.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.functions.Create_Counterparty;
import cdm.base.staticdata.party.functions.Create_PartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ClearingInstruction;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_ContractFormationPrimitive;
import cdm.event.common.functions.Create_ExecutionPrimitive;
import cdm.event.common.functions.Create_TerminationQuantityChangePrimitive;
import cdm.event.common.functions.NewContractFormationPrimitiveEvent;
import cdm.event.common.functions.NewExecutionPrimitiveEvent;
import cdm.event.common.functions.NewQuantityChangePrimitiveEvent;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(Create_ClearedTrade.Create_ClearedTradeDefault.class)
public abstract class Create_ClearedTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ContractFormationPrimitive create_ContractFormationPrimitive;
	@Inject protected Create_Counterparty create_Counterparty;
	@Inject protected Create_ExecutionPrimitive create_ExecutionPrimitive;
	@Inject protected Create_PartyRole create_PartyRole;
	@Inject protected Create_TerminationQuantityChangePrimitive create_TerminationQuantityChangePrimitive;
	@Inject protected NewContractFormationPrimitiveEvent newContractFormationPrimitiveEvent;
	@Inject protected NewExecutionPrimitiveEvent newExecutionPrimitiveEvent;
	@Inject protected NewQuantityChangePrimitiveEvent newQuantityChangePrimitiveEvent;

	/**
	* @param clearingInstruction Clearing Instruction with all party information required to clear the trade.
	* @param tradeDate Denotes the trade/execution date.
	* @param identifier Denotes one or more identifiers associated with the transaction.
	* @return clearedEvent Business event qualified as a cleared trade consisting of five primitive events; terminated alpha contract, new beta execution, beta contract formation, new gamma execution and gamma contract formation
	*/
	public BusinessEvent evaluate(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		// pre-conditions
		
			assert
				contains(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Party>mapC("getParty", _trade -> _trade.getParty()), MapperS.of(clearingInstruction).<Party>map("getParty1", _clearingInstruction -> _clearingInstruction.getParty1())).get()
				: "The alpha contract being terminated must include the party1 contained in the clearing instruction.";
		
			assert
				contains(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Party>mapC("getParty", _trade -> _trade.getParty()), MapperS.of(clearingInstruction).<Party>map("getParty2", _clearingInstruction -> _clearingInstruction.getParty2())).get()
				: "The alpha contract being terminated must include the party2 contained in the clearing instruction.";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(clearingInstruction).<Party>map("getClearerParty1", _clearingInstruction -> _clearingInstruction.getClearerParty1())).get()) {
							return contains(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<ReferenceWithMetaParty>map("getPartyReference", _partyRole -> _partyRole.getPartyReference()).<Party>map("getValue", _f->_f.getValue()), MapperS.of(clearingInstruction).<Party>map("getClearerParty1", _clearingInstruction -> _clearingInstruction.getClearerParty1()));
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "The alpha contract being terminated must include the party role of the clearing member (clearerParty1) if it has been specified.";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(clearingInstruction).<Party>map("getClearerParty2", _clearingInstruction -> _clearingInstruction.getClearerParty2())).get()) {
							return contains(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<ReferenceWithMetaParty>map("getPartyReference", _partyRole -> _partyRole.getPartyReference()).<Party>map("getValue", _f->_f.getValue()), MapperS.of(clearingInstruction).<Party>map("getClearerParty2", _clearingInstruction -> _clearingInstruction.getClearerParty2()));
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "The alpha contract being terminated must include the party role of the clearing member (clearerParty2) if it has been specified.";
		
		BusinessEvent.BusinessEventBuilder clearedEventHolder = doEvaluate(clearingInstruction, tradeDate, identifier);
		BusinessEvent.BusinessEventBuilder clearedEvent = assignOutput(clearedEventHolder, clearingInstruction, tradeDate, identifier);
		
		if (clearedEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, clearedEvent);
		return clearedEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder clearedEvent, ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		clearedEvent
			.addPrimitives(MapperC.of(MapperS.of(alphaTerminatedPrimitives(clearingInstruction, tradeDate, identifier).get()), MapperS.of(betaExecutionPrimitives(clearingInstruction, tradeDate, identifier).get()), MapperS.of(betaContractPrimitives(clearingInstruction, tradeDate, identifier).get()), MapperS.of(gammaExecutionPrimitives(clearingInstruction, tradeDate, identifier).get()), MapperS.of(gammaContractPrimitives(clearingInstruction, tradeDate, identifier).get())).getMulti())
		;
		return clearedEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier);
	
	
	protected Mapper<? extends QuantityChangePrimitive> alphaTerminated(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_TerminationQuantityChangePrimitive.evaluate(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).get()));
	}
	
	protected Mapper<? extends PrimitiveEvent> alphaTerminatedPrimitives(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(newQuantityChangePrimitiveEvent.evaluate(MapperS.of(alphaTerminated(clearingInstruction, tradeDate, identifier).get()).get()));
	}
	
	protected Mapper<? extends PartyRole> clearerRole(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_PartyRole.evaluate(MapperS.of(clearingInstruction).<Party>map("getClearingParty", _clearingInstruction -> _clearingInstruction.getClearingParty()).get(), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION).get()));
	}
	
	protected Mapper<? extends Counterparty> betaClearerCounterparty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_Counterparty.evaluate(MapperS.of(clearingInstruction).<Party>map("getClearingParty", _clearingInstruction -> _clearingInstruction.getClearingParty()).get(), MapperS.of(CounterpartyRoleEnum.PARTY_2).get()));
	}
	
	protected Mapper<? extends Party> betaParty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(clearingInstruction).<Party>map("getClearerParty1", _clearingInstruction -> _clearingInstruction.getClearerParty1())).get()) {
					return MapperS.of(clearingInstruction).<Party>map("getClearerParty1", _clearingInstruction -> _clearingInstruction.getClearerParty1());
				}
		else {
					return MapperS.of(clearingInstruction).<Party>map("getParty1", _clearingInstruction -> _clearingInstruction.getParty1());
				}
		});
	}
	
	protected Mapper<? extends Counterparty> betaCounterparty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_Counterparty.evaluate(MapperS.of(betaParty(clearingInstruction, tradeDate, identifier).get()).get(), MapperS.of(CounterpartyRoleEnum.PARTY_1).get()));
	}
	
	protected Mapper<? extends ExecutionPrimitive> betaExecution(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_ExecutionPrimitive.evaluate(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get(), MapperS.of(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperC.of(MapperS.of(betaCounterparty(clearingInstruction, tradeDate, identifier).get()), MapperS.of(betaClearerCounterparty(clearingInstruction, tradeDate, identifier).get())).getMulti(), MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperC.of(MapperS.of(betaParty(clearingInstruction, tradeDate, identifier).get()), MapperS.of(clearingInstruction).<Party>map("getClearingParty", _clearingInstruction -> _clearingInstruction.getClearingParty())).getMulti(), MapperC.of(MapperS.of(clearerRole(clearingInstruction, tradeDate, identifier).get())).getMulti(), null, MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()).get(), MapperS.of(tradeDate).get(), MapperC.of(MapperS.of(identifier)).getMulti()));
	}
	
	protected Mapper<? extends PrimitiveEvent> betaExecutionPrimitives(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(newExecutionPrimitiveEvent.evaluate(MapperS.of(betaExecution(clearingInstruction, tradeDate, identifier).get()).get()));
	}
	
	protected Mapper<? extends ContractFormationPrimitive> betaContract(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_ContractFormationPrimitive.evaluate(MapperS.of(betaExecution(clearingInstruction, tradeDate, identifier).get()).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), null));
	}
	
	protected Mapper<? extends PrimitiveEvent> betaContractPrimitives(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(newContractFormationPrimitiveEvent.evaluate(MapperS.of(betaContract(clearingInstruction, tradeDate, identifier).get()).get()));
	}
	
	protected Mapper<? extends Counterparty> gammaClearerCounterparty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_Counterparty.evaluate(MapperS.of(clearingInstruction).<Party>map("getClearingParty", _clearingInstruction -> _clearingInstruction.getClearingParty()).get(), MapperS.of(CounterpartyRoleEnum.PARTY_1).get()));
	}
	
	protected Mapper<? extends Party> gammaParty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(clearingInstruction).<Party>map("getClearerParty2", _clearingInstruction -> _clearingInstruction.getClearerParty2())).get()) {
					return MapperS.of(clearingInstruction).<Party>map("getClearerParty2", _clearingInstruction -> _clearingInstruction.getClearerParty2());
				}
		else {
					return MapperS.of(clearingInstruction).<Party>map("getParty2", _clearingInstruction -> _clearingInstruction.getParty2());
				}
		});
	}
	
	protected Mapper<? extends Counterparty> gammaCounterparty(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_Counterparty.evaluate(MapperS.of(gammaParty(clearingInstruction, tradeDate, identifier).get()).get(), MapperS.of(CounterpartyRoleEnum.PARTY_2).get()));
	}
	
	protected Mapper<? extends ExecutionPrimitive> gammaExecution(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_ExecutionPrimitive.evaluate(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get(), MapperS.of(MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperC.of(MapperS.of(gammaCounterparty(clearingInstruction, tradeDate, identifier).get()), MapperS.of(gammaClearerCounterparty(clearingInstruction, tradeDate, identifier).get())).getMulti(), MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperC.of(MapperS.of(gammaParty(clearingInstruction, tradeDate, identifier).get()), MapperS.of(clearingInstruction).<Party>map("getClearingParty", _clearingInstruction -> _clearingInstruction.getClearingParty())).getMulti(), MapperC.of(MapperS.of(clearerRole(clearingInstruction, tradeDate, identifier).get())).getMulti(), null, MapperS.of(clearingInstruction).<TradeState>map("getAlphaContract", _clearingInstruction -> _clearingInstruction.getAlphaContract()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()).get(), MapperS.of(tradeDate).get(), MapperC.of(MapperS.of(identifier)).getMulti()));
	}
	
	protected Mapper<? extends PrimitiveEvent> gammaExecutionPrimitives(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(newExecutionPrimitiveEvent.evaluate(MapperS.of(gammaExecution(clearingInstruction, tradeDate, identifier).get()).get()));
	}
	
	protected Mapper<? extends ContractFormationPrimitive> gammaContract(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(create_ContractFormationPrimitive.evaluate(MapperS.of(gammaExecution(clearingInstruction, tradeDate, identifier).get()).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), null));
	}
	
	protected Mapper<? extends PrimitiveEvent> gammaContractPrimitives(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
		return MapperS.of(newContractFormationPrimitiveEvent.evaluate(MapperS.of(gammaContract(clearingInstruction, tradeDate, identifier).get()).get()));
	}
	public static final class Create_ClearedTradeDefault extends Create_ClearedTrade {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(ClearingInstruction clearingInstruction, Date tradeDate, Identifier identifier) {
			return BusinessEvent.builder();
		}
	}
}
