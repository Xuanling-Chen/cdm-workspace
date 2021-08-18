package cdm.product.asset.metafields;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilderImpl;
import cdm.product.asset.metafields.ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutImpl;
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

public interface ReferenceWithMetaInterestRatePayout extends RosettaModelObject, ReferenceWithMeta<InterestRatePayout> {
	ReferenceWithMetaInterestRatePayout build();
	ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder toBuilder();
	
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
	InterestRatePayout getValue();
	final static ReferenceWithMetaInterestRatePayoutMeta metaData = new ReferenceWithMetaInterestRatePayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaInterestRatePayout> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder builder() {
		return new ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaInterestRatePayout> getType() {
		return ReferenceWithMetaInterestRatePayout.class;
	}
	
		default Class<InterestRatePayout> getValueType() {
			return InterestRatePayout.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, InterestRatePayout.class, getValue());
	}
	
	
	interface ReferenceWithMetaInterestRatePayoutBuilder extends ReferenceWithMetaInterestRatePayout, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<InterestRatePayout> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		InterestRatePayout.InterestRatePayoutBuilder getOrCreateValue();
		InterestRatePayout.InterestRatePayoutBuilder getValue();
		ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setReference(Reference reference);
		ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setValue(InterestRatePayout value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, InterestRatePayout.InterestRatePayoutBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutImpl
	class ReferenceWithMetaInterestRatePayoutImpl implements ReferenceWithMetaInterestRatePayout {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final InterestRatePayout value;
		
		protected ReferenceWithMetaInterestRatePayoutImpl(ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder builder) {
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
		public InterestRatePayout getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder toBuilder() {
			ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaInterestRatePayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaInterestRatePayout {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilderImpl
	class ReferenceWithMetaInterestRatePayoutBuilderImpl implements ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected InterestRatePayout.InterestRatePayoutBuilder value;
	
		public ReferenceWithMetaInterestRatePayoutBuilderImpl() {
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
		public InterestRatePayout.InterestRatePayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder getOrCreateValue() {
			InterestRatePayout.InterestRatePayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = InterestRatePayout.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder setValue(InterestRatePayout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout build() {
			return new ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder prune() {
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
		public ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder o = (ReferenceWithMetaInterestRatePayout.ReferenceWithMetaInterestRatePayoutBuilder) other;
			
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
		
			ReferenceWithMetaInterestRatePayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaInterestRatePayoutBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaInterestRatePayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaInterestRatePayout>{

}
