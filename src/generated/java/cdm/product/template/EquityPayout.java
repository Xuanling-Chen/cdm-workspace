package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.asset.DividendReturnTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.meta.EquityPayoutMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 *  The equity payout specification terms. The associated globalKey denotes the ability to associate a hash value to the EquityPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface EquityPayout extends PayoutBase, GlobalKey {
	EquityPayout build();
	EquityPayout.EquityPayoutBuilder toBuilder();
	
	/**
	 * The calculation period dates schedule.
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Dividend Obligations
	 */
	DividendReturnTerms getDividendReturnTerms();
	/**
	 * A quanto or composite FX feature.
	 */
	FxFeature getFxFeature();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
	 */
	PaymentDates getPaymentDates();
	/**
	 * Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. &#39;Equity Performance&#39;. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
	 */
	BigDecimal getPerformance();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing
	 */
	PriceReturnTerms getPriceReturnTerms();
	/**
	 * Rate of Return calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 139. &#39;Rate Of Return&#39;.
	 */
	BigDecimal getRateOfReturn();
	/**
	 * Specifies the type of return associated with the equity payout.
	 */
	ReturnTypeEnum getReturnType();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Security
	 */
	Product getUnderlier();
	final static EquityPayoutMeta metaData = new EquityPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends EquityPayout> metaData() {
		return metaData;
	} 
			
	static EquityPayout.EquityPayoutBuilder builder() {
		return new EquityPayout.EquityPayoutBuilderImpl();
	}
	
	default Class<? extends EquityPayout> getType() {
		return EquityPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("performance"), BigDecimal.class, getPerformance(), this);
		processor.processBasic(path.newSubPath("rateOfReturn"), BigDecimal.class, getRateOfReturn(), this);
		processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
		
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("dividendReturnTerms"), processor, DividendReturnTerms.class, getDividendReturnTerms());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("priceReturnTerms"), processor, PriceReturnTerms.class, getPriceReturnTerms());
		processRosetta(path.newSubPath("underlier"), processor, Product.class, getUnderlier());
	}
	
	
	interface EquityPayoutBuilder extends EquityPayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		DividendReturnTerms.DividendReturnTermsBuilder getOrCreateDividendReturnTerms();
		DividendReturnTerms.DividendReturnTermsBuilder getDividendReturnTerms();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		PriceReturnTerms.PriceReturnTermsBuilder getOrCreatePriceReturnTerms();
		PriceReturnTerms.PriceReturnTermsBuilder getPriceReturnTerms();
		Product.ProductBuilder getOrCreateUnderlier();
		Product.ProductBuilder getUnderlier();
		EquityPayout.EquityPayoutBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		EquityPayout.EquityPayoutBuilder setDividendReturnTerms(DividendReturnTerms dividendReturnTerms);
		EquityPayout.EquityPayoutBuilder setFxFeature(FxFeature fxFeature);
		EquityPayout.EquityPayoutBuilder setMeta(MetaFields meta);
		EquityPayout.EquityPayoutBuilder setPaymentDates(PaymentDates paymentDates);
		EquityPayout.EquityPayoutBuilder setPerformance(BigDecimal performance);
		EquityPayout.EquityPayoutBuilder setPriceReturnTerms(PriceReturnTerms priceReturnTerms);
		EquityPayout.EquityPayoutBuilder setRateOfReturn(BigDecimal rateOfReturn);
		EquityPayout.EquityPayoutBuilder setReturnType(ReturnTypeEnum returnType);
		EquityPayout.EquityPayoutBuilder setUnderlier(Product underlier);
		EquityPayout.EquityPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		EquityPayout.EquityPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		EquityPayout.EquityPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("performance"), BigDecimal.class, getPerformance(), this);
			processor.processBasic(path.newSubPath("rateOfReturn"), BigDecimal.class, getRateOfReturn(), this);
			processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
			
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("dividendReturnTerms"), processor, DividendReturnTerms.DividendReturnTermsBuilder.class, getDividendReturnTerms());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("priceReturnTerms"), processor, PriceReturnTerms.PriceReturnTermsBuilder.class, getPriceReturnTerms());
			processRosetta(path.newSubPath("underlier"), processor, Product.ProductBuilder.class, getUnderlier());
		}
		
	}
	
	//EquityPayout.EquityPayoutImpl
	class EquityPayoutImpl extends PayoutBase.PayoutBaseImpl implements EquityPayout {
		private final CalculationPeriodDates calculationPeriodDates;
		private final DividendReturnTerms dividendReturnTerms;
		private final FxFeature fxFeature;
		private final MetaFields meta;
		private final PaymentDates paymentDates;
		private final BigDecimal performance;
		private final PriceReturnTerms priceReturnTerms;
		private final BigDecimal rateOfReturn;
		private final ReturnTypeEnum returnType;
		private final Product underlier;
		
		protected EquityPayoutImpl(EquityPayout.EquityPayoutBuilder builder) {
			super(builder);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.dividendReturnTerms = ofNullable(builder.getDividendReturnTerms()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.performance = builder.getPerformance();
			this.priceReturnTerms = ofNullable(builder.getPriceReturnTerms()).map(f->f.build()).orElse(null);
			this.rateOfReturn = builder.getRateOfReturn();
			this.returnType = builder.getReturnType();
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public DividendReturnTerms getDividendReturnTerms() {
			return dividendReturnTerms;
		}
		
		@Override
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public BigDecimal getPerformance() {
			return performance;
		}
		
		@Override
		public PriceReturnTerms getPriceReturnTerms() {
			return priceReturnTerms;
		}
		
		@Override
		public BigDecimal getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		public Product getUnderlier() {
			return underlier;
		}
		
		@Override
		public EquityPayout build() {
			return this;
		}
		
		@Override
		public EquityPayout.EquityPayoutBuilder toBuilder() {
			EquityPayout.EquityPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityPayout.EquityPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getDividendReturnTerms()).ifPresent(builder::setDividendReturnTerms);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getPerformance()).ifPresent(builder::setPerformance);
			ofNullable(getPriceReturnTerms()).ifPresent(builder::setPriceReturnTerms);
			ofNullable(getRateOfReturn()).ifPresent(builder::setRateOfReturn);
			ofNullable(getReturnType()).ifPresent(builder::setReturnType);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPayout _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(dividendReturnTerms, _that.getDividendReturnTerms())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			if (!Objects.equals(priceReturnTerms, _that.getPriceReturnTerms())) return false;
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (dividendReturnTerms != null ? dividendReturnTerms.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			_result = 31 * _result + (priceReturnTerms != null ? priceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPayout {" +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"dividendReturnTerms=" + this.dividendReturnTerms + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"meta=" + this.meta + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"performance=" + this.performance + ", " +
				"priceReturnTerms=" + this.priceReturnTerms + ", " +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"returnType=" + this.returnType + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
	
	//EquityPayout.EquityPayoutBuilderImpl
	class EquityPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements EquityPayout.EquityPayoutBuilder, GlobalKeyBuilder {
	
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected BigDecimal performance;
		protected PriceReturnTerms.PriceReturnTermsBuilder priceReturnTerms;
		protected BigDecimal rateOfReturn;
		protected ReturnTypeEnum returnType;
		protected Product.ProductBuilder underlier;
	
		public EquityPayoutBuilderImpl() {
		}
	
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder getDividendReturnTerms() {
			return dividendReturnTerms;
		}
		
		@Override
		public DividendReturnTerms.DividendReturnTermsBuilder getOrCreateDividendReturnTerms() {
			DividendReturnTerms.DividendReturnTermsBuilder result;
			if (dividendReturnTerms!=null) {
				result = dividendReturnTerms;
			}
			else {
				result = dividendReturnTerms = DividendReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getPerformance() {
			return performance;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder getPriceReturnTerms() {
			return priceReturnTerms;
		}
		
		@Override
		public PriceReturnTerms.PriceReturnTermsBuilder getOrCreatePriceReturnTerms() {
			PriceReturnTerms.PriceReturnTermsBuilder result;
			if (priceReturnTerms!=null) {
				result = priceReturnTerms;
			}
			else {
				result = priceReturnTerms = PriceReturnTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getRateOfReturn() {
			return rateOfReturn;
		}
		
		@Override
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		public Product.ProductBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateUnderlier() {
			Product.ProductBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Product.builder();
			}
			
			return result;
		}
		
	
		@Override
		public EquityPayout.EquityPayoutBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates) {
			this.calculationPeriodDates = calculationPeriodDates==null?null:calculationPeriodDates.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setDividendReturnTerms(DividendReturnTerms dividendReturnTerms) {
			this.dividendReturnTerms = dividendReturnTerms==null?null:dividendReturnTerms.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setPerformance(BigDecimal performance) {
			this.performance = performance==null?null:performance;
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setPriceReturnTerms(PriceReturnTerms priceReturnTerms) {
			this.priceReturnTerms = priceReturnTerms==null?null:priceReturnTerms.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setRateOfReturn(BigDecimal rateOfReturn) {
			this.rateOfReturn = rateOfReturn==null?null:rateOfReturn;
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setReturnType(ReturnTypeEnum returnType) {
			this.returnType = returnType==null?null:returnType;
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setUnderlier(Product underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public EquityPayout.EquityPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public EquityPayout build() {
			return new EquityPayout.EquityPayoutImpl(this);
		}
		
		@Override
		public EquityPayout.EquityPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPayout.EquityPayoutBuilder prune() {
			super.prune();
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (dividendReturnTerms!=null && !dividendReturnTerms.prune().hasData()) dividendReturnTerms = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (priceReturnTerms!=null && !priceReturnTerms.prune().hasData()) priceReturnTerms = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getDividendReturnTerms()!=null && getDividendReturnTerms().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getPerformance()!=null) return true;
			if (getPriceReturnTerms()!=null && getPriceReturnTerms().hasData()) return true;
			if (getRateOfReturn()!=null) return true;
			if (getReturnType()!=null) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPayout.EquityPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityPayout.EquityPayoutBuilder o = (EquityPayout.EquityPayoutBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getDividendReturnTerms(), o.getDividendReturnTerms(), this::setDividendReturnTerms);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getPriceReturnTerms(), o.getPriceReturnTerms(), this::setPriceReturnTerms);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			
			merger.mergeBasic(getPerformance(), o.getPerformance(), this::setPerformance);
			merger.mergeBasic(getRateOfReturn(), o.getRateOfReturn(), this::setRateOfReturn);
			merger.mergeBasic(getReturnType(), o.getReturnType(), this::setReturnType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityPayout _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(dividendReturnTerms, _that.getDividendReturnTerms())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(performance, _that.getPerformance())) return false;
			if (!Objects.equals(priceReturnTerms, _that.getPriceReturnTerms())) return false;
			if (!Objects.equals(rateOfReturn, _that.getRateOfReturn())) return false;
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (dividendReturnTerms != null ? dividendReturnTerms.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (performance != null ? performance.hashCode() : 0);
			_result = 31 * _result + (priceReturnTerms != null ? priceReturnTerms.hashCode() : 0);
			_result = 31 * _result + (rateOfReturn != null ? rateOfReturn.hashCode() : 0);
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPayoutBuilder {" +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"dividendReturnTerms=" + this.dividendReturnTerms + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"meta=" + this.meta + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"performance=" + this.performance + ", " +
				"priceReturnTerms=" + this.priceReturnTerms + ", " +
				"rateOfReturn=" + this.rateOfReturn + ", " +
				"returnType=" + this.returnType + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
}
