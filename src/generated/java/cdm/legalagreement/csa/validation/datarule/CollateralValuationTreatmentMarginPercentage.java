package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.CollateralValuationTreatment;
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
@RosettaDataRule("CollateralValuationTreatmentMarginPercentage")
public class CollateralValuationTreatmentMarginPercentage implements Validator<CollateralValuationTreatment> {
	
	private static final String NAME = "CollateralValuationTreatmentMarginPercentage";
	private static final String DEFINITION = "if marginPercentage exists then marginPercentage >= 1";
	
	
	@Override
	public ValidationResult<CollateralValuationTreatment> validate(RosettaPath path, CollateralValuationTreatment collateralValuationTreatment) {
		ComparisonResult result = executeDataRule(collateralValuationTreatment);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CollateralValuationTreatment", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuationTreatment", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CollateralValuationTreatment collateralValuationTreatment) {
		if (ruleIsApplicable(collateralValuationTreatment).get()) {
			return evaluateThenExpression(collateralValuationTreatment);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CollateralValuationTreatment collateralValuationTreatment) {
		try {
			return exists(MapperS.of(collateralValuationTreatment).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CollateralValuationTreatment collateralValuationTreatment) {
		try {
			return greaterThanEquals(MapperS.of(collateralValuationTreatment).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
