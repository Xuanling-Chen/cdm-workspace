package cdm.event.common;

import cdm.event.common.meta.TradeStateMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each TradeState specifies where a Trade is in its life-cycle. TradeState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 * @version ${project.version}
 */
@RosettaClass

public interface TradeState extends RosettaModelObject, GlobalKey {
	TradeState build();
	TradeState.TradeStateBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.
	 */
	List<? extends Reset> getResetHistory();
	/**
	 * Represents the State of the Trade through its life-cycle.
	 */
	State getState();
	/**
	 * Represents the Trade that has been effected by a business or life-cycle event.
	 */
	Trade getTrade();
	/**
	 */
	List<? extends Transfer> getTransferHistory();
	final static TradeStateMeta metaData = new TradeStateMeta();
	
	@Override
	default RosettaMetaData<? extends TradeState> metaData() {
		return metaData;
	} 
			
	static TradeState.TradeStateBuilder builder() {
		return new TradeState.TradeStateBuilderImpl();
	}
	
	default Class<? extends TradeState> getType() {
		return TradeState.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("resetHistory"), processor, Reset.class, getResetHistory());
		processRosetta(path.newSubPath("state"), processor, State.class, getState());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("transferHistory"), processor, Transfer.class, getTransferHistory());
	}
	
	
	interface TradeStateBuilder extends TradeState, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Reset.ResetBuilder getOrCreateResetHistory(int _index);
		List<? extends Reset.ResetBuilder> getResetHistory();
		State.StateBuilder getOrCreateState();
		State.StateBuilder getState();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		Transfer.TransferBuilder getOrCreateTransferHistory(int _index);
		List<? extends Transfer.TransferBuilder> getTransferHistory();
		TradeState.TradeStateBuilder setMeta(MetaFields meta);
		TradeState.TradeStateBuilder addResetHistory(Reset resetHistory);
		TradeState.TradeStateBuilder addResetHistory(Reset resetHistory, int _idx);
		TradeState.TradeStateBuilder addResetHistory(List<? extends Reset> resetHistory);
		TradeState.TradeStateBuilder setResetHistory(List<? extends Reset> resetHistory);
		TradeState.TradeStateBuilder setState(State state);
		TradeState.TradeStateBuilder setTrade(Trade trade);
		TradeState.TradeStateBuilder addTransferHistory(Transfer transferHistory);
		TradeState.TradeStateBuilder addTransferHistory(Transfer transferHistory, int _idx);
		TradeState.TradeStateBuilder addTransferHistory(List<? extends Transfer> transferHistory);
		TradeState.TradeStateBuilder setTransferHistory(List<? extends Transfer> transferHistory);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("resetHistory"), processor, Reset.ResetBuilder.class, getResetHistory());
			processRosetta(path.newSubPath("state"), processor, State.StateBuilder.class, getState());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("transferHistory"), processor, Transfer.TransferBuilder.class, getTransferHistory());
		}
		
	}
	
	//TradeState.TradeStateImpl
	class TradeStateImpl implements TradeState {
		private final MetaFields meta;
		private final List<? extends Reset> resetHistory;
		private final State state;
		private final Trade trade;
		private final List<? extends Transfer> transferHistory;
		
		protected TradeStateImpl(TradeState.TradeStateBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.resetHistory = ofNullable(builder.getResetHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.state = ofNullable(builder.getState()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.transferHistory = ofNullable(builder.getTransferHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends Reset> getResetHistory() {
			return resetHistory;
		}
		
		@Override
		public State getState() {
			return state;
		}
		
		@Override
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		public List<? extends Transfer> getTransferHistory() {
			return transferHistory;
		}
		
		@Override
		public TradeState build() {
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder toBuilder() {
			TradeState.TradeStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeState.TradeStateBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getResetHistory()).ifPresent(builder::setResetHistory);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTransferHistory()).ifPresent(builder::setTransferHistory);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeState _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(resetHistory, _that.getResetHistory())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(transferHistory, _that.getTransferHistory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (resetHistory != null ? resetHistory.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (transferHistory != null ? transferHistory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeState {" +
				"meta=" + this.meta + ", " +
				"resetHistory=" + this.resetHistory + ", " +
				"state=" + this.state + ", " +
				"trade=" + this.trade + ", " +
				"transferHistory=" + this.transferHistory +
			'}';
		}
	}
	
	//TradeState.TradeStateBuilderImpl
	class TradeStateBuilderImpl implements TradeState.TradeStateBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<Reset.ResetBuilder> resetHistory = new ArrayList<>();
		protected State.StateBuilder state;
		protected Trade.TradeBuilder trade;
		protected List<Transfer.TransferBuilder> transferHistory = new ArrayList<>();
	
		public TradeStateBuilderImpl() {
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
		public List<? extends Reset.ResetBuilder> getResetHistory() {
			return resetHistory;
		}
		
		public Reset.ResetBuilder getOrCreateResetHistory(int _index) {
		
			if (resetHistory==null) {
				this.resetHistory = new ArrayList<>();
			}
			Reset.ResetBuilder result;
			return getIndex(resetHistory, _index, () -> {
						Reset.ResetBuilder newResetHistory = Reset.builder();
						return newResetHistory;
					});
		}
		
		@Override
		public State.StateBuilder getState() {
			return state;
		}
		
		@Override
		public State.StateBuilder getOrCreateState() {
			State.StateBuilder result;
			if (state!=null) {
				result = state;
			}
			else {
				result = state = State.builder();
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
		public List<? extends Transfer.TransferBuilder> getTransferHistory() {
			return transferHistory;
		}
		
		public Transfer.TransferBuilder getOrCreateTransferHistory(int _index) {
		
			if (transferHistory==null) {
				this.transferHistory = new ArrayList<>();
			}
			Transfer.TransferBuilder result;
			return getIndex(transferHistory, _index, () -> {
						Transfer.TransferBuilder newTransferHistory = Transfer.builder();
						return newTransferHistory;
					});
		}
		
	
		@Override
		public TradeState.TradeStateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public TradeState.TradeStateBuilder addResetHistory(Reset resetHistory) {
			if (resetHistory!=null) this.resetHistory.add(resetHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addResetHistory(Reset resetHistory, int _idx) {
			getIndex(this.resetHistory, _idx, () -> resetHistory.toBuilder());
			return this;
		}
		@Override 
		public TradeState.TradeStateBuilder addResetHistory(List<? extends Reset> resetHistorys) {
			if (resetHistorys != null) {
				for (Reset toAdd : resetHistorys) {
					this.resetHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeState.TradeStateBuilder setResetHistory(List<? extends Reset> resetHistorys) {
			if (resetHistorys == null)  {
				this.resetHistory = new ArrayList<>();
			}
			else {
				this.resetHistory = resetHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder setState(State state) {
			this.state = state==null?null:state.toBuilder();
			return this;
		}
		@Override
		public TradeState.TradeStateBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		public TradeState.TradeStateBuilder addTransferHistory(Transfer transferHistory) {
			if (transferHistory!=null) this.transferHistory.add(transferHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addTransferHistory(Transfer transferHistory, int _idx) {
			getIndex(this.transferHistory, _idx, () -> transferHistory.toBuilder());
			return this;
		}
		@Override 
		public TradeState.TradeStateBuilder addTransferHistory(List<? extends Transfer> transferHistorys) {
			if (transferHistorys != null) {
				for (Transfer toAdd : transferHistorys) {
					this.transferHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeState.TradeStateBuilder setTransferHistory(List<? extends Transfer> transferHistorys) {
			if (transferHistorys == null)  {
				this.transferHistory = new ArrayList<>();
			}
			else {
				this.transferHistory = transferHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TradeState build() {
			return new TradeState.TradeStateImpl(this);
		}
		
		@Override
		public TradeState.TradeStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeState.TradeStateBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			resetHistory = resetHistory.stream().filter(b->b!=null).<Reset.ResetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (state!=null && !state.prune().hasData()) state = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			transferHistory = transferHistory.stream().filter(b->b!=null).<Transfer.TransferBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResetHistory()!=null && getResetHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getState()!=null && getState().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTransferHistory()!=null && getTransferHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeState.TradeStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeState.TradeStateBuilder o = (TradeState.TradeStateBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getResetHistory(), o.getResetHistory(), this::getOrCreateResetHistory);
			merger.mergeRosetta(getState(), o.getState(), this::setState);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTransferHistory(), o.getTransferHistory(), this::getOrCreateTransferHistory);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeState _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(resetHistory, _that.getResetHistory())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(transferHistory, _that.getTransferHistory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (resetHistory != null ? resetHistory.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (transferHistory != null ? transferHistory.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeStateBuilder {" +
				"meta=" + this.meta + ", " +
				"resetHistory=" + this.resetHistory + ", " +
				"state=" + this.state + ", " +
				"trade=" + this.trade + ", " +
				"transferHistory=" + this.transferHistory +
			'}';
		}
	}
}
