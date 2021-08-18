package cdm.product.template.validation;

import cdm.product.template.CancelableProvision;
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

public class CancelableProvisionValidator implements Validator<CancelableProvision> {

	@Override
	public ValidationResult<CancelableProvision> validate(RosettaPath path, CancelableProvision o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("americanExercise", o.getAmericanExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("bermudaExercise", o.getBermudaExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("europeanExercise", o.getEuropeanExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("exerciseNotice", o.getExerciseNotice()!=null ? 1 : 0, 0, 1),
				checkCardinality("followUpConfirmation", o.getFollowUpConfirmation()!=null ? 1 : 0, 1, 1),
				checkCardinality("cancelableProvisionAdjustedDates", o.getCancelableProvisionAdjustedDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("finalCalculationPeriodDateAdjustment", o.getFinalCalculationPeriodDateAdjustment()==null?0:o.getFinalCalculationPeriodDateAdjustment().size(), 0, 0),
				checkCardinality("initialFee", o.getInitialFee()!=null ? 1 : 0, 0, 1),
				checkCardinality("callingParty", o.getCallingParty()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CancelableProvision", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CancelableProvision", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
