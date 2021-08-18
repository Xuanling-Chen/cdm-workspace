package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.DeliverableObligations;
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
@RosettaChoiceRule("DeliverableObligationsDeliverableObligationsChoice")
public class DeliverableObligationsDeliverableObligationsChoice implements Validator<DeliverableObligations> {
	
	private static final String NAME = "DeliverableObligationsDeliverableObligationsChoice";
	
	@Override
	public ValidationResult<DeliverableObligations> validate(RosettaPath path, DeliverableObligations object) {
		List<String> choiceFieldNames = asList("fullFaithAndCreditObLiability", "generalFundObligationLiability", "revenueObligationLiability");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFullFaithAndCreditObLiability())) populatedFieldNames.add("fullFaithAndCreditObLiability");
		if (isSet(object.getGeneralFundObligationLiability())) populatedFieldNames.add("generalFundObligationLiability");
		if (isSet(object.getRevenueObligationLiability())) populatedFieldNames.add("revenueObligationLiability");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "DeliverableObligations", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<DeliverableObligations>(NAME, "DeliverableObligations", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
