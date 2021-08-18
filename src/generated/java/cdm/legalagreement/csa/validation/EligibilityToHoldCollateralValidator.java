package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.EligibilityToHoldCollateral;
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

public class EligibilityToHoldCollateralValidator implements Validator<EligibilityToHoldCollateral> {

	@Override
	public ValidationResult<EligibilityToHoldCollateral> validate(RosettaPath path, EligibilityToHoldCollateral o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyTerms", o.getPartyTerms()==null?0:o.getPartyTerms().size(), 1, 0),
				checkCardinality("custodianTerms", o.getCustodianTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("eligibleCountry", o.getEligibleCountry()==null?0:o.getEligibleCountry().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EligibilityToHoldCollateral", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EligibilityToHoldCollateral", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
