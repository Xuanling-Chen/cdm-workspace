package cdm.product.template.validation;

import cdm.product.template.Quanto;
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

public class QuantoValidator implements Validator<Quanto> {

	@Override
	public ValidationResult<Quanto> validate(RosettaPath path, Quanto o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxRate", o.getFxRate()==null?0:o.getFxRate().size(), 0, 0),
				checkCardinality("fxSpotRateSource", o.getFxSpotRateSource()!=null ? 1 : 0, 0, 1),
				checkCardinality("fixingTime", o.getFixingTime()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Quanto", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Quanto", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
