package cdm.base.math.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterQuantityByFinancialUnit.FilterQuantityByFinancialUnitDefault.class)
public abstract class FilterQuantityByFinancialUnit implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantities List of quantities to filter.
	* @param financialUnit FinancialUnitEnum unit type.
	* @return quantity 
	*/
	public Quantity evaluate(List<? extends Quantity> quantities, FinancialUnitEnum financialUnit) {
		
		Quantity.QuantityBuilder quantityHolder = doEvaluate(quantities, financialUnit);
		Quantity.QuantityBuilder quantity = assignOutput(quantityHolder, quantities, financialUnit);
		
		if (quantity!=null) objectValidator.validateAndFailOnErorr(Quantity.class, quantity);
		return quantity;
	}
	
	private Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder quantity, List<? extends Quantity> quantities, FinancialUnitEnum financialUnit) {
		return quantity;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(List<? extends Quantity> quantities, FinancialUnitEnum financialUnit);
	
	public static final class FilterQuantityByFinancialUnitDefault extends FilterQuantityByFinancialUnit {
		@Override
		protected  Quantity.QuantityBuilder doEvaluate(List<? extends Quantity> quantities, FinancialUnitEnum financialUnit) {
			return Quantity.builder();
		}
	}
}
