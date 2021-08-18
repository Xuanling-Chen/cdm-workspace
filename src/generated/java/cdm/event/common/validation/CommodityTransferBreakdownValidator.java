package cdm.event.common.validation;

import cdm.event.common.CommodityTransferBreakdown;
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

public class CommodityTransferBreakdownValidator implements Validator<CommodityTransferBreakdown> {

	@Override
	public ValidationResult<CommodityTransferBreakdown> validate(RosettaPath path, CommodityTransferBreakdown o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferorTransferee", o.getTransferorTransferee()!=null ? 1 : 0, 1, 1),
				checkCardinality("commodity", o.getCommodity()!=null ? 1 : 0, 1, 1),
				checkCardinality("quantity", o.getQuantity()!=null ? 1 : 0, 1, 1),
				checkCardinality("unit", o.getUnit()!=null ? 1 : 0, 1, 1),
				checkCardinality("timeUnit", o.getTimeUnit()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CommodityTransferBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CommodityTransferBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
