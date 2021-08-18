package cdm.base.datetime;

import cdm.base.datetime.DateRange.DateRangeBuilder;
import cdm.base.datetime.DateRange.DateRangeBuilderImpl;
import cdm.base.datetime.DateRange.DateRangeImpl;
import cdm.base.datetime.meta.BusinessDateRangeMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
 * @version ${project.version}
 */
@RosettaClass

public interface BusinessDateRange extends DateRange {
	BusinessDateRange build();
	BusinessDateRange.BusinessDateRangeBuilder toBuilder();
	
	/**
	 * The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
	 */
	BusinessCenters getBusinessCenters();
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	final static BusinessDateRangeMeta metaData = new BusinessDateRangeMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessDateRange> metaData() {
		return metaData;
	} 
			
	static BusinessDateRange.BusinessDateRangeBuilder builder() {
		return new BusinessDateRange.BusinessDateRangeBuilderImpl();
	}
	
	default Class<? extends BusinessDateRange> getType() {
		return BusinessDateRange.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.DateRange.super.process(path, processor);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	
	
	interface BusinessDateRangeBuilder extends BusinessDateRange, DateRange.DateRangeBuilder, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		BusinessDateRange.BusinessDateRangeBuilder setBusinessCenters(BusinessCenters businessCenters);
		BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate);
		BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			DateRange.DateRangeBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		
	}
	
	//BusinessDateRange.BusinessDateRangeImpl
	class BusinessDateRangeImpl extends DateRange.DateRangeImpl implements BusinessDateRange {
		private final BusinessCenters businessCenters;
		private final BusinessDayConventionEnum businessDayConvention;
		
		protected BusinessDateRangeImpl(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super(builder);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
		}
		
		@Override
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public BusinessDateRange build() {
			return this;
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			BusinessDateRange.BusinessDateRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDateRange.BusinessDateRangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRange {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}' + " " + super.toString();
		}
	}
	
	//BusinessDateRange.BusinessDateRangeBuilderImpl
	class BusinessDateRangeBuilderImpl extends DateRange.DateRangeBuilderImpl  implements BusinessDateRange.BusinessDateRangeBuilder {
	
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected BusinessDayConventionEnum businessDayConvention;
	
		public BusinessDateRangeBuilderImpl() {
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
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
	
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedFirstDate(Date unadjustedFirstDate) {
			this.unadjustedFirstDate = unadjustedFirstDate==null?null:unadjustedFirstDate;
			return this;
		}
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder setUnadjustedLastDate(Date unadjustedLastDate) {
			this.unadjustedLastDate = unadjustedLastDate==null?null:unadjustedLastDate;
			return this;
		}
		
		@Override
		public BusinessDateRange build() {
			return new BusinessDateRange.BusinessDateRangeImpl(this);
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder prune() {
			super.prune();
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BusinessDateRange.BusinessDateRangeBuilder o = (BusinessDateRange.BusinessDateRangeBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BusinessDateRange _that = getType().cast(o);
		
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDateRangeBuilder {" +
				"businessCenters=" + this.businessCenters + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}' + " " + super.toString();
		}
	}
}
