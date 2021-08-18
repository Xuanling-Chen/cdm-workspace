package cdm.product.template.metafields;

import cdm.product.template.SecurityPayout;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilderImpl;
import cdm.product.template.metafields.ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutImpl;
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

public interface ReferenceWithMetaSecurityPayout extends RosettaModelObject, ReferenceWithMeta<SecurityPayout> {
	ReferenceWithMetaSecurityPayout build();
	ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder toBuilder();
	
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
	SecurityPayout getValue();
	final static ReferenceWithMetaSecurityPayoutMeta metaData = new ReferenceWithMetaSecurityPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaSecurityPayout> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder builder() {
		return new ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaSecurityPayout> getType() {
		return ReferenceWithMetaSecurityPayout.class;
	}
	
		default Class<SecurityPayout> getValueType() {
			return SecurityPayout.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, SecurityPayout.class, getValue());
	}
	
	
	interface ReferenceWithMetaSecurityPayoutBuilder extends ReferenceWithMetaSecurityPayout, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<SecurityPayout> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		SecurityPayout.SecurityPayoutBuilder getOrCreateValue();
		SecurityPayout.SecurityPayoutBuilder getValue();
		ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setReference(Reference reference);
		ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setValue(SecurityPayout value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, SecurityPayout.SecurityPayoutBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutImpl
	class ReferenceWithMetaSecurityPayoutImpl implements ReferenceWithMetaSecurityPayout {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final SecurityPayout value;
		
		protected ReferenceWithMetaSecurityPayoutImpl(ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder builder) {
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
		public SecurityPayout getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder toBuilder() {
			ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaSecurityPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSecurityPayout {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilderImpl
	class ReferenceWithMetaSecurityPayoutBuilderImpl implements ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected SecurityPayout.SecurityPayoutBuilder value;
	
		public ReferenceWithMetaSecurityPayoutBuilderImpl() {
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
		public SecurityPayout.SecurityPayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public SecurityPayout.SecurityPayoutBuilder getOrCreateValue() {
			SecurityPayout.SecurityPayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = SecurityPayout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder setValue(SecurityPayout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaSecurityPayout build() {
			return new ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder prune() {
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
		public ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder o = (ReferenceWithMetaSecurityPayout.ReferenceWithMetaSecurityPayoutBuilder) other;
			
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
		
			ReferenceWithMetaSecurityPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSecurityPayoutBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaSecurityPayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaSecurityPayout>{

}
