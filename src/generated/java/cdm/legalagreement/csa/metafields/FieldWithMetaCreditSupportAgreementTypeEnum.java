package cdm.legalagreement.csa.metafields;

import cdm.legalagreement.csa.CreditSupportAgreementTypeEnum;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilderImpl;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumImpl;
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

public interface FieldWithMetaCreditSupportAgreementTypeEnum extends RosettaModelObject, FieldWithMeta<CreditSupportAgreementTypeEnum>, GlobalKey {
	FieldWithMetaCreditSupportAgreementTypeEnum build();
	FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	CreditSupportAgreementTypeEnum getValue();
	final static FieldWithMetaCreditSupportAgreementTypeEnumMeta metaData = new FieldWithMetaCreditSupportAgreementTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCreditSupportAgreementTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder builder() {
		return new FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCreditSupportAgreementTypeEnum> getType() {
		return FieldWithMetaCreditSupportAgreementTypeEnum.class;
	}
	
		default Class<CreditSupportAgreementTypeEnum> getValueType() {
			return CreditSupportAgreementTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), CreditSupportAgreementTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaCreditSupportAgreementTypeEnumBuilder extends FieldWithMetaCreditSupportAgreementTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<CreditSupportAgreementTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder setValue(CreditSupportAgreementTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), CreditSupportAgreementTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumImpl
	class FieldWithMetaCreditSupportAgreementTypeEnumImpl implements FieldWithMetaCreditSupportAgreementTypeEnum {
		private final MetaFields meta;
		private final CreditSupportAgreementTypeEnum value;
		
		protected FieldWithMetaCreditSupportAgreementTypeEnumImpl(FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CreditSupportAgreementTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder toBuilder() {
			FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditSupportAgreementTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditSupportAgreementTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilderImpl
	class FieldWithMetaCreditSupportAgreementTypeEnumBuilderImpl implements FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected CreditSupportAgreementTypeEnum value;
	
		public FieldWithMetaCreditSupportAgreementTypeEnumBuilderImpl() {
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
		public CreditSupportAgreementTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder setValue(CreditSupportAgreementTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum build() {
			return new FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder prune() {
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
		public FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder o = (FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditSupportAgreementTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditSupportAgreementTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCreditSupportAgreementTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaCreditSupportAgreementTypeEnum>{

}
