package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.WeightedAveragingObservation;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("WeightedAveragingObservationPositiveObservationNumber")
public class WeightedAveragingObservationPositiveObservationNumber implements Validator<WeightedAveragingObservation> {
	
	private static final String NAME = "WeightedAveragingObservationPositiveObservationNumber";
	private static final String DEFINITION = "if observationNumber exists then observationNumber >= 0";
	
	
	@Override
	public ValidationResult<WeightedAveragingObservation> validate(RosettaPath path, WeightedAveragingObservation weightedAveragingObservation) {
		ComparisonResult result = executeDataRule(weightedAveragingObservation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "WeightedAveragingObservation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WeightedAveragingObservation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(WeightedAveragingObservation weightedAveragingObservation) {
		if (ruleIsApplicable(weightedAveragingObservation).get()) {
			return evaluateThenExpression(weightedAveragingObservation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(WeightedAveragingObservation weightedAveragingObservation) {
		try {
			return exists(MapperS.of(weightedAveragingObservation).<Integer>map("getObservationNumber", _weightedAveragingObservation -> _weightedAveragingObservation.getObservationNumber()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(WeightedAveragingObservation weightedAveragingObservation) {
		try {
			return greaterThanEquals(MapperS.of(weightedAveragingObservation).<Integer>map("getObservationNumber", _weightedAveragingObservation -> _weightedAveragingObservation.getObservationNumber()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
