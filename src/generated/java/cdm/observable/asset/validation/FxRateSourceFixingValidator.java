package cdm.observable.asset.validation;

import cdm.observable.asset.FxRateSourceFixing;
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

public class FxRateSourceFixingValidator implements Validator<FxRateSourceFixing> {

	@Override
	public ValidationResult<FxRateSourceFixing> validate(RosettaPath path, FxRateSourceFixing o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementRateSource", o.getSettlementRateSource()!=null ? 1 : 0, 1, 1),
				checkCardinality("fixingDate", o.getFixingDate()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FxRateSourceFixing", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FxRateSourceFixing", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
