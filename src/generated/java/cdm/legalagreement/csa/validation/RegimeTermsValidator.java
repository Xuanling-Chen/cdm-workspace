package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.RegimeTerms;
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

public class RegimeTermsValidator implements Validator<RegimeTerms> {

	@Override
	public ValidationResult<RegimeTerms> validate(RosettaPath path, RegimeTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 0, 1),
				checkCardinality("asSpecified", o.getAsSpecified()!=null ? 1 : 0, 0, 1),
				checkCardinality("simmException", o.getSimmException()!=null ? 1 : 0, 0, 1),
				checkCardinality("retrospectiveEffect", o.getRetrospectiveEffect()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RegimeTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RegimeTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
