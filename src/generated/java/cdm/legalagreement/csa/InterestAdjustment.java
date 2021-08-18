package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.InterestAdjustmentMeta;
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
 * A class to specify whether the Interest Adjustment is applicable and what its periodicity is. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
@RosettaClass

public interface InterestAdjustment extends RosettaModelObject {
	InterestAdjustment build();
	InterestAdjustment.InterestAdjustmentBuilder toBuilder();
	
	/**
	 * The Interest Adjustment is applicable when True and not applicable when False
	 */
	Boolean getIsApplicable();
	/**
	 * The qualification of the Interest Adjustment periodicity.
	 */
	InterestAdjustmentPeriodicity getPeriodicity();
	final static InterestAdjustmentMeta metaData = new InterestAdjustmentMeta();
	
	@Override
	default RosettaMetaData<? extends InterestAdjustment> metaData() {
		return metaData;
	} 
			
	static InterestAdjustment.InterestAdjustmentBuilder builder() {
		return new InterestAdjustment.InterestAdjustmentBuilderImpl();
	}
	
	default Class<? extends InterestAdjustment> getType() {
		return InterestAdjustment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("periodicity"), processor, InterestAdjustmentPeriodicity.class, getPeriodicity());
	}
	
	
	interface InterestAdjustmentBuilder extends InterestAdjustment, RosettaModelObjectBuilder {
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getOrCreatePeriodicity();
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getPeriodicity();
		InterestAdjustment.InterestAdjustmentBuilder setIsApplicable(Boolean isApplicable);
		InterestAdjustment.InterestAdjustmentBuilder setPeriodicity(InterestAdjustmentPeriodicity periodicity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("periodicity"), processor, InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder.class, getPeriodicity());
		}
		
	}
	
	//InterestAdjustment.InterestAdjustmentImpl
	class InterestAdjustmentImpl implements InterestAdjustment {
		private final Boolean isApplicable;
		private final InterestAdjustmentPeriodicity periodicity;
		
		protected InterestAdjustmentImpl(InterestAdjustment.InterestAdjustmentBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.periodicity = ofNullable(builder.getPeriodicity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public InterestAdjustmentPeriodicity getPeriodicity() {
			return periodicity;
		}
		
		@Override
		public InterestAdjustment build() {
			return this;
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder toBuilder() {
			InterestAdjustment.InterestAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAdjustment.InterestAdjustmentBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPeriodicity()).ifPresent(builder::setPeriodicity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(periodicity, _that.getPeriodicity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (periodicity != null ? periodicity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustment {" +
				"isApplicable=" + this.isApplicable + ", " +
				"periodicity=" + this.periodicity +
			'}';
		}
	}
	
	//InterestAdjustment.InterestAdjustmentBuilderImpl
	class InterestAdjustmentBuilderImpl implements InterestAdjustment.InterestAdjustmentBuilder {
	
		protected Boolean isApplicable;
		protected InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder periodicity;
	
		public InterestAdjustmentBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getPeriodicity() {
			return periodicity;
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getOrCreatePeriodicity() {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder result;
			if (periodicity!=null) {
				result = periodicity;
			}
			else {
				result = periodicity = InterestAdjustmentPeriodicity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder setPeriodicity(InterestAdjustmentPeriodicity periodicity) {
			this.periodicity = periodicity==null?null:periodicity.toBuilder();
			return this;
		}
		
		@Override
		public InterestAdjustment build() {
			return new InterestAdjustment.InterestAdjustmentImpl(this);
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder prune() {
			if (periodicity!=null && !periodicity.prune().hasData()) periodicity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPeriodicity()!=null && getPeriodicity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAdjustment.InterestAdjustmentBuilder o = (InterestAdjustment.InterestAdjustmentBuilder) other;
			
			merger.mergeRosetta(getPeriodicity(), o.getPeriodicity(), this::setPeriodicity);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(periodicity, _that.getPeriodicity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (periodicity != null ? periodicity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"periodicity=" + this.periodicity +
			'}';
		}
	}
}
