package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AmendmentEffectiveDate;
import cdm.legalagreement.csa.TerminationCurrencyAmendment;
import cdm.legalagreement.csa.TerminationCurrencyElection;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.ExpressionOperators;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TerminationCurrencyAmendmentApplicablity")
public class TerminationCurrencyAmendmentApplicablity implements Validator<TerminationCurrencyAmendment> {
	
	private static final String NAME = "TerminationCurrencyAmendmentApplicablity";
	private static final String DEFINITION = "if isApplicable = False then ( effectiveDate and partyElection) is absent";
	
	
	@Override
	public ValidationResult<TerminationCurrencyAmendment> validate(RosettaPath path, TerminationCurrencyAmendment terminationCurrencyAmendment) {
		ComparisonResult result = executeDataRule(terminationCurrencyAmendment);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "TerminationCurrencyAmendment", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TerminationCurrencyAmendment", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(TerminationCurrencyAmendment terminationCurrencyAmendment) {
		if (ruleIsApplicable(terminationCurrencyAmendment).get()) {
			return evaluateThenExpression(terminationCurrencyAmendment);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(TerminationCurrencyAmendment terminationCurrencyAmendment) {
		try {
			return areEqual(MapperS.of(terminationCurrencyAmendment).<Boolean>map("getIsApplicable", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(TerminationCurrencyAmendment terminationCurrencyAmendment) {
		try {
			return ExpressionOperators.notExists(MapperTree.andDifferent(MapperTree.of(MapperS.of(terminationCurrencyAmendment).<AmendmentEffectiveDate>map("getEffectiveDate", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getEffectiveDate())), MapperTree.of(MapperS.of(terminationCurrencyAmendment).<TerminationCurrencyElection>mapC("getPartyElection", _terminationCurrencyAmendment -> _terminationCurrencyAmendment.getPartyElection()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
