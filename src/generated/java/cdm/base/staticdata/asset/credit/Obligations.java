package cdm.base.staticdata.asset.credit;

import cdm.base.staticdata.asset.credit.meta.ObligationsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the underlying obligations of the reference entity on which protection is purchased or sold through the Credit Default Swap.
 * @version ${project.version}
 */
@RosettaClass

public interface Obligations extends RosettaModelObject {
	Obligations build();
	Obligations.ObligationsBuilder toBuilder();
	
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Cash Settlement Only.
	 */
	Boolean getCashSettlementOnly();
	/**
	 * Used in both obligations and deliverable obligations to represent a class or type of securities which apply. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category.
	 */
	ObligationCategoryEnum getCategory();
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Continuity.
	 */
	Boolean getContinuity();
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published Standard Terms Supplement for use with CDS Transactions on Leveraged Loans. ISDA 2003 Term: Delivery of Commitments.
	 */
	Boolean getDeliveryOfCommitments();
	/**
	 * Applies to Loan CDS, to indicate what lien level is appropriate for a deliverable obligation. Applies to European Loan CDS, to indicate the Ranking of the obligation. Example: a 2nd lien Loan CDS would imply that the deliverable obligations are 1st or 2nd lien loans.
	 */
	FieldWithMetaString getDesignatedPriority();
	/**
	 * A free format string to specify any excluded obligations or deliverable obligations, as the case may be, of the reference entity or excluded types of obligations or deliverable obligations. ISDA 2003 Term: Excluded Obligations/Excluded Deliverable Obligations.
	 */
	String getExcluded();
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Full Faith and Credit Obligation Liability.
	 */
	Boolean getFullFaithAndCreditObLiability();
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: General Fund Obligation Liability.
	 */
	Boolean getGeneralFundObligationLiability();
	/**
	 * An obligation and deliverable obligation characteristic. Indicates whether or not the obligation is quoted, listed or ordinarily purchased and sold on an exchange. ISDA 2003 Term: Listed.
	 */
	Boolean getListed();
	/**
	 * OTE: Only allowed as an obligation characteristic under ISDA Credit 1999. In essence Not Contingent means the repayment of principal cannot be dependent on a formula/index, i.e. to prevent the risk of being delivered an instrument that may never pay any element of principal, and to ensure that the obligation is interest bearing (on a regular schedule). ISDA 2003 Term: Not Contingent.
	 */
	Boolean getNotContingent();
	/**
	 * An obligation and deliverable obligation characteristic. Any obligation that is payable in any currency other than the domestic currency. Domestic currency is either the currency so specified or, if no currency is specified, the currency of (a) the reference entity, if the reference entity is a sovereign, or (b) the jurisdiction in which the relevant reference entity is organised, if the reference entity is not a sovereign. ISDA 2003 Term: Not Domestic Currency.
	 */
	NotDomesticCurrency getNotDomesticCurrency();
	/**
	 * An obligation and deliverable obligation characteristic. Any obligation other than an obligation that was intended to be offered for sale primarily in the domestic market of the relevant Reference Entity. This specifies that the obligation must be an internationally recognised bond. ISDA 2003 Term: Not Domestic Issuance.
	 */
	Boolean getNotDomesticIssuance();
	/**
	 * An obligation and deliverable obligation characteristic. If the reference entity is a Sovereign, this means any obligation that is not subject to the laws of the reference entity. If the reference entity is not a sovereign, this means any obligation that is not subject to the laws of the jurisdiction of the reference entity. ISDA 2003 Term: Not Domestic Law.
	 */
	Boolean getNotDomesticLaw();
	/**
	 * An obligation and deliverable obligation characteristic. Any obligation that is not primarily (majority) owed to a Sovereign or Supranational Organisation. ISDA 2003 Term: Not Sovereign Lender.
	 */
	Boolean getNotSovereignLender();
	/**
	 * An obligation and deliverable obligation characteristic. An obligation that ranks at least equal with the most senior Reference Obligation in priority of payment or, if no Reference Obligation is specified in the related Confirmation, the obligations of the Reference Entity that are senior. ISDA 2003 Term: Not Subordinated.
	 */
	Boolean getNotSubordinated();
	/**
	 * This element is used to specify any other obligations of a reference entity in both obligations and deliverable obligations. The obligations can be specified free-form. ISDA 2003 Term: Other Obligations of a Reference Entity.
	 */
	String getOthReferenceEntityObligations();
	/**
	 * An obligation and deliverable obligation characteristic. Defined in the ISDA published additional provisions for U.S. Municipal as Reference Entity. ISDA 2003 Term: Revenue Obligation Liability.
	 */
	Boolean getRevenueObligationLiability();
	/**
	 * An obligation and deliverable obligation characteristic. The currency or currencies in which an obligation or deliverable obligation must be payable. ISDA 2003 Term: Specified Currency.
	 */
	SpecifiedCurrency getSpecifiedCurrency();
	final static ObligationsMeta metaData = new ObligationsMeta();
	
	@Override
	default RosettaMetaData<? extends Obligations> metaData() {
		return metaData;
	} 
			
	static Obligations.ObligationsBuilder builder() {
		return new Obligations.ObligationsBuilderImpl();
	}
	
	default Class<? extends Obligations> getType() {
		return Obligations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashSettlementOnly"), Boolean.class, getCashSettlementOnly(), this);
		processor.processBasic(path.newSubPath("category"), ObligationCategoryEnum.class, getCategory(), this);
		processor.processBasic(path.newSubPath("continuity"), Boolean.class, getContinuity(), this);
		processor.processBasic(path.newSubPath("deliveryOfCommitments"), Boolean.class, getDeliveryOfCommitments(), this);
		processor.processBasic(path.newSubPath("excluded"), String.class, getExcluded(), this);
		processor.processBasic(path.newSubPath("fullFaithAndCreditObLiability"), Boolean.class, getFullFaithAndCreditObLiability(), this);
		processor.processBasic(path.newSubPath("generalFundObligationLiability"), Boolean.class, getGeneralFundObligationLiability(), this);
		processor.processBasic(path.newSubPath("listed"), Boolean.class, getListed(), this);
		processor.processBasic(path.newSubPath("notContingent"), Boolean.class, getNotContingent(), this);
		processor.processBasic(path.newSubPath("notDomesticIssuance"), Boolean.class, getNotDomesticIssuance(), this);
		processor.processBasic(path.newSubPath("notDomesticLaw"), Boolean.class, getNotDomesticLaw(), this);
		processor.processBasic(path.newSubPath("notSovereignLender"), Boolean.class, getNotSovereignLender(), this);
		processor.processBasic(path.newSubPath("notSubordinated"), Boolean.class, getNotSubordinated(), this);
		processor.processBasic(path.newSubPath("othReferenceEntityObligations"), String.class, getOthReferenceEntityObligations(), this);
		processor.processBasic(path.newSubPath("revenueObligationLiability"), Boolean.class, getRevenueObligationLiability(), this);
		
		processRosetta(path.newSubPath("designatedPriority"), processor, FieldWithMetaString.class, getDesignatedPriority());
		processRosetta(path.newSubPath("notDomesticCurrency"), processor, NotDomesticCurrency.class, getNotDomesticCurrency());
		processRosetta(path.newSubPath("specifiedCurrency"), processor, SpecifiedCurrency.class, getSpecifiedCurrency());
	}
	
	
	interface ObligationsBuilder extends Obligations, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateDesignatedPriority();
		FieldWithMetaStringBuilder getDesignatedPriority();
		NotDomesticCurrency.NotDomesticCurrencyBuilder getOrCreateNotDomesticCurrency();
		NotDomesticCurrency.NotDomesticCurrencyBuilder getNotDomesticCurrency();
		SpecifiedCurrency.SpecifiedCurrencyBuilder getOrCreateSpecifiedCurrency();
		SpecifiedCurrency.SpecifiedCurrencyBuilder getSpecifiedCurrency();
		Obligations.ObligationsBuilder setCashSettlementOnly(Boolean cashSettlementOnly);
		Obligations.ObligationsBuilder setCategory(ObligationCategoryEnum category);
		Obligations.ObligationsBuilder setContinuity(Boolean continuity);
		Obligations.ObligationsBuilder setDeliveryOfCommitments(Boolean deliveryOfCommitments);
		Obligations.ObligationsBuilder setDesignatedPriority(FieldWithMetaString designatedPriority);
		Obligations.ObligationsBuilder setDesignatedPriorityValue(String designatedPriority);
		Obligations.ObligationsBuilder setExcluded(String excluded);
		Obligations.ObligationsBuilder setFullFaithAndCreditObLiability(Boolean fullFaithAndCreditObLiability);
		Obligations.ObligationsBuilder setGeneralFundObligationLiability(Boolean generalFundObligationLiability);
		Obligations.ObligationsBuilder setListed(Boolean listed);
		Obligations.ObligationsBuilder setNotContingent(Boolean notContingent);
		Obligations.ObligationsBuilder setNotDomesticCurrency(NotDomesticCurrency notDomesticCurrency);
		Obligations.ObligationsBuilder setNotDomesticIssuance(Boolean notDomesticIssuance);
		Obligations.ObligationsBuilder setNotDomesticLaw(Boolean notDomesticLaw);
		Obligations.ObligationsBuilder setNotSovereignLender(Boolean notSovereignLender);
		Obligations.ObligationsBuilder setNotSubordinated(Boolean notSubordinated);
		Obligations.ObligationsBuilder setOthReferenceEntityObligations(String othReferenceEntityObligations);
		Obligations.ObligationsBuilder setRevenueObligationLiability(Boolean revenueObligationLiability);
		Obligations.ObligationsBuilder setSpecifiedCurrency(SpecifiedCurrency specifiedCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("cashSettlementOnly"), Boolean.class, getCashSettlementOnly(), this);
			processor.processBasic(path.newSubPath("category"), ObligationCategoryEnum.class, getCategory(), this);
			processor.processBasic(path.newSubPath("continuity"), Boolean.class, getContinuity(), this);
			processor.processBasic(path.newSubPath("deliveryOfCommitments"), Boolean.class, getDeliveryOfCommitments(), this);
			processor.processBasic(path.newSubPath("excluded"), String.class, getExcluded(), this);
			processor.processBasic(path.newSubPath("fullFaithAndCreditObLiability"), Boolean.class, getFullFaithAndCreditObLiability(), this);
			processor.processBasic(path.newSubPath("generalFundObligationLiability"), Boolean.class, getGeneralFundObligationLiability(), this);
			processor.processBasic(path.newSubPath("listed"), Boolean.class, getListed(), this);
			processor.processBasic(path.newSubPath("notContingent"), Boolean.class, getNotContingent(), this);
			processor.processBasic(path.newSubPath("notDomesticIssuance"), Boolean.class, getNotDomesticIssuance(), this);
			processor.processBasic(path.newSubPath("notDomesticLaw"), Boolean.class, getNotDomesticLaw(), this);
			processor.processBasic(path.newSubPath("notSovereignLender"), Boolean.class, getNotSovereignLender(), this);
			processor.processBasic(path.newSubPath("notSubordinated"), Boolean.class, getNotSubordinated(), this);
			processor.processBasic(path.newSubPath("othReferenceEntityObligations"), String.class, getOthReferenceEntityObligations(), this);
			processor.processBasic(path.newSubPath("revenueObligationLiability"), Boolean.class, getRevenueObligationLiability(), this);
			
			processRosetta(path.newSubPath("designatedPriority"), processor, FieldWithMetaStringBuilder.class, getDesignatedPriority());
			processRosetta(path.newSubPath("notDomesticCurrency"), processor, NotDomesticCurrency.NotDomesticCurrencyBuilder.class, getNotDomesticCurrency());
			processRosetta(path.newSubPath("specifiedCurrency"), processor, SpecifiedCurrency.SpecifiedCurrencyBuilder.class, getSpecifiedCurrency());
		}
		
	}
	
	//Obligations.ObligationsImpl
	class ObligationsImpl implements Obligations {
		private final Boolean cashSettlementOnly;
		private final ObligationCategoryEnum category;
		private final Boolean continuity;
		private final Boolean deliveryOfCommitments;
		private final FieldWithMetaString designatedPriority;
		private final String excluded;
		private final Boolean fullFaithAndCreditObLiability;
		private final Boolean generalFundObligationLiability;
		private final Boolean listed;
		private final Boolean notContingent;
		private final NotDomesticCurrency notDomesticCurrency;
		private final Boolean notDomesticIssuance;
		private final Boolean notDomesticLaw;
		private final Boolean notSovereignLender;
		private final Boolean notSubordinated;
		private final String othReferenceEntityObligations;
		private final Boolean revenueObligationLiability;
		private final SpecifiedCurrency specifiedCurrency;
		
		protected ObligationsImpl(Obligations.ObligationsBuilder builder) {
			this.cashSettlementOnly = builder.getCashSettlementOnly();
			this.category = builder.getCategory();
			this.continuity = builder.getContinuity();
			this.deliveryOfCommitments = builder.getDeliveryOfCommitments();
			this.designatedPriority = ofNullable(builder.getDesignatedPriority()).map(f->f.build()).orElse(null);
			this.excluded = builder.getExcluded();
			this.fullFaithAndCreditObLiability = builder.getFullFaithAndCreditObLiability();
			this.generalFundObligationLiability = builder.getGeneralFundObligationLiability();
			this.listed = builder.getListed();
			this.notContingent = builder.getNotContingent();
			this.notDomesticCurrency = ofNullable(builder.getNotDomesticCurrency()).map(f->f.build()).orElse(null);
			this.notDomesticIssuance = builder.getNotDomesticIssuance();
			this.notDomesticLaw = builder.getNotDomesticLaw();
			this.notSovereignLender = builder.getNotSovereignLender();
			this.notSubordinated = builder.getNotSubordinated();
			this.othReferenceEntityObligations = builder.getOthReferenceEntityObligations();
			this.revenueObligationLiability = builder.getRevenueObligationLiability();
			this.specifiedCurrency = ofNullable(builder.getSpecifiedCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getCashSettlementOnly() {
			return cashSettlementOnly;
		}
		
		@Override
		public ObligationCategoryEnum getCategory() {
			return category;
		}
		
		@Override
		public Boolean getContinuity() {
			return continuity;
		}
		
		@Override
		public Boolean getDeliveryOfCommitments() {
			return deliveryOfCommitments;
		}
		
		@Override
		public FieldWithMetaString getDesignatedPriority() {
			return designatedPriority;
		}
		
		@Override
		public String getExcluded() {
			return excluded;
		}
		
		@Override
		public Boolean getFullFaithAndCreditObLiability() {
			return fullFaithAndCreditObLiability;
		}
		
		@Override
		public Boolean getGeneralFundObligationLiability() {
			return generalFundObligationLiability;
		}
		
		@Override
		public Boolean getListed() {
			return listed;
		}
		
		@Override
		public Boolean getNotContingent() {
			return notContingent;
		}
		
		@Override
		public NotDomesticCurrency getNotDomesticCurrency() {
			return notDomesticCurrency;
		}
		
		@Override
		public Boolean getNotDomesticIssuance() {
			return notDomesticIssuance;
		}
		
		@Override
		public Boolean getNotDomesticLaw() {
			return notDomesticLaw;
		}
		
		@Override
		public Boolean getNotSovereignLender() {
			return notSovereignLender;
		}
		
		@Override
		public Boolean getNotSubordinated() {
			return notSubordinated;
		}
		
		@Override
		public String getOthReferenceEntityObligations() {
			return othReferenceEntityObligations;
		}
		
		@Override
		public Boolean getRevenueObligationLiability() {
			return revenueObligationLiability;
		}
		
		@Override
		public SpecifiedCurrency getSpecifiedCurrency() {
			return specifiedCurrency;
		}
		
		@Override
		public Obligations build() {
			return this;
		}
		
		@Override
		public Obligations.ObligationsBuilder toBuilder() {
			Obligations.ObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Obligations.ObligationsBuilder builder) {
			ofNullable(getCashSettlementOnly()).ifPresent(builder::setCashSettlementOnly);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getContinuity()).ifPresent(builder::setContinuity);
			ofNullable(getDeliveryOfCommitments()).ifPresent(builder::setDeliveryOfCommitments);
			ofNullable(getDesignatedPriority()).ifPresent(builder::setDesignatedPriority);
			ofNullable(getExcluded()).ifPresent(builder::setExcluded);
			ofNullable(getFullFaithAndCreditObLiability()).ifPresent(builder::setFullFaithAndCreditObLiability);
			ofNullable(getGeneralFundObligationLiability()).ifPresent(builder::setGeneralFundObligationLiability);
			ofNullable(getListed()).ifPresent(builder::setListed);
			ofNullable(getNotContingent()).ifPresent(builder::setNotContingent);
			ofNullable(getNotDomesticCurrency()).ifPresent(builder::setNotDomesticCurrency);
			ofNullable(getNotDomesticIssuance()).ifPresent(builder::setNotDomesticIssuance);
			ofNullable(getNotDomesticLaw()).ifPresent(builder::setNotDomesticLaw);
			ofNullable(getNotSovereignLender()).ifPresent(builder::setNotSovereignLender);
			ofNullable(getNotSubordinated()).ifPresent(builder::setNotSubordinated);
			ofNullable(getOthReferenceEntityObligations()).ifPresent(builder::setOthReferenceEntityObligations);
			ofNullable(getRevenueObligationLiability()).ifPresent(builder::setRevenueObligationLiability);
			ofNullable(getSpecifiedCurrency()).ifPresent(builder::setSpecifiedCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Obligations _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementOnly, _that.getCashSettlementOnly())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(continuity, _that.getContinuity())) return false;
			if (!Objects.equals(deliveryOfCommitments, _that.getDeliveryOfCommitments())) return false;
			if (!Objects.equals(designatedPriority, _that.getDesignatedPriority())) return false;
			if (!Objects.equals(excluded, _that.getExcluded())) return false;
			if (!Objects.equals(fullFaithAndCreditObLiability, _that.getFullFaithAndCreditObLiability())) return false;
			if (!Objects.equals(generalFundObligationLiability, _that.getGeneralFundObligationLiability())) return false;
			if (!Objects.equals(listed, _that.getListed())) return false;
			if (!Objects.equals(notContingent, _that.getNotContingent())) return false;
			if (!Objects.equals(notDomesticCurrency, _that.getNotDomesticCurrency())) return false;
			if (!Objects.equals(notDomesticIssuance, _that.getNotDomesticIssuance())) return false;
			if (!Objects.equals(notDomesticLaw, _that.getNotDomesticLaw())) return false;
			if (!Objects.equals(notSovereignLender, _that.getNotSovereignLender())) return false;
			if (!Objects.equals(notSubordinated, _that.getNotSubordinated())) return false;
			if (!Objects.equals(othReferenceEntityObligations, _that.getOthReferenceEntityObligations())) return false;
			if (!Objects.equals(revenueObligationLiability, _that.getRevenueObligationLiability())) return false;
			if (!Objects.equals(specifiedCurrency, _that.getSpecifiedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementOnly != null ? cashSettlementOnly.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (continuity != null ? continuity.hashCode() : 0);
			_result = 31 * _result + (deliveryOfCommitments != null ? deliveryOfCommitments.hashCode() : 0);
			_result = 31 * _result + (designatedPriority != null ? designatedPriority.hashCode() : 0);
			_result = 31 * _result + (excluded != null ? excluded.hashCode() : 0);
			_result = 31 * _result + (fullFaithAndCreditObLiability != null ? fullFaithAndCreditObLiability.hashCode() : 0);
			_result = 31 * _result + (generalFundObligationLiability != null ? generalFundObligationLiability.hashCode() : 0);
			_result = 31 * _result + (listed != null ? listed.hashCode() : 0);
			_result = 31 * _result + (notContingent != null ? notContingent.hashCode() : 0);
			_result = 31 * _result + (notDomesticCurrency != null ? notDomesticCurrency.hashCode() : 0);
			_result = 31 * _result + (notDomesticIssuance != null ? notDomesticIssuance.hashCode() : 0);
			_result = 31 * _result + (notDomesticLaw != null ? notDomesticLaw.hashCode() : 0);
			_result = 31 * _result + (notSovereignLender != null ? notSovereignLender.hashCode() : 0);
			_result = 31 * _result + (notSubordinated != null ? notSubordinated.hashCode() : 0);
			_result = 31 * _result + (othReferenceEntityObligations != null ? othReferenceEntityObligations.hashCode() : 0);
			_result = 31 * _result + (revenueObligationLiability != null ? revenueObligationLiability.hashCode() : 0);
			_result = 31 * _result + (specifiedCurrency != null ? specifiedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Obligations {" +
				"cashSettlementOnly=" + this.cashSettlementOnly + ", " +
				"category=" + this.category + ", " +
				"continuity=" + this.continuity + ", " +
				"deliveryOfCommitments=" + this.deliveryOfCommitments + ", " +
				"designatedPriority=" + this.designatedPriority + ", " +
				"excluded=" + this.excluded + ", " +
				"fullFaithAndCreditObLiability=" + this.fullFaithAndCreditObLiability + ", " +
				"generalFundObligationLiability=" + this.generalFundObligationLiability + ", " +
				"listed=" + this.listed + ", " +
				"notContingent=" + this.notContingent + ", " +
				"notDomesticCurrency=" + this.notDomesticCurrency + ", " +
				"notDomesticIssuance=" + this.notDomesticIssuance + ", " +
				"notDomesticLaw=" + this.notDomesticLaw + ", " +
				"notSovereignLender=" + this.notSovereignLender + ", " +
				"notSubordinated=" + this.notSubordinated + ", " +
				"othReferenceEntityObligations=" + this.othReferenceEntityObligations + ", " +
				"revenueObligationLiability=" + this.revenueObligationLiability + ", " +
				"specifiedCurrency=" + this.specifiedCurrency +
			'}';
		}
	}
	
	//Obligations.ObligationsBuilderImpl
	class ObligationsBuilderImpl implements Obligations.ObligationsBuilder {
	
		protected Boolean cashSettlementOnly;
		protected ObligationCategoryEnum category;
		protected Boolean continuity;
		protected Boolean deliveryOfCommitments;
		protected FieldWithMetaStringBuilder designatedPriority;
		protected String excluded;
		protected Boolean fullFaithAndCreditObLiability;
		protected Boolean generalFundObligationLiability;
		protected Boolean listed;
		protected Boolean notContingent;
		protected NotDomesticCurrency.NotDomesticCurrencyBuilder notDomesticCurrency;
		protected Boolean notDomesticIssuance;
		protected Boolean notDomesticLaw;
		protected Boolean notSovereignLender;
		protected Boolean notSubordinated;
		protected String othReferenceEntityObligations;
		protected Boolean revenueObligationLiability;
		protected SpecifiedCurrency.SpecifiedCurrencyBuilder specifiedCurrency;
	
		public ObligationsBuilderImpl() {
		}
	
		@Override
		public Boolean getCashSettlementOnly() {
			return cashSettlementOnly;
		}
		
		@Override
		public ObligationCategoryEnum getCategory() {
			return category;
		}
		
		@Override
		public Boolean getContinuity() {
			return continuity;
		}
		
		@Override
		public Boolean getDeliveryOfCommitments() {
			return deliveryOfCommitments;
		}
		
		@Override
		public FieldWithMetaStringBuilder getDesignatedPriority() {
			return designatedPriority;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateDesignatedPriority() {
			FieldWithMetaStringBuilder result;
			if (designatedPriority!=null) {
				result = designatedPriority;
			}
			else {
				result = designatedPriority = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getExcluded() {
			return excluded;
		}
		
		@Override
		public Boolean getFullFaithAndCreditObLiability() {
			return fullFaithAndCreditObLiability;
		}
		
		@Override
		public Boolean getGeneralFundObligationLiability() {
			return generalFundObligationLiability;
		}
		
		@Override
		public Boolean getListed() {
			return listed;
		}
		
		@Override
		public Boolean getNotContingent() {
			return notContingent;
		}
		
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder getNotDomesticCurrency() {
			return notDomesticCurrency;
		}
		
		@Override
		public NotDomesticCurrency.NotDomesticCurrencyBuilder getOrCreateNotDomesticCurrency() {
			NotDomesticCurrency.NotDomesticCurrencyBuilder result;
			if (notDomesticCurrency!=null) {
				result = notDomesticCurrency;
			}
			else {
				result = notDomesticCurrency = NotDomesticCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getNotDomesticIssuance() {
			return notDomesticIssuance;
		}
		
		@Override
		public Boolean getNotDomesticLaw() {
			return notDomesticLaw;
		}
		
		@Override
		public Boolean getNotSovereignLender() {
			return notSovereignLender;
		}
		
		@Override
		public Boolean getNotSubordinated() {
			return notSubordinated;
		}
		
		@Override
		public String getOthReferenceEntityObligations() {
			return othReferenceEntityObligations;
		}
		
		@Override
		public Boolean getRevenueObligationLiability() {
			return revenueObligationLiability;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder getSpecifiedCurrency() {
			return specifiedCurrency;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder getOrCreateSpecifiedCurrency() {
			SpecifiedCurrency.SpecifiedCurrencyBuilder result;
			if (specifiedCurrency!=null) {
				result = specifiedCurrency;
			}
			else {
				result = specifiedCurrency = SpecifiedCurrency.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Obligations.ObligationsBuilder setCashSettlementOnly(Boolean cashSettlementOnly) {
			this.cashSettlementOnly = cashSettlementOnly==null?null:cashSettlementOnly;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setCategory(ObligationCategoryEnum category) {
			this.category = category==null?null:category;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setContinuity(Boolean continuity) {
			this.continuity = continuity==null?null:continuity;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setDeliveryOfCommitments(Boolean deliveryOfCommitments) {
			this.deliveryOfCommitments = deliveryOfCommitments==null?null:deliveryOfCommitments;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setDesignatedPriority(FieldWithMetaString designatedPriority) {
			this.designatedPriority = designatedPriority==null?null:designatedPriority.toBuilder();
			return this;
		}
		
		@Override
		public Obligations.ObligationsBuilder setDesignatedPriorityValue(String designatedPriority) {
			this.getOrCreateDesignatedPriority().setValue(designatedPriority);
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setExcluded(String excluded) {
			this.excluded = excluded==null?null:excluded;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setFullFaithAndCreditObLiability(Boolean fullFaithAndCreditObLiability) {
			this.fullFaithAndCreditObLiability = fullFaithAndCreditObLiability==null?null:fullFaithAndCreditObLiability;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setGeneralFundObligationLiability(Boolean generalFundObligationLiability) {
			this.generalFundObligationLiability = generalFundObligationLiability==null?null:generalFundObligationLiability;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setListed(Boolean listed) {
			this.listed = listed==null?null:listed;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotContingent(Boolean notContingent) {
			this.notContingent = notContingent==null?null:notContingent;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotDomesticCurrency(NotDomesticCurrency notDomesticCurrency) {
			this.notDomesticCurrency = notDomesticCurrency==null?null:notDomesticCurrency.toBuilder();
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotDomesticIssuance(Boolean notDomesticIssuance) {
			this.notDomesticIssuance = notDomesticIssuance==null?null:notDomesticIssuance;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotDomesticLaw(Boolean notDomesticLaw) {
			this.notDomesticLaw = notDomesticLaw==null?null:notDomesticLaw;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotSovereignLender(Boolean notSovereignLender) {
			this.notSovereignLender = notSovereignLender==null?null:notSovereignLender;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setNotSubordinated(Boolean notSubordinated) {
			this.notSubordinated = notSubordinated==null?null:notSubordinated;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setOthReferenceEntityObligations(String othReferenceEntityObligations) {
			this.othReferenceEntityObligations = othReferenceEntityObligations==null?null:othReferenceEntityObligations;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setRevenueObligationLiability(Boolean revenueObligationLiability) {
			this.revenueObligationLiability = revenueObligationLiability==null?null:revenueObligationLiability;
			return this;
		}
		@Override
		public Obligations.ObligationsBuilder setSpecifiedCurrency(SpecifiedCurrency specifiedCurrency) {
			this.specifiedCurrency = specifiedCurrency==null?null:specifiedCurrency.toBuilder();
			return this;
		}
		
		@Override
		public Obligations build() {
			return new Obligations.ObligationsImpl(this);
		}
		
		@Override
		public Obligations.ObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Obligations.ObligationsBuilder prune() {
			if (designatedPriority!=null && !designatedPriority.prune().hasData()) designatedPriority = null;
			if (notDomesticCurrency!=null && !notDomesticCurrency.prune().hasData()) notDomesticCurrency = null;
			if (specifiedCurrency!=null && !specifiedCurrency.prune().hasData()) specifiedCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementOnly()!=null) return true;
			if (getCategory()!=null) return true;
			if (getContinuity()!=null) return true;
			if (getDeliveryOfCommitments()!=null) return true;
			if (getDesignatedPriority()!=null) return true;
			if (getExcluded()!=null) return true;
			if (getFullFaithAndCreditObLiability()!=null) return true;
			if (getGeneralFundObligationLiability()!=null) return true;
			if (getListed()!=null) return true;
			if (getNotContingent()!=null) return true;
			if (getNotDomesticCurrency()!=null && getNotDomesticCurrency().hasData()) return true;
			if (getNotDomesticIssuance()!=null) return true;
			if (getNotDomesticLaw()!=null) return true;
			if (getNotSovereignLender()!=null) return true;
			if (getNotSubordinated()!=null) return true;
			if (getOthReferenceEntityObligations()!=null) return true;
			if (getRevenueObligationLiability()!=null) return true;
			if (getSpecifiedCurrency()!=null && getSpecifiedCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Obligations.ObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Obligations.ObligationsBuilder o = (Obligations.ObligationsBuilder) other;
			
			merger.mergeRosetta(getDesignatedPriority(), o.getDesignatedPriority(), this::setDesignatedPriority);
			merger.mergeRosetta(getNotDomesticCurrency(), o.getNotDomesticCurrency(), this::setNotDomesticCurrency);
			merger.mergeRosetta(getSpecifiedCurrency(), o.getSpecifiedCurrency(), this::setSpecifiedCurrency);
			
			merger.mergeBasic(getCashSettlementOnly(), o.getCashSettlementOnly(), this::setCashSettlementOnly);
			merger.mergeBasic(getCategory(), o.getCategory(), this::setCategory);
			merger.mergeBasic(getContinuity(), o.getContinuity(), this::setContinuity);
			merger.mergeBasic(getDeliveryOfCommitments(), o.getDeliveryOfCommitments(), this::setDeliveryOfCommitments);
			merger.mergeBasic(getExcluded(), o.getExcluded(), this::setExcluded);
			merger.mergeBasic(getFullFaithAndCreditObLiability(), o.getFullFaithAndCreditObLiability(), this::setFullFaithAndCreditObLiability);
			merger.mergeBasic(getGeneralFundObligationLiability(), o.getGeneralFundObligationLiability(), this::setGeneralFundObligationLiability);
			merger.mergeBasic(getListed(), o.getListed(), this::setListed);
			merger.mergeBasic(getNotContingent(), o.getNotContingent(), this::setNotContingent);
			merger.mergeBasic(getNotDomesticIssuance(), o.getNotDomesticIssuance(), this::setNotDomesticIssuance);
			merger.mergeBasic(getNotDomesticLaw(), o.getNotDomesticLaw(), this::setNotDomesticLaw);
			merger.mergeBasic(getNotSovereignLender(), o.getNotSovereignLender(), this::setNotSovereignLender);
			merger.mergeBasic(getNotSubordinated(), o.getNotSubordinated(), this::setNotSubordinated);
			merger.mergeBasic(getOthReferenceEntityObligations(), o.getOthReferenceEntityObligations(), this::setOthReferenceEntityObligations);
			merger.mergeBasic(getRevenueObligationLiability(), o.getRevenueObligationLiability(), this::setRevenueObligationLiability);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Obligations _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementOnly, _that.getCashSettlementOnly())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(continuity, _that.getContinuity())) return false;
			if (!Objects.equals(deliveryOfCommitments, _that.getDeliveryOfCommitments())) return false;
			if (!Objects.equals(designatedPriority, _that.getDesignatedPriority())) return false;
			if (!Objects.equals(excluded, _that.getExcluded())) return false;
			if (!Objects.equals(fullFaithAndCreditObLiability, _that.getFullFaithAndCreditObLiability())) return false;
			if (!Objects.equals(generalFundObligationLiability, _that.getGeneralFundObligationLiability())) return false;
			if (!Objects.equals(listed, _that.getListed())) return false;
			if (!Objects.equals(notContingent, _that.getNotContingent())) return false;
			if (!Objects.equals(notDomesticCurrency, _that.getNotDomesticCurrency())) return false;
			if (!Objects.equals(notDomesticIssuance, _that.getNotDomesticIssuance())) return false;
			if (!Objects.equals(notDomesticLaw, _that.getNotDomesticLaw())) return false;
			if (!Objects.equals(notSovereignLender, _that.getNotSovereignLender())) return false;
			if (!Objects.equals(notSubordinated, _that.getNotSubordinated())) return false;
			if (!Objects.equals(othReferenceEntityObligations, _that.getOthReferenceEntityObligations())) return false;
			if (!Objects.equals(revenueObligationLiability, _that.getRevenueObligationLiability())) return false;
			if (!Objects.equals(specifiedCurrency, _that.getSpecifiedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementOnly != null ? cashSettlementOnly.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (continuity != null ? continuity.hashCode() : 0);
			_result = 31 * _result + (deliveryOfCommitments != null ? deliveryOfCommitments.hashCode() : 0);
			_result = 31 * _result + (designatedPriority != null ? designatedPriority.hashCode() : 0);
			_result = 31 * _result + (excluded != null ? excluded.hashCode() : 0);
			_result = 31 * _result + (fullFaithAndCreditObLiability != null ? fullFaithAndCreditObLiability.hashCode() : 0);
			_result = 31 * _result + (generalFundObligationLiability != null ? generalFundObligationLiability.hashCode() : 0);
			_result = 31 * _result + (listed != null ? listed.hashCode() : 0);
			_result = 31 * _result + (notContingent != null ? notContingent.hashCode() : 0);
			_result = 31 * _result + (notDomesticCurrency != null ? notDomesticCurrency.hashCode() : 0);
			_result = 31 * _result + (notDomesticIssuance != null ? notDomesticIssuance.hashCode() : 0);
			_result = 31 * _result + (notDomesticLaw != null ? notDomesticLaw.hashCode() : 0);
			_result = 31 * _result + (notSovereignLender != null ? notSovereignLender.hashCode() : 0);
			_result = 31 * _result + (notSubordinated != null ? notSubordinated.hashCode() : 0);
			_result = 31 * _result + (othReferenceEntityObligations != null ? othReferenceEntityObligations.hashCode() : 0);
			_result = 31 * _result + (revenueObligationLiability != null ? revenueObligationLiability.hashCode() : 0);
			_result = 31 * _result + (specifiedCurrency != null ? specifiedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObligationsBuilder {" +
				"cashSettlementOnly=" + this.cashSettlementOnly + ", " +
				"category=" + this.category + ", " +
				"continuity=" + this.continuity + ", " +
				"deliveryOfCommitments=" + this.deliveryOfCommitments + ", " +
				"designatedPriority=" + this.designatedPriority + ", " +
				"excluded=" + this.excluded + ", " +
				"fullFaithAndCreditObLiability=" + this.fullFaithAndCreditObLiability + ", " +
				"generalFundObligationLiability=" + this.generalFundObligationLiability + ", " +
				"listed=" + this.listed + ", " +
				"notContingent=" + this.notContingent + ", " +
				"notDomesticCurrency=" + this.notDomesticCurrency + ", " +
				"notDomesticIssuance=" + this.notDomesticIssuance + ", " +
				"notDomesticLaw=" + this.notDomesticLaw + ", " +
				"notSovereignLender=" + this.notSovereignLender + ", " +
				"notSubordinated=" + this.notSubordinated + ", " +
				"othReferenceEntityObligations=" + this.othReferenceEntityObligations + ", " +
				"revenueObligationLiability=" + this.revenueObligationLiability + ", " +
				"specifiedCurrency=" + this.specifiedCurrency +
			'}';
		}
	}
}
