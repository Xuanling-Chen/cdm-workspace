package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PrincipalExchanges;
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

public class PrincipalExchangesValidator implements Validator<PrincipalExchanges> {

	@Override
	public ValidationResult<PrincipalExchanges> validate(RosettaPath path, PrincipalExchanges o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialExchange", o.getInitialExchange()!=null ? 1 : 0, 1, 1),
				checkCardinality("finalExchange", o.getFinalExchange()!=null ? 1 : 0, 1, 1),
				checkCardinality("intermediateExchange", o.getIntermediateExchange()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PrincipalExchanges", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PrincipalExchanges", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
