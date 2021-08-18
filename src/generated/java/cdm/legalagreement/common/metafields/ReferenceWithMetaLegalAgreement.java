package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilderImpl;
import cdm.legalagreement.common.metafields.ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementImpl;
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

public interface ReferenceWithMetaLegalAgreement extends RosettaModelObject, ReferenceWithMeta<LegalAgreement> {
	ReferenceWithMetaLegalAgreement build();
	ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder toBuilder();
	
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
	LegalAgreement getValue();
	final static ReferenceWithMetaLegalAgreementMeta metaData = new ReferenceWithMetaLegalAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaLegalAgreement> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder builder() {
		return new ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaLegalAgreement> getType() {
		return ReferenceWithMetaLegalAgreement.class;
	}
	
		default Class<LegalAgreement> getValueType() {
			return LegalAgreement.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, LegalAgreement.class, getValue());
	}
	
	
	interface ReferenceWithMetaLegalAgreementBuilder extends ReferenceWithMetaLegalAgreement, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<LegalAgreement> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		LegalAgreement.LegalAgreementBuilder getOrCreateValue();
		LegalAgreement.LegalAgreementBuilder getValue();
		ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setExternalReference(String externalReference);
		ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setReference(Reference reference);
		ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setValue(LegalAgreement value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, LegalAgreement.LegalAgreementBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementImpl
	class ReferenceWithMetaLegalAgreementImpl implements ReferenceWithMetaLegalAgreement {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final LegalAgreement value;
		
		protected ReferenceWithMetaLegalAgreementImpl(ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder builder) {
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
		public LegalAgreement getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaLegalAgreement build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder toBuilder() {
			ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaLegalAgreement _that = getType().cast(o);
		
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
			return "ReferenceWithMetaLegalAgreement {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilderImpl
	class ReferenceWithMetaLegalAgreementBuilderImpl implements ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected LegalAgreement.LegalAgreementBuilder value;
	
		public ReferenceWithMetaLegalAgreementBuilderImpl() {
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
		public LegalAgreement.LegalAgreementBuilder getValue() {
			return value;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder getOrCreateValue() {
			LegalAgreement.LegalAgreementBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = LegalAgreement.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder setValue(LegalAgreement value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaLegalAgreement build() {
			return new ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementImpl(this);
		}
		
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder prune() {
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
		public ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder o = (ReferenceWithMetaLegalAgreement.ReferenceWithMetaLegalAgreementBuilder) other;
			
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
		
			ReferenceWithMetaLegalAgreement _that = getType().cast(o);
		
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
			return "ReferenceWithMetaLegalAgreementBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaLegalAgreementMeta extends BasicRosettaMetaData<ReferenceWithMetaLegalAgreement>{

}
