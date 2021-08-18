package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.FallbackReferencePrice;
import cdm.observable.asset.ValuationPostponement;
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
@RosettaDataRule("FallbackReferencePriceMaximumDaysOfPostponement")
public class FallbackReferencePriceMaximumDaysOfPostponement implements Validator<FallbackReferencePrice> {
	
	private static final String NAME = "FallbackReferencePriceMaximumDaysOfPostponement";
	private static final String DEFINITION = "if valuationPostponement exists then valuationPostponement -> maximumDaysOfPostponement > 0";
	
	
	@Override
	public ValidationResult<FallbackReferencePrice> validate(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
		ComparisonResult result = executeDataRule(fallbackReferencePrice);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FallbackReferencePrice", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FallbackReferencePrice fallbackReferencePrice) {
		if (ruleIsApplicable(fallbackReferencePrice).get()) {
			return evaluateThenExpression(fallbackReferencePrice);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FallbackReferencePrice fallbackReferencePrice) {
		try {
			return exists(MapperS.of(fallbackReferencePrice).<ValuationPostponement>map("getValuationPostponement", _fallbackReferencePrice -> _fallbackReferencePrice.getValuationPostponement()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FallbackReferencePrice fallbackReferencePrice) {
		try {
			return greaterThan(MapperS.of(fallbackReferencePrice).<ValuationPostponement>map("getValuationPostponement", _fallbackReferencePrice -> _fallbackReferencePrice.getValuationPostponement()).<Integer>map("getMaximumDaysOfPostponement", _valuationPostponement -> _valuationPostponement.getMaximumDaysOfPostponement()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
