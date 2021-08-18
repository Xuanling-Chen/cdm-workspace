package cdm.legalagreement.csa;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.legalagreement.csa.meta.CustodianElectionMeta;
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
 * A class to specify the custodian and custody account details for each party to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CustodianElection extends RosettaModelObject {
	CustodianElection build();
	CustodianElection.CustodianElectionBuilder toBuilder();
	
	/**
	 * The custody agent. While ISDA Create only specifies the custodian&#39;s name, specifying the legal entity as part of the CDM is deemed more appropriate, while this will still provide the ability to accommodate situations where only the entity name is available, as the entityId attribute is optional as part of the LegalEntity class.
	 */
	LegalEntity getCustodian();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The identification of the segregated cash account for the purpose of holding cash collateral.
	 */
	Account getSegregatedCashAccount();
	/**
	 * The identification of the segregated security account for the purpose of holding security collateral.
	 */
	Account getSegregatedSecurityAccount();
	final static CustodianElectionMeta metaData = new CustodianElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CustodianElection> metaData() {
		return metaData;
	} 
			
	static CustodianElection.CustodianElectionBuilder builder() {
		return new CustodianElection.CustodianElectionBuilderImpl();
	}
	
	default Class<? extends CustodianElection> getType() {
		return CustodianElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("custodian"), processor, LegalEntity.class, getCustodian());
		processRosetta(path.newSubPath("segregatedCashAccount"), processor, Account.class, getSegregatedCashAccount());
		processRosetta(path.newSubPath("segregatedSecurityAccount"), processor, Account.class, getSegregatedSecurityAccount());
	}
	
	
	interface CustodianElectionBuilder extends CustodianElection, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateCustodian();
		LegalEntity.LegalEntityBuilder getCustodian();
		Account.AccountBuilder getOrCreateSegregatedCashAccount();
		Account.AccountBuilder getSegregatedCashAccount();
		Account.AccountBuilder getOrCreateSegregatedSecurityAccount();
		Account.AccountBuilder getSegregatedSecurityAccount();
		CustodianElection.CustodianElectionBuilder setCustodian(LegalEntity custodian);
		CustodianElection.CustodianElectionBuilder setParty(CounterpartyRoleEnum party);
		CustodianElection.CustodianElectionBuilder setSegregatedCashAccount(Account segregatedCashAccount);
		CustodianElection.CustodianElectionBuilder setSegregatedSecurityAccount(Account segregatedSecurityAccount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("custodian"), processor, LegalEntity.LegalEntityBuilder.class, getCustodian());
			processRosetta(path.newSubPath("segregatedCashAccount"), processor, Account.AccountBuilder.class, getSegregatedCashAccount());
			processRosetta(path.newSubPath("segregatedSecurityAccount"), processor, Account.AccountBuilder.class, getSegregatedSecurityAccount());
		}
		
	}
	
	//CustodianElection.CustodianElectionImpl
	class CustodianElectionImpl implements CustodianElection {
		private final LegalEntity custodian;
		private final CounterpartyRoleEnum party;
		private final Account segregatedCashAccount;
		private final Account segregatedSecurityAccount;
		
		protected CustodianElectionImpl(CustodianElection.CustodianElectionBuilder builder) {
			this.custodian = ofNullable(builder.getCustodian()).map(f->f.build()).orElse(null);
			this.party = builder.getParty();
			this.segregatedCashAccount = ofNullable(builder.getSegregatedCashAccount()).map(f->f.build()).orElse(null);
			this.segregatedSecurityAccount = ofNullable(builder.getSegregatedSecurityAccount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public LegalEntity getCustodian() {
			return custodian;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Account getSegregatedCashAccount() {
			return segregatedCashAccount;
		}
		
		@Override
		public Account getSegregatedSecurityAccount() {
			return segregatedSecurityAccount;
		}
		
		@Override
		public CustodianElection build() {
			return this;
		}
		
		@Override
		public CustodianElection.CustodianElectionBuilder toBuilder() {
			CustodianElection.CustodianElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianElection.CustodianElectionBuilder builder) {
			ofNullable(getCustodian()).ifPresent(builder::setCustodian);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getSegregatedCashAccount()).ifPresent(builder::setSegregatedCashAccount);
			ofNullable(getSegregatedSecurityAccount()).ifPresent(builder::setSegregatedSecurityAccount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianElection _that = getType().cast(o);
		
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(segregatedCashAccount, _that.getSegregatedCashAccount())) return false;
			if (!Objects.equals(segregatedSecurityAccount, _that.getSegregatedSecurityAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (segregatedCashAccount != null ? segregatedCashAccount.hashCode() : 0);
			_result = 31 * _result + (segregatedSecurityAccount != null ? segregatedSecurityAccount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianElection {" +
				"custodian=" + this.custodian + ", " +
				"party=" + this.party + ", " +
				"segregatedCashAccount=" + this.segregatedCashAccount + ", " +
				"segregatedSecurityAccount=" + this.segregatedSecurityAccount +
			'}';
		}
	}
	
	//CustodianElection.CustodianElectionBuilderImpl
	class CustodianElectionBuilderImpl implements CustodianElection.CustodianElectionBuilder {
	
		protected LegalEntity.LegalEntityBuilder custodian;
		protected CounterpartyRoleEnum party;
		protected Account.AccountBuilder segregatedCashAccount;
		protected Account.AccountBuilder segregatedSecurityAccount;
	
		public CustodianElectionBuilderImpl() {
		}
	
		@Override
		public LegalEntity.LegalEntityBuilder getCustodian() {
			return custodian;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateCustodian() {
			LegalEntity.LegalEntityBuilder result;
			if (custodian!=null) {
				result = custodian;
			}
			else {
				result = custodian = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Account.AccountBuilder getSegregatedCashAccount() {
			return segregatedCashAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateSegregatedCashAccount() {
			Account.AccountBuilder result;
			if (segregatedCashAccount!=null) {
				result = segregatedCashAccount;
			}
			else {
				result = segregatedCashAccount = Account.builder();
			}
			
			return result;
		}
		
		@Override
		public Account.AccountBuilder getSegregatedSecurityAccount() {
			return segregatedSecurityAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateSegregatedSecurityAccount() {
			Account.AccountBuilder result;
			if (segregatedSecurityAccount!=null) {
				result = segregatedSecurityAccount;
			}
			else {
				result = segregatedSecurityAccount = Account.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CustodianElection.CustodianElectionBuilder setCustodian(LegalEntity custodian) {
			this.custodian = custodian==null?null:custodian.toBuilder();
			return this;
		}
		@Override
		public CustodianElection.CustodianElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public CustodianElection.CustodianElectionBuilder setSegregatedCashAccount(Account segregatedCashAccount) {
			this.segregatedCashAccount = segregatedCashAccount==null?null:segregatedCashAccount.toBuilder();
			return this;
		}
		@Override
		public CustodianElection.CustodianElectionBuilder setSegregatedSecurityAccount(Account segregatedSecurityAccount) {
			this.segregatedSecurityAccount = segregatedSecurityAccount==null?null:segregatedSecurityAccount.toBuilder();
			return this;
		}
		
		@Override
		public CustodianElection build() {
			return new CustodianElection.CustodianElectionImpl(this);
		}
		
		@Override
		public CustodianElection.CustodianElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianElection.CustodianElectionBuilder prune() {
			if (custodian!=null && !custodian.prune().hasData()) custodian = null;
			if (segregatedCashAccount!=null && !segregatedCashAccount.prune().hasData()) segregatedCashAccount = null;
			if (segregatedSecurityAccount!=null && !segregatedSecurityAccount.prune().hasData()) segregatedSecurityAccount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustodian()!=null && getCustodian().hasData()) return true;
			if (getParty()!=null) return true;
			if (getSegregatedCashAccount()!=null && getSegregatedCashAccount().hasData()) return true;
			if (getSegregatedSecurityAccount()!=null && getSegregatedSecurityAccount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianElection.CustodianElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianElection.CustodianElectionBuilder o = (CustodianElection.CustodianElectionBuilder) other;
			
			merger.mergeRosetta(getCustodian(), o.getCustodian(), this::setCustodian);
			merger.mergeRosetta(getSegregatedCashAccount(), o.getSegregatedCashAccount(), this::setSegregatedCashAccount);
			merger.mergeRosetta(getSegregatedSecurityAccount(), o.getSegregatedSecurityAccount(), this::setSegregatedSecurityAccount);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianElection _that = getType().cast(o);
		
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(segregatedCashAccount, _that.getSegregatedCashAccount())) return false;
			if (!Objects.equals(segregatedSecurityAccount, _that.getSegregatedSecurityAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (segregatedCashAccount != null ? segregatedCashAccount.hashCode() : 0);
			_result = 31 * _result + (segregatedSecurityAccount != null ? segregatedSecurityAccount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianElectionBuilder {" +
				"custodian=" + this.custodian + ", " +
				"party=" + this.party + ", " +
				"segregatedCashAccount=" + this.segregatedCashAccount + ", " +
				"segregatedSecurityAccount=" + this.segregatedSecurityAccount +
			'}';
		}
	}
}
