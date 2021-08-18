package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.LegalAgreement;
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

public class LegalAgreementValidator implements Validator<LegalAgreement> {

	@Override
	public ValidationResult<LegalAgreement> validate(RosettaPath path, LegalAgreement o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("agreementTerms", o.getAgreementTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("relatedAgreements", o.getRelatedAgreements()==null?0:o.getRelatedAgreements().size(), 0, 0),
				checkCardinality("umbrellaAgreement", o.getUmbrellaAgreement()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("LegalAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("LegalAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
