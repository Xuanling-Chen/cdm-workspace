package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AdditionalRepresentationMeta;
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
 * A class to specify the Additional Representation. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (o): Additional Representation(s).
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalRepresentation extends RosettaModelObject {
	AdditionalRepresentation build();
	AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder();
	
	/**
	 * A supplemental custom election that might be specified by the parties for the purpose of specifying the Additional Representation.
	 */
	String getCustomElection();
	/**
	 * A qualification as to whether the Additional Representation is applicable.
	 */
	List<? extends AdditionalRepresentationElection> getPartyElection();
	final static AdditionalRepresentationMeta metaData = new AdditionalRepresentationMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalRepresentation> metaData() {
		return metaData;
	} 
			
	static AdditionalRepresentation.AdditionalRepresentationBuilder builder() {
		return new AdditionalRepresentation.AdditionalRepresentationBuilderImpl();
	}
	
	default Class<? extends AdditionalRepresentation> getType() {
		return AdditionalRepresentation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, AdditionalRepresentationElection.class, getPartyElection());
	}
	
	
	interface AdditionalRepresentationBuilder extends AdditionalRepresentation, RosettaModelObjectBuilder {
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> getPartyElection();
		AdditionalRepresentation.AdditionalRepresentationBuilder setCustomElection(String customElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection, int _idx);
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(List<? extends AdditionalRepresentationElection> partyElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder setPartyElection(List<? extends AdditionalRepresentationElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//AdditionalRepresentation.AdditionalRepresentationImpl
	class AdditionalRepresentationImpl implements AdditionalRepresentation {
		private final String customElection;
		private final List<? extends AdditionalRepresentationElection> partyElection;
		
		protected AdditionalRepresentationImpl(AdditionalRepresentation.AdditionalRepresentationBuilder builder) {
			this.customElection = builder.getCustomElection();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public List<? extends AdditionalRepresentationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AdditionalRepresentation build() {
			return this;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder() {
			AdditionalRepresentation.AdditionalRepresentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRepresentation.AdditionalRepresentationBuilder builder) {
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentation {" +
				"customElection=" + this.customElection + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//AdditionalRepresentation.AdditionalRepresentationBuilderImpl
	class AdditionalRepresentationBuilderImpl implements AdditionalRepresentation.AdditionalRepresentationBuilder {
	
		protected String customElection;
		protected List<AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> partyElection = new ArrayList<>();
	
		public AdditionalRepresentationBuilderImpl() {
		}
	
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public List<? extends AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder newPartyElection = AdditionalRepresentationElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(List<? extends AdditionalRepresentationElection> partyElections) {
			if (partyElections != null) {
				for (AdditionalRepresentationElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AdditionalRepresentation.AdditionalRepresentationBuilder setPartyElection(List<? extends AdditionalRepresentationElection> partyElections) {
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
		public AdditionalRepresentation build() {
			return new AdditionalRepresentation.AdditionalRepresentationImpl(this);
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomElection()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRepresentation.AdditionalRepresentationBuilder o = (AdditionalRepresentation.AdditionalRepresentationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentationBuilder {" +
				"customElection=" + this.customElection + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
