package cdm.base.datetime.validation;

import cdm.base.datetime.RelativeDateOffset;
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

public class RelativeDateOffsetValidator implements Validator<RelativeDateOffset> {

	@Override
	public ValidationResult<RelativeDateOffset> validate(RosettaPath path, RelativeDateOffset o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDayConvention", o.getBusinessDayConvention()!=null ? 1 : 0, 1, 1),
				checkCardinality("businessCenters", o.getBusinessCenters()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessCentersReference", o.getBusinessCentersReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateRelativeTo", o.getDateRelativeTo()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedDate", o.getAdjustedDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RelativeDateOffset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RelativeDateOffset", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
