package cdm.event.common;

import cdm.event.common.meta.BusinessEventMeta;
import cdm.event.workflow.TradeWarehouseWorkflow;
import cdm.event.workflow.WorkflowStepState;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.annotations.RosettaQualified;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.qualify.Qualified;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A business event represents a life cycle event of a trade and consists of a series of primitive events. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
 * @version ${project.version}
 */
@RosettaClass
@RosettaQualified(attribute="eventQualifier",qualifiedClass=cdm.event.common.BusinessEvent.class)

public interface BusinessEvent extends RosettaModelObject, GlobalKey {
	BusinessEvent build();
	BusinessEvent.BusinessEventBuilder toBuilder();
	
	/**
	 * The date on which the event contractually takes effect, when different from the event date.
	 */
	Date getEffectiveDate();
	/**
	 * Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
	 */
	Date getEventDate();
	/**
	 * The set of effects associated with the lifecycle event, i.e. generated cashflows, contracts (from, say, novation events), listed products (from, say, a bond option exercise event) values and more. Those are represented through a set of globalKey references. This attribute is optional in order to provide implementers with the ability not to make use of this feature.
	 */
	EventEffect getEventEffect();
	/**
	 * The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
	 */
	String getEventQualifier();
	/**
	 * This is placeholder concept for a function call into a calculation that will return an outcome. This concept needs to be further firmed out.
	 */
	String getFunctionCall();
	/**
	 * The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
	 */
	IntentEnum getIntent();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The elemental component(s) that specify the lifecycle events. Each of the primitive/elemental components listed as part of the PrimitiveEvent class has distinctive features that allow to specify the lifecycle event, either by itself or in combination with some other of such components.
	 */
	List<? extends PrimitiveEvent> getPrimitives();
	/**
	 */
	TradeWarehouseWorkflow getTradeWarehouseWorkflow();
	/**
	 * The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.
	 */
	WorkflowStepState getWorkflowEventState();
	final static BusinessEventMeta metaData = new BusinessEventMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessEvent> metaData() {
		return metaData;
	} 
			
	static BusinessEvent.BusinessEventBuilder builder() {
		return new BusinessEvent.BusinessEventBuilderImpl();
	}
	
	default Class<? extends BusinessEvent> getType() {
		return BusinessEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
		processor.processBasic(path.newSubPath("eventQualifier"), String.class, getEventQualifier(), this);
		processor.processBasic(path.newSubPath("functionCall"), String.class, getFunctionCall(), this);
		processor.processBasic(path.newSubPath("intent"), IntentEnum.class, getIntent(), this);
		
		processRosetta(path.newSubPath("eventEffect"), processor, EventEffect.class, getEventEffect());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("primitives"), processor, PrimitiveEvent.class, getPrimitives());
		processRosetta(path.newSubPath("tradeWarehouseWorkflow"), processor, TradeWarehouseWorkflow.class, getTradeWarehouseWorkflow());
		processRosetta(path.newSubPath("workflowEventState"), processor, WorkflowStepState.class, getWorkflowEventState());
	}
	
	
	interface BusinessEventBuilder extends BusinessEvent, RosettaModelObjectBuilder {
		EventEffect.EventEffectBuilder getOrCreateEventEffect();
		EventEffect.EventEffectBuilder getEventEffect();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PrimitiveEvent.PrimitiveEventBuilder getOrCreatePrimitives(int _index);
		List<? extends PrimitiveEvent.PrimitiveEventBuilder> getPrimitives();
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getOrCreateTradeWarehouseWorkflow();
		TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getTradeWarehouseWorkflow();
		WorkflowStepState.WorkflowStepStateBuilder getOrCreateWorkflowEventState();
		WorkflowStepState.WorkflowStepStateBuilder getWorkflowEventState();
		BusinessEvent.BusinessEventBuilder setEffectiveDate(Date effectiveDate);
		BusinessEvent.BusinessEventBuilder setEventDate(Date eventDate);
		BusinessEvent.BusinessEventBuilder setEventEffect(EventEffect eventEffect);
		BusinessEvent.BusinessEventBuilder setEventQualifier(String eventQualifier);
		BusinessEvent.BusinessEventBuilder setFunctionCall(String functionCall);
		BusinessEvent.BusinessEventBuilder setIntent(IntentEnum intent);
		BusinessEvent.BusinessEventBuilder setMeta(MetaFields meta);
		BusinessEvent.BusinessEventBuilder addPrimitives(PrimitiveEvent primitives);
		BusinessEvent.BusinessEventBuilder addPrimitives(PrimitiveEvent primitives, int _idx);
		BusinessEvent.BusinessEventBuilder addPrimitives(List<? extends PrimitiveEvent> primitives);
		BusinessEvent.BusinessEventBuilder setPrimitives(List<? extends PrimitiveEvent> primitives);
		BusinessEvent.BusinessEventBuilder setTradeWarehouseWorkflow(TradeWarehouseWorkflow tradeWarehouseWorkflow);
		BusinessEvent.BusinessEventBuilder setWorkflowEventState(WorkflowStepState workflowEventState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("eventDate"), Date.class, getEventDate(), this);
			processor.processBasic(path.newSubPath("eventQualifier"), String.class, getEventQualifier(), this);
			processor.processBasic(path.newSubPath("functionCall"), String.class, getFunctionCall(), this);
			processor.processBasic(path.newSubPath("intent"), IntentEnum.class, getIntent(), this);
			
			processRosetta(path.newSubPath("eventEffect"), processor, EventEffect.EventEffectBuilder.class, getEventEffect());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("primitives"), processor, PrimitiveEvent.PrimitiveEventBuilder.class, getPrimitives());
			processRosetta(path.newSubPath("tradeWarehouseWorkflow"), processor, TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder.class, getTradeWarehouseWorkflow());
			processRosetta(path.newSubPath("workflowEventState"), processor, WorkflowStepState.WorkflowStepStateBuilder.class, getWorkflowEventState());
		}
		
	}
	
	//BusinessEvent.BusinessEventImpl
	class BusinessEventImpl implements BusinessEvent {
		private final Date effectiveDate;
		private final Date eventDate;
		private final EventEffect eventEffect;
		private final String eventQualifier;
		private final String functionCall;
		private final IntentEnum intent;
		private final MetaFields meta;
		private final List<? extends PrimitiveEvent> primitives;
		private final TradeWarehouseWorkflow tradeWarehouseWorkflow;
		private final WorkflowStepState workflowEventState;
		
		protected BusinessEventImpl(BusinessEvent.BusinessEventBuilder builder) {
			this.effectiveDate = builder.getEffectiveDate();
			this.eventDate = builder.getEventDate();
			this.eventEffect = ofNullable(builder.getEventEffect()).map(f->f.build()).orElse(null);
			this.eventQualifier = builder.getEventQualifier();
			this.functionCall = builder.getFunctionCall();
			this.intent = builder.getIntent();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.primitives = ofNullable(builder.getPrimitives()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeWarehouseWorkflow = ofNullable(builder.getTradeWarehouseWorkflow()).map(f->f.build()).orElse(null);
			this.workflowEventState = ofNullable(builder.getWorkflowEventState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		public EventEffect getEventEffect() {
			return eventEffect;
		}
		
		@Override
		public String getEventQualifier() {
			return eventQualifier;
		}
		
		@Override
		public String getFunctionCall() {
			return functionCall;
		}
		
		@Override
		public IntentEnum getIntent() {
			return intent;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends PrimitiveEvent> getPrimitives() {
			return primitives;
		}
		
		@Override
		public TradeWarehouseWorkflow getTradeWarehouseWorkflow() {
			return tradeWarehouseWorkflow;
		}
		
		@Override
		public WorkflowStepState getWorkflowEventState() {
			return workflowEventState;
		}
		
		@Override
		public BusinessEvent build() {
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder toBuilder() {
			BusinessEvent.BusinessEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessEvent.BusinessEventBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEventDate()).ifPresent(builder::setEventDate);
			ofNullable(getEventEffect()).ifPresent(builder::setEventEffect);
			ofNullable(getEventQualifier()).ifPresent(builder::setEventQualifier);
			ofNullable(getFunctionCall()).ifPresent(builder::setFunctionCall);
			ofNullable(getIntent()).ifPresent(builder::setIntent);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPrimitives()).ifPresent(builder::setPrimitives);
			ofNullable(getTradeWarehouseWorkflow()).ifPresent(builder::setTradeWarehouseWorkflow);
			ofNullable(getWorkflowEventState()).ifPresent(builder::setWorkflowEventState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(eventQualifier, _that.getEventQualifier())) return false;
			if (!Objects.equals(functionCall, _that.getFunctionCall())) return false;
			if (!Objects.equals(intent, _that.getIntent())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(primitives, _that.getPrimitives())) return false;
			if (!Objects.equals(tradeWarehouseWorkflow, _that.getTradeWarehouseWorkflow())) return false;
			if (!Objects.equals(workflowEventState, _that.getWorkflowEventState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (eventQualifier != null ? eventQualifier.hashCode() : 0);
			_result = 31 * _result + (functionCall != null ? functionCall.hashCode() : 0);
			_result = 31 * _result + (intent != null ? intent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (primitives != null ? primitives.hashCode() : 0);
			_result = 31 * _result + (tradeWarehouseWorkflow != null ? tradeWarehouseWorkflow.hashCode() : 0);
			_result = 31 * _result + (workflowEventState != null ? workflowEventState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEvent {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"eventDate=" + this.eventDate + ", " +
				"eventEffect=" + this.eventEffect + ", " +
				"eventQualifier=" + this.eventQualifier + ", " +
				"functionCall=" + this.functionCall + ", " +
				"intent=" + this.intent + ", " +
				"meta=" + this.meta + ", " +
				"primitives=" + this.primitives + ", " +
				"tradeWarehouseWorkflow=" + this.tradeWarehouseWorkflow + ", " +
				"workflowEventState=" + this.workflowEventState +
			'}';
		}
	}
	
	//BusinessEvent.BusinessEventBuilderImpl
	class BusinessEventBuilderImpl implements BusinessEvent.BusinessEventBuilder, GlobalKeyBuilder, Qualified {
	
		protected Date effectiveDate;
		protected Date eventDate;
		protected EventEffect.EventEffectBuilder eventEffect;
		protected String eventQualifier;
		protected String functionCall;
		protected IntentEnum intent;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<PrimitiveEvent.PrimitiveEventBuilder> primitives = new ArrayList<>();
		protected TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder tradeWarehouseWorkflow;
		protected WorkflowStepState.WorkflowStepStateBuilder workflowEventState;
	
		public BusinessEventBuilderImpl() {
		}
	
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Date getEventDate() {
			return eventDate;
		}
		
		@Override
		public EventEffect.EventEffectBuilder getEventEffect() {
			return eventEffect;
		}
		
		@Override
		public EventEffect.EventEffectBuilder getOrCreateEventEffect() {
			EventEffect.EventEffectBuilder result;
			if (eventEffect!=null) {
				result = eventEffect;
			}
			else {
				result = eventEffect = EventEffect.builder();
			}
			
			return result;
		}
		
		@Override
		public String getEventQualifier() {
			return eventQualifier;
		}
		
		@Override
		public String getFunctionCall() {
			return functionCall;
		}
		
		@Override
		public IntentEnum getIntent() {
			return intent;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends PrimitiveEvent.PrimitiveEventBuilder> getPrimitives() {
			return primitives;
		}
		
		public PrimitiveEvent.PrimitiveEventBuilder getOrCreatePrimitives(int _index) {
		
			if (primitives==null) {
				this.primitives = new ArrayList<>();
			}
			PrimitiveEvent.PrimitiveEventBuilder result;
			return getIndex(primitives, _index, () -> {
						PrimitiveEvent.PrimitiveEventBuilder newPrimitives = PrimitiveEvent.builder();
						return newPrimitives;
					});
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getTradeWarehouseWorkflow() {
			return tradeWarehouseWorkflow;
		}
		
		@Override
		public TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder getOrCreateTradeWarehouseWorkflow() {
			TradeWarehouseWorkflow.TradeWarehouseWorkflowBuilder result;
			if (tradeWarehouseWorkflow!=null) {
				result = tradeWarehouseWorkflow;
			}
			else {
				result = tradeWarehouseWorkflow = TradeWarehouseWorkflow.builder();
			}
			
			return result;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder getWorkflowEventState() {
			return workflowEventState;
		}
		
		@Override
		public WorkflowStepState.WorkflowStepStateBuilder getOrCreateWorkflowEventState() {
			WorkflowStepState.WorkflowStepStateBuilder result;
			if (workflowEventState!=null) {
				result = workflowEventState;
			}
			else {
				result = workflowEventState = WorkflowStepState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BusinessEvent.BusinessEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setEventDate(Date eventDate) {
			this.eventDate = eventDate==null?null:eventDate;
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setEventEffect(EventEffect eventEffect) {
			this.eventEffect = eventEffect==null?null:eventEffect.toBuilder();
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setEventQualifier(String eventQualifier) {
			this.eventQualifier = eventQualifier==null?null:eventQualifier;
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setFunctionCall(String functionCall) {
			this.functionCall = functionCall==null?null:functionCall;
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setIntent(IntentEnum intent) {
			this.intent = intent==null?null:intent;
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder addPrimitives(PrimitiveEvent primitives) {
			if (primitives!=null) this.primitives.add(primitives.toBuilder());
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder addPrimitives(PrimitiveEvent primitives, int _idx) {
			getIndex(this.primitives, _idx, () -> primitives.toBuilder());
			return this;
		}
		@Override 
		public BusinessEvent.BusinessEventBuilder addPrimitives(List<? extends PrimitiveEvent> primitivess) {
			if (primitivess != null) {
				for (PrimitiveEvent toAdd : primitivess) {
					this.primitives.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BusinessEvent.BusinessEventBuilder setPrimitives(List<? extends PrimitiveEvent> primitivess) {
			if (primitivess == null)  {
				this.primitives = new ArrayList<>();
			}
			else {
				this.primitives = primitivess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder setTradeWarehouseWorkflow(TradeWarehouseWorkflow tradeWarehouseWorkflow) {
			this.tradeWarehouseWorkflow = tradeWarehouseWorkflow==null?null:tradeWarehouseWorkflow.toBuilder();
			return this;
		}
		@Override
		public BusinessEvent.BusinessEventBuilder setWorkflowEventState(WorkflowStepState workflowEventState) {
			this.workflowEventState = workflowEventState==null?null:workflowEventState.toBuilder();
			return this;
		}
		public void setQualification(String qualification) {
			this.setEventQualifier(qualification);
		}
		
		@Override
		public BusinessEvent build() {
			return new BusinessEvent.BusinessEventImpl(this);
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEvent.BusinessEventBuilder prune() {
			if (eventEffect!=null && !eventEffect.prune().hasData()) eventEffect = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			primitives = primitives.stream().filter(b->b!=null).<PrimitiveEvent.PrimitiveEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeWarehouseWorkflow!=null && !tradeWarehouseWorkflow.prune().hasData()) tradeWarehouseWorkflow = null;
			if (workflowEventState!=null && !workflowEventState.prune().hasData()) workflowEventState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEventDate()!=null) return true;
			if (getEventEffect()!=null && getEventEffect().hasData()) return true;
			if (getEventQualifier()!=null) return true;
			if (getFunctionCall()!=null) return true;
			if (getIntent()!=null) return true;
			if (getPrimitives()!=null && getPrimitives().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeWarehouseWorkflow()!=null && getTradeWarehouseWorkflow().hasData()) return true;
			if (getWorkflowEventState()!=null && getWorkflowEventState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessEvent.BusinessEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessEvent.BusinessEventBuilder o = (BusinessEvent.BusinessEventBuilder) other;
			
			merger.mergeRosetta(getEventEffect(), o.getEventEffect(), this::setEventEffect);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPrimitives(), o.getPrimitives(), this::getOrCreatePrimitives);
			merger.mergeRosetta(getTradeWarehouseWorkflow(), o.getTradeWarehouseWorkflow(), this::setTradeWarehouseWorkflow);
			merger.mergeRosetta(getWorkflowEventState(), o.getWorkflowEventState(), this::setWorkflowEventState);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEventDate(), o.getEventDate(), this::setEventDate);
			merger.mergeBasic(getEventQualifier(), o.getEventQualifier(), this::setEventQualifier);
			merger.mergeBasic(getFunctionCall(), o.getFunctionCall(), this::setFunctionCall);
			merger.mergeBasic(getIntent(), o.getIntent(), this::setIntent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessEvent _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(eventDate, _that.getEventDate())) return false;
			if (!Objects.equals(eventQualifier, _that.getEventQualifier())) return false;
			if (!Objects.equals(functionCall, _that.getFunctionCall())) return false;
			if (!Objects.equals(intent, _that.getIntent())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(primitives, _that.getPrimitives())) return false;
			if (!Objects.equals(tradeWarehouseWorkflow, _that.getTradeWarehouseWorkflow())) return false;
			if (!Objects.equals(workflowEventState, _that.getWorkflowEventState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (eventDate != null ? eventDate.hashCode() : 0);
			_result = 31 * _result + (eventQualifier != null ? eventQualifier.hashCode() : 0);
			_result = 31 * _result + (functionCall != null ? functionCall.hashCode() : 0);
			_result = 31 * _result + (intent != null ? intent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (primitives != null ? primitives.hashCode() : 0);
			_result = 31 * _result + (tradeWarehouseWorkflow != null ? tradeWarehouseWorkflow.hashCode() : 0);
			_result = 31 * _result + (workflowEventState != null ? workflowEventState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessEventBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"eventDate=" + this.eventDate + ", " +
				"eventEffect=" + this.eventEffect + ", " +
				"eventQualifier=" + this.eventQualifier + ", " +
				"functionCall=" + this.functionCall + ", " +
				"intent=" + this.intent + ", " +
				"meta=" + this.meta + ", " +
				"primitives=" + this.primitives + ", " +
				"tradeWarehouseWorkflow=" + this.tradeWarehouseWorkflow + ", " +
				"workflowEventState=" + this.workflowEventState +
			'}';
		}
	}
}
