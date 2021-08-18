package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
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

public class CollateralIssuerTypeValidator implements Validator<CollateralIssuerType> {

	@Override
	public ValidationResult<CollateralIssuerType> validate(RosettaPath path, CollateralIssuerType o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerType", o.getIssuerType()!=null ? 1 : 0, 1, 1),
				checkCardinality("supraNationalType", o.getSupraNationalType()!=null ? 1 : 0, 0, 1),
				checkCardinality("quasiGovernmentType", o.getQuasiGovernmentType()!=null ? 1 : 0, 0, 1),
				checkCardinality("regionalGovernmentType", o.getRegionalGovernmentType()!=null ? 1 : 0, 0, 1),
				checkCardinality("specialPurposeVehicleType", o.getSpecialPurposeVehicleType()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CollateralIssuerType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CollateralIssuerType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
