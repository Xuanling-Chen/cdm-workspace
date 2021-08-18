package cdm.regulation.validation;

import cdm.regulation.RefRate;
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

public class RefRateValidator implements Validator<RefRate> {

	@Override
	public ValidationResult<RefRate> validate(RosettaPath path, RefRate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("indx", o.getIndx()!=null ? 1 : 0, 1, 1),
				checkCardinality("nm", o.getNm()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RefRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RefRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
