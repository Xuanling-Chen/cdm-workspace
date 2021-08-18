package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SettlementBase;
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

public class SettlementBaseValidator implements Validator<SettlementBase> {

	@Override
	public ValidationResult<SettlementBase> validate(RosettaPath path, SettlementBase o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementType", o.getSettlementType()!=null ? 1 : 0, 1, 1),
				checkCardinality("transferSettlementType", o.getTransferSettlementType()!=null ? 1 : 0, 0, 1),
				checkCardinality("settlementCurrency", o.getSettlementCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("settlementDate", o.getSettlementDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SettlementBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SettlementBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
