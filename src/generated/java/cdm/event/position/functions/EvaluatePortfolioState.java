package cdm.event.position.functions;

import cdm.event.position.Portfolio;
import cdm.event.position.PortfolioState;
import cdm.event.position.PortfolioState.PortfolioStateBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(EvaluatePortfolioState.EvaluatePortfolioStateDefault.class)
public abstract class EvaluatePortfolioState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param portfolio Portfolio containing the aggregation parameters to be used to calculate the new portfolio state.
	* @return portfolioState Portfolio state containing the aggregated positions based on the input aggregation parameters.
	*/
	public PortfolioState evaluate(Portfolio portfolio) {
		
		PortfolioState.PortfolioStateBuilder portfolioStateHolder = doEvaluate(portfolio);
		PortfolioState.PortfolioStateBuilder portfolioState = assignOutput(portfolioStateHolder, portfolio);
		
		if (portfolioState!=null) objectValidator.validateAndFailOnErorr(PortfolioState.class, portfolioState);
		return portfolioState;
	}
	
	private PortfolioState.PortfolioStateBuilder assignOutput(PortfolioState.PortfolioStateBuilder portfolioState, Portfolio portfolio) {
		return portfolioState;
	}

	protected abstract PortfolioState.PortfolioStateBuilder doEvaluate(Portfolio portfolio);
	
	public static final class EvaluatePortfolioStateDefault extends EvaluatePortfolioState {
		@Override
		protected  PortfolioState.PortfolioStateBuilder doEvaluate(Portfolio portfolio) {
			return PortfolioState.builder();
		}
	}
}
