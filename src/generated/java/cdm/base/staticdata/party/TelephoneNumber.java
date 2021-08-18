package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.TelephoneNumberMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
 * @version ${project.version}
 */
@RosettaClass

public interface TelephoneNumber extends RosettaModelObject {
	TelephoneNumber build();
	TelephoneNumber.TelephoneNumberBuilder toBuilder();
	
	/**
	 * The actual telephone number.
	 */
	String getNumber();
	/**
	 * The type of telephone number, e.g. work, mobile.
	 */
	TelephoneTypeEnum getTelephoneNumberType();
	final static TelephoneNumberMeta metaData = new TelephoneNumberMeta();
	
	@Override
	default RosettaMetaData<? extends TelephoneNumber> metaData() {
		return metaData;
	} 
			
	static TelephoneNumber.TelephoneNumberBuilder builder() {
		return new TelephoneNumber.TelephoneNumberBuilderImpl();
	}
	
	default Class<? extends TelephoneNumber> getType() {
		return TelephoneNumber.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
		processor.processBasic(path.newSubPath("telephoneNumberType"), TelephoneTypeEnum.class, getTelephoneNumberType(), this);
		
	}
	
	
	interface TelephoneNumberBuilder extends TelephoneNumber, RosettaModelObjectBuilder {
		TelephoneNumber.TelephoneNumberBuilder setNumber(String number);
		TelephoneNumber.TelephoneNumberBuilder setTelephoneNumberType(TelephoneTypeEnum telephoneNumberType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
			processor.processBasic(path.newSubPath("telephoneNumberType"), TelephoneTypeEnum.class, getTelephoneNumberType(), this);
			
		}
		
	}
	
	//TelephoneNumber.TelephoneNumberImpl
	class TelephoneNumberImpl implements TelephoneNumber {
		private final String number;
		private final TelephoneTypeEnum telephoneNumberType;
		
		protected TelephoneNumberImpl(TelephoneNumber.TelephoneNumberBuilder builder) {
			this.number = builder.getNumber();
			this.telephoneNumberType = builder.getTelephoneNumberType();
		}
		
		@Override
		public String getNumber() {
			return number;
		}
		
		@Override
		public TelephoneTypeEnum getTelephoneNumberType() {
			return telephoneNumberType;
		}
		
		@Override
		public TelephoneNumber build() {
			return this;
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			TelephoneNumber.TelephoneNumberBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TelephoneNumber.TelephoneNumberBuilder builder) {
			ofNullable(getNumber()).ifPresent(builder::setNumber);
			ofNullable(getTelephoneNumberType()).ifPresent(builder::setTelephoneNumberType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(number, _that.getNumber())) return false;
			if (!Objects.equals(telephoneNumberType, _that.getTelephoneNumberType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			_result = 31 * _result + (telephoneNumberType != null ? telephoneNumberType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumber {" +
				"number=" + this.number + ", " +
				"telephoneNumberType=" + this.telephoneNumberType +
			'}';
		}
	}
	
	//TelephoneNumber.TelephoneNumberBuilderImpl
	class TelephoneNumberBuilderImpl implements TelephoneNumber.TelephoneNumberBuilder {
	
		protected String number;
		protected TelephoneTypeEnum telephoneNumberType;
	
		public TelephoneNumberBuilderImpl() {
		}
	
		@Override
		public String getNumber() {
			return number;
		}
		
		@Override
		public TelephoneTypeEnum getTelephoneNumberType() {
			return telephoneNumberType;
		}
		
	
		@Override
		public TelephoneNumber.TelephoneNumberBuilder setNumber(String number) {
			this.number = number==null?null:number;
			return this;
		}
		@Override
		public TelephoneNumber.TelephoneNumberBuilder setTelephoneNumberType(TelephoneTypeEnum telephoneNumberType) {
			this.telephoneNumberType = telephoneNumberType==null?null:telephoneNumberType;
			return this;
		}
		
		@Override
		public TelephoneNumber build() {
			return new TelephoneNumber.TelephoneNumberImpl(this);
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumber()!=null) return true;
			if (getTelephoneNumberType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TelephoneNumber.TelephoneNumberBuilder o = (TelephoneNumber.TelephoneNumberBuilder) other;
			
			
			merger.mergeBasic(getNumber(), o.getNumber(), this::setNumber);
			merger.mergeBasic(getTelephoneNumberType(), o.getTelephoneNumberType(), this::setTelephoneNumberType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(number, _that.getNumber())) return false;
			if (!Objects.equals(telephoneNumberType, _that.getTelephoneNumberType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			_result = 31 * _result + (telephoneNumberType != null ? telephoneNumberType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumberBuilder {" +
				"number=" + this.number + ", " +
				"telephoneNumberType=" + this.telephoneNumberType +
			'}';
		}
	}
}
