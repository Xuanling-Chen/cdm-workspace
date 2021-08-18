package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AppropriatedCollateralValuation;
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
@RosettaDataRule("AppropriatedCollateralValuationNotSpecified")
public class AppropriatedCollateralValuationNotSpecified implements Validator<AppropriatedCollateralValuation> {
	
	private static final String NAME = "AppropriatedCollateralValuationNotSpecified";
	private static final String DEFINITION = "if isSpecified = False then election is absent";
	
	
	@Override
	public ValidationResult<AppropriatedCollateralValuation> validate(RosettaPath path, AppropriatedCollateralValuation appropriatedCollateralValuation) {
		ComparisonResult result = executeDataRule(appropriatedCollateralValuation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AppropriatedCollateralValuation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AppropriatedCollateralValuation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AppropriatedCollateralValuation appropriatedCollateralValuation) {
		if (ruleIsApplicable(appropriatedCollateralValuation).get()) {
			return evaluateThenExpression(appropriatedCollateralValuation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AppropriatedCollateralValuation appropriatedCollateralValuation) {
		try {
			return areEqual(MapperS.of(appropriatedCollateralValuation).<Boolean>map("getIsSpecified", _appropriatedCollateralValuation -> _appropriatedCollateralValuation.getIsSpecified()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AppropriatedCollateralValuation appropriatedCollateralValuation) {
		try {
			return notExists(MapperS.of(appropriatedCollateralValuation).<String>map("getElection", _appropriatedCollateralValuation -> _appropriatedCollateralValuation.getElection()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
