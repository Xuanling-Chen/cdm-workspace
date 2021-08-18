package cdm.product.asset;

import cdm.product.asset.meta.DividendPayoutMeta;
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
 * A class describing the dividend payout ratio associated with an equity underlier. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 * @version ${project.version}
 */
@RosettaClass

public interface DividendPayout extends RosettaModelObject {
	DividendPayout build();
	DividendPayout.DividendPayoutBuilder toBuilder();
	
	/**
	 * Specifies the total actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getDividendPayoutRatio();
	/**
	 * Specifies the cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getDividendPayoutRatioCash();
	/**
	 * Specifies the non cash actual dividend payout ratio associated with the equity underlier. A ratio of 90% should be expressed at 0.90.
	 */
	BigDecimal getDividendPayoutRatioNonCash();
	final static DividendPayoutMeta metaData = new DividendPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends DividendPayout> metaData() {
		return metaData;
	} 
			
	static DividendPayout.DividendPayoutBuilder builder() {
		return new DividendPayout.DividendPayoutBuilderImpl();
	}
	
	default Class<? extends DividendPayout> getType() {
		return DividendPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
		processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
		
	}
	
	
	interface DividendPayoutBuilder extends DividendPayout, RosettaModelObjectBuilder {
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatio(BigDecimal dividendPayoutRatio);
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatioCash(BigDecimal dividendPayoutRatioCash);
		DividendPayout.DividendPayoutBuilder setDividendPayoutRatioNonCash(BigDecimal dividendPayoutRatioNonCash);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dividendPayoutRatio"), BigDecimal.class, getDividendPayoutRatio(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioCash"), BigDecimal.class, getDividendPayoutRatioCash(), this);
			processor.processBasic(path.newSubPath("dividendPayoutRatioNonCash"), BigDecimal.class, getDividendPayoutRatioNonCash(), this);
			
		}
		
	}
	
	//DividendPayout.DividendPayoutImpl
	class DividendPayoutImpl implements DividendPayout {
		private final BigDecimal dividendPayoutRatio;
		private final BigDecimal dividendPayoutRatioCash;
		private final BigDecimal dividendPayoutRatioNonCash;
		
		protected DividendPayoutImpl(DividendPayout.DividendPayoutBuilder builder) {
			this.dividendPayoutRatio = builder.getDividendPayoutRatio();
			this.dividendPayoutRatioCash = builder.getDividendPayoutRatioCash();
			this.dividendPayoutRatioNonCash = builder.getDividendPayoutRatioNonCash();
		}
		
		@Override
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
		@Override
		public DividendPayout build() {
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			DividendPayout.DividendPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPayout.DividendPayoutBuilder builder) {
			ofNullable(getDividendPayoutRatio()).ifPresent(builder::setDividendPayoutRatio);
			ofNullable(getDividendPayoutRatioCash()).ifPresent(builder::setDividendPayoutRatioCash);
			ofNullable(getDividendPayoutRatioNonCash()).ifPresent(builder::setDividendPayoutRatioNonCash);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayout {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash +
			'}';
		}
	}
	
	//DividendPayout.DividendPayoutBuilderImpl
	class DividendPayoutBuilderImpl implements DividendPayout.DividendPayoutBuilder {
	
		protected BigDecimal dividendPayoutRatio;
		protected BigDecimal dividendPayoutRatioCash;
		protected BigDecimal dividendPayoutRatioNonCash;
	
		public DividendPayoutBuilderImpl() {
		}
	
		@Override
		public BigDecimal getDividendPayoutRatio() {
			return dividendPayoutRatio;
		}
		
		@Override
		public BigDecimal getDividendPayoutRatioCash() {
			return dividendPayoutRatioCash;
		}
		
		@Override
		public BigDecimal getDividendPayoutRatioNonCash() {
			return dividendPayoutRatioNonCash;
		}
		
	
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatio(BigDecimal dividendPayoutRatio) {
			this.dividendPayoutRatio = dividendPayoutRatio==null?null:dividendPayoutRatio;
			return this;
		}
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatioCash(BigDecimal dividendPayoutRatioCash) {
			this.dividendPayoutRatioCash = dividendPayoutRatioCash==null?null:dividendPayoutRatioCash;
			return this;
		}
		@Override
		public DividendPayout.DividendPayoutBuilder setDividendPayoutRatioNonCash(BigDecimal dividendPayoutRatioNonCash) {
			this.dividendPayoutRatioNonCash = dividendPayoutRatioNonCash==null?null:dividendPayoutRatioNonCash;
			return this;
		}
		
		@Override
		public DividendPayout build() {
			return new DividendPayout.DividendPayoutImpl(this);
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPayoutRatio()!=null) return true;
			if (getDividendPayoutRatioCash()!=null) return true;
			if (getDividendPayoutRatioNonCash()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPayout.DividendPayoutBuilder o = (DividendPayout.DividendPayoutBuilder) other;
			
			
			merger.mergeBasic(getDividendPayoutRatio(), o.getDividendPayoutRatio(), this::setDividendPayoutRatio);
			merger.mergeBasic(getDividendPayoutRatioCash(), o.getDividendPayoutRatioCash(), this::setDividendPayoutRatioCash);
			merger.mergeBasic(getDividendPayoutRatioNonCash(), o.getDividendPayoutRatioNonCash(), this::setDividendPayoutRatioNonCash);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutRatio, _that.getDividendPayoutRatio())) return false;
			if (!Objects.equals(dividendPayoutRatioCash, _that.getDividendPayoutRatioCash())) return false;
			if (!Objects.equals(dividendPayoutRatioNonCash, _that.getDividendPayoutRatioNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutRatio != null ? dividendPayoutRatio.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioCash != null ? dividendPayoutRatioCash.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutRatioNonCash != null ? dividendPayoutRatioNonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutBuilder {" +
				"dividendPayoutRatio=" + this.dividendPayoutRatio + ", " +
				"dividendPayoutRatioCash=" + this.dividendPayoutRatioCash + ", " +
				"dividendPayoutRatioNonCash=" + this.dividendPayoutRatioNonCash +
			'}';
		}
	}
}
