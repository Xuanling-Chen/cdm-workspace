package cdm.event.common.validation;

import cdm.event.common.BillingSummary;
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

public class BillingSummaryValidator implements Validator<BillingSummary> {

	@Override
	public ValidationResult<BillingSummary> validate(RosettaPath path, BillingSummary o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("summaryTransfer", o.getSummaryTransfer()!=null ? 1 : 0, 0, 1),
				checkCardinality("summaryAmountType", o.getSummaryAmountType()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BillingSummary", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BillingSummary", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
