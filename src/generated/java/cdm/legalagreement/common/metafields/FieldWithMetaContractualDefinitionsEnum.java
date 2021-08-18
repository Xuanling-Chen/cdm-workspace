package cdm.legalagreement.common.metafields;

import cdm.legalagreement.common.ContractualDefinitionsEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilderImpl;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumImpl;
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

public interface FieldWithMetaContractualDefinitionsEnum extends RosettaModelObject, FieldWithMeta<ContractualDefinitionsEnum>, GlobalKey {
	FieldWithMetaContractualDefinitionsEnum build();
	FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	ContractualDefinitionsEnum getValue();
	final static FieldWithMetaContractualDefinitionsEnumMeta metaData = new FieldWithMetaContractualDefinitionsEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaContractualDefinitionsEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder builder() {
		return new FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaContractualDefinitionsEnum> getType() {
		return FieldWithMetaContractualDefinitionsEnum.class;
	}
	
		default Class<ContractualDefinitionsEnum> getValueType() {
			return ContractualDefinitionsEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), ContractualDefinitionsEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaContractualDefinitionsEnumBuilder extends FieldWithMetaContractualDefinitionsEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<ContractualDefinitionsEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder setValue(ContractualDefinitionsEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), ContractualDefinitionsEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumImpl
	class FieldWithMetaContractualDefinitionsEnumImpl implements FieldWithMetaContractualDefinitionsEnum {
		private final MetaFields meta;
		private final ContractualDefinitionsEnum value;
		
		protected FieldWithMetaContractualDefinitionsEnumImpl(FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ContractualDefinitionsEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaContractualDefinitionsEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder toBuilder() {
			FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaContractualDefinitionsEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaContractualDefinitionsEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilderImpl
	class FieldWithMetaContractualDefinitionsEnumBuilderImpl implements FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected ContractualDefinitionsEnum value;
	
		public FieldWithMetaContractualDefinitionsEnumBuilderImpl() {
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
		public ContractualDefinitionsEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder setValue(ContractualDefinitionsEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaContractualDefinitionsEnum build() {
			return new FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder prune() {
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
		public FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder o = (FieldWithMetaContractualDefinitionsEnum.FieldWithMetaContractualDefinitionsEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaContractualDefinitionsEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaContractualDefinitionsEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaContractualDefinitionsEnumMeta extends BasicRosettaMetaData<FieldWithMetaContractualDefinitionsEnum>{

}
