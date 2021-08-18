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
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("WeightedAveragingObservationPositiveWeight")
public class WeightedAveragingObservationPositiveWeight implements Validator<WeightedAveragingObservation> {
	
	private static final String NAME = "WeightedAveragingObservationPositiveWeight";
	private static final String DEFINITION = "if weight exists then weight >= 0.0";
	
	
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
			return exists(MapperS.of(weightedAveragingObservation).<BigDecimal>map("getWeight", _weightedAveragingObservation -> _weightedAveragingObservation.getWeight()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(WeightedAveragingObservation weightedAveragingObservation) {
		try {
			return greaterThanEquals(MapperS.of(weightedAveragingObservation).<BigDecimal>map("getWeight", _weightedAveragingObservation -> _weightedAveragingObservation.getWeight()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
