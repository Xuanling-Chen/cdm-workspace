package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.SubstitutedRegimeTermsMeta;
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
 * Specifies the applicability of the Substituted Regime as denoted in the Substituted Regime Table as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.
 * @version ${project.version}
 */
@RosettaClass

public interface SubstitutedRegimeTerms extends RosettaModelObject {
	SubstitutedRegimeTerms build();
	SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder();
	
	/**
	 * The specification of whether the regime is elected as applicable to the party when acting as collateral taker.
	 */
	Boolean getIsApplicable();
	/**
	 * The party for which the regime terms are being specified when acting as collateral taker.
	 */
	CounterpartyRoleEnum getParty();
	final static SubstitutedRegimeTermsMeta metaData = new SubstitutedRegimeTermsMeta();
	
	@Override
	default RosettaMetaData<? extends SubstitutedRegimeTerms> metaData() {
		return metaData;
	} 
			
	static SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder() {
		return new SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilderImpl();
	}
	
	default Class<? extends SubstitutedRegimeTerms> getType() {
		return SubstitutedRegimeTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
	}
	
	
	interface SubstitutedRegimeTermsBuilder extends SubstitutedRegimeTerms, RosettaModelObjectBuilder {
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setIsApplicable(Boolean isApplicable);
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
		}
		
	}
	
	//SubstitutedRegimeTerms.SubstitutedRegimeTermsImpl
	class SubstitutedRegimeTermsImpl implements SubstitutedRegimeTerms {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		
		protected SubstitutedRegimeTermsImpl(SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder) {
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
		public SubstitutedRegimeTerms build() {
			return this;
		}
		
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder() {
			SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegimeTerms _that = getType().cast(o);
		
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
			return "SubstitutedRegimeTerms {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilderImpl
	class SubstitutedRegimeTermsBuilderImpl implements SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
	
		public SubstitutedRegimeTermsBuilderImpl() {
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
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public SubstitutedRegimeTerms build() {
			return new SubstitutedRegimeTerms.SubstitutedRegimeTermsImpl(this);
		}
		
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder prune() {
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
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder o = (SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegimeTerms _that = getType().cast(o);
		
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
			return "SubstitutedRegimeTermsBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
