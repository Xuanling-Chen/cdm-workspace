package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.ValuationSource;
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
@RosettaChoiceRule("ValuationSourceInformationSource")
public class ValuationSourceInformationSource implements Validator<ValuationSource> {
	
	private static final String NAME = "ValuationSourceInformationSource";
	
	@Override
	public ValidationResult<ValuationSource> validate(RosettaPath path, ValuationSource object) {
		List<String> choiceFieldNames = asList("informationSource", "settlementRateOption", "referenceBanks", "dealerOrCCP");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getInformationSource())) populatedFieldNames.add("informationSource");
		if (isSet(object.getSettlementRateOption())) populatedFieldNames.add("settlementRateOption");
		if (isSet(object.getReferenceBanks())) populatedFieldNames.add("referenceBanks");
		if (isSet(object.getDealerOrCCP())) populatedFieldNames.add("dealerOrCCP");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ValuationSource", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ValuationSource>(NAME, "ValuationSource", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
