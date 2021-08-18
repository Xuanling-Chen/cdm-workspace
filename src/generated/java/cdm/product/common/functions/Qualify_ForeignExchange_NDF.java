package cdm.product.common.functions;

import cdm.product.asset.ForeignExchange;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ForwardPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_ForeignExchange_NDF.Qualify_ForeignExchange_NDFDefault.class)
public abstract class Qualify_ForeignExchange_NDF implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

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
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout()).<Product>map("getUnderlier", _forwardPayout -> _forwardPayout.getUnderlier()).<ForeignExchange>map("getForeignExchange", _product -> _product.getForeignExchange()))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout()).<Product>map("getUnderlier", _forwardPayout -> _forwardPayout.getUnderlier()).<ForeignExchange>map("getForeignExchange", _product -> _product.getForeignExchange()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout()).<SettlementTerms>map("getSettlementTerms", _forwardPayout -> _forwardPayout.getSettlementTerms()).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_ForeignExchange_NDFDefault extends Qualify_ForeignExchange_NDF {
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
