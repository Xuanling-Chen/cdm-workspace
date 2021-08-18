package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.HoldingAndUsingPostedCollateralElectionMeta;
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
 * A class to specify the parties&#39; elections related to the holding and using of posted collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h): Holding and Using Posted Collateral (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface HoldingAndUsingPostedCollateralElection extends RosettaModelObject {
	HoldingAndUsingPostedCollateralElection build();
	HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder();
	
	/**
	 * The specification of the conditions under which a party and its custodian(s) are entitled to hold posted collateral.
	 */
	EligibilityToHoldCollateral getEligibilityToHoldCollateral();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Specifies whether the party to the agreement has the right to rehypothecate the collateral held (True), i.e. whether the condition specified in Paragraph 6, (c) of the ISDA 2016 Credit Support Annex for Variation Margin apply. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(ii): Use of Posted Collateral (VM).
	 */
	Boolean getUseOfPostedCollateral();
	final static HoldingAndUsingPostedCollateralElectionMeta metaData = new HoldingAndUsingPostedCollateralElectionMeta();
	
	@Override
	default RosettaMetaData<? extends HoldingAndUsingPostedCollateralElection> metaData() {
		return metaData;
	} 
			
	static HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder() {
		return new HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilderImpl();
	}
	
	default Class<? extends HoldingAndUsingPostedCollateralElection> getType() {
		return HoldingAndUsingPostedCollateralElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("useOfPostedCollateral"), Boolean.class, getUseOfPostedCollateral(), this);
		
		processRosetta(path.newSubPath("eligibilityToHoldCollateral"), processor, EligibilityToHoldCollateral.class, getEligibilityToHoldCollateral());
	}
	
	
	interface HoldingAndUsingPostedCollateralElectionBuilder extends HoldingAndUsingPostedCollateralElection, RosettaModelObjectBuilder {
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getOrCreateEligibilityToHoldCollateral();
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getEligibilityToHoldCollateral();
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setEligibilityToHoldCollateral(EligibilityToHoldCollateral eligibilityToHoldCollateral);
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setParty(CounterpartyRoleEnum party);
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setUseOfPostedCollateral(Boolean useOfPostedCollateral);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("useOfPostedCollateral"), Boolean.class, getUseOfPostedCollateral(), this);
			
			processRosetta(path.newSubPath("eligibilityToHoldCollateral"), processor, EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder.class, getEligibilityToHoldCollateral());
		}
		
	}
	
	//HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionImpl
	class HoldingAndUsingPostedCollateralElectionImpl implements HoldingAndUsingPostedCollateralElection {
		private final EligibilityToHoldCollateral eligibilityToHoldCollateral;
		private final CounterpartyRoleEnum party;
		private final Boolean useOfPostedCollateral;
		
		protected HoldingAndUsingPostedCollateralElectionImpl(HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder) {
			this.eligibilityToHoldCollateral = ofNullable(builder.getEligibilityToHoldCollateral()).map(f->f.build()).orElse(null);
			this.party = builder.getParty();
			this.useOfPostedCollateral = builder.getUseOfPostedCollateral();
		}
		
		@Override
		public EligibilityToHoldCollateral getEligibilityToHoldCollateral() {
			return eligibilityToHoldCollateral;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getUseOfPostedCollateral() {
			return useOfPostedCollateral;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection build() {
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder() {
			HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder) {
			ofNullable(getEligibilityToHoldCollateral()).ifPresent(builder::setEligibilityToHoldCollateral);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getUseOfPostedCollateral()).ifPresent(builder::setUseOfPostedCollateral);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateralElection _that = getType().cast(o);
		
			if (!Objects.equals(eligibilityToHoldCollateral, _that.getEligibilityToHoldCollateral())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(useOfPostedCollateral, _that.getUseOfPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eligibilityToHoldCollateral != null ? eligibilityToHoldCollateral.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (useOfPostedCollateral != null ? useOfPostedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HoldingAndUsingPostedCollateralElection {" +
				"eligibilityToHoldCollateral=" + this.eligibilityToHoldCollateral + ", " +
				"party=" + this.party + ", " +
				"useOfPostedCollateral=" + this.useOfPostedCollateral +
			'}';
		}
	}
	
	//HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilderImpl
	class HoldingAndUsingPostedCollateralElectionBuilderImpl implements HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder {
	
		protected EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder eligibilityToHoldCollateral;
		protected CounterpartyRoleEnum party;
		protected Boolean useOfPostedCollateral;
	
		public HoldingAndUsingPostedCollateralElectionBuilderImpl() {
		}
	
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getEligibilityToHoldCollateral() {
			return eligibilityToHoldCollateral;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getOrCreateEligibilityToHoldCollateral() {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder result;
			if (eligibilityToHoldCollateral!=null) {
				result = eligibilityToHoldCollateral;
			}
			else {
				result = eligibilityToHoldCollateral = EligibilityToHoldCollateral.builder();
			}
			
			return result;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Boolean getUseOfPostedCollateral() {
			return useOfPostedCollateral;
		}
		
	
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setEligibilityToHoldCollateral(EligibilityToHoldCollateral eligibilityToHoldCollateral) {
			this.eligibilityToHoldCollateral = eligibilityToHoldCollateral==null?null:eligibilityToHoldCollateral.toBuilder();
			return this;
		}
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setUseOfPostedCollateral(Boolean useOfPostedCollateral) {
			this.useOfPostedCollateral = useOfPostedCollateral==null?null:useOfPostedCollateral;
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection build() {
			return new HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionImpl(this);
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder prune() {
			if (eligibilityToHoldCollateral!=null && !eligibilityToHoldCollateral.prune().hasData()) eligibilityToHoldCollateral = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEligibilityToHoldCollateral()!=null && getEligibilityToHoldCollateral().hasData()) return true;
			if (getParty()!=null) return true;
			if (getUseOfPostedCollateral()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder o = (HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder) other;
			
			merger.mergeRosetta(getEligibilityToHoldCollateral(), o.getEligibilityToHoldCollateral(), this::setEligibilityToHoldCollateral);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getUseOfPostedCollateral(), o.getUseOfPostedCollateral(), this::setUseOfPostedCollateral);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateralElection _that = getType().cast(o);
		
			if (!Objects.equals(eligibilityToHoldCollateral, _that.getEligibilityToHoldCollateral())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(useOfPostedCollateral, _that.getUseOfPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (eligibilityToHoldCollateral != null ? eligibilityToHoldCollateral.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (useOfPostedCollateral != null ? useOfPostedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HoldingAndUsingPostedCollateralElectionBuilder {" +
				"eligibilityToHoldCollateral=" + this.eligibilityToHoldCollateral + ", " +
				"party=" + this.party + ", " +
				"useOfPostedCollateral=" + this.useOfPostedCollateral +
			'}';
		}
	}
}
