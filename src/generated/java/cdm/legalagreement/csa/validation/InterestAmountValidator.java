package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.InterestAmount;
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

public class InterestAmountValidator implements Validator<InterestAmount> {

	@Override
	public ValidationResult<InterestAmount> validate(RosettaPath path, InterestAmount o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("returnAmount", o.getReturnAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("deliveryAmount", o.getDeliveryAmount()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InterestAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InterestAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
