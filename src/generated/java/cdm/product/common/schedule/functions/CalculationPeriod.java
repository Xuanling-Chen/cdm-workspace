package cdm.product.common.schedule.functions;

import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodData.CalculationPeriodDataBuilder;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(CalculationPeriod.CalculationPeriodDefault.class)
public abstract class CalculationPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param calculationPeriodDates 
	* @param date 
	* @return result 
	*/
	public CalculationPeriodData evaluate(CalculationPeriodDates calculationPeriodDates, Date date) {
		
		CalculationPeriodData.CalculationPeriodDataBuilder resultHolder = doEvaluate(calculationPeriodDates, date);
		CalculationPeriodData.CalculationPeriodDataBuilder result = assignOutput(resultHolder, calculationPeriodDates, date);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(CalculationPeriodData.class, result);
		return result;
	}
	
	private CalculationPeriodData.CalculationPeriodDataBuilder assignOutput(CalculationPeriodData.CalculationPeriodDataBuilder result, CalculationPeriodDates calculationPeriodDates, Date date) {
		return result;
	}

	protected abstract CalculationPeriodData.CalculationPeriodDataBuilder doEvaluate(CalculationPeriodDates calculationPeriodDates, Date date);
	
	public static final class CalculationPeriodDefault extends CalculationPeriod {
		@Override
		protected  CalculationPeriodData.CalculationPeriodDataBuilder doEvaluate(CalculationPeriodDates calculationPeriodDates, Date date) {
			return CalculationPeriodData.builder();
		}
	}
}
