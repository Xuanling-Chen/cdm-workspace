package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.JapaneseSecuritiesProvisions;
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
@RosettaDataRule("JapaneseSecuritiesProvisionsrelevantProvisionsElection")
public class JapaneseSecuritiesProvisionsrelevantProvisionsElection implements Validator<JapaneseSecuritiesProvisions> {
	
	private static final String NAME = "JapaneseSecuritiesProvisionsrelevantProvisionsElection";
	private static final String DEFINITION = "if relevantProvisionsElection = True then relevantProvisionsTerms is absent";
	
	
	@Override
	public ValidationResult<JapaneseSecuritiesProvisions> validate(RosettaPath path, JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
		ComparisonResult result = executeDataRule(japaneseSecuritiesProvisions);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "JapaneseSecuritiesProvisions", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JapaneseSecuritiesProvisions", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
		if (ruleIsApplicable(japaneseSecuritiesProvisions).get()) {
			return evaluateThenExpression(japaneseSecuritiesProvisions);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
		try {
			return areEqual(MapperS.of(japaneseSecuritiesProvisions).<Boolean>map("getRelevantProvisionsElection", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getRelevantProvisionsElection()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
		try {
			return notExists(MapperS.of(japaneseSecuritiesProvisions).<String>map("getRelevantProvisionsTerms", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getRelevantProvisionsTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
