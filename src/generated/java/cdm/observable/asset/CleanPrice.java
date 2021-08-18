package cdm.observable.asset;

import cdm.observable.asset.meta.CleanPriceMeta;
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
 *  Class to specify the clean price of a bond in a bond valuation model, with accruals presented separately, and modelled onto the cleanPrice model in BonPriceAndYield.model in FpML.
 * @version ${project.version}
 */
@RosettaClass

public interface CleanPrice extends RosettaModelObject {
	CleanPrice build();
	CleanPrice.CleanPriceBuilder toBuilder();
	
	/**
	 * The accruals as a number.
	 */
	BigDecimal getAccruals();
	/**
	 * The clean price as a number.
	 */
	BigDecimal getCleanPrice();
	/**
	 * Placeholder for a calculation of dirtyPrice based on cleanPrice and accruals.
	 */
	String getDirtyPrice();
	final static CleanPriceMeta metaData = new CleanPriceMeta();
	
	@Override
	default RosettaMetaData<? extends CleanPrice> metaData() {
		return metaData;
	} 
			
	static CleanPrice.CleanPriceBuilder builder() {
		return new CleanPrice.CleanPriceBuilderImpl();
	}
	
	default Class<? extends CleanPrice> getType() {
		return CleanPrice.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
		processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
		processor.processBasic(path.newSubPath("dirtyPrice"), String.class, getDirtyPrice(), this);
		
	}
	
	
	interface CleanPriceBuilder extends CleanPrice, RosettaModelObjectBuilder {
		CleanPrice.CleanPriceBuilder setAccruals(BigDecimal accruals);
		CleanPrice.CleanPriceBuilder setCleanPrice(BigDecimal cleanPrice);
		CleanPrice.CleanPriceBuilder setDirtyPrice(String dirtyPrice);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
			processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
			processor.processBasic(path.newSubPath("dirtyPrice"), String.class, getDirtyPrice(), this);
			
		}
		
	}
	
	//CleanPrice.CleanPriceImpl
	class CleanPriceImpl implements CleanPrice {
		private final BigDecimal accruals;
		private final BigDecimal cleanPrice;
		private final String dirtyPrice;
		
		protected CleanPriceImpl(CleanPrice.CleanPriceBuilder builder) {
			this.accruals = builder.getAccruals();
			this.cleanPrice = builder.getCleanPrice();
			this.dirtyPrice = builder.getDirtyPrice();
		}
		
		@Override
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		public String getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		public CleanPrice build() {
			return this;
		}
		
		@Override
		public CleanPrice.CleanPriceBuilder toBuilder() {
			CleanPrice.CleanPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CleanPrice.CleanPriceBuilder builder) {
			ofNullable(getAccruals()).ifPresent(builder::setAccruals);
			ofNullable(getCleanPrice()).ifPresent(builder::setCleanPrice);
			ofNullable(getDirtyPrice()).ifPresent(builder::setDirtyPrice);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CleanPrice _that = getType().cast(o);
		
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CleanPrice {" +
				"accruals=" + this.accruals + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"dirtyPrice=" + this.dirtyPrice +
			'}';
		}
	}
	
	//CleanPrice.CleanPriceBuilderImpl
	class CleanPriceBuilderImpl implements CleanPrice.CleanPriceBuilder {
	
		protected BigDecimal accruals;
		protected BigDecimal cleanPrice;
		protected String dirtyPrice;
	
		public CleanPriceBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		public String getDirtyPrice() {
			return dirtyPrice;
		}
		
	
		@Override
		public CleanPrice.CleanPriceBuilder setAccruals(BigDecimal accruals) {
			this.accruals = accruals==null?null:accruals;
			return this;
		}
		@Override
		public CleanPrice.CleanPriceBuilder setCleanPrice(BigDecimal cleanPrice) {
			this.cleanPrice = cleanPrice==null?null:cleanPrice;
			return this;
		}
		@Override
		public CleanPrice.CleanPriceBuilder setDirtyPrice(String dirtyPrice) {
			this.dirtyPrice = dirtyPrice==null?null:dirtyPrice;
			return this;
		}
		
		@Override
		public CleanPrice build() {
			return new CleanPrice.CleanPriceImpl(this);
		}
		
		@Override
		public CleanPrice.CleanPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CleanPrice.CleanPriceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccruals()!=null) return true;
			if (getCleanPrice()!=null) return true;
			if (getDirtyPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CleanPrice.CleanPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CleanPrice.CleanPriceBuilder o = (CleanPrice.CleanPriceBuilder) other;
			
			
			merger.mergeBasic(getAccruals(), o.getAccruals(), this::setAccruals);
			merger.mergeBasic(getCleanPrice(), o.getCleanPrice(), this::setCleanPrice);
			merger.mergeBasic(getDirtyPrice(), o.getDirtyPrice(), this::setDirtyPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CleanPrice _that = getType().cast(o);
		
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CleanPriceBuilder {" +
				"accruals=" + this.accruals + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"dirtyPrice=" + this.dirtyPrice +
			'}';
		}
	}
}
