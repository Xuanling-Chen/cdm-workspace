package cdm.base.math.functions;

import cdm.base.math.CompareOp;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ListsCompare.ListsCompareDefault.class)
public abstract class ListsCompare implements RosettaFunction {

	/**
	* @param compareOp 
	* @param left 
	* @param right 
	* @param rightNumber 
	* @return result 
	*/
	public Boolean evaluate(CompareOp compareOp, List<? extends BigDecimal> left, List<? extends BigDecimal> right, BigDecimal rightNumber) {
		
		Boolean resultHolder = doEvaluate(compareOp, left, right, rightNumber);
		Boolean result = assignOutput(resultHolder, compareOp, left, right, rightNumber);
		
		return result;
	}
	
	private Boolean assignOutput(Boolean result, CompareOp compareOp, List<? extends BigDecimal> left, List<? extends BigDecimal> right, BigDecimal rightNumber) {
		return result;
	}

	protected abstract Boolean doEvaluate(CompareOp compareOp, List<? extends BigDecimal> left, List<? extends BigDecimal> right, BigDecimal rightNumber);
	
	public static final class ListsCompareDefault extends ListsCompare {
		@Override
		protected  Boolean doEvaluate(CompareOp compareOp, List<? extends BigDecimal> left, List<? extends BigDecimal> right, BigDecimal rightNumber) {
			return null;
		}
	}
}
