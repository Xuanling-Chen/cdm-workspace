package cdm.base.datetime.validation.choicerule;

import cdm.base.datetime.AdjustableDate;
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
@RosettaChoiceRule("AdjustableDateAdjustableDateChoice")
public class AdjustableDateAdjustableDateChoice implements Validator<AdjustableDate> {
	
	private static final String NAME = "AdjustableDateAdjustableDateChoice";
	
	@Override
	public ValidationResult<AdjustableDate> validate(RosettaPath path, AdjustableDate object) {
		List<String> choiceFieldNames = asList("dateAdjustments", "dateAdjustmentsReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDateAdjustments())) populatedFieldNames.add("dateAdjustments");
		if (isSet(object.getDateAdjustmentsReference())) populatedFieldNames.add("dateAdjustmentsReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AdjustableDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AdjustableDate>(NAME, "AdjustableDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
