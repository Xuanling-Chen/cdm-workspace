package cdm.product.common.schedule.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.PaymentDate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(EffectiveDateContainsPaymentDate.EffectiveDateContainsPaymentDateDefault.class)
public abstract class EffectiveDateContainsPaymentDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PaymentDate paymentDate;

	/**
	* @param economicTerms 
	* @return result 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		
		Boolean resultHolder = doEvaluate(economicTerms);
		Boolean result = assignOutput(resultHolder, economicTerms);
		
		return result;
	}
	
	private Boolean assignOutput(Boolean result, EconomicTerms economicTerms) {
		result = exists(MapperS.of(effectiveDates(economicTerms).get())).and(contains(MapperS.of(effectiveDates(economicTerms).get()), MapperS.of(paymentDate(economicTerms).get()))).get();
		return result;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	
	protected Mapper<Date> paymentDate(EconomicTerms economicTerms) {
		return MapperS.of(paymentDate.evaluate(MapperS.of(economicTerms).get()));
	}
	
	protected Mapper<Date> effectiveDates(EconomicTerms economicTerms) {
		return MapperC.of(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()));
	}
	public static final class EffectiveDateContainsPaymentDateDefault extends EffectiveDateContainsPaymentDate {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
}
