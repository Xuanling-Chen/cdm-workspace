package cdm.base.math;

import cdm.base.math.meta.NonNegativeStepScheduleMeta;
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
 *  Class to specify a non-negative schedule as a schedule of steps, typically used to define a payout leg with variable quantity. This quantity cannot be negative, while direction is specified through a BuyerSeller or PayerReceiver attribute. The non-negativity is enforced by making use of the non-negative step class.
 * @version ${project.version}
 */
@RosettaClass

public interface NonNegativeStepSchedule extends RosettaModelObject {
	NonNegativeStepSchedule build();
	NonNegativeStepSchedule.NonNegativeStepScheduleBuilder toBuilder();
	
	/**
	 * The schedule of step date and non-negative value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 */
	List<? extends NonNegativeStep> getStep();
	final static NonNegativeStepScheduleMeta metaData = new NonNegativeStepScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends NonNegativeStepSchedule> metaData() {
		return metaData;
	} 
			
	static NonNegativeStepSchedule.NonNegativeStepScheduleBuilder builder() {
		return new NonNegativeStepSchedule.NonNegativeStepScheduleBuilderImpl();
	}
	
	default Class<? extends NonNegativeStepSchedule> getType() {
		return NonNegativeStepSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
	}
	
	
	interface NonNegativeStepScheduleBuilder extends NonNegativeStepSchedule, RosettaModelObjectBuilder {
		NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int _index);
		List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep();
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(NonNegativeStep step);
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(NonNegativeStep step, int _idx);
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(List<? extends NonNegativeStep> step);
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder setStep(List<? extends NonNegativeStep> step);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
		}
		
	}
	
	//NonNegativeStepSchedule.NonNegativeStepScheduleImpl
	class NonNegativeStepScheduleImpl implements NonNegativeStepSchedule {
		private final List<? extends NonNegativeStep> step;
		
		protected NonNegativeStepScheduleImpl(NonNegativeStepSchedule.NonNegativeStepScheduleBuilder builder) {
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends NonNegativeStep> getStep() {
			return step;
		}
		
		@Override
		public NonNegativeStepSchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder toBuilder() {
			NonNegativeStepSchedule.NonNegativeStepScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeStepSchedule.NonNegativeStepScheduleBuilder builder) {
			ofNullable(getStep()).ifPresent(builder::setStep);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeStepSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStepSchedule {" +
				"step=" + this.step +
			'}';
		}
	}
	
	//NonNegativeStepSchedule.NonNegativeStepScheduleBuilderImpl
	class NonNegativeStepScheduleBuilderImpl implements NonNegativeStepSchedule.NonNegativeStepScheduleBuilder {
	
		protected List<NonNegativeStep.NonNegativeStepBuilder> step = new ArrayList<>();
	
		public NonNegativeStepScheduleBuilderImpl() {
		}
	
		@Override
		public List<? extends NonNegativeStep.NonNegativeStepBuilder> getStep() {
			return step;
		}
		
		public NonNegativeStep.NonNegativeStepBuilder getOrCreateStep(int _index) {
		
			if (step==null) {
				this.step = new ArrayList<>();
			}
			NonNegativeStep.NonNegativeStepBuilder result;
			return getIndex(step, _index, () -> {
						NonNegativeStep.NonNegativeStepBuilder newStep = NonNegativeStep.builder();
						return newStep;
					});
		}
		
	
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(NonNegativeStep step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(NonNegativeStep step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder setStep(List<? extends NonNegativeStep> steps) {
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
		public NonNegativeStepSchedule build() {
			return new NonNegativeStepSchedule.NonNegativeStepScheduleImpl(this);
		}
		
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder prune() {
			step = step.stream().filter(b->b!=null).<NonNegativeStep.NonNegativeStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonNegativeStepSchedule.NonNegativeStepScheduleBuilder o = (NonNegativeStepSchedule.NonNegativeStepScheduleBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeStepSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeStepScheduleBuilder {" +
				"step=" + this.step +
			'}';
		}
	}
}
