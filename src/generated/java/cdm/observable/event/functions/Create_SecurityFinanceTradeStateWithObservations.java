package cdm.observable.event.functions;

import cdm.event.common.BillingRecordInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.event.Observation;
import cdm.observable.event.functions.Create_SecurityFinanceReset;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_SecurityFinanceTradeStateWithObservations.Create_SecurityFinanceTradeStateWithObservationsDefault.class)
public abstract class Create_SecurityFinanceTradeStateWithObservations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SecurityFinanceReset create_SecurityFinanceReset;

	/**
	* @param billingInstruction 
	* @return tradeState 
	*/
	public TradeState evaluate(BillingRecordInstruction billingInstruction) {
		
		TradeState.TradeStateBuilder tradeStateHolder = doEvaluate(billingInstruction);
		TradeState.TradeStateBuilder tradeState = assignOutput(tradeStateHolder, billingInstruction);
		
		if (tradeState!=null) objectValidator.validateAndFailOnErorr(TradeState.class, tradeState);
		return tradeState;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, BillingRecordInstruction billingInstruction) {
		tradeState = toBuilder(MapperS.of(billingInstruction).<ReferenceWithMetaTradeState>map("getTradeState", _billingRecordInstruction -> _billingRecordInstruction.getTradeState()).<TradeState>map("getValue", _f->_f.getValue()).get())
		;
		tradeState
			.addResetHistory(MapperS.of(create_SecurityFinanceReset.evaluate(MapperS.of(securityFinancePayout(billingInstruction).get()).get(), MapperS.of(billingInstruction).<Observation>mapC("getObservation", _billingRecordInstruction -> _billingRecordInstruction.getObservation()).getMulti(), MapperS.of(date(billingInstruction).get()).get())).get())
		;
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(BillingRecordInstruction billingInstruction);
	
	
	protected Mapper<? extends SecurityFinancePayout> securityFinancePayout(BillingRecordInstruction billingInstruction) {
		return MapperS.of(MapperS.of(billingInstruction).<ReferenceWithMetaTradeState>map("getTradeState", _billingRecordInstruction -> _billingRecordInstruction.getTradeState()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()).get());
	}
	
	protected Mapper<Date> date(BillingRecordInstruction billingInstruction) {
		return MapperS.of(billingInstruction).<Date>map("getRecordEndDate", _billingRecordInstruction -> _billingRecordInstruction.getRecordEndDate());
	}
	public static final class Create_SecurityFinanceTradeStateWithObservationsDefault extends Create_SecurityFinanceTradeStateWithObservations {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(BillingRecordInstruction billingInstruction) {
			return TradeState.builder();
		}
	}
}
