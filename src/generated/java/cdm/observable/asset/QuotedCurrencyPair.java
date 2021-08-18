package cdm.observable.asset;

import cdm.observable.asset.meta.QuotedCurrencyPairMeta;
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
 * A class that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
 * @version ${project.version}
 */
@RosettaClass

public interface QuotedCurrencyPair extends RosettaModelObject {
	QuotedCurrencyPair build();
	QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder();
	
	/**
	 * The first currency specified when a pair of currencies is to be evaluated.
	 */
	FieldWithMetaString getCurrency1();
	/**
	 * The second currency specified when a pair of currencies is to be evaluated.
	 */
	FieldWithMetaString getCurrency2();
	/**
	 * The method by which the exchange rate is quoted.
	 */
	QuoteBasisEnum getQuoteBasis();
	final static QuotedCurrencyPairMeta metaData = new QuotedCurrencyPairMeta();
	
	@Override
	default RosettaMetaData<? extends QuotedCurrencyPair> metaData() {
		return metaData;
	} 
			
	static QuotedCurrencyPair.QuotedCurrencyPairBuilder builder() {
		return new QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl();
	}
	
	default Class<? extends QuotedCurrencyPair> getType() {
		return QuotedCurrencyPair.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		
		processRosetta(path.newSubPath("currency1"), processor, FieldWithMetaString.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, FieldWithMetaString.class, getCurrency2());
	}
	
	
	interface QuotedCurrencyPairBuilder extends QuotedCurrencyPair, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency1();
		FieldWithMetaStringBuilder getCurrency1();
		FieldWithMetaStringBuilder getOrCreateCurrency2();
		FieldWithMetaStringBuilder getCurrency2();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1(FieldWithMetaString currency1);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1Value(String currency1);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2(FieldWithMetaString currency2);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2Value(String currency2);
		QuotedCurrencyPair.QuotedCurrencyPairBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			
			processRosetta(path.newSubPath("currency1"), processor, FieldWithMetaStringBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, FieldWithMetaStringBuilder.class, getCurrency2());
		}
		
	}
	
	//QuotedCurrencyPair.QuotedCurrencyPairImpl
	class QuotedCurrencyPairImpl implements QuotedCurrencyPair {
		private final FieldWithMetaString currency1;
		private final FieldWithMetaString currency2;
		private final QuoteBasisEnum quoteBasis;
		
		protected QuotedCurrencyPairImpl(QuotedCurrencyPair.QuotedCurrencyPairBuilder builder) {
			this.currency1 = ofNullable(builder.getCurrency1()).map(f->f.build()).orElse(null);
			this.currency2 = ofNullable(builder.getCurrency2()).map(f->f.build()).orElse(null);
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		public FieldWithMetaString getCurrency1() {
			return currency1;
		}
		
		@Override
		public FieldWithMetaString getCurrency2() {
			return currency2;
		}
		
		@Override
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public QuotedCurrencyPair build() {
			return this;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotedCurrencyPair.QuotedCurrencyPairBuilder builder) {
			ofNullable(getCurrency1()).ifPresent(builder::setCurrency1);
			ofNullable(getCurrency2()).ifPresent(builder::setCurrency2);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedCurrencyPair _that = getType().cast(o);
		
			if (!Objects.equals(currency1, _that.getCurrency1())) return false;
			if (!Objects.equals(currency2, _that.getCurrency2())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1 != null ? currency1.hashCode() : 0);
			_result = 31 * _result + (currency2 != null ? currency2.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedCurrencyPair {" +
				"currency1=" + this.currency1 + ", " +
				"currency2=" + this.currency2 + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}
	
	//QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl
	class QuotedCurrencyPairBuilderImpl implements QuotedCurrencyPair.QuotedCurrencyPairBuilder {
	
		protected FieldWithMetaStringBuilder currency1;
		protected FieldWithMetaStringBuilder currency2;
		protected QuoteBasisEnum quoteBasis;
	
		public QuotedCurrencyPairBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getCurrency1() {
			return currency1;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency1() {
			FieldWithMetaStringBuilder result;
			if (currency1!=null) {
				result = currency1;
			}
			else {
				result = currency1 = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCurrency2() {
			return currency2;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency2() {
			FieldWithMetaStringBuilder result;
			if (currency2!=null) {
				result = currency2;
			}
			else {
				result = currency2 = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
	
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1(FieldWithMetaString currency1) {
			this.currency1 = currency1==null?null:currency1.toBuilder();
			return this;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency1Value(String currency1) {
			this.getOrCreateCurrency1().setValue(currency1);
			return this;
		}
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2(FieldWithMetaString currency2) {
			this.currency2 = currency2==null?null:currency2.toBuilder();
			return this;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setCurrency2Value(String currency2) {
			this.getOrCreateCurrency2().setValue(currency2);
			return this;
		}
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		
		@Override
		public QuotedCurrencyPair build() {
			return new QuotedCurrencyPair.QuotedCurrencyPairImpl(this);
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder prune() {
			if (currency1!=null && !currency1.prune().hasData()) currency1 = null;
			if (currency2!=null && !currency2.prune().hasData()) currency2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency1()!=null) return true;
			if (getCurrency2()!=null) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder o = (QuotedCurrencyPair.QuotedCurrencyPairBuilder) other;
			
			merger.mergeRosetta(getCurrency1(), o.getCurrency1(), this::setCurrency1);
			merger.mergeRosetta(getCurrency2(), o.getCurrency2(), this::setCurrency2);
			
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedCurrencyPair _that = getType().cast(o);
		
			if (!Objects.equals(currency1, _that.getCurrency1())) return false;
			if (!Objects.equals(currency2, _that.getCurrency2())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency1 != null ? currency1.hashCode() : 0);
			_result = 31 * _result + (currency2 != null ? currency2.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedCurrencyPairBuilder {" +
				"currency1=" + this.currency1 + ", " +
				"currency2=" + this.currency2 + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}
}
