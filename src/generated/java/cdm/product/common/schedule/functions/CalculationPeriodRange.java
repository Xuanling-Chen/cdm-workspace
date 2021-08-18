package cdm.product.common.schedule.functions;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodData.CalculationPeriodDataBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(CalculationPeriodRange.CalculationPeriodRangeDefault.class)
public abstract class CalculationPeriodRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param startDate 
	* @param endDate 
	* @param dateAdjustments 
	* @return result 
	*/
	public CalculationPeriodData evaluate(Date startDate, Date endDate, BusinessDayAdjustments dateAdjustments) {
		
		CalculationPeriodData.CalculationPeriodDataBuilder resultHolder = doEvaluate(startDate, endDate, dateAdjustments);
		CalculationPeriodData.CalculationPeriodDataBuilder result = assignOutput(resultHolder, startDate, endDate, dateAdjustments);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(CalculationPeriodData.class, result);
		return result;
	}
	
	private CalculationPeriodData.CalculationPeriodDataBuilder assignOutput(CalculationPeriodData.CalculationPeriodDataBuilder result, Date startDate, Date endDate, BusinessDayAdjustments dateAdjustments) {
		return result;
	}

	protected abstract CalculationPeriodData.CalculationPeriodDataBuilder doEvaluate(Date startDate, Date endDate, BusinessDayAdjustments dateAdjustments);
	
	public static final class CalculationPeriodRangeDefault extends CalculationPeriodRange {
		@Override
		protected  CalculationPeriodData.CalculationPeriodDataBuilder doEvaluate(Date startDate, Date endDate, BusinessDayAdjustments dateAdjustments) {
			return CalculationPeriodData.builder();
		}
	}
}
