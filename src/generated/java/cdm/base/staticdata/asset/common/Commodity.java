package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilder;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilderImpl;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseImpl;
import cdm.base.staticdata.asset.common.meta.CommodityMeta;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.observable.asset.QuotationSideEnum;
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
 * Identifies a specific commodity by referencing a product identifier or by a product definition.
 * @version ${project.version}
 */
@RosettaClass

public interface Commodity extends ProductBase {
	Commodity build();
	Commodity.CommodityBuilder toBuilder();
	
	/**
	 * Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
	 */
	CommodityProductDefinition getCommodityProductDefinition();
	/**
	 * Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
	 */
	DeliveryDateParameters getDeliveryDateReference();
	/**
	 * Describes the required quote type of the underlying price that will be observed. Example values include &#39;Bid, &#39;Ask&#39;, &#39;Settlement&#39; (for a futures contract) and &#39;WeightedAverage&#39; (for some published prices and indices).
	 */
	QuotationSideEnum getPriceQuoteType();
	final static CommodityMeta metaData = new CommodityMeta();
	
	@Override
	default RosettaMetaData<? extends Commodity> metaData() {
		return metaData;
	} 
			
	static Commodity.CommodityBuilder builder() {
		return new Commodity.CommodityBuilderImpl();
	}
	
	default Class<? extends Commodity> getType() {
		return Commodity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.asset.common.ProductBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("priceQuoteType"), QuotationSideEnum.class, getPriceQuoteType(), this);
		
		processRosetta(path.newSubPath("commodityProductDefinition"), processor, CommodityProductDefinition.class, getCommodityProductDefinition());
		processRosetta(path.newSubPath("deliveryDateReference"), processor, DeliveryDateParameters.class, getDeliveryDateReference());
	}
	
	
	interface CommodityBuilder extends Commodity, ProductBase.ProductBaseBuilder, RosettaModelObjectBuilder {
		CommodityProductDefinition.CommodityProductDefinitionBuilder getOrCreateCommodityProductDefinition();
		CommodityProductDefinition.CommodityProductDefinitionBuilder getCommodityProductDefinition();
		DeliveryDateParameters.DeliveryDateParametersBuilder getOrCreateDeliveryDateReference();
		DeliveryDateParameters.DeliveryDateParametersBuilder getDeliveryDateReference();
		Commodity.CommodityBuilder setCommodityProductDefinition(CommodityProductDefinition commodityProductDefinition);
		Commodity.CommodityBuilder setDeliveryDateReference(DeliveryDateParameters deliveryDateReference);
		Commodity.CommodityBuilder setPriceQuoteType(QuotationSideEnum priceQuoteType);
		Commodity.CommodityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		Commodity.CommodityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		Commodity.CommodityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		Commodity.CommodityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		Commodity.CommodityBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Commodity.CommodityBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Commodity.CommodityBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Commodity.CommodityBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ProductBase.ProductBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("priceQuoteType"), QuotationSideEnum.class, getPriceQuoteType(), this);
			
			processRosetta(path.newSubPath("commodityProductDefinition"), processor, CommodityProductDefinition.CommodityProductDefinitionBuilder.class, getCommodityProductDefinition());
			processRosetta(path.newSubPath("deliveryDateReference"), processor, DeliveryDateParameters.DeliveryDateParametersBuilder.class, getDeliveryDateReference());
		}
		
	}
	
	//Commodity.CommodityImpl
	class CommodityImpl extends ProductBase.ProductBaseImpl implements Commodity {
		private final CommodityProductDefinition commodityProductDefinition;
		private final DeliveryDateParameters deliveryDateReference;
		private final QuotationSideEnum priceQuoteType;
		
		protected CommodityImpl(Commodity.CommodityBuilder builder) {
			super(builder);
			this.commodityProductDefinition = ofNullable(builder.getCommodityProductDefinition()).map(f->f.build()).orElse(null);
			this.deliveryDateReference = ofNullable(builder.getDeliveryDateReference()).map(f->f.build()).orElse(null);
			this.priceQuoteType = builder.getPriceQuoteType();
		}
		
		@Override
		public CommodityProductDefinition getCommodityProductDefinition() {
			return commodityProductDefinition;
		}
		
		@Override
		public DeliveryDateParameters getDeliveryDateReference() {
			return deliveryDateReference;
		}
		
		@Override
		public QuotationSideEnum getPriceQuoteType() {
			return priceQuoteType;
		}
		
		@Override
		public Commodity build() {
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			Commodity.CommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Commodity.CommodityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityProductDefinition()).ifPresent(builder::setCommodityProductDefinition);
			ofNullable(getDeliveryDateReference()).ifPresent(builder::setDeliveryDateReference);
			ofNullable(getPriceQuoteType()).ifPresent(builder::setPriceQuoteType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductDefinition, _that.getCommodityProductDefinition())) return false;
			if (!Objects.equals(deliveryDateReference, _that.getDeliveryDateReference())) return false;
			if (!Objects.equals(priceQuoteType, _that.getPriceQuoteType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductDefinition != null ? commodityProductDefinition.hashCode() : 0);
			_result = 31 * _result + (deliveryDateReference != null ? deliveryDateReference.hashCode() : 0);
			_result = 31 * _result + (priceQuoteType != null ? priceQuoteType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Commodity {" +
				"commodityProductDefinition=" + this.commodityProductDefinition + ", " +
				"deliveryDateReference=" + this.deliveryDateReference + ", " +
				"priceQuoteType=" + this.priceQuoteType +
			'}' + " " + super.toString();
		}
	}
	
	//Commodity.CommodityBuilderImpl
	class CommodityBuilderImpl extends ProductBase.ProductBaseBuilderImpl  implements Commodity.CommodityBuilder {
	
		protected CommodityProductDefinition.CommodityProductDefinitionBuilder commodityProductDefinition;
		protected DeliveryDateParameters.DeliveryDateParametersBuilder deliveryDateReference;
		protected QuotationSideEnum priceQuoteType;
	
		public CommodityBuilderImpl() {
		}
	
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder getCommodityProductDefinition() {
			return commodityProductDefinition;
		}
		
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder getOrCreateCommodityProductDefinition() {
			CommodityProductDefinition.CommodityProductDefinitionBuilder result;
			if (commodityProductDefinition!=null) {
				result = commodityProductDefinition;
			}
			else {
				result = commodityProductDefinition = CommodityProductDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		public DeliveryDateParameters.DeliveryDateParametersBuilder getDeliveryDateReference() {
			return deliveryDateReference;
		}
		
		@Override
		public DeliveryDateParameters.DeliveryDateParametersBuilder getOrCreateDeliveryDateReference() {
			DeliveryDateParameters.DeliveryDateParametersBuilder result;
			if (deliveryDateReference!=null) {
				result = deliveryDateReference;
			}
			else {
				result = deliveryDateReference = DeliveryDateParameters.builder();
			}
			
			return result;
		}
		
		@Override
		public QuotationSideEnum getPriceQuoteType() {
			return priceQuoteType;
		}
		
	
		@Override
		public Commodity.CommodityBuilder setCommodityProductDefinition(CommodityProductDefinition commodityProductDefinition) {
			this.commodityProductDefinition = commodityProductDefinition==null?null:commodityProductDefinition.toBuilder();
			return this;
		}
		@Override
		public Commodity.CommodityBuilder setDeliveryDateReference(DeliveryDateParameters deliveryDateReference) {
			this.deliveryDateReference = deliveryDateReference==null?null:deliveryDateReference.toBuilder();
			return this;
		}
		@Override
		public Commodity.CommodityBuilder setPriceQuoteType(QuotationSideEnum priceQuoteType) {
			this.priceQuoteType = priceQuoteType==null?null:priceQuoteType;
			return this;
		}
		@Override
		public Commodity.CommodityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public Commodity.CommodityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public Commodity.CommodityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public Commodity.CommodityBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Commodity.CommodityBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
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
		public Commodity.CommodityBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Commodity.CommodityBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		
		@Override
		public Commodity build() {
			return new Commodity.CommodityImpl(this);
		}
		
		@Override
		public Commodity.CommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder prune() {
			super.prune();
			if (commodityProductDefinition!=null && !commodityProductDefinition.prune().hasData()) commodityProductDefinition = null;
			if (deliveryDateReference!=null && !deliveryDateReference.prune().hasData()) deliveryDateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityProductDefinition()!=null && getCommodityProductDefinition().hasData()) return true;
			if (getDeliveryDateReference()!=null && getDeliveryDateReference().hasData()) return true;
			if (getPriceQuoteType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Commodity.CommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Commodity.CommodityBuilder o = (Commodity.CommodityBuilder) other;
			
			merger.mergeRosetta(getCommodityProductDefinition(), o.getCommodityProductDefinition(), this::setCommodityProductDefinition);
			merger.mergeRosetta(getDeliveryDateReference(), o.getDeliveryDateReference(), this::setDeliveryDateReference);
			
			merger.mergeBasic(getPriceQuoteType(), o.getPriceQuoteType(), this::setPriceQuoteType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Commodity _that = getType().cast(o);
		
			if (!Objects.equals(commodityProductDefinition, _that.getCommodityProductDefinition())) return false;
			if (!Objects.equals(deliveryDateReference, _that.getDeliveryDateReference())) return false;
			if (!Objects.equals(priceQuoteType, _that.getPriceQuoteType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityProductDefinition != null ? commodityProductDefinition.hashCode() : 0);
			_result = 31 * _result + (deliveryDateReference != null ? deliveryDateReference.hashCode() : 0);
			_result = 31 * _result + (priceQuoteType != null ? priceQuoteType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBuilder {" +
				"commodityProductDefinition=" + this.commodityProductDefinition + ", " +
				"deliveryDateReference=" + this.deliveryDateReference + ", " +
				"priceQuoteType=" + this.priceQuoteType +
			'}' + " " + super.toString();
		}
	}
}
