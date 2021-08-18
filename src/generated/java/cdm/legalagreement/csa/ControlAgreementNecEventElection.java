package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.ControlAgreementNecEventElectionMeta;
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
 * A class to specify party specific Control Agreement language related to delivery of a Notice of Exclusive Control
 * @version ${project.version}
 */
@RosettaClass

public interface ControlAgreementNecEventElection extends RosettaModelObject {
	ControlAgreementNecEventElection build();
	ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder();
	
	/**
	 */
	Boolean getNecEvent();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static ControlAgreementNecEventElectionMeta metaData = new ControlAgreementNecEventElectionMeta();
	
	@Override
	default RosettaMetaData<? extends ControlAgreementNecEventElection> metaData() {
		return metaData;
	} 
			
	static ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder() {
		return new ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilderImpl();
	}
	
	default Class<? extends ControlAgreementNecEventElection> getType() {
		return ControlAgreementNecEventElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("necEvent"), Boolean.class, getNecEvent(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface ControlAgreementNecEventElectionBuilder extends ControlAgreementNecEventElection, RosettaModelObjectBuilder {
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setNecEvent(Boolean necEvent);
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("necEvent"), Boolean.class, getNecEvent(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//ControlAgreementNecEventElection.ControlAgreementNecEventElectionImpl
	class ControlAgreementNecEventElectionImpl implements ControlAgreementNecEventElection {
		private final Boolean necEvent;
		private final CounterpartyRoleEnum party;
		
		protected ControlAgreementNecEventElectionImpl(ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder) {
			this.necEvent = builder.getNecEvent();
			this.party = builder.getParty();
		}
		
		@Override
		public Boolean getNecEvent() {
			return necEvent;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public ControlAgreementNecEventElection build() {
			return this;
		}
		
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder() {
			ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder builder) {
			ofNullable(getNecEvent()).ifPresent(builder::setNecEvent);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEventElection _that = getType().cast(o);
		
			if (!Objects.equals(necEvent, _that.getNecEvent())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (necEvent != null ? necEvent.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventElection {" +
				"necEvent=" + this.necEvent + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilderImpl
	class ControlAgreementNecEventElectionBuilderImpl implements ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder {
	
		protected Boolean necEvent;
		protected CounterpartyRoleEnum party;
	
		public ControlAgreementNecEventElectionBuilderImpl() {
		}
	
		@Override
		public Boolean getNecEvent() {
			return necEvent;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setNecEvent(Boolean necEvent) {
			this.necEvent = necEvent==null?null:necEvent;
			return this;
		}
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public ControlAgreementNecEventElection build() {
			return new ControlAgreementNecEventElection.ControlAgreementNecEventElectionImpl(this);
		}
		
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNecEvent()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder o = (ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder) other;
			
			
			merger.mergeBasic(getNecEvent(), o.getNecEvent(), this::setNecEvent);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEventElection _that = getType().cast(o);
		
			if (!Objects.equals(necEvent, _that.getNecEvent())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (necEvent != null ? necEvent.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventElectionBuilder {" +
				"necEvent=" + this.necEvent + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
