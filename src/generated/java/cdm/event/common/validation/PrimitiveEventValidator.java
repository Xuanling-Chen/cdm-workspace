package cdm.event.common.validation;

import cdm.event.common.PrimitiveEvent;
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

public class PrimitiveEventValidator implements Validator<PrimitiveEvent> {

	@Override
	public ValidationResult<PrimitiveEvent> validate(RosettaPath path, PrimitiveEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("execution", o.getExecution()!=null ? 1 : 0, 0, 1),
				checkCardinality("contractFormation", o.getContractFormation()!=null ? 1 : 0, 0, 1),
				checkCardinality("split", o.getSplit()!=null ? 1 : 0, 0, 1),
				checkCardinality("quantityChange", o.getQuantityChange()!=null ? 1 : 0, 0, 1),
				checkCardinality("reset", o.getReset()!=null ? 1 : 0, 0, 1),
				checkCardinality("termsChange", o.getTermsChange()!=null ? 1 : 0, 0, 1),
				checkCardinality("transfer", o.getTransfer()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PrimitiveEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PrimitiveEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
