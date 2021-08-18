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
@RosettaChoiceRule("ReferenceObligationAssetChoice")
public class ReferenceObligationAssetChoice implements Validator<ReferenceObligation> {
	
	private static final String NAME = "ReferenceObligationAssetChoice";
	
	@Override
	public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation object) {
		List<String> choiceFieldNames = asList("security", "loan");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSecurity())) populatedFieldNames.add("security");
		if (isSet(object.getLoan())) populatedFieldNames.add("loan");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReferenceObligation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReferenceObligation>(NAME, "ReferenceObligation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
