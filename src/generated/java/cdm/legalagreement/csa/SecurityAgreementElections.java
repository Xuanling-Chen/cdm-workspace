package cdm.legalagreement.csa;

import cdm.base.staticdata.party.Account;
import cdm.legalagreement.csa.meta.SecurityAgreementElectionsMeta;
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
 * The set of elections which specify a Security Agremeent
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityAgreementElections extends RosettaModelObject {
	SecurityAgreementElections build();
	SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder();
	
	/**
	 * Any additional amendments that might be specified by the parties to the agreement.
	 */
	String getAdditionalAmendments();
	/**
	 * Any additional terms that might be specified applicable.
	 */
	String getAdditionalBespokeTerms();
	/**
	 * The election for the Valuation of Appropriate Collateral.
	 */
	AppropriatedCollateralValuation getAppropriatedCollateralValuation();
	/**
	 * Delivery In Lieu rights
	 */
	Boolean getDeliveryInLieuRight();
	/**
	 * Enforcement Events specific to the agreement
	 */
	EnforcementEvent getEnforcementEvent();
	/**
	 * The location and language of execution to determine duty to be paid.
	 */
	ExecutionTerms getExecutionTerms();
	/**
	 * Full Discharge condition
	 */
	Boolean getFullDischarge();
	/**
	 * The jurisdiction specific terms
	 */
	JurisdictionRelatedTerms getJurisdictionRelatedTerms();
	/**
	 * The pledged account associated with the agreement
	 */
	Account getPledgedAccount();
	/**
	 * The Process Agent that might be appointed by the parties to the agreement.
	 */
	ProcessAgent getProcessAgent();
	final static SecurityAgreementElectionsMeta metaData = new SecurityAgreementElectionsMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityAgreementElections> metaData() {
		return metaData;
	} 
			
	static SecurityAgreementElections.SecurityAgreementElectionsBuilder builder() {
		return new SecurityAgreementElections.SecurityAgreementElectionsBuilderImpl();
	}
	
	default Class<? extends SecurityAgreementElections> getType() {
		return SecurityAgreementElections.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
		processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
		processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
		processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
		
		processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.class, getAppropriatedCollateralValuation());
		processRosetta(path.newSubPath("enforcementEvent"), processor, EnforcementEvent.class, getEnforcementEvent());
		processRosetta(path.newSubPath("executionTerms"), processor, ExecutionTerms.class, getExecutionTerms());
		processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.class, getJurisdictionRelatedTerms());
		processRosetta(path.newSubPath("pledgedAccount"), processor, Account.class, getPledgedAccount());
		processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.class, getProcessAgent());
	}
	
	
	interface SecurityAgreementElectionsBuilder extends SecurityAgreementElections, RosettaModelObjectBuilder {
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation();
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation();
		EnforcementEvent.EnforcementEventBuilder getOrCreateEnforcementEvent();
		EnforcementEvent.EnforcementEventBuilder getEnforcementEvent();
		ExecutionTerms.ExecutionTermsBuilder getOrCreateExecutionTerms();
		ExecutionTerms.ExecutionTermsBuilder getExecutionTerms();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms();
		Account.AccountBuilder getOrCreatePledgedAccount();
		Account.AccountBuilder getPledgedAccount();
		ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent();
		ProcessAgent.ProcessAgentBuilder getProcessAgent();
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setEnforcementEvent(EnforcementEvent enforcementEvent);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setExecutionTerms(ExecutionTerms executionTerms);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setFullDischarge(Boolean fullDischarge);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setPledgedAccount(Account pledgedAccount);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
			processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
			processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
			processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
			
			processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder.class, getAppropriatedCollateralValuation());
			processRosetta(path.newSubPath("enforcementEvent"), processor, EnforcementEvent.EnforcementEventBuilder.class, getEnforcementEvent());
			processRosetta(path.newSubPath("executionTerms"), processor, ExecutionTerms.ExecutionTermsBuilder.class, getExecutionTerms());
			processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder.class, getJurisdictionRelatedTerms());
			processRosetta(path.newSubPath("pledgedAccount"), processor, Account.AccountBuilder.class, getPledgedAccount());
			processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.ProcessAgentBuilder.class, getProcessAgent());
		}
		
	}
	
	//SecurityAgreementElections.SecurityAgreementElectionsImpl
	class SecurityAgreementElectionsImpl implements SecurityAgreementElections {
		private final String additionalAmendments;
		private final String additionalBespokeTerms;
		private final AppropriatedCollateralValuation appropriatedCollateralValuation;
		private final Boolean deliveryInLieuRight;
		private final EnforcementEvent enforcementEvent;
		private final ExecutionTerms executionTerms;
		private final Boolean fullDischarge;
		private final JurisdictionRelatedTerms jurisdictionRelatedTerms;
		private final Account pledgedAccount;
		private final ProcessAgent processAgent;
		
		protected SecurityAgreementElectionsImpl(SecurityAgreementElections.SecurityAgreementElectionsBuilder builder) {
			this.additionalAmendments = builder.getAdditionalAmendments();
			this.additionalBespokeTerms = builder.getAdditionalBespokeTerms();
			this.appropriatedCollateralValuation = ofNullable(builder.getAppropriatedCollateralValuation()).map(f->f.build()).orElse(null);
			this.deliveryInLieuRight = builder.getDeliveryInLieuRight();
			this.enforcementEvent = ofNullable(builder.getEnforcementEvent()).map(f->f.build()).orElse(null);
			this.executionTerms = ofNullable(builder.getExecutionTerms()).map(f->f.build()).orElse(null);
			this.fullDischarge = builder.getFullDischarge();
			this.jurisdictionRelatedTerms = ofNullable(builder.getJurisdictionRelatedTerms()).map(f->f.build()).orElse(null);
			this.pledgedAccount = ofNullable(builder.getPledgedAccount()).map(f->f.build()).orElse(null);
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public AppropriatedCollateralValuation getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		public EnforcementEvent getEnforcementEvent() {
			return enforcementEvent;
		}
		
		@Override
		public ExecutionTerms getExecutionTerms() {
			return executionTerms;
		}
		
		@Override
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		public JurisdictionRelatedTerms getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public Account getPledgedAccount() {
			return pledgedAccount;
		}
		
		@Override
		public ProcessAgent getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public SecurityAgreementElections build() {
			return this;
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder() {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityAgreementElections.SecurityAgreementElectionsBuilder builder) {
			ofNullable(getAdditionalAmendments()).ifPresent(builder::setAdditionalAmendments);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
			ofNullable(getAppropriatedCollateralValuation()).ifPresent(builder::setAppropriatedCollateralValuation);
			ofNullable(getDeliveryInLieuRight()).ifPresent(builder::setDeliveryInLieuRight);
			ofNullable(getEnforcementEvent()).ifPresent(builder::setEnforcementEvent);
			ofNullable(getExecutionTerms()).ifPresent(builder::setExecutionTerms);
			ofNullable(getFullDischarge()).ifPresent(builder::setFullDischarge);
			ofNullable(getJurisdictionRelatedTerms()).ifPresent(builder::setJurisdictionRelatedTerms);
			ofNullable(getPledgedAccount()).ifPresent(builder::setPledgedAccount);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(enforcementEvent, _that.getEnforcementEvent())) return false;
			if (!Objects.equals(executionTerms, _that.getExecutionTerms())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(pledgedAccount, _that.getPledgedAccount())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (enforcementEvent != null ? enforcementEvent.hashCode() : 0);
			_result = 31 * _result + (executionTerms != null ? executionTerms.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (pledgedAccount != null ? pledgedAccount.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityAgreementElections {" +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"enforcementEvent=" + this.enforcementEvent + ", " +
				"executionTerms=" + this.executionTerms + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"pledgedAccount=" + this.pledgedAccount + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}
	
	//SecurityAgreementElections.SecurityAgreementElectionsBuilderImpl
	class SecurityAgreementElectionsBuilderImpl implements SecurityAgreementElections.SecurityAgreementElectionsBuilder {
	
		protected String additionalAmendments;
		protected String additionalBespokeTerms;
		protected AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder appropriatedCollateralValuation;
		protected Boolean deliveryInLieuRight;
		protected EnforcementEvent.EnforcementEventBuilder enforcementEvent;
		protected ExecutionTerms.ExecutionTermsBuilder executionTerms;
		protected Boolean fullDischarge;
		protected JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder jurisdictionRelatedTerms;
		protected Account.AccountBuilder pledgedAccount;
		protected ProcessAgent.ProcessAgentBuilder processAgent;
	
		public SecurityAgreementElectionsBuilderImpl() {
		}
	
		@Override
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder result;
			if (appropriatedCollateralValuation!=null) {
				result = appropriatedCollateralValuation;
			}
			else {
				result = appropriatedCollateralValuation = AppropriatedCollateralValuation.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder getEnforcementEvent() {
			return enforcementEvent;
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder getOrCreateEnforcementEvent() {
			EnforcementEvent.EnforcementEventBuilder result;
			if (enforcementEvent!=null) {
				result = enforcementEvent;
			}
			else {
				result = enforcementEvent = EnforcementEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder getExecutionTerms() {
			return executionTerms;
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder getOrCreateExecutionTerms() {
			ExecutionTerms.ExecutionTermsBuilder result;
			if (executionTerms!=null) {
				result = executionTerms;
			}
			else {
				result = executionTerms = ExecutionTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder result;
			if (jurisdictionRelatedTerms!=null) {
				result = jurisdictionRelatedTerms;
			}
			else {
				result = jurisdictionRelatedTerms = JurisdictionRelatedTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public Account.AccountBuilder getPledgedAccount() {
			return pledgedAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreatePledgedAccount() {
			Account.AccountBuilder result;
			if (pledgedAccount!=null) {
				result = pledgedAccount;
			}
			else {
				result = pledgedAccount = Account.builder();
			}
			
			return result;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent() {
			ProcessAgent.ProcessAgentBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = ProcessAgent.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments) {
			this.additionalAmendments = additionalAmendments==null?null:additionalAmendments;
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms) {
			this.additionalBespokeTerms = additionalBespokeTerms==null?null:additionalBespokeTerms;
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation) {
			this.appropriatedCollateralValuation = appropriatedCollateralValuation==null?null:appropriatedCollateralValuation.toBuilder();
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight) {
			this.deliveryInLieuRight = deliveryInLieuRight==null?null:deliveryInLieuRight;
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setEnforcementEvent(EnforcementEvent enforcementEvent) {
			this.enforcementEvent = enforcementEvent==null?null:enforcementEvent.toBuilder();
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setExecutionTerms(ExecutionTerms executionTerms) {
			this.executionTerms = executionTerms==null?null:executionTerms.toBuilder();
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setFullDischarge(Boolean fullDischarge) {
			this.fullDischarge = fullDischarge==null?null:fullDischarge;
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms) {
			this.jurisdictionRelatedTerms = jurisdictionRelatedTerms==null?null:jurisdictionRelatedTerms.toBuilder();
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setPledgedAccount(Account pledgedAccount) {
			this.pledgedAccount = pledgedAccount==null?null:pledgedAccount.toBuilder();
			return this;
		}
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent) {
			this.processAgent = processAgent==null?null:processAgent.toBuilder();
			return this;
		}
		
		@Override
		public SecurityAgreementElections build() {
			return new SecurityAgreementElections.SecurityAgreementElectionsImpl(this);
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder prune() {
			if (appropriatedCollateralValuation!=null && !appropriatedCollateralValuation.prune().hasData()) appropriatedCollateralValuation = null;
			if (enforcementEvent!=null && !enforcementEvent.prune().hasData()) enforcementEvent = null;
			if (executionTerms!=null && !executionTerms.prune().hasData()) executionTerms = null;
			if (jurisdictionRelatedTerms!=null && !jurisdictionRelatedTerms.prune().hasData()) jurisdictionRelatedTerms = null;
			if (pledgedAccount!=null && !pledgedAccount.prune().hasData()) pledgedAccount = null;
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalAmendments()!=null) return true;
			if (getAdditionalBespokeTerms()!=null) return true;
			if (getAppropriatedCollateralValuation()!=null && getAppropriatedCollateralValuation().hasData()) return true;
			if (getDeliveryInLieuRight()!=null) return true;
			if (getEnforcementEvent()!=null && getEnforcementEvent().hasData()) return true;
			if (getExecutionTerms()!=null && getExecutionTerms().hasData()) return true;
			if (getFullDischarge()!=null) return true;
			if (getJurisdictionRelatedTerms()!=null && getJurisdictionRelatedTerms().hasData()) return true;
			if (getPledgedAccount()!=null && getPledgedAccount().hasData()) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder o = (SecurityAgreementElections.SecurityAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getAppropriatedCollateralValuation(), o.getAppropriatedCollateralValuation(), this::setAppropriatedCollateralValuation);
			merger.mergeRosetta(getEnforcementEvent(), o.getEnforcementEvent(), this::setEnforcementEvent);
			merger.mergeRosetta(getExecutionTerms(), o.getExecutionTerms(), this::setExecutionTerms);
			merger.mergeRosetta(getJurisdictionRelatedTerms(), o.getJurisdictionRelatedTerms(), this::setJurisdictionRelatedTerms);
			merger.mergeRosetta(getPledgedAccount(), o.getPledgedAccount(), this::setPledgedAccount);
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			
			merger.mergeBasic(getAdditionalAmendments(), o.getAdditionalAmendments(), this::setAdditionalAmendments);
			merger.mergeBasic(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::setAdditionalBespokeTerms);
			merger.mergeBasic(getDeliveryInLieuRight(), o.getDeliveryInLieuRight(), this::setDeliveryInLieuRight);
			merger.mergeBasic(getFullDischarge(), o.getFullDischarge(), this::setFullDischarge);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(enforcementEvent, _that.getEnforcementEvent())) return false;
			if (!Objects.equals(executionTerms, _that.getExecutionTerms())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(pledgedAccount, _that.getPledgedAccount())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (enforcementEvent != null ? enforcementEvent.hashCode() : 0);
			_result = 31 * _result + (executionTerms != null ? executionTerms.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (pledgedAccount != null ? pledgedAccount.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityAgreementElectionsBuilder {" +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"enforcementEvent=" + this.enforcementEvent + ", " +
				"executionTerms=" + this.executionTerms + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"pledgedAccount=" + this.pledgedAccount + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}
}
