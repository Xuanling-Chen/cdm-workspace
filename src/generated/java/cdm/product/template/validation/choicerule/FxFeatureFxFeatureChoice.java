package cdm.product.template.validation.choicerule;

import cdm.product.template.FxFeature;
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
@RosettaChoiceRule("FxFeatureFxFeatureChoice")
public class FxFeatureFxFeatureChoice implements Validator<FxFeature> {
	
	private static final String NAME = "FxFeatureFxFeatureChoice";
	
	@Override
	public ValidationResult<FxFeature> validate(RosettaPath path, FxFeature object) {
		List<String> choiceFieldNames = asList("composite", "quanto", "crossCurrency");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getComposite())) populatedFieldNames.add("composite");
		if (isSet(object.getQuanto())) populatedFieldNames.add("quanto");
		if (isSet(object.getCrossCurrency())) populatedFieldNames.add("crossCurrency");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "FxFeature", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<FxFeature>(NAME, "FxFeature", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
