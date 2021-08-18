package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PrincipalExchange;
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

public class PrincipalExchangeValidator implements Validator<PrincipalExchange> {

	@Override
	public ValidationResult<PrincipalExchange> validate(RosettaPath path, PrincipalExchange o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedPrincipalExchangeDate", o.getUnadjustedPrincipalExchangeDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedPrincipalExchangeDate", o.getAdjustedPrincipalExchangeDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("principalExchangeAmount", o.getPrincipalExchangeAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("discountFactor", o.getDiscountFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("presentValuePrincipalExchangeAmount", o.getPresentValuePrincipalExchangeAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchange", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PrincipalExchange", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
