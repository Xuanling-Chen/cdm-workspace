package cdm.event.workflow;

import cdm.event.workflow.meta.WorkflowStepStateMeta;
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
 * A class to specify workflow information, which is conceptually applicable to all lifecycle events.
 * @version ${project.version}
 */
@RosettaClass

public interface WorkflowStepState extends RosettaModelObject {
	WorkflowStepState build();
	WorkflowStepState.WorkflowStepStateBuilder toBuilder();
	
	/**
	 * A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.
	 */
	String getComment();
	/**
	 * Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.
	 */
	List<? extends PartyCustomisedWorkflow> getPartyCustomisedWorkflow();
	/**
	 * The workflow status indicator, e.g. Accepted, Rejected, ...
	 */
	List<? extends WorkflowStatusEnum> getWorkflowStatus();
	final static WorkflowStepStateMeta metaData = new WorkflowStepStateMeta();
	
	@Override
	default RosettaMetaData<? extends WorkflowStepState> metaData() {
		return metaData;
	} 
			
	static WorkflowStepState.WorkflowStepStateBuilder builder() {
		return new WorkflowStepState.WorkflowStepStateBuilderImpl();
	}
	
	default Class<? extends WorkflowStepState> getType() {
		return WorkflowStepState.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processor.processBasic(path.newSubPath("workflowStatus"), WorkflowStatusEnum.class, getWorkflowStatus(), this);
		
		processRosetta(path.newSubPath("partyCustomisedWorkflow"), processor, PartyCustomisedWorkflow.class, getPartyCustomisedWorkflow());
	}
	
	
	interface WorkflowStepStateBuilder extends WorkflowStepState, RosettaModelObjectBuilder {
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder getOrCreatePartyCustomisedWorkflow(int _index);
		List<? extends PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder> getPartyCustomisedWorkflow();
		WorkflowStepState.WorkflowStepStateBuilder setComment(String comment);
		WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow);
		WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow, int _idx);
		WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow);
		WorkflowStepState.WorkflowStepStateBuilder setPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow);
		WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(WorkflowStatusEnum workflowStatus);
		WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(WorkflowStatusEnum workflowStatus, int _idx);
		WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(List<? extends WorkflowStatusEnum> workflowStatus);
		WorkflowStepState.WorkflowStepStateBuilder setWorkflowStatus(List<? extends WorkflowStatusEnum> workflowStatus);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processor.processBasic(path.newSubPath("workflowStatus"), WorkflowStatusEnum.class, getWorkflowStatus(), this);
			
			processRosetta(path.newSubPath("partyCustomisedWorkflow"), processor, PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder.class, getPartyCustomisedWorkflow());
		}
		
	}
	
	//WorkflowStepState.WorkflowStepStateImpl
	class WorkflowStepStateImpl implements WorkflowStepState {
		private final String comment;
		private final List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow;
		private final List<? extends WorkflowStatusEnum> workflowStatus;
		
		protected WorkflowStepStateImpl(WorkflowStepState.WorkflowStepStateBuilder builder) {
			this.comment = builder.getComment();
			this.partyCustomisedWorkflow = ofNullable(builder.getPartyCustomisedWorkflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.workflowStatus = ofNullable(builder.getWorkflowStatus()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public String getComment() {
			return comment;
		}
		
		@Override
		public List<? extends PartyCustomisedWorkflow> getPartyCustomisedWorkflow() {
			return partyCustomisedWorkflow;
		}
		
		@Override
		public List<? extends WorkflowStatusEnum> getWorkflowStatus() {
			return workflowStatus;
		}
		
		@Override
		public WorkflowStepState build() {
			return this;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder toBuilder() {
			WorkflowStepState.WorkflowStepStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WorkflowStepState.WorkflowStepStateBuilder builder) {
			ofNullable(getComment()).ifPresent(builder::setComment);
			ofNullable(getPartyCustomisedWorkflow()).ifPresent(builder::setPartyCustomisedWorkflow);
			ofNullable(getWorkflowStatus()).ifPresent(builder::setWorkflowStatus);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStepState _that = getType().cast(o);
		
			if (!Objects.equals(comment, _that.getComment())) return false;
			if (!ListEquals.listEquals(partyCustomisedWorkflow, _that.getPartyCustomisedWorkflow())) return false;
			if (!ListEquals.listEquals(workflowStatus, _that.getWorkflowStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			_result = 31 * _result + (partyCustomisedWorkflow != null ? partyCustomisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (workflowStatus != null ? workflowStatus.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepState {" +
				"comment=" + this.comment + ", " +
				"partyCustomisedWorkflow=" + this.partyCustomisedWorkflow + ", " +
				"workflowStatus=" + this.workflowStatus +
			'}';
		}
	}
	
	//WorkflowStepState.WorkflowStepStateBuilderImpl
	class WorkflowStepStateBuilderImpl implements WorkflowStepState.WorkflowStepStateBuilder {
	
		protected String comment;
		protected List<PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder> partyCustomisedWorkflow = new ArrayList<>();
		protected List<WorkflowStatusEnum> workflowStatus = new ArrayList<>();
	
		public WorkflowStepStateBuilderImpl() {
		}
	
		@Override
		public String getComment() {
			return comment;
		}
		
		@Override
		public List<? extends PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder> getPartyCustomisedWorkflow() {
			return partyCustomisedWorkflow;
		}
		
		public PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder getOrCreatePartyCustomisedWorkflow(int _index) {
		
			if (partyCustomisedWorkflow==null) {
				this.partyCustomisedWorkflow = new ArrayList<>();
			}
			PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder result;
			return getIndex(partyCustomisedWorkflow, _index, () -> {
						PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder newPartyCustomisedWorkflow = PartyCustomisedWorkflow.builder();
						return newPartyCustomisedWorkflow;
					});
		}
		
		@Override
		public List<? extends WorkflowStatusEnum> getWorkflowStatus() {
			return workflowStatus;
		}
		
	
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow) {
			if (partyCustomisedWorkflow!=null) this.partyCustomisedWorkflow.add(partyCustomisedWorkflow.toBuilder());
			return this;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow, int _idx) {
			getIndex(this.partyCustomisedWorkflow, _idx, () -> partyCustomisedWorkflow.toBuilder());
			return this;
		}
		@Override 
		public WorkflowStepState.WorkflowStepStateBuilder addPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflows) {
			if (partyCustomisedWorkflows != null) {
				for (PartyCustomisedWorkflow toAdd : partyCustomisedWorkflows) {
					this.partyCustomisedWorkflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStepState.WorkflowStepStateBuilder setPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflows) {
			if (partyCustomisedWorkflows == null)  {
				this.partyCustomisedWorkflow = new ArrayList<>();
			}
			else {
				this.partyCustomisedWorkflow = partyCustomisedWorkflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(WorkflowStatusEnum workflowStatus) {
			if (workflowStatus!=null) this.workflowStatus.add(workflowStatus);
			return this;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(WorkflowStatusEnum workflowStatus, int _idx) {
			getIndex(this.workflowStatus, _idx, () -> workflowStatus);
			return this;
		}
		@Override 
		public WorkflowStepState.WorkflowStepStateBuilder addWorkflowStatus(List<? extends WorkflowStatusEnum> workflowStatuss) {
			if (workflowStatuss != null) {
				for (WorkflowStatusEnum toAdd : workflowStatuss) {
					this.workflowStatus.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStepState.WorkflowStepStateBuilder setWorkflowStatus(List<? extends WorkflowStatusEnum> workflowStatuss) {
			if (workflowStatuss == null)  {
				this.workflowStatus = new ArrayList<>();
			}
			else {
				this.workflowStatus = workflowStatuss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public WorkflowStepState build() {
			return new WorkflowStepState.WorkflowStepStateImpl(this);
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder prune() {
			partyCustomisedWorkflow = partyCustomisedWorkflow.stream().filter(b->b!=null).<PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getComment()!=null) return true;
			if (getPartyCustomisedWorkflow()!=null && getPartyCustomisedWorkflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWorkflowStatus()!=null && !getWorkflowStatus().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WorkflowStepState.WorkflowStepStateBuilder o = (WorkflowStepState.WorkflowStepStateBuilder) other;
			
			merger.mergeRosetta(getPartyCustomisedWorkflow(), o.getPartyCustomisedWorkflow(), this::getOrCreatePartyCustomisedWorkflow);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			merger.mergeBasic(getWorkflowStatus(), o.getWorkflowStatus(), (Consumer<WorkflowStatusEnum>) this::addWorkflowStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStepState _that = getType().cast(o);
		
			if (!Objects.equals(comment, _that.getComment())) return false;
			if (!ListEquals.listEquals(partyCustomisedWorkflow, _that.getPartyCustomisedWorkflow())) return false;
			if (!ListEquals.listEquals(workflowStatus, _that.getWorkflowStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			_result = 31 * _result + (partyCustomisedWorkflow != null ? partyCustomisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (workflowStatus != null ? workflowStatus.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepStateBuilder {" +
				"comment=" + this.comment + ", " +
				"partyCustomisedWorkflow=" + this.partyCustomisedWorkflow + ", " +
				"workflowStatus=" + this.workflowStatus +
			'}';
		}
	}
}
