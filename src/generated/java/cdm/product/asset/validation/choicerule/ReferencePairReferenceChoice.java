package cdm.product.asset.validation.choicerule;

import cdm.product.asset.ReferencePair;
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
@RosettaChoiceRule("ReferencePairReferenceChoice")
public class ReferencePairReferenceChoice implements Validator<ReferencePair> {
	
	private static final String NAME = "ReferencePairReferenceChoice";
	
	@Override
	public ValidationResult<ReferencePair> validate(RosettaPath path, ReferencePair object) {
		List<String> choiceFieldNames = asList("referenceObligation", "noReferenceObligation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getReferenceObligation())) populatedFieldNames.add("referenceObligation");
		if (isSet(object.getNoReferenceObligation())) populatedFieldNames.add("noReferenceObligation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReferencePair", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReferencePair>(NAME, "ReferencePair", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
