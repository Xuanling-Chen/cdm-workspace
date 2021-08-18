package cdm.event.common.validation;

import cdm.event.common.TransferInstruction;
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

public class TransferInstructionValidator implements Validator<TransferInstruction> {

	@Override
	public ValidationResult<TransferInstruction> validate(RosettaPath path, TransferInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("payout", o.getPayout()!=null ? 1 : 0, 1, 1),
				checkCardinality("resets", o.getResets()==null?0:o.getResets().size(), 0, 0),
				checkCardinality("payerReceiver", o.getPayerReceiver()!=null ? 1 : 0, 0, 1),
				checkCardinality("quantity", o.getQuantity()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TransferInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TransferInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
