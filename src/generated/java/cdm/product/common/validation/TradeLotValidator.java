package cdm.product.common.validation;

import cdm.product.common.TradeLot;
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

public class TradeLotValidator implements Validator<TradeLot> {

	@Override
	public ValidationResult<TradeLot> validate(RosettaPath path, TradeLot o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("lotIdentifier", o.getLotIdentifier()==null?0:o.getLotIdentifier().size(), 0, 0),
				checkCardinality("priceQuantity", o.getPriceQuantity()==null?0:o.getPriceQuantity().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TradeLot", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TradeLot", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
