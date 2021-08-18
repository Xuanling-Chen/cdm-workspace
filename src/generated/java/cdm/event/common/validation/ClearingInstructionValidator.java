package cdm.event.common.validation;

import cdm.event.common.ClearingInstruction;
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

public class ClearingInstructionValidator implements Validator<ClearingInstruction> {

	@Override
	public ValidationResult<ClearingInstruction> validate(RosettaPath path, ClearingInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("alphaContract", o.getAlphaContract()!=null ? 1 : 0, 1, 1),
				checkCardinality("clearingParty", o.getClearingParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("party1", o.getParty1()!=null ? 1 : 0, 1, 1),
				checkCardinality("party2", o.getParty2()!=null ? 1 : 0, 1, 1),
				checkCardinality("clearerParty1", o.getClearerParty1()!=null ? 1 : 0, 0, 1),
				checkCardinality("clearerParty2", o.getClearerParty2()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ClearingInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ClearingInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
