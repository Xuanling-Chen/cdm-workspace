package cdm.base.staticdata.asset.common.metafields;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilderImpl;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierImpl;
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

public interface ReferenceWithMetaProductIdentifier extends RosettaModelObject, ReferenceWithMeta<ProductIdentifier> {
	ReferenceWithMetaProductIdentifier build();
	ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder toBuilder();
	
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
	ProductIdentifier getValue();
	final static ReferenceWithMetaProductIdentifierMeta metaData = new ReferenceWithMetaProductIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaProductIdentifier> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder builder() {
		return new ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaProductIdentifier> getType() {
		return ReferenceWithMetaProductIdentifier.class;
	}
	
		default Class<ProductIdentifier> getValueType() {
			return ProductIdentifier.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, ProductIdentifier.class, getValue());
	}
	
	
	interface ReferenceWithMetaProductIdentifierBuilder extends ReferenceWithMetaProductIdentifier, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<ProductIdentifier> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		ProductIdentifier.ProductIdentifierBuilder getOrCreateValue();
		ProductIdentifier.ProductIdentifierBuilder getValue();
		ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setExternalReference(String externalReference);
		ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setReference(Reference reference);
		ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setValue(ProductIdentifier value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierImpl
	class ReferenceWithMetaProductIdentifierImpl implements ReferenceWithMetaProductIdentifier {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final ProductIdentifier value;
		
		protected ReferenceWithMetaProductIdentifierImpl(ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder builder) {
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
		public ProductIdentifier getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaProductIdentifier build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder toBuilder() {
			ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaProductIdentifier _that = getType().cast(o);
		
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
			return "ReferenceWithMetaProductIdentifier {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilderImpl
	class ReferenceWithMetaProductIdentifierBuilderImpl implements ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected ProductIdentifier.ProductIdentifierBuilder value;
	
		public ReferenceWithMetaProductIdentifierBuilderImpl() {
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
		public ProductIdentifier.ProductIdentifierBuilder getValue() {
			return value;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateValue() {
			ProductIdentifier.ProductIdentifierBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = ProductIdentifier.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder setValue(ProductIdentifier value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaProductIdentifier build() {
			return new ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierImpl(this);
		}
		
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder prune() {
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
		public ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder o = (ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder) other;
			
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
		
			ReferenceWithMetaProductIdentifier _that = getType().cast(o);
		
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
			return "ReferenceWithMetaProductIdentifierBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaProductIdentifierMeta extends BasicRosettaMetaData<ReferenceWithMetaProductIdentifier>{

}
