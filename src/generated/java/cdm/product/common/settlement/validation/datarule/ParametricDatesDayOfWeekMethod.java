package cdm.product.common.settlement.validation.datarule;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.product.common.settlement.ParametricDates;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ParametricDatesDayOfWeekMethod")
public class ParametricDatesDayOfWeekMethod implements Validator<ParametricDates> {
	
	private static final String NAME = "ParametricDatesDayOfWeekMethod";
	private static final String DEFINITION = "if dayOfWeek exists then dayFrequency exists";
	
	
	@Override
	public ValidationResult<ParametricDates> validate(RosettaPath path, ParametricDates parametricDates) {
		ComparisonResult result = executeDataRule(parametricDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ParametricDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ParametricDates parametricDates) {
		if (ruleIsApplicable(parametricDates).get()) {
			return evaluateThenExpression(parametricDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ParametricDates parametricDates) {
		try {
			return exists(MapperS.of(parametricDates).<DayOfWeekEnum>mapC("getDayOfWeek", _parametricDates -> _parametricDates.getDayOfWeek()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ParametricDates parametricDates) {
		try {
			return exists(MapperS.of(parametricDates).<BigDecimal>map("getDayFrequency", _parametricDates -> _parametricDates.getDayFrequency()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
