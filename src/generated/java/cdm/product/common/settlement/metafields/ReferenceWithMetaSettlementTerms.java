package cdm.product.common.settlement.metafields;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilderImpl;
import cdm.product.common.settlement.metafields.ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsImpl;
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

public interface ReferenceWithMetaSettlementTerms extends RosettaModelObject, ReferenceWithMeta<SettlementTerms> {
	ReferenceWithMetaSettlementTerms build();
	ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder toBuilder();
	
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
	SettlementTerms getValue();
	final static ReferenceWithMetaSettlementTermsMeta metaData = new ReferenceWithMetaSettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaSettlementTerms> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder builder() {
		return new ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaSettlementTerms> getType() {
		return ReferenceWithMetaSettlementTerms.class;
	}
	
		default Class<SettlementTerms> getValueType() {
			return SettlementTerms.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, SettlementTerms.class, getValue());
	}
	
	
	interface ReferenceWithMetaSettlementTermsBuilder extends ReferenceWithMetaSettlementTerms, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<SettlementTerms> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		SettlementTerms.SettlementTermsBuilder getOrCreateValue();
		SettlementTerms.SettlementTermsBuilder getValue();
		ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setExternalReference(String externalReference);
		ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setReference(Reference reference);
		ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setValue(SettlementTerms value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, SettlementTerms.SettlementTermsBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsImpl
	class ReferenceWithMetaSettlementTermsImpl implements ReferenceWithMetaSettlementTerms {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final SettlementTerms value;
		
		protected ReferenceWithMetaSettlementTermsImpl(ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder builder) {
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
		public SettlementTerms getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaSettlementTerms build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder toBuilder() {
			ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSettlementTerms {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilderImpl
	class ReferenceWithMetaSettlementTermsBuilderImpl implements ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected SettlementTerms.SettlementTermsBuilder value;
	
		public ReferenceWithMetaSettlementTermsBuilderImpl() {
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
		public SettlementTerms.SettlementTermsBuilder getValue() {
			return value;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateValue() {
			SettlementTerms.SettlementTermsBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = SettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder setValue(SettlementTerms value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaSettlementTerms build() {
			return new ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsImpl(this);
		}
		
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder prune() {
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
		public ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder o = (ReferenceWithMetaSettlementTerms.ReferenceWithMetaSettlementTermsBuilder) other;
			
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
		
			ReferenceWithMetaSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSettlementTermsBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaSettlementTermsMeta extends BasicRosettaMetaData<ReferenceWithMetaSettlementTerms>{

}
