package cdm.legalagreement.csa.functions;

import cdm.legalagreement.csa.PostedCreditSupportItem;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(SumPostedCreditSupportItemAmounts.SumPostedCreditSupportItemAmountsDefault.class)
public abstract class SumPostedCreditSupportItemAmounts implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param postedCreditSupportItems 
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, String baseCurrency) {
		
		Money.MoneyBuilder resultHolder = doEvaluate(postedCreditSupportItems, baseCurrency);
		Money.MoneyBuilder result = assignOutput(resultHolder, postedCreditSupportItems, baseCurrency);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Money.class, result);
		return result;
	}
	
	private Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, List<? extends PostedCreditSupportItem> postedCreditSupportItems, String baseCurrency) {
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, String baseCurrency);
	
	public static final class SumPostedCreditSupportItemAmountsDefault extends SumPostedCreditSupportItemAmounts {
		@Override
		protected  Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, String baseCurrency) {
			return Money.builder();
		}
	}
}
