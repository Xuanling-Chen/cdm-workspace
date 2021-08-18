package cdm.product.asset.validation.datarule;

import cdm.observable.asset.Price;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CreditDefaultPayoutFpML_cd_12")
public class CreditDefaultPayoutFpMLCd12 implements Validator<CreditDefaultPayout> {
	
	private static final String NAME = "CreditDefaultPayoutFpML_cd_12";
	private static final String DEFINITION = "if generalTerms -> referenceInformation -> referencePrice exists then generalTerms -> referenceInformation -> referencePrice ->amount >= 0";
	
	
	@Override
	public ValidationResult<CreditDefaultPayout> validate(RosettaPath path, CreditDefaultPayout creditDefaultPayout) {
		ComparisonResult result = executeDataRule(creditDefaultPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CreditDefaultPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CreditDefaultPayout creditDefaultPayout) {
		if (ruleIsApplicable(creditDefaultPayout).get()) {
			return evaluateThenExpression(creditDefaultPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CreditDefaultPayout creditDefaultPayout) {
		try {
			return exists(MapperS.of(creditDefaultPayout).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<Price>map("getReferencePrice", _referenceInformation -> _referenceInformation.getReferencePrice()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CreditDefaultPayout creditDefaultPayout) {
		try {
			return greaterThanEquals(MapperS.of(creditDefaultPayout).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<Price>map("getReferencePrice", _referenceInformation -> _referenceInformation.getReferencePrice()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
