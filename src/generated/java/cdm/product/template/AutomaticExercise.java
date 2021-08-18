package cdm.product.template;

import cdm.product.template.meta.AutomaticExerciseMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define automatic exercise of a swaption. With automatic exercise the option is deemed to have exercised if it is in the money by more than the threshold amount on the exercise date.
 * @version ${project.version}
 */
@RosettaClass

public interface AutomaticExercise extends RosettaModelObject {
	AutomaticExercise build();
	AutomaticExercise.AutomaticExerciseBuilder toBuilder();
	
	/**
	 * A threshold rate. The threshold of 0.10% would be represented as 0.001
	 */
	BigDecimal getThresholdRate();
	final static AutomaticExerciseMeta metaData = new AutomaticExerciseMeta();
	
	@Override
	default RosettaMetaData<? extends AutomaticExercise> metaData() {
		return metaData;
	} 
			
	static AutomaticExercise.AutomaticExerciseBuilder builder() {
		return new AutomaticExercise.AutomaticExerciseBuilderImpl();
	}
	
	default Class<? extends AutomaticExercise> getType() {
		return AutomaticExercise.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("thresholdRate"), BigDecimal.class, getThresholdRate(), this);
		
	}
	
	
	interface AutomaticExerciseBuilder extends AutomaticExercise, RosettaModelObjectBuilder {
		AutomaticExercise.AutomaticExerciseBuilder setThresholdRate(BigDecimal thresholdRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("thresholdRate"), BigDecimal.class, getThresholdRate(), this);
			
		}
		
	}
	
	//AutomaticExercise.AutomaticExerciseImpl
	class AutomaticExerciseImpl implements AutomaticExercise {
		private final BigDecimal thresholdRate;
		
		protected AutomaticExerciseImpl(AutomaticExercise.AutomaticExerciseBuilder builder) {
			this.thresholdRate = builder.getThresholdRate();
		}
		
		@Override
		public BigDecimal getThresholdRate() {
			return thresholdRate;
		}
		
		@Override
		public AutomaticExercise build() {
			return this;
		}
		
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder toBuilder() {
			AutomaticExercise.AutomaticExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AutomaticExercise.AutomaticExerciseBuilder builder) {
			ofNullable(getThresholdRate()).ifPresent(builder::setThresholdRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticExercise _that = getType().cast(o);
		
			if (!Objects.equals(thresholdRate, _that.getThresholdRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (thresholdRate != null ? thresholdRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticExercise {" +
				"thresholdRate=" + this.thresholdRate +
			'}';
		}
	}
	
	//AutomaticExercise.AutomaticExerciseBuilderImpl
	class AutomaticExerciseBuilderImpl implements AutomaticExercise.AutomaticExerciseBuilder {
	
		protected BigDecimal thresholdRate;
	
		public AutomaticExerciseBuilderImpl() {
		}
	
		@Override
		public BigDecimal getThresholdRate() {
			return thresholdRate;
		}
		
	
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder setThresholdRate(BigDecimal thresholdRate) {
			this.thresholdRate = thresholdRate==null?null:thresholdRate;
			return this;
		}
		
		@Override
		public AutomaticExercise build() {
			return new AutomaticExercise.AutomaticExerciseImpl(this);
		}
		
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getThresholdRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AutomaticExercise.AutomaticExerciseBuilder o = (AutomaticExercise.AutomaticExerciseBuilder) other;
			
			
			merger.mergeBasic(getThresholdRate(), o.getThresholdRate(), this::setThresholdRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticExercise _that = getType().cast(o);
		
			if (!Objects.equals(thresholdRate, _that.getThresholdRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (thresholdRate != null ? thresholdRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticExerciseBuilder {" +
				"thresholdRate=" + this.thresholdRate +
			'}';
		}
	}
}
