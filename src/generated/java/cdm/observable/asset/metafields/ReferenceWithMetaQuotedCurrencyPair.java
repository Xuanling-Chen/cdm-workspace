package cdm.observable.asset.metafields;

import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilderImpl;
import cdm.observable.asset.metafields.ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairImpl;
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

public interface ReferenceWithMetaQuotedCurrencyPair extends RosettaModelObject, ReferenceWithMeta<QuotedCurrencyPair> {
	ReferenceWithMetaQuotedCurrencyPair build();
	ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder toBuilder();
	
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
	QuotedCurrencyPair getValue();
	final static ReferenceWithMetaQuotedCurrencyPairMeta metaData = new ReferenceWithMetaQuotedCurrencyPairMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaQuotedCurrencyPair> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder builder() {
		return new ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaQuotedCurrencyPair> getType() {
		return ReferenceWithMetaQuotedCurrencyPair.class;
	}
	
		default Class<QuotedCurrencyPair> getValueType() {
			return QuotedCurrencyPair.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, QuotedCurrencyPair.class, getValue());
	}
	
	
	interface ReferenceWithMetaQuotedCurrencyPairBuilder extends ReferenceWithMetaQuotedCurrencyPair, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<QuotedCurrencyPair> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateValue();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getValue();
		ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setExternalReference(String externalReference);
		ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setReference(Reference reference);
		ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setValue(QuotedCurrencyPair value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairImpl
	class ReferenceWithMetaQuotedCurrencyPairImpl implements ReferenceWithMetaQuotedCurrencyPair {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final QuotedCurrencyPair value;
		
		protected ReferenceWithMetaQuotedCurrencyPairImpl(ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder builder) {
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
		public QuotedCurrencyPair getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder toBuilder() {
			ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaQuotedCurrencyPair _that = getType().cast(o);
		
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
			return "ReferenceWithMetaQuotedCurrencyPair {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilderImpl
	class ReferenceWithMetaQuotedCurrencyPairBuilderImpl implements ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder value;
	
		public ReferenceWithMetaQuotedCurrencyPairBuilderImpl() {
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
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getValue() {
			return value;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateValue() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder setValue(QuotedCurrencyPair value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair build() {
			return new ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairImpl(this);
		}
		
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder prune() {
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
		public ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder o = (ReferenceWithMetaQuotedCurrencyPair.ReferenceWithMetaQuotedCurrencyPairBuilder) other;
			
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
		
			ReferenceWithMetaQuotedCurrencyPair _that = getType().cast(o);
		
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
			return "ReferenceWithMetaQuotedCurrencyPairBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaQuotedCurrencyPairMeta extends BasicRosettaMetaData<ReferenceWithMetaQuotedCurrencyPair>{

}
