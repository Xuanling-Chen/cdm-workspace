package cdm.legalagreement.master.metafields;

import cdm.legalagreement.master.MasterConfirmationAnnexTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilderImpl;
import cdm.legalagreement.master.metafields.FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumImpl;
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

public interface FieldWithMetaMasterConfirmationAnnexTypeEnum extends RosettaModelObject, FieldWithMeta<MasterConfirmationAnnexTypeEnum>, GlobalKey {
	FieldWithMetaMasterConfirmationAnnexTypeEnum build();
	FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	MasterConfirmationAnnexTypeEnum getValue();
	final static FieldWithMetaMasterConfirmationAnnexTypeEnumMeta metaData = new FieldWithMetaMasterConfirmationAnnexTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaMasterConfirmationAnnexTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder builder() {
		return new FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaMasterConfirmationAnnexTypeEnum> getType() {
		return FieldWithMetaMasterConfirmationAnnexTypeEnum.class;
	}
	
		default Class<MasterConfirmationAnnexTypeEnum> getValueType() {
			return MasterConfirmationAnnexTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), MasterConfirmationAnnexTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder extends FieldWithMetaMasterConfirmationAnnexTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<MasterConfirmationAnnexTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder setValue(MasterConfirmationAnnexTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), MasterConfirmationAnnexTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumImpl
	class FieldWithMetaMasterConfirmationAnnexTypeEnumImpl implements FieldWithMetaMasterConfirmationAnnexTypeEnum {
		private final MetaFields meta;
		private final MasterConfirmationAnnexTypeEnum value;
		
		protected FieldWithMetaMasterConfirmationAnnexTypeEnumImpl(FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public MasterConfirmationAnnexTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder toBuilder() {
			FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMasterConfirmationAnnexTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMasterConfirmationAnnexTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilderImpl
	class FieldWithMetaMasterConfirmationAnnexTypeEnumBuilderImpl implements FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected MasterConfirmationAnnexTypeEnum value;
	
		public FieldWithMetaMasterConfirmationAnnexTypeEnumBuilderImpl() {
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
		public MasterConfirmationAnnexTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder setValue(MasterConfirmationAnnexTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum build() {
			return new FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder prune() {
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
		public FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder o = (FieldWithMetaMasterConfirmationAnnexTypeEnum.FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaMasterConfirmationAnnexTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaMasterConfirmationAnnexTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaMasterConfirmationAnnexTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaMasterConfirmationAnnexTypeEnum>{

}
