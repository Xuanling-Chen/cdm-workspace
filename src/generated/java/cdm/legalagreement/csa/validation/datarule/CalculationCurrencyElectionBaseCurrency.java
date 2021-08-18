package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.CalculationCurrencyElection;
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
@RosettaDataRule("CalculationCurrencyElectionBaseCurrency")
public class CalculationCurrencyElectionBaseCurrency implements Validator<CalculationCurrencyElection> {
	
	private static final String NAME = "CalculationCurrencyElectionBaseCurrency";
	private static final String DEFINITION = "if isBaseCurrency = True then currency is absent else currency exists";
	
	
	@Override
	public ValidationResult<CalculationCurrencyElection> validate(RosettaPath path, CalculationCurrencyElection calculationCurrencyElection) {
		ComparisonResult result = executeDataRule(calculationCurrencyElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CalculationCurrencyElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationCurrencyElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CalculationCurrencyElection calculationCurrencyElection) {
		if (ruleIsApplicable(calculationCurrencyElection).get()) {
			return evaluateThenExpression(calculationCurrencyElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CalculationCurrencyElection calculationCurrencyElection) {
		try {
			return areEqual(MapperS.of(calculationCurrencyElection).<Boolean>map("getIsBaseCurrency", _calculationCurrencyElection -> _calculationCurrencyElection.getIsBaseCurrency()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CalculationCurrencyElection calculationCurrencyElection) {
		try {
			return notExists(MapperS.of(calculationCurrencyElection).<FieldWithMetaString>map("getCurrency", _calculationCurrencyElection -> _calculationCurrencyElection.getCurrency()).<String>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
