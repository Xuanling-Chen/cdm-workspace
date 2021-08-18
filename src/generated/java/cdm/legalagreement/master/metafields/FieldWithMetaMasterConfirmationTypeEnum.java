package cdm.legalagreement.master.metafields;

import cdm.legalagreement.master.MasterConfirmationTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilderImpl;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumImpl;
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

public interface FieldWithMetaMasterConfirmationTypeEnum extends RosettaModelObject, FieldWithMeta<MasterConfirmationTypeEnum>, GlobalKey {
	FieldWithMetaMasterConfirmationTypeEnum build();
	FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	MasterConfirmationTypeEnum getValue();
	final static FieldWithMetaMasterConfirmationTypeEnumMeta metaData = new FieldWithMetaMasterConfirmationTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaMasterConfirmationTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder builder() {
		return new FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaMasterConfirmationTypeEnum> getType() {
		return FieldWithMetaMasterConfirmationTypeEnum.class;
	}
	
		default Class<MasterConfirmationTypeEnum> getValueType() {
			return MasterConfirmationTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), MasterConfirmationTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaMasterConfirmationTypeEnumBuilder extends FieldWithMetaMasterConfirmationTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<MasterConfirmationTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder setValue(MasterConfirmationTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), MasterConfirmationTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumImpl
	class FieldWithMetaMasterConfirmationTypeEnumImpl implements FieldWithMetaMasterConfirmationTypeEnum {
		private final MetaFields meta;
		private final MasterConfirmationTypeEnum value;
		
		protected FieldWithMetaMasterConfirmationTypeEnumImpl(FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public MasterConfirmationTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder toBuilder() {
			FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMasterConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMasterConfirmationTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilderImpl
	class FieldWithMetaMasterConfirmationTypeEnumBuilderImpl implements FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected MasterConfirmationTypeEnum value;
	
		public FieldWithMetaMasterConfirmationTypeEnumBuilderImpl() {
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
		public MasterConfirmationTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder setValue(MasterConfirmationTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum build() {
			return new FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder prune() {
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
		public FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder o = (FieldWithMetaMasterConfirmationTypeEnum.FieldWithMetaMasterConfirmationTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMasterConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMasterConfirmationTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaMasterConfirmationTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaMasterConfirmationTypeEnum>{

}
