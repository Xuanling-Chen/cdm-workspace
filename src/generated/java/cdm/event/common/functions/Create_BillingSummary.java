package cdm.event.common.functions;

import cdm.event.common.BillingRecord;
import cdm.event.common.BillingSummary;
import cdm.event.common.BillingSummary.BillingSummaryBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_BillingSummary.Create_BillingSummaryDefault.class)
public abstract class Create_BillingSummary implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param billingRecord 
	* @return billingSummary 
	*/
	public BillingSummary evaluate(List<? extends BillingRecord> billingRecord) {
		
		BillingSummary.BillingSummaryBuilder billingSummaryHolder = doEvaluate(billingRecord);
		BillingSummary.BillingSummaryBuilder billingSummary = assignOutput(billingSummaryHolder, billingRecord);
		
		if (billingSummary!=null) objectValidator.validateAndFailOnErorr(BillingSummary.class, billingSummary);
		return billingSummary;
	}
	
	private BillingSummary.BillingSummaryBuilder assignOutput(BillingSummary.BillingSummaryBuilder billingSummary, List<? extends BillingRecord> billingRecord) {
		return billingSummary;
	}

	protected abstract BillingSummary.BillingSummaryBuilder doEvaluate(List<? extends BillingRecord> billingRecord);
	
	public static final class Create_BillingSummaryDefault extends Create_BillingSummary {
		@Override
		protected  BillingSummary.BillingSummaryBuilder doEvaluate(List<? extends BillingRecord> billingRecord) {
			return BillingSummary.builder();
		}
	}
}
