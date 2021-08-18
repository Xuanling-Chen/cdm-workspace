package cdm.event.common.validation;

import cdm.event.common.StockSplitInstruction;
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

public class StockSplitInstructionValidator implements Validator<StockSplitInstruction> {

	@Override
	public ValidationResult<StockSplitInstruction> validate(RosettaPath path, StockSplitInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeState", o.getTradeState()!=null ? 1 : 0, 1, 1),
				checkCardinality("adjustmentRatio", o.getAdjustmentRatio()!=null ? 1 : 0, 1, 1),
				checkCardinality("date", o.getDate()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("StockSplitInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("StockSplitInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
