package cdm.base.datetime.metafields;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilderImpl;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumImpl;
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

public interface FieldWithMetaBusinessCenterEnum extends RosettaModelObject, FieldWithMeta<BusinessCenterEnum>, GlobalKey {
	FieldWithMetaBusinessCenterEnum build();
	FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	BusinessCenterEnum getValue();
	final static FieldWithMetaBusinessCenterEnumMeta metaData = new FieldWithMetaBusinessCenterEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaBusinessCenterEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder builder() {
		return new FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaBusinessCenterEnum> getType() {
		return FieldWithMetaBusinessCenterEnum.class;
	}
	
		default Class<BusinessCenterEnum> getValueType() {
			return BusinessCenterEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BusinessCenterEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaBusinessCenterEnumBuilder extends FieldWithMetaBusinessCenterEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<BusinessCenterEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder setValue(BusinessCenterEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), BusinessCenterEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumImpl
	class FieldWithMetaBusinessCenterEnumImpl implements FieldWithMetaBusinessCenterEnum {
		private final MetaFields meta;
		private final BusinessCenterEnum value;
		
		protected FieldWithMetaBusinessCenterEnumImpl(FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BusinessCenterEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder toBuilder() {
			FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBusinessCenterEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBusinessCenterEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilderImpl
	class FieldWithMetaBusinessCenterEnumBuilderImpl implements FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected BusinessCenterEnum value;
	
		public FieldWithMetaBusinessCenterEnumBuilderImpl() {
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
		public BusinessCenterEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder setValue(BusinessCenterEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum build() {
			return new FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder prune() {
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
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder o = (FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBusinessCenterEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBusinessCenterEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaBusinessCenterEnumMeta extends BasicRosettaMetaData<FieldWithMetaBusinessCenterEnum>{

}
