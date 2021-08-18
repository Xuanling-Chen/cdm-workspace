package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.DocumentationIdentificationMeta;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder;
import cdm.legalagreement.contract.BrokerConfirmation;
import cdm.legalagreement.csa.CreditSupportAgreement;
import cdm.legalagreement.master.MasterAgreement;
import cdm.legalagreement.master.MasterConfirmation;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class for defining the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
 * @version ${project.version}
 */
@RosettaClass

public interface DocumentationIdentification extends RosettaModelObject {
	DocumentationIdentification build();
	DocumentationIdentification.DocumentationIdentificationBuilder toBuilder();
	
	/**
	 * A human readable document related to this transaction, for example a confirmation.
	 */
	List<? extends Resource> getAttachment();
	/**
	 * Specifies the details for a broker confirm.
	 */
	BrokerConfirmation getBrokerConfirmation();
	/**
	 * The definitions such as those published by ISDA that will define the terms of the trade.
	 */
	List<? extends FieldWithMetaContractualDefinitionsEnum> getContractualDefinitions();
	/**
	 * A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
	 */
	List<? extends ContractualMatrix> getContractualMatrix();
	/**
	 * A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();
	/**
	 * The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
	 */
	CreditSupportAgreement getCreditSupportAgreement();
	/**
	 * The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 */
	MasterAgreement getMasterAgreement();
	/**
	 */
	MasterConfirmation getMasterConfirmation();
	/**
	 * Any other agreement executed between the parties.
	 */
	List<? extends OtherAgreement> getOtherAgreement();
	final static DocumentationIdentificationMeta metaData = new DocumentationIdentificationMeta();
	
	@Override
	default RosettaMetaData<? extends DocumentationIdentification> metaData() {
		return metaData;
	} 
			
	static DocumentationIdentification.DocumentationIdentificationBuilder builder() {
		return new DocumentationIdentification.DocumentationIdentificationBuilderImpl();
	}
	
	default Class<? extends DocumentationIdentification> getType() {
		return DocumentationIdentification.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("attachment"), processor, Resource.class, getAttachment());
		processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.class, getBrokerConfirmation());
		processRosetta(path.newSubPath("contractualDefinitions"), processor, FieldWithMetaContractualDefinitionsEnum.class, getContractualDefinitions());
		processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.class, getContractualMatrix());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
		processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.class, getCreditSupportAgreement());
		processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.class, getMasterAgreement());
		processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.class, getMasterConfirmation());
		processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.class, getOtherAgreement());
	}
	
	
	interface DocumentationIdentificationBuilder extends DocumentationIdentification, RosettaModelObjectBuilder {
		Resource.ResourceBuilder getOrCreateAttachment(int _index);
		List<? extends Resource.ResourceBuilder> getAttachment();
		BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation();
		BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation();
		FieldWithMetaContractualDefinitionsEnumBuilder getOrCreateContractualDefinitions(int _index);
		List<? extends FieldWithMetaContractualDefinitionsEnumBuilder> getContractualDefinitions();
		ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index);
		List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index);
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement();
		CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement();
		MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement();
		MasterAgreement.MasterAgreementBuilder getMasterAgreement();
		MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation();
		MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation();
		OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int _index);
		List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement();
		DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(Resource attachment);
		DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(Resource attachment, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(List<? extends Resource> attachment);
		DocumentationIdentification.DocumentationIdentificationBuilder setAttachment(List<? extends Resource> attachment);
		DocumentationIdentification.DocumentationIdentificationBuilder setBrokerConfirmation(BrokerConfirmation brokerConfirmation);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(FieldWithMetaContractualDefinitionsEnum contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(FieldWithMetaContractualDefinitionsEnum contractualDefinitions, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(ContractualDefinitionsEnum contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(ContractualDefinitionsEnum contractualDefinitions, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder setContractualDefinitions(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(List<? extends ContractualDefinitionsEnum> contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder setContractualDefinitionsValue(List<? extends ContractualDefinitionsEnum> contractualDefinitions);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(ContractualMatrix contractualMatrix);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(ContractualMatrix contractualMatrix, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		DocumentationIdentification.DocumentationIdentificationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		DocumentationIdentification.DocumentationIdentificationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		DocumentationIdentification.DocumentationIdentificationBuilder setCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement);
		DocumentationIdentification.DocumentationIdentificationBuilder setMasterAgreement(MasterAgreement masterAgreement);
		DocumentationIdentification.DocumentationIdentificationBuilder setMasterConfirmation(MasterConfirmation masterConfirmation);
		DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(OtherAgreement otherAgreement);
		DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(OtherAgreement otherAgreement, int _idx);
		DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreement);
		DocumentationIdentification.DocumentationIdentificationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("attachment"), processor, Resource.ResourceBuilder.class, getAttachment());
			processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.BrokerConfirmationBuilder.class, getBrokerConfirmation());
			processRosetta(path.newSubPath("contractualDefinitions"), processor, FieldWithMetaContractualDefinitionsEnumBuilder.class, getContractualDefinitions());
			processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.ContractualMatrixBuilder.class, getContractualMatrix());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
			processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.CreditSupportAgreementBuilder.class, getCreditSupportAgreement());
			processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.MasterAgreementBuilder.class, getMasterAgreement());
			processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.MasterConfirmationBuilder.class, getMasterConfirmation());
			processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.OtherAgreementBuilder.class, getOtherAgreement());
		}
		
	}
	
	//DocumentationIdentification.DocumentationIdentificationImpl
	class DocumentationIdentificationImpl implements DocumentationIdentification {
		private final List<? extends Resource> attachment;
		private final BrokerConfirmation brokerConfirmation;
		private final List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitions;
		private final List<? extends ContractualMatrix> contractualMatrix;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		private final CreditSupportAgreement creditSupportAgreement;
		private final MasterAgreement masterAgreement;
		private final MasterConfirmation masterConfirmation;
		private final List<? extends OtherAgreement> otherAgreement;
		
		protected DocumentationIdentificationImpl(DocumentationIdentification.DocumentationIdentificationBuilder builder) {
			this.attachment = ofNullable(builder.getAttachment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.brokerConfirmation = ofNullable(builder.getBrokerConfirmation()).map(f->f.build()).orElse(null);
			this.contractualDefinitions = ofNullable(builder.getContractualDefinitions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualMatrix = ofNullable(builder.getContractualMatrix()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportAgreement = ofNullable(builder.getCreditSupportAgreement()).map(f->f.build()).orElse(null);
			this.masterAgreement = ofNullable(builder.getMasterAgreement()).map(f->f.build()).orElse(null);
			this.masterConfirmation = ofNullable(builder.getMasterConfirmation()).map(f->f.build()).orElse(null);
			this.otherAgreement = ofNullable(builder.getOtherAgreement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Resource> getAttachment() {
			return attachment;
		}
		
		@Override
		public BrokerConfirmation getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		public List<? extends FieldWithMetaContractualDefinitionsEnum> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		public List<? extends ContractualMatrix> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public CreditSupportAgreement getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		public MasterAgreement getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		public MasterConfirmation getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		public List<? extends OtherAgreement> getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		public DocumentationIdentification build() {
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder toBuilder() {
			DocumentationIdentification.DocumentationIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DocumentationIdentification.DocumentationIdentificationBuilder builder) {
			ofNullable(getAttachment()).ifPresent(builder::setAttachment);
			ofNullable(getBrokerConfirmation()).ifPresent(builder::setBrokerConfirmation);
			ofNullable(getContractualDefinitions()).ifPresent(builder::setContractualDefinitions);
			ofNullable(getContractualMatrix()).ifPresent(builder::setContractualMatrix);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
			ofNullable(getCreditSupportAgreement()).ifPresent(builder::setCreditSupportAgreement);
			ofNullable(getMasterAgreement()).ifPresent(builder::setMasterAgreement);
			ofNullable(getMasterConfirmation()).ifPresent(builder::setMasterConfirmation);
			ofNullable(getOtherAgreement()).ifPresent(builder::setOtherAgreement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DocumentationIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentationIdentification {" +
				"attachment=" + this.attachment + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"otherAgreement=" + this.otherAgreement +
			'}';
		}
	}
	
	//DocumentationIdentification.DocumentationIdentificationBuilderImpl
	class DocumentationIdentificationBuilderImpl implements DocumentationIdentification.DocumentationIdentificationBuilder {
	
		protected List<Resource.ResourceBuilder> attachment = new ArrayList<>();
		protected BrokerConfirmation.BrokerConfirmationBuilder brokerConfirmation;
		protected List<FieldWithMetaContractualDefinitionsEnumBuilder> contractualDefinitions = new ArrayList<>();
		protected List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrix = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
		protected CreditSupportAgreement.CreditSupportAgreementBuilder creditSupportAgreement;
		protected MasterAgreement.MasterAgreementBuilder masterAgreement;
		protected MasterConfirmation.MasterConfirmationBuilder masterConfirmation;
		protected List<OtherAgreement.OtherAgreementBuilder> otherAgreement = new ArrayList<>();
	
		public DocumentationIdentificationBuilderImpl() {
		}
	
		@Override
		public List<? extends Resource.ResourceBuilder> getAttachment() {
			return attachment;
		}
		
		public Resource.ResourceBuilder getOrCreateAttachment(int _index) {
		
			if (attachment==null) {
				this.attachment = new ArrayList<>();
			}
			Resource.ResourceBuilder result;
			return getIndex(attachment, _index, () -> {
						Resource.ResourceBuilder newAttachment = Resource.builder();
						return newAttachment;
					});
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation() {
			BrokerConfirmation.BrokerConfirmationBuilder result;
			if (brokerConfirmation!=null) {
				result = brokerConfirmation;
			}
			else {
				result = brokerConfirmation = BrokerConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaContractualDefinitionsEnumBuilder> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		public FieldWithMetaContractualDefinitionsEnumBuilder getOrCreateContractualDefinitions(int _index) {
		
			if (contractualDefinitions==null) {
				this.contractualDefinitions = new ArrayList<>();
			}
			FieldWithMetaContractualDefinitionsEnumBuilder result;
			return getIndex(contractualDefinitions, _index, () -> {
						FieldWithMetaContractualDefinitionsEnumBuilder newContractualDefinitions = FieldWithMetaContractualDefinitionsEnum.builder();
						return newContractualDefinitions;
					});
		}
		
		@Override
		public List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix() {
			return contractualMatrix;
		}
		
		public ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index) {
		
			if (contractualMatrix==null) {
				this.contractualMatrix = new ArrayList<>();
			}
			ContractualMatrix.ContractualMatrixBuilder result;
			return getIndex(contractualMatrix, _index, () -> {
						ContractualMatrix.ContractualMatrixBuilder newContractualMatrix = ContractualMatrix.builder();
						return newContractualMatrix;
					});
		}
		
		@Override
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index) {
		
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			ContractualTermsSupplement.ContractualTermsSupplementBuilder result;
			return getIndex(contractualTermsSupplement, _index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement() {
			CreditSupportAgreement.CreditSupportAgreementBuilder result;
			if (creditSupportAgreement!=null) {
				result = creditSupportAgreement;
			}
			else {
				result = creditSupportAgreement = CreditSupportAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement() {
			MasterAgreement.MasterAgreementBuilder result;
			if (masterAgreement!=null) {
				result = masterAgreement;
			}
			else {
				result = masterAgreement = MasterAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation() {
			MasterConfirmation.MasterConfirmationBuilder result;
			if (masterConfirmation!=null) {
				result = masterConfirmation;
			}
			else {
				result = masterConfirmation = MasterConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement() {
			return otherAgreement;
		}
		
		public OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int _index) {
		
			if (otherAgreement==null) {
				this.otherAgreement = new ArrayList<>();
			}
			OtherAgreement.OtherAgreementBuilder result;
			return getIndex(otherAgreement, _index, () -> {
						OtherAgreement.OtherAgreementBuilder newOtherAgreement = OtherAgreement.builder();
						return newOtherAgreement;
					});
		}
		
	
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(Resource attachment) {
			if (attachment!=null) this.attachment.add(attachment.toBuilder());
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(Resource attachment, int _idx) {
			getIndex(this.attachment, _idx, () -> attachment.toBuilder());
			return this;
		}
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder addAttachment(List<? extends Resource> attachments) {
			if (attachments != null) {
				for (Resource toAdd : attachments) {
					this.attachment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder setAttachment(List<? extends Resource> attachments) {
			if (attachments == null)  {
				this.attachment = new ArrayList<>();
			}
			else {
				this.attachment = attachments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder setBrokerConfirmation(BrokerConfirmation brokerConfirmation) {
			this.brokerConfirmation = brokerConfirmation==null?null:brokerConfirmation.toBuilder();
			return this;
		}
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(FieldWithMetaContractualDefinitionsEnum contractualDefinitions) {
			if (contractualDefinitions!=null) this.contractualDefinitions.add(contractualDefinitions.toBuilder());
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(FieldWithMetaContractualDefinitionsEnum contractualDefinitions, int _idx) {
			getIndex(this.contractualDefinitions, _idx, () -> contractualDefinitions.toBuilder());
			return this;
		}
		
			@Override
			public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(ContractualDefinitionsEnum contractualDefinitions) {
				this.getOrCreateContractualDefinitions(-1).setValue(contractualDefinitions);
				return this;
			}
			
			@Override
			public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(ContractualDefinitionsEnum contractualDefinitions, int _idx) {
				this.getOrCreateContractualDefinitions(_idx).setValue(contractualDefinitions);
				return this;
			}
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitions(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (FieldWithMetaContractualDefinitionsEnum toAdd : contractualDefinitionss) {
					this.contractualDefinitions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder setContractualDefinitions(List<? extends FieldWithMetaContractualDefinitionsEnum> contractualDefinitionss) {
			if (contractualDefinitionss == null)  {
				this.contractualDefinitions = new ArrayList<>();
			}
			else {
				this.contractualDefinitions = contractualDefinitionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualDefinitionsValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (ContractualDefinitionsEnum toAdd : contractualDefinitionss) {
					this.addContractualDefinitionsValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder setContractualDefinitionsValue(List<? extends ContractualDefinitionsEnum> contractualDefinitionss) {
			this.contractualDefinitions.clear();
			if (contractualDefinitionss!=null) {
				contractualDefinitionss.forEach(this::addContractualDefinitionsValue);
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(ContractualMatrix contractualMatrix) {
			if (contractualMatrix!=null) this.contractualMatrix.add(contractualMatrix.toBuilder());
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(ContractualMatrix contractualMatrix, int _idx) {
			getIndex(this.contractualMatrix, _idx, () -> contractualMatrix.toBuilder());
			return this;
		}
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs != null) {
				for (ContractualMatrix toAdd : contractualMatrixs) {
					this.contractualMatrix.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs == null)  {
				this.contractualMatrix = new ArrayList<>();
			}
			else {
				this.contractualMatrix = contractualMatrixs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement) {
			if (contractualTermsSupplement!=null) this.contractualTermsSupplement.add(contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int _idx) {
			getIndex(this.contractualTermsSupplement, _idx, () -> contractualTermsSupplement.toBuilder());
			return this;
		}
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null)  {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder setCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement) {
			this.creditSupportAgreement = creditSupportAgreement==null?null:creditSupportAgreement.toBuilder();
			return this;
		}
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder setMasterAgreement(MasterAgreement masterAgreement) {
			this.masterAgreement = masterAgreement==null?null:masterAgreement.toBuilder();
			return this;
		}
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder setMasterConfirmation(MasterConfirmation masterConfirmation) {
			this.masterConfirmation = masterConfirmation==null?null:masterConfirmation.toBuilder();
			return this;
		}
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(OtherAgreement otherAgreement) {
			if (otherAgreement!=null) this.otherAgreement.add(otherAgreement.toBuilder());
			return this;
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(OtherAgreement otherAgreement, int _idx) {
			getIndex(this.otherAgreement, _idx, () -> otherAgreement.toBuilder());
			return this;
		}
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements != null) {
				for (OtherAgreement toAdd : otherAgreements) {
					this.otherAgreement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DocumentationIdentification.DocumentationIdentificationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements == null)  {
				this.otherAgreement = new ArrayList<>();
			}
			else {
				this.otherAgreement = otherAgreements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DocumentationIdentification build() {
			return new DocumentationIdentification.DocumentationIdentificationImpl(this);
		}
		
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder prune() {
			attachment = attachment.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (brokerConfirmation!=null && !brokerConfirmation.prune().hasData()) brokerConfirmation = null;
			contractualDefinitions = contractualDefinitions.stream().filter(b->b!=null).<FieldWithMetaContractualDefinitionsEnumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualMatrix = contractualMatrix.stream().filter(b->b!=null).<ContractualMatrix.ContractualMatrixBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditSupportAgreement!=null && !creditSupportAgreement.prune().hasData()) creditSupportAgreement = null;
			if (masterAgreement!=null && !masterAgreement.prune().hasData()) masterAgreement = null;
			if (masterConfirmation!=null && !masterConfirmation.prune().hasData()) masterConfirmation = null;
			otherAgreement = otherAgreement.stream().filter(b->b!=null).<OtherAgreement.OtherAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAttachment()!=null && getAttachment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBrokerConfirmation()!=null && getBrokerConfirmation().hasData()) return true;
			if (getContractualDefinitions()!=null && !getContractualDefinitions().isEmpty()) return true;
			if (getContractualMatrix()!=null && getContractualMatrix().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportAgreement()!=null && getCreditSupportAgreement().hasData()) return true;
			if (getMasterAgreement()!=null && getMasterAgreement().hasData()) return true;
			if (getMasterConfirmation()!=null && getMasterConfirmation().hasData()) return true;
			if (getOtherAgreement()!=null && getOtherAgreement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DocumentationIdentification.DocumentationIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DocumentationIdentification.DocumentationIdentificationBuilder o = (DocumentationIdentification.DocumentationIdentificationBuilder) other;
			
			merger.mergeRosetta(getAttachment(), o.getAttachment(), this::getOrCreateAttachment);
			merger.mergeRosetta(getBrokerConfirmation(), o.getBrokerConfirmation(), this::setBrokerConfirmation);
			merger.mergeRosetta(getContractualDefinitions(), o.getContractualDefinitions(), this::getOrCreateContractualDefinitions);
			merger.mergeRosetta(getContractualMatrix(), o.getContractualMatrix(), this::getOrCreateContractualMatrix);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			merger.mergeRosetta(getCreditSupportAgreement(), o.getCreditSupportAgreement(), this::setCreditSupportAgreement);
			merger.mergeRosetta(getMasterAgreement(), o.getMasterAgreement(), this::setMasterAgreement);
			merger.mergeRosetta(getMasterConfirmation(), o.getMasterConfirmation(), this::setMasterConfirmation);
			merger.mergeRosetta(getOtherAgreement(), o.getOtherAgreement(), this::getOrCreateOtherAgreement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DocumentationIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentationIdentificationBuilder {" +
				"attachment=" + this.attachment + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"otherAgreement=" + this.otherAgreement +
			'}';
		}
	}
}
