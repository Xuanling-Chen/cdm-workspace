package cdm.event.common.functions;

import cdm.legalagreement.master.EquitySwapMasterConfirmation2018;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout.InterestRatePayoutBuilder;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(NewFloatingPayout.NewFloatingPayoutDefault.class)
public abstract class NewFloatingPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param masterConfirmation 
	* @return interestRatePayout 
	*/
	public InterestRatePayout evaluate(EquitySwapMasterConfirmation2018 masterConfirmation) {
		
		InterestRatePayout.InterestRatePayoutBuilder interestRatePayoutHolder = doEvaluate(masterConfirmation);
		InterestRatePayout.InterestRatePayoutBuilder interestRatePayout = assignOutput(interestRatePayoutHolder, masterConfirmation);
		
		// post-conditions

		assert
			com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(masterConfirmation)).get()) {
						return areEqual(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()), MapperS.of(masterConfirmation).<CalculationPeriodDates>map("getEquityCalculationPeriod", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getEquityCalculationPeriod()), CardinalityOperator.All).and(areEqual(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()), MapperS.of(masterConfirmation).<PaymentDates>map("getEquityCashSettlementDates", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getEquityCashSettlementDates()), CardinalityOperator.All));
					}
			else {
						return MapperS.ofNull();
					}
			})).get()
			: "Interest rate payout must inherit terms from the Master Confirmation Agreement when it exists.";
		if (interestRatePayout!=null) objectValidator.validateAndFailOnErorr(InterestRatePayout.class, interestRatePayout);
		return interestRatePayout;
	}
	
	private InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRatePayout, EquitySwapMasterConfirmation2018 masterConfirmation) {
		return interestRatePayout;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(EquitySwapMasterConfirmation2018 masterConfirmation);
	
	public static final class NewFloatingPayoutDefault extends NewFloatingPayout {
		@Override
		protected  InterestRatePayout.InterestRatePayoutBuilder doEvaluate(EquitySwapMasterConfirmation2018 masterConfirmation) {
			return InterestRatePayout.builder();
		}
	}
}
