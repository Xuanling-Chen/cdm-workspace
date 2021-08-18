package cdm.observable.asset.metafields;

import cdm.observable.asset.InformationProviderEnum;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumImpl;
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

public interface FieldWithMetaInformationProviderEnum extends RosettaModelObject, FieldWithMeta<InformationProviderEnum>, GlobalKey {
	FieldWithMetaInformationProviderEnum build();
	FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	InformationProviderEnum getValue();
	final static FieldWithMetaInformationProviderEnumMeta metaData = new FieldWithMetaInformationProviderEnumMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaInformationProviderEnum> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder builder() {
		return new FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaInformationProviderEnum> getType() {
		return FieldWithMetaInformationProviderEnum.class;
	}
	
		default Class<InformationProviderEnum> getValueType() {
			return InformationProviderEnum.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), InformationProviderEnum.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaInformationProviderEnumBuilder extends FieldWithMetaInformationProviderEnum, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<InformationProviderEnum> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder setMeta(MetaFields meta);
		FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder setValue(InformationProviderEnum value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), InformationProviderEnum.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumImpl
	class FieldWithMetaInformationProviderEnumImpl implements FieldWithMetaInformationProviderEnum {
		private final MetaFields meta;
		private final InformationProviderEnum value;
		
		protected FieldWithMetaInformationProviderEnumImpl(FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public InformationProviderEnum getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder toBuilder() {
			FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInformationProviderEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaInformationProviderEnum {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilderImpl
	class FieldWithMetaInformationProviderEnumBuilderImpl implements FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected InformationProviderEnum value;
	
		public FieldWithMetaInformationProviderEnumBuilderImpl() {
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
		public InformationProviderEnum getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder setValue(InformationProviderEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnum build() {
			return new FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder prune() {
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
		public FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder o = (FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaInformationProviderEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaInformationProviderEnumBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaInformationProviderEnumMeta extends BasicRosettaMetaData<FieldWithMetaInformationProviderEnum>{

}
