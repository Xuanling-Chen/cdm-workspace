package cdm.event.common.validation;

import cdm.event.common.PostContractFormationState;
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

public class PostContractFormationStateValidator implements Validator<PostContractFormationState> {

	@Override
	public ValidationResult<PostContractFormationState> validate(RosettaPath path, PostContractFormationState o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditLimitInformation", o.getCreditLimitInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("tradeWarehouseWorkflow", o.getTradeWarehouseWorkflow()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PostContractFormationState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PostContractFormationState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
