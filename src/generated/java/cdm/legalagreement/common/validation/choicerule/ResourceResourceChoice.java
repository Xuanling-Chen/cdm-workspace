package cdm.legalagreement.common.validation.choicerule;

import cdm.legalagreement.common.Resource;
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
@RosettaChoiceRule("ResourceResourceChoice")
public class ResourceResourceChoice implements Validator<Resource> {
	
	private static final String NAME = "ResourceResourceChoice";
	
	@Override
	public ValidationResult<Resource> validate(RosettaPath path, Resource object) {
		List<String> choiceFieldNames = asList("string", "url");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getString())) populatedFieldNames.add("string");
		if (isSet(object.getUrl())) populatedFieldNames.add("url");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Resource", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Resource>(NAME, "Resource", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
