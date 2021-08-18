package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ObservationPayout;
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

public class ObservationPayoutValidator implements Validator<ObservationPayout> {

	@Override
	public ValidationResult<ObservationPayout> validate(RosettaPath path, ObservationPayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDates", o.getCalculationPeriodDates()==null?0:o.getCalculationPeriodDates().size(), 1, 0),
				checkCardinality("paymentDates", o.getPaymentDates()!=null ? 1 : 0, 1, 1),
				checkCardinality("underlier", o.getUnderlier()!=null ? 1 : 0, 1, 1),
				checkCardinality("fxFeature", o.getFxFeature()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ObservationPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ObservationPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
