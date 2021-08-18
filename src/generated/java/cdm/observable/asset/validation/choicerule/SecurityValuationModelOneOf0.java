package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.SecurityValuationModel;
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
@RosettaChoiceRule("SecurityValuationModelOneOf0")
public class SecurityValuationModelOneOf0 implements Validator<SecurityValuationModel> {
	
	private static final String NAME = "SecurityValuationModelOneOf0";
	
	@Override
	public ValidationResult<SecurityValuationModel> validate(RosettaPath path, SecurityValuationModel object) {
		List<String> choiceFieldNames = asList("bondValuationModel", "unitContractValuationModel");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBondValuationModel())) populatedFieldNames.add("bondValuationModel");
		if (isSet(object.getUnitContractValuationModel())) populatedFieldNames.add("unitContractValuationModel");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SecurityValuationModel", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SecurityValuationModel>(NAME, "SecurityValuationModel", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
