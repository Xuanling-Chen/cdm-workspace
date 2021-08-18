package cdm.product.template.validation;

import cdm.product.template.FxFeature;
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

public class FxFeatureValidator implements Validator<FxFeature> {

	@Override
	public ValidationResult<FxFeature> validate(RosettaPath path, FxFeature o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceCurrency", o.getReferenceCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("composite", o.getComposite()!=null ? 1 : 0, 0, 1),
				checkCardinality("quanto", o.getQuanto()!=null ? 1 : 0, 0, 1),
				checkCardinality("crossCurrency", o.getCrossCurrency()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FxFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FxFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
