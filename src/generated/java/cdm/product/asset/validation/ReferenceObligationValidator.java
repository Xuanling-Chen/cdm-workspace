package cdm.product.asset.validation;

import cdm.product.asset.ReferenceObligation;
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

public class ReferenceObligationValidator implements Validator<ReferenceObligation> {

	@Override
	public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("security", o.getSecurity()!=null ? 1 : 0, 0, 1),
				checkCardinality("loan", o.getLoan()!=null ? 1 : 0, 0, 1),
				checkCardinality("primaryObligor", o.getPrimaryObligor()!=null ? 1 : 0, 0, 1),
				checkCardinality("primaryObligorReference", o.getPrimaryObligorReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("guarantor", o.getGuarantor()!=null ? 1 : 0, 0, 1),
				checkCardinality("guarantorReference", o.getGuarantorReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("standardReferenceObligation", o.getStandardReferenceObligation()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReferenceObligation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReferenceObligation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
