package cdm.event.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.meta.TradeMeta;
import cdm.legalagreement.csa.Collateral;
import cdm.product.template.TradableProduct;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the output of a financial transaction between parties - a Business Event. A Trade impacts the financial position (i.e. the balance sheet) of involved parties.
 * @version ${project.version}
 */
@RosettaClass

public interface Trade extends RosettaModelObject, GlobalKey {
	Trade build();
	Trade.TradeBuilder toBuilder();
	
	/**
	 * Represents a party&#39;s granular account information, which may be used in subsequent internal processing.
	 */
	List<? extends Account> getAccount();
	/**
	 * Specifies the date on which a trade is cleared (novated) through a central counterparty clearing service.
	 */
	Date getClearedDate();
	/**
	 * Represents the collateral obligations of a party.
	 */
	Collateral getCollateral();
	/**
	 * Represents information specific to trades involving contractual products.
	 */
	ContractDetails getContractDetails();
	/**
	 * Represents information specific to trades that arose from executions.
	 */
	ExecutionDetails getExecutionDetails();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Represents the parties to the trade. The cardinality is optional to address the case where the trade is defined within a BusinessEvent data type, in which case the party is specified in BusinessEvent.
	 */
	List<? extends Party> getParty();
	/**
	 * Represents the role each specified party takes in the trade. further to the principal roles, payer and receiver.
	 */
	List<? extends PartyRole> getPartyRole();
	/**
	 * Represents the financial instrument The corresponding FpML construct is the product abstract element and the associated substitution group.
	 */
	TradableProduct getTradableProduct();
	/**
	 * Specifies the date which the trade was agreed.
	 */
	FieldWithMetaDate getTradeDate();
	/**
	 * Represents the identifier(s) that uniquely identify a trade for an identity issuer. A trade can include multiple identifiers, for example a trade that is reportable to both the CFTC and ESMA, and then has an associated USI (Unique Swap Identifier) UTI (Unique Trade Identifier).
	 */
	List<? extends Identifier> getTradeIdentifier();
	final static TradeMeta metaData = new TradeMeta();
	
	@Override
	default RosettaMetaData<? extends Trade> metaData() {
		return metaData;
	} 
			
	static Trade.TradeBuilder builder() {
		return new Trade.TradeBuilderImpl();
	}
	
	default Class<? extends Trade> getType() {
		return Trade.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearedDate"), Date.class, getClearedDate(), this);
		
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("contractDetails"), processor, ContractDetails.class, getContractDetails());
		processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.class, getExecutionDetails());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("tradableProduct"), processor, TradableProduct.class, getTradableProduct());
		processRosetta(path.newSubPath("tradeDate"), processor, FieldWithMetaDate.class, getTradeDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("tradeIdentifier"), processor, Identifier.class, getTradeIdentifier());
	}
	
	
	interface TradeBuilder extends Trade, RosettaModelObjectBuilder {
		Account.AccountBuilder getOrCreateAccount(int _index);
		List<? extends Account.AccountBuilder> getAccount();
		Collateral.CollateralBuilder getOrCreateCollateral();
		Collateral.CollateralBuilder getCollateral();
		ContractDetails.ContractDetailsBuilder getOrCreateContractDetails();
		ContractDetails.ContractDetailsBuilder getContractDetails();
		ExecutionDetails.ExecutionDetailsBuilder getOrCreateExecutionDetails();
		ExecutionDetails.ExecutionDetailsBuilder getExecutionDetails();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index);
		List<? extends PartyRole.PartyRoleBuilder> getPartyRole();
		TradableProduct.TradableProductBuilder getOrCreateTradableProduct();
		TradableProduct.TradableProductBuilder getTradableProduct();
		FieldWithMetaDateBuilder getOrCreateTradeDate();
		FieldWithMetaDateBuilder getTradeDate();
		Identifier.IdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends Identifier.IdentifierBuilder> getTradeIdentifier();
		Trade.TradeBuilder addAccount(Account account);
		Trade.TradeBuilder addAccount(Account account, int _idx);
		Trade.TradeBuilder addAccount(List<? extends Account> account);
		Trade.TradeBuilder setAccount(List<? extends Account> account);
		Trade.TradeBuilder setClearedDate(Date clearedDate);
		Trade.TradeBuilder setCollateral(Collateral collateral);
		Trade.TradeBuilder setContractDetails(ContractDetails contractDetails);
		Trade.TradeBuilder setExecutionDetails(ExecutionDetails executionDetails);
		Trade.TradeBuilder setMeta(MetaFields meta);
		Trade.TradeBuilder addParty(Party party);
		Trade.TradeBuilder addParty(Party party, int _idx);
		Trade.TradeBuilder addParty(List<? extends Party> party);
		Trade.TradeBuilder setParty(List<? extends Party> party);
		Trade.TradeBuilder addPartyRole(PartyRole partyRole);
		Trade.TradeBuilder addPartyRole(PartyRole partyRole, int _idx);
		Trade.TradeBuilder addPartyRole(List<? extends PartyRole> partyRole);
		Trade.TradeBuilder setPartyRole(List<? extends PartyRole> partyRole);
		Trade.TradeBuilder setTradableProduct(TradableProduct tradableProduct);
		Trade.TradeBuilder setTradeDate(FieldWithMetaDate tradeDate);
		Trade.TradeBuilder setTradeDateValue(Date tradeDate);
		Trade.TradeBuilder addTradeIdentifier(Identifier tradeIdentifier);
		Trade.TradeBuilder addTradeIdentifier(Identifier tradeIdentifier, int _idx);
		Trade.TradeBuilder addTradeIdentifier(List<? extends Identifier> tradeIdentifier);
		Trade.TradeBuilder setTradeIdentifier(List<? extends Identifier> tradeIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("clearedDate"), Date.class, getClearedDate(), this);
			
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("contractDetails"), processor, ContractDetails.ContractDetailsBuilder.class, getContractDetails());
			processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.ExecutionDetailsBuilder.class, getExecutionDetails());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("tradableProduct"), processor, TradableProduct.TradableProductBuilder.class, getTradableProduct());
			processRosetta(path.newSubPath("tradeDate"), processor, FieldWithMetaDateBuilder.class, getTradeDate(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("tradeIdentifier"), processor, Identifier.IdentifierBuilder.class, getTradeIdentifier());
		}
		
	}
	
	//Trade.TradeImpl
	class TradeImpl implements Trade {
		private final List<? extends Account> account;
		private final Date clearedDate;
		private final Collateral collateral;
		private final ContractDetails contractDetails;
		private final ExecutionDetails executionDetails;
		private final MetaFields meta;
		private final List<? extends Party> party;
		private final List<? extends PartyRole> partyRole;
		private final TradableProduct tradableProduct;
		private final FieldWithMetaDate tradeDate;
		private final List<? extends Identifier> tradeIdentifier;
		
		protected TradeImpl(Trade.TradeBuilder builder) {
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clearedDate = builder.getClearedDate();
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.contractDetails = ofNullable(builder.getContractDetails()).map(f->f.build()).orElse(null);
			this.executionDetails = ofNullable(builder.getExecutionDetails()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRole = ofNullable(builder.getPartyRole()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradableProduct = ofNullable(builder.getTradableProduct()).map(f->f.build()).orElse(null);
			this.tradeDate = ofNullable(builder.getTradeDate()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public Date getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		public ContractDetails getContractDetails() {
			return contractDetails;
		}
		
		@Override
		public ExecutionDetails getExecutionDetails() {
			return executionDetails;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public List<? extends PartyRole> getPartyRole() {
			return partyRole;
		}
		
		@Override
		public TradableProduct getTradableProduct() {
			return tradableProduct;
		}
		
		@Override
		public FieldWithMetaDate getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public List<? extends Identifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public Trade build() {
			return this;
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			Trade.TradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trade.TradeBuilder builder) {
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getClearedDate()).ifPresent(builder::setClearedDate);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getContractDetails()).ifPresent(builder::setContractDetails);
			ofNullable(getExecutionDetails()).ifPresent(builder::setExecutionDetails);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getPartyRole()).ifPresent(builder::setPartyRole);
			ofNullable(getTradableProduct()).ifPresent(builder::setTradableProduct);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(contractDetails, _that.getContractDetails())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(tradableProduct, _that.getTradableProduct())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (contractDetails != null ? contractDetails.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (tradableProduct != null ? tradableProduct.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trade {" +
				"account=" + this.account + ", " +
				"clearedDate=" + this.clearedDate + ", " +
				"collateral=" + this.collateral + ", " +
				"contractDetails=" + this.contractDetails + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"meta=" + this.meta + ", " +
				"party=" + this.party + ", " +
				"partyRole=" + this.partyRole + ", " +
				"tradableProduct=" + this.tradableProduct + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
	
	//Trade.TradeBuilderImpl
	class TradeBuilderImpl implements Trade.TradeBuilder, GlobalKeyBuilder {
	
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected Date clearedDate;
		protected Collateral.CollateralBuilder collateral;
		protected ContractDetails.ContractDetailsBuilder contractDetails;
		protected ExecutionDetails.ExecutionDetailsBuilder executionDetails;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRole = new ArrayList<>();
		protected TradableProduct.TradableProductBuilder tradableProduct;
		protected FieldWithMetaDateBuilder tradeDate;
		protected List<Identifier.IdentifierBuilder> tradeIdentifier = new ArrayList<>();
	
		public TradeBuilderImpl() {
		}
	
		@Override
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		public Account.AccountBuilder getOrCreateAccount(int _index) {
		
			if (account==null) {
				this.account = new ArrayList<>();
			}
			Account.AccountBuilder result;
			return getIndex(account, _index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@Override
		public Date getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder getContractDetails() {
			return contractDetails;
		}
		
		@Override
		public ContractDetails.ContractDetailsBuilder getOrCreateContractDetails() {
			ContractDetails.ContractDetailsBuilder result;
			if (contractDetails!=null) {
				result = contractDetails;
			}
			else {
				result = contractDetails = ContractDetails.builder();
			}
			
			return result;
		}
		
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder getExecutionDetails() {
			return executionDetails;
		}
		
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder getOrCreateExecutionDetails() {
			ExecutionDetails.ExecutionDetailsBuilder result;
			if (executionDetails!=null) {
				result = executionDetails;
			}
			else {
				result = executionDetails = ExecutionDetails.builder();
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
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		public List<? extends PartyRole.PartyRoleBuilder> getPartyRole() {
			return partyRole;
		}
		
		public PartyRole.PartyRoleBuilder getOrCreatePartyRole(int _index) {
		
			if (partyRole==null) {
				this.partyRole = new ArrayList<>();
			}
			PartyRole.PartyRoleBuilder result;
			return getIndex(partyRole, _index, () -> {
						PartyRole.PartyRoleBuilder newPartyRole = PartyRole.builder();
						return newPartyRole;
					});
		}
		
		@Override
		public TradableProduct.TradableProductBuilder getTradableProduct() {
			return tradableProduct;
		}
		
		@Override
		public TradableProduct.TradableProductBuilder getOrCreateTradableProduct() {
			TradableProduct.TradableProductBuilder result;
			if (tradableProduct!=null) {
				result = tradableProduct;
			}
			else {
				result = tradableProduct = TradableProduct.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaDateBuilder getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public FieldWithMetaDateBuilder getOrCreateTradeDate() {
			FieldWithMetaDateBuilder result;
			if (tradeDate!=null) {
				result = tradeDate;
			}
			else {
				result = tradeDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Identifier.IdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		public Identifier.IdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						Identifier.IdentifierBuilder newTradeIdentifier = Identifier.builder();
						return newTradeIdentifier;
					});
		}
		
	
		@Override
		public Trade.TradeBuilder addAccount(Account account) {
			if (account!=null) this.account.add(account.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addAccount(Account account, int _idx) {
			getIndex(this.account, _idx, () -> account.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null)  {
				this.account = new ArrayList<>();
			}
			else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder setClearedDate(Date clearedDate) {
			this.clearedDate = clearedDate==null?null:clearedDate;
			return this;
		}
		@Override
		public Trade.TradeBuilder setCollateral(Collateral collateral) {
			this.collateral = collateral==null?null:collateral.toBuilder();
			return this;
		}
		@Override
		public Trade.TradeBuilder setContractDetails(ContractDetails contractDetails) {
			this.contractDetails = contractDetails==null?null:contractDetails.toBuilder();
			return this;
		}
		@Override
		public Trade.TradeBuilder setExecutionDetails(ExecutionDetails executionDetails) {
			this.executionDetails = executionDetails==null?null:executionDetails.toBuilder();
			return this;
		}
		@Override
		public Trade.TradeBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Trade.TradeBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addPartyRole(PartyRole partyRole) {
			if (partyRole!=null) this.partyRole.add(partyRole.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addPartyRole(PartyRole partyRole, int _idx) {
			getIndex(this.partyRole, _idx, () -> partyRole.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles == null)  {
				this.partyRole = new ArrayList<>();
			}
			else {
				this.partyRole = partyRoles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder setTradableProduct(TradableProduct tradableProduct) {
			this.tradableProduct = tradableProduct==null?null:tradableProduct.toBuilder();
			return this;
		}
		@Override
		public Trade.TradeBuilder setTradeDate(FieldWithMetaDate tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate.toBuilder();
			return this;
		}
		
		@Override
		public Trade.TradeBuilder setTradeDateValue(Date tradeDate) {
			this.getOrCreateTradeDate().setValue(tradeDate);
			return this;
		}
		@Override
		public Trade.TradeBuilder addTradeIdentifier(Identifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addTradeIdentifier(Identifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addTradeIdentifier(List<? extends Identifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (Identifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setTradeIdentifier(List<? extends Identifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Trade build() {
			return new Trade.TradeImpl(this);
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder prune() {
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (contractDetails!=null && !contractDetails.prune().hasData()) contractDetails = null;
			if (executionDetails!=null && !executionDetails.prune().hasData()) executionDetails = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRole = partyRole.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradableProduct!=null && !tradableProduct.prune().hasData()) tradableProduct = null;
			if (tradeDate!=null && !tradeDate.prune().hasData()) tradeDate = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getClearedDate()!=null) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getContractDetails()!=null && getContractDetails().hasData()) return true;
			if (getExecutionDetails()!=null && getExecutionDetails().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRole()!=null && getPartyRole().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradableProduct()!=null && getTradableProduct().hasData()) return true;
			if (getTradeDate()!=null) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trade.TradeBuilder o = (Trade.TradeBuilder) other;
			
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getContractDetails(), o.getContractDetails(), this::setContractDetails);
			merger.mergeRosetta(getExecutionDetails(), o.getExecutionDetails(), this::setExecutionDetails);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getPartyRole(), o.getPartyRole(), this::getOrCreatePartyRole);
			merger.mergeRosetta(getTradableProduct(), o.getTradableProduct(), this::setTradableProduct);
			merger.mergeRosetta(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getClearedDate(), o.getClearedDate(), this::setClearedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(contractDetails, _that.getContractDetails())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(partyRole, _that.getPartyRole())) return false;
			if (!Objects.equals(tradableProduct, _that.getTradableProduct())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (contractDetails != null ? contractDetails.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (partyRole != null ? partyRole.hashCode() : 0);
			_result = 31 * _result + (tradableProduct != null ? tradableProduct.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeBuilder {" +
				"account=" + this.account + ", " +
				"clearedDate=" + this.clearedDate + ", " +
				"collateral=" + this.collateral + ", " +
				"contractDetails=" + this.contractDetails + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"meta=" + this.meta + ", " +
				"party=" + this.party + ", " +
				"partyRole=" + this.partyRole + ", " +
				"tradableProduct=" + this.tradableProduct + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
}
