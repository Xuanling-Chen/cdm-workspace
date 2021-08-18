package cdm.product.asset.metafields;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilderImpl;
import cdm.product.asset.metafields.ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutImpl;
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

public interface ReferenceWithMetaCreditDefaultPayout extends RosettaModelObject, ReferenceWithMeta<CreditDefaultPayout> {
	ReferenceWithMetaCreditDefaultPayout build();
	ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder toBuilder();
	
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
	CreditDefaultPayout getValue();
	final static ReferenceWithMetaCreditDefaultPayoutMeta metaData = new ReferenceWithMetaCreditDefaultPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaCreditDefaultPayout> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder builder() {
		return new ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaCreditDefaultPayout> getType() {
		return ReferenceWithMetaCreditDefaultPayout.class;
	}
	
		default Class<CreditDefaultPayout> getValueType() {
			return CreditDefaultPayout.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, CreditDefaultPayout.class, getValue());
	}
	
	
	interface ReferenceWithMetaCreditDefaultPayoutBuilder extends ReferenceWithMetaCreditDefaultPayout, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<CreditDefaultPayout> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateValue();
		CreditDefaultPayout.CreditDefaultPayoutBuilder getValue();
		ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setReference(Reference reference);
		ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setValue(CreditDefaultPayout value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, CreditDefaultPayout.CreditDefaultPayoutBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutImpl
	class ReferenceWithMetaCreditDefaultPayoutImpl implements ReferenceWithMetaCreditDefaultPayout {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final CreditDefaultPayout value;
		
		protected ReferenceWithMetaCreditDefaultPayoutImpl(ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder builder) {
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
		public CreditDefaultPayout getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaCreditDefaultPayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder toBuilder() {
			ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaCreditDefaultPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCreditDefaultPayout {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilderImpl
	class ReferenceWithMetaCreditDefaultPayoutBuilderImpl implements ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder value;
	
		public ReferenceWithMetaCreditDefaultPayoutBuilderImpl() {
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
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateValue() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = CreditDefaultPayout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder setValue(CreditDefaultPayout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaCreditDefaultPayout build() {
			return new ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder prune() {
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
		public ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder o = (ReferenceWithMetaCreditDefaultPayout.ReferenceWithMetaCreditDefaultPayoutBuilder) other;
			
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
		
			ReferenceWithMetaCreditDefaultPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCreditDefaultPayoutBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaCreditDefaultPayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaCreditDefaultPayout>{

}
