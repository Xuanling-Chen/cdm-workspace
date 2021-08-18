package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.CollateralAccessBreach;
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
@RosettaDataRule("CollateralAccessBreachCabEndDateTerms")
public class CollateralAccessBreachCabEndDateTerms implements Validator<CollateralAccessBreach> {
	
	private static final String NAME = "CollateralAccessBreachCabEndDateTerms";
	private static final String DEFINITION = "if cabEndDateElection = True then cabEndDateTerms is absent";
	
	
	@Override
	public ValidationResult<CollateralAccessBreach> validate(RosettaPath path, CollateralAccessBreach collateralAccessBreach) {
		ComparisonResult result = executeDataRule(collateralAccessBreach);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CollateralAccessBreach", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralAccessBreach", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CollateralAccessBreach collateralAccessBreach) {
		if (ruleIsApplicable(collateralAccessBreach).get()) {
			return evaluateThenExpression(collateralAccessBreach);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CollateralAccessBreach collateralAccessBreach) {
		try {
			return areEqual(MapperS.of(collateralAccessBreach).<Boolean>map("getCabEndDateElection", _collateralAccessBreach -> _collateralAccessBreach.getCabEndDateElection()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CollateralAccessBreach collateralAccessBreach) {
		try {
			return notExists(MapperS.of(collateralAccessBreach).<String>map("getCabEndDateTerms", _collateralAccessBreach -> _collateralAccessBreach.getCabEndDateTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
