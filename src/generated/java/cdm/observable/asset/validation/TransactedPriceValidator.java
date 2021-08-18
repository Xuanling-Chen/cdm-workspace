package cdm.observable.asset.validation;

import cdm.observable.asset.TransactedPrice;
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

public class TransactedPriceValidator implements Validator<TransactedPrice> {

	@Override
	public ValidationResult<TransactedPrice> validate(RosettaPath path, TransactedPrice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("marketFixedRate", o.getMarketFixedRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("initialPoints", o.getInitialPoints()!=null ? 1 : 0, 0, 1),
				checkCardinality("marketPrice", o.getMarketPrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("quotationStyle", o.getQuotationStyle()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TransactedPrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TransactedPrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
