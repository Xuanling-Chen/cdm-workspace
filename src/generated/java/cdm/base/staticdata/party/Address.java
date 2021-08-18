package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.AddressMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a post or street address.
 * @version ${project.version}
 */
@RosettaClass

public interface Address extends RosettaModelObject {
	Address build();
	Address.AddressBuilder toBuilder();
	
	/**
	 * The city component of the postal address.
	 */
	String getCity();
	/**
	 * The ISO 3166 standard code for the country within which the postal address is located.
	 */
	FieldWithMetaString getCountry();
	/**
	 * The code, required for computerized mail sorting systems, that is allocated to a physical address by a national postal authority.
	 */
	String getPostalCode();
	/**
	 * A country subdivision used in postal addresses in some countries. For example, US states, Canadian provinces, Swiss cantons, ...
	 */
	String getState();
	/**
	 * The set of street and building number information that identifies a postal address within a city.
	 */
	List<? extends String> getStreet();
	final static AddressMeta metaData = new AddressMeta();
	
	@Override
	default RosettaMetaData<? extends Address> metaData() {
		return metaData;
	} 
			
	static Address.AddressBuilder builder() {
		return new Address.AddressBuilderImpl();
	}
	
	default Class<? extends Address> getType() {
		return Address.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
		processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
		processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
		processor.processBasic(path.newSubPath("street"), String.class, getStreet(), this);
		
		processRosetta(path.newSubPath("country"), processor, FieldWithMetaString.class, getCountry());
	}
	
	
	interface AddressBuilder extends Address, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCountry();
		FieldWithMetaStringBuilder getCountry();
		Address.AddressBuilder setCity(String city);
		Address.AddressBuilder setCountry(FieldWithMetaString country);
		Address.AddressBuilder setCountryValue(String country);
		Address.AddressBuilder setPostalCode(String postalCode);
		Address.AddressBuilder setState(String state);
		Address.AddressBuilder addStreet(String street);
		Address.AddressBuilder addStreet(String street, int _idx);
		Address.AddressBuilder addStreet(List<? extends String> street);
		Address.AddressBuilder setStreet(List<? extends String> street);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
			processor.processBasic(path.newSubPath("postalCode"), String.class, getPostalCode(), this);
			processor.processBasic(path.newSubPath("state"), String.class, getState(), this);
			processor.processBasic(path.newSubPath("street"), String.class, getStreet(), this);
			
			processRosetta(path.newSubPath("country"), processor, FieldWithMetaStringBuilder.class, getCountry());
		}
		
	}
	
	//Address.AddressImpl
	class AddressImpl implements Address {
		private final String city;
		private final FieldWithMetaString country;
		private final String postalCode;
		private final String state;
		private final List<? extends String> street;
		
		protected AddressImpl(Address.AddressBuilder builder) {
			this.city = builder.getCity();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.postalCode = builder.getPostalCode();
			this.state = builder.getState();
			this.street = ofNullable(builder.getStreet()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public String getCity() {
			return city;
		}
		
		@Override
		public FieldWithMetaString getCountry() {
			return country;
		}
		
		@Override
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		public String getState() {
			return state;
		}
		
		@Override
		public List<? extends String> getStreet() {
			return street;
		}
		
		@Override
		public Address build() {
			return this;
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			Address.AddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Address.AddressBuilder builder) {
			ofNullable(getCity()).ifPresent(builder::setCity);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getPostalCode()).ifPresent(builder::setPostalCode);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getStreet()).ifPresent(builder::setStreet);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(street, _that.getStreet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (street != null ? street.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Address {" +
				"city=" + this.city + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode + ", " +
				"state=" + this.state + ", " +
				"street=" + this.street +
			'}';
		}
	}
	
	//Address.AddressBuilderImpl
	class AddressBuilderImpl implements Address.AddressBuilder {
	
		protected String city;
		protected FieldWithMetaStringBuilder country;
		protected String postalCode;
		protected String state;
		protected List<String> street = new ArrayList<>();
	
		public AddressBuilderImpl() {
		}
	
		@Override
		public String getCity() {
			return city;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCountry() {
			return country;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCountry() {
			FieldWithMetaStringBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getPostalCode() {
			return postalCode;
		}
		
		@Override
		public String getState() {
			return state;
		}
		
		@Override
		public List<? extends String> getStreet() {
			return street;
		}
		
	
		@Override
		public Address.AddressBuilder setCity(String city) {
			this.city = city==null?null:city;
			return this;
		}
		@Override
		public Address.AddressBuilder setCountry(FieldWithMetaString country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		
		@Override
		public Address.AddressBuilder setCountryValue(String country) {
			this.getOrCreateCountry().setValue(country);
			return this;
		}
		@Override
		public Address.AddressBuilder setPostalCode(String postalCode) {
			this.postalCode = postalCode==null?null:postalCode;
			return this;
		}
		@Override
		public Address.AddressBuilder setState(String state) {
			this.state = state==null?null:state;
			return this;
		}
		@Override
		public Address.AddressBuilder addStreet(String street) {
			if (street!=null) this.street.add(street);
			return this;
		}
		
		@Override
		public Address.AddressBuilder addStreet(String street, int _idx) {
			getIndex(this.street, _idx, () -> street);
			return this;
		}
		@Override 
		public Address.AddressBuilder addStreet(List<? extends String> streets) {
			if (streets != null) {
				for (String toAdd : streets) {
					this.street.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public Address.AddressBuilder setStreet(List<? extends String> streets) {
			if (streets == null)  {
				this.street = new ArrayList<>();
			}
			else {
				this.street = streets.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Address build() {
			return new Address.AddressImpl(this);
		}
		
		@Override
		public Address.AddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder prune() {
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCity()!=null) return true;
			if (getCountry()!=null) return true;
			if (getPostalCode()!=null) return true;
			if (getState()!=null) return true;
			if (getStreet()!=null && !getStreet().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Address.AddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Address.AddressBuilder o = (Address.AddressBuilder) other;
			
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getCity(), o.getCity(), this::setCity);
			merger.mergeBasic(getPostalCode(), o.getPostalCode(), this::setPostalCode);
			merger.mergeBasic(getState(), o.getState(), this::setState);
			merger.mergeBasic(getStreet(), o.getStreet(), (Consumer<String>) this::addStreet);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Address _that = getType().cast(o);
		
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(postalCode, _that.getPostalCode())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(street, _that.getStreet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (postalCode != null ? postalCode.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (street != null ? street.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddressBuilder {" +
				"city=" + this.city + ", " +
				"country=" + this.country + ", " +
				"postalCode=" + this.postalCode + ", " +
				"state=" + this.state + ", " +
				"street=" + this.street +
			'}';
		}
	}
}
