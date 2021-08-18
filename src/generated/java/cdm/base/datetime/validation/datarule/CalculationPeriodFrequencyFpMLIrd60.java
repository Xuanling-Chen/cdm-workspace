package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.datetime.RollConventionEnum;
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
@RosettaDataRule("CalculationPeriodFrequencyFpML_ird_60")
public class CalculationPeriodFrequencyFpMLIrd60 implements Validator<CalculationPeriodFrequency> {
	
	private static final String NAME = "CalculationPeriodFrequencyFpML_ird_60";
	private static final String DEFINITION = "if period = PeriodExtendedEnum -> T then rollConvention = RollConventionEnum -> NONE";
	
	
	@Override
	public ValidationResult<CalculationPeriodFrequency> validate(RosettaPath path, CalculationPeriodFrequency calculationPeriodFrequency) {
		ComparisonResult result = executeDataRule(calculationPeriodFrequency);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CalculationPeriodFrequency", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodFrequency", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CalculationPeriodFrequency calculationPeriodFrequency) {
		if (ruleIsApplicable(calculationPeriodFrequency).get()) {
			return evaluateThenExpression(calculationPeriodFrequency);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CalculationPeriodFrequency calculationPeriodFrequency) {
		try {
			return areEqual(MapperS.of(calculationPeriodFrequency).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CalculationPeriodFrequency calculationPeriodFrequency) {
		try {
			return areEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.NONE), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
