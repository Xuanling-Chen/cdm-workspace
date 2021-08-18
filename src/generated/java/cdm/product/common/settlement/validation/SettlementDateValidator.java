package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SettlementDate;
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

public class SettlementDateValidator implements Validator<SettlementDate> {

	@Override
	public ValidationResult<SettlementDate> validate(RosettaPath path, SettlementDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementDate", o.getSettlementDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("valueDate", o.getValueDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustableDates", o.getAdjustableDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessDateRange", o.getBusinessDateRange()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashSettlementBusinessDays", o.getCashSettlementBusinessDays()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SettlementDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SettlementDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
