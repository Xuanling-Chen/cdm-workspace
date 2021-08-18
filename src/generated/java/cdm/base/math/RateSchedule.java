package cdm.base.math;

import cdm.base.math.meta.RateScheduleMeta;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilder;
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
 * A class defining a schedule of rates or amounts in terms of an initial value and then a series of step date and value pairs. On each step date the rate or amount changes to the new step value. The series of step date and value pairs are optional. If not specified, this implies that the initial value remains unchanged over time.
 * @version ${project.version}
 */
@RosettaClass

public interface RateSchedule extends RosettaModelObject {
	RateSchedule build();
	RateSchedule.RateScheduleBuilder toBuilder();
	
	/**
	 * The initial rate. An initial rate of 5% would be represented as 0.05.
	 */
	ReferenceWithMetaPrice getInitialValue();
	/**
	 * The schedule of step date and value pairs. On each step date the associated step value becomes effective A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 */
	List<? extends Step> getStep();
	final static RateScheduleMeta metaData = new RateScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends RateSchedule> metaData() {
		return metaData;
	} 
			
	static RateSchedule.RateScheduleBuilder builder() {
		return new RateSchedule.RateScheduleBuilderImpl();
	}
	
	default Class<? extends RateSchedule> getType() {
		return RateSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("initialValue"), processor, ReferenceWithMetaPrice.class, getInitialValue());
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	
	
	interface RateScheduleBuilder extends RateSchedule, RosettaModelObjectBuilder {
		ReferenceWithMetaPriceBuilder getOrCreateInitialValue();
		ReferenceWithMetaPriceBuilder getInitialValue();
		Step.StepBuilder getOrCreateStep(int _index);
		List<? extends Step.StepBuilder> getStep();
		RateSchedule.RateScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue);
		RateSchedule.RateScheduleBuilder setInitialValueValue(Price initialValue);
		RateSchedule.RateScheduleBuilder addStep(Step step);
		RateSchedule.RateScheduleBuilder addStep(Step step, int _idx);
		RateSchedule.RateScheduleBuilder addStep(List<? extends Step> step);
		RateSchedule.RateScheduleBuilder setStep(List<? extends Step> step);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("initialValue"), processor, ReferenceWithMetaPriceBuilder.class, getInitialValue());
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		
	}
	
	//RateSchedule.RateScheduleImpl
	class RateScheduleImpl implements RateSchedule {
		private final ReferenceWithMetaPrice initialValue;
		private final List<? extends Step> step;
		
		protected RateScheduleImpl(RateSchedule.RateScheduleBuilder builder) {
			this.initialValue = ofNullable(builder.getInitialValue()).map(f->f.build()).orElse(null);
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaPrice getInitialValue() {
			return initialValue;
		}
		
		@Override
		public List<? extends Step> getStep() {
			return step;
		}
		
		@Override
		public RateSchedule build() {
			return this;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder toBuilder() {
			RateSchedule.RateScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateSchedule.RateScheduleBuilder builder) {
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getStep()).ifPresent(builder::setStep);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSchedule _that = getType().cast(o);
		
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateSchedule {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}
	
	//RateSchedule.RateScheduleBuilderImpl
	class RateScheduleBuilderImpl implements RateSchedule.RateScheduleBuilder {
	
		protected ReferenceWithMetaPriceBuilder initialValue;
		protected List<Step.StepBuilder> step = new ArrayList<>();
	
		public RateScheduleBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPriceBuilder getInitialValue() {
			return initialValue;
		}
		
		@Override
		public ReferenceWithMetaPriceBuilder getOrCreateInitialValue() {
			ReferenceWithMetaPriceBuilder result;
			if (initialValue!=null) {
				result = initialValue;
			}
			else {
				result = initialValue = ReferenceWithMetaPrice.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Step.StepBuilder> getStep() {
			return step;
		}
		
		public Step.StepBuilder getOrCreateStep(int _index) {
		
			if (step==null) {
				this.step = new ArrayList<>();
			}
			Step.StepBuilder result;
			return getIndex(step, _index, () -> {
						Step.StepBuilder newStep = Step.builder();
						return newStep;
					});
		}
		
	
		@Override
		public RateSchedule.RateScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue) {
			this.initialValue = initialValue==null?null:initialValue.toBuilder();
			return this;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder setInitialValueValue(Price initialValue) {
			this.getOrCreateInitialValue().setValue(initialValue);
			return this;
		}
		@Override
		public RateSchedule.RateScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public RateSchedule.RateScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RateSchedule.RateScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public RateSchedule build() {
			return new RateSchedule.RateScheduleImpl(this);
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSchedule.RateScheduleBuilder prune() {
			if (initialValue!=null && !initialValue.prune().hasData()) initialValue = null;
			step = step.stream().filter(b->b!=null).<Step.StepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialValue()!=null && getInitialValue().hasData()) return true;
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateSchedule.RateScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateSchedule.RateScheduleBuilder o = (RateSchedule.RateScheduleBuilder) other;
			
			merger.mergeRosetta(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateSchedule _that = getType().cast(o);
		
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateScheduleBuilder {" +
				"initialValue=" + this.initialValue + ", " +
				"step=" + this.step +
			'}';
		}
	}
}
