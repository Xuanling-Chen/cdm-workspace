package cdm.product.common.schedule.validation.choicerule;

import cdm.product.common.schedule.WeightedAveragingObservation;
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
@RosettaChoiceRule("WeightedAveragingObservationWeightedAveragingObservationChoice")
public class WeightedAveragingObservationWeightedAveragingObservationChoice implements Validator<WeightedAveragingObservation> {
	
	private static final String NAME = "WeightedAveragingObservationWeightedAveragingObservationChoice";
	
	@Override
	public ValidationResult<WeightedAveragingObservation> validate(RosettaPath path, WeightedAveragingObservation object) {
		List<String> choiceFieldNames = asList("dateTime", "observationNumber");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDateTime())) populatedFieldNames.add("dateTime");
		if (isSet(object.getObservationNumber())) populatedFieldNames.add("observationNumber");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "WeightedAveragingObservation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<WeightedAveragingObservation>(NAME, "WeightedAveragingObservation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
