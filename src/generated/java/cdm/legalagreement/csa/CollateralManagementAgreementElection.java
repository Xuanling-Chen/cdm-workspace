package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CollateralManagementAgreementElectionMeta;
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
 * A class to specify the Collateral Management Agreement election by each party as the Obligee. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b(i): Collateral Management Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralManagementAgreementElection extends RosettaModelObject {
	CollateralManagementAgreementElection build();
	CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder();
	
	/**
	 * The designated Collateral Management Agreement with respect to the elective party as the Obligee.
	 */
	String getCollateralManagementAgreement();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static CollateralManagementAgreementElectionMeta metaData = new CollateralManagementAgreementElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralManagementAgreementElection> metaData() {
		return metaData;
	} 
			
	static CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder() {
		return new CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilderImpl();
	}
	
	default Class<? extends CollateralManagementAgreementElection> getType() {
		return CollateralManagementAgreementElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("collateralManagementAgreement"), String.class, getCollateralManagementAgreement(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface CollateralManagementAgreementElectionBuilder extends CollateralManagementAgreementElection, RosettaModelObjectBuilder {
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setCollateralManagementAgreement(String collateralManagementAgreement);
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("collateralManagementAgreement"), String.class, getCollateralManagementAgreement(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//CollateralManagementAgreementElection.CollateralManagementAgreementElectionImpl
	class CollateralManagementAgreementElectionImpl implements CollateralManagementAgreementElection {
		private final String collateralManagementAgreement;
		private final CounterpartyRoleEnum party;
		
		protected CollateralManagementAgreementElectionImpl(CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder) {
			this.collateralManagementAgreement = builder.getCollateralManagementAgreement();
			this.party = builder.getParty();
		}
		
		@Override
		public String getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CollateralManagementAgreementElection build() {
			return this;
		}
		
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder() {
			CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder) {
			ofNullable(getCollateralManagementAgreement()).ifPresent(builder::setCollateralManagementAgreement);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreementElection _that = getType().cast(o);
		
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralManagementAgreementElection {" +
				"collateralManagementAgreement=" + this.collateralManagementAgreement + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilderImpl
	class CollateralManagementAgreementElectionBuilderImpl implements CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder {
	
		protected String collateralManagementAgreement;
		protected CounterpartyRoleEnum party;
	
		public CollateralManagementAgreementElectionBuilderImpl() {
		}
	
		@Override
		public String getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setCollateralManagementAgreement(String collateralManagementAgreement) {
			this.collateralManagementAgreement = collateralManagementAgreement==null?null:collateralManagementAgreement;
			return this;
		}
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public CollateralManagementAgreementElection build() {
			return new CollateralManagementAgreementElection.CollateralManagementAgreementElectionImpl(this);
		}
		
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralManagementAgreement()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder o = (CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder) other;
			
			
			merger.mergeBasic(getCollateralManagementAgreement(), o.getCollateralManagementAgreement(), this::setCollateralManagementAgreement);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreementElection _that = getType().cast(o);
		
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralManagementAgreementElectionBuilder {" +
				"collateralManagementAgreement=" + this.collateralManagementAgreement + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
