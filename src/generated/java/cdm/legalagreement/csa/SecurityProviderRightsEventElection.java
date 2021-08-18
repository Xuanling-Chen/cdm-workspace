package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.SecurityProviderRightsEventElectionMeta;
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
 * A class to specify party specific Secured Party Rights Event language.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityProviderRightsEventElection extends RosettaModelObject {
	SecurityProviderRightsEventElection build();
	SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder();
	
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 */
	Boolean getRightsEvent();
	final static SecurityProviderRightsEventElectionMeta metaData = new SecurityProviderRightsEventElectionMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityProviderRightsEventElection> metaData() {
		return metaData;
	} 
			
	static SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder() {
		return new SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilderImpl();
	}
	
	default Class<? extends SecurityProviderRightsEventElection> getType() {
		return SecurityProviderRightsEventElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
		
	}
	
	
	interface SecurityProviderRightsEventElectionBuilder extends SecurityProviderRightsEventElection, RosettaModelObjectBuilder {
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setParty(CounterpartyRoleEnum party);
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
			
		}
		
	}
	
	//SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionImpl
	class SecurityProviderRightsEventElectionImpl implements SecurityProviderRightsEventElection {
		private final CounterpartyRoleEnum party;
		private final Boolean rightsEvent;
		
		protected SecurityProviderRightsEventElectionImpl(SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder) {
			this.party = builder.getParty();
			this.rightsEvent = builder.getRightsEvent();
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getRightsEvent() {
			return rightsEvent;
		}
		
		@Override
		public SecurityProviderRightsEventElection build() {
			return this;
		}
		
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder() {
			SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRightsEvent()).ifPresent(builder::setRightsEvent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rightsEvent, _that.getRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rightsEvent != null ? rightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventElection {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
	
	//SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilderImpl
	class SecurityProviderRightsEventElectionBuilderImpl implements SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean rightsEvent;
	
		public SecurityProviderRightsEventElectionBuilderImpl() {
		}
	
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getRightsEvent() {
			return rightsEvent;
		}
		
	
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent) {
			this.rightsEvent = rightsEvent==null?null:rightsEvent;
			return this;
		}
		
		@Override
		public SecurityProviderRightsEventElection build() {
			return new SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionImpl(this);
		}
		
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getRightsEvent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder o = (SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRightsEvent(), o.getRightsEvent(), this::setRightsEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEventElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(rightsEvent, _that.getRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rightsEvent != null ? rightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventElectionBuilder {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
}
