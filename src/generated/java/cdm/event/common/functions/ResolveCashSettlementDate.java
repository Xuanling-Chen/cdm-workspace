package cdm.event.common.functions;

import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(ResolveCashSettlementDate.ResolveCashSettlementDateDefault.class)
public abstract class ResolveCashSettlementDate implements RosettaFunction {

	/**
	* @param tradeState 
	* @return date 
	*/
	public Date evaluate(TradeState tradeState) {
		
		Date dateHolder = doEvaluate(tradeState);
		Date date = assignOutput(dateHolder, tradeState);
		
		return date;
	}
	
	private Date assignOutput(Date date, TradeState tradeState) {
		return date;
	}

	protected abstract Date doEvaluate(TradeState tradeState);
	
	public static final class ResolveCashSettlementDateDefault extends ResolveCashSettlementDate {
		@Override
		protected  Date doEvaluate(TradeState tradeState) {
			return null;
		}
	}
}
