package cdm.event.common.functions;

import cdm.event.common.ContractState;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(TradeStateFromContractState.TradeStateFromContractStateDefault.class)
public abstract class TradeStateFromContractState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param contractState 
	* @return tradeState 
	*/
	public TradeState evaluate(ContractState contractState) {
		
		TradeState.TradeStateBuilder tradeStateHolder = doEvaluate(contractState);
		TradeState.TradeStateBuilder tradeState = assignOutput(tradeStateHolder, contractState);
		
		if (tradeState!=null) objectValidator.validateAndFailOnErorr(TradeState.class, tradeState);
		return tradeState;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, ContractState contractState) {
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(ContractState contractState);
	
	public static final class TradeStateFromContractStateDefault extends TradeStateFromContractState {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(ContractState contractState) {
			return TradeState.builder();
		}
	}
}
