package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilder;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilderImpl;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseImpl;
import cdm.base.staticdata.asset.common.meta.IndexMeta;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies an index by referencing a product identifier.
 * @version ${project.version}
 */
@RosettaClass

public interface Index extends ProductBase {
	Index build();
	Index.IndexBuilder toBuilder();
	
	/**
	 */
	IndexTypeEnum getIndexType();
	final static IndexMeta metaData = new IndexMeta();
	
	@Override
	default RosettaMetaData<? extends Index> metaData() {
		return metaData;
	} 
			
	static Index.IndexBuilder builder() {
		return new Index.IndexBuilderImpl();
	}
	
	default Class<? extends Index> getType() {
		return Index.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.asset.common.ProductBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("indexType"), IndexTypeEnum.class, getIndexType(), this);
		
	}
	
	
	interface IndexBuilder extends Index, ProductBase.ProductBaseBuilder, RosettaModelObjectBuilder {
		Index.IndexBuilder setIndexType(IndexTypeEnum indexType);
		Index.IndexBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		Index.IndexBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		Index.IndexBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		Index.IndexBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		Index.IndexBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Index.IndexBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Index.IndexBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Index.IndexBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ProductBase.ProductBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("indexType"), IndexTypeEnum.class, getIndexType(), this);
			
		}
		
	}
	
	//Index.IndexImpl
	class IndexImpl extends ProductBase.ProductBaseImpl implements Index {
		private final IndexTypeEnum indexType;
		
		protected IndexImpl(Index.IndexBuilder builder) {
			super(builder);
			this.indexType = builder.getIndexType();
		}
		
		@Override
		public IndexTypeEnum getIndexType() {
			return indexType;
		}
		
		@Override
		public Index build() {
			return this;
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			Index.IndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Index.IndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIndexType()).ifPresent(builder::setIndexType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(indexType, _that.getIndexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexType != null ? indexType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Index {" +
				"indexType=" + this.indexType +
			'}' + " " + super.toString();
		}
	}
	
	//Index.IndexBuilderImpl
	class IndexBuilderImpl extends ProductBase.ProductBaseBuilderImpl  implements Index.IndexBuilder {
	
		protected IndexTypeEnum indexType;
	
		public IndexBuilderImpl() {
		}
	
		@Override
		public IndexTypeEnum getIndexType() {
			return indexType;
		}
		
	
		@Override
		public Index.IndexBuilder setIndexType(IndexTypeEnum indexType) {
			this.indexType = indexType==null?null:indexType;
			return this;
		}
		@Override
		public Index.IndexBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public Index.IndexBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public Index.IndexBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public Index.IndexBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Index.IndexBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
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
		public Index.IndexBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Index.IndexBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		
		@Override
		public Index build() {
			return new Index.IndexImpl(this);
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIndexType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Index.IndexBuilder o = (Index.IndexBuilder) other;
			
			
			merger.mergeBasic(getIndexType(), o.getIndexType(), this::setIndexType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(indexType, _that.getIndexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexType != null ? indexType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBuilder {" +
				"indexType=" + this.indexType +
			'}' + " " + super.toString();
		}
	}
}
