package cdm.product.asset.metafields;

import cdm.product.asset.IndexAnnexSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilderImpl;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumImpl;
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

public interface FieldWithMetaIndexAnnexSourceEnum extends RosettaModelObject, FieldWithMeta<IndexAnnexSourceEnum>, GlobalKey {
	FieldWithMetaIndexAnnexSourceEnum build();
	FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	IndexAnnexSourceEnum getValue();
	final static FieldWithMetaIndexAnnexSourceEnumMeta metaData = new FieldWithMetaIndexAnnexSourceEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaIndexAnnexSourceEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder builder() {
		return new FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaIndexAnnexSourceEnum> getType() {
		return FieldWithMetaIndexAnnexSourceEnum.class;
	}
	
		default Class<IndexAnnexSourceEnum> getValueType() {
			return IndexAnnexSourceEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), IndexAnnexSourceEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaIndexAnnexSourceEnumBuilder extends FieldWithMetaIndexAnnexSourceEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<IndexAnnexSourceEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder setValue(IndexAnnexSourceEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), IndexAnnexSourceEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumImpl
	class FieldWithMetaIndexAnnexSourceEnumImpl implements FieldWithMetaIndexAnnexSourceEnum {
		private final MetaFields meta;
		private final IndexAnnexSourceEnum value;
		
		protected FieldWithMetaIndexAnnexSourceEnumImpl(FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public IndexAnnexSourceEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder toBuilder() {
			FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaIndexAnnexSourceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaIndexAnnexSourceEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilderImpl
	class FieldWithMetaIndexAnnexSourceEnumBuilderImpl implements FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected IndexAnnexSourceEnum value;
	
		public FieldWithMetaIndexAnnexSourceEnumBuilderImpl() {
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
		public IndexAnnexSourceEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder setValue(IndexAnnexSourceEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum build() {
			return new FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder prune() {
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
		public FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder o = (FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaIndexAnnexSourceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaIndexAnnexSourceEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaIndexAnnexSourceEnumMeta extends BasicRosettaMetaData<FieldWithMetaIndexAnnexSourceEnum>{

}
