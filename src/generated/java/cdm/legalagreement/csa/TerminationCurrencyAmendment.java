package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.TerminationCurrencyAmendmentMeta;
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
 * A class to specify the Amendment to Termination Currency elections by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (t): Amendment to Termination Currency.
 * @version ${project.version}
 */
@RosettaClass

public interface TerminationCurrencyAmendment extends RosettaModelObject {
	TerminationCurrencyAmendment build();
	TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder();
	
	/**
	 * The effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision.
	 */
	AmendmentEffectiveDate getEffectiveDate();
	/**
	 * The qualification of whether the Amendment to Termination Currency is deemed applicable by the parties (True) or not (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The parties&#39; Amendment Currency election.
	 */
	List<? extends TerminationCurrencyElection> getPartyElection();
	final static TerminationCurrencyAmendmentMeta metaData = new TerminationCurrencyAmendmentMeta();
	
	@Override
	default RosettaMetaData<? extends TerminationCurrencyAmendment> metaData() {
		return metaData;
	} 
			
	static TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder() {
		return new TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilderImpl();
	}
	
	default Class<? extends TerminationCurrencyAmendment> getType() {
		return TerminationCurrencyAmendment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("partyElection"), processor, TerminationCurrencyElection.class, getPartyElection());
	}
	
	
	interface TerminationCurrencyAmendmentBuilder extends TerminationCurrencyAmendment, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate();
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate();
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends TerminationCurrencyElection.TerminationCurrencyElectionBuilder> getPartyElection();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setIsApplicable(Boolean isApplicable);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection, int _idx);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(List<? extends TerminationCurrencyElection> partyElection);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setPartyElection(List<? extends TerminationCurrencyElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.AmendmentEffectiveDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("partyElection"), processor, TerminationCurrencyElection.TerminationCurrencyElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//TerminationCurrencyAmendment.TerminationCurrencyAmendmentImpl
	class TerminationCurrencyAmendmentImpl implements TerminationCurrencyAmendment {
		private final AmendmentEffectiveDate effectiveDate;
		private final Boolean isApplicable;
		private final List<? extends TerminationCurrencyElection> partyElection;
		
		protected TerminationCurrencyAmendmentImpl(TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.isApplicable = builder.getIsApplicable();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public AmendmentEffectiveDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public List<? extends TerminationCurrencyElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public TerminationCurrencyAmendment build() {
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder() {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyAmendment _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyAmendment {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilderImpl
	class TerminationCurrencyAmendmentBuilderImpl implements TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder {
	
		protected AmendmentEffectiveDate.AmendmentEffectiveDateBuilder effectiveDate;
		protected Boolean isApplicable;
		protected List<TerminationCurrencyElection.TerminationCurrencyElectionBuilder> partyElection = new ArrayList<>();
	
		public TerminationCurrencyAmendmentBuilderImpl() {
		}
	
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate() {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AmendmentEffectiveDate.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public List<? extends TerminationCurrencyElection.TerminationCurrencyElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			TerminationCurrencyElection.TerminationCurrencyElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						TerminationCurrencyElection.TerminationCurrencyElectionBuilder newPartyElection = TerminationCurrencyElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(List<? extends TerminationCurrencyElection> partyElections) {
			if (partyElections != null) {
				for (TerminationCurrencyElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setPartyElection(List<? extends TerminationCurrencyElection> partyElections) {
			if (partyElections == null)  {
				this.partyElection = new ArrayList<>();
			}
			else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TerminationCurrencyAmendment build() {
			return new TerminationCurrencyAmendment.TerminationCurrencyAmendmentImpl(this);
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			partyElection = partyElection.stream().filter(b->b!=null).<TerminationCurrencyElection.TerminationCurrencyElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getIsApplicable()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder o = (TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyAmendment _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyAmendmentBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
