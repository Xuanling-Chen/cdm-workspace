package cdm.base.staticdata.party.validation.choicerule;

import cdm.base.staticdata.party.PartyContactInformation;
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
@RosettaChoiceRule("PartyContactInformationPartyContactInformationChoice")
public class PartyContactInformationPartyContactInformationChoice implements Validator<PartyContactInformation> {
	
	private static final String NAME = "PartyContactInformationPartyContactInformationChoice";
	
	@Override
	public ValidationResult<PartyContactInformation> validate(RosettaPath path, PartyContactInformation object) {
		List<String> choiceFieldNames = asList("contactInformation", "address");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getContactInformation())) populatedFieldNames.add("contactInformation");
		if (isSet(object.getAddress())) populatedFieldNames.add("address");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PartyContactInformation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PartyContactInformation>(NAME, "PartyContactInformation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
