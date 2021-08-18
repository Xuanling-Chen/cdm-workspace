package cdm.product.asset.validation;

import cdm.product.asset.ReferenceInformation;
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

public class ReferenceInformationValidator implements Validator<ReferenceInformation> {

	@Override
	public ValidationResult<ReferenceInformation> validate(RosettaPath path, ReferenceInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceEntity", o.getReferenceEntity()!=null ? 1 : 0, 1, 1),
				checkCardinality("referenceObligation", o.getReferenceObligation()==null?0:o.getReferenceObligation().size(), 0, 0),
				checkCardinality("noReferenceObligation", o.getNoReferenceObligation()!=null ? 1 : 0, 0, 1),
				checkCardinality("unknownReferenceObligation", o.getUnknownReferenceObligation()!=null ? 1 : 0, 0, 1),
				checkCardinality("allGuarantees", o.getAllGuarantees()!=null ? 1 : 0, 0, 1),
				checkCardinality("referencePrice", o.getReferencePrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("referencePolicy", o.getReferencePolicy()!=null ? 1 : 0, 0, 1),
				checkCardinality("securedList", o.getSecuredList()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
