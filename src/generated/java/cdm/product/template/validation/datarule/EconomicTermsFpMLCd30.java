package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EconomicTermsFpML_cd_30")
public class EconomicTermsFpMLCd30 implements Validator<EconomicTerms> {
	
	private static final String NAME = "EconomicTermsFpML_cd_30";
	private static final String DEFINITION = "if (payout -> interestRatePayout -> paymentDates -> lastRegularPaymentDate and terminationDate) exists then payout -> interestRatePayout -> paymentDates -> lastRegularPaymentDate all < terminationDate -> adjustableDate -> unadjustedDate";
	
	
	@Override
	public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
		ComparisonResult result = executeDataRule(economicTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EconomicTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
		if (ruleIsApplicable(economicTerms).get()) {
			return evaluateThenExpression(economicTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EconomicTerms economicTerms) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate())), MapperTree.of(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EconomicTerms economicTerms) {
		try {
			return lessThan(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
