package cdm.event.common.functions;

import cdm.base.math.UnitType;
import cdm.base.math.functions.Abs;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.Reset;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.EquityPerformance;
import cdm.event.common.functions.ResolveCashSettlementDate;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.functions.ResolveEquityInitialPrice;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(EquityCashSettlementAmount.EquityCashSettlementAmountDefault.class)
public abstract class EquityCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected EquityPerformance equityPerformance;
	@Inject protected ResolveCashSettlementDate resolveCashSettlementDate;
	@Inject protected ResolveEquityInitialPrice resolveEquityInitialPrice;

	/**
	* @param tradeState 
	* @param date 
	* @return equityCashSettlementAmount 
	*/
	public Cashflow evaluate(TradeState tradeState, Date date) {
		
		Cashflow.CashflowBuilder equityCashSettlementAmountHolder = doEvaluate(tradeState, date);
		Cashflow.CashflowBuilder equityCashSettlementAmount = assignOutput(equityCashSettlementAmountHolder, tradeState, date);
		
		if (equityCashSettlementAmount!=null) objectValidator.validateAndFailOnErorr(Cashflow.class, equityCashSettlementAmount);
		return equityCashSettlementAmount;
	}
	
	private Cashflow.CashflowBuilder assignOutput(Cashflow.CashflowBuilder equityCashSettlementAmount, TradeState tradeState, Date date) {
		equityCashSettlementAmount
			.getOrCreateCashflowAmount()
			.setAmount(MapperS.of(abs.evaluate(MapperS.of(equityPerformance(tradeState, date).get()).get())).get())
		;
		equityCashSettlementAmount
			.getOrCreateCashflowAmount()
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(resolveEquityInitialPrice.evaluate(MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti())).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get())
		;
		equityCashSettlementAmount
			.getOrCreatePayerReceiver()
			.setPayer(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(equityPerformance(tradeState, date).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(equityPayout(tradeState, date).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			else {
						return MapperS.of(equityPayout(tradeState, date).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			}).get())
		;
		equityCashSettlementAmount
			.getOrCreatePayerReceiver()
			.setReceiver(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(equityPerformance(tradeState, date).get()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
						return MapperS.of(equityPayout(tradeState, date).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver());
					}
			else {
						return MapperS.of(equityPayout(tradeState, date).get()).<PayerReceiver>map("getPayerReceiver", _payoutBase -> _payoutBase.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer());
					}
			}).get())
		;
		equityCashSettlementAmount
			.getOrCreateCashflowDate()
			.setAdjustedDateValue(MapperS.of(resolveCashSettlementDate.evaluate(MapperS.of(tradeState).get())).get())
		;
		return equityCashSettlementAmount;
	}

	protected abstract Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, Date date);
	
	
	protected Mapper<? extends EquityPayout> equityPayout(TradeState tradeState, Date date) {
		return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get());
	}
	
	protected Mapper<BigDecimal> equityPerformance(TradeState tradeState, Date date) {
		return MapperS.of(equityPerformance.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), MapperS.of(MapperS.of(tradeState).<Reset>mapC("getResetHistory", _tradeState -> _tradeState.getResetHistory()).get()).<Price>map("getResetValue", _reset -> _reset.getResetValue()).get(), MapperS.of(date).get()));
	}
	public static final class EquityCashSettlementAmountDefault extends EquityCashSettlementAmount {
		@Override
		protected  Cashflow.CashflowBuilder doEvaluate(TradeState tradeState, Date date) {
			return Cashflow.builder();
		}
	}
}
