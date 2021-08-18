package cdm.product.template.functions;

import cdm.base.staticdata.party.Account;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FpmlIrd8.FpmlIrd8Default.class)
public abstract class FpmlIrd8 implements RosettaFunction {

	/**
	* @param tradableProduct 
	* @param accounts 
	* @return success Validation result
	*/
	public Boolean evaluate(TradableProduct tradableProduct, List<? extends Account> accounts) {
		
		Boolean successHolder = doEvaluate(tradableProduct, accounts);
		Boolean success = assignOutput(successHolder, tradableProduct, accounts);
		
		return success;
	}
	
	private Boolean assignOutput(Boolean success, TradableProduct tradableProduct, List<? extends Account> accounts) {
		return success;
	}

	protected abstract Boolean doEvaluate(TradableProduct tradableProduct, List<? extends Account> accounts);
	
	public static final class FpmlIrd8Default extends FpmlIrd8 {
		@Override
		protected  Boolean doEvaluate(TradableProduct tradableProduct, List<? extends Account> accounts) {
			return null;
		}
	}
}
