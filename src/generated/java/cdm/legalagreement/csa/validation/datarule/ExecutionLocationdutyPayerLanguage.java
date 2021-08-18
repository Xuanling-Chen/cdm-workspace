package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ExecutionLocation;
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
@RosettaDataRule("ExecutionLocationdutyPayerLanguage")
public class ExecutionLocationdutyPayerLanguage implements Validator<ExecutionLocation> {
	
	private static final String NAME = "ExecutionLocationdutyPayerLanguage";
	private static final String DEFINITION = "if dutyPayer = \"Specify\" then dutyPayerLanguage exists";
	
	
	@Override
	public ValidationResult<ExecutionLocation> validate(RosettaPath path, ExecutionLocation executionLocation) {
		ComparisonResult result = executeDataRule(executionLocation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExecutionLocation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLocation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExecutionLocation executionLocation) {
		if (ruleIsApplicable(executionLocation).get()) {
			return evaluateThenExpression(executionLocation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExecutionLocation executionLocation) {
		try {
			return areEqual(MapperS.of(executionLocation).<String>map("getDutyPayer", _executionLocation -> _executionLocation.getDutyPayer()), MapperS.of("Specify"), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExecutionLocation executionLocation) {
		try {
			return exists(MapperS.of(executionLocation).<String>map("getDutyPayerLanguage", _executionLocation -> _executionLocation.getDutyPayerLanguage()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
