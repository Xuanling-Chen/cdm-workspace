package cdm.base.math;

import cdm.base.math.meta.NonNegativeQuantityScheduleMeta;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity.ReferenceWithMetaQuantityBuilder;
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
 * Class to specify a non-negative quantity schedule, which is used to define the quantity of a payout leg. This quantity cannot be negative, while direction is specified through a BuyerSeller or PayerReceiver attribute. The only available schedule implementation is a step schedule, specified as a set of date-value pairs. The non-negativity is enforced by using the non-negative quantity and step schedule classes.
 * @version ${project.version}
 */
@RosettaClass

public interface NonNegativeQuantitySchedule extends RosettaModelObject {
	NonNegativeQuantitySchedule build();
	NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder();
	
	/**
	 * The initial quantity of a schedule represented as a single, non-negative number. In the case where no schedule is specified, the constant quantity is specified at a higher level. Can be referenced from TradableProduct
	 */
	ReferenceWithMetaQuantity getInitialQuantity();
	/**
	 * The schedule specified as a set of date-value pairs. Attribute is optional, to represent the case where no schedule is specified so quantity is just constant over time.
	 */
	NonNegativeStepSchedule getStepSchedule();
	final static NonNegativeQuantityScheduleMeta metaData = new NonNegativeQuantityScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends NonNegativeQuantitySchedule> metaData() {
		return metaData;
	} 
			
	static NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder() {
		return new NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl();
	}
	
	default Class<? extends NonNegativeQuantitySchedule> getType() {
		return NonNegativeQuantitySchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("initialQuantity"), processor, ReferenceWithMetaQuantity.class, getInitialQuantity());
		processRosetta(path.newSubPath("stepSchedule"), processor, NonNegativeStepSchedule.class, getStepSchedule());
	}
	
	
	interface NonNegativeQuantityScheduleBuilder extends NonNegativeQuantitySchedule, RosettaModelObjectBuilder {
		ReferenceWithMetaQuantityBuilder getOrCreateInitialQuantity();
		ReferenceWithMetaQuantityBuilder getInitialQuantity();
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder getOrCreateStepSchedule();
		NonNegativeStepSchedule.NonNegativeStepScheduleBuilder getStepSchedule();
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setInitialQuantity(ReferenceWithMetaQuantity initialQuantity);
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setInitialQuantityValue(Quantity initialQuantity);
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setStepSchedule(NonNegativeStepSchedule stepSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("initialQuantity"), processor, ReferenceWithMetaQuantityBuilder.class, getInitialQuantity());
			processRosetta(path.newSubPath("stepSchedule"), processor, NonNegativeStepSchedule.NonNegativeStepScheduleBuilder.class, getStepSchedule());
		}
		
	}
	
	//NonNegativeQuantitySchedule.NonNegativeQuantityScheduleImpl
	class NonNegativeQuantityScheduleImpl implements NonNegativeQuantitySchedule {
		private final ReferenceWithMetaQuantity initialQuantity;
		private final NonNegativeStepSchedule stepSchedule;
		
		protected NonNegativeQuantityScheduleImpl(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder) {
			this.initialQuantity = ofNullable(builder.getInitialQuantity()).map(f->f.build()).orElse(null);
			this.stepSchedule = ofNullable(builder.getStepSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaQuantity getInitialQuantity() {
			return initialQuantity;
		}
		
		@Override
		public NonNegativeStepSchedule getStepSchedule() {
			return stepSchedule;
		}
		
		@Override
		public NonNegativeQuantitySchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder() {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder builder) {
			ofNullable(getInitialQuantity()).ifPresent(builder::setInitialQuantity);
			ofNullable(getStepSchedule()).ifPresent(builder::setStepSchedule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(initialQuantity, _that.getInitialQuantity())) return false;
			if (!Objects.equals(stepSchedule, _that.getStepSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialQuantity != null ? initialQuantity.hashCode() : 0);
			_result = 31 * _result + (stepSchedule != null ? stepSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeQuantitySchedule {" +
				"initialQuantity=" + this.initialQuantity + ", " +
				"stepSchedule=" + this.stepSchedule +
			'}';
		}
	}
	
	//NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilderImpl
	class NonNegativeQuantityScheduleBuilderImpl implements NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder {
	
		protected ReferenceWithMetaQuantityBuilder initialQuantity;
		protected NonNegativeStepSchedule.NonNegativeStepScheduleBuilder stepSchedule;
	
		public NonNegativeQuantityScheduleBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaQuantityBuilder getInitialQuantity() {
			return initialQuantity;
		}
		
		@Override
		public ReferenceWithMetaQuantityBuilder getOrCreateInitialQuantity() {
			ReferenceWithMetaQuantityBuilder result;
			if (initialQuantity!=null) {
				result = initialQuantity;
			}
			else {
				result = initialQuantity = ReferenceWithMetaQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder getStepSchedule() {
			return stepSchedule;
		}
		
		@Override
		public NonNegativeStepSchedule.NonNegativeStepScheduleBuilder getOrCreateStepSchedule() {
			NonNegativeStepSchedule.NonNegativeStepScheduleBuilder result;
			if (stepSchedule!=null) {
				result = stepSchedule;
			}
			else {
				result = stepSchedule = NonNegativeStepSchedule.builder();
			}
			
			return result;
		}
		
	
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setInitialQuantity(ReferenceWithMetaQuantity initialQuantity) {
			this.initialQuantity = initialQuantity==null?null:initialQuantity.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setInitialQuantityValue(Quantity initialQuantity) {
			this.getOrCreateInitialQuantity().setValue(initialQuantity);
			return this;
		}
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder setStepSchedule(NonNegativeStepSchedule stepSchedule) {
			this.stepSchedule = stepSchedule==null?null:stepSchedule.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeQuantitySchedule build() {
			return new NonNegativeQuantitySchedule.NonNegativeQuantityScheduleImpl(this);
		}
		
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder prune() {
			if (initialQuantity!=null && !initialQuantity.prune().hasData()) initialQuantity = null;
			if (stepSchedule!=null && !stepSchedule.prune().hasData()) stepSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialQuantity()!=null && getInitialQuantity().hasData()) return true;
			if (getStepSchedule()!=null && getStepSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder o = (NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getInitialQuantity(), o.getInitialQuantity(), this::setInitialQuantity);
			merger.mergeRosetta(getStepSchedule(), o.getStepSchedule(), this::setStepSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonNegativeQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(initialQuantity, _that.getInitialQuantity())) return false;
			if (!Objects.equals(stepSchedule, _that.getStepSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialQuantity != null ? initialQuantity.hashCode() : 0);
			_result = 31 * _result + (stepSchedule != null ? stepSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeQuantityScheduleBuilder {" +
				"initialQuantity=" + this.initialQuantity + ", " +
				"stepSchedule=" + this.stepSchedule +
			'}';
		}
	}
}
