package cdm.event.common;

import cdm.event.common.meta.ResetPrimitiveMeta;
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
 * Defines the primitive event to represent a reset. For details of how the TradeState is changed between the `before` and `after` TradeStates, see the corresponding Create_ResetPrimitive function.
 * @version ${project.version}
 */
@RosettaClass

public interface ResetPrimitive extends RosettaModelObject {
	ResetPrimitive build();
	ResetPrimitive.ResetPrimitiveBuilder toBuilder();
	
	/**
	 * Represents the TradeState after to applying the Reset primitive.
	 */
	TradeState getAfter();
	/**
	 * Represents the TradeState prior applying the Reset primitive.
	 */
	ReferenceWithMetaTradeState getBefore();
	final static ResetPrimitiveMeta metaData = new ResetPrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends ResetPrimitive> metaData() {
		return metaData;
	} 
			
	static ResetPrimitive.ResetPrimitiveBuilder builder() {
		return new ResetPrimitive.ResetPrimitiveBuilderImpl();
	}
	
	default Class<? extends ResetPrimitive> getType() {
		return ResetPrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface ResetPrimitiveBuilder extends ResetPrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		ResetPrimitive.ResetPrimitiveBuilder setAfter(TradeState after);
		ResetPrimitive.ResetPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		ResetPrimitive.ResetPrimitiveBuilder setBeforeValue(TradeState before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//ResetPrimitive.ResetPrimitiveImpl
	class ResetPrimitiveImpl implements ResetPrimitive {
		private final TradeState after;
		private final ReferenceWithMetaTradeState before;
		
		protected ResetPrimitiveImpl(ResetPrimitive.ResetPrimitiveBuilder builder) {
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
		public ResetPrimitive build() {
			return this;
		}
		
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder toBuilder() {
			ResetPrimitive.ResetPrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetPrimitive.ResetPrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetPrimitive _that = getType().cast(o);
		
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
			return "ResetPrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//ResetPrimitive.ResetPrimitiveBuilderImpl
	class ResetPrimitiveBuilderImpl implements ResetPrimitive.ResetPrimitiveBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected ReferenceWithMetaTradeStateBuilder before;
	
		public ResetPrimitiveBuilderImpl() {
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
		public ResetPrimitive.ResetPrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		
		@Override
		public ResetPrimitive build() {
			return new ResetPrimitive.ResetPrimitiveImpl(this);
		}
		
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetPrimitive.ResetPrimitiveBuilder prune() {
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
		public ResetPrimitive.ResetPrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetPrimitive.ResetPrimitiveBuilder o = (ResetPrimitive.ResetPrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetPrimitive _that = getType().cast(o);
		
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
			return "ResetPrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
