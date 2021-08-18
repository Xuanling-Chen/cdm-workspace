package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
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

public class CollateralIssuerTypeOnlyExistsValidator implements ValidatorWithArg<CollateralIssuerType, Set<String>> {

	@Override
	public <T2 extends CollateralIssuerType> ValidationResult<CollateralIssuerType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerType", ExistenceChecker.isSet(o.getIssuerType()))
				.put("supraNationalType", ExistenceChecker.isSet(o.getSupraNationalType()))
				.put("quasiGovernmentType", ExistenceChecker.isSet(o.getQuasiGovernmentType()))
				.put("regionalGovernmentType", ExistenceChecker.isSet(o.getRegionalGovernmentType()))
				.put("specialPurposeVehicleType", ExistenceChecker.isSet(o.getSpecialPurposeVehicleType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralIssuerType", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CollateralIssuerType", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
