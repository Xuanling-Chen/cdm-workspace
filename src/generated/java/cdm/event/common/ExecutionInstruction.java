package cdm.event.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.meta.ExecutionInstructionMeta;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionInstruction extends RosettaModelObject {
	ExecutionInstruction build();
	ExecutionInstruction.ExecutionInstructionBuilder toBuilder();
	
	/**
	 * Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
	 */
	List<? extends AncillaryParty> getAncillaryParty();
	/**
	 * Maps two defined parties to counterparty enums for the transacted product.
	 */
	List<? extends Counterparty> getCounterparty();
	/**
	 * Specifies the type and venue of execution, e.g. via voice, or electronically.
	 */
	ExecutionDetails getExecutionDetails();
	/**
	 * Defines all parties to that execution, including agents and brokers.
	 */
	List<? extends Party> getParties();
	/**
	 * Defines the role(s) that party(ies) may have in relation to the execution.
	 */
	List<? extends PartyRole> getPartyRoles();
	/**
	 * Defines the prices (e.g. spread, equity price, FX rate) and quantities (e.g. currency amount, no. shares) associated with the constituents of the transacted product.
	 */
	List<? extends PriceQuantity> getPriceQuantity();
	/**
	 * Defines the financial product to be executed and contract formed.
	 */
	Product getProduct();
	/**
	 * Specifies the settlement terms for the execution e.g. initial fee, broker fee, up-front cds payment or option premium settlement
	 */
	List<? extends SettlementInstructions> getSettlementInstructions();
	/**
	 * Denotes the trade/execution date.
	 */
	Date getTradeDate();
	/**
	 * Denotes one or more identifiers associated with the transaction.
	 */
	List<? extends Identifier> getTradeIdentifier();
	final static ExecutionInstructionMeta metaData = new ExecutionInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionInstruction> metaData() {
		return metaData;
	} 
			
	static ExecutionInstruction.ExecutionInstructionBuilder builder() {
		return new ExecutionInstruction.ExecutionInstructionBuilderImpl();
	}
	
	default Class<? extends ExecutionInstruction> getType() {
		return ExecutionInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
		
		processRosetta(path.newSubPath("ancillaryParty"), processor, AncillaryParty.class, getAncillaryParty());
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
		processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.class, getExecutionDetails());
		processRosetta(path.newSubPath("parties"), processor, Party.class, getParties());
		processRosetta(path.newSubPath("partyRoles"), processor, PartyRole.class, getPartyRoles());
		processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.class, getPriceQuantity());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("settlementInstructions"), processor, SettlementInstructions.class, getSettlementInstructions());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, Identifier.class, getTradeIdentifier());
	}
	
	
	interface ExecutionInstructionBuilder extends ExecutionInstruction, RosettaModelObjectBuilder {
		AncillaryParty.AncillaryPartyBuilder getOrCreateAncillaryParty(int _index);
		List<? extends AncillaryParty.AncillaryPartyBuilder> getAncillaryParty();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index);
		List<? extends Counterparty.CounterpartyBuilder> getCounterparty();
		ExecutionDetails.ExecutionDetailsBuilder getOrCreateExecutionDetails();
		ExecutionDetails.ExecutionDetailsBuilder getExecutionDetails();
		Party.PartyBuilder getOrCreateParties(int _index);
		List<? extends Party.PartyBuilder> getParties();
		PartyRole.PartyRoleBuilder getOrCreatePartyRoles(int _index);
		List<? extends PartyRole.PartyRoleBuilder> getPartyRoles();
		PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index);
		List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity();
		Product.ProductBuilder getOrCreateProduct();
		Product.ProductBuilder getProduct();
		SettlementInstructions.SettlementInstructionsBuilder getOrCreateSettlementInstructions(int _index);
		List<? extends SettlementInstructions.SettlementInstructionsBuilder> getSettlementInstructions();
		Identifier.IdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends Identifier.IdentifierBuilder> getTradeIdentifier();
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(List<? extends AncillaryParty> ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder setAncillaryParty(List<? extends AncillaryParty> ancillaryParty);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(List<? extends Counterparty> counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder setCounterparty(List<? extends Counterparty> counterparty);
		ExecutionInstruction.ExecutionInstructionBuilder setExecutionDetails(ExecutionDetails executionDetails);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addParties(List<? extends Party> parties);
		ExecutionInstruction.ExecutionInstructionBuilder setParties(List<? extends Party> parties);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(List<? extends PartyRole> partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder setPartyRoles(List<? extends PartyRole> partyRoles);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantity);
		ExecutionInstruction.ExecutionInstructionBuilder setProduct(Product product);
		ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(SettlementInstructions settlementInstructions);
		ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(SettlementInstructions settlementInstructions, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(List<? extends SettlementInstructions> settlementInstructions);
		ExecutionInstruction.ExecutionInstructionBuilder setSettlementInstructions(List<? extends SettlementInstructions> settlementInstructions);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeDate(Date tradeDate);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(Identifier tradeIdentifier);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(Identifier tradeIdentifier, int _idx);
		ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(List<? extends Identifier> tradeIdentifier);
		ExecutionInstruction.ExecutionInstructionBuilder setTradeIdentifier(List<? extends Identifier> tradeIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("tradeDate"), Date.class, getTradeDate(), this);
			
			processRosetta(path.newSubPath("ancillaryParty"), processor, AncillaryParty.AncillaryPartyBuilder.class, getAncillaryParty());
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
			processRosetta(path.newSubPath("executionDetails"), processor, ExecutionDetails.ExecutionDetailsBuilder.class, getExecutionDetails());
			processRosetta(path.newSubPath("parties"), processor, Party.PartyBuilder.class, getParties());
			processRosetta(path.newSubPath("partyRoles"), processor, PartyRole.PartyRoleBuilder.class, getPartyRoles());
			processRosetta(path.newSubPath("priceQuantity"), processor, PriceQuantity.PriceQuantityBuilder.class, getPriceQuantity());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("settlementInstructions"), processor, SettlementInstructions.SettlementInstructionsBuilder.class, getSettlementInstructions());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, Identifier.IdentifierBuilder.class, getTradeIdentifier());
		}
		
	}
	
	//ExecutionInstruction.ExecutionInstructionImpl
	class ExecutionInstructionImpl implements ExecutionInstruction {
		private final List<? extends AncillaryParty> ancillaryParty;
		private final List<? extends Counterparty> counterparty;
		private final ExecutionDetails executionDetails;
		private final List<? extends Party> parties;
		private final List<? extends PartyRole> partyRoles;
		private final List<? extends PriceQuantity> priceQuantity;
		private final Product product;
		private final List<? extends SettlementInstructions> settlementInstructions;
		private final Date tradeDate;
		private final List<? extends Identifier> tradeIdentifier;
		
		protected ExecutionInstructionImpl(ExecutionInstruction.ExecutionInstructionBuilder builder) {
			this.ancillaryParty = ofNullable(builder.getAncillaryParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.executionDetails = ofNullable(builder.getExecutionDetails()).map(f->f.build()).orElse(null);
			this.parties = ofNullable(builder.getParties()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyRoles = ofNullable(builder.getPartyRoles()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.priceQuantity = ofNullable(builder.getPriceQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
			this.settlementInstructions = ofNullable(builder.getSettlementInstructions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeDate = builder.getTradeDate();
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends AncillaryParty> getAncillaryParty() {
			return ancillaryParty;
		}
		
		@Override
		public List<? extends Counterparty> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public ExecutionDetails getExecutionDetails() {
			return executionDetails;
		}
		
		@Override
		public List<? extends Party> getParties() {
			return parties;
		}
		
		@Override
		public List<? extends PartyRole> getPartyRoles() {
			return partyRoles;
		}
		
		@Override
		public List<? extends PriceQuantity> getPriceQuantity() {
			return priceQuantity;
		}
		
		@Override
		public Product getProduct() {
			return product;
		}
		
		@Override
		public List<? extends SettlementInstructions> getSettlementInstructions() {
			return settlementInstructions;
		}
		
		@Override
		public Date getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public List<? extends Identifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public ExecutionInstruction build() {
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder toBuilder() {
			ExecutionInstruction.ExecutionInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionInstruction.ExecutionInstructionBuilder builder) {
			ofNullable(getAncillaryParty()).ifPresent(builder::setAncillaryParty);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
			ofNullable(getExecutionDetails()).ifPresent(builder::setExecutionDetails);
			ofNullable(getParties()).ifPresent(builder::setParties);
			ofNullable(getPartyRoles()).ifPresent(builder::setPartyRoles);
			ofNullable(getPriceQuantity()).ifPresent(builder::setPriceQuantity);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getSettlementInstructions()).ifPresent(builder::setSettlementInstructions);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			if (!ListEquals.listEquals(partyRoles, _that.getPartyRoles())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(settlementInstructions, _that.getSettlementInstructions())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (partyRoles != null ? partyRoles.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (settlementInstructions != null ? settlementInstructions.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionInstruction {" +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"counterparty=" + this.counterparty + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"parties=" + this.parties + ", " +
				"partyRoles=" + this.partyRoles + ", " +
				"priceQuantity=" + this.priceQuantity + ", " +
				"product=" + this.product + ", " +
				"settlementInstructions=" + this.settlementInstructions + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
	
	//ExecutionInstruction.ExecutionInstructionBuilderImpl
	class ExecutionInstructionBuilderImpl implements ExecutionInstruction.ExecutionInstructionBuilder {
	
		protected List<AncillaryParty.AncillaryPartyBuilder> ancillaryParty = new ArrayList<>();
		protected List<Counterparty.CounterpartyBuilder> counterparty = new ArrayList<>();
		protected ExecutionDetails.ExecutionDetailsBuilder executionDetails;
		protected List<Party.PartyBuilder> parties = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> partyRoles = new ArrayList<>();
		protected List<PriceQuantity.PriceQuantityBuilder> priceQuantity = new ArrayList<>();
		protected Product.ProductBuilder product;
		protected List<SettlementInstructions.SettlementInstructionsBuilder> settlementInstructions = new ArrayList<>();
		protected Date tradeDate;
		protected List<Identifier.IdentifierBuilder> tradeIdentifier = new ArrayList<>();
	
		public ExecutionInstructionBuilderImpl() {
		}
	
		@Override
		public List<? extends AncillaryParty.AncillaryPartyBuilder> getAncillaryParty() {
			return ancillaryParty;
		}
		
		public AncillaryParty.AncillaryPartyBuilder getOrCreateAncillaryParty(int _index) {
		
			if (ancillaryParty==null) {
				this.ancillaryParty = new ArrayList<>();
			}
			AncillaryParty.AncillaryPartyBuilder result;
			return getIndex(ancillaryParty, _index, () -> {
						AncillaryParty.AncillaryPartyBuilder newAncillaryParty = AncillaryParty.builder();
						return newAncillaryParty;
					});
		}
		
		@Override
		public List<? extends Counterparty.CounterpartyBuilder> getCounterparty() {
			return counterparty;
		}
		
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty(int _index) {
		
			if (counterparty==null) {
				this.counterparty = new ArrayList<>();
			}
			Counterparty.CounterpartyBuilder result;
			return getIndex(counterparty, _index, () -> {
						Counterparty.CounterpartyBuilder newCounterparty = Counterparty.builder();
						return newCounterparty;
					});
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
		public List<? extends Party.PartyBuilder> getParties() {
			return parties;
		}
		
		public Party.PartyBuilder getOrCreateParties(int _index) {
		
			if (parties==null) {
				this.parties = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(parties, _index, () -> {
						Party.PartyBuilder newParties = Party.builder();
						return newParties;
					});
		}
		
		@Override
		public List<? extends PartyRole.PartyRoleBuilder> getPartyRoles() {
			return partyRoles;
		}
		
		public PartyRole.PartyRoleBuilder getOrCreatePartyRoles(int _index) {
		
			if (partyRoles==null) {
				this.partyRoles = new ArrayList<>();
			}
			PartyRole.PartyRoleBuilder result;
			return getIndex(partyRoles, _index, () -> {
						PartyRole.PartyRoleBuilder newPartyRoles = PartyRole.builder();
						return newPartyRoles;
					});
		}
		
		@Override
		public List<? extends PriceQuantity.PriceQuantityBuilder> getPriceQuantity() {
			return priceQuantity;
		}
		
		public PriceQuantity.PriceQuantityBuilder getOrCreatePriceQuantity(int _index) {
		
			if (priceQuantity==null) {
				this.priceQuantity = new ArrayList<>();
			}
			PriceQuantity.PriceQuantityBuilder result;
			return getIndex(priceQuantity, _index, () -> {
						PriceQuantity.PriceQuantityBuilder newPriceQuantity = PriceQuantity.builder();
						return newPriceQuantity;
					});
		}
		
		@Override
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends SettlementInstructions.SettlementInstructionsBuilder> getSettlementInstructions() {
			return settlementInstructions;
		}
		
		public SettlementInstructions.SettlementInstructionsBuilder getOrCreateSettlementInstructions(int _index) {
		
			if (settlementInstructions==null) {
				this.settlementInstructions = new ArrayList<>();
			}
			SettlementInstructions.SettlementInstructionsBuilder result;
			return getIndex(settlementInstructions, _index, () -> {
						SettlementInstructions.SettlementInstructionsBuilder newSettlementInstructions = SettlementInstructions.builder();
						return newSettlementInstructions;
					});
		}
		
		@Override
		public Date getTradeDate() {
			return tradeDate;
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
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty) {
			if (ancillaryParty!=null) this.ancillaryParty.add(ancillaryParty.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(AncillaryParty ancillaryParty, int _idx) {
			getIndex(this.ancillaryParty, _idx, () -> ancillaryParty.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addAncillaryParty(List<? extends AncillaryParty> ancillaryPartys) {
			if (ancillaryPartys != null) {
				for (AncillaryParty toAdd : ancillaryPartys) {
					this.ancillaryParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setAncillaryParty(List<? extends AncillaryParty> ancillaryPartys) {
			if (ancillaryPartys == null)  {
				this.ancillaryParty = new ArrayList<>();
			}
			else {
				this.ancillaryParty = ancillaryPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty) {
			if (counterparty!=null) this.counterparty.add(counterparty.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(Counterparty counterparty, int _idx) {
			getIndex(this.counterparty, _idx, () -> counterparty.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys != null) {
				for (Counterparty toAdd : counterpartys) {
					this.counterparty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys == null)  {
				this.counterparty = new ArrayList<>();
			}
			else {
				this.counterparty = counterpartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder setExecutionDetails(ExecutionDetails executionDetails) {
			this.executionDetails = executionDetails==null?null:executionDetails.toBuilder();
			return this;
		}
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties) {
			if (parties!=null) this.parties.add(parties.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(Party parties, int _idx) {
			getIndex(this.parties, _idx, () -> parties.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addParties(List<? extends Party> partiess) {
			if (partiess != null) {
				for (Party toAdd : partiess) {
					this.parties.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setParties(List<? extends Party> partiess) {
			if (partiess == null)  {
				this.parties = new ArrayList<>();
			}
			else {
				this.parties = partiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles) {
			if (partyRoles!=null) this.partyRoles.add(partyRoles.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(PartyRole partyRoles, int _idx) {
			getIndex(this.partyRoles, _idx, () -> partyRoles.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addPartyRoles(List<? extends PartyRole> partyRoless) {
			if (partyRoless != null) {
				for (PartyRole toAdd : partyRoless) {
					this.partyRoles.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setPartyRoles(List<? extends PartyRole> partyRoless) {
			if (partyRoless == null)  {
				this.partyRoles = new ArrayList<>();
			}
			else {
				this.partyRoles = partyRoless.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity) {
			if (priceQuantity!=null) this.priceQuantity.add(priceQuantity.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(PriceQuantity priceQuantity, int _idx) {
			getIndex(this.priceQuantity, _idx, () -> priceQuantity.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys != null) {
				for (PriceQuantity toAdd : priceQuantitys) {
					this.priceQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setPriceQuantity(List<? extends PriceQuantity> priceQuantitys) {
			if (priceQuantitys == null)  {
				this.priceQuantity = new ArrayList<>();
			}
			else {
				this.priceQuantity = priceQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder setProduct(Product product) {
			this.product = product==null?null:product.toBuilder();
			return this;
		}
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(SettlementInstructions settlementInstructions) {
			if (settlementInstructions!=null) this.settlementInstructions.add(settlementInstructions.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(SettlementInstructions settlementInstructions, int _idx) {
			getIndex(this.settlementInstructions, _idx, () -> settlementInstructions.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addSettlementInstructions(List<? extends SettlementInstructions> settlementInstructionss) {
			if (settlementInstructionss != null) {
				for (SettlementInstructions toAdd : settlementInstructionss) {
					this.settlementInstructions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setSettlementInstructions(List<? extends SettlementInstructions> settlementInstructionss) {
			if (settlementInstructionss == null)  {
				this.settlementInstructions = new ArrayList<>();
			}
			else {
				this.settlementInstructions = settlementInstructionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeDate(Date tradeDate) {
			this.tradeDate = tradeDate==null?null:tradeDate;
			return this;
		}
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(Identifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(Identifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder addTradeIdentifier(List<? extends Identifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (Identifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionInstruction.ExecutionInstructionBuilder setTradeIdentifier(List<? extends Identifier> tradeIdentifiers) {
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
		public ExecutionInstruction build() {
			return new ExecutionInstruction.ExecutionInstructionImpl(this);
		}
		
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder prune() {
			ancillaryParty = ancillaryParty.stream().filter(b->b!=null).<AncillaryParty.AncillaryPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			counterparty = counterparty.stream().filter(b->b!=null).<Counterparty.CounterpartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionDetails!=null && !executionDetails.prune().hasData()) executionDetails = null;
			parties = parties.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyRoles = partyRoles.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			priceQuantity = priceQuantity.stream().filter(b->b!=null).<PriceQuantity.PriceQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (product!=null && !product.prune().hasData()) product = null;
			settlementInstructions = settlementInstructions.stream().filter(b->b!=null).<SettlementInstructions.SettlementInstructionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAncillaryParty()!=null && getAncillaryParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCounterparty()!=null && getCounterparty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExecutionDetails()!=null && getExecutionDetails().hasData()) return true;
			if (getParties()!=null && getParties().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyRoles()!=null && getPartyRoles().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPriceQuantity()!=null && getPriceQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			if (getSettlementInstructions()!=null && getSettlementInstructions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeDate()!=null) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionInstruction.ExecutionInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionInstruction.ExecutionInstructionBuilder o = (ExecutionInstruction.ExecutionInstructionBuilder) other;
			
			merger.mergeRosetta(getAncillaryParty(), o.getAncillaryParty(), this::getOrCreateAncillaryParty);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::getOrCreateCounterparty);
			merger.mergeRosetta(getExecutionDetails(), o.getExecutionDetails(), this::setExecutionDetails);
			merger.mergeRosetta(getParties(), o.getParties(), this::getOrCreateParties);
			merger.mergeRosetta(getPartyRoles(), o.getPartyRoles(), this::getOrCreatePartyRoles);
			merger.mergeRosetta(getPriceQuantity(), o.getPriceQuantity(), this::getOrCreatePriceQuantity);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			merger.mergeRosetta(getSettlementInstructions(), o.getSettlementInstructions(), this::getOrCreateSettlementInstructions);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			
			merger.mergeBasic(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(ancillaryParty, _that.getAncillaryParty())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			if (!Objects.equals(executionDetails, _that.getExecutionDetails())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			if (!ListEquals.listEquals(partyRoles, _that.getPartyRoles())) return false;
			if (!ListEquals.listEquals(priceQuantity, _that.getPriceQuantity())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(settlementInstructions, _that.getSettlementInstructions())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ancillaryParty != null ? ancillaryParty.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			_result = 31 * _result + (executionDetails != null ? executionDetails.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (partyRoles != null ? partyRoles.hashCode() : 0);
			_result = 31 * _result + (priceQuantity != null ? priceQuantity.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (settlementInstructions != null ? settlementInstructions.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionInstructionBuilder {" +
				"ancillaryParty=" + this.ancillaryParty + ", " +
				"counterparty=" + this.counterparty + ", " +
				"executionDetails=" + this.executionDetails + ", " +
				"parties=" + this.parties + ", " +
				"partyRoles=" + this.partyRoles + ", " +
				"priceQuantity=" + this.priceQuantity + ", " +
				"product=" + this.product + ", " +
				"settlementInstructions=" + this.settlementInstructions + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
}
