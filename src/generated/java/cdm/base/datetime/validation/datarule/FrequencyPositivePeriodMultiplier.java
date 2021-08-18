package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.Frequency;
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
@RosettaDataRule("FrequencyPositivePeriodMultiplier")
public class FrequencyPositivePeriodMultiplier implements Validator<Frequency> {
	
	private static final String NAME = "FrequencyPositivePeriodMultiplier";
	private static final String DEFINITION = "if Frequency exists then periodMultiplier >= 0";
	
	
	@Override
	public ValidationResult<Frequency> validate(RosettaPath path, Frequency frequency) {
		ComparisonResult result = executeDataRule(frequency);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Frequency", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Frequency", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Frequency frequency) {
		if (ruleIsApplicable(frequency).get()) {
			return evaluateThenExpression(frequency);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Frequency frequency) {
		try {
			return exists(MapperS.of(frequency));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Frequency frequency) {
		try {
			return greaterThanEquals(MapperS.of(frequency).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
