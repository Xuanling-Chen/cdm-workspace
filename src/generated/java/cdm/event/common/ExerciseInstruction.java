package cdm.event.common;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.base.datetime.BusinessCenterTime;
import cdm.event.common.meta.ExerciseInstructionMeta;
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
 * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseInstruction extends RosettaModelObject {
	ExerciseInstruction build();
	ExerciseInstruction.ExerciseInstructionBuilder toBuilder();
	
	/**
	 * Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
	 */
	AdjustableOrAdjustedDate getExerciseDate();
	/**
	 * Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
	 */
	BusinessCenterTime getExerciseTime();
	final static ExerciseInstructionMeta metaData = new ExerciseInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseInstruction> metaData() {
		return metaData;
	} 
			
	static ExerciseInstruction.ExerciseInstructionBuilder builder() {
		return new ExerciseInstruction.ExerciseInstructionBuilderImpl();
	}
	
	default Class<? extends ExerciseInstruction> getType() {
		return ExerciseInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("exerciseDate"), processor, AdjustableOrAdjustedDate.class, getExerciseDate());
		processRosetta(path.newSubPath("exerciseTime"), processor, BusinessCenterTime.class, getExerciseTime());
	}
	
	
	interface ExerciseInstructionBuilder extends ExerciseInstruction, RosettaModelObjectBuilder {
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateExerciseDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getExerciseDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExerciseTime();
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseDate(AdjustableOrAdjustedDate exerciseDate);
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseTime(BusinessCenterTime exerciseTime);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("exerciseDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getExerciseDate());
			processRosetta(path.newSubPath("exerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExerciseTime());
		}
		
	}
	
	//ExerciseInstruction.ExerciseInstructionImpl
	class ExerciseInstructionImpl implements ExerciseInstruction {
		private final AdjustableOrAdjustedDate exerciseDate;
		private final BusinessCenterTime exerciseTime;
		
		protected ExerciseInstructionImpl(ExerciseInstruction.ExerciseInstructionBuilder builder) {
			this.exerciseDate = ofNullable(builder.getExerciseDate()).map(f->f.build()).orElse(null);
			this.exerciseTime = ofNullable(builder.getExerciseTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableOrAdjustedDate getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		public BusinessCenterTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		public ExerciseInstruction build() {
			return this;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder toBuilder() {
			ExerciseInstruction.ExerciseInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseInstruction.ExerciseInstructionBuilder builder) {
			ofNullable(getExerciseDate()).ifPresent(builder::setExerciseDate);
			ofNullable(getExerciseTime()).ifPresent(builder::setExerciseTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseInstruction {" +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime +
			'}';
		}
	}
	
	//ExerciseInstruction.ExerciseInstructionBuilderImpl
	class ExerciseInstructionBuilderImpl implements ExerciseInstruction.ExerciseInstructionBuilder {
	
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder exerciseDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder exerciseTime;
	
		public ExerciseInstructionBuilderImpl() {
		}
	
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateExerciseDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (exerciseDate!=null) {
				result = exerciseDate;
			}
			else {
				result = exerciseDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (exerciseTime!=null) {
				result = exerciseTime;
			}
			else {
				result = exerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseDate(AdjustableOrAdjustedDate exerciseDate) {
			this.exerciseDate = exerciseDate==null?null:exerciseDate.toBuilder();
			return this;
		}
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseTime(BusinessCenterTime exerciseTime) {
			this.exerciseTime = exerciseTime==null?null:exerciseTime.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseInstruction build() {
			return new ExerciseInstruction.ExerciseInstructionImpl(this);
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder prune() {
			if (exerciseDate!=null && !exerciseDate.prune().hasData()) exerciseDate = null;
			if (exerciseTime!=null && !exerciseTime.prune().hasData()) exerciseTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseDate()!=null && getExerciseDate().hasData()) return true;
			if (getExerciseTime()!=null && getExerciseTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseInstruction.ExerciseInstructionBuilder o = (ExerciseInstruction.ExerciseInstructionBuilder) other;
			
			merger.mergeRosetta(getExerciseDate(), o.getExerciseDate(), this::setExerciseDate);
			merger.mergeRosetta(getExerciseTime(), o.getExerciseTime(), this::setExerciseTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseInstructionBuilder {" +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime +
			'}';
		}
	}
}
