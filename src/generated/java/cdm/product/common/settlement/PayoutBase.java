package cdm.product.common.settlement;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.common.settlement.meta.PayoutBaseMeta;
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
 *  Base class that all payout types should extend. Use case is that some validation rules may need to apply across all payout types, for which the data rule can be written at the base class level
 * @version ${project.version}
 */
@RosettaClass

public interface PayoutBase extends RosettaModelObject {
	PayoutBase build();
	PayoutBase.PayoutBaseBuilder toBuilder();
	
	/**
	 * Canonical representation of the payer and receiver parties applicable to each payout leg.
	 */
	PayerReceiver getPayerReceiver();
	/**
	 * Each payout leg must implement the quantity concept as a &#39;resolvable&#39; type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
	 */
	ResolvablePayoutQuantity getPayoutQuantity();
	/**
	 * Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
	 */
	SettlementTerms getSettlementTerms();
	final static PayoutBaseMeta metaData = new PayoutBaseMeta();
	
	@Override
	default RosettaMetaData<? extends PayoutBase> metaData() {
		return metaData;
	} 
			
	static PayoutBase.PayoutBaseBuilder builder() {
		return new PayoutBase.PayoutBaseBuilderImpl();
	}
	
	default Class<? extends PayoutBase> getType() {
		return PayoutBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("payoutQuantity"), processor, ResolvablePayoutQuantity.class, getPayoutQuantity());
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
	}
	
	
	interface PayoutBaseBuilder extends PayoutBase, RosettaModelObjectBuilder {
		PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver();
		PayerReceiver.PayerReceiverBuilder getPayerReceiver();
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder getOrCreatePayoutQuantity();
		ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder getPayoutQuantity();
		SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms();
		SettlementTerms.SettlementTermsBuilder getSettlementTerms();
		PayoutBase.PayoutBaseBuilder setPayerReceiver(PayerReceiver payerReceiver);
		PayoutBase.PayoutBaseBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		PayoutBase.PayoutBaseBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("payoutQuantity"), processor, ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder.class, getPayoutQuantity());
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
		}
		
	}
	
	//PayoutBase.PayoutBaseImpl
	class PayoutBaseImpl implements PayoutBase {
		private final PayerReceiver payerReceiver;
		private final ResolvablePayoutQuantity payoutQuantity;
		private final SettlementTerms settlementTerms;
		
		protected PayoutBaseImpl(PayoutBase.PayoutBaseBuilder builder) {
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.payoutQuantity = ofNullable(builder.getPayoutQuantity()).map(f->f.build()).orElse(null);
			this.settlementTerms = ofNullable(builder.getSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public PayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public ResolvablePayoutQuantity getPayoutQuantity() {
			return payoutQuantity;
		}
		
		@Override
		public SettlementTerms getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public PayoutBase build() {
			return this;
		}
		
		@Override
		public PayoutBase.PayoutBaseBuilder toBuilder() {
			PayoutBase.PayoutBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayoutBase.PayoutBaseBuilder builder) {
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getPayoutQuantity()).ifPresent(builder::setPayoutQuantity);
			ofNullable(getSettlementTerms()).ifPresent(builder::setSettlementTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayoutBase _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(payoutQuantity, _that.getPayoutQuantity())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (payoutQuantity != null ? payoutQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutBase {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"payoutQuantity=" + this.payoutQuantity + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}';
		}
	}
	
	//PayoutBase.PayoutBaseBuilderImpl
	class PayoutBaseBuilderImpl implements PayoutBase.PayoutBaseBuilder {
	
		protected PayerReceiver.PayerReceiverBuilder payerReceiver;
		protected ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder payoutQuantity;
		protected SettlementTerms.SettlementTermsBuilder settlementTerms;
	
		public PayoutBaseBuilderImpl() {
		}
	
		@Override
		public PayerReceiver.PayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver() {
			PayerReceiver.PayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder getPayoutQuantity() {
			return payoutQuantity;
		}
		
		@Override
		public ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder getOrCreatePayoutQuantity() {
			ResolvablePayoutQuantity.ResolvablePayoutQuantityBuilder result;
			if (payoutQuantity!=null) {
				result = payoutQuantity;
			}
			else {
				result = payoutQuantity = ResolvablePayoutQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms() {
			SettlementTerms.SettlementTermsBuilder result;
			if (settlementTerms!=null) {
				result = settlementTerms;
			}
			else {
				result = settlementTerms = SettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PayoutBase.PayoutBaseBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public PayoutBase.PayoutBaseBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public PayoutBase.PayoutBaseBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public PayoutBase build() {
			return new PayoutBase.PayoutBaseImpl(this);
		}
		
		@Override
		public PayoutBase.PayoutBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutBase.PayoutBaseBuilder prune() {
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (payoutQuantity!=null && !payoutQuantity.prune().hasData()) payoutQuantity = null;
			if (settlementTerms!=null && !settlementTerms.prune().hasData()) settlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getPayoutQuantity()!=null && getPayoutQuantity().hasData()) return true;
			if (getSettlementTerms()!=null && getSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutBase.PayoutBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PayoutBase.PayoutBaseBuilder o = (PayoutBase.PayoutBaseBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getPayoutQuantity(), o.getPayoutQuantity(), this::setPayoutQuantity);
			merger.mergeRosetta(getSettlementTerms(), o.getSettlementTerms(), this::setSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayoutBase _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(payoutQuantity, _that.getPayoutQuantity())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (payoutQuantity != null ? payoutQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutBaseBuilder {" +
				"payerReceiver=" + this.payerReceiver + ", " +
				"payoutQuantity=" + this.payoutQuantity + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}';
		}
	}
}
