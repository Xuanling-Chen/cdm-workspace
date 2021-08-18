package cdm.base.staticdata.asset.common;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.WeatherUnitEnum;
import cdm.base.staticdata.asset.common.meta.CommodityReferenceFrameworkMeta;
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
 * Specifies the type of commodity.
 * @version ${project.version}
 */
@RosettaClass

public interface CommodityReferenceFramework extends RosettaModelObject {
	CommodityReferenceFramework build();
	CommodityReferenceFramework.CommodityReferenceFrameworkBuilder toBuilder();
	
	/**
	 * Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
	 */
	CapacityUnitEnum getCapacityUnit();
	/**
	 * Identifies the base type of the commodity being traded, using the names defined in the ISDA 2005 Commodity Definitions SubAnnex A where possible, e.g. AgriculturalProducts, CommodityCompositeIndices, Energy, Freight, Metals, or PaperAndPlastic. Implementors can define their own scheme with additional values.
	 */
	FieldWithMetaString getCommodityBase();
	/**
	 * Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.
	 */
	String getCommodityName();
	/**
	 * Defines the currency in which the commodity is priced.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * Identifies the sub product type of the commodity being traded, using the names defined in the ISDA 2005 Commodity Definitions SubAnnex A where possible, e.g. under Energy, the possible values are Benzene, Coal, DieselFuel, Electricity, FuelOil, GasOil, Gasoline, HeatingOil, JetFuelKerosene, Methanol, Naphtha, NaturalGas, NaturalGasLiquids, Oil, and UltraLowSulpherDiesel. Implementors can define their own scheme with additional values.
	 */
	FieldWithMetaString getSubCommodity();
	/**
	 * Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
	 */
	WeatherUnitEnum getWeatherUnit();
	final static CommodityReferenceFrameworkMeta metaData = new CommodityReferenceFrameworkMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityReferenceFramework> metaData() {
		return metaData;
	} 
			
	static CommodityReferenceFramework.CommodityReferenceFrameworkBuilder builder() {
		return new CommodityReferenceFramework.CommodityReferenceFrameworkBuilderImpl();
	}
	
	default Class<? extends CommodityReferenceFramework> getType() {
		return CommodityReferenceFramework.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("capacityUnit"), CapacityUnitEnum.class, getCapacityUnit(), this);
		processor.processBasic(path.newSubPath("commodityName"), String.class, getCommodityName(), this);
		processor.processBasic(path.newSubPath("weatherUnit"), WeatherUnitEnum.class, getWeatherUnit(), this);
		
		processRosetta(path.newSubPath("commodityBase"), processor, FieldWithMetaString.class, getCommodityBase());
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("subCommodity"), processor, FieldWithMetaString.class, getSubCommodity());
	}
	
	
	interface CommodityReferenceFrameworkBuilder extends CommodityReferenceFramework, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCommodityBase();
		FieldWithMetaStringBuilder getCommodityBase();
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		FieldWithMetaStringBuilder getOrCreateSubCommodity();
		FieldWithMetaStringBuilder getSubCommodity();
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCapacityUnit(CapacityUnitEnum capacityUnit);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityBase(FieldWithMetaString commodityBase);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityBaseValue(String commodityBase);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityName(String commodityName);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCurrency(FieldWithMetaString currency);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCurrencyValue(String currency);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setSubCommodity(FieldWithMetaString subCommodity);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setSubCommodityValue(String subCommodity);
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setWeatherUnit(WeatherUnitEnum weatherUnit);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("capacityUnit"), CapacityUnitEnum.class, getCapacityUnit(), this);
			processor.processBasic(path.newSubPath("commodityName"), String.class, getCommodityName(), this);
			processor.processBasic(path.newSubPath("weatherUnit"), WeatherUnitEnum.class, getWeatherUnit(), this);
			
			processRosetta(path.newSubPath("commodityBase"), processor, FieldWithMetaStringBuilder.class, getCommodityBase());
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("subCommodity"), processor, FieldWithMetaStringBuilder.class, getSubCommodity());
		}
		
	}
	
	//CommodityReferenceFramework.CommodityReferenceFrameworkImpl
	class CommodityReferenceFrameworkImpl implements CommodityReferenceFramework {
		private final CapacityUnitEnum capacityUnit;
		private final FieldWithMetaString commodityBase;
		private final String commodityName;
		private final FieldWithMetaString currency;
		private final FieldWithMetaString subCommodity;
		private final WeatherUnitEnum weatherUnit;
		
		protected CommodityReferenceFrameworkImpl(CommodityReferenceFramework.CommodityReferenceFrameworkBuilder builder) {
			this.capacityUnit = builder.getCapacityUnit();
			this.commodityBase = ofNullable(builder.getCommodityBase()).map(f->f.build()).orElse(null);
			this.commodityName = builder.getCommodityName();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.subCommodity = ofNullable(builder.getSubCommodity()).map(f->f.build()).orElse(null);
			this.weatherUnit = builder.getWeatherUnit();
		}
		
		@Override
		public CapacityUnitEnum getCapacityUnit() {
			return capacityUnit;
		}
		
		@Override
		public FieldWithMetaString getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		public String getCommodityName() {
			return commodityName;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaString getSubCommodity() {
			return subCommodity;
		}
		
		@Override
		public WeatherUnitEnum getWeatherUnit() {
			return weatherUnit;
		}
		
		@Override
		public CommodityReferenceFramework build() {
			return this;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder toBuilder() {
			CommodityReferenceFramework.CommodityReferenceFrameworkBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReferenceFramework.CommodityReferenceFrameworkBuilder builder) {
			ofNullable(getCapacityUnit()).ifPresent(builder::setCapacityUnit);
			ofNullable(getCommodityBase()).ifPresent(builder::setCommodityBase);
			ofNullable(getCommodityName()).ifPresent(builder::setCommodityName);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getSubCommodity()).ifPresent(builder::setSubCommodity);
			ofNullable(getWeatherUnit()).ifPresent(builder::setWeatherUnit);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReferenceFramework _that = getType().cast(o);
		
			if (!Objects.equals(capacityUnit, _that.getCapacityUnit())) return false;
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityName, _that.getCommodityName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(subCommodity, _that.getSubCommodity())) return false;
			if (!Objects.equals(weatherUnit, _that.getWeatherUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capacityUnit != null ? capacityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityName != null ? commodityName.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (subCommodity != null ? subCommodity.hashCode() : 0);
			_result = 31 * _result + (weatherUnit != null ? weatherUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReferenceFramework {" +
				"capacityUnit=" + this.capacityUnit + ", " +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityName=" + this.commodityName + ", " +
				"currency=" + this.currency + ", " +
				"subCommodity=" + this.subCommodity + ", " +
				"weatherUnit=" + this.weatherUnit +
			'}';
		}
	}
	
	//CommodityReferenceFramework.CommodityReferenceFrameworkBuilderImpl
	class CommodityReferenceFrameworkBuilderImpl implements CommodityReferenceFramework.CommodityReferenceFrameworkBuilder {
	
		protected CapacityUnitEnum capacityUnit;
		protected FieldWithMetaStringBuilder commodityBase;
		protected String commodityName;
		protected FieldWithMetaStringBuilder currency;
		protected FieldWithMetaStringBuilder subCommodity;
		protected WeatherUnitEnum weatherUnit;
	
		public CommodityReferenceFrameworkBuilderImpl() {
		}
	
		@Override
		public CapacityUnitEnum getCapacityUnit() {
			return capacityUnit;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCommodityBase() {
			FieldWithMetaStringBuilder result;
			if (commodityBase!=null) {
				result = commodityBase;
			}
			else {
				result = commodityBase = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getCommodityName() {
			return commodityName;
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
		public FieldWithMetaStringBuilder getSubCommodity() {
			return subCommodity;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSubCommodity() {
			FieldWithMetaStringBuilder result;
			if (subCommodity!=null) {
				result = subCommodity;
			}
			else {
				result = subCommodity = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public WeatherUnitEnum getWeatherUnit() {
			return weatherUnit;
		}
		
	
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCapacityUnit(CapacityUnitEnum capacityUnit) {
			this.capacityUnit = capacityUnit==null?null:capacityUnit;
			return this;
		}
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityBase(FieldWithMetaString commodityBase) {
			this.commodityBase = commodityBase==null?null:commodityBase.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityBaseValue(String commodityBase) {
			this.getOrCreateCommodityBase().setValue(commodityBase);
			return this;
		}
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCommodityName(String commodityName) {
			this.commodityName = commodityName==null?null:commodityName;
			return this;
		}
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setSubCommodity(FieldWithMetaString subCommodity) {
			this.subCommodity = subCommodity==null?null:subCommodity.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setSubCommodityValue(String subCommodity) {
			this.getOrCreateSubCommodity().setValue(subCommodity);
			return this;
		}
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder setWeatherUnit(WeatherUnitEnum weatherUnit) {
			this.weatherUnit = weatherUnit==null?null:weatherUnit;
			return this;
		}
		
		@Override
		public CommodityReferenceFramework build() {
			return new CommodityReferenceFramework.CommodityReferenceFrameworkImpl(this);
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder prune() {
			if (commodityBase!=null && !commodityBase.prune().hasData()) commodityBase = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (subCommodity!=null && !subCommodity.prune().hasData()) subCommodity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCapacityUnit()!=null) return true;
			if (getCommodityBase()!=null) return true;
			if (getCommodityName()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getSubCommodity()!=null) return true;
			if (getWeatherUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityReferenceFramework.CommodityReferenceFrameworkBuilder o = (CommodityReferenceFramework.CommodityReferenceFrameworkBuilder) other;
			
			merger.mergeRosetta(getCommodityBase(), o.getCommodityBase(), this::setCommodityBase);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getSubCommodity(), o.getSubCommodity(), this::setSubCommodity);
			
			merger.mergeBasic(getCapacityUnit(), o.getCapacityUnit(), this::setCapacityUnit);
			merger.mergeBasic(getCommodityName(), o.getCommodityName(), this::setCommodityName);
			merger.mergeBasic(getWeatherUnit(), o.getWeatherUnit(), this::setWeatherUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReferenceFramework _that = getType().cast(o);
		
			if (!Objects.equals(capacityUnit, _that.getCapacityUnit())) return false;
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityName, _that.getCommodityName())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(subCommodity, _that.getSubCommodity())) return false;
			if (!Objects.equals(weatherUnit, _that.getWeatherUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capacityUnit != null ? capacityUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityName != null ? commodityName.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (subCommodity != null ? subCommodity.hashCode() : 0);
			_result = 31 * _result + (weatherUnit != null ? weatherUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReferenceFrameworkBuilder {" +
				"capacityUnit=" + this.capacityUnit + ", " +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityName=" + this.commodityName + ", " +
				"currency=" + this.currency + ", " +
				"subCommodity=" + this.subCommodity + ", " +
				"weatherUnit=" + this.weatherUnit +
			'}';
		}
	}
}
