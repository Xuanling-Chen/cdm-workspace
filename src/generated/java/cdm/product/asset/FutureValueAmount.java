package cdm.product.asset;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity.ReferenceWithMetaQuantityBuilder;
import cdm.product.asset.meta.FutureValueAmountMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining a currency and a future value date.
 * @version ${project.version}
 */
@RosettaClass

public interface FutureValueAmount extends RosettaModelObject {
	FutureValueAmount build();
	FutureValueAmount.FutureValueAmountBuilder toBuilder();
	
	/**
	 * The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 * The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 */
	ReferenceWithMetaQuantity getQuantity();
	/**
	 * Adjusted value date of the future value amount.
	 */
	Date getValueDate();
	final static FutureValueAmountMeta metaData = new FutureValueAmountMeta();
	
	@Override
	default RosettaMetaData<? extends FutureValueAmount> metaData() {
		return metaData;
	} 
			
	static FutureValueAmount.FutureValueAmountBuilder builder() {
		return new FutureValueAmount.FutureValueAmountBuilderImpl();
	}
	
	default Class<? extends FutureValueAmount> getType() {
		return FutureValueAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaQuantity.class, getQuantity());
	}
	
	
	interface FutureValueAmountBuilder extends FutureValueAmount, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		ReferenceWithMetaQuantityBuilder getOrCreateQuantity();
		ReferenceWithMetaQuantityBuilder getQuantity();
		FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		FutureValueAmount.FutureValueAmountBuilder setCurrency(FieldWithMetaString currency);
		FutureValueAmount.FutureValueAmountBuilder setCurrencyValue(String currency);
		FutureValueAmount.FutureValueAmountBuilder setQuantity(ReferenceWithMetaQuantity quantity);
		FutureValueAmount.FutureValueAmountBuilder setQuantityValue(Quantity quantity);
		FutureValueAmount.FutureValueAmountBuilder setValueDate(Date valueDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processor.processBasic(path.newSubPath("valueDate"), Date.class, getValueDate(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("quantity"), processor, ReferenceWithMetaQuantityBuilder.class, getQuantity());
		}
		
	}
	
	//FutureValueAmount.FutureValueAmountImpl
	class FutureValueAmountImpl implements FutureValueAmount {
		private final Integer calculationPeriodNumberOfDays;
		private final FieldWithMetaString currency;
		private final ReferenceWithMetaQuantity quantity;
		private final Date valueDate;
		
		protected FutureValueAmountImpl(FutureValueAmount.FutureValueAmountBuilder builder) {
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.valueDate = builder.getValueDate();
		}
		
		@Override
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public ReferenceWithMetaQuantity getQuantity() {
			return quantity;
		}
		
		@Override
		public Date getValueDate() {
			return valueDate;
		}
		
		@Override
		public FutureValueAmount build() {
			return this;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			FutureValueAmount.FutureValueAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FutureValueAmount.FutureValueAmountBuilder builder) {
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmount {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"currency=" + this.currency + ", " +
				"quantity=" + this.quantity + ", " +
				"valueDate=" + this.valueDate +
			'}';
		}
	}
	
	//FutureValueAmount.FutureValueAmountBuilderImpl
	class FutureValueAmountBuilderImpl implements FutureValueAmount.FutureValueAmountBuilder {
	
		protected Integer calculationPeriodNumberOfDays;
		protected FieldWithMetaStringBuilder currency;
		protected ReferenceWithMetaQuantityBuilder quantity;
		protected Date valueDate;
	
		public FutureValueAmountBuilderImpl() {
		}
	
		@Override
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
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
		public ReferenceWithMetaQuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public ReferenceWithMetaQuantityBuilder getOrCreateQuantity() {
			ReferenceWithMetaQuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = ReferenceWithMetaQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getValueDate() {
			return valueDate;
		}
		
	
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = calculationPeriodNumberOfDays==null?null:calculationPeriodNumberOfDays;
			return this;
		}
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setQuantity(ReferenceWithMetaQuantity quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setQuantityValue(Quantity quantity) {
			this.getOrCreateQuantity().setValue(quantity);
			return this;
		}
		@Override
		public FutureValueAmount.FutureValueAmountBuilder setValueDate(Date valueDate) {
			this.valueDate = valueDate==null?null:valueDate;
			return this;
		}
		
		@Override
		public FutureValueAmount build() {
			return new FutureValueAmount.FutureValueAmountImpl(this);
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureValueAmount.FutureValueAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FutureValueAmount.FutureValueAmountBuilder o = (FutureValueAmount.FutureValueAmountBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureValueAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureValueAmountBuilder {" +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"currency=" + this.currency + ", " +
				"quantity=" + this.quantity + ", " +
				"valueDate=" + this.valueDate +
			'}';
		}
	}
}
