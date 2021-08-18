package cdm.product.template.validation;

import cdm.product.template.OptionalEarlyTermination;
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

public class OptionalEarlyTerminationValidator implements Validator<OptionalEarlyTermination> {

	@Override
	public ValidationResult<OptionalEarlyTermination> validate(RosettaPath path, OptionalEarlyTermination o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("singlePartyOption", o.getSinglePartyOption()!=null ? 1 : 0, 0, 1),
				checkCardinality("americanExercise", o.getAmericanExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("bermudaExercise", o.getBermudaExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("europeanExercise", o.getEuropeanExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("exerciseNotice", o.getExerciseNotice()==null?0:o.getExerciseNotice().size(), 0, 0),
				checkCardinality("followUpConfirmation", o.getFollowUpConfirmation()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAgent", o.getCalculationAgent()!=null ? 1 : 0, 1, 1),
				checkCardinality("cashSettlement", o.getCashSettlement()!=null ? 1 : 0, 1, 1),
				checkCardinality("optionalEarlyTerminationAdjustedDates", o.getOptionalEarlyTerminationAdjustedDates()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OptionalEarlyTermination", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OptionalEarlyTermination", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
