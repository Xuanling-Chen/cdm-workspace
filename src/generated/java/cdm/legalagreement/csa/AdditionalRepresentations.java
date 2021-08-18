package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AdditionalRepresentationsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Additional Representations that may be applicable to an agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalRepresentations extends RosettaModelObject {
	AdditionalRepresentations build();
	AdditionalRepresentations.AdditionalRepresentationsBuilder toBuilder();
	
	/**
	 * The specification of the Additional Representation that may be applicable to the agreement.
	 */
	AdditionalRepresentation getAdditionalRepresentation();
	/**
	 * The qualification of whether Additional Information related to Regulatory Compliance and Concentration Limits is applicable or not.
	 */
	Boolean getRegulatoryComplianceRepresentation();
	final static AdditionalRepresentationsMeta metaData = new AdditionalRepresentationsMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalRepresentations> metaData() {
		return metaData;
	} 
			
	static AdditionalRepresentations.AdditionalRepresentationsBuilder builder() {
		return new AdditionalRepresentations.AdditionalRepresentationsBuilderImpl();
	}
	
	default Class<? extends AdditionalRepresentations> getType() {
		return AdditionalRepresentations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("regulatoryComplianceRepresentation"), Boolean.class, getRegulatoryComplianceRepresentation(), this);
		
		processRosetta(path.newSubPath("additionalRepresentation"), processor, AdditionalRepresentation.class, getAdditionalRepresentation());
	}
	
	
	interface AdditionalRepresentationsBuilder extends AdditionalRepresentations, RosettaModelObjectBuilder {
		AdditionalRepresentation.AdditionalRepresentationBuilder getOrCreateAdditionalRepresentation();
		AdditionalRepresentation.AdditionalRepresentationBuilder getAdditionalRepresentation();
		AdditionalRepresentations.AdditionalRepresentationsBuilder setAdditionalRepresentation(AdditionalRepresentation additionalRepresentation);
		AdditionalRepresentations.AdditionalRepresentationsBuilder setRegulatoryComplianceRepresentation(Boolean regulatoryComplianceRepresentation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("regulatoryComplianceRepresentation"), Boolean.class, getRegulatoryComplianceRepresentation(), this);
			
			processRosetta(path.newSubPath("additionalRepresentation"), processor, AdditionalRepresentation.AdditionalRepresentationBuilder.class, getAdditionalRepresentation());
		}
		
	}
	
	//AdditionalRepresentations.AdditionalRepresentationsImpl
	class AdditionalRepresentationsImpl implements AdditionalRepresentations {
		private final AdditionalRepresentation additionalRepresentation;
		private final Boolean regulatoryComplianceRepresentation;
		
		protected AdditionalRepresentationsImpl(AdditionalRepresentations.AdditionalRepresentationsBuilder builder) {
			this.additionalRepresentation = ofNullable(builder.getAdditionalRepresentation()).map(f->f.build()).orElse(null);
			this.regulatoryComplianceRepresentation = builder.getRegulatoryComplianceRepresentation();
		}
		
		@Override
		public AdditionalRepresentation getAdditionalRepresentation() {
			return additionalRepresentation;
		}
		
		@Override
		public Boolean getRegulatoryComplianceRepresentation() {
			return regulatoryComplianceRepresentation;
		}
		
		@Override
		public AdditionalRepresentations build() {
			return this;
		}
		
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder toBuilder() {
			AdditionalRepresentations.AdditionalRepresentationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRepresentations.AdditionalRepresentationsBuilder builder) {
			ofNullable(getAdditionalRepresentation()).ifPresent(builder::setAdditionalRepresentation);
			ofNullable(getRegulatoryComplianceRepresentation()).ifPresent(builder::setRegulatoryComplianceRepresentation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentations _that = getType().cast(o);
		
			if (!Objects.equals(additionalRepresentation, _that.getAdditionalRepresentation())) return false;
			if (!Objects.equals(regulatoryComplianceRepresentation, _that.getRegulatoryComplianceRepresentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRepresentation != null ? additionalRepresentation.hashCode() : 0);
			_result = 31 * _result + (regulatoryComplianceRepresentation != null ? regulatoryComplianceRepresentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentations {" +
				"additionalRepresentation=" + this.additionalRepresentation + ", " +
				"regulatoryComplianceRepresentation=" + this.regulatoryComplianceRepresentation +
			'}';
		}
	}
	
	//AdditionalRepresentations.AdditionalRepresentationsBuilderImpl
	class AdditionalRepresentationsBuilderImpl implements AdditionalRepresentations.AdditionalRepresentationsBuilder {
	
		protected AdditionalRepresentation.AdditionalRepresentationBuilder additionalRepresentation;
		protected Boolean regulatoryComplianceRepresentation;
	
		public AdditionalRepresentationsBuilderImpl() {
		}
	
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder getAdditionalRepresentation() {
			return additionalRepresentation;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder getOrCreateAdditionalRepresentation() {
			AdditionalRepresentation.AdditionalRepresentationBuilder result;
			if (additionalRepresentation!=null) {
				result = additionalRepresentation;
			}
			else {
				result = additionalRepresentation = AdditionalRepresentation.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getRegulatoryComplianceRepresentation() {
			return regulatoryComplianceRepresentation;
		}
		
	
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder setAdditionalRepresentation(AdditionalRepresentation additionalRepresentation) {
			this.additionalRepresentation = additionalRepresentation==null?null:additionalRepresentation.toBuilder();
			return this;
		}
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder setRegulatoryComplianceRepresentation(Boolean regulatoryComplianceRepresentation) {
			this.regulatoryComplianceRepresentation = regulatoryComplianceRepresentation==null?null:regulatoryComplianceRepresentation;
			return this;
		}
		
		@Override
		public AdditionalRepresentations build() {
			return new AdditionalRepresentations.AdditionalRepresentationsImpl(this);
		}
		
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder prune() {
			if (additionalRepresentation!=null && !additionalRepresentation.prune().hasData()) additionalRepresentation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalRepresentation()!=null && getAdditionalRepresentation().hasData()) return true;
			if (getRegulatoryComplianceRepresentation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRepresentations.AdditionalRepresentationsBuilder o = (AdditionalRepresentations.AdditionalRepresentationsBuilder) other;
			
			merger.mergeRosetta(getAdditionalRepresentation(), o.getAdditionalRepresentation(), this::setAdditionalRepresentation);
			
			merger.mergeBasic(getRegulatoryComplianceRepresentation(), o.getRegulatoryComplianceRepresentation(), this::setRegulatoryComplianceRepresentation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentations _that = getType().cast(o);
		
			if (!Objects.equals(additionalRepresentation, _that.getAdditionalRepresentation())) return false;
			if (!Objects.equals(regulatoryComplianceRepresentation, _that.getRegulatoryComplianceRepresentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRepresentation != null ? additionalRepresentation.hashCode() : 0);
			_result = 31 * _result + (regulatoryComplianceRepresentation != null ? regulatoryComplianceRepresentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentationsBuilder {" +
				"additionalRepresentation=" + this.additionalRepresentation + ", " +
				"regulatoryComplianceRepresentation=" + this.regulatoryComplianceRepresentation +
			'}';
		}
	}
}
