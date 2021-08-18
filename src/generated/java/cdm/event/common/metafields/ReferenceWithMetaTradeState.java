package cdm.event.common.metafields;

import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilderImpl;
import cdm.event.common.metafields.ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateImpl;
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

public interface ReferenceWithMetaTradeState extends RosettaModelObject, ReferenceWithMeta<TradeState> {
	ReferenceWithMetaTradeState build();
	ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder toBuilder();
	
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
	TradeState getValue();
	final static ReferenceWithMetaTradeStateMeta metaData = new ReferenceWithMetaTradeStateMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaTradeState> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder builder() {
		return new ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaTradeState> getType() {
		return ReferenceWithMetaTradeState.class;
	}
	
		default Class<TradeState> getValueType() {
			return TradeState.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, TradeState.class, getValue());
	}
	
	
	interface ReferenceWithMetaTradeStateBuilder extends ReferenceWithMetaTradeState, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<TradeState> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		TradeState.TradeStateBuilder getOrCreateValue();
		TradeState.TradeStateBuilder getValue();
		ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setExternalReference(String externalReference);
		ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setReference(Reference reference);
		ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setValue(TradeState value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, TradeState.TradeStateBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateImpl
	class ReferenceWithMetaTradeStateImpl implements ReferenceWithMetaTradeState {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final TradeState value;
		
		protected ReferenceWithMetaTradeStateImpl(ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder builder) {
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
		public TradeState getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaTradeState build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder toBuilder() {
			ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaTradeState _that = getType().cast(o);
		
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
			return "ReferenceWithMetaTradeState {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilderImpl
	class ReferenceWithMetaTradeStateBuilderImpl implements ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected TradeState.TradeStateBuilder value;
	
		public ReferenceWithMetaTradeStateBuilderImpl() {
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
		public TradeState.TradeStateBuilder getValue() {
			return value;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateValue() {
			TradeState.TradeStateBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = TradeState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder setValue(TradeState value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaTradeState build() {
			return new ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateImpl(this);
		}
		
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder prune() {
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
		public ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder o = (ReferenceWithMetaTradeState.ReferenceWithMetaTradeStateBuilder) other;
			
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
		
			ReferenceWithMetaTradeState _that = getType().cast(o);
		
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
			return "ReferenceWithMetaTradeStateBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaTradeStateMeta extends BasicRosettaMetaData<ReferenceWithMetaTradeState>{

}
