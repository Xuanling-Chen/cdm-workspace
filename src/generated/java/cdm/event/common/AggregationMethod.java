package cdm.event.common;

import cdm.base.math.AveragingMethodEnum;
import cdm.base.staticdata.asset.common.AveragingCalculationMethodEnum;
import cdm.event.common.meta.AggregationMethodMeta;
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
 * Defines the ways in which multiple values can be aggregated into a single value.
 * @version ${project.version}
 */
@RosettaClass

public interface AggregationMethod extends RosettaModelObject {
	AggregationMethod build();
	AggregationMethod.AggregationMethodBuilder toBuilder();
	
	/**
	 * Identifies which of the Pythagorean means is being used to compute an average value.
	 */
	AveragingCalculationMethodEnum getAveragingCalculationMethod();
	/**
	 * Identifies whether the average values will be weighted.
	 */
	AveragingMethodEnum getAveragingMethod();
	final static AggregationMethodMeta metaData = new AggregationMethodMeta();
	
	@Override
	default RosettaMetaData<? extends AggregationMethod> metaData() {
		return metaData;
	} 
			
	static AggregationMethod.AggregationMethodBuilder builder() {
		return new AggregationMethod.AggregationMethodBuilderImpl();
	}
	
	default Class<? extends AggregationMethod> getType() {
		return AggregationMethod.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("averagingCalculationMethod"), AveragingCalculationMethodEnum.class, getAveragingCalculationMethod(), this);
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		
	}
	
	
	interface AggregationMethodBuilder extends AggregationMethod, RosettaModelObjectBuilder {
		AggregationMethod.AggregationMethodBuilder setAveragingCalculationMethod(AveragingCalculationMethodEnum averagingCalculationMethod);
		AggregationMethod.AggregationMethodBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("averagingCalculationMethod"), AveragingCalculationMethodEnum.class, getAveragingCalculationMethod(), this);
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			
		}
		
	}
	
	//AggregationMethod.AggregationMethodImpl
	class AggregationMethodImpl implements AggregationMethod {
		private final AveragingCalculationMethodEnum averagingCalculationMethod;
		private final AveragingMethodEnum averagingMethod;
		
		protected AggregationMethodImpl(AggregationMethod.AggregationMethodBuilder builder) {
			this.averagingCalculationMethod = builder.getAveragingCalculationMethod();
			this.averagingMethod = builder.getAveragingMethod();
		}
		
		@Override
		public AveragingCalculationMethodEnum getAveragingCalculationMethod() {
			return averagingCalculationMethod;
		}
		
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public AggregationMethod build() {
			return this;
		}
		
		@Override
		public AggregationMethod.AggregationMethodBuilder toBuilder() {
			AggregationMethod.AggregationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AggregationMethod.AggregationMethodBuilder builder) {
			ofNullable(getAveragingCalculationMethod()).ifPresent(builder::setAveragingCalculationMethod);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationMethod _that = getType().cast(o);
		
			if (!Objects.equals(averagingCalculationMethod, _that.getAveragingCalculationMethod())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingCalculationMethod != null ? averagingCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationMethod {" +
				"averagingCalculationMethod=" + this.averagingCalculationMethod + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}
	
	//AggregationMethod.AggregationMethodBuilderImpl
	class AggregationMethodBuilderImpl implements AggregationMethod.AggregationMethodBuilder {
	
		protected AveragingCalculationMethodEnum averagingCalculationMethod;
		protected AveragingMethodEnum averagingMethod;
	
		public AggregationMethodBuilderImpl() {
		}
	
		@Override
		public AveragingCalculationMethodEnum getAveragingCalculationMethod() {
			return averagingCalculationMethod;
		}
		
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
	
		@Override
		public AggregationMethod.AggregationMethodBuilder setAveragingCalculationMethod(AveragingCalculationMethodEnum averagingCalculationMethod) {
			this.averagingCalculationMethod = averagingCalculationMethod==null?null:averagingCalculationMethod;
			return this;
		}
		@Override
		public AggregationMethod.AggregationMethodBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		
		@Override
		public AggregationMethod build() {
			return new AggregationMethod.AggregationMethodImpl(this);
		}
		
		@Override
		public AggregationMethod.AggregationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationMethod.AggregationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingCalculationMethod()!=null) return true;
			if (getAveragingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationMethod.AggregationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AggregationMethod.AggregationMethodBuilder o = (AggregationMethod.AggregationMethodBuilder) other;
			
			
			merger.mergeBasic(getAveragingCalculationMethod(), o.getAveragingCalculationMethod(), this::setAveragingCalculationMethod);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationMethod _that = getType().cast(o);
		
			if (!Objects.equals(averagingCalculationMethod, _that.getAveragingCalculationMethod())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingCalculationMethod != null ? averagingCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationMethodBuilder {" +
				"averagingCalculationMethod=" + this.averagingCalculationMethod + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}
}
