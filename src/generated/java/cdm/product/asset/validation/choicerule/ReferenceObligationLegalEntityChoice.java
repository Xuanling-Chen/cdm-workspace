package cdm.product.asset.validation.choicerule;

import cdm.product.asset.ReferenceObligation;
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
@RosettaChoiceRule("ReferenceObligationLegalEntityChoice")
public class ReferenceObligationLegalEntityChoice implements Validator<ReferenceObligation> {
	
	private static final String NAME = "ReferenceObligationLegalEntityChoice";
	
	@Override
	public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation object) {
		List<String> choiceFieldNames = asList("primaryObligor", "primaryObligorReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getPrimaryObligor())) populatedFieldNames.add("primaryObligor");
		if (isSet(object.getPrimaryObligorReference())) populatedFieldNames.add("primaryObligorReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReferenceObligation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReferenceObligation>(NAME, "ReferenceObligation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
