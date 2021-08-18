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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilderImpl;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateImpl;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface FieldWithMetaDate extends RosettaModelObject, FieldWithMeta<Date>, GlobalKey {
	FieldWithMetaDate build();
	FieldWithMetaDate.FieldWithMetaDateBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	Date getValue();
	final static FieldWithMetaDateMeta metaData = new FieldWithMetaDateMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaDate> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaDate.FieldWithMetaDateBuilder builder() {
		return new FieldWithMetaDate.FieldWithMetaDateBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaDate> getType() {
		return FieldWithMetaDate.class;
	}
	
		default Class<Date> getValueType() {
			return Date.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface FieldWithMetaDateBuilder extends FieldWithMetaDate, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<Date> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaDate.FieldWithMetaDateBuilder setMeta(MetaFields meta);
		FieldWithMetaDate.FieldWithMetaDateBuilder setValue(Date value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//FieldWithMetaDate.FieldWithMetaDateImpl
	class FieldWithMetaDateImpl implements FieldWithMetaDate {
		private final MetaFields meta;
		private final Date value;
		
		protected FieldWithMetaDateImpl(FieldWithMetaDate.FieldWithMetaDateBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Date getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaDate build() {
			return this;
		}
		
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder toBuilder() {
			FieldWithMetaDate.FieldWithMetaDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaDate.FieldWithMetaDateBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaDate _that = getType().cast(o);
		
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
			return "FieldWithMetaDate {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaDate.FieldWithMetaDateBuilderImpl
	class FieldWithMetaDateBuilderImpl implements FieldWithMetaDate.FieldWithMetaDateBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Date value;
	
		public FieldWithMetaDateBuilderImpl() {
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
		public Date getValue() {
			return value;
		}
		
	
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder setValue(Date value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public FieldWithMetaDate build() {
			return new FieldWithMetaDate.FieldWithMetaDateImpl(this);
		}
		
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaDate.FieldWithMetaDateBuilder prune() {
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
		public FieldWithMetaDate.FieldWithMetaDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaDate.FieldWithMetaDateBuilder o = (FieldWithMetaDate.FieldWithMetaDateBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaDate _that = getType().cast(o);
		
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
			return "FieldWithMetaDateBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaDateMeta extends BasicRosettaMetaData<FieldWithMetaDate>{

}
