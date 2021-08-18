package cdm.event.common.metafields;

import cdm.event.common.Trade;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilderImpl;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.ReferenceWithMeta;
import com.rosetta.model.lib.meta.ReferenceWithMeta.ReferenceWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface ReferenceWithMetaTrade extends RosettaModelObject, ReferenceWithMeta<Trade> {
	ReferenceWithMetaTrade build();
	ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder toBuilder();
	
	/**
	 */
	String getExternalReference();
	/**
	 */
	String getGlobalReference();
	/**
	 */
	Reference getReference();
	/**
	 */
	Trade getValue();
	final static ReferenceWithMetaTradeMeta metaData = new ReferenceWithMetaTradeMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaTrade> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder builder() {
		return new ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaTrade> getType() {
		return ReferenceWithMetaTrade.class;
	}
	
		default Class<Trade> getValueType() {
			return Trade.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, Trade.class, getValue());
	}
	
	
	interface ReferenceWithMetaTradeBuilder extends ReferenceWithMetaTrade, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Trade> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		Trade.TradeBuilder getOrCreateValue();
		Trade.TradeBuilder getValue();
		ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setExternalReference(String externalReference);
		ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setReference(Reference reference);
		ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setValue(Trade value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, Trade.TradeBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaTrade.ReferenceWithMetaTradeImpl
	class ReferenceWithMetaTradeImpl implements ReferenceWithMetaTrade {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Trade value;
		
		protected ReferenceWithMetaTradeImpl(ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder builder) {
			this.externalReference = builder.getExternalReference();
			this.globalReference = builder.getGlobalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference getReference() {
			return reference;
		}
		
		@Override
		public Trade getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaTrade build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder toBuilder() {
			ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaTrade _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaTrade {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilderImpl
	class ReferenceWithMetaTradeBuilderImpl implements ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Trade.TradeBuilder value;
	
		public ReferenceWithMetaTradeBuilderImpl() {
		}
	
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference.ReferenceBuilder getReference() {
			return reference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreateReference() {
			Reference.ReferenceBuilder result;
			if (reference!=null) {
				result = reference;
			}
			else {
				result = reference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		public Trade.TradeBuilder getValue() {
			return value;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateValue() {
			Trade.TradeBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Trade.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder setValue(Trade value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaTrade build() {
			return new ReferenceWithMetaTrade.ReferenceWithMetaTradeImpl(this);
		}
		
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder prune() {
			if (reference!=null && !reference.prune().hasData()) reference = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalReference()!=null) return true;
			if (getGlobalReference()!=null) return true;
			if (getReference()!=null && getReference().hasData()) return true;
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder o = (ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::setReference);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			merger.mergeBasic(getExternalReference(), o.getExternalReference(), this::setExternalReference);
			merger.mergeBasic(getGlobalReference(), o.getGlobalReference(), this::setGlobalReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaTrade _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaTradeBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaTradeMeta extends BasicRosettaMetaData<ReferenceWithMetaTrade>{

}
