package cdm.observable.asset;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityBuilder;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier.FieldWithMetaProductIdentifierBuilder;
import cdm.observable.asset.meta.ObservableMeta;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption.FieldWithMetaFloatingRateOptionBuilder;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the object to be observed for a price, it could be an asset or a reference.
 * @version ${project.version}
 */
@RosettaClass

public interface Observable extends RosettaModelObject, GlobalKey {
	Observable build();
	Observable.ObservableBuilder toBuilder();
	
	/**
	 * Identifies a commodity by referencing a product identifier.
	 */
	FieldWithMetaCommodity getCommodity();
	/**
	 * Describes the composition of a rate that has been quoted or is to be quoted, including the two currencies and the quotation relationship between the two currencies.
	 */
	FieldWithMetaQuotedCurrencyPair getCurrencyPair();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Comprises of an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
	 */
	List<? extends FieldWithMetaProductIdentifier> getProductIdentifier();
	/**
	 * Specifies a floating rate index and tenor.
	 */
	FieldWithMetaFloatingRateOption getRateOption();
	final static ObservableMeta metaData = new ObservableMeta();
	
	@Override
	default RosettaMetaData<? extends Observable> metaData() {
		return metaData;
	} 
			
	static Observable.ObservableBuilder builder() {
		return new Observable.ObservableBuilderImpl();
	}
	
	default Class<? extends Observable> getType() {
		return Observable.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("commodity"), processor, FieldWithMetaCommodity.class, getCommodity());
		processRosetta(path.newSubPath("currencyPair"), processor, FieldWithMetaQuotedCurrencyPair.class, getCurrencyPair());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("productIdentifier"), processor, FieldWithMetaProductIdentifier.class, getProductIdentifier());
		processRosetta(path.newSubPath("rateOption"), processor, FieldWithMetaFloatingRateOption.class, getRateOption());
	}
	
	
	interface ObservableBuilder extends Observable, RosettaModelObjectBuilder {
		FieldWithMetaCommodityBuilder getOrCreateCommodity();
		FieldWithMetaCommodityBuilder getCommodity();
		FieldWithMetaQuotedCurrencyPairBuilder getOrCreateCurrencyPair();
		FieldWithMetaQuotedCurrencyPairBuilder getCurrencyPair();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index);
		List<? extends FieldWithMetaProductIdentifierBuilder> getProductIdentifier();
		FieldWithMetaFloatingRateOptionBuilder getOrCreateRateOption();
		FieldWithMetaFloatingRateOptionBuilder getRateOption();
		Observable.ObservableBuilder setCommodity(FieldWithMetaCommodity commodity);
		Observable.ObservableBuilder setCommodityValue(Commodity commodity);
		Observable.ObservableBuilder setCurrencyPair(FieldWithMetaQuotedCurrencyPair currencyPair);
		Observable.ObservableBuilder setCurrencyPairValue(QuotedCurrencyPair currencyPair);
		Observable.ObservableBuilder setMeta(MetaFields meta);
		Observable.ObservableBuilder addProductIdentifier(FieldWithMetaProductIdentifier productIdentifier);
		Observable.ObservableBuilder addProductIdentifier(FieldWithMetaProductIdentifier productIdentifier, int _idx);
		Observable.ObservableBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		Observable.ObservableBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		Observable.ObservableBuilder addProductIdentifier(List<? extends FieldWithMetaProductIdentifier> productIdentifier);
		Observable.ObservableBuilder setProductIdentifier(List<? extends FieldWithMetaProductIdentifier> productIdentifier);
		Observable.ObservableBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Observable.ObservableBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Observable.ObservableBuilder setRateOption(FieldWithMetaFloatingRateOption rateOption);
		Observable.ObservableBuilder setRateOptionValue(FloatingRateOption rateOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("commodity"), processor, FieldWithMetaCommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("currencyPair"), processor, FieldWithMetaQuotedCurrencyPairBuilder.class, getCurrencyPair());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("productIdentifier"), processor, FieldWithMetaProductIdentifierBuilder.class, getProductIdentifier());
			processRosetta(path.newSubPath("rateOption"), processor, FieldWithMetaFloatingRateOptionBuilder.class, getRateOption());
		}
		
	}
	
	//Observable.ObservableImpl
	class ObservableImpl implements Observable {
		private final FieldWithMetaCommodity commodity;
		private final FieldWithMetaQuotedCurrencyPair currencyPair;
		private final MetaFields meta;
		private final List<? extends FieldWithMetaProductIdentifier> productIdentifier;
		private final FieldWithMetaFloatingRateOption rateOption;
		
		protected ObservableImpl(Observable.ObservableBuilder builder) {
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.currencyPair = ofNullable(builder.getCurrencyPair()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.productIdentifier = ofNullable(builder.getProductIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateOption = ofNullable(builder.getRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaCommodity getCommodity() {
			return commodity;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair getCurrencyPair() {
			return currencyPair;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends FieldWithMetaProductIdentifier> getProductIdentifier() {
			return productIdentifier;
		}
		
		@Override
		public FieldWithMetaFloatingRateOption getRateOption() {
			return rateOption;
		}
		
		@Override
		public Observable build() {
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder toBuilder() {
			Observable.ObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Observable.ObservableBuilder builder) {
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCurrencyPair()).ifPresent(builder::setCurrencyPair);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getProductIdentifier()).ifPresent(builder::setProductIdentifier);
			ofNullable(getRateOption()).ifPresent(builder::setRateOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observable _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(currencyPair, _that.getCurrencyPair())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (currencyPair != null ? currencyPair.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Observable {" +
				"commodity=" + this.commodity + ", " +
				"currencyPair=" + this.currencyPair + ", " +
				"meta=" + this.meta + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"rateOption=" + this.rateOption +
			'}';
		}
	}
	
	//Observable.ObservableBuilderImpl
	class ObservableBuilderImpl implements Observable.ObservableBuilder, GlobalKeyBuilder {
	
		protected FieldWithMetaCommodityBuilder commodity;
		protected FieldWithMetaQuotedCurrencyPairBuilder currencyPair;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<FieldWithMetaProductIdentifierBuilder> productIdentifier = new ArrayList<>();
		protected FieldWithMetaFloatingRateOptionBuilder rateOption;
	
		public ObservableBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaCommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public FieldWithMetaCommodityBuilder getOrCreateCommodity() {
			FieldWithMetaCommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = FieldWithMetaCommodity.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPairBuilder getCurrencyPair() {
			return currencyPair;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPairBuilder getOrCreateCurrencyPair() {
			FieldWithMetaQuotedCurrencyPairBuilder result;
			if (currencyPair!=null) {
				result = currencyPair;
			}
			else {
				result = currencyPair = FieldWithMetaQuotedCurrencyPair.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
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
		public List<? extends FieldWithMetaProductIdentifierBuilder> getProductIdentifier() {
			return productIdentifier;
		}
		
		public FieldWithMetaProductIdentifierBuilder getOrCreateProductIdentifier(int _index) {
		
			if (productIdentifier==null) {
				this.productIdentifier = new ArrayList<>();
			}
			FieldWithMetaProductIdentifierBuilder result;
			return getIndex(productIdentifier, _index, () -> {
						FieldWithMetaProductIdentifierBuilder newProductIdentifier = FieldWithMetaProductIdentifier.builder();
						newProductIdentifier.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newProductIdentifier;
					});
		}
		
		@Override
		public FieldWithMetaFloatingRateOptionBuilder getRateOption() {
			return rateOption;
		}
		
		@Override
		public FieldWithMetaFloatingRateOptionBuilder getOrCreateRateOption() {
			FieldWithMetaFloatingRateOptionBuilder result;
			if (rateOption!=null) {
				result = rateOption;
			}
			else {
				result = rateOption = FieldWithMetaFloatingRateOption.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
	
		@Override
		public Observable.ObservableBuilder setCommodity(FieldWithMetaCommodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder setCommodityValue(Commodity commodity) {
			this.getOrCreateCommodity().setValue(commodity);
			return this;
		}
		@Override
		public Observable.ObservableBuilder setCurrencyPair(FieldWithMetaQuotedCurrencyPair currencyPair) {
			this.currencyPair = currencyPair==null?null:currencyPair.toBuilder();
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder setCurrencyPairValue(QuotedCurrencyPair currencyPair) {
			this.getOrCreateCurrencyPair().setValue(currencyPair);
			return this;
		}
		@Override
		public Observable.ObservableBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Observable.ObservableBuilder addProductIdentifier(FieldWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder addProductIdentifier(FieldWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public Observable.ObservableBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public Observable.ObservableBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public Observable.ObservableBuilder addProductIdentifier(List<? extends FieldWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (FieldWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Observable.ObservableBuilder setProductIdentifier(List<? extends FieldWithMetaProductIdentifier> productIdentifiers) {
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
		public Observable.ObservableBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder setRateOption(FieldWithMetaFloatingRateOption rateOption) {
			this.rateOption = rateOption==null?null:rateOption.toBuilder();
			return this;
		}
		
		@Override
		public Observable.ObservableBuilder setRateOptionValue(FloatingRateOption rateOption) {
			this.getOrCreateRateOption().setValue(rateOption);
			return this;
		}
		
		@Override
		public Observable build() {
			return new Observable.ObservableImpl(this);
		}
		
		@Override
		public Observable.ObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observable.ObservableBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (currencyPair!=null && !currencyPair.prune().hasData()) currencyPair = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			productIdentifier = productIdentifier.stream().filter(b->b!=null).<FieldWithMetaProductIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (rateOption!=null && !rateOption.prune().hasData()) rateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCurrencyPair()!=null && getCurrencyPair().hasData()) return true;
			if (getProductIdentifier()!=null && getProductIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateOption()!=null && getRateOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observable.ObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Observable.ObservableBuilder o = (Observable.ObservableBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCurrencyPair(), o.getCurrencyPair(), this::setCurrencyPair);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getProductIdentifier(), o.getProductIdentifier(), this::getOrCreateProductIdentifier);
			merger.mergeRosetta(getRateOption(), o.getRateOption(), this::setRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observable _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(currencyPair, _that.getCurrencyPair())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(productIdentifier, _that.getProductIdentifier())) return false;
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (currencyPair != null ? currencyPair.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (productIdentifier != null ? productIdentifier.hashCode() : 0);
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservableBuilder {" +
				"commodity=" + this.commodity + ", " +
				"currencyPair=" + this.currencyPair + ", " +
				"meta=" + this.meta + ", " +
				"productIdentifier=" + this.productIdentifier + ", " +
				"rateOption=" + this.rateOption +
			'}';
		}
	}
}
