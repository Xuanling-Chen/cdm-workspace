package cdm.base.math.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterQuantity.FilterQuantityDefault.class)
public abstract class FilterQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantities List of quantities to filter.
	* @param currency Currency unit type.
	* @return quantity 
	*/
	public Quantity evaluate(List<? extends Quantity> quantities, String currency) {
		
		Quantity.QuantityBuilder quantityHolder = doEvaluate(quantities, currency);
		Quantity.QuantityBuilder quantity = assignOutput(quantityHolder, quantities, currency);
		
		if (quantity!=null) objectValidator.validateAndFailOnErorr(Quantity.class, quantity);
		return quantity;
	}
	
	private Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder quantity, List<? extends Quantity> quantities, String currency) {
		return quantity;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(List<? extends Quantity> quantities, String currency);
	
	public static final class FilterQuantityDefault extends FilterQuantity {
		@Override
		protected  Quantity.QuantityBuilder doEvaluate(List<? extends Quantity> quantities, String currency) {
			return Quantity.builder();
		}
	}
}
