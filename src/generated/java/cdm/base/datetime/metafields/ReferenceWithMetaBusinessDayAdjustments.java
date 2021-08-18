package cdm.base.datetime.metafields;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilderImpl;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsImpl;
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

public interface ReferenceWithMetaBusinessDayAdjustments extends RosettaModelObject, ReferenceWithMeta<BusinessDayAdjustments> {
	ReferenceWithMetaBusinessDayAdjustments build();
	ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder toBuilder();
	
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
	BusinessDayAdjustments getValue();
	final static ReferenceWithMetaBusinessDayAdjustmentsMeta metaData = new ReferenceWithMetaBusinessDayAdjustmentsMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaBusinessDayAdjustments> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder builder() {
		return new ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaBusinessDayAdjustments> getType() {
		return ReferenceWithMetaBusinessDayAdjustments.class;
	}
	
		default Class<BusinessDayAdjustments> getValueType() {
			return BusinessDayAdjustments.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, BusinessDayAdjustments.class, getValue());
	}
	
	
	interface ReferenceWithMetaBusinessDayAdjustmentsBuilder extends ReferenceWithMetaBusinessDayAdjustments, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<BusinessDayAdjustments> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateValue();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getValue();
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setExternalReference(String externalReference);
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setReference(Reference reference);
		ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setValue(BusinessDayAdjustments value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsImpl
	class ReferenceWithMetaBusinessDayAdjustmentsImpl implements ReferenceWithMetaBusinessDayAdjustments {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final BusinessDayAdjustments value;
		
		protected ReferenceWithMetaBusinessDayAdjustmentsImpl(ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder builder) {
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
		public BusinessDayAdjustments getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaBusinessDayAdjustments build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder toBuilder() {
			ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaBusinessDayAdjustments _that = getType().cast(o);
		
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
			return "ReferenceWithMetaBusinessDayAdjustments {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilderImpl
	class ReferenceWithMetaBusinessDayAdjustmentsBuilderImpl implements ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder value;
	
		public ReferenceWithMetaBusinessDayAdjustmentsBuilderImpl() {
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
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getValue() {
			return value;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateValue() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder setValue(BusinessDayAdjustments value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaBusinessDayAdjustments build() {
			return new ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsImpl(this);
		}
		
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder prune() {
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
		public ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder o = (ReferenceWithMetaBusinessDayAdjustments.ReferenceWithMetaBusinessDayAdjustmentsBuilder) other;
			
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
		
			ReferenceWithMetaBusinessDayAdjustments _that = getType().cast(o);
		
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
			return "ReferenceWithMetaBusinessDayAdjustmentsBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaBusinessDayAdjustmentsMeta extends BasicRosettaMetaData<ReferenceWithMetaBusinessDayAdjustments>{

}
