package cdm.base.staticdata.party.validation.choicerule;

import cdm.base.staticdata.party.AncillaryEntity;
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
@RosettaChoiceRule("AncillaryEntityOneOf0")
public class AncillaryEntityOneOf0 implements Validator<AncillaryEntity> {
	
	private static final String NAME = "AncillaryEntityOneOf0";
	
	@Override
	public ValidationResult<AncillaryEntity> validate(RosettaPath path, AncillaryEntity object) {
		List<String> choiceFieldNames = asList("ancillaryParty", "legalEntity");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAncillaryParty())) populatedFieldNames.add("ancillaryParty");
		if (isSet(object.getLegalEntity())) populatedFieldNames.add("legalEntity");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AncillaryEntity", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AncillaryEntity>(NAME, "AncillaryEntity", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
