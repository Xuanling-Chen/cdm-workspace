package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.RelatedAgreement;
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

public class RelatedAgreementValidator implements Validator<RelatedAgreement> {

	@Override
	public ValidationResult<RelatedAgreement> validate(RosettaPath path, RelatedAgreement o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("legalAgreement", o.getLegalAgreement()!=null ? 1 : 0, 0, 1),
				checkCardinality("documentationIdentification", o.getDocumentationIdentification()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RelatedAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RelatedAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
