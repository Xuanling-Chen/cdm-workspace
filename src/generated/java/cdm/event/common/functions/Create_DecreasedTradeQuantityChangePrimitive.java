package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.event.common.DecreasedTrade;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.QuantityChangePrimitive.QuantityChangePrimitiveBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_QuantityChangePrimitive;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_DecreasedTradeQuantityChangePrimitive.Create_DecreasedTradeQuantityChangePrimitiveDefault.class)
public abstract class Create_DecreasedTradeQuantityChangePrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_QuantityChangePrimitive create_QuantityChangePrimitive;

	/**
	* @param decrease 
	* @return quantityChangePrimitive 
	*/
	public QuantityChangePrimitive evaluate(DecreasedTrade decrease) {
		
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitiveHolder = doEvaluate(decrease);
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive = assignOutput(quantityChangePrimitiveHolder, decrease);
		
		if (quantityChangePrimitive!=null) objectValidator.validateAndFailOnErorr(QuantityChangePrimitive.class, quantityChangePrimitive);
		return quantityChangePrimitive;
	}
	
	private QuantityChangePrimitive.QuantityChangePrimitiveBuilder assignOutput(QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive, DecreasedTrade decrease) {
		quantityChangePrimitive = toBuilder(MapperS.of(create_QuantityChangePrimitive.evaluate(MapperS.of(decrease).<TradeState>map("getTradeState", _decreasedTrade -> _decreasedTrade.getTradeState()).get(), MapperS.of(decrease).<Quantity>mapC("getQuantity", _decreasedTrade -> _decreasedTrade.getQuantity()).getMulti())).get())
		;
		return quantityChangePrimitive;
	}

	protected abstract QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(DecreasedTrade decrease);
	
	public static final class Create_DecreasedTradeQuantityChangePrimitiveDefault extends Create_DecreasedTradeQuantityChangePrimitive {
		@Override
		protected  QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(DecreasedTrade decrease) {
			return QuantityChangePrimitive.builder();
		}
	}
}
