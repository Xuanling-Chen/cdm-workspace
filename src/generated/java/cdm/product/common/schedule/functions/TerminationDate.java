package cdm.product.common.schedule.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
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
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;


@ImplementedBy(TerminationDate.TerminationDateDefault.class)
public abstract class TerminationDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param economicTerms 
	* @return result 
	*/
	public DateGroup evaluate(EconomicTerms economicTerms) {
		
		DateGroup.DateGroupBuilder resultHolder = doEvaluate(economicTerms);
		DateGroup.DateGroupBuilder result = assignOutput(resultHolder, economicTerms);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, result);
		return result;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder result, EconomicTerms economicTerms) {
		result
			.addDates(MapperC.of(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(interestRateTerminationDate(economicTerms).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(interestRateTerminationDate(economicTerms).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(interestRateTerminationDate(economicTerms).get()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(equityPayoutTerminationDate(economicTerms).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(equityPayoutTerminationDate(economicTerms).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(equityPayoutTerminationDate(economicTerms).get()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate())).getMulti())
		;
		return result;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(EconomicTerms economicTerms);
	
	
	protected Mapper<? extends AdjustableOrRelativeDate> interestRateTerminationDate(EconomicTerms economicTerms) {
		return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate());
	}
	
	protected Mapper<? extends AdjustableOrRelativeDate> equityPayoutTerminationDate(EconomicTerms economicTerms) {
		return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get()).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate());
	}
	public static final class TerminationDateDefault extends TerminationDate {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(EconomicTerms economicTerms) {
			return DateGroup.builder();
		}
	}
}
