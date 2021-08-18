package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.ResourceTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumImpl;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.FieldWithMeta;
import com.rosetta.model.lib.meta.FieldWithMeta.FieldWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface FieldWithMetaResourceTypeEnum extends RosettaModelObject, FieldWithMeta<ResourceTypeEnum>, GlobalKey {
	FieldWithMetaResourceTypeEnum build();
	FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	ResourceTypeEnum getValue();
	final static FieldWithMetaResourceTypeEnumMeta metaData = new FieldWithMetaResourceTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaResourceTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder builder() {
		return new FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaResourceTypeEnum> getType() {
		return FieldWithMetaResourceTypeEnum.class;
	}
	
		default Class<ResourceTypeEnum> getValueType() {
			return ResourceTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), ResourceTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaResourceTypeEnumBuilder extends FieldWithMetaResourceTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<ResourceTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder setValue(ResourceTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), ResourceTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumImpl
	class FieldWithMetaResourceTypeEnumImpl implements FieldWithMetaResourceTypeEnum {
		private final MetaFields meta;
		private final ResourceTypeEnum value;
		
		protected FieldWithMetaResourceTypeEnumImpl(FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ResourceTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder toBuilder() {
			FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaResourceTypeEnum _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaResourceTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilderImpl
	class FieldWithMetaResourceTypeEnumBuilderImpl implements FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected ResourceTypeEnum value;
	
		public FieldWithMetaResourceTypeEnumBuilderImpl() {
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
		public ResourceTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder setValue(ResourceTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnum build() {
			return new FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder o = (FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaResourceTypeEnum _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaResourceTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaResourceTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaResourceTypeEnum>{

}
