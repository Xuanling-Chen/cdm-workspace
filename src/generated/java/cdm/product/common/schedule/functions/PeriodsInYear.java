package cdm.product.common.schedule.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Arrays;


@ImplementedBy(PeriodsInYear.PeriodsInYearDefault.class)
public abstract class PeriodsInYear implements RosettaFunction {

	/**
	* @param frequency 
	* @return numberOfPeriods 
	*/
	public Integer evaluate(CalculationPeriodFrequency frequency) {
		
		Integer numberOfPeriodsHolder = doEvaluate(frequency);
		Integer numberOfPeriods = assignOutput(numberOfPeriodsHolder, frequency);
		
		return numberOfPeriods;
	}
	
	private Integer assignOutput(Integer numberOfPeriods, CalculationPeriodFrequency frequency) {
		return numberOfPeriods;
	}

	protected abstract Integer doEvaluate(CalculationPeriodFrequency frequency);
	
	public static final class PeriodsInYearDefault extends PeriodsInYear {
		@Override
		protected  Integer doEvaluate(CalculationPeriodFrequency frequency) {
			return null;
		}
	}
}
