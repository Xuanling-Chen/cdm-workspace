package cdm.observable.event;

import cdm.base.datetime.AveragingSchedule;
import cdm.base.datetime.DateList;
import cdm.observable.event.meta.TriggerEventMeta;
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
 * Observation point for trigger.
 * @version ${project.version}
 */
@RosettaClass

public interface TriggerEvent extends RosettaModelObject {
	TriggerEvent build();
	TriggerEvent.TriggerEventBuilder toBuilder();
	
	/**
	 * The feature payment, i.e. the payment made following trigger occurrence.
	 */
	FeaturePayment getFeaturePayment();
	/**
	 * A derivative schedule.
	 */
	List<? extends AveragingSchedule> getSchedule();
	/**
	 * The trigger level
	 */
	Trigger getTrigger();
	/**
	 * The trigger Dates.
	 */
	DateList getTriggerDates();
	final static TriggerEventMeta metaData = new TriggerEventMeta();
	
	@Override
	default RosettaMetaData<? extends TriggerEvent> metaData() {
		return metaData;
	} 
			
	static TriggerEvent.TriggerEventBuilder builder() {
		return new TriggerEvent.TriggerEventBuilderImpl();
	}
	
	default Class<? extends TriggerEvent> getType() {
		return TriggerEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("featurePayment"), processor, FeaturePayment.class, getFeaturePayment());
		processRosetta(path.newSubPath("schedule"), processor, AveragingSchedule.class, getSchedule());
		processRosetta(path.newSubPath("trigger"), processor, Trigger.class, getTrigger());
		processRosetta(path.newSubPath("triggerDates"), processor, DateList.class, getTriggerDates());
	}
	
	
	interface TriggerEventBuilder extends TriggerEvent, RosettaModelObjectBuilder {
		FeaturePayment.FeaturePaymentBuilder getOrCreateFeaturePayment();
		FeaturePayment.FeaturePaymentBuilder getFeaturePayment();
		AveragingSchedule.AveragingScheduleBuilder getOrCreateSchedule(int _index);
		List<? extends AveragingSchedule.AveragingScheduleBuilder> getSchedule();
		Trigger.TriggerBuilder getOrCreateTrigger();
		Trigger.TriggerBuilder getTrigger();
		DateList.DateListBuilder getOrCreateTriggerDates();
		DateList.DateListBuilder getTriggerDates();
		TriggerEvent.TriggerEventBuilder setFeaturePayment(FeaturePayment featurePayment);
		TriggerEvent.TriggerEventBuilder addSchedule(AveragingSchedule schedule);
		TriggerEvent.TriggerEventBuilder addSchedule(AveragingSchedule schedule, int _idx);
		TriggerEvent.TriggerEventBuilder addSchedule(List<? extends AveragingSchedule> schedule);
		TriggerEvent.TriggerEventBuilder setSchedule(List<? extends AveragingSchedule> schedule);
		TriggerEvent.TriggerEventBuilder setTrigger(Trigger trigger);
		TriggerEvent.TriggerEventBuilder setTriggerDates(DateList triggerDates);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("featurePayment"), processor, FeaturePayment.FeaturePaymentBuilder.class, getFeaturePayment());
			processRosetta(path.newSubPath("schedule"), processor, AveragingSchedule.AveragingScheduleBuilder.class, getSchedule());
			processRosetta(path.newSubPath("trigger"), processor, Trigger.TriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("triggerDates"), processor, DateList.DateListBuilder.class, getTriggerDates());
		}
		
	}
	
	//TriggerEvent.TriggerEventImpl
	class TriggerEventImpl implements TriggerEvent {
		private final FeaturePayment featurePayment;
		private final List<? extends AveragingSchedule> schedule;
		private final Trigger trigger;
		private final DateList triggerDates;
		
		protected TriggerEventImpl(TriggerEvent.TriggerEventBuilder builder) {
			this.featurePayment = ofNullable(builder.getFeaturePayment()).map(f->f.build()).orElse(null);
			this.schedule = ofNullable(builder.getSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
			this.triggerDates = ofNullable(builder.getTriggerDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FeaturePayment getFeaturePayment() {
			return featurePayment;
		}
		
		@Override
		public List<? extends AveragingSchedule> getSchedule() {
			return schedule;
		}
		
		@Override
		public Trigger getTrigger() {
			return trigger;
		}
		
		@Override
		public DateList getTriggerDates() {
			return triggerDates;
		}
		
		@Override
		public TriggerEvent build() {
			return this;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder toBuilder() {
			TriggerEvent.TriggerEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerEvent.TriggerEventBuilder builder) {
			ofNullable(getFeaturePayment()).ifPresent(builder::setFeaturePayment);
			ofNullable(getSchedule()).ifPresent(builder::setSchedule);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getTriggerDates()).ifPresent(builder::setTriggerDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerEvent _that = getType().cast(o);
		
			if (!Objects.equals(featurePayment, _that.getFeaturePayment())) return false;
			if (!ListEquals.listEquals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(triggerDates, _that.getTriggerDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (featurePayment != null ? featurePayment.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (triggerDates != null ? triggerDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerEvent {" +
				"featurePayment=" + this.featurePayment + ", " +
				"schedule=" + this.schedule + ", " +
				"trigger=" + this.trigger + ", " +
				"triggerDates=" + this.triggerDates +
			'}';
		}
	}
	
	//TriggerEvent.TriggerEventBuilderImpl
	class TriggerEventBuilderImpl implements TriggerEvent.TriggerEventBuilder {
	
		protected FeaturePayment.FeaturePaymentBuilder featurePayment;
		protected List<AveragingSchedule.AveragingScheduleBuilder> schedule = new ArrayList<>();
		protected Trigger.TriggerBuilder trigger;
		protected DateList.DateListBuilder triggerDates;
	
		public TriggerEventBuilderImpl() {
		}
	
		@Override
		public FeaturePayment.FeaturePaymentBuilder getFeaturePayment() {
			return featurePayment;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder getOrCreateFeaturePayment() {
			FeaturePayment.FeaturePaymentBuilder result;
			if (featurePayment!=null) {
				result = featurePayment;
			}
			else {
				result = featurePayment = FeaturePayment.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends AveragingSchedule.AveragingScheduleBuilder> getSchedule() {
			return schedule;
		}
		
		public AveragingSchedule.AveragingScheduleBuilder getOrCreateSchedule(int _index) {
		
			if (schedule==null) {
				this.schedule = new ArrayList<>();
			}
			AveragingSchedule.AveragingScheduleBuilder result;
			return getIndex(schedule, _index, () -> {
						AveragingSchedule.AveragingScheduleBuilder newSchedule = AveragingSchedule.builder();
						return newSchedule;
					});
		}
		
		@Override
		public Trigger.TriggerBuilder getTrigger() {
			return trigger;
		}
		
		@Override
		public Trigger.TriggerBuilder getOrCreateTrigger() {
			Trigger.TriggerBuilder result;
			if (trigger!=null) {
				result = trigger;
			}
			else {
				result = trigger = Trigger.builder();
			}
			
			return result;
		}
		
		@Override
		public DateList.DateListBuilder getTriggerDates() {
			return triggerDates;
		}
		
		@Override
		public DateList.DateListBuilder getOrCreateTriggerDates() {
			DateList.DateListBuilder result;
			if (triggerDates!=null) {
				result = triggerDates;
			}
			else {
				result = triggerDates = DateList.builder();
			}
			
			return result;
		}
		
	
		@Override
		public TriggerEvent.TriggerEventBuilder setFeaturePayment(FeaturePayment featurePayment) {
			this.featurePayment = featurePayment==null?null:featurePayment.toBuilder();
			return this;
		}
		@Override
		public TriggerEvent.TriggerEventBuilder addSchedule(AveragingSchedule schedule) {
			if (schedule!=null) this.schedule.add(schedule.toBuilder());
			return this;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder addSchedule(AveragingSchedule schedule, int _idx) {
			getIndex(this.schedule, _idx, () -> schedule.toBuilder());
			return this;
		}
		@Override 
		public TriggerEvent.TriggerEventBuilder addSchedule(List<? extends AveragingSchedule> schedules) {
			if (schedules != null) {
				for (AveragingSchedule toAdd : schedules) {
					this.schedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TriggerEvent.TriggerEventBuilder setSchedule(List<? extends AveragingSchedule> schedules) {
			if (schedules == null)  {
				this.schedule = new ArrayList<>();
			}
			else {
				this.schedule = schedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder setTrigger(Trigger trigger) {
			this.trigger = trigger==null?null:trigger.toBuilder();
			return this;
		}
		@Override
		public TriggerEvent.TriggerEventBuilder setTriggerDates(DateList triggerDates) {
			this.triggerDates = triggerDates==null?null:triggerDates.toBuilder();
			return this;
		}
		
		@Override
		public TriggerEvent build() {
			return new TriggerEvent.TriggerEventImpl(this);
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerEvent.TriggerEventBuilder prune() {
			if (featurePayment!=null && !featurePayment.prune().hasData()) featurePayment = null;
			schedule = schedule.stream().filter(b->b!=null).<AveragingSchedule.AveragingScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			if (triggerDates!=null && !triggerDates.prune().hasData()) triggerDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeaturePayment()!=null && getFeaturePayment().hasData()) return true;
			if (getSchedule()!=null && getSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			if (getTriggerDates()!=null && getTriggerDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerEvent.TriggerEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerEvent.TriggerEventBuilder o = (TriggerEvent.TriggerEventBuilder) other;
			
			merger.mergeRosetta(getFeaturePayment(), o.getFeaturePayment(), this::setFeaturePayment);
			merger.mergeRosetta(getSchedule(), o.getSchedule(), this::getOrCreateSchedule);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			merger.mergeRosetta(getTriggerDates(), o.getTriggerDates(), this::setTriggerDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerEvent _that = getType().cast(o);
		
			if (!Objects.equals(featurePayment, _that.getFeaturePayment())) return false;
			if (!ListEquals.listEquals(schedule, _that.getSchedule())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(triggerDates, _that.getTriggerDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (featurePayment != null ? featurePayment.hashCode() : 0);
			_result = 31 * _result + (schedule != null ? schedule.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (triggerDates != null ? triggerDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerEventBuilder {" +
				"featurePayment=" + this.featurePayment + ", " +
				"schedule=" + this.schedule + ", " +
				"trigger=" + this.trigger + ", " +
				"triggerDates=" + this.triggerDates +
			'}';
		}
	}
}
