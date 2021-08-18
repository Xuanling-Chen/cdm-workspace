package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.AccountMeta;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify an account as an account number alongside, optionally. an account name, an account type, an account beneficiary and a servicing party.
 * @version ${project.version}
 */
@RosettaClass

public interface Account extends RosettaModelObject, GlobalKey {
	Account build();
	Account.AccountBuilder toBuilder();
	
	/**
	 * A reference to the party beneficiary of the account.
	 */
	ReferenceWithMetaParty getAccountBeneficiary();
	/**
	 * The name by which the account is known.
	 */
	FieldWithMetaString getAccountName();
	/**
	 * The account number.
	 */
	FieldWithMetaString getAccountNumber();
	/**
	 * The type of account, e.g. client, house.
	 */
	FieldWithMetaAccountTypeEnum getAccountType();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A reference to the party to which the account refers to.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * The reference to the legal entity that services the account, i.e. in the books of which the account is held.
	 */
	ReferenceWithMetaParty getServicingParty();
	final static AccountMeta metaData = new AccountMeta();
	
	@Override
	default RosettaMetaData<? extends Account> metaData() {
		return metaData;
	} 
			
	static Account.AccountBuilder builder() {
		return new Account.AccountBuilderImpl();
	}
	
	default Class<? extends Account> getType() {
		return Account.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("accountBeneficiary"), processor, ReferenceWithMetaParty.class, getAccountBeneficiary());
		processRosetta(path.newSubPath("accountName"), processor, FieldWithMetaString.class, getAccountName());
		processRosetta(path.newSubPath("accountNumber"), processor, FieldWithMetaString.class, getAccountNumber());
		processRosetta(path.newSubPath("accountType"), processor, FieldWithMetaAccountTypeEnum.class, getAccountType());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processRosetta(path.newSubPath("servicingParty"), processor, ReferenceWithMetaParty.class, getServicingParty());
	}
	
	
	interface AccountBuilder extends Account, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreateAccountBeneficiary();
		ReferenceWithMetaPartyBuilder getAccountBeneficiary();
		FieldWithMetaStringBuilder getOrCreateAccountName();
		FieldWithMetaStringBuilder getAccountName();
		FieldWithMetaStringBuilder getOrCreateAccountNumber();
		FieldWithMetaStringBuilder getAccountNumber();
		FieldWithMetaAccountTypeEnumBuilder getOrCreateAccountType();
		FieldWithMetaAccountTypeEnumBuilder getAccountType();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		ReferenceWithMetaPartyBuilder getOrCreateServicingParty();
		ReferenceWithMetaPartyBuilder getServicingParty();
		Account.AccountBuilder setAccountBeneficiary(ReferenceWithMetaParty accountBeneficiary);
		Account.AccountBuilder setAccountBeneficiaryValue(Party accountBeneficiary);
		Account.AccountBuilder setAccountName(FieldWithMetaString accountName);
		Account.AccountBuilder setAccountNameValue(String accountName);
		Account.AccountBuilder setAccountNumber(FieldWithMetaString accountNumber);
		Account.AccountBuilder setAccountNumberValue(String accountNumber);
		Account.AccountBuilder setAccountType(FieldWithMetaAccountTypeEnum accountType);
		Account.AccountBuilder setAccountTypeValue(AccountTypeEnum accountType);
		Account.AccountBuilder setMeta(MetaFields meta);
		Account.AccountBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		Account.AccountBuilder setPartyReferenceValue(Party partyReference);
		Account.AccountBuilder setServicingParty(ReferenceWithMetaParty servicingParty);
		Account.AccountBuilder setServicingPartyValue(Party servicingParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("accountBeneficiary"), processor, ReferenceWithMetaPartyBuilder.class, getAccountBeneficiary());
			processRosetta(path.newSubPath("accountName"), processor, FieldWithMetaStringBuilder.class, getAccountName());
			processRosetta(path.newSubPath("accountNumber"), processor, FieldWithMetaStringBuilder.class, getAccountNumber());
			processRosetta(path.newSubPath("accountType"), processor, FieldWithMetaAccountTypeEnumBuilder.class, getAccountType());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("servicingParty"), processor, ReferenceWithMetaPartyBuilder.class, getServicingParty());
		}
		
	}
	
	//Account.AccountImpl
	class AccountImpl implements Account {
		private final ReferenceWithMetaParty accountBeneficiary;
		private final FieldWithMetaString accountName;
		private final FieldWithMetaString accountNumber;
		private final FieldWithMetaAccountTypeEnum accountType;
		private final MetaFields meta;
		private final ReferenceWithMetaParty partyReference;
		private final ReferenceWithMetaParty servicingParty;
		
		protected AccountImpl(Account.AccountBuilder builder) {
			this.accountBeneficiary = ofNullable(builder.getAccountBeneficiary()).map(f->f.build()).orElse(null);
			this.accountName = ofNullable(builder.getAccountName()).map(f->f.build()).orElse(null);
			this.accountNumber = ofNullable(builder.getAccountNumber()).map(f->f.build()).orElse(null);
			this.accountType = ofNullable(builder.getAccountType()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.servicingParty = ofNullable(builder.getServicingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaParty getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		public FieldWithMetaString getAccountName() {
			return accountName;
		}
		
		@Override
		public FieldWithMetaString getAccountNumber() {
			return accountNumber;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnum getAccountType() {
			return accountType;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaParty getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public Account build() {
			return this;
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			Account.AccountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Account.AccountBuilder builder) {
			ofNullable(getAccountBeneficiary()).ifPresent(builder::setAccountBeneficiary);
			ofNullable(getAccountName()).ifPresent(builder::setAccountName);
			ofNullable(getAccountNumber()).ifPresent(builder::setAccountNumber);
			ofNullable(getAccountType()).ifPresent(builder::setAccountType);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getServicingParty()).ifPresent(builder::setServicingParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountNumber, _that.getAccountNumber())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountNumber != null ? accountNumber.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Account {" +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"accountName=" + this.accountName + ", " +
				"accountNumber=" + this.accountNumber + ", " +
				"accountType=" + this.accountType + ", " +
				"meta=" + this.meta + ", " +
				"partyReference=" + this.partyReference + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}
	
	//Account.AccountBuilderImpl
	class AccountBuilderImpl implements Account.AccountBuilder, GlobalKeyBuilder {
	
		protected ReferenceWithMetaPartyBuilder accountBeneficiary;
		protected FieldWithMetaStringBuilder accountName;
		protected FieldWithMetaStringBuilder accountNumber;
		protected FieldWithMetaAccountTypeEnumBuilder accountType;
		protected MetaFields.MetaFieldsBuilder meta;
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected ReferenceWithMetaPartyBuilder servicingParty;
	
		public AccountBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPartyBuilder getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateAccountBeneficiary() {
			ReferenceWithMetaPartyBuilder result;
			if (accountBeneficiary!=null) {
				result = accountBeneficiary;
			}
			else {
				result = accountBeneficiary = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getAccountName() {
			return accountName;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateAccountName() {
			FieldWithMetaStringBuilder result;
			if (accountName!=null) {
				result = accountName;
			}
			else {
				result = accountName = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getAccountNumber() {
			return accountNumber;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateAccountNumber() {
			FieldWithMetaStringBuilder result;
			if (accountNumber!=null) {
				result = accountNumber;
			}
			else {
				result = accountNumber = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnumBuilder getAccountType() {
			return accountType;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnumBuilder getOrCreateAccountType() {
			FieldWithMetaAccountTypeEnumBuilder result;
			if (accountType!=null) {
				result = accountType;
			}
			else {
				result = accountType = FieldWithMetaAccountTypeEnum.builder();
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
		public ReferenceWithMetaPartyBuilder getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreateServicingParty() {
			ReferenceWithMetaPartyBuilder result;
			if (servicingParty!=null) {
				result = servicingParty;
			}
			else {
				result = servicingParty = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Account.AccountBuilder setAccountBeneficiary(ReferenceWithMetaParty accountBeneficiary) {
			this.accountBeneficiary = accountBeneficiary==null?null:accountBeneficiary.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setAccountBeneficiaryValue(Party accountBeneficiary) {
			this.getOrCreateAccountBeneficiary().setValue(accountBeneficiary);
			return this;
		}
		@Override
		public Account.AccountBuilder setAccountName(FieldWithMetaString accountName) {
			this.accountName = accountName==null?null:accountName.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setAccountNameValue(String accountName) {
			this.getOrCreateAccountName().setValue(accountName);
			return this;
		}
		@Override
		public Account.AccountBuilder setAccountNumber(FieldWithMetaString accountNumber) {
			this.accountNumber = accountNumber==null?null:accountNumber.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setAccountNumberValue(String accountNumber) {
			this.getOrCreateAccountNumber().setValue(accountNumber);
			return this;
		}
		@Override
		public Account.AccountBuilder setAccountType(FieldWithMetaAccountTypeEnum accountType) {
			this.accountType = accountType==null?null:accountType.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setAccountTypeValue(AccountTypeEnum accountType) {
			this.getOrCreateAccountType().setValue(accountType);
			return this;
		}
		@Override
		public Account.AccountBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Account.AccountBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public Account.AccountBuilder setServicingParty(ReferenceWithMetaParty servicingParty) {
			this.servicingParty = servicingParty==null?null:servicingParty.toBuilder();
			return this;
		}
		
		@Override
		public Account.AccountBuilder setServicingPartyValue(Party servicingParty) {
			this.getOrCreateServicingParty().setValue(servicingParty);
			return this;
		}
		
		@Override
		public Account build() {
			return new Account.AccountImpl(this);
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder prune() {
			if (accountBeneficiary!=null && !accountBeneficiary.prune().hasData()) accountBeneficiary = null;
			if (accountName!=null && !accountName.prune().hasData()) accountName = null;
			if (accountNumber!=null && !accountNumber.prune().hasData()) accountNumber = null;
			if (accountType!=null && !accountType.prune().hasData()) accountType = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (servicingParty!=null && !servicingParty.prune().hasData()) servicingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountBeneficiary()!=null && getAccountBeneficiary().hasData()) return true;
			if (getAccountName()!=null) return true;
			if (getAccountNumber()!=null) return true;
			if (getAccountType()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getServicingParty()!=null && getServicingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Account.AccountBuilder o = (Account.AccountBuilder) other;
			
			merger.mergeRosetta(getAccountBeneficiary(), o.getAccountBeneficiary(), this::setAccountBeneficiary);
			merger.mergeRosetta(getAccountName(), o.getAccountName(), this::setAccountName);
			merger.mergeRosetta(getAccountNumber(), o.getAccountNumber(), this::setAccountNumber);
			merger.mergeRosetta(getAccountType(), o.getAccountType(), this::setAccountType);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getServicingParty(), o.getServicingParty(), this::setServicingParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountNumber, _that.getAccountNumber())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountNumber != null ? accountNumber.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountBuilder {" +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"accountName=" + this.accountName + ", " +
				"accountNumber=" + this.accountNumber + ", " +
				"accountType=" + this.accountType + ", " +
				"meta=" + this.meta + ", " +
				"partyReference=" + this.partyReference + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}
}
