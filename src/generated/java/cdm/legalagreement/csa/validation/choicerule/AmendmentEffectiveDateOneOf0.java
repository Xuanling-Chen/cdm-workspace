package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.AmendmentEffectiveDate;
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
@RosettaChoiceRule("AmendmentEffectiveDateOneOf0")
public class AmendmentEffectiveDateOneOf0 implements Validator<AmendmentEffectiveDate> {
	
	private static final String NAME = "AmendmentEffectiveDateOneOf0";
	
	@Override
	public ValidationResult<AmendmentEffectiveDate> validate(RosettaPath path, AmendmentEffectiveDate object) {
		List<String> choiceFieldNames = asList("date", "specificDate", "customProvision");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDate())) populatedFieldNames.add("date");
		if (isSet(object.getSpecificDate())) populatedFieldNames.add("specificDate");
		if (isSet(object.getCustomProvision())) populatedFieldNames.add("customProvision");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AmendmentEffectiveDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AmendmentEffectiveDate>(NAME, "AmendmentEffectiveDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
