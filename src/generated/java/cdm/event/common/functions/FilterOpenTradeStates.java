package cdm.event.common.functions;

import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterOpenTradeStates.FilterOpenTradeStatesDefault.class)
public abstract class FilterOpenTradeStates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeStates 
	* @return filteredTradeStates 
	*/
	public List<? extends TradeState> evaluate(List<? extends TradeState> tradeStates) {
		
		List<TradeState.TradeStateBuilder> filteredTradeStatesHolder = doEvaluate(tradeStates);
		List<TradeState.TradeStateBuilder> filteredTradeStates = assignOutput(filteredTradeStatesHolder, tradeStates);
		
		if (filteredTradeStates!=null) objectValidator.validateAndFailOnErorr(TradeState.class, filteredTradeStates);
		return filteredTradeStates;
	}
	
	private List<TradeState.TradeStateBuilder> assignOutput(List<TradeState.TradeStateBuilder> filteredTradeStates, List<? extends TradeState> tradeStates) {
		return filteredTradeStates;
	}

	protected abstract List<TradeState.TradeStateBuilder> doEvaluate(List<? extends TradeState> tradeStates);
	
	public static final class FilterOpenTradeStatesDefault extends FilterOpenTradeStates {
		@Override
		protected  List<TradeState.TradeStateBuilder> doEvaluate(List<? extends TradeState> tradeStates) {
			return Arrays.asList();
		}
	}
}
