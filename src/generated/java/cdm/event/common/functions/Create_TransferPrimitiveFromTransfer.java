package cdm.event.common.functions;

import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.TransferPrimitive.TransferPrimitiveBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_TransferPrimitiveFromTransfer.Create_TransferPrimitiveFromTransferDefault.class)
public abstract class Create_TransferPrimitiveFromTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @param transfer 
	* @return transferPrimitive 
	*/
	public TransferPrimitive evaluate(TradeState tradeState, Transfer transfer) {
		
		TransferPrimitive.TransferPrimitiveBuilder transferPrimitiveHolder = doEvaluate(tradeState, transfer);
		TransferPrimitive.TransferPrimitiveBuilder transferPrimitive = assignOutput(transferPrimitiveHolder, tradeState, transfer);
		
		if (transferPrimitive!=null) objectValidator.validateAndFailOnErorr(TransferPrimitive.class, transferPrimitive);
		return transferPrimitive;
	}
	
	private TransferPrimitive.TransferPrimitiveBuilder assignOutput(TransferPrimitive.TransferPrimitiveBuilder transferPrimitive, TradeState tradeState, Transfer transfer) {
		transferPrimitive
			.setAfter(MapperS.of(tradeState).get())
		;
		transferPrimitive
			.getOrCreateAfter()
			.addTransferHistory(MapperS.of(transfer).get())
		;
		transferPrimitive
			.setBeforeValue(MapperS.of(tradeState).get())
		;
		return transferPrimitive;
	}

	protected abstract TransferPrimitive.TransferPrimitiveBuilder doEvaluate(TradeState tradeState, Transfer transfer);
	
	public static final class Create_TransferPrimitiveFromTransferDefault extends Create_TransferPrimitiveFromTransfer {
		@Override
		protected  TransferPrimitive.TransferPrimitiveBuilder doEvaluate(TradeState tradeState, Transfer transfer) {
			return TransferPrimitive.builder();
		}
	}
}
