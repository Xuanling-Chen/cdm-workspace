package cdm.observable.asset;

import cdm.base.math.MeasureBase;
import cdm.base.math.MeasureBase.MeasureBaseBuilder;
import cdm.base.math.MeasureBase.MeasureBaseBuilderImpl;
import cdm.base.math.MeasureBase.MeasureBaseImpl;
import cdm.base.math.UnitType;
import cdm.observable.asset.meta.PriceMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a price to be used for trade amounts and other purposes.
 * @version ${project.version}
 */
@RosettaClass

public interface Price extends MeasureBase {
	Price build();
	Price.PriceBuilder toBuilder();
	
	/**
	 * Provides an attribute to define the unit being priced.  For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
	 */
	UnitType getPerUnitOfAmount();
	/**
	 * Provides a value for a type of price in order to explain how to interpret the amount and use it in calculations.
	 */
	PriceTypeEnum getPriceType();
	final static PriceMeta metaData = new PriceMeta();
	
	@Override
	default RosettaMetaData<? extends Price> metaData() {
		return metaData;
	} 
			
	static Price.PriceBuilder builder() {
		return new Price.PriceBuilderImpl();
	}
	
	default Class<? extends Price> getType() {
		return Price.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.MeasureBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
		
		processRosetta(path.newSubPath("perUnitOfAmount"), processor, UnitType.class, getPerUnitOfAmount());
	}
	
	
	interface PriceBuilder extends Price, MeasureBase.MeasureBaseBuilder, RosettaModelObjectBuilder {
		UnitType.UnitTypeBuilder getOrCreatePerUnitOfAmount();
		UnitType.UnitTypeBuilder getPerUnitOfAmount();
		Price.PriceBuilder setPerUnitOfAmount(UnitType perUnitOfAmount);
		Price.PriceBuilder setPriceType(PriceTypeEnum priceType);
		Price.PriceBuilder setAmount(BigDecimal amount);
		Price.PriceBuilder setUnitOfAmount(UnitType unitOfAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			MeasureBase.MeasureBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
			
			processRosetta(path.newSubPath("perUnitOfAmount"), processor, UnitType.UnitTypeBuilder.class, getPerUnitOfAmount());
		}
		
	}
	
	//Price.PriceImpl
	class PriceImpl extends MeasureBase.MeasureBaseImpl implements Price {
		private final UnitType perUnitOfAmount;
		private final PriceTypeEnum priceType;
		
		protected PriceImpl(Price.PriceBuilder builder) {
			super(builder);
			this.perUnitOfAmount = ofNullable(builder.getPerUnitOfAmount()).map(f->f.build()).orElse(null);
			this.priceType = builder.getPriceType();
		}
		
		@Override
		public UnitType getPerUnitOfAmount() {
			return perUnitOfAmount;
		}
		
		@Override
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
		@Override
		public Price build() {
			return this;
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			Price.PriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Price.PriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPerUnitOfAmount()).ifPresent(builder::setPerUnitOfAmount);
			ofNullable(getPriceType()).ifPresent(builder::setPriceType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(perUnitOfAmount, _that.getPerUnitOfAmount())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (perUnitOfAmount != null ? perUnitOfAmount.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Price {" +
				"perUnitOfAmount=" + this.perUnitOfAmount + ", " +
				"priceType=" + this.priceType +
			'}' + " " + super.toString();
		}
	}
	
	//Price.PriceBuilderImpl
	class PriceBuilderImpl extends MeasureBase.MeasureBaseBuilderImpl  implements Price.PriceBuilder {
	
		protected UnitType.UnitTypeBuilder perUnitOfAmount;
		protected PriceTypeEnum priceType;
	
		public PriceBuilderImpl() {
		}
	
		@Override
		public UnitType.UnitTypeBuilder getPerUnitOfAmount() {
			return perUnitOfAmount;
		}
		
		@Override
		public UnitType.UnitTypeBuilder getOrCreatePerUnitOfAmount() {
			UnitType.UnitTypeBuilder result;
			if (perUnitOfAmount!=null) {
				result = perUnitOfAmount;
			}
			else {
				result = perUnitOfAmount = UnitType.builder();
			}
			
			return result;
		}
		
		@Override
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
	
		@Override
		public Price.PriceBuilder setPerUnitOfAmount(UnitType perUnitOfAmount) {
			this.perUnitOfAmount = perUnitOfAmount==null?null:perUnitOfAmount.toBuilder();
			return this;
		}
		@Override
		public Price.PriceBuilder setPriceType(PriceTypeEnum priceType) {
			this.priceType = priceType==null?null:priceType;
			return this;
		}
		@Override
		public Price.PriceBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public Price.PriceBuilder setUnitOfAmount(UnitType unitOfAmount) {
			this.unitOfAmount = unitOfAmount==null?null:unitOfAmount.toBuilder();
			return this;
		}
		
		@Override
		public Price build() {
			return new Price.PriceImpl(this);
		}
		
		@Override
		public Price.PriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder prune() {
			super.prune();
			if (perUnitOfAmount!=null && !perUnitOfAmount.prune().hasData()) perUnitOfAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPerUnitOfAmount()!=null && getPerUnitOfAmount().hasData()) return true;
			if (getPriceType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Price.PriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Price.PriceBuilder o = (Price.PriceBuilder) other;
			
			merger.mergeRosetta(getPerUnitOfAmount(), o.getPerUnitOfAmount(), this::setPerUnitOfAmount);
			
			merger.mergeBasic(getPriceType(), o.getPriceType(), this::setPriceType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Price _that = getType().cast(o);
		
			if (!Objects.equals(perUnitOfAmount, _that.getPerUnitOfAmount())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (perUnitOfAmount != null ? perUnitOfAmount.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceBuilder {" +
				"perUnitOfAmount=" + this.perUnitOfAmount + ", " +
				"priceType=" + this.priceType +
			'}' + " " + super.toString();
		}
	}
}
