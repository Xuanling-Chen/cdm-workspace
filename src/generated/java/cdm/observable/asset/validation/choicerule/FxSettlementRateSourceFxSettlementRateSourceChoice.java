package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.FxSettlementRateSource;
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
@RosettaChoiceRule("FxSettlementRateSourceFxSettlementRateSourceChoice")
public class FxSettlementRateSourceFxSettlementRateSourceChoice implements Validator<FxSettlementRateSource> {
	
	private static final String NAME = "FxSettlementRateSourceFxSettlementRateSourceChoice";
	
	@Override
	public ValidationResult<FxSettlementRateSource> validate(RosettaPath path, FxSettlementRateSource object) {
		List<String> choiceFieldNames = asList("settlementRateOption", "nonstandardSettlementRate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSettlementRateOption())) populatedFieldNames.add("settlementRateOption");
		if (isSet(object.getNonstandardSettlementRate())) populatedFieldNames.add("nonstandardSettlementRate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "FxSettlementRateSource", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<FxSettlementRateSource>(NAME, "FxSettlementRateSource", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
