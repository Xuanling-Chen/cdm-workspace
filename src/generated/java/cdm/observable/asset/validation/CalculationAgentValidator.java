package cdm.observable.asset.validation;

import cdm.observable.asset.CalculationAgent;
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

public class CalculationAgentValidator implements Validator<CalculationAgent> {

	@Override
	public ValidationResult<CalculationAgent> validate(RosettaPath path, CalculationAgent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAgentParty", o.getCalculationAgentParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAgentPartyEnum", o.getCalculationAgentPartyEnum()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAgentBusinessCenter", o.getCalculationAgentBusinessCenter()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CalculationAgent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CalculationAgent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
