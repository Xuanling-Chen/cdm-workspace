package cdm.event.common;

import cdm.base.math.Quantity;
import cdm.event.common.meta.DecreasedTradeMeta;
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
 * Specifies details for a trade to be decreased as part of a reallocation event.
 * @version ${project.version}
 */
@RosettaClass

public interface DecreasedTrade extends RosettaModelObject {
	DecreasedTrade build();
	DecreasedTrade.DecreasedTradeBuilder toBuilder();
	
	/**
	 * Specifies the quantity(ies) to be decreased on the trade.
	 */
	List<? extends Quantity> getQuantity();
	/**
	 * Specifies the trade to be decreased.
	 */
	TradeState getTradeState();
	final static DecreasedTradeMeta metaData = new DecreasedTradeMeta();
	
	@Override
	default RosettaMetaData<? extends DecreasedTrade> metaData() {
		return metaData;
	} 
			
	static DecreasedTrade.DecreasedTradeBuilder builder() {
		return new DecreasedTrade.DecreasedTradeBuilderImpl();
	}
	
	default Class<? extends DecreasedTrade> getType() {
		return DecreasedTrade.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("tradeState"), processor, TradeState.class, getTradeState());
	}
	
	
	interface DecreasedTradeBuilder extends DecreasedTrade, RosettaModelObjectBuilder {
		Quantity.QuantityBuilder getOrCreateQuantity(int _index);
		List<? extends Quantity.QuantityBuilder> getQuantity();
		TradeState.TradeStateBuilder getOrCreateTradeState();
		TradeState.TradeStateBuilder getTradeState();
		DecreasedTrade.DecreasedTradeBuilder addQuantity(Quantity quantity);
		DecreasedTrade.DecreasedTradeBuilder addQuantity(Quantity quantity, int _idx);
		DecreasedTrade.DecreasedTradeBuilder addQuantity(List<? extends Quantity> quantity);
		DecreasedTrade.DecreasedTradeBuilder setQuantity(List<? extends Quantity> quantity);
		DecreasedTrade.DecreasedTradeBuilder setTradeState(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("tradeState"), processor, TradeState.TradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//DecreasedTrade.DecreasedTradeImpl
	class DecreasedTradeImpl implements DecreasedTrade {
		private final List<? extends Quantity> quantity;
		private final TradeState tradeState;
		
		protected DecreasedTradeImpl(DecreasedTrade.DecreasedTradeBuilder builder) {
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends Quantity> getQuantity() {
			return quantity;
		}
		
		@Override
		public TradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public DecreasedTrade build() {
			return this;
		}
		
		@Override
		public DecreasedTrade.DecreasedTradeBuilder toBuilder() {
			DecreasedTrade.DecreasedTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DecreasedTrade.DecreasedTradeBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DecreasedTrade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DecreasedTrade {" +
				"quantity=" + this.quantity + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//DecreasedTrade.DecreasedTradeBuilderImpl
	class DecreasedTradeBuilderImpl implements DecreasedTrade.DecreasedTradeBuilder {
	
		protected List<Quantity.QuantityBuilder> quantity = new ArrayList<>();
		protected TradeState.TradeStateBuilder tradeState;
	
		public DecreasedTradeBuilderImpl() {
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
		public TradeState.TradeStateBuilder getTradeState() {
			return tradeState;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateTradeState() {
			TradeState.TradeStateBuilder result;
			if (tradeState!=null) {
				result = tradeState;
			}
			else {
				result = tradeState = TradeState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public DecreasedTrade.DecreasedTradeBuilder addQuantity(Quantity quantity) {
			if (quantity!=null) this.quantity.add(quantity.toBuilder());
			return this;
		}
		
		@Override
		public DecreasedTrade.DecreasedTradeBuilder addQuantity(Quantity quantity, int _idx) {
			getIndex(this.quantity, _idx, () -> quantity.toBuilder());
			return this;
		}
		@Override 
		public DecreasedTrade.DecreasedTradeBuilder addQuantity(List<? extends Quantity> quantitys) {
			if (quantitys != null) {
				for (Quantity toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DecreasedTrade.DecreasedTradeBuilder setQuantity(List<? extends Quantity> quantitys) {
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
		public DecreasedTrade.DecreasedTradeBuilder setTradeState(TradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public DecreasedTrade build() {
			return new DecreasedTrade.DecreasedTradeImpl(this);
		}
		
		@Override
		public DecreasedTrade.DecreasedTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DecreasedTrade.DecreasedTradeBuilder prune() {
			quantity = quantity.stream().filter(b->b!=null).<Quantity.QuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DecreasedTrade.DecreasedTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DecreasedTrade.DecreasedTradeBuilder o = (DecreasedTrade.DecreasedTradeBuilder) other;
			
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DecreasedTrade _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DecreasedTradeBuilder {" +
				"quantity=" + this.quantity + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
