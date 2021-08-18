package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ExerciseInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.functions.CloseTrade;
import cdm.event.common.functions.Create_ContractFormationPrimitive;
import cdm.event.common.functions.Create_ExecutionPrimitive;
import cdm.event.common.functions.Create_TransferPrimitive;
import cdm.event.common.functions.SecurityTransferInstruction;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedStateEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionExercise;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_Exercise.Create_ExerciseDefault.class)
public abstract class Create_Exercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CloseTrade closeTrade;
	@Inject protected Create_ContractFormationPrimitive create_ContractFormationPrimitive;
	@Inject protected Create_ExecutionPrimitive create_ExecutionPrimitive;
	@Inject protected Create_TransferPrimitive create_TransferPrimitive;
	@Inject protected SecurityTransferInstruction securityTransferInstruction;

	/**
	* @param tradeState Specifies a previously formed contractual product with an option payout. It is required that the description of the contractual product be contained within the previous business event, i.e. its lineage must contain the formation of a contractual product.
	* @param exerciseInstruction Specifies the information required to communicate the choices made by the exercising party in accordance with the economic terms of the contractual product.
	* @return exerciseEvent Produces the business event composed of primitive events describing the transfer, termination, or formation of new contracts as a result of the input exercise instruction.
	*/
	public BusinessEvent evaluate(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		// pre-conditions
		
			assert
				exists(MapperS.of(tradableProduct(tradeState, exerciseInstruction).get()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct())).get()
				: "Requires that the original contract must contain a state corresponding to a contractual product.";
		
			assert
				exists(MapperS.of(optionPayout(tradeState, exerciseInstruction).get())).get()
				: "Requires that the original contract contains an option payout.";
		
		BusinessEvent.BusinessEventBuilder exerciseEventHolder = doEvaluate(tradeState, exerciseInstruction);
		BusinessEvent.BusinessEventBuilder exerciseEvent = assignOutput(exerciseEventHolder, tradeState, exerciseInstruction);
		
		if (exerciseEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, exerciseEvent);
		return exerciseEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder exerciseEvent, TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		exerciseEvent
			.getOrCreatePrimitives(0)
			.getOrCreateQuantityChange()
			.setBeforeValue(MapperS.of(tradeState).get())
		;
		exerciseEvent
			.getOrCreatePrimitives(0)
			.getOrCreateQuantityChange()
			.setAfter(MapperS.of(closeTrade.evaluate(MapperS.of(tradeState).get(), MapperS.of(ClosedStateEnum.EXERCISED).get(), MapperS.of(PositionStatusEnum.CLOSED).get())).get())
		;
		exerciseEvent
			.getOrCreatePrimitives(0)
			.getOrCreateQuantityChange()
			.getOrCreateAfter()
			.getOrCreateState()
			.setPositionState(MapperS.of(PositionStatusEnum.CLOSED).get())
		;
		exerciseEvent
			.getOrCreatePrimitives(0)
			.getOrCreateQuantityChange()
			.getOrCreateAfter()
			.getOrCreateState()
			.getOrCreateClosedState()
			.setState(MapperS.of(ClosedStateEnum.EXERCISED).get())
		;
		exerciseEvent
			.getOrCreatePrimitives(0)
			.setContractFormation(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(settlementTerms(tradeState, exerciseInstruction).get()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).get()) {
						return MapperS.of(create_ContractFormationPrimitive.evaluate(MapperS.of(execution(tradeState, exerciseInstruction).get()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), null));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		exerciseEvent
			.getOrCreatePrimitives(0)
			.setTransfer(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(settlementTerms(tradeState, exerciseInstruction).get()).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms())).get()) {
						return MapperS.of(create_TransferPrimitive.evaluate(MapperS.of(execution(tradeState, exerciseInstruction).get()).get(), MapperS.of(transferInstruction(tradeState, exerciseInstruction).get()).get(), MapperS.of(exerciseInstruction).<AdjustableOrAdjustedDate>map("getExerciseDate", _exerciseInstruction -> _exerciseInstruction.getExerciseDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return exerciseEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ExerciseInstruction exerciseInstruction);
	
	
	protected Mapper<? extends TransferInstruction> transferInstruction(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(securityTransferInstruction.evaluate(MapperS.of(tradeState).get()));
	}
	
	protected Mapper<? extends TradableProduct> tradableProduct(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct());
	}
	
	protected Mapper<? extends OptionPayout> optionPayout(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(MapperS.of(tradableProduct(tradeState, exerciseInstruction).get()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).get());
	}
	
	protected Mapper<? extends OptionExercise> exerciseTerms(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(optionPayout(tradeState, exerciseInstruction).get()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms());
	}
	
	protected Mapper<? extends Product> underlier(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(optionPayout(tradeState, exerciseInstruction).get()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier());
	}
	
	protected Mapper<? extends SettlementTerms> settlementTerms(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(optionPayout(tradeState, exerciseInstruction).get()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms());
	}
	
	protected Mapper<? extends TradeState> execution(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
		return MapperS.of(create_ExecutionPrimitive.evaluate(MapperS.of(underlier(tradeState, exerciseInstruction).get()).get(), MapperS.of(MapperS.of(tradableProduct(tradeState, exerciseInstruction).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(tradableProduct(tradeState, exerciseInstruction).get()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(tradableProduct(tradeState, exerciseInstruction).get()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Party>mapC("getParty", _trade -> _trade.getParty()).getMulti(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).getMulti(), null, null, MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("getValue", _f->_f.getValue()).get(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Identifier>mapC("getTradeIdentifier", _trade -> _trade.getTradeIdentifier()).getMulti())).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter());
	}
	public static final class Create_ExerciseDefault extends Create_Exercise {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ExerciseInstruction exerciseInstruction) {
			return BusinessEvent.builder();
		}
	}
}
