package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.FxFixingDate;
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
@RosettaChoiceRule("FxFixingDateDateChoice")
public class FxFixingDateDateChoice implements Validator<FxFixingDate> {
	
	private static final String NAME = "FxFixingDateDateChoice";
	
	@Override
	public ValidationResult<FxFixingDate> validate(RosettaPath path, FxFixingDate object) {
		List<String> choiceFieldNames = asList("dateRelativeToPaymentDates", "dateRelativeToCalculationPeriodDates", "fxFixingDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDateRelativeToPaymentDates())) populatedFieldNames.add("dateRelativeToPaymentDates");
		if (isSet(object.getDateRelativeToCalculationPeriodDates())) populatedFieldNames.add("dateRelativeToCalculationPeriodDates");
		if (isSet(object.getFxFixingDate())) populatedFieldNames.add("fxFixingDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "FxFixingDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<FxFixingDate>(NAME, "FxFixingDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
