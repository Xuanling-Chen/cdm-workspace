package cdm.observable.asset;

import cdm.observable.asset.meta.FxRateMeta;
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
 * A class describing the rate of a currency conversion: pair of currency, quotation mode and exchange rate.
 * @version ${project.version}
 */
@RosettaClass

public interface FxRate extends RosettaModelObject {
	FxRate build();
	FxRate.FxRateBuilder toBuilder();
	
	/**
	 * Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 * The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 */
	BigDecimal getRate();
	final static FxRateMeta metaData = new FxRateMeta();
	
	@Override
	default RosettaMetaData<? extends FxRate> metaData() {
		return metaData;
	} 
			
	static FxRate.FxRateBuilder builder() {
		return new FxRate.FxRateBuilderImpl();
	}
	
	default Class<? extends FxRate> getType() {
		return FxRate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
	}
	
	
	interface FxRateBuilder extends FxRate, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxRate.FxRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxRate.FxRateBuilder setRate(BigDecimal rate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
		}
		
	}
	
	//FxRate.FxRateImpl
	class FxRateImpl implements FxRate {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal rate;
		
		protected FxRateImpl(FxRate.FxRateBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.rate = builder.getRate();
		}
		
		@Override
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FxRate build() {
			return this;
		}
		
		@Override
		public FxRate.FxRateBuilder toBuilder() {
			FxRate.FxRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRate.FxRateBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRate {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate +
			'}';
		}
	}
	
	//FxRate.FxRateBuilderImpl
	class FxRateBuilderImpl implements FxRate.FxRateBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal rate;
	
		public FxRateBuilderImpl() {
		}
	
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getRate() {
			return rate;
		}
		
	
		@Override
		public FxRate.FxRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		public FxRate.FxRateBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public FxRate build() {
			return new FxRate.FxRateImpl(this);
		}
		
		@Override
		public FxRate.FxRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRate.FxRateBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRate.FxRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRate.FxRateBuilder o = (FxRate.FxRateBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRate _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"rate=" + this.rate +
			'}';
		}
	}
}
