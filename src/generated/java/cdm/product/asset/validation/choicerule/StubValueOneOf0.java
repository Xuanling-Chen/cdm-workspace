package cdm.product.asset.validation.choicerule;

import cdm.product.asset.StubValue;
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
@RosettaChoiceRule("StubValueOneOf0")
public class StubValueOneOf0 implements Validator<StubValue> {
	
	private static final String NAME = "StubValueOneOf0";
	
	@Override
	public ValidationResult<StubValue> validate(RosettaPath path, StubValue object) {
		List<String> choiceFieldNames = asList("floatingRate", "stubRate", "stubAmount");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFloatingRate())) populatedFieldNames.add("floatingRate");
		if (isSet(object.getStubRate())) populatedFieldNames.add("stubRate");
		if (isSet(object.getStubAmount())) populatedFieldNames.add("stubAmount");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "StubValue", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<StubValue>(NAME, "StubValue", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
