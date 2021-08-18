package cdm.observable.event;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.event.meta.AdditionalDisruptionEventsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the Additional Disruption Events.
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalDisruptionEvents extends RosettaModelObject {
	AdditionalDisruptionEvents build();
	AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder();
	
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Change in Law | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Change In Law | If true, then change in law is applicable.
	 */
	Boolean getChangeInLaw();
	/**
	 * Specifies the party which determines additional disruption events.
	 */
	AncillaryRoleEnum getDeterminingParty();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Failure to Deliver | Where the underlying is shares and the transaction is physically settled, then, if true, a failure to deliver the shares on the settlement date will not be an event of default for the purposes of the master agreement.
	 */
	Boolean getFailureToDeliver();
	/**
	 * If true, then foreign ownership event is applicable.
	 */
	Boolean getForeignOwnershipEvent();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Hedging Disruption | If true, then hedging disruption is applicable.
	 */
	Boolean getHedgingDisruption();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Increased Cost of Hedging | If true, then increased cost of hedging is applicable.
	 */
	Boolean getIncreasedCostOfHedging();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Increased Cost of Stock Borrow | If true, then increased cost of stock borrow is applicable.
	 */
	Boolean getIncreasedCostOfStockBorrow();
	/**
	 * Specifies the initial stock loan rate for Increased Cost of Stock Borrow. A percentage of 5% is represented as 0.05.
	 */
	BigDecimal getInitialStockLoanRate();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Insolvency Filing | If true, then insolvency filing is applicable.
	 */
	Boolean getInsolvencyFiling();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Loss of Stock Borrow | If true, then loss of stock borrow is applicable.
	 */
	Boolean getLossOfStockBorrow();
	/**
	 * Specifies the maximum stock loan rate for Loss of Stock Borrow. A percentage of 5% is represented as 0.05.
	 */
	BigDecimal getMaximumStockLoanRate();
	final static AdditionalDisruptionEventsMeta metaData = new AdditionalDisruptionEventsMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalDisruptionEvents> metaData() {
		return metaData;
	} 
			
	static AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder() {
		return new AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl();
	}
	
	default Class<? extends AdditionalDisruptionEvents> getType() {
		return AdditionalDisruptionEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
		processor.processBasic(path.newSubPath("determiningParty"), AncillaryRoleEnum.class, getDeterminingParty(), this);
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
		processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
		processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
		processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
		processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
		processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
		
	}
	
	
	interface AdditionalDisruptionEventsBuilder extends AdditionalDisruptionEvents, RosettaModelObjectBuilder {
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean changeInLaw);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingParty(AncillaryRoleEnum determiningParty);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean foreignOwnershipEvent);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean hedgingDisruption);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean increasedCostOfHedging);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean insolvencyFiling);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
			processor.processBasic(path.newSubPath("determiningParty"), AncillaryRoleEnum.class, getDeterminingParty(), this);
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
			processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
			processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
			processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
			processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
			processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
			
		}
		
	}
	
	//AdditionalDisruptionEvents.AdditionalDisruptionEventsImpl
	class AdditionalDisruptionEventsImpl implements AdditionalDisruptionEvents {
		private final Boolean changeInLaw;
		private final AncillaryRoleEnum determiningParty;
		private final Boolean failureToDeliver;
		private final Boolean foreignOwnershipEvent;
		private final Boolean hedgingDisruption;
		private final Boolean increasedCostOfHedging;
		private final Boolean increasedCostOfStockBorrow;
		private final BigDecimal initialStockLoanRate;
		private final Boolean insolvencyFiling;
		private final Boolean lossOfStockBorrow;
		private final BigDecimal maximumStockLoanRate;
		
		protected AdditionalDisruptionEventsImpl(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			this.changeInLaw = builder.getChangeInLaw();
			this.determiningParty = builder.getDeterminingParty();
			this.failureToDeliver = builder.getFailureToDeliver();
			this.foreignOwnershipEvent = builder.getForeignOwnershipEvent();
			this.hedgingDisruption = builder.getHedgingDisruption();
			this.increasedCostOfHedging = builder.getIncreasedCostOfHedging();
			this.increasedCostOfStockBorrow = builder.getIncreasedCostOfStockBorrow();
			this.initialStockLoanRate = builder.getInitialStockLoanRate();
			this.insolvencyFiling = builder.getInsolvencyFiling();
			this.lossOfStockBorrow = builder.getLossOfStockBorrow();
			this.maximumStockLoanRate = builder.getMaximumStockLoanRate();
		}
		
		@Override
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		public AncillaryRoleEnum getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@Override
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			ofNullable(getChangeInLaw()).ifPresent(builder::setChangeInLaw);
			ofNullable(getDeterminingParty()).ifPresent(builder::setDeterminingParty);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getForeignOwnershipEvent()).ifPresent(builder::setForeignOwnershipEvent);
			ofNullable(getHedgingDisruption()).ifPresent(builder::setHedgingDisruption);
			ofNullable(getIncreasedCostOfHedging()).ifPresent(builder::setIncreasedCostOfHedging);
			ofNullable(getIncreasedCostOfStockBorrow()).ifPresent(builder::setIncreasedCostOfStockBorrow);
			ofNullable(getInitialStockLoanRate()).ifPresent(builder::setInitialStockLoanRate);
			ofNullable(getInsolvencyFiling()).ifPresent(builder::setInsolvencyFiling);
			ofNullable(getLossOfStockBorrow()).ifPresent(builder::setLossOfStockBorrow);
			ofNullable(getMaximumStockLoanRate()).ifPresent(builder::setMaximumStockLoanRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEvents {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate +
			'}';
		}
	}
	
	//AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl
	class AdditionalDisruptionEventsBuilderImpl implements AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder {
	
		protected Boolean changeInLaw;
		protected AncillaryRoleEnum determiningParty;
		protected Boolean failureToDeliver;
		protected Boolean foreignOwnershipEvent;
		protected Boolean hedgingDisruption;
		protected Boolean increasedCostOfHedging;
		protected Boolean increasedCostOfStockBorrow;
		protected BigDecimal initialStockLoanRate;
		protected Boolean insolvencyFiling;
		protected Boolean lossOfStockBorrow;
		protected BigDecimal maximumStockLoanRate;
	
		public AdditionalDisruptionEventsBuilderImpl() {
		}
	
		@Override
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		public AncillaryRoleEnum getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@Override
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
	
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean changeInLaw) {
			this.changeInLaw = changeInLaw==null?null:changeInLaw;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingParty(AncillaryRoleEnum determiningParty) {
			this.determiningParty = determiningParty==null?null:determiningParty;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean failureToDeliver) {
			this.failureToDeliver = failureToDeliver==null?null:failureToDeliver;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean foreignOwnershipEvent) {
			this.foreignOwnershipEvent = foreignOwnershipEvent==null?null:foreignOwnershipEvent;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean hedgingDisruption) {
			this.hedgingDisruption = hedgingDisruption==null?null:hedgingDisruption;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean increasedCostOfHedging) {
			this.increasedCostOfHedging = increasedCostOfHedging==null?null:increasedCostOfHedging;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow) {
			this.increasedCostOfStockBorrow = increasedCostOfStockBorrow==null?null:increasedCostOfStockBorrow;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate) {
			this.initialStockLoanRate = initialStockLoanRate==null?null:initialStockLoanRate;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean insolvencyFiling) {
			this.insolvencyFiling = insolvencyFiling==null?null:insolvencyFiling;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow) {
			this.lossOfStockBorrow = lossOfStockBorrow==null?null:lossOfStockBorrow;
			return this;
		}
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate) {
			this.maximumStockLoanRate = maximumStockLoanRate==null?null:maximumStockLoanRate;
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return new AdditionalDisruptionEvents.AdditionalDisruptionEventsImpl(this);
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInLaw()!=null) return true;
			if (getDeterminingParty()!=null) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getForeignOwnershipEvent()!=null) return true;
			if (getHedgingDisruption()!=null) return true;
			if (getIncreasedCostOfHedging()!=null) return true;
			if (getIncreasedCostOfStockBorrow()!=null) return true;
			if (getInitialStockLoanRate()!=null) return true;
			if (getInsolvencyFiling()!=null) return true;
			if (getLossOfStockBorrow()!=null) return true;
			if (getMaximumStockLoanRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder o = (AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder) other;
			
			
			merger.mergeBasic(getChangeInLaw(), o.getChangeInLaw(), this::setChangeInLaw);
			merger.mergeBasic(getDeterminingParty(), o.getDeterminingParty(), this::setDeterminingParty);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getForeignOwnershipEvent(), o.getForeignOwnershipEvent(), this::setForeignOwnershipEvent);
			merger.mergeBasic(getHedgingDisruption(), o.getHedgingDisruption(), this::setHedgingDisruption);
			merger.mergeBasic(getIncreasedCostOfHedging(), o.getIncreasedCostOfHedging(), this::setIncreasedCostOfHedging);
			merger.mergeBasic(getIncreasedCostOfStockBorrow(), o.getIncreasedCostOfStockBorrow(), this::setIncreasedCostOfStockBorrow);
			merger.mergeBasic(getInitialStockLoanRate(), o.getInitialStockLoanRate(), this::setInitialStockLoanRate);
			merger.mergeBasic(getInsolvencyFiling(), o.getInsolvencyFiling(), this::setInsolvencyFiling);
			merger.mergeBasic(getLossOfStockBorrow(), o.getLossOfStockBorrow(), this::setLossOfStockBorrow);
			merger.mergeBasic(getMaximumStockLoanRate(), o.getMaximumStockLoanRate(), this::setMaximumStockLoanRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEventsBuilder {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate +
			'}';
		}
	}
}
