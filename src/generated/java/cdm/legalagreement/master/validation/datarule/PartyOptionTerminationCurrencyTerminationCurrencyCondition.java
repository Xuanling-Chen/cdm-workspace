package cdm.legalagreement.master.validation.datarule;

import cdm.legalagreement.common.TerminationCurrencyConditionEnum;
import cdm.legalagreement.master.PartyOptionTerminationCurrency;
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
@RosettaDataRule("PartyOptionTerminationCurrencyTerminationCurrencyCondition")
public class PartyOptionTerminationCurrencyTerminationCurrencyCondition implements Validator<PartyOptionTerminationCurrency> {
	
	private static final String NAME = "PartyOptionTerminationCurrencyTerminationCurrencyCondition";
	private static final String DEFINITION = "if terminationCurrencyCondition = TerminationCurrencyConditionEnum -> Specified then terminationCurrencySpecifiedCondition exists";
	
	
	@Override
	public ValidationResult<PartyOptionTerminationCurrency> validate(RosettaPath path, PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
		ComparisonResult result = executeDataRule(partyOptionTerminationCurrency);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PartyOptionTerminationCurrency", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyOptionTerminationCurrency", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
		if (ruleIsApplicable(partyOptionTerminationCurrency).get()) {
			return evaluateThenExpression(partyOptionTerminationCurrency);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
		try {
			return areEqual(MapperS.of(partyOptionTerminationCurrency).<TerminationCurrencyConditionEnum>map("getTerminationCurrencyCondition", _partyOptionTerminationCurrency -> _partyOptionTerminationCurrency.getTerminationCurrencyCondition()), MapperS.of(TerminationCurrencyConditionEnum.SPECIFIED), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
		try {
			return exists(MapperS.of(partyOptionTerminationCurrency).<String>map("getTerminationCurrencySpecifiedCondition", _partyOptionTerminationCurrency -> _partyOptionTerminationCurrency.getTerminationCurrencySpecifiedCondition()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
