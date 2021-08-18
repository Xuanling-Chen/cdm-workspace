package cdm.base.math.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.Vector;
import cdm.base.math.Vector.VectorBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(VectorScalarOperation.VectorScalarOperationDefault.class)
public abstract class VectorScalarOperation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param arithmeticOp operator
	* @param left left vector
	* @param right scalar number, single value applied to all elements of vector
	* @return result result vector
	*/
	public Vector evaluate(ArithmeticOperationEnum arithmeticOp, Vector left, BigDecimal right) {
		
		Vector.VectorBuilder resultHolder = doEvaluate(arithmeticOp, left, right);
		Vector.VectorBuilder result = assignOutput(resultHolder, arithmeticOp, left, right);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Vector.class, result);
		return result;
	}
	
	private Vector.VectorBuilder assignOutput(Vector.VectorBuilder result, ArithmeticOperationEnum arithmeticOp, Vector left, BigDecimal right) {
		return result;
	}

	protected abstract Vector.VectorBuilder doEvaluate(ArithmeticOperationEnum arithmeticOp, Vector left, BigDecimal right);
	
	public static final class VectorScalarOperationDefault extends VectorScalarOperation {
		@Override
		protected  Vector.VectorBuilder doEvaluate(ArithmeticOperationEnum arithmeticOp, Vector left, BigDecimal right) {
			return Vector.builder();
		}
	}
}
