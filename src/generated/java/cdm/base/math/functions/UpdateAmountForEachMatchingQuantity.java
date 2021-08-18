package cdm.base.math.functions;

import cdm.base.math.Quantity;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(UpdateAmountForEachMatchingQuantity.UpdateAmountForEachMatchingQuantityDefault.class)
public abstract class UpdateAmountForEachMatchingQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity List of price quantities to update.
	* @param quantity The new quantities.
	* @return updatedPriceQuantity List of price quantities with quantity amounts updated.
	*/
	public List<? extends PriceQuantity> evaluate(List<? extends PriceQuantity> priceQuantity, List<? extends Quantity> quantity) {
		
		List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantityHolder = doEvaluate(priceQuantity, quantity);
		List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity = assignOutput(updatedPriceQuantityHolder, priceQuantity, quantity);
		
		if (updatedPriceQuantity!=null) objectValidator.validateAndFailOnErorr(PriceQuantity.class, updatedPriceQuantity);
		return updatedPriceQuantity;
	}
	
	private List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> updatedPriceQuantity, List<? extends PriceQuantity> priceQuantity, List<? extends Quantity> quantity) {
		return updatedPriceQuantity;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantity, List<? extends Quantity> quantity);
	
	public static final class UpdateAmountForEachMatchingQuantityDefault extends UpdateAmountForEachMatchingQuantity {
		@Override
		protected  List<PriceQuantity.PriceQuantityBuilder> doEvaluate(List<? extends PriceQuantity> priceQuantity, List<? extends Quantity> quantity) {
			return Arrays.asList();
		}
	}
}
