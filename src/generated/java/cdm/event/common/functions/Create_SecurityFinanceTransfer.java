package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
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
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.product.common.TradeLot;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SecurityFinanceLeg;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.metafields.ReferenceWithMetaSecurityFinancePayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_SecurityFinanceTransfer.Create_SecurityFinanceTransferDefault.class)
public abstract class Create_SecurityFinanceTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractAncillaryPartyByRole extractAncillaryPartyByRole;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected FilterPrice filterPrice;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param tradeState Represents the trade and associated state on which to construct the Transfer data type.
	* @param instruction 
	* @param date Specifies the date the transfer is to take place.
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @return transfer 
	*/
	public Transfer evaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		// pre-conditions
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(quantity)).get()) {
							return areEqual(MapperS.of(quantity).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FinancialUnitEnum>map("getFinancialUnit", _unitType -> _unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All);
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "";
		
		Transfer.TransferBuilder transferHolder = doEvaluate(tradeState, instruction, date, quantity);
		Transfer.TransferBuilder transfer = assignOutput(transferHolder, tradeState, instruction, date, quantity);
		
		if (transfer!=null) objectValidator.validateAndFailOnErorr(Transfer.class, transfer);
		return transfer;
	}
	
	private Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		transfer
			.setQuantity(MapperS.of(securityQuantity(tradeState, instruction, date, quantity).get()).get())
		;
		transfer
			.getOrCreateObservable()
			.addProductIdentifierValue(MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<Product>map("getSecurityInformation", _securityFinancePayout -> _securityFinancePayout.getSecurityInformation()).<Security>map("getSecurity", _product -> _product.getSecurity()).<ReferenceWithMetaProductIdentifier>mapC("getProductIdentifier", _productBase -> _productBase.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()).getMulti())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setPayerPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", _transferInstruction -> _transferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", _transferInstruction -> _transferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
					else if (exists(MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
					else {
						return MapperS.of(MapperS.of(extractAncillaryPartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()).get())).<ReferenceWithMetaParty>mapC("getPartyReference", _ancillaryParty -> _ancillaryParty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get());
					}
			}).get())
		;
		transfer
			.getOrCreatePayerReceiver()
			.setReceiverPartyReferenceValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", _transferInstruction -> _transferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", _transferInstruction -> _transferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
					else if (exists(MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver())).get()) {
						return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).<Party>map("getValue", _f->_f.getValue());
					}
					else {
						return MapperS.of(MapperS.of(extractAncillaryPartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()).get())).<ReferenceWithMetaParty>mapC("getPartyReference", _ancillaryParty -> _ancillaryParty.getPartyReference()).<Party>map("getValue", _f->_f.getValue()).get());
					}
			}).get())
		;
		transfer
			.getOrCreateSettlementDate()
			.setAdjustedDateValue(MapperS.of(date).get())
		;
		transfer
			.getOrCreateSettlementOrigin()
			.setSecurityFinancePayout(ReferenceWithMetaSecurityFinancePayout.builder().setGlobalReference(
					Optional.ofNullable(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
					if (exists(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout())).get()) {
								return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
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
	
	
	protected Mapper<? extends SecurityFinancePayout> securityFinancePayout(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
	}
	
	protected Mapper<? extends SecurityFinanceLeg> securityFinanceLeg(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return MapperS.of(MapperS.of(securityFinancePayout(tradeState, instruction, date, quantity).get()).<SecurityFinanceLeg>mapC("getSecurityFinanceLeg", _securityFinancePayout -> _securityFinancePayout.getSecurityFinanceLeg()).get());
	}
	
	protected Mapper<? extends Quantity> securityQuantity(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(quantity)).get()) {
					return MapperS.of(quantity);
				}
		else {
					return MapperS.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(FinancialUnitEnum.SHARE).get()));
				}
		});
	}
	
	protected Mapper<? extends Price> securityPrice(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
		return MapperS.of(filterPrice.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(PriceTypeEnum.NET_PRICE).get()));
	}
	public static final class Create_SecurityFinanceTransferDefault extends Create_SecurityFinanceTransfer {
		@Override
		protected  Transfer.TransferBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date, Quantity quantity) {
			return Transfer.builder();
		}
	}
}
