package cdm.event.common;

import cdm.event.common.meta.EventTestBundleMeta;
import cdm.event.workflow.WorkflowStep;
import cdm.product.common.settlement.ComputedAmount;
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
 * Combines several events for testing purposes, intended to be used in downstream processes.
 * @version ${project.version}
 */
@RosettaClass

public interface EventTestBundle extends RosettaModelObject {
	EventTestBundle build();
	EventTestBundle.EventTestBundleBuilder toBuilder();
	
	/**
	 */
	List<? extends ComputedAmount> getComputedAmount();
	/**
	 */
	List<? extends WorkflowStep> getEvent();
	final static EventTestBundleMeta metaData = new EventTestBundleMeta();
	
	@Override
	default RosettaMetaData<? extends EventTestBundle> metaData() {
		return metaData;
	} 
			
	static EventTestBundle.EventTestBundleBuilder builder() {
		return new EventTestBundle.EventTestBundleBuilderImpl();
	}
	
	default Class<? extends EventTestBundle> getType() {
		return EventTestBundle.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("computedAmount"), processor, ComputedAmount.class, getComputedAmount());
		processRosetta(path.newSubPath("event"), processor, WorkflowStep.class, getEvent());
	}
	
	
	interface EventTestBundleBuilder extends EventTestBundle, RosettaModelObjectBuilder {
		ComputedAmount.ComputedAmountBuilder getOrCreateComputedAmount(int _index);
		List<? extends ComputedAmount.ComputedAmountBuilder> getComputedAmount();
		WorkflowStep.WorkflowStepBuilder getOrCreateEvent(int _index);
		List<? extends WorkflowStep.WorkflowStepBuilder> getEvent();
		EventTestBundle.EventTestBundleBuilder addComputedAmount(ComputedAmount computedAmount);
		EventTestBundle.EventTestBundleBuilder addComputedAmount(ComputedAmount computedAmount, int _idx);
		EventTestBundle.EventTestBundleBuilder addComputedAmount(List<? extends ComputedAmount> computedAmount);
		EventTestBundle.EventTestBundleBuilder setComputedAmount(List<? extends ComputedAmount> computedAmount);
		EventTestBundle.EventTestBundleBuilder addEvent(WorkflowStep event);
		EventTestBundle.EventTestBundleBuilder addEvent(WorkflowStep event, int _idx);
		EventTestBundle.EventTestBundleBuilder addEvent(List<? extends WorkflowStep> event);
		EventTestBundle.EventTestBundleBuilder setEvent(List<? extends WorkflowStep> event);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("computedAmount"), processor, ComputedAmount.ComputedAmountBuilder.class, getComputedAmount());
			processRosetta(path.newSubPath("event"), processor, WorkflowStep.WorkflowStepBuilder.class, getEvent());
		}
		
	}
	
	//EventTestBundle.EventTestBundleImpl
	class EventTestBundleImpl implements EventTestBundle {
		private final List<? extends ComputedAmount> computedAmount;
		private final List<? extends WorkflowStep> event;
		
		protected EventTestBundleImpl(EventTestBundle.EventTestBundleBuilder builder) {
			this.computedAmount = ofNullable(builder.getComputedAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.event = ofNullable(builder.getEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ComputedAmount> getComputedAmount() {
			return computedAmount;
		}
		
		@Override
		public List<? extends WorkflowStep> getEvent() {
			return event;
		}
		
		@Override
		public EventTestBundle build() {
			return this;
		}
		
		@Override
		public EventTestBundle.EventTestBundleBuilder toBuilder() {
			EventTestBundle.EventTestBundleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventTestBundle.EventTestBundleBuilder builder) {
			ofNullable(getComputedAmount()).ifPresent(builder::setComputedAmount);
			ofNullable(getEvent()).ifPresent(builder::setEvent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTestBundle _that = getType().cast(o);
		
			if (!ListEquals.listEquals(computedAmount, _that.getComputedAmount())) return false;
			if (!ListEquals.listEquals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (computedAmount != null ? computedAmount.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTestBundle {" +
				"computedAmount=" + this.computedAmount + ", " +
				"event=" + this.event +
			'}';
		}
	}
	
	//EventTestBundle.EventTestBundleBuilderImpl
	class EventTestBundleBuilderImpl implements EventTestBundle.EventTestBundleBuilder {
	
		protected List<ComputedAmount.ComputedAmountBuilder> computedAmount = new ArrayList<>();
		protected List<WorkflowStep.WorkflowStepBuilder> event = new ArrayList<>();
	
		public EventTestBundleBuilderImpl() {
		}
	
		@Override
		public List<? extends ComputedAmount.ComputedAmountBuilder> getComputedAmount() {
			return computedAmount;
		}
		
		public ComputedAmount.ComputedAmountBuilder getOrCreateComputedAmount(int _index) {
		
			if (computedAmount==null) {
				this.computedAmount = new ArrayList<>();
			}
			ComputedAmount.ComputedAmountBuilder result;
			return getIndex(computedAmount, _index, () -> {
						ComputedAmount.ComputedAmountBuilder newComputedAmount = ComputedAmount.builder();
						return newComputedAmount;
					});
		}
		
		@Override
		public List<? extends WorkflowStep.WorkflowStepBuilder> getEvent() {
			return event;
		}
		
		public WorkflowStep.WorkflowStepBuilder getOrCreateEvent(int _index) {
		
			if (event==null) {
				this.event = new ArrayList<>();
			}
			WorkflowStep.WorkflowStepBuilder result;
			return getIndex(event, _index, () -> {
						WorkflowStep.WorkflowStepBuilder newEvent = WorkflowStep.builder();
						return newEvent;
					});
		}
		
	
		@Override
		public EventTestBundle.EventTestBundleBuilder addComputedAmount(ComputedAmount computedAmount) {
			if (computedAmount!=null) this.computedAmount.add(computedAmount.toBuilder());
			return this;
		}
		
		@Override
		public EventTestBundle.EventTestBundleBuilder addComputedAmount(ComputedAmount computedAmount, int _idx) {
			getIndex(this.computedAmount, _idx, () -> computedAmount.toBuilder());
			return this;
		}
		@Override 
		public EventTestBundle.EventTestBundleBuilder addComputedAmount(List<? extends ComputedAmount> computedAmounts) {
			if (computedAmounts != null) {
				for (ComputedAmount toAdd : computedAmounts) {
					this.computedAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventTestBundle.EventTestBundleBuilder setComputedAmount(List<? extends ComputedAmount> computedAmounts) {
			if (computedAmounts == null)  {
				this.computedAmount = new ArrayList<>();
			}
			else {
				this.computedAmount = computedAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventTestBundle.EventTestBundleBuilder addEvent(WorkflowStep event) {
			if (event!=null) this.event.add(event.toBuilder());
			return this;
		}
		
		@Override
		public EventTestBundle.EventTestBundleBuilder addEvent(WorkflowStep event, int _idx) {
			getIndex(this.event, _idx, () -> event.toBuilder());
			return this;
		}
		@Override 
		public EventTestBundle.EventTestBundleBuilder addEvent(List<? extends WorkflowStep> events) {
			if (events != null) {
				for (WorkflowStep toAdd : events) {
					this.event.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventTestBundle.EventTestBundleBuilder setEvent(List<? extends WorkflowStep> events) {
			if (events == null)  {
				this.event = new ArrayList<>();
			}
			else {
				this.event = events.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EventTestBundle build() {
			return new EventTestBundle.EventTestBundleImpl(this);
		}
		
		@Override
		public EventTestBundle.EventTestBundleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTestBundle.EventTestBundleBuilder prune() {
			computedAmount = computedAmount.stream().filter(b->b!=null).<ComputedAmount.ComputedAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			event = event.stream().filter(b->b!=null).<WorkflowStep.WorkflowStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getComputedAmount()!=null && getComputedAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEvent()!=null && getEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTestBundle.EventTestBundleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventTestBundle.EventTestBundleBuilder o = (EventTestBundle.EventTestBundleBuilder) other;
			
			merger.mergeRosetta(getComputedAmount(), o.getComputedAmount(), this::getOrCreateComputedAmount);
			merger.mergeRosetta(getEvent(), o.getEvent(), this::getOrCreateEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTestBundle _that = getType().cast(o);
		
			if (!ListEquals.listEquals(computedAmount, _that.getComputedAmount())) return false;
			if (!ListEquals.listEquals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (computedAmount != null ? computedAmount.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTestBundleBuilder {" +
				"computedAmount=" + this.computedAmount + ", " +
				"event=" + this.event +
			'}';
		}
	}
}
