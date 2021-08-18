package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.observable.asset.CalculationAgent;
import cdm.observable.event.ExtraordinaryEvents;
import cdm.product.template.meta.EconomicTermsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 *  This class represents the full set of price-forming features associated with a contractual product: the payout component, the notional/quantity, the effective and termination date and the date adjustment provisions when applying uniformily across the payout components. This class also includes the legal provisions which have valuation implications: cancelable provision, extendible provision, early termination provision and extraordinary events specification.
 * @version ${project.version}
 */
@RosettaClass

public interface EconomicTerms extends RosettaModelObject {
	EconomicTerms build();
	EconomicTerms.EconomicTermsBuilder toBuilder();
	
	/**
	 * The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * The business day adjustment convention when it applies across all the payout components. This specification of the business day convention and financial business centers is used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * Parameters specifying provisions relating to the optional and mandatory early termination of a swap transaction.
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();
	/**
	 * The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Extraordinary Events.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();
	/**
	 * Cancelable and/or extendible provisions.
	 */
	OptionProvision getOptionProvision();
	/**
	 * The payout specifies the future cashflow computation methodology which characterizes a financial product.
	 */
	Payout getPayout();
	/**
	 * The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
	 */
	AdjustableOrRelativeDate getTerminationDate();
	final static EconomicTermsMeta metaData = new EconomicTermsMeta();
	
	@Override
	default RosettaMetaData<? extends EconomicTerms> metaData() {
		return metaData;
	} 
			
	static EconomicTerms.EconomicTermsBuilder builder() {
		return new EconomicTerms.EconomicTermsBuilderImpl();
	}
	
	default Class<? extends EconomicTerms> getType() {
		return EconomicTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("optionProvision"), processor, OptionProvision.class, getOptionProvision());
		processRosetta(path.newSubPath("payout"), processor, Payout.class, getPayout());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
	}
	
	
	interface EconomicTermsBuilder extends EconomicTerms, RosettaModelObjectBuilder {
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		OptionProvision.OptionProvisionBuilder getOrCreateOptionProvision();
		OptionProvision.OptionProvisionBuilder getOptionProvision();
		Payout.PayoutBuilder getOrCreatePayout();
		Payout.PayoutBuilder getPayout();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		EconomicTerms.EconomicTermsBuilder setCalculationAgent(CalculationAgent calculationAgent);
		EconomicTerms.EconomicTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		EconomicTerms.EconomicTermsBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);
		EconomicTerms.EconomicTermsBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		EconomicTerms.EconomicTermsBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		EconomicTerms.EconomicTermsBuilder setOptionProvision(OptionProvision optionProvision);
		EconomicTerms.EconomicTermsBuilder setPayout(Payout payout);
		EconomicTerms.EconomicTermsBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("optionProvision"), processor, OptionProvision.OptionProvisionBuilder.class, getOptionProvision());
			processRosetta(path.newSubPath("payout"), processor, Payout.PayoutBuilder.class, getPayout());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
		}
		
	}
	
	//EconomicTerms.EconomicTermsImpl
	class EconomicTermsImpl implements EconomicTerms {
		private final CalculationAgent calculationAgent;
		private final BusinessDayAdjustments dateAdjustments;
		private final EarlyTerminationProvision earlyTerminationProvision;
		private final AdjustableOrRelativeDate effectiveDate;
		private final ExtraordinaryEvents extraordinaryEvents;
		private final OptionProvision optionProvision;
		private final Payout payout;
		private final AdjustableOrRelativeDate terminationDate;
		
		protected EconomicTermsImpl(EconomicTerms.EconomicTermsBuilder builder) {
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
			this.optionProvision = ofNullable(builder.getOptionProvision()).map(f->f.build()).orElse(null);
			this.payout = ofNullable(builder.getPayout()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public OptionProvision getOptionProvision() {
			return optionProvision;
		}
		
		@Override
		public Payout getPayout() {
			return payout;
		}
		
		@Override
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public EconomicTerms build() {
			return this;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder toBuilder() {
			EconomicTerms.EconomicTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EconomicTerms.EconomicTermsBuilder builder) {
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
			ofNullable(getOptionProvision()).ifPresent(builder::setOptionProvision);
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EconomicTerms _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			if (!Objects.equals(optionProvision, _that.getOptionProvision())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			_result = 31 * _result + (optionProvision != null ? optionProvision.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EconomicTerms {" +
				"calculationAgent=" + this.calculationAgent + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents + ", " +
				"optionProvision=" + this.optionProvision + ", " +
				"payout=" + this.payout + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}
	
	//EconomicTerms.EconomicTermsBuilderImpl
	class EconomicTermsBuilderImpl implements EconomicTerms.EconomicTermsBuilder {
	
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		protected OptionProvision.OptionProvisionBuilder optionProvision;
		protected Payout.PayoutBuilder payout;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
	
		public EconomicTermsBuilderImpl() {
		}
	
		@Override
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder result;
			if (earlyTerminationProvision!=null) {
				result = earlyTerminationProvision;
			}
			else {
				result = earlyTerminationProvision = EarlyTerminationProvision.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionProvision.OptionProvisionBuilder getOptionProvision() {
			return optionProvision;
		}
		
		@Override
		public OptionProvision.OptionProvisionBuilder getOrCreateOptionProvision() {
			OptionProvision.OptionProvisionBuilder result;
			if (optionProvision!=null) {
				result = optionProvision;
			}
			else {
				result = optionProvision = OptionProvision.builder();
			}
			
			return result;
		}
		
		@Override
		public Payout.PayoutBuilder getPayout() {
			return payout;
		}
		
		@Override
		public Payout.PayoutBuilder getOrCreatePayout() {
			Payout.PayoutBuilder result;
			if (payout!=null) {
				result = payout;
			}
			else {
				result = payout = Payout.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public EconomicTerms.EconomicTermsBuilder setCalculationAgent(CalculationAgent calculationAgent) {
			this.calculationAgent = calculationAgent==null?null:calculationAgent.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision) {
			this.earlyTerminationProvision = earlyTerminationProvision==null?null:earlyTerminationProvision.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setOptionProvision(OptionProvision optionProvision) {
			this.optionProvision = optionProvision==null?null:optionProvision.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setPayout(Payout payout) {
			this.payout = payout==null?null:payout.toBuilder();
			return this;
		}
		@Override
		public EconomicTerms.EconomicTermsBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		
		@Override
		public EconomicTerms build() {
			return new EconomicTerms.EconomicTermsImpl(this);
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EconomicTerms.EconomicTermsBuilder prune() {
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			if (optionProvision!=null && !optionProvision.prune().hasData()) optionProvision = null;
			if (payout!=null && !payout.prune().hasData()) payout = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			if (getOptionProvision()!=null && getOptionProvision().hasData()) return true;
			if (getPayout()!=null && getPayout().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EconomicTerms.EconomicTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EconomicTerms.EconomicTermsBuilder o = (EconomicTerms.EconomicTermsBuilder) other;
			
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			merger.mergeRosetta(getOptionProvision(), o.getOptionProvision(), this::setOptionProvision);
			merger.mergeRosetta(getPayout(), o.getPayout(), this::setPayout);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EconomicTerms _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			if (!Objects.equals(optionProvision, _that.getOptionProvision())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			_result = 31 * _result + (optionProvision != null ? optionProvision.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EconomicTermsBuilder {" +
				"calculationAgent=" + this.calculationAgent + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents + ", " +
				"optionProvision=" + this.optionProvision + ", " +
				"payout=" + this.payout + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}
}
