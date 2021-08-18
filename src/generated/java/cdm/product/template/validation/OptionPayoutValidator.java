package cdm.product.template.validation;

import cdm.product.template.OptionPayout;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class OptionPayoutValidator implements Validator<OptionPayout> {

	@Override
	public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerSeller", o.getBuyerSeller()!=null ? 1 : 0, 1, 1),
				checkCardinality("optionType", o.getOptionType()!=null ? 1 : 0, 0, 1),
				checkCardinality("feature", o.getFeature()!=null ? 1 : 0, 0, 1),
				checkCardinality("exerciseTerms", o.getExerciseTerms()!=null ? 1 : 0, 1, 1),
				checkCardinality("underlier", o.getUnderlier()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OptionPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OptionPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
