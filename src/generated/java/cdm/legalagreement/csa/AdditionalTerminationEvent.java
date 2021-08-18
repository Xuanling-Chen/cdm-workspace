package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.AdditionalTerminationEventMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify an optional termination event, additional to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA)
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalTerminationEvent extends RosettaModelObject {
	AdditionalTerminationEvent build();
	AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder();
	
	/**
	 * Whether the additional termination event is applicable for the relevant party
	 */
	List<? extends CounterpartyRoleEnum> getApplicableParty();
	/**
	 * The name of the additional termination event
	 */
	String getName();
	final static AdditionalTerminationEventMeta metaData = new AdditionalTerminationEventMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalTerminationEvent> metaData() {
		return metaData;
	} 
			
	static AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder() {
		return new AdditionalTerminationEvent.AdditionalTerminationEventBuilderImpl();
	}
	
	default Class<? extends AdditionalTerminationEvent> getType() {
		return AdditionalTerminationEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableParty"), CounterpartyRoleEnum.class, getApplicableParty(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		
	}
	
	
	interface AdditionalTerminationEventBuilder extends AdditionalTerminationEvent, RosettaModelObjectBuilder {
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty, int _idx);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(List<? extends CounterpartyRoleEnum> applicableParty);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder setApplicableParty(List<? extends CounterpartyRoleEnum> applicableParty);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder setName(String name);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("applicableParty"), CounterpartyRoleEnum.class, getApplicableParty(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			
		}
		
	}
	
	//AdditionalTerminationEvent.AdditionalTerminationEventImpl
	class AdditionalTerminationEventImpl implements AdditionalTerminationEvent {
		private final List<? extends CounterpartyRoleEnum> applicableParty;
		private final String name;
		
		protected AdditionalTerminationEventImpl(AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder) {
			this.applicableParty = ofNullable(builder.getApplicableParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.name = builder.getName();
		}
		
		@Override
		public List<? extends CounterpartyRoleEnum> getApplicableParty() {
			return applicableParty;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public AdditionalTerminationEvent build() {
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder() {
			AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder) {
			ofNullable(getApplicableParty()).ifPresent(builder::setApplicableParty);
			ofNullable(getName()).ifPresent(builder::setName);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerminationEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableParty, _that.getApplicableParty())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableParty != null ? applicableParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTerminationEvent {" +
				"applicableParty=" + this.applicableParty + ", " +
				"name=" + this.name +
			'}';
		}
	}
	
	//AdditionalTerminationEvent.AdditionalTerminationEventBuilderImpl
	class AdditionalTerminationEventBuilderImpl implements AdditionalTerminationEvent.AdditionalTerminationEventBuilder {
	
		protected List<CounterpartyRoleEnum> applicableParty = new ArrayList<>();
		protected String name;
	
		public AdditionalTerminationEventBuilderImpl() {
		}
	
		@Override
		public List<? extends CounterpartyRoleEnum> getApplicableParty() {
			return applicableParty;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
	
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty) {
			if (applicableParty!=null) this.applicableParty.add(applicableParty);
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty, int _idx) {
			getIndex(this.applicableParty, _idx, () -> applicableParty);
			return this;
		}
		@Override 
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(List<? extends CounterpartyRoleEnum> applicablePartys) {
			if (applicablePartys != null) {
				for (CounterpartyRoleEnum toAdd : applicablePartys) {
					this.applicableParty.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder setApplicableParty(List<? extends CounterpartyRoleEnum> applicablePartys) {
			if (applicablePartys == null)  {
				this.applicableParty = new ArrayList<>();
			}
			else {
				this.applicableParty = applicablePartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent build() {
			return new AdditionalTerminationEvent.AdditionalTerminationEventImpl(this);
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableParty()!=null && !getApplicableParty().isEmpty()) return true;
			if (getName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalTerminationEvent.AdditionalTerminationEventBuilder o = (AdditionalTerminationEvent.AdditionalTerminationEventBuilder) other;
			
			
			merger.mergeBasic(getApplicableParty(), o.getApplicableParty(), (Consumer<CounterpartyRoleEnum>) this::addApplicableParty);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerminationEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableParty, _that.getApplicableParty())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableParty != null ? applicableParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTerminationEventBuilder {" +
				"applicableParty=" + this.applicableParty + ", " +
				"name=" + this.name +
			'}';
		}
	}
}
