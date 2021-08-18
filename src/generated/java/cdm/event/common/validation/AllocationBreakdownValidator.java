package cdm.event.common.validation;

import cdm.event.common.AllocationBreakdown;
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

public class AllocationBreakdownValidator implements Validator<AllocationBreakdown> {

	@Override
	public ValidationResult<AllocationBreakdown> validate(RosettaPath path, AllocationBreakdown o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("counterparty", o.getCounterparty()!=null ? 1 : 0, 1, 1),
				checkCardinality("ancillaryParty", o.getAncillaryParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("quantity", o.getQuantity()==null?0:o.getQuantity().size(), 1, 0),
				checkCardinality("allocationTradeId", o.getAllocationTradeId()==null?0:o.getAllocationTradeId().size(), 1, 0),
				checkCardinality("account", o.getAccount()!=null ? 1 : 0, 0, 1),
				checkCardinality("collateral", o.getCollateral()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AllocationBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AllocationBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
