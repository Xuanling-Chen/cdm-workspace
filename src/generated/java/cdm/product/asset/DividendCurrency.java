package cdm.product.asset;

import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.meta.DividendCurrencyMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.BasicReferenceWithMetaString;
import com.rosetta.model.metafields.BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the currency in which the dividends will be denominated, i.e. either in the dividend currency or in a currency specified as part of the contract.
 * @version ${project.version}
 */
@RosettaClass

public interface DividendCurrency extends RosettaModelObject {
	DividendCurrency build();
	DividendCurrency.DividendCurrencyBuilder toBuilder();
	
	/**
	 * The currency in which the dividend is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * Reference to a currency specified elsewhere in the document
	 */
	BasicReferenceWithMetaString getCurrencyReference();
	/**
	 * Specifies the method according to which the dividend is determined, e.g. the dividend currency.
	 */
	DeterminationMethodEnum getDeterminationMethod();
	final static DividendCurrencyMeta metaData = new DividendCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends DividendCurrency> metaData() {
		return metaData;
	} 
			
	static DividendCurrency.DividendCurrencyBuilder builder() {
		return new DividendCurrency.DividendCurrencyBuilderImpl();
	}
	
	default Class<? extends DividendCurrency> getType() {
		return DividendCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("currencyReference"), processor, BasicReferenceWithMetaString.class, getCurrencyReference());
	}
	
	
	interface DividendCurrencyBuilder extends DividendCurrency, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		BasicReferenceWithMetaStringBuilder getOrCreateCurrencyReference();
		BasicReferenceWithMetaStringBuilder getCurrencyReference();
		DividendCurrency.DividendCurrencyBuilder setCurrency(FieldWithMetaString currency);
		DividendCurrency.DividendCurrencyBuilder setCurrencyValue(String currency);
		DividendCurrency.DividendCurrencyBuilder setCurrencyReference(BasicReferenceWithMetaString currencyReference);
		DividendCurrency.DividendCurrencyBuilder setCurrencyReferenceValue(String currencyReference);
		DividendCurrency.DividendCurrencyBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("determinationMethod"), DeterminationMethodEnum.class, getDeterminationMethod(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("currencyReference"), processor, BasicReferenceWithMetaStringBuilder.class, getCurrencyReference());
		}
		
	}
	
	//DividendCurrency.DividendCurrencyImpl
	class DividendCurrencyImpl implements DividendCurrency {
		private final FieldWithMetaString currency;
		private final BasicReferenceWithMetaString currencyReference;
		private final DeterminationMethodEnum determinationMethod;
		
		protected DividendCurrencyImpl(DividendCurrency.DividendCurrencyBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.currencyReference = ofNullable(builder.getCurrencyReference()).map(f->f.build()).orElse(null);
			this.determinationMethod = builder.getDeterminationMethod();
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public BasicReferenceWithMetaString getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DividendCurrency build() {
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder toBuilder() {
			DividendCurrency.DividendCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendCurrency.DividendCurrencyBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getCurrencyReference()).ifPresent(builder::setCurrencyReference);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendCurrency _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendCurrency {" +
				"currency=" + this.currency + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"determinationMethod=" + this.determinationMethod +
			'}';
		}
	}
	
	//DividendCurrency.DividendCurrencyBuilderImpl
	class DividendCurrencyBuilderImpl implements DividendCurrency.DividendCurrencyBuilder {
	
		protected FieldWithMetaStringBuilder currency;
		protected BasicReferenceWithMetaStringBuilder currencyReference;
		protected DeterminationMethodEnum determinationMethod;
	
		public DividendCurrencyBuilderImpl() {
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
		public BasicReferenceWithMetaStringBuilder getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public BasicReferenceWithMetaStringBuilder getOrCreateCurrencyReference() {
			BasicReferenceWithMetaStringBuilder result;
			if (currencyReference!=null) {
				result = currencyReference;
			}
			else {
				result = currencyReference = BasicReferenceWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public DeterminationMethodEnum getDeterminationMethod() {
			return determinationMethod;
		}
		
	
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrencyReference(BasicReferenceWithMetaString currencyReference) {
			this.currencyReference = currencyReference==null?null:currencyReference.toBuilder();
			return this;
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder setCurrencyReferenceValue(String currencyReference) {
			this.getOrCreateCurrencyReference().setValue(currencyReference);
			return this;
		}
		@Override
		public DividendCurrency.DividendCurrencyBuilder setDeterminationMethod(DeterminationMethodEnum determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod;
			return this;
		}
		
		@Override
		public DividendCurrency build() {
			return new DividendCurrency.DividendCurrencyImpl(this);
		}
		
		@Override
		public DividendCurrency.DividendCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendCurrency.DividendCurrencyBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (currencyReference!=null && !currencyReference.prune().hasData()) currencyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null) return true;
			if (getCurrencyReference()!=null) return true;
			if (getDeterminationMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendCurrency.DividendCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendCurrency.DividendCurrencyBuilder o = (DividendCurrency.DividendCurrencyBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getCurrencyReference(), o.getCurrencyReference(), this::setCurrencyReference);
			
			merger.mergeBasic(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendCurrency _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendCurrencyBuilder {" +
				"currency=" + this.currency + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"determinationMethod=" + this.determinationMethod +
			'}';
		}
	}
}
