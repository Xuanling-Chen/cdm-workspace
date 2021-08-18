package cdm.product.template;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.product.common.ProductIdentification;
import cdm.product.template.meta.ContractualProductMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.Templatable;
import com.rosetta.model.lib.Templatable.TemplatableBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.qualify.Qualified;
import com.rosetta.model.metafields.MetaAndTemplateFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  A class to specify the contractual products&#39; economic terms, alongside their product identification and product taxonomy. The contractual product class is meant to be used across the pre-execution, execution and (as part of the Contract) post-execution lifecycle contexts.
 * @version ${project.version}
 */
@RosettaClass

public interface ContractualProduct extends RosettaModelObject, Templatable, GlobalKey {
	ContractualProduct build();
	ContractualProduct.ContractualProductBuilder toBuilder();
	
	/**
	 * The economic terms associated with a contractual product, i.e. the set of features that are price-forming.
	 */
	EconomicTerms getEconomicTerms();
	/**
	 */
	MetaAndTemplateFields getMeta();
	/**
	 * The product identification value(s) that might be associated with a contractual product. The CDM provides the ability to associate several product identification methods with a product.
	 */
	ProductIdentification getProductIdentification();
	/**
	 * The product taxonomy value(s) associated with a contractual product.
	 */
	List<? extends ProductTaxonomy> getProductTaxonomy();
	final static ContractualProductMeta metaData = new ContractualProductMeta();
	
	@Override
	default RosettaMetaData<? extends ContractualProduct> metaData() {
		return metaData;
	} 
			
	static ContractualProduct.ContractualProductBuilder builder() {
		return new ContractualProduct.ContractualProductBuilderImpl();
	}
	
	default Class<? extends ContractualProduct> getType() {
		return ContractualProduct.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.class, getEconomicTerms());
		processRosetta(path.newSubPath("meta"), processor, MetaAndTemplateFields.class, getMeta());
		processRosetta(path.newSubPath("productIdentification"), processor, ProductIdentification.class, getProductIdentification());
		processRosetta(path.newSubPath("productTaxonomy"), processor, ProductTaxonomy.class, getProductTaxonomy());
	}
	
	
	interface ContractualProductBuilder extends ContractualProduct, RosettaModelObjectBuilder {
		EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms();
		EconomicTerms.EconomicTermsBuilder getEconomicTerms();
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder getOrCreateMeta();
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder getMeta();
		ProductIdentification.ProductIdentificationBuilder getOrCreateProductIdentification();
		ProductIdentification.ProductIdentificationBuilder getProductIdentification();
		ProductTaxonomy.ProductTaxonomyBuilder getOrCreateProductTaxonomy(int _index);
		List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getProductTaxonomy();
		ContractualProduct.ContractualProductBuilder setEconomicTerms(EconomicTerms economicTerms);
		ContractualProduct.ContractualProductBuilder setMeta(MetaAndTemplateFields meta);
		ContractualProduct.ContractualProductBuilder setProductIdentification(ProductIdentification productIdentification);
		ContractualProduct.ContractualProductBuilder addProductTaxonomy(ProductTaxonomy productTaxonomy);
		ContractualProduct.ContractualProductBuilder addProductTaxonomy(ProductTaxonomy productTaxonomy, int _idx);
		ContractualProduct.ContractualProductBuilder addProductTaxonomy(List<? extends ProductTaxonomy> productTaxonomy);
		ContractualProduct.ContractualProductBuilder setProductTaxonomy(List<? extends ProductTaxonomy> productTaxonomy);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.EconomicTermsBuilder.class, getEconomicTerms());
			processRosetta(path.newSubPath("meta"), processor, MetaAndTemplateFields.MetaAndTemplateFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("productIdentification"), processor, ProductIdentification.ProductIdentificationBuilder.class, getProductIdentification());
			processRosetta(path.newSubPath("productTaxonomy"), processor, ProductTaxonomy.ProductTaxonomyBuilder.class, getProductTaxonomy());
		}
		
	}
	
	//ContractualProduct.ContractualProductImpl
	class ContractualProductImpl implements ContractualProduct {
		private final EconomicTerms economicTerms;
		private final MetaAndTemplateFields meta;
		private final ProductIdentification productIdentification;
		private final List<? extends ProductTaxonomy> productTaxonomy;
		
		protected ContractualProductImpl(ContractualProduct.ContractualProductBuilder builder) {
			this.economicTerms = ofNullable(builder.getEconomicTerms()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.productIdentification = ofNullable(builder.getProductIdentification()).map(f->f.build()).orElse(null);
			this.productTaxonomy = ofNullable(builder.getProductTaxonomy()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public EconomicTerms getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		public MetaAndTemplateFields getMeta() {
			return meta;
		}
		
		@Override
		public ProductIdentification getProductIdentification() {
			return productIdentification;
		}
		
		@Override
		public List<? extends ProductTaxonomy> getProductTaxonomy() {
			return productTaxonomy;
		}
		
		@Override
		public ContractualProduct build() {
			return this;
		}
		
		@Override
		public ContractualProduct.ContractualProductBuilder toBuilder() {
			ContractualProduct.ContractualProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualProduct.ContractualProductBuilder builder) {
			ofNullable(getEconomicTerms()).ifPresent(builder::setEconomicTerms);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getProductIdentification()).ifPresent(builder::setProductIdentification);
			ofNullable(getProductTaxonomy()).ifPresent(builder::setProductTaxonomy);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualProduct _that = getType().cast(o);
		
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(productIdentification, _that.getProductIdentification())) return false;
			if (!ListEquals.listEquals(productTaxonomy, _that.getProductTaxonomy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (productIdentification != null ? productIdentification.hashCode() : 0);
			_result = 31 * _result + (productTaxonomy != null ? productTaxonomy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualProduct {" +
				"economicTerms=" + this.economicTerms + ", " +
				"meta=" + this.meta + ", " +
				"productIdentification=" + this.productIdentification + ", " +
				"productTaxonomy=" + this.productTaxonomy +
			'}';
		}
	}
	
	//ContractualProduct.ContractualProductBuilderImpl
	class ContractualProductBuilderImpl implements ContractualProduct.ContractualProductBuilder, GlobalKeyBuilder, TemplatableBuilder, Qualified {
	
		protected EconomicTerms.EconomicTermsBuilder economicTerms;
		protected MetaAndTemplateFields.MetaAndTemplateFieldsBuilder meta;
		protected ProductIdentification.ProductIdentificationBuilder productIdentification;
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> productTaxonomy = new ArrayList<>();
	
		public ContractualProductBuilderImpl() {
		}
	
		@Override
		public EconomicTerms.EconomicTermsBuilder getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms() {
			EconomicTerms.EconomicTermsBuilder result;
			if (economicTerms!=null) {
				result = economicTerms;
			}
			else {
				result = economicTerms = EconomicTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder getOrCreateMeta() {
			MetaAndTemplateFields.MetaAndTemplateFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaAndTemplateFields.builder();
			}
			
			return result;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder getProductIdentification() {
			return productIdentification;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder getOrCreateProductIdentification() {
			ProductIdentification.ProductIdentificationBuilder result;
			if (productIdentification!=null) {
				result = productIdentification;
			}
			else {
				result = productIdentification = ProductIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ProductTaxonomy.ProductTaxonomyBuilder> getProductTaxonomy() {
			return productTaxonomy;
		}
		
		public ProductTaxonomy.ProductTaxonomyBuilder getOrCreateProductTaxonomy(int _index) {
		
			if (productTaxonomy==null) {
				this.productTaxonomy = new ArrayList<>();
			}
			ProductTaxonomy.ProductTaxonomyBuilder result;
			return getIndex(productTaxonomy, _index, () -> {
						ProductTaxonomy.ProductTaxonomyBuilder newProductTaxonomy = ProductTaxonomy.builder();
						return newProductTaxonomy;
					});
		}
		
	
		@Override
		public ContractualProduct.ContractualProductBuilder setEconomicTerms(EconomicTerms economicTerms) {
			this.economicTerms = economicTerms==null?null:economicTerms.toBuilder();
			return this;
		}
		@Override
		public ContractualProduct.ContractualProductBuilder setMeta(MetaAndTemplateFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ContractualProduct.ContractualProductBuilder setProductIdentification(ProductIdentification productIdentification) {
			this.productIdentification = productIdentification==null?null:productIdentification.toBuilder();
			return this;
		}
		@Override
		public ContractualProduct.ContractualProductBuilder addProductTaxonomy(ProductTaxonomy productTaxonomy) {
			if (productTaxonomy!=null) this.productTaxonomy.add(productTaxonomy.toBuilder());
			return this;
		}
		
		@Override
		public ContractualProduct.ContractualProductBuilder addProductTaxonomy(ProductTaxonomy productTaxonomy, int _idx) {
			getIndex(this.productTaxonomy, _idx, () -> productTaxonomy.toBuilder());
			return this;
		}
		@Override 
		public ContractualProduct.ContractualProductBuilder addProductTaxonomy(List<? extends ProductTaxonomy> productTaxonomys) {
			if (productTaxonomys != null) {
				for (ProductTaxonomy toAdd : productTaxonomys) {
					this.productTaxonomy.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ContractualProduct.ContractualProductBuilder setProductTaxonomy(List<? extends ProductTaxonomy> productTaxonomys) {
			if (productTaxonomys == null)  {
				this.productTaxonomy = new ArrayList<>();
			}
			else {
				this.productTaxonomy = productTaxonomys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		public void setQualification(String qualification) {
			this.getOrCreateProductIdentification().setProductQualifier(qualification);
		}
		
		@Override
		public ContractualProduct build() {
			return new ContractualProduct.ContractualProductImpl(this);
		}
		
		@Override
		public ContractualProduct.ContractualProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualProduct.ContractualProductBuilder prune() {
			if (economicTerms!=null && !economicTerms.prune().hasData()) economicTerms = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (productIdentification!=null && !productIdentification.prune().hasData()) productIdentification = null;
			productTaxonomy = productTaxonomy.stream().filter(b->b!=null).<ProductTaxonomy.ProductTaxonomyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEconomicTerms()!=null && getEconomicTerms().hasData()) return true;
			if (getProductIdentification()!=null && getProductIdentification().hasData()) return true;
			if (getProductTaxonomy()!=null && getProductTaxonomy().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualProduct.ContractualProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualProduct.ContractualProductBuilder o = (ContractualProduct.ContractualProductBuilder) other;
			
			merger.mergeRosetta(getEconomicTerms(), o.getEconomicTerms(), this::setEconomicTerms);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getProductIdentification(), o.getProductIdentification(), this::setProductIdentification);
			merger.mergeRosetta(getProductTaxonomy(), o.getProductTaxonomy(), this::getOrCreateProductTaxonomy);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualProduct _that = getType().cast(o);
		
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(productIdentification, _that.getProductIdentification())) return false;
			if (!ListEquals.listEquals(productTaxonomy, _that.getProductTaxonomy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (productIdentification != null ? productIdentification.hashCode() : 0);
			_result = 31 * _result + (productTaxonomy != null ? productTaxonomy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualProductBuilder {" +
				"economicTerms=" + this.economicTerms + ", " +
				"meta=" + this.meta + ", " +
				"productIdentification=" + this.productIdentification + ", " +
				"productTaxonomy=" + this.productTaxonomy +
			'}';
		}
	}
}
