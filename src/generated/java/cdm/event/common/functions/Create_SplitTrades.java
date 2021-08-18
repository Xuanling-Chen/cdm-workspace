package cdm.event.common.functions;

import cdm.event.common.AllocationBreakdown;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_SplitTrades.Create_SplitTradesDefault.class)
public abstract class Create_SplitTrades implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trade Block execution to be split.
	* @param breakdowns Split instructions to be applied.
	* @return splitOutcome 
	*/
	public List<? extends TradeState> evaluate(TradeState trade, List<? extends AllocationBreakdown> breakdowns) {
		
		List<TradeState.TradeStateBuilder> splitOutcomeHolder = doEvaluate(trade, breakdowns);
		List<TradeState.TradeStateBuilder> splitOutcome = assignOutput(splitOutcomeHolder, trade, breakdowns);
		
		if (splitOutcome!=null) objectValidator.validateAndFailOnErorr(TradeState.class, splitOutcome);
		return splitOutcome;
	}
	
	private List<TradeState.TradeStateBuilder> assignOutput(List<TradeState.TradeStateBuilder> splitOutcome, TradeState trade, List<? extends AllocationBreakdown> breakdowns) {
		return splitOutcome;
	}

	protected abstract List<TradeState.TradeStateBuilder> doEvaluate(TradeState trade, List<? extends AllocationBreakdown> breakdowns);
	
	public static final class Create_SplitTradesDefault extends Create_SplitTrades {
		@Override
		protected  List<TradeState.TradeStateBuilder> doEvaluate(TradeState trade, List<? extends AllocationBreakdown> breakdowns) {
			return Arrays.asList();
		}
	}
}
