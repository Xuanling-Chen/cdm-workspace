package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodEnum;
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
@RosettaDataRule("CalculationPeriodFrequencyFpML_ird_57")
public class CalculationPeriodFrequencyFpMLIrd57 implements Validator<CalculationPeriodFrequency> {
	
	private static final String NAME = "CalculationPeriodFrequencyFpML_ird_57";
	private static final String DEFINITION = "if period = PeriodExtendedEnum -> M or period = PeriodExtendedEnum -> Y then rollConvention <> RollConventionEnum -> NONE or rollConvention <> RollConventionEnum -> SFE or rollConvention <> RollConventionEnum -> MON or rollConvention <> RollConventionEnum -> TUE or rollConvention <> RollConventionEnum -> WED or rollConvention <> RollConventionEnum -> THU or rollConvention <> RollConventionEnum -> FRI or rollConvention <> RollConventionEnum -> SAT or rollConvention <> RollConventionEnum -> SUN";
	
	
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
			return areEqual(MapperS.of(calculationPeriodFrequency).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodEnum.M), CardinalityOperator.All).or(areEqual(MapperS.of(calculationPeriodFrequency).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodEnum.Y), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CalculationPeriodFrequency calculationPeriodFrequency) {
		try {
			return notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.NONE), CardinalityOperator.Any).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.SFE), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.MON), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.TUE), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.WED), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.THU), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.FRI), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.SAT), CardinalityOperator.Any)).or(notEqual(MapperS.of(calculationPeriodFrequency).<RollConventionEnum>map("getRollConvention", _calculationPeriodFrequency -> _calculationPeriodFrequency.getRollConvention()), MapperS.of(RollConventionEnum.SUN), CardinalityOperator.Any));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
