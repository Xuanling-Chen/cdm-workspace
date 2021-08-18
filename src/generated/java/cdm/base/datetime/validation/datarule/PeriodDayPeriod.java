package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
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
@RosettaDataRule("PeriodDayPeriod")
public class PeriodDayPeriod implements Validator<Period> {
	
	private static final String NAME = "PeriodDayPeriod";
	private static final String DEFINITION = "if periodMultiplier = 0 then period = PeriodEnum -> D";
	
	
	@Override
	public ValidationResult<Period> validate(RosettaPath path, Period period) {
		ComparisonResult result = executeDataRule(period);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Period", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Period", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Period period) {
		if (ruleIsApplicable(period).get()) {
			return evaluateThenExpression(period);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Period period) {
		try {
			return areEqual(MapperS.of(period).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Period period) {
		try {
			return areEqual(MapperS.of(period).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod()), MapperS.of(PeriodEnum.D), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
