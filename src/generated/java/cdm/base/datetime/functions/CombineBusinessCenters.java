package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessCenters.BusinessCentersBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(CombineBusinessCenters.CombineBusinessCentersDefault.class)
public abstract class CombineBusinessCenters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param list1 First list of business centers
	* @param list2 Second list of business centers
	* @return combinedList  resulting merged list of business centers
	*/
	public BusinessCenters evaluate(BusinessCenters list1, BusinessCenters list2) {
		
		BusinessCenters.BusinessCentersBuilder combinedListHolder = doEvaluate(list1, list2);
		BusinessCenters.BusinessCentersBuilder combinedList = assignOutput(combinedListHolder, list1, list2);
		
		if (combinedList!=null) objectValidator.validateAndFailOnErorr(BusinessCenters.class, combinedList);
		return combinedList;
	}
	
	private BusinessCenters.BusinessCentersBuilder assignOutput(BusinessCenters.BusinessCentersBuilder combinedList, BusinessCenters list1, BusinessCenters list2) {
		return combinedList;
	}

	protected abstract BusinessCenters.BusinessCentersBuilder doEvaluate(BusinessCenters list1, BusinessCenters list2);
	
	public static final class CombineBusinessCentersDefault extends CombineBusinessCenters {
		@Override
		protected  BusinessCenters.BusinessCentersBuilder doEvaluate(BusinessCenters list1, BusinessCenters list2) {
			return BusinessCenters.builder();
		}
	}
}
