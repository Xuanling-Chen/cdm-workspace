package cdm.observable.event.validation.choicerule;

import cdm.observable.event.PubliclyAvailableInformation;
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
@RosettaChoiceRule("PubliclyAvailableInformationSourceChoice")
public class PubliclyAvailableInformationSourceChoice implements Validator<PubliclyAvailableInformation> {
	
	private static final String NAME = "PubliclyAvailableInformationSourceChoice";
	
	@Override
	public ValidationResult<PubliclyAvailableInformation> validate(RosettaPath path, PubliclyAvailableInformation object) {
		List<String> choiceFieldNames = asList("standardPublicSources", "publicSource");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getStandardPublicSources())) populatedFieldNames.add("standardPublicSources");
		if (isSet(object.getPublicSource())) populatedFieldNames.add("publicSource");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PubliclyAvailableInformation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PubliclyAvailableInformation>(NAME, "PubliclyAvailableInformation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
