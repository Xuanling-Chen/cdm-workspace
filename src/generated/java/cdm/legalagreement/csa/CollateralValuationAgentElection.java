package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.CollateralValuationAgentElectionMeta;
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
 * A class to specify Collateral Valuation Agent language.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralValuationAgentElection extends RosettaModelObject {
	CollateralValuationAgentElection build();
	CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder();
	
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static CollateralValuationAgentElectionMeta metaData = new CollateralValuationAgentElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralValuationAgentElection> metaData() {
		return metaData;
	} 
			
	static CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder() {
		return new CollateralValuationAgentElection.CollateralValuationAgentElectionBuilderImpl();
	}
	
	default Class<? extends CollateralValuationAgentElection> getType() {
		return CollateralValuationAgentElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface CollateralValuationAgentElectionBuilder extends CollateralValuationAgentElection, RosettaModelObjectBuilder {
		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setAdditionalLanguage(String additionalLanguage);
		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//CollateralValuationAgentElection.CollateralValuationAgentElectionImpl
	class CollateralValuationAgentElectionImpl implements CollateralValuationAgentElection {
		private final String additionalLanguage;
		private final CounterpartyRoleEnum party;
		
		protected CollateralValuationAgentElectionImpl(CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder) {
			this.additionalLanguage = builder.getAdditionalLanguage();
			this.party = builder.getParty();
		}
		
		@Override
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CollateralValuationAgentElection build() {
			return this;
		}
		
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder() {
			CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder) {
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationAgentElection {" +
				"additionalLanguage=" + this.additionalLanguage + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CollateralValuationAgentElection.CollateralValuationAgentElectionBuilderImpl
	class CollateralValuationAgentElectionBuilderImpl implements CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder {
	
		protected String additionalLanguage;
		protected CounterpartyRoleEnum party;
	
		public CollateralValuationAgentElectionBuilderImpl() {
		}
	
		@Override
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setAdditionalLanguage(String additionalLanguage) {
			this.additionalLanguage = additionalLanguage==null?null:additionalLanguage;
			return this;
		}
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public CollateralValuationAgentElection build() {
			return new CollateralValuationAgentElection.CollateralValuationAgentElectionImpl(this);
		}
		
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalLanguage()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder o = (CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder) other;
			
			
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationAgentElectionBuilder {" +
				"additionalLanguage=" + this.additionalLanguage + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
