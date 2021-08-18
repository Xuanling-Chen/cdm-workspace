package cdm.legalagreement.master.validation.datarule;

import cdm.legalagreement.common.CreditSupportDocumentTermsEnum;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.master.CreditSupportDocumentElection;
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
@RosettaDataRule("CreditSupportDocumentElectionCreditSupportDocument")
public class CreditSupportDocumentElectionCreditSupportDocument implements Validator<CreditSupportDocumentElection> {
	
	private static final String NAME = "CreditSupportDocumentElectionCreditSupportDocument";
	private static final String DEFINITION = "if creditSupportDocumentTerms = CreditSupportDocumentTermsEnum->Specified then creditSupportDocument exists";
	
	
	@Override
	public ValidationResult<CreditSupportDocumentElection> validate(RosettaPath path, CreditSupportDocumentElection creditSupportDocumentElection) {
		ComparisonResult result = executeDataRule(creditSupportDocumentElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CreditSupportDocumentElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportDocumentElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CreditSupportDocumentElection creditSupportDocumentElection) {
		if (ruleIsApplicable(creditSupportDocumentElection).get()) {
			return evaluateThenExpression(creditSupportDocumentElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CreditSupportDocumentElection creditSupportDocumentElection) {
		try {
			return areEqual(MapperS.of(creditSupportDocumentElection).<CreditSupportDocumentTermsEnum>map("getCreditSupportDocumentTerms", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocumentTerms()), MapperS.of(CreditSupportDocumentTermsEnum.SPECIFIED), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CreditSupportDocumentElection creditSupportDocumentElection) {
		try {
			return exists(MapperS.of(creditSupportDocumentElection).<RelatedAgreement>mapC("getCreditSupportDocument", _creditSupportDocumentElection -> _creditSupportDocumentElection.getCreditSupportDocument()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
