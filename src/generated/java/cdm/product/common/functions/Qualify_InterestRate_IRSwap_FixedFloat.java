package cdm.product.common.functions;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.PrincipalExchanges;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_InterestRate_IRSwap_FixedFloat.Qualify_InterestRate_IRSwap_FixedFloatDefault.class)
public abstract class Qualify_InterestRate_IRSwap_FixedFloat implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		
		Boolean is_productHolder = doEvaluate(economicTerms);
		Boolean is_product = assignOutput(is_productHolder, economicTerms);
		
		return is_product;
	}
	
	private Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()))).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow())))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(notExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PrincipalExchanges>map("getPrincipalExchanges", _interestRatePayout -> _interestRatePayout.getPrincipalExchanges()))).and(notEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.Any)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.AUD_AONIA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.OIS), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.AUD_AONIA_OIS_COMPOUND_SWAP_MARKER), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.CAD_CORRA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.CNY_SHIBOR_OIS_COMPOUNDING), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.COP_IBR_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.DKK_DKKOIS_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_BGCANTOR), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_11_00_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_4_15_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EONIA_OIS_COMPOUND_BLOOMBERG), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.EUR_EURONIA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.GBP_SONIA_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.GBP_SONIA_OIS_11_00_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.GBP_SONIA_OIS_11_00_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.GBP_SONIA_OIS_4_15_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.HKD_HONIX_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.INR_MIBOR_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.INR_MITOR_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.JPY_OIS_11_00_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.JPY_OIS_11_00_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.JPY_OIS_3_00_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.JPY_TONA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.NZD_NZIONA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.PLN_POLONIA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.REPOFUNDS_RATE_FRANCE_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.REPOFUNDS_RATE_GERMANY_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.RUB_RUONIA_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.SEK_SIOR_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.SGD_SONAR_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.SGD_SONAR_OIS_VWAP_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_FEDERAL_FUNDS_H_15_OIS_COMPOUND), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_11_00_BGCANTOR), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_11_00_LON_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_11_00_NY_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_11_00_TRADITION), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_3_00_BGCANTOR), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_3_00_NY_ICAP), CardinalityOperator.All)).and(notEqual(MapperS.of(floatingRateIndex(economicTerms).get()), MapperS.of(FloatingRateIndexEnum.USD_OIS_4_00_TRADITION), CardinalityOperator.All)).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	
	protected Mapper<FloatingRateIndexEnum> floatingRateIndex(EconomicTerms economicTerms) {
		return MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).<ReferenceWithMetaFloatingRateOption>map("getRateOption", _floatingRate -> _floatingRate.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateOption -> _floatingRateOption.getFloatingRateIndex()).<FloatingRateIndexEnum>map("getValue", _f->_f.getValue());
	}
	public static final class Qualify_InterestRate_IRSwap_FixedFloatDefault extends Qualify_InterestRate_IRSwap_FixedFloat {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
