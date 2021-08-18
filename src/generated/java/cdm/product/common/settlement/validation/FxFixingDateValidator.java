package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.FxFixingDate;
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

public class FxFixingDateValidator implements Validator<FxFixingDate> {

	@Override
	public ValidationResult<FxFixingDate> validate(RosettaPath path, FxFixingDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDayConvention", o.getBusinessDayConvention()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessCenters", o.getBusinessCenters()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessCentersReference", o.getBusinessCentersReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateRelativeToPaymentDates", o.getDateRelativeToPaymentDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateRelativeToCalculationPeriodDates", o.getDateRelativeToCalculationPeriodDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("fxFixingDate", o.getFxFixingDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FxFixingDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FxFixingDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
