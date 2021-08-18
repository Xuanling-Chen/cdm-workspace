package cdm.product.common.schedule.metafields;

import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilderImpl;
import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesImpl;
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

public interface ReferenceWithMetaPaymentDates extends RosettaModelObject, ReferenceWithMeta<PaymentDates> {
	ReferenceWithMetaPaymentDates build();
	ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder toBuilder();
	
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
	PaymentDates getValue();
	final static ReferenceWithMetaPaymentDatesMeta metaData = new ReferenceWithMetaPaymentDatesMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaPaymentDates> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder builder() {
		return new ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaPaymentDates> getType() {
		return ReferenceWithMetaPaymentDates.class;
	}
	
		default Class<PaymentDates> getValueType() {
			return PaymentDates.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, PaymentDates.class, getValue());
	}
	
	
	interface ReferenceWithMetaPaymentDatesBuilder extends ReferenceWithMetaPaymentDates, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<PaymentDates> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		PaymentDates.PaymentDatesBuilder getOrCreateValue();
		PaymentDates.PaymentDatesBuilder getValue();
		ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setExternalReference(String externalReference);
		ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setReference(Reference reference);
		ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setValue(PaymentDates value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, PaymentDates.PaymentDatesBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesImpl
	class ReferenceWithMetaPaymentDatesImpl implements ReferenceWithMetaPaymentDates {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final PaymentDates value;
		
		protected ReferenceWithMetaPaymentDatesImpl(ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder builder) {
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
		public PaymentDates getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaPaymentDates build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder toBuilder() {
			ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaPaymentDates _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPaymentDates {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilderImpl
	class ReferenceWithMetaPaymentDatesBuilderImpl implements ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected PaymentDates.PaymentDatesBuilder value;
	
		public ReferenceWithMetaPaymentDatesBuilderImpl() {
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
		public PaymentDates.PaymentDatesBuilder getValue() {
			return value;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreateValue() {
			PaymentDates.PaymentDatesBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = PaymentDates.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder setValue(PaymentDates value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaPaymentDates build() {
			return new ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesImpl(this);
		}
		
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder prune() {
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
		public ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder o = (ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder) other;
			
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
		
			ReferenceWithMetaPaymentDates _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPaymentDatesBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaPaymentDatesMeta extends BasicRosettaMetaData<ReferenceWithMetaPaymentDates>{

}
