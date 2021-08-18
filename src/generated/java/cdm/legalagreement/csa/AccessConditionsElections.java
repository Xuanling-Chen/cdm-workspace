package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.AccessConditionsElectionsMeta;
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
 * A class to specify the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.
 * @version ${project.version}
 */
@RosettaClass

public interface AccessConditionsElections extends RosettaModelObject {
	AccessConditionsElections build();
	AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder();
	
	/**
	 */
	Boolean getCreditEventUponMerger();
	/**
	 */
	Boolean getForceMajeure();
	/**
	 */
	Boolean getIllegality();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 */
	Boolean getTaxEvent();
	/**
	 */
	Boolean getTaxEventUponMerger();
	final static AccessConditionsElectionsMeta metaData = new AccessConditionsElectionsMeta();
	
	@Override
	default RosettaMetaData<? extends AccessConditionsElections> metaData() {
		return metaData;
	} 
			
	static AccessConditionsElections.AccessConditionsElectionsBuilder builder() {
		return new AccessConditionsElections.AccessConditionsElectionsBuilderImpl();
	}
	
	default Class<? extends AccessConditionsElections> getType() {
		return AccessConditionsElections.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("creditEventUponMerger"), Boolean.class, getCreditEventUponMerger(), this);
		processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
		processor.processBasic(path.newSubPath("illegality"), Boolean.class, getIllegality(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("taxEvent"), Boolean.class, getTaxEvent(), this);
		processor.processBasic(path.newSubPath("taxEventUponMerger"), Boolean.class, getTaxEventUponMerger(), this);
		
	}
	
	
	interface AccessConditionsElectionsBuilder extends AccessConditionsElections, RosettaModelObjectBuilder {
		AccessConditionsElections.AccessConditionsElectionsBuilder setCreditEventUponMerger(Boolean creditEventUponMerger);
		AccessConditionsElections.AccessConditionsElectionsBuilder setForceMajeure(Boolean forceMajeure);
		AccessConditionsElections.AccessConditionsElectionsBuilder setIllegality(Boolean illegality);
		AccessConditionsElections.AccessConditionsElectionsBuilder setParty(CounterpartyRoleEnum party);
		AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEvent(Boolean taxEvent);
		AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEventUponMerger(Boolean taxEventUponMerger);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("creditEventUponMerger"), Boolean.class, getCreditEventUponMerger(), this);
			processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
			processor.processBasic(path.newSubPath("illegality"), Boolean.class, getIllegality(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("taxEvent"), Boolean.class, getTaxEvent(), this);
			processor.processBasic(path.newSubPath("taxEventUponMerger"), Boolean.class, getTaxEventUponMerger(), this);
			
		}
		
	}
	
	//AccessConditionsElections.AccessConditionsElectionsImpl
	class AccessConditionsElectionsImpl implements AccessConditionsElections {
		private final Boolean creditEventUponMerger;
		private final Boolean forceMajeure;
		private final Boolean illegality;
		private final CounterpartyRoleEnum party;
		private final Boolean taxEvent;
		private final Boolean taxEventUponMerger;
		
		protected AccessConditionsElectionsImpl(AccessConditionsElections.AccessConditionsElectionsBuilder builder) {
			this.creditEventUponMerger = builder.getCreditEventUponMerger();
			this.forceMajeure = builder.getForceMajeure();
			this.illegality = builder.getIllegality();
			this.party = builder.getParty();
			this.taxEvent = builder.getTaxEvent();
			this.taxEventUponMerger = builder.getTaxEventUponMerger();
		}
		
		@Override
		public Boolean getCreditEventUponMerger() {
			return creditEventUponMerger;
		}
		
		@Override
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		public Boolean getIllegality() {
			return illegality;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getTaxEvent() {
			return taxEvent;
		}
		
		@Override
		public Boolean getTaxEventUponMerger() {
			return taxEventUponMerger;
		}
		
		@Override
		public AccessConditionsElections build() {
			return this;
		}
		
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder() {
			AccessConditionsElections.AccessConditionsElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccessConditionsElections.AccessConditionsElectionsBuilder builder) {
			ofNullable(getCreditEventUponMerger()).ifPresent(builder::setCreditEventUponMerger);
			ofNullable(getForceMajeure()).ifPresent(builder::setForceMajeure);
			ofNullable(getIllegality()).ifPresent(builder::setIllegality);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getTaxEvent()).ifPresent(builder::setTaxEvent);
			ofNullable(getTaxEventUponMerger()).ifPresent(builder::setTaxEventUponMerger);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditionsElections _that = getType().cast(o);
		
			if (!Objects.equals(creditEventUponMerger, _that.getCreditEventUponMerger())) return false;
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			if (!Objects.equals(illegality, _that.getIllegality())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(taxEvent, _that.getTaxEvent())) return false;
			if (!Objects.equals(taxEventUponMerger, _that.getTaxEventUponMerger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEventUponMerger != null ? creditEventUponMerger.hashCode() : 0);
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			_result = 31 * _result + (illegality != null ? illegality.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxEvent != null ? taxEvent.hashCode() : 0);
			_result = 31 * _result + (taxEventUponMerger != null ? taxEventUponMerger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsElections {" +
				"creditEventUponMerger=" + this.creditEventUponMerger + ", " +
				"forceMajeure=" + this.forceMajeure + ", " +
				"illegality=" + this.illegality + ", " +
				"party=" + this.party + ", " +
				"taxEvent=" + this.taxEvent + ", " +
				"taxEventUponMerger=" + this.taxEventUponMerger +
			'}';
		}
	}
	
	//AccessConditionsElections.AccessConditionsElectionsBuilderImpl
	class AccessConditionsElectionsBuilderImpl implements AccessConditionsElections.AccessConditionsElectionsBuilder {
	
		protected Boolean creditEventUponMerger;
		protected Boolean forceMajeure;
		protected Boolean illegality;
		protected CounterpartyRoleEnum party;
		protected Boolean taxEvent;
		protected Boolean taxEventUponMerger;
	
		public AccessConditionsElectionsBuilderImpl() {
		}
	
		@Override
		public Boolean getCreditEventUponMerger() {
			return creditEventUponMerger;
		}
		
		@Override
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		public Boolean getIllegality() {
			return illegality;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getTaxEvent() {
			return taxEvent;
		}
		
		@Override
		public Boolean getTaxEventUponMerger() {
			return taxEventUponMerger;
		}
		
	
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setCreditEventUponMerger(Boolean creditEventUponMerger) {
			this.creditEventUponMerger = creditEventUponMerger==null?null:creditEventUponMerger;
			return this;
		}
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setForceMajeure(Boolean forceMajeure) {
			this.forceMajeure = forceMajeure==null?null:forceMajeure;
			return this;
		}
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setIllegality(Boolean illegality) {
			this.illegality = illegality==null?null:illegality;
			return this;
		}
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEvent(Boolean taxEvent) {
			this.taxEvent = taxEvent==null?null:taxEvent;
			return this;
		}
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEventUponMerger(Boolean taxEventUponMerger) {
			this.taxEventUponMerger = taxEventUponMerger==null?null:taxEventUponMerger;
			return this;
		}
		
		@Override
		public AccessConditionsElections build() {
			return new AccessConditionsElections.AccessConditionsElectionsImpl(this);
		}
		
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEventUponMerger()!=null) return true;
			if (getForceMajeure()!=null) return true;
			if (getIllegality()!=null) return true;
			if (getParty()!=null) return true;
			if (getTaxEvent()!=null) return true;
			if (getTaxEventUponMerger()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccessConditionsElections.AccessConditionsElectionsBuilder o = (AccessConditionsElections.AccessConditionsElectionsBuilder) other;
			
			
			merger.mergeBasic(getCreditEventUponMerger(), o.getCreditEventUponMerger(), this::setCreditEventUponMerger);
			merger.mergeBasic(getForceMajeure(), o.getForceMajeure(), this::setForceMajeure);
			merger.mergeBasic(getIllegality(), o.getIllegality(), this::setIllegality);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getTaxEvent(), o.getTaxEvent(), this::setTaxEvent);
			merger.mergeBasic(getTaxEventUponMerger(), o.getTaxEventUponMerger(), this::setTaxEventUponMerger);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditionsElections _that = getType().cast(o);
		
			if (!Objects.equals(creditEventUponMerger, _that.getCreditEventUponMerger())) return false;
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			if (!Objects.equals(illegality, _that.getIllegality())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(taxEvent, _that.getTaxEvent())) return false;
			if (!Objects.equals(taxEventUponMerger, _that.getTaxEventUponMerger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEventUponMerger != null ? creditEventUponMerger.hashCode() : 0);
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			_result = 31 * _result + (illegality != null ? illegality.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxEvent != null ? taxEvent.hashCode() : 0);
			_result = 31 * _result + (taxEventUponMerger != null ? taxEventUponMerger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsElectionsBuilder {" +
				"creditEventUponMerger=" + this.creditEventUponMerger + ", " +
				"forceMajeure=" + this.forceMajeure + ", " +
				"illegality=" + this.illegality + ", " +
				"party=" + this.party + ", " +
				"taxEvent=" + this.taxEvent + ", " +
				"taxEventUponMerger=" + this.taxEventUponMerger +
			'}';
		}
	}
}
