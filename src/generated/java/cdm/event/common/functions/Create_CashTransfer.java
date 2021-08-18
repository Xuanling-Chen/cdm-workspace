package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractAncillaryPartyByRole;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.event.common.TransferInstruction;
import cdm.event.common.functions.ResolveCashflow;
import cdm.observable.asset.Money;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaSecurityFinancePayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_CashTransfer.Create_CashTransferDefault.class)
public abstract class Create_CashTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractAncillaryPartyByRole extractAncillaryPartyByRole;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected ResolveCashflow resolveCashflow;

	/**
	* @param tradeState Represents the trade and associated state on which to construct the Transfer data type.
	* @param instruction 
	* @param date Specifies the date the transfer is to take place.
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @return transfer 
	*/
	public Transfer evaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		
		Transfer.TransferBuilder transferHolder = doEvaluate(tradeState, instruction, date, quantity);
		Transfer.TransferBuilder transfer = assignOutput(transferHolder, tradeState, instruction, date, quantity);
		
		if (transfer!=null) objectValidator.validateAndFailOnErorr(Transfer.class, transfer);
		return transfer;
	}
	
	private Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		transfer
			.getOrCreateQuantity()
			.setAmount(MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<Money>map("getCashflowAmount", _cashflow -> _cashflow.getCashflowAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get())
		;
		transfer
			.getOrCreateQuantity()
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<Money>map("getCashflowAmount", _cashflow -> _cashflow.getCashflowAmount()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setPayerPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.of(MapperS.of(extractAncillaryPartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()).get())).<ReferenceWithMetaParty>mapC("getPartyReference", _ancillaryParty -> _ancillaryParty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get());
					}
			}).get())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setReceiverPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.of(MapperS.of(extractAncillaryPartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()).get())).<ReferenceWithMetaParty>mapC("getPartyReference", _ancillaryParty -> _ancillaryParty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get());
					}
			}).get())
		;
		transfer
			.setSettlementDate(MapperS.of(cashflow(tradeState, instruction, date, quantity).get()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).get())
		;
		transfer
			.getOrCreateSettlementOrigin()
			.setInterestRatePayout(ReferenceWithMetaInterestRatePayout.builder().setGlobalReference(
					Optional.ofNullable(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
					if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())).get()) {
								return MapperS.of(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get());
							}
					else {
								return MapperS.ofNull();
							}
					}).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		transfer
			.getOrCreateSettlementOrigin()
			.setEquityPayout(ReferenceWithMetaEquityPayout.builder().setGlobalReference(
					Optional.ofNullable(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
					if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout())).get()) {
								return MapperS.of(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get());
							}
					else {
								return MapperS.ofNull();
							}
					}).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		transfer
			.getOrCreateSettlementOrigin()
			.setSecurityFinancePayout(ReferenceWithMetaSecurityFinancePayout.builder().setGlobalReference(
					Optional.ofNullable(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
					if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout())).get()) {
								return MapperS.of(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
							}
					else {
								return MapperS.ofNull();
							}
					}).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity);
	
	
	protected Mapper<? extends Cashflow> cashflow(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return MapperS.of(resolveCashflow.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get(), MapperS.of(date).get(), MapperS.of(quantity).get()));
	}
	public static final class Create_CashTransferDefault extends Create_CashTransfer {
		@Override
		protected  Transfer.TransferBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
			return Transfer.builder();
		}
	}
}
