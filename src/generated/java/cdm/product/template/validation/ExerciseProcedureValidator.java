package cdm.product.template.validation;

import cdm.product.template.ExerciseProcedure;
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

public class ExerciseProcedureValidator implements Validator<ExerciseProcedure> {

	@Override
	public ValidationResult<ExerciseProcedure> validate(RosettaPath path, ExerciseProcedure o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("manualExercise", o.getManualExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("automaticExercise", o.getAutomaticExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("followUpConfirmation", o.getFollowUpConfirmation()!=null ? 1 : 0, 1, 1),
				checkCardinality("limitedRightToConfirm", o.getLimitedRightToConfirm()!=null ? 1 : 0, 0, 1),
				checkCardinality("splitTicket", o.getSplitTicket()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExerciseProcedure", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExerciseProcedure", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
