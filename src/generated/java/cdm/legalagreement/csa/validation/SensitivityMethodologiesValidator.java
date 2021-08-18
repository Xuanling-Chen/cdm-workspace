package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.SensitivityMethodologies;
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

public class SensitivityMethodologiesValidator implements Validator<SensitivityMethodologies> {

	@Override
	public ValidationResult<SensitivityMethodologies> validate(RosettaPath path, SensitivityMethodologies o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("sensitivityToEquity", o.getSensitivityToEquity()!=null ? 1 : 0, 1, 1),
				checkCardinality("sensitivityToCommodity", o.getSensitivityToCommodity()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SensitivityMethodologies", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SensitivityMethodologies", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
