package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.PartyReferencePayerReceiverMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
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

public interface PartyReferencePayerReceiver extends RosettaModelObject {
	PartyReferencePayerReceiver build();
	PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder();
	
	/**
	 * A reference to the account responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaAccount getPayerAccountReference();
	/**
	 * The party responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaParty getPayerPartyReference();
	/**
	 * A reference to the account that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaAccount getReceiverAccountReference();
	/**
	 * The party that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaParty getReceiverPartyReference();
	final static PartyReferencePayerReceiverMeta metaData = new PartyReferencePayerReceiverMeta();
	
	@Override
	default RosettaMetaData<? extends PartyReferencePayerReceiver> metaData() {
		return metaData;
	} 
			
	static PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder() {
		return new PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl();
	}
	
	default Class<? extends PartyReferencePayerReceiver> getType() {
		return PartyReferencePayerReceiver.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccount.class, getPayerAccountReference());
		processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaParty.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccount.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaParty.class, getReceiverPartyReference());
	}
	
	
	interface PartyReferencePayerReceiverBuilder extends PartyReferencePayerReceiver, RosettaModelObjectBuilder {
		ReferenceWithMetaAccountBuilder getOrCreatePayerAccountReference();
		ReferenceWithMetaAccountBuilder getPayerAccountReference();
		ReferenceWithMetaPartyBuilder getOrCreatePayerPartyReference();
		ReferenceWithMetaPartyBuilder getPayerPartyReference();
		ReferenceWithMetaAccountBuilder getOrCreateReceiverAccountReference();
		ReferenceWithMetaAccountBuilder getReceiverAccountReference();
		ReferenceWithMetaPartyBuilder getOrCreateReceiverPartyReference();
		ReferenceWithMetaPartyBuilder getReceiverPartyReference();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReferenceValue(Account payerAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReferenceValue(Party payerPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReferenceValue(Account receiverAccountReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference);
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReferenceValue(Party receiverPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("payerAccountReference"), processor, ReferenceWithMetaAccountBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("payerPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, ReferenceWithMetaAccountBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getReceiverPartyReference());
		}
		
	}
	
	//PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl
	class PartyReferencePayerReceiverImpl implements PartyReferencePayerReceiver {
		private final ReferenceWithMetaAccount payerAccountReference;
		private final ReferenceWithMetaParty payerPartyReference;
		private final ReferenceWithMetaAccount receiverAccountReference;
		private final ReferenceWithMetaParty receiverPartyReference;
		
		protected PartyReferencePayerReceiverImpl(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder) {
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaAccount getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public ReferenceWithMetaParty getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public ReferenceWithMetaAccount getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public ReferenceWithMetaParty getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReferencePayerReceiver build() {
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder builder) {
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyReferencePayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyReferencePayerReceiver {" +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference +
			'}';
		}
	}
	
	//PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilderImpl
	class PartyReferencePayerReceiverBuilderImpl implements PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder {
	
		protected ReferenceWithMetaAccountBuilder payerAccountReference;
		protected ReferenceWithMetaPartyBuilder payerPartyReference;
		protected ReferenceWithMetaAccountBuilder receiverAccountReference;
		protected ReferenceWithMetaPartyBuilder receiverPartyReference;
	
		public PartyReferencePayerReceiverBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaAccountBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreatePayerAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
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
		public ReferenceWithMetaAccountBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateReceiverAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
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
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReference(ReferenceWithMetaAccount payerAccountReference) {
			this.payerAccountReference = payerAccountReference==null?null:payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerAccountReferenceValue(Account payerAccountReference) {
			this.getOrCreatePayerAccountReference().setValue(payerAccountReference);
			return this;
		}
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReference(ReferenceWithMetaParty payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setPayerPartyReferenceValue(Party payerPartyReference) {
			this.getOrCreatePayerPartyReference().setValue(payerPartyReference);
			return this;
		}
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReference(ReferenceWithMetaAccount receiverAccountReference) {
			this.receiverAccountReference = receiverAccountReference==null?null:receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverAccountReferenceValue(Account receiverAccountReference) {
			this.getOrCreateReceiverAccountReference().setValue(receiverAccountReference);
			return this;
		}
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReference(ReferenceWithMetaParty receiverPartyReference) {
			this.receiverPartyReference = receiverPartyReference==null?null:receiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder setReceiverPartyReferenceValue(Party receiverPartyReference) {
			this.getOrCreateReceiverPartyReference().setValue(receiverPartyReference);
			return this;
		}
		
		@Override
		public PartyReferencePayerReceiver build() {
			return new PartyReferencePayerReceiver.PartyReferencePayerReceiverImpl(this);
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder prune() {
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder o = (PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder) other;
			
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyReferencePayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyReferencePayerReceiverBuilder {" +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference +
			'}';
		}
	}
}
