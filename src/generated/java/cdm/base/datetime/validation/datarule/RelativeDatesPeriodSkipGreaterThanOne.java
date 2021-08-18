package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.RelativeDates;
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
@RosettaDataRule("RelativeDatesPeriodSkipGreaterThanOne")
public class RelativeDatesPeriodSkipGreaterThanOne implements Validator<RelativeDates> {
	
	private static final String NAME = "RelativeDatesPeriodSkipGreaterThanOne";
	private static final String DEFINITION = "if periodSkip exists then periodSkip > 1";
	
	
	@Override
	public ValidationResult<RelativeDates> validate(RosettaPath path, RelativeDates relativeDates) {
		ComparisonResult result = executeDataRule(relativeDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "RelativeDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RelativeDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(RelativeDates relativeDates) {
		if (ruleIsApplicable(relativeDates).get()) {
			return evaluateThenExpression(relativeDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(RelativeDates relativeDates) {
		try {
			return exists(MapperS.of(relativeDates).<Integer>map("getPeriodSkip", _relativeDates -> _relativeDates.getPeriodSkip()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(RelativeDates relativeDates) {
		try {
			return greaterThan(MapperS.of(relativeDates).<Integer>map("getPeriodSkip", _relativeDates -> _relativeDates.getPeriodSkip()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
