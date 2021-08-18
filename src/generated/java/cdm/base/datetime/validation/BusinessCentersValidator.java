package cdm.base.datetime.validation;

import cdm.base.datetime.BusinessCenters;
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

public class BusinessCentersValidator implements Validator<BusinessCenters> {

	@Override
	public ValidationResult<BusinessCenters> validate(RosettaPath path, BusinessCenters o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessCenter", o.getBusinessCenter()==null?0:o.getBusinessCenter().size(), 0, 0),
				checkCardinality("businessCentersReference", o.getBusinessCentersReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BusinessCenters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BusinessCenters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
