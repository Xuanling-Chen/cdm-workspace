package cdm.observable.asset.validation.datarule;

import cdm.base.math.Quantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.observable.asset.PriceQuantity;
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
@RosettaDataRule("PriceQuantityNonNegativeQuantity")
public class PriceQuantityNonNegativeQuantity implements Validator<PriceQuantity> {
	
	private static final String NAME = "PriceQuantityNonNegativeQuantity";
	private static final String DEFINITION = "if quantity -> amount exists then quantity -> amount all >= 0";
	
	
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
			return exists(MapperS.of(priceQuantity).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PriceQuantity priceQuantity) {
		try {
			return greaterThanEquals(MapperS.of(priceQuantity).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
