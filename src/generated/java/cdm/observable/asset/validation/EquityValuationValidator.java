package cdm.observable.asset.validation;

import cdm.observable.asset.EquityValuation;
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

public class EquityValuationValidator implements Validator<EquityValuation> {

	@Override
	public ValidationResult<EquityValuation> validate(RosettaPath path, EquityValuation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", o.getPrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("determinationMethod", o.getDeterminationMethod()!=null ? 1 : 0, 1, 1),
				checkCardinality("valuationDates", o.getValuationDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationDate", o.getValuationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationTime", o.getValuationTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationTimeType", o.getValuationTimeType()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EquityValuation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EquityValuation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
