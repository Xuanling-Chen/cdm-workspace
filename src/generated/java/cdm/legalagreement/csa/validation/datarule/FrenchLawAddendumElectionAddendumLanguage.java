package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.FrenchLawAddendumElection;
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
@RosettaDataRule("FrenchLawAddendumElectionAddendumLanguage")
public class FrenchLawAddendumElectionAddendumLanguage implements Validator<FrenchLawAddendumElection> {
	
	private static final String NAME = "FrenchLawAddendumElectionAddendumLanguage";
	private static final String DEFINITION = "if isApplicable = True then addendumLanguage exists else if isApplicable = False then addendumLanguage is absent";
	
	
	@Override
	public ValidationResult<FrenchLawAddendumElection> validate(RosettaPath path, FrenchLawAddendumElection frenchLawAddendumElection) {
		ComparisonResult result = executeDataRule(frenchLawAddendumElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FrenchLawAddendumElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendumElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FrenchLawAddendumElection frenchLawAddendumElection) {
		if (ruleIsApplicable(frenchLawAddendumElection).get()) {
			return evaluateThenExpression(frenchLawAddendumElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FrenchLawAddendumElection frenchLawAddendumElection) {
		try {
			return areEqual(MapperS.of(frenchLawAddendumElection).<Boolean>map("getIsApplicable", _frenchLawAddendumElection -> _frenchLawAddendumElection.getIsApplicable()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FrenchLawAddendumElection frenchLawAddendumElection) {
		try {
			return exists(MapperS.of(frenchLawAddendumElection).<String>map("getAddendumLanguage", _frenchLawAddendumElection -> _frenchLawAddendumElection.getAddendumLanguage()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
