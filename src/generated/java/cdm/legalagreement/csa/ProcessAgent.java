package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ProcessAgentMeta;
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
 * A class to specify the Process Agent that might be appointed by the parties as part of a Credit Support Annex/Deed or Collateral Transfer Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface ProcessAgent extends RosettaModelObject {
	ProcessAgent build();
	ProcessAgent.ProcessAgentBuilder toBuilder();
	
	/**
	 * The parties&#39; Process Agent election.
	 */
	List<? extends ProcessAgentElection> getPartyElection();
	final static ProcessAgentMeta metaData = new ProcessAgentMeta();
	
	@Override
	default RosettaMetaData<? extends ProcessAgent> metaData() {
		return metaData;
	} 
			
	static ProcessAgent.ProcessAgentBuilder builder() {
		return new ProcessAgent.ProcessAgentBuilderImpl();
	}
	
	default Class<? extends ProcessAgent> getType() {
		return ProcessAgent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, ProcessAgentElection.class, getPartyElection());
	}
	
	
	interface ProcessAgentBuilder extends ProcessAgent, RosettaModelObjectBuilder {
		ProcessAgentElection.ProcessAgentElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends ProcessAgentElection.ProcessAgentElectionBuilder> getPartyElection();
		ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection);
		ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection, int _idx);
		ProcessAgent.ProcessAgentBuilder addPartyElection(List<? extends ProcessAgentElection> partyElection);
		ProcessAgent.ProcessAgentBuilder setPartyElection(List<? extends ProcessAgentElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, ProcessAgentElection.ProcessAgentElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//ProcessAgent.ProcessAgentImpl
	class ProcessAgentImpl implements ProcessAgent {
		private final List<? extends ProcessAgentElection> partyElection;
		
		protected ProcessAgentImpl(ProcessAgent.ProcessAgentBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ProcessAgentElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ProcessAgent build() {
			return this;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder toBuilder() {
			ProcessAgent.ProcessAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProcessAgent.ProcessAgentBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgent {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//ProcessAgent.ProcessAgentBuilderImpl
	class ProcessAgentBuilderImpl implements ProcessAgent.ProcessAgentBuilder {
	
		protected List<ProcessAgentElection.ProcessAgentElectionBuilder> partyElection = new ArrayList<>();
	
		public ProcessAgentBuilderImpl() {
		}
	
		@Override
		public List<? extends ProcessAgentElection.ProcessAgentElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public ProcessAgentElection.ProcessAgentElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			ProcessAgentElection.ProcessAgentElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						ProcessAgentElection.ProcessAgentElectionBuilder newPartyElection = ProcessAgentElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public ProcessAgent.ProcessAgentBuilder addPartyElection(List<? extends ProcessAgentElection> partyElections) {
			if (partyElections != null) {
				for (ProcessAgentElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProcessAgent.ProcessAgentBuilder setPartyElection(List<? extends ProcessAgentElection> partyElections) {
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
		public ProcessAgent build() {
			return new ProcessAgent.ProcessAgentImpl(this);
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgent.ProcessAgentBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<ProcessAgentElection.ProcessAgentElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgent.ProcessAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProcessAgent.ProcessAgentBuilder o = (ProcessAgent.ProcessAgentBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgentBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
