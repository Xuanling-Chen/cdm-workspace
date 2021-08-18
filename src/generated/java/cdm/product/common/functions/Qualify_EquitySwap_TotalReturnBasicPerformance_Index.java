package cdm.product.common.functions;

import cdm.base.staticdata.asset.common.Index;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_EquitySwap_TotalReturnBasicPerformance_Index.Qualify_EquitySwap_TotalReturnBasicPerformance_IndexDefault.class)
public abstract class Qualify_EquitySwap_TotalReturnBasicPerformance_Index implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

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
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()))).and(areEqual(MapperS.of(equityPayout(economicTerms).get()).<ReturnTypeEnum>map("getReturnType", _equityPayout -> _equityPayout.getReturnType()), MapperS.of(ReturnTypeEnum.TOTAL), CardinalityOperator.All)).and(exists(MapperS.of(equityPayout(economicTerms).get()).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Index>map("getIndex", _product -> _product.getIndex()))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	
	protected Mapper<? extends EquityPayout> equityPayout(EconomicTerms economicTerms) {
		return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get());
	}
	public static final class Qualify_EquitySwap_TotalReturnBasicPerformance_IndexDefault extends Qualify_EquitySwap_TotalReturnBasicPerformance_Index {
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
