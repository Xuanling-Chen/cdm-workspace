package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Index;
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

public class IndexValidator implements Validator<Index> {

	@Override
	public ValidationResult<Index> validate(RosettaPath path, Index o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexType", o.getIndexType()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Index", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Index", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
