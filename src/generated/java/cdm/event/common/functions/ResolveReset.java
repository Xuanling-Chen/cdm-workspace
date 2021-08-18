package cdm.event.common.functions;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.event.common.TradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ResolveReset.ResolveResetDefault.class)
public abstract class ResolveReset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @param date 
	* @return reset 
	*/
	public Reset evaluate(TradeState tradeState, Date date) {
		
		Reset.ResetBuilder resetHolder = doEvaluate(tradeState, date);
		Reset.ResetBuilder reset = assignOutput(resetHolder, tradeState, date);
		
		if (reset!=null) objectValidator.validateAndFailOnErorr(Reset.class, reset);
		return reset;
	}
	
	private Reset.ResetBuilder assignOutput(Reset.ResetBuilder reset, TradeState tradeState, Date date) {
		return reset;
	}

	protected abstract Reset.ResetBuilder doEvaluate(TradeState tradeState, Date date);
	
	public static final class ResolveResetDefault extends ResolveReset {
		@Override
		protected  Reset.ResetBuilder doEvaluate(TradeState tradeState, Date date) {
			return Reset.builder();
		}
	}
}
