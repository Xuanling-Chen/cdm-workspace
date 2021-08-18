package cdm.product.template.metafields;

import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilderImpl;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutImpl;
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

public interface ReferenceWithMetaPayout extends RosettaModelObject, ReferenceWithMeta<Payout> {
	ReferenceWithMetaPayout build();
	ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder toBuilder();
	
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
	Payout getValue();
	final static ReferenceWithMetaPayoutMeta metaData = new ReferenceWithMetaPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaPayout> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder builder() {
		return new ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaPayout> getType() {
		return ReferenceWithMetaPayout.class;
	}
	
		default Class<Payout> getValueType() {
			return Payout.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, Payout.class, getValue());
	}
	
	
	interface ReferenceWithMetaPayoutBuilder extends ReferenceWithMetaPayout, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Payout> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		Payout.PayoutBuilder getOrCreateValue();
		Payout.PayoutBuilder getValue();
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setReference(Reference reference);
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setValue(Payout value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, Payout.PayoutBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaPayout.ReferenceWithMetaPayoutImpl
	class ReferenceWithMetaPayoutImpl implements ReferenceWithMetaPayout {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Payout value;
		
		protected ReferenceWithMetaPayoutImpl(ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder builder) {
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
		public Payout getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaPayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder toBuilder() {
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPayout {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilderImpl
	class ReferenceWithMetaPayoutBuilderImpl implements ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Payout.PayoutBuilder value;
	
		public ReferenceWithMetaPayoutBuilderImpl() {
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
		public Payout.PayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public Payout.PayoutBuilder getOrCreateValue() {
			Payout.PayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Payout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder setValue(Payout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaPayout build() {
			return new ReferenceWithMetaPayout.ReferenceWithMetaPayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder prune() {
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
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder o = (ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder) other;
			
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
		
			ReferenceWithMetaPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPayoutBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaPayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaPayout>{

}
