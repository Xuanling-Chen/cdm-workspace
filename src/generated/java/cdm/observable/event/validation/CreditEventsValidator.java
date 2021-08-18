package cdm.observable.event.validation;

import cdm.observable.event.CreditEvents;
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

public class CreditEventsValidator implements Validator<CreditEvents> {

	@Override
	public ValidationResult<CreditEvents> validate(RosettaPath path, CreditEvents o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("bankruptcy", o.getBankruptcy()!=null ? 1 : 0, 0, 1),
				checkCardinality("failureToPay", o.getFailureToPay()!=null ? 1 : 0, 0, 1),
				checkCardinality("failureToPayPrincipal", o.getFailureToPayPrincipal()!=null ? 1 : 0, 0, 1),
				checkCardinality("failureToPayInterest", o.getFailureToPayInterest()!=null ? 1 : 0, 0, 1),
				checkCardinality("obligationDefault", o.getObligationDefault()!=null ? 1 : 0, 0, 1),
				checkCardinality("obligationAcceleration", o.getObligationAcceleration()!=null ? 1 : 0, 0, 1),
				checkCardinality("repudiationMoratorium", o.getRepudiationMoratorium()!=null ? 1 : 0, 0, 1),
				checkCardinality("restructuring", o.getRestructuring()!=null ? 1 : 0, 0, 1),
				checkCardinality("governmentalIntervention", o.getGovernmentalIntervention()!=null ? 1 : 0, 0, 1),
				checkCardinality("distressedRatingsDowngrade", o.getDistressedRatingsDowngrade()!=null ? 1 : 0, 0, 1),
				checkCardinality("maturityExtension", o.getMaturityExtension()!=null ? 1 : 0, 0, 1),
				checkCardinality("writedown", o.getWritedown()!=null ? 1 : 0, 0, 1),
				checkCardinality("impliedWritedown", o.getImpliedWritedown()!=null ? 1 : 0, 0, 1),
				checkCardinality("defaultRequirement", o.getDefaultRequirement()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditEventNotice", o.getCreditEventNotice()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
