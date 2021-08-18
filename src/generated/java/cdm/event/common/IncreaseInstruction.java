package cdm.event.common;

import cdm.event.common.meta.IncreaseInstructionMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.SettlementTerms;
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
 * Instructions required to create an Increase Business Event. An increase effectively adds a new trade lot to the original trade.
 * @version ${project.version}
 */
@RosettaClass

public interface IncreaseInstruction extends RosettaModelObject {
	IncreaseInstruction build();
	IncreaseInstruction.IncreaseInstructionBuilder toBuilder();
	
	/**
	 * Fee agreed to be exchanged as part of the trade increase (optional).
	 */
	SettlementTerms getFee();
	/**
	 * Trade lot containing the quantity by which the trade is being increased, and the price and effective date of that increase.
	 */
	TradeLot getTradeLot();
	/**
	 * Reference to the trade that is being increased.
	 */
	ReferenceWithMetaTradeState getTradeState();
	final static IncreaseInstructionMeta metaData = new IncreaseInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends IncreaseInstruction> metaData() {
		return metaData;
	} 
			
	static IncreaseInstruction.IncreaseInstructionBuilder builder() {
		return new IncreaseInstruction.IncreaseInstructionBuilderImpl();
	}
	
	default Class<? extends IncreaseInstruction> getType() {
		return IncreaseInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("fee"), processor, SettlementTerms.class, getFee());
		processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.class, getTradeLot());
		processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeState.class, getTradeState());
	}
	
	
	interface IncreaseInstructionBuilder extends IncreaseInstruction, RosettaModelObjectBuilder {
		SettlementTerms.SettlementTermsBuilder getOrCreateFee();
		SettlementTerms.SettlementTermsBuilder getFee();
		TradeLot.TradeLotBuilder getOrCreateTradeLot();
		TradeLot.TradeLotBuilder getTradeLot();
		ReferenceWithMetaTradeStateBuilder getOrCreateTradeState();
		ReferenceWithMetaTradeStateBuilder getTradeState();
		IncreaseInstruction.IncreaseInstructionBuilder setFee(SettlementTerms fee);
		IncreaseInstruction.IncreaseInstructionBuilder setTradeLot(TradeLot tradeLot);
		IncreaseInstruction.IncreaseInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState);
		IncreaseInstruction.IncreaseInstructionBuilder setTradeStateValue(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("fee"), processor, SettlementTerms.SettlementTermsBuilder.class, getFee());
			processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.TradeLotBuilder.class, getTradeLot());
			processRosetta(path.newSubPath("tradeState"), processor, ReferenceWithMetaTradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//IncreaseInstruction.IncreaseInstructionImpl
	class IncreaseInstructionImpl implements IncreaseInstruction {
		private final SettlementTerms fee;
		private final TradeLot tradeLot;
		private final ReferenceWithMetaTradeState tradeState;
		
		protected IncreaseInstructionImpl(IncreaseInstruction.IncreaseInstructionBuilder builder) {
			this.fee = ofNullable(builder.getFee()).map(f->f.build()).orElse(null);
			this.tradeLot = ofNullable(builder.getTradeLot()).map(f->f.build()).orElse(null);
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SettlementTerms getFee() {
			return fee;
		}
		
		@Override
		public TradeLot getTradeLot() {
			return tradeLot;
		}
		
		@Override
		public ReferenceWithMetaTradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public IncreaseInstruction build() {
			return this;
		}
		
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder toBuilder() {
			IncreaseInstruction.IncreaseInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IncreaseInstruction.IncreaseInstructionBuilder builder) {
			ofNullable(getFee()).ifPresent(builder::setFee);
			ofNullable(getTradeLot()).ifPresent(builder::setTradeLot);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IncreaseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!Objects.equals(tradeLot, _that.getTradeLot())) return false;
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
			return "IncreaseInstruction {" +
				"fee=" + this.fee + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//IncreaseInstruction.IncreaseInstructionBuilderImpl
	class IncreaseInstructionBuilderImpl implements IncreaseInstruction.IncreaseInstructionBuilder {
	
		protected SettlementTerms.SettlementTermsBuilder fee;
		protected TradeLot.TradeLotBuilder tradeLot;
		protected ReferenceWithMetaTradeStateBuilder tradeState;
	
		public IncreaseInstructionBuilderImpl() {
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
		public TradeLot.TradeLotBuilder getTradeLot() {
			return tradeLot;
		}
		
		@Override
		public TradeLot.TradeLotBuilder getOrCreateTradeLot() {
			TradeLot.TradeLotBuilder result;
			if (tradeLot!=null) {
				result = tradeLot;
			}
			else {
				result = tradeLot = TradeLot.builder();
			}
			
			return result;
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
		public IncreaseInstruction.IncreaseInstructionBuilder setFee(SettlementTerms fee) {
			this.fee = fee==null?null:fee.toBuilder();
			return this;
		}
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder setTradeLot(TradeLot tradeLot) {
			this.tradeLot = tradeLot==null?null:tradeLot.toBuilder();
			return this;
		}
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder setTradeState(ReferenceWithMetaTradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder setTradeStateValue(TradeState tradeState) {
			this.getOrCreateTradeState().setValue(tradeState);
			return this;
		}
		
		@Override
		public IncreaseInstruction build() {
			return new IncreaseInstruction.IncreaseInstructionImpl(this);
		}
		
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder prune() {
			if (fee!=null && !fee.prune().hasData()) fee = null;
			if (tradeLot!=null && !tradeLot.prune().hasData()) tradeLot = null;
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFee()!=null && getFee().hasData()) return true;
			if (getTradeLot()!=null && getTradeLot().hasData()) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IncreaseInstruction.IncreaseInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IncreaseInstruction.IncreaseInstructionBuilder o = (IncreaseInstruction.IncreaseInstructionBuilder) other;
			
			merger.mergeRosetta(getFee(), o.getFee(), this::setFee);
			merger.mergeRosetta(getTradeLot(), o.getTradeLot(), this::setTradeLot);
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IncreaseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!Objects.equals(tradeLot, _that.getTradeLot())) return false;
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
			return "IncreaseInstructionBuilder {" +
				"fee=" + this.fee + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
