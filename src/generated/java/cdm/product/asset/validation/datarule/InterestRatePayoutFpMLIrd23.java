package cdm.product.asset.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.StubValue;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.StubPeriod;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRatePayoutFpML_ird_23")
public class InterestRatePayoutFpMLIrd23 implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutFpML_ird_23";
	private static final String DEFINITION = "if stubPeriod -> initialStub exists then calculationPeriodDates -> firstRegularPeriodStartDate exists";
	
	
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
			return exists(MapperS.of(interestRatePayout).<StubPeriod>map("getStubPeriod", _interestRatePayout -> _interestRatePayout.getStubPeriod()).<StubValue>map("getInitialStub", _stubPeriod -> _stubPeriod.getInitialStub()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<Date>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
