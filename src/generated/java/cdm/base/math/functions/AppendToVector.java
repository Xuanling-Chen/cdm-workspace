package cdm.base.math.functions;

import cdm.base.math.Vector;
import cdm.base.math.Vector.VectorBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(AppendToVector.AppendToVectorDefault.class)
public abstract class AppendToVector implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param vector input vector
	* @param value value to add to the vector
	* @return resultVector resulting vector
	*/
	public Vector evaluate(Vector vector, BigDecimal value) {
		
		Vector.VectorBuilder resultVectorHolder = doEvaluate(vector, value);
		Vector.VectorBuilder resultVector = assignOutput(resultVectorHolder, vector, value);
		
		if (resultVector!=null) objectValidator.validateAndFailOnErorr(Vector.class, resultVector);
		return resultVector;
	}
	
	private Vector.VectorBuilder assignOutput(Vector.VectorBuilder resultVector, Vector vector, BigDecimal value) {
		return resultVector;
	}

	protected abstract Vector.VectorBuilder doEvaluate(Vector vector, BigDecimal value);
	
	public static final class AppendToVectorDefault extends AppendToVector {
		@Override
		protected  Vector.VectorBuilder doEvaluate(Vector vector, BigDecimal value) {
			return Vector.builder();
		}
	}
}
