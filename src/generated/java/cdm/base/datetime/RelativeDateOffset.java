package cdm.base.datetime;

import cdm.base.datetime.Offset.OffsetBuilder;
import cdm.base.datetime.Offset.OffsetBuilderImpl;
import cdm.base.datetime.Offset.OffsetImpl;
import cdm.base.datetime.meta.RelativeDateOffsetMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date). If the anchor date is itself an adjustable date then the offset is assumed to be calculated from the adjusted anchor date. A number of different scenarios can be supported, namely; 1) the derived date may simply be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date; 2) the unadjusted derived date may be a number of calendar periods (days, weeks, months or years) preceding or following the anchor date with the resulting unadjusted derived date subject to adjustment in accordance with a specified business day convention, i.e. the derived date must fall on a good business day; 3) the derived date may be a number of business days preceding or following the anchor date. Note that the businessDayConvention specifies any required adjustment to the unadjusted derived date. A negative or positive value in the periodMultiplier indicates whether the unadjusted derived precedes or follows the anchor date. The businessDayConvention should contain a value NONE if the day type element contains a value of Business (since specifying a negative or positive business days offset would already guarantee that the derived date would fall on a good business day in the specified business centers).
 * @version ${project.version}
 */
@RosettaClass

public interface RelativeDateOffset extends Offset {
	RelativeDateOffset build();
	RelativeDateOffset.RelativeDateOffsetBuilder toBuilder();
	
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	Date getAdjustedDate();
	/**
	 */
	BusinessCenters getBusinessCenters();
	/**
	 * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 */
	ReferenceWithMetaBusinessCenters getBusinessCentersReference();
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	/**
	 * Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 */
	BasicReferenceWithMetaDate getDateRelativeTo();
	final static RelativeDateOffsetMeta metaData = new RelativeDateOffsetMeta();
	
	@Override
	default RosettaMetaData<? extends RelativeDateOffset> metaData() {
		return metaData;
	} 
			
	static RelativeDateOffset.RelativeDateOffsetBuilder builder() {
		return new RelativeDateOffset.RelativeDateOffsetBuilderImpl();
	}
	
	default Class<? extends RelativeDateOffset> getType() {
		return RelativeDateOffset.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.Offset.super.process(path, processor);
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCenters.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, BasicReferenceWithMetaDate.class, getDateRelativeTo());
	}
	
	
	interface RelativeDateOffsetBuilder extends RelativeDateOffset, Offset.OffsetBuilder, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		ReferenceWithMetaBusinessCentersBuilder getOrCreateBusinessCentersReference();
		ReferenceWithMetaBusinessCentersBuilder getBusinessCentersReference();
		BasicReferenceWithMetaDateBuilder getOrCreateDateRelativeTo();
		BasicReferenceWithMetaDateBuilder getDateRelativeTo();
		RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo);
		RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		RelativeDateOffset.RelativeDateOffsetBuilder setMeta(MetaFields meta);
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Offset.OffsetBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("businessCentersReference"), processor, ReferenceWithMetaBusinessCentersBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, BasicReferenceWithMetaDateBuilder.class, getDateRelativeTo());
		}
		
	}
	
	//RelativeDateOffset.RelativeDateOffsetImpl
	class RelativeDateOffsetImpl extends Offset.OffsetImpl implements RelativeDateOffset {
		private final Date adjustedDate;
		private final BusinessCenters businessCenters;
		private final ReferenceWithMetaBusinessCenters businessCentersReference;
		private final BusinessDayConventionEnum businessDayConvention;
		private final BasicReferenceWithMetaDate dateRelativeTo;
		
		protected RelativeDateOffsetImpl(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super(builder);
			this.adjustedDate = builder.getAdjustedDate();
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getAdjustedDate() {
			return adjustedDate;
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
		public BasicReferenceWithMetaDate getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public RelativeDateOffset build() {
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			RelativeDateOffset.RelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateOffset.RelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffset {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"dateRelativeTo=" + this.dateRelativeTo +
			'}' + " " + super.toString();
		}
	}
	
	//RelativeDateOffset.RelativeDateOffsetBuilderImpl
	class RelativeDateOffsetBuilderImpl extends Offset.OffsetBuilderImpl  implements RelativeDateOffset.RelativeDateOffsetBuilder {
	
		protected Date adjustedDate;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected ReferenceWithMetaBusinessCentersBuilder businessCentersReference;
		protected BusinessDayConventionEnum businessDayConvention;
		protected BasicReferenceWithMetaDateBuilder dateRelativeTo;
	
		public RelativeDateOffsetBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedDate() {
			return adjustedDate;
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
		public BasicReferenceWithMetaDateBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public BasicReferenceWithMetaDateBuilder getOrCreateDateRelativeTo() {
			BasicReferenceWithMetaDateBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = BasicReferenceWithMetaDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setAdjustedDate(Date adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate;
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(businessCentersReference);
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDateRelativeToValue(Date dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(dateRelativeTo);
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public RelativeDateOffset build() {
			return new RelativeDateOffset.RelativeDateOffsetImpl(this);
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder prune() {
			super.prune();
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustedDate()!=null) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			if (getDateRelativeTo()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RelativeDateOffset.RelativeDateOffsetBuilder o = (RelativeDateOffset.RelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateOffsetBuilder {" +
				"adjustedDate=" + this.adjustedDate + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"dateRelativeTo=" + this.dateRelativeTo +
			'}' + " " + super.toString();
		}
	}
}
