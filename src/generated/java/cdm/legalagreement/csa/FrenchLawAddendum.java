package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.FrenchLawAddendumMeta;
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
 * A class to specify party specific elections when a Collateral Transfer Agreement is governed by French Law.
 * @version ${project.version}
 */
@RosettaClass

public interface FrenchLawAddendum extends RosettaModelObject {
	FrenchLawAddendum build();
	FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder();
	
	/**
	 * The qualification of whether the French Law Addendum is deemed applicable by the parties (True) or not (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The parties French Law Addendum Elections.
	 */
	List<? extends FrenchLawAddendumElection> getPartyElection();
	final static FrenchLawAddendumMeta metaData = new FrenchLawAddendumMeta();
	
	@Override
	default RosettaMetaData<? extends FrenchLawAddendum> metaData() {
		return metaData;
	} 
			
	static FrenchLawAddendum.FrenchLawAddendumBuilder builder() {
		return new FrenchLawAddendum.FrenchLawAddendumBuilderImpl();
	}
	
	default Class<? extends FrenchLawAddendum> getType() {
		return FrenchLawAddendum.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, FrenchLawAddendumElection.class, getPartyElection());
	}
	
	
	interface FrenchLawAddendumBuilder extends FrenchLawAddendum, RosettaModelObjectBuilder {
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> getPartyElection();
		FrenchLawAddendum.FrenchLawAddendumBuilder setIsApplicable(Boolean isApplicable);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection, int _idx);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(List<? extends FrenchLawAddendumElection> partyElection);
		FrenchLawAddendum.FrenchLawAddendumBuilder setPartyElection(List<? extends FrenchLawAddendumElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//FrenchLawAddendum.FrenchLawAddendumImpl
	class FrenchLawAddendumImpl implements FrenchLawAddendum {
		private final Boolean isApplicable;
		private final List<? extends FrenchLawAddendumElection> partyElection;
		
		protected FrenchLawAddendumImpl(FrenchLawAddendum.FrenchLawAddendumBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public List<? extends FrenchLawAddendumElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public FrenchLawAddendum build() {
			return this;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder() {
			FrenchLawAddendum.FrenchLawAddendumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FrenchLawAddendum.FrenchLawAddendumBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendum _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendum {" +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//FrenchLawAddendum.FrenchLawAddendumBuilderImpl
	class FrenchLawAddendumBuilderImpl implements FrenchLawAddendum.FrenchLawAddendumBuilder {
	
		protected Boolean isApplicable;
		protected List<FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> partyElection = new ArrayList<>();
	
		public FrenchLawAddendumBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public List<? extends FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder newPartyElection = FrenchLawAddendumElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(List<? extends FrenchLawAddendumElection> partyElections) {
			if (partyElections != null) {
				for (FrenchLawAddendumElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FrenchLawAddendum.FrenchLawAddendumBuilder setPartyElection(List<? extends FrenchLawAddendumElection> partyElections) {
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
		public FrenchLawAddendum build() {
			return new FrenchLawAddendum.FrenchLawAddendumImpl(this);
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FrenchLawAddendum.FrenchLawAddendumBuilder o = (FrenchLawAddendum.FrenchLawAddendumBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendum _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
