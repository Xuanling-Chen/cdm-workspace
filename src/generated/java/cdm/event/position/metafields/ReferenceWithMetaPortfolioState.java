package cdm.event.position.metafields;

import cdm.event.position.PortfolioState;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilderImpl;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateImpl;
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

public interface ReferenceWithMetaPortfolioState extends RosettaModelObject, ReferenceWithMeta<PortfolioState> {
	ReferenceWithMetaPortfolioState build();
	ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder toBuilder();
	
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
	PortfolioState getValue();
	final static ReferenceWithMetaPortfolioStateMeta metaData = new ReferenceWithMetaPortfolioStateMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaPortfolioState> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder builder() {
		return new ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaPortfolioState> getType() {
		return ReferenceWithMetaPortfolioState.class;
	}
	
		default Class<PortfolioState> getValueType() {
			return PortfolioState.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, PortfolioState.class, getValue());
	}
	
	
	interface ReferenceWithMetaPortfolioStateBuilder extends ReferenceWithMetaPortfolioState, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<PortfolioState> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		PortfolioState.PortfolioStateBuilder getOrCreateValue();
		PortfolioState.PortfolioStateBuilder getValue();
		ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setExternalReference(String externalReference);
		ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setReference(Reference reference);
		ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setValue(PortfolioState value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, PortfolioState.PortfolioStateBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateImpl
	class ReferenceWithMetaPortfolioStateImpl implements ReferenceWithMetaPortfolioState {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final PortfolioState value;
		
		protected ReferenceWithMetaPortfolioStateImpl(ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder builder) {
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
		public PortfolioState getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaPortfolioState build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder toBuilder() {
			ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaPortfolioState _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPortfolioState {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilderImpl
	class ReferenceWithMetaPortfolioStateBuilderImpl implements ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected PortfolioState.PortfolioStateBuilder value;
	
		public ReferenceWithMetaPortfolioStateBuilderImpl() {
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
		public PortfolioState.PortfolioStateBuilder getValue() {
			return value;
		}
		
		@Override
		public PortfolioState.PortfolioStateBuilder getOrCreateValue() {
			PortfolioState.PortfolioStateBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = PortfolioState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder setValue(PortfolioState value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaPortfolioState build() {
			return new ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateImpl(this);
		}
		
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder prune() {
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
		public ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder o = (ReferenceWithMetaPortfolioState.ReferenceWithMetaPortfolioStateBuilder) other;
			
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
		
			ReferenceWithMetaPortfolioState _that = getType().cast(o);
		
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
			return "ReferenceWithMetaPortfolioStateBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaPortfolioStateMeta extends BasicRosettaMetaData<ReferenceWithMetaPortfolioState>{

}
