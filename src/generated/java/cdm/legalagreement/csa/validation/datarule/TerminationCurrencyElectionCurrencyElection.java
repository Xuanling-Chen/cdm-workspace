package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.TerminationCurrencyElection;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TerminationCurrencyElectionCurrencyElection")
public class TerminationCurrencyElectionCurrencyElection implements Validator<TerminationCurrencyElection> {
	
	private static final String NAME = "TerminationCurrencyElectionCurrencyElection";
	private static final String DEFINITION = "if isSpecified = False then currency is absent";
	
	
	@Override
	public ValidationResult<TerminationCurrencyElection> validate(RosettaPath path, TerminationCurrencyElection terminationCurrencyElection) {
		ComparisonResult result = executeDataRule(terminationCurrencyElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "TerminationCurrencyElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(TerminationCurrencyElection terminationCurrencyElection) {
		if (ruleIsApplicable(terminationCurrencyElection).get()) {
			return evaluateThenExpression(terminationCurrencyElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(TerminationCurrencyElection terminationCurrencyElection) {
		try {
			return areEqual(MapperS.of(terminationCurrencyElection).<Boolean>map("getIsSpecified", _terminationCurrencyElection -> _terminationCurrencyElection.getIsSpecified()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(TerminationCurrencyElection terminationCurrencyElection) {
		try {
			return notExists(MapperS.of(terminationCurrencyElection).<FieldWithMetaString>map("getCurrency", _terminationCurrencyElection -> _terminationCurrencyElection.getCurrency()).<String>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
