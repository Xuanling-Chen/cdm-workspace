package cdm.event.common;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.event.common.meta.TransferorTransfereeMeta;
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
 * A class mimicking the PartyReferencePayerReceiver, which is itself derived from the FpML PayerReceiver.model, to represent the transferee and transferor party information in relation to the transfer of security or commodities.
 * @version ${project.version}
 */
@RosettaClass

public interface TransferorTransferee extends RosettaModelObject {
	TransferorTransferee build();
	TransferorTransferee.TransferorTransfereeBuilder toBuilder();
	
	/**
	 * A reference to the account that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaAccount getTransfereeAccountReference();
	/**
	 * A reference to the party that receives the payments corresponding to this structure.
	 */
	ReferenceWithMetaParty getTransfereePartyReference();
	/**
	 * A reference to the account responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaAccount getTransferorAccountReference();
	/**
	 * A reference to the party responsible for making the payments defined by this structure.
	 */
	ReferenceWithMetaParty getTransferorPartyReference();
	final static TransferorTransfereeMeta metaData = new TransferorTransfereeMeta();
	
	@Override
	default RosettaMetaData<? extends TransferorTransferee> metaData() {
		return metaData;
	} 
			
	static TransferorTransferee.TransferorTransfereeBuilder builder() {
		return new TransferorTransferee.TransferorTransfereeBuilderImpl();
	}
	
	default Class<? extends TransferorTransferee> getType() {
		return TransferorTransferee.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("transfereeAccountReference"), processor, ReferenceWithMetaAccount.class, getTransfereeAccountReference());
		processRosetta(path.newSubPath("transfereePartyReference"), processor, ReferenceWithMetaParty.class, getTransfereePartyReference());
		processRosetta(path.newSubPath("transferorAccountReference"), processor, ReferenceWithMetaAccount.class, getTransferorAccountReference());
		processRosetta(path.newSubPath("transferorPartyReference"), processor, ReferenceWithMetaParty.class, getTransferorPartyReference());
	}
	
	
	interface TransferorTransfereeBuilder extends TransferorTransferee, RosettaModelObjectBuilder {
		ReferenceWithMetaAccountBuilder getOrCreateTransfereeAccountReference();
		ReferenceWithMetaAccountBuilder getTransfereeAccountReference();
		ReferenceWithMetaPartyBuilder getOrCreateTransfereePartyReference();
		ReferenceWithMetaPartyBuilder getTransfereePartyReference();
		ReferenceWithMetaAccountBuilder getOrCreateTransferorAccountReference();
		ReferenceWithMetaAccountBuilder getTransferorAccountReference();
		ReferenceWithMetaPartyBuilder getOrCreateTransferorPartyReference();
		ReferenceWithMetaPartyBuilder getTransferorPartyReference();
		TransferorTransferee.TransferorTransfereeBuilder setTransfereeAccountReference(ReferenceWithMetaAccount transfereeAccountReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransfereeAccountReferenceValue(Account transfereeAccountReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransfereePartyReference(ReferenceWithMetaParty transfereePartyReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransfereePartyReferenceValue(Party transfereePartyReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransferorAccountReference(ReferenceWithMetaAccount transferorAccountReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransferorAccountReferenceValue(Account transferorAccountReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransferorPartyReference(ReferenceWithMetaParty transferorPartyReference);
		TransferorTransferee.TransferorTransfereeBuilder setTransferorPartyReferenceValue(Party transferorPartyReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("transfereeAccountReference"), processor, ReferenceWithMetaAccountBuilder.class, getTransfereeAccountReference());
			processRosetta(path.newSubPath("transfereePartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getTransfereePartyReference());
			processRosetta(path.newSubPath("transferorAccountReference"), processor, ReferenceWithMetaAccountBuilder.class, getTransferorAccountReference());
			processRosetta(path.newSubPath("transferorPartyReference"), processor, ReferenceWithMetaPartyBuilder.class, getTransferorPartyReference());
		}
		
	}
	
	//TransferorTransferee.TransferorTransfereeImpl
	class TransferorTransfereeImpl implements TransferorTransferee {
		private final ReferenceWithMetaAccount transfereeAccountReference;
		private final ReferenceWithMetaParty transfereePartyReference;
		private final ReferenceWithMetaAccount transferorAccountReference;
		private final ReferenceWithMetaParty transferorPartyReference;
		
		protected TransferorTransfereeImpl(TransferorTransferee.TransferorTransfereeBuilder builder) {
			this.transfereeAccountReference = ofNullable(builder.getTransfereeAccountReference()).map(f->f.build()).orElse(null);
			this.transfereePartyReference = ofNullable(builder.getTransfereePartyReference()).map(f->f.build()).orElse(null);
			this.transferorAccountReference = ofNullable(builder.getTransferorAccountReference()).map(f->f.build()).orElse(null);
			this.transferorPartyReference = ofNullable(builder.getTransferorPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaAccount getTransfereeAccountReference() {
			return transfereeAccountReference;
		}
		
		@Override
		public ReferenceWithMetaParty getTransfereePartyReference() {
			return transfereePartyReference;
		}
		
		@Override
		public ReferenceWithMetaAccount getTransferorAccountReference() {
			return transferorAccountReference;
		}
		
		@Override
		public ReferenceWithMetaParty getTransferorPartyReference() {
			return transferorPartyReference;
		}
		
		@Override
		public TransferorTransferee build() {
			return this;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder toBuilder() {
			TransferorTransferee.TransferorTransfereeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferorTransferee.TransferorTransfereeBuilder builder) {
			ofNullable(getTransfereeAccountReference()).ifPresent(builder::setTransfereeAccountReference);
			ofNullable(getTransfereePartyReference()).ifPresent(builder::setTransfereePartyReference);
			ofNullable(getTransferorAccountReference()).ifPresent(builder::setTransferorAccountReference);
			ofNullable(getTransferorPartyReference()).ifPresent(builder::setTransferorPartyReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferorTransferee _that = getType().cast(o);
		
			if (!Objects.equals(transfereeAccountReference, _that.getTransfereeAccountReference())) return false;
			if (!Objects.equals(transfereePartyReference, _that.getTransfereePartyReference())) return false;
			if (!Objects.equals(transferorAccountReference, _that.getTransferorAccountReference())) return false;
			if (!Objects.equals(transferorPartyReference, _that.getTransferorPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transfereeAccountReference != null ? transfereeAccountReference.hashCode() : 0);
			_result = 31 * _result + (transfereePartyReference != null ? transfereePartyReference.hashCode() : 0);
			_result = 31 * _result + (transferorAccountReference != null ? transferorAccountReference.hashCode() : 0);
			_result = 31 * _result + (transferorPartyReference != null ? transferorPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferorTransferee {" +
				"transfereeAccountReference=" + this.transfereeAccountReference + ", " +
				"transfereePartyReference=" + this.transfereePartyReference + ", " +
				"transferorAccountReference=" + this.transferorAccountReference + ", " +
				"transferorPartyReference=" + this.transferorPartyReference +
			'}';
		}
	}
	
	//TransferorTransferee.TransferorTransfereeBuilderImpl
	class TransferorTransfereeBuilderImpl implements TransferorTransferee.TransferorTransfereeBuilder {
	
		protected ReferenceWithMetaAccountBuilder transfereeAccountReference;
		protected ReferenceWithMetaPartyBuilder transfereePartyReference;
		protected ReferenceWithMetaAccountBuilder transferorAccountReference;
		protected ReferenceWithMetaPartyBuilder transferorPartyReference;
	
		public TransferorTransfereeBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaAccountBuilder getTransfereeAccountReference() {
			return transfereeAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateTransfereeAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (transfereeAccountReference!=null) {
				result = transfereeAccountReference;
			}
			else {
				result = transfereeAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getTransfereePartyReference() {
			return transfereePartyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateTransfereePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (transfereePartyReference!=null) {
				result = transfereePartyReference;
			}
			else {
				result = transfereePartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getTransferorAccountReference() {
			return transferorAccountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateTransferorAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (transferorAccountReference!=null) {
				result = transferorAccountReference;
			}
			else {
				result = transferorAccountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getTransferorPartyReference() {
			return transferorPartyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateTransferorPartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (transferorPartyReference!=null) {
				result = transferorPartyReference;
			}
			else {
				result = transferorPartyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransfereeAccountReference(ReferenceWithMetaAccount transfereeAccountReference) {
			this.transfereeAccountReference = transfereeAccountReference==null?null:transfereeAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransfereeAccountReferenceValue(Account transfereeAccountReference) {
			this.getOrCreateTransfereeAccountReference().setValue(transfereeAccountReference);
			return this;
		}
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransfereePartyReference(ReferenceWithMetaParty transfereePartyReference) {
			this.transfereePartyReference = transfereePartyReference==null?null:transfereePartyReference.toBuilder();
			return this;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransfereePartyReferenceValue(Party transfereePartyReference) {
			this.getOrCreateTransfereePartyReference().setValue(transfereePartyReference);
			return this;
		}
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransferorAccountReference(ReferenceWithMetaAccount transferorAccountReference) {
			this.transferorAccountReference = transferorAccountReference==null?null:transferorAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransferorAccountReferenceValue(Account transferorAccountReference) {
			this.getOrCreateTransferorAccountReference().setValue(transferorAccountReference);
			return this;
		}
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransferorPartyReference(ReferenceWithMetaParty transferorPartyReference) {
			this.transferorPartyReference = transferorPartyReference==null?null:transferorPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder setTransferorPartyReferenceValue(Party transferorPartyReference) {
			this.getOrCreateTransferorPartyReference().setValue(transferorPartyReference);
			return this;
		}
		
		@Override
		public TransferorTransferee build() {
			return new TransferorTransferee.TransferorTransfereeImpl(this);
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder prune() {
			if (transfereeAccountReference!=null && !transfereeAccountReference.prune().hasData()) transfereeAccountReference = null;
			if (transfereePartyReference!=null && !transfereePartyReference.prune().hasData()) transfereePartyReference = null;
			if (transferorAccountReference!=null && !transferorAccountReference.prune().hasData()) transferorAccountReference = null;
			if (transferorPartyReference!=null && !transferorPartyReference.prune().hasData()) transferorPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransfereeAccountReference()!=null && getTransfereeAccountReference().hasData()) return true;
			if (getTransfereePartyReference()!=null && getTransfereePartyReference().hasData()) return true;
			if (getTransferorAccountReference()!=null && getTransferorAccountReference().hasData()) return true;
			if (getTransferorPartyReference()!=null && getTransferorPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferorTransferee.TransferorTransfereeBuilder o = (TransferorTransferee.TransferorTransfereeBuilder) other;
			
			merger.mergeRosetta(getTransfereeAccountReference(), o.getTransfereeAccountReference(), this::setTransfereeAccountReference);
			merger.mergeRosetta(getTransfereePartyReference(), o.getTransfereePartyReference(), this::setTransfereePartyReference);
			merger.mergeRosetta(getTransferorAccountReference(), o.getTransferorAccountReference(), this::setTransferorAccountReference);
			merger.mergeRosetta(getTransferorPartyReference(), o.getTransferorPartyReference(), this::setTransferorPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferorTransferee _that = getType().cast(o);
		
			if (!Objects.equals(transfereeAccountReference, _that.getTransfereeAccountReference())) return false;
			if (!Objects.equals(transfereePartyReference, _that.getTransfereePartyReference())) return false;
			if (!Objects.equals(transferorAccountReference, _that.getTransferorAccountReference())) return false;
			if (!Objects.equals(transferorPartyReference, _that.getTransferorPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transfereeAccountReference != null ? transfereeAccountReference.hashCode() : 0);
			_result = 31 * _result + (transfereePartyReference != null ? transfereePartyReference.hashCode() : 0);
			_result = 31 * _result + (transferorAccountReference != null ? transferorAccountReference.hashCode() : 0);
			_result = 31 * _result + (transferorPartyReference != null ? transferorPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferorTransfereeBuilder {" +
				"transfereeAccountReference=" + this.transfereeAccountReference + ", " +
				"transfereePartyReference=" + this.transfereePartyReference + ", " +
				"transferorAccountReference=" + this.transferorAccountReference + ", " +
				"transferorPartyReference=" + this.transferorPartyReference +
			'}';
		}
	}
}
