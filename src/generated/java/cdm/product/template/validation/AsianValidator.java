package cdm.product.template.validation;

import cdm.product.template.Asian;
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

public class AsianValidator implements Validator<Asian> {

	@Override
	public ValidationResult<Asian> validate(RosettaPath path, Asian o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("averagingInOut", o.getAveragingInOut()!=null ? 1 : 0, 1, 1),
				checkCardinality("strikeFactor", o.getStrikeFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("averagingPeriodIn", o.getAveragingPeriodIn()!=null ? 1 : 0, 0, 1),
				checkCardinality("averagingPeriodOut", o.getAveragingPeriodOut()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Asian", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Asian", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
