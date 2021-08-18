package cdm.event.common;

import cdm.event.common.meta.StockSplitInstructionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Data required to perform a stock split business event.
 * @version ${project.version}
 */
@RosettaClass

public interface StockSplitInstruction extends RosettaModelObject {
	StockSplitInstruction build();
	StockSplitInstruction.StockSplitInstructionBuilder toBuilder();
	
	/**
	 * The number that denotes the cumulative quantity of post-split shares issued to shareholders versus the quantity of pre-split shares previously issued to shareholders.  This number will be multiplied by existing shares in an equity derivative contract or other positions to determine the post-split number of shares.  With regard to any reference to price, the pre-split reference price will be divided by this number to determine the post-split reference price.
	 */
	BigDecimal getAdjustmentRatio();
	/**
	 * The effective date of the stock split, also known as the ex-date. This is the date on which the additional shares are paid to the shareholders, or in the case of a reverse stock split, the number shares held by each shareholder is proportionally reduced.  Equity derivative transactions can be amended in firms&#39; internal systems on such date.   In most markets, the listed stock price is reduced (or increased for a reverse stock split) to account for the split on the same date, but in some markets the price adjustment occurs on a later date.  In either case, equity derivative transactions should be amended on the date that the stocks are paid to the shareholders (or consolidated).
	 */
	Date getDate();
	/**
	 * Contract to be split.
	 */
	TradeState getTradeState();
	final static StockSplitInstructionMeta metaData = new StockSplitInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends StockSplitInstruction> metaData() {
		return metaData;
	} 
			
	static StockSplitInstruction.StockSplitInstructionBuilder builder() {
		return new StockSplitInstruction.StockSplitInstructionBuilderImpl();
	}
	
	default Class<? extends StockSplitInstruction> getType() {
		return StockSplitInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustmentRatio"), BigDecimal.class, getAdjustmentRatio(), this);
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		
		processRosetta(path.newSubPath("tradeState"), processor, TradeState.class, getTradeState());
	}
	
	
	interface StockSplitInstructionBuilder extends StockSplitInstruction, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateTradeState();
		TradeState.TradeStateBuilder getTradeState();
		StockSplitInstruction.StockSplitInstructionBuilder setAdjustmentRatio(BigDecimal adjustmentRatio);
		StockSplitInstruction.StockSplitInstructionBuilder setDate(Date date);
		StockSplitInstruction.StockSplitInstructionBuilder setTradeState(TradeState tradeState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustmentRatio"), BigDecimal.class, getAdjustmentRatio(), this);
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			
			processRosetta(path.newSubPath("tradeState"), processor, TradeState.TradeStateBuilder.class, getTradeState());
		}
		
	}
	
	//StockSplitInstruction.StockSplitInstructionImpl
	class StockSplitInstructionImpl implements StockSplitInstruction {
		private final BigDecimal adjustmentRatio;
		private final Date date;
		private final TradeState tradeState;
		
		protected StockSplitInstructionImpl(StockSplitInstruction.StockSplitInstructionBuilder builder) {
			this.adjustmentRatio = builder.getAdjustmentRatio();
			this.date = builder.getDate();
			this.tradeState = ofNullable(builder.getTradeState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getAdjustmentRatio() {
			return adjustmentRatio;
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public TradeState getTradeState() {
			return tradeState;
		}
		
		@Override
		public StockSplitInstruction build() {
			return this;
		}
		
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder toBuilder() {
			StockSplitInstruction.StockSplitInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StockSplitInstruction.StockSplitInstructionBuilder builder) {
			ofNullable(getAdjustmentRatio()).ifPresent(builder::setAdjustmentRatio);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTradeState()).ifPresent(builder::setTradeState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StockSplitInstruction _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentRatio, _that.getAdjustmentRatio())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentRatio != null ? adjustmentRatio.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StockSplitInstruction {" +
				"adjustmentRatio=" + this.adjustmentRatio + ", " +
				"date=" + this.date + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
	
	//StockSplitInstruction.StockSplitInstructionBuilderImpl
	class StockSplitInstructionBuilderImpl implements StockSplitInstruction.StockSplitInstructionBuilder {
	
		protected BigDecimal adjustmentRatio;
		protected Date date;
		protected TradeState.TradeStateBuilder tradeState;
	
		public StockSplitInstructionBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAdjustmentRatio() {
			return adjustmentRatio;
		}
		
		@Override
		public Date getDate() {
			return date;
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
		public StockSplitInstruction.StockSplitInstructionBuilder setAdjustmentRatio(BigDecimal adjustmentRatio) {
			this.adjustmentRatio = adjustmentRatio==null?null:adjustmentRatio;
			return this;
		}
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder setTradeState(TradeState tradeState) {
			this.tradeState = tradeState==null?null:tradeState.toBuilder();
			return this;
		}
		
		@Override
		public StockSplitInstruction build() {
			return new StockSplitInstruction.StockSplitInstructionImpl(this);
		}
		
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder prune() {
			if (tradeState!=null && !tradeState.prune().hasData()) tradeState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustmentRatio()!=null) return true;
			if (getDate()!=null) return true;
			if (getTradeState()!=null && getTradeState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StockSplitInstruction.StockSplitInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StockSplitInstruction.StockSplitInstructionBuilder o = (StockSplitInstruction.StockSplitInstructionBuilder) other;
			
			merger.mergeRosetta(getTradeState(), o.getTradeState(), this::setTradeState);
			
			merger.mergeBasic(getAdjustmentRatio(), o.getAdjustmentRatio(), this::setAdjustmentRatio);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StockSplitInstruction _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentRatio, _that.getAdjustmentRatio())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tradeState, _that.getTradeState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentRatio != null ? adjustmentRatio.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tradeState != null ? tradeState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StockSplitInstructionBuilder {" +
				"adjustmentRatio=" + this.adjustmentRatio + ", " +
				"date=" + this.date + ", " +
				"tradeState=" + this.tradeState +
			'}';
		}
	}
}
