package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.ConcentrationLimit;
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

public class ConcentrationLimitValidator implements Validator<ConcentrationLimit> {

	@Override
	public ValidationResult<ConcentrationLimit> validate(RosettaPath path, ConcentrationLimit o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("concentrationLimitType", o.getConcentrationLimitType()!=null ? 1 : 0, 0, 1),
				checkCardinality("concentrationLimitCriteria", o.getConcentrationLimitCriteria()==null?0:o.getConcentrationLimitCriteria().size(), 0, 0),
				checkCardinality("valueCap", o.getValueCap()!=null ? 1 : 0, 0, 1),
				checkCardinality("percentageCap", o.getPercentageCap()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ConcentrationLimit", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ConcentrationLimit", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
