package cdm.event.common;

import cdm.event.common.meta.TransferPrimitiveMeta;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
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
 * A class to specify the transfer of assets between parties, those assets being either cash, securities or physical assets. This class combines components that are cross-assets (settlement date, settlement type, status, ...) and some other which are specialized by asset class (e.g. the payer/receiver amount and cashflow type for a cash transfer, the transferor/transferee, security indication, quantity, and asset transfer type qualification for the case of a security). The associated globalKey denotes the ability to associate a hash value to the respective Execution instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface TransferPrimitive extends RosettaModelObject, GlobalKey {
	TransferPrimitive build();
	TransferPrimitive.TransferPrimitiveBuilder toBuilder();
	
	/**
	 */
	TradeState getAfter();
	/**
	 */
	ReferenceWithMetaTradeState getBefore();
	/**
	 */
	MetaFields getMeta();
	final static TransferPrimitiveMeta metaData = new TransferPrimitiveMeta();
	
	@Override
	default RosettaMetaData<? extends TransferPrimitive> metaData() {
		return metaData;
	} 
			
	static TransferPrimitive.TransferPrimitiveBuilder builder() {
		return new TransferPrimitive.TransferPrimitiveBuilderImpl();
	}
	
	default Class<? extends TransferPrimitive> getType() {
		return TransferPrimitive.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("after"), processor, TradeState.class, getAfter());
		processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeState.class, getBefore());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface TransferPrimitiveBuilder extends TransferPrimitive, RosettaModelObjectBuilder {
		TradeState.TradeStateBuilder getOrCreateAfter();
		TradeState.TradeStateBuilder getAfter();
		ReferenceWithMetaTradeStateBuilder getOrCreateBefore();
		ReferenceWithMetaTradeStateBuilder getBefore();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		TransferPrimitive.TransferPrimitiveBuilder setAfter(TradeState after);
		TransferPrimitive.TransferPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before);
		TransferPrimitive.TransferPrimitiveBuilder setBeforeValue(TradeState before);
		TransferPrimitive.TransferPrimitiveBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("after"), processor, TradeState.TradeStateBuilder.class, getAfter());
			processRosetta(path.newSubPath("before"), processor, ReferenceWithMetaTradeStateBuilder.class, getBefore());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//TransferPrimitive.TransferPrimitiveImpl
	class TransferPrimitiveImpl implements TransferPrimitive {
		private final TradeState after;
		private final ReferenceWithMetaTradeState before;
		private final MetaFields meta;
		
		protected TransferPrimitiveImpl(TransferPrimitive.TransferPrimitiveBuilder builder) {
			this.after = ofNullable(builder.getAfter()).map(f->f.build()).orElse(null);
			this.before = ofNullable(builder.getBefore()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
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
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public TransferPrimitive build() {
			return this;
		}
		
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder toBuilder() {
			TransferPrimitive.TransferPrimitiveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferPrimitive.TransferPrimitiveBuilder builder) {
			ofNullable(getAfter()).ifPresent(builder::setAfter);
			ofNullable(getBefore()).ifPresent(builder::setBefore);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferPrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferPrimitive {" +
				"after=" + this.after + ", " +
				"before=" + this.before + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//TransferPrimitive.TransferPrimitiveBuilderImpl
	class TransferPrimitiveBuilderImpl implements TransferPrimitive.TransferPrimitiveBuilder, GlobalKeyBuilder {
	
		protected TradeState.TradeStateBuilder after;
		protected ReferenceWithMetaTradeStateBuilder before;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public TransferPrimitiveBuilderImpl() {
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
		public TransferPrimitive.TransferPrimitiveBuilder setAfter(TradeState after) {
			this.after = after==null?null:after.toBuilder();
			return this;
		}
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder setBefore(ReferenceWithMetaTradeState before) {
			this.before = before==null?null:before.toBuilder();
			return this;
		}
		
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder setBeforeValue(TradeState before) {
			this.getOrCreateBefore().setValue(before);
			return this;
		}
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public TransferPrimitive build() {
			return new TransferPrimitive.TransferPrimitiveImpl(this);
		}
		
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferPrimitive.TransferPrimitiveBuilder prune() {
			if (after!=null && !after.prune().hasData()) after = null;
			if (before!=null && !before.prune().hasData()) before = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
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
		public TransferPrimitive.TransferPrimitiveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferPrimitive.TransferPrimitiveBuilder o = (TransferPrimitive.TransferPrimitiveBuilder) other;
			
			merger.mergeRosetta(getAfter(), o.getAfter(), this::setAfter);
			merger.mergeRosetta(getBefore(), o.getBefore(), this::setBefore);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferPrimitive _that = getType().cast(o);
		
			if (!Objects.equals(after, _that.getAfter())) return false;
			if (!Objects.equals(before, _that.getBefore())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (after != null ? after.hashCode() : 0);
			_result = 31 * _result + (before != null ? before.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferPrimitiveBuilder {" +
				"after=" + this.after + ", " +
				"before=" + this.before + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
