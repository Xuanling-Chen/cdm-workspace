package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.ContractualSupplementEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumImpl;
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

public interface FieldWithMetaContractualSupplementEnum extends RosettaModelObject, FieldWithMeta<ContractualSupplementEnum>, GlobalKey {
	FieldWithMetaContractualSupplementEnum build();
	FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	ContractualSupplementEnum getValue();
	final static FieldWithMetaContractualSupplementEnumMeta metaData = new FieldWithMetaContractualSupplementEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaContractualSupplementEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder builder() {
		return new FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaContractualSupplementEnum> getType() {
		return FieldWithMetaContractualSupplementEnum.class;
	}
	
		default Class<ContractualSupplementEnum> getValueType() {
			return ContractualSupplementEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), ContractualSupplementEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaContractualSupplementEnumBuilder extends FieldWithMetaContractualSupplementEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<ContractualSupplementEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder setValue(ContractualSupplementEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), ContractualSupplementEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumImpl
	class FieldWithMetaContractualSupplementEnumImpl implements FieldWithMetaContractualSupplementEnum {
		private final MetaFields meta;
		private final ContractualSupplementEnum value;
		
		protected FieldWithMetaContractualSupplementEnumImpl(FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ContractualSupplementEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder toBuilder() {
			FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaContractualSupplementEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaContractualSupplementEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilderImpl
	class FieldWithMetaContractualSupplementEnumBuilderImpl implements FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected ContractualSupplementEnum value;
	
		public FieldWithMetaContractualSupplementEnumBuilderImpl() {
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
		public ContractualSupplementEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder setValue(ContractualSupplementEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnum build() {
			return new FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder prune() {
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
		public FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder o = (FieldWithMetaContractualSupplementEnum.FieldWithMetaContractualSupplementEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaContractualSupplementEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaContractualSupplementEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaContractualSupplementEnumMeta extends BasicRosettaMetaData<FieldWithMetaContractualSupplementEnum>{

}
