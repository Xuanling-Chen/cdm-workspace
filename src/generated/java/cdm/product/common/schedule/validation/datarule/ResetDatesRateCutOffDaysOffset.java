package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.Offset;
import cdm.product.common.schedule.ResetDates;
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
@RosettaDataRule("ResetDatesRateCutOffDaysOffset")
public class ResetDatesRateCutOffDaysOffset implements Validator<ResetDates> {
	
	private static final String NAME = "ResetDatesRateCutOffDaysOffset";
	private static final String DEFINITION = "if rateCutOffDaysOffset exists then rateCutOffDaysOffset -> periodMultiplier < 0";
	
	
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
			return exists(MapperS.of(resetDates).<Offset>map("getRateCutOffDaysOffset", _resetDates -> _resetDates.getRateCutOffDaysOffset()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ResetDates resetDates) {
		try {
			return lessThan(MapperS.of(resetDates).<Offset>map("getRateCutOffDaysOffset", _resetDates -> _resetDates.getRateCutOffDaysOffset()).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
