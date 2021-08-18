package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.HoldingAndUsingPostedCollateralMeta;
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
 * A class to specify the elections for the holding and using of posted collateral by the respective parties to the Credit Support Annex for Variation Margin. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h): Holding and Using Posted Collateral (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface HoldingAndUsingPostedCollateral extends RosettaModelObject {
	HoldingAndUsingPostedCollateral build();
	HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder();
	
	/**
	 * The parties&#39; elections for the holding and using of posted collateral.
	 */
	List<? extends HoldingAndUsingPostedCollateralElection> getPartyElection();
	final static HoldingAndUsingPostedCollateralMeta metaData = new HoldingAndUsingPostedCollateralMeta();
	
	@Override
	default RosettaMetaData<? extends HoldingAndUsingPostedCollateral> metaData() {
		return metaData;
	} 
			
	static HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder() {
		return new HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilderImpl();
	}
	
	default Class<? extends HoldingAndUsingPostedCollateral> getType() {
		return HoldingAndUsingPostedCollateral.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, HoldingAndUsingPostedCollateralElection.class, getPartyElection());
	}
	
	
	interface HoldingAndUsingPostedCollateralBuilder extends HoldingAndUsingPostedCollateral, RosettaModelObjectBuilder {
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> getPartyElection();
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection, int _idx);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElection);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder setPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralImpl
	class HoldingAndUsingPostedCollateralImpl implements HoldingAndUsingPostedCollateral {
		private final List<? extends HoldingAndUsingPostedCollateralElection> partyElection;
		
		protected HoldingAndUsingPostedCollateralImpl(HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends HoldingAndUsingPostedCollateralElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral build() {
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder() {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateral _that = getType().cast(o);
		
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
			return "HoldingAndUsingPostedCollateral {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilderImpl
	class HoldingAndUsingPostedCollateralBuilderImpl implements HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder {
	
		protected List<HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> partyElection = new ArrayList<>();
	
		public HoldingAndUsingPostedCollateralBuilderImpl() {
		}
	
		@Override
		public List<? extends HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder newPartyElection = HoldingAndUsingPostedCollateralElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElections) {
			if (partyElections != null) {
				for (HoldingAndUsingPostedCollateralElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder setPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElections) {
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
		public HoldingAndUsingPostedCollateral build() {
			return new HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralImpl(this);
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder o = (HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateral _that = getType().cast(o);
		
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
			return "HoldingAndUsingPostedCollateralBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
