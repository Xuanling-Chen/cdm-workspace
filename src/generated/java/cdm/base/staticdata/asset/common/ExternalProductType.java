package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.ExternalProductTypeMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides a classification of the type of product that is external to the product qualifications used in the CDM. Product types mapped from external models are mapped to this data type.
 * @version ${project.version}
 */
@RosettaClass

public interface ExternalProductType extends RosettaModelObject {
	ExternalProductType build();
	ExternalProductType.ExternalProductTypeBuilder toBuilder();
	
	/**
	 * Denotes the enumerated value to identify the source for the specified product type.
	 */
	ExternalProductTypeSourceEnum getExternalProductTypeSource();
	/**
	 * Stores the product type value.
	 */
	FieldWithMetaString getValue();
	final static ExternalProductTypeMeta metaData = new ExternalProductTypeMeta();
	
	@Override
	default RosettaMetaData<? extends ExternalProductType> metaData() {
		return metaData;
	} 
			
	static ExternalProductType.ExternalProductTypeBuilder builder() {
		return new ExternalProductType.ExternalProductTypeBuilderImpl();
	}
	
	default Class<? extends ExternalProductType> getType() {
		return ExternalProductType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalProductTypeSource"), ExternalProductTypeSourceEnum.class, getExternalProductTypeSource(), this);
		
		processRosetta(path.newSubPath("value"), processor, FieldWithMetaString.class, getValue());
	}
	
	
	interface ExternalProductTypeBuilder extends ExternalProductType, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateValue();
		FieldWithMetaStringBuilder getValue();
		ExternalProductType.ExternalProductTypeBuilder setExternalProductTypeSource(ExternalProductTypeSourceEnum externalProductTypeSource);
		ExternalProductType.ExternalProductTypeBuilder setValue(FieldWithMetaString value);
		ExternalProductType.ExternalProductTypeBuilder setValueValue(String value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalProductTypeSource"), ExternalProductTypeSourceEnum.class, getExternalProductTypeSource(), this);
			
			processRosetta(path.newSubPath("value"), processor, FieldWithMetaStringBuilder.class, getValue());
		}
		
	}
	
	//ExternalProductType.ExternalProductTypeImpl
	class ExternalProductTypeImpl implements ExternalProductType {
		private final ExternalProductTypeSourceEnum externalProductTypeSource;
		private final FieldWithMetaString value;
		
		protected ExternalProductTypeImpl(ExternalProductType.ExternalProductTypeBuilder builder) {
			this.externalProductTypeSource = builder.getExternalProductTypeSource();
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ExternalProductTypeSourceEnum getExternalProductTypeSource() {
			return externalProductTypeSource;
		}
		
		@Override
		public FieldWithMetaString getValue() {
			return value;
		}
		
		@Override
		public ExternalProductType build() {
			return this;
		}
		
		@Override
		public ExternalProductType.ExternalProductTypeBuilder toBuilder() {
			ExternalProductType.ExternalProductTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExternalProductType.ExternalProductTypeBuilder builder) {
			ofNullable(getExternalProductTypeSource()).ifPresent(builder::setExternalProductTypeSource);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExternalProductType _that = getType().cast(o);
		
			if (!Objects.equals(externalProductTypeSource, _that.getExternalProductTypeSource())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalProductTypeSource != null ? externalProductTypeSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExternalProductType {" +
				"externalProductTypeSource=" + this.externalProductTypeSource + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ExternalProductType.ExternalProductTypeBuilderImpl
	class ExternalProductTypeBuilderImpl implements ExternalProductType.ExternalProductTypeBuilder {
	
		protected ExternalProductTypeSourceEnum externalProductTypeSource;
		protected FieldWithMetaStringBuilder value;
	
		public ExternalProductTypeBuilderImpl() {
		}
	
		@Override
		public ExternalProductTypeSourceEnum getExternalProductTypeSource() {
			return externalProductTypeSource;
		}
		
		@Override
		public FieldWithMetaStringBuilder getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateValue() {
			FieldWithMetaStringBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExternalProductType.ExternalProductTypeBuilder setExternalProductTypeSource(ExternalProductTypeSourceEnum externalProductTypeSource) {
			this.externalProductTypeSource = externalProductTypeSource==null?null:externalProductTypeSource;
			return this;
		}
		@Override
		public ExternalProductType.ExternalProductTypeBuilder setValue(FieldWithMetaString value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ExternalProductType.ExternalProductTypeBuilder setValueValue(String value) {
			this.getOrCreateValue().setValue(value);
			return this;
		}
		
		@Override
		public ExternalProductType build() {
			return new ExternalProductType.ExternalProductTypeImpl(this);
		}
		
		@Override
		public ExternalProductType.ExternalProductTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExternalProductType.ExternalProductTypeBuilder prune() {
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalProductTypeSource()!=null) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExternalProductType.ExternalProductTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExternalProductType.ExternalProductTypeBuilder o = (ExternalProductType.ExternalProductTypeBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			merger.mergeBasic(getExternalProductTypeSource(), o.getExternalProductTypeSource(), this::setExternalProductTypeSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExternalProductType _that = getType().cast(o);
		
			if (!Objects.equals(externalProductTypeSource, _that.getExternalProductTypeSource())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalProductTypeSource != null ? externalProductTypeSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExternalProductTypeBuilder {" +
				"externalProductTypeSource=" + this.externalProductTypeSource + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
