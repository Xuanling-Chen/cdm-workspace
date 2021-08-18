package cdm.event.common;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder;
import cdm.event.common.meta.EventEffectMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.event.common.metafields.ReferenceWithMetaTransferPrimitive;
import cdm.event.common.metafields.ReferenceWithMetaTransferPrimitive.ReferenceWithMetaTransferPrimitiveBuilder;
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
 * The set of operational and positional effects associated with a lifecycle event, alongside the reference to the contract reference(s) that is subject to the event (and is positioned in the before state of the event primitive).
 * @version ${project.version}
 */
@RosettaClass

public interface EventEffect extends RosettaModelObject {
	EventEffect build();
	EventEffect.EventEffectBuilder toBuilder();
	
	/**
	 * A pointer to the trade(s) to which the event effect(s) apply, i.e. in the before event state.
	 */
	List<? extends ReferenceWithMetaTradeState> getEffectedTrade();
	/**
	 * A pointer to the product identifier effect(s), an example of such being the outcome of the physical exercise of a bond option.
	 */
	List<? extends ReferenceWithMetaProductIdentifier> getProductIdentifier();
	/**
	 * A pointer to the trade effect(s), an example of such being the outcome of a new trade, swaption exercise or novation event.
	 */
	List<? extends ReferenceWithMetaTradeState> getTrade();
	/**
	 * A pointer to the transfer effect(s), either a cash, security or other asset.
	 */
	List<? extends ReferenceWithMetaTransferPrimitive> getTransfer();
	final static EventEffectMeta metaData = new EventEffectMeta();
	
	@Override
	default RosettaMetaData<? extends EventEffect> metaData() {
		return metaData;
	} 
			
	static EventEffect.EventEffectBuilder builder() {
		return new EventEffect.EventEffectBuilderImpl();
	}
	
	default Class<? extends EventEffect> getType() {
		return EventEffect.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("effectedTrade"), processor, ReferenceWithMetaTradeState.class, getEffectedTrade());
		processRosetta(path.newSubPath("productIdentifier"), processor, ReferenceWithMetaProductIdentifier.class, getProductIdentifier());
		processRosetta(path.newSubPath("trade"), processor, ReferenceWithMetaTradeState.class, getTrade());
		processRosetta(path.newSubPath("transfer"), processor, ReferenceWithMetaTransferPrimitive.class, getTransfer());
	}
	
	
	interface EventEffectBuilder extends EventEffect, RosettaModelObjectBuilder {
		ReferenceWithMetaTradeStateBuilder getOrCreateEffectedTrade(int _index);
		List<? extends ReferenceWithMetaTradeStateBuilder> getEffectedTrade();
		ReferenceWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index);
		List<? extends ReferenceWithMetaProductIdentifierBuilder> getProductIdentifier();
		ReferenceWithMetaTradeStateBuilder getOrCreateTrade(int _index);
		List<? extends ReferenceWithMetaTradeStateBuilder> getTrade();
		ReferenceWithMetaTransferPrimitiveBuilder getOrCreateTransfer(int _index);
		List<? extends ReferenceWithMetaTransferPrimitiveBuilder> getTransfer();
		EventEffect.EventEffectBuilder addEffectedTrade(ReferenceWithMetaTradeState effectedTrade);
		EventEffect.EventEffectBuilder addEffectedTrade(ReferenceWithMetaTradeState effectedTrade, int _idx);
		EventEffect.EventEffectBuilder addEffectedTradeValue(TradeState effectedTrade);
		EventEffect.EventEffectBuilder addEffectedTradeValue(TradeState effectedTrade, int _idx);
		EventEffect.EventEffectBuilder addEffectedTrade(List<? extends ReferenceWithMetaTradeState> effectedTrade);
		EventEffect.EventEffectBuilder setEffectedTrade(List<? extends ReferenceWithMetaTradeState> effectedTrade);
		EventEffect.EventEffectBuilder addEffectedTradeValue(List<? extends TradeState> effectedTrade);
		EventEffect.EventEffectBuilder setEffectedTradeValue(List<? extends TradeState> effectedTrade);
		EventEffect.EventEffectBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		EventEffect.EventEffectBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		EventEffect.EventEffectBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		EventEffect.EventEffectBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		EventEffect.EventEffectBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		EventEffect.EventEffectBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		EventEffect.EventEffectBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		EventEffect.EventEffectBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		EventEffect.EventEffectBuilder addTrade(ReferenceWithMetaTradeState trade);
		EventEffect.EventEffectBuilder addTrade(ReferenceWithMetaTradeState trade, int _idx);
		EventEffect.EventEffectBuilder addTradeValue(TradeState trade);
		EventEffect.EventEffectBuilder addTradeValue(TradeState trade, int _idx);
		EventEffect.EventEffectBuilder addTrade(List<? extends ReferenceWithMetaTradeState> trade);
		EventEffect.EventEffectBuilder setTrade(List<? extends ReferenceWithMetaTradeState> trade);
		EventEffect.EventEffectBuilder addTradeValue(List<? extends TradeState> trade);
		EventEffect.EventEffectBuilder setTradeValue(List<? extends TradeState> trade);
		EventEffect.EventEffectBuilder addTransfer(ReferenceWithMetaTransferPrimitive transfer);
		EventEffect.EventEffectBuilder addTransfer(ReferenceWithMetaTransferPrimitive transfer, int _idx);
		EventEffect.EventEffectBuilder addTransferValue(TransferPrimitive transfer);
		EventEffect.EventEffectBuilder addTransferValue(TransferPrimitive transfer, int _idx);
		EventEffect.EventEffectBuilder addTransfer(List<? extends ReferenceWithMetaTransferPrimitive> transfer);
		EventEffect.EventEffectBuilder setTransfer(List<? extends ReferenceWithMetaTransferPrimitive> transfer);
		EventEffect.EventEffectBuilder addTransferValue(List<? extends TransferPrimitive> transfer);
		EventEffect.EventEffectBuilder setTransferValue(List<? extends TransferPrimitive> transfer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("effectedTrade"), processor, ReferenceWithMetaTradeStateBuilder.class, getEffectedTrade());
			processRosetta(path.newSubPath("productIdentifier"), processor, ReferenceWithMetaProductIdentifierBuilder.class, getProductIdentifier());
			processRosetta(path.newSubPath("trade"), processor, ReferenceWithMetaTradeStateBuilder.class, getTrade());
			processRosetta(path.newSubPath("transfer"), processor, ReferenceWithMetaTransferPrimitiveBuilder.class, getTransfer());
		}
		
	}
	
	//EventEffect.EventEffectImpl
	class EventEffectImpl implements EventEffect {
		private final List<? extends ReferenceWithMetaTradeState> effectedTrade;
		private final List<? extends ReferenceWithMetaProductIdentifier> productIdentifier;
		private final List<? extends ReferenceWithMetaTradeState> trade;
		private final List<? extends ReferenceWithMetaTransferPrimitive> transfer;
		
		protected EventEffectImpl(EventEffect.EventEffectBuilder builder) {
			this.effectedTrade = ofNullable(builder.getEffectedTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trade = ofNullable(builder.getTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeState> getEffectedTrade() {
			return effectedTrade;
		}
		
		@Override
		public List<? extends ReferenceWithMetaProductIdentifier> getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeState> getTrade() {
			return trade;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTransferPrimitive> getTransfer() {
			return transfer;
		}
		
		@Override
		public EventEffect build() {
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder toBuilder() {
			EventEffect.EventEffectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventEffect.EventEffectBuilder builder) {
			ofNullable(getEffectedTrade()).ifPresent(builder::setEffectedTrade);
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventEffect _that = getType().cast(o);
		
			if (!ListEquals.listEquals(effectedTrade, _that.getEffectedTrade())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectedTrade != null ? effectedTrade.hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventEffect {" +
				"effectedTrade=" + this.effectedTrade + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"trade=" + this.trade + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
	
	//EventEffect.EventEffectBuilderImpl
	class EventEffectBuilderImpl implements EventEffect.EventEffectBuilder {
	
		protected List<ReferenceWithMetaTradeStateBuilder> effectedTrade = new ArrayList<>();
		protected List<ReferenceWithMetaProductIdentifierBuilder> productIdentifier = new ArrayList<>();
		protected List<ReferenceWithMetaTradeStateBuilder> trade = new ArrayList<>();
		protected List<ReferenceWithMetaTransferPrimitiveBuilder> transfer = new ArrayList<>();
	
		public EventEffectBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaTradeStateBuilder> getEffectedTrade() {
			return effectedTrade;
		}
		
		public ReferenceWithMetaTradeStateBuilder getOrCreateEffectedTrade(int _index) {
		
			if (effectedTrade==null) {
				this.effectedTrade = new ArrayList<>();
			}
			ReferenceWithMetaTradeStateBuilder result;
			return getIndex(effectedTrade, _index, () -> {
						ReferenceWithMetaTradeStateBuilder newEffectedTrade = ReferenceWithMetaTradeState.builder();
						return newEffectedTrade;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaProductIdentifierBuilder> getProductIdentifier() {
			return productIdentifier;
		}
		
		public ReferenceWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index) {
		
			if (productIdentifier==null) {
				this.productIdentifier = new ArrayList<>();
			}
			ReferenceWithMetaProductIdentifierBuilder result;
			return getIndex(productIdentifier, _index, () -> {
						ReferenceWithMetaProductIdentifierBuilder newProductIdentifier = ReferenceWithMetaProductIdentifier.builder();
						return newProductIdentifier;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeStateBuilder> getTrade() {
			return trade;
		}
		
		public ReferenceWithMetaTradeStateBuilder getOrCreateTrade(int _index) {
		
			if (trade==null) {
				this.trade = new ArrayList<>();
			}
			ReferenceWithMetaTradeStateBuilder result;
			return getIndex(trade, _index, () -> {
						ReferenceWithMetaTradeStateBuilder newTrade = ReferenceWithMetaTradeState.builder();
						return newTrade;
					});
		}
		
		@Override
		public List<? extends ReferenceWithMetaTransferPrimitiveBuilder> getTransfer() {
			return transfer;
		}
		
		public ReferenceWithMetaTransferPrimitiveBuilder getOrCreateTransfer(int _index) {
		
			if (transfer==null) {
				this.transfer = new ArrayList<>();
			}
			ReferenceWithMetaTransferPrimitiveBuilder result;
			return getIndex(transfer, _index, () -> {
						ReferenceWithMetaTransferPrimitiveBuilder newTransfer = ReferenceWithMetaTransferPrimitive.builder();
						return newTransfer;
					});
		}
		
	
		@Override
		public EventEffect.EventEffectBuilder addEffectedTrade(ReferenceWithMetaTradeState effectedTrade) {
			if (effectedTrade!=null) this.effectedTrade.add(effectedTrade.toBuilder());
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addEffectedTrade(ReferenceWithMetaTradeState effectedTrade, int _idx) {
			getIndex(this.effectedTrade, _idx, () -> effectedTrade.toBuilder());
			return this;
		}
		
			@Override
			public EventEffect.EventEffectBuilder addEffectedTradeValue(TradeState effectedTrade) {
				this.getOrCreateEffectedTrade(-1).setValue(effectedTrade.toBuilder());
				return this;
			}
			
			@Override
			public EventEffect.EventEffectBuilder addEffectedTradeValue(TradeState effectedTrade, int _idx) {
				this.getOrCreateEffectedTrade(_idx).setValue(effectedTrade.toBuilder());
				return this;
			}
		@Override 
		public EventEffect.EventEffectBuilder addEffectedTrade(List<? extends ReferenceWithMetaTradeState> effectedTrades) {
			if (effectedTrades != null) {
				for (ReferenceWithMetaTradeState toAdd : effectedTrades) {
					this.effectedTrade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventEffect.EventEffectBuilder setEffectedTrade(List<? extends ReferenceWithMetaTradeState> effectedTrades) {
			if (effectedTrades == null)  {
				this.effectedTrade = new ArrayList<>();
			}
			else {
				this.effectedTrade = effectedTrades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addEffectedTradeValue(List<? extends TradeState> effectedTrades) {
			if (effectedTrades != null) {
				for (TradeState toAdd : effectedTrades) {
					this.addEffectedTradeValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder setEffectedTradeValue(List<? extends TradeState> effectedTrades) {
			this.effectedTrade.clear();
			if (effectedTrades!=null) {
				effectedTrades.forEach(this::addEffectedTradeValue);
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public EventEffect.EventEffectBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public EventEffect.EventEffectBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public EventEffect.EventEffectBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventEffect.EventEffectBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers == null)  {
				this.productIdentifier = new ArrayList<>();
			}
			else {
				this.productIdentifier = productIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTrade(ReferenceWithMetaTradeState trade) {
			if (trade!=null) this.trade.add(trade.toBuilder());
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTrade(ReferenceWithMetaTradeState trade, int _idx) {
			getIndex(this.trade, _idx, () -> trade.toBuilder());
			return this;
		}
		
			@Override
			public EventEffect.EventEffectBuilder addTradeValue(TradeState trade) {
				this.getOrCreateTrade(-1).setValue(trade.toBuilder());
				return this;
			}
			
			@Override
			public EventEffect.EventEffectBuilder addTradeValue(TradeState trade, int _idx) {
				this.getOrCreateTrade(_idx).setValue(trade.toBuilder());
				return this;
			}
		@Override 
		public EventEffect.EventEffectBuilder addTrade(List<? extends ReferenceWithMetaTradeState> trades) {
			if (trades != null) {
				for (ReferenceWithMetaTradeState toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventEffect.EventEffectBuilder setTrade(List<? extends ReferenceWithMetaTradeState> trades) {
			if (trades == null)  {
				this.trade = new ArrayList<>();
			}
			else {
				this.trade = trades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTradeValue(List<? extends TradeState> trades) {
			if (trades != null) {
				for (TradeState toAdd : trades) {
					this.addTradeValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder setTradeValue(List<? extends TradeState> trades) {
			this.trade.clear();
			if (trades!=null) {
				trades.forEach(this::addTradeValue);
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTransfer(ReferenceWithMetaTransferPrimitive transfer) {
			if (transfer!=null) this.transfer.add(transfer.toBuilder());
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTransfer(ReferenceWithMetaTransferPrimitive transfer, int _idx) {
			getIndex(this.transfer, _idx, () -> transfer.toBuilder());
			return this;
		}
		
			@Override
			public EventEffect.EventEffectBuilder addTransferValue(TransferPrimitive transfer) {
				this.getOrCreateTransfer(-1).setValue(transfer.toBuilder());
				return this;
			}
			
			@Override
			public EventEffect.EventEffectBuilder addTransferValue(TransferPrimitive transfer, int _idx) {
				this.getOrCreateTransfer(_idx).setValue(transfer.toBuilder());
				return this;
			}
		@Override 
		public EventEffect.EventEffectBuilder addTransfer(List<? extends ReferenceWithMetaTransferPrimitive> transfers) {
			if (transfers != null) {
				for (ReferenceWithMetaTransferPrimitive toAdd : transfers) {
					this.transfer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EventEffect.EventEffectBuilder setTransfer(List<? extends ReferenceWithMetaTransferPrimitive> transfers) {
			if (transfers == null)  {
				this.transfer = new ArrayList<>();
			}
			else {
				this.transfer = transfers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder addTransferValue(List<? extends TransferPrimitive> transfers) {
			if (transfers != null) {
				for (TransferPrimitive toAdd : transfers) {
					this.addTransferValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EventEffect.EventEffectBuilder setTransferValue(List<? extends TransferPrimitive> transfers) {
			this.transfer.clear();
			if (transfers!=null) {
				transfers.forEach(this::addTransferValue);
			}
			return this;
		}
		
		
		@Override
		public EventEffect build() {
			return new EventEffect.EventEffectImpl(this);
		}
		
		@Override
		public EventEffect.EventEffectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventEffect.EventEffectBuilder prune() {
			effectedTrade = effectedTrade.stream().filter(b->b!=null).<ReferenceWithMetaTradeStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productIdentifier = productIdentifier.stream().filter(b->b!=null).<ReferenceWithMetaProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			trade = trade.stream().filter(b->b!=null).<ReferenceWithMetaTradeStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transfer = transfer.stream().filter(b->b!=null).<ReferenceWithMetaTransferPrimitiveBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectedTrade()!=null && getEffectedTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductIdentifier()!=null && getProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrade()!=null && getTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransfer()!=null && getTransfer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventEffect.EventEffectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventEffect.EventEffectBuilder o = (EventEffect.EventEffectBuilder) other;
			
			merger.mergeRosetta(getEffectedTrade(), o.getEffectedTrade(), this::getOrCreateEffectedTrade);
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::getOrCreateProductIdentifier);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::getOrCreateTrade);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::getOrCreateTransfer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventEffect _that = getType().cast(o);
		
			if (!ListEquals.listEquals(effectedTrade, _that.getEffectedTrade())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(transfer, _that.getTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectedTrade != null ? effectedTrade.hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventEffectBuilder {" +
				"effectedTrade=" + this.effectedTrade + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"trade=" + this.trade + ", " +
				"transfer=" + this.transfer +
			'}';
		}
	}
}
