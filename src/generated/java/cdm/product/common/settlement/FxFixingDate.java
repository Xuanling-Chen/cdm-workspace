package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.Offset;
import cdm.base.datetime.Offset.OffsetBuilder;
import cdm.base.datetime.Offset.OffsetBuilderImpl;
import cdm.base.datetime.Offset.OffsetImpl;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates;
import cdm.product.common.schedule.DateRelativeToPaymentDates;
import cdm.product.common.settlement.meta.FxFixingDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Extends the Offset structure to specify an FX fixing date as an offset to dates specified somewhere else in the document.
 * @version ${project.version}
 */
@RosettaClass

public interface FxFixingDate extends Offset {
	FxFixingDate build();
	FxFixingDate.FxFixingDateBuilder toBuilder();
	
	/**
	 */
	BusinessCenters getBusinessCenters();
	/**
	 * A reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 */
	ReferenceWithMetaBusinessCenters getBusinessCentersReference();
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 * The calculation period references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure. Implemented for Brazilian-CDI swaps where it will refer to the termination date of the appropriate leg.
	 */
	DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates();
	/**
	 * The payment date references on which settlements in non-deliverable currency are due and will then have to be converted according to the terms specified through the other parts of the nonDeliverableSettlement structure.
	 */
	DateRelativeToPaymentDates getDateRelativeToPaymentDates();
	/**
	 * Describes the specific date when a non-deliverable forward or cash-settled option will &#39;fix&#39; against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.  This attribute was formerly part of &#39;fxSettlementTerms&#39;, which is now being harmonised into a common &#39;CashSettlementTerms&#39; that includes a &#39;ValuationDate&#39;.
	 */
	AdjustableOrRelativeDate getFxFixingDate();
	final static FxFixingDateMeta metaData = new FxFixingDateMeta();
	
	@Override
	default RosettaMetaData<? extends FxFixingDate> metaData() {
		return metaData;
	} 
			
	static FxFixingDate.FxFixingDateBuilder builder() {
		return new FxFixingDate.FxFixingDateBuilderImpl();
	}
	
	default Class<? extends FxFixingDate> getType() {
		return FxFixingDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.Offset.super.process(path, processor);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.class, getDateRelativeToCalculationPeriodDates());
		processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.class, getDateRelativeToPaymentDates());
		processRosetta(path.newSubPath("fxFixingDate"), processor, AdjustableOrRelativeDate.class, getFxFixingDate());
	}
	
	
	interface FxFixingDateBuilder extends FxFixingDate, Offset.OffsetBuilder, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference();
		ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFxFixingDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFxFixingDate();
		FxFixingDate.FxFixingDateBuilder setBusinessCenters(BusinessCenters businessCenters);
		FxFixingDate.FxFixingDateBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		FxFixingDate.FxFixingDateBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates);
		FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates dateRelativeToPaymentDates);
		FxFixingDate.FxFixingDateBuilder setFxFixingDate(AdjustableOrRelativeDate fxFixingDate);
		FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum dayType);
		FxFixingDate.FxFixingDateBuilder setMeta(MetaFields meta);
		FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum period);
		FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Offset.OffsetBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCentersBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("dateRelativeToCalculationPeriodDates"), processor, DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder.class, getDateRelativeToCalculationPeriodDates());
			processRosetta(path.newSubPath("dateRelativeToPaymentDates"), processor, DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder.class, getDateRelativeToPaymentDates());
			processRosetta(path.newSubPath("fxFixingDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getFxFixingDate());
		}
		
	}
	
	//FxFixingDate.FxFixingDateImpl
	class FxFixingDateImpl extends Offset.OffsetImpl implements FxFixingDate {
		private final BusinessCenters businessCenters;
		private final ReferenceWithMetaBusinessCenters businessCentersReference;
		private final BusinessDayConventionEnum businessDayConvention;
		private final DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates;
		private final DateRelativeToPaymentDates dateRelativeToPaymentDates;
		private final AdjustableOrRelativeDate fxFixingDate;
		
		protected FxFixingDateImpl(FxFixingDate.FxFixingDateBuilder builder) {
			super(builder);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.dateRelativeToCalculationPeriodDates = ofNullable(builder.getDateRelativeToCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.dateRelativeToPaymentDates = ofNullable(builder.getDateRelativeToPaymentDates()).map(f->f.build()).orElse(null);
			this.fxFixingDate = ofNullable(builder.getFxFixingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public DateRelativeToPaymentDates getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		public AdjustableOrRelativeDate getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public FxFixingDate build() {
			return this;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			FxFixingDate.FxFixingDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingDate.FxFixingDateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getDateRelativeToCalculationPeriodDates()).ifPresent(builder::setDateRelativeToCalculationPeriodDates);
			ofNullable(getDateRelativeToPaymentDates()).ifPresent(builder::setDateRelativeToPaymentDates);
			ofNullable(getFxFixingDate()).ifPresent(builder::setFxFixingDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDate {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"fxFixingDate=" + this.fxFixingDate +
			'}' + " " + super.toString();
		}
	}
	
	//FxFixingDate.FxFixingDateBuilderImpl
	class FxFixingDateBuilderImpl extends Offset.OffsetBuilderImpl  implements FxFixingDate.FxFixingDateBuilder {
	
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected ReferenceWithMetaBusinessCentersBuilder businessCentersReference;
		protected BusinessDayConventionEnum businessDayConvention;
		protected DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDates;
		protected DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDates;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder fxFixingDate;
	
		public FxFixingDateBuilderImpl() {
		}
	
		@Override
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference() {
			ReferenceWithMetaBusinessCentersBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = ReferenceWithMetaBusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getDateRelativeToCalculationPeriodDates() {
			return dateRelativeToCalculationPeriodDates;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder getOrCreateDateRelativeToCalculationPeriodDates() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder result;
			if (dateRelativeToCalculationPeriodDates!=null) {
				result = dateRelativeToCalculationPeriodDates;
			}
			else {
				result = dateRelativeToCalculationPeriodDates = DateRelativeToCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getDateRelativeToPaymentDates() {
			return dateRelativeToPaymentDates;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder getOrCreateDateRelativeToPaymentDates() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder result;
			if (dateRelativeToPaymentDates!=null) {
				result = dateRelativeToPaymentDates;
			}
			else {
				result = dateRelativeToPaymentDates = DateRelativeToPaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFxFixingDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (fxFixingDate!=null) {
				result = fxFixingDate;
			}
			else {
				result = fxFixingDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(businessCentersReference);
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToCalculationPeriodDates(DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates) {
			this.dateRelativeToCalculationPeriodDates = dateRelativeToCalculationPeriodDates==null?null:dateRelativeToCalculationPeriodDates.toBuilder();
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setDateRelativeToPaymentDates(DateRelativeToPaymentDates dateRelativeToPaymentDates) {
			this.dateRelativeToPaymentDates = dateRelativeToPaymentDates==null?null:dateRelativeToPaymentDates.toBuilder();
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setFxFixingDate(AdjustableOrRelativeDate fxFixingDate) {
			this.fxFixingDate = fxFixingDate==null?null:fxFixingDate.toBuilder();
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public FxFixingDate.FxFixingDateBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public FxFixingDate build() {
			return new FxFixingDate.FxFixingDateImpl(this);
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder prune() {
			super.prune();
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (dateRelativeToCalculationPeriodDates!=null && !dateRelativeToCalculationPeriodDates.prune().hasData()) dateRelativeToCalculationPeriodDates = null;
			if (dateRelativeToPaymentDates!=null && !dateRelativeToPaymentDates.prune().hasData()) dateRelativeToPaymentDates = null;
			if (fxFixingDate!=null && !fxFixingDate.prune().hasData()) fxFixingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getDateRelativeToCalculationPeriodDates()!=null && getDateRelativeToCalculationPeriodDates().hasData()) return true;
			if (getDateRelativeToPaymentDates()!=null && getDateRelativeToPaymentDates().hasData()) return true;
			if (getFxFixingDate()!=null && getFxFixingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingDate.FxFixingDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxFixingDate.FxFixingDateBuilder o = (FxFixingDate.FxFixingDateBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getDateRelativeToCalculationPeriodDates(), o.getDateRelativeToCalculationPeriodDates(), this::setDateRelativeToCalculationPeriodDates);
			merger.mergeRosetta(getDateRelativeToPaymentDates(), o.getDateRelativeToPaymentDates(), this::setDateRelativeToPaymentDates);
			merger.mergeRosetta(getFxFixingDate(), o.getFxFixingDate(), this::setFxFixingDate);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFixingDate _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(dateRelativeToCalculationPeriodDates, _that.getDateRelativeToCalculationPeriodDates())) return false;
			if (!Objects.equals(dateRelativeToPaymentDates, _that.getDateRelativeToPaymentDates())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dateRelativeToCalculationPeriodDates != null ? dateRelativeToCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (dateRelativeToPaymentDates != null ? dateRelativeToPaymentDates.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingDateBuilder {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"dateRelativeToCalculationPeriodDates=" + this.dateRelativeToCalculationPeriodDates + ", " +
				"dateRelativeToPaymentDates=" + this.dateRelativeToPaymentDates + ", " +
				"fxFixingDate=" + this.fxFixingDate +
			'}' + " " + super.toString();
		}
	}
}
