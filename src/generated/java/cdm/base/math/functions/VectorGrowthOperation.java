package cdm.base.math.functions;

import cdm.base.math.Vector;
import cdm.base.math.Vector.VectorBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(VectorGrowthOperation.VectorGrowthOperationDefault.class)
public abstract class VectorGrowthOperation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param baseValue original value, typically 1.0
	* @param factor vector of growth factions, which are all typically slightly greater than 1.0
	* @return result result vector, showing all of the interim growth values
	*/
	public Vector evaluate(BigDecimal baseValue, Vector factor) {
		
		Vector.VectorBuilder resultHolder = doEvaluate(baseValue, factor);
		Vector.VectorBuilder result = assignOutput(resultHolder, baseValue, factor);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Vector.class, result);
		return result;
	}
	
	private Vector.VectorBuilder assignOutput(Vector.VectorBuilder result, BigDecimal baseValue, Vector factor) {
		return result;
	}

	protected abstract Vector.VectorBuilder doEvaluate(BigDecimal baseValue, Vector factor);
	
	public static final class VectorGrowthOperationDefault extends VectorGrowthOperation {
		@Override
		protected  Vector.VectorBuilder doEvaluate(BigDecimal baseValue, Vector factor) {
			return Vector.builder();
		}
	}
}
