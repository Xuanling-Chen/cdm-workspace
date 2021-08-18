package cdm.event.common.functions;

import cdm.event.common.BillingRecord;
import cdm.event.common.BillingRecord.BillingRecordBuilder;
import cdm.event.common.BillingRecordInstruction;
import cdm.event.common.Reset;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.functions.ResolveSecurityFinanceBillingAmount;
import cdm.observable.event.functions.Create_SecurityFinanceTradeStateWithObservations;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_BillingRecord.Create_BillingRecordDefault.class)
public abstract class Create_BillingRecord implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SecurityFinanceTradeStateWithObservations create_SecurityFinanceTradeStateWithObservations;
	@Inject protected ResolveSecurityFinanceBillingAmount resolveSecurityFinanceBillingAmount;

	/**
	* @param billingInstruction Instruction for creating the billing records contained within the invoice
	* @return billingRecord The billing record
	*/
	public BillingRecord evaluate(BillingRecordInstruction billingInstruction) {
		
		BillingRecord.BillingRecordBuilder billingRecordHolder = doEvaluate(billingInstruction);
		BillingRecord.BillingRecordBuilder billingRecord = assignOutput(billingRecordHolder, billingInstruction);
		
		if (billingRecord!=null) objectValidator.validateAndFailOnErorr(BillingRecord.class, billingRecord);
		return billingRecord;
	}
	
	private BillingRecord.BillingRecordBuilder assignOutput(BillingRecord.BillingRecordBuilder billingRecord, BillingRecordInstruction billingInstruction) {
		billingRecord
			.setRecordStartDate(MapperS.of(billingInstruction).<Date>map("getRecordStartDate", _billingRecordInstruction -> _billingRecordInstruction.getRecordStartDate()).get())
		;
		billingRecord
			.setRecordEndDate(MapperS.of(billingInstruction).<Date>map("getRecordEndDate", _billingRecordInstruction -> _billingRecordInstruction.getRecordEndDate()).get())
		;
		billingRecord
			.setTradeStateValue(MapperS.of(tradeState(billingInstruction).get()).get())
		;
		billingRecord
			.setRecordTransfer(MapperS.of(billingAmount(billingInstruction).get()).get())
		;
		return billingRecord;
	}

	protected abstract BillingRecord.BillingRecordBuilder doEvaluate(BillingRecordInstruction billingInstruction);
	
	
	protected Mapper<? extends TradeState> tradeState(BillingRecordInstruction billingInstruction) {
		return MapperS.of(create_SecurityFinanceTradeStateWithObservations.evaluate(MapperS.of(billingInstruction).get()));
	}
	
	protected Mapper<? extends Transfer> billingAmount(BillingRecordInstruction billingInstruction) {
		return MapperS.of(resolveSecurityFinanceBillingAmount.evaluate(MapperS.of(tradeState(billingInstruction).get()).get(), MapperS.of(MapperS.of(tradeState(billingInstruction).get()).<Reset>mapC("getResetHistory", _tradeState -> _tradeState.getResetHistory()).get()).get(), MapperS.of(billingInstruction).<Date>map("getRecordStartDate", _billingRecordInstruction -> _billingRecordInstruction.getRecordStartDate()).get(), MapperS.of(billingInstruction).<Date>map("getRecordEndDate", _billingRecordInstruction -> _billingRecordInstruction.getRecordEndDate()).get(), MapperS.of(billingInstruction).<Date>map("getSettlementDate", _billingRecordInstruction -> _billingRecordInstruction.getSettlementDate()).get()));
	}
	public static final class Create_BillingRecordDefault extends Create_BillingRecord {
		@Override
		protected  BillingRecord.BillingRecordBuilder doEvaluate(BillingRecordInstruction billingInstruction) {
			return BillingRecord.builder();
		}
	}
}
