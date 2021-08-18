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
import com.rosetta.model.metafields.BasicReferenceWithMetaString;
import com.rosetta.model.metafields.BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder;
import com.rosetta.model.metafields.BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilderImpl;
import com.rosetta.model.metafields.BasicReferenceWithMetaString.BasicReferenceWithMetaStringImpl;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface BasicReferenceWithMetaString extends RosettaModelObject, ReferenceWithMeta<String> {
	BasicReferenceWithMetaString build();
	BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder toBuilder();
	
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
	String getValue();
	final static BasicReferenceWithMetaStringMeta metaData = new BasicReferenceWithMetaStringMeta();
	
	@Override
	default RosettaMetaData<? extends BasicReferenceWithMetaString> metaData() {
		return metaData;
	} 
			
	static BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder builder() {
		return new BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilderImpl();
	}
	
	default Class<? extends BasicReferenceWithMetaString> getType() {
		return BasicReferenceWithMetaString.class;
	}
	
		default Class<String> getValueType() {
			return String.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
	}
	
	
	interface BasicReferenceWithMetaStringBuilder extends BasicReferenceWithMetaString, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<String> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setExternalReference(String externalReference);
		BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setGlobalReference(String globalReference);
		BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setReference(Reference reference);
		BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setValue(String value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
		}
		
	}
	
	//BasicReferenceWithMetaString.BasicReferenceWithMetaStringImpl
	class BasicReferenceWithMetaStringImpl implements BasicReferenceWithMetaString {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final String value;
		
		protected BasicReferenceWithMetaStringImpl(BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder builder) {
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
		public String getValue() {
			return value;
		}
		
		@Override
		public BasicReferenceWithMetaString build() {
			return this;
		}
		
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder toBuilder() {
			BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasicReferenceWithMetaString _that = getType().cast(o);
		
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
			return "BasicReferenceWithMetaString {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilderImpl
	class BasicReferenceWithMetaStringBuilderImpl implements BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected String value;
	
		public BasicReferenceWithMetaStringBuilderImpl() {
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
		public String getValue() {
			return value;
		}
		
	
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public BasicReferenceWithMetaString build() {
			return new BasicReferenceWithMetaString.BasicReferenceWithMetaStringImpl(this);
		}
		
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder prune() {
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
		public BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder o = (BasicReferenceWithMetaString.BasicReferenceWithMetaStringBuilder) other;
			
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
		
			BasicReferenceWithMetaString _that = getType().cast(o);
		
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
			return "BasicReferenceWithMetaStringBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class BasicReferenceWithMetaStringMeta extends BasicRosettaMetaData<BasicReferenceWithMetaString>{

}
