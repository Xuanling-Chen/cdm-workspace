package cdm.observable.asset;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.math.Quantity;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.base.math.metafields.FieldWithMetaQuantity.FieldWithMetaQuantityBuilder;
import cdm.observable.asset.meta.PriceQuantityMeta;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.observable.asset.metafields.FieldWithMetaPrice.FieldWithMetaPriceBuilder;
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
 * Specifies the price, quantity, and optionally the observable and effective date for use in a trade or other purposes.
 * @version ${project.version}
 */
@RosettaClass

public interface PriceQuantity extends RosettaModelObject, GlobalKey {
	PriceQuantity build();
	PriceQuantity.PriceQuantityBuilder toBuilder();
	
	/**
	 * Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Specifies the object to be observed for a price, it could be an asset or a reference. The cardinality is optional as some quantity / price cases have no observable (e.g. a notional and a fixed rate in a given currency).
	 */
	Observable getObservable();
	/**
	 * Specifies a price to be used for trade amounts and other purposes.
	 */
	List<? extends FieldWithMetaPrice> getPrice();
	/**
	 * Specifies a quantity to be associated with an event, for example a trade amount.
	 */
	List<? extends FieldWithMetaQuantity> getQuantity();
	final static PriceQuantityMeta metaData = new PriceQuantityMeta();
	
	@Override
	default RosettaMetaData<? extends PriceQuantity> metaData() {
		return metaData;
	} 
			
	static PriceQuantity.PriceQuantityBuilder builder() {
		return new PriceQuantity.PriceQuantityBuilderImpl();
	}
	
	default Class<? extends PriceQuantity> getType() {
		return PriceQuantity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("observable"), processor, Observable.class, getObservable());
		processRosetta(path.newSubPath("price"), processor, FieldWithMetaPrice.class, getPrice());
		processRosetta(path.newSubPath("quantity"), processor, FieldWithMetaQuantity.class, getQuantity());
	}
	
	
	interface PriceQuantityBuilder extends PriceQuantity, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Observable.ObservableBuilder getOrCreateObservable();
		Observable.ObservableBuilder getObservable();
		FieldWithMetaPriceBuilder getOrCreatePrice(int _index);
		List<? extends FieldWithMetaPriceBuilder> getPrice();
		FieldWithMetaQuantityBuilder getOrCreateQuantity(int _index);
		List<? extends FieldWithMetaQuantityBuilder> getQuantity();
		PriceQuantity.PriceQuantityBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		PriceQuantity.PriceQuantityBuilder setMeta(MetaFields meta);
		PriceQuantity.PriceQuantityBuilder setObservable(Observable observable);
		PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPrice price);
		PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPrice price, int _idx);
		PriceQuantity.PriceQuantityBuilder addPriceValue(Price price);
		PriceQuantity.PriceQuantityBuilder addPriceValue(Price price, int _idx);
		PriceQuantity.PriceQuantityBuilder addPrice(List<? extends FieldWithMetaPrice> price);
		PriceQuantity.PriceQuantityBuilder setPrice(List<? extends FieldWithMetaPrice> price);
		PriceQuantity.PriceQuantityBuilder addPriceValue(List<? extends Price> price);
		PriceQuantity.PriceQuantityBuilder setPriceValue(List<? extends Price> price);
		PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaQuantity quantity);
		PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaQuantity quantity, int _idx);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(Quantity quantity);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(Quantity quantity, int _idx);
		PriceQuantity.PriceQuantityBuilder addQuantity(List<? extends FieldWithMetaQuantity> quantity);
		PriceQuantity.PriceQuantityBuilder setQuantity(List<? extends FieldWithMetaQuantity> quantity);
		PriceQuantity.PriceQuantityBuilder addQuantityValue(List<? extends Quantity> quantity);
		PriceQuantity.PriceQuantityBuilder setQuantityValue(List<? extends Quantity> quantity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("observable"), processor, Observable.ObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("price"), processor, FieldWithMetaPriceBuilder.class, getPrice());
			processRosetta(path.newSubPath("quantity"), processor, FieldWithMetaQuantityBuilder.class, getQuantity());
		}
		
	}
	
	//PriceQuantity.PriceQuantityImpl
	class PriceQuantityImpl implements PriceQuantity {
		private final AdjustableOrRelativeDate effectiveDate;
		private final MetaFields meta;
		private final Observable observable;
		private final List<? extends FieldWithMetaPrice> price;
		private final List<? extends FieldWithMetaQuantity> quantity;
		
		protected PriceQuantityImpl(PriceQuantity.PriceQuantityBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.observable = ofNullable(builder.getObservable()).map(f->f.build()).orElse(null);
			this.price = ofNullable(builder.getPrice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Observable getObservable() {
			return observable;
		}
		
		@Override
		public List<? extends FieldWithMetaPrice> getPrice() {
			return price;
		}
		
		@Override
		public List<? extends FieldWithMetaQuantity> getQuantity() {
			return quantity;
		}
		
		@Override
		public PriceQuantity build() {
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder toBuilder() {
			PriceQuantity.PriceQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceQuantity.PriceQuantityBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuantity _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(price, _that.getPrice())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuantity {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"meta=" + this.meta + ", " +
				"observable=" + this.observable + ", " +
				"price=" + this.price + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
	
	//PriceQuantity.PriceQuantityBuilderImpl
	class PriceQuantityBuilderImpl implements PriceQuantity.PriceQuantityBuilder, GlobalKeyBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Observable.ObservableBuilder observable;
		protected List<FieldWithMetaPriceBuilder> price = new ArrayList<>();
		protected List<FieldWithMetaQuantityBuilder> quantity = new ArrayList<>();
	
		public PriceQuantityBuilderImpl() {
		}
	
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
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
		public Observable.ObservableBuilder getObservable() {
			return observable;
		}
		
		@Override
		public Observable.ObservableBuilder getOrCreateObservable() {
			Observable.ObservableBuilder result;
			if (observable!=null) {
				result = observable;
			}
			else {
				result = observable = Observable.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaPriceBuilder> getPrice() {
			return price;
		}
		
		public FieldWithMetaPriceBuilder getOrCreatePrice(int _index) {
		
			if (price==null) {
				this.price = new ArrayList<>();
			}
			FieldWithMetaPriceBuilder result;
			return getIndex(price, _index, () -> {
						FieldWithMetaPriceBuilder newPrice = FieldWithMetaPrice.builder();
						newPrice.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newPrice;
					});
		}
		
		@Override
		public List<? extends FieldWithMetaQuantityBuilder> getQuantity() {
			return quantity;
		}
		
		public FieldWithMetaQuantityBuilder getOrCreateQuantity(int _index) {
		
			if (quantity==null) {
				this.quantity = new ArrayList<>();
			}
			FieldWithMetaQuantityBuilder result;
			return getIndex(quantity, _index, () -> {
						FieldWithMetaQuantityBuilder newQuantity = FieldWithMetaQuantity.builder();
						newQuantity.getOrCreateMeta().addKey(Key.builder().setScope("DOCUMENT"));
						return newQuantity;
					});
		}
		
	
		@Override
		public PriceQuantity.PriceQuantityBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		public PriceQuantity.PriceQuantityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PriceQuantity.PriceQuantityBuilder setObservable(Observable observable) {
			this.observable = observable==null?null:observable.toBuilder();
			return this;
		}
		@Override
		public PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPrice price) {
			if (price!=null) this.price.add(price.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPrice(FieldWithMetaPrice price, int _idx) {
			getIndex(this.price, _idx, () -> price.toBuilder());
			return this;
		}
		
			@Override
			public PriceQuantity.PriceQuantityBuilder addPriceValue(Price price) {
				this.getOrCreatePrice(-1).setValue(price.toBuilder());
				return this;
			}
			
			@Override
			public PriceQuantity.PriceQuantityBuilder addPriceValue(Price price, int _idx) {
				this.getOrCreatePrice(_idx).setValue(price.toBuilder());
				return this;
			}
		@Override 
		public PriceQuantity.PriceQuantityBuilder addPrice(List<? extends FieldWithMetaPrice> prices) {
			if (prices != null) {
				for (FieldWithMetaPrice toAdd : prices) {
					this.price.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PriceQuantity.PriceQuantityBuilder setPrice(List<? extends FieldWithMetaPrice> prices) {
			if (prices == null)  {
				this.price = new ArrayList<>();
			}
			else {
				this.price = prices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addPriceValue(List<? extends Price> prices) {
			if (prices != null) {
				for (Price toAdd : prices) {
					this.addPriceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder setPriceValue(List<? extends Price> prices) {
			this.price.clear();
			if (prices!=null) {
				prices.forEach(this::addPriceValue);
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaQuantity quantity) {
			if (quantity!=null) this.quantity.add(quantity.toBuilder());
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantity(FieldWithMetaQuantity quantity, int _idx) {
			getIndex(this.quantity, _idx, () -> quantity.toBuilder());
			return this;
		}
		
			@Override
			public PriceQuantity.PriceQuantityBuilder addQuantityValue(Quantity quantity) {
				this.getOrCreateQuantity(-1).setValue(quantity.toBuilder());
				return this;
			}
			
			@Override
			public PriceQuantity.PriceQuantityBuilder addQuantityValue(Quantity quantity, int _idx) {
				this.getOrCreateQuantity(_idx).setValue(quantity.toBuilder());
				return this;
			}
		@Override 
		public PriceQuantity.PriceQuantityBuilder addQuantity(List<? extends FieldWithMetaQuantity> quantitys) {
			if (quantitys != null) {
				for (FieldWithMetaQuantity toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PriceQuantity.PriceQuantityBuilder setQuantity(List<? extends FieldWithMetaQuantity> quantitys) {
			if (quantitys == null)  {
				this.quantity = new ArrayList<>();
			}
			else {
				this.quantity = quantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder addQuantityValue(List<? extends Quantity> quantitys) {
			if (quantitys != null) {
				for (Quantity toAdd : quantitys) {
					this.addQuantityValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder setQuantityValue(List<? extends Quantity> quantitys) {
			this.quantity.clear();
			if (quantitys!=null) {
				quantitys.forEach(this::addQuantityValue);
			}
			return this;
		}
		
		
		@Override
		public PriceQuantity build() {
			return new PriceQuantity.PriceQuantityImpl(this);
		}
		
		@Override
		public PriceQuantity.PriceQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuantity.PriceQuantityBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (observable!=null && !observable.prune().hasData()) observable = null;
			price = price.stream().filter(b->b!=null).<FieldWithMetaPriceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			quantity = quantity.stream().filter(b->b!=null).<FieldWithMetaQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getObservable()!=null && getObservable().hasData()) return true;
			if (getPrice()!=null && getPrice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceQuantity.PriceQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceQuantity.PriceQuantityBuilder o = (PriceQuantity.PriceQuantityBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getObservable(), o.getObservable(), this::setObservable);
			merger.mergeRosetta(getPrice(), o.getPrice(), this::getOrCreatePrice);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceQuantity _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!ListEquals.listEquals(price, _that.getPrice())) return false;
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceQuantityBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"meta=" + this.meta + ", " +
				"observable=" + this.observable + ", " +
				"price=" + this.price + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
