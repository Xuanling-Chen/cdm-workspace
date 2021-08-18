package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.RelatedAgreementMeta;
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
 * A class for specifying the legal agreements that govern the contract, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those documents, such as the type of document, the document identifier, the publisher, the document vintage and the agreement date.
 * @version ${project.version}
 */
@RosettaClass

public interface RelatedAgreement extends RosettaModelObject {
	RelatedAgreement build();
	RelatedAgreement.RelatedAgreementBuilder toBuilder();
	
	/**
	 * The identification of the legal document(s) that govern the contract through some of the key terms of such document(s): type of document, the document identifier, the publisher, the document vintage and the agreement date.
	 */
	DocumentationIdentification getDocumentationIdentification();
	/**
	 * The legal agreement(s) that govern the contract, when such agreement is specified as a reference part of the CDM.
	 */
	LegalAgreement getLegalAgreement();
	final static RelatedAgreementMeta metaData = new RelatedAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends RelatedAgreement> metaData() {
		return metaData;
	} 
			
	static RelatedAgreement.RelatedAgreementBuilder builder() {
		return new RelatedAgreement.RelatedAgreementBuilderImpl();
	}
	
	default Class<? extends RelatedAgreement> getType() {
		return RelatedAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("documentationIdentification"), processor, DocumentationIdentification.class, getDocumentationIdentification());
		processRosetta(path.newSubPath("legalAgreement"), processor, LegalAgreement.class, getLegalAgreement());
	}
	
	
	interface RelatedAgreementBuilder extends RelatedAgreement, RosettaModelObjectBuilder {
		DocumentationIdentification.DocumentationIdentificationBuilder getOrCreateDocumentationIdentification();
		DocumentationIdentification.DocumentationIdentificationBuilder getDocumentationIdentification();
		LegalAgreement.LegalAgreementBuilder getOrCreateLegalAgreement();
		LegalAgreement.LegalAgreementBuilder getLegalAgreement();
		RelatedAgreement.RelatedAgreementBuilder setDocumentationIdentification(DocumentationIdentification documentationIdentification);
		RelatedAgreement.RelatedAgreementBuilder setLegalAgreement(LegalAgreement legalAgreement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("documentationIdentification"), processor, DocumentationIdentification.DocumentationIdentificationBuilder.class, getDocumentationIdentification());
			processRosetta(path.newSubPath("legalAgreement"), processor, LegalAgreement.LegalAgreementBuilder.class, getLegalAgreement());
		}
		
	}
	
	//RelatedAgreement.RelatedAgreementImpl
	class RelatedAgreementImpl implements RelatedAgreement {
		private final DocumentationIdentification documentationIdentification;
		private final LegalAgreement legalAgreement;
		
		protected RelatedAgreementImpl(RelatedAgreement.RelatedAgreementBuilder builder) {
			this.documentationIdentification = ofNullable(builder.getDocumentationIdentification()).map(f->f.build()).orElse(null);
			this.legalAgreement = ofNullable(builder.getLegalAgreement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DocumentationIdentification getDocumentationIdentification() {
			return documentationIdentification;
		}
		
		@Override
		public LegalAgreement getLegalAgreement() {
			return legalAgreement;
		}
		
		@Override
		public RelatedAgreement build() {
			return this;
		}
		
		@Override
		public RelatedAgreement.RelatedAgreementBuilder toBuilder() {
			RelatedAgreement.RelatedAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelatedAgreement.RelatedAgreementBuilder builder) {
			ofNullable(getDocumentationIdentification()).ifPresent(builder::setDocumentationIdentification);
			ofNullable(getLegalAgreement()).ifPresent(builder::setLegalAgreement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedAgreement _that = getType().cast(o);
		
			if (!Objects.equals(documentationIdentification, _that.getDocumentationIdentification())) return false;
			if (!Objects.equals(legalAgreement, _that.getLegalAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentationIdentification != null ? documentationIdentification.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedAgreement {" +
				"documentationIdentification=" + this.documentationIdentification + ", " +
				"legalAgreement=" + this.legalAgreement +
			'}';
		}
	}
	
	//RelatedAgreement.RelatedAgreementBuilderImpl
	class RelatedAgreementBuilderImpl implements RelatedAgreement.RelatedAgreementBuilder {
	
		protected DocumentationIdentification.DocumentationIdentificationBuilder documentationIdentification;
		protected LegalAgreement.LegalAgreementBuilder legalAgreement;
	
		public RelatedAgreementBuilderImpl() {
		}
	
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder getDocumentationIdentification() {
			return documentationIdentification;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder getOrCreateDocumentationIdentification() {
			DocumentationIdentification.DocumentationIdentificationBuilder result;
			if (documentationIdentification!=null) {
				result = documentationIdentification;
			}
			else {
				result = documentationIdentification = DocumentationIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder getLegalAgreement() {
			return legalAgreement;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder getOrCreateLegalAgreement() {
			LegalAgreement.LegalAgreementBuilder result;
			if (legalAgreement!=null) {
				result = legalAgreement;
			}
			else {
				result = legalAgreement = LegalAgreement.builder();
			}
			
			return result;
		}
		
	
		@Override
		public RelatedAgreement.RelatedAgreementBuilder setDocumentationIdentification(DocumentationIdentification documentationIdentification) {
			this.documentationIdentification = documentationIdentification==null?null:documentationIdentification.toBuilder();
			return this;
		}
		@Override
		public RelatedAgreement.RelatedAgreementBuilder setLegalAgreement(LegalAgreement legalAgreement) {
			this.legalAgreement = legalAgreement==null?null:legalAgreement.toBuilder();
			return this;
		}
		
		@Override
		public RelatedAgreement build() {
			return new RelatedAgreement.RelatedAgreementImpl(this);
		}
		
		@Override
		public RelatedAgreement.RelatedAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedAgreement.RelatedAgreementBuilder prune() {
			if (documentationIdentification!=null && !documentationIdentification.prune().hasData()) documentationIdentification = null;
			if (legalAgreement!=null && !legalAgreement.prune().hasData()) legalAgreement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDocumentationIdentification()!=null && getDocumentationIdentification().hasData()) return true;
			if (getLegalAgreement()!=null && getLegalAgreement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelatedAgreement.RelatedAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelatedAgreement.RelatedAgreementBuilder o = (RelatedAgreement.RelatedAgreementBuilder) other;
			
			merger.mergeRosetta(getDocumentationIdentification(), o.getDocumentationIdentification(), this::setDocumentationIdentification);
			merger.mergeRosetta(getLegalAgreement(), o.getLegalAgreement(), this::setLegalAgreement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelatedAgreement _that = getType().cast(o);
		
			if (!Objects.equals(documentationIdentification, _that.getDocumentationIdentification())) return false;
			if (!Objects.equals(legalAgreement, _that.getLegalAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (documentationIdentification != null ? documentationIdentification.hashCode() : 0);
			_result = 31 * _result + (legalAgreement != null ? legalAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelatedAgreementBuilder {" +
				"documentationIdentification=" + this.documentationIdentification + ", " +
				"legalAgreement=" + this.legalAgreement +
			'}';
		}
	}
}
