package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.AgreementMeta;
import cdm.legalagreement.csa.CollateralTransferAgreementElections;
import cdm.legalagreement.csa.CreditSupportAgreementElections;
import cdm.legalagreement.csa.SecurityAgreementElections;
import cdm.legalagreement.master.MasterAgreementSchedule;
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
 * Specification of the standard set of terms that define a legal agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface Agreement extends RosettaModelObject {
	Agreement build();
	Agreement.AgreementBuilder toBuilder();
	
	/**
	 * Elections to specify a Collateral Transfer Agreement.
	 */
	CollateralTransferAgreementElections getCollateralTransferAgreementElections();
	/**
	 * Elections to specify a Credit Support Annex or Credit Support Deed for Intial or Variation Margin.
	 */
	CreditSupportAgreementElections getCreditSupportAgreementElections();
	/**
	 * Elections to specify a Master Agreement Schedule.
	 */
	MasterAgreementSchedule getMasterAgreementSchedule();
	/**
	 * Elections to specify a Security agreement.
	 */
	SecurityAgreementElections getSecurityAgreementElections();
	final static AgreementMeta metaData = new AgreementMeta();
	
	@Override
	default RosettaMetaData<? extends Agreement> metaData() {
		return metaData;
	} 
			
	static Agreement.AgreementBuilder builder() {
		return new Agreement.AgreementBuilderImpl();
	}
	
	default Class<? extends Agreement> getType() {
		return Agreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("collateralTransferAgreementElections"), processor, CollateralTransferAgreementElections.class, getCollateralTransferAgreementElections());
		processRosetta(path.newSubPath("creditSupportAgreementElections"), processor, CreditSupportAgreementElections.class, getCreditSupportAgreementElections());
		processRosetta(path.newSubPath("masterAgreementSchedule"), processor, MasterAgreementSchedule.class, getMasterAgreementSchedule());
		processRosetta(path.newSubPath("securityAgreementElections"), processor, SecurityAgreementElections.class, getSecurityAgreementElections());
	}
	
	
	interface AgreementBuilder extends Agreement, RosettaModelObjectBuilder {
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder getOrCreateCollateralTransferAgreementElections();
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder getCollateralTransferAgreementElections();
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder getOrCreateCreditSupportAgreementElections();
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder getCreditSupportAgreementElections();
		MasterAgreementSchedule.MasterAgreementScheduleBuilder getOrCreateMasterAgreementSchedule();
		MasterAgreementSchedule.MasterAgreementScheduleBuilder getMasterAgreementSchedule();
		SecurityAgreementElections.SecurityAgreementElectionsBuilder getOrCreateSecurityAgreementElections();
		SecurityAgreementElections.SecurityAgreementElectionsBuilder getSecurityAgreementElections();
		Agreement.AgreementBuilder setCollateralTransferAgreementElections(CollateralTransferAgreementElections collateralTransferAgreementElections);
		Agreement.AgreementBuilder setCreditSupportAgreementElections(CreditSupportAgreementElections creditSupportAgreementElections);
		Agreement.AgreementBuilder setMasterAgreementSchedule(MasterAgreementSchedule masterAgreementSchedule);
		Agreement.AgreementBuilder setSecurityAgreementElections(SecurityAgreementElections securityAgreementElections);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("collateralTransferAgreementElections"), processor, CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder.class, getCollateralTransferAgreementElections());
			processRosetta(path.newSubPath("creditSupportAgreementElections"), processor, CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder.class, getCreditSupportAgreementElections());
			processRosetta(path.newSubPath("masterAgreementSchedule"), processor, MasterAgreementSchedule.MasterAgreementScheduleBuilder.class, getMasterAgreementSchedule());
			processRosetta(path.newSubPath("securityAgreementElections"), processor, SecurityAgreementElections.SecurityAgreementElectionsBuilder.class, getSecurityAgreementElections());
		}
		
	}
	
	//Agreement.AgreementImpl
	class AgreementImpl implements Agreement {
		private final CollateralTransferAgreementElections collateralTransferAgreementElections;
		private final CreditSupportAgreementElections creditSupportAgreementElections;
		private final MasterAgreementSchedule masterAgreementSchedule;
		private final SecurityAgreementElections securityAgreementElections;
		
		protected AgreementImpl(Agreement.AgreementBuilder builder) {
			this.collateralTransferAgreementElections = ofNullable(builder.getCollateralTransferAgreementElections()).map(f->f.build()).orElse(null);
			this.creditSupportAgreementElections = ofNullable(builder.getCreditSupportAgreementElections()).map(f->f.build()).orElse(null);
			this.masterAgreementSchedule = ofNullable(builder.getMasterAgreementSchedule()).map(f->f.build()).orElse(null);
			this.securityAgreementElections = ofNullable(builder.getSecurityAgreementElections()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CollateralTransferAgreementElections getCollateralTransferAgreementElections() {
			return collateralTransferAgreementElections;
		}
		
		@Override
		public CreditSupportAgreementElections getCreditSupportAgreementElections() {
			return creditSupportAgreementElections;
		}
		
		@Override
		public MasterAgreementSchedule getMasterAgreementSchedule() {
			return masterAgreementSchedule;
		}
		
		@Override
		public SecurityAgreementElections getSecurityAgreementElections() {
			return securityAgreementElections;
		}
		
		@Override
		public Agreement build() {
			return this;
		}
		
		@Override
		public Agreement.AgreementBuilder toBuilder() {
			Agreement.AgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Agreement.AgreementBuilder builder) {
			ofNullable(getCollateralTransferAgreementElections()).ifPresent(builder::setCollateralTransferAgreementElections);
			ofNullable(getCreditSupportAgreementElections()).ifPresent(builder::setCreditSupportAgreementElections);
			ofNullable(getMasterAgreementSchedule()).ifPresent(builder::setMasterAgreementSchedule);
			ofNullable(getSecurityAgreementElections()).ifPresent(builder::setSecurityAgreementElections);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Agreement _that = getType().cast(o);
		
			if (!Objects.equals(collateralTransferAgreementElections, _that.getCollateralTransferAgreementElections())) return false;
			if (!Objects.equals(creditSupportAgreementElections, _that.getCreditSupportAgreementElections())) return false;
			if (!Objects.equals(masterAgreementSchedule, _that.getMasterAgreementSchedule())) return false;
			if (!Objects.equals(securityAgreementElections, _that.getSecurityAgreementElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralTransferAgreementElections != null ? collateralTransferAgreementElections.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementElections != null ? creditSupportAgreementElections.hashCode() : 0);
			_result = 31 * _result + (masterAgreementSchedule != null ? masterAgreementSchedule.hashCode() : 0);
			_result = 31 * _result + (securityAgreementElections != null ? securityAgreementElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Agreement {" +
				"collateralTransferAgreementElections=" + this.collateralTransferAgreementElections + ", " +
				"creditSupportAgreementElections=" + this.creditSupportAgreementElections + ", " +
				"masterAgreementSchedule=" + this.masterAgreementSchedule + ", " +
				"securityAgreementElections=" + this.securityAgreementElections +
			'}';
		}
	}
	
	//Agreement.AgreementBuilderImpl
	class AgreementBuilderImpl implements Agreement.AgreementBuilder {
	
		protected CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder collateralTransferAgreementElections;
		protected CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder creditSupportAgreementElections;
		protected MasterAgreementSchedule.MasterAgreementScheduleBuilder masterAgreementSchedule;
		protected SecurityAgreementElections.SecurityAgreementElectionsBuilder securityAgreementElections;
	
		public AgreementBuilderImpl() {
		}
	
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder getCollateralTransferAgreementElections() {
			return collateralTransferAgreementElections;
		}
		
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder getOrCreateCollateralTransferAgreementElections() {
			CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder result;
			if (collateralTransferAgreementElections!=null) {
				result = collateralTransferAgreementElections;
			}
			else {
				result = collateralTransferAgreementElections = CollateralTransferAgreementElections.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder getCreditSupportAgreementElections() {
			return creditSupportAgreementElections;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder getOrCreateCreditSupportAgreementElections() {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder result;
			if (creditSupportAgreementElections!=null) {
				result = creditSupportAgreementElections;
			}
			else {
				result = creditSupportAgreementElections = CreditSupportAgreementElections.builder();
			}
			
			return result;
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder getMasterAgreementSchedule() {
			return masterAgreementSchedule;
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder getOrCreateMasterAgreementSchedule() {
			MasterAgreementSchedule.MasterAgreementScheduleBuilder result;
			if (masterAgreementSchedule!=null) {
				result = masterAgreementSchedule;
			}
			else {
				result = masterAgreementSchedule = MasterAgreementSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder getSecurityAgreementElections() {
			return securityAgreementElections;
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder getOrCreateSecurityAgreementElections() {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder result;
			if (securityAgreementElections!=null) {
				result = securityAgreementElections;
			}
			else {
				result = securityAgreementElections = SecurityAgreementElections.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Agreement.AgreementBuilder setCollateralTransferAgreementElections(CollateralTransferAgreementElections collateralTransferAgreementElections) {
			this.collateralTransferAgreementElections = collateralTransferAgreementElections==null?null:collateralTransferAgreementElections.toBuilder();
			return this;
		}
		@Override
		public Agreement.AgreementBuilder setCreditSupportAgreementElections(CreditSupportAgreementElections creditSupportAgreementElections) {
			this.creditSupportAgreementElections = creditSupportAgreementElections==null?null:creditSupportAgreementElections.toBuilder();
			return this;
		}
		@Override
		public Agreement.AgreementBuilder setMasterAgreementSchedule(MasterAgreementSchedule masterAgreementSchedule) {
			this.masterAgreementSchedule = masterAgreementSchedule==null?null:masterAgreementSchedule.toBuilder();
			return this;
		}
		@Override
		public Agreement.AgreementBuilder setSecurityAgreementElections(SecurityAgreementElections securityAgreementElections) {
			this.securityAgreementElections = securityAgreementElections==null?null:securityAgreementElections.toBuilder();
			return this;
		}
		
		@Override
		public Agreement build() {
			return new Agreement.AgreementImpl(this);
		}
		
		@Override
		public Agreement.AgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Agreement.AgreementBuilder prune() {
			if (collateralTransferAgreementElections!=null && !collateralTransferAgreementElections.prune().hasData()) collateralTransferAgreementElections = null;
			if (creditSupportAgreementElections!=null && !creditSupportAgreementElections.prune().hasData()) creditSupportAgreementElections = null;
			if (masterAgreementSchedule!=null && !masterAgreementSchedule.prune().hasData()) masterAgreementSchedule = null;
			if (securityAgreementElections!=null && !securityAgreementElections.prune().hasData()) securityAgreementElections = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralTransferAgreementElections()!=null && getCollateralTransferAgreementElections().hasData()) return true;
			if (getCreditSupportAgreementElections()!=null && getCreditSupportAgreementElections().hasData()) return true;
			if (getMasterAgreementSchedule()!=null && getMasterAgreementSchedule().hasData()) return true;
			if (getSecurityAgreementElections()!=null && getSecurityAgreementElections().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Agreement.AgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Agreement.AgreementBuilder o = (Agreement.AgreementBuilder) other;
			
			merger.mergeRosetta(getCollateralTransferAgreementElections(), o.getCollateralTransferAgreementElections(), this::setCollateralTransferAgreementElections);
			merger.mergeRosetta(getCreditSupportAgreementElections(), o.getCreditSupportAgreementElections(), this::setCreditSupportAgreementElections);
			merger.mergeRosetta(getMasterAgreementSchedule(), o.getMasterAgreementSchedule(), this::setMasterAgreementSchedule);
			merger.mergeRosetta(getSecurityAgreementElections(), o.getSecurityAgreementElections(), this::setSecurityAgreementElections);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Agreement _that = getType().cast(o);
		
			if (!Objects.equals(collateralTransferAgreementElections, _that.getCollateralTransferAgreementElections())) return false;
			if (!Objects.equals(creditSupportAgreementElections, _that.getCreditSupportAgreementElections())) return false;
			if (!Objects.equals(masterAgreementSchedule, _that.getMasterAgreementSchedule())) return false;
			if (!Objects.equals(securityAgreementElections, _that.getSecurityAgreementElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralTransferAgreementElections != null ? collateralTransferAgreementElections.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreementElections != null ? creditSupportAgreementElections.hashCode() : 0);
			_result = 31 * _result + (masterAgreementSchedule != null ? masterAgreementSchedule.hashCode() : 0);
			_result = 31 * _result + (securityAgreementElections != null ? securityAgreementElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementBuilder {" +
				"collateralTransferAgreementElections=" + this.collateralTransferAgreementElections + ", " +
				"creditSupportAgreementElections=" + this.creditSupportAgreementElections + ", " +
				"masterAgreementSchedule=" + this.masterAgreementSchedule + ", " +
				"securityAgreementElections=" + this.securityAgreementElections +
			'}';
		}
	}
}
