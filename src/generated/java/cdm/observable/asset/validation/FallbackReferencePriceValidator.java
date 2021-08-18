package cdm.observable.asset.validation;

import cdm.observable.asset.FallbackReferencePrice;
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

public class FallbackReferencePriceValidator implements Validator<FallbackReferencePrice> {

	@Override
	public ValidationResult<FallbackReferencePrice> validate(RosettaPath path, FallbackReferencePrice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationPostponement", o.getValuationPostponement()!=null ? 1 : 0, 0, 1),
				checkCardinality("fallBackSettlementRateOption", o.getFallBackSettlementRateOption()==null?0:o.getFallBackSettlementRateOption().size(), 0, 0),
				checkCardinality("fallbackSurveyValuationPostponement", o.getFallbackSurveyValuationPostponement()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAgentDetermination", o.getCalculationAgentDetermination()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FallbackReferencePrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FallbackReferencePrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
