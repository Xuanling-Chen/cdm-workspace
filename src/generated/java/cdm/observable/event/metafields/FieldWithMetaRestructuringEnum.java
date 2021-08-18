package cdm.observable.event.metafields;

import cdm.observable.event.RestructuringEnum;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilderImpl;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumImpl;
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

public interface FieldWithMetaRestructuringEnum extends RosettaModelObject, FieldWithMeta<RestructuringEnum>, GlobalKey {
	FieldWithMetaRestructuringEnum build();
	FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	RestructuringEnum getValue();
	final static FieldWithMetaRestructuringEnumMeta metaData = new FieldWithMetaRestructuringEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaRestructuringEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder builder() {
		return new FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaRestructuringEnum> getType() {
		return FieldWithMetaRestructuringEnum.class;
	}
	
		default Class<RestructuringEnum> getValueType() {
			return RestructuringEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), RestructuringEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaRestructuringEnumBuilder extends FieldWithMetaRestructuringEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<RestructuringEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder setValue(RestructuringEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), RestructuringEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumImpl
	class FieldWithMetaRestructuringEnumImpl implements FieldWithMetaRestructuringEnum {
		private final MetaFields meta;
		private final RestructuringEnum value;
		
		protected FieldWithMetaRestructuringEnumImpl(FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public RestructuringEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaRestructuringEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder toBuilder() {
			FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaRestructuringEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaRestructuringEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilderImpl
	class FieldWithMetaRestructuringEnumBuilderImpl implements FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected RestructuringEnum value;
	
		public FieldWithMetaRestructuringEnumBuilderImpl() {
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
		public RestructuringEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder setValue(RestructuringEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaRestructuringEnum build() {
			return new FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder prune() {
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
		public FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder o = (FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaRestructuringEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaRestructuringEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaRestructuringEnumMeta extends BasicRosettaMetaData<FieldWithMetaRestructuringEnum>{

}
