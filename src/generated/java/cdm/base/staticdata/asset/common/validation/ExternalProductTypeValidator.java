package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ExternalProductType;
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

public class ExternalProductTypeValidator implements Validator<ExternalProductType> {

	@Override
	public ValidationResult<ExternalProductType> validate(RosettaPath path, ExternalProductType o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", o.getValue()!=null ? 1 : 0, 1, 1),
				checkCardinality("externalProductTypeSource", o.getExternalProductTypeSource()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExternalProductType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExternalProductType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
