package cdm.event.common;

import cdm.event.common.meta.DecreaseInstructionMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.SettlementTerms;
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
 * Instructions required to create a Decrease Business Event (i.e. Partial or Full Termination). A decrease effectively decreases one or more trade lots contained in the original trade.
 * @version ${project.version}
 */
@RosettaClass

public interface DecreaseInstruction extends RosettaModelObject {
	DecreaseInstruction build();
	DecreaseInstruction.DecreaseInstructionBuilder toBuilder();
	
	/**
	 * Fee agreed to be exchanged as part of the trade decrease (optional).
	 */
	SettlementTerms getFee();
	/**
	 * Trade lots containing the quantity being decreased, and the price and effective date of each decrease. Attribute is of multiple cardinality, to be used to specify exactly which lots / IDs are being decreased. A client could opt not to specify this and indicate just 1 lot and no ID, and implementations should then enrich these details based on unwind method (e.g. FIFO, LIFO, etc).
	 */
	List<? extends TradeLot> getTradeLot();
	/**
	 * Reference to the trade that is being decreased.
	 */
	ReferenceWithMetaTradeState getTradeState();
	final static DecreaseInstructionMeta metaData = new DecreaseInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends DecreaseInstruction> metaData() {
		return metaData;
	} 
			
	static DecreaseInstruction.DecreaseInstructionBuilder builder() {
		return new DecreaseInstruction.DecreaseInstructionBuilderImpl();
	}
	
	default Class<? extends DecreaseInstruction> getType() {
		return DecreaseInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("fee"), processor, SettlementTerms.class, getFee());
		processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.class, getTradeLot());
		processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeState.class, getTradeState());
	}
	
	
	interface DecreaseInstructionBuilder extends DecreaseInstruction, RosettaModelObjectBuilder {
		SettlementTerms.SettlementTermsBuilder getOrCreateFee();
		SettlementTerms.SettlementTermsBuilder getFee();
		TradeLot.TradeLotBuilder getOrCreateTradeLot(int _index);
		List<? extends TradeLot.TradeLotBuilder> getTradeLot();
		ReferenceWithMetaTradeStateBuilder getOrCreateTradeState();
		ReferenceWithMetaTradeStateBuilder getTradeState();
		DecreaseInstruction.DecreaseInstructionBuilder setFee(SettlementTerms fee);
		DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(TradeLot tradeLot);
		DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(TradeLot tradeLot, int _idx);
		DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(List<? extends TradeLot> tradeLot);
		DecreaseInstruction.DecreaseInstructionBuilder setTradeLot(List<? extends TradeLot> tradeLot);
		DecreaseInstruction.DecreaseInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState);
		DecreaseInstruction.DecreaseInstructionBuilder setTradeStateValue(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("fee"), processor, SettlementTerms.SettlementTermsBuilder.class, getFee());
			processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.TradeLotBuilder.class, getTradeLot());
			processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//DecreaseInstruction.DecreaseInstructionImpl
	class DecreaseInstructionImpl implements DecreaseInstruction {
		private final SettlementTerms fee;
		private final List<? extends TradeLot> tradeLot;
		private final ReferenceWithMetaTradeState tradeState;
		
		protected DecreaseInstructionImpl(DecreaseInstruction.DecreaseInstructionBuilder builder) {
			this.fee = ofNullable(builder.getFee()).map(f->f.build()).orElse(null);
			this.tradeLot = ofNullable(builder.getTradeLot()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SettlementTerms getFee() {
			return fee;
		}
		
		@Override
		public List<? extends TradeLot> getTradeLot() {
			return tradeLot;
		}
		
		@Override
		public ReferenceWithMetaTradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public DecreaseInstruction build() {
			return this;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder toBuilder() {
			DecreaseInstruction.DecreaseInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DecreaseInstruction.DecreaseInstructionBuilder builder) {
			ofNullable(getFee()).ifPresent(builder::setFee);
			ofNullable(getTradeLot()).ifPresent(builder::setTradeLot);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DecreaseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!ListEquals.listEquals(tradeLot, _that.getTradeLot())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fee != null ? fee.hashCode() : 0);
			_result = 31 * _result + (tradeLot != null ? tradeLot.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DecreaseInstruction {" +
				"fee=" + this.fee + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//DecreaseInstruction.DecreaseInstructionBuilderImpl
	class DecreaseInstructionBuilderImpl implements DecreaseInstruction.DecreaseInstructionBuilder {
	
		protected SettlementTerms.SettlementTermsBuilder fee;
		protected List<TradeLot.TradeLotBuilder> tradeLot = new ArrayList<>();
		protected ReferenceWithMetaTradeStateBuilder tradeState;
	
		public DecreaseInstructionBuilderImpl() {
		}
	
		@Override
		public SettlementTerms.SettlementTermsBuilder getFee() {
			return fee;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateFee() {
			SettlementTerms.SettlementTermsBuilder result;
			if (fee!=null) {
				result = fee;
			}
			else {
				result = fee = SettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends TradeLot.TradeLotBuilder> getTradeLot() {
			return tradeLot;
		}
		
		public TradeLot.TradeLotBuilder getOrCreateTradeLot(int _index) {
		
			if (tradeLot==null) {
				this.tradeLot = new ArrayList<>();
			}
			TradeLot.TradeLotBuilder result;
			return getIndex(tradeLot, _index, () -> {
						TradeLot.TradeLotBuilder newTradeLot = TradeLot.builder();
						return newTradeLot;
					});
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getTradeState() {
			return tradeState;
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getOrCreateTradeState() {
			ReferenceWithMetaTradeStateBuilder result;
			if (tradeState!=null) {
				result = tradeState;
			}
			else {
				result = tradeState = ReferenceWithMetaTradeState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder setFee(SettlementTerms fee) {
			this.fee = fee==null?null:fee.toBuilder();
			return this;
		}
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(TradeLot tradeLot) {
			if (tradeLot!=null) this.tradeLot.add(tradeLot.toBuilder());
			return this;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(TradeLot tradeLot, int _idx) {
			getIndex(this.tradeLot, _idx, () -> tradeLot.toBuilder());
			return this;
		}
		@Override 
		public DecreaseInstruction.DecreaseInstructionBuilder addTradeLot(List<? extends TradeLot> tradeLots) {
			if (tradeLots != null) {
				for (TradeLot toAdd : tradeLots) {
					this.tradeLot.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DecreaseInstruction.DecreaseInstructionBuilder setTradeLot(List<? extends TradeLot> tradeLots) {
			if (tradeLots == null)  {
				this.tradeLot = new ArrayList<>();
			}
			else {
				this.tradeLot = tradeLots.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder setTradeStateValue(TradeState tradeState) {
			this.getOrCreateTradeState().setValue(tradeState);
			return this;
		}
		
		@Override
		public DecreaseInstruction build() {
			return new DecreaseInstruction.DecreaseInstructionImpl(this);
		}
		
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder prune() {
			if (fee!=null && !fee.prune().hasData()) fee = null;
			tradeLot = tradeLot.stream().filter(b->b!=null).<TradeLot.TradeLotBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFee()!=null && getFee().hasData()) return true;
			if (getTradeLot()!=null && getTradeLot().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DecreaseInstruction.DecreaseInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DecreaseInstruction.DecreaseInstructionBuilder o = (DecreaseInstruction.DecreaseInstructionBuilder) other;
			
			merger.mergeRosetta(getFee(), o.getFee(), this::setFee);
			merger.mergeRosetta(getTradeLot(), o.getTradeLot(), this::getOrCreateTradeLot);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DecreaseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!ListEquals.listEquals(tradeLot, _that.getTradeLot())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fee != null ? fee.hashCode() : 0);
			_result = 31 * _result + (tradeLot != null ? tradeLot.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DecreaseInstructionBuilder {" +
				"fee=" + this.fee + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
