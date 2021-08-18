package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.MatrixTermEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumImpl;
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

public interface FieldWithMetaMatrixTermEnum extends RosettaModelObject, FieldWithMeta<MatrixTermEnum>, GlobalKey {
	FieldWithMetaMatrixTermEnum build();
	FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	MatrixTermEnum getValue();
	final static FieldWithMetaMatrixTermEnumMeta metaData = new FieldWithMetaMatrixTermEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaMatrixTermEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder builder() {
		return new FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaMatrixTermEnum> getType() {
		return FieldWithMetaMatrixTermEnum.class;
	}
	
		default Class<MatrixTermEnum> getValueType() {
			return MatrixTermEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), MatrixTermEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaMatrixTermEnumBuilder extends FieldWithMetaMatrixTermEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<MatrixTermEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder setValue(MatrixTermEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), MatrixTermEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumImpl
	class FieldWithMetaMatrixTermEnumImpl implements FieldWithMetaMatrixTermEnum {
		private final MetaFields meta;
		private final MatrixTermEnum value;
		
		protected FieldWithMetaMatrixTermEnumImpl(FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public MatrixTermEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaMatrixTermEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder toBuilder() {
			FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMatrixTermEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMatrixTermEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilderImpl
	class FieldWithMetaMatrixTermEnumBuilderImpl implements FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected MatrixTermEnum value;
	
		public FieldWithMetaMatrixTermEnumBuilderImpl() {
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
		public MatrixTermEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder setValue(MatrixTermEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaMatrixTermEnum build() {
			return new FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder prune() {
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
		public FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder o = (FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMatrixTermEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMatrixTermEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaMatrixTermEnumMeta extends BasicRosettaMetaData<FieldWithMetaMatrixTermEnum>{

}
