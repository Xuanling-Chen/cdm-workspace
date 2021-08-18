package cdm.base.math.validation;

import cdm.base.math.Vector;
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

public class VectorValidator implements Validator<Vector> {

	@Override
	public ValidationResult<Vector> validate(RosettaPath path, Vector o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("values", o.getValues()==null?0:o.getValues().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Vector", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Vector", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
