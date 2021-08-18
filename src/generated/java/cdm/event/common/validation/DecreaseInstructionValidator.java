package cdm.event.common.validation;

import cdm.event.common.DecreaseInstruction;
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

public class DecreaseInstructionValidator implements Validator<DecreaseInstruction> {

	@Override
	public ValidationResult<DecreaseInstruction> validate(RosettaPath path, DecreaseInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeState", o.getTradeState()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradeLot", o.getTradeLot()==null?0:o.getTradeLot().size(), 1, 0),
				checkCardinality("fee", o.getFee()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DecreaseInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DecreaseInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
