package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.functions.UpdateAmountForEachMatchingQuantity;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.functions.Create_Counterparty;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.functions.ReplaceParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.AllocationBreakdown;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionTypeEnum;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_SplitTrade.Create_SplitTradeDefault.class)
public abstract class Create_SplitTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_Counterparty create_Counterparty;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected ReplaceParty replaceParty;
	@Inject protected UpdateAmountForEachMatchingQuantity updateAmountForEachMatchingQuantity;

	/**
	* @param blockTradeState Block execution to be split.
	* @param breakdown Split instructions to be applied.
	* @return splitTrade 
	*/
	public TradeState evaluate(TradeState blockTradeState, AllocationBreakdown breakdown) {
		
		TradeState.TradeStateBuilder splitTradeHolder = doEvaluate(blockTradeState, breakdown);
		TradeState.TradeStateBuilder splitTrade = assignOutput(splitTradeHolder, blockTradeState, breakdown);
		
		if (splitTrade!=null) objectValidator.validateAndFailOnErorr(TradeState.class, splitTrade);
		return splitTrade;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder splitTrade, TradeState blockTradeState, AllocationBreakdown breakdown) {
		splitTrade
			.getOrCreateTrade()
			.getOrCreateExecutionDetails()
			.setExecutionType(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()).<ExecutionTypeEnum>map("getExecutionType", _executionDetails -> _executionDetails.getExecutionType()).get())
		;
		splitTrade
			.getOrCreateTrade()
			.addTradeIdentifier(MapperS.of(breakdown).<Identifier>mapC("getAllocationTradeId", _allocationBreakdown -> _allocationBreakdown.getAllocationTradeId()).getMulti())
		;
		splitTrade
			.getOrCreateTrade()
			.setTradeDateValue(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("getValue", _f->_f.getValue()).get())
		;
		splitTrade
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.addCounterparty(MapperC.of(MapperS.of(counterparty1(blockTradeState, breakdown).get()), MapperS.of(counterparty2(blockTradeState, breakdown).get())).getMulti())
		;
		splitTrade
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.setProduct(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get())
		;
		splitTrade
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.getOrCreateTradeLot(0)
			.addPriceQuantity(MapperC.of(updateAmountForEachMatchingQuantity.evaluate(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(breakdown).<Quantity>mapC("getQuantity", _allocationBreakdown -> _allocationBreakdown.getQuantity()).getMulti())).getMulti())
		;
		splitTrade
			.getOrCreateTrade()
			.getOrCreateTradableProduct()
			.addSettlementInstructions(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<SettlementInstructions>mapC("getSettlementInstructions", _tradableProduct -> _tradableProduct.getSettlementInstructions()).getMulti())
		;
		splitTrade
			.getOrCreateTrade()
			.addParty(MapperC.of(replaceParty.evaluate(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Party>mapC("getParty", _trade -> _trade.getParty()).getMulti(), MapperS.of(partyToRemove(blockTradeState, breakdown).get()).get(), MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get())).getMulti())
		;
		splitTrade
			.getOrCreateTrade()
			.addParty(MapperS.of(ancillaryParty(blockTradeState, breakdown).get()).<ReferenceWithMetaParty>map("getPartyReference", _partyRole -> _partyRole.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get())
		;
		splitTrade
			.getOrCreateTrade()
			.addPartyRole(MapperS.of(ancillaryParty(blockTradeState, breakdown).get()).get())
		;
		return splitTrade;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(TradeState blockTradeState, AllocationBreakdown breakdown);
	
	
	protected Mapper<? extends Counterparty> counterparty1(TradeState blockTradeState, AllocationBreakdown breakdown) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<CounterpartyRoleEnum>map("getRole", _counterparty -> _counterparty.getRole()), MapperS.of(CounterpartyRoleEnum.PARTY_1), CardinalityOperator.All).get()) {
					return MapperS.of(create_Counterparty.evaluate(MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get(), MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<CounterpartyRoleEnum>map("getRole", _counterparty -> _counterparty.getRole()).get()));
				}
		else {
					return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(CounterpartyRoleEnum.PARTY_1).get()));
				}
		});
	}
	
	protected Mapper<? extends Counterparty> counterparty2(TradeState blockTradeState, AllocationBreakdown breakdown) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<CounterpartyRoleEnum>map("getRole", _counterparty -> _counterparty.getRole()), MapperS.of(CounterpartyRoleEnum.PARTY_2), CardinalityOperator.All).get()) {
					return MapperS.of(create_Counterparty.evaluate(MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get(), MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<CounterpartyRoleEnum>map("getRole", _counterparty -> _counterparty.getRole()).get()));
				}
		else {
					return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(CounterpartyRoleEnum.PARTY_2).get()));
				}
		});
	}
	
	protected Mapper<? extends PartyRole> ancillaryParty(TradeState blockTradeState, AllocationBreakdown breakdown) {
		return MapperS.of(breakdown).<PartyRole>map("getAncillaryParty", _allocationBreakdown -> _allocationBreakdown.getAncillaryParty());
	}
	
	protected Mapper<? extends Party> partyToRemove(TradeState blockTradeState, AllocationBreakdown breakdown) {
		return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(blockTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(breakdown).<Counterparty>map("getCounterparty", _allocationBreakdown -> _allocationBreakdown.getCounterparty()).<CounterpartyRoleEnum>map("getRole", _counterparty -> _counterparty.getRole()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
	}
	public static final class Create_SplitTradeDefault extends Create_SplitTrade {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(TradeState blockTradeState, AllocationBreakdown breakdown) {
			return TradeState.builder();
		}
	}
}
