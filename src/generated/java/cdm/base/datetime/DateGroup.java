package cdm.base.datetime;

import cdm.base.datetime.meta.DateGroupMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface DateGroup extends RosettaModelObject {
	DateGroup build();
	DateGroup.DateGroupBuilder toBuilder();
	
	/**
	 */
	List<? extends Date> getDates();
	final static DateGroupMeta metaData = new DateGroupMeta();
	
	@Override
	default RosettaMetaData<? extends DateGroup> metaData() {
		return metaData;
	} 
			
	static DateGroup.DateGroupBuilder builder() {
		return new DateGroup.DateGroupBuilderImpl();
	}
	
	default Class<? extends DateGroup> getType() {
		return DateGroup.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dates"), Date.class, getDates(), this);
		
	}
	
	
	interface DateGroupBuilder extends DateGroup, RosettaModelObjectBuilder {
		DateGroup.DateGroupBuilder addDates(Date dates);
		DateGroup.DateGroupBuilder addDates(Date dates, int _idx);
		DateGroup.DateGroupBuilder addDates(List<? extends Date> dates);
		DateGroup.DateGroupBuilder setDates(List<? extends Date> dates);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dates"), Date.class, getDates(), this);
			
		}
		
	}
	
	//DateGroup.DateGroupImpl
	class DateGroupImpl implements DateGroup {
		private final List<? extends Date> dates;
		
		protected DateGroupImpl(DateGroup.DateGroupBuilder builder) {
			this.dates = ofNullable(builder.getDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public List<? extends Date> getDates() {
			return dates;
		}
		
		@Override
		public DateGroup build() {
			return this;
		}
		
		@Override
		public DateGroup.DateGroupBuilder toBuilder() {
			DateGroup.DateGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateGroup.DateGroupBuilder builder) {
			ofNullable(getDates()).ifPresent(builder::setDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateGroup _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dates, _that.getDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateGroup {" +
				"dates=" + this.dates +
			'}';
		}
	}
	
	//DateGroup.DateGroupBuilderImpl
	class DateGroupBuilderImpl implements DateGroup.DateGroupBuilder {
	
		protected List<Date> dates = new ArrayList<>();
	
		public DateGroupBuilderImpl() {
		}
	
		@Override
		public List<? extends Date> getDates() {
			return dates;
		}
		
	
		@Override
		public DateGroup.DateGroupBuilder addDates(Date dates) {
			if (dates!=null) this.dates.add(dates);
			return this;
		}
		
		@Override
		public DateGroup.DateGroupBuilder addDates(Date dates, int _idx) {
			getIndex(this.dates, _idx, () -> dates);
			return this;
		}
		@Override 
		public DateGroup.DateGroupBuilder addDates(List<? extends Date> datess) {
			if (datess != null) {
				for (Date toAdd : datess) {
					this.dates.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public DateGroup.DateGroupBuilder setDates(List<? extends Date> datess) {
			if (datess == null)  {
				this.dates = new ArrayList<>();
			}
			else {
				this.dates = datess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DateGroup build() {
			return new DateGroup.DateGroupImpl(this);
		}
		
		@Override
		public DateGroup.DateGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateGroup.DateGroupBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDates()!=null && !getDates().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateGroup.DateGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateGroup.DateGroupBuilder o = (DateGroup.DateGroupBuilder) other;
			
			
			merger.mergeBasic(getDates(), o.getDates(), (Consumer<Date>) this::addDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateGroup _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dates, _that.getDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateGroupBuilder {" +
				"dates=" + this.dates +
			'}';
		}
	}
}
