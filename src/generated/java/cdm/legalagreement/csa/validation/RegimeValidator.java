package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.Regime;
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

public class RegimeValidator implements Validator<Regime> {

	@Override
	public ValidationResult<Regime> validate(RosettaPath path, Regime o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicableRegime", o.getApplicableRegime()==null?0:o.getApplicableRegime().size(), 1, 0),
				checkCardinality("fallbackToMandatoryMethodDays", o.getFallbackToMandatoryMethodDays()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Regime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Regime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
