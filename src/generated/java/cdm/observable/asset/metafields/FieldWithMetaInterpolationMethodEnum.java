package cdm.observable.asset.metafields;

import cdm.observable.asset.InterpolationMethodEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumImpl;
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

public interface FieldWithMetaInterpolationMethodEnum extends RosettaModelObject, FieldWithMeta<InterpolationMethodEnum>, GlobalKey {
	FieldWithMetaInterpolationMethodEnum build();
	FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	InterpolationMethodEnum getValue();
	final static FieldWithMetaInterpolationMethodEnumMeta metaData = new FieldWithMetaInterpolationMethodEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaInterpolationMethodEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder builder() {
		return new FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaInterpolationMethodEnum> getType() {
		return FieldWithMetaInterpolationMethodEnum.class;
	}
	
		default Class<InterpolationMethodEnum> getValueType() {
			return InterpolationMethodEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), InterpolationMethodEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaInterpolationMethodEnumBuilder extends FieldWithMetaInterpolationMethodEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<InterpolationMethodEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder setValue(InterpolationMethodEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), InterpolationMethodEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumImpl
	class FieldWithMetaInterpolationMethodEnumImpl implements FieldWithMetaInterpolationMethodEnum {
		private final MetaFields meta;
		private final InterpolationMethodEnum value;
		
		protected FieldWithMetaInterpolationMethodEnumImpl(FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public InterpolationMethodEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder toBuilder() {
			FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInterpolationMethodEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaInterpolationMethodEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilderImpl
	class FieldWithMetaInterpolationMethodEnumBuilderImpl implements FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected InterpolationMethodEnum value;
	
		public FieldWithMetaInterpolationMethodEnumBuilderImpl() {
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
		public InterpolationMethodEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder setValue(InterpolationMethodEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum build() {
			return new FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder prune() {
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
		public FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder o = (FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInterpolationMethodEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaInterpolationMethodEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaInterpolationMethodEnumMeta extends BasicRosettaMetaData<FieldWithMetaInterpolationMethodEnum>{

}
