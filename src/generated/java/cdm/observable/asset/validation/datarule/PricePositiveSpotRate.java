package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
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
@RosettaDataRule("PricePositiveSpotRate")
public class PricePositiveSpotRate implements Validator<Price> {
	
	private static final String NAME = "PricePositiveSpotRate";
	private static final String DEFINITION = "if priceType = PriceTypeEnum -> Spot then amount > 0";
	
	
	@Override
	public ValidationResult<Price> validate(RosettaPath path, Price price) {
		ComparisonResult result = executeDataRule(price);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Price", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Price", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Price price) {
		if (ruleIsApplicable(price).get()) {
			return evaluateThenExpression(price);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Price price) {
		try {
			return areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.SPOT), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Price price) {
		try {
			return greaterThan(MapperS.of(price).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
