package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.AccessConditions;
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

public class AccessConditionsValidator implements Validator<AccessConditions> {

	@Override
	public ValidationResult<AccessConditions> validate(RosettaPath path, AccessConditions o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", o.getPartyElection()==null?0:o.getPartyElection().size(), 2, 2),
				checkCardinality("additionalTerminationEvent", o.getAdditionalTerminationEvent()==null?0:o.getAdditionalTerminationEvent().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AccessConditions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AccessConditions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
