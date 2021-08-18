package cdm.product.asset.validation;

import cdm.product.asset.GeneralTerms;
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

public class GeneralTermsValidator implements Validator<GeneralTerms> {

	@Override
	public ValidationResult<GeneralTerms> validate(RosettaPath path, GeneralTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceInformation", o.getReferenceInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexReferenceInformation", o.getIndexReferenceInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("basketReferenceInformation", o.getBasketReferenceInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalTerm", o.getAdditionalTerm()==null?0:o.getAdditionalTerm().size(), 0, 0),
				checkCardinality("substitution", o.getSubstitution()!=null ? 1 : 0, 0, 1),
				checkCardinality("modifiedEquityDelivery", o.getModifiedEquityDelivery()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("GeneralTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("GeneralTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
