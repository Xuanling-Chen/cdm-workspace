package cdm.base.datetime.validation;

import cdm.base.datetime.Frequency;
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

public class FrequencyValidator implements Validator<Frequency> {

	@Override
	public ValidationResult<Frequency> validate(RosettaPath path, Frequency o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", o.getPeriodMultiplier()!=null ? 1 : 0, 1, 1),
				checkCardinality("period", o.getPeriod()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Frequency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Frequency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
