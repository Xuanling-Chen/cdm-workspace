package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.RecalculationOfValueElectionMeta;
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
 * A class to specify Recalculation of Value terms that will be applicable
 * @version ${project.version}
 */
@RosettaClass

public interface RecalculationOfValueElection extends RosettaModelObject {
	RecalculationOfValueElection build();
	RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder();
	
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The procedure for Recalculation of Value.
	 */
	RecalculationOfValueElectionEnum getRecalculationOfValueElection();
	/**
	 * Additional Recalculation of Value terms when specified
	 */
	String getRecalculationOfValueTerms();
	final static RecalculationOfValueElectionMeta metaData = new RecalculationOfValueElectionMeta();
	
	@Override
	default RosettaMetaData<? extends RecalculationOfValueElection> metaData() {
		return metaData;
	} 
			
	static RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder() {
		return new RecalculationOfValueElection.RecalculationOfValueElectionBuilderImpl();
	}
	
	default Class<? extends RecalculationOfValueElection> getType() {
		return RecalculationOfValueElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("recalculationOfValueElection"), RecalculationOfValueElectionEnum.class, getRecalculationOfValueElection(), this);
		processor.processBasic(path.newSubPath("recalculationOfValueTerms"), String.class, getRecalculationOfValueTerms(), this);
		
	}
	
	
	interface RecalculationOfValueElectionBuilder extends RecalculationOfValueElection, RosettaModelObjectBuilder {
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setParty(CounterpartyRoleEnum party);
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueElection(RecalculationOfValueElectionEnum recalculationOfValueElection);
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueTerms(String recalculationOfValueTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("recalculationOfValueElection"), RecalculationOfValueElectionEnum.class, getRecalculationOfValueElection(), this);
			processor.processBasic(path.newSubPath("recalculationOfValueTerms"), String.class, getRecalculationOfValueTerms(), this);
			
		}
		
	}
	
	//RecalculationOfValueElection.RecalculationOfValueElectionImpl
	class RecalculationOfValueElectionImpl implements RecalculationOfValueElection {
		private final CounterpartyRoleEnum party;
		private final RecalculationOfValueElectionEnum recalculationOfValueElection;
		private final String recalculationOfValueTerms;
		
		protected RecalculationOfValueElectionImpl(RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder) {
			this.party = builder.getParty();
			this.recalculationOfValueElection = builder.getRecalculationOfValueElection();
			this.recalculationOfValueTerms = builder.getRecalculationOfValueTerms();
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public RecalculationOfValueElectionEnum getRecalculationOfValueElection() {
			return recalculationOfValueElection;
		}
		
		@Override
		public String getRecalculationOfValueTerms() {
			return recalculationOfValueTerms;
		}
		
		@Override
		public RecalculationOfValueElection build() {
			return this;
		}
		
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder() {
			RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRecalculationOfValueElection()).ifPresent(builder::setRecalculationOfValueElection);
			ofNullable(getRecalculationOfValueTerms()).ifPresent(builder::setRecalculationOfValueTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValueElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(recalculationOfValueElection, _that.getRecalculationOfValueElection())) return false;
			if (!Objects.equals(recalculationOfValueTerms, _that.getRecalculationOfValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueElection != null ? recalculationOfValueElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueTerms != null ? recalculationOfValueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecalculationOfValueElection {" +
				"party=" + this.party + ", " +
				"recalculationOfValueElection=" + this.recalculationOfValueElection + ", " +
				"recalculationOfValueTerms=" + this.recalculationOfValueTerms +
			'}';
		}
	}
	
	//RecalculationOfValueElection.RecalculationOfValueElectionBuilderImpl
	class RecalculationOfValueElectionBuilderImpl implements RecalculationOfValueElection.RecalculationOfValueElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected RecalculationOfValueElectionEnum recalculationOfValueElection;
		protected String recalculationOfValueTerms;
	
		public RecalculationOfValueElectionBuilderImpl() {
		}
	
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public RecalculationOfValueElectionEnum getRecalculationOfValueElection() {
			return recalculationOfValueElection;
		}
		
		@Override
		public String getRecalculationOfValueTerms() {
			return recalculationOfValueTerms;
		}
		
	
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueElection(RecalculationOfValueElectionEnum recalculationOfValueElection) {
			this.recalculationOfValueElection = recalculationOfValueElection==null?null:recalculationOfValueElection;
			return this;
		}
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueTerms(String recalculationOfValueTerms) {
			this.recalculationOfValueTerms = recalculationOfValueTerms==null?null:recalculationOfValueTerms;
			return this;
		}
		
		@Override
		public RecalculationOfValueElection build() {
			return new RecalculationOfValueElection.RecalculationOfValueElectionImpl(this);
		}
		
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getRecalculationOfValueElection()!=null) return true;
			if (getRecalculationOfValueTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RecalculationOfValueElection.RecalculationOfValueElectionBuilder o = (RecalculationOfValueElection.RecalculationOfValueElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRecalculationOfValueElection(), o.getRecalculationOfValueElection(), this::setRecalculationOfValueElection);
			merger.mergeBasic(getRecalculationOfValueTerms(), o.getRecalculationOfValueTerms(), this::setRecalculationOfValueTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValueElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(recalculationOfValueElection, _that.getRecalculationOfValueElection())) return false;
			if (!Objects.equals(recalculationOfValueTerms, _that.getRecalculationOfValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueElection != null ? recalculationOfValueElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueTerms != null ? recalculationOfValueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecalculationOfValueElectionBuilder {" +
				"party=" + this.party + ", " +
				"recalculationOfValueElection=" + this.recalculationOfValueElection + ", " +
				"recalculationOfValueTerms=" + this.recalculationOfValueTerms +
			'}';
		}
	}
}
