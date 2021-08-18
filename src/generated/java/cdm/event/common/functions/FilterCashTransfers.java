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


@ImplementedBy(FilterCashTransfers.FilterCashTransfersDefault.class)
public abstract class FilterCashTransfers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transfers 
	* @return cashTransfers 
	*/
	public Transfers evaluate(List<? extends Transfer> transfers) {
		
		Transfers.TransfersBuilder cashTransfersHolder = doEvaluate(transfers);
		Transfers.TransfersBuilder cashTransfers = assignOutput(cashTransfersHolder, transfers);
		
		if (cashTransfers!=null) objectValidator.validateAndFailOnErorr(Transfers.class, cashTransfers);
		return cashTransfers;
	}
	
	private Transfers.TransfersBuilder assignOutput(Transfers.TransfersBuilder cashTransfers, List<? extends Transfer> transfers) {
		return cashTransfers;
	}

	protected abstract Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers);
	
	public static final class FilterCashTransfersDefault extends FilterCashTransfers {
		@Override
		protected  Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers) {
			return Transfers.builder();
		}
	}
}
