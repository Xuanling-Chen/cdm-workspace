package cdm.base.datetime;

import cdm.base.datetime.meta.BusinessCenterTimeMeta;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for defining a time with respect to a business day calendar location. For example, 11:00:00 GBLO.
 * @version ${project.version}
 */
@RosettaClass

public interface BusinessCenterTime extends RosettaModelObject {
	BusinessCenterTime build();
	BusinessCenterTime.BusinessCenterTimeBuilder toBuilder();
	
	/**
	 * A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.
	 */
	FieldWithMetaBusinessCenterEnum getBusinessCenter();
	/**
	 * A time specified in hh:mm:ss format where the second component must be &#39;00&#39;, e.g. 11am would be represented as 11:00:00.
	 */
	LocalTime getHourMinuteTime();
	final static BusinessCenterTimeMeta metaData = new BusinessCenterTimeMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessCenterTime> metaData() {
		return metaData;
	} 
			
	static BusinessCenterTime.BusinessCenterTimeBuilder builder() {
		return new BusinessCenterTime.BusinessCenterTimeBuilderImpl();
	}
	
	default Class<? extends BusinessCenterTime> getType() {
		return BusinessCenterTime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
		
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
	}
	
	
	interface BusinessCenterTimeBuilder extends BusinessCenterTime, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter();
		FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter();
		BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter);
		BusinessCenterTime.BusinessCenterTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("hourMinuteTime"), LocalTime.class, getHourMinuteTime(), this);
			
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
		}
		
	}
	
	//BusinessCenterTime.BusinessCenterTimeImpl
	class BusinessCenterTimeImpl implements BusinessCenterTime {
		private final FieldWithMetaBusinessCenterEnum businessCenter;
		private final LocalTime hourMinuteTime;
		
		protected BusinessCenterTimeImpl(BusinessCenterTime.BusinessCenterTimeBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.hourMinuteTime = builder.getHourMinuteTime();
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
		@Override
		public BusinessCenterTime build() {
			return this;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder toBuilder() {
			BusinessCenterTime.BusinessCenterTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenterTime.BusinessCenterTimeBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getHourMinuteTime()).ifPresent(builder::setHourMinuteTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenterTime _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterTime {" +
				"businessCenter=" + this.businessCenter + ", " +
				"hourMinuteTime=" + this.hourMinuteTime +
			'}';
		}
	}
	
	//BusinessCenterTime.BusinessCenterTimeBuilderImpl
	class BusinessCenterTimeBuilderImpl implements BusinessCenterTime.BusinessCenterTimeBuilder {
	
		protected FieldWithMetaBusinessCenterEnumBuilder businessCenter;
		protected LocalTime hourMinuteTime;
	
		public BusinessCenterTimeBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter() {
			FieldWithMetaBusinessCenterEnumBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = FieldWithMetaBusinessCenterEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public LocalTime getHourMinuteTime() {
			return hourMinuteTime;
		}
		
	
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter) {
			this.getOrCreateBusinessCenter().setValue(businessCenter);
			return this;
		}
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder setHourMinuteTime(LocalTime hourMinuteTime) {
			this.hourMinuteTime = hourMinuteTime==null?null:hourMinuteTime;
			return this;
		}
		
		@Override
		public BusinessCenterTime build() {
			return new BusinessCenterTime.BusinessCenterTimeImpl(this);
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null) return true;
			if (getHourMinuteTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenterTime.BusinessCenterTimeBuilder o = (BusinessCenterTime.BusinessCenterTimeBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			merger.mergeBasic(getHourMinuteTime(), o.getHourMinuteTime(), this::setHourMinuteTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenterTime _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(hourMinuteTime, _that.getHourMinuteTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (hourMinuteTime != null ? hourMinuteTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterTimeBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"hourMinuteTime=" + this.hourMinuteTime +
			'}';
		}
	}
}
