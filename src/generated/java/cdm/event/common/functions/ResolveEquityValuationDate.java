package cdm.event.common.functions;

import cdm.observable.asset.EquityValuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(ResolveEquityValuationDate.ResolveEquityValuationDateDefault.class)
public abstract class ResolveEquityValuationDate implements RosettaFunction {

	/**
	* @param equityValuation Represents the Equity Valuation terms from the Equity product definition.
	* @param date Specifies the date, which is a proxy for the period, for which the valuation date should be resolved.
	* @return valuationDate 
	*/
	public Date evaluate(EquityValuation equityValuation, Date date) {
		
		Date valuationDateHolder = doEvaluate(equityValuation, date);
		Date valuationDate = assignOutput(valuationDateHolder, equityValuation, date);
		
		return valuationDate;
	}
	
	private Date assignOutput(Date valuationDate, EquityValuation equityValuation, Date date) {
		return valuationDate;
	}

	protected abstract Date doEvaluate(EquityValuation equityValuation, Date date);
	
	public static final class ResolveEquityValuationDateDefault extends ResolveEquityValuationDate {
		@Override
		protected  Date doEvaluate(EquityValuation equityValuation, Date date) {
			return null;
		}
	}
}
