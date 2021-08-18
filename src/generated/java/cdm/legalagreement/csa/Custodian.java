package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CustodianMeta;
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
 * A class to specify the custodian and custody account details for each party to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface Custodian extends RosettaModelObject {
	Custodian build();
	Custodian.CustodianBuilder toBuilder();
	
	/**
	 * The party specific elections.
	 */
	List<? extends CustodianElection> getPartyElection();
	final static CustodianMeta metaData = new CustodianMeta();
	
	@Override
	default RosettaMetaData<? extends Custodian> metaData() {
		return metaData;
	} 
			
	static Custodian.CustodianBuilder builder() {
		return new Custodian.CustodianBuilderImpl();
	}
	
	default Class<? extends Custodian> getType() {
		return Custodian.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, CustodianElection.class, getPartyElection());
	}
	
	
	interface CustodianBuilder extends Custodian, RosettaModelObjectBuilder {
		CustodianElection.CustodianElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends CustodianElection.CustodianElectionBuilder> getPartyElection();
		Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection);
		Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection, int _idx);
		Custodian.CustodianBuilder addPartyElection(List<? extends CustodianElection> partyElection);
		Custodian.CustodianBuilder setPartyElection(List<? extends CustodianElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, CustodianElection.CustodianElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//Custodian.CustodianImpl
	class CustodianImpl implements Custodian {
		private final List<? extends CustodianElection> partyElection;
		
		protected CustodianImpl(Custodian.CustodianBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CustodianElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public Custodian build() {
			return this;
		}
		
		@Override
		public Custodian.CustodianBuilder toBuilder() {
			Custodian.CustodianBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Custodian.CustodianBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Custodian _that = getType().cast(o);
		
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
			return "Custodian {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//Custodian.CustodianBuilderImpl
	class CustodianBuilderImpl implements Custodian.CustodianBuilder {
	
		protected List<CustodianElection.CustodianElectionBuilder> partyElection = new ArrayList<>();
	
		public CustodianBuilderImpl() {
		}
	
		@Override
		public List<? extends CustodianElection.CustodianElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public CustodianElection.CustodianElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			CustodianElection.CustodianElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						CustodianElection.CustodianElectionBuilder newPartyElection = CustodianElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public Custodian.CustodianBuilder addPartyElection(List<? extends CustodianElection> partyElections) {
			if (partyElections != null) {
				for (CustodianElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Custodian.CustodianBuilder setPartyElection(List<? extends CustodianElection> partyElections) {
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
		public Custodian build() {
			return new Custodian.CustodianImpl(this);
		}
		
		@Override
		public Custodian.CustodianBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Custodian.CustodianBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CustodianElection.CustodianElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Custodian.CustodianBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Custodian.CustodianBuilder o = (Custodian.CustodianBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Custodian _that = getType().cast(o);
		
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
			return "CustodianBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
