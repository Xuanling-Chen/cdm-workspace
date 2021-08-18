package cdm.base.math.validation.datarule;

import cdm.base.math.NonNegativeStep;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("NonNegativeStepStepValue")
public class NonNegativeStepStepValue implements Validator<NonNegativeStep> {
	
	private static final String NAME = "NonNegativeStepStepValue";
	private static final String DEFINITION = "if NonNegativeStep exists then stepValue >= 0.0";
	
	
	@Override
	public ValidationResult<NonNegativeStep> validate(RosettaPath path, NonNegativeStep nonNegativeStep) {
		ComparisonResult result = executeDataRule(nonNegativeStep);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "NonNegativeStep", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeStep", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(NonNegativeStep nonNegativeStep) {
		if (ruleIsApplicable(nonNegativeStep).get()) {
			return evaluateThenExpression(nonNegativeStep);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(NonNegativeStep nonNegativeStep) {
		try {
			return exists(MapperS.of(nonNegativeStep));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(NonNegativeStep nonNegativeStep) {
		try {
			return greaterThanEquals(MapperS.of(nonNegativeStep).<BigDecimal>map("getStepValue", _nonNegativeStep -> _nonNegativeStep.getStepValue()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
