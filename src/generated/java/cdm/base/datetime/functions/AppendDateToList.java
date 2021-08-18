package cdm.base.datetime.functions;

import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(AppendDateToList.AppendDateToListDefault.class)
public abstract class AppendDateToList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param origDates list of dates
	* @param newDate Date to add to the list
	* @return newList The newly increased list
	*/
	public DateGroup evaluate(DateGroup origDates, Date newDate) {
		
		DateGroup.DateGroupBuilder newListHolder = doEvaluate(origDates, newDate);
		DateGroup.DateGroupBuilder newList = assignOutput(newListHolder, origDates, newDate);
		
		if (newList!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, newList);
		return newList;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder newList, DateGroup origDates, Date newDate) {
		return newList;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(DateGroup origDates, Date newDate);
	
	public static final class AppendDateToListDefault extends AppendDateToList {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(DateGroup origDates, Date newDate) {
			return DateGroup.builder();
		}
	}
}
