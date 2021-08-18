package cdm.product.template.validation;

import cdm.product.template.EarlyTerminationProvision;
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

public class EarlyTerminationProvisionValidator implements Validator<EarlyTerminationProvision> {

	@Override
	public ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, EarlyTerminationProvision o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("mandatoryEarlyTermination", o.getMandatoryEarlyTermination()!=null ? 1 : 0, 0, 1),
				checkCardinality("mandatoryEarlyTerminationDateTenor", o.getMandatoryEarlyTerminationDateTenor()!=null ? 1 : 0, 0, 1),
				checkCardinality("optionalEarlyTermination", o.getOptionalEarlyTermination()!=null ? 1 : 0, 0, 1),
				checkCardinality("optionalEarlyTerminationParameters", o.getOptionalEarlyTerminationParameters()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EarlyTerminationProvision", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EarlyTerminationProvision", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
