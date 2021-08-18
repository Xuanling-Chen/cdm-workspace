package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ValuationDate;
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

public class ValuationDateValidator implements Validator<ValuationDate> {

	@Override
	public ValidationResult<ValuationDate> validate(RosettaPath path, ValuationDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("singleValuationDate", o.getSingleValuationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("multipleValuationDates", o.getMultipleValuationDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationDate", o.getValuationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("fxFixingDate", o.getFxFixingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("fxFixingSchedule", o.getFxFixingSchedule()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ValuationDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ValuationDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
