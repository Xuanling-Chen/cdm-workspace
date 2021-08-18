package cdm.event.common.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
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


@ImplementedBy(NovatedContractEffectiveDate.NovatedContractEffectiveDateDefault.class)
public abstract class NovatedContractEffectiveDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param businessEvent 
	* @return result 
	*/
	public DateGroup evaluate(BusinessEvent businessEvent) {
		
		DateGroup.DateGroupBuilder resultHolder = doEvaluate(businessEvent);
		DateGroup.DateGroupBuilder result = assignOutput(resultHolder, businessEvent);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, result);
		return result;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder result, BusinessEvent businessEvent) {
		result
			.addDates(MapperC.of(MapperS.of(effectiveDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(effectiveDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(effectiveDate(businessEvent).get()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(interestRatePayoutDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(interestRatePayoutDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(interestRatePayoutDate(businessEvent).get()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(equityPayoutDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(equityPayoutDate(businessEvent).get()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(equityPayoutDate(businessEvent).get()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate())).getMulti())
		;
		return result;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends EconomicTerms> eTerms(BusinessEvent businessEvent) {
		return MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms());
	}
	
	protected Mapper<? extends AdjustableOrRelativeDate> effectiveDate(BusinessEvent businessEvent) {
		return MapperS.of(eTerms(businessEvent).get()).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate());
	}
	
	protected Mapper<? extends AdjustableOrRelativeDate> interestRatePayoutDate(BusinessEvent businessEvent) {
		return MapperS.of(eTerms(businessEvent).get()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate());
	}
	
	protected Mapper<? extends AdjustableOrRelativeDate> equityPayoutDate(BusinessEvent businessEvent) {
		return MapperS.of(eTerms(businessEvent).get()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate());
	}
	public static final class NovatedContractEffectiveDateDefault extends NovatedContractEffectiveDate {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(BusinessEvent businessEvent) {
			return DateGroup.builder();
		}
	}
}
