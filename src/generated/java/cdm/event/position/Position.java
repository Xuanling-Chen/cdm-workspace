package cdm.event.position;

import cdm.base.math.Quantity;
import cdm.event.common.Trade;
import cdm.event.common.Trade;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.common.metafields.ReferenceWithMetaTrade.ReferenceWithMetaTradeBuilder;
import cdm.event.position.meta.PositionMeta;
import cdm.observable.asset.Money;
import cdm.product.template.Product;
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
 *  A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
 * @version ${project.version}
 */
@RosettaClass

public interface Position extends RosettaModelObject {
	Position build();
	Position.PositionBuilder toBuilder();
	
	/**
	 * The aggregate cost of proceeds
	 */
	Money getCashBalance();
	/**
	 * Qualifier for the state of the Position, to distinguish if just executed, formed, already settled, closed etc.
	 */
	PositionStatusEnum getPositionStatus();
	/**
	 * The product underlying the position, which can either be a contractual product or securities.
	 */
	Product getProduct();
	/**
	 * The quantity of the product, which can be a negative number in case of a short position.
	 */
	Quantity getQuantity();
	/**
	 * Reference to the Contract, in case product is contractual and the contract has been formed
	 */
	ReferenceWithMetaTrade getTradeReference();
	final static PositionMeta metaData = new PositionMeta();
	
	@Override
	default RosettaMetaData<? extends Position> metaData() {
		return metaData;
	} 
			
	static Position.PositionBuilder builder() {
		return new Position.PositionBuilderImpl();
	}
	
	default Class<? extends Position> getType() {
		return Position.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
		
		processRosetta(path.newSubPath("cashBalance"), processor, Money.class, getCashBalance());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
		processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTrade.class, getTradeReference());
	}
	
	
	interface PositionBuilder extends Position, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashBalance();
		Money.MoneyBuilder getCashBalance();
		Product.ProductBuilder getOrCreateProduct();
		Product.ProductBuilder getProduct();
		Quantity.QuantityBuilder getOrCreateQuantity();
		Quantity.QuantityBuilder getQuantity();
		ReferenceWithMetaTradeBuilder getOrCreateTradeReference();
		ReferenceWithMetaTradeBuilder getTradeReference();
		Position.PositionBuilder setCashBalance(Money cashBalance);
		Position.PositionBuilder setPositionStatus(PositionStatusEnum positionStatus);
		Position.PositionBuilder setProduct(Product product);
		Position.PositionBuilder setQuantity(Quantity quantity);
		Position.PositionBuilder setTradeReference(ReferenceWithMetaTrade tradeReference);
		Position.PositionBuilder setTradeReferenceValue(Trade tradeReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("positionStatus"), PositionStatusEnum.class, getPositionStatus(), this);
			
			processRosetta(path.newSubPath("cashBalance"), processor, Money.MoneyBuilder.class, getCashBalance());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
			processRosetta(path.newSubPath("tradeReference"), processor, ReferenceWithMetaTradeBuilder.class, getTradeReference());
		}
		
	}
	
	//Position.PositionImpl
	class PositionImpl implements Position {
		private final Money cashBalance;
		private final PositionStatusEnum positionStatus;
		private final Product product;
		private final Quantity quantity;
		private final ReferenceWithMetaTrade tradeReference;
		
		protected PositionImpl(Position.PositionBuilder builder) {
			this.cashBalance = ofNullable(builder.getCashBalance()).map(f->f.build()).orElse(null);
			this.positionStatus = builder.getPositionStatus();
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
			this.quantity = ofNullable(builder.getQuantity()).map(f->f.build()).orElse(null);
			this.tradeReference = ofNullable(builder.getTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getCashBalance() {
			return cashBalance;
		}
		
		@Override
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		public Product getProduct() {
			return product;
		}
		
		@Override
		public Quantity getQuantity() {
			return quantity;
		}
		
		@Override
		public ReferenceWithMetaTrade getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public Position build() {
			return this;
		}
		
		@Override
		public Position.PositionBuilder toBuilder() {
			Position.PositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Position.PositionBuilder builder) {
			ofNullable(getCashBalance()).ifPresent(builder::setCashBalance);
			ofNullable(getPositionStatus()).ifPresent(builder::setPositionStatus);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Position _that = getType().cast(o);
		
			if (!Objects.equals(cashBalance, _that.getCashBalance())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashBalance != null ? cashBalance.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Position {" +
				"cashBalance=" + this.cashBalance + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"product=" + this.product + ", " +
				"quantity=" + this.quantity + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
	
	//Position.PositionBuilderImpl
	class PositionBuilderImpl implements Position.PositionBuilder {
	
		protected Money.MoneyBuilder cashBalance;
		protected PositionStatusEnum positionStatus;
		protected Product.ProductBuilder product;
		protected Quantity.QuantityBuilder quantity;
		protected ReferenceWithMetaTradeBuilder tradeReference;
	
		public PositionBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getCashBalance() {
			return cashBalance;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashBalance() {
			Money.MoneyBuilder result;
			if (cashBalance!=null) {
				result = cashBalance;
			}
			else {
				result = cashBalance = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public PositionStatusEnum getPositionStatus() {
			return positionStatus;
		}
		
		@Override
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		public Quantity.QuantityBuilder getQuantity() {
			return quantity;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateQuantity() {
			Quantity.QuantityBuilder result;
			if (quantity!=null) {
				result = quantity;
			}
			else {
				result = quantity = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaTradeBuilder getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public ReferenceWithMetaTradeBuilder getOrCreateTradeReference() {
			ReferenceWithMetaTradeBuilder result;
			if (tradeReference!=null) {
				result = tradeReference;
			}
			else {
				result = tradeReference = ReferenceWithMetaTrade.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Position.PositionBuilder setCashBalance(Money cashBalance) {
			this.cashBalance = cashBalance==null?null:cashBalance.toBuilder();
			return this;
		}
		@Override
		public Position.PositionBuilder setPositionStatus(PositionStatusEnum positionStatus) {
			this.positionStatus = positionStatus==null?null:positionStatus;
			return this;
		}
		@Override
		public Position.PositionBuilder setProduct(Product product) {
			this.product = product==null?null:product.toBuilder();
			return this;
		}
		@Override
		public Position.PositionBuilder setQuantity(Quantity quantity) {
			this.quantity = quantity==null?null:quantity.toBuilder();
			return this;
		}
		@Override
		public Position.PositionBuilder setTradeReference(ReferenceWithMetaTrade tradeReference) {
			this.tradeReference = tradeReference==null?null:tradeReference.toBuilder();
			return this;
		}
		
		@Override
		public Position.PositionBuilder setTradeReferenceValue(Trade tradeReference) {
			this.getOrCreateTradeReference().setValue(tradeReference);
			return this;
		}
		
		@Override
		public Position build() {
			return new Position.PositionImpl(this);
		}
		
		@Override
		public Position.PositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Position.PositionBuilder prune() {
			if (cashBalance!=null && !cashBalance.prune().hasData()) cashBalance = null;
			if (product!=null && !product.prune().hasData()) product = null;
			if (quantity!=null && !quantity.prune().hasData()) quantity = null;
			if (tradeReference!=null && !tradeReference.prune().hasData()) tradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashBalance()!=null && getCashBalance().hasData()) return true;
			if (getPositionStatus()!=null) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			if (getQuantity()!=null && getQuantity().hasData()) return true;
			if (getTradeReference()!=null && getTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Position.PositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Position.PositionBuilder o = (Position.PositionBuilder) other;
			
			merger.mergeRosetta(getCashBalance(), o.getCashBalance(), this::setCashBalance);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::setTradeReference);
			
			merger.mergeBasic(getPositionStatus(), o.getPositionStatus(), this::setPositionStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Position _that = getType().cast(o);
		
			if (!Objects.equals(cashBalance, _that.getCashBalance())) return false;
			if (!Objects.equals(positionStatus, _that.getPositionStatus())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashBalance != null ? cashBalance.hashCode() : 0);
			_result = 31 * _result + (positionStatus != null ? positionStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PositionBuilder {" +
				"cashBalance=" + this.cashBalance + ", " +
				"positionStatus=" + this.positionStatus + ", " +
				"product=" + this.product + ", " +
				"quantity=" + this.quantity + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
}
