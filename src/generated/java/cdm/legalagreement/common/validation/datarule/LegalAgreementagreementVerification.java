package cdm.legalagreement.common.validation.datarule;

import cdm.legalagreement.common.Agreement;
import cdm.legalagreement.common.AgreementTerms;
import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.LegalAgreementNameEnum;
import cdm.legalagreement.common.LegalAgreementType;
import cdm.legalagreement.csa.SecurityAgreementElections;
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
@RosettaDataRule("LegalAgreementagreementVerification")
public class LegalAgreementagreementVerification implements Validator<LegalAgreement> {
	
	private static final String NAME = "LegalAgreementagreementVerification";
	private static final String DEFINITION = "if agreementTerms -> agreement -> securityAgreementElections exists then agreementType -> name = LegalAgreementNameEnum->SecurityAgreement else if agreementTerms -> agreement -> creditSupportAgreementElections exists then agreementType -> name = LegalAgreementNameEnum->CreditSupportDeed or agreementType -> name = LegalAgreementNameEnum->CreditSupportAnnex else if agreementTerms -> agreement -> collateralTransferAgreementElections exists then agreementType -> name = LegalAgreementNameEnum->CollateralTransferAgreement else if agreementTerms -> agreement -> masterAgreementSchedule exists then agreementType -> name = LegalAgreementNameEnum->MasterAgreement";
	
	
	@Override
	public ValidationResult<LegalAgreement> validate(RosettaPath path, LegalAgreement legalAgreement) {
		ComparisonResult result = executeDataRule(legalAgreement);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "LegalAgreement", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalAgreement", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(LegalAgreement legalAgreement) {
		if (ruleIsApplicable(legalAgreement).get()) {
			return evaluateThenExpression(legalAgreement);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(LegalAgreement legalAgreement) {
		try {
			return exists(MapperS.of(legalAgreement).<AgreementTerms>map("getAgreementTerms", _legalAgreement -> _legalAgreement.getAgreementTerms()).<Agreement>map("getAgreement", _agreementTerms -> _agreementTerms.getAgreement()).<SecurityAgreementElections>map("getSecurityAgreementElections", _agreement -> _agreement.getSecurityAgreementElections()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(LegalAgreement legalAgreement) {
		try {
			return areEqual(MapperS.of(legalAgreement).<LegalAgreementType>map("getAgreementType", _legalAgreementBase -> _legalAgreementBase.getAgreementType()).<LegalAgreementNameEnum>map("getName", _legalAgreementType -> _legalAgreementType.getName()), MapperS.of(LegalAgreementNameEnum.SECURITY_AGREEMENT), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
