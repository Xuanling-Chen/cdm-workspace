package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.ProductBaseMeta;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier.ReferenceWithMetaProductIdentifierBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Serves as an abstract class to specify a product using a productIdentifier.
 * @version ${project.version}
 */
@RosettaClass

public interface ProductBase extends RosettaModelObject {
	ProductBase build();
	ProductBase.ProductBaseBuilder toBuilder();
	
	/**
	 */
	List<? extends ReferenceWithMetaProductIdentifier> getProductIdentifier();
	final static ProductBaseMeta metaData = new ProductBaseMeta();
	
	@Override
	default RosettaMetaData<? extends ProductBase> metaData() {
		return metaData;
	} 
			
	static ProductBase.ProductBaseBuilder builder() {
		return new ProductBase.ProductBaseBuilderImpl();
	}
	
	default Class<? extends ProductBase> getType() {
		return ProductBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("productIdentifier"), processor, ReferenceWithMetaProductIdentifier.class, getProductIdentifier());
	}
	
	
	interface ProductBaseBuilder extends ProductBase, RosettaModelObjectBuilder {
		ReferenceWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index);
		List<? extends ReferenceWithMetaProductIdentifierBuilder> getProductIdentifier();
		ProductBase.ProductBaseBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		ProductBase.ProductBaseBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		ProductBase.ProductBaseBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		ProductBase.ProductBaseBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		ProductBase.ProductBaseBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		ProductBase.ProductBaseBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		ProductBase.ProductBaseBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		ProductBase.ProductBaseBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("productIdentifier"), processor, ReferenceWithMetaProductIdentifierBuilder.class, getProductIdentifier());
		}
		
	}
	
	//ProductBase.ProductBaseImpl
	class ProductBaseImpl implements ProductBase {
		private final List<? extends ReferenceWithMetaProductIdentifier> productIdentifier;
		
		protected ProductBaseImpl(ProductBase.ProductBaseBuilder builder) {
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ReferenceWithMetaProductIdentifier> getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public ProductBase build() {
			return this;
		}
		
		@Override
		public ProductBase.ProductBaseBuilder toBuilder() {
			ProductBase.ProductBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductBase.ProductBaseBuilder builder) {
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBase {" +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
	
	//ProductBase.ProductBaseBuilderImpl
	class ProductBaseBuilderImpl implements ProductBase.ProductBaseBuilder {
	
		protected List<ReferenceWithMetaProductIdentifierBuilder> productIdentifier = new ArrayList<>();
	
		public ProductBaseBuilderImpl() {
		}
	
		@Override
		public List<? extends ReferenceWithMetaProductIdentifierBuilder> getProductIdentifier() {
			return productIdentifier;
		}
		
		public ReferenceWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index) {
		
			if (productIdentifier==null) {
				this.productIdentifier = new ArrayList<>();
			}
			ReferenceWithMetaProductIdentifierBuilder result;
			return getIndex(productIdentifier, _index, () -> {
						ReferenceWithMetaProductIdentifierBuilder newProductIdentifier = ReferenceWithMetaProductIdentifier.builder();
						return newProductIdentifier;
					});
		}
		
	
		@Override
		public ProductBase.ProductBaseBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ProductBase.ProductBaseBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public ProductBase.ProductBaseBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public ProductBase.ProductBaseBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public ProductBase.ProductBaseBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProductBase.ProductBaseBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers == null)  {
				this.productIdentifier = new ArrayList<>();
			}
			else {
				this.productIdentifier = productIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductBase.ProductBaseBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ProductBase.ProductBaseBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		
		@Override
		public ProductBase build() {
			return new ProductBase.ProductBaseImpl(this);
		}
		
		@Override
		public ProductBase.ProductBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductBase.ProductBaseBuilder prune() {
			productIdentifier = productIdentifier.stream().filter(b->b!=null).<ReferenceWithMetaProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductIdentifier()!=null && getProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductBase.ProductBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductBase.ProductBaseBuilder o = (ProductBase.ProductBaseBuilder) other;
			
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::getOrCreateProductIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBaseBuilder {" +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
}
