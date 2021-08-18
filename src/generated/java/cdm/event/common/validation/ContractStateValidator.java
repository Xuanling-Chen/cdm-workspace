package cdm.event.common.validation;

import cdm.event.common.ContractState;
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

public class ContractStateValidator implements Validator<ContractState> {

	@Override
	public ValidationResult<ContractState> validate(RosettaPath path, ContractState o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("trade", o.getTrade()!=null ? 1 : 0, 1, 1),
				checkCardinality("updatedTrade", o.getUpdatedTrade()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ContractState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ContractState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
