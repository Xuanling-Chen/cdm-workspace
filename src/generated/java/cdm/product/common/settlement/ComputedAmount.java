package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.ComputedAmountMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the outcome of a computed amount, for testing purposes.
 * @version ${project.version}
 */
@RosettaClass

public interface ComputedAmount extends RosettaModelObject {
	ComputedAmount build();
	ComputedAmount.ComputedAmountBuilder toBuilder();
	
	/**
	 */
	BigDecimal getAmount();
	/**
	 */
	String getCallFunction();
	/**
	 * The currency in which the computed amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	final static ComputedAmountMeta metaData = new ComputedAmountMeta();
	
	@Override
	default RosettaMetaData<? extends ComputedAmount> metaData() {
		return metaData;
	} 
			
	static ComputedAmount.ComputedAmountBuilder builder() {
		return new ComputedAmount.ComputedAmountBuilderImpl();
	}
	
	default Class<? extends ComputedAmount> getType() {
		return ComputedAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("callFunction"), String.class, getCallFunction(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	
	
	interface ComputedAmountBuilder extends ComputedAmount, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		ComputedAmount.ComputedAmountBuilder setAmount(BigDecimal amount);
		ComputedAmount.ComputedAmountBuilder setCallFunction(String callFunction);
		ComputedAmount.ComputedAmountBuilder setCurrency(FieldWithMetaString currency);
		ComputedAmount.ComputedAmountBuilder setCurrencyValue(String currency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("callFunction"), String.class, getCallFunction(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
		}
		
	}
	
	//ComputedAmount.ComputedAmountImpl
	class ComputedAmountImpl implements ComputedAmount {
		private final BigDecimal amount;
		private final String callFunction;
		private final FieldWithMetaString currency;
		
		protected ComputedAmountImpl(ComputedAmount.ComputedAmountBuilder builder) {
			this.amount = builder.getAmount();
			this.callFunction = builder.getCallFunction();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public String getCallFunction() {
			return callFunction;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public ComputedAmount build() {
			return this;
		}
		
		@Override
		public ComputedAmount.ComputedAmountBuilder toBuilder() {
			ComputedAmount.ComputedAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ComputedAmount.ComputedAmountBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCallFunction()).ifPresent(builder::setCallFunction);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ComputedAmount _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(callFunction, _that.getCallFunction())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (callFunction != null ? callFunction.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ComputedAmount {" +
				"amount=" + this.amount + ", " +
				"callFunction=" + this.callFunction + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
	
	//ComputedAmount.ComputedAmountBuilderImpl
	class ComputedAmountBuilderImpl implements ComputedAmount.ComputedAmountBuilder {
	
		protected BigDecimal amount;
		protected String callFunction;
		protected FieldWithMetaStringBuilder currency;
	
		public ComputedAmountBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public String getCallFunction() {
			return callFunction;
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
		public ComputedAmount.ComputedAmountBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public ComputedAmount.ComputedAmountBuilder setCallFunction(String callFunction) {
			this.callFunction = callFunction==null?null:callFunction;
			return this;
		}
		@Override
		public ComputedAmount.ComputedAmountBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public ComputedAmount.ComputedAmountBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		
		@Override
		public ComputedAmount build() {
			return new ComputedAmount.ComputedAmountImpl(this);
		}
		
		@Override
		public ComputedAmount.ComputedAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ComputedAmount.ComputedAmountBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getCallFunction()!=null) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ComputedAmount.ComputedAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ComputedAmount.ComputedAmountBuilder o = (ComputedAmount.ComputedAmountBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getCallFunction(), o.getCallFunction(), this::setCallFunction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ComputedAmount _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(callFunction, _that.getCallFunction())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (callFunction != null ? callFunction.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ComputedAmountBuilder {" +
				"amount=" + this.amount + ", " +
				"callFunction=" + this.callFunction + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
