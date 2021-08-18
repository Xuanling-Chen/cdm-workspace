package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.EligibleCurrencyInterestRateMeta;
import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder;
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
 * A class to specify the interest rate associated with initial margin collateral. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n): Distributions and Interest Payment (IM).
 * @version ${project.version}
 */
@RosettaClass

public interface EligibleCurrencyInterestRate extends RosettaModelObject {
	EligibleCurrencyInterestRate build();
	EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder toBuilder();
	
	/**
	 */
	FieldWithMetaDayCountFractionEnum getActual365Currency();
	/**
	 * The eligible currency.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * The interest rate associated with the eligible currency.
	 */
	BigDecimal getInterestRate();
	final static EligibleCurrencyInterestRateMeta metaData = new EligibleCurrencyInterestRateMeta();
	
	@Override
	default RosettaMetaData<? extends EligibleCurrencyInterestRate> metaData() {
		return metaData;
	} 
			
	static EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder builder() {
		return new EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilderImpl();
	}
	
	default Class<? extends EligibleCurrencyInterestRate> getType() {
		return EligibleCurrencyInterestRate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("interestRate"), BigDecimal.class, getInterestRate(), this);
		
		processRosetta(path.newSubPath("actual365Currency"), processor, FieldWithMetaDayCountFractionEnum.class, getActual365Currency());
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	
	
	interface EligibleCurrencyInterestRateBuilder extends EligibleCurrencyInterestRate, RosettaModelObjectBuilder {
		FieldWithMetaDayCountFractionEnumBuilder getOrCreateActual365Currency();
		FieldWithMetaDayCountFractionEnumBuilder getActual365Currency();
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setActual365Currency(FieldWithMetaDayCountFractionEnum actual365Currency);
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setActual365CurrencyValue(DayCountFractionEnum actual365Currency);
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setCurrency(FieldWithMetaString currency);
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setCurrencyValue(String currency);
		EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setInterestRate(BigDecimal interestRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("interestRate"), BigDecimal.class, getInterestRate(), this);
			
			processRosetta(path.newSubPath("actual365Currency"), processor, FieldWithMetaDayCountFractionEnumBuilder.class, getActual365Currency());
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
		}
		
	}
	
	//EligibleCurrencyInterestRate.EligibleCurrencyInterestRateImpl
	class EligibleCurrencyInterestRateImpl implements EligibleCurrencyInterestRate {
		private final FieldWithMetaDayCountFractionEnum actual365Currency;
		private final FieldWithMetaString currency;
		private final BigDecimal interestRate;
		
		protected EligibleCurrencyInterestRateImpl(EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder builder) {
			this.actual365Currency = ofNullable(builder.getActual365Currency()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.interestRate = builder.getInterestRate();
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum getActual365Currency() {
			return actual365Currency;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public BigDecimal getInterestRate() {
			return interestRate;
		}
		
		@Override
		public EligibleCurrencyInterestRate build() {
			return this;
		}
		
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder toBuilder() {
			EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder builder) {
			ofNullable(getActual365Currency()).ifPresent(builder::setActual365Currency);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getInterestRate()).ifPresent(builder::setInterestRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCurrencyInterestRate _that = getType().cast(o);
		
			if (!Objects.equals(actual365Currency, _that.getActual365Currency())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(interestRate, _that.getInterestRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (actual365Currency != null ? actual365Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCurrencyInterestRate {" +
				"actual365Currency=" + this.actual365Currency + ", " +
				"currency=" + this.currency + ", " +
				"interestRate=" + this.interestRate +
			'}';
		}
	}
	
	//EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilderImpl
	class EligibleCurrencyInterestRateBuilderImpl implements EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder {
	
		protected FieldWithMetaDayCountFractionEnumBuilder actual365Currency;
		protected FieldWithMetaStringBuilder currency;
		protected BigDecimal interestRate;
	
		public EligibleCurrencyInterestRateBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getActual365Currency() {
			return actual365Currency;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnumBuilder getOrCreateActual365Currency() {
			FieldWithMetaDayCountFractionEnumBuilder result;
			if (actual365Currency!=null) {
				result = actual365Currency;
			}
			else {
				result = actual365Currency = FieldWithMetaDayCountFractionEnum.builder();
			}
			
			return result;
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
		public BigDecimal getInterestRate() {
			return interestRate;
		}
		
	
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setActual365Currency(FieldWithMetaDayCountFractionEnum actual365Currency) {
			this.actual365Currency = actual365Currency==null?null:actual365Currency.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setActual365CurrencyValue(DayCountFractionEnum actual365Currency) {
			this.getOrCreateActual365Currency().setValue(actual365Currency);
			return this;
		}
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder setInterestRate(BigDecimal interestRate) {
			this.interestRate = interestRate==null?null:interestRate;
			return this;
		}
		
		@Override
		public EligibleCurrencyInterestRate build() {
			return new EligibleCurrencyInterestRate.EligibleCurrencyInterestRateImpl(this);
		}
		
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder prune() {
			if (actual365Currency!=null && !actual365Currency.prune().hasData()) actual365Currency = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getActual365Currency()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getInterestRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder o = (EligibleCurrencyInterestRate.EligibleCurrencyInterestRateBuilder) other;
			
			merger.mergeRosetta(getActual365Currency(), o.getActual365Currency(), this::setActual365Currency);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getInterestRate(), o.getInterestRate(), this::setInterestRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCurrencyInterestRate _that = getType().cast(o);
		
			if (!Objects.equals(actual365Currency, _that.getActual365Currency())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(interestRate, _that.getInterestRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (actual365Currency != null ? actual365Currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (interestRate != null ? interestRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCurrencyInterestRateBuilder {" +
				"actual365Currency=" + this.actual365Currency + ", " +
				"currency=" + this.currency + ", " +
				"interestRate=" + this.interestRate +
			'}';
		}
	}
}
