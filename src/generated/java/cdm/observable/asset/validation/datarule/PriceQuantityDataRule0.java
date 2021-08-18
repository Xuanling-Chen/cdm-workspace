package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PriceQuantityDataRule0")
public class PriceQuantityDataRule0 implements Validator<PriceQuantity> {
	
	private static final String NAME = "PriceQuantityDataRule0";
	private static final String DEFINITION = "if observable -> rateOption exists and price exists then price -> priceType contains PriceTypeEnum -> Spread or price -> priceType contains PriceTypeEnum -> CapRate or price -> priceType contains PriceTypeEnum -> FloorRate or price -> priceType contains PriceTypeEnum -> MultiplierOfIndexValue";
	
	
	@Override
	public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
		ComparisonResult result = executeDataRule(priceQuantity);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PriceQuantity", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PriceQuantity priceQuantity) {
		if (ruleIsApplicable(priceQuantity).get()) {
			return evaluateThenExpression(priceQuantity);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PriceQuantity priceQuantity) {
		try {
			return exists(MapperS.of(priceQuantity).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue())).and(exists(MapperS.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PriceQuantity priceQuantity) {
		try {
			return contains(MapperS.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.SPREAD)).or(contains(MapperS.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.CAP_RATE))).or(contains(MapperS.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.FLOOR_RATE))).or(contains(MapperS.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.MULTIPLIER_OF_INDEX_VALUE)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
