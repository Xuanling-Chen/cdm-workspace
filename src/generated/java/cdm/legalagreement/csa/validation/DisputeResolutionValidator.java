package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.DisputeResolution;
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

public class DisputeResolutionValidator implements Validator<DisputeResolution> {

	@Override
	public ValidationResult<DisputeResolution> validate(RosettaPath path, DisputeResolution o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("resolutionTime", o.getResolutionTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherTerms", o.getOtherTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("valueTerms", o.getValueTerms()!=null ? 1 : 0, 1, 1),
				checkCardinality("alternativeTerms", o.getAlternativeTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("recalculationOfValue", o.getRecalculationOfValue()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DisputeResolution", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DisputeResolution", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
