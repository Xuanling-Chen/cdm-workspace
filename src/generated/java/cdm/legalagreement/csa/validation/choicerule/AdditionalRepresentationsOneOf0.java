package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.AdditionalRepresentations;
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
@RosettaChoiceRule("AdditionalRepresentationsOneOf0")
public class AdditionalRepresentationsOneOf0 implements Validator<AdditionalRepresentations> {
	
	private static final String NAME = "AdditionalRepresentationsOneOf0";
	
	@Override
	public ValidationResult<AdditionalRepresentations> validate(RosettaPath path, AdditionalRepresentations object) {
		List<String> choiceFieldNames = asList("additionalRepresentation", "regulatoryComplianceRepresentation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdditionalRepresentation())) populatedFieldNames.add("additionalRepresentation");
		if (isSet(object.getRegulatoryComplianceRepresentation())) populatedFieldNames.add("regulatoryComplianceRepresentation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AdditionalRepresentations", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AdditionalRepresentations>(NAME, "AdditionalRepresentations", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
