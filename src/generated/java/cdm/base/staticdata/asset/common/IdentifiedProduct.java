package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.IdentifiedProductMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract class to specify a product which terms are abstracted through reference data.
 * @version ${project.version}
 */
@RosettaClass

public interface IdentifiedProduct extends RosettaModelObject {
	IdentifiedProduct build();
	IdentifiedProduct.IdentifiedProductBuilder toBuilder();
	
	/**
	 */
	ProductIdentifier getProductIdentifier();
	final static IdentifiedProductMeta metaData = new IdentifiedProductMeta();
	
	@Override
	default RosettaMetaData<? extends IdentifiedProduct> metaData() {
		return metaData;
	} 
			
	static IdentifiedProduct.IdentifiedProductBuilder builder() {
		return new IdentifiedProduct.IdentifiedProductBuilderImpl();
	}
	
	default Class<? extends IdentifiedProduct> getType() {
		return IdentifiedProduct.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.class, getProductIdentifier());
	}
	
	
	interface IdentifiedProductBuilder extends IdentifiedProduct, RosettaModelObjectBuilder {
		ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier();
		ProductIdentifier.ProductIdentifierBuilder getProductIdentifier();
		IdentifiedProduct.IdentifiedProductBuilder setProductIdentifier(ProductIdentifier productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getProductIdentifier());
		}
		
	}
	
	//IdentifiedProduct.IdentifiedProductImpl
	class IdentifiedProductImpl implements IdentifiedProduct {
		private final ProductIdentifier productIdentifier;
		
		protected IdentifiedProductImpl(IdentifiedProduct.IdentifiedProductBuilder builder) {
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ProductIdentifier getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public IdentifiedProduct build() {
			return this;
		}
		
		@Override
		public IdentifiedProduct.IdentifiedProductBuilder toBuilder() {
			IdentifiedProduct.IdentifiedProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedProduct.IdentifiedProductBuilder builder) {
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedProduct _that = getType().cast(o);
		
			if (!Objects.equals(productIdentifier, _that.getProductIdentifier())) return false;
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
			return "IdentifiedProduct {" +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
	
	//IdentifiedProduct.IdentifiedProductBuilderImpl
	class IdentifiedProductBuilderImpl implements IdentifiedProduct.IdentifiedProductBuilder {
	
		protected ProductIdentifier.ProductIdentifierBuilder productIdentifier;
	
		public IdentifiedProductBuilderImpl() {
		}
	
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier() {
			ProductIdentifier.ProductIdentifierBuilder result;
			if (productIdentifier!=null) {
				result = productIdentifier;
			}
			else {
				result = productIdentifier = ProductIdentifier.builder();
			}
			
			return result;
		}
		
	
		@Override
		public IdentifiedProduct.IdentifiedProductBuilder setProductIdentifier(ProductIdentifier productIdentifier) {
			this.productIdentifier = productIdentifier==null?null:productIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public IdentifiedProduct build() {
			return new IdentifiedProduct.IdentifiedProductImpl(this);
		}
		
		@Override
		public IdentifiedProduct.IdentifiedProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedProduct.IdentifiedProductBuilder prune() {
			if (productIdentifier!=null && !productIdentifier.prune().hasData()) productIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductIdentifier()!=null && getProductIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedProduct.IdentifiedProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IdentifiedProduct.IdentifiedProductBuilder o = (IdentifiedProduct.IdentifiedProductBuilder) other;
			
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::setProductIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedProduct _that = getType().cast(o);
		
			if (!Objects.equals(productIdentifier, _that.getProductIdentifier())) return false;
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
			return "IdentifiedProductBuilder {" +
				"productIdentifier=" + this.productIdentifier +
			'}';
		}
	}
}
