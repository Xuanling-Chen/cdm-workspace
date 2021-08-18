package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CreditSupportAgreementElections;
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

public class CreditSupportAgreementElectionsValidator implements Validator<CreditSupportAgreementElections> {

	@Override
	public ValidationResult<CreditSupportAgreementElections> validate(RosettaPath path, CreditSupportAgreementElections o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("regime", o.getRegime()!=null ? 1 : 0, 1, 1),
				checkCardinality("oneWayProvisions", o.getOneWayProvisions()!=null ? 1 : 0, 1, 1),
				checkCardinality("generalSimmElections", o.getGeneralSimmElections()!=null ? 1 : 0, 0, 1),
				checkCardinality("identifiedCrossCurrencySwap", o.getIdentifiedCrossCurrencySwap()!=null ? 1 : 0, 0, 1),
				checkCardinality("sensitivityMethodologies", o.getSensitivityMethodologies()!=null ? 1 : 0, 1, 1),
				checkCardinality("fxHaircutCurrency", o.getFxHaircutCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("postingObligations", o.getPostingObligations()!=null ? 1 : 0, 1, 1),
				checkCardinality("substitutedRegime", o.getSubstitutedRegime()==null?0:o.getSubstitutedRegime().size(), 0, 0),
				checkCardinality("baseAndEligibleCurrency", o.getBaseAndEligibleCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("additionalObligations", o.getAdditionalObligations()!=null ? 1 : 0, 0, 1),
				checkCardinality("coveredTransactions", o.getCoveredTransactions()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditSupportObligations", o.getCreditSupportObligations()!=null ? 1 : 0, 1, 1),
				checkCardinality("exchangeDate", o.getExchangeDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAndTiming", o.getCalculationAndTiming()!=null ? 1 : 0, 1, 1),
				checkCardinality("conditionsPrecedent", o.getConditionsPrecedent()!=null ? 1 : 0, 0, 1),
				checkCardinality("substitution", o.getSubstitution()!=null ? 1 : 0, 1, 1),
				checkCardinality("disputeResolution", o.getDisputeResolution()!=null ? 1 : 0, 1, 1),
				checkCardinality("holdingAndUsingPostedCollateral", o.getHoldingAndUsingPostedCollateral()!=null ? 1 : 0, 1, 1),
				checkCardinality("rightsEvents", o.getRightsEvents()!=null ? 1 : 0, 1, 1),
				checkCardinality("custodyArrangements", o.getCustodyArrangements()!=null ? 1 : 0, 0, 1),
				checkCardinality("distributionAndInterestPayment", o.getDistributionAndInterestPayment()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditSupportOffsets", o.getCreditSupportOffsets()!=null ? 1 : 0, 1, 1),
				checkCardinality("additionalRepresentations", o.getAdditionalRepresentations()!=null ? 1 : 0, 1, 1),
				checkCardinality("otherEligibleAndPostedSupport", o.getOtherEligibleAndPostedSupport()!=null ? 1 : 0, 1, 1),
				checkCardinality("demandsAndNotices", o.getDemandsAndNotices()!=null ? 1 : 0, 0, 1),
				checkCardinality("addressesForTransfer", o.getAddressesForTransfer()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherAgreements", o.getOtherAgreements()!=null ? 1 : 0, 0, 1),
				checkCardinality("terminationCurrencyAmendment", o.getTerminationCurrencyAmendment()!=null ? 1 : 0, 1, 1),
				checkCardinality("minimumTransferAmountAmendment", o.getMinimumTransferAmountAmendment()!=null ? 1 : 0, 1, 1),
				checkCardinality("interpretationTerms", o.getInterpretationTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("processAgent", o.getProcessAgent()!=null ? 1 : 0, 0, 1),
				checkCardinality("appropriatedCollateralValuation", o.getAppropriatedCollateralValuation()!=null ? 1 : 0, 0, 1),
				checkCardinality("jurisdictionRelatedTerms", o.getJurisdictionRelatedTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalAmendments", o.getAdditionalAmendments()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalBespokeTerms", o.getAdditionalBespokeTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("trustSchemeAddendum", o.getTrustSchemeAddendum()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportAgreementElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditSupportAgreementElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
