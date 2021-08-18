package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.PostedCreditSupportItem;
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

public class PostedCreditSupportItemValidator implements Validator<PostedCreditSupportItem> {

	@Override
	public ValidationResult<PostedCreditSupportItem> validate(RosettaPath path, PostedCreditSupportItem o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashOrSecurityValue", o.getCashOrSecurityValue()!=null ? 1 : 0, 1, 1),
				checkCardinality("haircutPercentage", o.getHaircutPercentage()!=null ? 1 : 0, 1, 1),
				checkCardinality("fxHaircutPercentage", o.getFxHaircutPercentage()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalHaircutPercentage", o.getAdditionalHaircutPercentage()!=null ? 1 : 0, 0, 1),
				checkCardinality("disputedCashOrSecurityValue", o.getDisputedCashOrSecurityValue()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PostedCreditSupportItem", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PostedCreditSupportItem", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
