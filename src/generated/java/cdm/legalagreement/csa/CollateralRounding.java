package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralRoundingMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(C): Rounding. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding.
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralRounding extends RosettaModelObject {
	CollateralRounding build();
	CollateralRounding.CollateralRoundingBuilder toBuilder();
	
	/**
	 * The rounding methodology applicable to the Delivery Amount in terms of nearest integral multiple of Base Currency units.
	 */
	BigDecimal getDeliveryAmount();
	/**
	 * The rounding methodology applicable to the Return Amount in terms of nearest integral multiple of Base Currency units.
	 */
	BigDecimal getReturnAmount();
	final static CollateralRoundingMeta metaData = new CollateralRoundingMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralRounding> metaData() {
		return metaData;
	} 
			
	static CollateralRounding.CollateralRoundingBuilder builder() {
		return new CollateralRounding.CollateralRoundingBuilderImpl();
	}
	
	default Class<? extends CollateralRounding> getType() {
		return CollateralRounding.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryAmount"), BigDecimal.class, getDeliveryAmount(), this);
		processor.processBasic(path.newSubPath("returnAmount"), BigDecimal.class, getReturnAmount(), this);
		
	}
	
	
	interface CollateralRoundingBuilder extends CollateralRounding, RosettaModelObjectBuilder {
		CollateralRounding.CollateralRoundingBuilder setDeliveryAmount(BigDecimal deliveryAmount);
		CollateralRounding.CollateralRoundingBuilder setReturnAmount(BigDecimal returnAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("deliveryAmount"), BigDecimal.class, getDeliveryAmount(), this);
			processor.processBasic(path.newSubPath("returnAmount"), BigDecimal.class, getReturnAmount(), this);
			
		}
		
	}
	
	//CollateralRounding.CollateralRoundingImpl
	class CollateralRoundingImpl implements CollateralRounding {
		private final BigDecimal deliveryAmount;
		private final BigDecimal returnAmount;
		
		protected CollateralRoundingImpl(CollateralRounding.CollateralRoundingBuilder builder) {
			this.deliveryAmount = builder.getDeliveryAmount();
			this.returnAmount = builder.getReturnAmount();
		}
		
		@Override
		public BigDecimal getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public BigDecimal getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public CollateralRounding build() {
			return this;
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder toBuilder() {
			CollateralRounding.CollateralRoundingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralRounding.CollateralRoundingBuilder builder) {
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralRounding _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralRounding {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount +
			'}';
		}
	}
	
	//CollateralRounding.CollateralRoundingBuilderImpl
	class CollateralRoundingBuilderImpl implements CollateralRounding.CollateralRoundingBuilder {
	
		protected BigDecimal deliveryAmount;
		protected BigDecimal returnAmount;
	
		public CollateralRoundingBuilderImpl() {
		}
	
		@Override
		public BigDecimal getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public BigDecimal getReturnAmount() {
			return returnAmount;
		}
		
	
		@Override
		public CollateralRounding.CollateralRoundingBuilder setDeliveryAmount(BigDecimal deliveryAmount) {
			this.deliveryAmount = deliveryAmount==null?null:deliveryAmount;
			return this;
		}
		@Override
		public CollateralRounding.CollateralRoundingBuilder setReturnAmount(BigDecimal returnAmount) {
			this.returnAmount = returnAmount==null?null:returnAmount;
			return this;
		}
		
		@Override
		public CollateralRounding build() {
			return new CollateralRounding.CollateralRoundingImpl(this);
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralRounding.CollateralRoundingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryAmount()!=null) return true;
			if (getReturnAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralRounding.CollateralRoundingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralRounding.CollateralRoundingBuilder o = (CollateralRounding.CollateralRoundingBuilder) other;
			
			
			merger.mergeBasic(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			merger.mergeBasic(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralRounding _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralRoundingBuilder {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount +
			'}';
		}
	}
}
