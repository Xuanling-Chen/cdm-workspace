package cdm.product.template.validation.datarule;

import cdm.product.template.MultipleExercise;
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
@RosettaDataRule("MultipleExerciseMinimumNumberOfOptions")
public class MultipleExerciseMinimumNumberOfOptions implements Validator<MultipleExercise> {
	
	private static final String NAME = "MultipleExerciseMinimumNumberOfOptions";
	private static final String DEFINITION = "if minimumNumberOfOptions exists then minimumNumberOfOptions >= 0";
	
	
	@Override
	public ValidationResult<MultipleExercise> validate(RosettaPath path, MultipleExercise multipleExercise) {
		ComparisonResult result = executeDataRule(multipleExercise);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MultipleExercise", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleExercise", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MultipleExercise multipleExercise) {
		if (ruleIsApplicable(multipleExercise).get()) {
			return evaluateThenExpression(multipleExercise);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MultipleExercise multipleExercise) {
		try {
			return exists(MapperS.of(multipleExercise).<Integer>map("getMinimumNumberOfOptions", _partialExercise -> _partialExercise.getMinimumNumberOfOptions()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MultipleExercise multipleExercise) {
		try {
			return greaterThanEquals(MapperS.of(multipleExercise).<Integer>map("getMinimumNumberOfOptions", _partialExercise -> _partialExercise.getMinimumNumberOfOptions()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
