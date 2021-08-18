package cdm.event.common;

import cdm.base.math.Quantity;
import cdm.event.common.meta.IncreasedTradeMeta;
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
 * Specifies details for a trade to be increased as part of a reallocation event.
 * @version ${project.version}
 */
@RosettaClass

public interface IncreasedTrade extends RosettaModelObject {
	IncreasedTrade build();
	IncreasedTrade.IncreasedTradeBuilder toBuilder();
	
	/**
	 * Specifies the quantity(ies) to be increased on the trade.
	 */
	List<? extends Quantity> getQuantity();
	/**
	 * Specifies the trade to be increased.
	 */
	TradeState getTradeState();
	final static IncreasedTradeMeta metaData = new IncreasedTradeMeta();
	
	@Override
	default RosettaMetaData<? extends IncreasedTrade> metaData() {
		return metaData;
	} 
			
	static IncreasedTrade.IncreasedTradeBuilder builder() {
		return new IncreasedTrade.IncreasedTradeBuilderImpl();
	}
	
	default Class<? extends IncreasedTrade> getType() {
		return IncreasedTrade.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("tradeState"), processor, TradeState.class, getTradeState());
	}
	
	
	interface IncreasedTradeBuilder extends IncreasedTrade, RosettaModelObjectBuilder {
		Quantity.QuantityBuilder getOrCreateQuantity(int _index);
		List<? extends Quantity.QuantityBuilder> getQuantity();
		TradeState.TradeStateBuilder getOrCreateTradeState();
		TradeState.TradeStateBuilder getTradeState();
		IncreasedTrade.IncreasedTradeBuilder addQuantity(Quantity quantity);
		IncreasedTrade.IncreasedTradeBuilder addQuantity(Quantity quantity, int _idx);
		IncreasedTrade.IncreasedTradeBuilder addQuantity(List<? extends Quantity> quantity);
		IncreasedTrade.IncreasedTradeBuilder setQuantity(List<? extends Quantity> quantity);
		IncreasedTrade.IncreasedTradeBuilder setTradeState(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("tradeState"), processor, TradeState.TradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//IncreasedTrade.IncreasedTradeImpl
	class IncreasedTradeImpl implements IncreasedTrade {
		private final List<? extends Quantity> quantity;
		private final TradeState tradeState;
		
		protected IncreasedTradeImpl(IncreasedTrade.IncreasedTradeBuilder builder) {
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
		public IncreasedTrade build() {
			return this;
		}
		
		@Override
		public IncreasedTrade.IncreasedTradeBuilder toBuilder() {
			IncreasedTrade.IncreasedTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IncreasedTrade.IncreasedTradeBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IncreasedTrade _that = getType().cast(o);
		
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
			return "IncreasedTrade {" +
				"quantity=" + this.quantity + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//IncreasedTrade.IncreasedTradeBuilderImpl
	class IncreasedTradeBuilderImpl implements IncreasedTrade.IncreasedTradeBuilder {
	
		protected List<Quantity.QuantityBuilder> quantity = new ArrayList<>();
		protected TradeState.TradeStateBuilder tradeState;
	
		public IncreasedTradeBuilderImpl() {
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
		public IncreasedTrade.IncreasedTradeBuilder addQuantity(Quantity quantity) {
			if (quantity!=null) this.quantity.add(quantity.toBuilder());
			return this;
		}
		
		@Override
		public IncreasedTrade.IncreasedTradeBuilder addQuantity(Quantity quantity, int _idx) {
			getIndex(this.quantity, _idx, () -> quantity.toBuilder());
			return this;
		}
		@Override 
		public IncreasedTrade.IncreasedTradeBuilder addQuantity(List<? extends Quantity> quantitys) {
			if (quantitys != null) {
				for (Quantity toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IncreasedTrade.IncreasedTradeBuilder setQuantity(List<? extends Quantity> quantitys) {
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
		public IncreasedTrade.IncreasedTradeBuilder setTradeState(TradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public IncreasedTrade build() {
			return new IncreasedTrade.IncreasedTradeImpl(this);
		}
		
		@Override
		public IncreasedTrade.IncreasedTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IncreasedTrade.IncreasedTradeBuilder prune() {
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
		public IncreasedTrade.IncreasedTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IncreasedTrade.IncreasedTradeBuilder o = (IncreasedTrade.IncreasedTradeBuilder) other;
			
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IncreasedTrade _that = getType().cast(o);
		
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
			return "IncreasedTradeBuilder {" +
				"quantity=" + this.quantity + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
