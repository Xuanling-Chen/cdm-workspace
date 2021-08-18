package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.FxLinkedNotionalSchedule;
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

public class FxLinkedNotionalScheduleValidator implements Validator<FxLinkedNotionalSchedule> {

	@Override
	public ValidationResult<FxLinkedNotionalSchedule> validate(RosettaPath path, FxLinkedNotionalSchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialValue", o.getInitialValue()!=null ? 1 : 0, 0, 1),
				checkCardinality("varyingNotionalCurrency", o.getVaryingNotionalCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("varyingNotionalFixingDates", o.getVaryingNotionalFixingDates()!=null ? 1 : 0, 1, 1),
				checkCardinality("fxSpotRateSource", o.getFxSpotRateSource()!=null ? 1 : 0, 1, 1),
				checkCardinality("fixingTime", o.getFixingTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("varyingNotionalInterimExchangePaymentDates", o.getVaryingNotionalInterimExchangePaymentDates()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FxLinkedNotionalSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FxLinkedNotionalSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
