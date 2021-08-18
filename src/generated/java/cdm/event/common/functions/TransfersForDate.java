package cdm.event.common.functions;

import cdm.event.common.Transfer;
import cdm.event.common.Transfers;
import cdm.event.common.Transfers.TransfersBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(TransfersForDate.TransfersForDateDefault.class)
public abstract class TransfersForDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transfers 
	* @param date 
	* @return transfersForDate 
	*/
	public Transfers evaluate(List<? extends Transfer> transfers, Date date) {
		
		Transfers.TransfersBuilder transfersForDateHolder = doEvaluate(transfers, date);
		Transfers.TransfersBuilder transfersForDate = assignOutput(transfersForDateHolder, transfers, date);
		
		if (transfersForDate!=null) objectValidator.validateAndFailOnErorr(Transfers.class, transfersForDate);
		return transfersForDate;
	}
	
	private Transfers.TransfersBuilder assignOutput(Transfers.TransfersBuilder transfersForDate, List<? extends Transfer> transfers, Date date) {
		return transfersForDate;
	}

	protected abstract Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers, Date date);
	
	public static final class TransfersForDateDefault extends TransfersForDate {
		@Override
		protected  Transfers.TransfersBuilder doEvaluate(List<? extends Transfer> transfers, Date date) {
			return Transfers.builder();
		}
	}
}
