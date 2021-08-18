package cdm.base.datetime.functions;

import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(PopOffDateList.PopOffDateListDefault.class)
public abstract class PopOffDateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param dates List of dates
	* @return newList The newly created list, omitting the last element of the original list
	*/
	public DateGroup evaluate(DateGroup dates) {
		
		DateGroup.DateGroupBuilder newListHolder = doEvaluate(dates);
		DateGroup.DateGroupBuilder newList = assignOutput(newListHolder, dates);
		
		if (newList!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, newList);
		return newList;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder newList, DateGroup dates) {
		return newList;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(DateGroup dates);
	
	public static final class PopOffDateListDefault extends PopOffDateList {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(DateGroup dates) {
			return DateGroup.builder();
		}
	}
}
