package cdm.event.common.functions;

import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferInstruction.TransferInstructionBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(SecurityTransferInstruction.SecurityTransferInstructionDefault.class)
public abstract class SecurityTransferInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @return instruction 
	*/
	public TransferInstruction evaluate(TradeState tradeState) {
		
		TransferInstruction.TransferInstructionBuilder instructionHolder = doEvaluate(tradeState);
		TransferInstruction.TransferInstructionBuilder instruction = assignOutput(instructionHolder, tradeState);
		
		if (instruction!=null) objectValidator.validateAndFailOnErorr(TransferInstruction.class, instruction);
		return instruction;
	}
	
	private TransferInstruction.TransferInstructionBuilder assignOutput(TransferInstruction.TransferInstructionBuilder instruction, TradeState tradeState) {
		return instruction;
	}

	protected abstract TransferInstruction.TransferInstructionBuilder doEvaluate(TradeState tradeState);
	
	public static final class SecurityTransferInstructionDefault extends SecurityTransferInstruction {
		@Override
		protected  TransferInstruction.TransferInstructionBuilder doEvaluate(TradeState tradeState) {
			return TransferInstruction.builder();
		}
	}
}
