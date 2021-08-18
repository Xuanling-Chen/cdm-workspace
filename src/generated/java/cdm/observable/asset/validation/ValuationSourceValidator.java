package cdm.observable.asset.validation;

import cdm.observable.asset.ValuationSource;
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

public class ValuationSourceValidator implements Validator<ValuationSource> {

	@Override
	public ValidationResult<ValuationSource> validate(RosettaPath path, ValuationSource o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", o.getQuotedCurrencyPair()!=null ? 1 : 0, 0, 1),
				checkCardinality("informationSource", o.getInformationSource()!=null ? 1 : 0, 0, 1),
				checkCardinality("settlementRateOption", o.getSettlementRateOption()!=null ? 1 : 0, 0, 1),
				checkCardinality("referenceBanks", o.getReferenceBanks()!=null ? 1 : 0, 0, 1),
				checkCardinality("dealerOrCCP", o.getDealerOrCCP()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ValuationSource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ValuationSource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
