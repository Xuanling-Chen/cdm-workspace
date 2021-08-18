package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ExecutionLanguage;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ExecutionLanguagenumberOfOriginals")
public class ExecutionLanguagenumberOfOriginals implements Validator<ExecutionLanguage> {
	
	private static final String NAME = "ExecutionLanguagenumberOfOriginals";
	private static final String DEFINITION = "if standardLanguage = False then numberOfOriginals is absent";
	
	
	@Override
	public ValidationResult<ExecutionLanguage> validate(RosettaPath path, ExecutionLanguage executionLanguage) {
		ComparisonResult result = executeDataRule(executionLanguage);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExecutionLanguage", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLanguage", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExecutionLanguage executionLanguage) {
		if (ruleIsApplicable(executionLanguage).get()) {
			return evaluateThenExpression(executionLanguage);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExecutionLanguage executionLanguage) {
		try {
			return areEqual(MapperS.of(executionLanguage).<Boolean>map("getStandardLanguage", _executionLanguage -> _executionLanguage.getStandardLanguage()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExecutionLanguage executionLanguage) {
		try {
			return notExists(MapperS.of(executionLanguage).<String>map("getNumberOfOriginals", _executionLanguage -> _executionLanguage.getNumberOfOriginals()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
