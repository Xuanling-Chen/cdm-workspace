package com.rosetta.model.metafields;

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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilderImpl;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringImpl;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface FieldWithMetaString extends RosettaModelObject, FieldWithMeta<String>, GlobalKey {
	FieldWithMetaString build();
	FieldWithMetaString.FieldWithMetaStringBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	String getValue();
	final static FieldWithMetaStringMeta metaData = new FieldWithMetaStringMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaString> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaString.FieldWithMetaStringBuilder builder() {
		return new FieldWithMetaString.FieldWithMetaStringBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaString> getType() {
		return FieldWithMetaString.class;
	}
	
		default Class<String> getValueType() {
			return String.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaStringBuilder extends FieldWithMetaString, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<String> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaString.FieldWithMetaStringBuilder setMeta(MetaFields meta);
		FieldWithMetaString.FieldWithMetaStringBuilder setValue(String value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaString.FieldWithMetaStringImpl
	class FieldWithMetaStringImpl implements FieldWithMetaString {
		private final MetaFields meta;
		private final String value;
		
		protected FieldWithMetaStringImpl(FieldWithMetaString.FieldWithMetaStringBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public String getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaString build() {
			return this;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder toBuilder() {
			FieldWithMetaString.FieldWithMetaStringBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaString.FieldWithMetaStringBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaString _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaString {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaString.FieldWithMetaStringBuilderImpl
	class FieldWithMetaStringBuilderImpl implements FieldWithMetaString.FieldWithMetaStringBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected String value;
	
		public FieldWithMetaStringBuilderImpl() {
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
		public String getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaString build() {
			return new FieldWithMetaString.FieldWithMetaStringImpl(this);
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder prune() {
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
		public FieldWithMetaString.FieldWithMetaStringBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaString.FieldWithMetaStringBuilder o = (FieldWithMetaString.FieldWithMetaStringBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaString _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaStringBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaStringMeta extends BasicRosettaMetaData<FieldWithMetaString>{

}
