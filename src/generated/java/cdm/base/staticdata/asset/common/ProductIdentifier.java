package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.ProductIdentifierMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface ProductIdentifier extends RosettaModelObject, GlobalKey {
	ProductIdentifier build();
	ProductIdentifier.ProductIdentifierBuilder toBuilder();
	
	/**
	 * Provides an identifier associated with a specific product.  The identifier is unique within the public source specified in the source attribute.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Defines the source of the identifier.
	 */
	ProductIdTypeEnum getSource();
	final static ProductIdentifierMeta metaData = new ProductIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends ProductIdentifier> metaData() {
		return metaData;
	} 
			
	static ProductIdentifier.ProductIdentifierBuilder builder() {
		return new ProductIdentifier.ProductIdentifierBuilderImpl();
	}
	
	default Class<? extends ProductIdentifier> getType() {
		return ProductIdentifier.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("source"), ProductIdTypeEnum.class, getSource(), this);
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface ProductIdentifierBuilder extends ProductIdentifier, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIdentifier();
		FieldWithMetaStringBuilder getIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ProductIdentifier.ProductIdentifierBuilder setIdentifier(FieldWithMetaString identifier);
		ProductIdentifier.ProductIdentifierBuilder setIdentifierValue(String identifier);
		ProductIdentifier.ProductIdentifierBuilder setMeta(MetaFields meta);
		ProductIdentifier.ProductIdentifierBuilder setSource(ProductIdTypeEnum source);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("source"), ProductIdTypeEnum.class, getSource(), this);
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaStringBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//ProductIdentifier.ProductIdentifierImpl
	class ProductIdentifierImpl implements ProductIdentifier {
		private final FieldWithMetaString identifier;
		private final MetaFields meta;
		private final ProductIdTypeEnum source;
		
		protected ProductIdentifierImpl(ProductIdentifier.ProductIdentifierBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.source = builder.getSource();
		}
		
		@Override
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ProductIdTypeEnum getSource() {
			return source;
		}
		
		@Override
		public ProductIdentifier build() {
			return this;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder toBuilder() {
			ProductIdentifier.ProductIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductIdentifier.ProductIdentifierBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSource()).ifPresent(builder::setSource);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdentifier {" +
				"identifier=" + this.identifier + ", " +
				"meta=" + this.meta + ", " +
				"source=" + this.source +
			'}';
		}
	}
	
	//ProductIdentifier.ProductIdentifierBuilderImpl
	class ProductIdentifierBuilderImpl implements ProductIdentifier.ProductIdentifierBuilder, GlobalKeyBuilder {
	
		protected FieldWithMetaStringBuilder identifier;
		protected MetaFields.MetaFieldsBuilder meta;
		protected ProductIdTypeEnum source;
	
		public ProductIdentifierBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
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
		public ProductIdTypeEnum getSource() {
			return source;
		}
		
	
		@Override
		public ProductIdentifier.ProductIdentifierBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public ProductIdentifier.ProductIdentifierBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ProductIdentifier.ProductIdentifierBuilder setSource(ProductIdTypeEnum source) {
			this.source = source==null?null:source;
			return this;
		}
		
		@Override
		public ProductIdentifier build() {
			return new ProductIdentifier.ProductIdentifierImpl(this);
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductIdentifier.ProductIdentifierBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductIdentifier.ProductIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductIdentifier.ProductIdentifierBuilder o = (ProductIdentifier.ProductIdentifierBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getSource(), o.getSource(), this::setSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdentifierBuilder {" +
				"identifier=" + this.identifier + ", " +
				"meta=" + this.meta + ", " +
				"source=" + this.source +
			'}';
		}
	}
}
