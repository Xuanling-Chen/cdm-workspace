package cdm.observable.asset.metafields;

import cdm.observable.asset.RateObservation;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilderImpl;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationImpl;
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

public interface ReferenceWithMetaRateObservation extends RosettaModelObject, ReferenceWithMeta<RateObservation> {
	ReferenceWithMetaRateObservation build();
	ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder toBuilder();
	
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
	RateObservation getValue();
	final static ReferenceWithMetaRateObservationMeta metaData = new ReferenceWithMetaRateObservationMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaRateObservation> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder builder() {
		return new ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaRateObservation> getType() {
		return ReferenceWithMetaRateObservation.class;
	}
	
		default Class<RateObservation> getValueType() {
			return RateObservation.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, RateObservation.class, getValue());
	}
	
	
	interface ReferenceWithMetaRateObservationBuilder extends ReferenceWithMetaRateObservation, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<RateObservation> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		RateObservation.RateObservationBuilder getOrCreateValue();
		RateObservation.RateObservationBuilder getValue();
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setExternalReference(String externalReference);
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setReference(Reference reference);
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setValue(RateObservation value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, RateObservation.RateObservationBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationImpl
	class ReferenceWithMetaRateObservationImpl implements ReferenceWithMetaRateObservation {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final RateObservation value;
		
		protected ReferenceWithMetaRateObservationImpl(ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder builder) {
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
		public RateObservation getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaRateObservation build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder toBuilder() {
			ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaRateObservation _that = getType().cast(o);
		
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
			return "ReferenceWithMetaRateObservation {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilderImpl
	class ReferenceWithMetaRateObservationBuilderImpl implements ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected RateObservation.RateObservationBuilder value;
	
		public ReferenceWithMetaRateObservationBuilderImpl() {
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
		public RateObservation.RateObservationBuilder getValue() {
			return value;
		}
		
		@Override
		public RateObservation.RateObservationBuilder getOrCreateValue() {
			RateObservation.RateObservationBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = RateObservation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder setValue(RateObservation value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaRateObservation build() {
			return new ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationImpl(this);
		}
		
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder prune() {
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
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder o = (ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder) other;
			
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
		
			ReferenceWithMetaRateObservation _that = getType().cast(o);
		
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
			return "ReferenceWithMetaRateObservationBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaRateObservationMeta extends BasicRosettaMetaData<ReferenceWithMetaRateObservation>{

}
