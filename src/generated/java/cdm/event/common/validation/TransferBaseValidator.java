package cdm.event.common.validation;

import cdm.event.common.TransferBase;
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

public class TransferBaseValidator implements Validator<TransferBase> {

	@Override
	public ValidationResult<TransferBase> validate(RosettaPath path, TransferBase o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", o.getIdentifier()!=null ? 1 : 0, 0, 1),
				checkCardinality("transferCalculation", o.getTransferCalculation()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TransferBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TransferBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
