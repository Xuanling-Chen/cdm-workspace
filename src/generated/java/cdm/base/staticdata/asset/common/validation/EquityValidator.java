package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Equity;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class EquityValidator implements Validator<Equity> {

	@Override
	public ValidationResult<Equity> validate(RosettaPath path, Equity o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Equity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Equity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
