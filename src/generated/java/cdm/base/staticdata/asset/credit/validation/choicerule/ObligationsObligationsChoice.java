package cdm.base.staticdata.asset.credit.validation.choicerule;

import cdm.base.staticdata.asset.credit.Obligations;
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
@RosettaChoiceRule("ObligationsObligationsChoice")
public class ObligationsObligationsChoice implements Validator<Obligations> {
	
	private static final String NAME = "ObligationsObligationsChoice";
	
	@Override
	public ValidationResult<Obligations> validate(RosettaPath path, Obligations object) {
		List<String> choiceFieldNames = asList("fullFaithAndCreditObLiability", "generalFundObligationLiability", "revenueObligationLiability");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFullFaithAndCreditObLiability())) populatedFieldNames.add("fullFaithAndCreditObLiability");
		if (isSet(object.getGeneralFundObligationLiability())) populatedFieldNames.add("generalFundObligationLiability");
		if (isSet(object.getRevenueObligationLiability())) populatedFieldNames.add("revenueObligationLiability");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Obligations", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Obligations>(NAME, "Obligations", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
