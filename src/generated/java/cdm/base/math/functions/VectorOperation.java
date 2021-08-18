package cdm.base.math.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.Vector;
import cdm.base.math.Vector.VectorBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(VectorOperation.VectorOperationDefault.class)
public abstract class VectorOperation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param arithmeticOp operator
	* @param left left vector
	* @param right right vector
	* @return result result vector
	*/
	public Vector evaluate(ArithmeticOperationEnum arithmeticOp, Vector left, Vector right) {
		
		Vector.VectorBuilder resultHolder = doEvaluate(arithmeticOp, left, right);
		Vector.VectorBuilder result = assignOutput(resultHolder, arithmeticOp, left, right);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Vector.class, result);
		return result;
	}
	
	private Vector.VectorBuilder assignOutput(Vector.VectorBuilder result, ArithmeticOperationEnum arithmeticOp, Vector left, Vector right) {
		return result;
	}

	protected abstract Vector.VectorBuilder doEvaluate(ArithmeticOperationEnum arithmeticOp, Vector left, Vector right);
	
	public static final class VectorOperationDefault extends VectorOperation {
		@Override
		protected  Vector.VectorBuilder doEvaluate(ArithmeticOperationEnum arithmeticOp, Vector left, Vector right) {
			return Vector.builder();
		}
	}
}
