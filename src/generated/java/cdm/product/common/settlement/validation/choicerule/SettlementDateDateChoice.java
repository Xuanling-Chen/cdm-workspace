package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.SettlementDate;
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
@RosettaChoiceRule("SettlementDateDateChoice")
public class SettlementDateDateChoice implements Validator<SettlementDate> {
	
	private static final String NAME = "SettlementDateDateChoice";
	
	@Override
	public ValidationResult<SettlementDate> validate(RosettaPath path, SettlementDate object) {
		List<String> choiceFieldNames = asList("settlementDate", "valueDate", "adjustableDates", "businessDateRange");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSettlementDate())) populatedFieldNames.add("settlementDate");
		if (isSet(object.getValueDate())) populatedFieldNames.add("valueDate");
		if (isSet(object.getAdjustableDates())) populatedFieldNames.add("adjustableDates");
		if (isSet(object.getBusinessDateRange())) populatedFieldNames.add("businessDateRange");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SettlementDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SettlementDate>(NAME, "SettlementDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
