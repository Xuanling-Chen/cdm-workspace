package cdm.event.common.functions;

import cdm.event.common.Transfer;
import cdm.event.common.Transfers;
import cdm.event.common.Transfers.TransfersBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(LatestTransfers.LatestTransfersDefault.class)
public abstract class LatestTransfers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transfers 
	* @return transfer 
	*/
	public Transfers evaluate(List<? extends Transfer> transfers) {
		
		Transfers.TransfersBuilder transferHolder = doEvaluate(transfers);
		Transfers.TransfersBuilder transfer = assignOutput(transferHolder, transfers);
		
		if (transfer!=null) objectValidator.validateAndFailOnErorr(Transfers.class, transfer);
		return transfer;
	}
	
	private Transfers.TransfersBuilder assignOutput(Transfers.TransfersBuilder transfer, List<? extends Transfer> transfers) {
		return transfer;
	}

	protected abstract Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers);
	
	public static final class LatestTransfersDefault extends LatestTransfers {
		@Override
		protected  Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers) {
			return Transfers.builder();
		}
	}
}
