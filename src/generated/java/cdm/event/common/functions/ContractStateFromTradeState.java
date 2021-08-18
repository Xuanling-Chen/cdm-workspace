package cdm.event.common.functions;

import cdm.event.common.ContractState;
import cdm.event.common.ContractState.ContractStateBuilder;
import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ContractStateFromTradeState.ContractStateFromTradeStateDefault.class)
public abstract class ContractStateFromTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param contractState 
	* @return tradeState 
	*/
	public ContractState evaluate(TradeState contractState) {
		
		ContractState.ContractStateBuilder tradeStateHolder = doEvaluate(contractState);
		ContractState.ContractStateBuilder tradeState = assignOutput(tradeStateHolder, contractState);
		
		if (tradeState!=null) objectValidator.validateAndFailOnErorr(ContractState.class, tradeState);
		return tradeState;
	}
	
	private ContractState.ContractStateBuilder assignOutput(ContractState.ContractStateBuilder tradeState, TradeState contractState) {
		return tradeState;
	}

	protected abstract ContractState.ContractStateBuilder doEvaluate(TradeState contractState);
	
	public static final class ContractStateFromTradeStateDefault extends ContractStateFromTradeState {
		@Override
		protected  ContractState.ContractStateBuilder doEvaluate(TradeState contractState) {
			return ContractState.builder();
		}
	}
}
