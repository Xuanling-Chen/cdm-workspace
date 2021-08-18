package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.AdditionalTerminationEvent;
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

public class AdditionalTerminationEventValidator implements Validator<AdditionalTerminationEvent> {

	@Override
	public ValidationResult<AdditionalTerminationEvent> validate(RosettaPath path, AdditionalTerminationEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", o.getName()!=null ? 1 : 0, 1, 1),
				checkCardinality("applicableParty", o.getApplicableParty()==null?0:o.getApplicableParty().size(), 1, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdditionalTerminationEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdditionalTerminationEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
