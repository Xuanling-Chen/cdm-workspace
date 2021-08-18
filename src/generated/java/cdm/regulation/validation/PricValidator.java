package cdm.regulation.validation;

import cdm.regulation.Pric;
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

public class PricValidator implements Validator<Pric> {

	@Override
	public ValidationResult<Pric> validate(RosettaPath path, Pric o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("pric", o.getPric()!=null ? 1 : 0, 1, 1),
				checkCardinality("bsisPts", o.getBsisPts()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Pric", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Pric", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
