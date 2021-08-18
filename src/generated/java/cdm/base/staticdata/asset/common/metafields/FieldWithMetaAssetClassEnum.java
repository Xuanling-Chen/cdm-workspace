package cdm.base.staticdata.asset.common.metafields;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilderImpl;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumImpl;
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

public interface FieldWithMetaAssetClassEnum extends RosettaModelObject, FieldWithMeta<AssetClassEnum>, GlobalKey {
	FieldWithMetaAssetClassEnum build();
	FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	AssetClassEnum getValue();
	final static FieldWithMetaAssetClassEnumMeta metaData = new FieldWithMetaAssetClassEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaAssetClassEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder builder() {
		return new FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaAssetClassEnum> getType() {
		return FieldWithMetaAssetClassEnum.class;
	}
	
		default Class<AssetClassEnum> getValueType() {
			return AssetClassEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), AssetClassEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaAssetClassEnumBuilder extends FieldWithMetaAssetClassEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<AssetClassEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder setValue(AssetClassEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), AssetClassEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumImpl
	class FieldWithMetaAssetClassEnumImpl implements FieldWithMetaAssetClassEnum {
		private final MetaFields meta;
		private final AssetClassEnum value;
		
		protected FieldWithMetaAssetClassEnumImpl(FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AssetClassEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaAssetClassEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder toBuilder() {
			FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaAssetClassEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaAssetClassEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilderImpl
	class FieldWithMetaAssetClassEnumBuilderImpl implements FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected AssetClassEnum value;
	
		public FieldWithMetaAssetClassEnumBuilderImpl() {
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
		public AssetClassEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder setValue(AssetClassEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaAssetClassEnum build() {
			return new FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder prune() {
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
		public FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder o = (FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaAssetClassEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaAssetClassEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaAssetClassEnumMeta extends BasicRosettaMetaData<FieldWithMetaAssetClassEnum>{

}
