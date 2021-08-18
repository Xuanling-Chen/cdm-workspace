package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import cdm.base.datetime.functions.AddBusinessDays;
import cdm.base.datetime.functions.AppendDateToList;
import cdm.base.datetime.functions.IsBusinessDay;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GenerateDateList.GenerateDateListDefault.class)
public abstract class GenerateDateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AddBusinessDays addBusinessDays;
	@Inject protected AppendDateToList appendDateToList;
	@Inject protected cdm.base.datetime.functions.GenerateDateList generateDateList;
	@Inject protected IsBusinessDay isBusinessDay;

	/**
	* @param startDate Start of the date range to be generated
	* @param endDate End of the date range to be generated
	* @param businessCenters business centers to be used to generate the list of good business days
	* @return dateList  resulting list of good business days
	*/
	public DateGroup evaluate(Date startDate, Date endDate, BusinessCenters businessCenters) {
		
		DateGroup.DateGroupBuilder dateListHolder = doEvaluate(startDate, endDate, businessCenters);
		DateGroup.DateGroupBuilder dateList = assignOutput(dateListHolder, startDate, endDate, businessCenters);
		
		if (dateList!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, dateList);
		return dateList;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder dateList, Date startDate, Date endDate, BusinessCenters businessCenters) {
		dateList = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(active(startDate, endDate, businessCenters).get()).get()) {
					return MapperS.of(newList(startDate, endDate, businessCenters).get());
				}
		else {
					return MapperS.ofNull();
				}
		}).get())
		;
		return dateList;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(Date startDate, Date endDate, BusinessCenters businessCenters);
	
	
	protected Mapper<Boolean> active(Date startDate, Date endDate, BusinessCenters businessCenters) {
		return lessThanEquals(MapperS.of(startDate), MapperS.of(endDate), CardinalityOperator.All);
	}
	
	protected Mapper<Boolean> isGoodBusinessDay(Date startDate, Date endDate, BusinessCenters businessCenters) {
		return MapperS.of(isBusinessDay.evaluate(MapperS.of(endDate).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<Date> priorDate(Date startDate, Date endDate, BusinessCenters businessCenters) {
		return MapperS.of(addBusinessDays.evaluate(MapperS.of(endDate).get(), MapperS.of(Integer.valueOf(-1)).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<? extends DateGroup> priorList(Date startDate, Date endDate, BusinessCenters businessCenters) {
		return MapperS.of(generateDateList.evaluate(MapperS.of(startDate).get(), MapperS.of(priorDate(startDate, endDate, businessCenters).get()).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<? extends DateGroup> newList(Date startDate, Date endDate, BusinessCenters businessCenters) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(isGoodBusinessDay(startDate, endDate, businessCenters).get()).get()) {
					return MapperS.of(appendDateToList.evaluate(MapperS.of(priorList(startDate, endDate, businessCenters).get()).get(), MapperS.of(endDate).get()));
				}
		else {
					return MapperS.of(priorList(startDate, endDate, businessCenters).get());
				}
		});
	}
	public static final class GenerateDateListDefault extends GenerateDateList {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(Date startDate, Date endDate, BusinessCenters businessCenters) {
			return DateGroup.builder();
		}
	}
}
