package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.ProductTaxonomyMeta;
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
 * Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
 * @version ${project.version}
 */
@RosettaClass

public interface ProductTaxonomy extends RosettaModelObject {
	ProductTaxonomy build();
	ProductTaxonomy.ProductTaxonomyBuilder toBuilder();
	
	/**
	 * The taxonomy source.
	 */
	TaxonomySourceEnum getTaxonomySource();
	/**
	 * The taxonomy value.
	 */
	String getTaxonomyValue();
	final static ProductTaxonomyMeta metaData = new ProductTaxonomyMeta();
	
	@Override
	default RosettaMetaData<? extends ProductTaxonomy> metaData() {
		return metaData;
	} 
			
	static ProductTaxonomy.ProductTaxonomyBuilder builder() {
		return new ProductTaxonomy.ProductTaxonomyBuilderImpl();
	}
	
	default Class<? extends ProductTaxonomy> getType() {
		return ProductTaxonomy.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("taxonomySource"), TaxonomySourceEnum.class, getTaxonomySource(), this);
		processor.processBasic(path.newSubPath("taxonomyValue"), String.class, getTaxonomyValue(), this);
		
	}
	
	
	interface ProductTaxonomyBuilder extends ProductTaxonomy, RosettaModelObjectBuilder {
		ProductTaxonomy.ProductTaxonomyBuilder setTaxonomySource(TaxonomySourceEnum taxonomySource);
		ProductTaxonomy.ProductTaxonomyBuilder setTaxonomyValue(String taxonomyValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("taxonomySource"), TaxonomySourceEnum.class, getTaxonomySource(), this);
			processor.processBasic(path.newSubPath("taxonomyValue"), String.class, getTaxonomyValue(), this);
			
		}
		
	}
	
	//ProductTaxonomy.ProductTaxonomyImpl
	class ProductTaxonomyImpl implements ProductTaxonomy {
		private final TaxonomySourceEnum taxonomySource;
		private final String taxonomyValue;
		
		protected ProductTaxonomyImpl(ProductTaxonomy.ProductTaxonomyBuilder builder) {
			this.taxonomySource = builder.getTaxonomySource();
			this.taxonomyValue = builder.getTaxonomyValue();
		}
		
		@Override
		public TaxonomySourceEnum getTaxonomySource() {
			return taxonomySource;
		}
		
		@Override
		public String getTaxonomyValue() {
			return taxonomyValue;
		}
		
		@Override
		public ProductTaxonomy build() {
			return this;
		}
		
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder toBuilder() {
			ProductTaxonomy.ProductTaxonomyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductTaxonomy.ProductTaxonomyBuilder builder) {
			ofNullable(getTaxonomySource()).ifPresent(builder::setTaxonomySource);
			ofNullable(getTaxonomyValue()).ifPresent(builder::setTaxonomyValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(taxonomySource, _that.getTaxonomySource())) return false;
			if (!Objects.equals(taxonomyValue, _that.getTaxonomyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxonomySource != null ? taxonomySource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxonomyValue != null ? taxonomyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductTaxonomy {" +
				"taxonomySource=" + this.taxonomySource + ", " +
				"taxonomyValue=" + this.taxonomyValue +
			'}';
		}
	}
	
	//ProductTaxonomy.ProductTaxonomyBuilderImpl
	class ProductTaxonomyBuilderImpl implements ProductTaxonomy.ProductTaxonomyBuilder {
	
		protected TaxonomySourceEnum taxonomySource;
		protected String taxonomyValue;
	
		public ProductTaxonomyBuilderImpl() {
		}
	
		@Override
		public TaxonomySourceEnum getTaxonomySource() {
			return taxonomySource;
		}
		
		@Override
		public String getTaxonomyValue() {
			return taxonomyValue;
		}
		
	
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder setTaxonomySource(TaxonomySourceEnum taxonomySource) {
			this.taxonomySource = taxonomySource==null?null:taxonomySource;
			return this;
		}
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder setTaxonomyValue(String taxonomyValue) {
			this.taxonomyValue = taxonomyValue==null?null:taxonomyValue;
			return this;
		}
		
		@Override
		public ProductTaxonomy build() {
			return new ProductTaxonomy.ProductTaxonomyImpl(this);
		}
		
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaxonomySource()!=null) return true;
			if (getTaxonomyValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductTaxonomy.ProductTaxonomyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductTaxonomy.ProductTaxonomyBuilder o = (ProductTaxonomy.ProductTaxonomyBuilder) other;
			
			
			merger.mergeBasic(getTaxonomySource(), o.getTaxonomySource(), this::setTaxonomySource);
			merger.mergeBasic(getTaxonomyValue(), o.getTaxonomyValue(), this::setTaxonomyValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductTaxonomy _that = getType().cast(o);
		
			if (!Objects.equals(taxonomySource, _that.getTaxonomySource())) return false;
			if (!Objects.equals(taxonomyValue, _that.getTaxonomyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxonomySource != null ? taxonomySource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (taxonomyValue != null ? taxonomyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductTaxonomyBuilder {" +
				"taxonomySource=" + this.taxonomySource + ", " +
				"taxonomyValue=" + this.taxonomyValue +
			'}';
		}
	}
}
