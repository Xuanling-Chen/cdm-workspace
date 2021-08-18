package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.PeriodExtendedEnum;
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
@RosettaDataRule("ResetFrequencyFpML_ird_49")
public class ResetFrequencyFpMLIrd49 implements Validator<ResetFrequency> {
	
	private static final String NAME = "ResetFrequencyFpML_ird_49";
	private static final String DEFINITION = "if weeklyRollConvention exists then period = PeriodExtendedEnum -> W";
	
	
	@Override
	public ValidationResult<ResetFrequency> validate(RosettaPath path, ResetFrequency resetFrequency) {
		ComparisonResult result = executeDataRule(resetFrequency);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ResetFrequency", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetFrequency", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ResetFrequency resetFrequency) {
		if (ruleIsApplicable(resetFrequency).get()) {
			return evaluateThenExpression(resetFrequency);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ResetFrequency resetFrequency) {
		try {
			return exists(MapperS.of(resetFrequency).<WeeklyRollConventionEnum>map("getWeeklyRollConvention", _resetFrequency -> _resetFrequency.getWeeklyRollConvention()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ResetFrequency resetFrequency) {
		try {
			return areEqual(MapperS.of(resetFrequency).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodEnum.W), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
