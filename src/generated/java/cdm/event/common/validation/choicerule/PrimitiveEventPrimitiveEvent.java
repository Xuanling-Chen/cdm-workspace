package cdm.event.common.validation.choicerule;

import cdm.event.common.PrimitiveEvent;
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
@RosettaChoiceRule("PrimitiveEventPrimitiveEvent")
public class PrimitiveEventPrimitiveEvent implements Validator<PrimitiveEvent> {
	
	private static final String NAME = "PrimitiveEventPrimitiveEvent";
	
	@Override
	public ValidationResult<PrimitiveEvent> validate(RosettaPath path, PrimitiveEvent object) {
		List<String> choiceFieldNames = asList("execution", "contractFormation", "split", "quantityChange", "reset", "termsChange", "transfer");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getExecution())) populatedFieldNames.add("execution");
		if (isSet(object.getContractFormation())) populatedFieldNames.add("contractFormation");
		if (isSet(object.getSplit())) populatedFieldNames.add("split");
		if (isSet(object.getQuantityChange())) populatedFieldNames.add("quantityChange");
		if (isSet(object.getReset())) populatedFieldNames.add("reset");
		if (isSet(object.getTermsChange())) populatedFieldNames.add("termsChange");
		if (isSet(object.getTransfer())) populatedFieldNames.add("transfer");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PrimitiveEvent", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PrimitiveEvent>(NAME, "PrimitiveEvent", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
