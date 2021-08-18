package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.BondChoiceModel;
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
@RosettaChoiceRule("BondChoiceModelOneOf0")
public class BondChoiceModelOneOf0 implements Validator<BondChoiceModel> {
	
	private static final String NAME = "BondChoiceModelOneOf0";
	
	@Override
	public ValidationResult<BondChoiceModel> validate(RosettaPath path, BondChoiceModel object) {
		List<String> choiceFieldNames = asList("bond", "convertibleBond");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBond())) populatedFieldNames.add("bond");
		if (isSet(object.getConvertibleBond())) populatedFieldNames.add("convertibleBond");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "BondChoiceModel", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<BondChoiceModel>(NAME, "BondChoiceModel", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
