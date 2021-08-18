package cdm.base.staticdata.asset.rates.metafields;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilderImpl;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumImpl;
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

public interface FieldWithMetaFloatingRateIndexEnum extends RosettaModelObject, FieldWithMeta<FloatingRateIndexEnum>, GlobalKey {
	FieldWithMetaFloatingRateIndexEnum build();
	FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	FloatingRateIndexEnum getValue();
	final static FieldWithMetaFloatingRateIndexEnumMeta metaData = new FieldWithMetaFloatingRateIndexEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaFloatingRateIndexEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder builder() {
		return new FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaFloatingRateIndexEnum> getType() {
		return FieldWithMetaFloatingRateIndexEnum.class;
	}
	
		default Class<FloatingRateIndexEnum> getValueType() {
			return FloatingRateIndexEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), FloatingRateIndexEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaFloatingRateIndexEnumBuilder extends FieldWithMetaFloatingRateIndexEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<FloatingRateIndexEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder setValue(FloatingRateIndexEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), FloatingRateIndexEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumImpl
	class FieldWithMetaFloatingRateIndexEnumImpl implements FieldWithMetaFloatingRateIndexEnum {
		private final MetaFields meta;
		private final FloatingRateIndexEnum value;
		
		protected FieldWithMetaFloatingRateIndexEnumImpl(FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FloatingRateIndexEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder toBuilder() {
			FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateIndexEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaFloatingRateIndexEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilderImpl
	class FieldWithMetaFloatingRateIndexEnumBuilderImpl implements FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected FloatingRateIndexEnum value;
	
		public FieldWithMetaFloatingRateIndexEnumBuilderImpl() {
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
		public FloatingRateIndexEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder setValue(FloatingRateIndexEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum build() {
			return new FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder prune() {
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
		public FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder o = (FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateIndexEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaFloatingRateIndexEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaFloatingRateIndexEnumMeta extends BasicRosettaMetaData<FieldWithMetaFloatingRateIndexEnum>{

}
