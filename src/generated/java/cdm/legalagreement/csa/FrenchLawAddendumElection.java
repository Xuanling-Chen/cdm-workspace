package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.FrenchLawAddendumElectionMeta;
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
 * A class to specify party specific French Law Addendum language
 * @version ${project.version}
 */
@RosettaClass

public interface FrenchLawAddendumElection extends RosettaModelObject {
	FrenchLawAddendumElection build();
	FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder();
	
	/**
	 * The party specific language to be included in the agreement.
	 */
	String getAddendumLanguage();
	/**
	 * The qualification of whether the party elects specific language
	 */
	Boolean getIsApplicable();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static FrenchLawAddendumElectionMeta metaData = new FrenchLawAddendumElectionMeta();
	
	@Override
	default RosettaMetaData<? extends FrenchLawAddendumElection> metaData() {
		return metaData;
	} 
			
	static FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder() {
		return new FrenchLawAddendumElection.FrenchLawAddendumElectionBuilderImpl();
	}
	
	default Class<? extends FrenchLawAddendumElection> getType() {
		return FrenchLawAddendumElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("addendumLanguage"), String.class, getAddendumLanguage(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface FrenchLawAddendumElectionBuilder extends FrenchLawAddendumElection, RosettaModelObjectBuilder {
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setAddendumLanguage(String addendumLanguage);
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setIsApplicable(Boolean isApplicable);
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("addendumLanguage"), String.class, getAddendumLanguage(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//FrenchLawAddendumElection.FrenchLawAddendumElectionImpl
	class FrenchLawAddendumElectionImpl implements FrenchLawAddendumElection {
		private final String addendumLanguage;
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		
		protected FrenchLawAddendumElectionImpl(FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder) {
			this.addendumLanguage = builder.getAddendumLanguage();
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
		}
		
		@Override
		public String getAddendumLanguage() {
			return addendumLanguage;
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
		public FrenchLawAddendumElection build() {
			return this;
		}
		
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder() {
			FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder) {
			ofNullable(getAddendumLanguage()).ifPresent(builder::setAddendumLanguage);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendumElection _that = getType().cast(o);
		
			if (!Objects.equals(addendumLanguage, _that.getAddendumLanguage())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (addendumLanguage != null ? addendumLanguage.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumElection {" +
				"addendumLanguage=" + this.addendumLanguage + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//FrenchLawAddendumElection.FrenchLawAddendumElectionBuilderImpl
	class FrenchLawAddendumElectionBuilderImpl implements FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder {
	
		protected String addendumLanguage;
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
	
		public FrenchLawAddendumElectionBuilderImpl() {
		}
	
		@Override
		public String getAddendumLanguage() {
			return addendumLanguage;
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
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setAddendumLanguage(String addendumLanguage) {
			this.addendumLanguage = addendumLanguage==null?null:addendumLanguage;
			return this;
		}
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public FrenchLawAddendumElection build() {
			return new FrenchLawAddendumElection.FrenchLawAddendumElectionImpl(this);
		}
		
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAddendumLanguage()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder o = (FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder) other;
			
			
			merger.mergeBasic(getAddendumLanguage(), o.getAddendumLanguage(), this::setAddendumLanguage);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendumElection _that = getType().cast(o);
		
			if (!Objects.equals(addendumLanguage, _that.getAddendumLanguage())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (addendumLanguage != null ? addendumLanguage.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumElectionBuilder {" +
				"addendumLanguage=" + this.addendumLanguage + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
