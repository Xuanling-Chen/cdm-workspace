package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.PayerReceiverMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * Specifies the parties responsible for making and receiving payments defined by this structure.
 * @version ${project.version}
 */
@RosettaClass

public interface PayerReceiver extends RosettaModelObject {
	PayerReceiver build();
	PayerReceiver.PayerReceiverBuilder toBuilder();
	
	/**
	 * Specifies the counterparty responsible for making the payments defined by this structure.  The party is one of the two principal parties to the transaction.
	 */
	CounterpartyRoleEnum getPayer();
	/**
	 * Specifies the ancillary role responsible for making the payments defined by this structure.  Only populated on the cashflow payout when there is a payment to a party which is not one of the two principal parties to the transaction.
	 */
	AncillaryRoleEnum getPayerAncillaryRole();
	/**
	 * Specifies the party responsible for making the payments defined by this structure.  Only populated on physical exercise and cash exercise which do not have the required model structure to specify the counterparties.
	 */
	ReferenceWithMetaParty getPayerPartyReference();
	/**
	 * Specifies the party that receives the payments corresponding to this structure.  The party is one of the two counterparties to the transaction.
	 */
	CounterpartyRoleEnum getReceiver();
	/**
	 * Specifies the ancillary role that receives the payments corresponding to this structure.  Only populated on the cashflow payout when there is a payment to a party which is not one of the two principal parties to the transaction.
	 */
	AncillaryRoleEnum getReceiverAncillaryRole();
	/**
	 * Specifies the party that receives the payments corresponding to this structure.  Only populated on physical exercise and cash exercise which do not have the required model structure to specify the counterparties.
	 */
	ReferenceWithMetaParty getReceiverPartyReference();
	final static PayerReceiverMeta metaData = new PayerReceiverMeta();
	
	@Override
	default RosettaMetaData<? extends PayerReceiver> metaData() {
		return metaData;
	} 
			
	static PayerReceiver.PayerReceiverBuilder builder() {
		return new PayerReceiver.PayerReceiverBuilderImpl();
	}
	
	default Class<? extends PayerReceiver> getType() {
		return PayerReceiver.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("payer"), CounterpartyRoleEnum.class, getPayer(), this);
		processor.processBasic(path.newSubPath("payerAncillaryRole"), AncillaryRoleEnum.class, getPayerAncillaryRole(), this);
		processor.processBasic(path.newSubPath("receiver"), CounterpartyRoleEnum.class, getReceiver(), this);
		processor.processBasic(path.newSubPath("receiverAncillaryRole"), AncillaryRoleEnum.class, getReceiverAncillaryRole(), this);
		
		processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.class, getReceiverPartyReference());
	}
	
	
	interface PayerReceiverBuilder extends PayerReceiver, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreatePayerPartyReference();
		ReferenceWithMetaPartyBuilder getPayerPartyReference();
		ReferenceWithMetaPartyBuilder getOrCreateReceiverPartyReference();
		ReferenceWithMetaPartyBuilder getReceiverPartyReference();
		PayerReceiver.PayerReceiverBuilder setPayer(CounterpartyRoleEnum payer);
		PayerReceiver.PayerReceiverBuilder setPayerAncillaryRole(AncillaryRoleEnum payerAncillaryRole);
		PayerReceiver.PayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		PayerReceiver.PayerReceiverBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		PayerReceiver.PayerReceiverBuilder setReceiver(CounterpartyRoleEnum receiver);
		PayerReceiver.PayerReceiverBuilder setReceiverAncillaryRole(AncillaryRoleEnum receiverAncillaryRole);
		PayerReceiver.PayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		PayerReceiver.PayerReceiverBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("payer"), CounterpartyRoleEnum.class, getPayer(), this);
			processor.processBasic(path.newSubPath("payerAncillaryRole"), AncillaryRoleEnum.class, getPayerAncillaryRole(), this);
			processor.processBasic(path.newSubPath("receiver"), CounterpartyRoleEnum.class, getReceiver(), this);
			processor.processBasic(path.newSubPath("receiverAncillaryRole"), AncillaryRoleEnum.class, getReceiverAncillaryRole(), this);
			
			processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getReceiverPartyReference());
		}
		
	}
	
	//PayerReceiver.PayerReceiverImpl
	class PayerReceiverImpl implements PayerReceiver {
		private final CounterpartyRoleEnum payer;
		private final AncillaryRoleEnum payerAncillaryRole;
		private final ReferenceWithMetaParty payerPartyReference;
		private final CounterpartyRoleEnum receiver;
		private final AncillaryRoleEnum receiverAncillaryRole;
		private final ReferenceWithMetaParty receiverPartyReference;
		
		protected PayerReceiverImpl(PayerReceiver.PayerReceiverBuilder builder) {
			this.payer = builder.getPayer();
			this.payerAncillaryRole = builder.getPayerAncillaryRole();
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiver = builder.getReceiver();
			this.receiverAncillaryRole = builder.getReceiverAncillaryRole();
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CounterpartyRoleEnum getPayer() {
			return payer;
		}
		
		@Override
		public AncillaryRoleEnum getPayerAncillaryRole() {
			return payerAncillaryRole;
		}
		
		@Override
		public ReferenceWithMetaParty getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public CounterpartyRoleEnum getReceiver() {
			return receiver;
		}
		
		@Override
		public AncillaryRoleEnum getReceiverAncillaryRole() {
			return receiverAncillaryRole;
		}
		
		@Override
		public ReferenceWithMetaParty getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PayerReceiver build() {
			return this;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder toBuilder() {
			PayerReceiver.PayerReceiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayerReceiver.PayerReceiverBuilder builder) {
			ofNullable(getPayer()).ifPresent(builder::setPayer);
			ofNullable(getPayerAncillaryRole()).ifPresent(builder::setPayerAncillaryRole);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiver()).ifPresent(builder::setReceiver);
			ofNullable(getReceiverAncillaryRole()).ifPresent(builder::setReceiverAncillaryRole);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payer, _that.getPayer())) return false;
			if (!Objects.equals(payerAncillaryRole, _that.getPayerAncillaryRole())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(receiverAncillaryRole, _that.getReceiverAncillaryRole())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payer != null ? payer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerAncillaryRole != null ? payerAncillaryRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverAncillaryRole != null ? receiverAncillaryRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerReceiver {" +
				"payer=" + this.payer + ", " +
				"payerAncillaryRole=" + this.payerAncillaryRole + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiver=" + this.receiver + ", " +
				"receiverAncillaryRole=" + this.receiverAncillaryRole + ", " +
				"receiverPartyReference=" + this.receiverPartyReference +
			'}';
		}
	}
	
	//PayerReceiver.PayerReceiverBuilderImpl
	class PayerReceiverBuilderImpl implements PayerReceiver.PayerReceiverBuilder {
	
		protected CounterpartyRoleEnum payer;
		protected AncillaryRoleEnum payerAncillaryRole;
		protected ReferenceWithMetaPartyBuilder payerPartyReference;
		protected CounterpartyRoleEnum receiver;
		protected AncillaryRoleEnum receiverAncillaryRole;
		protected ReferenceWithMetaPartyBuilder receiverPartyReference;
	
		public PayerReceiverBuilderImpl() {
		}
	
		@Override
		public CounterpartyRoleEnum getPayer() {
			return payer;
		}
		
		@Override
		public AncillaryRoleEnum getPayerAncillaryRole() {
			return payerAncillaryRole;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePayerPartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public CounterpartyRoleEnum getReceiver() {
			return receiver;
		}
		
		@Override
		public AncillaryRoleEnum getReceiverAncillaryRole() {
			return receiverAncillaryRole;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateReceiverPartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PayerReceiver.PayerReceiverBuilder setPayer(CounterpartyRoleEnum payer) {
			this.payer = payer==null?null:payer;
			return this;
		}
		@Override
		public PayerReceiver.PayerReceiverBuilder setPayerAncillaryRole(AncillaryRoleEnum payerAncillaryRole) {
			this.payerAncillaryRole = payerAncillaryRole==null?null:payerAncillaryRole;
			return this;
		}
		@Override
		public PayerReceiver.PayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder setPayerPartyReferenceValue(Party payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(payerPartyReference);
			return this;
		}
		@Override
		public PayerReceiver.PayerReceiverBuilder setReceiver(CounterpartyRoleEnum receiver) {
			this.receiver = receiver==null?null:receiver;
			return this;
		}
		@Override
		public PayerReceiver.PayerReceiverBuilder setReceiverAncillaryRole(AncillaryRoleEnum receiverAncillaryRole) {
			this.receiverAncillaryRole = receiverAncillaryRole==null?null:receiverAncillaryRole;
			return this;
		}
		@Override
		public PayerReceiver.PayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder setReceiverPartyReferenceValue(Party receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(receiverPartyReference);
			return this;
		}
		
		@Override
		public PayerReceiver build() {
			return new PayerReceiver.PayerReceiverImpl(this);
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerReceiver.PayerReceiverBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayer()!=null) return true;
			if (getPayerAncillaryRole()!=null) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiver()!=null) return true;
			if (getReceiverAncillaryRole()!=null) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerReceiver.PayerReceiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PayerReceiver.PayerReceiverBuilder o = (PayerReceiver.PayerReceiverBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			
			merger.mergeBasic(getPayer(), o.getPayer(), this::setPayer);
			merger.mergeBasic(getPayerAncillaryRole(), o.getPayerAncillaryRole(), this::setPayerAncillaryRole);
			merger.mergeBasic(getReceiver(), o.getReceiver(), this::setReceiver);
			merger.mergeBasic(getReceiverAncillaryRole(), o.getReceiverAncillaryRole(), this::setReceiverAncillaryRole);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payer, _that.getPayer())) return false;
			if (!Objects.equals(payerAncillaryRole, _that.getPayerAncillaryRole())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(receiverAncillaryRole, _that.getReceiverAncillaryRole())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payer != null ? payer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerAncillaryRole != null ? payerAncillaryRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverAncillaryRole != null ? receiverAncillaryRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerReceiverBuilder {" +
				"payer=" + this.payer + ", " +
				"payerAncillaryRole=" + this.payerAncillaryRole + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiver=" + this.receiver + ", " +
				"receiverAncillaryRole=" + this.receiverAncillaryRole + ", " +
				"receiverPartyReference=" + this.receiverPartyReference +
			'}';
		}
	}
}
