package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ReturnAmount;
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
@RosettaDataRule("ReturnAmountCustomElection")
public class ReturnAmountCustomElection implements Validator<ReturnAmount> {
	
	private static final String NAME = "ReturnAmountCustomElection";
	private static final String DEFINITION = "if customElection exists then includesDefaultLanguage = False";
	
	
	@Override
	public ValidationResult<ReturnAmount> validate(RosettaPath path, ReturnAmount returnAmount) {
		ComparisonResult result = executeDataRule(returnAmount);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ReturnAmount", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnAmount", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ReturnAmount returnAmount) {
		if (ruleIsApplicable(returnAmount).get()) {
			return evaluateThenExpression(returnAmount);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ReturnAmount returnAmount) {
		try {
			return exists(MapperS.of(returnAmount).<String>map("getCustomElection", _returnAmount -> _returnAmount.getCustomElection()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ReturnAmount returnAmount) {
		try {
			return areEqual(MapperS.of(returnAmount).<Boolean>map("getIncludesDefaultLanguage", _returnAmount -> _returnAmount.getIncludesDefaultLanguage()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
