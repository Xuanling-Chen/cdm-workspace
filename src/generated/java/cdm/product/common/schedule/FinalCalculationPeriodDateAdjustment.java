package cdm.product.common.schedule;

import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.metafields.ReferenceWithMetaAdjustableOrRelativeDates;
import cdm.base.datetime.metafields.ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder;
import cdm.product.common.schedule.meta.FinalCalculationPeriodDateAdjustmentMeta;
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
 * A data to:  define business date convention adjustment to final payment period per leg.
 * @version ${project.version}
 */
@RosettaClass

public interface FinalCalculationPeriodDateAdjustment extends RosettaModelObject {
	FinalCalculationPeriodDateAdjustment build();
	FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder();
	
	/**
	 * Override business date convention. This takes precedence over leg level information.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 * Reference to the unadjusted cancellation effective dates.
	 */
	ReferenceWithMetaAdjustableOrRelativeDates getRelevantUnderlyingDateReference();
	/**
	 * Reference to the leg, where date adjustments may apply.
	 */
	ReferenceWithMetaInterestRatePayout getSwapStreamReference();
	final static FinalCalculationPeriodDateAdjustmentMeta metaData = new FinalCalculationPeriodDateAdjustmentMeta();
	
	@Override
	default RosettaMetaData<? extends FinalCalculationPeriodDateAdjustment> metaData() {
		return metaData;
	} 
			
	static FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder() {
		return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl();
	}
	
	default Class<? extends FinalCalculationPeriodDateAdjustment> getType() {
		return FinalCalculationPeriodDateAdjustment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		
		processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, ReferenceWithMetaAdjustableOrRelativeDates.class, getRelevantUnderlyingDateReference());
		processRosetta(path.newSubPath("swapStreamReference"), processor, ReferenceWithMetaInterestRatePayout.class, getSwapStreamReference());
	}
	
	
	interface FinalCalculationPeriodDateAdjustmentBuilder extends FinalCalculationPeriodDateAdjustment, RosettaModelObjectBuilder {
		ReferenceWithMetaAdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDateReference();
		ReferenceWithMetaAdjustableOrRelativeDatesBuilder getRelevantUnderlyingDateReference();
		ReferenceWithMetaInterestRatePayoutBuilder getOrCreateSwapStreamReference();
		ReferenceWithMetaInterestRatePayoutBuilder getSwapStreamReference();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(ReferenceWithMetaAdjustableOrRelativeDates relevantUnderlyingDateReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReferenceValue(AdjustableOrRelativeDates relevantUnderlyingDateReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(ReferenceWithMetaInterestRatePayout swapStreamReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReferenceValue(InterestRatePayout swapStreamReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			
			processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, ReferenceWithMetaAdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDateReference());
			processRosetta(path.newSubPath("swapStreamReference"), processor, ReferenceWithMetaInterestRatePayoutBuilder.class, getSwapStreamReference());
		}
		
	}
	
	//FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentImpl
	class FinalCalculationPeriodDateAdjustmentImpl implements FinalCalculationPeriodDateAdjustment {
		private final BusinessDayConventionEnum businessDayConvention;
		private final ReferenceWithMetaAdjustableOrRelativeDates relevantUnderlyingDateReference;
		private final ReferenceWithMetaInterestRatePayout swapStreamReference;
		
		protected FinalCalculationPeriodDateAdjustmentImpl(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.relevantUnderlyingDateReference = ofNullable(builder.getRelevantUnderlyingDateReference()).map(f->f.build()).orElse(null);
			this.swapStreamReference = ofNullable(builder.getSwapStreamReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public ReferenceWithMetaAdjustableOrRelativeDates getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getRelevantUnderlyingDateReference()).ifPresent(builder::setRelevantUnderlyingDateReference);
			ofNullable(getSwapStreamReference()).ifPresent(builder::setSwapStreamReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustment {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference +
			'}';
		}
	}
	
	//FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl
	class FinalCalculationPeriodDateAdjustmentBuilderImpl implements FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected ReferenceWithMetaAdjustableOrRelativeDatesBuilder relevantUnderlyingDateReference;
		protected ReferenceWithMetaInterestRatePayoutBuilder swapStreamReference;
	
		public FinalCalculationPeriodDateAdjustmentBuilderImpl() {
		}
	
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public ReferenceWithMetaAdjustableOrRelativeDatesBuilder getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		public ReferenceWithMetaAdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDateReference() {
			ReferenceWithMetaAdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDateReference!=null) {
				result = relevantUnderlyingDateReference;
			}
			else {
				result = relevantUnderlyingDateReference = ReferenceWithMetaAdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayoutBuilder getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayoutBuilder getOrCreateSwapStreamReference() {
			ReferenceWithMetaInterestRatePayoutBuilder result;
			if (swapStreamReference!=null) {
				result = swapStreamReference;
			}
			else {
				result = swapStreamReference = ReferenceWithMetaInterestRatePayout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(ReferenceWithMetaAdjustableOrRelativeDates relevantUnderlyingDateReference) {
			this.relevantUnderlyingDateReference = relevantUnderlyingDateReference==null?null:relevantUnderlyingDateReference.toBuilder();
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReferenceValue(AdjustableOrRelativeDates relevantUnderlyingDateReference) {
			this.getOrCreateRelevantUnderlyingDateReference().setValue(relevantUnderlyingDateReference);
			return this;
		}
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(ReferenceWithMetaInterestRatePayout swapStreamReference) {
			this.swapStreamReference = swapStreamReference==null?null:swapStreamReference.toBuilder();
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReferenceValue(InterestRatePayout swapStreamReference) {
			this.getOrCreateSwapStreamReference().setValue(swapStreamReference);
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentImpl(this);
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder prune() {
			if (relevantUnderlyingDateReference!=null && !relevantUnderlyingDateReference.prune().hasData()) relevantUnderlyingDateReference = null;
			if (swapStreamReference!=null && !swapStreamReference.prune().hasData()) swapStreamReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessDayConvention()!=null) return true;
			if (getRelevantUnderlyingDateReference()!=null && getRelevantUnderlyingDateReference().hasData()) return true;
			if (getSwapStreamReference()!=null && getSwapStreamReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder o = (FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder) other;
			
			merger.mergeRosetta(getRelevantUnderlyingDateReference(), o.getRelevantUnderlyingDateReference(), this::setRelevantUnderlyingDateReference);
			merger.mergeRosetta(getSwapStreamReference(), o.getSwapStreamReference(), this::setSwapStreamReference);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustmentBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference +
			'}';
		}
	}
}
