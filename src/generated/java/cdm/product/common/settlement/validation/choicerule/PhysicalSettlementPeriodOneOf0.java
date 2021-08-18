package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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
@RosettaChoiceRule("PhysicalSettlementPeriodOneOf0")
public class PhysicalSettlementPeriodOneOf0 implements Validator<PhysicalSettlementPeriod> {
	
	private static final String NAME = "PhysicalSettlementPeriodOneOf0";
	
	@Override
	public ValidationResult<PhysicalSettlementPeriod> validate(RosettaPath path, PhysicalSettlementPeriod object) {
		List<String> choiceFieldNames = asList("businessDaysNotSpecified", "businessDays", "maximumBusinessDays");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBusinessDaysNotSpecified())) populatedFieldNames.add("businessDaysNotSpecified");
		if (isSet(object.getBusinessDays())) populatedFieldNames.add("businessDays");
		if (isSet(object.getMaximumBusinessDays())) populatedFieldNames.add("maximumBusinessDays");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PhysicalSettlementPeriod", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PhysicalSettlementPeriod>(NAME, "PhysicalSettlementPeriod", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
