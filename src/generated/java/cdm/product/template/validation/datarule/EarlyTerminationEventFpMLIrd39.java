package cdm.product.template.validation.datarule;

import cdm.product.template.EarlyTerminationEvent;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EarlyTerminationEventFpML_ird_39")
public class EarlyTerminationEventFpMLIrd39 implements Validator<EarlyTerminationEvent> {
	
	private static final String NAME = "EarlyTerminationEventFpML_ird_39";
	private static final String DEFINITION = "if EarlyTerminationEvent exists then adjustedExerciseDate <= adjustedEarlyTerminationDate";
	
	
	@Override
	public ValidationResult<EarlyTerminationEvent> validate(RosettaPath path, EarlyTerminationEvent earlyTerminationEvent) {
		ComparisonResult result = executeDataRule(earlyTerminationEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EarlyTerminationEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EarlyTerminationEvent earlyTerminationEvent) {
		if (ruleIsApplicable(earlyTerminationEvent).get()) {
			return evaluateThenExpression(earlyTerminationEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EarlyTerminationEvent earlyTerminationEvent) {
		try {
			return exists(MapperS.of(earlyTerminationEvent));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EarlyTerminationEvent earlyTerminationEvent) {
		try {
			return lessThanEquals(MapperS.of(earlyTerminationEvent).<Date>map("getAdjustedExerciseDate", _earlyTerminationEvent -> _earlyTerminationEvent.getAdjustedExerciseDate()), MapperS.of(earlyTerminationEvent).<Date>map("getAdjustedEarlyTerminationDate", _earlyTerminationEvent -> _earlyTerminationEvent.getAdjustedEarlyTerminationDate()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
