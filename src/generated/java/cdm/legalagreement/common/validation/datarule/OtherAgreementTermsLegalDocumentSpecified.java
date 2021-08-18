package cdm.legalagreement.common.validation.datarule;

import cdm.legalagreement.common.OtherAgreementTerms;
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
@RosettaDataRule("OtherAgreementTermsLegalDocumentSpecified")
public class OtherAgreementTermsLegalDocumentSpecified implements Validator<OtherAgreementTerms> {
	
	private static final String NAME = "OtherAgreementTermsLegalDocumentSpecified";
	private static final String DEFINITION = "if isSpecified = True then legalDocument exists";
	
	
	@Override
	public ValidationResult<OtherAgreementTerms> validate(RosettaPath path, OtherAgreementTerms otherAgreementTerms) {
		ComparisonResult result = executeDataRule(otherAgreementTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "OtherAgreementTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OtherAgreementTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(OtherAgreementTerms otherAgreementTerms) {
		if (ruleIsApplicable(otherAgreementTerms).get()) {
			return evaluateThenExpression(otherAgreementTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(OtherAgreementTerms otherAgreementTerms) {
		try {
			return areEqual(MapperS.of(otherAgreementTerms).<Boolean>map("getIsSpecified", _otherAgreementTerms -> _otherAgreementTerms.getIsSpecified()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(OtherAgreementTerms otherAgreementTerms) {
		try {
			return exists(MapperS.of(otherAgreementTerms).<String>map("getLegalDocument", _otherAgreementTerms -> _otherAgreementTerms.getLegalDocument()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
