package cdm.event.position;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder;
import cdm.event.common.Trade;
import cdm.event.common.Trade;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder;
import cdm.event.position.meta.AggregationParametersMeta;
import cdm.product.template.Product;
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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  Parameters to be used to filter events that are relevant to a given portfolio in order to calculate the state of this portfolio. The attributes correspond to all the possible aggregation criteria that can be used and these criteria can be combined. All the attributes are optional.
 * @version ${project.version}
 */
@RosettaClass
@RosettaQualified(attribute="productQualifier",qualifiedClass=cdm.product.template.EconomicTerms.class)

public interface AggregationParameters extends RosettaModelObject {
	AggregationParameters build();
	AggregationParameters.AggregationParametersBuilder toBuilder();
	
	/**
	 * To aggregate as of a particular date
	 */
	ZonedDateTime getDateTime();
	/**
	 * To aggregate based on a selection of party(ies) / legal entity(ies).
	 */
	List<? extends ReferenceWithMetaParty> getParty();
	/**
	 * To aggregate based on position status (EXECUTED, SETTLED etc)
	 */
	PositionStatusEnum getPositionStatus();
	/**
	 * To aggregate based on a selection of products.
	 */
	List<? extends Product> getProduct();
	/**
	 * To aggregate based on a selection of product type(s).
	 */
	List<? extends String> getProductQualifier();
	/**
	 * Specifies whether to calculate total position to given date, or only daily position for the given date.
	 */
	Boolean getTotalPosition();
	/**
	 */
	List<? extends ReferenceWithMetaTrade> getTradeReference();
	final static AggregationParametersMeta metaData = new AggregationParametersMeta();
	
	@Override
	default RosettaMetaData<? extends AggregationParameters> metaData() {
		return metaData;
	} 
			
	static AggregationParameters.AggregationParametersBuilder builder() {
		return new AggregationParameters.AggregationParametersBuilderImpl();
	}
	
	default Class<? extends AggregationParameters> getType() {
		return AggregationParameters.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
		processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
		processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
		processor.processBasic(path.newSubPath("totalPosition"), Boolean.class, getTotalPosition(), this);
		
		processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaParty.class, getParty());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTrade.class, getTradeReference());
	}
	
	
	interface AggregationParametersBuilder extends AggregationParameters, RosettaModelObjectBuilder {
		ReferenceWithMetaPartyBuilder getOrCreateParty(int _index);
		List<? extends ReferenceWithMetaPartyBuilder> getParty();
		Product.ProductBuilder getOrCreateProduct(int _index);
		List<? extends Product.ProductBuilder> getProduct();
		ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index);
		List<? extends ReferenceWithMetaTradeBuilder> getTradeReference();
		AggregationParameters.AggregationParametersBuilder setDateTime(ZonedDateTime dateTime);
		AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party);
		AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party, int _idx);
		AggregationParameters.AggregationParametersBuilder addPartyValue(Party party);
		AggregationParameters.AggregationParametersBuilder addPartyValue(Party party, int _idx);
		AggregationParameters.AggregationParametersBuilder addParty(List<? extends ReferenceWithMetaParty> party);
		AggregationParameters.AggregationParametersBuilder setParty(List<? extends ReferenceWithMetaParty> party);
		AggregationParameters.AggregationParametersBuilder addPartyValue(List<? extends Party> party);
		AggregationParameters.AggregationParametersBuilder setPartyValue(List<? extends Party> party);
		AggregationParameters.AggregationParametersBuilder setPositionStatus(PositionStatusEnum positionStatus);
		AggregationParameters.AggregationParametersBuilder addProduct(Product product);
		AggregationParameters.AggregationParametersBuilder addProduct(Product product, int _idx);
		AggregationParameters.AggregationParametersBuilder addProduct(List<? extends Product> product);
		AggregationParameters.AggregationParametersBuilder setProduct(List<? extends Product> product);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier, int _idx);
		AggregationParameters.AggregationParametersBuilder addProductQualifier(List<? extends String> productQualifier);
		AggregationParameters.AggregationParametersBuilder setProductQualifier(List<? extends String> productQualifier);
		AggregationParameters.AggregationParametersBuilder setTotalPosition(Boolean totalPosition);
		AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference, int _idx);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference, int _idx);
		AggregationParameters.AggregationParametersBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		AggregationParameters.AggregationParametersBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReference);
		AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(List<? extends Trade> tradeReference);
		AggregationParameters.AggregationParametersBuilder setTradeReferenceValue(List<? extends Trade> tradeReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dateTime"), ZonedDateTime.class, getDateTime(), this);
			processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
			processor.processBasic(path.newSubPath("productQualifier"), String.class, getProductQualifier(), this);
			processor.processBasic(path.newSubPath("totalPosition"), Boolean.class, getTotalPosition(), this);
			
			processRosetta(path.newSubPath("party"), processor, ReferenceWithMetaPartyBuilder.class, getParty());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTradeBuilder.class, getTradeReference());
		}
		
	}
	
	//AggregationParameters.AggregationParametersImpl
	class AggregationParametersImpl implements AggregationParameters {
		private final ZonedDateTime dateTime;
		private final List<? extends ReferenceWithMetaParty> party;
		private final PositionStatusEnum positionStatus;
		private final List<? extends Product> product;
		private final List<? extends String> productQualifier;
		private final Boolean totalPosition;
		private final List<? extends ReferenceWithMetaTrade> tradeReference;
		
		protected AggregationParametersImpl(AggregationParameters.AggregationParametersBuilder builder) {
			this.dateTime = builder.getDateTime();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.positionStatus = builder.getPositionStatus();
			this.product = ofNullable(builder.getProduct()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productQualifier = ofNullable(builder.getProductQualifier()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.totalPosition = builder.getTotalPosition();
			this.tradeReference = ofNullable(builder.getTradeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public ZonedDateTime getDateTime() {
			return dateTime;
		}
		
		@Override
		public List<? extends ReferenceWithMetaParty> getParty() {
			return party;
		}
		
		@Override
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		public List<? extends Product> getProduct() {
			return product;
		}
		
		@Override
		public List<? extends String> getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		public Boolean getTotalPosition() {
			return totalPosition;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTrade> getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public AggregationParameters build() {
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder toBuilder() {
			AggregationParameters.AggregationParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AggregationParameters.AggregationParametersBuilder builder) {
			ofNullable(getDateTime()).ifPresent(builder::setDateTime);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getPositionStatus()).ifPresent(builder::setPositionStatus);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getProductQualifier()).ifPresent(builder::setProductQualifier);
			ofNullable(getTotalPosition()).ifPresent(builder::setTotalPosition);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationParameters _that = getType().cast(o);
		
			if (!Objects.equals(dateTime, _that.getDateTime())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(productQualifier, _that.getProductQualifier())) return false;
			if (!Objects.equals(totalPosition, _that.getTotalPosition())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (totalPosition != null ? totalPosition.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationParameters {" +
				"dateTime=" + this.dateTime + ", " +
				"party=" + this.party + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"product=" + this.product + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"totalPosition=" + this.totalPosition + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
	
	//AggregationParameters.AggregationParametersBuilderImpl
	class AggregationParametersBuilderImpl implements AggregationParameters.AggregationParametersBuilder {
	
		protected ZonedDateTime dateTime;
		protected List<ReferenceWithMetaPartyBuilder> party = new ArrayList<>();
		protected PositionStatusEnum positionStatus;
		protected List<Product.ProductBuilder> product = new ArrayList<>();
		protected List<String> productQualifier = new ArrayList<>();
		protected Boolean totalPosition;
		protected List<ReferenceWithMetaTradeBuilder> tradeReference = new ArrayList<>();
	
		public AggregationParametersBuilderImpl() {
		}
	
		@Override
		public ZonedDateTime getDateTime() {
			return dateTime;
		}
		
		@Override
		public List<? extends ReferenceWithMetaPartyBuilder> getParty() {
			return party;
		}
		
		public ReferenceWithMetaPartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			ReferenceWithMetaPartyBuilder result;
			return getIndex(party, _index, () -> {
						ReferenceWithMetaPartyBuilder newParty = ReferenceWithMetaParty.builder();
						return newParty;
					});
		}
		
		@Override
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		public List<? extends Product.ProductBuilder> getProduct() {
			return product;
		}
		
		public Product.ProductBuilder getOrCreateProduct(int _index) {
		
			if (product==null) {
				this.product = new ArrayList<>();
			}
			Product.ProductBuilder result;
			return getIndex(product, _index, () -> {
						Product.ProductBuilder newProduct = Product.builder();
						return newProduct;
					});
		}
		
		@Override
		public List<? extends String> getProductQualifier() {
			return productQualifier;
		}
		
		@Override
		public Boolean getTotalPosition() {
			return totalPosition;
		}
		
		@Override
		public List<? extends ReferenceWithMetaTradeBuilder> getTradeReference() {
			return tradeReference;
		}
		
		public ReferenceWithMetaTradeBuilder getOrCreateTradeReference(int _index) {
		
			if (tradeReference==null) {
				this.tradeReference = new ArrayList<>();
			}
			ReferenceWithMetaTradeBuilder result;
			return getIndex(tradeReference, _index, () -> {
						ReferenceWithMetaTradeBuilder newTradeReference = ReferenceWithMetaTrade.builder();
						return newTradeReference;
					});
		}
		
	
		@Override
		public AggregationParameters.AggregationParametersBuilder setDateTime(ZonedDateTime dateTime) {
			this.dateTime = dateTime==null?null:dateTime;
			return this;
		}
		@Override
		public AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addParty(ReferenceWithMetaParty party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		
			@Override
			public AggregationParameters.AggregationParametersBuilder addPartyValue(Party party) {
				this.getOrCreateParty(-1).setValue(party.toBuilder());
				return this;
			}
			
			@Override
			public AggregationParameters.AggregationParametersBuilder addPartyValue(Party party, int _idx) {
				this.getOrCreateParty(_idx).setValue(party.toBuilder());
				return this;
			}
		@Override 
		public AggregationParameters.AggregationParametersBuilder addParty(List<? extends ReferenceWithMetaParty> partys) {
			if (partys != null) {
				for (ReferenceWithMetaParty toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder setParty(List<? extends ReferenceWithMetaParty> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addPartyValue(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.addPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setPartyValue(List<? extends Party> partys) {
			this.party.clear();
			if (partys!=null) {
				partys.forEach(this::addPartyValue);
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setPositionStatus(PositionStatusEnum positionStatus) {
			this.positionStatus = positionStatus==null?null:positionStatus;
			return this;
		}
		@Override
		public AggregationParameters.AggregationParametersBuilder addProduct(Product product) {
			if (product!=null) this.product.add(product.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addProduct(Product product, int _idx) {
			getIndex(this.product, _idx, () -> product.toBuilder());
			return this;
		}
		@Override 
		public AggregationParameters.AggregationParametersBuilder addProduct(List<? extends Product> products) {
			if (products != null) {
				for (Product toAdd : products) {
					this.product.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder setProduct(List<? extends Product> products) {
			if (products == null)  {
				this.product = new ArrayList<>();
			}
			else {
				this.product = products.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier) {
			if (productQualifier!=null) this.productQualifier.add(productQualifier);
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(String productQualifier, int _idx) {
			getIndex(this.productQualifier, _idx, () -> productQualifier);
			return this;
		}
		@Override 
		public AggregationParameters.AggregationParametersBuilder addProductQualifier(List<? extends String> productQualifiers) {
			if (productQualifiers != null) {
				for (String toAdd : productQualifiers) {
					this.productQualifier.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder setProductQualifier(List<? extends String> productQualifiers) {
			if (productQualifiers == null)  {
				this.productQualifier = new ArrayList<>();
			}
			else {
				this.productQualifier = productQualifiers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setTotalPosition(Boolean totalPosition) {
			this.totalPosition = totalPosition==null?null:totalPosition;
			return this;
		}
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference) {
			if (tradeReference!=null) this.tradeReference.add(tradeReference.toBuilder());
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReference(ReferenceWithMetaTrade tradeReference, int _idx) {
			getIndex(this.tradeReference, _idx, () -> tradeReference.toBuilder());
			return this;
		}
		
			@Override
			public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference) {
				this.getOrCreateTradeReference(-1).setValue(tradeReference.toBuilder());
				return this;
			}
			
			@Override
			public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(Trade tradeReference, int _idx) {
				this.getOrCreateTradeReference(_idx).setValue(tradeReference.toBuilder());
				return this;
			}
		@Override 
		public AggregationParameters.AggregationParametersBuilder addTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences != null) {
				for (ReferenceWithMetaTrade toAdd : tradeReferences) {
					this.tradeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AggregationParameters.AggregationParametersBuilder setTradeReference(List<? extends ReferenceWithMetaTrade> tradeReferences) {
			if (tradeReferences == null)  {
				this.tradeReference = new ArrayList<>();
			}
			else {
				this.tradeReference = tradeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder addTradeReferenceValue(List<? extends Trade> tradeReferences) {
			if (tradeReferences != null) {
				for (Trade toAdd : tradeReferences) {
					this.addTradeReferenceValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder setTradeReferenceValue(List<? extends Trade> tradeReferences) {
			this.tradeReference.clear();
			if (tradeReferences!=null) {
				tradeReferences.forEach(this::addTradeReferenceValue);
			}
			return this;
		}
		
		
		@Override
		public AggregationParameters build() {
			return new AggregationParameters.AggregationParametersImpl(this);
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationParameters.AggregationParametersBuilder prune() {
			party = party.stream().filter(b->b!=null).<ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			product = product.stream().filter(b->b!=null).<Product.ProductBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeReference = tradeReference.stream().filter(b->b!=null).<ReferenceWithMetaTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateTime()!=null) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPositionStatus()!=null) return true;
			if (getProduct()!=null && getProduct().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductQualifier()!=null && !getProductQualifier().isEmpty()) return true;
			if (getTotalPosition()!=null) return true;
			if (getTradeReference()!=null && getTradeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AggregationParameters.AggregationParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AggregationParameters.AggregationParametersBuilder o = (AggregationParameters.AggregationParametersBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::getOrCreateProduct);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::getOrCreateTradeReference);
			
			merger.mergeBasic(getDateTime(), o.getDateTime(), this::setDateTime);
			merger.mergeBasic(getPositionStatus(), o.getPositionStatus(), this::setPositionStatus);
			merger.mergeBasic(getProductQualifier(), o.getProductQualifier(), (Consumer<String>) this::addProductQualifier);
			merger.mergeBasic(getTotalPosition(), o.getTotalPosition(), this::setTotalPosition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AggregationParameters _that = getType().cast(o);
		
			if (!Objects.equals(dateTime, _that.getDateTime())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(productQualifier, _that.getProductQualifier())) return false;
			if (!Objects.equals(totalPosition, _that.getTotalPosition())) return false;
			if (!ListEquals.listEquals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateTime != null ? dateTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (productQualifier != null ? productQualifier.hashCode() : 0);
			_result = 31 * _result + (totalPosition != null ? totalPosition.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AggregationParametersBuilder {" +
				"dateTime=" + this.dateTime + ", " +
				"party=" + this.party + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"product=" + this.product + ", " +
				"productQualifier=" + this.productQualifier + ", " +
				"totalPosition=" + this.totalPosition + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
}
