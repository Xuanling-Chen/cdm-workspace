package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Security;
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

public class SecurityValidator implements Validator<Security> {

	@Override
	public ValidationResult<Security> validate(RosettaPath path, Security o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityType", o.getSecurityType()!=null ? 1 : 0, 1, 1),
				checkCardinality("debtType", o.getDebtType()!=null ? 1 : 0, 0, 1),
				checkCardinality("equityType", o.getEquityType()!=null ? 1 : 0, 0, 1),
				checkCardinality("fundType", o.getFundType()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Security", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Security", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
