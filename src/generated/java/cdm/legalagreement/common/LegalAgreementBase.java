package cdm.legalagreement.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.legalagreement.common.meta.LegalAgreementBaseMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class describing the legal agreement baseline information, other than the specialized elections: type of legal agreement, agreement date and effective date, parties to the agreement, ... The purpose of this abstract class is to provide the ability to associate a &#39;one of&#39; feature to the LegalAgreement class as a way to enforce a systematic choice between its attributes.
 * @version ${project.version}
 */
@RosettaClass

public interface LegalAgreementBase extends RosettaModelObject {
	LegalAgreementBase build();
	LegalAgreementBase.LegalAgreementBaseBuilder toBuilder();
	
	/**
	 * The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
	 */
	Date getAgreementDate();
	/**
	 * The type of legal agreement, identified via a set of distinct attributes: name, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
	 */
	LegalAgreementType getAgreementType();
	/**
	 * The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
	 */
	List<? extends ReferenceWithMetaParty> getContractualParty();
	/**
	 * The date on which, or as of which, the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
	 */
	Date getEffectiveDate();
	/**
	 * The legal agreement identifier. Several identifiers can be specified.
	 */
	List<? extends Identifier> getIdentifier();
	/**
	 * The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
	 */
	List<? extends PartyRole> getOtherParty();
	final static LegalAgreementBaseMeta metaData = new LegalAgreementBaseMeta();
	
	@Override
	default RosettaMetaData<? extends LegalAgreementBase> metaData() {
		return metaData;
	} 
			
	static LegalAgreementBase.LegalAgreementBaseBuilder builder() {
		return new LegalAgreementBase.LegalAgreementBaseBuilderImpl();
	}
	
	default Class<? extends LegalAgreementBase> getType() {
		return LegalAgreementBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("agreementDate"), Date.class, getAgreementDate(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		
		processRosetta(path.newSubPath("agreementType"), processor, LegalAgreementType.class, getAgreementType());
		processRosetta(path.newSubPath("contractualParty"), processor, ReferenceWithMetaParty.class, getContractualParty());
		processRosetta(path.newSubPath("identifier"), processor, Identifier.class, getIdentifier());
		processRosetta(path.newSubPath("otherParty"), processor, PartyRole.class, getOtherParty());
	}
	
	
	interface LegalAgreementBaseBuilder extends LegalAgreementBase, RosettaModelObjectBuilder {
		LegalAgreementType.LegalAgreementTypeBuilder getOrCreateAgreementType();
		LegalAgreementType.LegalAgreementTypeBuilder getAgreementType();
		ReferenceWithMetaPartyBuilder getOrCreateContractualParty(int _index);
		List<? extends ReferenceWithMetaPartyBuilder> getContractualParty();
		Identifier.IdentifierBuilder getOrCreateIdentifier(int _index);
		List<? extends Identifier.IdentifierBuilder> getIdentifier();
		PartyRole.PartyRoleBuilder getOrCreateOtherParty(int _index);
		List<? extends PartyRole.PartyRoleBuilder> getOtherParty();
		LegalAgreementBase.LegalAgreementBaseBuilder setAgreementDate(Date agreementDate);
		LegalAgreementBase.LegalAgreementBaseBuilder setAgreementType(LegalAgreementType agreementType);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(ReferenceWithMetaParty contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(ReferenceWithMetaParty contractualParty, int _idx);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(Party contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(Party contractualParty, int _idx);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(List<? extends ReferenceWithMetaParty> contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder setContractualParty(List<? extends ReferenceWithMetaParty> contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(List<? extends Party> contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder setContractualPartyValue(List<? extends Party> contractualParty);
		LegalAgreementBase.LegalAgreementBaseBuilder setEffectiveDate(Date effectiveDate);
		LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(Identifier identifier);
		LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(Identifier identifier, int _idx);
		LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(List<? extends Identifier> identifier);
		LegalAgreementBase.LegalAgreementBaseBuilder setIdentifier(List<? extends Identifier> identifier);
		LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(PartyRole otherParty);
		LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(PartyRole otherParty, int _idx);
		LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(List<? extends PartyRole> otherParty);
		LegalAgreementBase.LegalAgreementBaseBuilder setOtherParty(List<? extends PartyRole> otherParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("agreementDate"), Date.class, getAgreementDate(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			
			processRosetta(path.newSubPath("agreementType"), processor, LegalAgreementType.LegalAgreementTypeBuilder.class, getAgreementType());
			processRosetta(path.newSubPath("contractualParty"), processor, ReferenceWithMetaPartyBuilder.class, getContractualParty());
			processRosetta(path.newSubPath("identifier"), processor, Identifier.IdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("otherParty"), processor, PartyRole.PartyRoleBuilder.class, getOtherParty());
		}
		
	}
	
	//LegalAgreementBase.LegalAgreementBaseImpl
	class LegalAgreementBaseImpl implements LegalAgreementBase {
		private final Date agreementDate;
		private final LegalAgreementType agreementType;
		private final List<? extends ReferenceWithMetaParty> contractualParty;
		private final Date effectiveDate;
		private final List<? extends Identifier> identifier;
		private final List<? extends PartyRole> otherParty;
		
		protected LegalAgreementBaseImpl(LegalAgreementBase.LegalAgreementBaseBuilder builder) {
			this.agreementDate = builder.getAgreementDate();
			this.agreementType = ofNullable(builder.getAgreementType()).map(f->f.build()).orElse(null);
			this.contractualParty = ofNullable(builder.getContractualParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.otherParty = ofNullable(builder.getOtherParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Date getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		public LegalAgreementType getAgreementType() {
			return agreementType;
		}
		
		@Override
		public List<? extends ReferenceWithMetaParty> getContractualParty() {
			return contractualParty;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends Identifier> getIdentifier() {
			return identifier;
		}
		
		@Override
		public List<? extends PartyRole> getOtherParty() {
			return otherParty;
		}
		
		@Override
		public LegalAgreementBase build() {
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder toBuilder() {
			LegalAgreementBase.LegalAgreementBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalAgreementBase.LegalAgreementBaseBuilder builder) {
			ofNullable(getAgreementDate()).ifPresent(builder::setAgreementDate);
			ofNullable(getAgreementType()).ifPresent(builder::setAgreementType);
			ofNullable(getContractualParty()).ifPresent(builder::setContractualParty);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getOtherParty()).ifPresent(builder::setOtherParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalAgreementBase _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(agreementType, _that.getAgreementType())) return false;
			if (!ListEquals.listEquals(contractualParty, _that.getContractualParty())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (agreementType != null ? agreementType.hashCode() : 0);
			_result = 31 * _result + (contractualParty != null ? contractualParty.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreementBase {" +
				"agreementDate=" + this.agreementDate + ", " +
				"agreementType=" + this.agreementType + ", " +
				"contractualParty=" + this.contractualParty + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"identifier=" + this.identifier + ", " +
				"otherParty=" + this.otherParty +
			'}';
		}
	}
	
	//LegalAgreementBase.LegalAgreementBaseBuilderImpl
	class LegalAgreementBaseBuilderImpl implements LegalAgreementBase.LegalAgreementBaseBuilder {
	
		protected Date agreementDate;
		protected LegalAgreementType.LegalAgreementTypeBuilder agreementType;
		protected List<ReferenceWithMetaPartyBuilder> contractualParty = new ArrayList<>();
		protected Date effectiveDate;
		protected List<Identifier.IdentifierBuilder> identifier = new ArrayList<>();
		protected List<PartyRole.PartyRoleBuilder> otherParty = new ArrayList<>();
	
		public LegalAgreementBaseBuilderImpl() {
		}
	
		@Override
		public Date getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder getAgreementType() {
			return agreementType;
		}
		
		@Override
		public LegalAgreementType.LegalAgreementTypeBuilder getOrCreateAgreementType() {
			LegalAgreementType.LegalAgreementTypeBuilder result;
			if (agreementType!=null) {
				result = agreementType;
			}
			else {
				result = agreementType = LegalAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ReferenceWithMetaPartyBuilder> getContractualParty() {
			return contractualParty;
		}
		
		public ReferenceWithMetaPartyBuilder getOrCreateContractualParty(int _index) {
		
			if (contractualParty==null) {
				this.contractualParty = new ArrayList<>();
			}
			ReferenceWithMetaPartyBuilder result;
			return getIndex(contractualParty, _index, () -> {
						ReferenceWithMetaPartyBuilder newContractualParty = ReferenceWithMetaParty.builder();
						return newContractualParty;
					});
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public List<? extends Identifier.IdentifierBuilder> getIdentifier() {
			return identifier;
		}
		
		public Identifier.IdentifierBuilder getOrCreateIdentifier(int _index) {
		
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(identifier, _index, () -> {
						Identifier.IdentifierBuilder newIdentifier = Identifier.builder();
						return newIdentifier;
					});
		}
		
		@Override
		public List<? extends PartyRole.PartyRoleBuilder> getOtherParty() {
			return otherParty;
		}
		
		public PartyRole.PartyRoleBuilder getOrCreateOtherParty(int _index) {
		
			if (otherParty==null) {
				this.otherParty = new ArrayList<>();
			}
			PartyRole.PartyRoleBuilder result;
			return getIndex(otherParty, _index, () -> {
						PartyRole.PartyRoleBuilder newOtherParty = PartyRole.builder();
						return newOtherParty;
					});
		}
		
	
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder setAgreementDate(Date agreementDate) {
			this.agreementDate = agreementDate==null?null:agreementDate;
			return this;
		}
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder setAgreementType(LegalAgreementType agreementType) {
			this.agreementType = agreementType==null?null:agreementType.toBuilder();
			return this;
		}
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(ReferenceWithMetaParty contractualParty) {
			if (contractualParty!=null) this.contractualParty.add(contractualParty.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(ReferenceWithMetaParty contractualParty, int _idx) {
			getIndex(this.contractualParty, _idx, () -> contractualParty.toBuilder());
			return this;
		}
		
			@Override
			public LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(Party contractualParty) {
				this.getOrCreateContractualParty(-1).setValue(contractualParty.toBuilder());
				return this;
			}
			
			@Override
			public LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(Party contractualParty, int _idx) {
				this.getOrCreateContractualParty(_idx).setValue(contractualParty.toBuilder());
				return this;
			}
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder addContractualParty(List<? extends ReferenceWithMetaParty> contractualPartys) {
			if (contractualPartys != null) {
				for (ReferenceWithMetaParty toAdd : contractualPartys) {
					this.contractualParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder setContractualParty(List<? extends ReferenceWithMetaParty> contractualPartys) {
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
		public LegalAgreementBase.LegalAgreementBaseBuilder addContractualPartyValue(List<? extends Party> contractualPartys) {
			if (contractualPartys != null) {
				for (Party toAdd : contractualPartys) {
					this.addContractualPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder setContractualPartyValue(List<? extends Party> contractualPartys) {
			this.contractualParty.clear();
			if (contractualPartys!=null) {
				contractualPartys.forEach(this::addContractualPartyValue);
			}
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(Identifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(Identifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder addIdentifier(List<? extends Identifier> identifiers) {
			if (identifiers != null) {
				for (Identifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder setIdentifier(List<? extends Identifier> identifiers) {
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
		public LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(PartyRole otherParty) {
			if (otherParty!=null) this.otherParty.add(otherParty.toBuilder());
			return this;
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(PartyRole otherParty, int _idx) {
			getIndex(this.otherParty, _idx, () -> otherParty.toBuilder());
			return this;
		}
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder addOtherParty(List<? extends PartyRole> otherPartys) {
			if (otherPartys != null) {
				for (PartyRole toAdd : otherPartys) {
					this.otherParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalAgreementBase.LegalAgreementBaseBuilder setOtherParty(List<? extends PartyRole> otherPartys) {
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
		public LegalAgreementBase build() {
			return new LegalAgreementBase.LegalAgreementBaseImpl(this);
		}
		
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder prune() {
			if (agreementType!=null && !agreementType.prune().hasData()) agreementType = null;
			contractualParty = contractualParty.stream().filter(b->b!=null).<ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			identifier = identifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			otherParty = otherParty.stream().filter(b->b!=null).<PartyRole.PartyRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreementDate()!=null) return true;
			if (getAgreementType()!=null && getAgreementType().hasData()) return true;
			if (getContractualParty()!=null && getContractualParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEffectiveDate()!=null) return true;
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOtherParty()!=null && getOtherParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalAgreementBase.LegalAgreementBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalAgreementBase.LegalAgreementBaseBuilder o = (LegalAgreementBase.LegalAgreementBaseBuilder) other;
			
			merger.mergeRosetta(getAgreementType(), o.getAgreementType(), this::setAgreementType);
			merger.mergeRosetta(getContractualParty(), o.getContractualParty(), this::getOrCreateContractualParty);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(getOtherParty(), o.getOtherParty(), this::getOrCreateOtherParty);
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalAgreementBase _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(agreementType, _that.getAgreementType())) return false;
			if (!ListEquals.listEquals(contractualParty, _that.getContractualParty())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!ListEquals.listEquals(otherParty, _that.getOtherParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (agreementType != null ? agreementType.hashCode() : 0);
			_result = 31 * _result + (contractualParty != null ? contractualParty.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (otherParty != null ? otherParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalAgreementBaseBuilder {" +
				"agreementDate=" + this.agreementDate + ", " +
				"agreementType=" + this.agreementType + ", " +
				"contractualParty=" + this.contractualParty + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"identifier=" + this.identifier + ", " +
				"otherParty=" + this.otherParty +
			'}';
		}
	}
}
