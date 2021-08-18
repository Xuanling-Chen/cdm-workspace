package cdm.event.common.validation;

import cdm.event.common.ReallocationInstruction;
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

public class ReallocationInstructionValidator implements Validator<ReallocationInstruction> {

	@Override
	public ValidationResult<ReallocationInstruction> validate(RosettaPath path, ReallocationInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("decrease", o.getDecrease()==null?0:o.getDecrease().size(), 1, 0),
				checkCardinality("increase", o.getIncrease()==null?0:o.getIncrease().size(), 0, 0),
				checkCardinality("breakdowns", o.getBreakdowns()==null?0:o.getBreakdowns().size(), 0, 0),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReallocationInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReallocationInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
