package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.EligibleCollateralCriteria;
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

public class EligibleCollateralCriteriaValidator implements Validator<EligibleCollateralCriteria> {

	@Override
	public ValidationResult<EligibleCollateralCriteria> validate(RosettaPath path, EligibleCollateralCriteria o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuer", o.getIssuer()==null?0:o.getIssuer().size(), 0, 0),
				checkCardinality("asset", o.getAsset()==null?0:o.getAsset().size(), 0, 0),
				checkCardinality("treatment", o.getTreatment()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EligibleCollateralCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EligibleCollateralCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
