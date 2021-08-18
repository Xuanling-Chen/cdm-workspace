package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilder;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.meta.FixedForwardPayoutMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Represents a forward settling, fixed price payout. There is no underlier associated with this payout type and is based on fixed pricing per a given unit (e.g. in commodities price per barrel)
 * @version ${project.version}
 */
@RosettaClass

public interface FixedForwardPayout extends PayoutBase {
	FixedForwardPayout build();
	FixedForwardPayout.FixedForwardPayoutBuilder toBuilder();
	
	/**
	 * Specifies the fixed price on which fixed forward payments are based.
	 */
	ReferenceWithMetaPrice getFixedPrice();
	/**
	 * Specifies the parameters to generate the payment date schedule, either through a parametric representation or by reference to specified dates.
	 */
	PaymentDates getPaymentDates();
	final static FixedForwardPayoutMeta metaData = new FixedForwardPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends FixedForwardPayout> metaData() {
		return metaData;
	} 
			
	static FixedForwardPayout.FixedForwardPayoutBuilder builder() {
		return new FixedForwardPayout.FixedForwardPayoutBuilderImpl();
	}
	
	default Class<? extends FixedForwardPayout> getType() {
		return FixedForwardPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("fixedPrice"), processor, ReferenceWithMetaPrice.class, getFixedPrice());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
	}
	
	
	interface FixedForwardPayoutBuilder extends FixedForwardPayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		ReferenceWithMetaPriceBuilder getOrCreateFixedPrice();
		ReferenceWithMetaPriceBuilder getFixedPrice();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		FixedForwardPayout.FixedForwardPayoutBuilder setFixedPrice(ReferenceWithMetaPrice fixedPrice);
		FixedForwardPayout.FixedForwardPayoutBuilder setFixedPriceValue(Price fixedPrice);
		FixedForwardPayout.FixedForwardPayoutBuilder setPaymentDates(PaymentDates paymentDates);
		FixedForwardPayout.FixedForwardPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		FixedForwardPayout.FixedForwardPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		FixedForwardPayout.FixedForwardPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("fixedPrice"), processor, ReferenceWithMetaPriceBuilder.class, getFixedPrice());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
		}
		
	}
	
	//FixedForwardPayout.FixedForwardPayoutImpl
	class FixedForwardPayoutImpl extends PayoutBase.PayoutBaseImpl implements FixedForwardPayout {
		private final ReferenceWithMetaPrice fixedPrice;
		private final PaymentDates paymentDates;
		
		protected FixedForwardPayoutImpl(FixedForwardPayout.FixedForwardPayoutBuilder builder) {
			super(builder);
			this.fixedPrice = ofNullable(builder.getFixedPrice()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaPrice getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public FixedForwardPayout build() {
			return this;
		}
		
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder toBuilder() {
			FixedForwardPayout.FixedForwardPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedForwardPayout.FixedForwardPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedPrice()).ifPresent(builder::setFixedPrice);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedForwardPayout _that = getType().cast(o);
		
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedForwardPayout {" +
				"fixedPrice=" + this.fixedPrice + ", " +
				"paymentDates=" + this.paymentDates +
			'}' + " " + super.toString();
		}
	}
	
	//FixedForwardPayout.FixedForwardPayoutBuilderImpl
	class FixedForwardPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements FixedForwardPayout.FixedForwardPayoutBuilder {
	
		protected ReferenceWithMetaPriceBuilder fixedPrice;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
	
		public FixedForwardPayoutBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPriceBuilder getFixedPrice() {
			return fixedPrice;
		}
		
		@Override
		public ReferenceWithMetaPriceBuilder getOrCreateFixedPrice() {
			ReferenceWithMetaPriceBuilder result;
			if (fixedPrice!=null) {
				result = fixedPrice;
			}
			else {
				result = fixedPrice = ReferenceWithMetaPrice.builder();
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
		public FixedForwardPayout.FixedForwardPayoutBuilder setFixedPrice(ReferenceWithMetaPrice fixedPrice) {
			this.fixedPrice = fixedPrice==null?null:fixedPrice.toBuilder();
			return this;
		}
		
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder setFixedPriceValue(Price fixedPrice) {
			this.getOrCreateFixedPrice().setValue(fixedPrice);
			return this;
		}
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public FixedForwardPayout build() {
			return new FixedForwardPayout.FixedForwardPayoutImpl(this);
		}
		
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder prune() {
			super.prune();
			if (fixedPrice!=null && !fixedPrice.prune().hasData()) fixedPrice = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedPrice()!=null && getFixedPrice().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedForwardPayout.FixedForwardPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedForwardPayout.FixedForwardPayoutBuilder o = (FixedForwardPayout.FixedForwardPayoutBuilder) other;
			
			merger.mergeRosetta(getFixedPrice(), o.getFixedPrice(), this::setFixedPrice);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedForwardPayout _that = getType().cast(o);
		
			if (!Objects.equals(fixedPrice, _that.getFixedPrice())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedPrice != null ? fixedPrice.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedForwardPayoutBuilder {" +
				"fixedPrice=" + this.fixedPrice + ", " +
				"paymentDates=" + this.paymentDates +
			'}' + " " + super.toString();
		}
	}
}
