package cdm.product.asset.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout.InterestRatePayoutBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ExtractFixedLeg.ExtractFixedLegDefault.class)
public abstract class ExtractFixedLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param interestRatePayouts 
	* @return fixedRatePayout 
	*/
	public InterestRatePayout evaluate(List<? extends InterestRatePayout> interestRatePayouts) {
		
		InterestRatePayout.InterestRatePayoutBuilder fixedRatePayoutHolder = doEvaluate(interestRatePayouts);
		InterestRatePayout.InterestRatePayoutBuilder fixedRatePayout = assignOutput(fixedRatePayoutHolder, interestRatePayouts);
		
		if (fixedRatePayout!=null) objectValidator.validateAndFailOnErorr(InterestRatePayout.class, fixedRatePayout);
		return fixedRatePayout;
	}
	
	private InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder fixedRatePayout, List<? extends InterestRatePayout> interestRatePayouts) {
		return fixedRatePayout;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(List<? extends InterestRatePayout> interestRatePayouts);
	
	public static final class ExtractFixedLegDefault extends ExtractFixedLeg {
		@Override
		protected  InterestRatePayout.InterestRatePayoutBuilder doEvaluate(List<? extends InterestRatePayout> interestRatePayouts) {
			return InterestRatePayout.builder();
		}
	}
}
