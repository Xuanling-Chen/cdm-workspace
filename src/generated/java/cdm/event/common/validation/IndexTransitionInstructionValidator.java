package cdm.event.common.validation;

import cdm.event.common.IndexTransitionInstruction;
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

public class IndexTransitionInstructionValidator implements Validator<IndexTransitionInstruction> {

	@Override
	public ValidationResult<IndexTransitionInstruction> validate(RosettaPath path, IndexTransitionInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("priceQuantity", o.getPriceQuantity()==null?0:o.getPriceQuantity().size(), 1, 0),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("cashTransfer", o.getCashTransfer()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IndexTransitionInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IndexTransitionInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
