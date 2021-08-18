package cdm.product.template.metafields;

import cdm.product.template.EquityPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilderImpl;
import cdm.product.template.metafields.ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutImpl;
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

public interface ReferenceWithMetaEquityPayout extends RosettaModelObject, ReferenceWithMeta<EquityPayout> {
	ReferenceWithMetaEquityPayout build();
	ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder toBuilder();
	
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
	EquityPayout getValue();
	final static ReferenceWithMetaEquityPayoutMeta metaData = new ReferenceWithMetaEquityPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaEquityPayout> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder builder() {
		return new ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaEquityPayout> getType() {
		return ReferenceWithMetaEquityPayout.class;
	}
	
		default Class<EquityPayout> getValueType() {
			return EquityPayout.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, EquityPayout.class, getValue());
	}
	
	
	interface ReferenceWithMetaEquityPayoutBuilder extends ReferenceWithMetaEquityPayout, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<EquityPayout> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		EquityPayout.EquityPayoutBuilder getOrCreateValue();
		EquityPayout.EquityPayoutBuilder getValue();
		ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setReference(Reference reference);
		ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setValue(EquityPayout value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, EquityPayout.EquityPayoutBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutImpl
	class ReferenceWithMetaEquityPayoutImpl implements ReferenceWithMetaEquityPayout {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final EquityPayout value;
		
		protected ReferenceWithMetaEquityPayoutImpl(ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder builder) {
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
		public EquityPayout getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaEquityPayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder toBuilder() {
			ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaEquityPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaEquityPayout {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilderImpl
	class ReferenceWithMetaEquityPayoutBuilderImpl implements ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected EquityPayout.EquityPayoutBuilder value;
	
		public ReferenceWithMetaEquityPayoutBuilderImpl() {
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
		public EquityPayout.EquityPayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public EquityPayout.EquityPayoutBuilder getOrCreateValue() {
			EquityPayout.EquityPayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = EquityPayout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder setValue(EquityPayout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaEquityPayout build() {
			return new ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder prune() {
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
		public ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder o = (ReferenceWithMetaEquityPayout.ReferenceWithMetaEquityPayoutBuilder) other;
			
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
		
			ReferenceWithMetaEquityPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaEquityPayoutBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaEquityPayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaEquityPayout>{

}
