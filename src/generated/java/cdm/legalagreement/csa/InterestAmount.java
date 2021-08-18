package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.InterestAmountMeta;
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
 * A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
@RosettaClass

public interface InterestAmount extends RosettaModelObject {
	InterestAmount build();
	InterestAmount.InterestAmountBuilder toBuilder();
	
	/**
	 * The application of Interest Amount with respect the Delivery Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
	 */
	DeliveryAmount getDeliveryAmount();
	/**
	 * The application of Interest Amount with respect the Return Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
	 */
	ReturnAmount getReturnAmount();
	final static InterestAmountMeta metaData = new InterestAmountMeta();
	
	@Override
	default RosettaMetaData<? extends InterestAmount> metaData() {
		return metaData;
	} 
			
	static InterestAmount.InterestAmountBuilder builder() {
		return new InterestAmount.InterestAmountBuilderImpl();
	}
	
	default Class<? extends InterestAmount> getType() {
		return InterestAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("deliveryAmount"), processor, DeliveryAmount.class, getDeliveryAmount());
		processRosetta(path.newSubPath("returnAmount"), processor, ReturnAmount.class, getReturnAmount());
	}
	
	
	interface InterestAmountBuilder extends InterestAmount, RosettaModelObjectBuilder {
		DeliveryAmount.DeliveryAmountBuilder getOrCreateDeliveryAmount();
		DeliveryAmount.DeliveryAmountBuilder getDeliveryAmount();
		ReturnAmount.ReturnAmountBuilder getOrCreateReturnAmount();
		ReturnAmount.ReturnAmountBuilder getReturnAmount();
		InterestAmount.InterestAmountBuilder setDeliveryAmount(DeliveryAmount deliveryAmount);
		InterestAmount.InterestAmountBuilder setReturnAmount(ReturnAmount returnAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("deliveryAmount"), processor, DeliveryAmount.DeliveryAmountBuilder.class, getDeliveryAmount());
			processRosetta(path.newSubPath("returnAmount"), processor, ReturnAmount.ReturnAmountBuilder.class, getReturnAmount());
		}
		
	}
	
	//InterestAmount.InterestAmountImpl
	class InterestAmountImpl implements InterestAmount {
		private final DeliveryAmount deliveryAmount;
		private final ReturnAmount returnAmount;
		
		protected InterestAmountImpl(InterestAmount.InterestAmountBuilder builder) {
			this.deliveryAmount = ofNullable(builder.getDeliveryAmount()).map(f->f.build()).orElse(null);
			this.returnAmount = ofNullable(builder.getReturnAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DeliveryAmount getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public ReturnAmount getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public InterestAmount build() {
			return this;
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder toBuilder() {
			InterestAmount.InterestAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAmount.InterestAmountBuilder builder) {
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAmount _that = getType().cast(o);
		
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
			return "InterestAmount {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount +
			'}';
		}
	}
	
	//InterestAmount.InterestAmountBuilderImpl
	class InterestAmountBuilderImpl implements InterestAmount.InterestAmountBuilder {
	
		protected DeliveryAmount.DeliveryAmountBuilder deliveryAmount;
		protected ReturnAmount.ReturnAmountBuilder returnAmount;
	
		public InterestAmountBuilderImpl() {
		}
	
		@Override
		public DeliveryAmount.DeliveryAmountBuilder getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public DeliveryAmount.DeliveryAmountBuilder getOrCreateDeliveryAmount() {
			DeliveryAmount.DeliveryAmountBuilder result;
			if (deliveryAmount!=null) {
				result = deliveryAmount;
			}
			else {
				result = deliveryAmount = DeliveryAmount.builder();
			}
			
			return result;
		}
		
		@Override
		public ReturnAmount.ReturnAmountBuilder getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public ReturnAmount.ReturnAmountBuilder getOrCreateReturnAmount() {
			ReturnAmount.ReturnAmountBuilder result;
			if (returnAmount!=null) {
				result = returnAmount;
			}
			else {
				result = returnAmount = ReturnAmount.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InterestAmount.InterestAmountBuilder setDeliveryAmount(DeliveryAmount deliveryAmount) {
			this.deliveryAmount = deliveryAmount==null?null:deliveryAmount.toBuilder();
			return this;
		}
		@Override
		public InterestAmount.InterestAmountBuilder setReturnAmount(ReturnAmount returnAmount) {
			this.returnAmount = returnAmount==null?null:returnAmount.toBuilder();
			return this;
		}
		
		@Override
		public InterestAmount build() {
			return new InterestAmount.InterestAmountImpl(this);
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAmount.InterestAmountBuilder prune() {
			if (deliveryAmount!=null && !deliveryAmount.prune().hasData()) deliveryAmount = null;
			if (returnAmount!=null && !returnAmount.prune().hasData()) returnAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryAmount()!=null && getDeliveryAmount().hasData()) return true;
			if (getReturnAmount()!=null && getReturnAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAmount.InterestAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAmount.InterestAmountBuilder o = (InterestAmount.InterestAmountBuilder) other;
			
			merger.mergeRosetta(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			merger.mergeRosetta(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAmount _that = getType().cast(o);
		
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
			return "InterestAmountBuilder {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount +
			'}';
		}
	}
}
