package cdm.product.common;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.ExternalProductType;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder;
import cdm.product.common.meta.ProductIdentificationMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.annotations.RosettaQualified;
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
 * Combines the CDM product qualifier with other product types and identifiers. While the CDM product qualifier is derived by the CDM from the product payout features, the other product type and identification elements are assigned by external sources and correspond to values specified by other data representation protocols.
 * @version ${project.version}
 */
@RosettaClass
@RosettaQualified(attribute="productQualifier",qualifiedClass=cdm.product.template.EconomicTerms.class)

public interface ProductIdentification extends RosettaModelObject {
	ProductIdentification build();
	ProductIdentification.ProductIdentificationBuilder toBuilder();
	
	/**
	 * Provides a classification of the type of product that is external to the product qualifications used in the CDM. Product types mapped from external models are mapped to this data type.
	 */
	List<? extends ExternalProductType> getExternalProductType();
	/**
	 * Classifies the most important risk class of the trade.
	 */
	FieldWithMetaAssetClassEnum getPrimaryAssetData();
	/**
	 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
	 */
	List<? extends ProductIdentifier> getProductIdentifier();
	/**
	 * Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.
	 */
	String getProductQualifier();
	/**
	 *  Classifies additional risk classes of the trade, if any.
	 */
	List<? extends FieldWithMetaAssetClassEnum> getSecondaryAssetData();
	final static ProductIdentificationMeta metaData = new ProductIdentificationMeta();
	
	@Override
	default RosettaMetaData<? extends ProductIdentification> metaData() {
		return metaData;
	} 
			
	static ProductIdentification.ProductIdentificationBuilder builder() {
		return new ProductIdentification.ProductIdentificationBuilderImpl();
	}
	
	default Class<? extends ProductIdentification> getType() {
		return ProductIdentification.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
		
		processRosetta(path.newSubPath("externalProductType"), processor, ExternalProductType.class, getExternalProductType());
		processRosetta(path.newSubPath("primaryAssetData"), processor, FieldWithMetaAssetClassEnum.class, getPrimaryAssetData());
		processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.class, getProductIdentifier());
		processRosetta(path.newSubPath("secondaryAssetData"), processor, FieldWithMetaAssetClassEnum.class, getSecondaryAssetData());
	}
	
	
	interface ProductIdentificationBuilder extends ProductIdentification, RosettaModelObjectBuilder {
		ExternalProductType.ExternalProductTypeBuilder getOrCreateExternalProductType(int _index);
		List<? extends ExternalProductType.ExternalProductTypeBuilder> getExternalProductType();
		FieldWithMetaAssetClassEnumBuilder getOrCreatePrimaryAssetData();
		FieldWithMetaAssetClassEnumBuilder getPrimaryAssetData();
		ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier(int _index);
		List<? extends ProductIdentifier.ProductIdentifierBuilder> getProductIdentifier();
		FieldWithMetaAssetClassEnumBuilder getOrCreateSecondaryAssetData(int _index);
		List<? extends FieldWithMetaAssetClassEnumBuilder> getSecondaryAssetData();
		ProductIdentification.ProductIdentificationBuilder addExternalProductType(ExternalProductType externalProductType);
		ProductIdentification.ProductIdentificationBuilder addExternalProductType(ExternalProductType externalProductType, int _idx);
		ProductIdentification.ProductIdentificationBuilder addExternalProductType(List<? extends ExternalProductType> externalProductType);
		ProductIdentification.ProductIdentificationBuilder setExternalProductType(List<? extends ExternalProductType> externalProductType);
		ProductIdentification.ProductIdentificationBuilder setPrimaryAssetData(FieldWithMetaAssetClassEnum primaryAssetData);
		ProductIdentification.ProductIdentificationBuilder setPrimaryAssetDataValue(AssetClassEnum primaryAssetData);
		ProductIdentification.ProductIdentificationBuilder addProductIdentifier(ProductIdentifier productIdentifier);
		ProductIdentification.ProductIdentificationBuilder addProductIdentifier(ProductIdentifier productIdentifier, int _idx);
		ProductIdentification.ProductIdentificationBuilder addProductIdentifier(List<? extends ProductIdentifier> productIdentifier);
		ProductIdentification.ProductIdentificationBuilder setProductIdentifier(List<? extends ProductIdentifier> productIdentifier);
		ProductIdentification.ProductIdentificationBuilder setProductQualifier(String productQualifier);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(FieldWithMetaAssetClassEnum secondaryAssetData);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(FieldWithMetaAssetClassEnum secondaryAssetData, int _idx);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(AssetClassEnum secondaryAssetData);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(AssetClassEnum secondaryAssetData, int _idx);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(List<? extends FieldWithMetaAssetClassEnum> secondaryAssetData);
		ProductIdentification.ProductIdentificationBuilder setSecondaryAssetData(List<? extends FieldWithMetaAssetClassEnum> secondaryAssetData);
		ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(List<? extends AssetClassEnum> secondaryAssetData);
		ProductIdentification.ProductIdentificationBuilder setSecondaryAssetDataValue(List<? extends AssetClassEnum> secondaryAssetData);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
			
			processRosetta(path.newSubPath("externalProductType"), processor, ExternalProductType.ExternalProductTypeBuilder.class, getExternalProductType());
			processRosetta(path.newSubPath("primaryAssetData"), processor, FieldWithMetaAssetClassEnumBuilder.class, getPrimaryAssetData());
			processRosetta(path.newSubPath("productIdentifier"), processor, ProductIdentifier.ProductIdentifierBuilder.class, getProductIdentifier());
			processRosetta(path.newSubPath("secondaryAssetData"), processor, FieldWithMetaAssetClassEnumBuilder.class, getSecondaryAssetData());
		}
		
	}
	
	//ProductIdentification.ProductIdentificationImpl
	class ProductIdentificationImpl implements ProductIdentification {
		private final List<? extends ExternalProductType> externalProductType;
		private final FieldWithMetaAssetClassEnum primaryAssetData;
		private final List<? extends ProductIdentifier> productIdentifier;
		private final String productQualifier;
		private final List<? extends FieldWithMetaAssetClassEnum> secondaryAssetData;
		
		protected ProductIdentificationImpl(ProductIdentification.ProductIdentificationBuilder builder) {
			this.externalProductType = ofNullable(builder.getExternalProductType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.primaryAssetData = ofNullable(builder.getPrimaryAssetData()).map(f->f.build()).orElse(null);
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productQualifier = builder.getProductQualifier();
			this.secondaryAssetData = ofNullable(builder.getSecondaryAssetData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends ExternalProductType> getExternalProductType() {
			return externalProductType;
		}
		
		@Override
		public FieldWithMetaAssetClassEnum getPrimaryAssetData() {
			return primaryAssetData;
		}
		
		@Override
		public List<? extends ProductIdentifier> getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public String getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		public List<? extends FieldWithMetaAssetClassEnum> getSecondaryAssetData() {
			return secondaryAssetData;
		}
		
		@Override
		public ProductIdentification build() {
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder toBuilder() {
			ProductIdentification.ProductIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductIdentification.ProductIdentificationBuilder builder) {
			ofNullable(getExternalProductType()).ifPresent(builder::setExternalProductType);
			ofNullable(getPrimaryAssetData()).ifPresent(builder::setPrimaryAssetData);
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
			ofNullable(getProductQualifier()).ifPresent(builder::setProductQualifier);
			ofNullable(getSecondaryAssetData()).ifPresent(builder::setSecondaryAssetData);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(externalProductType, _that.getExternalProductType())) return false;
			if (!Objects.equals(primaryAssetData, _that.getPrimaryAssetData())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!Objects.equals(productQualifier, _that.getProductQualifier())) return false;
			if (!ListEquals.listEquals(secondaryAssetData, _that.getSecondaryAssetData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalProductType != null ? externalProductType.hashCode() : 0);
			_result = 31 * _result + (primaryAssetData != null ? primaryAssetData.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetData != null ? secondaryAssetData.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdentification {" +
				"externalProductType=" + this.externalProductType + ", " +
				"primaryAssetData=" + this.primaryAssetData + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"secondaryAssetData=" + this.secondaryAssetData +
			'}';
		}
	}
	
	//ProductIdentification.ProductIdentificationBuilderImpl
	class ProductIdentificationBuilderImpl implements ProductIdentification.ProductIdentificationBuilder {
	
		protected List<ExternalProductType.ExternalProductTypeBuilder> externalProductType = new ArrayList<>();
		protected FieldWithMetaAssetClassEnumBuilder primaryAssetData;
		protected List<ProductIdentifier.ProductIdentifierBuilder> productIdentifier = new ArrayList<>();
		protected String productQualifier;
		protected List<FieldWithMetaAssetClassEnumBuilder> secondaryAssetData = new ArrayList<>();
	
		public ProductIdentificationBuilderImpl() {
		}
	
		@Override
		public List<? extends ExternalProductType.ExternalProductTypeBuilder> getExternalProductType() {
			return externalProductType;
		}
		
		public ExternalProductType.ExternalProductTypeBuilder getOrCreateExternalProductType(int _index) {
		
			if (externalProductType==null) {
				this.externalProductType = new ArrayList<>();
			}
			ExternalProductType.ExternalProductTypeBuilder result;
			return getIndex(externalProductType, _index, () -> {
						ExternalProductType.ExternalProductTypeBuilder newExternalProductType = ExternalProductType.builder();
						return newExternalProductType;
					});
		}
		
		@Override
		public FieldWithMetaAssetClassEnumBuilder getPrimaryAssetData() {
			return primaryAssetData;
		}
		
		@Override
		public FieldWithMetaAssetClassEnumBuilder getOrCreatePrimaryAssetData() {
			FieldWithMetaAssetClassEnumBuilder result;
			if (primaryAssetData!=null) {
				result = primaryAssetData;
			}
			else {
				result = primaryAssetData = FieldWithMetaAssetClassEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ProductIdentifier.ProductIdentifierBuilder> getProductIdentifier() {
			return productIdentifier;
		}
		
		public ProductIdentifier.ProductIdentifierBuilder getOrCreateProductIdentifier(int _index) {
		
			if (productIdentifier==null) {
				this.productIdentifier = new ArrayList<>();
			}
			ProductIdentifier.ProductIdentifierBuilder result;
			return getIndex(productIdentifier, _index, () -> {
						ProductIdentifier.ProductIdentifierBuilder newProductIdentifier = ProductIdentifier.builder();
						return newProductIdentifier;
					});
		}
		
		@Override
		public String getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		public List<? extends FieldWithMetaAssetClassEnumBuilder> getSecondaryAssetData() {
			return secondaryAssetData;
		}
		
		public FieldWithMetaAssetClassEnumBuilder getOrCreateSecondaryAssetData(int _index) {
		
			if (secondaryAssetData==null) {
				this.secondaryAssetData = new ArrayList<>();
			}
			FieldWithMetaAssetClassEnumBuilder result;
			return getIndex(secondaryAssetData, _index, () -> {
						FieldWithMetaAssetClassEnumBuilder newSecondaryAssetData = FieldWithMetaAssetClassEnum.builder();
						return newSecondaryAssetData;
					});
		}
		
	
		@Override
		public ProductIdentification.ProductIdentificationBuilder addExternalProductType(ExternalProductType externalProductType) {
			if (externalProductType!=null) this.externalProductType.add(externalProductType.toBuilder());
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder addExternalProductType(ExternalProductType externalProductType, int _idx) {
			getIndex(this.externalProductType, _idx, () -> externalProductType.toBuilder());
			return this;
		}
		@Override 
		public ProductIdentification.ProductIdentificationBuilder addExternalProductType(List<? extends ExternalProductType> externalProductTypes) {
			if (externalProductTypes != null) {
				for (ExternalProductType toAdd : externalProductTypes) {
					this.externalProductType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProductIdentification.ProductIdentificationBuilder setExternalProductType(List<? extends ExternalProductType> externalProductTypes) {
			if (externalProductTypes == null)  {
				this.externalProductType = new ArrayList<>();
			}
			else {
				this.externalProductType = externalProductTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder setPrimaryAssetData(FieldWithMetaAssetClassEnum primaryAssetData) {
			this.primaryAssetData = primaryAssetData==null?null:primaryAssetData.toBuilder();
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder setPrimaryAssetDataValue(AssetClassEnum primaryAssetData) {
			this.getOrCreatePrimaryAssetData().setValue(primaryAssetData);
			return this;
		}
		@Override
		public ProductIdentification.ProductIdentificationBuilder addProductIdentifier(ProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder addProductIdentifier(ProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ProductIdentification.ProductIdentificationBuilder addProductIdentifier(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProductIdentification.ProductIdentificationBuilder setProductIdentifier(List<? extends ProductIdentifier> productIdentifiers) {
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
		public ProductIdentification.ProductIdentificationBuilder setProductQualifier(String productQualifier) {
			this.productQualifier = productQualifier==null?null:productQualifier;
			return this;
		}
		@Override
		public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(FieldWithMetaAssetClassEnum secondaryAssetData) {
			if (secondaryAssetData!=null) this.secondaryAssetData.add(secondaryAssetData.toBuilder());
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(FieldWithMetaAssetClassEnum secondaryAssetData, int _idx) {
			getIndex(this.secondaryAssetData, _idx, () -> secondaryAssetData.toBuilder());
			return this;
		}
		
			@Override
			public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(AssetClassEnum secondaryAssetData) {
				this.getOrCreateSecondaryAssetData(-1).setValue(secondaryAssetData);
				return this;
			}
			
			@Override
			public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(AssetClassEnum secondaryAssetData, int _idx) {
				this.getOrCreateSecondaryAssetData(_idx).setValue(secondaryAssetData);
				return this;
			}
		@Override 
		public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetData(List<? extends FieldWithMetaAssetClassEnum> secondaryAssetDatas) {
			if (secondaryAssetDatas != null) {
				for (FieldWithMetaAssetClassEnum toAdd : secondaryAssetDatas) {
					this.secondaryAssetData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ProductIdentification.ProductIdentificationBuilder setSecondaryAssetData(List<? extends FieldWithMetaAssetClassEnum> secondaryAssetDatas) {
			if (secondaryAssetDatas == null)  {
				this.secondaryAssetData = new ArrayList<>();
			}
			else {
				this.secondaryAssetData = secondaryAssetDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder addSecondaryAssetDataValue(List<? extends AssetClassEnum> secondaryAssetDatas) {
			if (secondaryAssetDatas != null) {
				for (AssetClassEnum toAdd : secondaryAssetDatas) {
					this.addSecondaryAssetDataValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder setSecondaryAssetDataValue(List<? extends AssetClassEnum> secondaryAssetDatas) {
			this.secondaryAssetData.clear();
			if (secondaryAssetDatas!=null) {
				secondaryAssetDatas.forEach(this::addSecondaryAssetDataValue);
			}
			return this;
		}
		
		
		@Override
		public ProductIdentification build() {
			return new ProductIdentification.ProductIdentificationImpl(this);
		}
		
		@Override
		public ProductIdentification.ProductIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductIdentification.ProductIdentificationBuilder prune() {
			externalProductType = externalProductType.stream().filter(b->b!=null).<ExternalProductType.ExternalProductTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (primaryAssetData!=null && !primaryAssetData.prune().hasData()) primaryAssetData = null;
			productIdentifier = productIdentifier.stream().filter(b->b!=null).<ProductIdentifier.ProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			secondaryAssetData = secondaryAssetData.stream().filter(b->b!=null).<FieldWithMetaAssetClassEnumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalProductType()!=null && getExternalProductType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrimaryAssetData()!=null) return true;
			if (getProductIdentifier()!=null && getProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductQualifier()!=null) return true;
			if (getSecondaryAssetData()!=null && !getSecondaryAssetData().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductIdentification.ProductIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductIdentification.ProductIdentificationBuilder o = (ProductIdentification.ProductIdentificationBuilder) other;
			
			merger.mergeRosetta(getExternalProductType(), o.getExternalProductType(), this::getOrCreateExternalProductType);
			merger.mergeRosetta(getPrimaryAssetData(), o.getPrimaryAssetData(), this::setPrimaryAssetData);
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::getOrCreateProductIdentifier);
			merger.mergeRosetta(getSecondaryAssetData(), o.getSecondaryAssetData(), this::getOrCreateSecondaryAssetData);
			
			merger.mergeBasic(getProductQualifier(), o.getProductQualifier(), this::setProductQualifier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductIdentification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(externalProductType, _that.getExternalProductType())) return false;
			if (!Objects.equals(primaryAssetData, _that.getPrimaryAssetData())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!Objects.equals(productQualifier, _that.getProductQualifier())) return false;
			if (!ListEquals.listEquals(secondaryAssetData, _that.getSecondaryAssetData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalProductType != null ? externalProductType.hashCode() : 0);
			_result = 31 * _result + (primaryAssetData != null ? primaryAssetData.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (secondaryAssetData != null ? secondaryAssetData.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductIdentificationBuilder {" +
				"externalProductType=" + this.externalProductType + ", " +
				"primaryAssetData=" + this.primaryAssetData + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"secondaryAssetData=" + this.secondaryAssetData +
			'}';
		}
	}
}
