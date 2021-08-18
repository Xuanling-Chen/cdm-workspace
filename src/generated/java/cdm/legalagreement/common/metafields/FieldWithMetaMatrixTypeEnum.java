package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.MatrixTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumImpl;
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

public interface FieldWithMetaMatrixTypeEnum extends RosettaModelObject, FieldWithMeta<MatrixTypeEnum>, GlobalKey {
	FieldWithMetaMatrixTypeEnum build();
	FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	MatrixTypeEnum getValue();
	final static FieldWithMetaMatrixTypeEnumMeta metaData = new FieldWithMetaMatrixTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaMatrixTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder builder() {
		return new FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaMatrixTypeEnum> getType() {
		return FieldWithMetaMatrixTypeEnum.class;
	}
	
		default Class<MatrixTypeEnum> getValueType() {
			return MatrixTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), MatrixTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaMatrixTypeEnumBuilder extends FieldWithMetaMatrixTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<MatrixTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder setValue(MatrixTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), MatrixTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumImpl
	class FieldWithMetaMatrixTypeEnumImpl implements FieldWithMetaMatrixTypeEnum {
		private final MetaFields meta;
		private final MatrixTypeEnum value;
		
		protected FieldWithMetaMatrixTypeEnumImpl(FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public MatrixTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder toBuilder() {
			FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMatrixTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMatrixTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilderImpl
	class FieldWithMetaMatrixTypeEnumBuilderImpl implements FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected MatrixTypeEnum value;
	
		public FieldWithMetaMatrixTypeEnumBuilderImpl() {
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
		public MatrixTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder setValue(MatrixTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnum build() {
			return new FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder prune() {
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
		public FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder o = (FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMatrixTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMatrixTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaMatrixTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaMatrixTypeEnum>{

}
