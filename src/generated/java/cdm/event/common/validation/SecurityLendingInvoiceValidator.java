package cdm.event.common.validation;

import cdm.event.common.SecurityLendingInvoice;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class SecurityLendingInvoiceValidator implements Validator<SecurityLendingInvoice> {

	@Override
	public ValidationResult<SecurityLendingInvoice> validate(RosettaPath path, SecurityLendingInvoice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("sendingParty", o.getSendingParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("receivingParty", o.getReceivingParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("billingStartDate", o.getBillingStartDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("billingEndDate", o.getBillingEndDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("billingRecord", o.getBillingRecord()==null?0:o.getBillingRecord().size(), 1, 0),
				checkCardinality("billingSummary", o.getBillingSummary()==null?0:o.getBillingSummary().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityLendingInvoice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityLendingInvoice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
