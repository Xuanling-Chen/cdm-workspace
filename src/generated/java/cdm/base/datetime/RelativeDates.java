package cdm.base.datetime;

import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetImpl;
import cdm.base.datetime.meta.RelativeDatesMeta;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
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
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class describing a set of dates defined as relative to another set of dates.
 * @version ${project.version}
 */
@RosettaClass

public interface RelativeDates extends RelativeDateOffset {
	RelativeDates build();
	RelativeDates.RelativeDatesBuilder toBuilder();
	
	/**
	 * The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
	 */
	Integer getPeriodSkip();
	/**
	 * The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
	 */
	DateRange getScheduleBounds();
	final static RelativeDatesMeta metaData = new RelativeDatesMeta();
	
	@Override
	default RosettaMetaData<? extends RelativeDates> metaData() {
		return metaData;
	} 
			
	static RelativeDates.RelativeDatesBuilder builder() {
		return new RelativeDates.RelativeDatesBuilderImpl();
	}
	
	default Class<? extends RelativeDates> getType() {
		return RelativeDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.RelativeDateOffset.super.process(path, processor);
		processor.processBasic(path.newSubPath("periodSkip"), Integer.class, getPeriodSkip(), this);
		
		processRosetta(path.newSubPath("scheduleBounds"), processor, DateRange.class, getScheduleBounds());
	}
	
	
	interface RelativeDatesBuilder extends RelativeDates, RelativeDateOffset.RelativeDateOffsetBuilder, RosettaModelObjectBuilder {
		DateRange.DateRangeBuilder getOrCreateScheduleBounds();
		DateRange.DateRangeBuilder getScheduleBounds();
		RelativeDates.RelativeDatesBuilder setPeriodSkip(Integer periodSkip);
		RelativeDates.RelativeDatesBuilder setScheduleBounds(DateRange scheduleBounds);
		RelativeDates.RelativeDatesBuilder setAdjustedDate(Date adjustedDate);
		RelativeDates.RelativeDatesBuilder setBusinessCenters(BusinessCenters businessCenters);
		RelativeDates.RelativeDatesBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference);
		RelativeDates.RelativeDatesBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference);
		RelativeDates.RelativeDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		RelativeDates.RelativeDatesBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo);
		RelativeDates.RelativeDatesBuilder setDateRelativeToValue(Date dateRelativeTo);
		RelativeDates.RelativeDatesBuilder setDayType(DayTypeEnum dayType);
		RelativeDates.RelativeDatesBuilder setMeta(MetaFields meta);
		RelativeDates.RelativeDatesBuilder setPeriod(PeriodEnum period);
		RelativeDates.RelativeDatesBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			RelativeDateOffset.RelativeDateOffsetBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("periodSkip"), Integer.class, getPeriodSkip(), this);
			
			processRosetta(path.newSubPath("scheduleBounds"), processor, DateRange.DateRangeBuilder.class, getScheduleBounds());
		}
		
	}
	
	//RelativeDates.RelativeDatesImpl
	class RelativeDatesImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements RelativeDates {
		private final Integer periodSkip;
		private final DateRange scheduleBounds;
		
		protected RelativeDatesImpl(RelativeDates.RelativeDatesBuilder builder) {
			super(builder);
			this.periodSkip = builder.getPeriodSkip();
			this.scheduleBounds = ofNullable(builder.getScheduleBounds()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Integer getPeriodSkip() {
			return periodSkip;
		}
		
		@Override
		public DateRange getScheduleBounds() {
			return scheduleBounds;
		}
		
		@Override
		public RelativeDates build() {
			return this;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder toBuilder() {
			RelativeDates.RelativeDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDates.RelativeDatesBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPeriodSkip()).ifPresent(builder::setPeriodSkip);
			ofNullable(getScheduleBounds()).ifPresent(builder::setScheduleBounds);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(periodSkip, _that.getPeriodSkip())) return false;
			if (!Objects.equals(scheduleBounds, _that.getScheduleBounds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodSkip != null ? periodSkip.hashCode() : 0);
			_result = 31 * _result + (scheduleBounds != null ? scheduleBounds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDates {" +
				"periodSkip=" + this.periodSkip + ", " +
				"scheduleBounds=" + this.scheduleBounds +
			'}' + " " + super.toString();
		}
	}
	
	//RelativeDates.RelativeDatesBuilderImpl
	class RelativeDatesBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl  implements RelativeDates.RelativeDatesBuilder {
	
		protected Integer periodSkip;
		protected DateRange.DateRangeBuilder scheduleBounds;
	
		public RelativeDatesBuilderImpl() {
		}
	
		@Override
		public Integer getPeriodSkip() {
			return periodSkip;
		}
		
		@Override
		public DateRange.DateRangeBuilder getScheduleBounds() {
			return scheduleBounds;
		}
		
		@Override
		public DateRange.DateRangeBuilder getOrCreateScheduleBounds() {
			DateRange.DateRangeBuilder result;
			if (scheduleBounds!=null) {
				result = scheduleBounds;
			}
			else {
				result = scheduleBounds = DateRange.builder();
			}
			
			return result;
		}
		
	
		@Override
		public RelativeDates.RelativeDatesBuilder setPeriodSkip(Integer periodSkip) {
			this.periodSkip = periodSkip==null?null:periodSkip;
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setScheduleBounds(DateRange scheduleBounds) {
			this.scheduleBounds = scheduleBounds==null?null:scheduleBounds.toBuilder();
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setAdjustedDate(Date adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate;
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setBusinessCentersReference(ReferenceWithMetaBusinessCenters businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder setBusinessCentersReferenceValue(BusinessCenters businessCentersReference) {
			this.getOrCreateBusinessCentersReference().setValue(businessCentersReference);
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setDateRelativeTo(BasicReferenceWithMetaDate dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder setDateRelativeToValue(Date dateRelativeTo) {
			this.getOrCreateDateRelativeTo().setValue(dateRelativeTo);
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public RelativeDates.RelativeDatesBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public RelativeDates build() {
			return new RelativeDates.RelativeDatesImpl(this);
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDates.RelativeDatesBuilder prune() {
			super.prune();
			if (scheduleBounds!=null && !scheduleBounds.prune().hasData()) scheduleBounds = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPeriodSkip()!=null) return true;
			if (getScheduleBounds()!=null && getScheduleBounds().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDates.RelativeDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RelativeDates.RelativeDatesBuilder o = (RelativeDates.RelativeDatesBuilder) other;
			
			merger.mergeRosetta(getScheduleBounds(), o.getScheduleBounds(), this::setScheduleBounds);
			
			merger.mergeBasic(getPeriodSkip(), o.getPeriodSkip(), this::setPeriodSkip);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelativeDates _that = getType().cast(o);
		
			if (!Objects.equals(periodSkip, _that.getPeriodSkip())) return false;
			if (!Objects.equals(scheduleBounds, _that.getScheduleBounds())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (periodSkip != null ? periodSkip.hashCode() : 0);
			_result = 31 * _result + (scheduleBounds != null ? scheduleBounds.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDatesBuilder {" +
				"periodSkip=" + this.periodSkip + ", " +
				"scheduleBounds=" + this.scheduleBounds +
			'}' + " " + super.toString();
		}
	}
}
