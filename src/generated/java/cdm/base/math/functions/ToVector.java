package cdm.base.math.functions;

import cdm.base.math.Vector;
import cdm.base.math.Vector.VectorBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ToVector.ToVectorDefault.class)
public abstract class ToVector implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param vals 
	* @return vect 
	*/
	public Vector evaluate(List<? extends BigDecimal> vals) {
		
		Vector.VectorBuilder vectHolder = doEvaluate(vals);
		Vector.VectorBuilder vect = assignOutput(vectHolder, vals);
		
		if (vect!=null) objectValidator.validateAndFailOnErorr(Vector.class, vect);
		return vect;
	}
	
	private Vector.VectorBuilder assignOutput(Vector.VectorBuilder vect, List<? extends BigDecimal> vals) {
		vect
			.addValues(MapperC.of(vals).getMulti())
		;
		return vect;
	}

	protected abstract Vector.VectorBuilder doEvaluate(List<? extends BigDecimal> vals);
	
	public static final class ToVectorDefault extends ToVector {
		@Override
		protected  Vector.VectorBuilder doEvaluate(List<? extends BigDecimal> vals) {
			return Vector.builder();
		}
	}
}
