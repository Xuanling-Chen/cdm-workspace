package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.ControlAgreementMeta;
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
 * A class to specify the relationship between the Control Agreement and the Credit Support Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface ControlAgreement extends RosettaModelObject {
	ControlAgreement build();
	ControlAgreement.ControlAgreementBuilder toBuilder();
	
	/**
	 * The party specific elections.
	 */
	List<? extends ControlAgreementElections> getPartyElection();
	final static ControlAgreementMeta metaData = new ControlAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends ControlAgreement> metaData() {
		return metaData;
	} 
			
	static ControlAgreement.ControlAgreementBuilder builder() {
		return new ControlAgreement.ControlAgreementBuilderImpl();
	}
	
	default Class<? extends ControlAgreement> getType() {
		return ControlAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("partyElection"), processor, ControlAgreementElections.class, getPartyElection());
	}
	
	
	interface ControlAgreementBuilder extends ControlAgreement, RosettaModelObjectBuilder {
		ControlAgreementElections.ControlAgreementElectionsBuilder getOrCreatePartyElection(int _index);
		List<? extends ControlAgreementElections.ControlAgreementElectionsBuilder> getPartyElection();
		ControlAgreement.ControlAgreementBuilder addPartyElection(ControlAgreementElections partyElection);
		ControlAgreement.ControlAgreementBuilder addPartyElection(ControlAgreementElections partyElection, int _idx);
		ControlAgreement.ControlAgreementBuilder addPartyElection(List<? extends ControlAgreementElections> partyElection);
		ControlAgreement.ControlAgreementBuilder setPartyElection(List<? extends ControlAgreementElections> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("partyElection"), processor, ControlAgreementElections.ControlAgreementElectionsBuilder.class, getPartyElection());
		}
		
	}
	
	//ControlAgreement.ControlAgreementImpl
	class ControlAgreementImpl implements ControlAgreement {
		private final List<? extends ControlAgreementElections> partyElection;
		
		protected ControlAgreementImpl(ControlAgreement.ControlAgreementBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ControlAgreementElections> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ControlAgreement build() {
			return this;
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder toBuilder() {
			ControlAgreement.ControlAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreement.ControlAgreementBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreement _that = getType().cast(o);
		
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
			return "ControlAgreement {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//ControlAgreement.ControlAgreementBuilderImpl
	class ControlAgreementBuilderImpl implements ControlAgreement.ControlAgreementBuilder {
	
		protected List<ControlAgreementElections.ControlAgreementElectionsBuilder> partyElection = new ArrayList<>();
	
		public ControlAgreementBuilderImpl() {
		}
	
		@Override
		public List<? extends ControlAgreementElections.ControlAgreementElectionsBuilder> getPartyElection() {
			return partyElection;
		}
		
		public ControlAgreementElections.ControlAgreementElectionsBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			ControlAgreementElections.ControlAgreementElectionsBuilder result;
			return getIndex(partyElection, _index, () -> {
						ControlAgreementElections.ControlAgreementElectionsBuilder newPartyElection = ControlAgreementElections.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public ControlAgreement.ControlAgreementBuilder addPartyElection(ControlAgreementElections partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder addPartyElection(ControlAgreementElections partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public ControlAgreement.ControlAgreementBuilder addPartyElection(List<? extends ControlAgreementElections> partyElections) {
			if (partyElections != null) {
				for (ControlAgreementElections toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ControlAgreement.ControlAgreementBuilder setPartyElection(List<? extends ControlAgreementElections> partyElections) {
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
		public ControlAgreement build() {
			return new ControlAgreement.ControlAgreementImpl(this);
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreement.ControlAgreementBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<ControlAgreementElections.ControlAgreementElectionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreement.ControlAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreement.ControlAgreementBuilder o = (ControlAgreement.ControlAgreementBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreement _that = getType().cast(o);
		
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
			return "ControlAgreementBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
