package cdm.event.common;

import cdm.event.common.meta.SplitPrimitiveMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
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
 * Defines splitting of a single trade into one or more trades, where the quantity of the split trade(s) totals that of the single trade.
 * @version ${project.version}
 */
@RosettaClass

public interface SplitPrimitive extends RosettaModelObject {
	SplitPrimitive build();
	SplitPrimitive.SplitPrimitiveBuilder toBuilder();
	
	/**
	 * Represents the outcome of the split. Includes the single trade (referenced in the &#39;before&#39; attribute) with its Position State updated to closed, along with a reason.
	 */
	List<? extends TradeState> getAfter();
	/**
	 * Represents the single trade to be split.
	 */
	ReferenceWithMetaTradeState getBefore();
	final static SplitPrimitiveMeta metaData = new SplitPrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends SplitPrimitive> metaData() {
		return metaData;
	} 
			
	static SplitPrimitive.SplitPrimitiveBuilder builder() {
		return new SplitPrimitive.SplitPrimitiveBuilderImpl();
	}
	
	default Class<? extends SplitPrimitive> getType() {
		return SplitPrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface SplitPrimitiveBuilder extends SplitPrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter(int _index);
		List<? extends TradeState.TradeStateBuilder> getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		SplitPrimitive.SplitPrimitiveBuilder addAfter(TradeState after);
		SplitPrimitive.SplitPrimitiveBuilder addAfter(TradeState after, int _idx);
		SplitPrimitive.SplitPrimitiveBuilder addAfter(List<? extends TradeState> after);
		SplitPrimitive.SplitPrimitiveBuilder setAfter(List<? extends TradeState> after);
		SplitPrimitive.SplitPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		SplitPrimitive.SplitPrimitiveBuilder setBeforeValue(TradeState before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//SplitPrimitive.SplitPrimitiveImpl
	class SplitPrimitiveImpl implements SplitPrimitive {
		private final List<? extends TradeState> after;
		private final ReferenceWithMetaTradeState before;
		
		protected SplitPrimitiveImpl(SplitPrimitive.SplitPrimitiveBuilder builder) {
			this.after = ofNullable(builder.getAfter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.before = ofNullable(builder.getBefore()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends TradeState> getAfter() {
			return after;
		}
		
		@Override
		public ReferenceWithMetaTradeState getBefore() {
			return before;
		}
		
		@Override
		public SplitPrimitive build() {
			return this;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder toBuilder() {
			SplitPrimitive.SplitPrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SplitPrimitive.SplitPrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SplitPrimitive _that = getType().cast(o);
		
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SplitPrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//SplitPrimitive.SplitPrimitiveBuilderImpl
	class SplitPrimitiveBuilderImpl implements SplitPrimitive.SplitPrimitiveBuilder {
	
		protected List<TradeState.TradeStateBuilder> after = new ArrayList<>();
		protected ReferenceWithMetaTradeStateBuilder before;
	
		public SplitPrimitiveBuilderImpl() {
		}
	
		@Override
		public List<? extends TradeState.TradeStateBuilder> getAfter() {
			return after;
		}
		
		public TradeState.TradeStateBuilder getOrCreateAfter(int _index) {
		
			if (after==null) {
				this.after = new ArrayList<>();
			}
			TradeState.TradeStateBuilder result;
			return getIndex(after, _index, () -> {
						TradeState.TradeStateBuilder newAfter = TradeState.builder();
						return newAfter;
					});
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getBefore() {
			return before;
		}
		
		@Override
		public ReferenceWithMetaTradeStateBuilder getOrCreateBefore() {
			ReferenceWithMetaTradeStateBuilder result;
			if (before!=null) {
				result = before;
			}
			else {
				result = before = ReferenceWithMetaTradeState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder addAfter(TradeState after) {
			if (after!=null) this.after.add(after.toBuilder());
			return this;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder addAfter(TradeState after, int _idx) {
			getIndex(this.after, _idx, () -> after.toBuilder());
			return this;
		}
		@Override 
		public SplitPrimitive.SplitPrimitiveBuilder addAfter(List<? extends TradeState> afters) {
			if (afters != null) {
				for (TradeState toAdd : afters) {
					this.after.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SplitPrimitive.SplitPrimitiveBuilder setAfter(List<? extends TradeState> afters) {
			if (afters == null)  {
				this.after = new ArrayList<>();
			}
			else {
				this.after = afters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		
		@Override
		public SplitPrimitive build() {
			return new SplitPrimitive.SplitPrimitiveImpl(this);
		}
		
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder prune() {
			after = after.stream().filter(b->b!=null).<TradeState.TradeStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (before!=null && !before.prune().hasData()) before = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAfter()!=null && getAfter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBefore()!=null && getBefore().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SplitPrimitive.SplitPrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SplitPrimitive.SplitPrimitiveBuilder o = (SplitPrimitive.SplitPrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::getOrCreateAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SplitPrimitive _that = getType().cast(o);
		
			if (!ListEquals.listEquals(after, _that.getAfter())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SplitPrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
