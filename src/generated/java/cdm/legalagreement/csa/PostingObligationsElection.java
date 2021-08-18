package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.PostingObligationsElectionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the collateral posting obligations for the security provider party(ies), for example, as specified under the terms of the ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii).
 * @version ${project.version}
 */
@RosettaClass

public interface PostingObligationsElection extends RosettaModelObject {
	PostingObligationsElection build();
	PostingObligationsElection.PostingObligationsElectionBuilder toBuilder();
	
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();
	/**
	 * If set to True, the Control Agreement is a Credit Support Document with respect to the party(ies). ISDA 2016 Credit Support Annex for Initial Margin, paragraph 6, (e).
	 */
	Boolean getAsPermitted();
	/**
	 * The eligible collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation. ISDA 2016 Credit Support Annex for Initial Margin, Eligible Credit Support (IM) Schedule.
	 */
	List<? extends EligibleCollateralSchedule> getEligibleCollateral();
	/**
	 * The excluded collateral as specified in relation to the pledgor/chargor/obligor(s) posting obligation. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii)(B)(i).
	 */
	String getExcludedCollateral();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static PostingObligationsElectionMeta metaData = new PostingObligationsElectionMeta();
	
	@Override
	default RosettaMetaData<? extends PostingObligationsElection> metaData() {
		return metaData;
	} 
			
	static PostingObligationsElection.PostingObligationsElectionBuilder builder() {
		return new PostingObligationsElection.PostingObligationsElectionBuilderImpl();
	}
	
	default Class<? extends PostingObligationsElection> getType() {
		return PostingObligationsElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		processor.processBasic(path.newSubPath("asPermitted"), Boolean.class, getAsPermitted(), this);
		processor.processBasic(path.newSubPath("excludedCollateral"), String.class, getExcludedCollateral(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralSchedule.class, getEligibleCollateral());
	}
	
	
	interface PostingObligationsElectionBuilder extends PostingObligationsElection, RosettaModelObjectBuilder {
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder getOrCreateEligibleCollateral(int _index);
		List<? extends EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> getEligibleCollateral();
		PostingObligationsElection.PostingObligationsElectionBuilder setAdditionalLanguage(String additionalLanguage);
		PostingObligationsElection.PostingObligationsElectionBuilder setAsPermitted(Boolean asPermitted);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral, int _idx);
		PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setExcludedCollateral(String excludedCollateral);
		PostingObligationsElection.PostingObligationsElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
			processor.processBasic(path.newSubPath("asPermitted"), Boolean.class, getAsPermitted(), this);
			processor.processBasic(path.newSubPath("excludedCollateral"), String.class, getExcludedCollateral(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("eligibleCollateral"), processor, EligibleCollateralSchedule.EligibleCollateralScheduleBuilder.class, getEligibleCollateral());
		}
		
	}
	
	//PostingObligationsElection.PostingObligationsElectionImpl
	class PostingObligationsElectionImpl implements PostingObligationsElection {
		private final String additionalLanguage;
		private final Boolean asPermitted;
		private final List<? extends EligibleCollateralSchedule> eligibleCollateral;
		private final String excludedCollateral;
		private final CounterpartyRoleEnum party;
		
		protected PostingObligationsElectionImpl(PostingObligationsElection.PostingObligationsElectionBuilder builder) {
			this.additionalLanguage = builder.getAdditionalLanguage();
			this.asPermitted = builder.getAsPermitted();
			this.eligibleCollateral = ofNullable(builder.getEligibleCollateral()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.excludedCollateral = builder.getExcludedCollateral();
			this.party = builder.getParty();
		}
		
		@Override
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public Boolean getAsPermitted() {
			return asPermitted;
		}
		
		@Override
		public List<? extends EligibleCollateralSchedule> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		@Override
		public String getExcludedCollateral() {
			return excludedCollateral;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public PostingObligationsElection build() {
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder toBuilder() {
			PostingObligationsElection.PostingObligationsElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostingObligationsElection.PostingObligationsElectionBuilder builder) {
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
			ofNullable(getAsPermitted()).ifPresent(builder::setAsPermitted);
			ofNullable(getEligibleCollateral()).ifPresent(builder::setEligibleCollateral);
			ofNullable(getExcludedCollateral()).ifPresent(builder::setExcludedCollateral);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligationsElection _that = getType().cast(o);
		
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			if (!Objects.equals(asPermitted, _that.getAsPermitted())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(excludedCollateral, _that.getExcludedCollateral())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			_result = 31 * _result + (asPermitted != null ? asPermitted.hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (excludedCollateral != null ? excludedCollateral.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligationsElection {" +
				"additionalLanguage=" + this.additionalLanguage + ", " +
				"asPermitted=" + this.asPermitted + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"excludedCollateral=" + this.excludedCollateral + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//PostingObligationsElection.PostingObligationsElectionBuilderImpl
	class PostingObligationsElectionBuilderImpl implements PostingObligationsElection.PostingObligationsElectionBuilder {
	
		protected String additionalLanguage;
		protected Boolean asPermitted;
		protected List<EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> eligibleCollateral = new ArrayList<>();
		protected String excludedCollateral;
		protected CounterpartyRoleEnum party;
	
		public PostingObligationsElectionBuilderImpl() {
		}
	
		@Override
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public Boolean getAsPermitted() {
			return asPermitted;
		}
		
		@Override
		public List<? extends EligibleCollateralSchedule.EligibleCollateralScheduleBuilder> getEligibleCollateral() {
			return eligibleCollateral;
		}
		
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder getOrCreateEligibleCollateral(int _index) {
		
			if (eligibleCollateral==null) {
				this.eligibleCollateral = new ArrayList<>();
			}
			EligibleCollateralSchedule.EligibleCollateralScheduleBuilder result;
			return getIndex(eligibleCollateral, _index, () -> {
						EligibleCollateralSchedule.EligibleCollateralScheduleBuilder newEligibleCollateral = EligibleCollateralSchedule.builder();
						return newEligibleCollateral;
					});
		}
		
		@Override
		public String getExcludedCollateral() {
			return excludedCollateral;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setAdditionalLanguage(String additionalLanguage) {
			this.additionalLanguage = additionalLanguage==null?null:additionalLanguage;
			return this;
		}
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setAsPermitted(Boolean asPermitted) {
			this.asPermitted = asPermitted==null?null:asPermitted;
			return this;
		}
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral) {
			if (eligibleCollateral!=null) this.eligibleCollateral.add(eligibleCollateral.toBuilder());
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(EligibleCollateralSchedule eligibleCollateral, int _idx) {
			getIndex(this.eligibleCollateral, _idx, () -> eligibleCollateral.toBuilder());
			return this;
		}
		@Override 
		public PostingObligationsElection.PostingObligationsElectionBuilder addEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollaterals) {
			if (eligibleCollaterals != null) {
				for (EligibleCollateralSchedule toAdd : eligibleCollaterals) {
					this.eligibleCollateral.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PostingObligationsElection.PostingObligationsElectionBuilder setEligibleCollateral(List<? extends EligibleCollateralSchedule> eligibleCollaterals) {
			if (eligibleCollaterals == null)  {
				this.eligibleCollateral = new ArrayList<>();
			}
			else {
				this.eligibleCollateral = eligibleCollaterals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setExcludedCollateral(String excludedCollateral) {
			this.excludedCollateral = excludedCollateral==null?null:excludedCollateral;
			return this;
		}
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public PostingObligationsElection build() {
			return new PostingObligationsElection.PostingObligationsElectionImpl(this);
		}
		
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder prune() {
			eligibleCollateral = eligibleCollateral.stream().filter(b->b!=null).<EligibleCollateralSchedule.EligibleCollateralScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalLanguage()!=null) return true;
			if (getAsPermitted()!=null) return true;
			if (getEligibleCollateral()!=null && getEligibleCollateral().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExcludedCollateral()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligationsElection.PostingObligationsElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostingObligationsElection.PostingObligationsElectionBuilder o = (PostingObligationsElection.PostingObligationsElectionBuilder) other;
			
			merger.mergeRosetta(getEligibleCollateral(), o.getEligibleCollateral(), this::getOrCreateEligibleCollateral);
			
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			merger.mergeBasic(getAsPermitted(), o.getAsPermitted(), this::setAsPermitted);
			merger.mergeBasic(getExcludedCollateral(), o.getExcludedCollateral(), this::setExcludedCollateral);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligationsElection _that = getType().cast(o);
		
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			if (!Objects.equals(asPermitted, _that.getAsPermitted())) return false;
			if (!ListEquals.listEquals(eligibleCollateral, _that.getEligibleCollateral())) return false;
			if (!Objects.equals(excludedCollateral, _that.getExcludedCollateral())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			_result = 31 * _result + (asPermitted != null ? asPermitted.hashCode() : 0);
			_result = 31 * _result + (eligibleCollateral != null ? eligibleCollateral.hashCode() : 0);
			_result = 31 * _result + (excludedCollateral != null ? excludedCollateral.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligationsElectionBuilder {" +
				"additionalLanguage=" + this.additionalLanguage + ", " +
				"asPermitted=" + this.asPermitted + ", " +
				"eligibleCollateral=" + this.eligibleCollateral + ", " +
				"excludedCollateral=" + this.excludedCollateral + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
