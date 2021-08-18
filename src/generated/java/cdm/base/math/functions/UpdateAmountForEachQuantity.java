package cdm.base.math.functions;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(UpdateAmountForEachQuantity.UpdateAmountForEachQuantityDefault.class)
public abstract class UpdateAmountForEachQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity List of price quantities to update.
	* @param amount The new amount.
	* @return updatedPriceQuantity List of price quantities with all quantity amounts updated.
	*/
	public List<? extends PriceQuantity> evaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal amount) {
		
		List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantityHolder = doEvaluate(priceQuantity, amount);
		List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity = assignOutput(updatedPriceQuantityHolder, priceQuantity, amount);
		
		if (updatedPriceQuantity!=null) objectValidator.validateAndFailOnErorr(PriceQuantity.class, updatedPriceQuantity);
		return updatedPriceQuantity;
	}
	
	private List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity, List<? extends PriceQuantity> priceQuantity, BigDecimal amount) {
		return updatedPriceQuantity;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal amount);
	
	public static final class UpdateAmountForEachQuantityDefault extends UpdateAmountForEachQuantity {
		@Override
		protected  List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal amount) {
			return Arrays.asList();
		}
	}
}
