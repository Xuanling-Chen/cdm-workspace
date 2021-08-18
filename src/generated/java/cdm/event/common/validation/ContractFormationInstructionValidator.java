package cdm.event.common.validation;

import cdm.event.common.ContractFormationInstruction;
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

public class ContractFormationInstructionValidator implements Validator<ContractFormationInstruction> {

	@Override
	public ValidationResult<ContractFormationInstruction> validate(RosettaPath path, ContractFormationInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("execution", o.getExecution()!=null ? 1 : 0, 1, 1),
				checkCardinality("legalAgreement", o.getLegalAgreement()==null?0:o.getLegalAgreement().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ContractFormationInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ContractFormationInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
