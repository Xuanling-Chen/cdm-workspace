package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.RecalculationOfValueMeta;
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
 * A class to specify terms for Recalculation of the Market Value of Posted Collateral when a dispute has been failed to be resolved by Resolution Time.
 * @version ${project.version}
 */
@RosettaClass

public interface RecalculationOfValue extends RosettaModelObject {
	RecalculationOfValue build();
	RecalculationOfValue.RecalculationOfValueBuilder toBuilder();
	
	/**
	 * The parties&#39; Recalculation of Value terms.
	 */
	List<? extends RecalculationOfValueElection> getPartyElection();
	final static RecalculationOfValueMeta metaData = new RecalculationOfValueMeta();
	
	@Override
	default RosettaMetaData<? extends RecalculationOfValue> metaData() {
		return metaData;
	} 
			
	static RecalculationOfValue.RecalculationOfValueBuilder builder() {
		return new RecalculationOfValue.RecalculationOfValueBuilderImpl();
	}
	
	default Class<? extends RecalculationOfValue> getType() {
		return RecalculationOfValue.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, RecalculationOfValueElection.class, getPartyElection());
	}
	
	
	interface RecalculationOfValueBuilder extends RecalculationOfValue, RosettaModelObjectBuilder {
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends RecalculationOfValueElection.RecalculationOfValueElectionBuilder> getPartyElection();
		RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(RecalculationOfValueElection partyElection);
		RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(RecalculationOfValueElection partyElection, int _idx);
		RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(List<? extends RecalculationOfValueElection> partyElection);
		RecalculationOfValue.RecalculationOfValueBuilder setPartyElection(List<? extends RecalculationOfValueElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, RecalculationOfValueElection.RecalculationOfValueElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//RecalculationOfValue.RecalculationOfValueImpl
	class RecalculationOfValueImpl implements RecalculationOfValue {
		private final List<? extends RecalculationOfValueElection> partyElection;
		
		protected RecalculationOfValueImpl(RecalculationOfValue.RecalculationOfValueBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends RecalculationOfValueElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public RecalculationOfValue build() {
			return this;
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder toBuilder() {
			RecalculationOfValue.RecalculationOfValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RecalculationOfValue.RecalculationOfValueBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValue _that = getType().cast(o);
		
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
			return "RecalculationOfValue {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//RecalculationOfValue.RecalculationOfValueBuilderImpl
	class RecalculationOfValueBuilderImpl implements RecalculationOfValue.RecalculationOfValueBuilder {
	
		protected List<RecalculationOfValueElection.RecalculationOfValueElectionBuilder> partyElection = new ArrayList<>();
	
		public RecalculationOfValueBuilderImpl() {
		}
	
		@Override
		public List<? extends RecalculationOfValueElection.RecalculationOfValueElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			RecalculationOfValueElection.RecalculationOfValueElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						RecalculationOfValueElection.RecalculationOfValueElectionBuilder newPartyElection = RecalculationOfValueElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(RecalculationOfValueElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(RecalculationOfValueElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public RecalculationOfValue.RecalculationOfValueBuilder addPartyElection(List<? extends RecalculationOfValueElection> partyElections) {
			if (partyElections != null) {
				for (RecalculationOfValueElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RecalculationOfValue.RecalculationOfValueBuilder setPartyElection(List<? extends RecalculationOfValueElection> partyElections) {
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
		public RecalculationOfValue build() {
			return new RecalculationOfValue.RecalculationOfValueImpl(this);
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<RecalculationOfValueElection.RecalculationOfValueElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RecalculationOfValue.RecalculationOfValueBuilder o = (RecalculationOfValue.RecalculationOfValueBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValue _that = getType().cast(o);
		
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
			return "RecalculationOfValueBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
