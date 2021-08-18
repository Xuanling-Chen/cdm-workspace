package cdm.event.common;

import cdm.event.common.meta.TermsChangePrimitiveMeta;
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
 * Defines the primitive event to represent changes to terms of the trade.
 * @version ${project.version}
 */
@RosettaClass

public interface TermsChangePrimitive extends RosettaModelObject {
	TermsChangePrimitive build();
	TermsChangePrimitive.TermsChangePrimitiveBuilder toBuilder();
	
	/**
	 * Represents the TradeState after to applying the TermsChange primitive. 
	 */
	TradeState getAfter();
	/**
	 * Represents the TradeState prior to applying the TermsChange primitive.
	 */
	ReferenceWithMetaTradeState getBefore();
	final static TermsChangePrimitiveMeta metaData = new TermsChangePrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends TermsChangePrimitive> metaData() {
		return metaData;
	} 
			
	static TermsChangePrimitive.TermsChangePrimitiveBuilder builder() {
		return new TermsChangePrimitive.TermsChangePrimitiveBuilderImpl();
	}
	
	default Class<? extends TermsChangePrimitive> getType() {
		return TermsChangePrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface TermsChangePrimitiveBuilder extends TermsChangePrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		TermsChangePrimitive.TermsChangePrimitiveBuilder setAfter(TradeState after);
		TermsChangePrimitive.TermsChangePrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		TermsChangePrimitive.TermsChangePrimitiveBuilder setBeforeValue(TradeState before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//TermsChangePrimitive.TermsChangePrimitiveImpl
	class TermsChangePrimitiveImpl implements TermsChangePrimitive {
		private final TradeState after;
		private final ReferenceWithMetaTradeState before;
		
		protected TermsChangePrimitiveImpl(TermsChangePrimitive.TermsChangePrimitiveBuilder builder) {
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
		public TermsChangePrimitive build() {
			return this;
		}
		
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder toBuilder() {
			TermsChangePrimitive.TermsChangePrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermsChangePrimitive.TermsChangePrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermsChangePrimitive _that = getType().cast(o);
		
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
			return "TermsChangePrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//TermsChangePrimitive.TermsChangePrimitiveBuilderImpl
	class TermsChangePrimitiveBuilderImpl implements TermsChangePrimitive.TermsChangePrimitiveBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected ReferenceWithMetaTradeStateBuilder before;
	
		public TermsChangePrimitiveBuilderImpl() {
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
		public TermsChangePrimitive.TermsChangePrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		
		@Override
		public TermsChangePrimitive build() {
			return new TermsChangePrimitive.TermsChangePrimitiveImpl(this);
		}
		
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermsChangePrimitive.TermsChangePrimitiveBuilder prune() {
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
		public TermsChangePrimitive.TermsChangePrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TermsChangePrimitive.TermsChangePrimitiveBuilder o = (TermsChangePrimitive.TermsChangePrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermsChangePrimitive _that = getType().cast(o);
		
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
			return "TermsChangePrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
