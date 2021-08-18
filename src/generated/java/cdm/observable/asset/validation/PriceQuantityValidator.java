package cdm.observable.asset.validation;

import cdm.observable.asset.PriceQuantity;
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

public class PriceQuantityValidator implements Validator<PriceQuantity> {

	@Override
	public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", o.getPrice()==null?0:o.getPrice().size(), 0, 0),
				checkCardinality("quantity", o.getQuantity()==null?0:o.getQuantity().size(), 0, 0),
				checkCardinality("observable", o.getObservable()!=null ? 1 : 0, 0, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PriceQuantity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PriceQuantity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
