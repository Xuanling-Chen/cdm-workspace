package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.UmbrellaAgreementEntity;
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

public class UmbrellaAgreementEntityValidator implements Validator<UmbrellaAgreementEntity> {

	@Override
	public ValidationResult<UmbrellaAgreementEntity> validate(RosettaPath path, UmbrellaAgreementEntity o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("terms", o.getTerms()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("UmbrellaAgreementEntity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("UmbrellaAgreementEntity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
