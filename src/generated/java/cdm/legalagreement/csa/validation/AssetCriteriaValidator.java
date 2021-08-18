package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.AssetCriteria;
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

public class AssetCriteriaValidator implements Validator<AssetCriteria> {

	@Override
	public ValidationResult<AssetCriteria> validate(RosettaPath path, AssetCriteria o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralAssetType", o.getCollateralAssetType()==null?0:o.getCollateralAssetType().size(), 0, 0),
				checkCardinality("assetCountryOfOrigin", o.getAssetCountryOfOrigin()==null?0:o.getAssetCountryOfOrigin().size(), 0, 0),
				checkCardinality("denominatedCurrency", o.getDenominatedCurrency()==null?0:o.getDenominatedCurrency().size(), 0, 0),
				checkCardinality("agencyRating", o.getAgencyRating()==null?0:o.getAgencyRating().size(), 0, 0),
				checkCardinality("maturityType", o.getMaturityType()!=null ? 1 : 0, 0, 1),
				checkCardinality("maturityRange", o.getMaturityRange()!=null ? 1 : 0, 0, 1),
				checkCardinality("productIdentifier", o.getProductIdentifier()==null?0:o.getProductIdentifier().size(), 0, 0),
				checkCardinality("collateralTaxonomy", o.getCollateralTaxonomy()==null?0:o.getCollateralTaxonomy().size(), 0, 0),
				checkCardinality("domesticCurrencyIssued", o.getDomesticCurrencyIssued()!=null ? 1 : 0, 0, 1),
				checkCardinality("listing", o.getListing()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AssetCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AssetCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
