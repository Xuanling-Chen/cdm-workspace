package cdm.event.common;

import cdm.event.common.meta.QuantityChangePrimitiveMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
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
 * Defines the primitive event to represent a change in quantity, which includes notional. For details of how the TradeState is changed between the `before` and `after` TradeStates, see the corresponding Create_QuantityChangePrimitive function.
 * @version ${project.version}
 */
@RosettaClass

public interface QuantityChangePrimitive extends RosettaModelObject {
	QuantityChangePrimitive build();
	QuantityChangePrimitive.QuantityChangePrimitiveBuilder toBuilder();
	
	/**
	 * Represents the state of the trade as a follow-up from the event.
	 */
	TradeState getAfter();
	/**
	 * Represents the state of the trade before the event.
	 */
	ReferenceWithMetaTradeState getBefore();
	final static QuantityChangePrimitiveMeta metaData = new QuantityChangePrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends QuantityChangePrimitive> metaData() {
		return metaData;
	} 
			
	static QuantityChangePrimitive.QuantityChangePrimitiveBuilder builder() {
		return new QuantityChangePrimitive.QuantityChangePrimitiveBuilderImpl();
	}
	
	default Class<? extends QuantityChangePrimitive> getType() {
		return QuantityChangePrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface QuantityChangePrimitiveBuilder extends QuantityChangePrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder setAfter(TradeState after);
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder setBeforeValue(TradeState before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//QuantityChangePrimitive.QuantityChangePrimitiveImpl
	class QuantityChangePrimitiveImpl implements QuantityChangePrimitive {
		private final TradeState after;
		private final ReferenceWithMetaTradeState before;
		
		protected QuantityChangePrimitiveImpl(QuantityChangePrimitive.QuantityChangePrimitiveBuilder builder) {
			this.after = ofNullable(builder.getAfter()).map(f->f.build()).orElse(null);
			this.before = ofNullable(builder.getBefore()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public TradeState getAfter() {
			return after;
		}
		
		@Override
		public ReferenceWithMetaTradeState getBefore() {
			return before;
		}
		
		@Override
		public QuantityChangePrimitive build() {
			return this;
		}
		
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder toBuilder() {
			QuantityChangePrimitive.QuantityChangePrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityChangePrimitive.QuantityChangePrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityChangePrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
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
			return "QuantityChangePrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//QuantityChangePrimitive.QuantityChangePrimitiveBuilderImpl
	class QuantityChangePrimitiveBuilderImpl implements QuantityChangePrimitive.QuantityChangePrimitiveBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected ReferenceWithMetaTradeStateBuilder before;
	
		public QuantityChangePrimitiveBuilderImpl() {
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
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		
		@Override
		public QuantityChangePrimitive build() {
			return new QuantityChangePrimitive.QuantityChangePrimitiveImpl(this);
		}
		
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder prune() {
			if (after!=null && !after.prune().hasData()) after = null;
			if (before!=null && !before.prune().hasData()) before = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAfter()!=null && getAfter().hasData()) return true;
			if (getBefore()!=null && getBefore().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityChangePrimitive.QuantityChangePrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityChangePrimitive.QuantityChangePrimitiveBuilder o = (QuantityChangePrimitive.QuantityChangePrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityChangePrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
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
			return "QuantityChangePrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
