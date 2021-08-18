package cdm.base.math.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(Create_Quantity.Create_QuantityDefault.class)
public abstract class Create_Quantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param amount 
	* @param unitOfAmount 
	* @return quantity 
	*/
	public Quantity evaluate(BigDecimal amount, UnitType unitOfAmount) {
		
		Quantity.QuantityBuilder quantityHolder = doEvaluate(amount, unitOfAmount);
		Quantity.QuantityBuilder quantity = assignOutput(quantityHolder, amount, unitOfAmount);
		
		if (quantity!=null) objectValidator.validateAndFailOnErorr(Quantity.class, quantity);
		return quantity;
	}
	
	private Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder quantity, BigDecimal amount, UnitType unitOfAmount) {
		quantity
			.setAmount(MapperS.of(amount).get())
		;
		quantity
			.setUnitOfAmount(MapperS.of(unitOfAmount).get())
		;
		return quantity;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(BigDecimal amount, UnitType unitOfAmount);
	
	public static final class Create_QuantityDefault extends Create_Quantity {
		@Override
		protected  Quantity.QuantityBuilder doEvaluate(BigDecimal amount, UnitType unitOfAmount) {
			return Quantity.builder();
		}
	}
}
