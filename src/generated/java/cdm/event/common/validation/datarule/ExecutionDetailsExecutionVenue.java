package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.LegalEntity;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionTypeEnum;
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
@RosettaDataRule("ExecutionDetailsExecutionVenue")
public class ExecutionDetailsExecutionVenue implements Validator<ExecutionDetails> {
	
	private static final String NAME = "ExecutionDetailsExecutionVenue";
	private static final String DEFINITION = "if executionType = ExecutionTypeEnum -> Electronic then executionVenue exists";
	
	
	@Override
	public ValidationResult<ExecutionDetails> validate(RosettaPath path, ExecutionDetails executionDetails) {
		ComparisonResult result = executeDataRule(executionDetails);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExecutionDetails", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionDetails", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExecutionDetails executionDetails) {
		if (ruleIsApplicable(executionDetails).get()) {
			return evaluateThenExpression(executionDetails);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExecutionDetails executionDetails) {
		try {
			return areEqual(MapperS.of(executionDetails).<ExecutionTypeEnum>map("getExecutionType", _executionDetails -> _executionDetails.getExecutionType()), MapperS.of(ExecutionTypeEnum.ELECTRONIC), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExecutionDetails executionDetails) {
		try {
			return exists(MapperS.of(executionDetails).<LegalEntity>map("getExecutionVenue", _executionDetails -> _executionDetails.getExecutionVenue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
