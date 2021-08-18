package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AccessConditionsMeta;
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
 * A class to specify each party&#39;s election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA). ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii). | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(ii). | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (e): Conditions Precedent and Secured Party’s Rights and Remedies.
 * @version ${project.version}
 */
@RosettaClass

public interface AccessConditions extends RosettaModelObject {
	AccessConditions build();
	AccessConditions.AccessConditionsBuilder toBuilder();
	
	/**
	 * Additional Termination Events applicable to the agreement.
	 */
	List<? extends AdditionalTerminationEvent> getAdditionalTerminationEvent();
	/**
	 * The parties&#39; Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA) election.
	 */
	List<? extends AccessConditionsElections> getPartyElection();
	final static AccessConditionsMeta metaData = new AccessConditionsMeta();
	
	@Override
	default RosettaMetaData<? extends AccessConditions> metaData() {
		return metaData;
	} 
			
	static AccessConditions.AccessConditionsBuilder builder() {
		return new AccessConditions.AccessConditionsBuilderImpl();
	}
	
	default Class<? extends AccessConditions> getType() {
		return AccessConditions.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("additionalTerminationEvent"), processor, AdditionalTerminationEvent.class, getAdditionalTerminationEvent());
		processRosetta(path.newSubPath("partyElection"), processor, AccessConditionsElections.class, getPartyElection());
	}
	
	
	interface AccessConditionsBuilder extends AccessConditions, RosettaModelObjectBuilder {
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder getOrCreateAdditionalTerminationEvent(int _index);
		List<? extends AdditionalTerminationEvent.AdditionalTerminationEventBuilder> getAdditionalTerminationEvent();
		AccessConditionsElections.AccessConditionsElectionsBuilder getOrCreatePartyElection(int _index);
		List<? extends AccessConditionsElections.AccessConditionsElectionsBuilder> getPartyElection();
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent);
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent, int _idx);
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvent);
		AccessConditions.AccessConditionsBuilder setAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvent);
		AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection);
		AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection, int _idx);
		AccessConditions.AccessConditionsBuilder addPartyElection(List<? extends AccessConditionsElections> partyElection);
		AccessConditions.AccessConditionsBuilder setPartyElection(List<? extends AccessConditionsElections> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("additionalTerminationEvent"), processor, AdditionalTerminationEvent.AdditionalTerminationEventBuilder.class, getAdditionalTerminationEvent());
			processRosetta(path.newSubPath("partyElection"), processor, AccessConditionsElections.AccessConditionsElectionsBuilder.class, getPartyElection());
		}
		
	}
	
	//AccessConditions.AccessConditionsImpl
	class AccessConditionsImpl implements AccessConditions {
		private final List<? extends AdditionalTerminationEvent> additionalTerminationEvent;
		private final List<? extends AccessConditionsElections> partyElection;
		
		protected AccessConditionsImpl(AccessConditions.AccessConditionsBuilder builder) {
			this.additionalTerminationEvent = ofNullable(builder.getAdditionalTerminationEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends AdditionalTerminationEvent> getAdditionalTerminationEvent() {
			return additionalTerminationEvent;
		}
		
		@Override
		public List<? extends AccessConditionsElections> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AccessConditions build() {
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder toBuilder() {
			AccessConditions.AccessConditionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccessConditions.AccessConditionsBuilder builder) {
			ofNullable(getAdditionalTerminationEvent()).ifPresent(builder::setAdditionalTerminationEvent);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalTerminationEvent, _that.getAdditionalTerminationEvent())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalTerminationEvent != null ? additionalTerminationEvent.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditions {" +
				"additionalTerminationEvent=" + this.additionalTerminationEvent + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//AccessConditions.AccessConditionsBuilderImpl
	class AccessConditionsBuilderImpl implements AccessConditions.AccessConditionsBuilder {
	
		protected List<AdditionalTerminationEvent.AdditionalTerminationEventBuilder> additionalTerminationEvent = new ArrayList<>();
		protected List<AccessConditionsElections.AccessConditionsElectionsBuilder> partyElection = new ArrayList<>();
	
		public AccessConditionsBuilderImpl() {
		}
	
		@Override
		public List<? extends AdditionalTerminationEvent.AdditionalTerminationEventBuilder> getAdditionalTerminationEvent() {
			return additionalTerminationEvent;
		}
		
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder getOrCreateAdditionalTerminationEvent(int _index) {
		
			if (additionalTerminationEvent==null) {
				this.additionalTerminationEvent = new ArrayList<>();
			}
			AdditionalTerminationEvent.AdditionalTerminationEventBuilder result;
			return getIndex(additionalTerminationEvent, _index, () -> {
						AdditionalTerminationEvent.AdditionalTerminationEventBuilder newAdditionalTerminationEvent = AdditionalTerminationEvent.builder();
						return newAdditionalTerminationEvent;
					});
		}
		
		@Override
		public List<? extends AccessConditionsElections.AccessConditionsElectionsBuilder> getPartyElection() {
			return partyElection;
		}
		
		public AccessConditionsElections.AccessConditionsElectionsBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			AccessConditionsElections.AccessConditionsElectionsBuilder result;
			return getIndex(partyElection, _index, () -> {
						AccessConditionsElections.AccessConditionsElectionsBuilder newPartyElection = AccessConditionsElections.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent) {
			if (additionalTerminationEvent!=null) this.additionalTerminationEvent.add(additionalTerminationEvent.toBuilder());
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent, int _idx) {
			getIndex(this.additionalTerminationEvent, _idx, () -> additionalTerminationEvent.toBuilder());
			return this;
		}
		@Override 
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvents) {
			if (additionalTerminationEvents != null) {
				for (AdditionalTerminationEvent toAdd : additionalTerminationEvents) {
					this.additionalTerminationEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccessConditions.AccessConditionsBuilder setAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvents) {
			if (additionalTerminationEvents == null)  {
				this.additionalTerminationEvent = new ArrayList<>();
			}
			else {
				this.additionalTerminationEvent = additionalTerminationEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public AccessConditions.AccessConditionsBuilder addPartyElection(List<? extends AccessConditionsElections> partyElections) {
			if (partyElections != null) {
				for (AccessConditionsElections toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccessConditions.AccessConditionsBuilder setPartyElection(List<? extends AccessConditionsElections> partyElections) {
			if (partyElections == null)  {
				this.partyElection = new ArrayList<>();
			}
			else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AccessConditions build() {
			return new AccessConditions.AccessConditionsImpl(this);
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditions.AccessConditionsBuilder prune() {
			additionalTerminationEvent = additionalTerminationEvent.stream().filter(b->b!=null).<AdditionalTerminationEvent.AdditionalTerminationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyElection = partyElection.stream().filter(b->b!=null).<AccessConditionsElections.AccessConditionsElectionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalTerminationEvent()!=null && getAdditionalTerminationEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditions.AccessConditionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccessConditions.AccessConditionsBuilder o = (AccessConditions.AccessConditionsBuilder) other;
			
			merger.mergeRosetta(getAdditionalTerminationEvent(), o.getAdditionalTerminationEvent(), this::getOrCreateAdditionalTerminationEvent);
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(additionalTerminationEvent, _that.getAdditionalTerminationEvent())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalTerminationEvent != null ? additionalTerminationEvent.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsBuilder {" +
				"additionalTerminationEvent=" + this.additionalTerminationEvent + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
