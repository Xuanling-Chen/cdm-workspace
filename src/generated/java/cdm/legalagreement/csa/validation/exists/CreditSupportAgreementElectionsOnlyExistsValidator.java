package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CreditSupportAgreementElections;
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

public class CreditSupportAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<CreditSupportAgreementElections, Set<String>> {

	@Override
	public <T2 extends CreditSupportAgreementElections> ValidationResult<CreditSupportAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("additionalObligations", ExistenceChecker.isSet(o.getAdditionalObligations()))
				.put("coveredTransactions", ExistenceChecker.isSet(o.getCoveredTransactions()))
				.put("creditSupportObligations", ExistenceChecker.isSet(o.getCreditSupportObligations()))
				.put("exchangeDate", ExistenceChecker.isSet(o.getExchangeDate()))
				.put("calculationAndTiming", ExistenceChecker.isSet(o.getCalculationAndTiming()))
				.put("conditionsPrecedent", ExistenceChecker.isSet(o.getConditionsPrecedent()))
				.put("substitution", ExistenceChecker.isSet(o.getSubstitution()))
				.put("disputeResolution", ExistenceChecker.isSet(o.getDisputeResolution()))
				.put("holdingAndUsingPostedCollateral", ExistenceChecker.isSet(o.getHoldingAndUsingPostedCollateral()))
				.put("rightsEvents", ExistenceChecker.isSet(o.getRightsEvents()))
				.put("custodyArrangements", ExistenceChecker.isSet(o.getCustodyArrangements()))
				.put("distributionAndInterestPayment", ExistenceChecker.isSet(o.getDistributionAndInterestPayment()))
				.put("creditSupportOffsets", ExistenceChecker.isSet(o.getCreditSupportOffsets()))
				.put("additionalRepresentations", ExistenceChecker.isSet(o.getAdditionalRepresentations()))
				.put("otherEligibleAndPostedSupport", ExistenceChecker.isSet(o.getOtherEligibleAndPostedSupport()))
				.put("demandsAndNotices", ExistenceChecker.isSet(o.getDemandsAndNotices()))
				.put("addressesForTransfer", ExistenceChecker.isSet(o.getAddressesForTransfer()))
				.put("otherAgreements", ExistenceChecker.isSet(o.getOtherAgreements()))
				.put("terminationCurrencyAmendment", ExistenceChecker.isSet(o.getTerminationCurrencyAmendment()))
				.put("minimumTransferAmountAmendment", ExistenceChecker.isSet(o.getMinimumTransferAmountAmendment()))
				.put("interpretationTerms", ExistenceChecker.isSet(o.getInterpretationTerms()))
				.put("processAgent", ExistenceChecker.isSet(o.getProcessAgent()))
				.put("appropriatedCollateralValuation", ExistenceChecker.isSet(o.getAppropriatedCollateralValuation()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet(o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet(o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet(o.getAdditionalBespokeTerms()))
				.put("trustSchemeAddendum", ExistenceChecker.isSet(o.getTrustSchemeAddendum()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CreditSupportAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
