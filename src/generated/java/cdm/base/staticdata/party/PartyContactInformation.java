package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.PartyContactInformationMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
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
 * A class to specify contact information within a party: address and, optionally, associated business unit and person. This class also supports the ISDA CSA representation as a single string, through the address attribute.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyContactInformation extends RosettaModelObject {
	PartyContactInformation build();
	PartyContactInformation.PartyContactInformationBuilder toBuilder();
	
	/**
	 * Specification of special instructions of the relevant party.
	 */
	String getAdditionalInformation();
	/**
	 * The address specified as a string to support non-normalized contact information, such as in the case of ISDA Create.
	 */
	String getAddress();
	/**
	 * Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
	 */
	List<? extends BusinessUnit> getBusinessUnit();
	/**
	 * The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.
	 */
	ContactInformation getContactInformation();
	/**
	 * The reference to the party to which the contact information refers to.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * Optional information about people involved in a transaction or business process. (These are employees of the party.)
	 */
	List<? extends NaturalPerson> getPerson();
	final static PartyContactInformationMeta metaData = new PartyContactInformationMeta();
	
	@Override
	default RosettaMetaData<? extends PartyContactInformation> metaData() {
		return metaData;
	} 
			
	static PartyContactInformation.PartyContactInformationBuilder builder() {
		return new PartyContactInformation.PartyContactInformationBuilderImpl();
	}
	
	default Class<? extends PartyContactInformation> getType() {
		return PartyContactInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalInformation"), String.class, getAdditionalInformation(), this);
		processor.processBasic(path.newSubPath("address"), String.class, getAddress(), this);
		
		processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.class, getBusinessUnit());
		processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.class, getContactInformation());
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processRosetta(path.newSubPath("person"), processor, NaturalPerson.class, getPerson());
	}
	
	
	interface PartyContactInformationBuilder extends PartyContactInformation, RosettaModelObjectBuilder {
		BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int _index);
		List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit();
		ContactInformation.ContactInformationBuilder getOrCreateContactInformation();
		ContactInformation.ContactInformationBuilder getContactInformation();
		ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		ReferenceWithMetaPartyBuilder getPartyReference();
		NaturalPerson.NaturalPersonBuilder getOrCreatePerson(int _index);
		List<? extends NaturalPerson.NaturalPersonBuilder> getPerson();
		PartyContactInformation.PartyContactInformationBuilder setAdditionalInformation(String additionalInformation);
		PartyContactInformation.PartyContactInformationBuilder setAddress(String address);
		PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(BusinessUnit businessUnit);
		PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(BusinessUnit businessUnit, int _idx);
		PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnit);
		PartyContactInformation.PartyContactInformationBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnit);
		PartyContactInformation.PartyContactInformationBuilder setContactInformation(ContactInformation contactInformation);
		PartyContactInformation.PartyContactInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyContactInformation.PartyContactInformationBuilder setPartyReferenceValue(Party partyReference);
		PartyContactInformation.PartyContactInformationBuilder addPerson(NaturalPerson person);
		PartyContactInformation.PartyContactInformationBuilder addPerson(NaturalPerson person, int _idx);
		PartyContactInformation.PartyContactInformationBuilder addPerson(List<? extends NaturalPerson> person);
		PartyContactInformation.PartyContactInformationBuilder setPerson(List<? extends NaturalPerson> person);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalInformation"), String.class, getAdditionalInformation(), this);
			processor.processBasic(path.newSubPath("address"), String.class, getAddress(), this);
			
			processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.BusinessUnitBuilder.class, getBusinessUnit());
			processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.ContactInformationBuilder.class, getContactInformation());
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("person"), processor, NaturalPerson.NaturalPersonBuilder.class, getPerson());
		}
		
	}
	
	//PartyContactInformation.PartyContactInformationImpl
	class PartyContactInformationImpl implements PartyContactInformation {
		private final String additionalInformation;
		private final String address;
		private final List<? extends BusinessUnit> businessUnit;
		private final ContactInformation contactInformation;
		private final ReferenceWithMetaParty partyReference;
		private final List<? extends NaturalPerson> person;
		
		protected PartyContactInformationImpl(PartyContactInformation.PartyContactInformationBuilder builder) {
			this.additionalInformation = builder.getAdditionalInformation();
			this.address = builder.getAddress();
			this.businessUnit = ofNullable(builder.getBusinessUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contactInformation = ofNullable(builder.getContactInformation()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.person = ofNullable(builder.getPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public String getAdditionalInformation() {
			return additionalInformation;
		}
		
		@Override
		public String getAddress() {
			return address;
		}
		
		@Override
		public List<? extends BusinessUnit> getBusinessUnit() {
			return businessUnit;
		}
		
		@Override
		public ContactInformation getContactInformation() {
			return contactInformation;
		}
		
		@Override
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		public List<? extends NaturalPerson> getPerson() {
			return person;
		}
		
		@Override
		public PartyContactInformation build() {
			return this;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder toBuilder() {
			PartyContactInformation.PartyContactInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyContactInformation.PartyContactInformationBuilder builder) {
			ofNullable(getAdditionalInformation()).ifPresent(builder::setAdditionalInformation);
			ofNullable(getAddress()).ifPresent(builder::setAddress);
			ofNullable(getBusinessUnit()).ifPresent(builder::setBusinessUnit);
			ofNullable(getContactInformation()).ifPresent(builder::setContactInformation);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPerson()).ifPresent(builder::setPerson);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyContactInformation _that = getType().cast(o);
		
			if (!Objects.equals(additionalInformation, _that.getAdditionalInformation())) return false;
			if (!Objects.equals(address, _that.getAddress())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
			_result = 31 * _result + (address != null ? address.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyContactInformation {" +
				"additionalInformation=" + this.additionalInformation + ", " +
				"address=" + this.address + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"contactInformation=" + this.contactInformation + ", " +
				"partyReference=" + this.partyReference + ", " +
				"person=" + this.person +
			'}';
		}
	}
	
	//PartyContactInformation.PartyContactInformationBuilderImpl
	class PartyContactInformationBuilderImpl implements PartyContactInformation.PartyContactInformationBuilder {
	
		protected String additionalInformation;
		protected String address;
		protected List<BusinessUnit.BusinessUnitBuilder> businessUnit = new ArrayList<>();
		protected ContactInformation.ContactInformationBuilder contactInformation;
		protected ReferenceWithMetaPartyBuilder partyReference;
		protected List<NaturalPerson.NaturalPersonBuilder> person = new ArrayList<>();
	
		public PartyContactInformationBuilderImpl() {
		}
	
		@Override
		public String getAdditionalInformation() {
			return additionalInformation;
		}
		
		@Override
		public String getAddress() {
			return address;
		}
		
		@Override
		public List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit() {
			return businessUnit;
		}
		
		public BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int _index) {
		
			if (businessUnit==null) {
				this.businessUnit = new ArrayList<>();
			}
			BusinessUnit.BusinessUnitBuilder result;
			return getIndex(businessUnit, _index, () -> {
						BusinessUnit.BusinessUnitBuilder newBusinessUnit = BusinessUnit.builder();
						return newBusinessUnit;
					});
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder getContactInformation() {
			return contactInformation;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder getOrCreateContactInformation() {
			ContactInformation.ContactInformationBuilder result;
			if (contactInformation!=null) {
				result = contactInformation;
			}
			else {
				result = contactInformation = ContactInformation.builder();
			}
			
			return result;
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
		public PartyContactInformation.PartyContactInformationBuilder setAdditionalInformation(String additionalInformation) {
			this.additionalInformation = additionalInformation==null?null:additionalInformation;
			return this;
		}
		@Override
		public PartyContactInformation.PartyContactInformationBuilder setAddress(String address) {
			this.address = address==null?null:address;
			return this;
		}
		@Override
		public PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(BusinessUnit businessUnit) {
			if (businessUnit!=null) this.businessUnit.add(businessUnit.toBuilder());
			return this;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(BusinessUnit businessUnit, int _idx) {
			getIndex(this.businessUnit, _idx, () -> businessUnit.toBuilder());
			return this;
		}
		@Override 
		public PartyContactInformation.PartyContactInformationBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits != null) {
				for (BusinessUnit toAdd : businessUnits) {
					this.businessUnit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyContactInformation.PartyContactInformationBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits == null)  {
				this.businessUnit = new ArrayList<>();
			}
			else {
				this.businessUnit = businessUnits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder setContactInformation(ContactInformation contactInformation) {
			this.contactInformation = contactInformation==null?null:contactInformation.toBuilder();
			return this;
		}
		@Override
		public PartyContactInformation.PartyContactInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder setPartyReferenceValue(Party partyReference) {
			this.getOrCreatePartyReference().setValue(partyReference);
			return this;
		}
		@Override
		public PartyContactInformation.PartyContactInformationBuilder addPerson(NaturalPerson person) {
			if (person!=null) this.person.add(person.toBuilder());
			return this;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder addPerson(NaturalPerson person, int _idx) {
			getIndex(this.person, _idx, () -> person.toBuilder());
			return this;
		}
		@Override 
		public PartyContactInformation.PartyContactInformationBuilder addPerson(List<? extends NaturalPerson> persons) {
			if (persons != null) {
				for (NaturalPerson toAdd : persons) {
					this.person.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyContactInformation.PartyContactInformationBuilder setPerson(List<? extends NaturalPerson> persons) {
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
		public PartyContactInformation build() {
			return new PartyContactInformation.PartyContactInformationImpl(this);
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyContactInformation.PartyContactInformationBuilder prune() {
			businessUnit = businessUnit.stream().filter(b->b!=null).<BusinessUnit.BusinessUnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (contactInformation!=null && !contactInformation.prune().hasData()) contactInformation = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			person = person.stream().filter(b->b!=null).<NaturalPerson.NaturalPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalInformation()!=null) return true;
			if (getAddress()!=null) return true;
			if (getBusinessUnit()!=null && getBusinessUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContactInformation()!=null && getContactInformation().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPerson()!=null && getPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyContactInformation.PartyContactInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyContactInformation.PartyContactInformationBuilder o = (PartyContactInformation.PartyContactInformationBuilder) other;
			
			merger.mergeRosetta(getBusinessUnit(), o.getBusinessUnit(), this::getOrCreateBusinessUnit);
			merger.mergeRosetta(getContactInformation(), o.getContactInformation(), this::setContactInformation);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getPerson(), o.getPerson(), this::getOrCreatePerson);
			
			merger.mergeBasic(getAdditionalInformation(), o.getAdditionalInformation(), this::setAdditionalInformation);
			merger.mergeBasic(getAddress(), o.getAddress(), this::setAddress);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyContactInformation _that = getType().cast(o);
		
			if (!Objects.equals(additionalInformation, _that.getAdditionalInformation())) return false;
			if (!Objects.equals(address, _that.getAddress())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
			_result = 31 * _result + (address != null ? address.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyContactInformationBuilder {" +
				"additionalInformation=" + this.additionalInformation + ", " +
				"address=" + this.address + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"contactInformation=" + this.contactInformation + ", " +
				"partyReference=" + this.partyReference + ", " +
				"person=" + this.person +
			'}';
		}
	}
}
