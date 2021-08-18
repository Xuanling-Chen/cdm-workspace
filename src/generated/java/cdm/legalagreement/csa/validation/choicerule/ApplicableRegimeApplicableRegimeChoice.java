package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.ApplicableRegime;
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
@RosettaChoiceRule("ApplicableRegimeApplicableRegimeChoice")
public class ApplicableRegimeApplicableRegimeChoice implements Validator<ApplicableRegime> {
	
	private static final String NAME = "ApplicableRegimeApplicableRegimeChoice";
	
	@Override
	public ValidationResult<ApplicableRegime> validate(RosettaPath path, ApplicableRegime object) {
		List<String> choiceFieldNames = asList("regime", "additionalRegime");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getRegime())) populatedFieldNames.add("regime");
		if (isSet(object.getAdditionalRegime())) populatedFieldNames.add("additionalRegime");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ApplicableRegime", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ApplicableRegime>(NAME, "ApplicableRegime", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
