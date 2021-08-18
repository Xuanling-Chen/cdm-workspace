package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.CommodityPriceReturnTerms;
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

public class CommodityPriceReturnTermsValidator implements Validator<CommodityPriceReturnTerms> {

	@Override
	public ValidationResult<CommodityPriceReturnTerms> validate(RosettaPath path, CommodityPriceReturnTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("rounding", o.getRounding()!=null ? 1 : 0, 0, 1),
				checkCardinality("spread", o.getSpread()!=null ? 1 : 0, 0, 1),
				checkCardinality("rollFeature", o.getRollFeature()!=null ? 1 : 0, 0, 1),
				checkCardinality("conversionFactor", o.getConversionFactor()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CommodityPriceReturnTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CommodityPriceReturnTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
