package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.AddressForNotices;
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

public class AddressForNoticesValidator implements Validator<AddressForNotices> {

	@Override
	public ValidationResult<AddressForNotices> validate(RosettaPath path, AddressForNotices o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryNotices", o.getPrimaryNotices()!=null ? 1 : 0, 1, 1),
				checkCardinality("additionalNotices", o.getAdditionalNotices()==null?0:o.getAdditionalNotices().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AddressForNotices", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AddressForNotices", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
