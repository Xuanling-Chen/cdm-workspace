package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralManagementAgreementMeta;
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
 * A class to specify the Collateral Management Agreement election by the respective parties to a Japanese Law ISDA CSA. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(i): Collateral Management Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralManagementAgreement extends RosettaModelObject {
	CollateralManagementAgreement build();
	CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder();
	
	/**
	 * The parties&#39; Collateral Management Agreement election.
	 */
	List<? extends CollateralManagementAgreementElection> getPartyElection();
	final static CollateralManagementAgreementMeta metaData = new CollateralManagementAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralManagementAgreement> metaData() {
		return metaData;
	} 
			
	static CollateralManagementAgreement.CollateralManagementAgreementBuilder builder() {
		return new CollateralManagementAgreement.CollateralManagementAgreementBuilderImpl();
	}
	
	default Class<? extends CollateralManagementAgreement> getType() {
		return CollateralManagementAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, CollateralManagementAgreementElection.class, getPartyElection());
	}
	
	
	interface CollateralManagementAgreementBuilder extends CollateralManagementAgreement, RosettaModelObjectBuilder {
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> getPartyElection();
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection, int _idx);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(List<? extends CollateralManagementAgreementElection> partyElection);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder setPartyElection(List<? extends CollateralManagementAgreementElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//CollateralManagementAgreement.CollateralManagementAgreementImpl
	class CollateralManagementAgreementImpl implements CollateralManagementAgreement {
		private final List<? extends CollateralManagementAgreementElection> partyElection;
		
		protected CollateralManagementAgreementImpl(CollateralManagementAgreement.CollateralManagementAgreementBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CollateralManagementAgreementElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CollateralManagementAgreement build() {
			return this;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder() {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralManagementAgreement.CollateralManagementAgreementBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreement _that = getType().cast(o);
		
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
			return "CollateralManagementAgreement {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//CollateralManagementAgreement.CollateralManagementAgreementBuilderImpl
	class CollateralManagementAgreementBuilderImpl implements CollateralManagementAgreement.CollateralManagementAgreementBuilder {
	
		protected List<CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> partyElection = new ArrayList<>();
	
		public CollateralManagementAgreementBuilderImpl() {
		}
	
		@Override
		public List<? extends CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder newPartyElection = CollateralManagementAgreementElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(List<? extends CollateralManagementAgreementElection> partyElections) {
			if (partyElections != null) {
				for (CollateralManagementAgreementElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder setPartyElection(List<? extends CollateralManagementAgreementElection> partyElections) {
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
		public CollateralManagementAgreement build() {
			return new CollateralManagementAgreement.CollateralManagementAgreementImpl(this);
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder o = (CollateralManagementAgreement.CollateralManagementAgreementBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreement _that = getType().cast(o);
		
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
			return "CollateralManagementAgreementBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
