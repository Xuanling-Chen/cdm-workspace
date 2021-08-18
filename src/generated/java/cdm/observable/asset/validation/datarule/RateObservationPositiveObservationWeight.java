package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.RateObservation;
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
@RosettaDataRule("RateObservationPositiveObservationWeight")
public class RateObservationPositiveObservationWeight implements Validator<RateObservation> {
	
	private static final String NAME = "RateObservationPositiveObservationWeight";
	private static final String DEFINITION = "if observationWeight exists then observationWeight >= 0";
	
	
	@Override
	public ValidationResult<RateObservation> validate(RosettaPath path, RateObservation rateObservation) {
		ComparisonResult result = executeDataRule(rateObservation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "RateObservation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RateObservation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(RateObservation rateObservation) {
		if (ruleIsApplicable(rateObservation).get()) {
			return evaluateThenExpression(rateObservation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(RateObservation rateObservation) {
		try {
			return exists(MapperS.of(rateObservation).<Integer>map("getObservationWeight", _rateObservation -> _rateObservation.getObservationWeight()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(RateObservation rateObservation) {
		try {
			return greaterThanEquals(MapperS.of(rateObservation).<Integer>map("getObservationWeight", _rateObservation -> _rateObservation.getObservationWeight()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
