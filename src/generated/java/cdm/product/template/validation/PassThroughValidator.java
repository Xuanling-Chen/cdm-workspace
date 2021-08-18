package cdm.product.template.validation;

import cdm.product.template.PassThrough;
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

public class PassThroughValidator implements Validator<PassThrough> {

	@Override
	public ValidationResult<PassThrough> validate(RosettaPath path, PassThrough o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("passThroughItem", o.getPassThroughItem()==null?0:o.getPassThroughItem().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PassThrough", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PassThrough", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
