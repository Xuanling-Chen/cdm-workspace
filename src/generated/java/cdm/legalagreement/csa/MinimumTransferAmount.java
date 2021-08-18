package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.MinimumTransferAmountMeta;
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
 * A class to specify amount of exposure reached before collateral has to be posted or returned. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(B): Minimum Transfer Amount. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(B): Minimum Transfer Amount.
 * @version ${project.version}
 */
@RosettaClass

public interface MinimumTransferAmount extends RosettaModelObject {
	MinimumTransferAmount build();
	MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder();
	
	/**
	 * The parties&#39; minimum transfer amount elections.
	 */
	List<? extends ElectiveAmountElection> getPartyElection();
	final static MinimumTransferAmountMeta metaData = new MinimumTransferAmountMeta();
	
	@Override
	default RosettaMetaData<? extends MinimumTransferAmount> metaData() {
		return metaData;
	} 
			
	static MinimumTransferAmount.MinimumTransferAmountBuilder builder() {
		return new MinimumTransferAmount.MinimumTransferAmountBuilderImpl();
	}
	
	default Class<? extends MinimumTransferAmount> getType() {
		return MinimumTransferAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.class, getPartyElection());
	}
	
	
	interface MinimumTransferAmountBuilder extends MinimumTransferAmount, RosettaModelObjectBuilder {
		ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElection();
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection);
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection, int _idx);
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElection);
		MinimumTransferAmount.MinimumTransferAmountBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.ElectiveAmountElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//MinimumTransferAmount.MinimumTransferAmountImpl
	class MinimumTransferAmountImpl implements MinimumTransferAmount {
		private final List<? extends ElectiveAmountElection> partyElection;
		
		protected MinimumTransferAmountImpl(MinimumTransferAmount.MinimumTransferAmountBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ElectiveAmountElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public MinimumTransferAmount build() {
			return this;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder() {
			MinimumTransferAmount.MinimumTransferAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MinimumTransferAmount.MinimumTransferAmountBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmount _that = getType().cast(o);
		
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
			return "MinimumTransferAmount {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//MinimumTransferAmount.MinimumTransferAmountBuilderImpl
	class MinimumTransferAmountBuilderImpl implements MinimumTransferAmount.MinimumTransferAmountBuilder {
	
		protected List<ElectiveAmountElection.ElectiveAmountElectionBuilder> partyElection = new ArrayList<>();
	
		public MinimumTransferAmountBuilderImpl() {
		}
	
		@Override
		public List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			ElectiveAmountElection.ElectiveAmountElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						ElectiveAmountElection.ElectiveAmountElectionBuilder newPartyElection = ElectiveAmountElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElections) {
			if (partyElections != null) {
				for (ElectiveAmountElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MinimumTransferAmount.MinimumTransferAmountBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElections) {
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
		public MinimumTransferAmount build() {
			return new MinimumTransferAmount.MinimumTransferAmountImpl(this);
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<ElectiveAmountElection.ElectiveAmountElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MinimumTransferAmount.MinimumTransferAmountBuilder o = (MinimumTransferAmount.MinimumTransferAmountBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmount _that = getType().cast(o);
		
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
			return "MinimumTransferAmountBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
