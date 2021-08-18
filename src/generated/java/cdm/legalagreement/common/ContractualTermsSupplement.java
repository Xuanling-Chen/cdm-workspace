package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.ContractualTermsSupplementMeta;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractualTermsSupplement extends RosettaModelObject {
	ContractualTermsSupplement build();
	ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder();
	
	/**
	 * Identifies the form of applicable contractual supplement.
	 */
	FieldWithMetaContractualSupplementEnum getContractualTermsSupplementType();
	/**
	 * Specifies the publication date of the applicable version of the contractual supplement.
	 */
	Date getPublicationDate();
	final static ContractualTermsSupplementMeta metaData = new ContractualTermsSupplementMeta();
	
	@Override
	default RosettaMetaData<? extends ContractualTermsSupplement> metaData() {
		return metaData;
	} 
			
	static ContractualTermsSupplement.ContractualTermsSupplementBuilder builder() {
		return new ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl();
	}
	
	default Class<? extends ContractualTermsSupplement> getType() {
		return ContractualTermsSupplement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		
		processRosetta(path.newSubPath("contractualTermsSupplementType"), processor, FieldWithMetaContractualSupplementEnum.class, getContractualTermsSupplementType());
	}
	
	
	interface ContractualTermsSupplementBuilder extends ContractualTermsSupplement, RosettaModelObjectBuilder {
		FieldWithMetaContractualSupplementEnumBuilder getOrCreateContractualTermsSupplementType();
		FieldWithMetaContractualSupplementEnumBuilder getContractualTermsSupplementType();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setContractualTermsSupplementType(FieldWithMetaContractualSupplementEnum contractualTermsSupplementType);
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setContractualTermsSupplementTypeValue(ContractualSupplementEnum contractualTermsSupplementType);
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(Date publicationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
			
			processRosetta(path.newSubPath("contractualTermsSupplementType"), processor, FieldWithMetaContractualSupplementEnumBuilder.class, getContractualTermsSupplementType());
		}
		
	}
	
	//ContractualTermsSupplement.ContractualTermsSupplementImpl
	class ContractualTermsSupplementImpl implements ContractualTermsSupplement {
		private final FieldWithMetaContractualSupplementEnum contractualTermsSupplementType;
		private final Date publicationDate;
		
		protected ContractualTermsSupplementImpl(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			this.contractualTermsSupplementType = ofNullable(builder.getContractualTermsSupplementType()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnum getContractualTermsSupplementType() {
			return contractualTermsSupplementType;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return this;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			ofNullable(getContractualTermsSupplementType()).ifPresent(builder::setContractualTermsSupplementType);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(contractualTermsSupplementType, _that.getContractualTermsSupplementType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractualTermsSupplementType != null ? contractualTermsSupplementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplement {" +
				"contractualTermsSupplementType=" + this.contractualTermsSupplementType + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
	
	//ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl
	class ContractualTermsSupplementBuilderImpl implements ContractualTermsSupplement.ContractualTermsSupplementBuilder {
	
		protected FieldWithMetaContractualSupplementEnumBuilder contractualTermsSupplementType;
		protected Date publicationDate;
	
		public ContractualTermsSupplementBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaContractualSupplementEnumBuilder getContractualTermsSupplementType() {
			return contractualTermsSupplementType;
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnumBuilder getOrCreateContractualTermsSupplementType() {
			FieldWithMetaContractualSupplementEnumBuilder result;
			if (contractualTermsSupplementType!=null) {
				result = contractualTermsSupplementType;
			}
			else {
				result = contractualTermsSupplementType = FieldWithMetaContractualSupplementEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
	
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setContractualTermsSupplementType(FieldWithMetaContractualSupplementEnum contractualTermsSupplementType) {
			this.contractualTermsSupplementType = contractualTermsSupplementType==null?null:contractualTermsSupplementType.toBuilder();
			return this;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setContractualTermsSupplementTypeValue(ContractualSupplementEnum contractualTermsSupplementType) {
			this.getOrCreateContractualTermsSupplementType().setValue(contractualTermsSupplementType);
			return this;
		}
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate==null?null:publicationDate;
			return this;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return new ContractualTermsSupplement.ContractualTermsSupplementImpl(this);
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder prune() {
			if (contractualTermsSupplementType!=null && !contractualTermsSupplementType.prune().hasData()) contractualTermsSupplementType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractualTermsSupplementType()!=null) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder o = (ContractualTermsSupplement.ContractualTermsSupplementBuilder) other;
			
			merger.mergeRosetta(getContractualTermsSupplementType(), o.getContractualTermsSupplementType(), this::setContractualTermsSupplementType);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(contractualTermsSupplementType, _that.getContractualTermsSupplementType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractualTermsSupplementType != null ? contractualTermsSupplementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplementBuilder {" +
				"contractualTermsSupplementType=" + this.contractualTermsSupplementType + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
