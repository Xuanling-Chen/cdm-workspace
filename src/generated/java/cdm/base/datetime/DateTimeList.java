package cdm.base.datetime;

import cdm.base.datetime.meta.DateTimeListMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * List of dateTimes.
 * @version ${project.version}
 */
@RosettaClass

public interface DateTimeList extends RosettaModelObject {
	DateTimeList build();
	DateTimeList.DateTimeListBuilder toBuilder();
	
	/**
	 * The CDM specifies that the zoned date time is to be expressed in accordance with ISO 8601, either as UTC as an offset to UTC.
	 */
	List<? extends ZonedDateTime> getDateTime();
	final static DateTimeListMeta metaData = new DateTimeListMeta();
	
	@Override
	default RosettaMetaData<? extends DateTimeList> metaData() {
		return metaData;
	} 
			
	static DateTimeList.DateTimeListBuilder builder() {
		return new DateTimeList.DateTimeListBuilderImpl();
	}
	
	default Class<? extends DateTimeList> getType() {
		return DateTimeList.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
		
	}
	
	
	interface DateTimeListBuilder extends DateTimeList, RosettaModelObjectBuilder {
		DateTimeList.DateTimeListBuilder addDateTime(ZonedDateTime dateTime);
		DateTimeList.DateTimeListBuilder addDateTime(ZonedDateTime dateTime, int _idx);
		DateTimeList.DateTimeListBuilder addDateTime(List<? extends ZonedDateTime> dateTime);
		DateTimeList.DateTimeListBuilder setDateTime(List<? extends ZonedDateTime> dateTime);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
			
		}
		
	}
	
	//DateTimeList.DateTimeListImpl
	class DateTimeListImpl implements DateTimeList {
		private final List<? extends ZonedDateTime> dateTime;
		
		protected DateTimeListImpl(DateTimeList.DateTimeListBuilder builder) {
			this.dateTime = ofNullable(builder.getDateTime()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public List<? extends ZonedDateTime> getDateTime() {
			return dateTime;
		}
		
		@Override
		public DateTimeList build() {
			return this;
		}
		
		@Override
		public DateTimeList.DateTimeListBuilder toBuilder() {
			DateTimeList.DateTimeListBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateTimeList.DateTimeListBuilder builder) {
			ofNullable(getDateTime()).ifPresent(builder::setDateTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateTimeList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dateTime, _that.getDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateTimeList {" +
				"dateTime=" + this.dateTime +
			'}';
		}
	}
	
	//DateTimeList.DateTimeListBuilderImpl
	class DateTimeListBuilderImpl implements DateTimeList.DateTimeListBuilder {
	
		protected List<ZonedDateTime> dateTime = new ArrayList<>();
	
		public DateTimeListBuilderImpl() {
		}
	
		@Override
		public List<? extends ZonedDateTime> getDateTime() {
			return dateTime;
		}
		
	
		@Override
		public DateTimeList.DateTimeListBuilder addDateTime(ZonedDateTime dateTime) {
			if (dateTime!=null) this.dateTime.add(dateTime);
			return this;
		}
		
		@Override
		public DateTimeList.DateTimeListBuilder addDateTime(ZonedDateTime dateTime, int _idx) {
			getIndex(this.dateTime, _idx, () -> dateTime);
			return this;
		}
		@Override 
		public DateTimeList.DateTimeListBuilder addDateTime(List<? extends ZonedDateTime> dateTimes) {
			if (dateTimes != null) {
				for (ZonedDateTime toAdd : dateTimes) {
					this.dateTime.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public DateTimeList.DateTimeListBuilder setDateTime(List<? extends ZonedDateTime> dateTimes) {
			if (dateTimes == null)  {
				this.dateTime = new ArrayList<>();
			}
			else {
				this.dateTime = dateTimes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DateTimeList build() {
			return new DateTimeList.DateTimeListImpl(this);
		}
		
		@Override
		public DateTimeList.DateTimeListBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateTimeList.DateTimeListBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateTime()!=null && !getDateTime().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateTimeList.DateTimeListBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateTimeList.DateTimeListBuilder o = (DateTimeList.DateTimeListBuilder) other;
			
			
			merger.mergeBasic(getDateTime(), o.getDateTime(), (Consumer<ZonedDateTime>) this::addDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateTimeList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dateTime, _that.getDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateTimeListBuilder {" +
				"dateTime=" + this.dateTime +
			'}';
		}
	}
}
