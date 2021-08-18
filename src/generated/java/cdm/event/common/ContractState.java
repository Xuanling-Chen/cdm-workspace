package cdm.event.common;

import cdm.event.common.meta.ContractStateMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a contract state instantiation with respect to the before and/or after state of lifecycle events.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractState extends RosettaModelObject, GlobalKey {
	ContractState build();
	ContractState.ContractStateBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * Reference to the original contract, such that the contract state can be resolved by super-imposing the updated values on top of the original contract.
	 */
	Trade getTrade();
	/**
	 * The state of the contract, represented as a replica of the original contract with updated values where applicable, e.g. in the case of resets.
	 */
	Trade getUpdatedTrade();
	final static ContractStateMeta metaData = new ContractStateMeta();
	
	@Override
	default RosettaMetaData<? extends ContractState> metaData() {
		return metaData;
	} 
			
	static ContractState.ContractStateBuilder builder() {
		return new ContractState.ContractStateBuilderImpl();
	}
	
	default Class<? extends ContractState> getType() {
		return ContractState.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("updatedTrade"), processor, Trade.class, getUpdatedTrade());
	}
	
	
	interface ContractStateBuilder extends ContractState, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		Trade.TradeBuilder getOrCreateUpdatedTrade();
		Trade.TradeBuilder getUpdatedTrade();
		ContractState.ContractStateBuilder setMeta(MetaFields meta);
		ContractState.ContractStateBuilder setTrade(Trade trade);
		ContractState.ContractStateBuilder setUpdatedTrade(Trade updatedTrade);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("updatedTrade"), processor, Trade.TradeBuilder.class, getUpdatedTrade());
		}
		
	}
	
	//ContractState.ContractStateImpl
	class ContractStateImpl implements ContractState {
		private final MetaFields meta;
		private final Trade trade;
		private final Trade updatedTrade;
		
		protected ContractStateImpl(ContractState.ContractStateBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.updatedTrade = ofNullable(builder.getUpdatedTrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		public Trade getUpdatedTrade() {
			return updatedTrade;
		}
		
		@Override
		public ContractState build() {
			return this;
		}
		
		@Override
		public ContractState.ContractStateBuilder toBuilder() {
			ContractState.ContractStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractState.ContractStateBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getUpdatedTrade()).ifPresent(builder::setUpdatedTrade);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractState _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(updatedTrade, _that.getUpdatedTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (updatedTrade != null ? updatedTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractState {" +
				"meta=" + this.meta + ", " +
				"trade=" + this.trade + ", " +
				"updatedTrade=" + this.updatedTrade +
			'}';
		}
	}
	
	//ContractState.ContractStateBuilderImpl
	class ContractStateBuilderImpl implements ContractState.ContractStateBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Trade.TradeBuilder trade;
		protected Trade.TradeBuilder updatedTrade;
	
		public ContractStateBuilderImpl() {
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
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		public Trade.TradeBuilder getUpdatedTrade() {
			return updatedTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateUpdatedTrade() {
			Trade.TradeBuilder result;
			if (updatedTrade!=null) {
				result = updatedTrade;
			}
			else {
				result = updatedTrade = Trade.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ContractState.ContractStateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ContractState.ContractStateBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		public ContractState.ContractStateBuilder setUpdatedTrade(Trade updatedTrade) {
			this.updatedTrade = updatedTrade==null?null:updatedTrade.toBuilder();
			return this;
		}
		
		@Override
		public ContractState build() {
			return new ContractState.ContractStateImpl(this);
		}
		
		@Override
		public ContractState.ContractStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractState.ContractStateBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (updatedTrade!=null && !updatedTrade.prune().hasData()) updatedTrade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getUpdatedTrade()!=null && getUpdatedTrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractState.ContractStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractState.ContractStateBuilder o = (ContractState.ContractStateBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getUpdatedTrade(), o.getUpdatedTrade(), this::setUpdatedTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractState _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(updatedTrade, _that.getUpdatedTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (updatedTrade != null ? updatedTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractStateBuilder {" +
				"meta=" + this.meta + ", " +
				"trade=" + this.trade + ", " +
				"updatedTrade=" + this.updatedTrade +
			'}';
		}
	}
}
