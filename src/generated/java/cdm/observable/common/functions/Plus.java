package cdm.observable.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Plus.PlusDefault.class)
public abstract class Plus implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param q1 
	* @param q2 
	* @return result 
	*/
	public Quantity evaluate(Quantity q1, Quantity q2) {
		
		Quantity.QuantityBuilder resultHolder = doEvaluate(q1, q2);
		Quantity.QuantityBuilder result = assignOutput(resultHolder, q1, q2);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Quantity.class, result);
		return result;
	}
	
	private Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder result, Quantity q1, Quantity q2) {
		return result;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(Quantity q1, Quantity q2);
	
	public static final class PlusDefault extends Plus {
		@Override
		protected  Quantity.QuantityBuilder doEvaluate(Quantity q1, Quantity q2) {
			return Quantity.builder();
		}
	}
}
