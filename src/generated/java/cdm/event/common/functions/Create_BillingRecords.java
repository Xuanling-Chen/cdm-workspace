package cdm.event.common.functions;

import cdm.event.common.BillingRecord;
import cdm.event.common.BillingRecord.BillingRecordBuilder;
import cdm.event.common.BillingRecordInstruction;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_BillingRecords.Create_BillingRecordsDefault.class)
public abstract class Create_BillingRecords implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param billingInstruction Instruction for creating the billing records contained within the invoice
	* @return billingRecord 
	*/
	public List<? extends BillingRecord> evaluate(List<? extends BillingRecordInstruction> billingInstruction) {
		
		List<BillingRecord.BillingRecordBuilder> billingRecordHolder = doEvaluate(billingInstruction);
		List<BillingRecord.BillingRecordBuilder> billingRecord = assignOutput(billingRecordHolder, billingInstruction);
		
		if (billingRecord!=null) objectValidator.validateAndFailOnErorr(BillingRecord.class, billingRecord);
		return billingRecord;
	}
	
	private List<BillingRecord.BillingRecordBuilder> assignOutput(List<BillingRecord.BillingRecordBuilder> billingRecord, List<? extends BillingRecordInstruction> billingInstruction) {
		return billingRecord;
	}

	protected abstract List<BillingRecord.BillingRecordBuilder> doEvaluate(List<? extends BillingRecordInstruction> billingInstruction);
	
	public static final class Create_BillingRecordsDefault extends Create_BillingRecords {
		@Override
		protected  List<BillingRecord.BillingRecordBuilder> doEvaluate(List<? extends BillingRecordInstruction> billingInstruction) {
			return Arrays.asList();
		}
	}
}
