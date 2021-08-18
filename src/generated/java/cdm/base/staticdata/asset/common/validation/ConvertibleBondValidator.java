package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ConvertibleBond;
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

public class ConvertibleBondValidator implements Validator<ConvertibleBond> {

	@Override
	public ValidationResult<ConvertibleBond> validate(RosettaPath path, ConvertibleBond o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ConvertibleBond", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ConvertibleBond", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
