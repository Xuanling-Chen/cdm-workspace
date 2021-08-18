package cdm.base.math.metafields;

import cdm.base.math.Quantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.base.math.metafields.FieldWithMetaQuantity.FieldWithMetaQuantityBuilder;
import cdm.base.math.metafields.FieldWithMetaQuantity.FieldWithMetaQuantityBuilderImpl;
import cdm.base.math.metafields.FieldWithMetaQuantity.FieldWithMetaQuantityImpl;
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

public interface FieldWithMetaQuantity extends RosettaModelObject, FieldWithMeta<Quantity>, GlobalKey {
	FieldWithMetaQuantity build();
	FieldWithMetaQuantity.FieldWithMetaQuantityBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	Quantity getValue();
	final static FieldWithMetaQuantityMeta metaData = new FieldWithMetaQuantityMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaQuantity> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaQuantity.FieldWithMetaQuantityBuilder builder() {
		return new FieldWithMetaQuantity.FieldWithMetaQuantityBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaQuantity> getType() {
		return FieldWithMetaQuantity.class;
	}
	
		default Class<Quantity> getValueType() {
			return Quantity.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, Quantity.class, getValue());
	}
	
	
	interface FieldWithMetaQuantityBuilder extends FieldWithMetaQuantity, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<Quantity> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Quantity.QuantityBuilder getOrCreateValue();
		Quantity.QuantityBuilder getValue();
		FieldWithMetaQuantity.FieldWithMetaQuantityBuilder setMeta(MetaFields meta);
		FieldWithMetaQuantity.FieldWithMetaQuantityBuilder setValue(Quantity value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, Quantity.QuantityBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaQuantity.FieldWithMetaQuantityImpl
	class FieldWithMetaQuantityImpl implements FieldWithMetaQuantity {
		private final MetaFields meta;
		private final Quantity value;
		
		protected FieldWithMetaQuantityImpl(FieldWithMetaQuantity.FieldWithMetaQuantityBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Quantity getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaQuantity build() {
			return this;
		}
		
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder toBuilder() {
			FieldWithMetaQuantity.FieldWithMetaQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaQuantity.FieldWithMetaQuantityBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaQuantity _that = getType().cast(o);
		
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
			return "FieldWithMetaQuantity {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaQuantity.FieldWithMetaQuantityBuilderImpl
	class FieldWithMetaQuantityBuilderImpl implements FieldWithMetaQuantity.FieldWithMetaQuantityBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Quantity.QuantityBuilder value;
	
		public FieldWithMetaQuantityBuilderImpl() {
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
		public Quantity.QuantityBuilder getValue() {
			return value;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateValue() {
			Quantity.QuantityBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Quantity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder setValue(Quantity value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaQuantity build() {
			return new FieldWithMetaQuantity.FieldWithMetaQuantityImpl(this);
		}
		
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaQuantity.FieldWithMetaQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaQuantity.FieldWithMetaQuantityBuilder o = (FieldWithMetaQuantity.FieldWithMetaQuantityBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaQuantity _that = getType().cast(o);
		
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
			return "FieldWithMetaQuantityBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaQuantityMeta extends BasicRosettaMetaData<FieldWithMetaQuantity>{

}
