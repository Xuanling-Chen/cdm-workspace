package cdm.legalagreement.contract.metafields;

import cdm.legalagreement.contract.BrokerConfirmationTypeEnum;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumImpl;
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

public interface FieldWithMetaBrokerConfirmationTypeEnum extends RosettaModelObject, FieldWithMeta<BrokerConfirmationTypeEnum>, GlobalKey {
	FieldWithMetaBrokerConfirmationTypeEnum build();
	FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	BrokerConfirmationTypeEnum getValue();
	final static FieldWithMetaBrokerConfirmationTypeEnumMeta metaData = new FieldWithMetaBrokerConfirmationTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaBrokerConfirmationTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder() {
		return new FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaBrokerConfirmationTypeEnum> getType() {
		return FieldWithMetaBrokerConfirmationTypeEnum.class;
	}
	
		default Class<BrokerConfirmationTypeEnum> getValueType() {
			return BrokerConfirmationTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BrokerConfirmationTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaBrokerConfirmationTypeEnumBuilder extends FieldWithMetaBrokerConfirmationTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<BrokerConfirmationTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setValue(BrokerConfirmationTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), BrokerConfirmationTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumImpl
	class FieldWithMetaBrokerConfirmationTypeEnumImpl implements FieldWithMetaBrokerConfirmationTypeEnum {
		private final MetaFields meta;
		private final BrokerConfirmationTypeEnum value;
		
		protected FieldWithMetaBrokerConfirmationTypeEnumImpl(FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public BrokerConfirmationTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder() {
			FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBrokerConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBrokerConfirmationTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl
	class FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl implements FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected BrokerConfirmationTypeEnum value;
	
		public FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl() {
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
		public BrokerConfirmationTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setValue(BrokerConfirmationTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum build() {
			return new FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder prune() {
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
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder o = (FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBrokerConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBrokerConfirmationTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaBrokerConfirmationTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaBrokerConfirmationTypeEnum>{

}
