package cdm.base.staticdata.asset.credit.validation.exists;

import cdm.base.staticdata.asset.credit.Obligations;
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

public class ObligationsOnlyExistsValidator implements ValidatorWithArg<Obligations, Set<String>> {

	@Override
	public <T2 extends Obligations> ValidationResult<Obligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("category", ExistenceChecker.isSet(o.getCategory()))
				.put("notSubordinated", ExistenceChecker.isSet(o.getNotSubordinated()))
				.put("specifiedCurrency", ExistenceChecker.isSet(o.getSpecifiedCurrency()))
				.put("notSovereignLender", ExistenceChecker.isSet(o.getNotSovereignLender()))
				.put("notDomesticCurrency", ExistenceChecker.isSet(o.getNotDomesticCurrency()))
				.put("notDomesticLaw", ExistenceChecker.isSet(o.getNotDomesticLaw()))
				.put("listed", ExistenceChecker.isSet(o.getListed()))
				.put("notDomesticIssuance", ExistenceChecker.isSet(o.getNotDomesticIssuance()))
				.put("fullFaithAndCreditObLiability", ExistenceChecker.isSet(o.getFullFaithAndCreditObLiability()))
				.put("generalFundObligationLiability", ExistenceChecker.isSet(o.getGeneralFundObligationLiability()))
				.put("revenueObligationLiability", ExistenceChecker.isSet(o.getRevenueObligationLiability()))
				.put("notContingent", ExistenceChecker.isSet(o.getNotContingent()))
				.put("excluded", ExistenceChecker.isSet(o.getExcluded()))
				.put("othReferenceEntityObligations", ExistenceChecker.isSet(o.getOthReferenceEntityObligations()))
				.put("designatedPriority", ExistenceChecker.isSet(o.getDesignatedPriority()))
				.put("cashSettlementOnly", ExistenceChecker.isSet(o.getCashSettlementOnly()))
				.put("deliveryOfCommitments", ExistenceChecker.isSet(o.getDeliveryOfCommitments()))
				.put("continuity", ExistenceChecker.isSet(o.getContinuity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Obligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Obligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
