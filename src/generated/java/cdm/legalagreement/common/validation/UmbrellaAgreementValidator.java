package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.UmbrellaAgreement;
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

public class UmbrellaAgreementValidator implements Validator<UmbrellaAgreement> {

	@Override
	public ValidationResult<UmbrellaAgreement> validate(RosettaPath path, UmbrellaAgreement o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("language", o.getLanguage()!=null ? 1 : 0, 0, 1),
				checkCardinality("parties", o.getParties()==null?0:o.getParties().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("UmbrellaAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("UmbrellaAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
