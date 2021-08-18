package cdm.base.math;

import cdm.base.datetime.Frequency;
import cdm.base.math.meta.UnitTypeMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the unit to be used for price, quantity, or other purposes
 * @version ${project.version}
 */
@RosettaClass

public interface UnitType extends RosettaModelObject {
	UnitType build();
	UnitType.UnitTypeBuilder toBuilder();
	
	/**
	 * Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
	 */
	CapacityUnitEnum getCapacityUnit();
	/**
	 * Defines the currency to be used as a unit for a price, quantity, or other purpose.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.
	 */
	FinancialUnitEnum getFinancialUnit();
	/**
	 * Defines the frequency to be used as a unit for a price, quantity, or other purpose.
	 */
	Frequency getFrequency();
	/**
	 * Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
	 */
	WeatherUnitEnum getWeatherUnit();
	final static UnitTypeMeta metaData = new UnitTypeMeta();
	
	@Override
	default RosettaMetaData<? extends UnitType> metaData() {
		return metaData;
	} 
			
	static UnitType.UnitTypeBuilder builder() {
		return new UnitType.UnitTypeBuilderImpl();
	}
	
	default Class<? extends UnitType> getType() {
		return UnitType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("capacityUnit"), CapacityUnitEnum.class, getCapacityUnit(), this);
		processor.processBasic(path.newSubPath("financialUnit"), FinancialUnitEnum.class, getFinancialUnit(), this);
		processor.processBasic(path.newSubPath("weatherUnit"), WeatherUnitEnum.class, getWeatherUnit(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("frequency"), processor, Frequency.class, getFrequency());
	}
	
	
	interface UnitTypeBuilder extends UnitType, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		Frequency.FrequencyBuilder getOrCreateFrequency();
		Frequency.FrequencyBuilder getFrequency();
		UnitType.UnitTypeBuilder setCapacityUnit(CapacityUnitEnum capacityUnit);
		UnitType.UnitTypeBuilder setCurrency(FieldWithMetaString currency);
		UnitType.UnitTypeBuilder setCurrencyValue(String currency);
		UnitType.UnitTypeBuilder setFinancialUnit(FinancialUnitEnum financialUnit);
		UnitType.UnitTypeBuilder setFrequency(Frequency frequency);
		UnitType.UnitTypeBuilder setWeatherUnit(WeatherUnitEnum weatherUnit);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("capacityUnit"), CapacityUnitEnum.class, getCapacityUnit(), this);
			processor.processBasic(path.newSubPath("financialUnit"), FinancialUnitEnum.class, getFinancialUnit(), this);
			processor.processBasic(path.newSubPath("weatherUnit"), WeatherUnitEnum.class, getWeatherUnit(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("frequency"), processor, Frequency.FrequencyBuilder.class, getFrequency());
		}
		
	}
	
	//UnitType.UnitTypeImpl
	class UnitTypeImpl implements UnitType {
		private final CapacityUnitEnum capacityUnit;
		private final FieldWithMetaString currency;
		private final FinancialUnitEnum financialUnit;
		private final Frequency frequency;
		private final WeatherUnitEnum weatherUnit;
		
		protected UnitTypeImpl(UnitType.UnitTypeBuilder builder) {
			this.capacityUnit = builder.getCapacityUnit();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.financialUnit = builder.getFinancialUnit();
			this.frequency = ofNullable(builder.getFrequency()).map(f->f.build()).orElse(null);
			this.weatherUnit = builder.getWeatherUnit();
		}
		
		@Override
		public CapacityUnitEnum getCapacityUnit() {
			return capacityUnit;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public FinancialUnitEnum getFinancialUnit() {
			return financialUnit;
		}
		
		@Override
		public Frequency getFrequency() {
			return frequency;
		}
		
		@Override
		public WeatherUnitEnum getWeatherUnit() {
			return weatherUnit;
		}
		
		@Override
		public UnitType build() {
			return this;
		}
		
		@Override
		public UnitType.UnitTypeBuilder toBuilder() {
			UnitType.UnitTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitType.UnitTypeBuilder builder) {
			ofNullable(getCapacityUnit()).ifPresent(builder::setCapacityUnit);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getFinancialUnit()).ifPresent(builder::setFinancialUnit);
			ofNullable(getFrequency()).ifPresent(builder::setFrequency);
			ofNullable(getWeatherUnit()).ifPresent(builder::setWeatherUnit);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitType _that = getType().cast(o);
		
			if (!Objects.equals(capacityUnit, _that.getCapacityUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(financialUnit, _that.getFinancialUnit())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			if (!Objects.equals(weatherUnit, _that.getWeatherUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capacityUnit != null ? capacityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (financialUnit != null ? financialUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.hashCode() : 0);
			_result = 31 * _result + (weatherUnit != null ? weatherUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitType {" +
				"capacityUnit=" + this.capacityUnit + ", " +
				"currency=" + this.currency + ", " +
				"financialUnit=" + this.financialUnit + ", " +
				"frequency=" + this.frequency + ", " +
				"weatherUnit=" + this.weatherUnit +
			'}';
		}
	}
	
	//UnitType.UnitTypeBuilderImpl
	class UnitTypeBuilderImpl implements UnitType.UnitTypeBuilder {
	
		protected CapacityUnitEnum capacityUnit;
		protected FieldWithMetaStringBuilder currency;
		protected FinancialUnitEnum financialUnit;
		protected Frequency.FrequencyBuilder frequency;
		protected WeatherUnitEnum weatherUnit;
	
		public UnitTypeBuilderImpl() {
		}
	
		@Override
		public CapacityUnitEnum getCapacityUnit() {
			return capacityUnit;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FinancialUnitEnum getFinancialUnit() {
			return financialUnit;
		}
		
		@Override
		public Frequency.FrequencyBuilder getFrequency() {
			return frequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateFrequency() {
			Frequency.FrequencyBuilder result;
			if (frequency!=null) {
				result = frequency;
			}
			else {
				result = frequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		public WeatherUnitEnum getWeatherUnit() {
			return weatherUnit;
		}
		
	
		@Override
		public UnitType.UnitTypeBuilder setCapacityUnit(CapacityUnitEnum capacityUnit) {
			this.capacityUnit = capacityUnit==null?null:capacityUnit;
			return this;
		}
		@Override
		public UnitType.UnitTypeBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public UnitType.UnitTypeBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public UnitType.UnitTypeBuilder setFinancialUnit(FinancialUnitEnum financialUnit) {
			this.financialUnit = financialUnit==null?null:financialUnit;
			return this;
		}
		@Override
		public UnitType.UnitTypeBuilder setFrequency(Frequency frequency) {
			this.frequency = frequency==null?null:frequency.toBuilder();
			return this;
		}
		@Override
		public UnitType.UnitTypeBuilder setWeatherUnit(WeatherUnitEnum weatherUnit) {
			this.weatherUnit = weatherUnit==null?null:weatherUnit;
			return this;
		}
		
		@Override
		public UnitType build() {
			return new UnitType.UnitTypeImpl(this);
		}
		
		@Override
		public UnitType.UnitTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitType.UnitTypeBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (frequency!=null && !frequency.prune().hasData()) frequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCapacityUnit()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getFinancialUnit()!=null) return true;
			if (getFrequency()!=null && getFrequency().hasData()) return true;
			if (getWeatherUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitType.UnitTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnitType.UnitTypeBuilder o = (UnitType.UnitTypeBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFrequency(), o.getFrequency(), this::setFrequency);
			
			merger.mergeBasic(getCapacityUnit(), o.getCapacityUnit(), this::setCapacityUnit);
			merger.mergeBasic(getFinancialUnit(), o.getFinancialUnit(), this::setFinancialUnit);
			merger.mergeBasic(getWeatherUnit(), o.getWeatherUnit(), this::setWeatherUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitType _that = getType().cast(o);
		
			if (!Objects.equals(capacityUnit, _that.getCapacityUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(financialUnit, _that.getFinancialUnit())) return false;
			if (!Objects.equals(frequency, _that.getFrequency())) return false;
			if (!Objects.equals(weatherUnit, _that.getWeatherUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capacityUnit != null ? capacityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (financialUnit != null ? financialUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (frequency != null ? frequency.hashCode() : 0);
			_result = 31 * _result + (weatherUnit != null ? weatherUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitTypeBuilder {" +
				"capacityUnit=" + this.capacityUnit + ", " +
				"currency=" + this.currency + ", " +
				"financialUnit=" + this.financialUnit + ", " +
				"frequency=" + this.frequency + ", " +
				"weatherUnit=" + this.weatherUnit +
			'}';
		}
	}
}
