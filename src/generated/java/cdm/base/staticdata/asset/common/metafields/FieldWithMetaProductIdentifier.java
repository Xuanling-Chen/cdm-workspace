package cdm.base.staticdata.asset.common.metafields;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilderImpl;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierImpl;
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

public interface FieldWithMetaProductIdentifier extends RosettaModelObject, FieldWithMeta<ProductIdentifier>, GlobalKey {
	FieldWithMetaProductIdentifier build();
	FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	ProductIdentifier getValue();
	final static FieldWithMetaProductIdentifierMeta metaData = new FieldWithMetaProductIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaProductIdentifier> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder builder() {
		return new FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaProductIdentifier> getType() {
		return FieldWithMetaProductIdentifier.class;
	}
	
		default Class<ProductIdentifier> getValueType() {
			return ProductIdentifier.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, ProductIdentifier.class, getValue());
	}
	
	
	interface FieldWithMetaProductIdentifierBuilder extends FieldWithMetaProductIdentifier, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<ProductIdentifier> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ProductIdentifier.ProductIdentifierBuilder getOrCreateValue();
		ProductIdentifier.ProductIdentifierBuilder getValue();
		FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder setMeta(MetaFields meta);
		FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder setValue(ProductIdentifier value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierImpl
	class FieldWithMetaProductIdentifierImpl implements FieldWithMetaProductIdentifier {
		private final MetaFields meta;
		private final ProductIdentifier value;
		
		protected FieldWithMetaProductIdentifierImpl(FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ProductIdentifier getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaProductIdentifier build() {
			return this;
		}
		
		@Override
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder toBuilder() {
			FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaProductIdentifier _that = getType().cast(o);
		
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
			return "FieldWithMetaProductIdentifier {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilderImpl
	class FieldWithMetaProductIdentifierBuilderImpl implements FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected ProductIdentifier.ProductIdentifierBuilder value;
	
		public FieldWithMetaProductIdentifierBuilderImpl() {
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
		public ProductIdentifier.ProductIdentifierBuilder getValue() {
			return value;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateValue() {
			ProductIdentifier.ProductIdentifierBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = ProductIdentifier.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder setValue(ProductIdentifier value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaProductIdentifier build() {
			return new FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierImpl(this);
		}
		
		@Override
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder prune() {
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
		public FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder o = (FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaProductIdentifier _that = getType().cast(o);
		
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
			return "FieldWithMetaProductIdentifierBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaProductIdentifierMeta extends BasicRosettaMetaData<FieldWithMetaProductIdentifier>{

}
