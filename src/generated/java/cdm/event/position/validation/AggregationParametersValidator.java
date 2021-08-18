package cdm.event.position.validation;

import cdm.event.position.AggregationParameters;
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

public class AggregationParametersValidator implements Validator<AggregationParameters> {

	@Override
	public ValidationResult<AggregationParameters> validate(RosettaPath path, AggregationParameters o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateTime", o.getDateTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("totalPosition", o.getTotalPosition()!=null ? 1 : 0, 0, 1),
				checkCardinality("positionStatus", o.getPositionStatus()!=null ? 1 : 0, 0, 1),
				checkCardinality("party", o.getParty()==null?0:o.getParty().size(), 0, 0),
				checkCardinality("product", o.getProduct()==null?0:o.getProduct().size(), 0, 0),
				checkCardinality("productQualifier", o.getProductQualifier()==null?0:o.getProductQualifier().size(), 0, 0),
				checkCardinality("tradeReference", o.getTradeReference()==null?0:o.getTradeReference().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AggregationParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AggregationParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
