package cdm.product.template.validation.datarule;

import cdm.product.asset.DividendReturnTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.template.EquityPayout;
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
@RosettaDataRule("EquityPayoutPriceReturn")
public class EquityPayoutPriceReturn implements Validator<EquityPayout> {
	
	private static final String NAME = "EquityPayoutPriceReturn";
	private static final String DEFINITION = "if returnType = ReturnTypeEnum -> Dividend then dividendReturnTerms exists and priceReturnTerms is absent";
	
	
	@Override
	public ValidationResult<EquityPayout> validate(RosettaPath path, EquityPayout equityPayout) {
		ComparisonResult result = executeDataRule(equityPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EquityPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EquityPayout equityPayout) {
		if (ruleIsApplicable(equityPayout).get()) {
			return evaluateThenExpression(equityPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EquityPayout equityPayout) {
		try {
			return areEqual(MapperS.of(equityPayout).<ReturnTypeEnum>map("getReturnType", _equityPayout -> _equityPayout.getReturnType()), MapperS.of(ReturnTypeEnum.DIVIDEND), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EquityPayout equityPayout) {
		try {
			return exists(MapperS.of(equityPayout).<DividendReturnTerms>map("getDividendReturnTerms", _equityPayout -> _equityPayout.getDividendReturnTerms())).and(notExists(MapperS.of(equityPayout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
