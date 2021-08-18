package cdm.product.template.validation.datarule;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.common.functions.PriceQuantityTriangulation;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.Inject;
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
@RosettaDataRule("TradableProductPriceQuantityTriangulation")
public class TradableProductPriceQuantityTriangulation implements Validator<TradableProduct> {
	
	private static final String NAME = "TradableProductPriceQuantityTriangulation";
	private static final String DEFINITION = "PriceQuantityTriangulation(tradeLot -> priceQuantity) = True";
	
	@Inject protected PriceQuantityTriangulation priceQuantityTriangulation;
	
	@Override
	public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct) {
		ComparisonResult result = executeDataRule(tradableProduct);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "TradableProduct", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
		if (ruleIsApplicable(tradableProduct).get()) {
			return evaluateThenExpression(tradableProduct);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(TradableProduct tradableProduct) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(TradableProduct tradableProduct) {
		try {
			return areEqual(MapperS.of(priceQuantityTriangulation.evaluate(MapperS.of(tradableProduct).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
