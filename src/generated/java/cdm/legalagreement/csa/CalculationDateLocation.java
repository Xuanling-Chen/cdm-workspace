package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CalculationDateLocationMeta;
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
 * A class to specify the Calculation Date Location election for the respective parties to the legal agreement. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(i): Calculation Date Location. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(i): Calculation Date Location.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationDateLocation extends RosettaModelObject {
	CalculationDateLocation build();
	CalculationDateLocation.CalculationDateLocationBuilder toBuilder();
	
	/**
	 * The parties&#39; calculation date location election.
	 */
	List<? extends CalculationDateLocationElection> getPartyElection();
	final static CalculationDateLocationMeta metaData = new CalculationDateLocationMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationDateLocation> metaData() {
		return metaData;
	} 
			
	static CalculationDateLocation.CalculationDateLocationBuilder builder() {
		return new CalculationDateLocation.CalculationDateLocationBuilderImpl();
	}
	
	default Class<? extends CalculationDateLocation> getType() {
		return CalculationDateLocation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, CalculationDateLocationElection.class, getPartyElection());
	}
	
	
	interface CalculationDateLocationBuilder extends CalculationDateLocation, RosettaModelObjectBuilder {
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends CalculationDateLocationElection.CalculationDateLocationElectionBuilder> getPartyElection();
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection);
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection, int _idx);
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(List<? extends CalculationDateLocationElection> partyElection);
		CalculationDateLocation.CalculationDateLocationBuilder setPartyElection(List<? extends CalculationDateLocationElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, CalculationDateLocationElection.CalculationDateLocationElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//CalculationDateLocation.CalculationDateLocationImpl
	class CalculationDateLocationImpl implements CalculationDateLocation {
		private final List<? extends CalculationDateLocationElection> partyElection;
		
		protected CalculationDateLocationImpl(CalculationDateLocation.CalculationDateLocationBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CalculationDateLocationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CalculationDateLocation build() {
			return this;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder toBuilder() {
			CalculationDateLocation.CalculationDateLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationDateLocation.CalculationDateLocationBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocation {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//CalculationDateLocation.CalculationDateLocationBuilderImpl
	class CalculationDateLocationBuilderImpl implements CalculationDateLocation.CalculationDateLocationBuilder {
	
		protected List<CalculationDateLocationElection.CalculationDateLocationElectionBuilder> partyElection = new ArrayList<>();
	
		public CalculationDateLocationBuilderImpl() {
		}
	
		@Override
		public List<? extends CalculationDateLocationElection.CalculationDateLocationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			CalculationDateLocationElection.CalculationDateLocationElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						CalculationDateLocationElection.CalculationDateLocationElectionBuilder newPartyElection = CalculationDateLocationElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(List<? extends CalculationDateLocationElection> partyElections) {
			if (partyElections != null) {
				for (CalculationDateLocationElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CalculationDateLocation.CalculationDateLocationBuilder setPartyElection(List<? extends CalculationDateLocationElection> partyElections) {
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
		public CalculationDateLocation build() {
			return new CalculationDateLocation.CalculationDateLocationImpl(this);
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CalculationDateLocationElection.CalculationDateLocationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationDateLocation.CalculationDateLocationBuilder o = (CalculationDateLocation.CalculationDateLocationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocationBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
