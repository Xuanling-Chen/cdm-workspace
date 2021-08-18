package cdm.observable.asset.validation;

import cdm.observable.asset.Observable;
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

public class ObservableValidator implements Validator<Observable> {

	@Override
	public ValidationResult<Observable> validate(RosettaPath path, Observable o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateOption", o.getRateOption()!=null ? 1 : 0, 0, 1),
				checkCardinality("commodity", o.getCommodity()!=null ? 1 : 0, 0, 1),
				checkCardinality("productIdentifier", o.getProductIdentifier()==null?0:o.getProductIdentifier().size(), 0, 0),
				checkCardinality("currencyPair", o.getCurrencyPair()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Observable", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Observable", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
