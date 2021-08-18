package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.FxFixingDate;
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
@RosettaChoiceRule("FxFixingDateBusinessCentersChoice")
public class FxFixingDateBusinessCentersChoice implements Validator<FxFixingDate> {
	
	private static final String NAME = "FxFixingDateBusinessCentersChoice";
	
	@Override
	public ValidationResult<FxFixingDate> validate(RosettaPath path, FxFixingDate object) {
		List<String> choiceFieldNames = asList("businessCenters", "businessCentersReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBusinessCenters())) populatedFieldNames.add("businessCenters");
		if (isSet(object.getBusinessCentersReference())) populatedFieldNames.add("businessCentersReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "FxFixingDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<FxFixingDate>(NAME, "FxFixingDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
