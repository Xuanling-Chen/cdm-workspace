package cdm.product.common.settlement;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.meta.PhysicalSettlementTermsMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies Physical Settlement Terms characteristics for the settlement of a Credit Default Swap or Option.
 * @version ${project.version}
 */
@RosettaClass

public interface PhysicalSettlementTerms extends RosettaModelObject, GlobalKey {
	PhysicalSettlementTerms build();
	PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder();
	
	/**
	 * Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
	 */
	Boolean getClearedPhysicalSettlement();
	/**
	 * This element contains all the ISDA terms relevant to defining the deliverable obligations.
	 */
	DeliverableObligations getDeliverableObligations();
	/**
	 * If this element is specified and set to &#39;true&#39;, indicates that physical settlement must take place through the use of an escrow agent. (For Canadian counterparties this is always &#39;Not Applicable&#39;. ISDA 2003 Term: Escrow.
	 */
	Boolean getEscrow();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The number of business days used in the determination of the physical settlement date. The physical settlement date is this number of business days after all applicable conditions to settlement are satisfied. If a number of business days is not specified fallback provisions apply for determining the number of business days. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply the businessDaysNotSpecified element should be included. If a specified number of business days are to apply these should be specified in the businessDays element. If Section 8.5/8.6 of the 1999/2003 ISDA Definitions are to apply but capped at a maximum number of business days then the maximum number should be specified in the maximumBusinessDays element. ISDA 2003 Term: Physical Settlement Period.
	 */
	PhysicalSettlementPeriod getPhysicalSettlementPeriod();
	/**
	 * Specifies the clearing organization (CCP, DCO) to which the trade should be cleared.
	 */
	AncillaryRoleEnum getPredeterminedClearingOrganizationParty();
	/**
	 * If this element is specified and set to &#39;true&#39;, for a transaction documented under the 2003 ISDA Credit Derivatives Definitions, has the effect of incorporating the language set forth below into the confirmation. The section references are to the 2003 ISDA Credit Derivatives Definitions. Notwithstanding Section 1.7 or any provisions of Sections 9.9 or 9.10 to the contrary, but without prejudice to Section 9.3 and (where applicable) Sections 9.4, 9.5 and 9.6, if the Termination Date has not occurred on or prior to the date that is 60 Business Days following the Physical Settlement Date, such 60th Business Day shall be deemed to be the Termination Date with respect to this Transaction except in relation to any portion of the Transaction (an &#39;Affected Portion&#39;) in respect of which: (1) a valid notice of Buy-in Price has been delivered that is effective fewer than three Business Days prior to such 60th Business Day, in which case the Termination Date for that Affected Portion shall be the third Business Day following the date on which such notice is effective; or (2) Buyer has purchased but not Delivered Deliverable Obligations validly specified by Seller pursuant to Section 9.10(b), in which case the Termination Date for that Affected Portion shall be the tenth Business Day following the date on which Seller validly specified such Deliverable Obligations to Buyer.
	 */
	Boolean getSixtyBusinessDaySettlementCap();
	final static PhysicalSettlementTermsMeta metaData = new PhysicalSettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends PhysicalSettlementTerms> metaData() {
		return metaData;
	} 
			
	static PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder() {
		return new PhysicalSettlementTerms.PhysicalSettlementTermsBuilderImpl();
	}
	
	default Class<? extends PhysicalSettlementTerms> getType() {
		return PhysicalSettlementTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
		processor.processBasic(path.newSubPath("escrow"), Boolean.class, getEscrow(), this);
		processor.processBasic(path.newSubPath("predeterminedClearingOrganizationParty"), AncillaryRoleEnum.class, getPredeterminedClearingOrganizationParty(), this);
		processor.processBasic(path.newSubPath("sixtyBusinessDaySettlementCap"), Boolean.class, getSixtyBusinessDaySettlementCap(), this);
		
		processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.class, getDeliverableObligations());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("physicalSettlementPeriod"), processor, PhysicalSettlementPeriod.class, getPhysicalSettlementPeriod());
	}
	
	
	interface PhysicalSettlementTermsBuilder extends PhysicalSettlementTerms, RosettaModelObjectBuilder {
		DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations();
		DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getOrCreatePhysicalSettlementPeriod();
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getPhysicalSettlementPeriod();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setClearedPhysicalSettlement(Boolean clearedPhysicalSettlement);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setDeliverableObligations(DeliverableObligations deliverableObligations);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setEscrow(Boolean escrow);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setMeta(MetaFields meta);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPhysicalSettlementPeriod(PhysicalSettlementPeriod physicalSettlementPeriod);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPredeterminedClearingOrganizationParty(AncillaryRoleEnum predeterminedClearingOrganizationParty);
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSixtyBusinessDaySettlementCap(Boolean sixtyBusinessDaySettlementCap);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
			processor.processBasic(path.newSubPath("escrow"), Boolean.class, getEscrow(), this);
			processor.processBasic(path.newSubPath("predeterminedClearingOrganizationParty"), AncillaryRoleEnum.class, getPredeterminedClearingOrganizationParty(), this);
			processor.processBasic(path.newSubPath("sixtyBusinessDaySettlementCap"), Boolean.class, getSixtyBusinessDaySettlementCap(), this);
			
			processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.DeliverableObligationsBuilder.class, getDeliverableObligations());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("physicalSettlementPeriod"), processor, PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder.class, getPhysicalSettlementPeriod());
		}
		
	}
	
	//PhysicalSettlementTerms.PhysicalSettlementTermsImpl
	class PhysicalSettlementTermsImpl implements PhysicalSettlementTerms {
		private final Boolean clearedPhysicalSettlement;
		private final DeliverableObligations deliverableObligations;
		private final Boolean escrow;
		private final MetaFields meta;
		private final PhysicalSettlementPeriod physicalSettlementPeriod;
		private final AncillaryRoleEnum predeterminedClearingOrganizationParty;
		private final Boolean sixtyBusinessDaySettlementCap;
		
		protected PhysicalSettlementTermsImpl(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder) {
			this.clearedPhysicalSettlement = builder.getClearedPhysicalSettlement();
			this.deliverableObligations = ofNullable(builder.getDeliverableObligations()).map(f->f.build()).orElse(null);
			this.escrow = builder.getEscrow();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.physicalSettlementPeriod = ofNullable(builder.getPhysicalSettlementPeriod()).map(f->f.build()).orElse(null);
			this.predeterminedClearingOrganizationParty = builder.getPredeterminedClearingOrganizationParty();
			this.sixtyBusinessDaySettlementCap = builder.getSixtyBusinessDaySettlementCap();
		}
		
		@Override
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		public DeliverableObligations getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public Boolean getEscrow() {
			return escrow;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PhysicalSettlementPeriod getPhysicalSettlementPeriod() {
			return physicalSettlementPeriod;
		}
		
		@Override
		public AncillaryRoleEnum getPredeterminedClearingOrganizationParty() {
			return predeterminedClearingOrganizationParty;
		}
		
		@Override
		public Boolean getSixtyBusinessDaySettlementCap() {
			return sixtyBusinessDaySettlementCap;
		}
		
		@Override
		public PhysicalSettlementTerms build() {
			return this;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder builder) {
			ofNullable(getClearedPhysicalSettlement()).ifPresent(builder::setClearedPhysicalSettlement);
			ofNullable(getDeliverableObligations()).ifPresent(builder::setDeliverableObligations);
			ofNullable(getEscrow()).ifPresent(builder::setEscrow);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPhysicalSettlementPeriod()).ifPresent(builder::setPhysicalSettlementPeriod);
			ofNullable(getPredeterminedClearingOrganizationParty()).ifPresent(builder::setPredeterminedClearingOrganizationParty);
			ofNullable(getSixtyBusinessDaySettlementCap()).ifPresent(builder::setSixtyBusinessDaySettlementCap);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			if (!Objects.equals(escrow, _that.getEscrow())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(physicalSettlementPeriod, _that.getPhysicalSettlementPeriod())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationParty, _that.getPredeterminedClearingOrganizationParty())) return false;
			if (!Objects.equals(sixtyBusinessDaySettlementCap, _that.getSixtyBusinessDaySettlementCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			_result = 31 * _result + (escrow != null ? escrow.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementPeriod != null ? physicalSettlementPeriod.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationParty != null ? predeterminedClearingOrganizationParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sixtyBusinessDaySettlementCap != null ? sixtyBusinessDaySettlementCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementTerms {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"deliverableObligations=" + this.deliverableObligations + ", " +
				"escrow=" + this.escrow + ", " +
				"meta=" + this.meta + ", " +
				"physicalSettlementPeriod=" + this.physicalSettlementPeriod + ", " +
				"predeterminedClearingOrganizationParty=" + this.predeterminedClearingOrganizationParty + ", " +
				"sixtyBusinessDaySettlementCap=" + this.sixtyBusinessDaySettlementCap +
			'}';
		}
	}
	
	//PhysicalSettlementTerms.PhysicalSettlementTermsBuilderImpl
	class PhysicalSettlementTermsBuilderImpl implements PhysicalSettlementTerms.PhysicalSettlementTermsBuilder, GlobalKeyBuilder {
	
		protected Boolean clearedPhysicalSettlement;
		protected DeliverableObligations.DeliverableObligationsBuilder deliverableObligations;
		protected Boolean escrow;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder physicalSettlementPeriod;
		protected AncillaryRoleEnum predeterminedClearingOrganizationParty;
		protected Boolean sixtyBusinessDaySettlementCap;
	
		public PhysicalSettlementTermsBuilderImpl() {
		}
	
		@Override
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		public DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations() {
			DeliverableObligations.DeliverableObligationsBuilder result;
			if (deliverableObligations!=null) {
				result = deliverableObligations;
			}
			else {
				result = deliverableObligations = DeliverableObligations.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getEscrow() {
			return escrow;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getPhysicalSettlementPeriod() {
			return physicalSettlementPeriod;
		}
		
		@Override
		public PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder getOrCreatePhysicalSettlementPeriod() {
			PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder result;
			if (physicalSettlementPeriod!=null) {
				result = physicalSettlementPeriod;
			}
			else {
				result = physicalSettlementPeriod = PhysicalSettlementPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		public AncillaryRoleEnum getPredeterminedClearingOrganizationParty() {
			return predeterminedClearingOrganizationParty;
		}
		
		@Override
		public Boolean getSixtyBusinessDaySettlementCap() {
			return sixtyBusinessDaySettlementCap;
		}
		
	
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setClearedPhysicalSettlement(Boolean clearedPhysicalSettlement) {
			this.clearedPhysicalSettlement = clearedPhysicalSettlement==null?null:clearedPhysicalSettlement;
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setDeliverableObligations(DeliverableObligations deliverableObligations) {
			this.deliverableObligations = deliverableObligations==null?null:deliverableObligations.toBuilder();
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setEscrow(Boolean escrow) {
			this.escrow = escrow==null?null:escrow;
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPhysicalSettlementPeriod(PhysicalSettlementPeriod physicalSettlementPeriod) {
			this.physicalSettlementPeriod = physicalSettlementPeriod==null?null:physicalSettlementPeriod.toBuilder();
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setPredeterminedClearingOrganizationParty(AncillaryRoleEnum predeterminedClearingOrganizationParty) {
			this.predeterminedClearingOrganizationParty = predeterminedClearingOrganizationParty==null?null:predeterminedClearingOrganizationParty;
			return this;
		}
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder setSixtyBusinessDaySettlementCap(Boolean sixtyBusinessDaySettlementCap) {
			this.sixtyBusinessDaySettlementCap = sixtyBusinessDaySettlementCap==null?null:sixtyBusinessDaySettlementCap;
			return this;
		}
		
		@Override
		public PhysicalSettlementTerms build() {
			return new PhysicalSettlementTerms.PhysicalSettlementTermsImpl(this);
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder prune() {
			if (deliverableObligations!=null && !deliverableObligations.prune().hasData()) deliverableObligations = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (physicalSettlementPeriod!=null && !physicalSettlementPeriod.prune().hasData()) physicalSettlementPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClearedPhysicalSettlement()!=null) return true;
			if (getDeliverableObligations()!=null && getDeliverableObligations().hasData()) return true;
			if (getEscrow()!=null) return true;
			if (getPhysicalSettlementPeriod()!=null && getPhysicalSettlementPeriod().hasData()) return true;
			if (getPredeterminedClearingOrganizationParty()!=null) return true;
			if (getSixtyBusinessDaySettlementCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder o = (PhysicalSettlementTerms.PhysicalSettlementTermsBuilder) other;
			
			merger.mergeRosetta(getDeliverableObligations(), o.getDeliverableObligations(), this::setDeliverableObligations);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPhysicalSettlementPeriod(), o.getPhysicalSettlementPeriod(), this::setPhysicalSettlementPeriod);
			
			merger.mergeBasic(getClearedPhysicalSettlement(), o.getClearedPhysicalSettlement(), this::setClearedPhysicalSettlement);
			merger.mergeBasic(getEscrow(), o.getEscrow(), this::setEscrow);
			merger.mergeBasic(getPredeterminedClearingOrganizationParty(), o.getPredeterminedClearingOrganizationParty(), this::setPredeterminedClearingOrganizationParty);
			merger.mergeBasic(getSixtyBusinessDaySettlementCap(), o.getSixtyBusinessDaySettlementCap(), this::setSixtyBusinessDaySettlementCap);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PhysicalSettlementTerms _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			if (!Objects.equals(escrow, _that.getEscrow())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(physicalSettlementPeriod, _that.getPhysicalSettlementPeriod())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationParty, _that.getPredeterminedClearingOrganizationParty())) return false;
			if (!Objects.equals(sixtyBusinessDaySettlementCap, _that.getSixtyBusinessDaySettlementCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			_result = 31 * _result + (escrow != null ? escrow.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementPeriod != null ? physicalSettlementPeriod.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationParty != null ? predeterminedClearingOrganizationParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sixtyBusinessDaySettlementCap != null ? sixtyBusinessDaySettlementCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalSettlementTermsBuilder {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"deliverableObligations=" + this.deliverableObligations + ", " +
				"escrow=" + this.escrow + ", " +
				"meta=" + this.meta + ", " +
				"physicalSettlementPeriod=" + this.physicalSettlementPeriod + ", " +
				"predeterminedClearingOrganizationParty=" + this.predeterminedClearingOrganizationParty + ", " +
				"sixtyBusinessDaySettlementCap=" + this.sixtyBusinessDaySettlementCap +
			'}';
		}
	}
}
