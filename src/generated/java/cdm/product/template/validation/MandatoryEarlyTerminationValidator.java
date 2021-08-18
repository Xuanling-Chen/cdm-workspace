package cdm.product.template.validation;

import cdm.product.template.MandatoryEarlyTermination;
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

public class MandatoryEarlyTerminationValidator implements Validator<MandatoryEarlyTermination> {

	@Override
	public ValidationResult<MandatoryEarlyTermination> validate(RosettaPath path, MandatoryEarlyTermination o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("mandatoryEarlyTerminationDate", o.getMandatoryEarlyTerminationDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("calculationAgent", o.getCalculationAgent()!=null ? 1 : 0, 1, 1),
				checkCardinality("cashSettlement", o.getCashSettlement()!=null ? 1 : 0, 1, 1),
				checkCardinality("mandatoryEarlyTerminationAdjustedDates", o.getMandatoryEarlyTerminationAdjustedDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MandatoryEarlyTermination", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MandatoryEarlyTermination", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
