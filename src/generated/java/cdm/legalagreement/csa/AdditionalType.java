package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AdditionalTypeMeta;
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
 * The specification of the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).
 * @version ${project.version}
 */
@RosettaClass

public interface AdditionalType extends RosettaModelObject {
	AdditionalType build();
	AdditionalType.AdditionalTypeBuilder toBuilder();
	
	/**
	 * The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a custom value by the parties to the legal agreement.
	 */
	String getCustomValue();
	/**
	 * The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a standard value.
	 */
	AdditionalTypeEnum getStandardValue();
	final static AdditionalTypeMeta metaData = new AdditionalTypeMeta();
	
	@Override
	default RosettaMetaData<? extends AdditionalType> metaData() {
		return metaData;
	} 
			
	static AdditionalType.AdditionalTypeBuilder builder() {
		return new AdditionalType.AdditionalTypeBuilderImpl();
	}
	
	default Class<? extends AdditionalType> getType() {
		return AdditionalType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customValue"), String.class, getCustomValue(), this);
		processor.processBasic(path.newSubPath("standardValue"), AdditionalTypeEnum.class, getStandardValue(), this);
		
	}
	
	
	interface AdditionalTypeBuilder extends AdditionalType, RosettaModelObjectBuilder {
		AdditionalType.AdditionalTypeBuilder setCustomValue(String customValue);
		AdditionalType.AdditionalTypeBuilder setStandardValue(AdditionalTypeEnum standardValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customValue"), String.class, getCustomValue(), this);
			processor.processBasic(path.newSubPath("standardValue"), AdditionalTypeEnum.class, getStandardValue(), this);
			
		}
		
	}
	
	//AdditionalType.AdditionalTypeImpl
	class AdditionalTypeImpl implements AdditionalType {
		private final String customValue;
		private final AdditionalTypeEnum standardValue;
		
		protected AdditionalTypeImpl(AdditionalType.AdditionalTypeBuilder builder) {
			this.customValue = builder.getCustomValue();
			this.standardValue = builder.getStandardValue();
		}
		
		@Override
		public String getCustomValue() {
			return customValue;
		}
		
		@Override
		public AdditionalTypeEnum getStandardValue() {
			return standardValue;
		}
		
		@Override
		public AdditionalType build() {
			return this;
		}
		
		@Override
		public AdditionalType.AdditionalTypeBuilder toBuilder() {
			AdditionalType.AdditionalTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalType.AdditionalTypeBuilder builder) {
			ofNullable(getCustomValue()).ifPresent(builder::setCustomValue);
			ofNullable(getStandardValue()).ifPresent(builder::setStandardValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalType _that = getType().cast(o);
		
			if (!Objects.equals(customValue, _that.getCustomValue())) return false;
			if (!Objects.equals(standardValue, _that.getStandardValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customValue != null ? customValue.hashCode() : 0);
			_result = 31 * _result + (standardValue != null ? standardValue.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalType {" +
				"customValue=" + this.customValue + ", " +
				"standardValue=" + this.standardValue +
			'}';
		}
	}
	
	//AdditionalType.AdditionalTypeBuilderImpl
	class AdditionalTypeBuilderImpl implements AdditionalType.AdditionalTypeBuilder {
	
		protected String customValue;
		protected AdditionalTypeEnum standardValue;
	
		public AdditionalTypeBuilderImpl() {
		}
	
		@Override
		public String getCustomValue() {
			return customValue;
		}
		
		@Override
		public AdditionalTypeEnum getStandardValue() {
			return standardValue;
		}
		
	
		@Override
		public AdditionalType.AdditionalTypeBuilder setCustomValue(String customValue) {
			this.customValue = customValue==null?null:customValue;
			return this;
		}
		@Override
		public AdditionalType.AdditionalTypeBuilder setStandardValue(AdditionalTypeEnum standardValue) {
			this.standardValue = standardValue==null?null:standardValue;
			return this;
		}
		
		@Override
		public AdditionalType build() {
			return new AdditionalType.AdditionalTypeImpl(this);
		}
		
		@Override
		public AdditionalType.AdditionalTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalType.AdditionalTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomValue()!=null) return true;
			if (getStandardValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalType.AdditionalTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalType.AdditionalTypeBuilder o = (AdditionalType.AdditionalTypeBuilder) other;
			
			
			merger.mergeBasic(getCustomValue(), o.getCustomValue(), this::setCustomValue);
			merger.mergeBasic(getStandardValue(), o.getStandardValue(), this::setStandardValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalType _that = getType().cast(o);
		
			if (!Objects.equals(customValue, _that.getCustomValue())) return false;
			if (!Objects.equals(standardValue, _that.getStandardValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customValue != null ? customValue.hashCode() : 0);
			_result = 31 * _result + (standardValue != null ? standardValue.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTypeBuilder {" +
				"customValue=" + this.customValue + ", " +
				"standardValue=" + this.standardValue +
			'}';
		}
	}
}
