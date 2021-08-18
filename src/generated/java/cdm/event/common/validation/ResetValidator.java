package cdm.event.common.validation;

import cdm.event.common.Reset;
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

public class ResetValidator implements Validator<Reset> {

	@Override
	public ValidationResult<Reset> validate(RosettaPath path, Reset o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("resetValue", o.getResetValue()!=null ? 1 : 0, 1, 1),
				checkCardinality("resetDate", o.getResetDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("rateRecordDate", o.getRateRecordDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("observations", o.getObservations()==null?0:o.getObservations().size(), 1, 0),
				checkCardinality("aggregationMethodology", o.getAggregationMethodology()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Reset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Reset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
