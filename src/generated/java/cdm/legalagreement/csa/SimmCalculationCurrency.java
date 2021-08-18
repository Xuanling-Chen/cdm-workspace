package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SimmCalculationCurrencyMeta;
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
 * A class to specify the SIMM Calculation Currency elections by each party to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface SimmCalculationCurrency extends RosettaModelObject {
	SimmCalculationCurrency build();
	SimmCalculationCurrency.SimmCalculationCurrencyBuilder toBuilder();
	
	/**
	 * The parties&#39; SIMM Calculation Currency election.
	 */
	List<? extends CalculationCurrencyElection> getPartyElection();
	final static SimmCalculationCurrencyMeta metaData = new SimmCalculationCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends SimmCalculationCurrency> metaData() {
		return metaData;
	} 
			
	static SimmCalculationCurrency.SimmCalculationCurrencyBuilder builder() {
		return new SimmCalculationCurrency.SimmCalculationCurrencyBuilderImpl();
	}
	
	default Class<? extends SimmCalculationCurrency> getType() {
		return SimmCalculationCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, CalculationCurrencyElection.class, getPartyElection());
	}
	
	
	interface SimmCalculationCurrencyBuilder extends SimmCalculationCurrency, RosettaModelObjectBuilder {
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends CalculationCurrencyElection.CalculationCurrencyElectionBuilder> getPartyElection();
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(CalculationCurrencyElection partyElection);
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(CalculationCurrencyElection partyElection, int _idx);
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(List<? extends CalculationCurrencyElection> partyElection);
		SimmCalculationCurrency.SimmCalculationCurrencyBuilder setPartyElection(List<? extends CalculationCurrencyElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, CalculationCurrencyElection.CalculationCurrencyElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//SimmCalculationCurrency.SimmCalculationCurrencyImpl
	class SimmCalculationCurrencyImpl implements SimmCalculationCurrency {
		private final List<? extends CalculationCurrencyElection> partyElection;
		
		protected SimmCalculationCurrencyImpl(SimmCalculationCurrency.SimmCalculationCurrencyBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CalculationCurrencyElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public SimmCalculationCurrency build() {
			return this;
		}
		
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder toBuilder() {
			SimmCalculationCurrency.SimmCalculationCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimmCalculationCurrency.SimmCalculationCurrencyBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmCalculationCurrency _that = getType().cast(o);
		
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
			return "SimmCalculationCurrency {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//SimmCalculationCurrency.SimmCalculationCurrencyBuilderImpl
	class SimmCalculationCurrencyBuilderImpl implements SimmCalculationCurrency.SimmCalculationCurrencyBuilder {
	
		protected List<CalculationCurrencyElection.CalculationCurrencyElectionBuilder> partyElection = new ArrayList<>();
	
		public SimmCalculationCurrencyBuilderImpl() {
		}
	
		@Override
		public List<? extends CalculationCurrencyElection.CalculationCurrencyElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			CalculationCurrencyElection.CalculationCurrencyElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						CalculationCurrencyElection.CalculationCurrencyElectionBuilder newPartyElection = CalculationCurrencyElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(CalculationCurrencyElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(CalculationCurrencyElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder addPartyElection(List<? extends CalculationCurrencyElection> partyElections) {
			if (partyElections != null) {
				for (CalculationCurrencyElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder setPartyElection(List<? extends CalculationCurrencyElection> partyElections) {
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
		public SimmCalculationCurrency build() {
			return new SimmCalculationCurrency.SimmCalculationCurrencyImpl(this);
		}
		
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CalculationCurrencyElection.CalculationCurrencyElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmCalculationCurrency.SimmCalculationCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SimmCalculationCurrency.SimmCalculationCurrencyBuilder o = (SimmCalculationCurrency.SimmCalculationCurrencyBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmCalculationCurrency _that = getType().cast(o);
		
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
			return "SimmCalculationCurrencyBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
