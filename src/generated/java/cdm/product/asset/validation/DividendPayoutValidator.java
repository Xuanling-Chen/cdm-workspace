package cdm.product.asset.validation;

import cdm.product.asset.DividendPayout;
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

public class DividendPayoutValidator implements Validator<DividendPayout> {

	@Override
	public ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPayoutRatio", o.getDividendPayoutRatio()!=null ? 1 : 0, 1, 1),
				checkCardinality("dividendPayoutRatioCash", o.getDividendPayoutRatioCash()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendPayoutRatioNonCash", o.getDividendPayoutRatioNonCash()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DividendPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DividendPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
