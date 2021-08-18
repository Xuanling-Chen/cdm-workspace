package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.ResetFrequency;
import cdm.product.common.schedule.WeeklyRollConventionEnum;
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
@RosettaDataRule("ResetDatesWeeklyPeriod")
public class ResetDatesWeeklyPeriod implements Validator<ResetDates> {
	
	private static final String NAME = "ResetDatesWeeklyPeriod";
	private static final String DEFINITION = "if resetFrequency -> period = PeriodExtendedEnum -> W then resetFrequency -> weeklyRollConvention exists";
	
	
	@Override
	public ValidationResult<ResetDates> validate(RosettaPath path, ResetDates resetDates) {
		ComparisonResult result = executeDataRule(resetDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ResetDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ResetDates resetDates) {
		if (ruleIsApplicable(resetDates).get()) {
			return evaluateThenExpression(resetDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ResetDates resetDates) {
		try {
			return areEqual(MapperS.of(resetDates).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodEnum.W), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ResetDates resetDates) {
		try {
			return exists(MapperS.of(resetDates).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).<WeeklyRollConventionEnum>map("getWeeklyRollConvention", _resetFrequency -> _resetFrequency.getWeeklyRollConvention()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
