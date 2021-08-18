package cdm.observable.asset;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.observable.asset.meta.EquityValuationMeta;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.common.TimeTypeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines how and when an equity option or equity swap is to be valued.
 * @version ${project.version}
 */
@RosettaClass

public interface EquityValuation extends RosettaModelObject {
	EquityValuation build();
	EquityValuation.EquityValuationBuilder toBuilder();
	
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethodEnum getDeterminationMethod();
	/**
	 * Specifies the price used for valuation.
	 */
	Price getPrice();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
	 */
	AdjustableOrRelativeDate getValuationDate();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
	 */
	AdjustableRelativeOrPeriodicDates getValuationDates();
	/**
	 * The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location – e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
	 */
	BusinessCenterTime getValuationTime();
	/**
	 * The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
	 */
	TimeTypeEnum getValuationTimeType();
	final static EquityValuationMeta metaData = new EquityValuationMeta();
	
	@Override
	default RosettaMetaData<? extends EquityValuation> metaData() {
		return metaData;
	} 
			
	static EquityValuation.EquityValuationBuilder builder() {
		return new EquityValuation.EquityValuationBuilderImpl();
	}
	
	default Class<? extends EquityValuation> getType() {
		return EquityValuation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
		processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
		
		processRosetta(path.newSubPath("price"), processor, Price.class, getPrice());
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.class, getValuationDate());
		processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getValuationDates());
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
	}
	
	
	interface EquityValuationBuilder extends EquityValuation, RosettaModelObjectBuilder {
		Price.PriceBuilder getOrCreatePrice();
		Price.PriceBuilder getPrice();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		EquityValuation.EquityValuationBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod);
		EquityValuation.EquityValuationBuilder setPrice(Price price);
		EquityValuation.EquityValuationBuilder setValuationDate(AdjustableOrRelativeDate valuationDate);
		EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates valuationDates);
		EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime valuationTime);
		EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum valuationTimeType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
			processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
			
			processRosetta(path.newSubPath("price"), processor, Price.PriceBuilder.class, getPrice());
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getValuationDates());
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
		}
		
	}
	
	//EquityValuation.EquityValuationImpl
	class EquityValuationImpl implements EquityValuation {
		private final DeterminationMethodEnum determinationMethod;
		private final Price price;
		private final AdjustableOrRelativeDate valuationDate;
		private final AdjustableRelativeOrPeriodicDates valuationDates;
		private final BusinessCenterTime valuationTime;
		private final TimeTypeEnum valuationTimeType;
		
		protected EquityValuationImpl(EquityValuation.EquityValuationBuilder builder) {
			this.determinationMethod = builder.getDeterminationMethod();
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
			this.valuationTimeType = builder.getValuationTimeType();
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public Price getPrice() {
			return price;
		}
		
		@Override
		public AdjustableOrRelativeDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
		@Override
		public EquityValuation build() {
			return this;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			EquityValuation.EquityValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityValuation.EquityValuationBuilder builder) {
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
			ofNullable(getValuationTimeType()).ifPresent(builder::setValuationTimeType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuation {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"price=" + this.price + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"valuationTimeType=" + this.valuationTimeType +
			'}';
		}
	}
	
	//EquityValuation.EquityValuationBuilderImpl
	class EquityValuationBuilderImpl implements EquityValuation.EquityValuationBuilder {
	
		protected DeterminationMethodEnum determinationMethod;
		protected Price.PriceBuilder price;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder valuationDate;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder valuationDates;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
		protected TimeTypeEnum valuationTimeType;
	
		public EquityValuationBuilderImpl() {
		}
	
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public Price.PriceBuilder getPrice() {
			return price;
		}
		
		@Override
		public Price.PriceBuilder getOrCreatePrice() {
			Price.PriceBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = Price.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
	
		@Override
		public EquityValuation.EquityValuationBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod;
			return this;
		}
		@Override
		public EquityValuation.EquityValuationBuilder setPrice(Price price) {
			this.price = price==null?null:price.toBuilder();
			return this;
		}
		@Override
		public EquityValuation.EquityValuationBuilder setValuationDate(AdjustableOrRelativeDate valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		@Override
		public EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates valuationDates) {
			this.valuationDates = valuationDates==null?null:valuationDates.toBuilder();
			return this;
		}
		@Override
		public EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime valuationTime) {
			this.valuationTime = valuationTime==null?null:valuationTime.toBuilder();
			return this;
		}
		@Override
		public EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum valuationTimeType) {
			this.valuationTimeType = valuationTimeType==null?null:valuationTimeType;
			return this;
		}
		
		@Override
		public EquityValuation build() {
			return new EquityValuation.EquityValuationImpl(this);
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder prune() {
			if (price!=null && !price.prune().hasData()) price = null;
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationMethod()!=null) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			if (getValuationTimeType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityValuation.EquityValuationBuilder o = (EquityValuation.EquityValuationBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			
			merger.mergeBasic(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeBasic(getValuationTimeType(), o.getValuationTimeType(), this::setValuationTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuationBuilder {" +
				"determinationMethod=" + this.determinationMethod + ", " +
				"price=" + this.price + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"valuationTimeType=" + this.valuationTimeType +
			'}';
		}
	}
}
