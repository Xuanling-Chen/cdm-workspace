package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.AccountTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilderImpl;
import cdm.base.staticdata.party.metafields.FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumImpl;
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

public interface FieldWithMetaAccountTypeEnum extends RosettaModelObject, FieldWithMeta<AccountTypeEnum>, GlobalKey {
	FieldWithMetaAccountTypeEnum build();
	FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	AccountTypeEnum getValue();
	final static FieldWithMetaAccountTypeEnumMeta metaData = new FieldWithMetaAccountTypeEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaAccountTypeEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder builder() {
		return new FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaAccountTypeEnum> getType() {
		return FieldWithMetaAccountTypeEnum.class;
	}
	
		default Class<AccountTypeEnum> getValueType() {
			return AccountTypeEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), AccountTypeEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaAccountTypeEnumBuilder extends FieldWithMetaAccountTypeEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<AccountTypeEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder setValue(AccountTypeEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), AccountTypeEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumImpl
	class FieldWithMetaAccountTypeEnumImpl implements FieldWithMetaAccountTypeEnum {
		private final MetaFields meta;
		private final AccountTypeEnum value;
		
		protected FieldWithMetaAccountTypeEnumImpl(FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AccountTypeEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder toBuilder() {
			FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaAccountTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaAccountTypeEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilderImpl
	class FieldWithMetaAccountTypeEnumBuilderImpl implements FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected AccountTypeEnum value;
	
		public FieldWithMetaAccountTypeEnumBuilderImpl() {
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
		public AccountTypeEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder setValue(AccountTypeEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaAccountTypeEnum build() {
			return new FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder prune() {
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
		public FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder o = (FieldWithMetaAccountTypeEnum.FieldWithMetaAccountTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaAccountTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaAccountTypeEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaAccountTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaAccountTypeEnum>{

}
