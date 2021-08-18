package cdm.observable.asset.metafields;

import cdm.observable.asset.SettlementRateOptionEnum;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumImpl;
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

public interface FieldWithMetaSettlementRateOptionEnum extends RosettaModelObject, FieldWithMeta<SettlementRateOptionEnum>, GlobalKey {
	FieldWithMetaSettlementRateOptionEnum build();
	FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	SettlementRateOptionEnum getValue();
	final static FieldWithMetaSettlementRateOptionEnumMeta metaData = new FieldWithMetaSettlementRateOptionEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaSettlementRateOptionEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder builder() {
		return new FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaSettlementRateOptionEnum> getType() {
		return FieldWithMetaSettlementRateOptionEnum.class;
	}
	
		default Class<SettlementRateOptionEnum> getValueType() {
			return SettlementRateOptionEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), SettlementRateOptionEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaSettlementRateOptionEnumBuilder extends FieldWithMetaSettlementRateOptionEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<SettlementRateOptionEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder setValue(SettlementRateOptionEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), SettlementRateOptionEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumImpl
	class FieldWithMetaSettlementRateOptionEnumImpl implements FieldWithMetaSettlementRateOptionEnum {
		private final MetaFields meta;
		private final SettlementRateOptionEnum value;
		
		protected FieldWithMetaSettlementRateOptionEnumImpl(FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public SettlementRateOptionEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder toBuilder() {
			FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSettlementRateOptionEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSettlementRateOptionEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilderImpl
	class FieldWithMetaSettlementRateOptionEnumBuilderImpl implements FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected SettlementRateOptionEnum value;
	
		public FieldWithMetaSettlementRateOptionEnumBuilderImpl() {
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
		public SettlementRateOptionEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder setValue(SettlementRateOptionEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnum build() {
			return new FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder prune() {
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
		public FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder o = (FieldWithMetaSettlementRateOptionEnum.FieldWithMetaSettlementRateOptionEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSettlementRateOptionEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaSettlementRateOptionEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaSettlementRateOptionEnumMeta extends BasicRosettaMetaData<FieldWithMetaSettlementRateOptionEnum>{

}
