package cdm.product.template.validation;

import cdm.product.template.InitialMarginCalculation;
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

public class InitialMarginCalculationValidator implements Validator<InitialMarginCalculation> {

	@Override
	public ValidationResult<InitialMarginCalculation> validate(RosettaPath path, InitialMarginCalculation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("marginRatio", o.getMarginRatio()!=null ? 1 : 0, 0, 1),
				checkCardinality("marginRatioThreshold", o.getMarginRatioThreshold()==null?0:o.getMarginRatioThreshold().size(), 0, 2),
				checkCardinality("haircut", o.getHaircut()!=null ? 1 : 0, 0, 1),
				checkCardinality("haircutThreshold", o.getHaircutThreshold()==null?0:o.getHaircutThreshold().size(), 0, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InitialMarginCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InitialMarginCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
