package cdm.observable.asset.validation;

import cdm.observable.asset.RelativePrice;
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

public class RelativePriceValidator implements Validator<RelativePrice> {

	@Override
	public ValidationResult<RelativePrice> validate(RosettaPath path, RelativePrice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("spread", o.getSpread()!=null ? 1 : 0, 1, 1),
				checkCardinality("bondEquityModel", o.getBondEquityModel()==null?0:o.getBondEquityModel().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RelativePrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RelativePrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
