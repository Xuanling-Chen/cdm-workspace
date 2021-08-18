package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyContactInformation;
import cdm.legalagreement.csa.meta.ProcessAgentElectionMeta;
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
 * A class to specify the parties&#39; respective elections with respect to the Process Agent.
 * @version ${project.version}
 */
@RosettaClass

public interface ProcessAgentElection extends RosettaModelObject {
	ProcessAgentElection build();
	ProcessAgentElection.ProcessAgentElectionBuilder toBuilder();
	
	/**
	 * The qualification of whether the Process Agent is applicable (True) or not applicable (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The Process Agent specification, when applicable.
	 */
	PartyContactInformation getProcessAgent();
	final static ProcessAgentElectionMeta metaData = new ProcessAgentElectionMeta();
	
	@Override
	default RosettaMetaData<? extends ProcessAgentElection> metaData() {
		return metaData;
	} 
			
	static ProcessAgentElection.ProcessAgentElectionBuilder builder() {
		return new ProcessAgentElection.ProcessAgentElectionBuilderImpl();
	}
	
	default Class<? extends ProcessAgentElection> getType() {
		return ProcessAgentElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("processAgent"), processor, PartyContactInformation.class, getProcessAgent());
	}
	
	
	interface ProcessAgentElectionBuilder extends ProcessAgentElection, RosettaModelObjectBuilder {
		PartyContactInformation.PartyContactInformationBuilder getOrCreateProcessAgent();
		PartyContactInformation.PartyContactInformationBuilder getProcessAgent();
		ProcessAgentElection.ProcessAgentElectionBuilder setIsApplicable(Boolean isApplicable);
		ProcessAgentElection.ProcessAgentElectionBuilder setParty(CounterpartyRoleEnum party);
		ProcessAgentElection.ProcessAgentElectionBuilder setProcessAgent(PartyContactInformation processAgent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("processAgent"), processor, PartyContactInformation.PartyContactInformationBuilder.class, getProcessAgent());
		}
		
	}
	
	//ProcessAgentElection.ProcessAgentElectionImpl
	class ProcessAgentElectionImpl implements ProcessAgentElection {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		private final PartyContactInformation processAgent;
		
		protected ProcessAgentElectionImpl(ProcessAgentElection.ProcessAgentElectionBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public PartyContactInformation getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgentElection build() {
			return this;
		}
		
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder toBuilder() {
			ProcessAgentElection.ProcessAgentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProcessAgentElection.ProcessAgentElectionBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgentElection {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}
	
	//ProcessAgentElection.ProcessAgentElectionBuilderImpl
	class ProcessAgentElectionBuilderImpl implements ProcessAgentElection.ProcessAgentElectionBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
		protected PartyContactInformation.PartyContactInformationBuilder processAgent;
	
		public ProcessAgentElectionBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder getOrCreateProcessAgent() {
			PartyContactInformation.PartyContactInformationBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = PartyContactInformation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setProcessAgent(PartyContactInformation processAgent) {
			this.processAgent = processAgent==null?null:processAgent.toBuilder();
			return this;
		}
		
		@Override
		public ProcessAgentElection build() {
			return new ProcessAgentElection.ProcessAgentElectionImpl(this);
		}
		
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder prune() {
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProcessAgentElection.ProcessAgentElectionBuilder o = (ProcessAgentElection.ProcessAgentElectionBuilder) other;
			
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgentElectionBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}
}
