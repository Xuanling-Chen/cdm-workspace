package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.RelatedPartyMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface RelatedParty extends RosettaModelObject {
	RelatedParty build();
	RelatedParty.RelatedPartyBuilder toBuilder();
	
	/**
	 * Reference to an account.
	 */
	ReferenceWithMetaAccount getAccountReference();
	/**
	 * Reference to a party.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is ,Guarantor, the related party acts as a guarantor for the base party.
	 */
	PartyRoleEnum getRole();
	final static RelatedPartyMeta metaData = new RelatedPartyMeta();
	
	@Override
	default RosettaMetaData<? extends RelatedParty> metaData() {
		return metaData;
	} 
			
	static RelatedParty.RelatedPartyBuilder builder() {
		return new RelatedParty.RelatedPartyBuilderImpl();
	}
	
	default Class<? extends RelatedParty> getType() {
		return RelatedParty.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("role"), PartyRoleEnum.class, getRole(), this);
		
		processRosetta(path.newSubPath("accountReference"), processor, ReferenceWithMetaAccount.class, getAccountReference());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
	}
	
	
	interface RelatedPartyBuilder extends RelatedParty, RosettaModelObjectBuilder {
		ReferenceWithMetaAccountBuilder getOrCreateAccountReference();
		ReferenceWithMetaAccountBuilder getAccountReference();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		RelatedParty.RelatedPartyBuilder setAccountReference(ReferenceWithMetaAccount accountReference);
		RelatedParty.RelatedPartyBuilder setAccountReferenceValue(Account accountReference);
		RelatedParty.RelatedPartyBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		RelatedParty.RelatedPartyBuilder setPartyReferenceValue(Party partyReference);
		RelatedParty.RelatedPartyBuilder setRole(PartyRoleEnum role);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("role"), PartyRoleEnum.class, getRole(), this);
			
			processRosetta(path.newSubPath("accountReference"), processor, ReferenceWithMetaAccountBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
		}
		
	}
	
	//RelatedParty.RelatedPartyImpl
	class RelatedPartyImpl implements RelatedParty {
		private final ReferenceWithMetaAccount accountReference;
		private final ReferenceWithMetaParty partyReference;
		private final PartyRoleEnum role;
		
		protected RelatedPartyImpl(RelatedParty.RelatedPartyBuilder builder) {
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.role = builder.getRole();
		}
		
		@Override
		public ReferenceWithMetaAccount getAccountReference() {
			return accountReference;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyRoleEnum getRole() {
			return role;
		}
		
		@Override
		public RelatedParty build() {
			return this;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			RelatedParty.RelatedPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedParty.RelatedPartyBuilder builder) {
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedParty {" +
				"accountReference=" + this.accountReference + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
	
	//RelatedParty.RelatedPartyBuilderImpl
	class RelatedPartyBuilderImpl implements RelatedParty.RelatedPartyBuilder {
	
		protected ReferenceWithMetaAccountBuilder accountReference;
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected PartyRoleEnum role;
	
		public RelatedPartyBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaAccountBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public PartyRoleEnum getRole() {
			return role;
		}
		
	
		@Override
		public RelatedParty.RelatedPartyBuilder setAccountReference(ReferenceWithMetaAccount accountReference) {
			this.accountReference = accountReference==null?null:accountReference.toBuilder();
			return this;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder setAccountReferenceValue(Account accountReference) {
			this.getOrCreateAccountReference().setValue(accountReference);
			return this;
		}
		@Override
		public RelatedParty.RelatedPartyBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public RelatedParty.RelatedPartyBuilder setRole(PartyRoleEnum role) {
			this.role = role==null?null:role;
			return this;
		}
		
		@Override
		public RelatedParty build() {
			return new RelatedParty.RelatedPartyImpl(this);
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder prune() {
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRole()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedParty.RelatedPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedParty.RelatedPartyBuilder o = (RelatedParty.RelatedPartyBuilder) other;
			
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			
			merger.mergeBasic(getRole(), o.getRole(), this::setRole);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedParty _that = getType().cast(o);
		
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedPartyBuilder {" +
				"accountReference=" + this.accountReference + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
