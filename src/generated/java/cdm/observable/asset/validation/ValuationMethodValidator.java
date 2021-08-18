package cdm.observable.asset.validation;

import cdm.observable.asset.ValuationMethod;
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

public class ValuationMethodValidator implements Validator<ValuationMethod> {

	@Override
	public ValidationResult<ValuationMethod> validate(RosettaPath path, ValuationMethod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationSource", o.getValuationSource()!=null ? 1 : 0, 1, 1),
				checkCardinality("quotationMethod", o.getQuotationMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationMethod", o.getValuationMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("quotationAmount", o.getQuotationAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("minimumQuotationAmount", o.getMinimumQuotationAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashCollateralValuationMethod", o.getCashCollateralValuationMethod()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ValuationMethod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ValuationMethod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
