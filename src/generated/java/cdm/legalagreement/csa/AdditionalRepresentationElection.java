package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.AdditionalRepresentationElectionMeta;
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
 * A class to specify the parties&#39; Additional Representation(s) election.
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalRepresentationElection extends RosettaModelObject {
	AdditionalRepresentationElection build();
	AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder();
	
	/**
	 * The Additional Representation is applicable when True, and not applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static AdditionalRepresentationElectionMeta metaData = new AdditionalRepresentationElectionMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalRepresentationElection> metaData() {
		return metaData;
	} 
			
	static AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder() {
		return new AdditionalRepresentationElection.AdditionalRepresentationElectionBuilderImpl();
	}
	
	default Class<? extends AdditionalRepresentationElection> getType() {
		return AdditionalRepresentationElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface AdditionalRepresentationElectionBuilder extends AdditionalRepresentationElection, RosettaModelObjectBuilder {
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setIsApplicable(Boolean isApplicable);
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//AdditionalRepresentationElection.AdditionalRepresentationElectionImpl
	class AdditionalRepresentationElectionImpl implements AdditionalRepresentationElection {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		
		protected AdditionalRepresentationElectionImpl(AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public AdditionalRepresentationElection build() {
			return this;
		}
		
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder() {
			AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentationElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentationElection {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//AdditionalRepresentationElection.AdditionalRepresentationElectionBuilderImpl
	class AdditionalRepresentationElectionBuilderImpl implements AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
	
		public AdditionalRepresentationElectionBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public AdditionalRepresentationElection build() {
			return new AdditionalRepresentationElection.AdditionalRepresentationElectionImpl(this);
		}
		
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder o = (AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentationElection _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentationElectionBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
