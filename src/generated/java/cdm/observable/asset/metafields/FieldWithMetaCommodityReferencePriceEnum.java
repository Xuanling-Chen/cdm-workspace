package cdm.observable.asset.metafields;

import cdm.observable.asset.CommodityReferencePriceEnum;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumImpl;
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

public interface FieldWithMetaCommodityReferencePriceEnum extends RosettaModelObject, FieldWithMeta<CommodityReferencePriceEnum>, GlobalKey {
	FieldWithMetaCommodityReferencePriceEnum build();
	FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	CommodityReferencePriceEnum getValue();
	final static FieldWithMetaCommodityReferencePriceEnumMeta metaData = new FieldWithMetaCommodityReferencePriceEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCommodityReferencePriceEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder builder() {
		return new FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCommodityReferencePriceEnum> getType() {
		return FieldWithMetaCommodityReferencePriceEnum.class;
	}
	
		default Class<CommodityReferencePriceEnum> getValueType() {
			return CommodityReferencePriceEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), CommodityReferencePriceEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaCommodityReferencePriceEnumBuilder extends FieldWithMetaCommodityReferencePriceEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<CommodityReferencePriceEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder setValue(CommodityReferencePriceEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), CommodityReferencePriceEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumImpl
	class FieldWithMetaCommodityReferencePriceEnumImpl implements FieldWithMetaCommodityReferencePriceEnum {
		private final MetaFields meta;
		private final CommodityReferencePriceEnum value;
		
		protected FieldWithMetaCommodityReferencePriceEnumImpl(FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CommodityReferencePriceEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder toBuilder() {
			FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCommodityReferencePriceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCommodityReferencePriceEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilderImpl
	class FieldWithMetaCommodityReferencePriceEnumBuilderImpl implements FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected CommodityReferencePriceEnum value;
	
		public FieldWithMetaCommodityReferencePriceEnumBuilderImpl() {
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
		public CommodityReferencePriceEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder setValue(CommodityReferencePriceEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnum build() {
			return new FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder prune() {
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
		public FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder o = (FieldWithMetaCommodityReferencePriceEnum.FieldWithMetaCommodityReferencePriceEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCommodityReferencePriceEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaCommodityReferencePriceEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCommodityReferencePriceEnumMeta extends BasicRosettaMetaData<FieldWithMetaCommodityReferencePriceEnum>{

}
