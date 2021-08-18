package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.PostingObligationsMeta;
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
 * A class to specify the collateral posting obligations of the security provider or security providers as specified in the corresponding agreement, for example, the New York Law ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii).
 * @version ${project.version}
 */
@RosettaClass

public interface PostingObligations extends RosettaModelObject {
	PostingObligations build();
	PostingObligations.PostingObligationsBuilder toBuilder();
	
	/**
	 * The specification of the collateral posting obligations for the security provider party(ies), for example, as specified under the terms of the ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (ii).
	 */
	List<? extends PostingObligationsElection> getPartyElection();
	/**
	 * The security provider party(ies) to which the posting obligations apply to, which can be either one of the parties to the legal agreement, or both of those.
	 */
	String getSecurityProvider();
	final static PostingObligationsMeta metaData = new PostingObligationsMeta();
	
	@Override
	default RosettaMetaData<? extends PostingObligations> metaData() {
		return metaData;
	} 
			
	static PostingObligations.PostingObligationsBuilder builder() {
		return new PostingObligations.PostingObligationsBuilderImpl();
	}
	
	default Class<? extends PostingObligations> getType() {
		return PostingObligations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("securityProvider"), String.class, getSecurityProvider(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, PostingObligationsElection.class, getPartyElection());
	}
	
	
	interface PostingObligationsBuilder extends PostingObligations, RosettaModelObjectBuilder {
		PostingObligationsElection.PostingObligationsElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends PostingObligationsElection.PostingObligationsElectionBuilder> getPartyElection();
		PostingObligations.PostingObligationsBuilder addPartyElection(PostingObligationsElection partyElection);
		PostingObligations.PostingObligationsBuilder addPartyElection(PostingObligationsElection partyElection, int _idx);
		PostingObligations.PostingObligationsBuilder addPartyElection(List<? extends PostingObligationsElection> partyElection);
		PostingObligations.PostingObligationsBuilder setPartyElection(List<? extends PostingObligationsElection> partyElection);
		PostingObligations.PostingObligationsBuilder setSecurityProvider(String securityProvider);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("securityProvider"), String.class, getSecurityProvider(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, PostingObligationsElection.PostingObligationsElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//PostingObligations.PostingObligationsImpl
	class PostingObligationsImpl implements PostingObligations {
		private final List<? extends PostingObligationsElection> partyElection;
		private final String securityProvider;
		
		protected PostingObligationsImpl(PostingObligations.PostingObligationsBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.securityProvider = builder.getSecurityProvider();
		}
		
		@Override
		public List<? extends PostingObligationsElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public String getSecurityProvider() {
			return securityProvider;
		}
		
		@Override
		public PostingObligations build() {
			return this;
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder toBuilder() {
			PostingObligations.PostingObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostingObligations.PostingObligationsBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getSecurityProvider()).ifPresent(builder::setSecurityProvider);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(securityProvider, _that.getSecurityProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (securityProvider != null ? securityProvider.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligations {" +
				"partyElection=" + this.partyElection + ", " +
				"securityProvider=" + this.securityProvider +
			'}';
		}
	}
	
	//PostingObligations.PostingObligationsBuilderImpl
	class PostingObligationsBuilderImpl implements PostingObligations.PostingObligationsBuilder {
	
		protected List<PostingObligationsElection.PostingObligationsElectionBuilder> partyElection = new ArrayList<>();
		protected String securityProvider;
	
		public PostingObligationsBuilderImpl() {
		}
	
		@Override
		public List<? extends PostingObligationsElection.PostingObligationsElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public PostingObligationsElection.PostingObligationsElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			PostingObligationsElection.PostingObligationsElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						PostingObligationsElection.PostingObligationsElectionBuilder newPartyElection = PostingObligationsElection.builder();
						return newPartyElection;
					});
		}
		
		@Override
		public String getSecurityProvider() {
			return securityProvider;
		}
		
	
		@Override
		public PostingObligations.PostingObligationsBuilder addPartyElection(PostingObligationsElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder addPartyElection(PostingObligationsElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public PostingObligations.PostingObligationsBuilder addPartyElection(List<? extends PostingObligationsElection> partyElections) {
			if (partyElections != null) {
				for (PostingObligationsElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PostingObligations.PostingObligationsBuilder setPartyElection(List<? extends PostingObligationsElection> partyElections) {
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
		public PostingObligations.PostingObligationsBuilder setSecurityProvider(String securityProvider) {
			this.securityProvider = securityProvider==null?null:securityProvider;
			return this;
		}
		
		@Override
		public PostingObligations build() {
			return new PostingObligations.PostingObligationsImpl(this);
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligations.PostingObligationsBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<PostingObligationsElection.PostingObligationsElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSecurityProvider()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostingObligations.PostingObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostingObligations.PostingObligationsBuilder o = (PostingObligations.PostingObligationsBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getSecurityProvider(), o.getSecurityProvider(), this::setSecurityProvider);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostingObligations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(securityProvider, _that.getSecurityProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (securityProvider != null ? securityProvider.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostingObligationsBuilder {" +
				"partyElection=" + this.partyElection + ", " +
				"securityProvider=" + this.securityProvider +
			'}';
		}
	}
}
