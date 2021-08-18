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
@RosettaDataRule("JapaneseSecuritiesProvisionsamendmentsToJapaneseProvisions")
public class JapaneseSecuritiesProvisionsamendmentsToJapaneseProvisions implements Validator<JapaneseSecuritiesProvisions> {
	
	private static final String NAME = "JapaneseSecuritiesProvisionsamendmentsToJapaneseProvisions";
	private static final String DEFINITION = "if amendmentsToJapaneseProvisions = False then amendmentsToJapaneseProvisionsTerms is absent";
	
	
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
			return areEqual(MapperS.of(japaneseSecuritiesProvisions).<Boolean>map("getAmendmentsToJapaneseProvisions", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getAmendmentsToJapaneseProvisions()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
		try {
			return notExists(MapperS.of(japaneseSecuritiesProvisions).<String>map("getAmendmentsToJapaneseProvisionsTerms", _japaneseSecuritiesProvisions -> _japaneseSecuritiesProvisions.getAmendmentsToJapaneseProvisionsTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
