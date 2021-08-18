package cdm.legalagreement.common.validation.choicerule;

import cdm.legalagreement.common.DocumentationIdentification;
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
@RosettaChoiceRule("DocumentationIdentificationConfirmationChoice")
public class DocumentationIdentificationConfirmationChoice implements Validator<DocumentationIdentification> {
	
	private static final String NAME = "DocumentationIdentificationConfirmationChoice";
	
	@Override
	public ValidationResult<DocumentationIdentification> validate(RosettaPath path, DocumentationIdentification object) {
		List<String> choiceFieldNames = asList("masterConfirmation", "brokerConfirmation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMasterConfirmation())) populatedFieldNames.add("masterConfirmation");
		if (isSet(object.getBrokerConfirmation())) populatedFieldNames.add("brokerConfirmation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "DocumentationIdentification", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<DocumentationIdentification>(NAME, "DocumentationIdentification", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
