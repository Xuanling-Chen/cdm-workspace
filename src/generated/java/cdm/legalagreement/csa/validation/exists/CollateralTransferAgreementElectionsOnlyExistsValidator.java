package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CollateralTransferAgreementElections;
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

public class CollateralTransferAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<CollateralTransferAgreementElections, Set<String>> {

	@Override
	public <T2 extends CollateralTransferAgreementElections> ValidationResult<CollateralTransferAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regime", ExistenceChecker.isSet(o.getRegime()))
				.put("oneWayProvisions", ExistenceChecker.isSet(o.getOneWayProvisions()))
				.put("generalSimmElections", ExistenceChecker.isSet(o.getGeneralSimmElections()))
				.put("identifiedCrossCurrencySwap", ExistenceChecker.isSet(o.getIdentifiedCrossCurrencySwap()))
				.put("sensitivityMethodologies", ExistenceChecker.isSet(o.getSensitivityMethodologies()))
				.put("fxHaircutCurrency", ExistenceChecker.isSet(o.getFxHaircutCurrency()))
				.put("postingObligations", ExistenceChecker.isSet(o.getPostingObligations()))
				.put("substitutedRegime", ExistenceChecker.isSet(o.getSubstitutedRegime()))
				.put("baseAndEligibleCurrency", ExistenceChecker.isSet(o.getBaseAndEligibleCurrency()))
				.put("creditSupportObligations", ExistenceChecker.isSet(o.getCreditSupportObligations()))
				.put("calculationAndTiming", ExistenceChecker.isSet(o.getCalculationAndTiming()))
				.put("conditionsPrecedent", ExistenceChecker.isSet(o.getConditionsPrecedent()))
				.put("substitution", ExistenceChecker.isSet(o.getSubstitution()))
				.put("disputeResolution", ExistenceChecker.isSet(o.getDisputeResolution()))
				.put("rightsEvents", ExistenceChecker.isSet(o.getRightsEvents()))
				.put("custodyArrangements", ExistenceChecker.isSet(o.getCustodyArrangements()))
				.put("additionalRepresentations", ExistenceChecker.isSet(o.getAdditionalRepresentations()))
				.put("demandsAndNotices", ExistenceChecker.isSet(o.getDemandsAndNotices()))
				.put("addressesForTransfer", ExistenceChecker.isSet(o.getAddressesForTransfer()))
				.put("otherCsa", ExistenceChecker.isSet(o.getOtherCsa()))
				.put("terminationCurrencyAmendment", ExistenceChecker.isSet(o.getTerminationCurrencyAmendment()))
				.put("minimumTransferAmountAmendment", ExistenceChecker.isSet(o.getMinimumTransferAmountAmendment()))
				.put("interpretationTerms", ExistenceChecker.isSet(o.getInterpretationTerms()))
				.put("processAgent", ExistenceChecker.isSet(o.getProcessAgent()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet(o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet(o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet(o.getAdditionalBespokeTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralTransferAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CollateralTransferAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
