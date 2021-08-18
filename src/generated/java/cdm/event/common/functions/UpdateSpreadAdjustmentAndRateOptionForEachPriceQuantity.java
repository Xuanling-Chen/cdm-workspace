package cdm.event.common.functions;

import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantity.UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantityDefault.class)
public abstract class UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState Specifies the trade to be updated.
	* @param instructionPriceQuantity List of PriceQuantity from the IndexTransitionInstruction (e.g. one for each floating rate leg).
	* @return updatedTradeState Specifies the updated trade.
	*/
	public TradeState evaluate(TradeState tradeState, List<? extends PriceQuantity> instructionPriceQuantity) {
		
		TradeState.TradeStateBuilder updatedTradeStateHolder = doEvaluate(tradeState, instructionPriceQuantity);
		TradeState.TradeStateBuilder updatedTradeState = assignOutput(updatedTradeStateHolder, tradeState, instructionPriceQuantity);
		
		if (updatedTradeState!=null) objectValidator.validateAndFailOnErorr(TradeState.class, updatedTradeState);
		return updatedTradeState;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder updatedTradeState, TradeState tradeState, List<? extends PriceQuantity> instructionPriceQuantity) {
		return updatedTradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, List<? extends PriceQuantity> instructionPriceQuantity);
	
	public static final class UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantityDefault extends UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantity {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, List<? extends PriceQuantity> instructionPriceQuantity) {
			return TradeState.builder();
		}
	}
}
