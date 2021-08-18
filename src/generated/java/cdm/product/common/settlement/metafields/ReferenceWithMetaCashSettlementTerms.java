package cdm.product.common.settlement.metafields;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilderImpl;
import cdm.product.common.settlement.metafields.ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsImpl;
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

public interface ReferenceWithMetaCashSettlementTerms extends RosettaModelObject, ReferenceWithMeta<CashSettlementTerms> {
	ReferenceWithMetaCashSettlementTerms build();
	ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder toBuilder();
	
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
	CashSettlementTerms getValue();
	final static ReferenceWithMetaCashSettlementTermsMeta metaData = new ReferenceWithMetaCashSettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaCashSettlementTerms> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder builder() {
		return new ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaCashSettlementTerms> getType() {
		return ReferenceWithMetaCashSettlementTerms.class;
	}
	
		default Class<CashSettlementTerms> getValueType() {
			return CashSettlementTerms.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, CashSettlementTerms.class, getValue());
	}
	
	
	interface ReferenceWithMetaCashSettlementTermsBuilder extends ReferenceWithMetaCashSettlementTerms, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<CashSettlementTerms> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateValue();
		CashSettlementTerms.CashSettlementTermsBuilder getValue();
		ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setExternalReference(String externalReference);
		ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setReference(Reference reference);
		ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setValue(CashSettlementTerms value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsImpl
	class ReferenceWithMetaCashSettlementTermsImpl implements ReferenceWithMetaCashSettlementTerms {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final CashSettlementTerms value;
		
		protected ReferenceWithMetaCashSettlementTermsImpl(ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder builder) {
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
		public CashSettlementTerms getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder toBuilder() {
			ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaCashSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCashSettlementTerms {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilderImpl
	class ReferenceWithMetaCashSettlementTermsBuilderImpl implements ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected CashSettlementTerms.CashSettlementTermsBuilder value;
	
		public ReferenceWithMetaCashSettlementTermsBuilderImpl() {
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
		public CashSettlementTerms.CashSettlementTermsBuilder getValue() {
			return value;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateValue() {
			CashSettlementTerms.CashSettlementTermsBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = CashSettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder setValue(CashSettlementTerms value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms build() {
			return new ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsImpl(this);
		}
		
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder prune() {
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
		public ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder o = (ReferenceWithMetaCashSettlementTerms.ReferenceWithMetaCashSettlementTermsBuilder) other;
			
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
		
			ReferenceWithMetaCashSettlementTerms _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCashSettlementTermsBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaCashSettlementTermsMeta extends BasicRosettaMetaData<ReferenceWithMetaCashSettlementTerms>{

}
