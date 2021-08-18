package cdm.product.template;

import cdm.base.math.RateSchedule;
import cdm.base.math.RateSchedule.RateScheduleBuilder;
import cdm.base.math.RateSchedule.RateScheduleBuilderImpl;
import cdm.base.math.RateSchedule.RateScheduleImpl;
import cdm.base.math.Step;
import cdm.base.staticdata.party.PayerReceiverEnum;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.product.template.meta.StrikeScheduleMeta;
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
 * A class describing a schedule of cap or floor rates.
 * @version ${project.version}
 */
@RosettaClass

public interface StrikeSchedule extends RateSchedule {
	StrikeSchedule build();
	StrikeSchedule.StrikeScheduleBuilder toBuilder();
	
	/**
	 * The buyer of the option.
	 */
	PayerReceiverEnum getBuyer();
	/**
	 * The party that has sold.
	 */
	PayerReceiverEnum getSeller();
	final static StrikeScheduleMeta metaData = new StrikeScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends StrikeSchedule> metaData() {
		return metaData;
	} 
			
	static StrikeSchedule.StrikeScheduleBuilder builder() {
		return new StrikeSchedule.StrikeScheduleBuilderImpl();
	}
	
	default Class<? extends StrikeSchedule> getType() {
		return StrikeSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.RateSchedule.super.process(path, processor);
		processor.processBasic(path.newSubPath("buyer"), PayerReceiverEnum.class, getBuyer(), this);
		processor.processBasic(path.newSubPath("seller"), PayerReceiverEnum.class, getSeller(), this);
		
	}
	
	
	interface StrikeScheduleBuilder extends StrikeSchedule, RateSchedule.RateScheduleBuilder, RosettaModelObjectBuilder {
		StrikeSchedule.StrikeScheduleBuilder setBuyer(PayerReceiverEnum buyer);
		StrikeSchedule.StrikeScheduleBuilder setSeller(PayerReceiverEnum seller);
		StrikeSchedule.StrikeScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue);
		StrikeSchedule.StrikeScheduleBuilder setInitialValueValue(Price initialValue);
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step);
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step, int _idx);
		StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> step);
		StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> step);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			RateSchedule.RateScheduleBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("buyer"), PayerReceiverEnum.class, getBuyer(), this);
			processor.processBasic(path.newSubPath("seller"), PayerReceiverEnum.class, getSeller(), this);
			
		}
		
	}
	
	//StrikeSchedule.StrikeScheduleImpl
	class StrikeScheduleImpl extends RateSchedule.RateScheduleImpl implements StrikeSchedule {
		private final PayerReceiverEnum buyer;
		private final PayerReceiverEnum seller;
		
		protected StrikeScheduleImpl(StrikeSchedule.StrikeScheduleBuilder builder) {
			super(builder);
			this.buyer = builder.getBuyer();
			this.seller = builder.getSeller();
		}
		
		@Override
		public PayerReceiverEnum getBuyer() {
			return buyer;
		}
		
		@Override
		public PayerReceiverEnum getSeller() {
			return seller;
		}
		
		@Override
		public StrikeSchedule build() {
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			StrikeSchedule.StrikeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikeSchedule.StrikeScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeSchedule {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}
	
	//StrikeSchedule.StrikeScheduleBuilderImpl
	class StrikeScheduleBuilderImpl extends RateSchedule.RateScheduleBuilderImpl  implements StrikeSchedule.StrikeScheduleBuilder {
	
		protected PayerReceiverEnum buyer;
		protected PayerReceiverEnum seller;
	
		public StrikeScheduleBuilderImpl() {
		}
	
		@Override
		public PayerReceiverEnum getBuyer() {
			return buyer;
		}
		
		@Override
		public PayerReceiverEnum getSeller() {
			return seller;
		}
		
	
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setBuyer(PayerReceiverEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setSeller(PayerReceiverEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue) {
			this.initialValue = initialValue==null?null:initialValue.toBuilder();
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setInitialValueValue(Price initialValue) {
			this.getOrCreateInitialValue().setValue(initialValue);
			return this;
		}
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public StrikeSchedule build() {
			return new StrikeSchedule.StrikeScheduleImpl(this);
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyer()!=null) return true;
			if (getSeller()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			StrikeSchedule.StrikeScheduleBuilder o = (StrikeSchedule.StrikeScheduleBuilder) other;
			
			
			merger.mergeBasic(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeBasic(getSeller(), o.getSeller(), this::setSeller);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeScheduleBuilder {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}
}
