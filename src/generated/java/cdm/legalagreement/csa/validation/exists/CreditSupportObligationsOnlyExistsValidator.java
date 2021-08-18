package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CreditSupportObligations;
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

public class CreditSupportObligationsOnlyExistsValidator implements ValidatorWithArg<CreditSupportObligations, Set<String>> {

	@Override
	public <T2 extends CreditSupportObligations> ValidationResult<CreditSupportObligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryAmount", ExistenceChecker.isSet(o.getDeliveryAmount()))
				.put("returnAmount", ExistenceChecker.isSet(o.getReturnAmount()))
				.put("marginApproach", ExistenceChecker.isSet(o.getMarginApproach()))
				.put("otherEligibleSupport", ExistenceChecker.isSet(o.getOtherEligibleSupport()))
				.put("threshold", ExistenceChecker.isSet(o.getThreshold()))
				.put("minimumTransferAmount", ExistenceChecker.isSet(o.getMinimumTransferAmount()))
				.put("rounding", ExistenceChecker.isSet(o.getRounding()))
				.put("bespokeTransferTiming", ExistenceChecker.isSet(o.getBespokeTransferTiming()))
				.put("creditSupportObligationsVariationMargin", ExistenceChecker.isSet(o.getCreditSupportObligationsVariationMargin()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportObligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CreditSupportObligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
