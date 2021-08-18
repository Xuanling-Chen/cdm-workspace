package cdm.legalagreement.contract;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.CategoryEnum;
import cdm.base.staticdata.party.CategoryEnum;
import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.legalagreement.contract.meta.PartyContractInformationMeta;
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
 * A class defining party-specific additional information that may be recorded with respect to a contract.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyContractInformation extends RosettaModelObject {
	PartyContractInformation build();
	PartyContractInformation.PartyContractInformationBuilder toBuilder();
	
	/**
	 * Reference to an account.
	 */
	ReferenceWithMetaAccount getAccountReference();
	/**
	 * The qualification of the trade by the counterparty, e.g. customer or principal. This information is relevant for a number of marketplace processes, such as regulatory reporting or clearing.
	 */
	FieldWithMetaCategoryEnum getCategory();
	/**
	 * The role(s) that natural person(s) may have in relation to the contract.
	 */
	List<? extends NaturalPersonRole> getNaturalPersonRole();
	/**
	 * The reference to the party that owns this party contract information or, in the case of shared trades information, the reference that originated such information.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 */
	RelatedParty getRelatedParty();
	final static PartyContractInformationMeta metaData = new PartyContractInformationMeta();
	
	@Override
	default RosettaMetaData<? extends PartyContractInformation> metaData() {
		return metaData;
	} 
			
	static PartyContractInformation.PartyContractInformationBuilder builder() {
		return new PartyContractInformation.PartyContractInformationBuilderImpl();
	}
	
	default Class<? extends PartyContractInformation> getType() {
		return PartyContractInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("accountReference"), processor, ReferenceWithMetaAccount.class, getAccountReference());
		processRosetta(path.newSubPath("category"), processor, FieldWithMetaCategoryEnum.class, getCategory());
		processRosetta(path.newSubPath("naturalPersonRole"), processor, NaturalPersonRole.class, getNaturalPersonRole());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
	}
	
	
	interface PartyContractInformationBuilder extends PartyContractInformation, RosettaModelObjectBuilder {
		ReferenceWithMetaAccountBuilder getOrCreateAccountReference();
		ReferenceWithMetaAccountBuilder getAccountReference();
		FieldWithMetaCategoryEnumBuilder getOrCreateCategory();
		FieldWithMetaCategoryEnumBuilder getCategory();
		NaturalPersonRole.NaturalPersonRoleBuilder getOrCreateNaturalPersonRole(int _index);
		List<? extends NaturalPersonRole.NaturalPersonRoleBuilder> getNaturalPersonRole();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty();
		RelatedParty.RelatedPartyBuilder getRelatedParty();
		PartyContractInformation.PartyContractInformationBuilder setAccountReference(ReferenceWithMetaAccount accountReference);
		PartyContractInformation.PartyContractInformationBuilder setAccountReferenceValue(Account accountReference);
		PartyContractInformation.PartyContractInformationBuilder setCategory(FieldWithMetaCategoryEnum category);
		PartyContractInformation.PartyContractInformationBuilder setCategoryValue(CategoryEnum category);
		PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(NaturalPersonRole naturalPersonRole);
		PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(NaturalPersonRole naturalPersonRole, int _idx);
		PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(List<? extends NaturalPersonRole> naturalPersonRole);
		PartyContractInformation.PartyContractInformationBuilder setNaturalPersonRole(List<? extends NaturalPersonRole> naturalPersonRole);
		PartyContractInformation.PartyContractInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyContractInformation.PartyContractInformationBuilder setPartyReferenceValue(Party partyReference);
		PartyContractInformation.PartyContractInformationBuilder setRelatedParty(RelatedParty relatedParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("accountReference"), processor, ReferenceWithMetaAccountBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("category"), processor, FieldWithMetaCategoryEnumBuilder.class, getCategory());
			processRosetta(path.newSubPath("naturalPersonRole"), processor, NaturalPersonRole.NaturalPersonRoleBuilder.class, getNaturalPersonRole());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
		}
		
	}
	
	//PartyContractInformation.PartyContractInformationImpl
	class PartyContractInformationImpl implements PartyContractInformation {
		private final ReferenceWithMetaAccount accountReference;
		private final FieldWithMetaCategoryEnum category;
		private final List<? extends NaturalPersonRole> naturalPersonRole;
		private final ReferenceWithMetaParty partyReference;
		private final RelatedParty relatedParty;
		
		protected PartyContractInformationImpl(PartyContractInformation.PartyContractInformationBuilder builder) {
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.category = ofNullable(builder.getCategory()).map(f->f.build()).orElse(null);
			this.naturalPersonRole = ofNullable(builder.getNaturalPersonRole()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaAccount getAccountReference() {
			return accountReference;
		}
		
		@Override
		public FieldWithMetaCategoryEnum getCategory() {
			return category;
		}
		
		@Override
		public List<? extends NaturalPersonRole> getNaturalPersonRole() {
			return naturalPersonRole;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public RelatedParty getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public PartyContractInformation build() {
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder toBuilder() {
			PartyContractInformation.PartyContractInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyContractInformation.PartyContractInformationBuilder builder) {
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getNaturalPersonRole()).ifPresent(builder::setNaturalPersonRole);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyContractInformation _that = getType().cast(o);
		
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(naturalPersonRole, _that.getNaturalPersonRole())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (naturalPersonRole != null ? naturalPersonRole.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyContractInformation {" +
				"accountReference=" + this.accountReference + ", " +
				"category=" + this.category + ", " +
				"naturalPersonRole=" + this.naturalPersonRole + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
	
	//PartyContractInformation.PartyContractInformationBuilderImpl
	class PartyContractInformationBuilderImpl implements PartyContractInformation.PartyContractInformationBuilder {
	
		protected ReferenceWithMetaAccountBuilder accountReference;
		protected FieldWithMetaCategoryEnumBuilder category;
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRole = new ArrayList<>();
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected RelatedParty.RelatedPartyBuilder relatedParty;
	
		public PartyContractInformationBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaAccountBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateAccountReference() {
			ReferenceWithMetaAccountBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaCategoryEnumBuilder getCategory() {
			return category;
		}
		
		@Override
		public FieldWithMetaCategoryEnumBuilder getOrCreateCategory() {
			FieldWithMetaCategoryEnumBuilder result;
			if (category!=null) {
				result = category;
			}
			else {
				result = category = FieldWithMetaCategoryEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends NaturalPersonRole.NaturalPersonRoleBuilder> getNaturalPersonRole() {
			return naturalPersonRole;
		}
		
		public NaturalPersonRole.NaturalPersonRoleBuilder getOrCreateNaturalPersonRole(int _index) {
		
			if (naturalPersonRole==null) {
				this.naturalPersonRole = new ArrayList<>();
			}
			NaturalPersonRole.NaturalPersonRoleBuilder result;
			return getIndex(naturalPersonRole, _index, () -> {
						NaturalPersonRole.NaturalPersonRoleBuilder newNaturalPersonRole = NaturalPersonRole.builder();
						return newNaturalPersonRole;
					});
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty() {
			RelatedParty.RelatedPartyBuilder result;
			if (relatedParty!=null) {
				result = relatedParty;
			}
			else {
				result = relatedParty = RelatedParty.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setAccountReference(ReferenceWithMetaAccount accountReference) {
			this.accountReference = accountReference==null?null:accountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setAccountReferenceValue(Account accountReference) {
			this.getOrCreateAccountReference().setValue(accountReference);
			return this;
		}
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setCategory(FieldWithMetaCategoryEnum category) {
			this.category = category==null?null:category.toBuilder();
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setCategoryValue(CategoryEnum category) {
			this.getOrCreateCategory().setValue(category);
			return this;
		}
		@Override
		public PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(NaturalPersonRole naturalPersonRole) {
			if (naturalPersonRole!=null) this.naturalPersonRole.add(naturalPersonRole.toBuilder());
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(NaturalPersonRole naturalPersonRole, int _idx) {
			getIndex(this.naturalPersonRole, _idx, () -> naturalPersonRole.toBuilder());
			return this;
		}
		@Override 
		public PartyContractInformation.PartyContractInformationBuilder addNaturalPersonRole(List<? extends NaturalPersonRole> naturalPersonRoles) {
			if (naturalPersonRoles != null) {
				for (NaturalPersonRole toAdd : naturalPersonRoles) {
					this.naturalPersonRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyContractInformation.PartyContractInformationBuilder setNaturalPersonRole(List<? extends NaturalPersonRole> naturalPersonRoles) {
			if (naturalPersonRoles == null)  {
				this.naturalPersonRole = new ArrayList<>();
			}
			else {
				this.naturalPersonRole = naturalPersonRoles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public PartyContractInformation.PartyContractInformationBuilder setRelatedParty(RelatedParty relatedParty) {
			this.relatedParty = relatedParty==null?null:relatedParty.toBuilder();
			return this;
		}
		
		@Override
		public PartyContractInformation build() {
			return new PartyContractInformation.PartyContractInformationImpl(this);
		}
		
		@Override
		public PartyContractInformation.PartyContractInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyContractInformation.PartyContractInformationBuilder prune() {
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			if (category!=null && !category.prune().hasData()) category = null;
			naturalPersonRole = naturalPersonRole.stream().filter(b->b!=null).<NaturalPersonRole.NaturalPersonRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (relatedParty!=null && !relatedParty.prune().hasData()) relatedParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getCategory()!=null) return true;
			if (getNaturalPersonRole()!=null && getNaturalPersonRole().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyContractInformation.PartyContractInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyContractInformation.PartyContractInformationBuilder o = (PartyContractInformation.PartyContractInformationBuilder) other;
			
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::setCategory);
			merger.mergeRosetta(getNaturalPersonRole(), o.getNaturalPersonRole(), this::getOrCreateNaturalPersonRole);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::setRelatedParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyContractInformation _that = getType().cast(o);
		
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(naturalPersonRole, _that.getNaturalPersonRole())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (naturalPersonRole != null ? naturalPersonRole.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyContractInformationBuilder {" +
				"accountReference=" + this.accountReference + ", " +
				"category=" + this.category + ", " +
				"naturalPersonRole=" + this.naturalPersonRole + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
}
