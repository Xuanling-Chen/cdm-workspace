package com.rosetta.model.metafields;

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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilderImpl;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate.BasicReferenceWithMetaDateImpl;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface BasicReferenceWithMetaDate extends RosettaModelObject, ReferenceWithMeta<Date> {
	BasicReferenceWithMetaDate build();
	BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder toBuilder();
	
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
	Date getValue();
	final static BasicReferenceWithMetaDateMeta metaData = new BasicReferenceWithMetaDateMeta();
	
	@Override
	default RosettaMetaData<? extends BasicReferenceWithMetaDate> metaData() {
		return metaData;
	} 
			
	static BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder builder() {
		return new BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilderImpl();
	}
	
	default Class<? extends BasicReferenceWithMetaDate> getType() {
		return BasicReferenceWithMetaDate.class;
	}
	
		default Class<Date> getValueType() {
			return Date.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
	}
	
	
	interface BasicReferenceWithMetaDateBuilder extends BasicReferenceWithMetaDate, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Date> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setExternalReference(String externalReference);
		BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setGlobalReference(String globalReference);
		BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setReference(Reference reference);
		BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setValue(Date value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
		}
		
	}
	
	//BasicReferenceWithMetaDate.BasicReferenceWithMetaDateImpl
	class BasicReferenceWithMetaDateImpl implements BasicReferenceWithMetaDate {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Date value;
		
		protected BasicReferenceWithMetaDateImpl(BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder builder) {
			this.externalReference = builder.getExternalReference();
			this.globalReference = builder.getGlobalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
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
		public Date getValue() {
			return value;
		}
		
		@Override
		public BasicReferenceWithMetaDate build() {
			return this;
		}
		
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder toBuilder() {
			BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasicReferenceWithMetaDate _that = getType().cast(o);
		
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
			return "BasicReferenceWithMetaDate {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilderImpl
	class BasicReferenceWithMetaDateBuilderImpl implements BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Date value;
	
		public BasicReferenceWithMetaDateBuilderImpl() {
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
		public Date getValue() {
			return value;
		}
		
	
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder setValue(Date value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public BasicReferenceWithMetaDate build() {
			return new BasicReferenceWithMetaDate.BasicReferenceWithMetaDateImpl(this);
		}
		
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder prune() {
			if (reference!=null && !reference.prune().hasData()) reference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalReference()!=null) return true;
			if (getGlobalReference()!=null) return true;
			if (getReference()!=null && getReference().hasData()) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder o = (BasicReferenceWithMetaDate.BasicReferenceWithMetaDateBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::setReference);
			
			merger.mergeBasic(getExternalReference(), o.getExternalReference(), this::setExternalReference);
			merger.mergeBasic(getGlobalReference(), o.getGlobalReference(), this::setGlobalReference);
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasicReferenceWithMetaDate _that = getType().cast(o);
		
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
			return "BasicReferenceWithMetaDateBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class BasicReferenceWithMetaDateMeta extends BasicRosettaMetaData<BasicReferenceWithMetaDate>{

}
