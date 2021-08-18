package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.FrenchLawAddendum;
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
@RosettaDataRule("FrenchLawAddendumApplicable")
public class FrenchLawAddendumApplicable implements Validator<FrenchLawAddendum> {
	
	private static final String NAME = "FrenchLawAddendumApplicable";
	private static final String DEFINITION = "if isApplicable = True then partyElection exists";
	
	
	@Override
	public ValidationResult<FrenchLawAddendum> validate(RosettaPath path, FrenchLawAddendum frenchLawAddendum) {
		ComparisonResult result = executeDataRule(frenchLawAddendum);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FrenchLawAddendum", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FrenchLawAddendum", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FrenchLawAddendum frenchLawAddendum) {
		if (ruleIsApplicable(frenchLawAddendum).get()) {
			return evaluateThenExpression(frenchLawAddendum);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FrenchLawAddendum frenchLawAddendum) {
		try {
			return areEqual(MapperS.of(frenchLawAddendum).<Boolean>map("getIsApplicable", _frenchLawAddendum -> _frenchLawAddendum.getIsApplicable()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FrenchLawAddendum frenchLawAddendum) {
		try {
			return exists(MapperS.of(frenchLawAddendum).<FrenchLawAddendumElection>mapC("getPartyElection", _frenchLawAddendum -> _frenchLawAddendum.getPartyElection()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
