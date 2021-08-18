package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CustodianRiskElectionMeta;
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
 * A class to specify the Custodian Risk (English Law and New York Law ISDA CSA) and the Collateral Manager Risk (Japanese Law ISDA CSA) election. | ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk. | ISDA 2018 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (m)(i): Collateral Manager Risk. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii): Custodian (IM) Risk.
 * @version ${project.version}
 */
@RosettaClass

public interface CustodianRiskElection extends RosettaModelObject {
	CustodianRiskElection build();
	CustodianRiskElection.CustodianRiskElectionBuilder toBuilder();
	
	/**
	 * The qualification as to whether the risk is deemed as Specified.
	 */
	Boolean getIsSpecified();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The Custodian Risk (English Law and New York Law ISDA CSA) or Collateral Manager Risk (Japanese Law ISDA CSA) qualification. This attribute is optional because the Custodian Risk provision can be deemed as &#39;Specified&#39;, although not be qualified through this attribute.
	 */
	String getQualification();
	final static CustodianRiskElectionMeta metaData = new CustodianRiskElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CustodianRiskElection> metaData() {
		return metaData;
	} 
			
	static CustodianRiskElection.CustodianRiskElectionBuilder builder() {
		return new CustodianRiskElection.CustodianRiskElectionBuilderImpl();
	}
	
	default Class<? extends CustodianRiskElection> getType() {
		return CustodianRiskElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
		
	}
	
	
	interface CustodianRiskElectionBuilder extends CustodianRiskElection, RosettaModelObjectBuilder {
		CustodianRiskElection.CustodianRiskElectionBuilder setIsSpecified(Boolean isSpecified);
		CustodianRiskElection.CustodianRiskElectionBuilder setParty(CounterpartyRoleEnum party);
		CustodianRiskElection.CustodianRiskElectionBuilder setQualification(String qualification);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
			
		}
		
	}
	
	//CustodianRiskElection.CustodianRiskElectionImpl
	class CustodianRiskElectionImpl implements CustodianRiskElection {
		private final Boolean isSpecified;
		private final CounterpartyRoleEnum party;
		private final String qualification;
		
		protected CustodianRiskElectionImpl(CustodianRiskElection.CustodianRiskElectionBuilder builder) {
			this.isSpecified = builder.getIsSpecified();
			this.party = builder.getParty();
			this.qualification = builder.getQualification();
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public String getQualification() {
			return qualification;
		}
		
		@Override
		public CustodianRiskElection build() {
			return this;
		}
		
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder toBuilder() {
			CustodianRiskElection.CustodianRiskElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianRiskElection.CustodianRiskElectionBuilder builder) {
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getQualification()).ifPresent(builder::setQualification);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRiskElection _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianRiskElection {" +
				"isSpecified=" + this.isSpecified + ", " +
				"party=" + this.party + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}
	
	//CustodianRiskElection.CustodianRiskElectionBuilderImpl
	class CustodianRiskElectionBuilderImpl implements CustodianRiskElection.CustodianRiskElectionBuilder {
	
		protected Boolean isSpecified;
		protected CounterpartyRoleEnum party;
		protected String qualification;
	
		public CustodianRiskElectionBuilderImpl() {
		}
	
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public String getQualification() {
			return qualification;
		}
		
	
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setIsSpecified(Boolean isSpecified) {
			this.isSpecified = isSpecified==null?null:isSpecified;
			return this;
		}
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setQualification(String qualification) {
			this.qualification = qualification==null?null:qualification;
			return this;
		}
		
		@Override
		public CustodianRiskElection build() {
			return new CustodianRiskElection.CustodianRiskElectionImpl(this);
		}
		
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsSpecified()!=null) return true;
			if (getParty()!=null) return true;
			if (getQualification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianRiskElection.CustodianRiskElectionBuilder o = (CustodianRiskElection.CustodianRiskElectionBuilder) other;
			
			
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getQualification(), o.getQualification(), this::setQualification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRiskElection _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianRiskElectionBuilder {" +
				"isSpecified=" + this.isSpecified + ", " +
				"party=" + this.party + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}
}
