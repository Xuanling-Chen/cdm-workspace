package cdm.event.common.functions;

import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.TermsChangePrimitive.TermsChangePrimitiveBuilder;
import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(Create_PriceChangePrimitive.Create_PriceChangePrimitiveDefault.class)
public abstract class Create_PriceChangePrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @param cashPrice 
	* @return termsChangePrimitive 
	*/
	public TermsChangePrimitive evaluate(TradeState tradeState, BigDecimal cashPrice) {
		
		TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitiveHolder = doEvaluate(tradeState, cashPrice);
		TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitive = assignOutput(termsChangePrimitiveHolder, tradeState, cashPrice);
		
		if (termsChangePrimitive!=null) objectValidator.validateAndFailOnErorr(TermsChangePrimitive.class, termsChangePrimitive);
		return termsChangePrimitive;
	}
	
	private TermsChangePrimitive.TermsChangePrimitiveBuilder assignOutput(TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitive, TradeState tradeState, BigDecimal cashPrice) {
		return termsChangePrimitive;
	}

	protected abstract TermsChangePrimitive.TermsChangePrimitiveBuilder doEvaluate(TradeState tradeState, BigDecimal cashPrice);
	
	public static final class Create_PriceChangePrimitiveDefault extends Create_PriceChangePrimitive {
		@Override
		protected  TermsChangePrimitive.TermsChangePrimitiveBuilder doEvaluate(TradeState tradeState, BigDecimal cashPrice) {
			return TermsChangePrimitive.builder();
		}
	}
}
