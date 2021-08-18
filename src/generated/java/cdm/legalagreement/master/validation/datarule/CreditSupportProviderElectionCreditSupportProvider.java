package cdm.legalagreement.master.validation.datarule;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legalagreement.common.CreditSupportProviderTermsEnum;
import cdm.legalagreement.master.CreditSupportProviderElection;
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
@RosettaDataRule("CreditSupportProviderElectionCreditSupportProvider")
public class CreditSupportProviderElectionCreditSupportProvider implements Validator<CreditSupportProviderElection> {
	
	private static final String NAME = "CreditSupportProviderElectionCreditSupportProvider";
	private static final String DEFINITION = "if creditSupportProviderTerms = CreditSupportProviderTermsEnum->Specified then creditSupportProvider exists";
	
	
	@Override
	public ValidationResult<CreditSupportProviderElection> validate(RosettaPath path, CreditSupportProviderElection creditSupportProviderElection) {
		ComparisonResult result = executeDataRule(creditSupportProviderElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CreditSupportProviderElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditSupportProviderElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CreditSupportProviderElection creditSupportProviderElection) {
		if (ruleIsApplicable(creditSupportProviderElection).get()) {
			return evaluateThenExpression(creditSupportProviderElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CreditSupportProviderElection creditSupportProviderElection) {
		try {
			return areEqual(MapperS.of(creditSupportProviderElection).<CreditSupportProviderTermsEnum>map("getCreditSupportProviderTerms", _creditSupportProviderElection -> _creditSupportProviderElection.getCreditSupportProviderTerms()), MapperS.of(CreditSupportProviderTermsEnum.SPECIFIED), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CreditSupportProviderElection creditSupportProviderElection) {
		try {
			return exists(MapperS.of(creditSupportProviderElection).<LegalEntity>mapC("getCreditSupportProvider", _creditSupportProviderElection -> _creditSupportProviderElection.getCreditSupportProvider()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
