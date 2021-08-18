package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.SecurityProviderRightsEvent;
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

public class SecurityProviderRightsEventValidator implements Validator<SecurityProviderRightsEvent> {

	@Override
	public ValidationResult<SecurityProviderRightsEvent> validate(RosettaPath path, SecurityProviderRightsEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", o.getPartyElection()==null?0:o.getPartyElection().size(), 0, 2),
				checkCardinality("includeCoolingOffLanguage", o.getIncludeCoolingOffLanguage()!=null ? 1 : 0, 1, 1),
				checkCardinality("fullDischarge", o.getFullDischarge()!=null ? 1 : 0, 0, 1),
				checkCardinality("automaticSetOff", o.getAutomaticSetOff()!=null ? 1 : 0, 0, 1),
				checkCardinality("customElection", o.getCustomElection()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityProviderRightsEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityProviderRightsEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
