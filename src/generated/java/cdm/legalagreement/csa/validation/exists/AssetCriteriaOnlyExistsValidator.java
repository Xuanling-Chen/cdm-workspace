package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.AssetCriteria;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetCriteriaOnlyExistsValidator implements ValidatorWithArg<AssetCriteria, Set<String>> {

	@Override
	public <T2 extends AssetCriteria> ValidationResult<AssetCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralAssetType", ExistenceChecker.isSet(o.getCollateralAssetType()))
				.put("assetCountryOfOrigin", ExistenceChecker.isSet(o.getAssetCountryOfOrigin()))
				.put("denominatedCurrency", ExistenceChecker.isSet(o.getDenominatedCurrency()))
				.put("agencyRating", ExistenceChecker.isSet(o.getAgencyRating()))
				.put("maturityType", ExistenceChecker.isSet(o.getMaturityType()))
				.put("maturityRange", ExistenceChecker.isSet(o.getMaturityRange()))
				.put("productIdentifier", ExistenceChecker.isSet(o.getProductIdentifier()))
				.put("collateralTaxonomy", ExistenceChecker.isSet(o.getCollateralTaxonomy()))
				.put("domesticCurrencyIssued", ExistenceChecker.isSet(o.getDomesticCurrencyIssued()))
				.put("listing", ExistenceChecker.isSet(o.getListing()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AssetCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
