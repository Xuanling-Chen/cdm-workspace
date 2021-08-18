package cdm.product.asset.validation.datarule;

import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.DiscountingMethod;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("DiscountingMethodDiscountRate")
public class DiscountingMethodDiscountRate implements Validator<DiscountingMethod> {
	
	private static final String NAME = "DiscountingMethodDiscountRate";
	private static final String DEFINITION = "if discountRateDayCountFraction exists then discountRate exists";
	
	
	@Override
	public ValidationResult<DiscountingMethod> validate(RosettaPath path, DiscountingMethod discountingMethod) {
		ComparisonResult result = executeDataRule(discountingMethod);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "DiscountingMethod", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DiscountingMethod", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(DiscountingMethod discountingMethod) {
		if (ruleIsApplicable(discountingMethod).get()) {
			return evaluateThenExpression(discountingMethod);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(DiscountingMethod discountingMethod) {
		try {
			return exists(MapperS.of(discountingMethod).<FieldWithMetaDayCountFractionEnum>map("getDiscountRateDayCountFraction", _discountingMethod -> _discountingMethod.getDiscountRateDayCountFraction()).<DayCountFractionEnum>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(DiscountingMethod discountingMethod) {
		try {
			return exists(MapperS.of(discountingMethod).<BigDecimal>map("getDiscountRate", _discountingMethod -> _discountingMethod.getDiscountRate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
