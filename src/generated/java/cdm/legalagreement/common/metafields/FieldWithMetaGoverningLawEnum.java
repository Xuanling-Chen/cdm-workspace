package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.GoverningLawEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumImpl;
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

public interface FieldWithMetaGoverningLawEnum extends RosettaModelObject, FieldWithMeta<GoverningLawEnum>, GlobalKey {
	FieldWithMetaGoverningLawEnum build();
	FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	GoverningLawEnum getValue();
	final static FieldWithMetaGoverningLawEnumMeta metaData = new FieldWithMetaGoverningLawEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaGoverningLawEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder builder() {
		return new FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaGoverningLawEnum> getType() {
		return FieldWithMetaGoverningLawEnum.class;
	}
	
		default Class<GoverningLawEnum> getValueType() {
			return GoverningLawEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), GoverningLawEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaGoverningLawEnumBuilder extends FieldWithMetaGoverningLawEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<GoverningLawEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder setValue(GoverningLawEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), GoverningLawEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumImpl
	class FieldWithMetaGoverningLawEnumImpl implements FieldWithMetaGoverningLawEnum {
		private final MetaFields meta;
		private final GoverningLawEnum value;
		
		protected FieldWithMetaGoverningLawEnumImpl(FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public GoverningLawEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder toBuilder() {
			FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaGoverningLawEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaGoverningLawEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilderImpl
	class FieldWithMetaGoverningLawEnumBuilderImpl implements FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected GoverningLawEnum value;
	
		public FieldWithMetaGoverningLawEnumBuilderImpl() {
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
		public GoverningLawEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder setValue(GoverningLawEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum build() {
			return new FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder prune() {
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
		public FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder o = (FieldWithMetaGoverningLawEnum.FieldWithMetaGoverningLawEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaGoverningLawEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaGoverningLawEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaGoverningLawEnumMeta extends BasicRosettaMetaData<FieldWithMetaGoverningLawEnum>{

}
