package cdm.product.common.schedule;

import cdm.product.common.schedule.meta.CalculationPeriodDataMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationPeriodData extends RosettaModelObject {
	CalculationPeriodData build();
	CalculationPeriodData.CalculationPeriodDataBuilder toBuilder();
	
	/**
	 */
	Integer getDaysInLeapYearPeriod();
	/**
	 */
	Integer getDaysInPeriod();
	/**
	 */
	Date getEndDate();
	/**
	 */
	Boolean getIsFirstPeriod();
	/**
	 */
	Boolean getIsLastPeriod();
	/**
	 */
	Date getStartDate();
	final static CalculationPeriodDataMeta metaData = new CalculationPeriodDataMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationPeriodData> metaData() {
		return metaData;
	} 
			
	static CalculationPeriodData.CalculationPeriodDataBuilder builder() {
		return new CalculationPeriodData.CalculationPeriodDataBuilderImpl();
	}
	
	default Class<? extends CalculationPeriodData> getType() {
		return CalculationPeriodData.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("daysInLeapYearPeriod"), Integer.class, getDaysInLeapYearPeriod(), this);
		processor.processBasic(path.newSubPath("daysInPeriod"), Integer.class, getDaysInPeriod(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("isFirstPeriod"), Boolean.class, getIsFirstPeriod(), this);
		processor.processBasic(path.newSubPath("isLastPeriod"), Boolean.class, getIsLastPeriod(), this);
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		
	}
	
	
	interface CalculationPeriodDataBuilder extends CalculationPeriodData, RosettaModelObjectBuilder {
		CalculationPeriodData.CalculationPeriodDataBuilder setDaysInLeapYearPeriod(Integer daysInLeapYearPeriod);
		CalculationPeriodData.CalculationPeriodDataBuilder setDaysInPeriod(Integer daysInPeriod);
		CalculationPeriodData.CalculationPeriodDataBuilder setEndDate(Date endDate);
		CalculationPeriodData.CalculationPeriodDataBuilder setIsFirstPeriod(Boolean isFirstPeriod);
		CalculationPeriodData.CalculationPeriodDataBuilder setIsLastPeriod(Boolean isLastPeriod);
		CalculationPeriodData.CalculationPeriodDataBuilder setStartDate(Date startDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("daysInLeapYearPeriod"), Integer.class, getDaysInLeapYearPeriod(), this);
			processor.processBasic(path.newSubPath("daysInPeriod"), Integer.class, getDaysInPeriod(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("isFirstPeriod"), Boolean.class, getIsFirstPeriod(), this);
			processor.processBasic(path.newSubPath("isLastPeriod"), Boolean.class, getIsLastPeriod(), this);
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			
		}
		
	}
	
	//CalculationPeriodData.CalculationPeriodDataImpl
	class CalculationPeriodDataImpl implements CalculationPeriodData {
		private final Integer daysInLeapYearPeriod;
		private final Integer daysInPeriod;
		private final Date endDate;
		private final Boolean isFirstPeriod;
		private final Boolean isLastPeriod;
		private final Date startDate;
		
		protected CalculationPeriodDataImpl(CalculationPeriodData.CalculationPeriodDataBuilder builder) {
			this.daysInLeapYearPeriod = builder.getDaysInLeapYearPeriod();
			this.daysInPeriod = builder.getDaysInPeriod();
			this.endDate = builder.getEndDate();
			this.isFirstPeriod = builder.getIsFirstPeriod();
			this.isLastPeriod = builder.getIsLastPeriod();
			this.startDate = builder.getStartDate();
		}
		
		@Override
		public Integer getDaysInLeapYearPeriod() {
			return daysInLeapYearPeriod;
		}
		
		@Override
		public Integer getDaysInPeriod() {
			return daysInPeriod;
		}
		
		@Override
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public Boolean getIsFirstPeriod() {
			return isFirstPeriod;
		}
		
		@Override
		public Boolean getIsLastPeriod() {
			return isLastPeriod;
		}
		
		@Override
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		public CalculationPeriodData build() {
			return this;
		}
		
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder toBuilder() {
			CalculationPeriodData.CalculationPeriodDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodData.CalculationPeriodDataBuilder builder) {
			ofNullable(getDaysInLeapYearPeriod()).ifPresent(builder::setDaysInLeapYearPeriod);
			ofNullable(getDaysInPeriod()).ifPresent(builder::setDaysInPeriod);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getIsFirstPeriod()).ifPresent(builder::setIsFirstPeriod);
			ofNullable(getIsLastPeriod()).ifPresent(builder::setIsLastPeriod);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodData _that = getType().cast(o);
		
			if (!Objects.equals(daysInLeapYearPeriod, _that.getDaysInLeapYearPeriod())) return false;
			if (!Objects.equals(daysInPeriod, _that.getDaysInPeriod())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(isFirstPeriod, _that.getIsFirstPeriod())) return false;
			if (!Objects.equals(isLastPeriod, _that.getIsLastPeriod())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysInLeapYearPeriod != null ? daysInLeapYearPeriod.hashCode() : 0);
			_result = 31 * _result + (daysInPeriod != null ? daysInPeriod.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (isFirstPeriod != null ? isFirstPeriod.hashCode() : 0);
			_result = 31 * _result + (isLastPeriod != null ? isLastPeriod.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodData {" +
				"daysInLeapYearPeriod=" + this.daysInLeapYearPeriod + ", " +
				"daysInPeriod=" + this.daysInPeriod + ", " +
				"endDate=" + this.endDate + ", " +
				"isFirstPeriod=" + this.isFirstPeriod + ", " +
				"isLastPeriod=" + this.isLastPeriod + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
	
	//CalculationPeriodData.CalculationPeriodDataBuilderImpl
	class CalculationPeriodDataBuilderImpl implements CalculationPeriodData.CalculationPeriodDataBuilder {
	
		protected Integer daysInLeapYearPeriod;
		protected Integer daysInPeriod;
		protected Date endDate;
		protected Boolean isFirstPeriod;
		protected Boolean isLastPeriod;
		protected Date startDate;
	
		public CalculationPeriodDataBuilderImpl() {
		}
	
		@Override
		public Integer getDaysInLeapYearPeriod() {
			return daysInLeapYearPeriod;
		}
		
		@Override
		public Integer getDaysInPeriod() {
			return daysInPeriod;
		}
		
		@Override
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public Boolean getIsFirstPeriod() {
			return isFirstPeriod;
		}
		
		@Override
		public Boolean getIsLastPeriod() {
			return isLastPeriod;
		}
		
		@Override
		public Date getStartDate() {
			return startDate;
		}
		
	
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setDaysInLeapYearPeriod(Integer daysInLeapYearPeriod) {
			this.daysInLeapYearPeriod = daysInLeapYearPeriod==null?null:daysInLeapYearPeriod;
			return this;
		}
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setDaysInPeriod(Integer daysInPeriod) {
			this.daysInPeriod = daysInPeriod==null?null:daysInPeriod;
			return this;
		}
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setIsFirstPeriod(Boolean isFirstPeriod) {
			this.isFirstPeriod = isFirstPeriod==null?null:isFirstPeriod;
			return this;
		}
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setIsLastPeriod(Boolean isLastPeriod) {
			this.isLastPeriod = isLastPeriod==null?null:isLastPeriod;
			return this;
		}
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		
		@Override
		public CalculationPeriodData build() {
			return new CalculationPeriodData.CalculationPeriodDataImpl(this);
		}
		
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDaysInLeapYearPeriod()!=null) return true;
			if (getDaysInPeriod()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getIsFirstPeriod()!=null) return true;
			if (getIsLastPeriod()!=null) return true;
			if (getStartDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodData.CalculationPeriodDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriodData.CalculationPeriodDataBuilder o = (CalculationPeriodData.CalculationPeriodDataBuilder) other;
			
			
			merger.mergeBasic(getDaysInLeapYearPeriod(), o.getDaysInLeapYearPeriod(), this::setDaysInLeapYearPeriod);
			merger.mergeBasic(getDaysInPeriod(), o.getDaysInPeriod(), this::setDaysInPeriod);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getIsFirstPeriod(), o.getIsFirstPeriod(), this::setIsFirstPeriod);
			merger.mergeBasic(getIsLastPeriod(), o.getIsLastPeriod(), this::setIsLastPeriod);
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodData _that = getType().cast(o);
		
			if (!Objects.equals(daysInLeapYearPeriod, _that.getDaysInLeapYearPeriod())) return false;
			if (!Objects.equals(daysInPeriod, _that.getDaysInPeriod())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(isFirstPeriod, _that.getIsFirstPeriod())) return false;
			if (!Objects.equals(isLastPeriod, _that.getIsLastPeriod())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysInLeapYearPeriod != null ? daysInLeapYearPeriod.hashCode() : 0);
			_result = 31 * _result + (daysInPeriod != null ? daysInPeriod.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (isFirstPeriod != null ? isFirstPeriod.hashCode() : 0);
			_result = 31 * _result + (isLastPeriod != null ? isLastPeriod.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDataBuilder {" +
				"daysInLeapYearPeriod=" + this.daysInLeapYearPeriod + ", " +
				"daysInPeriod=" + this.daysInPeriod + ", " +
				"endDate=" + this.endDate + ", " +
				"isFirstPeriod=" + this.isFirstPeriod + ", " +
				"isLastPeriod=" + this.isLastPeriod + ", " +
				"startDate=" + this.startDate +
			'}';
		}
	}
}
