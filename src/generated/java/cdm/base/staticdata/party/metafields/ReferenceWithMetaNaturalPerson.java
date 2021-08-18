package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilderImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonImpl;
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

public interface ReferenceWithMetaNaturalPerson extends RosettaModelObject, ReferenceWithMeta<NaturalPerson> {
	ReferenceWithMetaNaturalPerson build();
	ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder toBuilder();
	
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
	NaturalPerson getValue();
	final static ReferenceWithMetaNaturalPersonMeta metaData = new ReferenceWithMetaNaturalPersonMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaNaturalPerson> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder builder() {
		return new ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaNaturalPerson> getType() {
		return ReferenceWithMetaNaturalPerson.class;
	}
	
		default Class<NaturalPerson> getValueType() {
			return NaturalPerson.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, NaturalPerson.class, getValue());
	}
	
	
	interface ReferenceWithMetaNaturalPersonBuilder extends ReferenceWithMetaNaturalPerson, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<NaturalPerson> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		NaturalPerson.NaturalPersonBuilder getOrCreateValue();
		NaturalPerson.NaturalPersonBuilder getValue();
		ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setExternalReference(String externalReference);
		ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setReference(Reference reference);
		ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setValue(NaturalPerson value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, NaturalPerson.NaturalPersonBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonImpl
	class ReferenceWithMetaNaturalPersonImpl implements ReferenceWithMetaNaturalPerson {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final NaturalPerson value;
		
		protected ReferenceWithMetaNaturalPersonImpl(ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder builder) {
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
		public NaturalPerson getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaNaturalPerson build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder toBuilder() {
			ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaNaturalPerson _that = getType().cast(o);
		
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
			return "ReferenceWithMetaNaturalPerson {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilderImpl
	class ReferenceWithMetaNaturalPersonBuilderImpl implements ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected NaturalPerson.NaturalPersonBuilder value;
	
		public ReferenceWithMetaNaturalPersonBuilderImpl() {
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
		public NaturalPerson.NaturalPersonBuilder getValue() {
			return value;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder getOrCreateValue() {
			NaturalPerson.NaturalPersonBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = NaturalPerson.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder setValue(NaturalPerson value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaNaturalPerson build() {
			return new ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonImpl(this);
		}
		
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder prune() {
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
		public ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder o = (ReferenceWithMetaNaturalPerson.ReferenceWithMetaNaturalPersonBuilder) other;
			
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
		
			ReferenceWithMetaNaturalPerson _that = getType().cast(o);
		
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
			return "ReferenceWithMetaNaturalPersonBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaNaturalPersonMeta extends BasicRosettaMetaData<ReferenceWithMetaNaturalPerson>{

}
