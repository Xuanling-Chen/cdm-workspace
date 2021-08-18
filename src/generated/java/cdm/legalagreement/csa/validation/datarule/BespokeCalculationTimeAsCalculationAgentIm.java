package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.BespokeCalculationTime;
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
@RosettaDataRule("BespokeCalculationTimeAsCalculationAgentIm")
public class BespokeCalculationTimeAsCalculationAgentIm implements Validator<BespokeCalculationTime> {
	
	private static final String NAME = "BespokeCalculationTimeAsCalculationAgentIm";
	private static final String DEFINITION = "if asCalculationAgent = True then bespokeCalculationTimeTerms is absent";
	
	
	@Override
	public ValidationResult<BespokeCalculationTime> validate(RosettaPath path, BespokeCalculationTime bespokeCalculationTime) {
		ComparisonResult result = executeDataRule(bespokeCalculationTime);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "BespokeCalculationTime", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationTime", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(BespokeCalculationTime bespokeCalculationTime) {
		if (ruleIsApplicable(bespokeCalculationTime).get()) {
			return evaluateThenExpression(bespokeCalculationTime);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(BespokeCalculationTime bespokeCalculationTime) {
		try {
			return areEqual(MapperS.of(bespokeCalculationTime).<Boolean>map("getAsCalculationAgent", _bespokeCalculationTime -> _bespokeCalculationTime.getAsCalculationAgent()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(BespokeCalculationTime bespokeCalculationTime) {
		try {
			return notExists(MapperS.of(bespokeCalculationTime).<String>map("getBespokeCalculationTimeTerms", _bespokeCalculationTime -> _bespokeCalculationTime.getBespokeCalculationTimeTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
