package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustedRelativeDateOffset;
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

public class AdjustedRelativeDateOffsetValidator implements Validator<AdjustedRelativeDateOffset> {

	@Override
	public ValidationResult<AdjustedRelativeDateOffset> validate(RosettaPath path, AdjustedRelativeDateOffset o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("relativeDateAdjustments", o.getRelativeDateAdjustments()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdjustedRelativeDateOffset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdjustedRelativeDateOffset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
