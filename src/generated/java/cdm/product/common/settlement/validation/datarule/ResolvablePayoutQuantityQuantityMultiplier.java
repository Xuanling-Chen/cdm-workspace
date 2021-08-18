package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.QuantityMultiplier;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePayoutQuantity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ResolvablePayoutQuantityQuantityMultiplier")
public class ResolvablePayoutQuantityQuantityMultiplier implements Validator<ResolvablePayoutQuantity> {
	
	private static final String NAME = "ResolvablePayoutQuantityQuantityMultiplier";
	private static final String DEFINITION = "if quantityMultiplier exists then ResolvablePayoutQuantity -> quantityReference -> reference exists";
	
	
	@Override
	public ValidationResult<ResolvablePayoutQuantity> validate(RosettaPath path, ResolvablePayoutQuantity resolvablePayoutQuantity) {
		ComparisonResult result = executeDataRule(resolvablePayoutQuantity);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ResolvablePayoutQuantity", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResolvablePayoutQuantity", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ResolvablePayoutQuantity resolvablePayoutQuantity) {
		if (ruleIsApplicable(resolvablePayoutQuantity).get()) {
			return evaluateThenExpression(resolvablePayoutQuantity);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ResolvablePayoutQuantity resolvablePayoutQuantity) {
		try {
			return exists(MapperS.of(resolvablePayoutQuantity).<QuantityMultiplier>map("getQuantityMultiplier", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantityMultiplier()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ResolvablePayoutQuantity resolvablePayoutQuantity) {
		try {
			return exists(MapperS.of(resolvablePayoutQuantity).<ReferenceWithMetaResolvablePayoutQuantity>map("getQuantityReference", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantityReference()).map("getReference", a->a.getGlobalReference()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
