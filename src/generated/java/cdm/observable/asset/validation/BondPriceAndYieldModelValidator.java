package cdm.observable.asset.validation;

import cdm.observable.asset.BondPriceAndYieldModel;
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

public class BondPriceAndYieldModelValidator implements Validator<BondPriceAndYieldModel> {

	@Override
	public ValidationResult<BondPriceAndYieldModel> validate(RosettaPath path, BondPriceAndYieldModel o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cleanOrDirtyPrice", o.getCleanOrDirtyPrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("relativePrice", o.getRelativePrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("yieldToMaturity", o.getYieldToMaturity()!=null ? 1 : 0, 0, 1),
				checkCardinality("inflationFactor", o.getInflationFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("allInPrice", o.getAllInPrice()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BondPriceAndYieldModel", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BondPriceAndYieldModel", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
