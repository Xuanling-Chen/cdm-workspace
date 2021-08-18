package cdm.base.staticdata.party.validation.choicerule;

import cdm.base.staticdata.party.NaturalPerson;
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
@RosettaChoiceRule("NaturalPersonNaturalPersonChoice")
public class NaturalPersonNaturalPersonChoice implements Validator<NaturalPerson> {
	
	private static final String NAME = "NaturalPersonNaturalPersonChoice";
	
	@Override
	public ValidationResult<NaturalPerson> validate(RosettaPath path, NaturalPerson object) {
		List<String> choiceFieldNames = asList("middleName", "initial");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMiddleName())) populatedFieldNames.add("middleName");
		if (isSet(object.getInitial())) populatedFieldNames.add("initial");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "NaturalPerson", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<NaturalPerson>(NAME, "NaturalPerson", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
