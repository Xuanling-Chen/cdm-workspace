package cdm.base.datetime;

import cdm.base.datetime.meta.AveragingScheduleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Class to representing a method for generating a series of dates.
 * @version ${project.version}
 */
@RosettaClass

public interface AveragingSchedule extends RosettaModelObject {
	AveragingSchedule build();
	AveragingSchedule.AveragingScheduleBuilder toBuilder();
	
	/**
	 * The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getAveragingPeriodFrequency();
	/**
	 * Date on which this period ends.
	 */
	Date getEndDate();
	/**
	 * Date on which this period begins.
	 */
	Date getStartDate();
	final static AveragingScheduleMeta metaData = new AveragingScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends AveragingSchedule> metaData() {
		return metaData;
	} 
			
	static AveragingSchedule.AveragingScheduleBuilder builder() {
		return new AveragingSchedule.AveragingScheduleBuilderImpl();
	}
	
	default Class<? extends AveragingSchedule> getType() {
		return AveragingSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		
		processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.class, getAveragingPeriodFrequency());
	}
	
	
	interface AveragingScheduleBuilder extends AveragingSchedule, RosettaModelObjectBuilder {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency();
		AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency averagingPeriodFrequency);
		AveragingSchedule.AveragingScheduleBuilder setEndDate(Date endDate);
		AveragingSchedule.AveragingScheduleBuilder setStartDate(Date startDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			
			processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getAveragingPeriodFrequency());
		}
		
	}
	
	//AveragingSchedule.AveragingScheduleImpl
	class AveragingScheduleImpl implements AveragingSchedule {
		private final CalculationPeriodFrequency averagingPeriodFrequency;
		private final Date endDate;
		private final Date startDate;
		
		protected AveragingScheduleImpl(AveragingSchedule.AveragingScheduleBuilder builder) {
			this.averagingPeriodFrequency = ofNullable(builder.getAveragingPeriodFrequency()).map(f->f.build()).orElse(null);
			this.endDate = builder.getEndDate();
			this.startDate = builder.getStartDate();
		}
		
		@Override
		public CalculationPeriodFrequency getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		public AveragingSchedule build() {
			return this;
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			AveragingSchedule.AveragingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragingSchedule.AveragingScheduleBuilder builder) {
			ofNullable(getAveragingPeriodFrequency()).ifPresent(builder::setAveragingPeriodFrequency);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingSchedule {" +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency + ", " +
				"endDate=" + this.endDate + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
	
	//AveragingSchedule.AveragingScheduleBuilderImpl
	class AveragingScheduleBuilderImpl implements AveragingSchedule.AveragingScheduleBuilder {
	
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder averagingPeriodFrequency;
		protected Date endDate;
		protected Date startDate;
	
		public AveragingScheduleBuilderImpl() {
		}
	
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (averagingPeriodFrequency!=null) {
				result = averagingPeriodFrequency;
			}
			else {
				result = averagingPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public Date getStartDate() {
			return startDate;
		}
		
	
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency averagingPeriodFrequency) {
			this.averagingPeriodFrequency = averagingPeriodFrequency==null?null:averagingPeriodFrequency.toBuilder();
			return this;
		}
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		public AveragingSchedule.AveragingScheduleBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		
		@Override
		public AveragingSchedule build() {
			return new AveragingSchedule.AveragingScheduleImpl(this);
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder prune() {
			if (averagingPeriodFrequency!=null && !averagingPeriodFrequency.prune().hasData()) averagingPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingPeriodFrequency()!=null && getAveragingPeriodFrequency().hasData()) return true;
			if (getEndDate()!=null) return true;
			if (getStartDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AveragingSchedule.AveragingScheduleBuilder o = (AveragingSchedule.AveragingScheduleBuilder) other;
			
			merger.mergeRosetta(getAveragingPeriodFrequency(), o.getAveragingPeriodFrequency(), this::setAveragingPeriodFrequency);
			
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingScheduleBuilder {" +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency + ", " +
				"endDate=" + this.endDate + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
}
