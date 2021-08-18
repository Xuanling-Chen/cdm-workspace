package cdm.base.datetime;

import cdm.base.datetime.meta.TimeZoneMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The time alongside with the timezone location information. This class makes use of the FpML TimezoneLocation construct.
 * @version ${project.version}
 */
@RosettaClass

public interface TimeZone extends RosettaModelObject {
	TimeZone build();
	TimeZone.TimeZoneBuilder toBuilder();
	
	/**
	 * FpML specifies the timezoneLocationScheme by reference to the Time Zone Database (a.k.a. tz database) maintained by IANA, the Internet Assigned Numbers Authority.
	 */
	FieldWithMetaString getLocation();
	/**
	 * The observation time.
	 */
	LocalTime getTime();
	final static TimeZoneMeta metaData = new TimeZoneMeta();
	
	@Override
	default RosettaMetaData<? extends TimeZone> metaData() {
		return metaData;
	} 
			
	static TimeZone.TimeZoneBuilder builder() {
		return new TimeZone.TimeZoneBuilderImpl();
	}
	
	default Class<? extends TimeZone> getType() {
		return TimeZone.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		
		processRosetta(path.newSubPath("location"), processor, FieldWithMetaString.class, getLocation());
	}
	
	
	interface TimeZoneBuilder extends TimeZone, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateLocation();
		FieldWithMetaStringBuilder getLocation();
		TimeZone.TimeZoneBuilder setLocation(FieldWithMetaString location);
		TimeZone.TimeZoneBuilder setLocationValue(String location);
		TimeZone.TimeZoneBuilder setTime(LocalTime time);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			
			processRosetta(path.newSubPath("location"), processor, FieldWithMetaStringBuilder.class, getLocation());
		}
		
	}
	
	//TimeZone.TimeZoneImpl
	class TimeZoneImpl implements TimeZone {
		private final FieldWithMetaString location;
		private final LocalTime time;
		
		protected TimeZoneImpl(TimeZone.TimeZoneBuilder builder) {
			this.location = ofNullable(builder.getLocation()).map(f->f.build()).orElse(null);
			this.time = builder.getTime();
		}
		
		@Override
		public FieldWithMetaString getLocation() {
			return location;
		}
		
		@Override
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		public TimeZone build() {
			return this;
		}
		
		@Override
		public TimeZone.TimeZoneBuilder toBuilder() {
			TimeZone.TimeZoneBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimeZone.TimeZoneBuilder builder) {
			ofNullable(getLocation()).ifPresent(builder::setLocation);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeZone _that = getType().cast(o);
		
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeZone {" +
				"location=" + this.location + ", " +
				"time=" + this.time +
			'}';
		}
	}
	
	//TimeZone.TimeZoneBuilderImpl
	class TimeZoneBuilderImpl implements TimeZone.TimeZoneBuilder {
	
		protected FieldWithMetaStringBuilder location;
		protected LocalTime time;
	
		public TimeZoneBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getLocation() {
			return location;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateLocation() {
			FieldWithMetaStringBuilder result;
			if (location!=null) {
				result = location;
			}
			else {
				result = location = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public LocalTime getTime() {
			return time;
		}
		
	
		@Override
		public TimeZone.TimeZoneBuilder setLocation(FieldWithMetaString location) {
			this.location = location==null?null:location.toBuilder();
			return this;
		}
		
		@Override
		public TimeZone.TimeZoneBuilder setLocationValue(String location) {
			this.getOrCreateLocation().setValue(location);
			return this;
		}
		@Override
		public TimeZone.TimeZoneBuilder setTime(LocalTime time) {
			this.time = time==null?null:time;
			return this;
		}
		
		@Override
		public TimeZone build() {
			return new TimeZone.TimeZoneImpl(this);
		}
		
		@Override
		public TimeZone.TimeZoneBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeZone.TimeZoneBuilder prune() {
			if (location!=null && !location.prune().hasData()) location = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLocation()!=null) return true;
			if (getTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeZone.TimeZoneBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimeZone.TimeZoneBuilder o = (TimeZone.TimeZoneBuilder) other;
			
			merger.mergeRosetta(getLocation(), o.getLocation(), this::setLocation);
			
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeZone _that = getType().cast(o);
		
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeZoneBuilder {" +
				"location=" + this.location + ", " +
				"time=" + this.time +
			'}';
		}
	}
}
