package cdm.product.common.settlement.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.PhysicalSettlementTerms;
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
@RosettaDataRule("PhysicalSettlementTermsPredeterminedClearingOrganizationParty")
public class PhysicalSettlementTermsPredeterminedClearingOrganizationParty implements Validator<PhysicalSettlementTerms> {
	
	private static final String NAME = "PhysicalSettlementTermsPredeterminedClearingOrganizationParty";
	private static final String DEFINITION = "if predeterminedClearingOrganizationParty exists then predeterminedClearingOrganizationParty = AncillaryRoleEnum -> PredeterminedClearingOrganizationParty";
	
	
	@Override
	public ValidationResult<PhysicalSettlementTerms> validate(RosettaPath path, PhysicalSettlementTerms physicalSettlementTerms) {
		ComparisonResult result = executeDataRule(physicalSettlementTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PhysicalSettlementTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PhysicalSettlementTerms physicalSettlementTerms) {
		if (ruleIsApplicable(physicalSettlementTerms).get()) {
			return evaluateThenExpression(physicalSettlementTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PhysicalSettlementTerms physicalSettlementTerms) {
		try {
			return exists(MapperS.of(physicalSettlementTerms).<AncillaryRoleEnum>map("getPredeterminedClearingOrganizationParty", _physicalSettlementTerms -> _physicalSettlementTerms.getPredeterminedClearingOrganizationParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PhysicalSettlementTerms physicalSettlementTerms) {
		try {
			return areEqual(MapperS.of(physicalSettlementTerms).<AncillaryRoleEnum>map("getPredeterminedClearingOrganizationParty", _physicalSettlementTerms -> _physicalSettlementTerms.getPredeterminedClearingOrganizationParty()), MapperS.of(AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
