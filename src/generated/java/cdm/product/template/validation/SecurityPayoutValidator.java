package cdm.product.template.validation;

import cdm.product.template.SecurityPayout;
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

public class SecurityPayoutValidator implements Validator<SecurityPayout> {

	@Override
	public ValidationResult<SecurityPayout> validate(RosettaPath path, SecurityPayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityLeg", o.getSecurityLeg()==null?0:o.getSecurityLeg().size(), 1, 0),
				checkCardinality("initialMargin", o.getInitialMargin()!=null ? 1 : 0, 0, 1),
				checkCardinality("repoDuration", o.getRepoDuration()!=null ? 1 : 0, 0, 1),
				checkCardinality("securityValuation", o.getSecurityValuation()==null?0:o.getSecurityValuation().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
