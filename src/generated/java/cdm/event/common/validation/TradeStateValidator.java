package cdm.event.common.validation;

import cdm.event.common.TradeState;
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

public class TradeStateValidator implements Validator<TradeState> {

	@Override
	public ValidationResult<TradeState> validate(RosettaPath path, TradeState o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("trade", o.getTrade()!=null ? 1 : 0, 1, 1),
				checkCardinality("state", o.getState()!=null ? 1 : 0, 0, 1),
				checkCardinality("resetHistory", o.getResetHistory()==null?0:o.getResetHistory().size(), 0, 0),
				checkCardinality("transferHistory", o.getTransferHistory()==null?0:o.getTransferHistory().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TradeState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TradeState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
