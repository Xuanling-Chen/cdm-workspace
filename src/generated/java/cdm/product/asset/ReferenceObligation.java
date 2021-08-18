package cdm.product.asset;

import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaLegalEntity;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder;
import cdm.product.asset.meta.ReferenceObligationMeta;
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
 * A class to specify the reference obligation that is associated with a credit derivative instrument.
 * @version ${project.version}
 */
@RosettaClass

public interface ReferenceObligation extends RosettaModelObject {
	ReferenceObligation build();
	ReferenceObligation.ReferenceObligationBuilder toBuilder();
	
	/**
	 * The party that guarantees by way of a contractual arrangement to pay the debts of an obligor if the obligor is unable to make the required payments itself. ISDA 2003 Term: Guarantor.
	 */
	LegalEntity getGuarantor();
	/**
	 * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the guarantor.
	 */
	String getGuarantorReference();
	/**
	 * Identifies the underlying asset when it is a loan.
	 */
	Loan getLoan();
	/**
	 * The entity primarily responsible for repaying debt to a creditor as a result of borrowing or issuing bonds. ISDA 2003 Term: Primary Obligor.
	 */
	LegalEntity getPrimaryObligor();
	/**
	 * A pointer style reference to a reference entity defined elsewhere in the document. Used when the reference entity is the primary obligor.
	 */
	ReferenceWithMetaLegalEntity getPrimaryObligorReference();
	/**
	 * Identifies the underlying asset when it is a security, such as a bond or convertible bond. The security data type requires one or more productIdentifiers, specificaiton of the security type (e.g. debt), and includes optional attributes to specify a debt class, such as asset-backed, as well as seniority.
	 */
	Security getSecurity();
	/**
	 * Indicates if the reference obligation is a Standard Reference Obligation. ISDA 2014 Term: Standard Reference Obligation.
	 */
	Boolean getStandardReferenceObligation();
	final static ReferenceObligationMeta metaData = new ReferenceObligationMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceObligation> metaData() {
		return metaData;
	} 
			
	static ReferenceObligation.ReferenceObligationBuilder builder() {
		return new ReferenceObligation.ReferenceObligationBuilderImpl();
	}
	
	default Class<? extends ReferenceObligation> getType() {
		return ReferenceObligation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("guarantorReference"), String.class, getGuarantorReference(), this);
		processor.processBasic(path.newSubPath("standardReferenceObligation"), Boolean.class, getStandardReferenceObligation(), this);
		
		processRosetta(path.newSubPath("guarantor"), processor, LegalEntity.class, getGuarantor());
		processRosetta(path.newSubPath("loan"), processor, Loan.class, getLoan());
		processRosetta(path.newSubPath("primaryObligor"), processor, LegalEntity.class, getPrimaryObligor());
		processRosetta(path.newSubPath("primaryObligorReference"), processor, ReferenceWithMetaLegalEntity.class, getPrimaryObligorReference());
		processRosetta(path.newSubPath("security"), processor, Security.class, getSecurity());
	}
	
	
	interface ReferenceObligationBuilder extends ReferenceObligation, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateGuarantor();
		LegalEntity.LegalEntityBuilder getGuarantor();
		Loan.LoanBuilder getOrCreateLoan();
		Loan.LoanBuilder getLoan();
		LegalEntity.LegalEntityBuilder getOrCreatePrimaryObligor();
		LegalEntity.LegalEntityBuilder getPrimaryObligor();
		ReferenceWithMetaLegalEntityBuilder getOrCreatePrimaryObligorReference();
		ReferenceWithMetaLegalEntityBuilder getPrimaryObligorReference();
		Security.SecurityBuilder getOrCreateSecurity();
		Security.SecurityBuilder getSecurity();
		ReferenceObligation.ReferenceObligationBuilder setGuarantor(LegalEntity guarantor);
		ReferenceObligation.ReferenceObligationBuilder setGuarantorReference(String guarantorReference);
		ReferenceObligation.ReferenceObligationBuilder setLoan(Loan loan);
		ReferenceObligation.ReferenceObligationBuilder setPrimaryObligor(LegalEntity primaryObligor);
		ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReference(ReferenceWithMetaLegalEntity primaryObligorReference);
		ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReferenceValue(LegalEntity primaryObligorReference);
		ReferenceObligation.ReferenceObligationBuilder setSecurity(Security security);
		ReferenceObligation.ReferenceObligationBuilder setStandardReferenceObligation(Boolean standardReferenceObligation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("guarantorReference"), String.class, getGuarantorReference(), this);
			processor.processBasic(path.newSubPath("standardReferenceObligation"), Boolean.class, getStandardReferenceObligation(), this);
			
			processRosetta(path.newSubPath("guarantor"), processor, LegalEntity.LegalEntityBuilder.class, getGuarantor());
			processRosetta(path.newSubPath("loan"), processor, Loan.LoanBuilder.class, getLoan());
			processRosetta(path.newSubPath("primaryObligor"), processor, LegalEntity.LegalEntityBuilder.class, getPrimaryObligor());
			processRosetta(path.newSubPath("primaryObligorReference"), processor, ReferenceWithMetaLegalEntityBuilder.class, getPrimaryObligorReference());
			processRosetta(path.newSubPath("security"), processor, Security.SecurityBuilder.class, getSecurity());
		}
		
	}
	
	//ReferenceObligation.ReferenceObligationImpl
	class ReferenceObligationImpl implements ReferenceObligation {
		private final LegalEntity guarantor;
		private final String guarantorReference;
		private final Loan loan;
		private final LegalEntity primaryObligor;
		private final ReferenceWithMetaLegalEntity primaryObligorReference;
		private final Security security;
		private final Boolean standardReferenceObligation;
		
		protected ReferenceObligationImpl(ReferenceObligation.ReferenceObligationBuilder builder) {
			this.guarantor = ofNullable(builder.getGuarantor()).map(f->f.build()).orElse(null);
			this.guarantorReference = builder.getGuarantorReference();
			this.loan = ofNullable(builder.getLoan()).map(f->f.build()).orElse(null);
			this.primaryObligor = ofNullable(builder.getPrimaryObligor()).map(f->f.build()).orElse(null);
			this.primaryObligorReference = ofNullable(builder.getPrimaryObligorReference()).map(f->f.build()).orElse(null);
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
			this.standardReferenceObligation = builder.getStandardReferenceObligation();
		}
		
		@Override
		public LegalEntity getGuarantor() {
			return guarantor;
		}
		
		@Override
		public String getGuarantorReference() {
			return guarantorReference;
		}
		
		@Override
		public Loan getLoan() {
			return loan;
		}
		
		@Override
		public LegalEntity getPrimaryObligor() {
			return primaryObligor;
		}
		
		@Override
		public ReferenceWithMetaLegalEntity getPrimaryObligorReference() {
			return primaryObligorReference;
		}
		
		@Override
		public Security getSecurity() {
			return security;
		}
		
		@Override
		public Boolean getStandardReferenceObligation() {
			return standardReferenceObligation;
		}
		
		@Override
		public ReferenceObligation build() {
			return this;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder toBuilder() {
			ReferenceObligation.ReferenceObligationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceObligation.ReferenceObligationBuilder builder) {
			ofNullable(getGuarantor()).ifPresent(builder::setGuarantor);
			ofNullable(getGuarantorReference()).ifPresent(builder::setGuarantorReference);
			ofNullable(getLoan()).ifPresent(builder::setLoan);
			ofNullable(getPrimaryObligor()).ifPresent(builder::setPrimaryObligor);
			ofNullable(getPrimaryObligorReference()).ifPresent(builder::setPrimaryObligorReference);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
			ofNullable(getStandardReferenceObligation()).ifPresent(builder::setStandardReferenceObligation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligation _that = getType().cast(o);
		
			if (!Objects.equals(guarantor, _that.getGuarantor())) return false;
			if (!Objects.equals(guarantorReference, _that.getGuarantorReference())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(primaryObligor, _that.getPrimaryObligor())) return false;
			if (!Objects.equals(primaryObligorReference, _that.getPrimaryObligorReference())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(standardReferenceObligation, _that.getStandardReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (guarantor != null ? guarantor.hashCode() : 0);
			_result = 31 * _result + (guarantorReference != null ? guarantorReference.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (primaryObligor != null ? primaryObligor.hashCode() : 0);
			_result = 31 * _result + (primaryObligorReference != null ? primaryObligorReference.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (standardReferenceObligation != null ? standardReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligation {" +
				"guarantor=" + this.guarantor + ", " +
				"guarantorReference=" + this.guarantorReference + ", " +
				"loan=" + this.loan + ", " +
				"primaryObligor=" + this.primaryObligor + ", " +
				"primaryObligorReference=" + this.primaryObligorReference + ", " +
				"security=" + this.security + ", " +
				"standardReferenceObligation=" + this.standardReferenceObligation +
			'}';
		}
	}
	
	//ReferenceObligation.ReferenceObligationBuilderImpl
	class ReferenceObligationBuilderImpl implements ReferenceObligation.ReferenceObligationBuilder {
	
		protected LegalEntity.LegalEntityBuilder guarantor;
		protected String guarantorReference;
		protected Loan.LoanBuilder loan;
		protected LegalEntity.LegalEntityBuilder primaryObligor;
		protected ReferenceWithMetaLegalEntityBuilder primaryObligorReference;
		protected Security.SecurityBuilder security;
		protected Boolean standardReferenceObligation;
	
		public ReferenceObligationBuilderImpl() {
		}
	
		@Override
		public LegalEntity.LegalEntityBuilder getGuarantor() {
			return guarantor;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateGuarantor() {
			LegalEntity.LegalEntityBuilder result;
			if (guarantor!=null) {
				result = guarantor;
			}
			else {
				result = guarantor = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public String getGuarantorReference() {
			return guarantorReference;
		}
		
		@Override
		public Loan.LoanBuilder getLoan() {
			return loan;
		}
		
		@Override
		public Loan.LoanBuilder getOrCreateLoan() {
			Loan.LoanBuilder result;
			if (loan!=null) {
				result = loan;
			}
			else {
				result = loan = Loan.builder();
			}
			
			return result;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getPrimaryObligor() {
			return primaryObligor;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreatePrimaryObligor() {
			LegalEntity.LegalEntityBuilder result;
			if (primaryObligor!=null) {
				result = primaryObligor;
			}
			else {
				result = primaryObligor = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaLegalEntityBuilder getPrimaryObligorReference() {
			return primaryObligorReference;
		}
		
		@Override
		public ReferenceWithMetaLegalEntityBuilder getOrCreatePrimaryObligorReference() {
			ReferenceWithMetaLegalEntityBuilder result;
			if (primaryObligorReference!=null) {
				result = primaryObligorReference;
			}
			else {
				result = primaryObligorReference = ReferenceWithMetaLegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public Security.SecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public Security.SecurityBuilder getOrCreateSecurity() {
			Security.SecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = Security.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getStandardReferenceObligation() {
			return standardReferenceObligation;
		}
		
	
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setGuarantor(LegalEntity guarantor) {
			this.guarantor = guarantor==null?null:guarantor.toBuilder();
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setGuarantorReference(String guarantorReference) {
			this.guarantorReference = guarantorReference==null?null:guarantorReference;
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setLoan(Loan loan) {
			this.loan = loan==null?null:loan.toBuilder();
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setPrimaryObligor(LegalEntity primaryObligor) {
			this.primaryObligor = primaryObligor==null?null:primaryObligor.toBuilder();
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReference(ReferenceWithMetaLegalEntity primaryObligorReference) {
			this.primaryObligorReference = primaryObligorReference==null?null:primaryObligorReference.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setPrimaryObligorReferenceValue(LegalEntity primaryObligorReference) {
			this.getOrCreatePrimaryObligorReference().setValue(primaryObligorReference);
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setSecurity(Security security) {
			this.security = security==null?null:security.toBuilder();
			return this;
		}
		@Override
		public ReferenceObligation.ReferenceObligationBuilder setStandardReferenceObligation(Boolean standardReferenceObligation) {
			this.standardReferenceObligation = standardReferenceObligation==null?null:standardReferenceObligation;
			return this;
		}
		
		@Override
		public ReferenceObligation build() {
			return new ReferenceObligation.ReferenceObligationImpl(this);
		}
		
		@Override
		public ReferenceObligation.ReferenceObligationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligation.ReferenceObligationBuilder prune() {
			if (guarantor!=null && !guarantor.prune().hasData()) guarantor = null;
			if (loan!=null && !loan.prune().hasData()) loan = null;
			if (primaryObligor!=null && !primaryObligor.prune().hasData()) primaryObligor = null;
			if (primaryObligorReference!=null && !primaryObligorReference.prune().hasData()) primaryObligorReference = null;
			if (security!=null && !security.prune().hasData()) security = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGuarantor()!=null && getGuarantor().hasData()) return true;
			if (getGuarantorReference()!=null) return true;
			if (getLoan()!=null && getLoan().hasData()) return true;
			if (getPrimaryObligor()!=null && getPrimaryObligor().hasData()) return true;
			if (getPrimaryObligorReference()!=null && getPrimaryObligorReference().hasData()) return true;
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			if (getStandardReferenceObligation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceObligation.ReferenceObligationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceObligation.ReferenceObligationBuilder o = (ReferenceObligation.ReferenceObligationBuilder) other;
			
			merger.mergeRosetta(getGuarantor(), o.getGuarantor(), this::setGuarantor);
			merger.mergeRosetta(getLoan(), o.getLoan(), this::setLoan);
			merger.mergeRosetta(getPrimaryObligor(), o.getPrimaryObligor(), this::setPrimaryObligor);
			merger.mergeRosetta(getPrimaryObligorReference(), o.getPrimaryObligorReference(), this::setPrimaryObligorReference);
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			
			merger.mergeBasic(getGuarantorReference(), o.getGuarantorReference(), this::setGuarantorReference);
			merger.mergeBasic(getStandardReferenceObligation(), o.getStandardReferenceObligation(), this::setStandardReferenceObligation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceObligation _that = getType().cast(o);
		
			if (!Objects.equals(guarantor, _that.getGuarantor())) return false;
			if (!Objects.equals(guarantorReference, _that.getGuarantorReference())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(primaryObligor, _that.getPrimaryObligor())) return false;
			if (!Objects.equals(primaryObligorReference, _that.getPrimaryObligorReference())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(standardReferenceObligation, _that.getStandardReferenceObligation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (guarantor != null ? guarantor.hashCode() : 0);
			_result = 31 * _result + (guarantorReference != null ? guarantorReference.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (primaryObligor != null ? primaryObligor.hashCode() : 0);
			_result = 31 * _result + (primaryObligorReference != null ? primaryObligorReference.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (standardReferenceObligation != null ? standardReferenceObligation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceObligationBuilder {" +
				"guarantor=" + this.guarantor + ", " +
				"guarantorReference=" + this.guarantorReference + ", " +
				"loan=" + this.loan + ", " +
				"primaryObligor=" + this.primaryObligor + ", " +
				"primaryObligorReference=" + this.primaryObligorReference + ", " +
				"security=" + this.security + ", " +
				"standardReferenceObligation=" + this.standardReferenceObligation +
			'}';
		}
	}
}
