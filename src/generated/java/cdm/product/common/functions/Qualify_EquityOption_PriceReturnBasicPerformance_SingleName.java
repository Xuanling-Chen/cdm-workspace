package cdm.product.common.functions;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.event.position.AveragingObservation;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.AmericanExercise;
import cdm.product.template.BermudaExercise;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EuropeanExercise;
import cdm.product.template.OptionExercise;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStyle;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_EquityOption_PriceReturnBasicPerformance_SingleName.Qualify_EquityOption_PriceReturnBasicPerformance_SingleNameDefault.class)
public abstract class Qualify_EquityOption_PriceReturnBasicPerformance_SingleName implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

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
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()))).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow())))).and(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.All).or(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.EXCHANGE_TRADED_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.MUTUAL_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.WARRANT), CardinalityOperator.All))).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<OptionStyle>map("getOptionStyle", _optionExercise -> _optionExercise.getOptionStyle()).<AmericanExercise>map("getAmericanExercise", _optionStyle -> _optionStyle.getAmericanExercise())).or(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<OptionStyle>map("getOptionStyle", _optionExercise -> _optionExercise.getOptionStyle()).<EuropeanExercise>map("getEuropeanExercise", _optionStyle -> _optionStyle.getEuropeanExercise()))).or(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<OptionStyle>map("getOptionStyle", _optionExercise -> _optionExercise.getOptionStyle()).<BermudaExercise>map("getBermudaExercise", _optionStyle -> _optionStyle.getBermudaExercise())))).and(notExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature())).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()).<AveragingObservation>map("getAveragingRateFeature", _optionFeature -> _optionFeature.getAveragingRateFeature()))))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_EquityOption_PriceReturnBasicPerformance_SingleNameDefault extends Qualify_EquityOption_PriceReturnBasicPerformance_SingleName {
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
