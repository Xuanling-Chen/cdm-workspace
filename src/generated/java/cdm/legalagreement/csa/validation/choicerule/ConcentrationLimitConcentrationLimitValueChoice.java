package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.ConcentrationLimit;
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
@RosettaChoiceRule("ConcentrationLimitConcentrationLimitValueChoice")
public class ConcentrationLimitConcentrationLimitValueChoice implements Validator<ConcentrationLimit> {
	
	private static final String NAME = "ConcentrationLimitConcentrationLimitValueChoice";
	
	@Override
	public ValidationResult<ConcentrationLimit> validate(RosettaPath path, ConcentrationLimit object) {
		List<String> choiceFieldNames = asList("valueCap", "percentageCap");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getValueCap())) populatedFieldNames.add("valueCap");
		if (isSet(object.getPercentageCap())) populatedFieldNames.add("percentageCap");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ConcentrationLimit", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ConcentrationLimit>(NAME, "ConcentrationLimit", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
