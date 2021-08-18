package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.OtherAgreements;
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

public class OtherAgreementsValidator implements Validator<OtherAgreements> {

	@Override
	public ValidationResult<OtherAgreements> validate(RosettaPath path, OtherAgreements o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("otherCsa", o.getOtherCsa()!=null ? 1 : 0, 0, 1),
				checkCardinality("japaneseLawCsa", o.getJapaneseLawCsa()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OtherAgreements", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OtherAgreements", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
