package cdm.legalagreement.master;

import cdm.base.staticdata.party.Party;
import cdm.legalagreement.master.meta.AutomaticEarlyTerminationElectionMeta;
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
 * A class to specify the party elections specific to the Automatic Early Termination Clause.
 * @version ${project.version}
 */
@RosettaClass

public interface AutomaticEarlyTerminationElection extends RosettaModelObject {
	AutomaticEarlyTerminationElection build();
	AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder();
	
	/**
	 * A boolean election to specify whether the Automatic Early Termination provisions of Section 6(a) are applicable (True) or not applicable (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The party for which the Automatic Early Termination provisions are being specified.
	 */
	Party getParty();
	final static AutomaticEarlyTerminationElectionMeta metaData = new AutomaticEarlyTerminationElectionMeta();
	
	@Override
	default RosettaMetaData<? extends AutomaticEarlyTerminationElection> metaData() {
		return metaData;
	} 
			
	static AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder() {
		return new AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilderImpl();
	}
	
	default Class<? extends AutomaticEarlyTerminationElection> getType() {
		return AutomaticEarlyTerminationElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	
	
	interface AutomaticEarlyTerminationElectionBuilder extends AutomaticEarlyTerminationElection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setIsApplicable(Boolean isApplicable);
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setParty(Party party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		
	}
	
	//AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionImpl
	class AutomaticEarlyTerminationElectionImpl implements AutomaticEarlyTerminationElection {
		private final Boolean isApplicable;
		private final Party party;
		
		protected AutomaticEarlyTerminationElectionImpl(AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public Party getParty() {
			return party;
		}
		
		@Override
		public AutomaticEarlyTerminationElection build() {
			return this;
		}
		
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder() {
			AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTerminationElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationElection {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilderImpl
	class AutomaticEarlyTerminationElectionBuilderImpl implements AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder {
	
		protected Boolean isApplicable;
		protected Party.PartyBuilder party;
	
		public AutomaticEarlyTerminationElectionBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		
		@Override
		public AutomaticEarlyTerminationElection build() {
			return new AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionImpl(this);
		}
		
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder o = (AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTerminationElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationElectionBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
