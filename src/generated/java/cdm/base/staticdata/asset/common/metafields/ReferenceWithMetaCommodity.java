package cdm.base.staticdata.asset.common.metafields;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilderImpl;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity.ReferenceWithMetaCommodityImpl;
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

public interface ReferenceWithMetaCommodity extends RosettaModelObject, ReferenceWithMeta<Commodity> {
	ReferenceWithMetaCommodity build();
	ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder toBuilder();
	
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
	Commodity getValue();
	final static ReferenceWithMetaCommodityMeta metaData = new ReferenceWithMetaCommodityMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaCommodity> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder builder() {
		return new ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaCommodity> getType() {
		return ReferenceWithMetaCommodity.class;
	}
	
		default Class<Commodity> getValueType() {
			return Commodity.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, Commodity.class, getValue());
	}
	
	
	interface ReferenceWithMetaCommodityBuilder extends ReferenceWithMetaCommodity, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Commodity> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		Commodity.CommodityBuilder getOrCreateValue();
		Commodity.CommodityBuilder getValue();
		ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setExternalReference(String externalReference);
		ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setReference(Reference reference);
		ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setValue(Commodity value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, Commodity.CommodityBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaCommodity.ReferenceWithMetaCommodityImpl
	class ReferenceWithMetaCommodityImpl implements ReferenceWithMetaCommodity {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Commodity value;
		
		protected ReferenceWithMetaCommodityImpl(ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder builder) {
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
		public Commodity getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaCommodity build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder toBuilder() {
			ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaCommodity _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCommodity {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilderImpl
	class ReferenceWithMetaCommodityBuilderImpl implements ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Commodity.CommodityBuilder value;
	
		public ReferenceWithMetaCommodityBuilderImpl() {
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
		public Commodity.CommodityBuilder getValue() {
			return value;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateValue() {
			Commodity.CommodityBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Commodity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder setValue(Commodity value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaCommodity build() {
			return new ReferenceWithMetaCommodity.ReferenceWithMetaCommodityImpl(this);
		}
		
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder prune() {
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
		public ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder o = (ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder) other;
			
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
		
			ReferenceWithMetaCommodity _that = getType().cast(o);
		
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
			return "ReferenceWithMetaCommodityBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaCommodityMeta extends BasicRosettaMetaData<ReferenceWithMetaCommodity>{

}
