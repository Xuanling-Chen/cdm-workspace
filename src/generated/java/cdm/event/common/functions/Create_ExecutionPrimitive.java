package cdm.event.common.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.ExecutionPrimitive.ExecutionPrimitiveBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.position.PositionStatusEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Create_ExecutionPrimitive.Create_ExecutionPrimitiveDefault.class)
public abstract class Create_ExecutionPrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product Defines the financial product to be executed and contract formed.
	* @param priceQuantity Specifies the price, quantity, and optionally the observable for use in a trade or other purposes.
	* @param counterparty Maps two defined parties to counterparty enums for the transacted product.
	* @param ancillaryParty Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
	* @param parties Defines all parties to that execution, including agents and brokers.
	* @param partyRoles Defines the role(s) that party(ies) may have in relation to the execution.
	* @param settlementInstructions Specifies the settlement terms for the execution e.g. initial fee, broker fee, up-front cds payment or option premium settlement.
	* @param executionDetails Specifies the type of execution, e.g. via voice or electronically.
	* @param tradeDate Denotes the trade/execution date.
	* @param tradeIdentifier Denotes one or more identifiers associated with the transaction.
	* @return executionPrimitive Execution primitive event with absent before state and an after state containing the tradable product, parties, associated party roles and the known settlement terms.
	*/
	public ExecutionPrimitive evaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, List<? extends Party> parties, List<? extends PartyRole> partyRoles, List<? extends SettlementInstructions> settlementInstructions, ExecutionDetails executionDetails, Date tradeDate, List<? extends Identifier> tradeIdentifier) {
		
		ExecutionPrimitive.ExecutionPrimitiveBuilder executionPrimitiveHolder = doEvaluate(product, priceQuantity, counterparty, ancillaryParty, parties, partyRoles, settlementInstructions, executionDetails, tradeDate, tradeIdentifier);
		ExecutionPrimitive.ExecutionPrimitiveBuilder executionPrimitive = assignOutput(executionPrimitiveHolder, product, priceQuantity, counterparty, ancillaryParty, parties, partyRoles, settlementInstructions, executionDetails, tradeDate, tradeIdentifier);
		
		// post-conditions

		assert
			notExists(MapperS.of(executionPrimitive).<ReferenceWithMetaTradeState>mapC("getBefore", _executionPrimitive -> _executionPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue())).get()
			: "The execution will be the first event in any post-trade life cycle and therefore does not have a before state. Once pre-trade elements are brought into CDM, the 'before' will be used to refer to the last of the pre-trade event states.";
		if (executionPrimitive!=null) objectValidator.validateAndFailOnErorr(ExecutionPrimitive.class, executionPrimitive);
		return executionPrimitive;
	}
	
	private ExecutionPrimitive.ExecutionPrimitiveBuilder assignOutput(ExecutionPrimitive.ExecutionPrimitiveBuilder executionPrimitive, Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, List<? extends Party> parties, List<? extends PartyRole> partyRoles, List<? extends SettlementInstructions> settlementInstructions, ExecutionDetails executionDetails, Date tradeDate, List<? extends Identifier> tradeIdentifier) {
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.setProduct(MapperS.of(product).get())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.getOrCreateTradeLot(0)
			.addPriceQuantity(MapperC.of(priceQuantity).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.addCounterparty(MapperC.of(counterparty).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.addAncillaryParty(MapperC.of(ancillaryParty).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.addParty(MapperC.of(parties).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.addPartyRole(MapperC.of(partyRoles).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.addSettlementInstructions(MapperC.of(settlementInstructions).get())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.setExecutionDetails(MapperS.of(executionDetails).get())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.setTradeDateValue(MapperS.of(tradeDate).get())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.addTradeIdentifier(MapperC.of(tradeIdentifier).getMulti())
		;
		executionPrimitive
			.getOrCreateAfter()
			.getOrCreateState()
			.setPositionState(MapperS.of(PositionStatusEnum.EXECUTED).get())
		;
		return executionPrimitive;
	}

	protected abstract ExecutionPrimitive.ExecutionPrimitiveBuilder doEvaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, List<? extends Party> parties, List<? extends PartyRole> partyRoles, List<? extends SettlementInstructions> settlementInstructions, ExecutionDetails executionDetails, Date tradeDate, List<? extends Identifier> tradeIdentifier);
	
	public static final class Create_ExecutionPrimitiveDefault extends Create_ExecutionPrimitive {
		@Override
		protected  ExecutionPrimitive.ExecutionPrimitiveBuilder doEvaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, List<? extends Party> parties, List<? extends PartyRole> partyRoles, List<? extends SettlementInstructions> settlementInstructions, ExecutionDetails executionDetails, Date tradeDate, List<? extends Identifier> tradeIdentifier) {
			return ExecutionPrimitive.builder();
		}
	}
}
