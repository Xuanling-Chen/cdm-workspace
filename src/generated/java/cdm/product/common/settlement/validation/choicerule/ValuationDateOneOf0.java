package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.ValuationDate;
import com.rosetta.model.lib.annotations.RosettaChoiceRule;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleFailure;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.LinkedList;
import java.util.List;

import static com.rosetta.model.lib.validation.ExistenceChecker.isSet;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Arrays.asList;

/**
 * @version ${project.version}
 */
@RosettaChoiceRule("ValuationDateOneOf0")
public class ValuationDateOneOf0 implements Validator<ValuationDate> {
	
	private static final String NAME = "ValuationDateOneOf0";
	
	@Override
	public ValidationResult<ValuationDate> validate(RosettaPath path, ValuationDate object) {
		List<String> choiceFieldNames = asList("singleValuationDate", "multipleValuationDates", "valuationDate", "fxFixingDate", "fxFixingSchedule");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSingleValuationDate())) populatedFieldNames.add("singleValuationDate");
		if (isSet(object.getMultipleValuationDates())) populatedFieldNames.add("multipleValuationDates");
		if (isSet(object.getValuationDate())) populatedFieldNames.add("valuationDate");
		if (isSet(object.getFxFixingDate())) populatedFieldNames.add("fxFixingDate");
		if (isSet(object.getFxFixingSchedule())) populatedFieldNames.add("fxFixingSchedule");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ValuationDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ValuationDate>(NAME, "ValuationDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
