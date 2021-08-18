package cdm.product.asset.validation.choicerule;

import cdm.product.asset.GeneralTerms;
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
@RosettaChoiceRule("GeneralTermsGeneralTermsChoice")
public class GeneralTermsGeneralTermsChoice implements Validator<GeneralTerms> {
	
	private static final String NAME = "GeneralTermsGeneralTermsChoice";
	
	@Override
	public ValidationResult<GeneralTerms> validate(RosettaPath path, GeneralTerms object) {
		List<String> choiceFieldNames = asList("referenceInformation", "indexReferenceInformation", "basketReferenceInformation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getReferenceInformation())) populatedFieldNames.add("referenceInformation");
		if (isSet(object.getIndexReferenceInformation())) populatedFieldNames.add("indexReferenceInformation");
		if (isSet(object.getBasketReferenceInformation())) populatedFieldNames.add("basketReferenceInformation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "GeneralTerms", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<GeneralTerms>(NAME, "GeneralTerms", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
