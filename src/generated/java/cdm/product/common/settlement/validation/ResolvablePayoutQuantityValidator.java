package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ResolvablePayoutQuantity;
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

public class ResolvablePayoutQuantityValidator implements Validator<ResolvablePayoutQuantity> {

	@Override
	public ValidationResult<ResolvablePayoutQuantity> validate(RosettaPath path, ResolvablePayoutQuantity o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("resolvedQuantity", o.getResolvedQuantity()!=null ? 1 : 0, 0, 1),
				checkCardinality("quantitySchedule", o.getQuantitySchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("quantityReference", o.getQuantityReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("quantityMultiplier", o.getQuantityMultiplier()!=null ? 1 : 0, 0, 1),
				checkCardinality("reset", o.getReset()!=null ? 1 : 0, 0, 1),
				checkCardinality("futureValueNotional", o.getFutureValueNotional()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ResolvablePayoutQuantity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ResolvablePayoutQuantity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
