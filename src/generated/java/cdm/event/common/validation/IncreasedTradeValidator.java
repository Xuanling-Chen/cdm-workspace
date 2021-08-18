package cdm.event.common.validation;

import cdm.event.common.IncreasedTrade;
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

public class IncreasedTradeValidator implements Validator<IncreasedTrade> {

	@Override
	public ValidationResult<IncreasedTrade> validate(RosettaPath path, IncreasedTrade o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeState", o.getTradeState()!=null ? 1 : 0, 1, 1),
				checkCardinality("quantity", o.getQuantity()==null?0:o.getQuantity().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IncreasedTrade", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IncreasedTrade", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
