package cdm.product.common.functions;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.CommodityPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_Commodity_Swap_Basis.Qualify_Commodity_Swap_BasisDefault.class)
public abstract class Qualify_Commodity_Swap_Basis implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

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
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>mapC("getCommodityPayout", _payout -> _payout.getCommodityPayout()))).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>mapC("getCommodityPayout", _payout -> _payout.getCommodityPayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow())))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>mapC("getCommodityPayout", _payout -> _payout.getCommodityPayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>mapC("getCommodityPayout", _payout -> _payout.getCommodityPayout()).<Product>map("getUnderlier", _observationPayout -> _observationPayout.getUnderlier()).<ReferenceWithMetaCommodity>map("getCommodity", _product -> _product.getCommodity()).<Commodity>map("getValue", _f->_f.getValue()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_Commodity_Swap_BasisDefault extends Qualify_Commodity_Swap_Basis {
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
