package cdm.event.workflow.metafields;

import cdm.event.workflow.CreditLimitTypeEnum;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilderImpl;
import cdm.event.workflow.metafields.FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumImpl;
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

public interface FieldWithMetaCreditLimitTypeEnum extends RosettaModelObject, FieldWithMeta<CreditLimitTypeEnum>, GlobalKey {
	FieldWithMetaCreditLimitTypeEnum build();
	FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	CreditLimitTypeEnum getValue();
	final static FieldWithMetaCreditLimitTypeEnumMeta metaData = new FieldWithMetaCreditLimitTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCreditLimitTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder builder() {
		return new FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCreditLimitTypeEnum> getType() {
		return FieldWithMetaCreditLimitTypeEnum.class;
	}
	
		default Class<CreditLimitTypeEnum> getValueType() {
			return CreditLimitTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), CreditLimitTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaCreditLimitTypeEnumBuilder extends FieldWithMetaCreditLimitTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<CreditLimitTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder setValue(CreditLimitTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), CreditLimitTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumImpl
	class FieldWithMetaCreditLimitTypeEnumImpl implements FieldWithMetaCreditLimitTypeEnum {
		private final MetaFields meta;
		private final CreditLimitTypeEnum value;
		
		protected FieldWithMetaCreditLimitTypeEnumImpl(FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CreditLimitTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder toBuilder() {
			FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditLimitTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditLimitTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilderImpl
	class FieldWithMetaCreditLimitTypeEnumBuilderImpl implements FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected CreditLimitTypeEnum value;
	
		public FieldWithMetaCreditLimitTypeEnumBuilderImpl() {
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
		public CreditLimitTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder setValue(CreditLimitTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnum build() {
			return new FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder prune() {
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
		public FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder o = (FieldWithMetaCreditLimitTypeEnum.FieldWithMetaCreditLimitTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditLimitTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditLimitTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCreditLimitTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaCreditLimitTypeEnum>{

}
