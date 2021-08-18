package cdm.product.common.settlement;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.meta.ObservationPayoutMeta;
import cdm.product.template.FxFeature;
import cdm.product.template.Product;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines payout terms relevent where the underlier is an asset (e.g. equities, commodities) or a referenced benchmark that is observed to obtain a price
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationPayout extends PayoutBase {
	ObservationPayout build();
	ObservationPayout.ObservationPayoutBuilder toBuilder();
	
	/**
	 * Defines the calculation period dates schedule.
	 */
	List<? extends CalculationPeriodDates> getCalculationPeriodDates();
	/**
	 * Defines quanto or composite FX features that are included in the swap leg.
	 */
	FxFeature getFxFeature();
	/**
	 * Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
	 */
	PaymentDates getPaymentDates();
	/**
	 * Identifies the underlying product that is referenced for pricing of the applicable leg in a swap.  Referenced in the &#39;2018 ISDA CDM Equity Confirmation for Security Equity Swap&#39; as Security.
	 */
	Product getUnderlier();
	final static ObservationPayoutMeta metaData = new ObservationPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationPayout> metaData() {
		return metaData;
	} 
			
	static ObservationPayout.ObservationPayoutBuilder builder() {
		return new ObservationPayout.ObservationPayoutBuilderImpl();
	}
	
	default Class<? extends ObservationPayout> getType() {
		return ObservationPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("underlier"), processor, Product.class, getUnderlier());
	}
	
	
	interface ObservationPayoutBuilder extends ObservationPayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates(int _index);
		List<? extends CalculationPeriodDates.CalculationPeriodDatesBuilder> getCalculationPeriodDates();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		Product.ProductBuilder getOrCreateUnderlier();
		Product.ProductBuilder getUnderlier();
		ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates, int _idx);
		ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDates);
		ObservationPayout.ObservationPayoutBuilder setCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDates);
		ObservationPayout.ObservationPayoutBuilder setFxFeature(FxFeature fxFeature);
		ObservationPayout.ObservationPayoutBuilder setPaymentDates(PaymentDates paymentDates);
		ObservationPayout.ObservationPayoutBuilder setUnderlier(Product underlier);
		ObservationPayout.ObservationPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		ObservationPayout.ObservationPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		ObservationPayout.ObservationPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("underlier"), processor, Product.ProductBuilder.class, getUnderlier());
		}
		
	}
	
	//ObservationPayout.ObservationPayoutImpl
	class ObservationPayoutImpl extends PayoutBase.PayoutBaseImpl implements ObservationPayout {
		private final List<? extends CalculationPeriodDates> calculationPeriodDates;
		private final FxFeature fxFeature;
		private final PaymentDates paymentDates;
		private final Product underlier;
		
		protected ObservationPayoutImpl(ObservationPayout.ObservationPayoutBuilder builder) {
			super(builder);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends CalculationPeriodDates> getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public Product getUnderlier() {
			return underlier;
		}
		
		@Override
		public ObservationPayout build() {
			return this;
		}
		
		@Override
		public ObservationPayout.ObservationPayoutBuilder toBuilder() {
			ObservationPayout.ObservationPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationPayout.ObservationPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationPayout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationPayout {" +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
	
	//ObservationPayout.ObservationPayoutBuilderImpl
	class ObservationPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements ObservationPayout.ObservationPayoutBuilder {
	
		protected List<CalculationPeriodDates.CalculationPeriodDatesBuilder> calculationPeriodDates = new ArrayList<>();
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected Product.ProductBuilder underlier;
	
		public ObservationPayoutBuilderImpl() {
		}
	
		@Override
		public List<? extends CalculationPeriodDates.CalculationPeriodDatesBuilder> getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates(int _index) {
		
			if (calculationPeriodDates==null) {
				this.calculationPeriodDates = new ArrayList<>();
			}
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			return getIndex(calculationPeriodDates, _index, () -> {
						CalculationPeriodDates.CalculationPeriodDatesBuilder newCalculationPeriodDates = CalculationPeriodDates.builder();
						return newCalculationPeriodDates;
					});
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
		public ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates) {
			if (calculationPeriodDates!=null) this.calculationPeriodDates.add(calculationPeriodDates.toBuilder());
			return this;
		}
		
		@Override
		public ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates, int _idx) {
			getIndex(this.calculationPeriodDates, _idx, () -> calculationPeriodDates.toBuilder());
			return this;
		}
		@Override 
		public ObservationPayout.ObservationPayoutBuilder addCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDatess) {
			if (calculationPeriodDatess != null) {
				for (CalculationPeriodDates toAdd : calculationPeriodDatess) {
					this.calculationPeriodDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ObservationPayout.ObservationPayoutBuilder setCalculationPeriodDates(List<? extends CalculationPeriodDates> calculationPeriodDatess) {
			if (calculationPeriodDatess == null)  {
				this.calculationPeriodDates = new ArrayList<>();
			}
			else {
				this.calculationPeriodDates = calculationPeriodDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ObservationPayout.ObservationPayoutBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		public ObservationPayout.ObservationPayoutBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		public ObservationPayout.ObservationPayoutBuilder setUnderlier(Product underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		@Override
		public ObservationPayout.ObservationPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public ObservationPayout.ObservationPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public ObservationPayout.ObservationPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public ObservationPayout build() {
			return new ObservationPayout.ObservationPayoutImpl(this);
		}
		
		@Override
		public ObservationPayout.ObservationPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationPayout.ObservationPayoutBuilder prune() {
			super.prune();
			calculationPeriodDates = calculationPeriodDates.stream().filter(b->b!=null).<CalculationPeriodDates.CalculationPeriodDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationPayout.ObservationPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ObservationPayout.ObservationPayoutBuilder o = (ObservationPayout.ObservationPayoutBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::getOrCreateCalculationPeriodDates);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationPayout _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationPayoutBuilder {" +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"underlier=" + this.underlier +
			'}' + " " + super.toString();
		}
	}
}
