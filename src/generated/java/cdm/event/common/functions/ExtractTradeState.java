package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.ResetPrimitive;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ExtractTradeState.ExtractTradeStateDefault.class)
public abstract class ExtractTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param event 
	* @return tradeState 
	*/
	public TradeState evaluate(BusinessEvent event) {
		
		TradeState.TradeStateBuilder tradeStateHolder = doEvaluate(event);
		TradeState.TradeStateBuilder tradeState = assignOutput(tradeStateHolder, event);
		
		if (tradeState!=null) objectValidator.validateAndFailOnErorr(TradeState.class, tradeState);
		return tradeState;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, BusinessEvent event) {
		tradeState = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(primitive(event).get()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation())).get()) {
					return MapperS.of(primitive(event).get()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter());
				}
				else if (exists(MapperS.of(primitive(event).get()).<ResetPrimitive>map("getReset", _primitiveEvent -> _primitiveEvent.getReset())).get()) {
					return MapperS.of(primitive(event).get()).<ResetPrimitive>map("getReset", _primitiveEvent -> _primitiveEvent.getReset()).<TradeState>map("getAfter", _resetPrimitive -> _resetPrimitive.getAfter());
				}
				else {
					return MapperS.ofNull();
				}
		}).get())
		;
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(BusinessEvent event);
	
	
	protected Mapper<? extends PrimitiveEvent> primitive(BusinessEvent event) {
		return MapperS.of(MapperS.of(event).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).get());
	}
	public static final class ExtractTradeStateDefault extends ExtractTradeState {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(BusinessEvent event) {
			return TradeState.builder();
		}
	}
}
