package cdm.product.asset.metafields;

import cdm.product.asset.SpreadScheduleTypeEnum;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilderImpl;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumImpl;
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

public interface FieldWithMetaSpreadScheduleTypeEnum extends RosettaModelObject, FieldWithMeta<SpreadScheduleTypeEnum>, GlobalKey {
	FieldWithMetaSpreadScheduleTypeEnum build();
	FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	SpreadScheduleTypeEnum getValue();
	final static FieldWithMetaSpreadScheduleTypeEnumMeta metaData = new FieldWithMetaSpreadScheduleTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaSpreadScheduleTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder builder() {
		return new FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaSpreadScheduleTypeEnum> getType() {
		return FieldWithMetaSpreadScheduleTypeEnum.class;
	}
	
		default Class<SpreadScheduleTypeEnum> getValueType() {
			return SpreadScheduleTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), SpreadScheduleTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaSpreadScheduleTypeEnumBuilder extends FieldWithMetaSpreadScheduleTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<SpreadScheduleTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder setValue(SpreadScheduleTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), SpreadScheduleTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumImpl
	class FieldWithMetaSpreadScheduleTypeEnumImpl implements FieldWithMetaSpreadScheduleTypeEnum {
		private final MetaFields meta;
		private final SpreadScheduleTypeEnum value;
		
		protected FieldWithMetaSpreadScheduleTypeEnumImpl(FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public SpreadScheduleTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder toBuilder() {
			FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSpreadScheduleTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSpreadScheduleTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilderImpl
	class FieldWithMetaSpreadScheduleTypeEnumBuilderImpl implements FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected SpreadScheduleTypeEnum value;
	
		public FieldWithMetaSpreadScheduleTypeEnumBuilderImpl() {
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
		public SpreadScheduleTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder setValue(SpreadScheduleTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum build() {
			return new FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder prune() {
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
		public FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder o = (FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSpreadScheduleTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSpreadScheduleTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaSpreadScheduleTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaSpreadScheduleTypeEnum>{

}
