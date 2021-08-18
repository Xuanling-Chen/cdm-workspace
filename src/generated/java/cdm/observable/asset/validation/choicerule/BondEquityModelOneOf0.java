package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.BondEquityModel;
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
@RosettaChoiceRule("BondEquityModelOneOf0")
public class BondEquityModelOneOf0 implements Validator<BondEquityModel> {
	
	private static final String NAME = "BondEquityModelOneOf0";
	
	@Override
	public ValidationResult<BondEquityModel> validate(RosettaPath path, BondEquityModel object) {
		List<String> choiceFieldNames = asList("bondchoiceModel", "equity");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBondchoiceModel())) populatedFieldNames.add("bondchoiceModel");
		if (isSet(object.getEquity())) populatedFieldNames.add("equity");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "BondEquityModel", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<BondEquityModel>(NAME, "BondEquityModel", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
