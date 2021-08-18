package cdm.event.common;

import cdm.event.common.meta.LineageMeta;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder;
import cdm.event.common.metafields.ReferenceWithMetaTransferPrimitive;
import cdm.event.common.metafields.ReferenceWithMetaTransferPrimitive.ReferenceWithMetaTransferPrimitiveBuilder;
import cdm.event.position.PortfolioState;
import cdm.event.position.PortfolioState;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder;
import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashflow;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashflow.ReferenceWithMetaCashflowBuilder;
import cdm.product.template.EquityPayout;
import cdm.product.template.EquityPayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaOptionPayout;
import cdm.product.template.metafields.ReferenceWithMetaOptionPayout.ReferenceWithMetaOptionPayoutBuilder;
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
 * A class to provide lineage information across lifecycle events through a pointer or set of pointers into the event(s), contract(s) and, possibly, payout components that the event is dependent on or relates to. As an example, if an contractFormation event is corrected, the correction event will have a lineage into the initial event, which takes the form of a globalKey into that initial contract formation event. Two referencing mechanisms are provided as part of the CDM: either the globalKey, which corresponds to the hash value of the CDM class which is referred to, or a reference qualifier which is meant to provide support for the ingestion of xml documents with id/href mechanisms. The CDM recommends the use of the globalKey and provides a default implementation which is accessible in the generated code through org.isda.cdm.globalKey.GlobalKeyHashCalculator. If implementers want to use an alternative hashing mechanism, the API in which they need to plug it is com.rosetta.model.lib.HashFunction.
 * @version ${project.version}
 */
@RosettaClass

public interface Lineage extends RosettaModelObject {
	Lineage build();
	Lineage.LineageBuilder toBuilder();
	
	/**
	 * The reference to the instantiation of a Cashflow payout component object. An expected typical usage is to provide lineage for the payment of, say, the option premium or the swap initial fee. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaCashflow> getCashflowReference();
	/**
	 * The reference to the instantiation of a CreditdefaultPayout component object. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaCreditDefaultPayout> getCreditDefaultPayoutReference();
	/**
	 * The reference to the instantiation of a EquityPayout object. An expected typical usage is to provide lineage for the payment of, say, an equity dividend. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaEquityPayout> getEquityPayoutReference();
	/**
	 * The reference to the instantiation of an Event object, either through a globalKey or an xml-derived id/href mechanism. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaWorkflowStep> getEventReference();
	/**
	 * The reference to the instantiation of a InterestRatePayout component object. An expected typical usage is to provide lineage for the payment of, say, an interest rate swap reset, with the ability to relate the gross cashflow amounts to the respective payout components. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaInterestRatePayout> getInterestRatePayoutReference();
	/**
	 * The reference to the instantiation of a Legal Agreement object. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaLegalAgreement> getLegalAgreement();
	/**
	 * The reference to the instantiation of a OptionPayout component object. The definition associated to the Lineage class provides more details with respect to those referencing approaches, their expected usage and available implementation.
	 */
	List<? extends ReferenceWithMetaOptionPayout> getOptionPayoutReference();
	/**
	 * The refence to the previous state of a Portfolio, in a chain of Events leading up to a build of that Portfolio as the holding of Product(s) in specific Quantity(ies). As part of the PortfolioState object, a pointer to the previous PortfolioState is provided through a Lineage object, together with pointer(s) to the Event or set of Events leading up to the current (new) state.
	 */
	List<? extends ReferenceWithMetaPortfolioState> getPortfolioStateReference();
	/**
	 */
	List<? extends ReferenceWithMetaTrade> getTradeReference();
	/**
	 * The reference to the instantiation of a TransferPrimitive object.
	 */
	List<? extends ReferenceWithMetaTransferPrimitive> getTransferReference();
	final static LineageMeta metaData = new LineageMeta();
	
	@Override
	default RosettaMetaData<? extends Lineage> metaData() {
		return metaData;
	} 
			
	static Lineage.LineageBuilder builder() {
		return new Lineage.LineageBuilderImpl();
	}
	
	default Class<? extends Lineage> getType() {
		return Lineage.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("cashflowReference"), processor, ReferenceWithMetaCashflow.class, getCashflowReference());
		processRosetta(path.newSubPath("creditDefaultPayoutReference"), processor, ReferenceWithMetaCreditDefaultPayout.class, getCreditDefaultPayoutReference());
		processRosetta(path.newSubPath("equityPayoutReference"), processor, ReferenceWithMetaEquityPayout.class, getEquityPayoutReference());
		processRosetta(path.newSubPath("eventReference"), processor, ReferenceWithMetaWorkflowStep.class, getEventReference());
		processRosetta(path.newSubPath("interestRatePayoutReference"), processor, ReferenceWithMetaInterestRatePayout.class, getInterestRatePayoutReference());
		processRosetta(path.newSubPath("legalAgreement"), processor, ReferenceWithMetaLegalAgreement.class, getLegalAgreement());
		processRosetta(path.newSubPath("optionPayoutReference"), processor, ReferenceWithMetaOptionPayout.class, getOptionPayoutReference());
		processRosetta(path.newSubPath("portfolioStateReference"), processor, ReferenceWithMetaPortfolioState.class, getPortfolioStateReference());
		processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTrade.class, getTradeReference());
		processRosetta(path.newSubPath("transferReference"), processor, ReferenceWithMetaTransferPrimitive.class, getTransferReference());
	}
	
	
	interface LineageBuilder extends Lineage, RosettaModelObjectBuilder {
		ReferenceWithMetaCashflowBuilder getOrCreateCashflowReference(int _index);
		List<? extends ReferenceWithMetaCashflowBuilder> getCashflowReference();
		ReferenceWithMetaCreditDefaultPayoutBuilder getOrCreateCreditDefaultPayoutReference(int _index);
		List<? extends ReferenceWithMetaCreditDefaultPayoutBuilder> getCreditDefaultPayoutReference();
		ReferenceWithMetaEquityPayoutBuilder getOrCreateEquityPayoutReference(int _index);
		List<? extends ReferenceWithMetaEquityPayoutBuilder> getEquityPayoutReference();
		ReferenceWithMetaWorkflowStepBuilder getOrCreateEventReference(int _index);
		List<? extends ReferenceWithMetaWorkflowStepBuilder> getEventReference();
		ReferenceWithMetaInterestRatePayoutBuilder getOrCreateInterestRatePayoutReference(int _index);
		List<? extends ReferenceWithMetaInterestRatePayoutBuilder> getInterestRatePayoutReference();
		ReferenceWithMetaLegalAgreementBuilder getOrCreateLegalAgreement(int _index);
		List<? extends ReferenceWithMetaLegalAgreementBuilder> getLegalAgreement();
		ReferenceWithMetaOptionPayoutBuilder getOrCreateOptionPayoutReference(int _index);
		List<? extends ReferenceWithMetaOptionPayoutBuilder> getOptionPayoutReference();
		ReferenceWithMetaPortfolioStateBuilder getOrCreatePortfolioStateReference(int _index);
		List<? extends ReferenceWithMetaPortfolioStateBuilder> getPortfolioStateReference();
		ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index);
		List<? extends ReferenceWithMetaTradeBuilder> getTradeReference();
		ReferenceWithMetaTransferPrimitiveBuilder getOrCreateTransferReference(int _index);
		List<? extends ReferenceWithMetaTransferPrimitiveBuilder> getTransferReference();
		Lineage.LineageBuilder addCashflowReference(ReferenceWithMetaCashflow cashflowReference);
		Lineage.LineageBuilder addCashflowReference(ReferenceWithMetaCashflow cashflowReference, int _idx);
		Lineage.LineageBuilder addCashflowReferenceValue(Cashflow cashflowReference);
		Lineage.LineageBuilder addCashflowReferenceValue(Cashflow cashflowReference, int _idx);
		Lineage.LineageBuilder addCashflowReference(List<? extends ReferenceWithMetaCashflow> cashflowReference);
		Lineage.LineageBuilder setCashflowReference(List<? extends ReferenceWithMetaCashflow> cashflowReference);
		Lineage.LineageBuilder addCashflowReferenceValue(List<? extends Cashflow> cashflowReference);
		Lineage.LineageBuilder setCashflowReferenceValue(List<? extends Cashflow> cashflowReference);
		Lineage.LineageBuilder addCreditDefaultPayoutReference(ReferenceWithMetaCreditDefaultPayout creditDefaultPayoutReference);
		Lineage.LineageBuilder addCreditDefaultPayoutReference(ReferenceWithMetaCreditDefaultPayout creditDefaultPayoutReference, int _idx);
		Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(CreditDefaultPayout creditDefaultPayoutReference);
		Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(CreditDefaultPayout creditDefaultPayoutReference, int _idx);
		Lineage.LineageBuilder addCreditDefaultPayoutReference(List<? extends ReferenceWithMetaCreditDefaultPayout> creditDefaultPayoutReference);
		Lineage.LineageBuilder setCreditDefaultPayoutReference(List<? extends ReferenceWithMetaCreditDefaultPayout> creditDefaultPayoutReference);
		Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(List<? extends CreditDefaultPayout> creditDefaultPayoutReference);
		Lineage.LineageBuilder setCreditDefaultPayoutReferenceValue(List<? extends CreditDefaultPayout> creditDefaultPayoutReference);
		Lineage.LineageBuilder addEquityPayoutReference(ReferenceWithMetaEquityPayout equityPayoutReference);
		Lineage.LineageBuilder addEquityPayoutReference(ReferenceWithMetaEquityPayout equityPayoutReference, int _idx);
		Lineage.LineageBuilder addEquityPayoutReferenceValue(EquityPayout equityPayoutReference);
		Lineage.LineageBuilder addEquityPayoutReferenceValue(EquityPayout equityPayoutReference, int _idx);
		Lineage.LineageBuilder addEquityPayoutReference(List<? extends ReferenceWithMetaEquityPayout> equityPayoutReference);
		Lineage.LineageBuilder setEquityPayoutReference(List<? extends ReferenceWithMetaEquityPayout> equityPayoutReference);
		Lineage.LineageBuilder addEquityPayoutReferenceValue(List<? extends EquityPayout> equityPayoutReference);
		Lineage.LineageBuilder setEquityPayoutReferenceValue(List<? extends EquityPayout> equityPayoutReference);
		Lineage.LineageBuilder addEventReference(ReferenceWithMetaWorkflowStep eventReference);
		Lineage.LineageBuilder addEventReference(ReferenceWithMetaWorkflowStep eventReference, int _idx);
		Lineage.LineageBuilder addEventReferenceValue(WorkflowStep eventReference);
		Lineage.LineageBuilder addEventReferenceValue(WorkflowStep eventReference, int _idx);
		Lineage.LineageBuilder addEventReference(List<? extends ReferenceWithMetaWorkflowStep> eventReference);
		Lineage.LineageBuilder setEventReference(List<? extends ReferenceWithMetaWorkflowStep> eventReference);
		Lineage.LineageBuilder addEventReferenceValue(List<? extends WorkflowStep> eventReference);
		Lineage.LineageBuilder setEventReferenceValue(List<? extends WorkflowStep> eventReference);
		Lineage.LineageBuilder addInterestRatePayoutReference(ReferenceWithMetaInterestRatePayout interestRatePayoutReference);
		Lineage.LineageBuilder addInterestRatePayoutReference(ReferenceWithMetaInterestRatePayout interestRatePayoutReference, int _idx);
		Lineage.LineageBuilder addInterestRatePayoutReferenceValue(InterestRatePayout interestRatePayoutReference);
		Lineage.LineageBuilder addInterestRatePayoutReferenceValue(InterestRatePayout interestRatePayoutReference, int _idx);
		Lineage.LineageBuilder addInterestRatePayoutReference(List<? extends ReferenceWithMetaInterestRatePayout> interestRatePayoutReference);
		Lineage.LineageBuilder setInterestRatePayoutReference(List<? extends ReferenceWithMetaInterestRatePayout> interestRatePayoutReference);
		Lineage.LineageBuilder addInterestRatePayoutReferenceValue(List<? extends InterestRatePayout> interestRatePayoutReference);
		Lineage.LineageBuilder setInterestRatePayoutReferenceValue(List<? extends InterestRatePayout> interestRatePayoutReference);
		Lineage.LineageBuilder addLegalAgreement(ReferenceWithMetaLegalAgreement legalAgreement);
		Lineage.LineageBuilder addLegalAgreement(ReferenceWithMetaLegalAgreement legalAgreement, int _idx);
		Lineage.LineageBuilder addLegalAgreementValue(LegalAgreement legalAgreement);
		Lineage.LineageBuilder addLegalAgreementValue(LegalAgreement legalAgreement, int _idx);
		Lineage.LineageBuilder addLegalAgreement(List<? extends ReferenceWithMetaLegalAgreement> legalAgreement);
		Lineage.LineageBuilder setLegalAgreement(List<? extends ReferenceWithMetaLegalAgreement> legalAgreement);
		Lineage.LineageBuilder addLegalAgreementValue(List<? extends LegalAgreement> legalAgreement);
		Lineage.LineageBuilder setLegalAgreementValue(List<? extends LegalAgreement> legalAgreement);
		Lineage.LineageBuilder addOptionPayoutReference(ReferenceWithMetaOptionPayout optionPayoutReference);
		Lineage.LineageBuilder addOptionPayoutReference(ReferenceWithMetaOptionPayout optionPayoutReference, int _idx);
		Lineage.LineageBuilder addOptionPayoutReferenceValue(OptionPayout optionPayoutReference);
		Lineage.LineageBuilder addOptionPayoutReferenceValue(OptionPayout optionPayoutReference, int _idx);
		Lineage.LineageBuilder addOptionPayoutReference(List<? extends ReferenceWithMetaOptionPayout> optionPayoutReference);
		Lineage.LineageBuilder setOptionPayoutReference(List<? extends ReferenceWithMetaOptionPayout> optionPayoutReference);
		Lineage.LineageBuilder addOptionPayoutReferenceValue(List<? extends OptionPayout> optionPayoutReference);
		Lineage.LineageBuilder setOptionPayoutReferenceValue(List<? extends OptionPayout> optionPayoutReference);
		Lineage.LineageBuilder addPortfolioStateReference(ReferenceWithMetaPortfolioState portfolioStateReference);
		Lineage.LineageBuilder addPortfolioStateReference(ReferenceWithMetaPortfolioState portfolioStateReference, int _idx);
		Lineage.LineageBuilder addPortfolioStateReferenceValue(PortfolioState portfolioStateReference);
		Lineage.LineageBuilder addPortfolioStateReferenceValue(PortfolioState portfolioStateReference, int _idx);
		Lineage.LineageBuilder addPortfolioStateReference(List<? extends ReferenceWithMetaPortfolioState> portfolioStateReference);
		Lineage.LineageBuilder setPortfolioStateReference(List<? extends ReferenceWithMetaPortfolioState> portfolioStateReference);
		Lineage.LineageBuilder addPortfolioStateReferenceValue(List<? extends PortfolioState> portfolioStateReference);
		Lineage.LineageBuilder setPortfolioStateReferenceValue(List<? extends PortfolioState> portfolioStateReference);
		Lineage.LineageBuilder addTradeReference(ReferenceWithMetaTrade tradeReference);
		Lineage.LineageBuilder addTradeReference(ReferenceWithMetaTrade tradeReference, int _idx);
		Lineage.LineageBuilder addTradeReferenceValue(Trade tradeReference);
		Lineage.LineageBuilder addTradeReferenceValue(Trade tradeReference, int _idx);
		Lineage.LineageBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		Lineage.LineageBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		Lineage.LineageBuilder addTradeReferenceValue(List<? extends Trade> tradeReference);
		Lineage.LineageBuilder setTradeReferenceValue(List<? extends Trade> tradeReference);
		Lineage.LineageBuilder addTransferReference(ReferenceWithMetaTransferPrimitive transferReference);
		Lineage.LineageBuilder addTransferReference(ReferenceWithMetaTransferPrimitive transferReference, int _idx);
		Lineage.LineageBuilder addTransferReferenceValue(TransferPrimitive transferReference);
		Lineage.LineageBuilder addTransferReferenceValue(TransferPrimitive transferReference, int _idx);
		Lineage.LineageBuilder addTransferReference(List<? extends ReferenceWithMetaTransferPrimitive> transferReference);
		Lineage.LineageBuilder setTransferReference(List<? extends ReferenceWithMetaTransferPrimitive> transferReference);
		Lineage.LineageBuilder addTransferReferenceValue(List<? extends TransferPrimitive> transferReference);
		Lineage.LineageBuilder setTransferReferenceValue(List<? extends TransferPrimitive> transferReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("cashflowReference"), processor, ReferenceWithMetaCashflowBuilder.class, getCashflowReference());
			processRosetta(path.newSubPath("creditDefaultPayoutReference"), processor, ReferenceWithMetaCreditDefaultPayoutBuilder.class, getCreditDefaultPayoutReference());
			processRosetta(path.newSubPath("equityPayoutReference"), processor, ReferenceWithMetaEquityPayoutBuilder.class, getEquityPayoutReference());
			processRosetta(path.newSubPath("eventReference"), processor, ReferenceWithMetaWorkflowStepBuilder.class, getEventReference());
			processRosetta(path.newSubPath("interestRatePayoutReference"), processor, ReferenceWithMetaInterestRatePayoutBuilder.class, getInterestRatePayoutReference());
			processRosetta(path.newSubPath("legalAgreement"), processor, ReferenceWithMetaLegalAgreementBuilder.class, getLegalAgreement());
			processRosetta(path.newSubPath("optionPayoutReference"), processor, ReferenceWithMetaOptionPayoutBuilder.class, getOptionPayoutReference());
			processRosetta(path.newSubPath("portfolioStateReference"), processor, ReferenceWithMetaPortfolioStateBuilder.class, getPortfolioStateReference());
			processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTradeBuilder.class, getTradeReference());
			processRosetta(path.newSubPath("transferReference"), processor, ReferenceWithMetaTransferPrimitiveBuilder.class, getTransferReference());
		}
		
	}
	
	//Lineage.LineageImpl
	class LineageImpl implements Lineage {
		private final List<? extends ReferenceWithMetaCashflow> cashflowReference;
		private final List<? extends ReferenceWithMetaCreditDefaultPayout> creditDefaultPayoutReference;
		private final List<? extends ReferenceWithMetaEquityPayout> equityPayoutReference;
		private final List<? extends ReferenceWithMetaWorkflowStep> eventReference;
		private final List<? extends ReferenceWithMetaInterestRatePayout> interestRatePayoutReference;
		private final List<? extends ReferenceWithMetaLegalAgreement> legalAgreement;
		private final List<? extends ReferenceWithMetaOptionPayout> optionPayoutReference;
		private final List<? extends ReferenceWithMetaPortfolioState> portfolioStateReference;
		private final List<? extends ReferenceWithMetaTrade> tradeReference;
		private final List<? extends ReferenceWithMetaTransferPrimitive> transferReference;
		
		protected LineageImpl(Lineage.LineageBuilder builder) {
			this.cashflowReference = ofNullable(builder.getCashflowReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDefaultPayoutReference = ofNullable(builder.getCreditDefaultPayoutReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.equityPayoutReference = ofNullable(builder.getEquityPayoutReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.eventReference = ofNullable(builder.getEventReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.interestRatePayoutReference = ofNullable(builder.getInterestRatePayoutReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.legalAgreement = ofNullable(builder.getLegalAgreement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionPayoutReference = ofNullable(builder.getOptionPayoutReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.portfolioStateReference = ofNullable(builder.getPortfolioStateReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeReference = ofNullable(builder.getTradeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transferReference = ofNullable(builder.getTransferReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ReferenceWithMetaCashflow> getCashflowReference() {
			return cashflowReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaCreditDefaultPayout> getCreditDefaultPayoutReference() {
			return creditDefaultPayoutReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaEquityPayout> getEquityPayoutReference() {
			return equityPayoutReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaWorkflowStep> getEventReference() {
			return eventReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaInterestRatePayout> getInterestRatePayoutReference() {
			return interestRatePayoutReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaLegalAgreement> getLegalAgreement() {
			return legalAgreement;
		}
		
		@Override
		public List<? extends ReferenceWithMetaOptionPayout> getOptionPayoutReference() {
			return optionPayoutReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaPortfolioState> getPortfolioStateReference() {
			return portfolioStateReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTrade> getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTransferPrimitive> getTransferReference() {
			return transferReference;
		}
		
		@Override
		public Lineage build() {
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder toBuilder() {
			Lineage.LineageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lineage.LineageBuilder builder) {
			ofNullable(getCashflowReference()).ifPresent(builder::setCashflowReference);
			ofNullable(getCreditDefaultPayoutReference()).ifPresent(builder::setCreditDefaultPayoutReference);
			ofNullable(getEquityPayoutReference()).ifPresent(builder::setEquityPayoutReference);
			ofNullable(getEventReference()).ifPresent(builder::setEventReference);
			ofNullable(getInterestRatePayoutReference()).ifPresent(builder::setInterestRatePayoutReference);
			ofNullable(getLegalAgreement()).ifPresent(builder::setLegalAgreement);
			ofNullable(getOptionPayoutReference()).ifPresent(builder::setOptionPayoutReference);
			ofNullable(getPortfolioStateReference()).ifPresent(builder::setPortfolioStateReference);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
			ofNullable(getTransferReference()).ifPresent(builder::setTransferReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lineage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashflowReference, _that.getCashflowReference())) return false;
			if (!ListEquals.listEquals(creditDefaultPayoutReference, _that.getCreditDefaultPayoutReference())) return false;
			if (!ListEquals.listEquals(equityPayoutReference, _that.getEquityPayoutReference())) return false;
			if (!ListEquals.listEquals(eventReference, _that.getEventReference())) return false;
			if (!ListEquals.listEquals(interestRatePayoutReference, _that.getInterestRatePayoutReference())) return false;
			if (!ListEquals.listEquals(legalAgreement, _that.getLegalAgreement())) return false;
			if (!ListEquals.listEquals(optionPayoutReference, _that.getOptionPayoutReference())) return false;
			if (!ListEquals.listEquals(portfolioStateReference, _that.getPortfolioStateReference())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			if (!ListEquals.listEquals(transferReference, _that.getTransferReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowReference != null ? cashflowReference.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayoutReference != null ? creditDefaultPayoutReference.hashCode() : 0);
			_result = 31 * _result + (equityPayoutReference != null ? equityPayoutReference.hashCode() : 0);
			_result = 31 * _result + (eventReference != null ? eventReference.hashCode() : 0);
			_result = 31 * _result + (interestRatePayoutReference != null ? interestRatePayoutReference.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			_result = 31 * _result + (optionPayoutReference != null ? optionPayoutReference.hashCode() : 0);
			_result = 31 * _result + (portfolioStateReference != null ? portfolioStateReference.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (transferReference != null ? transferReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lineage {" +
				"cashflowReference=" + this.cashflowReference + ", " +
				"creditDefaultPayoutReference=" + this.creditDefaultPayoutReference + ", " +
				"equityPayoutReference=" + this.equityPayoutReference + ", " +
				"eventReference=" + this.eventReference + ", " +
				"interestRatePayoutReference=" + this.interestRatePayoutReference + ", " +
				"legalAgreement=" + this.legalAgreement + ", " +
				"optionPayoutReference=" + this.optionPayoutReference + ", " +
				"portfolioStateReference=" + this.portfolioStateReference + ", " +
				"tradeReference=" + this.tradeReference + ", " +
				"transferReference=" + this.transferReference +
			'}';
		}
	}
	
	//Lineage.LineageBuilderImpl
	class LineageBuilderImpl implements Lineage.LineageBuilder {
	
		protected List<ReferenceWithMetaCashflowBuilder> cashflowReference = new ArrayList<>();
		protected List<ReferenceWithMetaCreditDefaultPayoutBuilder> creditDefaultPayoutReference = new ArrayList<>();
		protected List<ReferenceWithMetaEquityPayoutBuilder> equityPayoutReference = new ArrayList<>();
		protected List<ReferenceWithMetaWorkflowStepBuilder> eventReference = new ArrayList<>();
		protected List<ReferenceWithMetaInterestRatePayoutBuilder> interestRatePayoutReference = new ArrayList<>();
		protected List<ReferenceWithMetaLegalAgreementBuilder> legalAgreement = new ArrayList<>();
		protected List<ReferenceWithMetaOptionPayoutBuilder> optionPayoutReference = new ArrayList<>();
		protected List<ReferenceWithMetaPortfolioStateBuilder> portfolioStateReference = new ArrayList<>();
		protected List<ReferenceWithMetaTradeBuilder> tradeReference = new ArrayList<>();
		protected List<ReferenceWithMetaTransferPrimitiveBuilder> transferReference = new ArrayList<>();
	
		public LineageBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaCashflowBuilder> getCashflowReference() {
			return cashflowReference;
		}
		
		public ReferenceWithMetaCashflowBuilder getOrCreateCashflowReference(int _index) {
		
			if (cashflowReference==null) {
				this.cashflowReference = new ArrayList<>();
			}
			ReferenceWithMetaCashflowBuilder result;
			return getIndex(cashflowReference, _index, () -> {
						ReferenceWithMetaCashflowBuilder newCashflowReference = ReferenceWithMetaCashflow.builder();
						return newCashflowReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaCreditDefaultPayoutBuilder> getCreditDefaultPayoutReference() {
			return creditDefaultPayoutReference;
		}
		
		public ReferenceWithMetaCreditDefaultPayoutBuilder getOrCreateCreditDefaultPayoutReference(int _index) {
		
			if (creditDefaultPayoutReference==null) {
				this.creditDefaultPayoutReference = new ArrayList<>();
			}
			ReferenceWithMetaCreditDefaultPayoutBuilder result;
			return getIndex(creditDefaultPayoutReference, _index, () -> {
						ReferenceWithMetaCreditDefaultPayoutBuilder newCreditDefaultPayoutReference = ReferenceWithMetaCreditDefaultPayout.builder();
						return newCreditDefaultPayoutReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaEquityPayoutBuilder> getEquityPayoutReference() {
			return equityPayoutReference;
		}
		
		public ReferenceWithMetaEquityPayoutBuilder getOrCreateEquityPayoutReference(int _index) {
		
			if (equityPayoutReference==null) {
				this.equityPayoutReference = new ArrayList<>();
			}
			ReferenceWithMetaEquityPayoutBuilder result;
			return getIndex(equityPayoutReference, _index, () -> {
						ReferenceWithMetaEquityPayoutBuilder newEquityPayoutReference = ReferenceWithMetaEquityPayout.builder();
						return newEquityPayoutReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaWorkflowStepBuilder> getEventReference() {
			return eventReference;
		}
		
		public ReferenceWithMetaWorkflowStepBuilder getOrCreateEventReference(int _index) {
		
			if (eventReference==null) {
				this.eventReference = new ArrayList<>();
			}
			ReferenceWithMetaWorkflowStepBuilder result;
			return getIndex(eventReference, _index, () -> {
						ReferenceWithMetaWorkflowStepBuilder newEventReference = ReferenceWithMetaWorkflowStep.builder();
						return newEventReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaInterestRatePayoutBuilder> getInterestRatePayoutReference() {
			return interestRatePayoutReference;
		}
		
		public ReferenceWithMetaInterestRatePayoutBuilder getOrCreateInterestRatePayoutReference(int _index) {
		
			if (interestRatePayoutReference==null) {
				this.interestRatePayoutReference = new ArrayList<>();
			}
			ReferenceWithMetaInterestRatePayoutBuilder result;
			return getIndex(interestRatePayoutReference, _index, () -> {
						ReferenceWithMetaInterestRatePayoutBuilder newInterestRatePayoutReference = ReferenceWithMetaInterestRatePayout.builder();
						return newInterestRatePayoutReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaLegalAgreementBuilder> getLegalAgreement() {
			return legalAgreement;
		}
		
		public ReferenceWithMetaLegalAgreementBuilder getOrCreateLegalAgreement(int _index) {
		
			if (legalAgreement==null) {
				this.legalAgreement = new ArrayList<>();
			}
			ReferenceWithMetaLegalAgreementBuilder result;
			return getIndex(legalAgreement, _index, () -> {
						ReferenceWithMetaLegalAgreementBuilder newLegalAgreement = ReferenceWithMetaLegalAgreement.builder();
						return newLegalAgreement;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaOptionPayoutBuilder> getOptionPayoutReference() {
			return optionPayoutReference;
		}
		
		public ReferenceWithMetaOptionPayoutBuilder getOrCreateOptionPayoutReference(int _index) {
		
			if (optionPayoutReference==null) {
				this.optionPayoutReference = new ArrayList<>();
			}
			ReferenceWithMetaOptionPayoutBuilder result;
			return getIndex(optionPayoutReference, _index, () -> {
						ReferenceWithMetaOptionPayoutBuilder newOptionPayoutReference = ReferenceWithMetaOptionPayout.builder();
						return newOptionPayoutReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaPortfolioStateBuilder> getPortfolioStateReference() {
			return portfolioStateReference;
		}
		
		public ReferenceWithMetaPortfolioStateBuilder getOrCreatePortfolioStateReference(int _index) {
		
			if (portfolioStateReference==null) {
				this.portfolioStateReference = new ArrayList<>();
			}
			ReferenceWithMetaPortfolioStateBuilder result;
			return getIndex(portfolioStateReference, _index, () -> {
						ReferenceWithMetaPortfolioStateBuilder newPortfolioStateReference = ReferenceWithMetaPortfolioState.builder();
						return newPortfolioStateReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeBuilder> getTradeReference() {
			return tradeReference;
		}
		
		public ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index) {
		
			if (tradeReference==null) {
				this.tradeReference = new ArrayList<>();
			}
			ReferenceWithMetaTradeBuilder result;
			return getIndex(tradeReference, _index, () -> {
						ReferenceWithMetaTradeBuilder newTradeReference = ReferenceWithMetaTrade.builder();
						return newTradeReference;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaTransferPrimitiveBuilder> getTransferReference() {
			return transferReference;
		}
		
		public ReferenceWithMetaTransferPrimitiveBuilder getOrCreateTransferReference(int _index) {
		
			if (transferReference==null) {
				this.transferReference = new ArrayList<>();
			}
			ReferenceWithMetaTransferPrimitiveBuilder result;
			return getIndex(transferReference, _index, () -> {
						ReferenceWithMetaTransferPrimitiveBuilder newTransferReference = ReferenceWithMetaTransferPrimitive.builder();
						return newTransferReference;
					});
		}
		
	
		@Override
		public Lineage.LineageBuilder addCashflowReference(ReferenceWithMetaCashflow cashflowReference) {
			if (cashflowReference!=null) this.cashflowReference.add(cashflowReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addCashflowReference(ReferenceWithMetaCashflow cashflowReference, int _idx) {
			getIndex(this.cashflowReference, _idx, () -> cashflowReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addCashflowReferenceValue(Cashflow cashflowReference) {
				this.getOrCreateCashflowReference(-1).setValue(cashflowReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addCashflowReferenceValue(Cashflow cashflowReference, int _idx) {
				this.getOrCreateCashflowReference(_idx).setValue(cashflowReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addCashflowReference(List<? extends ReferenceWithMetaCashflow> cashflowReferences) {
			if (cashflowReferences != null) {
				for (ReferenceWithMetaCashflow toAdd : cashflowReferences) {
					this.cashflowReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setCashflowReference(List<? extends ReferenceWithMetaCashflow> cashflowReferences) {
			if (cashflowReferences == null)  {
				this.cashflowReference = new ArrayList<>();
			}
			else {
				this.cashflowReference = cashflowReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addCashflowReferenceValue(List<? extends Cashflow> cashflowReferences) {
			if (cashflowReferences != null) {
				for (Cashflow toAdd : cashflowReferences) {
					this.addCashflowReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setCashflowReferenceValue(List<? extends Cashflow> cashflowReferences) {
			this.cashflowReference.clear();
			if (cashflowReferences!=null) {
				cashflowReferences.forEach(this::addCashflowReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addCreditDefaultPayoutReference(ReferenceWithMetaCreditDefaultPayout creditDefaultPayoutReference) {
			if (creditDefaultPayoutReference!=null) this.creditDefaultPayoutReference.add(creditDefaultPayoutReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addCreditDefaultPayoutReference(ReferenceWithMetaCreditDefaultPayout creditDefaultPayoutReference, int _idx) {
			getIndex(this.creditDefaultPayoutReference, _idx, () -> creditDefaultPayoutReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(CreditDefaultPayout creditDefaultPayoutReference) {
				this.getOrCreateCreditDefaultPayoutReference(-1).setValue(creditDefaultPayoutReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(CreditDefaultPayout creditDefaultPayoutReference, int _idx) {
				this.getOrCreateCreditDefaultPayoutReference(_idx).setValue(creditDefaultPayoutReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addCreditDefaultPayoutReference(List<? extends ReferenceWithMetaCreditDefaultPayout> creditDefaultPayoutReferences) {
			if (creditDefaultPayoutReferences != null) {
				for (ReferenceWithMetaCreditDefaultPayout toAdd : creditDefaultPayoutReferences) {
					this.creditDefaultPayoutReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setCreditDefaultPayoutReference(List<? extends ReferenceWithMetaCreditDefaultPayout> creditDefaultPayoutReferences) {
			if (creditDefaultPayoutReferences == null)  {
				this.creditDefaultPayoutReference = new ArrayList<>();
			}
			else {
				this.creditDefaultPayoutReference = creditDefaultPayoutReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addCreditDefaultPayoutReferenceValue(List<? extends CreditDefaultPayout> creditDefaultPayoutReferences) {
			if (creditDefaultPayoutReferences != null) {
				for (CreditDefaultPayout toAdd : creditDefaultPayoutReferences) {
					this.addCreditDefaultPayoutReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setCreditDefaultPayoutReferenceValue(List<? extends CreditDefaultPayout> creditDefaultPayoutReferences) {
			this.creditDefaultPayoutReference.clear();
			if (creditDefaultPayoutReferences!=null) {
				creditDefaultPayoutReferences.forEach(this::addCreditDefaultPayoutReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEquityPayoutReference(ReferenceWithMetaEquityPayout equityPayoutReference) {
			if (equityPayoutReference!=null) this.equityPayoutReference.add(equityPayoutReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEquityPayoutReference(ReferenceWithMetaEquityPayout equityPayoutReference, int _idx) {
			getIndex(this.equityPayoutReference, _idx, () -> equityPayoutReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addEquityPayoutReferenceValue(EquityPayout equityPayoutReference) {
				this.getOrCreateEquityPayoutReference(-1).setValue(equityPayoutReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addEquityPayoutReferenceValue(EquityPayout equityPayoutReference, int _idx) {
				this.getOrCreateEquityPayoutReference(_idx).setValue(equityPayoutReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addEquityPayoutReference(List<? extends ReferenceWithMetaEquityPayout> equityPayoutReferences) {
			if (equityPayoutReferences != null) {
				for (ReferenceWithMetaEquityPayout toAdd : equityPayoutReferences) {
					this.equityPayoutReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setEquityPayoutReference(List<? extends ReferenceWithMetaEquityPayout> equityPayoutReferences) {
			if (equityPayoutReferences == null)  {
				this.equityPayoutReference = new ArrayList<>();
			}
			else {
				this.equityPayoutReference = equityPayoutReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEquityPayoutReferenceValue(List<? extends EquityPayout> equityPayoutReferences) {
			if (equityPayoutReferences != null) {
				for (EquityPayout toAdd : equityPayoutReferences) {
					this.addEquityPayoutReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setEquityPayoutReferenceValue(List<? extends EquityPayout> equityPayoutReferences) {
			this.equityPayoutReference.clear();
			if (equityPayoutReferences!=null) {
				equityPayoutReferences.forEach(this::addEquityPayoutReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEventReference(ReferenceWithMetaWorkflowStep eventReference) {
			if (eventReference!=null) this.eventReference.add(eventReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEventReference(ReferenceWithMetaWorkflowStep eventReference, int _idx) {
			getIndex(this.eventReference, _idx, () -> eventReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addEventReferenceValue(WorkflowStep eventReference) {
				this.getOrCreateEventReference(-1).setValue(eventReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addEventReferenceValue(WorkflowStep eventReference, int _idx) {
				this.getOrCreateEventReference(_idx).setValue(eventReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addEventReference(List<? extends ReferenceWithMetaWorkflowStep> eventReferences) {
			if (eventReferences != null) {
				for (ReferenceWithMetaWorkflowStep toAdd : eventReferences) {
					this.eventReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setEventReference(List<? extends ReferenceWithMetaWorkflowStep> eventReferences) {
			if (eventReferences == null)  {
				this.eventReference = new ArrayList<>();
			}
			else {
				this.eventReference = eventReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addEventReferenceValue(List<? extends WorkflowStep> eventReferences) {
			if (eventReferences != null) {
				for (WorkflowStep toAdd : eventReferences) {
					this.addEventReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setEventReferenceValue(List<? extends WorkflowStep> eventReferences) {
			this.eventReference.clear();
			if (eventReferences!=null) {
				eventReferences.forEach(this::addEventReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addInterestRatePayoutReference(ReferenceWithMetaInterestRatePayout interestRatePayoutReference) {
			if (interestRatePayoutReference!=null) this.interestRatePayoutReference.add(interestRatePayoutReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addInterestRatePayoutReference(ReferenceWithMetaInterestRatePayout interestRatePayoutReference, int _idx) {
			getIndex(this.interestRatePayoutReference, _idx, () -> interestRatePayoutReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addInterestRatePayoutReferenceValue(InterestRatePayout interestRatePayoutReference) {
				this.getOrCreateInterestRatePayoutReference(-1).setValue(interestRatePayoutReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addInterestRatePayoutReferenceValue(InterestRatePayout interestRatePayoutReference, int _idx) {
				this.getOrCreateInterestRatePayoutReference(_idx).setValue(interestRatePayoutReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addInterestRatePayoutReference(List<? extends ReferenceWithMetaInterestRatePayout> interestRatePayoutReferences) {
			if (interestRatePayoutReferences != null) {
				for (ReferenceWithMetaInterestRatePayout toAdd : interestRatePayoutReferences) {
					this.interestRatePayoutReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setInterestRatePayoutReference(List<? extends ReferenceWithMetaInterestRatePayout> interestRatePayoutReferences) {
			if (interestRatePayoutReferences == null)  {
				this.interestRatePayoutReference = new ArrayList<>();
			}
			else {
				this.interestRatePayoutReference = interestRatePayoutReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addInterestRatePayoutReferenceValue(List<? extends InterestRatePayout> interestRatePayoutReferences) {
			if (interestRatePayoutReferences != null) {
				for (InterestRatePayout toAdd : interestRatePayoutReferences) {
					this.addInterestRatePayoutReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setInterestRatePayoutReferenceValue(List<? extends InterestRatePayout> interestRatePayoutReferences) {
			this.interestRatePayoutReference.clear();
			if (interestRatePayoutReferences!=null) {
				interestRatePayoutReferences.forEach(this::addInterestRatePayoutReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addLegalAgreement(ReferenceWithMetaLegalAgreement legalAgreement) {
			if (legalAgreement!=null) this.legalAgreement.add(legalAgreement.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addLegalAgreement(ReferenceWithMetaLegalAgreement legalAgreement, int _idx) {
			getIndex(this.legalAgreement, _idx, () -> legalAgreement.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addLegalAgreementValue(LegalAgreement legalAgreement) {
				this.getOrCreateLegalAgreement(-1).setValue(legalAgreement.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addLegalAgreementValue(LegalAgreement legalAgreement, int _idx) {
				this.getOrCreateLegalAgreement(_idx).setValue(legalAgreement.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addLegalAgreement(List<? extends ReferenceWithMetaLegalAgreement> legalAgreements) {
			if (legalAgreements != null) {
				for (ReferenceWithMetaLegalAgreement toAdd : legalAgreements) {
					this.legalAgreement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setLegalAgreement(List<? extends ReferenceWithMetaLegalAgreement> legalAgreements) {
			if (legalAgreements == null)  {
				this.legalAgreement = new ArrayList<>();
			}
			else {
				this.legalAgreement = legalAgreements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addLegalAgreementValue(List<? extends LegalAgreement> legalAgreements) {
			if (legalAgreements != null) {
				for (LegalAgreement toAdd : legalAgreements) {
					this.addLegalAgreementValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setLegalAgreementValue(List<? extends LegalAgreement> legalAgreements) {
			this.legalAgreement.clear();
			if (legalAgreements!=null) {
				legalAgreements.forEach(this::addLegalAgreementValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addOptionPayoutReference(ReferenceWithMetaOptionPayout optionPayoutReference) {
			if (optionPayoutReference!=null) this.optionPayoutReference.add(optionPayoutReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addOptionPayoutReference(ReferenceWithMetaOptionPayout optionPayoutReference, int _idx) {
			getIndex(this.optionPayoutReference, _idx, () -> optionPayoutReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addOptionPayoutReferenceValue(OptionPayout optionPayoutReference) {
				this.getOrCreateOptionPayoutReference(-1).setValue(optionPayoutReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addOptionPayoutReferenceValue(OptionPayout optionPayoutReference, int _idx) {
				this.getOrCreateOptionPayoutReference(_idx).setValue(optionPayoutReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addOptionPayoutReference(List<? extends ReferenceWithMetaOptionPayout> optionPayoutReferences) {
			if (optionPayoutReferences != null) {
				for (ReferenceWithMetaOptionPayout toAdd : optionPayoutReferences) {
					this.optionPayoutReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setOptionPayoutReference(List<? extends ReferenceWithMetaOptionPayout> optionPayoutReferences) {
			if (optionPayoutReferences == null)  {
				this.optionPayoutReference = new ArrayList<>();
			}
			else {
				this.optionPayoutReference = optionPayoutReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addOptionPayoutReferenceValue(List<? extends OptionPayout> optionPayoutReferences) {
			if (optionPayoutReferences != null) {
				for (OptionPayout toAdd : optionPayoutReferences) {
					this.addOptionPayoutReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setOptionPayoutReferenceValue(List<? extends OptionPayout> optionPayoutReferences) {
			this.optionPayoutReference.clear();
			if (optionPayoutReferences!=null) {
				optionPayoutReferences.forEach(this::addOptionPayoutReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addPortfolioStateReference(ReferenceWithMetaPortfolioState portfolioStateReference) {
			if (portfolioStateReference!=null) this.portfolioStateReference.add(portfolioStateReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addPortfolioStateReference(ReferenceWithMetaPortfolioState portfolioStateReference, int _idx) {
			getIndex(this.portfolioStateReference, _idx, () -> portfolioStateReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addPortfolioStateReferenceValue(PortfolioState portfolioStateReference) {
				this.getOrCreatePortfolioStateReference(-1).setValue(portfolioStateReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addPortfolioStateReferenceValue(PortfolioState portfolioStateReference, int _idx) {
				this.getOrCreatePortfolioStateReference(_idx).setValue(portfolioStateReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addPortfolioStateReference(List<? extends ReferenceWithMetaPortfolioState> portfolioStateReferences) {
			if (portfolioStateReferences != null) {
				for (ReferenceWithMetaPortfolioState toAdd : portfolioStateReferences) {
					this.portfolioStateReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setPortfolioStateReference(List<? extends ReferenceWithMetaPortfolioState> portfolioStateReferences) {
			if (portfolioStateReferences == null)  {
				this.portfolioStateReference = new ArrayList<>();
			}
			else {
				this.portfolioStateReference = portfolioStateReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addPortfolioStateReferenceValue(List<? extends PortfolioState> portfolioStateReferences) {
			if (portfolioStateReferences != null) {
				for (PortfolioState toAdd : portfolioStateReferences) {
					this.addPortfolioStateReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setPortfolioStateReferenceValue(List<? extends PortfolioState> portfolioStateReferences) {
			this.portfolioStateReference.clear();
			if (portfolioStateReferences!=null) {
				portfolioStateReferences.forEach(this::addPortfolioStateReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTradeReference(ReferenceWithMetaTrade tradeReference) {
			if (tradeReference!=null) this.tradeReference.add(tradeReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTradeReference(ReferenceWithMetaTrade tradeReference, int _idx) {
			getIndex(this.tradeReference, _idx, () -> tradeReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addTradeReferenceValue(Trade tradeReference) {
				this.getOrCreateTradeReference(-1).setValue(tradeReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addTradeReferenceValue(Trade tradeReference, int _idx) {
				this.getOrCreateTradeReference(_idx).setValue(tradeReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences != null) {
				for (ReferenceWithMetaTrade toAdd : tradeReferences) {
					this.tradeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences == null)  {
				this.tradeReference = new ArrayList<>();
			}
			else {
				this.tradeReference = tradeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTradeReferenceValue(List<? extends Trade> tradeReferences) {
			if (tradeReferences != null) {
				for (Trade toAdd : tradeReferences) {
					this.addTradeReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setTradeReferenceValue(List<? extends Trade> tradeReferences) {
			this.tradeReference.clear();
			if (tradeReferences!=null) {
				tradeReferences.forEach(this::addTradeReferenceValue);
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTransferReference(ReferenceWithMetaTransferPrimitive transferReference) {
			if (transferReference!=null) this.transferReference.add(transferReference.toBuilder());
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTransferReference(ReferenceWithMetaTransferPrimitive transferReference, int _idx) {
			getIndex(this.transferReference, _idx, () -> transferReference.toBuilder());
			return this;
		}
		
			@Override
			public Lineage.LineageBuilder addTransferReferenceValue(TransferPrimitive transferReference) {
				this.getOrCreateTransferReference(-1).setValue(transferReference.toBuilder());
				return this;
			}
			
			@Override
			public Lineage.LineageBuilder addTransferReferenceValue(TransferPrimitive transferReference, int _idx) {
				this.getOrCreateTransferReference(_idx).setValue(transferReference.toBuilder());
				return this;
			}
		@Override 
		public Lineage.LineageBuilder addTransferReference(List<? extends ReferenceWithMetaTransferPrimitive> transferReferences) {
			if (transferReferences != null) {
				for (ReferenceWithMetaTransferPrimitive toAdd : transferReferences) {
					this.transferReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Lineage.LineageBuilder setTransferReference(List<? extends ReferenceWithMetaTransferPrimitive> transferReferences) {
			if (transferReferences == null)  {
				this.transferReference = new ArrayList<>();
			}
			else {
				this.transferReference = transferReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder addTransferReferenceValue(List<? extends TransferPrimitive> transferReferences) {
			if (transferReferences != null) {
				for (TransferPrimitive toAdd : transferReferences) {
					this.addTransferReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Lineage.LineageBuilder setTransferReferenceValue(List<? extends TransferPrimitive> transferReferences) {
			this.transferReference.clear();
			if (transferReferences!=null) {
				transferReferences.forEach(this::addTransferReferenceValue);
			}
			return this;
		}
		
		
		@Override
		public Lineage build() {
			return new Lineage.LineageImpl(this);
		}
		
		@Override
		public Lineage.LineageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lineage.LineageBuilder prune() {
			cashflowReference = cashflowReference.stream().filter(b->b!=null).<ReferenceWithMetaCashflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditDefaultPayoutReference = creditDefaultPayoutReference.stream().filter(b->b!=null).<ReferenceWithMetaCreditDefaultPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			equityPayoutReference = equityPayoutReference.stream().filter(b->b!=null).<ReferenceWithMetaEquityPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			eventReference = eventReference.stream().filter(b->b!=null).<ReferenceWithMetaWorkflowStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			interestRatePayoutReference = interestRatePayoutReference.stream().filter(b->b!=null).<ReferenceWithMetaInterestRatePayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			legalAgreement = legalAgreement.stream().filter(b->b!=null).<ReferenceWithMetaLegalAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			optionPayoutReference = optionPayoutReference.stream().filter(b->b!=null).<ReferenceWithMetaOptionPayoutBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			portfolioStateReference = portfolioStateReference.stream().filter(b->b!=null).<ReferenceWithMetaPortfolioStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeReference = tradeReference.stream().filter(b->b!=null).<ReferenceWithMetaTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transferReference = transferReference.stream().filter(b->b!=null).<ReferenceWithMetaTransferPrimitiveBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflowReference()!=null && getCashflowReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDefaultPayoutReference()!=null && getCreditDefaultPayoutReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEquityPayoutReference()!=null && getEquityPayoutReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEventReference()!=null && getEventReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInterestRatePayoutReference()!=null && getInterestRatePayoutReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLegalAgreement()!=null && getLegalAgreement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionPayoutReference()!=null && getOptionPayoutReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPortfolioStateReference()!=null && getPortfolioStateReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeReference()!=null && getTradeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransferReference()!=null && getTransferReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lineage.LineageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lineage.LineageBuilder o = (Lineage.LineageBuilder) other;
			
			merger.mergeRosetta(getCashflowReference(), o.getCashflowReference(), this::getOrCreateCashflowReference);
			merger.mergeRosetta(getCreditDefaultPayoutReference(), o.getCreditDefaultPayoutReference(), this::getOrCreateCreditDefaultPayoutReference);
			merger.mergeRosetta(getEquityPayoutReference(), o.getEquityPayoutReference(), this::getOrCreateEquityPayoutReference);
			merger.mergeRosetta(getEventReference(), o.getEventReference(), this::getOrCreateEventReference);
			merger.mergeRosetta(getInterestRatePayoutReference(), o.getInterestRatePayoutReference(), this::getOrCreateInterestRatePayoutReference);
			merger.mergeRosetta(getLegalAgreement(), o.getLegalAgreement(), this::getOrCreateLegalAgreement);
			merger.mergeRosetta(getOptionPayoutReference(), o.getOptionPayoutReference(), this::getOrCreateOptionPayoutReference);
			merger.mergeRosetta(getPortfolioStateReference(), o.getPortfolioStateReference(), this::getOrCreatePortfolioStateReference);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::getOrCreateTradeReference);
			merger.mergeRosetta(getTransferReference(), o.getTransferReference(), this::getOrCreateTransferReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lineage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashflowReference, _that.getCashflowReference())) return false;
			if (!ListEquals.listEquals(creditDefaultPayoutReference, _that.getCreditDefaultPayoutReference())) return false;
			if (!ListEquals.listEquals(equityPayoutReference, _that.getEquityPayoutReference())) return false;
			if (!ListEquals.listEquals(eventReference, _that.getEventReference())) return false;
			if (!ListEquals.listEquals(interestRatePayoutReference, _that.getInterestRatePayoutReference())) return false;
			if (!ListEquals.listEquals(legalAgreement, _that.getLegalAgreement())) return false;
			if (!ListEquals.listEquals(optionPayoutReference, _that.getOptionPayoutReference())) return false;
			if (!ListEquals.listEquals(portfolioStateReference, _that.getPortfolioStateReference())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			if (!ListEquals.listEquals(transferReference, _that.getTransferReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowReference != null ? cashflowReference.hashCode() : 0);
			_result = 31 * _result + (creditDefaultPayoutReference != null ? creditDefaultPayoutReference.hashCode() : 0);
			_result = 31 * _result + (equityPayoutReference != null ? equityPayoutReference.hashCode() : 0);
			_result = 31 * _result + (eventReference != null ? eventReference.hashCode() : 0);
			_result = 31 * _result + (interestRatePayoutReference != null ? interestRatePayoutReference.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			_result = 31 * _result + (optionPayoutReference != null ? optionPayoutReference.hashCode() : 0);
			_result = 31 * _result + (portfolioStateReference != null ? portfolioStateReference.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (transferReference != null ? transferReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LineageBuilder {" +
				"cashflowReference=" + this.cashflowReference + ", " +
				"creditDefaultPayoutReference=" + this.creditDefaultPayoutReference + ", " +
				"equityPayoutReference=" + this.equityPayoutReference + ", " +
				"eventReference=" + this.eventReference + ", " +
				"interestRatePayoutReference=" + this.interestRatePayoutReference + ", " +
				"legalAgreement=" + this.legalAgreement + ", " +
				"optionPayoutReference=" + this.optionPayoutReference + ", " +
				"portfolioStateReference=" + this.portfolioStateReference + ", " +
				"tradeReference=" + this.tradeReference + ", " +
				"transferReference=" + this.transferReference +
			'}';
		}
	}
}
