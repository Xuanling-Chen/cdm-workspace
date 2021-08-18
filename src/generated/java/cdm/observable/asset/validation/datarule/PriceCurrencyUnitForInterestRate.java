package cdm.observable.asset.validation.datarule;

import cdm.base.math.UnitType;
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
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PriceCurrencyUnitForInterestRate")
public class PriceCurrencyUnitForInterestRate implements Validator<Price> {
	
	private static final String NAME = "PriceCurrencyUnitForInterestRate";
	private static final String DEFINITION = "if priceType = PriceTypeEnum -> InterestRate then unitOfAmount -> currency exists";
	
	
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
			return areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Price price) {
		try {
			return exists(MapperS.of(price).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
