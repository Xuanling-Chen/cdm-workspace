package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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

public class PhysicalSettlementPeriodValidator implements Validator<PhysicalSettlementPeriod> {

	@Override
	public ValidationResult<PhysicalSettlementPeriod> validate(RosettaPath path, PhysicalSettlementPeriod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDaysNotSpecified", o.getBusinessDaysNotSpecified()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessDays", o.getBusinessDays()!=null ? 1 : 0, 0, 1),
				checkCardinality("maximumBusinessDays", o.getMaximumBusinessDays()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PhysicalSettlementPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PhysicalSettlementPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
