package cdm.base.datetime.metafields;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilderImpl;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersImpl;
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

public interface ReferenceWithMetaBusinessCenters extends RosettaModelObject, ReferenceWithMeta<BusinessCenters> {
	ReferenceWithMetaBusinessCenters build();
	ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder toBuilder();
	
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
	BusinessCenters getValue();
	final static ReferenceWithMetaBusinessCentersMeta metaData = new ReferenceWithMetaBusinessCentersMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaBusinessCenters> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder builder() {
		return new ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaBusinessCenters> getType() {
		return ReferenceWithMetaBusinessCenters.class;
	}
	
		default Class<BusinessCenters> getValueType() {
			return BusinessCenters.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, BusinessCenters.class, getValue());
	}
	
	
	interface ReferenceWithMetaBusinessCentersBuilder extends ReferenceWithMetaBusinessCenters, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<BusinessCenters> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateValue();
		BusinessCenters.BusinessCentersBuilder getValue();
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setExternalReference(String externalReference);
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setReference(Reference reference);
		ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setValue(BusinessCenters value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, BusinessCenters.BusinessCentersBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersImpl
	class ReferenceWithMetaBusinessCentersImpl implements ReferenceWithMetaBusinessCenters {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final BusinessCenters value;
		
		protected ReferenceWithMetaBusinessCentersImpl(ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder builder) {
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
		public BusinessCenters getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder toBuilder() {
			ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaBusinessCenters _that = getType().cast(o);
		
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
			return "ReferenceWithMetaBusinessCenters {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilderImpl
	class ReferenceWithMetaBusinessCentersBuilderImpl implements ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected BusinessCenters.BusinessCentersBuilder value;
	
		public ReferenceWithMetaBusinessCentersBuilderImpl() {
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
		public BusinessCenters.BusinessCentersBuilder getValue() {
			return value;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateValue() {
			BusinessCenters.BusinessCentersBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = BusinessCenters.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder setValue(BusinessCenters value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters build() {
			return new ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersImpl(this);
		}
		
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder prune() {
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
		public ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder o = (ReferenceWithMetaBusinessCenters.ReferenceWithMetaBusinessCentersBuilder) other;
			
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
		
			ReferenceWithMetaBusinessCenters _that = getType().cast(o);
		
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
			return "ReferenceWithMetaBusinessCentersBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaBusinessCentersMeta extends BasicRosettaMetaData<ReferenceWithMetaBusinessCenters>{

}
