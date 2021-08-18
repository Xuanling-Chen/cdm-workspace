package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AmendmentEffectiveDate;
import cdm.legalagreement.csa.ElectiveAmountElection;
import cdm.legalagreement.csa.MinimumTransferAmountAmendment;
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
@RosettaDataRule("MinimumTransferAmountAmendmentAmendmentNotApplicable")
public class MinimumTransferAmountAmendmentAmendmentNotApplicable implements Validator<MinimumTransferAmountAmendment> {
	
	private static final String NAME = "MinimumTransferAmountAmendmentAmendmentNotApplicable";
	private static final String DEFINITION = "if isApplicable = False then effectiveDate is absent and partyElections is absent";
	
	
	@Override
	public ValidationResult<MinimumTransferAmountAmendment> validate(RosettaPath path, MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
		ComparisonResult result = executeDataRule(minimumTransferAmountAmendment);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MinimumTransferAmountAmendment", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MinimumTransferAmountAmendment", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
		if (ruleIsApplicable(minimumTransferAmountAmendment).get()) {
			return evaluateThenExpression(minimumTransferAmountAmendment);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
		try {
			return areEqual(MapperS.of(minimumTransferAmountAmendment).<Boolean>map("getIsApplicable", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
		try {
			return notExists(MapperS.of(minimumTransferAmountAmendment).<AmendmentEffectiveDate>map("getEffectiveDate", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getEffectiveDate())).and(notExists(MapperS.of(minimumTransferAmountAmendment).<ElectiveAmountElection>mapC("getPartyElections", _minimumTransferAmountAmendment -> _minimumTransferAmountAmendment.getPartyElections())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
