package cdm.product.asset.metafields;

import cdm.product.asset.SettledEntityMatrixSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilderImpl;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumImpl;
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

public interface FieldWithMetaSettledEntityMatrixSourceEnum extends RosettaModelObject, FieldWithMeta<SettledEntityMatrixSourceEnum>, GlobalKey {
	FieldWithMetaSettledEntityMatrixSourceEnum build();
	FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	SettledEntityMatrixSourceEnum getValue();
	final static FieldWithMetaSettledEntityMatrixSourceEnumMeta metaData = new FieldWithMetaSettledEntityMatrixSourceEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaSettledEntityMatrixSourceEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder builder() {
		return new FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaSettledEntityMatrixSourceEnum> getType() {
		return FieldWithMetaSettledEntityMatrixSourceEnum.class;
	}
	
		default Class<SettledEntityMatrixSourceEnum> getValueType() {
			return SettledEntityMatrixSourceEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), SettledEntityMatrixSourceEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaSettledEntityMatrixSourceEnumBuilder extends FieldWithMetaSettledEntityMatrixSourceEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<SettledEntityMatrixSourceEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder setValue(SettledEntityMatrixSourceEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), SettledEntityMatrixSourceEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumImpl
	class FieldWithMetaSettledEntityMatrixSourceEnumImpl implements FieldWithMetaSettledEntityMatrixSourceEnum {
		private final MetaFields meta;
		private final SettledEntityMatrixSourceEnum value;
		
		protected FieldWithMetaSettledEntityMatrixSourceEnumImpl(FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public SettledEntityMatrixSourceEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder toBuilder() {
			FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSettledEntityMatrixSourceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSettledEntityMatrixSourceEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilderImpl
	class FieldWithMetaSettledEntityMatrixSourceEnumBuilderImpl implements FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected SettledEntityMatrixSourceEnum value;
	
		public FieldWithMetaSettledEntityMatrixSourceEnumBuilderImpl() {
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
		public SettledEntityMatrixSourceEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder setValue(SettledEntityMatrixSourceEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum build() {
			return new FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder prune() {
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
		public FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder o = (FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSettledEntityMatrixSourceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSettledEntityMatrixSourceEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaSettledEntityMatrixSourceEnumMeta extends BasicRosettaMetaData<FieldWithMetaSettledEntityMatrixSourceEnum>{

}
