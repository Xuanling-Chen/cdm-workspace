package cdm.legalagreement.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legalagreement.common.LegalAgreementBase.LegalAgreementBaseBuilder;
import cdm.legalagreement.common.LegalAgreementBase.LegalAgreementBaseBuilderImpl;
import cdm.legalagreement.common.LegalAgreementBase.LegalAgreementBaseImpl;
import cdm.legalagreement.common.meta.LegalAgreementMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The specification of a legal agreement between two parties, including the baseline information and the optional specification of agreement terms allowing .
 * @version ${project.version}
 */
@RosettaClass

public interface LegalAgreement extends LegalAgreementBase, GlobalKey {
	LegalAgreement build();
	LegalAgreement.LegalAgreementBuilder toBuilder();
	
	/**
	 * Specification of the content of the legal agreement.
	 */
	AgreementTerms getAgreementTerms();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Specifies the agreement(s) that govern the agreement, either as a reference to such agreements when specified as part of the CDM, or through identification of some of the key terms of those agreements, such as the type of agreement, the publisher, the vintage, the agreement identifier and the agreement date.
	 */
	List<? extends RelatedAgreement> getRelatedAgreements();
	/**
	 * The determination of whether Umbrella Agreement terms are applicable (True) or Not Applicable (False).
	 */
	UmbrellaAgreement getUmbrellaAgreement();
	final static LegalAgreementMeta metaData = new LegalAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends LegalAgreement> metaData() {
		return metaData;
	} 
			
	static LegalAgreement.LegalAgreementBuilder builder() {
		return new LegalAgreement.LegalAgreementBuilderImpl();
	}
	
	default Class<? extends LegalAgreement> getType() {
		return LegalAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.legalagreement.common.LegalAgreementBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("agreementTerms"), processor, AgreementTerms.class, getAgreementTerms());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("relatedAgreements"), processor, RelatedAgreement.class, getRelatedAgreements());
		processRosetta(path.newSubPath("umbrellaAgreement"), processor, UmbrellaAgreement.class, getUmbrellaAgreement());
	}
	
	
	interface LegalAgreementBuilder extends LegalAgreement, LegalAgreementBase.LegalAgreementBaseBuilder, RosettaModelObjectBuilder {
		AgreementTerms.AgreementTermsBuilder getOrCreateAgreementTerms();
		AgreementTerms.AgreementTermsBuilder getAgreementTerms();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		RelatedAgreement.RelatedAgreementBuilder getOrCreateRelatedAgreements(int _index);
		List<? extends RelatedAgreement.RelatedAgreementBuilder> getRelatedAgreements();
		UmbrellaAgreement.UmbrellaAgreementBuilder getOrCreateUmbrellaAgreement();
		UmbrellaAgreement.UmbrellaAgreementBuilder getUmbrellaAgreement();
		LegalAgreement.LegalAgreementBuilder setAgreementTerms(AgreementTerms agreementTerms);
		LegalAgreement.LegalAgreementBuilder setMeta(MetaFields meta);
		LegalAgreement.LegalAgreementBuilder addRelatedAgreements(RelatedAgreement relatedAgreements);
		LegalAgreement.LegalAgreementBuilder addRelatedAgreements(RelatedAgreement relatedAgreements, int _idx);
		LegalAgreement.LegalAgreementBuilder addRelatedAgreements(List<? extends RelatedAgreement> relatedAgreements);
		LegalAgreement.LegalAgreementBuilder setRelatedAgreements(List<? extends RelatedAgreement> relatedAgreements);
		LegalAgreement.LegalAgreementBuilder setUmbrellaAgreement(UmbrellaAgreement umbrellaAgreement);
		LegalAgreement.LegalAgreementBuilder setAgreementDate(Date agreementDate);
		LegalAgreement.LegalAgreementBuilder setAgreementType(LegalAgreementType agreementType);
		LegalAgreement.LegalAgreementBuilder addContractualParty(ReferenceWithMetaParty contractualParty);
		LegalAgreement.LegalAgreementBuilder addContractualParty(ReferenceWithMetaParty contractualParty, int _idx);
		LegalAgreement.LegalAgreementBuilder addContractualPartyValue(Party contractualParty);
		LegalAgreement.LegalAgreementBuilder addContractualPartyValue(Party contractualParty, int _idx);
		LegalAgreement.LegalAgreementBuilder addContractualParty(List<? extends ReferenceWithMetaParty> contractualParty);
		LegalAgreement.LegalAgreementBuilder setContractualParty(List<? extends ReferenceWithMetaParty> contractualParty);
		LegalAgreement.LegalAgreementBuilder addContractualPartyValue(List<? extends Party> contractualParty);
		LegalAgreement.LegalAgreementBuilder setContractualPartyValue(List<? extends Party> contractualParty);
		LegalAgreement.LegalAgreementBuilder setEffectiveDate(Date effectiveDate);
		LegalAgreement.LegalAgreementBuilder addIdentifier(Identifier identifier);
		LegalAgreement.LegalAgreementBuilder addIdentifier(Identifier identifier, int _idx);
		LegalAgreement.LegalAgreementBuilder addIdentifier(List<? extends Identifier> identifier);
		LegalAgreement.LegalAgreementBuilder setIdentifier(List<? extends Identifier> identifier);
		LegalAgreement.LegalAgreementBuilder addOtherParty(PartyRole otherParty);
		LegalAgreement.LegalAgreementBuilder addOtherParty(PartyRole otherParty, int _idx);
		LegalAgreement.LegalAgreementBuilder addOtherParty(List<? extends PartyRole> otherParty);
		LegalAgreement.LegalAgreementBuilder setOtherParty(List<? extends PartyRole> otherParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			LegalAgreementBase.LegalAgreementBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("agreementTerms"), processor, AgreementTerms.AgreementTermsBuilder.class, getAgreementTerms());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("relatedAgreements"), processor, RelatedAgreement.RelatedAgreementBuilder.class, getRelatedAgreements());
			processRosetta(path.newSubPath("umbrellaAgreement"), processor, UmbrellaAgreement.UmbrellaAgreementBuilder.class, getUmbrellaAgreement());
		}
		
	}
	
	//LegalAgreement.LegalAgreementImpl
	class LegalAgreementImpl extends LegalAgreementBase.LegalAgreementBaseImpl implements LegalAgreement {
		private final AgreementTerms agreementTerms;
		private final MetaFields meta;
		private final List<? extends RelatedAgreement> relatedAgreements;
		private final UmbrellaAgreement umbrellaAgreement;
		
		protected LegalAgreementImpl(LegalAgreement.LegalAgreementBuilder builder) {
			super(builder);
			this.agreementTerms = ofNullable(builder.getAgreementTerms()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.relatedAgreements = ofNullable(builder.getRelatedAgreements()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.umbrellaAgreement = ofNullable(builder.getUmbrellaAgreement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AgreementTerms getAgreementTerms() {
			return agreementTerms;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends RelatedAgreement> getRelatedAgreements() {
			return relatedAgreements;
		}
		
		@Override
		public UmbrellaAgreement getUmbrellaAgreement() {
			return umbrellaAgreement;
		}
		
		@Override
		public LegalAgreement build() {
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder toBuilder() {
			LegalAgreement.LegalAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalAgreement.LegalAgreementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAgreementTerms()).ifPresent(builder::setAgreementTerms);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getRelatedAgreements()).ifPresent(builder::setRelatedAgreements);
			ofNullable(getUmbrellaAgreement()).ifPresent(builder::setUmbrellaAgreement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegalAgreement _that = getType().cast(o);
		
			if (!Objects.equals(agreementTerms, _that.getAgreementTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(relatedAgreements, _that.getRelatedAgreements())) return false;
			if (!Objects.equals(umbrellaAgreement, _that.getUmbrellaAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (agreementTerms != null ? agreementTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (relatedAgreements != null ? relatedAgreements.hashCode() : 0);
			_result = 31 * _result + (umbrellaAgreement != null ? umbrellaAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreement {" +
				"agreementTerms=" + this.agreementTerms + ", " +
				"meta=" + this.meta + ", " +
				"relatedAgreements=" + this.relatedAgreements + ", " +
				"umbrellaAgreement=" + this.umbrellaAgreement +
			'}' + " " + super.toString();
		}
	}
	
	//LegalAgreement.LegalAgreementBuilderImpl
	class LegalAgreementBuilderImpl extends LegalAgreementBase.LegalAgreementBaseBuilderImpl  implements LegalAgreement.LegalAgreementBuilder, GlobalKeyBuilder {
	
		protected AgreementTerms.AgreementTermsBuilder agreementTerms;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<RelatedAgreement.RelatedAgreementBuilder> relatedAgreements = new ArrayList<>();
		protected UmbrellaAgreement.UmbrellaAgreementBuilder umbrellaAgreement;
	
		public LegalAgreementBuilderImpl() {
		}
	
		@Override
		public AgreementTerms.AgreementTermsBuilder getAgreementTerms() {
			return agreementTerms;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder getOrCreateAgreementTerms() {
			AgreementTerms.AgreementTermsBuilder result;
			if (agreementTerms!=null) {
				result = agreementTerms;
			}
			else {
				result = agreementTerms = AgreementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends RelatedAgreement.RelatedAgreementBuilder> getRelatedAgreements() {
			return relatedAgreements;
		}
		
		public RelatedAgreement.RelatedAgreementBuilder getOrCreateRelatedAgreements(int _index) {
		
			if (relatedAgreements==null) {
				this.relatedAgreements = new ArrayList<>();
			}
			RelatedAgreement.RelatedAgreementBuilder result;
			return getIndex(relatedAgreements, _index, () -> {
						RelatedAgreement.RelatedAgreementBuilder newRelatedAgreements = RelatedAgreement.builder();
						return newRelatedAgreements;
					});
		}
		
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder getUmbrellaAgreement() {
			return umbrellaAgreement;
		}
		
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder getOrCreateUmbrellaAgreement() {
			UmbrellaAgreement.UmbrellaAgreementBuilder result;
			if (umbrellaAgreement!=null) {
				result = umbrellaAgreement;
			}
			else {
				result = umbrellaAgreement = UmbrellaAgreement.builder();
			}
			
			return result;
		}
		
	
		@Override
		public LegalAgreement.LegalAgreementBuilder setAgreementTerms(AgreementTerms agreementTerms) {
			this.agreementTerms = agreementTerms==null?null:agreementTerms.toBuilder();
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder addRelatedAgreements(RelatedAgreement relatedAgreements) {
			if (relatedAgreements!=null) this.relatedAgreements.add(relatedAgreements.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addRelatedAgreements(RelatedAgreement relatedAgreements, int _idx) {
			getIndex(this.relatedAgreements, _idx, () -> relatedAgreements.toBuilder());
			return this;
		}
		@Override 
		public LegalAgreement.LegalAgreementBuilder addRelatedAgreements(List<? extends RelatedAgreement> relatedAgreementss) {
			if (relatedAgreementss != null) {
				for (RelatedAgreement toAdd : relatedAgreementss) {
					this.relatedAgreements.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreement.LegalAgreementBuilder setRelatedAgreements(List<? extends RelatedAgreement> relatedAgreementss) {
			if (relatedAgreementss == null)  {
				this.relatedAgreements = new ArrayList<>();
			}
			else {
				this.relatedAgreements = relatedAgreementss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder setUmbrellaAgreement(UmbrellaAgreement umbrellaAgreement) {
			this.umbrellaAgreement = umbrellaAgreement==null?null:umbrellaAgreement.toBuilder();
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder setAgreementDate(Date agreementDate) {
			this.agreementDate = agreementDate==null?null:agreementDate;
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder setAgreementType(LegalAgreementType agreementType) {
			this.agreementType = agreementType==null?null:agreementType.toBuilder();
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder addContractualParty(ReferenceWithMetaParty contractualParty) {
			if (contractualParty!=null) this.contractualParty.add(contractualParty.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addContractualParty(ReferenceWithMetaParty contractualParty, int _idx) {
			getIndex(this.contractualParty, _idx, () -> contractualParty.toBuilder());
			return this;
		}
		
			@Override
			public LegalAgreement.LegalAgreementBuilder addContractualPartyValue(Party contractualParty) {
				this.getOrCreateContractualParty(-1).setValue(contractualParty.toBuilder());
				return this;
			}
			
			@Override
			public LegalAgreement.LegalAgreementBuilder addContractualPartyValue(Party contractualParty, int _idx) {
				this.getOrCreateContractualParty(_idx).setValue(contractualParty.toBuilder());
				return this;
			}
		@Override 
		public LegalAgreement.LegalAgreementBuilder addContractualParty(List<? extends ReferenceWithMetaParty> contractualPartys) {
			if (contractualPartys != null) {
				for (ReferenceWithMetaParty toAdd : contractualPartys) {
					this.contractualParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreement.LegalAgreementBuilder setContractualParty(List<? extends ReferenceWithMetaParty> contractualPartys) {
			if (contractualPartys == null)  {
				this.contractualParty = new ArrayList<>();
			}
			else {
				this.contractualParty = contractualPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addContractualPartyValue(List<? extends Party> contractualPartys) {
			if (contractualPartys != null) {
				for (Party toAdd : contractualPartys) {
					this.addContractualPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder setContractualPartyValue(List<? extends Party> contractualPartys) {
			this.contractualParty.clear();
			if (contractualPartys!=null) {
				contractualPartys.forEach(this::addContractualPartyValue);
			}
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public LegalAgreement.LegalAgreementBuilder addIdentifier(Identifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addIdentifier(Identifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LegalAgreement.LegalAgreementBuilder addIdentifier(List<? extends Identifier> identifiers) {
			if (identifiers != null) {
				for (Identifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreement.LegalAgreementBuilder setIdentifier(List<? extends Identifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addOtherParty(PartyRole otherParty) {
			if (otherParty!=null) this.otherParty.add(otherParty.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder addOtherParty(PartyRole otherParty, int _idx) {
			getIndex(this.otherParty, _idx, () -> otherParty.toBuilder());
			return this;
		}
		@Override 
		public LegalAgreement.LegalAgreementBuilder addOtherParty(List<? extends PartyRole> otherPartys) {
			if (otherPartys != null) {
				for (PartyRole toAdd : otherPartys) {
					this.otherParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreement.LegalAgreementBuilder setOtherParty(List<? extends PartyRole> otherPartys) {
			if (otherPartys == null)  {
				this.otherParty = new ArrayList<>();
			}
			else {
				this.otherParty = otherPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LegalAgreement build() {
			return new LegalAgreement.LegalAgreementImpl(this);
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreement.LegalAgreementBuilder prune() {
			super.prune();
			if (agreementTerms!=null && !agreementTerms.prune().hasData()) agreementTerms = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			relatedAgreements = relatedAgreements.stream().filter(b->b!=null).<RelatedAgreement.RelatedAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (umbrellaAgreement!=null && !umbrellaAgreement.prune().hasData()) umbrellaAgreement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAgreementTerms()!=null && getAgreementTerms().hasData()) return true;
			if (getRelatedAgreements()!=null && getRelatedAgreements().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUmbrellaAgreement()!=null && getUmbrellaAgreement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreement.LegalAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LegalAgreement.LegalAgreementBuilder o = (LegalAgreement.LegalAgreementBuilder) other;
			
			merger.mergeRosetta(getAgreementTerms(), o.getAgreementTerms(), this::setAgreementTerms);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRelatedAgreements(), o.getRelatedAgreements(), this::getOrCreateRelatedAgreements);
			merger.mergeRosetta(getUmbrellaAgreement(), o.getUmbrellaAgreement(), this::setUmbrellaAgreement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegalAgreement _that = getType().cast(o);
		
			if (!Objects.equals(agreementTerms, _that.getAgreementTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(relatedAgreements, _that.getRelatedAgreements())) return false;
			if (!Objects.equals(umbrellaAgreement, _that.getUmbrellaAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (agreementTerms != null ? agreementTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (relatedAgreements != null ? relatedAgreements.hashCode() : 0);
			_result = 31 * _result + (umbrellaAgreement != null ? umbrellaAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreementBuilder {" +
				"agreementTerms=" + this.agreementTerms + ", " +
				"meta=" + this.meta + ", " +
				"relatedAgreements=" + this.relatedAgreements + ", " +
				"umbrellaAgreement=" + this.umbrellaAgreement +
			'}' + " " + super.toString();
		}
	}
}
