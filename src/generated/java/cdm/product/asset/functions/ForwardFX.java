package cdm.product.asset.functions;

import cdm.product.asset.ForeignExchange;
import cdm.product.asset.ForeignExchange.ForeignExchangeBuilder;
import cdm.product.template.ForwardPayout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ForwardFX.ForwardFXDefault.class)
public abstract class ForwardFX implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param forwardPayout 
	* @return result 
	*/
	public ForeignExchange evaluate(ForwardPayout forwardPayout) {
		
		ForeignExchange.ForeignExchangeBuilder resultHolder = doEvaluate(forwardPayout);
		ForeignExchange.ForeignExchangeBuilder result = assignOutput(resultHolder, forwardPayout);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(ForeignExchange.class, result);
		return result;
	}
	
	private ForeignExchange.ForeignExchangeBuilder assignOutput(ForeignExchange.ForeignExchangeBuilder result, ForwardPayout forwardPayout) {
		result = toBuilder(MapperS.of(forwardPayout).<Product>map("getUnderlier", _forwardPayout -> _forwardPayout.getUnderlier()).<ForeignExchange>map("getForeignExchange", _product -> _product.getForeignExchange()).get())
		;
		return result;
	}

	protected abstract ForeignExchange.ForeignExchangeBuilder doEvaluate(ForwardPayout forwardPayout);
	
	public static final class ForwardFXDefault extends ForwardFX {
		@Override
		protected  ForeignExchange.ForeignExchangeBuilder doEvaluate(ForwardPayout forwardPayout) {
			return ForeignExchange.builder();
		}
	}
}
