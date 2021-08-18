package cdm.product.common.functions;

import cdm.observable.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.PrincipalExchanges;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InterestRate_CrossCurrency_FixedFixed.Qualify_InterestRate_CrossCurrency_FixedFixedDefault.class)
public abstract class Qualify_InterestRate_CrossCurrency_FixedFixed implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

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
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()))).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow())))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PrincipalExchanges>map("getPrincipalExchanges", _interestRatePayout -> _interestRatePayout.getPrincipalExchanges()))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_InterestRate_CrossCurrency_FixedFixedDefault extends Qualify_InterestRate_CrossCurrency_FixedFixed {
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
