package cdm.event.common;

import cdm.base.math.Quantity;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.meta.AllocationBreakdownMeta;
import cdm.legalagreement.csa.Collateral;
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
 * @version ${project.version}
 */
@RosettaClass

public interface AllocationBreakdown extends RosettaModelObject {
	AllocationBreakdown build();
	AllocationBreakdown.AllocationBreakdownBuilder toBuilder();
	
	/**
	 * The account to allocate the trade into
	 */
	Account getAccount();
	/**
	 * The identifier to be assigned to the new trade post allocation
	 */
	List<? extends Identifier> getAllocationTradeId();
	/**
	 * Specifies an additional counterparty to add as part of the allocation process.
	 */
	PartyRole getAncillaryParty();
	/**
	 * The sum that must be posted upfront to collateralize against counterparty credit risk.
	 */
	Collateral getCollateral();
	/**
	 * Specifies the counterparty to add.
	 */
	Counterparty getCounterparty();
	/**
	 * The quantity to be allocated to the party.
	 */
	List<? extends Quantity> getQuantity();
	final static AllocationBreakdownMeta metaData = new AllocationBreakdownMeta();
	
	@Override
	default RosettaMetaData<? extends AllocationBreakdown> metaData() {
		return metaData;
	} 
			
	static AllocationBreakdown.AllocationBreakdownBuilder builder() {
		return new AllocationBreakdown.AllocationBreakdownBuilderImpl();
	}
	
	default Class<? extends AllocationBreakdown> getType() {
		return AllocationBreakdown.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("allocationTradeId"), processor, Identifier.class, getAllocationTradeId());
		processRosetta(path.newSubPath("ancillaryParty"), processor, PartyRole.class, getAncillaryParty());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
	}
	
	
	interface AllocationBreakdownBuilder extends AllocationBreakdown, RosettaModelObjectBuilder {
		Account.AccountBuilder getOrCreateAccount();
		Account.AccountBuilder getAccount();
		Identifier.IdentifierBuilder getOrCreateAllocationTradeId(int _index);
		List<? extends Identifier.IdentifierBuilder> getAllocationTradeId();
		PartyRole.PartyRoleBuilder getOrCreateAncillaryParty();
		PartyRole.PartyRoleBuilder getAncillaryParty();
		Collateral.CollateralBuilder getOrCreateCollateral();
		Collateral.CollateralBuilder getCollateral();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty();
		Counterparty.CounterpartyBuilder getCounterparty();
		Quantity.QuantityBuilder getOrCreateQuantity(int _index);
		List<? extends Quantity.QuantityBuilder> getQuantity();
		AllocationBreakdown.AllocationBreakdownBuilder setAccount(Account account);
		AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(Identifier allocationTradeId);
		AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(Identifier allocationTradeId, int _idx);
		AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(List<? extends Identifier> allocationTradeId);
		AllocationBreakdown.AllocationBreakdownBuilder setAllocationTradeId(List<? extends Identifier> allocationTradeId);
		AllocationBreakdown.AllocationBreakdownBuilder setAncillaryParty(PartyRole ancillaryParty);
		AllocationBreakdown.AllocationBreakdownBuilder setCollateral(Collateral collateral);
		AllocationBreakdown.AllocationBreakdownBuilder setCounterparty(Counterparty counterparty);
		AllocationBreakdown.AllocationBreakdownBuilder addQuantity(Quantity quantity);
		AllocationBreakdown.AllocationBreakdownBuilder addQuantity(Quantity quantity, int _idx);
		AllocationBreakdown.AllocationBreakdownBuilder addQuantity(List<? extends Quantity> quantity);
		AllocationBreakdown.AllocationBreakdownBuilder setQuantity(List<? extends Quantity> quantity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("allocationTradeId"), processor, Identifier.IdentifierBuilder.class, getAllocationTradeId());
			processRosetta(path.newSubPath("ancillaryParty"), processor, PartyRole.PartyRoleBuilder.class, getAncillaryParty());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
		}
		
	}
	
	//AllocationBreakdown.AllocationBreakdownImpl
	class AllocationBreakdownImpl implements AllocationBreakdown {
		private final Account account;
		private final List<? extends Identifier> allocationTradeId;
		private final PartyRole ancillaryParty;
		private final Collateral collateral;
		private final Counterparty counterparty;
		private final List<? extends Quantity> quantity;
		
		protected AllocationBreakdownImpl(AllocationBreakdown.AllocationBreakdownBuilder builder) {
			this.account = ofNullable(builder.getAccount()).map(f->f.build()).orElse(null);
			this.allocationTradeId = ofNullable(builder.getAllocationTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.ancillaryParty = ofNullable(builder.getAncillaryParty()).map(f->f.build()).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.counterparty = ofNullable(builder.getCounterparty()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Account getAccount() {
			return account;
		}
		
		@Override
		public List<? extends Identifier> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		public PartyRole getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		public Counterparty getCounterparty() {
			return counterparty;
		}
		
		@Override
		public List<? extends Quantity> getQuantity() {
			return quantity;
		}
		
		@Override
		public AllocationBreakdown build() {
			return this;
		}
		
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder toBuilder() {
			AllocationBreakdown.AllocationBreakdownBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationBreakdown.AllocationBreakdownBuilder builder) {
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getAllocationTradeId()).ifPresent(builder::setAllocationTradeId);
			ofNullable(getAncillaryParty()).ifPresent(builder::setAncillaryParty);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationBreakdown {" +
				"account=" + this.account + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"collateral=" + this.collateral + ", " +
				"counterparty=" + this.counterparty + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
	
	//AllocationBreakdown.AllocationBreakdownBuilderImpl
	class AllocationBreakdownBuilderImpl implements AllocationBreakdown.AllocationBreakdownBuilder {
	
		protected Account.AccountBuilder account;
		protected List<Identifier.IdentifierBuilder> allocationTradeId = new ArrayList<>();
		protected PartyRole.PartyRoleBuilder ancillaryParty;
		protected Collateral.CollateralBuilder collateral;
		protected Counterparty.CounterpartyBuilder counterparty;
		protected List<Quantity.QuantityBuilder> quantity = new ArrayList<>();
	
		public AllocationBreakdownBuilderImpl() {
		}
	
		@Override
		public Account.AccountBuilder getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount() {
			Account.AccountBuilder result;
			if (account!=null) {
				result = account;
			}
			else {
				result = account = Account.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Identifier.IdentifierBuilder> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		public Identifier.IdentifierBuilder getOrCreateAllocationTradeId(int _index) {
		
			if (allocationTradeId==null) {
				this.allocationTradeId = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(allocationTradeId, _index, () -> {
						Identifier.IdentifierBuilder newAllocationTradeId = Identifier.builder();
						return newAllocationTradeId;
					});
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public PartyRole.PartyRoleBuilder getOrCreateAncillaryParty() {
			PartyRole.PartyRoleBuilder result;
			if (ancillaryParty!=null) {
				result = ancillaryParty;
			}
			else {
				result = ancillaryParty = PartyRole.builder();
			}
			
			return result;
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
		public Counterparty.CounterpartyBuilder getCounterparty() {
			return counterparty;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty() {
			Counterparty.CounterpartyBuilder result;
			if (counterparty!=null) {
				result = counterparty;
			}
			else {
				result = counterparty = Counterparty.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Quantity.QuantityBuilder> getQuantity() {
			return quantity;
		}
		
		public Quantity.QuantityBuilder getOrCreateQuantity(int _index) {
		
			if (quantity==null) {
				this.quantity = new ArrayList<>();
			}
			Quantity.QuantityBuilder result;
			return getIndex(quantity, _index, () -> {
						Quantity.QuantityBuilder newQuantity = Quantity.builder();
						return newQuantity;
					});
		}
		
	
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder setAccount(Account account) {
			this.account = account==null?null:account.toBuilder();
			return this;
		}
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(Identifier allocationTradeId) {
			if (allocationTradeId!=null) this.allocationTradeId.add(allocationTradeId.toBuilder());
			return this;
		}
		
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(Identifier allocationTradeId, int _idx) {
			getIndex(this.allocationTradeId, _idx, () -> allocationTradeId.toBuilder());
			return this;
		}
		@Override 
		public AllocationBreakdown.AllocationBreakdownBuilder addAllocationTradeId(List<? extends Identifier> allocationTradeIds) {
			if (allocationTradeIds != null) {
				for (Identifier toAdd : allocationTradeIds) {
					this.allocationTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AllocationBreakdown.AllocationBreakdownBuilder setAllocationTradeId(List<? extends Identifier> allocationTradeIds) {
			if (allocationTradeIds == null)  {
				this.allocationTradeId = new ArrayList<>();
			}
			else {
				this.allocationTradeId = allocationTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder setAncillaryParty(PartyRole ancillaryParty) {
			this.ancillaryParty = ancillaryParty==null?null:ancillaryParty.toBuilder();
			return this;
		}
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder setCollateral(Collateral collateral) {
			this.collateral = collateral==null?null:collateral.toBuilder();
			return this;
		}
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder setCounterparty(Counterparty counterparty) {
			this.counterparty = counterparty==null?null:counterparty.toBuilder();
			return this;
		}
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder addQuantity(Quantity quantity) {
			if (quantity!=null) this.quantity.add(quantity.toBuilder());
			return this;
		}
		
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder addQuantity(Quantity quantity, int _idx) {
			getIndex(this.quantity, _idx, () -> quantity.toBuilder());
			return this;
		}
		@Override 
		public AllocationBreakdown.AllocationBreakdownBuilder addQuantity(List<? extends Quantity> quantitys) {
			if (quantitys != null) {
				for (Quantity toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AllocationBreakdown.AllocationBreakdownBuilder setQuantity(List<? extends Quantity> quantitys) {
			if (quantitys == null)  {
				this.quantity = new ArrayList<>();
			}
			else {
				this.quantity = quantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AllocationBreakdown build() {
			return new AllocationBreakdown.AllocationBreakdownImpl(this);
		}
		
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder prune() {
			if (account!=null && !account.prune().hasData()) account = null;
			allocationTradeId = allocationTradeId.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (ancillaryParty!=null && !ancillaryParty.prune().hasData()) ancillaryParty = null;
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (counterparty!=null && !counterparty.prune().hasData()) counterparty = null;
			quantity = quantity.stream().filter(b->b!=null).<Quantity.QuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccount()!=null && getAccount().hasData()) return true;
			if (getAllocationTradeId()!=null && getAllocationTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAncillaryParty()!=null && getAncillaryParty().hasData()) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getCounterparty()!=null && getCounterparty().hasData()) return true;
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationBreakdown.AllocationBreakdownBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllocationBreakdown.AllocationBreakdownBuilder o = (AllocationBreakdown.AllocationBreakdownBuilder) other;
			
			merger.mergeRosetta(getAccount(), o.getAccount(), this::setAccount);
			merger.mergeRosetta(getAllocationTradeId(), o.getAllocationTradeId(), this::getOrCreateAllocationTradeId);
			merger.mergeRosetta(getAncillaryParty(), o.getAncillaryParty(), this::setAncillaryParty);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::setCounterparty);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(counterparty, _that.getCounterparty())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationBreakdownBuilder {" +
				"account=" + this.account + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"collateral=" + this.collateral + ", " +
				"counterparty=" + this.counterparty + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
