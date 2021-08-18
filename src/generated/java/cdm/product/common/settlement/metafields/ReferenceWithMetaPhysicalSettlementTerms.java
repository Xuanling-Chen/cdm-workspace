package cdm.product.common.settlement.metafields;

import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilderImpl;
import cdm.product.common.settlement.metafields.ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsImpl;
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

public interface ReferenceWithMetaPhysicalSettlementTerms extends RosettaModelObject, ReferenceWithMeta<PhysicalSettlementTerms> {
	ReferenceWithMetaPhysicalSettlementTerms build();
	ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder toBuilder();
	
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
	PhysicalSettlementTerms getValue();
	final static ReferenceWithMetaPhysicalSettlementTermsMeta metaData = new ReferenceWithMetaPhysicalSettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaPhysicalSettlementTerms> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder builder() {
		return new ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaPhysicalSettlementTerms> getType() {
		return ReferenceWithMetaPhysicalSettlementTerms.class;
	}
	
		default Class<PhysicalSettlementTerms> getValueType() {
			return PhysicalSettlementTerms.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, PhysicalSettlementTerms.class, getValue());
	}
	
	
	interface ReferenceWithMetaPhysicalSettlementTermsBuilder extends ReferenceWithMetaPhysicalSettlementTerms, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<PhysicalSettlementTerms> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreateValue();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getValue();
		ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setExternalReference(String externalReference);
		ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setReference(Reference reference);
		ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setValue(PhysicalSettlementTerms value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, PhysicalSettlementTerms.PhysicalSettlementTermsBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsImpl
	class ReferenceWithMetaPhysicalSettlementTermsImpl implements ReferenceWithMetaPhysicalSettlementTerms {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final PhysicalSettlementTerms value;
		
		protected ReferenceWithMetaPhysicalSettlementTermsImpl(ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder builder) {
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
		public PhysicalSettlementTerms getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder toBuilder() {
			ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaPhysicalSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPhysicalSettlementTerms {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilderImpl
	class ReferenceWithMetaPhysicalSettlementTermsBuilderImpl implements ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder value;
	
		public ReferenceWithMetaPhysicalSettlementTermsBuilderImpl() {
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
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getValue() {
			return value;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreateValue() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = PhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder setValue(PhysicalSettlementTerms value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms build() {
			return new ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsImpl(this);
		}
		
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder prune() {
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
		public ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder o = (ReferenceWithMetaPhysicalSettlementTerms.ReferenceWithMetaPhysicalSettlementTermsBuilder) other;
			
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
		
			ReferenceWithMetaPhysicalSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPhysicalSettlementTermsBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaPhysicalSettlementTermsMeta extends BasicRosettaMetaData<ReferenceWithMetaPhysicalSettlementTerms>{

}
