package cdm.event.common;

import cdm.event.common.meta.ContractFormationPrimitiveMeta;
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
 * Defines the primitive event that represents an executed trade that has been affirmed (or confirmed) by the two parties. If both &#39;after&#39; and &#39;before&#39; attributes exist, then both must have identical TradableProduct values.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractFormationPrimitive extends RosettaModelObject {
	ContractFormationPrimitive build();
	ContractFormationPrimitive.ContractFormationPrimitiveBuilder toBuilder();
	
	/**
	 * Represents the new contract being formed between the parties.
	 */
	TradeState getAfter();
	/**
	 * Represents the output of an execution between the parties.
	 */
	ReferenceWithMetaTradeState getBefore();
	final static ContractFormationPrimitiveMeta metaData = new ContractFormationPrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends ContractFormationPrimitive> metaData() {
		return metaData;
	} 
			
	static ContractFormationPrimitive.ContractFormationPrimitiveBuilder builder() {
		return new ContractFormationPrimitive.ContractFormationPrimitiveBuilderImpl();
	}
	
	default Class<? extends ContractFormationPrimitive> getType() {
		return ContractFormationPrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
	}
	
	
	interface ContractFormationPrimitiveBuilder extends ContractFormationPrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder setAfter(TradeState after);
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		ContractFormationPrimitive.ContractFormationPrimitiveBuilder setBeforeValue(TradeState before);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
		}
		
	}
	
	//ContractFormationPrimitive.ContractFormationPrimitiveImpl
	class ContractFormationPrimitiveImpl implements ContractFormationPrimitive {
		private final TradeState after;
		private final ReferenceWithMetaTradeState before;
		
		protected ContractFormationPrimitiveImpl(ContractFormationPrimitive.ContractFormationPrimitiveBuilder builder) {
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
		public ContractFormationPrimitive build() {
			return this;
		}
		
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder toBuilder() {
			ContractFormationPrimitive.ContractFormationPrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractFormationPrimitive.ContractFormationPrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractFormationPrimitive _that = getType().cast(o);
		
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
			return "ContractFormationPrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
	
	//ContractFormationPrimitive.ContractFormationPrimitiveBuilderImpl
	class ContractFormationPrimitiveBuilderImpl implements ContractFormationPrimitive.ContractFormationPrimitiveBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected ReferenceWithMetaTradeStateBuilder before;
	
		public ContractFormationPrimitiveBuilderImpl() {
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
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		
		@Override
		public ContractFormationPrimitive build() {
			return new ContractFormationPrimitive.ContractFormationPrimitiveImpl(this);
		}
		
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder prune() {
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
		public ContractFormationPrimitive.ContractFormationPrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractFormationPrimitive.ContractFormationPrimitiveBuilder o = (ContractFormationPrimitive.ContractFormationPrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractFormationPrimitive _that = getType().cast(o);
		
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
			return "ContractFormationPrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before +
			'}';
		}
	}
}
