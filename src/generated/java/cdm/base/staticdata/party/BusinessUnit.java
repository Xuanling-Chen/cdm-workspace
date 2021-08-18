package cdm.base.staticdata.party;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.meta.BusinessUnitMeta;
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
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify an organizational unit.
 * @version ${project.version}
 */
@RosettaClass

public interface BusinessUnit extends RosettaModelObject, GlobalKey {
	BusinessUnit build();
	BusinessUnit.BusinessUnitBuilder toBuilder();
	
	/**
	 * The contact information for such business unit, when different from the contact information associated with the party.
	 */
	ContactInformation getContactInformation();
	/**
	 * An identifier used to uniquely identify the organizational unit
	 */
	Identifier getIdentifier();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A name used to describe the organizational unit
	 */
	String getName();
	final static BusinessUnitMeta metaData = new BusinessUnitMeta();
	
	@Override
	default RosettaMetaData<? extends BusinessUnit> metaData() {
		return metaData;
	} 
			
	static BusinessUnit.BusinessUnitBuilder builder() {
		return new BusinessUnit.BusinessUnitBuilderImpl();
	}
	
	default Class<? extends BusinessUnit> getType() {
		return BusinessUnit.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		
		processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.class, getContactInformation());
		processRosetta(path.newSubPath("identifier"), processor, Identifier.class, getIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface BusinessUnitBuilder extends BusinessUnit, RosettaModelObjectBuilder {
		ContactInformation.ContactInformationBuilder getOrCreateContactInformation();
		ContactInformation.ContactInformationBuilder getContactInformation();
		Identifier.IdentifierBuilder getOrCreateIdentifier();
		Identifier.IdentifierBuilder getIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		BusinessUnit.BusinessUnitBuilder setContactInformation(ContactInformation contactInformation);
		BusinessUnit.BusinessUnitBuilder setIdentifier(Identifier identifier);
		BusinessUnit.BusinessUnitBuilder setMeta(MetaFields meta);
		BusinessUnit.BusinessUnitBuilder setName(String name);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			
			processRosetta(path.newSubPath("contactInformation"), processor, ContactInformation.ContactInformationBuilder.class, getContactInformation());
			processRosetta(path.newSubPath("identifier"), processor, Identifier.IdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//BusinessUnit.BusinessUnitImpl
	class BusinessUnitImpl implements BusinessUnit {
		private final ContactInformation contactInformation;
		private final Identifier identifier;
		private final MetaFields meta;
		private final String name;
		
		protected BusinessUnitImpl(BusinessUnit.BusinessUnitBuilder builder) {
			this.contactInformation = ofNullable(builder.getContactInformation()).map(f->f.build()).orElse(null);
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.name = builder.getName();
		}
		
		@Override
		public ContactInformation getContactInformation() {
			return contactInformation;
		}
		
		@Override
		public Identifier getIdentifier() {
			return identifier;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public BusinessUnit build() {
			return this;
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			BusinessUnit.BusinessUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessUnit.BusinessUnitBuilder builder) {
			ofNullable(getContactInformation()).ifPresent(builder::setContactInformation);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getName()).ifPresent(builder::setName);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnit {" +
				"contactInformation=" + this.contactInformation + ", " +
				"identifier=" + this.identifier + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name +
			'}';
		}
	}
	
	//BusinessUnit.BusinessUnitBuilderImpl
	class BusinessUnitBuilderImpl implements BusinessUnit.BusinessUnitBuilder, GlobalKeyBuilder {
	
		protected ContactInformation.ContactInformationBuilder contactInformation;
		protected Identifier.IdentifierBuilder identifier;
		protected MetaFields.MetaFieldsBuilder meta;
		protected String name;
	
		public BusinessUnitBuilderImpl() {
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
		public Identifier.IdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateIdentifier() {
			Identifier.IdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = Identifier.builder();
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
		public String getName() {
			return name;
		}
		
	
		@Override
		public BusinessUnit.BusinessUnitBuilder setContactInformation(ContactInformation contactInformation) {
			this.contactInformation = contactInformation==null?null:contactInformation.toBuilder();
			return this;
		}
		@Override
		public BusinessUnit.BusinessUnitBuilder setIdentifier(Identifier identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		@Override
		public BusinessUnit.BusinessUnitBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public BusinessUnit.BusinessUnitBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		
		@Override
		public BusinessUnit build() {
			return new BusinessUnit.BusinessUnitImpl(this);
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder prune() {
			if (contactInformation!=null && !contactInformation.prune().hasData()) contactInformation = null;
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContactInformation()!=null && getContactInformation().hasData()) return true;
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			if (getName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessUnit.BusinessUnitBuilder o = (BusinessUnit.BusinessUnitBuilder) other;
			
			merger.mergeRosetta(getContactInformation(), o.getContactInformation(), this::setContactInformation);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(contactInformation, _that.getContactInformation())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contactInformation != null ? contactInformation.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnitBuilder {" +
				"contactInformation=" + this.contactInformation + ", " +
				"identifier=" + this.identifier + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name +
			'}';
		}
	}
}
