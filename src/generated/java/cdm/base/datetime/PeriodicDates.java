package cdm.base.datetime;

import cdm.base.datetime.meta.PeriodicDatesMeta;
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
 * A class for specifying a calculation period schedule.
 * @version ${project.version}
 */
@RosettaClass

public interface PeriodicDates extends RosettaModelObject {
	PeriodicDates build();
	PeriodicDates.PeriodicDatesBuilder toBuilder();
	
	/**
	 * The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableOrRelativeDate getEndDate();
	/**
	 * The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
	 */
	BusinessDayAdjustments getPeriodDatesAdjustments();
	/**
	 * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getPeriodFrequency();
	/**
	 * The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableOrRelativeDate getStartDate();
	final static PeriodicDatesMeta metaData = new PeriodicDatesMeta();
	
	@Override
	default RosettaMetaData<? extends PeriodicDates> metaData() {
		return metaData;
	} 
			
	static PeriodicDates.PeriodicDatesBuilder builder() {
		return new PeriodicDates.PeriodicDatesBuilderImpl();
	}
	
	default Class<? extends PeriodicDates> getType() {
		return PeriodicDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("endDate"), processor, AdjustableOrRelativeDate.class, getEndDate());
		processRosetta(path.newSubPath("periodDatesAdjustments"), processor, BusinessDayAdjustments.class, getPeriodDatesAdjustments());
		processRosetta(path.newSubPath("periodFrequency"), processor, CalculationPeriodFrequency.class, getPeriodFrequency());
		processRosetta(path.newSubPath("startDate"), processor, AdjustableOrRelativeDate.class, getStartDate());
	}
	
	
	interface PeriodicDatesBuilder extends PeriodicDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEndDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEndDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePeriodDatesAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPeriodDatesAdjustments();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreatePeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getPeriodFrequency();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStartDate();
		PeriodicDates.PeriodicDatesBuilder setEndDate(AdjustableOrRelativeDate endDate);
		PeriodicDates.PeriodicDatesBuilder setPeriodDatesAdjustments(BusinessDayAdjustments periodDatesAdjustments);
		PeriodicDates.PeriodicDatesBuilder setPeriodFrequency(CalculationPeriodFrequency periodFrequency);
		PeriodicDates.PeriodicDatesBuilder setStartDate(AdjustableOrRelativeDate startDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("endDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEndDate());
			processRosetta(path.newSubPath("periodDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getPeriodDatesAdjustments());
			processRosetta(path.newSubPath("periodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getPeriodFrequency());
			processRosetta(path.newSubPath("startDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStartDate());
		}
		
	}
	
	//PeriodicDates.PeriodicDatesImpl
	class PeriodicDatesImpl implements PeriodicDates {
		private final AdjustableOrRelativeDate endDate;
		private final BusinessDayAdjustments periodDatesAdjustments;
		private final CalculationPeriodFrequency periodFrequency;
		private final AdjustableOrRelativeDate startDate;
		
		protected PeriodicDatesImpl(PeriodicDates.PeriodicDatesBuilder builder) {
			this.endDate = ofNullable(builder.getEndDate()).map(f->f.build()).orElse(null);
			this.periodDatesAdjustments = ofNullable(builder.getPeriodDatesAdjustments()).map(f->f.build()).orElse(null);
			this.periodFrequency = ofNullable(builder.getPeriodFrequency()).map(f->f.build()).orElse(null);
			this.startDate = ofNullable(builder.getStartDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableOrRelativeDate getEndDate() {
			return endDate;
		}
		
		@Override
		public BusinessDayAdjustments getPeriodDatesAdjustments() {
			return periodDatesAdjustments;
		}
		
		@Override
		public CalculationPeriodFrequency getPeriodFrequency() {
			return periodFrequency;
		}
		
		@Override
		public AdjustableOrRelativeDate getStartDate() {
			return startDate;
		}
		
		@Override
		public PeriodicDates build() {
			return this;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder toBuilder() {
			PeriodicDates.PeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodicDates.PeriodicDatesBuilder builder) {
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getPeriodDatesAdjustments()).ifPresent(builder::setPeriodDatesAdjustments);
			ofNullable(getPeriodFrequency()).ifPresent(builder::setPeriodFrequency);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(periodDatesAdjustments, _that.getPeriodDatesAdjustments())) return false;
			if (!Objects.equals(periodFrequency, _that.getPeriodFrequency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (periodDatesAdjustments != null ? periodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (periodFrequency != null ? periodFrequency.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicDates {" +
				"endDate=" + this.endDate + ", " +
				"periodDatesAdjustments=" + this.periodDatesAdjustments + ", " +
				"periodFrequency=" + this.periodFrequency + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
	
	//PeriodicDates.PeriodicDatesBuilderImpl
	class PeriodicDatesBuilderImpl implements PeriodicDates.PeriodicDatesBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder endDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder periodDatesAdjustments;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder periodFrequency;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder startDate;
	
		public PeriodicDatesBuilderImpl() {
		}
	
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEndDate() {
			return endDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEndDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (endDate!=null) {
				result = endDate;
			}
			else {
				result = endDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getPeriodDatesAdjustments() {
			return periodDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreatePeriodDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (periodDatesAdjustments!=null) {
				result = periodDatesAdjustments;
			}
			else {
				result = periodDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getPeriodFrequency() {
			return periodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreatePeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (periodFrequency!=null) {
				result = periodFrequency;
			}
			else {
				result = periodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStartDate() {
			return startDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (startDate!=null) {
				result = startDate;
			}
			else {
				result = startDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PeriodicDates.PeriodicDatesBuilder setEndDate(AdjustableOrRelativeDate endDate) {
			this.endDate = endDate==null?null:endDate.toBuilder();
			return this;
		}
		@Override
		public PeriodicDates.PeriodicDatesBuilder setPeriodDatesAdjustments(BusinessDayAdjustments periodDatesAdjustments) {
			this.periodDatesAdjustments = periodDatesAdjustments==null?null:periodDatesAdjustments.toBuilder();
			return this;
		}
		@Override
		public PeriodicDates.PeriodicDatesBuilder setPeriodFrequency(CalculationPeriodFrequency periodFrequency) {
			this.periodFrequency = periodFrequency==null?null:periodFrequency.toBuilder();
			return this;
		}
		@Override
		public PeriodicDates.PeriodicDatesBuilder setStartDate(AdjustableOrRelativeDate startDate) {
			this.startDate = startDate==null?null:startDate.toBuilder();
			return this;
		}
		
		@Override
		public PeriodicDates build() {
			return new PeriodicDates.PeriodicDatesImpl(this);
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicDates.PeriodicDatesBuilder prune() {
			if (endDate!=null && !endDate.prune().hasData()) endDate = null;
			if (periodDatesAdjustments!=null && !periodDatesAdjustments.prune().hasData()) periodDatesAdjustments = null;
			if (periodFrequency!=null && !periodFrequency.prune().hasData()) periodFrequency = null;
			if (startDate!=null && !startDate.prune().hasData()) startDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEndDate()!=null && getEndDate().hasData()) return true;
			if (getPeriodDatesAdjustments()!=null && getPeriodDatesAdjustments().hasData()) return true;
			if (getPeriodFrequency()!=null && getPeriodFrequency().hasData()) return true;
			if (getStartDate()!=null && getStartDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicDates.PeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodicDates.PeriodicDatesBuilder o = (PeriodicDates.PeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeRosetta(getPeriodDatesAdjustments(), o.getPeriodDatesAdjustments(), this::setPeriodDatesAdjustments);
			merger.mergeRosetta(getPeriodFrequency(), o.getPeriodFrequency(), this::setPeriodFrequency);
			merger.mergeRosetta(getStartDate(), o.getStartDate(), this::setStartDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(periodDatesAdjustments, _that.getPeriodDatesAdjustments())) return false;
			if (!Objects.equals(periodFrequency, _that.getPeriodFrequency())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (periodDatesAdjustments != null ? periodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (periodFrequency != null ? periodFrequency.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicDatesBuilder {" +
				"endDate=" + this.endDate + ", " +
				"periodDatesAdjustments=" + this.periodDatesAdjustments + ", " +
				"periodFrequency=" + this.periodFrequency + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
}
