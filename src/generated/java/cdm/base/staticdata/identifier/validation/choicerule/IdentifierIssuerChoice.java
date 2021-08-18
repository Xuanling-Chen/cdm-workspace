package cdm.base.staticdata.identifier.validation.choicerule;

import cdm.base.staticdata.identifier.Identifier;
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
@RosettaChoiceRule("IdentifierIssuerChoice")
public class IdentifierIssuerChoice implements Validator<Identifier> {
	
	private static final String NAME = "IdentifierIssuerChoice";
	
	@Override
	public ValidationResult<Identifier> validate(RosettaPath path, Identifier object) {
		List<String> choiceFieldNames = asList("issuerReference", "issuer");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getIssuerReference())) populatedFieldNames.add("issuerReference");
		if (isSet(object.getIssuer())) populatedFieldNames.add("issuer");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Identifier", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Identifier>(NAME, "Identifier", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
