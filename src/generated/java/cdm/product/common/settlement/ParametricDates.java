package cdm.product.common.settlement;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.DayOfWeekEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.product.asset.DayDistributionEnum;
import cdm.product.common.settlement.meta.ParametricDatesMeta;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines rules for the dates on which the price will be determined.
 * @version ${project.version}
 */
@RosettaClass

public interface ParametricDates extends RosettaModelObject {
	ParametricDates build();
	ParametricDates.ParametricDatesBuilder toBuilder();
	
	/**
	 * The enumerated values to specify the business centers.
	 */
	BusinessCenterEnum getBusinessCalendar();
	/**
	 * Denotes the method by which the pricing days are distributed across the pricing period.
	 */
	DayDistributionEnum getDayDistribution();
	/**
	 * Defines the occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
	 */
	BigDecimal getDayFrequency();
	/**
	 * Indicates the days of the week on which the price will be determined.
	 */
	List<? extends DayOfWeekEnum> getDayOfWeek();
	/**
	 * Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
	 */
	DayTypeEnum getDayType();
	/**
	 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 */
	Lag getLag();
	final static ParametricDatesMeta metaData = new ParametricDatesMeta();
	
	@Override
	default RosettaMetaData<? extends ParametricDates> metaData() {
		return metaData;
	} 
			
	static ParametricDates.ParametricDatesBuilder builder() {
		return new ParametricDates.ParametricDatesBuilderImpl();
	}
	
	default Class<? extends ParametricDates> getType() {
		return ParametricDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessCalendar"), BusinessCenterEnum.class, getBusinessCalendar(), this);
		processor.processBasic(path.newSubPath("dayDistribution"), DayDistributionEnum.class, getDayDistribution(), this);
		processor.processBasic(path.newSubPath("dayFrequency"), BigDecimal.class, getDayFrequency(), this);
		processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
	}
	
	
	interface ParametricDatesBuilder extends ParametricDates, RosettaModelObjectBuilder {
		Lag.LagBuilder getOrCreateLag();
		Lag.LagBuilder getLag();
		ParametricDates.ParametricDatesBuilder setBusinessCalendar(BusinessCenterEnum businessCalendar);
		ParametricDates.ParametricDatesBuilder setDayDistribution(DayDistributionEnum dayDistribution);
		ParametricDates.ParametricDatesBuilder setDayFrequency(BigDecimal dayFrequency);
		ParametricDates.ParametricDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek);
		ParametricDates.ParametricDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek, int _idx);
		ParametricDates.ParametricDatesBuilder addDayOfWeek(List<? extends DayOfWeekEnum> dayOfWeek);
		ParametricDates.ParametricDatesBuilder setDayOfWeek(List<? extends DayOfWeekEnum> dayOfWeek);
		ParametricDates.ParametricDatesBuilder setDayType(DayTypeEnum dayType);
		ParametricDates.ParametricDatesBuilder setLag(Lag lag);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("businessCalendar"), BusinessCenterEnum.class, getBusinessCalendar(), this);
			processor.processBasic(path.newSubPath("dayDistribution"), DayDistributionEnum.class, getDayDistribution(), this);
			processor.processBasic(path.newSubPath("dayFrequency"), BigDecimal.class, getDayFrequency(), this);
			processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
		}
		
	}
	
	//ParametricDates.ParametricDatesImpl
	class ParametricDatesImpl implements ParametricDates {
		private final BusinessCenterEnum businessCalendar;
		private final DayDistributionEnum dayDistribution;
		private final BigDecimal dayFrequency;
		private final List<? extends DayOfWeekEnum> dayOfWeek;
		private final DayTypeEnum dayType;
		private final Lag lag;
		
		protected ParametricDatesImpl(ParametricDates.ParametricDatesBuilder builder) {
			this.businessCalendar = builder.getBusinessCalendar();
			this.dayDistribution = builder.getDayDistribution();
			this.dayFrequency = builder.getDayFrequency();
			this.dayOfWeek = ofNullable(builder.getDayOfWeek()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dayType = builder.getDayType();
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessCenterEnum getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		public DayDistributionEnum getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		public BigDecimal getDayFrequency() {
			return dayFrequency;
		}
		
		@Override
		public List<? extends DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		public Lag getLag() {
			return lag;
		}
		
		@Override
		public ParametricDates build() {
			return this;
		}
		
		@Override
		public ParametricDates.ParametricDatesBuilder toBuilder() {
			ParametricDates.ParametricDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricDates.ParametricDatesBuilder builder) {
			ofNullable(getBusinessCalendar()).ifPresent(builder::setBusinessCalendar);
			ofNullable(getDayDistribution()).ifPresent(builder::setDayDistribution);
			ofNullable(getDayFrequency()).ifPresent(builder::setDayFrequency);
			ofNullable(getDayOfWeek()).ifPresent(builder::setDayOfWeek);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getLag()).ifPresent(builder::setLag);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricDates _that = getType().cast(o);
		
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayFrequency, _that.getDayFrequency())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayFrequency != null ? dayFrequency.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricDates {" +
				"businessCalendar=" + this.businessCalendar + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayFrequency=" + this.dayFrequency + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayType=" + this.dayType + ", " +
				"lag=" + this.lag +
			'}';
		}
	}
	
	//ParametricDates.ParametricDatesBuilderImpl
	class ParametricDatesBuilderImpl implements ParametricDates.ParametricDatesBuilder {
	
		protected BusinessCenterEnum businessCalendar;
		protected DayDistributionEnum dayDistribution;
		protected BigDecimal dayFrequency;
		protected List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();
		protected DayTypeEnum dayType;
		protected Lag.LagBuilder lag;
	
		public ParametricDatesBuilderImpl() {
		}
	
		@Override
		public BusinessCenterEnum getBusinessCalendar() {
			return businessCalendar;
		}
		
		@Override
		public DayDistributionEnum getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		public BigDecimal getDayFrequency() {
			return dayFrequency;
		}
		
		@Override
		public List<? extends DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		public Lag.LagBuilder getLag() {
			return lag;
		}
		
		@Override
		public Lag.LagBuilder getOrCreateLag() {
			Lag.LagBuilder result;
			if (lag!=null) {
				result = lag;
			}
			else {
				result = lag = Lag.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ParametricDates.ParametricDatesBuilder setBusinessCalendar(BusinessCenterEnum businessCalendar) {
			this.businessCalendar = businessCalendar==null?null:businessCalendar;
			return this;
		}
		@Override
		public ParametricDates.ParametricDatesBuilder setDayDistribution(DayDistributionEnum dayDistribution) {
			this.dayDistribution = dayDistribution==null?null:dayDistribution;
			return this;
		}
		@Override
		public ParametricDates.ParametricDatesBuilder setDayFrequency(BigDecimal dayFrequency) {
			this.dayFrequency = dayFrequency==null?null:dayFrequency;
			return this;
		}
		@Override
		public ParametricDates.ParametricDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek) {
			if (dayOfWeek!=null) this.dayOfWeek.add(dayOfWeek);
			return this;
		}
		
		@Override
		public ParametricDates.ParametricDatesBuilder addDayOfWeek(DayOfWeekEnum dayOfWeek, int _idx) {
			getIndex(this.dayOfWeek, _idx, () -> dayOfWeek);
			return this;
		}
		@Override 
		public ParametricDates.ParametricDatesBuilder addDayOfWeek(List<? extends DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks != null) {
				for (DayOfWeekEnum toAdd : dayOfWeeks) {
					this.dayOfWeek.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public ParametricDates.ParametricDatesBuilder setDayOfWeek(List<? extends DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks == null)  {
				this.dayOfWeek = new ArrayList<>();
			}
			else {
				this.dayOfWeek = dayOfWeeks.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ParametricDates.ParametricDatesBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		public ParametricDates.ParametricDatesBuilder setLag(Lag lag) {
			this.lag = lag==null?null:lag.toBuilder();
			return this;
		}
		
		@Override
		public ParametricDates build() {
			return new ParametricDates.ParametricDatesImpl(this);
		}
		
		@Override
		public ParametricDates.ParametricDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricDates.ParametricDatesBuilder prune() {
			if (lag!=null && !lag.prune().hasData()) lag = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCalendar()!=null) return true;
			if (getDayDistribution()!=null) return true;
			if (getDayFrequency()!=null) return true;
			if (getDayOfWeek()!=null && !getDayOfWeek().isEmpty()) return true;
			if (getDayType()!=null) return true;
			if (getLag()!=null && getLag().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricDates.ParametricDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricDates.ParametricDatesBuilder o = (ParametricDates.ParametricDatesBuilder) other;
			
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			
			merger.mergeBasic(getBusinessCalendar(), o.getBusinessCalendar(), this::setBusinessCalendar);
			merger.mergeBasic(getDayDistribution(), o.getDayDistribution(), this::setDayDistribution);
			merger.mergeBasic(getDayFrequency(), o.getDayFrequency(), this::setDayFrequency);
			merger.mergeBasic(getDayOfWeek(), o.getDayOfWeek(), (Consumer<DayOfWeekEnum>) this::addDayOfWeek);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricDates _that = getType().cast(o);
		
			if (!Objects.equals(businessCalendar, _that.getBusinessCalendar())) return false;
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayFrequency, _that.getDayFrequency())) return false;
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(lag, _that.getLag())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCalendar != null ? businessCalendar.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dayFrequency != null ? dayFrequency.hashCode() : 0);
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricDatesBuilder {" +
				"businessCalendar=" + this.businessCalendar + ", " +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayFrequency=" + this.dayFrequency + ", " +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayType=" + this.dayType + ", " +
				"lag=" + this.lag +
			'}';
		}
	}
}
