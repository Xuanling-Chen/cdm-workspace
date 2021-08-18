package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.IndependentAmount;
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

public class IndependentAmountValidator implements Validator<IndependentAmount> {

	@Override
	public ValidationResult<IndependentAmount> validate(RosettaPath path, IndependentAmount o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentDetail", o.getPaymentDetail()==null?0:o.getPaymentDetail().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IndependentAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IndependentAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
