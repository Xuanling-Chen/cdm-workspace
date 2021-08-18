package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.RightsEvents;
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

public class RightsEventsValidator implements Validator<RightsEvents> {

	@Override
	public ValidationResult<RightsEvents> validate(RosettaPath path, RightsEvents o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityTakerRightsEvent", o.getSecurityTakerRightsEvent()!=null ? 1 : 0, 1, 1),
				checkCardinality("controlAgreementNecEvent", o.getControlAgreementNecEvent()!=null ? 1 : 0, 0, 1),
				checkCardinality("securityProviderRightsEvent", o.getSecurityProviderRightsEvent()!=null ? 1 : 0, 1, 1),
				checkCardinality("deliveryInLieuRight", o.getDeliveryInLieuRight()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalRightsEvent", o.getAdditionalRightsEvent()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RightsEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RightsEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
