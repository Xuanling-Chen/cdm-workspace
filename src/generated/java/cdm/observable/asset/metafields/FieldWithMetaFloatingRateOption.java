package cdm.observable.asset.metafields;

import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionImpl;
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

public interface FieldWithMetaFloatingRateOption extends RosettaModelObject, FieldWithMeta<FloatingRateOption>, GlobalKey {
	FieldWithMetaFloatingRateOption build();
	FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	FloatingRateOption getValue();
	final static FieldWithMetaFloatingRateOptionMeta metaData = new FieldWithMetaFloatingRateOptionMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaFloatingRateOption> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder builder() {
		return new FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaFloatingRateOption> getType() {
		return FieldWithMetaFloatingRateOption.class;
	}
	
		default Class<FloatingRateOption> getValueType() {
			return FloatingRateOption.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, FloatingRateOption.class, getValue());
	}
	
	
	interface FieldWithMetaFloatingRateOptionBuilder extends FieldWithMetaFloatingRateOption, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<FloatingRateOption> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FloatingRateOption.FloatingRateOptionBuilder getOrCreateValue();
		FloatingRateOption.FloatingRateOptionBuilder getValue();
		FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder setMeta(MetaFields meta);
		FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder setValue(FloatingRateOption value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, FloatingRateOption.FloatingRateOptionBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionImpl
	class FieldWithMetaFloatingRateOptionImpl implements FieldWithMetaFloatingRateOption {
		private final MetaFields meta;
		private final FloatingRateOption value;
		
		protected FieldWithMetaFloatingRateOptionImpl(FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FloatingRateOption getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaFloatingRateOption build() {
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder toBuilder() {
			FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaFloatingRateOption {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilderImpl
	class FieldWithMetaFloatingRateOptionBuilderImpl implements FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected FloatingRateOption.FloatingRateOptionBuilder value;
	
		public FieldWithMetaFloatingRateOptionBuilderImpl() {
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
		public FloatingRateOption.FloatingRateOptionBuilder getValue() {
			return value;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder getOrCreateValue() {
			FloatingRateOption.FloatingRateOptionBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = FloatingRateOption.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder setValue(FloatingRateOption value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateOption build() {
			return new FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionImpl(this);
		}
		
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder o = (FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateOption _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaFloatingRateOptionBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaFloatingRateOptionMeta extends BasicRosettaMetaData<FieldWithMetaFloatingRateOption>{

}
