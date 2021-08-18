package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.SecuredPartyRightsEvent;
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

public class SecuredPartyRightsEventValidator implements Validator<SecuredPartyRightsEvent> {

	@Override
	public ValidationResult<SecuredPartyRightsEvent> validate(RosettaPath path, SecuredPartyRightsEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("securedPartyRightsEventElection", o.getSecuredPartyRightsEventElection()==null?0:o.getSecuredPartyRightsEventElection().size(), 0, 2),
				checkCardinality("earlyTerminationDateOptionalLanguage", o.getEarlyTerminationDateOptionalLanguage()!=null ? 1 : 0, 1, 1),
				checkCardinality("failureToPayEarlyTermination", o.getFailureToPayEarlyTermination()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecuredPartyRightsEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecuredPartyRightsEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
