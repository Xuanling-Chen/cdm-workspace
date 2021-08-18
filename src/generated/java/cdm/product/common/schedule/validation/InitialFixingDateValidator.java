package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.InitialFixingDate;
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

public class InitialFixingDateValidator implements Validator<InitialFixingDate> {

	@Override
	public ValidationResult<InitialFixingDate> validate(RosettaPath path, InitialFixingDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("relativeDateOffset", o.getRelativeDateOffset()!=null ? 1 : 0, 0, 1),
				checkCardinality("initialFixingDate", o.getInitialFixingDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InitialFixingDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InitialFixingDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
