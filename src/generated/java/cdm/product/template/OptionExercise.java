package cdm.product.template;

import cdm.product.template.meta.OptionExerciseMeta;
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
 *  A class to represent the applicable terms to qualify an option exercise: the option style (e.g. American style option), the exercise procedure (e.g. manual exercise) and the settlement terms (e.g. physical vs. cash).
 * @version ${project.version}
 */
@RosettaClass

public interface OptionExercise extends RosettaModelObject {
	OptionExercise build();
	OptionExercise.OptionExerciseBuilder toBuilder();
	
	/**
	 * The set of parameters defining the procedure associated with the exercise, e.g. manual exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * The option exercise can be of American style, Bermuda style or European style. The FpML implementation makes use of a substitution group.
	 */
	OptionStyle getOptionStyle();
	/**
	 * Specifies the strike of the option on credit default swap.
	 */
	OptionStrike getStrike();
	final static OptionExerciseMeta metaData = new OptionExerciseMeta();
	
	@Override
	default RosettaMetaData<? extends OptionExercise> metaData() {
		return metaData;
	} 
			
	static OptionExercise.OptionExerciseBuilder builder() {
		return new OptionExercise.OptionExerciseBuilderImpl();
	}
	
	default Class<? extends OptionExercise> getType() {
		return OptionExercise.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("optionStyle"), processor, OptionStyle.class, getOptionStyle());
		processRosetta(path.newSubPath("strike"), processor, OptionStrike.class, getStrike());
	}
	
	
	interface OptionExerciseBuilder extends OptionExercise, RosettaModelObjectBuilder {
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		OptionStyle.OptionStyleBuilder getOrCreateOptionStyle();
		OptionStyle.OptionStyleBuilder getOptionStyle();
		OptionStrike.OptionStrikeBuilder getOrCreateStrike();
		OptionStrike.OptionStrikeBuilder getStrike();
		OptionExercise.OptionExerciseBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		OptionExercise.OptionExerciseBuilder setOptionStyle(OptionStyle optionStyle);
		OptionExercise.OptionExerciseBuilder setStrike(OptionStrike strike);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("optionStyle"), processor, OptionStyle.OptionStyleBuilder.class, getOptionStyle());
			processRosetta(path.newSubPath("strike"), processor, OptionStrike.OptionStrikeBuilder.class, getStrike());
		}
		
	}
	
	//OptionExercise.OptionExerciseImpl
	class OptionExerciseImpl implements OptionExercise {
		private final ExerciseProcedure exerciseProcedure;
		private final OptionStyle optionStyle;
		private final OptionStrike strike;
		
		protected OptionExerciseImpl(OptionExercise.OptionExerciseBuilder builder) {
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.optionStyle = ofNullable(builder.getOptionStyle()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public OptionStyle getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		public OptionStrike getStrike() {
			return strike;
		}
		
		@Override
		public OptionExercise build() {
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			OptionExercise.OptionExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExercise.OptionExerciseBuilder builder) {
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getOptionStyle()).ifPresent(builder::setOptionStyle);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExercise {" +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"strike=" + this.strike +
			'}';
		}
	}
	
	//OptionExercise.OptionExerciseBuilderImpl
	class OptionExerciseBuilderImpl implements OptionExercise.OptionExerciseBuilder {
	
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected OptionStyle.OptionStyleBuilder optionStyle;
		protected OptionStrike.OptionStrikeBuilder strike;
	
		public OptionExerciseBuilderImpl() {
		}
	
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionStyle.OptionStyleBuilder getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		public OptionStyle.OptionStyleBuilder getOrCreateOptionStyle() {
			OptionStyle.OptionStyleBuilder result;
			if (optionStyle!=null) {
				result = optionStyle;
			}
			else {
				result = optionStyle = OptionStyle.builder();
			}
			
			return result;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder getOrCreateStrike() {
			OptionStrike.OptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = OptionStrike.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		public OptionExercise.OptionExerciseBuilder setOptionStyle(OptionStyle optionStyle) {
			this.optionStyle = optionStyle==null?null:optionStyle.toBuilder();
			return this;
		}
		@Override
		public OptionExercise.OptionExerciseBuilder setStrike(OptionStrike strike) {
			this.strike = strike==null?null:strike.toBuilder();
			return this;
		}
		
		@Override
		public OptionExercise build() {
			return new OptionExercise.OptionExerciseImpl(this);
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder prune() {
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (optionStyle!=null && !optionStyle.prune().hasData()) optionStyle = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getOptionStyle()!=null && getOptionStyle().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExercise.OptionExerciseBuilder o = (OptionExercise.OptionExerciseBuilder) other;
			
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getOptionStyle(), o.getOptionStyle(), this::setOptionStyle);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseBuilder {" +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"strike=" + this.strike +
			'}';
		}
	}
}
