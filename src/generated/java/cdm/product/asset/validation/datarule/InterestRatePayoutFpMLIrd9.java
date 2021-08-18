package cdm.product.asset.validation.datarule;

import cdm.product.asset.CompoundingMethodEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.ResetDates;
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
@RosettaDataRule("InterestRatePayoutFpML_ird_9")
public class InterestRatePayoutFpMLIrd9 implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutFpML_ird_9";
	private static final String DEFINITION = "if compoundingMethod exists then resetDates exists";
	
	
	@Override
	public ValidationResult<InterestRatePayout> validate(RosettaPath path, InterestRatePayout interestRatePayout) {
		ComparisonResult result = executeDataRule(interestRatePayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "InterestRatePayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
		if (ruleIsApplicable(interestRatePayout).get()) {
			return evaluateThenExpression(interestRatePayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperS.of(interestRatePayout).<CompoundingMethodEnum>map("getCompoundingMethod", _interestRatePayout -> _interestRatePayout.getCompoundingMethod()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperS.of(interestRatePayout).<ResetDates>map("getResetDates", _interestRatePayout -> _interestRatePayout.getResetDates()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
