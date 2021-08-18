package cdm.observable.asset.metafields;

import cdm.observable.asset.FixedRateSpecification;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilderImpl;
import cdm.observable.asset.metafields.ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationImpl;
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

public interface ReferenceWithMetaFixedRateSpecification extends RosettaModelObject, ReferenceWithMeta<FixedRateSpecification> {
	ReferenceWithMetaFixedRateSpecification build();
	ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder toBuilder();
	
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
	FixedRateSpecification getValue();
	final static ReferenceWithMetaFixedRateSpecificationMeta metaData = new ReferenceWithMetaFixedRateSpecificationMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaFixedRateSpecification> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder builder() {
		return new ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaFixedRateSpecification> getType() {
		return ReferenceWithMetaFixedRateSpecification.class;
	}
	
		default Class<FixedRateSpecification> getValueType() {
			return FixedRateSpecification.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, FixedRateSpecification.class, getValue());
	}
	
	
	interface ReferenceWithMetaFixedRateSpecificationBuilder extends ReferenceWithMetaFixedRateSpecification, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<FixedRateSpecification> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		FixedRateSpecification.FixedRateSpecificationBuilder getOrCreateValue();
		FixedRateSpecification.FixedRateSpecificationBuilder getValue();
		ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setExternalReference(String externalReference);
		ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setReference(Reference reference);
		ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setValue(FixedRateSpecification value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, FixedRateSpecification.FixedRateSpecificationBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationImpl
	class ReferenceWithMetaFixedRateSpecificationImpl implements ReferenceWithMetaFixedRateSpecification {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final FixedRateSpecification value;
		
		protected ReferenceWithMetaFixedRateSpecificationImpl(ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder builder) {
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
		public FixedRateSpecification getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecification build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder toBuilder() {
			ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaFixedRateSpecification _that = getType().cast(o);
		
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
			return "ReferenceWithMetaFixedRateSpecification {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilderImpl
	class ReferenceWithMetaFixedRateSpecificationBuilderImpl implements ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected FixedRateSpecification.FixedRateSpecificationBuilder value;
	
		public ReferenceWithMetaFixedRateSpecificationBuilderImpl() {
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
		public FixedRateSpecification.FixedRateSpecificationBuilder getValue() {
			return value;
		}
		
		@Override
		public FixedRateSpecification.FixedRateSpecificationBuilder getOrCreateValue() {
			FixedRateSpecification.FixedRateSpecificationBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = FixedRateSpecification.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder setValue(FixedRateSpecification value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecification build() {
			return new ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationImpl(this);
		}
		
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder prune() {
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
		public ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder o = (ReferenceWithMetaFixedRateSpecification.ReferenceWithMetaFixedRateSpecificationBuilder) other;
			
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
		
			ReferenceWithMetaFixedRateSpecification _that = getType().cast(o);
		
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
			return "ReferenceWithMetaFixedRateSpecificationBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaFixedRateSpecificationMeta extends BasicRosettaMetaData<ReferenceWithMetaFixedRateSpecification>{

}
