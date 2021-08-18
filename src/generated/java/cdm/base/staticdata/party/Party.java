package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.PartyMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a party, without a qualification as to whether this party is a legal entity or a natural person, although the model provides the ability to associate a person (or set of persons) to a party, which use case would imply that such party would be a legal entity (even if not formally specified as such). 
 * @version ${project.version}
 */
@RosettaClass

public interface Party extends RosettaModelObject, GlobalKey {
	Party build();
	Party.PartyBuilder toBuilder();
	
	/**
	 * The account that might be associated with the party. At most one account can be specified, as it is expected that this information is used in the context of a contract or legal document where only one account per party can be associated with such object.
	 */
	Account getAccount();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The party name.
	 */
	FieldWithMetaString getName();
	/**
	 * The identifier associated with a party, e.g. the 20 digits LEI code.
	 */
	List<? extends FieldWithMetaString> getPartyId();
	/**
	 * The person(s) who might be associated with the party as part of the execution, contract or legal document.
	 */
	List<? extends NaturalPerson> getPerson();
	final static PartyMeta metaData = new PartyMeta();
	
	@Override
	default RosettaMetaData<? extends Party> metaData() {
		return metaData;
	} 
			
	static Party.PartyBuilder builder() {
		return new Party.PartyBuilderImpl();
	}
	
	default Class<? extends Party> getType() {
		return Party.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
		processRosetta(path.newSubPath("partyId"), processor, FieldWithMetaString.class, getPartyId());
		processRosetta(path.newSubPath("person"), processor, NaturalPerson.class, getPerson());
	}
	
	
	interface PartyBuilder extends Party, RosettaModelObjectBuilder {
		Account.AccountBuilder getOrCreateAccount();
		Account.AccountBuilder getAccount();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaStringBuilder getOrCreateName();
		FieldWithMetaStringBuilder getName();
		FieldWithMetaStringBuilder getOrCreatePartyId(int _index);
		List<? extends FieldWithMetaStringBuilder> getPartyId();
		NaturalPerson.NaturalPersonBuilder getOrCreatePerson(int _index);
		List<? extends NaturalPerson.NaturalPersonBuilder> getPerson();
		Party.PartyBuilder setAccount(Account account);
		Party.PartyBuilder setMeta(MetaFields meta);
		Party.PartyBuilder setName(FieldWithMetaString name);
		Party.PartyBuilder setNameValue(String name);
		Party.PartyBuilder addPartyId(FieldWithMetaString partyId);
		Party.PartyBuilder addPartyId(FieldWithMetaString partyId, int _idx);
		Party.PartyBuilder addPartyIdValue(String partyId);
		Party.PartyBuilder addPartyIdValue(String partyId, int _idx);
		Party.PartyBuilder addPartyId(List<? extends FieldWithMetaString> partyId);
		Party.PartyBuilder setPartyId(List<? extends FieldWithMetaString> partyId);
		Party.PartyBuilder addPartyIdValue(List<? extends String> partyId);
		Party.PartyBuilder setPartyIdValue(List<? extends String> partyId);
		Party.PartyBuilder addPerson(NaturalPerson person);
		Party.PartyBuilder addPerson(NaturalPerson person, int _idx);
		Party.PartyBuilder addPerson(List<? extends NaturalPerson> person);
		Party.PartyBuilder setPerson(List<? extends NaturalPerson> person);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaStringBuilder.class, getName());
			processRosetta(path.newSubPath("partyId"), processor, FieldWithMetaStringBuilder.class, getPartyId());
			processRosetta(path.newSubPath("person"), processor, NaturalPerson.NaturalPersonBuilder.class, getPerson());
		}
		
	}
	
	//Party.PartyImpl
	class PartyImpl implements Party {
		private final Account account;
		private final MetaFields meta;
		private final FieldWithMetaString name;
		private final List<? extends FieldWithMetaString> partyId;
		private final List<? extends NaturalPerson> person;
		
		protected PartyImpl(Party.PartyBuilder builder) {
			this.account = ofNullable(builder.getAccount()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.partyId = ofNullable(builder.getPartyId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.person = ofNullable(builder.getPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Account getAccount() {
			return account;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getPartyId() {
			return partyId;
		}
		
		@Override
		public List<? extends NaturalPerson> getPerson() {
			return person;
		}
		
		@Override
		public Party build() {
			return this;
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			Party.PartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Party.PartyBuilder builder) {
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getPartyId()).ifPresent(builder::setPartyId);
			ofNullable(getPerson()).ifPresent(builder::setPerson);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(account, _that.getAccount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Party {" +
				"account=" + this.account + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name + ", " +
				"partyId=" + this.partyId + ", " +
				"person=" + this.person +
			'}';
		}
	}
	
	//Party.PartyBuilderImpl
	class PartyBuilderImpl implements Party.PartyBuilder, GlobalKeyBuilder {
	
		protected Account.AccountBuilder account;
		protected MetaFields.MetaFieldsBuilder meta;
		protected FieldWithMetaStringBuilder name;
		protected List<FieldWithMetaStringBuilder> partyId = new ArrayList<>();
		protected List<NaturalPerson.NaturalPersonBuilder> person = new ArrayList<>();
	
		public PartyBuilderImpl() {
		}
	
		@Override
		public Account.AccountBuilder getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount() {
			Account.AccountBuilder result;
			if (account!=null) {
				result = account;
			}
			else {
				result = account = Account.builder();
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
		public FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getPartyId() {
			return partyId;
		}
		
		public FieldWithMetaStringBuilder getOrCreatePartyId(int _index) {
		
			if (partyId==null) {
				this.partyId = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(partyId, _index, () -> {
						FieldWithMetaStringBuilder newPartyId = FieldWithMetaString.builder();
						return newPartyId;
					});
		}
		
		@Override
		public List<? extends NaturalPerson.NaturalPersonBuilder> getPerson() {
			return person;
		}
		
		public NaturalPerson.NaturalPersonBuilder getOrCreatePerson(int _index) {
		
			if (person==null) {
				this.person = new ArrayList<>();
			}
			NaturalPerson.NaturalPersonBuilder result;
			return getIndex(person, _index, () -> {
						NaturalPerson.NaturalPersonBuilder newPerson = NaturalPerson.builder();
						return newPerson;
					});
		}
		
	
		@Override
		public Party.PartyBuilder setAccount(Account account) {
			this.account = account==null?null:account.toBuilder();
			return this;
		}
		@Override
		public Party.PartyBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Party.PartyBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		
		@Override
		public Party.PartyBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		@Override
		public Party.PartyBuilder addPartyId(FieldWithMetaString partyId) {
			if (partyId!=null) this.partyId.add(partyId.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyId(FieldWithMetaString partyId, int _idx) {
			getIndex(this.partyId, _idx, () -> partyId.toBuilder());
			return this;
		}
		
			@Override
			public Party.PartyBuilder addPartyIdValue(String partyId) {
				this.getOrCreatePartyId(-1).setValue(partyId);
				return this;
			}
			
			@Override
			public Party.PartyBuilder addPartyIdValue(String partyId, int _idx) {
				this.getOrCreatePartyId(_idx).setValue(partyId);
				return this;
			}
		@Override 
		public Party.PartyBuilder addPartyId(List<? extends FieldWithMetaString> partyIds) {
			if (partyIds != null) {
				for (FieldWithMetaString toAdd : partyIds) {
					this.partyId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Party.PartyBuilder setPartyId(List<? extends FieldWithMetaString> partyIds) {
			if (partyIds == null)  {
				this.partyId = new ArrayList<>();
			}
			else {
				this.partyId = partyIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyIdValue(List<? extends String> partyIds) {
			if (partyIds != null) {
				for (String toAdd : partyIds) {
					this.addPartyIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder setPartyIdValue(List<? extends String> partyIds) {
			this.partyId.clear();
			if (partyIds!=null) {
				partyIds.forEach(this::addPartyIdValue);
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPerson(NaturalPerson person) {
			if (person!=null) this.person.add(person.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPerson(NaturalPerson person, int _idx) {
			getIndex(this.person, _idx, () -> person.toBuilder());
			return this;
		}
		@Override 
		public Party.PartyBuilder addPerson(List<? extends NaturalPerson> persons) {
			if (persons != null) {
				for (NaturalPerson toAdd : persons) {
					this.person.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Party.PartyBuilder setPerson(List<? extends NaturalPerson> persons) {
			if (persons == null)  {
				this.person = new ArrayList<>();
			}
			else {
				this.person = persons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Party build() {
			return new Party.PartyImpl(this);
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder prune() {
			if (account!=null && !account.prune().hasData()) account = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (name!=null && !name.prune().hasData()) name = null;
			partyId = partyId.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			person = person.stream().filter(b->b!=null).<NaturalPerson.NaturalPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccount()!=null && getAccount().hasData()) return true;
			if (getName()!=null) return true;
			if (getPartyId()!=null && !getPartyId().isEmpty()) return true;
			if (getPerson()!=null && getPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Party.PartyBuilder o = (Party.PartyBuilder) other;
			
			merger.mergeRosetta(getAccount(), o.getAccount(), this::setAccount);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getPartyId(), o.getPartyId(), this::getOrCreatePartyId);
			merger.mergeRosetta(getPerson(), o.getPerson(), this::getOrCreatePerson);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(account, _that.getAccount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyBuilder {" +
				"account=" + this.account + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name + ", " +
				"partyId=" + this.partyId + ", " +
				"person=" + this.person +
			'}';
		}
	}
}
