package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.CategoryEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilderImpl;
import cdm.base.staticdata.party.metafields.FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumImpl;
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

public interface FieldWithMetaCategoryEnum extends RosettaModelObject, FieldWithMeta<CategoryEnum>, GlobalKey {
	FieldWithMetaCategoryEnum build();
	FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	CategoryEnum getValue();
	final static FieldWithMetaCategoryEnumMeta metaData = new FieldWithMetaCategoryEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCategoryEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder builder() {
		return new FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCategoryEnum> getType() {
		return FieldWithMetaCategoryEnum.class;
	}
	
		default Class<CategoryEnum> getValueType() {
			return CategoryEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), CategoryEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaCategoryEnumBuilder extends FieldWithMetaCategoryEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<CategoryEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder setValue(CategoryEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), CategoryEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumImpl
	class FieldWithMetaCategoryEnumImpl implements FieldWithMetaCategoryEnum {
		private final MetaFields meta;
		private final CategoryEnum value;
		
		protected FieldWithMetaCategoryEnumImpl(FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CategoryEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCategoryEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder toBuilder() {
			FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCategoryEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCategoryEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilderImpl
	class FieldWithMetaCategoryEnumBuilderImpl implements FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected CategoryEnum value;
	
		public FieldWithMetaCategoryEnumBuilderImpl() {
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
		public CategoryEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder setValue(CategoryEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaCategoryEnum build() {
			return new FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder prune() {
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
		public FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder o = (FieldWithMetaCategoryEnum.FieldWithMetaCategoryEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCategoryEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCategoryEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCategoryEnumMeta extends BasicRosettaMetaData<FieldWithMetaCategoryEnum>{

}
