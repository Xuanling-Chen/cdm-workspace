package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.BespokeCalculationDate;
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
@RosettaDataRule("BespokeCalculationDateCalculationDateImTerms")
public class BespokeCalculationDateCalculationDateImTerms implements Validator<BespokeCalculationDate> {
	
	private static final String NAME = "BespokeCalculationDateCalculationDateImTerms";
	private static final String DEFINITION = "if isApplicable = False then calculationDateImTerms is absent";
	
	
	@Override
	public ValidationResult<BespokeCalculationDate> validate(RosettaPath path, BespokeCalculationDate bespokeCalculationDate) {
		ComparisonResult result = executeDataRule(bespokeCalculationDate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "BespokeCalculationDate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationDate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(BespokeCalculationDate bespokeCalculationDate) {
		if (ruleIsApplicable(bespokeCalculationDate).get()) {
			return evaluateThenExpression(bespokeCalculationDate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(BespokeCalculationDate bespokeCalculationDate) {
		try {
			return areEqual(MapperS.of(bespokeCalculationDate).<Boolean>map("getIsApplicable", _bespokeCalculationDate -> _bespokeCalculationDate.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(BespokeCalculationDate bespokeCalculationDate) {
		try {
			return notExists(MapperS.of(bespokeCalculationDate).<String>map("getCalculationDateImTerms", _bespokeCalculationDate -> _bespokeCalculationDate.getCalculationDateImTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
