package cdm.base.datetime;

import cdm.base.datetime.Period.PeriodBuilder;
import cdm.base.datetime.Period.PeriodBuilderImpl;
import cdm.base.datetime.Period.PeriodImpl;
import cdm.base.datetime.meta.OffsetMeta;
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
 * A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
 * @version ${project.version}
 */
@RosettaClass

public interface Offset extends Period {
	Offset build();
	Offset.OffsetBuilder toBuilder();
	
	/**
	 * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
	 */
	DayTypeEnum getDayType();
	final static OffsetMeta metaData = new OffsetMeta();
	
	@Override
	default RosettaMetaData<? extends Offset> metaData() {
		return metaData;
	} 
			
	static Offset.OffsetBuilder builder() {
		return new Offset.OffsetBuilderImpl();
	}
	
	default Class<? extends Offset> getType() {
		return Offset.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.datetime.Period.super.process(path, processor);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		
	}
	
	
	interface OffsetBuilder extends Offset, Period.PeriodBuilder, RosettaModelObjectBuilder {
		Offset.OffsetBuilder setDayType(DayTypeEnum dayType);
		Offset.OffsetBuilder setMeta(MetaFields meta);
		Offset.OffsetBuilder setPeriod(PeriodEnum period);
		Offset.OffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			Period.PeriodBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			
		}
		
	}
	
	//Offset.OffsetImpl
	class OffsetImpl extends Period.PeriodImpl implements Offset {
		private final DayTypeEnum dayType;
		
		protected OffsetImpl(Offset.OffsetBuilder builder) {
			super(builder);
			this.dayType = builder.getDayType();
		}
		
		@Override
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		public Offset build() {
			return this;
		}
		
		@Override
		public Offset.OffsetBuilder toBuilder() {
			Offset.OffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Offset.OffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Offset _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Offset {" +
				"dayType=" + this.dayType +
			'}' + " " + super.toString();
		}
	}
	
	//Offset.OffsetBuilderImpl
	class OffsetBuilderImpl extends Period.PeriodBuilderImpl  implements Offset.OffsetBuilder {
	
		protected DayTypeEnum dayType;
	
		public OffsetBuilderImpl() {
		}
	
		@Override
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
	
		@Override
		public Offset.OffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public Offset.OffsetBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Offset.OffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		public Offset.OffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		
		@Override
		public Offset build() {
			return new Offset.OffsetImpl(this);
		}
		
		@Override
		public Offset.OffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Offset.OffsetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDayType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Offset.OffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Offset.OffsetBuilder o = (Offset.OffsetBuilder) other;
			
			
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Offset _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetBuilder {" +
				"dayType=" + this.dayType +
			'}' + " " + super.toString();
		}
	}
}
