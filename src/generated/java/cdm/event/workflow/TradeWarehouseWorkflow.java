package cdm.event.workflow;

import cdm.event.workflow.meta.TradeWarehouseWorkflowMeta;
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
 * A class to specify trade warehouse workflow information: the identity of the trade warehouse, the contract status at the warehouse and party-specific workflow information.
 * @version ${project.version}
 */
@RosettaClass

public interface TradeWarehouseWorkflow extends RosettaModelObject {
	TradeWarehouseWorkflow build();
	TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder toBuilder();
	
	/**
	 * Non-standardized workflow data related to a party.
	 */
	List<? extends PartyCustomisedWorkflow> getPartyCustomisedWorkflow();
	/**
	 */
	WarehouseIdentityEnum getWarehouseIdentity();
	/**
	 */
	WorkflowStatusEnum getWarehouseStatus();
	final static TradeWarehouseWorkflowMeta metaData = new TradeWarehouseWorkflowMeta();
	
	@Override
	default RosettaMetaData<? extends TradeWarehouseWorkflow> metaData() {
		return metaData;
	} 
			
	static TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder builder() {
		return new TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilderImpl();
	}
	
	default Class<? extends TradeWarehouseWorkflow> getType() {
		return TradeWarehouseWorkflow.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("warehouseIdentity"), WarehouseIdentityEnum.class, getWarehouseIdentity(), this);
		processor.processBasic(path.newSubPath("warehouseStatus"), WorkflowStatusEnum.class, getWarehouseStatus(), this);
		
		processRosetta(path.newSubPath("partyCustomisedWorkflow"), processor, PartyCustomisedWorkflow.class, getPartyCustomisedWorkflow());
	}
	
	
	interface TradeWarehouseWorkflowBuilder extends TradeWarehouseWorkflow, RosettaModelObjectBuilder {
		PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder getOrCreatePartyCustomisedWorkflow(int _index);
		List<? extends PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder> getPartyCustomisedWorkflow();
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow);
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow, int _idx);
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow);
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow);
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setWarehouseIdentity(WarehouseIdentityEnum warehouseIdentity);
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setWarehouseStatus(WorkflowStatusEnum warehouseStatus);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("warehouseIdentity"), WarehouseIdentityEnum.class, getWarehouseIdentity(), this);
			processor.processBasic(path.newSubPath("warehouseStatus"), WorkflowStatusEnum.class, getWarehouseStatus(), this);
			
			processRosetta(path.newSubPath("partyCustomisedWorkflow"), processor, PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder.class, getPartyCustomisedWorkflow());
		}
		
	}
	
	//TradeWarehouseWorkflow.TradeWarehouseWorkflowImpl
	class TradeWarehouseWorkflowImpl implements TradeWarehouseWorkflow {
		private final List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflow;
		private final WarehouseIdentityEnum warehouseIdentity;
		private final WorkflowStatusEnum warehouseStatus;
		
		protected TradeWarehouseWorkflowImpl(TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder builder) {
			this.partyCustomisedWorkflow = ofNullable(builder.getPartyCustomisedWorkflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.warehouseIdentity = builder.getWarehouseIdentity();
			this.warehouseStatus = builder.getWarehouseStatus();
		}
		
		@Override
		public List<? extends PartyCustomisedWorkflow> getPartyCustomisedWorkflow() {
			return partyCustomisedWorkflow;
		}
		
		@Override
		public WarehouseIdentityEnum getWarehouseIdentity() {
			return warehouseIdentity;
		}
		
		@Override
		public WorkflowStatusEnum getWarehouseStatus() {
			return warehouseStatus;
		}
		
		@Override
		public TradeWarehouseWorkflow build() {
			return this;
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder toBuilder() {
			TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder builder) {
			ofNullable(getPartyCustomisedWorkflow()).ifPresent(builder::setPartyCustomisedWorkflow);
			ofNullable(getWarehouseIdentity()).ifPresent(builder::setWarehouseIdentity);
			ofNullable(getWarehouseStatus()).ifPresent(builder::setWarehouseStatus);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWarehouseWorkflow _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyCustomisedWorkflow, _that.getPartyCustomisedWorkflow())) return false;
			if (!Objects.equals(warehouseIdentity, _that.getWarehouseIdentity())) return false;
			if (!Objects.equals(warehouseStatus, _that.getWarehouseStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyCustomisedWorkflow != null ? partyCustomisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (warehouseIdentity != null ? warehouseIdentity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (warehouseStatus != null ? warehouseStatus.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWarehouseWorkflow {" +
				"partyCustomisedWorkflow=" + this.partyCustomisedWorkflow + ", " +
				"warehouseIdentity=" + this.warehouseIdentity + ", " +
				"warehouseStatus=" + this.warehouseStatus +
			'}';
		}
	}
	
	//TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilderImpl
	class TradeWarehouseWorkflowBuilderImpl implements TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder {
	
		protected List<PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder> partyCustomisedWorkflow = new ArrayList<>();
		protected WarehouseIdentityEnum warehouseIdentity;
		protected WorkflowStatusEnum warehouseStatus;
	
		public TradeWarehouseWorkflowBuilderImpl() {
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
		public WarehouseIdentityEnum getWarehouseIdentity() {
			return warehouseIdentity;
		}
		
		@Override
		public WorkflowStatusEnum getWarehouseStatus() {
			return warehouseStatus;
		}
		
	
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow) {
			if (partyCustomisedWorkflow!=null) this.partyCustomisedWorkflow.add(partyCustomisedWorkflow.toBuilder());
			return this;
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(PartyCustomisedWorkflow partyCustomisedWorkflow, int _idx) {
			getIndex(this.partyCustomisedWorkflow, _idx, () -> partyCustomisedWorkflow.toBuilder());
			return this;
		}
		@Override 
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder addPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflows) {
			if (partyCustomisedWorkflows != null) {
				for (PartyCustomisedWorkflow toAdd : partyCustomisedWorkflows) {
					this.partyCustomisedWorkflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setPartyCustomisedWorkflow(List<? extends PartyCustomisedWorkflow> partyCustomisedWorkflows) {
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
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setWarehouseIdentity(WarehouseIdentityEnum warehouseIdentity) {
			this.warehouseIdentity = warehouseIdentity==null?null:warehouseIdentity;
			return this;
		}
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder setWarehouseStatus(WorkflowStatusEnum warehouseStatus) {
			this.warehouseStatus = warehouseStatus==null?null:warehouseStatus;
			return this;
		}
		
		@Override
		public TradeWarehouseWorkflow build() {
			return new TradeWarehouseWorkflow.TradeWarehouseWorkflowImpl(this);
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder prune() {
			partyCustomisedWorkflow = partyCustomisedWorkflow.stream().filter(b->b!=null).<PartyCustomisedWorkflow.PartyCustomisedWorkflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyCustomisedWorkflow()!=null && getPartyCustomisedWorkflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWarehouseIdentity()!=null) return true;
			if (getWarehouseStatus()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder o = (TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder) other;
			
			merger.mergeRosetta(getPartyCustomisedWorkflow(), o.getPartyCustomisedWorkflow(), this::getOrCreatePartyCustomisedWorkflow);
			
			merger.mergeBasic(getWarehouseIdentity(), o.getWarehouseIdentity(), this::setWarehouseIdentity);
			merger.mergeBasic(getWarehouseStatus(), o.getWarehouseStatus(), this::setWarehouseStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWarehouseWorkflow _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyCustomisedWorkflow, _that.getPartyCustomisedWorkflow())) return false;
			if (!Objects.equals(warehouseIdentity, _that.getWarehouseIdentity())) return false;
			if (!Objects.equals(warehouseStatus, _that.getWarehouseStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyCustomisedWorkflow != null ? partyCustomisedWorkflow.hashCode() : 0);
			_result = 31 * _result + (warehouseIdentity != null ? warehouseIdentity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (warehouseStatus != null ? warehouseStatus.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWarehouseWorkflowBuilder {" +
				"partyCustomisedWorkflow=" + this.partyCustomisedWorkflow + ", " +
				"warehouseIdentity=" + this.warehouseIdentity + ", " +
				"warehouseStatus=" + this.warehouseStatus +
			'}';
		}
	}
}
