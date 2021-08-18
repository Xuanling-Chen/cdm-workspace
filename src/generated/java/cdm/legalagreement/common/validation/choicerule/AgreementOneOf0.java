package cdm.legalagreement.common.validation.choicerule;

import cdm.legalagreement.common.Agreement;
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
@RosettaChoiceRule("AgreementOneOf0")
public class AgreementOneOf0 implements Validator<Agreement> {
	
	private static final String NAME = "AgreementOneOf0";
	
	@Override
	public ValidationResult<Agreement> validate(RosettaPath path, Agreement object) {
		List<String> choiceFieldNames = asList("creditSupportAgreementElections", "collateralTransferAgreementElections", "securityAgreementElections", "masterAgreementSchedule");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCreditSupportAgreementElections())) populatedFieldNames.add("creditSupportAgreementElections");
		if (isSet(object.getCollateralTransferAgreementElections())) populatedFieldNames.add("collateralTransferAgreementElections");
		if (isSet(object.getSecurityAgreementElections())) populatedFieldNames.add("securityAgreementElections");
		if (isSet(object.getMasterAgreementSchedule())) populatedFieldNames.add("masterAgreementSchedule");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Agreement", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Agreement>(NAME, "Agreement", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
