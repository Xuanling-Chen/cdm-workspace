package cdm.observable.asset.validation;

import cdm.observable.asset.BondValuationModel;
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

public class BondValuationModelValidator implements Validator<BondValuationModel> {

	@Override
	public ValidationResult<BondValuationModel> validate(RosettaPath path, BondValuationModel o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("nominalAmount", o.getNominalAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("bondPriceAndYieldModel", o.getBondPriceAndYieldModel()!=null ? 1 : 0, 1, 1),
				checkCardinality("accrualsAmount", o.getAccrualsAmount()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BondValuationModel", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BondValuationModel", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
