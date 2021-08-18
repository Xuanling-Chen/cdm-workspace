package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.SecuredPartyRightsEventElectionMeta;
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
 * A class to specify party specific Secured Party Rights Event language
 * @version ${project.version}
 */
@RosettaClass

public interface SecuredPartyRightsEventElection extends RosettaModelObject {
	SecuredPartyRightsEventElection build();
	SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder();
	
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * A boolean attribute to specify whether a Secured Party Rights Event will only occur upon the occurrence of one or more of the event specified in a Control Agreement
	 */
	Boolean getRightsEvent();
	final static SecuredPartyRightsEventElectionMeta metaData = new SecuredPartyRightsEventElectionMeta();
	
	@Override
	default RosettaMetaData<? extends SecuredPartyRightsEventElection> metaData() {
		return metaData;
	} 
			
	static SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder() {
		return new SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilderImpl();
	}
	
	default Class<? extends SecuredPartyRightsEventElection> getType() {
		return SecuredPartyRightsEventElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
		
	}
	
	
	interface SecuredPartyRightsEventElectionBuilder extends SecuredPartyRightsEventElection, RosettaModelObjectBuilder {
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setParty(CounterpartyRoleEnum party);
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("rightsEvent"), Boolean.class, getRightsEvent(), this);
			
		}
		
	}
	
	//SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionImpl
	class SecuredPartyRightsEventElectionImpl implements SecuredPartyRightsEventElection {
		private final CounterpartyRoleEnum party;
		private final Boolean rightsEvent;
		
		protected SecuredPartyRightsEventElectionImpl(SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder) {
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
		public SecuredPartyRightsEventElection build() {
			return this;
		}
		
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder() {
			SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRightsEvent()).ifPresent(builder::setRightsEvent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEventElection _that = getType().cast(o);
		
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
			return "SecuredPartyRightsEventElection {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
	
	//SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilderImpl
	class SecuredPartyRightsEventElectionBuilderImpl implements SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean rightsEvent;
	
		public SecuredPartyRightsEventElectionBuilderImpl() {
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
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder setRightsEvent(Boolean rightsEvent) {
			this.rightsEvent = rightsEvent==null?null:rightsEvent;
			return this;
		}
		
		@Override
		public SecuredPartyRightsEventElection build() {
			return new SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionImpl(this);
		}
		
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder prune() {
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
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder o = (SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRightsEvent(), o.getRightsEvent(), this::setRightsEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEventElection _that = getType().cast(o);
		
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
			return "SecuredPartyRightsEventElectionBuilder {" +
				"party=" + this.party + ", " +
				"rightsEvent=" + this.rightsEvent +
			'}';
		}
	}
}
