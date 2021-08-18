package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.NaturalPersonMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to represent the attributes that are specific to a natural person.
 * @version ${project.version}
 */
@RosettaClass

public interface NaturalPerson extends RosettaModelObject, GlobalKey {
	NaturalPerson build();
	NaturalPerson.NaturalPersonBuilder toBuilder();
	
	/**
	 * The natural person&#39;s date of birth.
	 */
	Date getDateOfBirth();
	/**
	 * The natural person&#39;s first name. It is optional in FpML.
	 */
	String getFirstName();
	/**
	 * An honorific title, such as Mr., Ms., Dr. etc.
	 */
	String getHonorific();
	/**
	 */
	List<? extends String> getInitial();
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	List<? extends String> getMiddleName();
	/**
	 * Name suffix, such as Jr., III, etc.
	 */
	String getSuffix();
	/**
	 * The natural person&#39;s surname.
	 */
	String getSurname();
	final static NaturalPersonMeta metaData = new NaturalPersonMeta();
	
	@Override
	default RosettaMetaData<? extends NaturalPerson> metaData() {
		return metaData;
	} 
			
	static NaturalPerson.NaturalPersonBuilder builder() {
		return new NaturalPerson.NaturalPersonBuilderImpl();
	}
	
	default Class<? extends NaturalPerson> getType() {
		return NaturalPerson.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
		processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
		processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
		processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
		processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
		processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
		processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface NaturalPersonBuilder extends NaturalPerson, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		NaturalPerson.NaturalPersonBuilder setDateOfBirth(Date dateOfBirth);
		NaturalPerson.NaturalPersonBuilder setFirstName(String firstName);
		NaturalPerson.NaturalPersonBuilder setHonorific(String honorific);
		NaturalPerson.NaturalPersonBuilder addInitial(String initial);
		NaturalPerson.NaturalPersonBuilder addInitial(String initial, int _idx);
		NaturalPerson.NaturalPersonBuilder addInitial(List<? extends String> initial);
		NaturalPerson.NaturalPersonBuilder setInitial(List<? extends String> initial);
		NaturalPerson.NaturalPersonBuilder setMeta(MetaFields meta);
		NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName);
		NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName, int _idx);
		NaturalPerson.NaturalPersonBuilder addMiddleName(List<? extends String> middleName);
		NaturalPerson.NaturalPersonBuilder setMiddleName(List<? extends String> middleName);
		NaturalPerson.NaturalPersonBuilder setSuffix(String suffix);
		NaturalPerson.NaturalPersonBuilder setSurname(String surname);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
			processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
			processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
			processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
			processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
			processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
			processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//NaturalPerson.NaturalPersonImpl
	class NaturalPersonImpl implements NaturalPerson {
		private final Date dateOfBirth;
		private final String firstName;
		private final String honorific;
		private final List<? extends String> initial;
		private final MetaFields meta;
		private final List<? extends String> middleName;
		private final String suffix;
		private final String surname;
		
		protected NaturalPersonImpl(NaturalPerson.NaturalPersonBuilder builder) {
			this.dateOfBirth = builder.getDateOfBirth();
			this.firstName = builder.getFirstName();
			this.honorific = builder.getHonorific();
			this.initial = ofNullable(builder.getInitial()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.middleName = ofNullable(builder.getMiddleName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.suffix = builder.getSuffix();
			this.surname = builder.getSurname();
		}
		
		@Override
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		@Override
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		public List<? extends String> getInitial() {
			return initial;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends String> getMiddleName() {
			return middleName;
		}
		
		@Override
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		public String getSurname() {
			return surname;
		}
		
		@Override
		public NaturalPerson build() {
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder toBuilder() {
			NaturalPerson.NaturalPersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPerson.NaturalPersonBuilder builder) {
			ofNullable(getDateOfBirth()).ifPresent(builder::setDateOfBirth);
			ofNullable(getFirstName()).ifPresent(builder::setFirstName);
			ofNullable(getHonorific()).ifPresent(builder::setHonorific);
			ofNullable(getInitial()).ifPresent(builder::setInitial);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getMiddleName()).ifPresent(builder::setMiddleName);
			ofNullable(getSuffix()).ifPresent(builder::setSuffix);
			ofNullable(getSurname()).ifPresent(builder::setSurname);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPerson _that = getType().cast(o);
		
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPerson {" +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"firstName=" + this.firstName + ", " +
				"honorific=" + this.honorific + ", " +
				"initial=" + this.initial + ", " +
				"meta=" + this.meta + ", " +
				"middleName=" + this.middleName + ", " +
				"suffix=" + this.suffix + ", " +
				"surname=" + this.surname +
			'}';
		}
	}
	
	//NaturalPerson.NaturalPersonBuilderImpl
	class NaturalPersonBuilderImpl implements NaturalPerson.NaturalPersonBuilder, GlobalKeyBuilder {
	
		protected Date dateOfBirth;
		protected String firstName;
		protected String honorific;
		protected List<String> initial = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<String> middleName = new ArrayList<>();
		protected String suffix;
		protected String surname;
	
		public NaturalPersonBuilderImpl() {
		}
	
		@Override
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		@Override
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		public List<? extends String> getInitial() {
			return initial;
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
		public List<? extends String> getMiddleName() {
			return middleName;
		}
		
		@Override
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		public String getSurname() {
			return surname;
		}
		
	
		@Override
		public NaturalPerson.NaturalPersonBuilder setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth==null?null:dateOfBirth;
			return this;
		}
		@Override
		public NaturalPerson.NaturalPersonBuilder setFirstName(String firstName) {
			this.firstName = firstName==null?null:firstName;
			return this;
		}
		@Override
		public NaturalPerson.NaturalPersonBuilder setHonorific(String honorific) {
			this.honorific = honorific==null?null:honorific;
			return this;
		}
		@Override
		public NaturalPerson.NaturalPersonBuilder addInitial(String initial) {
			if (initial!=null) this.initial.add(initial);
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addInitial(String initial, int _idx) {
			getIndex(this.initial, _idx, () -> initial);
			return this;
		}
		@Override 
		public NaturalPerson.NaturalPersonBuilder addInitial(List<? extends String> initials) {
			if (initials != null) {
				for (String toAdd : initials) {
					this.initial.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public NaturalPerson.NaturalPersonBuilder setInitial(List<? extends String> initials) {
			if (initials == null)  {
				this.initial = new ArrayList<>();
			}
			else {
				this.initial = initials.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName) {
			if (middleName!=null) this.middleName.add(middleName);
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder addMiddleName(String middleName, int _idx) {
			getIndex(this.middleName, _idx, () -> middleName);
			return this;
		}
		@Override 
		public NaturalPerson.NaturalPersonBuilder addMiddleName(List<? extends String> middleNames) {
			if (middleNames != null) {
				for (String toAdd : middleNames) {
					this.middleName.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public NaturalPerson.NaturalPersonBuilder setMiddleName(List<? extends String> middleNames) {
			if (middleNames == null)  {
				this.middleName = new ArrayList<>();
			}
			else {
				this.middleName = middleNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder setSuffix(String suffix) {
			this.suffix = suffix==null?null:suffix;
			return this;
		}
		@Override
		public NaturalPerson.NaturalPersonBuilder setSurname(String surname) {
			this.surname = surname==null?null:surname;
			return this;
		}
		
		@Override
		public NaturalPerson build() {
			return new NaturalPerson.NaturalPersonImpl(this);
		}
		
		@Override
		public NaturalPerson.NaturalPersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPerson.NaturalPersonBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateOfBirth()!=null) return true;
			if (getFirstName()!=null) return true;
			if (getHonorific()!=null) return true;
			if (getInitial()!=null && !getInitial().isEmpty()) return true;
			if (getMiddleName()!=null && !getMiddleName().isEmpty()) return true;
			if (getSuffix()!=null) return true;
			if (getSurname()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPerson.NaturalPersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPerson.NaturalPersonBuilder o = (NaturalPerson.NaturalPersonBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getDateOfBirth(), o.getDateOfBirth(), this::setDateOfBirth);
			merger.mergeBasic(getFirstName(), o.getFirstName(), this::setFirstName);
			merger.mergeBasic(getHonorific(), o.getHonorific(), this::setHonorific);
			merger.mergeBasic(getInitial(), o.getInitial(), (Consumer<String>) this::addInitial);
			merger.mergeBasic(getMiddleName(), o.getMiddleName(), (Consumer<String>) this::addMiddleName);
			merger.mergeBasic(getSuffix(), o.getSuffix(), this::setSuffix);
			merger.mergeBasic(getSurname(), o.getSurname(), this::setSurname);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPerson _that = getType().cast(o);
		
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonBuilder {" +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"firstName=" + this.firstName + ", " +
				"honorific=" + this.honorific + ", " +
				"initial=" + this.initial + ", " +
				"meta=" + this.meta + ", " +
				"middleName=" + this.middleName + ", " +
				"suffix=" + this.suffix + ", " +
				"surname=" + this.surname +
			'}';
		}
	}
}
