package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilder;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilderImpl;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseImpl;
import cdm.base.staticdata.asset.common.meta.LoanMeta;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.party.LegalEntity;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a loan by referencing a product identifier and through an optional set of attributes.
 * @version ${project.version}
 */
@RosettaClass

public interface Loan extends ProductBase {
	Loan build();
	Loan.LoanBuilder toBuilder();
	
	/**
	 * Specifies the borrower. There can be more than one borrower. It is meant to be used in the event that there is no Bloomberg Id or the Secured List isn&#39;t applicable.
	 */
	List<? extends LegalEntity> getBorrower();
	/**
	 * Specifies the credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlier attribute is used to help identify which of the company&#39;s outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
	 */
	Date getCreditAgreementDate();
	/**
	 * Specifies the type of loan facility (letter of credit, revolving, ...).
	 */
	FieldWithMetaString getFacilityType();
	/**
	 * Specifies the seniority level of the lien.
	 */
	FieldWithMetaString getLien();
	/**
	 * Denotes the loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
	 */
	FieldWithMetaString getTranche();
	final static LoanMeta metaData = new LoanMeta();
	
	@Override
	default RosettaMetaData<? extends Loan> metaData() {
		return metaData;
	} 
			
	static Loan.LoanBuilder builder() {
		return new Loan.LoanBuilderImpl();
	}
	
	default Class<? extends Loan> getType() {
		return Loan.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.asset.common.ProductBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
		
		processRosetta(path.newSubPath("borrower"), processor, LegalEntity.class, getBorrower());
		processRosetta(path.newSubPath("facilityType"), processor, FieldWithMetaString.class, getFacilityType());
		processRosetta(path.newSubPath("lien"), processor, FieldWithMetaString.class, getLien());
		processRosetta(path.newSubPath("tranche"), processor, FieldWithMetaString.class, getTranche());
	}
	
	
	interface LoanBuilder extends Loan, ProductBase.ProductBaseBuilder, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateBorrower(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getBorrower();
		FieldWithMetaStringBuilder getOrCreateFacilityType();
		FieldWithMetaStringBuilder getFacilityType();
		FieldWithMetaStringBuilder getOrCreateLien();
		FieldWithMetaStringBuilder getLien();
		FieldWithMetaStringBuilder getOrCreateTranche();
		FieldWithMetaStringBuilder getTranche();
		Loan.LoanBuilder addBorrower(LegalEntity borrower);
		Loan.LoanBuilder addBorrower(LegalEntity borrower, int _idx);
		Loan.LoanBuilder addBorrower(List<? extends LegalEntity> borrower);
		Loan.LoanBuilder setBorrower(List<? extends LegalEntity> borrower);
		Loan.LoanBuilder setCreditAgreementDate(Date creditAgreementDate);
		Loan.LoanBuilder setFacilityType(FieldWithMetaString facilityType);
		Loan.LoanBuilder setFacilityTypeValue(String facilityType);
		Loan.LoanBuilder setLien(FieldWithMetaString lien);
		Loan.LoanBuilder setLienValue(String lien);
		Loan.LoanBuilder setTranche(FieldWithMetaString tranche);
		Loan.LoanBuilder setTrancheValue(String tranche);
		Loan.LoanBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		Loan.LoanBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		Loan.LoanBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		Loan.LoanBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		Loan.LoanBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Loan.LoanBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Loan.LoanBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Loan.LoanBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ProductBase.ProductBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("creditAgreementDate"), Date.class, getCreditAgreementDate(), this);
			
			processRosetta(path.newSubPath("borrower"), processor, LegalEntity.LegalEntityBuilder.class, getBorrower());
			processRosetta(path.newSubPath("facilityType"), processor, FieldWithMetaStringBuilder.class, getFacilityType());
			processRosetta(path.newSubPath("lien"), processor, FieldWithMetaStringBuilder.class, getLien());
			processRosetta(path.newSubPath("tranche"), processor, FieldWithMetaStringBuilder.class, getTranche());
		}
		
	}
	
	//Loan.LoanImpl
	class LoanImpl extends ProductBase.ProductBaseImpl implements Loan {
		private final List<? extends LegalEntity> borrower;
		private final Date creditAgreementDate;
		private final FieldWithMetaString facilityType;
		private final FieldWithMetaString lien;
		private final FieldWithMetaString tranche;
		
		protected LoanImpl(Loan.LoanBuilder builder) {
			super(builder);
			this.borrower = ofNullable(builder.getBorrower()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.facilityType = ofNullable(builder.getFacilityType()).map(f->f.build()).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends LegalEntity> getBorrower() {
			return borrower;
		}
		
		@Override
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		public FieldWithMetaString getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FieldWithMetaString getLien() {
			return lien;
		}
		
		@Override
		public FieldWithMetaString getTranche() {
			return tranche;
		}
		
		@Override
		public Loan build() {
			return this;
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			Loan.LoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Loan.LoanBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBorrower()).ifPresent(builder::setBorrower);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Loan {" +
				"borrower=" + this.borrower + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"facilityType=" + this.facilityType + ", " +
				"lien=" + this.lien + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}
	
	//Loan.LoanBuilderImpl
	class LoanBuilderImpl extends ProductBase.ProductBaseBuilderImpl  implements Loan.LoanBuilder {
	
		protected List<LegalEntity.LegalEntityBuilder> borrower = new ArrayList<>();
		protected Date creditAgreementDate;
		protected FieldWithMetaStringBuilder facilityType;
		protected FieldWithMetaStringBuilder lien;
		protected FieldWithMetaStringBuilder tranche;
	
		public LoanBuilderImpl() {
		}
	
		@Override
		public List<? extends LegalEntity.LegalEntityBuilder> getBorrower() {
			return borrower;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateBorrower(int _index) {
		
			if (borrower==null) {
				this.borrower = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(borrower, _index, () -> {
						LegalEntity.LegalEntityBuilder newBorrower = LegalEntity.builder();
						return newBorrower;
					});
		}
		
		@Override
		public Date getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		public FieldWithMetaStringBuilder getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateFacilityType() {
			FieldWithMetaStringBuilder result;
			if (facilityType!=null) {
				result = facilityType;
			}
			else {
				result = facilityType = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getLien() {
			return lien;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateLien() {
			FieldWithMetaStringBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateTranche() {
			FieldWithMetaStringBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Loan.LoanBuilder addBorrower(LegalEntity borrower) {
			if (borrower!=null) this.borrower.add(borrower.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addBorrower(LegalEntity borrower, int _idx) {
			getIndex(this.borrower, _idx, () -> borrower.toBuilder());
			return this;
		}
		@Override 
		public Loan.LoanBuilder addBorrower(List<? extends LegalEntity> borrowers) {
			if (borrowers != null) {
				for (LegalEntity toAdd : borrowers) {
					this.borrower.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setBorrower(List<? extends LegalEntity> borrowers) {
			if (borrowers == null)  {
				this.borrower = new ArrayList<>();
			}
			else {
				this.borrower = borrowers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder setCreditAgreementDate(Date creditAgreementDate) {
			this.creditAgreementDate = creditAgreementDate==null?null:creditAgreementDate;
			return this;
		}
		@Override
		public Loan.LoanBuilder setFacilityType(FieldWithMetaString facilityType) {
			this.facilityType = facilityType==null?null:facilityType.toBuilder();
			return this;
		}
		
		@Override
		public Loan.LoanBuilder setFacilityTypeValue(String facilityType) {
			this.getOrCreateFacilityType().setValue(facilityType);
			return this;
		}
		@Override
		public Loan.LoanBuilder setLien(FieldWithMetaString lien) {
			this.lien = lien==null?null:lien.toBuilder();
			return this;
		}
		
		@Override
		public Loan.LoanBuilder setLienValue(String lien) {
			this.getOrCreateLien().setValue(lien);
			return this;
		}
		@Override
		public Loan.LoanBuilder setTranche(FieldWithMetaString tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		
		@Override
		public Loan.LoanBuilder setTrancheValue(String tranche) {
			this.getOrCreateTranche().setValue(tranche);
			return this;
		}
		@Override
		public Loan.LoanBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public Loan.LoanBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public Loan.LoanBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public Loan.LoanBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Loan.LoanBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers == null)  {
				this.productIdentifier = new ArrayList<>();
			}
			else {
				this.productIdentifier = productIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		
		@Override
		public Loan build() {
			return new Loan.LoanImpl(this);
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder prune() {
			super.prune();
			borrower = borrower.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (facilityType!=null && !facilityType.prune().hasData()) facilityType = null;
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBorrower()!=null && getBorrower().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getFacilityType()!=null) return true;
			if (getLien()!=null) return true;
			if (getTranche()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Loan.LoanBuilder o = (Loan.LoanBuilder) other;
			
			merger.mergeRosetta(getBorrower(), o.getBorrower(), this::getOrCreateBorrower);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::setFacilityType);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(borrower, _that.getBorrower())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (borrower != null ? borrower.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBuilder {" +
				"borrower=" + this.borrower + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"facilityType=" + this.facilityType + ", " +
				"lien=" + this.lien + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}
}
