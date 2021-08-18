package cdm.product.template;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Index;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaCommodity.ReferenceWithMetaCommodityBuilder;
import cdm.product.asset.ForeignExchange;
import cdm.product.template.meta.ProductMeta;
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
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the product that is the subject of a tradable product definition, an underlying product definition, a physical exercise, a position, or other purposes.
 * @version ${project.version}
 */
@RosettaClass

public interface Product extends RosettaModelObject, GlobalKey {
	Product build();
	Product.ProductBuilder toBuilder();
	
	/**
	 * Identifies a commodity by referencing a product identifier.
	 */
	ReferenceWithMetaCommodity getCommodity();
	/**
	 * Specifies the contractual product&#39;s economic terms, product identifier, and product taxonomy.
	 */
	ContractualProduct getContractualProduct();
	/**
	 * Defines a foreign exchange spot or forward transaction.
	 */
	ForeignExchange getForeignExchange();
	/**
	 * Identifies an index by referencing a product identifier.
	 */
	Index getIndex();
	/**
	 * Identifies a loan by referencing a product identifier and an optiional set of attributes.
	 */
	Loan getLoan();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Identifies a security by referencing a product identifier and a security type, plus an optional set of attributes.
	 */
	Security getSecurity();
	final static ProductMeta metaData = new ProductMeta();
	
	@Override
	default RosettaMetaData<? extends Product> metaData() {
		return metaData;
	} 
			
	static Product.ProductBuilder builder() {
		return new Product.ProductBuilderImpl();
	}
	
	default Class<? extends Product> getType() {
		return Product.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("commodity"), processor, ReferenceWithMetaCommodity.class, getCommodity());
		processRosetta(path.newSubPath("contractualProduct"), processor, ContractualProduct.class, getContractualProduct());
		processRosetta(path.newSubPath("foreignExchange"), processor, ForeignExchange.class, getForeignExchange());
		processRosetta(path.newSubPath("index"), processor, Index.class, getIndex());
		processRosetta(path.newSubPath("loan"), processor, Loan.class, getLoan());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("security"), processor, Security.class, getSecurity());
	}
	
	
	interface ProductBuilder extends Product, RosettaModelObjectBuilder {
		ReferenceWithMetaCommodityBuilder getOrCreateCommodity();
		ReferenceWithMetaCommodityBuilder getCommodity();
		ContractualProduct.ContractualProductBuilder getOrCreateContractualProduct();
		ContractualProduct.ContractualProductBuilder getContractualProduct();
		ForeignExchange.ForeignExchangeBuilder getOrCreateForeignExchange();
		ForeignExchange.ForeignExchangeBuilder getForeignExchange();
		Index.IndexBuilder getOrCreateIndex();
		Index.IndexBuilder getIndex();
		Loan.LoanBuilder getOrCreateLoan();
		Loan.LoanBuilder getLoan();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Security.SecurityBuilder getOrCreateSecurity();
		Security.SecurityBuilder getSecurity();
		Product.ProductBuilder setCommodity(ReferenceWithMetaCommodity commodity);
		Product.ProductBuilder setCommodityValue(Commodity commodity);
		Product.ProductBuilder setContractualProduct(ContractualProduct contractualProduct);
		Product.ProductBuilder setForeignExchange(ForeignExchange foreignExchange);
		Product.ProductBuilder setIndex(Index index);
		Product.ProductBuilder setLoan(Loan loan);
		Product.ProductBuilder setMeta(MetaFields meta);
		Product.ProductBuilder setSecurity(Security security);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("commodity"), processor, ReferenceWithMetaCommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("contractualProduct"), processor, ContractualProduct.ContractualProductBuilder.class, getContractualProduct());
			processRosetta(path.newSubPath("foreignExchange"), processor, ForeignExchange.ForeignExchangeBuilder.class, getForeignExchange());
			processRosetta(path.newSubPath("index"), processor, Index.IndexBuilder.class, getIndex());
			processRosetta(path.newSubPath("loan"), processor, Loan.LoanBuilder.class, getLoan());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("security"), processor, Security.SecurityBuilder.class, getSecurity());
		}
		
	}
	
	//Product.ProductImpl
	class ProductImpl implements Product {
		private final ReferenceWithMetaCommodity commodity;
		private final ContractualProduct contractualProduct;
		private final ForeignExchange foreignExchange;
		private final Index index;
		private final Loan loan;
		private final MetaFields meta;
		private final Security security;
		
		protected ProductImpl(Product.ProductBuilder builder) {
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.contractualProduct = ofNullable(builder.getContractualProduct()).map(f->f.build()).orElse(null);
			this.foreignExchange = ofNullable(builder.getForeignExchange()).map(f->f.build()).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
			this.loan = ofNullable(builder.getLoan()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaCommodity getCommodity() {
			return commodity;
		}
		
		@Override
		public ContractualProduct getContractualProduct() {
			return contractualProduct;
		}
		
		@Override
		public ForeignExchange getForeignExchange() {
			return foreignExchange;
		}
		
		@Override
		public Index getIndex() {
			return index;
		}
		
		@Override
		public Loan getLoan() {
			return loan;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Security getSecurity() {
			return security;
		}
		
		@Override
		public Product build() {
			return this;
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			Product.ProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Product.ProductBuilder builder) {
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getContractualProduct()).ifPresent(builder::setContractualProduct);
			ofNullable(getForeignExchange()).ifPresent(builder::setForeignExchange);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getLoan()).ifPresent(builder::setLoan);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(contractualProduct, _that.getContractualProduct())) return false;
			if (!Objects.equals(foreignExchange, _that.getForeignExchange())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (contractualProduct != null ? contractualProduct.hashCode() : 0);
			_result = 31 * _result + (foreignExchange != null ? foreignExchange.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Product {" +
				"commodity=" + this.commodity + ", " +
				"contractualProduct=" + this.contractualProduct + ", " +
				"foreignExchange=" + this.foreignExchange + ", " +
				"index=" + this.index + ", " +
				"loan=" + this.loan + ", " +
				"meta=" + this.meta + ", " +
				"security=" + this.security +
			'}';
		}
	}
	
	//Product.ProductBuilderImpl
	class ProductBuilderImpl implements Product.ProductBuilder, GlobalKeyBuilder {
	
		protected ReferenceWithMetaCommodityBuilder commodity;
		protected ContractualProduct.ContractualProductBuilder contractualProduct;
		protected ForeignExchange.ForeignExchangeBuilder foreignExchange;
		protected Index.IndexBuilder index;
		protected Loan.LoanBuilder loan;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Security.SecurityBuilder security;
	
		public ProductBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaCommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public ReferenceWithMetaCommodityBuilder getOrCreateCommodity() {
			ReferenceWithMetaCommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = ReferenceWithMetaCommodity.builder();
			}
			
			return result;
		}
		
		@Override
		public ContractualProduct.ContractualProductBuilder getContractualProduct() {
			return contractualProduct;
		}
		
		@Override
		public ContractualProduct.ContractualProductBuilder getOrCreateContractualProduct() {
			ContractualProduct.ContractualProductBuilder result;
			if (contractualProduct!=null) {
				result = contractualProduct;
			}
			else {
				result = contractualProduct = ContractualProduct.builder();
			}
			
			return result;
		}
		
		@Override
		public ForeignExchange.ForeignExchangeBuilder getForeignExchange() {
			return foreignExchange;
		}
		
		@Override
		public ForeignExchange.ForeignExchangeBuilder getOrCreateForeignExchange() {
			ForeignExchange.ForeignExchangeBuilder result;
			if (foreignExchange!=null) {
				result = foreignExchange;
			}
			else {
				result = foreignExchange = ForeignExchange.builder();
			}
			
			return result;
		}
		
		@Override
		public Index.IndexBuilder getIndex() {
			return index;
		}
		
		@Override
		public Index.IndexBuilder getOrCreateIndex() {
			Index.IndexBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = Index.builder();
			}
			
			return result;
		}
		
		@Override
		public Loan.LoanBuilder getLoan() {
			return loan;
		}
		
		@Override
		public Loan.LoanBuilder getOrCreateLoan() {
			Loan.LoanBuilder result;
			if (loan!=null) {
				result = loan;
			}
			else {
				result = loan = Loan.builder();
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
		public Security.SecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public Security.SecurityBuilder getOrCreateSecurity() {
			Security.SecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = Security.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Product.ProductBuilder setCommodity(ReferenceWithMetaCommodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		
		@Override
		public Product.ProductBuilder setCommodityValue(Commodity commodity) {
			this.getOrCreateCommodity().setValue(commodity);
			return this;
		}
		@Override
		public Product.ProductBuilder setContractualProduct(ContractualProduct contractualProduct) {
			this.contractualProduct = contractualProduct==null?null:contractualProduct.toBuilder();
			return this;
		}
		@Override
		public Product.ProductBuilder setForeignExchange(ForeignExchange foreignExchange) {
			this.foreignExchange = foreignExchange==null?null:foreignExchange.toBuilder();
			return this;
		}
		@Override
		public Product.ProductBuilder setIndex(Index index) {
			this.index = index==null?null:index.toBuilder();
			return this;
		}
		@Override
		public Product.ProductBuilder setLoan(Loan loan) {
			this.loan = loan==null?null:loan.toBuilder();
			return this;
		}
		@Override
		public Product.ProductBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Product.ProductBuilder setSecurity(Security security) {
			this.security = security==null?null:security.toBuilder();
			return this;
		}
		
		@Override
		public Product build() {
			return new Product.ProductImpl(this);
		}
		
		@Override
		public Product.ProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (contractualProduct!=null && !contractualProduct.prune().hasData()) contractualProduct = null;
			if (foreignExchange!=null && !foreignExchange.prune().hasData()) foreignExchange = null;
			if (index!=null && !index.prune().hasData()) index = null;
			if (loan!=null && !loan.prune().hasData()) loan = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (security!=null && !security.prune().hasData()) security = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getContractualProduct()!=null && getContractualProduct().hasData()) return true;
			if (getForeignExchange()!=null && getForeignExchange().hasData()) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			if (getLoan()!=null && getLoan().hasData()) return true;
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Product.ProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Product.ProductBuilder o = (Product.ProductBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getContractualProduct(), o.getContractualProduct(), this::setContractualProduct);
			merger.mergeRosetta(getForeignExchange(), o.getForeignExchange(), this::setForeignExchange);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			merger.mergeRosetta(getLoan(), o.getLoan(), this::setLoan);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Product _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(contractualProduct, _that.getContractualProduct())) return false;
			if (!Objects.equals(foreignExchange, _that.getForeignExchange())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(loan, _that.getLoan())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (contractualProduct != null ? contractualProduct.hashCode() : 0);
			_result = 31 * _result + (foreignExchange != null ? foreignExchange.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (loan != null ? loan.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductBuilder {" +
				"commodity=" + this.commodity + ", " +
				"contractualProduct=" + this.contractualProduct + ", " +
				"foreignExchange=" + this.foreignExchange + ", " +
				"index=" + this.index + ", " +
				"loan=" + this.loan + ", " +
				"meta=" + this.meta + ", " +
				"security=" + this.security +
			'}';
		}
	}
}
