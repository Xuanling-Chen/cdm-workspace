package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.AutomaticEarlyTerminationMeta;
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
 * A class to specify the Automatic Early Termination provision applicable to a Master Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface AutomaticEarlyTermination extends RosettaModelObject {
	AutomaticEarlyTermination build();
	AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder();
	
	/**
	 * A boolean election to specify whether provided that, where a party is governed by a system of law which does not permit the termination of one or more Transactions to occur following an Event of Default specified in Section 5(a)(vii)(1), (3), (4), (5), (6) or, to extent analogous thereto, (8) ,then the Automatic Early Termination provisions of Section 6(a) shall apply to such party.
	 */
	Boolean getFallbackAET();
	/**
	 * A boolean attribute to specify whether if an Early Termination Date occurs because Automatic Early Termination applies in respect of a party, the Defaulting Party shall indemnify the Non- defaulting Party, on demand, against any losses, costs, expenses or damages that the Non- defaulting Party incurs (to the extent not already taken into account in Section 6(e)) in relation to terminating, liquidating, establishing or re- establishing any hedge or related positions as result of movements of rates, indices, prices, yields, volatilities, spreads or other market data between the Early Termination Date and the Local Business Day on which the Non-defaulting Party becomes aware that the Early Termination Date has occurred
	 */
	Boolean getIndemnity();
	/**
	 * The party election specific to the Automatic Early Termination Clause.
	 */
	List<? extends AutomaticEarlyTerminationElection> getPartyElection();
	final static AutomaticEarlyTerminationMeta metaData = new AutomaticEarlyTerminationMeta();
	
	@Override
	default RosettaMetaData<? extends AutomaticEarlyTermination> metaData() {
		return metaData;
	} 
			
	static AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder() {
		return new AutomaticEarlyTermination.AutomaticEarlyTerminationBuilderImpl();
	}
	
	default Class<? extends AutomaticEarlyTermination> getType() {
		return AutomaticEarlyTermination.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fallbackAET"), Boolean.class, getFallbackAET(), this);
		processor.processBasic(path.newSubPath("indemnity"), Boolean.class, getIndemnity(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, AutomaticEarlyTerminationElection.class, getPartyElection());
	}
	
	
	interface AutomaticEarlyTerminationBuilder extends AutomaticEarlyTermination, RosettaModelObjectBuilder {
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> getPartyElection();
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setFallbackAET(Boolean fallbackAET);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setIndemnity(Boolean indemnity);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection, int _idx);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElection);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("fallbackAET"), Boolean.class, getFallbackAET(), this);
			processor.processBasic(path.newSubPath("indemnity"), Boolean.class, getIndemnity(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//AutomaticEarlyTermination.AutomaticEarlyTerminationImpl
	class AutomaticEarlyTerminationImpl implements AutomaticEarlyTermination {
		private final Boolean fallbackAET;
		private final Boolean indemnity;
		private final List<? extends AutomaticEarlyTerminationElection> partyElection;
		
		protected AutomaticEarlyTerminationImpl(AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder) {
			this.fallbackAET = builder.getFallbackAET();
			this.indemnity = builder.getIndemnity();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getFallbackAET() {
			return fallbackAET;
		}
		
		@Override
		public Boolean getIndemnity() {
			return indemnity;
		}
		
		@Override
		public List<? extends AutomaticEarlyTerminationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AutomaticEarlyTermination build() {
			return this;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder() {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder) {
			ofNullable(getFallbackAET()).ifPresent(builder::setFallbackAET);
			ofNullable(getIndemnity()).ifPresent(builder::setIndemnity);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(fallbackAET, _that.getFallbackAET())) return false;
			if (!Objects.equals(indemnity, _that.getIndemnity())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackAET != null ? fallbackAET.hashCode() : 0);
			_result = 31 * _result + (indemnity != null ? indemnity.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTermination {" +
				"fallbackAET=" + this.fallbackAET + ", " +
				"indemnity=" + this.indemnity + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//AutomaticEarlyTermination.AutomaticEarlyTerminationBuilderImpl
	class AutomaticEarlyTerminationBuilderImpl implements AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder {
	
		protected Boolean fallbackAET;
		protected Boolean indemnity;
		protected List<AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> partyElection = new ArrayList<>();
	
		public AutomaticEarlyTerminationBuilderImpl() {
		}
	
		@Override
		public Boolean getFallbackAET() {
			return fallbackAET;
		}
		
		@Override
		public Boolean getIndemnity() {
			return indemnity;
		}
		
		@Override
		public List<? extends AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder newPartyElection = AutomaticEarlyTerminationElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setFallbackAET(Boolean fallbackAET) {
			this.fallbackAET = fallbackAET==null?null:fallbackAET;
			return this;
		}
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setIndemnity(Boolean indemnity) {
			this.indemnity = indemnity==null?null:indemnity;
			return this;
		}
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElections) {
			if (partyElections != null) {
				for (AutomaticEarlyTerminationElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElections) {
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
		public AutomaticEarlyTermination build() {
			return new AutomaticEarlyTermination.AutomaticEarlyTerminationImpl(this);
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFallbackAET()!=null) return true;
			if (getIndemnity()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder o = (AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getFallbackAET(), o.getFallbackAET(), this::setFallbackAET);
			merger.mergeBasic(getIndemnity(), o.getIndemnity(), this::setIndemnity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(fallbackAET, _that.getFallbackAET())) return false;
			if (!Objects.equals(indemnity, _that.getIndemnity())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackAET != null ? fallbackAET.hashCode() : 0);
			_result = 31 * _result + (indemnity != null ? indemnity.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationBuilder {" +
				"fallbackAET=" + this.fallbackAET + ", " +
				"indemnity=" + this.indemnity + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
