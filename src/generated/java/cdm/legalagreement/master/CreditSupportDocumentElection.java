package cdm.legalagreement.master;

import cdm.base.staticdata.party.Party;
import cdm.legalagreement.common.CreditSupportDocumentTermsEnum;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.master.meta.CreditSupportDocumentElectionMeta;
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

public interface CreditSupportDocumentElection extends RosettaModelObject {
	CreditSupportDocumentElection build();
	CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder();
	
	/**
	 * Specification of a document when not captured under RelatedAgreement
	 */
	String getBespokeCreditSuppportDocument();
	/**
	 * The specifed Credit Support Document(s), if any.
	 */
	List<? extends RelatedAgreement> getCreditSupportDocument();
	/**
	 * Specification of the Credit Support Document terms.
	 */
	CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms();
	/**
	 * The elective party
	 */
	Party getParty();
	final static CreditSupportDocumentElectionMeta metaData = new CreditSupportDocumentElectionMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportDocumentElection> metaData() {
		return metaData;
	} 
			
	static CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder() {
		return new CreditSupportDocumentElection.CreditSupportDocumentElectionBuilderImpl();
	}
	
	default Class<? extends CreditSupportDocumentElection> getType() {
		return CreditSupportDocumentElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bespokeCreditSuppportDocument"), String.class, getBespokeCreditSuppportDocument(), this);
		processor.processBasic(path.newSubPath("creditSupportDocumentTerms"), CreditSupportDocumentTermsEnum.class, getCreditSupportDocumentTerms(), this);
		
		processRosetta(path.newSubPath("creditSupportDocument"), processor, RelatedAgreement.class, getCreditSupportDocument());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	
	
	interface CreditSupportDocumentElectionBuilder extends CreditSupportDocumentElection, RosettaModelObjectBuilder {
		RelatedAgreement.RelatedAgreementBuilder getOrCreateCreditSupportDocument(int _index);
		List<? extends RelatedAgreement.RelatedAgreementBuilder> getCreditSupportDocument();
		Party.PartyBuilder getOrCreateParty();
		Party.PartyBuilder getParty();
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setBespokeCreditSuppportDocument(String bespokeCreditSuppportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(RelatedAgreement creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(RelatedAgreement creditSupportDocument, int _idx);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(List<? extends RelatedAgreement> creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocument(List<? extends RelatedAgreement> creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTerms(CreditSupportDocumentTermsEnum creditSupportDocumentTerms);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setParty(Party party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bespokeCreditSuppportDocument"), String.class, getBespokeCreditSuppportDocument(), this);
			processor.processBasic(path.newSubPath("creditSupportDocumentTerms"), CreditSupportDocumentTermsEnum.class, getCreditSupportDocumentTerms(), this);
			
			processRosetta(path.newSubPath("creditSupportDocument"), processor, RelatedAgreement.RelatedAgreementBuilder.class, getCreditSupportDocument());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		
	}
	
	//CreditSupportDocumentElection.CreditSupportDocumentElectionImpl
	class CreditSupportDocumentElectionImpl implements CreditSupportDocumentElection {
		private final String bespokeCreditSuppportDocument;
		private final List<? extends RelatedAgreement> creditSupportDocument;
		private final CreditSupportDocumentTermsEnum creditSupportDocumentTerms;
		private final Party party;
		
		protected CreditSupportDocumentElectionImpl(CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder) {
			this.bespokeCreditSuppportDocument = builder.getBespokeCreditSuppportDocument();
			this.creditSupportDocument = ofNullable(builder.getCreditSupportDocument()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportDocumentTerms = builder.getCreditSupportDocumentTerms();
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getBespokeCreditSuppportDocument() {
			return bespokeCreditSuppportDocument;
		}
		
		@Override
		public List<? extends RelatedAgreement> getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		public CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms() {
			return creditSupportDocumentTerms;
		}
		
		@Override
		public Party getParty() {
			return party;
		}
		
		@Override
		public CreditSupportDocumentElection build() {
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder() {
			CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder) {
			ofNullable(getBespokeCreditSuppportDocument()).ifPresent(builder::setBespokeCreditSuppportDocument);
			ofNullable(getCreditSupportDocument()).ifPresent(builder::setCreditSupportDocument);
			ofNullable(getCreditSupportDocumentTerms()).ifPresent(builder::setCreditSupportDocumentTerms);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocumentElection _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCreditSuppportDocument, _that.getBespokeCreditSuppportDocument())) return false;
			if (!ListEquals.listEquals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportDocumentTerms, _that.getCreditSupportDocumentTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCreditSuppportDocument != null ? bespokeCreditSuppportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTerms != null ? creditSupportDocumentTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentElection {" +
				"bespokeCreditSuppportDocument=" + this.bespokeCreditSuppportDocument + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportDocumentTerms=" + this.creditSupportDocumentTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//CreditSupportDocumentElection.CreditSupportDocumentElectionBuilderImpl
	class CreditSupportDocumentElectionBuilderImpl implements CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder {
	
		protected String bespokeCreditSuppportDocument;
		protected List<RelatedAgreement.RelatedAgreementBuilder> creditSupportDocument = new ArrayList<>();
		protected CreditSupportDocumentTermsEnum creditSupportDocumentTerms;
		protected Party.PartyBuilder party;
	
		public CreditSupportDocumentElectionBuilderImpl() {
		}
	
		@Override
		public String getBespokeCreditSuppportDocument() {
			return bespokeCreditSuppportDocument;
		}
		
		@Override
		public List<? extends RelatedAgreement.RelatedAgreementBuilder> getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		public RelatedAgreement.RelatedAgreementBuilder getOrCreateCreditSupportDocument(int _index) {
		
			if (creditSupportDocument==null) {
				this.creditSupportDocument = new ArrayList<>();
			}
			RelatedAgreement.RelatedAgreementBuilder result;
			return getIndex(creditSupportDocument, _index, () -> {
						RelatedAgreement.RelatedAgreementBuilder newCreditSupportDocument = RelatedAgreement.builder();
						return newCreditSupportDocument;
					});
		}
		
		@Override
		public CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms() {
			return creditSupportDocumentTerms;
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
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setBespokeCreditSuppportDocument(String bespokeCreditSuppportDocument) {
			this.bespokeCreditSuppportDocument = bespokeCreditSuppportDocument==null?null:bespokeCreditSuppportDocument;
			return this;
		}
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(RelatedAgreement creditSupportDocument) {
			if (creditSupportDocument!=null) this.creditSupportDocument.add(creditSupportDocument.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(RelatedAgreement creditSupportDocument, int _idx) {
			getIndex(this.creditSupportDocument, _idx, () -> creditSupportDocument.toBuilder());
			return this;
		}
		@Override 
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(List<? extends RelatedAgreement> creditSupportDocuments) {
			if (creditSupportDocuments != null) {
				for (RelatedAgreement toAdd : creditSupportDocuments) {
					this.creditSupportDocument.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocument(List<? extends RelatedAgreement> creditSupportDocuments) {
			if (creditSupportDocuments == null)  {
				this.creditSupportDocument = new ArrayList<>();
			}
			else {
				this.creditSupportDocument = creditSupportDocuments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTerms(CreditSupportDocumentTermsEnum creditSupportDocumentTerms) {
			this.creditSupportDocumentTerms = creditSupportDocumentTerms==null?null:creditSupportDocumentTerms;
			return this;
		}
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setParty(Party party) {
			this.party = party==null?null:party.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection build() {
			return new CreditSupportDocumentElection.CreditSupportDocumentElectionImpl(this);
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder prune() {
			creditSupportDocument = creditSupportDocument.stream().filter(b->b!=null).<RelatedAgreement.RelatedAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeCreditSuppportDocument()!=null) return true;
			if (getCreditSupportDocument()!=null && getCreditSupportDocument().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportDocumentTerms()!=null) return true;
			if (getParty()!=null && getParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder o = (CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder) other;
			
			merger.mergeRosetta(getCreditSupportDocument(), o.getCreditSupportDocument(), this::getOrCreateCreditSupportDocument);
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getBespokeCreditSuppportDocument(), o.getBespokeCreditSuppportDocument(), this::setBespokeCreditSuppportDocument);
			merger.mergeBasic(getCreditSupportDocumentTerms(), o.getCreditSupportDocumentTerms(), this::setCreditSupportDocumentTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocumentElection _that = getType().cast(o);
		
			if (!Objects.equals(bespokeCreditSuppportDocument, _that.getBespokeCreditSuppportDocument())) return false;
			if (!ListEquals.listEquals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportDocumentTerms, _that.getCreditSupportDocumentTerms())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeCreditSuppportDocument != null ? bespokeCreditSuppportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTerms != null ? creditSupportDocumentTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentElectionBuilder {" +
				"bespokeCreditSuppportDocument=" + this.bespokeCreditSuppportDocument + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportDocumentTerms=" + this.creditSupportDocumentTerms + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
