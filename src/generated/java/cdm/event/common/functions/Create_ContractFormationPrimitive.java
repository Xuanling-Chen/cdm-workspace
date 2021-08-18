package cdm.event.common.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.ContractFormationPrimitive.ContractFormationPrimitiveBuilder;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.functions.Create_RelatedAgreementsWithPartyReference;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_ContractFormationPrimitive.Create_ContractFormationPrimitiveDefault.class)
public abstract class Create_ContractFormationPrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_RelatedAgreementsWithPartyReference create_RelatedAgreementsWithPartyReference;

	/**
	* @param execution Execution consisting of the economic terms which are agreed between the parties.
	* @param legalAgreement Optional legal agreements associated to the contract being formed, for instance a master agreement.
	* @return contractFormation Primitive event containing the execution as its before state and the contract as the after state.
	*/
	public ContractFormationPrimitive evaluate(Trade execution, List<? extends LegalAgreement> legalAgreement) {
		
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder contractFormationHolder = doEvaluate(execution, legalAgreement);
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder contractFormation = assignOutput(contractFormationHolder, execution, legalAgreement);
		
		if (contractFormation!=null) objectValidator.validateAndFailOnErorr(ContractFormationPrimitive.class, contractFormation);
		return contractFormation;
	}
	
	private ContractFormationPrimitive.ContractFormationPrimitiveBuilder assignOutput(ContractFormationPrimitive.ContractFormationPrimitiveBuilder contractFormation, Trade execution, List<? extends LegalAgreement> legalAgreement) {
		contractFormation
			.getOrCreateBefore()
			.getOrCreateValue()
			.setTrade(MapperS.of(execution).get())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.setTradableProduct(MapperS.of(execution).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).get())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.addTradeIdentifier(MapperS.of(execution).<Identifier>mapC("getTradeIdentifier", _trade -> _trade.getTradeIdentifier()).getMulti())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.setTradeDateValue(MapperS.of(execution).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("getValue", _f->_f.getValue()).get())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.addPartyRole(MapperS.of(execution).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).getMulti())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.addParty(MapperS.of(execution).<Party>mapC("getParty", _trade -> _trade.getParty()).getMulti())
		;
		contractFormation.getOrCreateAfter().getOrCreateTrade()
			.getOrCreateContractDetails()
			.addDocumentation(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperC.of(legalAgreement)).get()) {
						return MapperC.of(create_RelatedAgreementsWithPartyReference.evaluate(MapperC.of(legalAgreement).getMulti()));
					}
			else {
						return MapperS.ofNull();
					}
			}).getMulti())
		;
		return contractFormation;
	}

	protected abstract ContractFormationPrimitive.ContractFormationPrimitiveBuilder doEvaluate(Trade execution, List<? extends LegalAgreement> legalAgreement);
	
	
	protected Trade.TradeBuilder trade(ContractFormationPrimitive.ContractFormationPrimitiveBuilder contractFormation, Trade execution, List<? extends LegalAgreement> legalAgreement) {
		return MapperS.of(contractFormation).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get().toBuilder();
	}
	public static final class Create_ContractFormationPrimitiveDefault extends Create_ContractFormationPrimitive {
		@Override
		protected  ContractFormationPrimitive.ContractFormationPrimitiveBuilder doEvaluate(Trade execution, List<? extends LegalAgreement> legalAgreement) {
			return ContractFormationPrimitive.builder();
		}
	}
}
