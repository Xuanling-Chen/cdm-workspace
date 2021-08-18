package cdm.product.asset.metafields;

import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilderImpl;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumImpl;
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

public interface FieldWithMetaDayCountFractionEnum extends RosettaModelObject, FieldWithMeta<DayCountFractionEnum>, GlobalKey {
	FieldWithMetaDayCountFractionEnum build();
	FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	DayCountFractionEnum getValue();
	final static FieldWithMetaDayCountFractionEnumMeta metaData = new FieldWithMetaDayCountFractionEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaDayCountFractionEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder builder() {
		return new FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaDayCountFractionEnum> getType() {
		return FieldWithMetaDayCountFractionEnum.class;
	}
	
		default Class<DayCountFractionEnum> getValueType() {
			return DayCountFractionEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), DayCountFractionEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaDayCountFractionEnumBuilder extends FieldWithMetaDayCountFractionEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<DayCountFractionEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder setValue(DayCountFractionEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), DayCountFractionEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumImpl
	class FieldWithMetaDayCountFractionEnumImpl implements FieldWithMetaDayCountFractionEnum {
		private final MetaFields meta;
		private final DayCountFractionEnum value;
		
		protected FieldWithMetaDayCountFractionEnumImpl(FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public DayCountFractionEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder toBuilder() {
			FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaDayCountFractionEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaDayCountFractionEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilderImpl
	class FieldWithMetaDayCountFractionEnumBuilderImpl implements FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected DayCountFractionEnum value;
	
		public FieldWithMetaDayCountFractionEnumBuilderImpl() {
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
		public DayCountFractionEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder setValue(DayCountFractionEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum build() {
			return new FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder prune() {
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
		public FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder o = (FieldWithMetaDayCountFractionEnum.FieldWithMetaDayCountFractionEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaDayCountFractionEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaDayCountFractionEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaDayCountFractionEnumMeta extends BasicRosettaMetaData<FieldWithMetaDayCountFractionEnum>{

}
