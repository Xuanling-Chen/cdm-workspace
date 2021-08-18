package cdm.base.math.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(DeductAmountForEachMatchingQuantity.DeductAmountForEachMatchingQuantityDefault.class)
public abstract class DeductAmountForEachMatchingQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantity List of quantities to update.
	* @param quantityDeducted The quantities to be deducted from the quantity input.
	* @return updatedQuantity List of  quantities with quantity amounts updated.
	*/
	public List<? extends Quantity> evaluate(List<? extends Quantity> quantity, List<? extends Quantity> quantityDeducted) {
		
		List<Quantity.QuantityBuilder> updatedQuantityHolder = doEvaluate(quantity, quantityDeducted);
		List<Quantity.QuantityBuilder> updatedQuantity = assignOutput(updatedQuantityHolder, quantity, quantityDeducted);
		
		if (updatedQuantity!=null) objectValidator.validateAndFailOnErorr(Quantity.class, updatedQuantity);
		return updatedQuantity;
	}
	
	private List<Quantity.QuantityBuilder> assignOutput(List<Quantity.QuantityBuilder> updatedQuantity, List<? extends Quantity> quantity, List<? extends Quantity> quantityDeducted) {
		return updatedQuantity;
	}

	protected abstract List<Quantity.QuantityBuilder> doEvaluate(List<? extends Quantity> quantity, List<? extends Quantity> quantityDeducted);
	
	public static final class DeductAmountForEachMatchingQuantityDefault extends DeductAmountForEachMatchingQuantity {
		@Override
		protected  List<Quantity.QuantityBuilder> doEvaluate(List<? extends Quantity> quantity, List<? extends Quantity> quantityDeducted) {
			return Arrays.asList();
		}
	}
}
