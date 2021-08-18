package cdm.legalagreement.master;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legalagreement.common.CreditSupportProviderTermsEnum;
import cdm.legalagreement.master.meta.CreditSupportProviderElectionMeta;
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
 * The party election of Credit Support Provider(s), if any.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportProviderElection extends RosettaModelObject {
	CreditSupportProviderElection build();
	CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder();
	
	/**
	 * ...
	 */
	String getBespokeCreditSuppportProvider();
	/**
	 * The specifed Credit Support Provider(s), if any.
	 */
	List<? extends LegalEntity> getCreditSupportProvider();
	/**
	 * Specification of the Credit Support Provider terms.
	 */
	CreditSupportProviderTermsEnum getCreditSupportProviderTerms();
	/**
	 * The elective party
	 */
	Party getParty();
	final static CreditSupportProviderElectionMeta metaData = new CreditSupportProviderElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportProviderElection> metaData() {
		return metaData;
	} 
			
	static CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder() {
		return new CreditSupportProviderElection.CreditSupportProviderElectionBuilderImpl();
	}
	
	default Class<? extends CreditSupportProviderElection> getType() {
		return CreditSupportProviderElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bespokeCreditSuppportProvider"), String.class, getBespokeCreditSuppportProvider(), this);
		processor.processBasic(path.newSubPath("creditSupportProviderTerms"), CreditSupportProviderTermsEnum.class, getCreditSupportProviderTerms(), this);
		
		processRosetta(path.newSubPath("creditSupportProvider"), processor, LegalEntity.class, getCreditSupportProvider());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	
	
	interface CreditSupportProviderElectionBuilder extends CreditSupportProviderElection, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateCreditSupportProvider(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getCreditSupportProvider();
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setBespokeCreditSuppportProvider(String bespokeCreditSuppportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider, int _idx);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(List<? extends LegalEntity> creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProvider(List<? extends LegalEntity> creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProviderTerms(CreditSupportProviderTermsEnum creditSupportProviderTerms);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setParty(Party party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bespokeCreditSuppportProvider"), String.class, getBespokeCreditSuppportProvider(), this);
			processor.processBasic(path.newSubPath("creditSupportProviderTerms"), CreditSupportProviderTermsEnum.class, getCreditSupportProviderTerms(), this);
			
			processRosetta(path.newSubPath("creditSupportProvider"), processor, LegalEntity.LegalEntityBuilder.class, getCreditSupportProvider());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		
	}
	
	//CreditSupportProviderElection.CreditSupportProviderElectionImpl
	class CreditSupportProviderElectionImpl implements CreditSupportProviderElection {
		private final String bespokeCreditSuppportProvider;
		private final List<? extends LegalEntity> creditSupportProvider;
		private final CreditSupportProviderTermsEnum creditSupportProviderTerms;
		private final Party party;
		
		protected CreditSupportProviderElectionImpl(CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder) {
			this.bespokeCreditSuppportProvider = builder.getBespokeCreditSuppportProvider();
			this.creditSupportProvider = ofNullable(builder.getCreditSupportProvider()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportProviderTerms = builder.getCreditSupportProviderTerms();
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getBespokeCreditSuppportProvider() {
			return bespokeCreditSuppportProvider;
		}
		
		@Override
		public List<? extends LegalEntity> getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		public CreditSupportProviderTermsEnum getCreditSupportProviderTerms() {
			return creditSupportProviderTerms;
		}
		
		@Override
		public Party getParty() {
			return party;
		}
		
		@Override
		public CreditSupportProviderElection build() {
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder() {
			CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder) {
			ofNullable(getBespokeCreditSuppportProvider()).ifPresent(builder::setBespokeCreditSuppportProvider);
			ofNullable(getCreditSupportProvider()).ifPresent(builder::setCreditSupportProvider);
			ofNullable(getCreditSupportProviderTerms()).ifPresent(builder::setCreditSupportProviderTerms);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProviderElection _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCreditSuppportProvider, _that.getBespokeCreditSuppportProvider())) return false;
			if (!ListEquals.listEquals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(creditSupportProviderTerms, _that.getCreditSupportProviderTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCreditSuppportProvider != null ? bespokeCreditSuppportProvider.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (creditSupportProviderTerms != null ? creditSupportProviderTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProviderElection {" +
				"bespokeCreditSuppportProvider=" + this.bespokeCreditSuppportProvider + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"creditSupportProviderTerms=" + this.creditSupportProviderTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CreditSupportProviderElection.CreditSupportProviderElectionBuilderImpl
	class CreditSupportProviderElectionBuilderImpl implements CreditSupportProviderElection.CreditSupportProviderElectionBuilder {
	
		protected String bespokeCreditSuppportProvider;
		protected List<LegalEntity.LegalEntityBuilder> creditSupportProvider = new ArrayList<>();
		protected CreditSupportProviderTermsEnum creditSupportProviderTerms;
		protected Party.PartyBuilder party;
	
		public CreditSupportProviderElectionBuilderImpl() {
		}
	
		@Override
		public String getBespokeCreditSuppportProvider() {
			return bespokeCreditSuppportProvider;
		}
		
		@Override
		public List<? extends LegalEntity.LegalEntityBuilder> getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateCreditSupportProvider(int _index) {
		
			if (creditSupportProvider==null) {
				this.creditSupportProvider = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(creditSupportProvider, _index, () -> {
						LegalEntity.LegalEntityBuilder newCreditSupportProvider = LegalEntity.builder();
						return newCreditSupportProvider;
					});
		}
		
		@Override
		public CreditSupportProviderTermsEnum getCreditSupportProviderTerms() {
			return creditSupportProviderTerms;
		}
		
		@Override
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setBespokeCreditSuppportProvider(String bespokeCreditSuppportProvider) {
			this.bespokeCreditSuppportProvider = bespokeCreditSuppportProvider==null?null:bespokeCreditSuppportProvider;
			return this;
		}
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider) {
			if (creditSupportProvider!=null) this.creditSupportProvider.add(creditSupportProvider.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider, int _idx) {
			getIndex(this.creditSupportProvider, _idx, () -> creditSupportProvider.toBuilder());
			return this;
		}
		@Override 
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(List<? extends LegalEntity> creditSupportProviders) {
			if (creditSupportProviders != null) {
				for (LegalEntity toAdd : creditSupportProviders) {
					this.creditSupportProvider.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProvider(List<? extends LegalEntity> creditSupportProviders) {
			if (creditSupportProviders == null)  {
				this.creditSupportProvider = new ArrayList<>();
			}
			else {
				this.creditSupportProvider = creditSupportProviders.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProviderTerms(CreditSupportProviderTermsEnum creditSupportProviderTerms) {
			this.creditSupportProviderTerms = creditSupportProviderTerms==null?null:creditSupportProviderTerms;
			return this;
		}
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportProviderElection build() {
			return new CreditSupportProviderElection.CreditSupportProviderElectionImpl(this);
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder prune() {
			creditSupportProvider = creditSupportProvider.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeCreditSuppportProvider()!=null) return true;
			if (getCreditSupportProvider()!=null && getCreditSupportProvider().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportProviderTerms()!=null) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportProviderElection.CreditSupportProviderElectionBuilder o = (CreditSupportProviderElection.CreditSupportProviderElectionBuilder) other;
			
			merger.mergeRosetta(getCreditSupportProvider(), o.getCreditSupportProvider(), this::getOrCreateCreditSupportProvider);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getBespokeCreditSuppportProvider(), o.getBespokeCreditSuppportProvider(), this::setBespokeCreditSuppportProvider);
			merger.mergeBasic(getCreditSupportProviderTerms(), o.getCreditSupportProviderTerms(), this::setCreditSupportProviderTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProviderElection _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCreditSuppportProvider, _that.getBespokeCreditSuppportProvider())) return false;
			if (!ListEquals.listEquals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(creditSupportProviderTerms, _that.getCreditSupportProviderTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCreditSuppportProvider != null ? bespokeCreditSuppportProvider.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (creditSupportProviderTerms != null ? creditSupportProviderTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProviderElectionBuilder {" +
				"bespokeCreditSuppportProvider=" + this.bespokeCreditSuppportProvider + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"creditSupportProviderTerms=" + this.creditSupportProviderTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
