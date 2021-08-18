package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.MinimumTransferAmountAmendmentMeta;
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
 *  A class to specify whether Amendment to Minimum Transfer Amount language is applicable or not
 * @version ${project.version}
 */
@RosettaClass

public interface MinimumTransferAmountAmendment extends RosettaModelObject {
	MinimumTransferAmountAmendment build();
	MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder();
	
	/**
	 * The effective date of the Amendment to Termination Currency.
	 */
	AmendmentEffectiveDate getEffectiveDate();
	/**
	 * The definition of Minimum Transfer Amount in any Other Regulatory CSA will be amended when applicable.
	 */
	Boolean getIsApplicable();
	/**
	 * The party elective amounts.
	 */
	List<? extends ElectiveAmountElection> getPartyElections();
	final static MinimumTransferAmountAmendmentMeta metaData = new MinimumTransferAmountAmendmentMeta();
	
	@Override
	default RosettaMetaData<? extends MinimumTransferAmountAmendment> metaData() {
		return metaData;
	} 
			
	static MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder() {
		return new MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilderImpl();
	}
	
	default Class<? extends MinimumTransferAmountAmendment> getType() {
		return MinimumTransferAmountAmendment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("partyElections"), processor, ElectiveAmountElection.class, getPartyElections());
	}
	
	
	interface MinimumTransferAmountAmendmentBuilder extends MinimumTransferAmountAmendment, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate();
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate();
		ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElections(int _index);
		List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElections();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setIsApplicable(Boolean isApplicable);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections, int _idx);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(List<? extends ElectiveAmountElection> partyElections);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setPartyElections(List<? extends ElectiveAmountElection> partyElections);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.AmendmentEffectiveDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("partyElections"), processor, ElectiveAmountElection.ElectiveAmountElectionBuilder.class, getPartyElections());
		}
		
	}
	
	//MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentImpl
	class MinimumTransferAmountAmendmentImpl implements MinimumTransferAmountAmendment {
		private final AmendmentEffectiveDate effectiveDate;
		private final Boolean isApplicable;
		private final List<? extends ElectiveAmountElection> partyElections;
		
		protected MinimumTransferAmountAmendmentImpl(MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.isApplicable = builder.getIsApplicable();
			this.partyElections = ofNullable(builder.getPartyElections()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public List<? extends ElectiveAmountElection> getPartyElections() {
			return partyElections;
		}
		
		@Override
		public MinimumTransferAmountAmendment build() {
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder() {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPartyElections()).ifPresent(builder::setPartyElections);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmountAmendment _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MinimumTransferAmountAmendment {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElections=" + this.partyElections +
			'}';
		}
	}
	
	//MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilderImpl
	class MinimumTransferAmountAmendmentBuilderImpl implements MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder {
	
		protected AmendmentEffectiveDate.AmendmentEffectiveDateBuilder effectiveDate;
		protected Boolean isApplicable;
		protected List<ElectiveAmountElection.ElectiveAmountElectionBuilder> partyElections = new ArrayList<>();
	
		public MinimumTransferAmountAmendmentBuilderImpl() {
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
		public List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElections() {
			return partyElections;
		}
		
		public ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElections(int _index) {
		
			if (partyElections==null) {
				this.partyElections = new ArrayList<>();
			}
			ElectiveAmountElection.ElectiveAmountElectionBuilder result;
			return getIndex(partyElections, _index, () -> {
						ElectiveAmountElection.ElectiveAmountElectionBuilder newPartyElections = ElectiveAmountElection.builder();
						return newPartyElections;
					});
		}
		
	
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections) {
			if (partyElections!=null) this.partyElections.add(partyElections.toBuilder());
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections, int _idx) {
			getIndex(this.partyElections, _idx, () -> partyElections.toBuilder());
			return this;
		}
		@Override 
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(List<? extends ElectiveAmountElection> partyElectionss) {
			if (partyElectionss != null) {
				for (ElectiveAmountElection toAdd : partyElectionss) {
					this.partyElections.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setPartyElections(List<? extends ElectiveAmountElection> partyElectionss) {
			if (partyElectionss == null)  {
				this.partyElections = new ArrayList<>();
			}
			else {
				this.partyElections = partyElectionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public MinimumTransferAmountAmendment build() {
			return new MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentImpl(this);
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			partyElections = partyElections.stream().filter(b->b!=null).<ElectiveAmountElection.ElectiveAmountElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getIsApplicable()!=null) return true;
			if (getPartyElections()!=null && getPartyElections().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder o = (MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getPartyElections(), o.getPartyElections(), this::getOrCreatePartyElections);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmountAmendment _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MinimumTransferAmountAmendmentBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElections=" + this.partyElections +
			'}';
		}
	}
}
