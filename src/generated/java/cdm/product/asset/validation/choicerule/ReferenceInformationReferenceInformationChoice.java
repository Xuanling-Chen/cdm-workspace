package cdm.product.asset.validation.choicerule;

import cdm.product.asset.ReferenceInformation;
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
@RosettaChoiceRule("ReferenceInformationReferenceInformationChoice")
public class ReferenceInformationReferenceInformationChoice implements Validator<ReferenceInformation> {
	
	private static final String NAME = "ReferenceInformationReferenceInformationChoice";
	
	@Override
	public ValidationResult<ReferenceInformation> validate(RosettaPath path, ReferenceInformation object) {
		List<String> choiceFieldNames = asList("referenceObligation", "noReferenceObligation", "unknownReferenceObligation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getReferenceObligation())) populatedFieldNames.add("referenceObligation");
		if (isSet(object.getNoReferenceObligation())) populatedFieldNames.add("noReferenceObligation");
		if (isSet(object.getUnknownReferenceObligation())) populatedFieldNames.add("unknownReferenceObligation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReferenceInformation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReferenceInformation>(NAME, "ReferenceInformation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
