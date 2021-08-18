package cdm.base.datetime.validation.choicerule;

import cdm.base.datetime.BusinessCenters;
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
@RosettaChoiceRule("BusinessCentersBusinessCentersChoice")
public class BusinessCentersBusinessCentersChoice implements Validator<BusinessCenters> {
	
	private static final String NAME = "BusinessCentersBusinessCentersChoice";
	
	@Override
	public ValidationResult<BusinessCenters> validate(RosettaPath path, BusinessCenters object) {
		List<String> choiceFieldNames = asList("businessCenter", "businessCentersReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBusinessCenter())) populatedFieldNames.add("businessCenter");
		if (isSet(object.getBusinessCentersReference())) populatedFieldNames.add("businessCentersReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "BusinessCenters", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<BusinessCenters>(NAME, "BusinessCenters", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
