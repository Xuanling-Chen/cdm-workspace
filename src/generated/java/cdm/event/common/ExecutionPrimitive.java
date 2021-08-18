package cdm.event.common;

import cdm.event.common.meta.ExecutionPrimitiveMeta;
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
 * Defines the primitive event for an execution, with &#39;after&#39; attribute being a TradeState and the &#39;before&#39; attribute being Null. It is expected that the &#39;before&#39; attribute will be adjusted or deprecated once the CDM scope is extended to include pre-trade.
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionPrimitive extends RosettaModelObject {
	ExecutionPrimitive build();
	ExecutionPrimitive.ExecutionPrimitiveBuilder toBuilder();
	
	/**
	 * Represents an execution between parties. In the case of an execution on a contractual product, some additional characteristics may need to be specified to get a fully-formed contract, for instance when the executing party acts as an agent, as is the case in an allocation scenario. This is the purpose of the &#39;ContractFormation&#39; primitive event.
	 */
	TradeState getAfter();
	/**
	 * Represents the connection point between pre and post trade life-cycle events. The TradeState associated to the &#39;before&#39; attribute represents the final step of any pre-trade workflow. CDM scope does not include pre-trade and so cardinality of this attribute is specified as exactly 0, which enforces the absence of the &#39;before&#39; attribute.
	 */
	List<? extends ReferenceWithMetaTradeState> getBefore();
	final static ExecutionPrimitiveMeta metaData = new ExecutionPrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionPrimitive> metaData() {
		return metaData;
	} 
			
	static ExecutionPrimitive.ExecutionPrimitiveBuilder builder() {
		return new ExecutionPrimitive.ExecutionPrimitiveBuilderImpl();
	}
	
	default Class<? extends ExecutionPrimitive> getType() {
		return ExecutionPrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface ExecutionPrimitiveBuilder extends ExecutionPrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore(int _index);
		List<? extends ReferenceWithMetaTradeStateBuilder> getBefore();
		ExecutionPrimitive.ExecutionPrimitiveBuilder setAfter(TradeState after);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(ReferenceWithMetaTradeState before);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(ReferenceWithMetaTradeState before, int _idx);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(TradeState before);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(TradeState before, int _idx);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(List<? extends ReferenceWithMetaTradeState> before);
		ExecutionPrimitive.ExecutionPrimitiveBuilder setBefore(List<? extends ReferenceWithMetaTradeState> before);
		ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(List<? extends TradeState> before);
		ExecutionPrimitive.ExecutionPrimitiveBuilder setBeforeValue(List<? extends TradeState> before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//ExecutionPrimitive.ExecutionPrimitiveImpl
	class ExecutionPrimitiveImpl implements ExecutionPrimitive {
		private final TradeState after;
		private final List<? extends ReferenceWithMetaTradeState> before;
		
		protected ExecutionPrimitiveImpl(ExecutionPrimitive.ExecutionPrimitiveBuilder builder) {
			this.after = ofNullable(builder.getAfter()).map(f->f.build()).orElse(null);
			this.before = ofNullable(builder.getBefore()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public TradeState getAfter() {
			return after;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeState> getBefore() {
			return before;
		}
		
		@Override
		public ExecutionPrimitive build() {
			return this;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder toBuilder() {
			ExecutionPrimitive.ExecutionPrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionPrimitive.ExecutionPrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionPrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
			if (!ListEquals.listEquals(before, _that.getBefore())) return false;
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
			return "ExecutionPrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//ExecutionPrimitive.ExecutionPrimitiveBuilderImpl
	class ExecutionPrimitiveBuilderImpl implements ExecutionPrimitive.ExecutionPrimitiveBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected List<ReferenceWithMetaTradeStateBuilder> before = new ArrayList<>();
	
		public ExecutionPrimitiveBuilderImpl() {
		}
	
		@Override
		public TradeState.TradeStateBuilder getAfter() {
			return after;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateAfter() {
			TradeState.TradeStateBuilder result;
			if (after!=null) {
				result = after;
			}
			else {
				result = after = TradeState.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeStateBuilder> getBefore() {
			return before;
		}
		
		public ReferenceWithMetaTradeStateBuilder getOrCreateBefore(int _index) {
		
			if (before==null) {
				this.before = new ArrayList<>();
			}
			ReferenceWithMetaTradeStateBuilder result;
			return getIndex(before, _index, () -> {
						ReferenceWithMetaTradeStateBuilder newBefore = ReferenceWithMetaTradeState.builder();
						return newBefore;
					});
		}
		
	
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(ReferenceWithMetaTradeState before) {
			if (before!=null) this.before.add(before.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(ReferenceWithMetaTradeState before, int _idx) {
			getIndex(this.before, _idx, () -> before.toBuilder());
			return this;
		}
		
			@Override
			public ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(TradeState before) {
				this.getOrCreateBefore(-1).setValue(before.toBuilder());
				return this;
			}
			
			@Override
			public ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(TradeState before, int _idx) {
				this.getOrCreateBefore(_idx).setValue(before.toBuilder());
				return this;
			}
		@Override 
		public ExecutionPrimitive.ExecutionPrimitiveBuilder addBefore(List<? extends ReferenceWithMetaTradeState> befores) {
			if (befores != null) {
				for (ReferenceWithMetaTradeState toAdd : befores) {
					this.before.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExecutionPrimitive.ExecutionPrimitiveBuilder setBefore(List<? extends ReferenceWithMetaTradeState> befores) {
			if (befores == null)  {
				this.before = new ArrayList<>();
			}
			else {
				this.before = befores.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder addBeforeValue(List<? extends TradeState> befores) {
			if (befores != null) {
				for (TradeState toAdd : befores) {
					this.addBeforeValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder setBeforeValue(List<? extends TradeState> befores) {
			this.before.clear();
			if (befores!=null) {
				befores.forEach(this::addBeforeValue);
			}
			return this;
		}
		
		
		@Override
		public ExecutionPrimitive build() {
			return new ExecutionPrimitive.ExecutionPrimitiveImpl(this);
		}
		
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder prune() {
			if (after!=null && !after.prune().hasData()) after = null;
			before = before.stream().filter(b->b!=null).<ReferenceWithMetaTradeStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAfter()!=null && getAfter().hasData()) return true;
			if (getBefore()!=null && getBefore().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionPrimitive.ExecutionPrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionPrimitive.ExecutionPrimitiveBuilder o = (ExecutionPrimitive.ExecutionPrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::getOrCreateBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionPrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
			if (!ListEquals.listEquals(before, _that.getBefore())) return false;
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
			return "ExecutionPrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
