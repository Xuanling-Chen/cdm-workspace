package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CustodyArrangementsMeta;
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
 * A class to specify the Custody Arrangements for the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CustodyArrangements extends RosettaModelObject {
	CustodyArrangements build();
	CustodyArrangements.CustodyArrangementsBuilder toBuilder();
	
	/**
	 * The elections specific to Collateral Access Breach language
	 */
	CollateralAccessBreach getCollateralAccessBreach();
	/**
	 * ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(i): Collateral Management Agreement.
	 */
	CollateralManagementAgreement getCollateralManagementAgreeement();
	/**
	 * The party-specific election with respect to the control agreement.
	 */
	ControlAgreement getControlAgreement();
	/**
	 * The custodian and segregated account details for each party to the agreement.
	 */
	Custodian getCustodian();
	/**
	 * When specified as True, means that the Custodian Events specified in Paragraph 13 General Principles, (m)(iii) will constitute an Additional Termination Event. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(iii): Custodian Event.
	 */
	CustodianEvent getCustodianEvent();
	/**
	 * The qualification of the Custodian Risk. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk.
	 */
	CustodianRisk getCustodianRisk();
	/**
	 * Control Agreement language is specified when True.
	 */
	Boolean getHasControlAgreementLanguage();
	/**
	 * Unless specified as True, the Control Agreement is not a Credit Support Document under the agreement with respect to a party. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 6 (e): The Control Agreement as a Credit Support Document.
	 */
	Boolean getIsCreditSupportDocument();
	/**
	 * ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(vii): Other Provisions.
	 */
	String getOtherProvisions();
	final static CustodyArrangementsMeta metaData = new CustodyArrangementsMeta();
	
	@Override
	default RosettaMetaData<? extends CustodyArrangements> metaData() {
		return metaData;
	} 
			
	static CustodyArrangements.CustodyArrangementsBuilder builder() {
		return new CustodyArrangements.CustodyArrangementsBuilderImpl();
	}
	
	default Class<? extends CustodyArrangements> getType() {
		return CustodyArrangements.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("hasControlAgreementLanguage"), Boolean.class, getHasControlAgreementLanguage(), this);
		processor.processBasic(path.newSubPath("isCreditSupportDocument"), Boolean.class, getIsCreditSupportDocument(), this);
		processor.processBasic(path.newSubPath("otherProvisions"), String.class, getOtherProvisions(), this);
		
		processRosetta(path.newSubPath("collateralAccessBreach"), processor, CollateralAccessBreach.class, getCollateralAccessBreach());
		processRosetta(path.newSubPath("collateralManagementAgreeement"), processor, CollateralManagementAgreement.class, getCollateralManagementAgreeement());
		processRosetta(path.newSubPath("controlAgreement"), processor, ControlAgreement.class, getControlAgreement());
		processRosetta(path.newSubPath("custodian"), processor, Custodian.class, getCustodian());
		processRosetta(path.newSubPath("custodianEvent"), processor, CustodianEvent.class, getCustodianEvent());
		processRosetta(path.newSubPath("custodianRisk"), processor, CustodianRisk.class, getCustodianRisk());
	}
	
	
	interface CustodyArrangementsBuilder extends CustodyArrangements, RosettaModelObjectBuilder {
		CollateralAccessBreach.CollateralAccessBreachBuilder getOrCreateCollateralAccessBreach();
		CollateralAccessBreach.CollateralAccessBreachBuilder getCollateralAccessBreach();
		CollateralManagementAgreement.CollateralManagementAgreementBuilder getOrCreateCollateralManagementAgreeement();
		CollateralManagementAgreement.CollateralManagementAgreementBuilder getCollateralManagementAgreeement();
		ControlAgreement.ControlAgreementBuilder getOrCreateControlAgreement();
		ControlAgreement.ControlAgreementBuilder getControlAgreement();
		Custodian.CustodianBuilder getOrCreateCustodian();
		Custodian.CustodianBuilder getCustodian();
		CustodianEvent.CustodianEventBuilder getOrCreateCustodianEvent();
		CustodianEvent.CustodianEventBuilder getCustodianEvent();
		CustodianRisk.CustodianRiskBuilder getOrCreateCustodianRisk();
		CustodianRisk.CustodianRiskBuilder getCustodianRisk();
		CustodyArrangements.CustodyArrangementsBuilder setCollateralAccessBreach(CollateralAccessBreach collateralAccessBreach);
		CustodyArrangements.CustodyArrangementsBuilder setCollateralManagementAgreeement(CollateralManagementAgreement collateralManagementAgreeement);
		CustodyArrangements.CustodyArrangementsBuilder setControlAgreement(ControlAgreement controlAgreement);
		CustodyArrangements.CustodyArrangementsBuilder setCustodian(Custodian custodian);
		CustodyArrangements.CustodyArrangementsBuilder setCustodianEvent(CustodianEvent custodianEvent);
		CustodyArrangements.CustodyArrangementsBuilder setCustodianRisk(CustodianRisk custodianRisk);
		CustodyArrangements.CustodyArrangementsBuilder setHasControlAgreementLanguage(Boolean hasControlAgreementLanguage);
		CustodyArrangements.CustodyArrangementsBuilder setIsCreditSupportDocument(Boolean isCreditSupportDocument);
		CustodyArrangements.CustodyArrangementsBuilder setOtherProvisions(String otherProvisions);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("hasControlAgreementLanguage"), Boolean.class, getHasControlAgreementLanguage(), this);
			processor.processBasic(path.newSubPath("isCreditSupportDocument"), Boolean.class, getIsCreditSupportDocument(), this);
			processor.processBasic(path.newSubPath("otherProvisions"), String.class, getOtherProvisions(), this);
			
			processRosetta(path.newSubPath("collateralAccessBreach"), processor, CollateralAccessBreach.CollateralAccessBreachBuilder.class, getCollateralAccessBreach());
			processRosetta(path.newSubPath("collateralManagementAgreeement"), processor, CollateralManagementAgreement.CollateralManagementAgreementBuilder.class, getCollateralManagementAgreeement());
			processRosetta(path.newSubPath("controlAgreement"), processor, ControlAgreement.ControlAgreementBuilder.class, getControlAgreement());
			processRosetta(path.newSubPath("custodian"), processor, Custodian.CustodianBuilder.class, getCustodian());
			processRosetta(path.newSubPath("custodianEvent"), processor, CustodianEvent.CustodianEventBuilder.class, getCustodianEvent());
			processRosetta(path.newSubPath("custodianRisk"), processor, CustodianRisk.CustodianRiskBuilder.class, getCustodianRisk());
		}
		
	}
	
	//CustodyArrangements.CustodyArrangementsImpl
	class CustodyArrangementsImpl implements CustodyArrangements {
		private final CollateralAccessBreach collateralAccessBreach;
		private final CollateralManagementAgreement collateralManagementAgreeement;
		private final ControlAgreement controlAgreement;
		private final Custodian custodian;
		private final CustodianEvent custodianEvent;
		private final CustodianRisk custodianRisk;
		private final Boolean hasControlAgreementLanguage;
		private final Boolean isCreditSupportDocument;
		private final String otherProvisions;
		
		protected CustodyArrangementsImpl(CustodyArrangements.CustodyArrangementsBuilder builder) {
			this.collateralAccessBreach = ofNullable(builder.getCollateralAccessBreach()).map(f->f.build()).orElse(null);
			this.collateralManagementAgreeement = ofNullable(builder.getCollateralManagementAgreeement()).map(f->f.build()).orElse(null);
			this.controlAgreement = ofNullable(builder.getControlAgreement()).map(f->f.build()).orElse(null);
			this.custodian = ofNullable(builder.getCustodian()).map(f->f.build()).orElse(null);
			this.custodianEvent = ofNullable(builder.getCustodianEvent()).map(f->f.build()).orElse(null);
			this.custodianRisk = ofNullable(builder.getCustodianRisk()).map(f->f.build()).orElse(null);
			this.hasControlAgreementLanguage = builder.getHasControlAgreementLanguage();
			this.isCreditSupportDocument = builder.getIsCreditSupportDocument();
			this.otherProvisions = builder.getOtherProvisions();
		}
		
		@Override
		public CollateralAccessBreach getCollateralAccessBreach() {
			return collateralAccessBreach;
		}
		
		@Override
		public CollateralManagementAgreement getCollateralManagementAgreeement() {
			return collateralManagementAgreeement;
		}
		
		@Override
		public ControlAgreement getControlAgreement() {
			return controlAgreement;
		}
		
		@Override
		public Custodian getCustodian() {
			return custodian;
		}
		
		@Override
		public CustodianEvent getCustodianEvent() {
			return custodianEvent;
		}
		
		@Override
		public CustodianRisk getCustodianRisk() {
			return custodianRisk;
		}
		
		@Override
		public Boolean getHasControlAgreementLanguage() {
			return hasControlAgreementLanguage;
		}
		
		@Override
		public Boolean getIsCreditSupportDocument() {
			return isCreditSupportDocument;
		}
		
		@Override
		public String getOtherProvisions() {
			return otherProvisions;
		}
		
		@Override
		public CustodyArrangements build() {
			return this;
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder toBuilder() {
			CustodyArrangements.CustodyArrangementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodyArrangements.CustodyArrangementsBuilder builder) {
			ofNullable(getCollateralAccessBreach()).ifPresent(builder::setCollateralAccessBreach);
			ofNullable(getCollateralManagementAgreeement()).ifPresent(builder::setCollateralManagementAgreeement);
			ofNullable(getControlAgreement()).ifPresent(builder::setControlAgreement);
			ofNullable(getCustodian()).ifPresent(builder::setCustodian);
			ofNullable(getCustodianEvent()).ifPresent(builder::setCustodianEvent);
			ofNullable(getCustodianRisk()).ifPresent(builder::setCustodianRisk);
			ofNullable(getHasControlAgreementLanguage()).ifPresent(builder::setHasControlAgreementLanguage);
			ofNullable(getIsCreditSupportDocument()).ifPresent(builder::setIsCreditSupportDocument);
			ofNullable(getOtherProvisions()).ifPresent(builder::setOtherProvisions);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodyArrangements _that = getType().cast(o);
		
			if (!Objects.equals(collateralAccessBreach, _that.getCollateralAccessBreach())) return false;
			if (!Objects.equals(collateralManagementAgreeement, _that.getCollateralManagementAgreeement())) return false;
			if (!Objects.equals(controlAgreement, _that.getControlAgreement())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(custodianEvent, _that.getCustodianEvent())) return false;
			if (!Objects.equals(custodianRisk, _that.getCustodianRisk())) return false;
			if (!Objects.equals(hasControlAgreementLanguage, _that.getHasControlAgreementLanguage())) return false;
			if (!Objects.equals(isCreditSupportDocument, _that.getIsCreditSupportDocument())) return false;
			if (!Objects.equals(otherProvisions, _that.getOtherProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralAccessBreach != null ? collateralAccessBreach.hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreeement != null ? collateralManagementAgreeement.hashCode() : 0);
			_result = 31 * _result + (controlAgreement != null ? controlAgreement.hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (custodianEvent != null ? custodianEvent.hashCode() : 0);
			_result = 31 * _result + (custodianRisk != null ? custodianRisk.hashCode() : 0);
			_result = 31 * _result + (hasControlAgreementLanguage != null ? hasControlAgreementLanguage.hashCode() : 0);
			_result = 31 * _result + (isCreditSupportDocument != null ? isCreditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (otherProvisions != null ? otherProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodyArrangements {" +
				"collateralAccessBreach=" + this.collateralAccessBreach + ", " +
				"collateralManagementAgreeement=" + this.collateralManagementAgreeement + ", " +
				"controlAgreement=" + this.controlAgreement + ", " +
				"custodian=" + this.custodian + ", " +
				"custodianEvent=" + this.custodianEvent + ", " +
				"custodianRisk=" + this.custodianRisk + ", " +
				"hasControlAgreementLanguage=" + this.hasControlAgreementLanguage + ", " +
				"isCreditSupportDocument=" + this.isCreditSupportDocument + ", " +
				"otherProvisions=" + this.otherProvisions +
			'}';
		}
	}
	
	//CustodyArrangements.CustodyArrangementsBuilderImpl
	class CustodyArrangementsBuilderImpl implements CustodyArrangements.CustodyArrangementsBuilder {
	
		protected CollateralAccessBreach.CollateralAccessBreachBuilder collateralAccessBreach;
		protected CollateralManagementAgreement.CollateralManagementAgreementBuilder collateralManagementAgreeement;
		protected ControlAgreement.ControlAgreementBuilder controlAgreement;
		protected Custodian.CustodianBuilder custodian;
		protected CustodianEvent.CustodianEventBuilder custodianEvent;
		protected CustodianRisk.CustodianRiskBuilder custodianRisk;
		protected Boolean hasControlAgreementLanguage;
		protected Boolean isCreditSupportDocument;
		protected String otherProvisions;
	
		public CustodyArrangementsBuilderImpl() {
		}
	
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder getCollateralAccessBreach() {
			return collateralAccessBreach;
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder getOrCreateCollateralAccessBreach() {
			CollateralAccessBreach.CollateralAccessBreachBuilder result;
			if (collateralAccessBreach!=null) {
				result = collateralAccessBreach;
			}
			else {
				result = collateralAccessBreach = CollateralAccessBreach.builder();
			}
			
			return result;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder getCollateralManagementAgreeement() {
			return collateralManagementAgreeement;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder getOrCreateCollateralManagementAgreeement() {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder result;
			if (collateralManagementAgreeement!=null) {
				result = collateralManagementAgreeement;
			}
			else {
				result = collateralManagementAgreeement = CollateralManagementAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder getControlAgreement() {
			return controlAgreement;
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder getOrCreateControlAgreement() {
			ControlAgreement.ControlAgreementBuilder result;
			if (controlAgreement!=null) {
				result = controlAgreement;
			}
			else {
				result = controlAgreement = ControlAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		public Custodian.CustodianBuilder getCustodian() {
			return custodian;
		}
		
		@Override
		public Custodian.CustodianBuilder getOrCreateCustodian() {
			Custodian.CustodianBuilder result;
			if (custodian!=null) {
				result = custodian;
			}
			else {
				result = custodian = Custodian.builder();
			}
			
			return result;
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder getCustodianEvent() {
			return custodianEvent;
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder getOrCreateCustodianEvent() {
			CustodianEvent.CustodianEventBuilder result;
			if (custodianEvent!=null) {
				result = custodianEvent;
			}
			else {
				result = custodianEvent = CustodianEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder getCustodianRisk() {
			return custodianRisk;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder getOrCreateCustodianRisk() {
			CustodianRisk.CustodianRiskBuilder result;
			if (custodianRisk!=null) {
				result = custodianRisk;
			}
			else {
				result = custodianRisk = CustodianRisk.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getHasControlAgreementLanguage() {
			return hasControlAgreementLanguage;
		}
		
		@Override
		public Boolean getIsCreditSupportDocument() {
			return isCreditSupportDocument;
		}
		
		@Override
		public String getOtherProvisions() {
			return otherProvisions;
		}
		
	
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCollateralAccessBreach(CollateralAccessBreach collateralAccessBreach) {
			this.collateralAccessBreach = collateralAccessBreach==null?null:collateralAccessBreach.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCollateralManagementAgreeement(CollateralManagementAgreement collateralManagementAgreeement) {
			this.collateralManagementAgreeement = collateralManagementAgreeement==null?null:collateralManagementAgreeement.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setControlAgreement(ControlAgreement controlAgreement) {
			this.controlAgreement = controlAgreement==null?null:controlAgreement.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodian(Custodian custodian) {
			this.custodian = custodian==null?null:custodian.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodianEvent(CustodianEvent custodianEvent) {
			this.custodianEvent = custodianEvent==null?null:custodianEvent.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodianRisk(CustodianRisk custodianRisk) {
			this.custodianRisk = custodianRisk==null?null:custodianRisk.toBuilder();
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setHasControlAgreementLanguage(Boolean hasControlAgreementLanguage) {
			this.hasControlAgreementLanguage = hasControlAgreementLanguage==null?null:hasControlAgreementLanguage;
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setIsCreditSupportDocument(Boolean isCreditSupportDocument) {
			this.isCreditSupportDocument = isCreditSupportDocument==null?null:isCreditSupportDocument;
			return this;
		}
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setOtherProvisions(String otherProvisions) {
			this.otherProvisions = otherProvisions==null?null:otherProvisions;
			return this;
		}
		
		@Override
		public CustodyArrangements build() {
			return new CustodyArrangements.CustodyArrangementsImpl(this);
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder prune() {
			if (collateralAccessBreach!=null && !collateralAccessBreach.prune().hasData()) collateralAccessBreach = null;
			if (collateralManagementAgreeement!=null && !collateralManagementAgreeement.prune().hasData()) collateralManagementAgreeement = null;
			if (controlAgreement!=null && !controlAgreement.prune().hasData()) controlAgreement = null;
			if (custodian!=null && !custodian.prune().hasData()) custodian = null;
			if (custodianEvent!=null && !custodianEvent.prune().hasData()) custodianEvent = null;
			if (custodianRisk!=null && !custodianRisk.prune().hasData()) custodianRisk = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralAccessBreach()!=null && getCollateralAccessBreach().hasData()) return true;
			if (getCollateralManagementAgreeement()!=null && getCollateralManagementAgreeement().hasData()) return true;
			if (getControlAgreement()!=null && getControlAgreement().hasData()) return true;
			if (getCustodian()!=null && getCustodian().hasData()) return true;
			if (getCustodianEvent()!=null && getCustodianEvent().hasData()) return true;
			if (getCustodianRisk()!=null && getCustodianRisk().hasData()) return true;
			if (getHasControlAgreementLanguage()!=null) return true;
			if (getIsCreditSupportDocument()!=null) return true;
			if (getOtherProvisions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodyArrangements.CustodyArrangementsBuilder o = (CustodyArrangements.CustodyArrangementsBuilder) other;
			
			merger.mergeRosetta(getCollateralAccessBreach(), o.getCollateralAccessBreach(), this::setCollateralAccessBreach);
			merger.mergeRosetta(getCollateralManagementAgreeement(), o.getCollateralManagementAgreeement(), this::setCollateralManagementAgreeement);
			merger.mergeRosetta(getControlAgreement(), o.getControlAgreement(), this::setControlAgreement);
			merger.mergeRosetta(getCustodian(), o.getCustodian(), this::setCustodian);
			merger.mergeRosetta(getCustodianEvent(), o.getCustodianEvent(), this::setCustodianEvent);
			merger.mergeRosetta(getCustodianRisk(), o.getCustodianRisk(), this::setCustodianRisk);
			
			merger.mergeBasic(getHasControlAgreementLanguage(), o.getHasControlAgreementLanguage(), this::setHasControlAgreementLanguage);
			merger.mergeBasic(getIsCreditSupportDocument(), o.getIsCreditSupportDocument(), this::setIsCreditSupportDocument);
			merger.mergeBasic(getOtherProvisions(), o.getOtherProvisions(), this::setOtherProvisions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodyArrangements _that = getType().cast(o);
		
			if (!Objects.equals(collateralAccessBreach, _that.getCollateralAccessBreach())) return false;
			if (!Objects.equals(collateralManagementAgreeement, _that.getCollateralManagementAgreeement())) return false;
			if (!Objects.equals(controlAgreement, _that.getControlAgreement())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(custodianEvent, _that.getCustodianEvent())) return false;
			if (!Objects.equals(custodianRisk, _that.getCustodianRisk())) return false;
			if (!Objects.equals(hasControlAgreementLanguage, _that.getHasControlAgreementLanguage())) return false;
			if (!Objects.equals(isCreditSupportDocument, _that.getIsCreditSupportDocument())) return false;
			if (!Objects.equals(otherProvisions, _that.getOtherProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralAccessBreach != null ? collateralAccessBreach.hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreeement != null ? collateralManagementAgreeement.hashCode() : 0);
			_result = 31 * _result + (controlAgreement != null ? controlAgreement.hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (custodianEvent != null ? custodianEvent.hashCode() : 0);
			_result = 31 * _result + (custodianRisk != null ? custodianRisk.hashCode() : 0);
			_result = 31 * _result + (hasControlAgreementLanguage != null ? hasControlAgreementLanguage.hashCode() : 0);
			_result = 31 * _result + (isCreditSupportDocument != null ? isCreditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (otherProvisions != null ? otherProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodyArrangementsBuilder {" +
				"collateralAccessBreach=" + this.collateralAccessBreach + ", " +
				"collateralManagementAgreeement=" + this.collateralManagementAgreeement + ", " +
				"controlAgreement=" + this.controlAgreement + ", " +
				"custodian=" + this.custodian + ", " +
				"custodianEvent=" + this.custodianEvent + ", " +
				"custodianRisk=" + this.custodianRisk + ", " +
				"hasControlAgreementLanguage=" + this.hasControlAgreementLanguage + ", " +
				"isCreditSupportDocument=" + this.isCreditSupportDocument + ", " +
				"otherProvisions=" + this.otherProvisions +
			'}';
		}
	}
}
