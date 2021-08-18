package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType;
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

public class QuasiGovernmentIssuerTypeValidator implements Validator<QuasiGovernmentIssuerType> {

	@Override
	public ValidationResult<QuasiGovernmentIssuerType> validate(RosettaPath path, QuasiGovernmentIssuerType o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("sovereignEntity", o.getSovereignEntity()!=null ? 1 : 0, 1, 1),
				checkCardinality("sovereignRecourse", o.getSovereignRecourse()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("QuasiGovernmentIssuerType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("QuasiGovernmentIssuerType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
