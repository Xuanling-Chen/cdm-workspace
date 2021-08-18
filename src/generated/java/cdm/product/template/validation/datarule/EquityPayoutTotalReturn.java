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

/**
 * @version ${project.version}
 */
@RosettaDataRule("EquityPayoutTotalReturn")
public class EquityPayoutTotalReturn implements Validator<EquityPayout> {
	
	private static final String NAME = "EquityPayoutTotalReturn";
	private static final String DEFINITION = "if returnType = ReturnTypeEnum -> Total then priceReturnTerms exists and dividendReturnTerms exists";
	
	
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
			return areEqual(MapperS.of(equityPayout).<ReturnTypeEnum>map("getReturnType", _equityPayout -> _equityPayout.getReturnType()), MapperS.of(ReturnTypeEnum.TOTAL), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EquityPayout equityPayout) {
		try {
			return exists(MapperS.of(equityPayout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms())).and(exists(MapperS.of(equityPayout).<DividendReturnTerms>map("getDividendReturnTerms", _equityPayout -> _equityPayout.getDividendReturnTerms())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
