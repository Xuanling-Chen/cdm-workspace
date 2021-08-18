package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CreditSupportAgreementElectionsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The set of elections which specify a Credit Support Annex or Deed.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportAgreementElections extends RosettaModelObject {
	CreditSupportAgreementElections build();
	CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder();
	
	/**
	 * Any additional amendments that might be specified by the parties to the agreement.
	 */
	String getAdditionalAmendments();
	/**
	 * Any additional terms that might be specified applicable.
	 */
	String getAdditionalBespokeTerms();
	/**
	 * The additional obligations that might be specified by the parties to a Credit Support Agreement.
	 */
	String getAdditionalObligations();
	/**
	 * The specification Additional Representations that may be applicable to the agreement.
	 */
	AdditionalRepresentations getAdditionalRepresentations();
	/**
	 * The optional specification of address for transfer as specified by the respective parties to the agreement.
	 */
	ContactElection getAddressesForTransfer();
	/**
	 * The election for the Valuation of Appropriate Collateral.
	 */
	AppropriatedCollateralValuation getAppropriatedCollateralValuation();
	/**
	 * The base and eligible currency(ies) for the document as specified by the parties to the agreement.
	 */
	BaseAndEligibleCurrency getBaseAndEligibleCurrency();
	/**
	 * The set of elections for determining Valuation and Timing terms specific to the agreement
	 */
	CalculationAndTiming getCalculationAndTiming();
	/**
	 * The set of elections that may overwrite the default Condition Precedent provision, and the set of provisions that are deemed Access Condition.
	 */
	ConditionsPrecedent getConditionsPrecedent();
	/**
	 * The specification of transactions covered by the terms of the agreement.
	 */
	CoveredTransactions getCoveredTransactions();
	/**
	 * The Credit Support Obligations applicable to the agreement. 
	 */
	CreditSupportObligations getCreditSupportObligations();
	/**
	 * The specification of whether the standard Credit Support Offset provisions are applicable (true) or not applicable (false).
	 */
	Boolean getCreditSupportOffsets();
	/**
	 * The Custodian and Segregated Account details in respect of each party to the agreement.
	 */
	CustodyArrangements getCustodyArrangements();
	/**
	 * The optional specification of address where the demands, specifications and notices will be communicated to for each of the parties to the agreement.
	 */
	ContactElection getDemandsAndNotices();
	/**
	 * The election terms under which a party disputes (i) the Calculation Agent’s calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support.
	 */
	DisputeResolution getDisputeResolution();
	/**
	 * The Distributions and Interest Payment terms specified as part of the agreement.
	 */
	DistributionAndInterestPayment getDistributionAndInterestPayment();
	/**
	 * The bespoke exchange date terms that might be specified by the parties to the agreement.
	 */
	String getExchangeDate();
	/**
	 * The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.
	 */
	FxHaircutCurrency getFxHaircutCurrency();
	/**
	 * The specification of the ISDA SIMM Method for all Covered Transactions with respect to all Regimes.
	 */
	GeneralSimmElections getGeneralSimmElections();
	/**
	 * The elections for the holding and using of posted collateral by the respective parties to the Credit Support Annex for Variation Margin.
	 */
	HoldingAndUsingPostedCollateral getHoldingAndUsingPostedCollateral();
	/**
	 * The qualification of whether cross-currency swaps need to be identified in the Confirmation so that the obligations to exchange principal be disregarded for the purpose of determining the Delivery Amount or Return Amount.
	 */
	Boolean getIdentifiedCrossCurrencySwap();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Interpretations.
	 */
	String getInterpretationTerms();
	/**
	 * The jurisdiction specific terms relevant to the agreement.
	 */
	JurisdictionRelatedTerms getJurisdictionRelatedTerms();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.
	 */
	MinimumTransferAmountAmendment getMinimumTransferAmountAmendment();
	/**
	 * The determination of whether the One Way Provisions are applicable (true) or not applicable (false).
	 */
	OneWayProvisions getOneWayProvisions();
	/**
	 * The bespoke definition of other agreement terms as specified by the parties to the agreement.
	 */
	OtherAgreements getOtherAgreements();
	/**
	 * The Other Eligible Support elections associated with margin agreements.
	 */
	OtherEligibleAndPostedSupport getOtherEligibleAndPostedSupport();
	/**
	 * The security providers posting obligations.
	 */
	PostingObligations getPostingObligations();
	/**
	 * The Process Agent that might be appointed by the parties to the agreement.
	 */
	ProcessAgent getProcessAgent();
	/**
	 * The Regime Table provision , which determines the regulatory regime(s) applicable to each of the parties to the agreement.
	 */
	Regime getRegime();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred..
	 */
	RightsEvents getRightsEvents();
	/**
	 * The specification of methodologies to compute sensitivities specific to the agreement.
	 */
	SensitivityMethodologies getSensitivityMethodologies();
	/**
	 * The specification of Additional regimes for purposes of determining whether a Regulatory Event has occurred.
	 */
	List<? extends SubstitutedRegime> getSubstitutedRegime();
	/**
	 * The conditions under which the Security Provider can substitute posted collateral.
	 */
	Substitution getSubstitution();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Termination Currency.  Unless specified the definition of Termination Currency has the meaning specified in the Schedule to the ISDA Master Agreement.
	 */
	TerminationCurrencyAmendment getTerminationCurrencyAmendment();
	/**
	 * The qualification of whether Trust Scheme Addendum is applicable (True) or not applicable (False).
	 */
	Boolean getTrustSchemeAddendum();
	final static CreditSupportAgreementElectionsMeta metaData = new CreditSupportAgreementElectionsMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportAgreementElections> metaData() {
		return metaData;
	} 
			
	static CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder() {
		return new CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl();
	}
	
	default Class<? extends CreditSupportAgreementElections> getType() {
		return CreditSupportAgreementElections.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
		processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
		processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
		processor.processBasic(path.newSubPath("creditSupportOffsets"), Boolean.class, getCreditSupportOffsets(), this);
		processor.processBasic(path.newSubPath("exchangeDate"), String.class, getExchangeDate(), this);
		processor.processBasic(path.newSubPath("identifiedCrossCurrencySwap"), Boolean.class, getIdentifiedCrossCurrencySwap(), this);
		processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
		processor.processBasic(path.newSubPath("trustSchemeAddendum"), Boolean.class, getTrustSchemeAddendum(), this);
		
		processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.class, getAdditionalRepresentations());
		processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.class, getAddressesForTransfer());
		processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.class, getAppropriatedCollateralValuation());
		processRosetta(path.newSubPath("baseAndEligibleCurrency"), processor, BaseAndEligibleCurrency.class, getBaseAndEligibleCurrency());
		processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.class, getCalculationAndTiming());
		processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.class, getConditionsPrecedent());
		processRosetta(path.newSubPath("coveredTransactions"), processor, CoveredTransactions.class, getCoveredTransactions());
		processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.class, getCreditSupportObligations());
		processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.class, getCustodyArrangements());
		processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.class, getDemandsAndNotices());
		processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.class, getDisputeResolution());
		processRosetta(path.newSubPath("distributionAndInterestPayment"), processor, DistributionAndInterestPayment.class, getDistributionAndInterestPayment());
		processRosetta(path.newSubPath("fxHaircutCurrency"), processor, FxHaircutCurrency.class, getFxHaircutCurrency());
		processRosetta(path.newSubPath("generalSimmElections"), processor, GeneralSimmElections.class, getGeneralSimmElections());
		processRosetta(path.newSubPath("holdingAndUsingPostedCollateral"), processor, HoldingAndUsingPostedCollateral.class, getHoldingAndUsingPostedCollateral());
		processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.class, getJurisdictionRelatedTerms());
		processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.class, getMinimumTransferAmountAmendment());
		processRosetta(path.newSubPath("oneWayProvisions"), processor, OneWayProvisions.class, getOneWayProvisions());
		processRosetta(path.newSubPath("otherAgreements"), processor, OtherAgreements.class, getOtherAgreements());
		processRosetta(path.newSubPath("otherEligibleAndPostedSupport"), processor, OtherEligibleAndPostedSupport.class, getOtherEligibleAndPostedSupport());
		processRosetta(path.newSubPath("postingObligations"), processor, PostingObligations.class, getPostingObligations());
		processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.class, getProcessAgent());
		processRosetta(path.newSubPath("regime"), processor, Regime.class, getRegime());
		processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.class, getRightsEvents());
		processRosetta(path.newSubPath("sensitivityMethodologies"), processor, SensitivityMethodologies.class, getSensitivityMethodologies());
		processRosetta(path.newSubPath("substitutedRegime"), processor, SubstitutedRegime.class, getSubstitutedRegime());
		processRosetta(path.newSubPath("substitution"), processor, Substitution.class, getSubstitution());
		processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.class, getTerminationCurrencyAmendment());
	}
	
	
	interface CreditSupportAgreementElectionsBuilder extends CreditSupportAgreementElections, RosettaModelObjectBuilder {
		AdditionalRepresentations.AdditionalRepresentationsBuilder getOrCreateAdditionalRepresentations();
		AdditionalRepresentations.AdditionalRepresentationsBuilder getAdditionalRepresentations();
		ContactElection.ContactElectionBuilder getOrCreateAddressesForTransfer();
		ContactElection.ContactElectionBuilder getAddressesForTransfer();
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation();
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation();
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getOrCreateBaseAndEligibleCurrency();
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getBaseAndEligibleCurrency();
		CalculationAndTiming.CalculationAndTimingBuilder getOrCreateCalculationAndTiming();
		CalculationAndTiming.CalculationAndTimingBuilder getCalculationAndTiming();
		ConditionsPrecedent.ConditionsPrecedentBuilder getOrCreateConditionsPrecedent();
		ConditionsPrecedent.ConditionsPrecedentBuilder getConditionsPrecedent();
		CoveredTransactions.CoveredTransactionsBuilder getOrCreateCoveredTransactions();
		CoveredTransactions.CoveredTransactionsBuilder getCoveredTransactions();
		CreditSupportObligations.CreditSupportObligationsBuilder getOrCreateCreditSupportObligations();
		CreditSupportObligations.CreditSupportObligationsBuilder getCreditSupportObligations();
		CustodyArrangements.CustodyArrangementsBuilder getOrCreateCustodyArrangements();
		CustodyArrangements.CustodyArrangementsBuilder getCustodyArrangements();
		ContactElection.ContactElectionBuilder getOrCreateDemandsAndNotices();
		ContactElection.ContactElectionBuilder getDemandsAndNotices();
		DisputeResolution.DisputeResolutionBuilder getOrCreateDisputeResolution();
		DisputeResolution.DisputeResolutionBuilder getDisputeResolution();
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getOrCreateDistributionAndInterestPayment();
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getDistributionAndInterestPayment();
		FxHaircutCurrency.FxHaircutCurrencyBuilder getOrCreateFxHaircutCurrency();
		FxHaircutCurrency.FxHaircutCurrencyBuilder getFxHaircutCurrency();
		GeneralSimmElections.GeneralSimmElectionsBuilder getOrCreateGeneralSimmElections();
		GeneralSimmElections.GeneralSimmElectionsBuilder getGeneralSimmElections();
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getOrCreateHoldingAndUsingPostedCollateral();
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getHoldingAndUsingPostedCollateral();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getOrCreateMinimumTransferAmountAmendment();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getMinimumTransferAmountAmendment();
		OneWayProvisions.OneWayProvisionsBuilder getOrCreateOneWayProvisions();
		OneWayProvisions.OneWayProvisionsBuilder getOneWayProvisions();
		OtherAgreements.OtherAgreementsBuilder getOrCreateOtherAgreements();
		OtherAgreements.OtherAgreementsBuilder getOtherAgreements();
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOrCreateOtherEligibleAndPostedSupport();
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOtherEligibleAndPostedSupport();
		PostingObligations.PostingObligationsBuilder getOrCreatePostingObligations();
		PostingObligations.PostingObligationsBuilder getPostingObligations();
		ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent();
		ProcessAgent.ProcessAgentBuilder getProcessAgent();
		Regime.RegimeBuilder getOrCreateRegime();
		Regime.RegimeBuilder getRegime();
		RightsEvents.RightsEventsBuilder getOrCreateRightsEvents();
		RightsEvents.RightsEventsBuilder getRightsEvents();
		SensitivityMethodologies.SensitivityMethodologiesBuilder getOrCreateSensitivityMethodologies();
		SensitivityMethodologies.SensitivityMethodologiesBuilder getSensitivityMethodologies();
		SubstitutedRegime.SubstitutedRegimeBuilder getOrCreateSubstitutedRegime(int _index);
		List<? extends SubstitutedRegime.SubstitutedRegimeBuilder> getSubstitutedRegime();
		Substitution.SubstitutionBuilder getOrCreateSubstitution();
		Substitution.SubstitutionBuilder getSubstitution();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getOrCreateTerminationCurrencyAmendment();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getTerminationCurrencyAmendment();
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalObligations(String additionalObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations additionalRepresentations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAddressesForTransfer(ContactElection addressesForTransfer);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency baseAndEligibleCurrency);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming calculationAndTiming);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent conditionsPrecedent);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCoveredTransactions(CoveredTransactions coveredTransactions);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations creditSupportObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportOffsets(Boolean creditSupportOffsets);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements custodyArrangements);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDemandsAndNotices(ContactElection demandsAndNotices);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDisputeResolution(DisputeResolution disputeResolution);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDistributionAndInterestPayment(DistributionAndInterestPayment distributionAndInterestPayment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setExchangeDate(String exchangeDate);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency fxHaircutCurrency);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections generalSimmElections);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setHoldingAndUsingPostedCollateral(HoldingAndUsingPostedCollateral holdingAndUsingPostedCollateral);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean identifiedCrossCurrencySwap);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setInterpretationTerms(String interpretationTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment minimumTransferAmountAmendment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions oneWayProvisions);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherAgreements(OtherAgreements otherAgreements);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherEligibleAndPostedSupport(OtherEligibleAndPostedSupport otherEligibleAndPostedSupport);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setPostingObligations(PostingObligations postingObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRegime(Regime regime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRightsEvents(RightsEvents rightsEvents);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies sensitivityMethodologies);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime, int _idx);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitution(Substitution substitution);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment terminationCurrencyAmendment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTrustSchemeAddendum(Boolean trustSchemeAddendum);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
			processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
			processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
			processor.processBasic(path.newSubPath("creditSupportOffsets"), Boolean.class, getCreditSupportOffsets(), this);
			processor.processBasic(path.newSubPath("exchangeDate"), String.class, getExchangeDate(), this);
			processor.processBasic(path.newSubPath("identifiedCrossCurrencySwap"), Boolean.class, getIdentifiedCrossCurrencySwap(), this);
			processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
			processor.processBasic(path.newSubPath("trustSchemeAddendum"), Boolean.class, getTrustSchemeAddendum(), this);
			
			processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.AdditionalRepresentationsBuilder.class, getAdditionalRepresentations());
			processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.ContactElectionBuilder.class, getAddressesForTransfer());
			processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder.class, getAppropriatedCollateralValuation());
			processRosetta(path.newSubPath("baseAndEligibleCurrency"), processor, BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder.class, getBaseAndEligibleCurrency());
			processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.CalculationAndTimingBuilder.class, getCalculationAndTiming());
			processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.ConditionsPrecedentBuilder.class, getConditionsPrecedent());
			processRosetta(path.newSubPath("coveredTransactions"), processor, CoveredTransactions.CoveredTransactionsBuilder.class, getCoveredTransactions());
			processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.CreditSupportObligationsBuilder.class, getCreditSupportObligations());
			processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.CustodyArrangementsBuilder.class, getCustodyArrangements());
			processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.ContactElectionBuilder.class, getDemandsAndNotices());
			processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.DisputeResolutionBuilder.class, getDisputeResolution());
			processRosetta(path.newSubPath("distributionAndInterestPayment"), processor, DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder.class, getDistributionAndInterestPayment());
			processRosetta(path.newSubPath("fxHaircutCurrency"), processor, FxHaircutCurrency.FxHaircutCurrencyBuilder.class, getFxHaircutCurrency());
			processRosetta(path.newSubPath("generalSimmElections"), processor, GeneralSimmElections.GeneralSimmElectionsBuilder.class, getGeneralSimmElections());
			processRosetta(path.newSubPath("holdingAndUsingPostedCollateral"), processor, HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder.class, getHoldingAndUsingPostedCollateral());
			processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder.class, getJurisdictionRelatedTerms());
			processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder.class, getMinimumTransferAmountAmendment());
			processRosetta(path.newSubPath("oneWayProvisions"), processor, OneWayProvisions.OneWayProvisionsBuilder.class, getOneWayProvisions());
			processRosetta(path.newSubPath("otherAgreements"), processor, OtherAgreements.OtherAgreementsBuilder.class, getOtherAgreements());
			processRosetta(path.newSubPath("otherEligibleAndPostedSupport"), processor, OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder.class, getOtherEligibleAndPostedSupport());
			processRosetta(path.newSubPath("postingObligations"), processor, PostingObligations.PostingObligationsBuilder.class, getPostingObligations());
			processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.ProcessAgentBuilder.class, getProcessAgent());
			processRosetta(path.newSubPath("regime"), processor, Regime.RegimeBuilder.class, getRegime());
			processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.RightsEventsBuilder.class, getRightsEvents());
			processRosetta(path.newSubPath("sensitivityMethodologies"), processor, SensitivityMethodologies.SensitivityMethodologiesBuilder.class, getSensitivityMethodologies());
			processRosetta(path.newSubPath("substitutedRegime"), processor, SubstitutedRegime.SubstitutedRegimeBuilder.class, getSubstitutedRegime());
			processRosetta(path.newSubPath("substitution"), processor, Substitution.SubstitutionBuilder.class, getSubstitution());
			processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder.class, getTerminationCurrencyAmendment());
		}
		
	}
	
	//CreditSupportAgreementElections.CreditSupportAgreementElectionsImpl
	class CreditSupportAgreementElectionsImpl implements CreditSupportAgreementElections {
		private final String additionalAmendments;
		private final String additionalBespokeTerms;
		private final String additionalObligations;
		private final AdditionalRepresentations additionalRepresentations;
		private final ContactElection addressesForTransfer;
		private final AppropriatedCollateralValuation appropriatedCollateralValuation;
		private final BaseAndEligibleCurrency baseAndEligibleCurrency;
		private final CalculationAndTiming calculationAndTiming;
		private final ConditionsPrecedent conditionsPrecedent;
		private final CoveredTransactions coveredTransactions;
		private final CreditSupportObligations creditSupportObligations;
		private final Boolean creditSupportOffsets;
		private final CustodyArrangements custodyArrangements;
		private final ContactElection demandsAndNotices;
		private final DisputeResolution disputeResolution;
		private final DistributionAndInterestPayment distributionAndInterestPayment;
		private final String exchangeDate;
		private final FxHaircutCurrency fxHaircutCurrency;
		private final GeneralSimmElections generalSimmElections;
		private final HoldingAndUsingPostedCollateral holdingAndUsingPostedCollateral;
		private final Boolean identifiedCrossCurrencySwap;
		private final String interpretationTerms;
		private final JurisdictionRelatedTerms jurisdictionRelatedTerms;
		private final MinimumTransferAmountAmendment minimumTransferAmountAmendment;
		private final OneWayProvisions oneWayProvisions;
		private final OtherAgreements otherAgreements;
		private final OtherEligibleAndPostedSupport otherEligibleAndPostedSupport;
		private final PostingObligations postingObligations;
		private final ProcessAgent processAgent;
		private final Regime regime;
		private final RightsEvents rightsEvents;
		private final SensitivityMethodologies sensitivityMethodologies;
		private final List<? extends SubstitutedRegime> substitutedRegime;
		private final Substitution substitution;
		private final TerminationCurrencyAmendment terminationCurrencyAmendment;
		private final Boolean trustSchemeAddendum;
		
		protected CreditSupportAgreementElectionsImpl(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
			this.additionalAmendments = builder.getAdditionalAmendments();
			this.additionalBespokeTerms = builder.getAdditionalBespokeTerms();
			this.additionalObligations = builder.getAdditionalObligations();
			this.additionalRepresentations = ofNullable(builder.getAdditionalRepresentations()).map(f->f.build()).orElse(null);
			this.addressesForTransfer = ofNullable(builder.getAddressesForTransfer()).map(f->f.build()).orElse(null);
			this.appropriatedCollateralValuation = ofNullable(builder.getAppropriatedCollateralValuation()).map(f->f.build()).orElse(null);
			this.baseAndEligibleCurrency = ofNullable(builder.getBaseAndEligibleCurrency()).map(f->f.build()).orElse(null);
			this.calculationAndTiming = ofNullable(builder.getCalculationAndTiming()).map(f->f.build()).orElse(null);
			this.conditionsPrecedent = ofNullable(builder.getConditionsPrecedent()).map(f->f.build()).orElse(null);
			this.coveredTransactions = ofNullable(builder.getCoveredTransactions()).map(f->f.build()).orElse(null);
			this.creditSupportObligations = ofNullable(builder.getCreditSupportObligations()).map(f->f.build()).orElse(null);
			this.creditSupportOffsets = builder.getCreditSupportOffsets();
			this.custodyArrangements = ofNullable(builder.getCustodyArrangements()).map(f->f.build()).orElse(null);
			this.demandsAndNotices = ofNullable(builder.getDemandsAndNotices()).map(f->f.build()).orElse(null);
			this.disputeResolution = ofNullable(builder.getDisputeResolution()).map(f->f.build()).orElse(null);
			this.distributionAndInterestPayment = ofNullable(builder.getDistributionAndInterestPayment()).map(f->f.build()).orElse(null);
			this.exchangeDate = builder.getExchangeDate();
			this.fxHaircutCurrency = ofNullable(builder.getFxHaircutCurrency()).map(f->f.build()).orElse(null);
			this.generalSimmElections = ofNullable(builder.getGeneralSimmElections()).map(f->f.build()).orElse(null);
			this.holdingAndUsingPostedCollateral = ofNullable(builder.getHoldingAndUsingPostedCollateral()).map(f->f.build()).orElse(null);
			this.identifiedCrossCurrencySwap = builder.getIdentifiedCrossCurrencySwap();
			this.interpretationTerms = builder.getInterpretationTerms();
			this.jurisdictionRelatedTerms = ofNullable(builder.getJurisdictionRelatedTerms()).map(f->f.build()).orElse(null);
			this.minimumTransferAmountAmendment = ofNullable(builder.getMinimumTransferAmountAmendment()).map(f->f.build()).orElse(null);
			this.oneWayProvisions = ofNullable(builder.getOneWayProvisions()).map(f->f.build()).orElse(null);
			this.otherAgreements = ofNullable(builder.getOtherAgreements()).map(f->f.build()).orElse(null);
			this.otherEligibleAndPostedSupport = ofNullable(builder.getOtherEligibleAndPostedSupport()).map(f->f.build()).orElse(null);
			this.postingObligations = ofNullable(builder.getPostingObligations()).map(f->f.build()).orElse(null);
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
			this.regime = ofNullable(builder.getRegime()).map(f->f.build()).orElse(null);
			this.rightsEvents = ofNullable(builder.getRightsEvents()).map(f->f.build()).orElse(null);
			this.sensitivityMethodologies = ofNullable(builder.getSensitivityMethodologies()).map(f->f.build()).orElse(null);
			this.substitutedRegime = ofNullable(builder.getSubstitutedRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.substitution = ofNullable(builder.getSubstitution()).map(f->f.build()).orElse(null);
			this.terminationCurrencyAmendment = ofNullable(builder.getTerminationCurrencyAmendment()).map(f->f.build()).orElse(null);
			this.trustSchemeAddendum = builder.getTrustSchemeAddendum();
		}
		
		@Override
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public AdditionalRepresentations getAdditionalRepresentations() {
			return additionalRepresentations;
		}
		
		@Override
		public ContactElection getAddressesForTransfer() {
			return addressesForTransfer;
		}
		
		@Override
		public AppropriatedCollateralValuation getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public BaseAndEligibleCurrency getBaseAndEligibleCurrency() {
			return baseAndEligibleCurrency;
		}
		
		@Override
		public CalculationAndTiming getCalculationAndTiming() {
			return calculationAndTiming;
		}
		
		@Override
		public ConditionsPrecedent getConditionsPrecedent() {
			return conditionsPrecedent;
		}
		
		@Override
		public CoveredTransactions getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		public CreditSupportObligations getCreditSupportObligations() {
			return creditSupportObligations;
		}
		
		@Override
		public Boolean getCreditSupportOffsets() {
			return creditSupportOffsets;
		}
		
		@Override
		public CustodyArrangements getCustodyArrangements() {
			return custodyArrangements;
		}
		
		@Override
		public ContactElection getDemandsAndNotices() {
			return demandsAndNotices;
		}
		
		@Override
		public DisputeResolution getDisputeResolution() {
			return disputeResolution;
		}
		
		@Override
		public DistributionAndInterestPayment getDistributionAndInterestPayment() {
			return distributionAndInterestPayment;
		}
		
		@Override
		public String getExchangeDate() {
			return exchangeDate;
		}
		
		@Override
		public FxHaircutCurrency getFxHaircutCurrency() {
			return fxHaircutCurrency;
		}
		
		@Override
		public GeneralSimmElections getGeneralSimmElections() {
			return generalSimmElections;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral getHoldingAndUsingPostedCollateral() {
			return holdingAndUsingPostedCollateral;
		}
		
		@Override
		public Boolean getIdentifiedCrossCurrencySwap() {
			return identifiedCrossCurrencySwap;
		}
		
		@Override
		public String getInterpretationTerms() {
			return interpretationTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public MinimumTransferAmountAmendment getMinimumTransferAmountAmendment() {
			return minimumTransferAmountAmendment;
		}
		
		@Override
		public OneWayProvisions getOneWayProvisions() {
			return oneWayProvisions;
		}
		
		@Override
		public OtherAgreements getOtherAgreements() {
			return otherAgreements;
		}
		
		@Override
		public OtherEligibleAndPostedSupport getOtherEligibleAndPostedSupport() {
			return otherEligibleAndPostedSupport;
		}
		
		@Override
		public PostingObligations getPostingObligations() {
			return postingObligations;
		}
		
		@Override
		public ProcessAgent getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public Regime getRegime() {
			return regime;
		}
		
		@Override
		public RightsEvents getRightsEvents() {
			return rightsEvents;
		}
		
		@Override
		public SensitivityMethodologies getSensitivityMethodologies() {
			return sensitivityMethodologies;
		}
		
		@Override
		public List<? extends SubstitutedRegime> getSubstitutedRegime() {
			return substitutedRegime;
		}
		
		@Override
		public Substitution getSubstitution() {
			return substitution;
		}
		
		@Override
		public TerminationCurrencyAmendment getTerminationCurrencyAmendment() {
			return terminationCurrencyAmendment;
		}
		
		@Override
		public Boolean getTrustSchemeAddendum() {
			return trustSchemeAddendum;
		}
		
		@Override
		public CreditSupportAgreementElections build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
			ofNullable(getAdditionalAmendments()).ifPresent(builder::setAdditionalAmendments);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
			ofNullable(getAdditionalRepresentations()).ifPresent(builder::setAdditionalRepresentations);
			ofNullable(getAddressesForTransfer()).ifPresent(builder::setAddressesForTransfer);
			ofNullable(getAppropriatedCollateralValuation()).ifPresent(builder::setAppropriatedCollateralValuation);
			ofNullable(getBaseAndEligibleCurrency()).ifPresent(builder::setBaseAndEligibleCurrency);
			ofNullable(getCalculationAndTiming()).ifPresent(builder::setCalculationAndTiming);
			ofNullable(getConditionsPrecedent()).ifPresent(builder::setConditionsPrecedent);
			ofNullable(getCoveredTransactions()).ifPresent(builder::setCoveredTransactions);
			ofNullable(getCreditSupportObligations()).ifPresent(builder::setCreditSupportObligations);
			ofNullable(getCreditSupportOffsets()).ifPresent(builder::setCreditSupportOffsets);
			ofNullable(getCustodyArrangements()).ifPresent(builder::setCustodyArrangements);
			ofNullable(getDemandsAndNotices()).ifPresent(builder::setDemandsAndNotices);
			ofNullable(getDisputeResolution()).ifPresent(builder::setDisputeResolution);
			ofNullable(getDistributionAndInterestPayment()).ifPresent(builder::setDistributionAndInterestPayment);
			ofNullable(getExchangeDate()).ifPresent(builder::setExchangeDate);
			ofNullable(getFxHaircutCurrency()).ifPresent(builder::setFxHaircutCurrency);
			ofNullable(getGeneralSimmElections()).ifPresent(builder::setGeneralSimmElections);
			ofNullable(getHoldingAndUsingPostedCollateral()).ifPresent(builder::setHoldingAndUsingPostedCollateral);
			ofNullable(getIdentifiedCrossCurrencySwap()).ifPresent(builder::setIdentifiedCrossCurrencySwap);
			ofNullable(getInterpretationTerms()).ifPresent(builder::setInterpretationTerms);
			ofNullable(getJurisdictionRelatedTerms()).ifPresent(builder::setJurisdictionRelatedTerms);
			ofNullable(getMinimumTransferAmountAmendment()).ifPresent(builder::setMinimumTransferAmountAmendment);
			ofNullable(getOneWayProvisions()).ifPresent(builder::setOneWayProvisions);
			ofNullable(getOtherAgreements()).ifPresent(builder::setOtherAgreements);
			ofNullable(getOtherEligibleAndPostedSupport()).ifPresent(builder::setOtherEligibleAndPostedSupport);
			ofNullable(getPostingObligations()).ifPresent(builder::setPostingObligations);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getRightsEvents()).ifPresent(builder::setRightsEvents);
			ofNullable(getSensitivityMethodologies()).ifPresent(builder::setSensitivityMethodologies);
			ofNullable(getSubstitutedRegime()).ifPresent(builder::setSubstitutedRegime);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
			ofNullable(getTerminationCurrencyAmendment()).ifPresent(builder::setTerminationCurrencyAmendment);
			ofNullable(getTrustSchemeAddendum()).ifPresent(builder::setTrustSchemeAddendum);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(creditSupportOffsets, _that.getCreditSupportOffsets())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(distributionAndInterestPayment, _that.getDistributionAndInterestPayment())) return false;
			if (!Objects.equals(exchangeDate, _that.getExchangeDate())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(holdingAndUsingPostedCollateral, _that.getHoldingAndUsingPostedCollateral())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(otherAgreements, _that.getOtherAgreements())) return false;
			if (!Objects.equals(otherEligibleAndPostedSupport, _that.getOtherEligibleAndPostedSupport())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(trustSchemeAddendum, _that.getTrustSchemeAddendum())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (baseAndEligibleCurrency != null ? baseAndEligibleCurrency.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (creditSupportOffsets != null ? creditSupportOffsets.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (distributionAndInterestPayment != null ? distributionAndInterestPayment.hashCode() : 0);
			_result = 31 * _result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
			_result = 31 * _result + (fxHaircutCurrency != null ? fxHaircutCurrency.hashCode() : 0);
			_result = 31 * _result + (generalSimmElections != null ? generalSimmElections.hashCode() : 0);
			_result = 31 * _result + (holdingAndUsingPostedCollateral != null ? holdingAndUsingPostedCollateral.hashCode() : 0);
			_result = 31 * _result + (identifiedCrossCurrencySwap != null ? identifiedCrossCurrencySwap.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (oneWayProvisions != null ? oneWayProvisions.hashCode() : 0);
			_result = 31 * _result + (otherAgreements != null ? otherAgreements.hashCode() : 0);
			_result = 31 * _result + (otherEligibleAndPostedSupport != null ? otherEligibleAndPostedSupport.hashCode() : 0);
			_result = 31 * _result + (postingObligations != null ? postingObligations.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (sensitivityMethodologies != null ? sensitivityMethodologies.hashCode() : 0);
			_result = 31 * _result + (substitutedRegime != null ? substitutedRegime.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (trustSchemeAddendum != null ? trustSchemeAddendum.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElections {" +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"creditSupportOffsets=" + this.creditSupportOffsets + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"distributionAndInterestPayment=" + this.distributionAndInterestPayment + ", " +
				"exchangeDate=" + this.exchangeDate + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"holdingAndUsingPostedCollateral=" + this.holdingAndUsingPostedCollateral + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"otherAgreements=" + this.otherAgreements + ", " +
				"otherEligibleAndPostedSupport=" + this.otherEligibleAndPostedSupport + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"processAgent=" + this.processAgent + ", " +
				"regime=" + this.regime + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"substitution=" + this.substitution + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"trustSchemeAddendum=" + this.trustSchemeAddendum +
			'}';
		}
	}
	
	//CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl
	class CreditSupportAgreementElectionsBuilderImpl implements CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder {
	
		protected String additionalAmendments;
		protected String additionalBespokeTerms;
		protected String additionalObligations;
		protected AdditionalRepresentations.AdditionalRepresentationsBuilder additionalRepresentations;
		protected ContactElection.ContactElectionBuilder addressesForTransfer;
		protected AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder appropriatedCollateralValuation;
		protected BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder baseAndEligibleCurrency;
		protected CalculationAndTiming.CalculationAndTimingBuilder calculationAndTiming;
		protected ConditionsPrecedent.ConditionsPrecedentBuilder conditionsPrecedent;
		protected CoveredTransactions.CoveredTransactionsBuilder coveredTransactions;
		protected CreditSupportObligations.CreditSupportObligationsBuilder creditSupportObligations;
		protected Boolean creditSupportOffsets;
		protected CustodyArrangements.CustodyArrangementsBuilder custodyArrangements;
		protected ContactElection.ContactElectionBuilder demandsAndNotices;
		protected DisputeResolution.DisputeResolutionBuilder disputeResolution;
		protected DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder distributionAndInterestPayment;
		protected String exchangeDate;
		protected FxHaircutCurrency.FxHaircutCurrencyBuilder fxHaircutCurrency;
		protected GeneralSimmElections.GeneralSimmElectionsBuilder generalSimmElections;
		protected HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder holdingAndUsingPostedCollateral;
		protected Boolean identifiedCrossCurrencySwap;
		protected String interpretationTerms;
		protected JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder jurisdictionRelatedTerms;
		protected MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder minimumTransferAmountAmendment;
		protected OneWayProvisions.OneWayProvisionsBuilder oneWayProvisions;
		protected OtherAgreements.OtherAgreementsBuilder otherAgreements;
		protected OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder otherEligibleAndPostedSupport;
		protected PostingObligations.PostingObligationsBuilder postingObligations;
		protected ProcessAgent.ProcessAgentBuilder processAgent;
		protected Regime.RegimeBuilder regime;
		protected RightsEvents.RightsEventsBuilder rightsEvents;
		protected SensitivityMethodologies.SensitivityMethodologiesBuilder sensitivityMethodologies;
		protected List<SubstitutedRegime.SubstitutedRegimeBuilder> substitutedRegime = new ArrayList<>();
		protected Substitution.SubstitutionBuilder substitution;
		protected TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder terminationCurrencyAmendment;
		protected Boolean trustSchemeAddendum;
	
		public CreditSupportAgreementElectionsBuilderImpl() {
		}
	
		@Override
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder getAdditionalRepresentations() {
			return additionalRepresentations;
		}
		
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder getOrCreateAdditionalRepresentations() {
			AdditionalRepresentations.AdditionalRepresentationsBuilder result;
			if (additionalRepresentations!=null) {
				result = additionalRepresentations;
			}
			else {
				result = additionalRepresentations = AdditionalRepresentations.builder();
			}
			
			return result;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getAddressesForTransfer() {
			return addressesForTransfer;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getOrCreateAddressesForTransfer() {
			ContactElection.ContactElectionBuilder result;
			if (addressesForTransfer!=null) {
				result = addressesForTransfer;
			}
			else {
				result = addressesForTransfer = ContactElection.builder();
			}
			
			return result;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder result;
			if (appropriatedCollateralValuation!=null) {
				result = appropriatedCollateralValuation;
			}
			else {
				result = appropriatedCollateralValuation = AppropriatedCollateralValuation.builder();
			}
			
			return result;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getBaseAndEligibleCurrency() {
			return baseAndEligibleCurrency;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getOrCreateBaseAndEligibleCurrency() {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder result;
			if (baseAndEligibleCurrency!=null) {
				result = baseAndEligibleCurrency;
			}
			else {
				result = baseAndEligibleCurrency = BaseAndEligibleCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder getCalculationAndTiming() {
			return calculationAndTiming;
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder getOrCreateCalculationAndTiming() {
			CalculationAndTiming.CalculationAndTimingBuilder result;
			if (calculationAndTiming!=null) {
				result = calculationAndTiming;
			}
			else {
				result = calculationAndTiming = CalculationAndTiming.builder();
			}
			
			return result;
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder getConditionsPrecedent() {
			return conditionsPrecedent;
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder getOrCreateConditionsPrecedent() {
			ConditionsPrecedent.ConditionsPrecedentBuilder result;
			if (conditionsPrecedent!=null) {
				result = conditionsPrecedent;
			}
			else {
				result = conditionsPrecedent = ConditionsPrecedent.builder();
			}
			
			return result;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder getOrCreateCoveredTransactions() {
			CoveredTransactions.CoveredTransactionsBuilder result;
			if (coveredTransactions!=null) {
				result = coveredTransactions;
			}
			else {
				result = coveredTransactions = CoveredTransactions.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder getCreditSupportObligations() {
			return creditSupportObligations;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder getOrCreateCreditSupportObligations() {
			CreditSupportObligations.CreditSupportObligationsBuilder result;
			if (creditSupportObligations!=null) {
				result = creditSupportObligations;
			}
			else {
				result = creditSupportObligations = CreditSupportObligations.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getCreditSupportOffsets() {
			return creditSupportOffsets;
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder getCustodyArrangements() {
			return custodyArrangements;
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder getOrCreateCustodyArrangements() {
			CustodyArrangements.CustodyArrangementsBuilder result;
			if (custodyArrangements!=null) {
				result = custodyArrangements;
			}
			else {
				result = custodyArrangements = CustodyArrangements.builder();
			}
			
			return result;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getDemandsAndNotices() {
			return demandsAndNotices;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getOrCreateDemandsAndNotices() {
			ContactElection.ContactElectionBuilder result;
			if (demandsAndNotices!=null) {
				result = demandsAndNotices;
			}
			else {
				result = demandsAndNotices = ContactElection.builder();
			}
			
			return result;
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder getDisputeResolution() {
			return disputeResolution;
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder getOrCreateDisputeResolution() {
			DisputeResolution.DisputeResolutionBuilder result;
			if (disputeResolution!=null) {
				result = disputeResolution;
			}
			else {
				result = disputeResolution = DisputeResolution.builder();
			}
			
			return result;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getDistributionAndInterestPayment() {
			return distributionAndInterestPayment;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getOrCreateDistributionAndInterestPayment() {
			DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder result;
			if (distributionAndInterestPayment!=null) {
				result = distributionAndInterestPayment;
			}
			else {
				result = distributionAndInterestPayment = DistributionAndInterestPayment.builder();
			}
			
			return result;
		}
		
		@Override
		public String getExchangeDate() {
			return exchangeDate;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder getFxHaircutCurrency() {
			return fxHaircutCurrency;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder getOrCreateFxHaircutCurrency() {
			FxHaircutCurrency.FxHaircutCurrencyBuilder result;
			if (fxHaircutCurrency!=null) {
				result = fxHaircutCurrency;
			}
			else {
				result = fxHaircutCurrency = FxHaircutCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder getGeneralSimmElections() {
			return generalSimmElections;
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder getOrCreateGeneralSimmElections() {
			GeneralSimmElections.GeneralSimmElectionsBuilder result;
			if (generalSimmElections!=null) {
				result = generalSimmElections;
			}
			else {
				result = generalSimmElections = GeneralSimmElections.builder();
			}
			
			return result;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getHoldingAndUsingPostedCollateral() {
			return holdingAndUsingPostedCollateral;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getOrCreateHoldingAndUsingPostedCollateral() {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder result;
			if (holdingAndUsingPostedCollateral!=null) {
				result = holdingAndUsingPostedCollateral;
			}
			else {
				result = holdingAndUsingPostedCollateral = HoldingAndUsingPostedCollateral.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getIdentifiedCrossCurrencySwap() {
			return identifiedCrossCurrencySwap;
		}
		
		@Override
		public String getInterpretationTerms() {
			return interpretationTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder result;
			if (jurisdictionRelatedTerms!=null) {
				result = jurisdictionRelatedTerms;
			}
			else {
				result = jurisdictionRelatedTerms = JurisdictionRelatedTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getMinimumTransferAmountAmendment() {
			return minimumTransferAmountAmendment;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getOrCreateMinimumTransferAmountAmendment() {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder result;
			if (minimumTransferAmountAmendment!=null) {
				result = minimumTransferAmountAmendment;
			}
			else {
				result = minimumTransferAmountAmendment = MinimumTransferAmountAmendment.builder();
			}
			
			return result;
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder getOneWayProvisions() {
			return oneWayProvisions;
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder getOrCreateOneWayProvisions() {
			OneWayProvisions.OneWayProvisionsBuilder result;
			if (oneWayProvisions!=null) {
				result = oneWayProvisions;
			}
			else {
				result = oneWayProvisions = OneWayProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder getOtherAgreements() {
			return otherAgreements;
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder getOrCreateOtherAgreements() {
			OtherAgreements.OtherAgreementsBuilder result;
			if (otherAgreements!=null) {
				result = otherAgreements;
			}
			else {
				result = otherAgreements = OtherAgreements.builder();
			}
			
			return result;
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOtherEligibleAndPostedSupport() {
			return otherEligibleAndPostedSupport;
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOrCreateOtherEligibleAndPostedSupport() {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder result;
			if (otherEligibleAndPostedSupport!=null) {
				result = otherEligibleAndPostedSupport;
			}
			else {
				result = otherEligibleAndPostedSupport = OtherEligibleAndPostedSupport.builder();
			}
			
			return result;
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder getPostingObligations() {
			return postingObligations;
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder getOrCreatePostingObligations() {
			PostingObligations.PostingObligationsBuilder result;
			if (postingObligations!=null) {
				result = postingObligations;
			}
			else {
				result = postingObligations = PostingObligations.builder();
			}
			
			return result;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent() {
			ProcessAgent.ProcessAgentBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = ProcessAgent.builder();
			}
			
			return result;
		}
		
		@Override
		public Regime.RegimeBuilder getRegime() {
			return regime;
		}
		
		@Override
		public Regime.RegimeBuilder getOrCreateRegime() {
			Regime.RegimeBuilder result;
			if (regime!=null) {
				result = regime;
			}
			else {
				result = regime = Regime.builder();
			}
			
			return result;
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder getRightsEvents() {
			return rightsEvents;
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder getOrCreateRightsEvents() {
			RightsEvents.RightsEventsBuilder result;
			if (rightsEvents!=null) {
				result = rightsEvents;
			}
			else {
				result = rightsEvents = RightsEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder getSensitivityMethodologies() {
			return sensitivityMethodologies;
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder getOrCreateSensitivityMethodologies() {
			SensitivityMethodologies.SensitivityMethodologiesBuilder result;
			if (sensitivityMethodologies!=null) {
				result = sensitivityMethodologies;
			}
			else {
				result = sensitivityMethodologies = SensitivityMethodologies.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends SubstitutedRegime.SubstitutedRegimeBuilder> getSubstitutedRegime() {
			return substitutedRegime;
		}
		
		public SubstitutedRegime.SubstitutedRegimeBuilder getOrCreateSubstitutedRegime(int _index) {
		
			if (substitutedRegime==null) {
				this.substitutedRegime = new ArrayList<>();
			}
			SubstitutedRegime.SubstitutedRegimeBuilder result;
			return getIndex(substitutedRegime, _index, () -> {
						SubstitutedRegime.SubstitutedRegimeBuilder newSubstitutedRegime = SubstitutedRegime.builder();
						return newSubstitutedRegime;
					});
		}
		
		@Override
		public Substitution.SubstitutionBuilder getSubstitution() {
			return substitution;
		}
		
		@Override
		public Substitution.SubstitutionBuilder getOrCreateSubstitution() {
			Substitution.SubstitutionBuilder result;
			if (substitution!=null) {
				result = substitution;
			}
			else {
				result = substitution = Substitution.builder();
			}
			
			return result;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getTerminationCurrencyAmendment() {
			return terminationCurrencyAmendment;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getOrCreateTerminationCurrencyAmendment() {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder result;
			if (terminationCurrencyAmendment!=null) {
				result = terminationCurrencyAmendment;
			}
			else {
				result = terminationCurrencyAmendment = TerminationCurrencyAmendment.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getTrustSchemeAddendum() {
			return trustSchemeAddendum;
		}
		
	
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments) {
			this.additionalAmendments = additionalAmendments==null?null:additionalAmendments;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms) {
			this.additionalBespokeTerms = additionalBespokeTerms==null?null:additionalBespokeTerms;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalObligations(String additionalObligations) {
			this.additionalObligations = additionalObligations==null?null:additionalObligations;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations additionalRepresentations) {
			this.additionalRepresentations = additionalRepresentations==null?null:additionalRepresentations.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAddressesForTransfer(ContactElection addressesForTransfer) {
			this.addressesForTransfer = addressesForTransfer==null?null:addressesForTransfer.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation) {
			this.appropriatedCollateralValuation = appropriatedCollateralValuation==null?null:appropriatedCollateralValuation.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency baseAndEligibleCurrency) {
			this.baseAndEligibleCurrency = baseAndEligibleCurrency==null?null:baseAndEligibleCurrency.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming calculationAndTiming) {
			this.calculationAndTiming = calculationAndTiming==null?null:calculationAndTiming.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent conditionsPrecedent) {
			this.conditionsPrecedent = conditionsPrecedent==null?null:conditionsPrecedent.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCoveredTransactions(CoveredTransactions coveredTransactions) {
			this.coveredTransactions = coveredTransactions==null?null:coveredTransactions.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations creditSupportObligations) {
			this.creditSupportObligations = creditSupportObligations==null?null:creditSupportObligations.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportOffsets(Boolean creditSupportOffsets) {
			this.creditSupportOffsets = creditSupportOffsets==null?null:creditSupportOffsets;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements custodyArrangements) {
			this.custodyArrangements = custodyArrangements==null?null:custodyArrangements.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDemandsAndNotices(ContactElection demandsAndNotices) {
			this.demandsAndNotices = demandsAndNotices==null?null:demandsAndNotices.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDisputeResolution(DisputeResolution disputeResolution) {
			this.disputeResolution = disputeResolution==null?null:disputeResolution.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDistributionAndInterestPayment(DistributionAndInterestPayment distributionAndInterestPayment) {
			this.distributionAndInterestPayment = distributionAndInterestPayment==null?null:distributionAndInterestPayment.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setExchangeDate(String exchangeDate) {
			this.exchangeDate = exchangeDate==null?null:exchangeDate;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency fxHaircutCurrency) {
			this.fxHaircutCurrency = fxHaircutCurrency==null?null:fxHaircutCurrency.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections generalSimmElections) {
			this.generalSimmElections = generalSimmElections==null?null:generalSimmElections.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setHoldingAndUsingPostedCollateral(HoldingAndUsingPostedCollateral holdingAndUsingPostedCollateral) {
			this.holdingAndUsingPostedCollateral = holdingAndUsingPostedCollateral==null?null:holdingAndUsingPostedCollateral.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean identifiedCrossCurrencySwap) {
			this.identifiedCrossCurrencySwap = identifiedCrossCurrencySwap==null?null:identifiedCrossCurrencySwap;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setInterpretationTerms(String interpretationTerms) {
			this.interpretationTerms = interpretationTerms==null?null:interpretationTerms;
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms) {
			this.jurisdictionRelatedTerms = jurisdictionRelatedTerms==null?null:jurisdictionRelatedTerms.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment minimumTransferAmountAmendment) {
			this.minimumTransferAmountAmendment = minimumTransferAmountAmendment==null?null:minimumTransferAmountAmendment.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions oneWayProvisions) {
			this.oneWayProvisions = oneWayProvisions==null?null:oneWayProvisions.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherAgreements(OtherAgreements otherAgreements) {
			this.otherAgreements = otherAgreements==null?null:otherAgreements.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherEligibleAndPostedSupport(OtherEligibleAndPostedSupport otherEligibleAndPostedSupport) {
			this.otherEligibleAndPostedSupport = otherEligibleAndPostedSupport==null?null:otherEligibleAndPostedSupport.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setPostingObligations(PostingObligations postingObligations) {
			this.postingObligations = postingObligations==null?null:postingObligations.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent) {
			this.processAgent = processAgent==null?null:processAgent.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRegime(Regime regime) {
			this.regime = regime==null?null:regime.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRightsEvents(RightsEvents rightsEvents) {
			this.rightsEvents = rightsEvents==null?null:rightsEvents.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies sensitivityMethodologies) {
			this.sensitivityMethodologies = sensitivityMethodologies==null?null:sensitivityMethodologies.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime) {
			if (substitutedRegime!=null) this.substitutedRegime.add(substitutedRegime.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime, int _idx) {
			getIndex(this.substitutedRegime, _idx, () -> substitutedRegime.toBuilder());
			return this;
		}
		@Override 
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
			if (substitutedRegimes != null) {
				for (SubstitutedRegime toAdd : substitutedRegimes) {
					this.substitutedRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
			if (substitutedRegimes == null)  {
				this.substitutedRegime = new ArrayList<>();
			}
			else {
				this.substitutedRegime = substitutedRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitution(Substitution substitution) {
			this.substitution = substitution==null?null:substitution.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment terminationCurrencyAmendment) {
			this.terminationCurrencyAmendment = terminationCurrencyAmendment==null?null:terminationCurrencyAmendment.toBuilder();
			return this;
		}
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTrustSchemeAddendum(Boolean trustSchemeAddendum) {
			this.trustSchemeAddendum = trustSchemeAddendum==null?null:trustSchemeAddendum;
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections build() {
			return new CreditSupportAgreementElections.CreditSupportAgreementElectionsImpl(this);
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder prune() {
			if (additionalRepresentations!=null && !additionalRepresentations.prune().hasData()) additionalRepresentations = null;
			if (addressesForTransfer!=null && !addressesForTransfer.prune().hasData()) addressesForTransfer = null;
			if (appropriatedCollateralValuation!=null && !appropriatedCollateralValuation.prune().hasData()) appropriatedCollateralValuation = null;
			if (baseAndEligibleCurrency!=null && !baseAndEligibleCurrency.prune().hasData()) baseAndEligibleCurrency = null;
			if (calculationAndTiming!=null && !calculationAndTiming.prune().hasData()) calculationAndTiming = null;
			if (conditionsPrecedent!=null && !conditionsPrecedent.prune().hasData()) conditionsPrecedent = null;
			if (coveredTransactions!=null && !coveredTransactions.prune().hasData()) coveredTransactions = null;
			if (creditSupportObligations!=null && !creditSupportObligations.prune().hasData()) creditSupportObligations = null;
			if (custodyArrangements!=null && !custodyArrangements.prune().hasData()) custodyArrangements = null;
			if (demandsAndNotices!=null && !demandsAndNotices.prune().hasData()) demandsAndNotices = null;
			if (disputeResolution!=null && !disputeResolution.prune().hasData()) disputeResolution = null;
			if (distributionAndInterestPayment!=null && !distributionAndInterestPayment.prune().hasData()) distributionAndInterestPayment = null;
			if (fxHaircutCurrency!=null && !fxHaircutCurrency.prune().hasData()) fxHaircutCurrency = null;
			if (generalSimmElections!=null && !generalSimmElections.prune().hasData()) generalSimmElections = null;
			if (holdingAndUsingPostedCollateral!=null && !holdingAndUsingPostedCollateral.prune().hasData()) holdingAndUsingPostedCollateral = null;
			if (jurisdictionRelatedTerms!=null && !jurisdictionRelatedTerms.prune().hasData()) jurisdictionRelatedTerms = null;
			if (minimumTransferAmountAmendment!=null && !minimumTransferAmountAmendment.prune().hasData()) minimumTransferAmountAmendment = null;
			if (oneWayProvisions!=null && !oneWayProvisions.prune().hasData()) oneWayProvisions = null;
			if (otherAgreements!=null && !otherAgreements.prune().hasData()) otherAgreements = null;
			if (otherEligibleAndPostedSupport!=null && !otherEligibleAndPostedSupport.prune().hasData()) otherEligibleAndPostedSupport = null;
			if (postingObligations!=null && !postingObligations.prune().hasData()) postingObligations = null;
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			if (regime!=null && !regime.prune().hasData()) regime = null;
			if (rightsEvents!=null && !rightsEvents.prune().hasData()) rightsEvents = null;
			if (sensitivityMethodologies!=null && !sensitivityMethodologies.prune().hasData()) sensitivityMethodologies = null;
			substitutedRegime = substitutedRegime.stream().filter(b->b!=null).<SubstitutedRegime.SubstitutedRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (substitution!=null && !substitution.prune().hasData()) substitution = null;
			if (terminationCurrencyAmendment!=null && !terminationCurrencyAmendment.prune().hasData()) terminationCurrencyAmendment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalAmendments()!=null) return true;
			if (getAdditionalBespokeTerms()!=null) return true;
			if (getAdditionalObligations()!=null) return true;
			if (getAdditionalRepresentations()!=null && getAdditionalRepresentations().hasData()) return true;
			if (getAddressesForTransfer()!=null && getAddressesForTransfer().hasData()) return true;
			if (getAppropriatedCollateralValuation()!=null && getAppropriatedCollateralValuation().hasData()) return true;
			if (getBaseAndEligibleCurrency()!=null && getBaseAndEligibleCurrency().hasData()) return true;
			if (getCalculationAndTiming()!=null && getCalculationAndTiming().hasData()) return true;
			if (getConditionsPrecedent()!=null && getConditionsPrecedent().hasData()) return true;
			if (getCoveredTransactions()!=null && getCoveredTransactions().hasData()) return true;
			if (getCreditSupportObligations()!=null && getCreditSupportObligations().hasData()) return true;
			if (getCreditSupportOffsets()!=null) return true;
			if (getCustodyArrangements()!=null && getCustodyArrangements().hasData()) return true;
			if (getDemandsAndNotices()!=null && getDemandsAndNotices().hasData()) return true;
			if (getDisputeResolution()!=null && getDisputeResolution().hasData()) return true;
			if (getDistributionAndInterestPayment()!=null && getDistributionAndInterestPayment().hasData()) return true;
			if (getExchangeDate()!=null) return true;
			if (getFxHaircutCurrency()!=null && getFxHaircutCurrency().hasData()) return true;
			if (getGeneralSimmElections()!=null && getGeneralSimmElections().hasData()) return true;
			if (getHoldingAndUsingPostedCollateral()!=null && getHoldingAndUsingPostedCollateral().hasData()) return true;
			if (getIdentifiedCrossCurrencySwap()!=null) return true;
			if (getInterpretationTerms()!=null) return true;
			if (getJurisdictionRelatedTerms()!=null && getJurisdictionRelatedTerms().hasData()) return true;
			if (getMinimumTransferAmountAmendment()!=null && getMinimumTransferAmountAmendment().hasData()) return true;
			if (getOneWayProvisions()!=null && getOneWayProvisions().hasData()) return true;
			if (getOtherAgreements()!=null && getOtherAgreements().hasData()) return true;
			if (getOtherEligibleAndPostedSupport()!=null && getOtherEligibleAndPostedSupport().hasData()) return true;
			if (getPostingObligations()!=null && getPostingObligations().hasData()) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			if (getRegime()!=null && getRegime().hasData()) return true;
			if (getRightsEvents()!=null && getRightsEvents().hasData()) return true;
			if (getSensitivityMethodologies()!=null && getSensitivityMethodologies().hasData()) return true;
			if (getSubstitutedRegime()!=null && getSubstitutedRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubstitution()!=null && getSubstitution().hasData()) return true;
			if (getTerminationCurrencyAmendment()!=null && getTerminationCurrencyAmendment().hasData()) return true;
			if (getTrustSchemeAddendum()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder o = (CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getAdditionalRepresentations(), o.getAdditionalRepresentations(), this::setAdditionalRepresentations);
			merger.mergeRosetta(getAddressesForTransfer(), o.getAddressesForTransfer(), this::setAddressesForTransfer);
			merger.mergeRosetta(getAppropriatedCollateralValuation(), o.getAppropriatedCollateralValuation(), this::setAppropriatedCollateralValuation);
			merger.mergeRosetta(getBaseAndEligibleCurrency(), o.getBaseAndEligibleCurrency(), this::setBaseAndEligibleCurrency);
			merger.mergeRosetta(getCalculationAndTiming(), o.getCalculationAndTiming(), this::setCalculationAndTiming);
			merger.mergeRosetta(getConditionsPrecedent(), o.getConditionsPrecedent(), this::setConditionsPrecedent);
			merger.mergeRosetta(getCoveredTransactions(), o.getCoveredTransactions(), this::setCoveredTransactions);
			merger.mergeRosetta(getCreditSupportObligations(), o.getCreditSupportObligations(), this::setCreditSupportObligations);
			merger.mergeRosetta(getCustodyArrangements(), o.getCustodyArrangements(), this::setCustodyArrangements);
			merger.mergeRosetta(getDemandsAndNotices(), o.getDemandsAndNotices(), this::setDemandsAndNotices);
			merger.mergeRosetta(getDisputeResolution(), o.getDisputeResolution(), this::setDisputeResolution);
			merger.mergeRosetta(getDistributionAndInterestPayment(), o.getDistributionAndInterestPayment(), this::setDistributionAndInterestPayment);
			merger.mergeRosetta(getFxHaircutCurrency(), o.getFxHaircutCurrency(), this::setFxHaircutCurrency);
			merger.mergeRosetta(getGeneralSimmElections(), o.getGeneralSimmElections(), this::setGeneralSimmElections);
			merger.mergeRosetta(getHoldingAndUsingPostedCollateral(), o.getHoldingAndUsingPostedCollateral(), this::setHoldingAndUsingPostedCollateral);
			merger.mergeRosetta(getJurisdictionRelatedTerms(), o.getJurisdictionRelatedTerms(), this::setJurisdictionRelatedTerms);
			merger.mergeRosetta(getMinimumTransferAmountAmendment(), o.getMinimumTransferAmountAmendment(), this::setMinimumTransferAmountAmendment);
			merger.mergeRosetta(getOneWayProvisions(), o.getOneWayProvisions(), this::setOneWayProvisions);
			merger.mergeRosetta(getOtherAgreements(), o.getOtherAgreements(), this::setOtherAgreements);
			merger.mergeRosetta(getOtherEligibleAndPostedSupport(), o.getOtherEligibleAndPostedSupport(), this::setOtherEligibleAndPostedSupport);
			merger.mergeRosetta(getPostingObligations(), o.getPostingObligations(), this::setPostingObligations);
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			merger.mergeRosetta(getRegime(), o.getRegime(), this::setRegime);
			merger.mergeRosetta(getRightsEvents(), o.getRightsEvents(), this::setRightsEvents);
			merger.mergeRosetta(getSensitivityMethodologies(), o.getSensitivityMethodologies(), this::setSensitivityMethodologies);
			merger.mergeRosetta(getSubstitutedRegime(), o.getSubstitutedRegime(), this::getOrCreateSubstitutedRegime);
			merger.mergeRosetta(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			merger.mergeRosetta(getTerminationCurrencyAmendment(), o.getTerminationCurrencyAmendment(), this::setTerminationCurrencyAmendment);
			
			merger.mergeBasic(getAdditionalAmendments(), o.getAdditionalAmendments(), this::setAdditionalAmendments);
			merger.mergeBasic(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::setAdditionalBespokeTerms);
			merger.mergeBasic(getAdditionalObligations(), o.getAdditionalObligations(), this::setAdditionalObligations);
			merger.mergeBasic(getCreditSupportOffsets(), o.getCreditSupportOffsets(), this::setCreditSupportOffsets);
			merger.mergeBasic(getExchangeDate(), o.getExchangeDate(), this::setExchangeDate);
			merger.mergeBasic(getIdentifiedCrossCurrencySwap(), o.getIdentifiedCrossCurrencySwap(), this::setIdentifiedCrossCurrencySwap);
			merger.mergeBasic(getInterpretationTerms(), o.getInterpretationTerms(), this::setInterpretationTerms);
			merger.mergeBasic(getTrustSchemeAddendum(), o.getTrustSchemeAddendum(), this::setTrustSchemeAddendum);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(creditSupportOffsets, _that.getCreditSupportOffsets())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(distributionAndInterestPayment, _that.getDistributionAndInterestPayment())) return false;
			if (!Objects.equals(exchangeDate, _that.getExchangeDate())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(holdingAndUsingPostedCollateral, _that.getHoldingAndUsingPostedCollateral())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(otherAgreements, _that.getOtherAgreements())) return false;
			if (!Objects.equals(otherEligibleAndPostedSupport, _that.getOtherEligibleAndPostedSupport())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(trustSchemeAddendum, _that.getTrustSchemeAddendum())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (baseAndEligibleCurrency != null ? baseAndEligibleCurrency.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (creditSupportOffsets != null ? creditSupportOffsets.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (distributionAndInterestPayment != null ? distributionAndInterestPayment.hashCode() : 0);
			_result = 31 * _result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
			_result = 31 * _result + (fxHaircutCurrency != null ? fxHaircutCurrency.hashCode() : 0);
			_result = 31 * _result + (generalSimmElections != null ? generalSimmElections.hashCode() : 0);
			_result = 31 * _result + (holdingAndUsingPostedCollateral != null ? holdingAndUsingPostedCollateral.hashCode() : 0);
			_result = 31 * _result + (identifiedCrossCurrencySwap != null ? identifiedCrossCurrencySwap.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (oneWayProvisions != null ? oneWayProvisions.hashCode() : 0);
			_result = 31 * _result + (otherAgreements != null ? otherAgreements.hashCode() : 0);
			_result = 31 * _result + (otherEligibleAndPostedSupport != null ? otherEligibleAndPostedSupport.hashCode() : 0);
			_result = 31 * _result + (postingObligations != null ? postingObligations.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (regime != null ? regime.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (sensitivityMethodologies != null ? sensitivityMethodologies.hashCode() : 0);
			_result = 31 * _result + (substitutedRegime != null ? substitutedRegime.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (trustSchemeAddendum != null ? trustSchemeAddendum.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElectionsBuilder {" +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"creditSupportOffsets=" + this.creditSupportOffsets + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"distributionAndInterestPayment=" + this.distributionAndInterestPayment + ", " +
				"exchangeDate=" + this.exchangeDate + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"holdingAndUsingPostedCollateral=" + this.holdingAndUsingPostedCollateral + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"otherAgreements=" + this.otherAgreements + ", " +
				"otherEligibleAndPostedSupport=" + this.otherEligibleAndPostedSupport + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"processAgent=" + this.processAgent + ", " +
				"regime=" + this.regime + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"substitution=" + this.substitution + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"trustSchemeAddendum=" + this.trustSchemeAddendum +
			'}';
		}
	}
}
