package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.AveragingPeriod;
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

public class AveragingPeriodValidator implements Validator<AveragingPeriod> {

	@Override
	public ValidationResult<AveragingPeriod> validate(RosettaPath path, AveragingPeriod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("schedule", o.getSchedule()==null?0:o.getSchedule().size(), 0, 0),
				checkCardinality("averagingDateTimes", o.getAveragingDateTimes()!=null ? 1 : 0, 0, 1),
				checkCardinality("averagingObservations", o.getAveragingObservations()!=null ? 1 : 0, 0, 1),
				checkCardinality("marketDisruption", o.getMarketDisruption()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AveragingPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AveragingPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
