package cdm.observable.event;

import cdm.base.staticdata.asset.common.AveragingCalculationMethodEnum;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.event.meta.DeterminationMethodologyMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface DeterminationMethodology extends RosettaModelObject {
	DeterminationMethodology build();
	DeterminationMethodology.DeterminationMethodologyBuilder toBuilder();
	
	/**
	 */
	AveragingCalculationMethodEnum getAveragingMethod();
	/**
	 * Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.
	 */
	DeterminationMethodEnum getDeterminationMethod();
	final static DeterminationMethodologyMeta metaData = new DeterminationMethodologyMeta();
	
	@Override
	default RosettaMetaData<? extends DeterminationMethodology> metaData() {
		return metaData;
	} 
			
	static DeterminationMethodology.DeterminationMethodologyBuilder builder() {
		return new DeterminationMethodology.DeterminationMethodologyBuilderImpl();
	}
	
	default Class<? extends DeterminationMethodology> getType() {
		return DeterminationMethodology.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingCalculationMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
		
	}
	
	
	interface DeterminationMethodologyBuilder extends DeterminationMethodology, RosettaModelObjectBuilder {
		DeterminationMethodology.DeterminationMethodologyBuilder setAveragingMethod(AveragingCalculationMethodEnum averagingMethod);
		DeterminationMethodology.DeterminationMethodologyBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingCalculationMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
			
		}
		
	}
	
	//DeterminationMethodology.DeterminationMethodologyImpl
	class DeterminationMethodologyImpl implements DeterminationMethodology {
		private final AveragingCalculationMethodEnum averagingMethod;
		private final DeterminationMethodEnum determinationMethod;
		
		protected DeterminationMethodologyImpl(DeterminationMethodology.DeterminationMethodologyBuilder builder) {
			this.averagingMethod = builder.getAveragingMethod();
			this.determinationMethod = builder.getDeterminationMethod();
		}
		
		@Override
		public AveragingCalculationMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethodology build() {
			return this;
		}
		
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder toBuilder() {
			DeterminationMethodology.DeterminationMethodologyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeterminationMethodology.DeterminationMethodologyBuilder builder) {
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethodology _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodology {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"determinationMethod=" + this.determinationMethod +
			'}';
		}
	}
	
	//DeterminationMethodology.DeterminationMethodologyBuilderImpl
	class DeterminationMethodologyBuilderImpl implements DeterminationMethodology.DeterminationMethodologyBuilder {
	
		protected AveragingCalculationMethodEnum averagingMethod;
		protected DeterminationMethodEnum determinationMethod;
	
		public DeterminationMethodologyBuilderImpl() {
		}
	
		@Override
		public AveragingCalculationMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
	
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder setAveragingMethod(AveragingCalculationMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod;
			return this;
		}
		
		@Override
		public DeterminationMethodology build() {
			return new DeterminationMethodology.DeterminationMethodologyImpl(this);
		}
		
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingMethod()!=null) return true;
			if (getDeterminationMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeterminationMethodology.DeterminationMethodologyBuilder o = (DeterminationMethodology.DeterminationMethodologyBuilder) other;
			
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethodology _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodologyBuilder {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"determinationMethod=" + this.determinationMethod +
			'}';
		}
	}
}
