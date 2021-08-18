package cdm.observable.event.metafields;

import cdm.observable.event.CreditEvents;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilderImpl;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsImpl;
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

public interface ReferenceWithMetaCreditEvents extends RosettaModelObject, ReferenceWithMeta<CreditEvents> {
	ReferenceWithMetaCreditEvents build();
	ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder toBuilder();
	
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
	CreditEvents getValue();
	final static ReferenceWithMetaCreditEventsMeta metaData = new ReferenceWithMetaCreditEventsMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaCreditEvents> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder builder() {
		return new ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaCreditEvents> getType() {
		return ReferenceWithMetaCreditEvents.class;
	}
	
		default Class<CreditEvents> getValueType() {
			return CreditEvents.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, CreditEvents.class, getValue());
	}
	
	
	interface ReferenceWithMetaCreditEventsBuilder extends ReferenceWithMetaCreditEvents, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<CreditEvents> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		CreditEvents.CreditEventsBuilder getOrCreateValue();
		CreditEvents.CreditEventsBuilder getValue();
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setExternalReference(String externalReference);
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setReference(Reference reference);
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setValue(CreditEvents value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, CreditEvents.CreditEventsBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsImpl
	class ReferenceWithMetaCreditEventsImpl implements ReferenceWithMetaCreditEvents {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final CreditEvents value;
		
		protected ReferenceWithMetaCreditEventsImpl(ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder builder) {
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
		public CreditEvents getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaCreditEvents build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder toBuilder() {
			ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaCreditEvents _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCreditEvents {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilderImpl
	class ReferenceWithMetaCreditEventsBuilderImpl implements ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected CreditEvents.CreditEventsBuilder value;
	
		public ReferenceWithMetaCreditEventsBuilderImpl() {
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
		public CreditEvents.CreditEventsBuilder getValue() {
			return value;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateValue() {
			CreditEvents.CreditEventsBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = CreditEvents.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder setValue(CreditEvents value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaCreditEvents build() {
			return new ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsImpl(this);
		}
		
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder prune() {
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
		public ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder o = (ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder) other;
			
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
		
			ReferenceWithMetaCreditEvents _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCreditEventsBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaCreditEventsMeta extends BasicRosettaMetaData<ReferenceWithMetaCreditEvents>{

}
