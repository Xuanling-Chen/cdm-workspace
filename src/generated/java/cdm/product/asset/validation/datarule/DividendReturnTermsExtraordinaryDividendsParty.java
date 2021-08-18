package cdm.product.asset.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.asset.DividendReturnTerms;
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
@RosettaDataRule("DividendReturnTermsExtraordinaryDividendsParty")
public class DividendReturnTermsExtraordinaryDividendsParty implements Validator<DividendReturnTerms> {
	
	private static final String NAME = "DividendReturnTermsExtraordinaryDividendsParty";
	private static final String DEFINITION = "if extraordinaryDividendsParty exists then extraordinaryDividendsParty = AncillaryRoleEnum -> ExtraordinaryDividendsParty";
	
	
	@Override
	public ValidationResult<DividendReturnTerms> validate(RosettaPath path, DividendReturnTerms dividendReturnTerms) {
		ComparisonResult result = executeDataRule(dividendReturnTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "DividendReturnTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendReturnTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(DividendReturnTerms dividendReturnTerms) {
		if (ruleIsApplicable(dividendReturnTerms).get()) {
			return evaluateThenExpression(dividendReturnTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(DividendReturnTerms dividendReturnTerms) {
		try {
			return exists(MapperS.of(dividendReturnTerms).<AncillaryRoleEnum>map("getExtraordinaryDividendsParty", _dividendReturnTerms -> _dividendReturnTerms.getExtraordinaryDividendsParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(DividendReturnTerms dividendReturnTerms) {
		try {
			return areEqual(MapperS.of(dividendReturnTerms).<AncillaryRoleEnum>map("getExtraordinaryDividendsParty", _dividendReturnTerms -> _dividendReturnTerms.getExtraordinaryDividendsParty()), MapperS.of(AncillaryRoleEnum.EXTRAORDINARY_DIVIDENDS_PARTY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
