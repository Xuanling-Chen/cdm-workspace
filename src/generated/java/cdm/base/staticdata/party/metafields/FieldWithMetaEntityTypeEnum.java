package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.EntityTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilderImpl;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumImpl;
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

public interface FieldWithMetaEntityTypeEnum extends RosettaModelObject, FieldWithMeta<EntityTypeEnum>, GlobalKey {
	FieldWithMetaEntityTypeEnum build();
	FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	EntityTypeEnum getValue();
	final static FieldWithMetaEntityTypeEnumMeta metaData = new FieldWithMetaEntityTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaEntityTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder builder() {
		return new FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaEntityTypeEnum> getType() {
		return FieldWithMetaEntityTypeEnum.class;
	}
	
		default Class<EntityTypeEnum> getValueType() {
			return EntityTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), EntityTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaEntityTypeEnumBuilder extends FieldWithMetaEntityTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<EntityTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder setValue(EntityTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), EntityTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumImpl
	class FieldWithMetaEntityTypeEnumImpl implements FieldWithMetaEntityTypeEnum {
		private final MetaFields meta;
		private final EntityTypeEnum value;
		
		protected FieldWithMetaEntityTypeEnumImpl(FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public EntityTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaEntityTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder toBuilder() {
			FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaEntityTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaEntityTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilderImpl
	class FieldWithMetaEntityTypeEnumBuilderImpl implements FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected EntityTypeEnum value;
	
		public FieldWithMetaEntityTypeEnumBuilderImpl() {
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
		public EntityTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder setValue(EntityTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaEntityTypeEnum build() {
			return new FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder prune() {
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
		public FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder o = (FieldWithMetaEntityTypeEnum.FieldWithMetaEntityTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaEntityTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaEntityTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaEntityTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaEntityTypeEnum>{

}
