package cdm.product.common.schedule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.product.common.schedule.meta.PaymentDateScheduleMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
 * @version ${project.version}
 */
@RosettaClass

public interface PaymentDateSchedule extends RosettaModelObject {
	PaymentDateSchedule build();
	PaymentDateSchedule.PaymentDateScheduleBuilder toBuilder();
	
	/**
	 * The last payment when specified as an adjustable or relative date, as in the FpML total return construct.
	 */
	AdjustableOrRelativeDate getFinalPaymentDate();
	/**
	 */
	List<? extends AdjustableRelativeOrPeriodicDates> getInterimPaymentDates();
	final static PaymentDateScheduleMeta metaData = new PaymentDateScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends PaymentDateSchedule> metaData() {
		return metaData;
	} 
			
	static PaymentDateSchedule.PaymentDateScheduleBuilder builder() {
		return new PaymentDateSchedule.PaymentDateScheduleBuilderImpl();
	}
	
	default Class<? extends PaymentDateSchedule> getType() {
		return PaymentDateSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("finalPaymentDate"), processor, AdjustableOrRelativeDate.class, getFinalPaymentDate());
		processRosetta(path.newSubPath("interimPaymentDates"), processor, AdjustableRelativeOrPeriodicDates.class, getInterimPaymentDates());
	}
	
	
	interface PaymentDateScheduleBuilder extends PaymentDateSchedule, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFinalPaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFinalPaymentDate();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateInterimPaymentDates(int _index);
		List<? extends AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> getInterimPaymentDates();
		PaymentDateSchedule.PaymentDateScheduleBuilder setFinalPaymentDate(AdjustableOrRelativeDate finalPaymentDate);
		PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(AdjustableRelativeOrPeriodicDates interimPaymentDates);
		PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(AdjustableRelativeOrPeriodicDates interimPaymentDates, int _idx);
		PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(List<? extends AdjustableRelativeOrPeriodicDates> interimPaymentDates);
		PaymentDateSchedule.PaymentDateScheduleBuilder setInterimPaymentDates(List<? extends AdjustableRelativeOrPeriodicDates> interimPaymentDates);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("finalPaymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getFinalPaymentDate());
			processRosetta(path.newSubPath("interimPaymentDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getInterimPaymentDates());
		}
		
	}
	
	//PaymentDateSchedule.PaymentDateScheduleImpl
	class PaymentDateScheduleImpl implements PaymentDateSchedule {
		private final AdjustableOrRelativeDate finalPaymentDate;
		private final List<? extends AdjustableRelativeOrPeriodicDates> interimPaymentDates;
		
		protected PaymentDateScheduleImpl(PaymentDateSchedule.PaymentDateScheduleBuilder builder) {
			this.finalPaymentDate = ofNullable(builder.getFinalPaymentDate()).map(f->f.build()).orElse(null);
			this.interimPaymentDates = ofNullable(builder.getInterimPaymentDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public AdjustableOrRelativeDate getFinalPaymentDate() {
			return finalPaymentDate;
		}
		
		@Override
		public List<? extends AdjustableRelativeOrPeriodicDates> getInterimPaymentDates() {
			return interimPaymentDates;
		}
		
		@Override
		public PaymentDateSchedule build() {
			return this;
		}
		
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder toBuilder() {
			PaymentDateSchedule.PaymentDateScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDateSchedule.PaymentDateScheduleBuilder builder) {
			ofNullable(getFinalPaymentDate()).ifPresent(builder::setFinalPaymentDate);
			ofNullable(getInterimPaymentDates()).ifPresent(builder::setInterimPaymentDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDateSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalPaymentDate, _that.getFinalPaymentDate())) return false;
			if (!ListEquals.listEquals(interimPaymentDates, _that.getInterimPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalPaymentDate != null ? finalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (interimPaymentDates != null ? interimPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDateSchedule {" +
				"finalPaymentDate=" + this.finalPaymentDate + ", " +
				"interimPaymentDates=" + this.interimPaymentDates +
			'}';
		}
	}
	
	//PaymentDateSchedule.PaymentDateScheduleBuilderImpl
	class PaymentDateScheduleBuilderImpl implements PaymentDateSchedule.PaymentDateScheduleBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder finalPaymentDate;
		protected List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> interimPaymentDates = new ArrayList<>();
	
		public PaymentDateScheduleBuilderImpl() {
		}
	
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFinalPaymentDate() {
			return finalPaymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFinalPaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (finalPaymentDate!=null) {
				result = finalPaymentDate;
			}
			else {
				result = finalPaymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> getInterimPaymentDates() {
			return interimPaymentDates;
		}
		
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateInterimPaymentDates(int _index) {
		
			if (interimPaymentDates==null) {
				this.interimPaymentDates = new ArrayList<>();
			}
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			return getIndex(interimPaymentDates, _index, () -> {
						AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder newInterimPaymentDates = AdjustableRelativeOrPeriodicDates.builder();
						return newInterimPaymentDates;
					});
		}
		
	
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder setFinalPaymentDate(AdjustableOrRelativeDate finalPaymentDate) {
			this.finalPaymentDate = finalPaymentDate==null?null:finalPaymentDate.toBuilder();
			return this;
		}
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(AdjustableRelativeOrPeriodicDates interimPaymentDates) {
			if (interimPaymentDates!=null) this.interimPaymentDates.add(interimPaymentDates.toBuilder());
			return this;
		}
		
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(AdjustableRelativeOrPeriodicDates interimPaymentDates, int _idx) {
			getIndex(this.interimPaymentDates, _idx, () -> interimPaymentDates.toBuilder());
			return this;
		}
		@Override 
		public PaymentDateSchedule.PaymentDateScheduleBuilder addInterimPaymentDates(List<? extends AdjustableRelativeOrPeriodicDates> interimPaymentDatess) {
			if (interimPaymentDatess != null) {
				for (AdjustableRelativeOrPeriodicDates toAdd : interimPaymentDatess) {
					this.interimPaymentDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PaymentDateSchedule.PaymentDateScheduleBuilder setInterimPaymentDates(List<? extends AdjustableRelativeOrPeriodicDates> interimPaymentDatess) {
			if (interimPaymentDatess == null)  {
				this.interimPaymentDates = new ArrayList<>();
			}
			else {
				this.interimPaymentDates = interimPaymentDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PaymentDateSchedule build() {
			return new PaymentDateSchedule.PaymentDateScheduleImpl(this);
		}
		
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder prune() {
			if (finalPaymentDate!=null && !finalPaymentDate.prune().hasData()) finalPaymentDate = null;
			interimPaymentDates = interimPaymentDates.stream().filter(b->b!=null).<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinalPaymentDate()!=null && getFinalPaymentDate().hasData()) return true;
			if (getInterimPaymentDates()!=null && getInterimPaymentDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDateSchedule.PaymentDateScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDateSchedule.PaymentDateScheduleBuilder o = (PaymentDateSchedule.PaymentDateScheduleBuilder) other;
			
			merger.mergeRosetta(getFinalPaymentDate(), o.getFinalPaymentDate(), this::setFinalPaymentDate);
			merger.mergeRosetta(getInterimPaymentDates(), o.getInterimPaymentDates(), this::getOrCreateInterimPaymentDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDateSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalPaymentDate, _that.getFinalPaymentDate())) return false;
			if (!ListEquals.listEquals(interimPaymentDates, _that.getInterimPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalPaymentDate != null ? finalPaymentDate.hashCode() : 0);
			_result = 31 * _result + (interimPaymentDates != null ? interimPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDateScheduleBuilder {" +
				"finalPaymentDate=" + this.finalPaymentDate + ", " +
				"interimPaymentDates=" + this.interimPaymentDates +
			'}';
		}
	}
}
