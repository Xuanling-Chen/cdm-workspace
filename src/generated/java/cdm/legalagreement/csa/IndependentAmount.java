package cdm.legalagreement.csa;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legalagreement.csa.meta.IndependentAmountMeta;
import cdm.product.common.settlement.PaymentDetail;
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
 * A class specifying the Independent Amount as the combination of a payer/receiver, a payment amount, a payment date and an associated payment calculation rule.
 * @version ${project.version}
 */
@RosettaClass

public interface IndependentAmount extends PartyReferencePayerReceiver {
	IndependentAmount build();
	IndependentAmount.IndependentAmountBuilder toBuilder();
	
	/**
	 * An attribute that specifies a payment as the combination of a payment amount, a payment date and an associated payment calculation rule.
	 */
	List<? extends PaymentDetail> getPaymentDetail();
	final static IndependentAmountMeta metaData = new IndependentAmountMeta();
	
	@Override
	default RosettaMetaData<? extends IndependentAmount> metaData() {
		return metaData;
	} 
			
	static IndependentAmount.IndependentAmountBuilder builder() {
		return new IndependentAmount.IndependentAmountBuilderImpl();
	}
	
	default Class<? extends IndependentAmount> getType() {
		return IndependentAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.party.PartyReferencePayerReceiver.super.process(path, processor);
		
		processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.class, getPaymentDetail());
	}
	
	
	interface IndependentAmountBuilder extends IndependentAmount, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder, RosettaModelObjectBuilder {
		PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index);
		List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail();
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail, int _idx);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetail);
		IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetail);
		IndependentAmount.IndependentAmountBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference);
		IndependentAmount.IndependentAmountBuilder setPayerAccountReferenceValue(Account payerAccountReference);
		IndependentAmount.IndependentAmountBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		IndependentAmount.IndependentAmountBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		IndependentAmount.IndependentAmountBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference);
		IndependentAmount.IndependentAmountBuilder setReceiverAccountReferenceValue(Account receiverAccountReference);
		IndependentAmount.IndependentAmountBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		IndependentAmount.IndependentAmountBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.PaymentDetailBuilder.class, getPaymentDetail());
		}
		
	}
	
	//IndependentAmount.IndependentAmountImpl
	class IndependentAmountImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl implements IndependentAmount {
		private final List<? extends PaymentDetail> paymentDetail;
		
		protected IndependentAmountImpl(IndependentAmount.IndependentAmountBuilder builder) {
			super(builder);
			this.paymentDetail = ofNullable(builder.getPaymentDetail()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends PaymentDetail> getPaymentDetail() {
			return paymentDetail;
		}
		
		@Override
		public IndependentAmount build() {
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			IndependentAmount.IndependentAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndependentAmount.IndependentAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentDetail()).ifPresent(builder::setPaymentDetail);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmount {" +
				"paymentDetail=" + this.paymentDetail +
			'}' + " " + super.toString();
		}
	}
	
	//IndependentAmount.IndependentAmountBuilderImpl
	class IndependentAmountBuilderImpl extends PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl  implements IndependentAmount.IndependentAmountBuilder {
	
		protected List<PaymentDetail.PaymentDetailBuilder> paymentDetail = new ArrayList<>();
	
		public IndependentAmountBuilderImpl() {
		}
	
		@Override
		public List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail() {
			return paymentDetail;
		}
		
		public PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index) {
		
			if (paymentDetail==null) {
				this.paymentDetail = new ArrayList<>();
			}
			PaymentDetail.PaymentDetailBuilder result;
			return getIndex(paymentDetail, _index, () -> {
						PaymentDetail.PaymentDetailBuilder newPaymentDetail = PaymentDetail.builder();
						return newPaymentDetail;
					});
		}
		
	
		@Override
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail) {
			if (paymentDetail!=null) this.paymentDetail.add(paymentDetail.toBuilder());
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail, int _idx) {
			getIndex(this.paymentDetail, _idx, () -> paymentDetail.toBuilder());
			return this;
		}
		@Override 
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails != null) {
				for (PaymentDetail toAdd : paymentDetails) {
					this.paymentDetail.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails == null)  {
				this.paymentDetail = new ArrayList<>();
			}
			else {
				this.paymentDetail = paymentDetails.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference) {
			this.payerAccountReference = payerAccountReference==null?null:payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerAccountReferenceValue(Account payerAccountReference) {
			this.getOrCreatePayerAccountReference().setValue(payerAccountReference);
			return this;
		}
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setPayerPartyReferenceValue(Party payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(payerPartyReference);
			return this;
		}
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference) {
			this.receiverAccountReference = receiverAccountReference==null?null:receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverAccountReferenceValue(Account receiverAccountReference) {
			this.getOrCreateReceiverAccountReference().setValue(receiverAccountReference);
			return this;
		}
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder setReceiverPartyReferenceValue(Party receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(receiverPartyReference);
			return this;
		}
		
		@Override
		public IndependentAmount build() {
			return new IndependentAmount.IndependentAmountImpl(this);
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder prune() {
			super.prune();
			paymentDetail = paymentDetail.stream().filter(b->b!=null).<PaymentDetail.PaymentDetailBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentDetail()!=null && getPaymentDetail().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IndependentAmount.IndependentAmountBuilder o = (IndependentAmount.IndependentAmountBuilder) other;
			
			merger.mergeRosetta(getPaymentDetail(), o.getPaymentDetail(), this::getOrCreatePaymentDetail);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmountBuilder {" +
				"paymentDetail=" + this.paymentDetail +
			'}' + " " + super.toString();
		}
	}
}
