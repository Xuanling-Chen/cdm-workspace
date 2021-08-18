package cdm.product.common.schedule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.product.common.schedule.meta.CalculationPeriodDatesMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data for:  defining the parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
 * @version ${project.version}
 */
@RosettaClass

public interface CalculationPeriodDates extends RosettaModelObject, GlobalKey {
	CalculationPeriodDates build();
	CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder();
	
	/**
	 * The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
	 */
	BusinessDayAdjustments getCalculationPeriodDatesAdjustments();
	/**
	 * The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getCalculationPeriodFrequency();
	/**
	 * The first day of the terms of the trade. This day may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * The end date of the initial compounding period when compounding is applicable. It must only be specified when the compoundingMethod element is present and not equal to a value of None. This date may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getFirstCompoundingPeriodEndDate();
	/**
	 * The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
	 */
	AdjustableOrRelativeDate getFirstPeriodStartDate();
	/**
	 * The start date of the regular part of the calculation period schedule. It must only be specified if there is an initial stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getFirstRegularPeriodStartDate();
	/**
	 * The end date of the regular part of the calculation period schedule. It must only be specified if there is a final stub calculation period. This day may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	Date getLastRegularPeriodEndDate();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Method to allocate any irregular period remaining after regular periods have been allocated between the effective and termination date.
	 */
	StubPeriodTypeEnum getStubPeriodType();
	/**
	 * The last day of the terms of the trade. This date may be subject to adjustments in accordance with the business day convention. It can also be specified in relation to another scheduled date (e.g. the last payment date).
	 */
	AdjustableOrRelativeDate getTerminationDate();
	final static CalculationPeriodDatesMeta metaData = new CalculationPeriodDatesMeta();
	
	@Override
	default RosettaMetaData<? extends CalculationPeriodDates> metaData() {
		return metaData;
	} 
			
	static CalculationPeriodDates.CalculationPeriodDatesBuilder builder() {
		return new CalculationPeriodDates.CalculationPeriodDatesBuilderImpl();
	}
	
	default Class<? extends CalculationPeriodDates> getType() {
		return CalculationPeriodDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), Date.class, getFirstCompoundingPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), Date.class, getFirstRegularPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), Date.class, getLastRegularPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
		
		processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.class, getCalculationPeriodDatesAdjustments());
		processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.class, getCalculationPeriodFrequency());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableOrRelativeDate.class, getFirstPeriodStartDate());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
	}
	
	
	interface CalculationPeriodDatesBuilder extends CalculationPeriodDates, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFirstPeriodStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFirstPeriodStartDate();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(Date firstCompoundingPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableOrRelativeDate firstPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(Date firstRegularPeriodStartDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(Date lastRegularPeriodEndDate);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setMeta(MetaFields meta);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum stubPeriodType);
		CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("firstCompoundingPeriodEndDate"), Date.class, getFirstCompoundingPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("firstRegularPeriodStartDate"), Date.class, getFirstRegularPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPeriodEndDate"), Date.class, getLastRegularPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("stubPeriodType"), StubPeriodTypeEnum.class, getStubPeriodType(), this);
			
			processRosetta(path.newSubPath("calculationPeriodDatesAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getCalculationPeriodDatesAdjustments());
			processRosetta(path.newSubPath("calculationPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getCalculationPeriodFrequency());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("firstPeriodStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getFirstPeriodStartDate());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
		}
		
	}
	
	//CalculationPeriodDates.CalculationPeriodDatesImpl
	class CalculationPeriodDatesImpl implements CalculationPeriodDates {
		private final BusinessDayAdjustments calculationPeriodDatesAdjustments;
		private final CalculationPeriodFrequency calculationPeriodFrequency;
		private final AdjustableOrRelativeDate effectiveDate;
		private final Date firstCompoundingPeriodEndDate;
		private final AdjustableOrRelativeDate firstPeriodStartDate;
		private final Date firstRegularPeriodStartDate;
		private final Date lastRegularPeriodEndDate;
		private final MetaFields meta;
		private final StubPeriodTypeEnum stubPeriodType;
		private final AdjustableOrRelativeDate terminationDate;
		
		protected CalculationPeriodDatesImpl(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			this.calculationPeriodDatesAdjustments = ofNullable(builder.getCalculationPeriodDatesAdjustments()).map(f->f.build()).orElse(null);
			this.calculationPeriodFrequency = ofNullable(builder.getCalculationPeriodFrequency()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.firstCompoundingPeriodEndDate = builder.getFirstCompoundingPeriodEndDate();
			this.firstPeriodStartDate = ofNullable(builder.getFirstPeriodStartDate()).map(f->f.build()).orElse(null);
			this.firstRegularPeriodStartDate = builder.getFirstRegularPeriodStartDate();
			this.lastRegularPeriodEndDate = builder.getLastRegularPeriodEndDate();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.stubPeriodType = builder.getStubPeriodType();
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessDayAdjustments getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public CalculationPeriodFrequency getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public Date getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		public AdjustableOrRelativeDate getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public Date getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		public Date getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodDates.CalculationPeriodDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesAdjustments()).ifPresent(builder::setCalculationPeriodDatesAdjustments);
			ofNullable(getCalculationPeriodFrequency()).ifPresent(builder::setCalculationPeriodFrequency);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getFirstCompoundingPeriodEndDate()).ifPresent(builder::setFirstCompoundingPeriodEndDate);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getFirstRegularPeriodStartDate()).ifPresent(builder::setFirstRegularPeriodStartDate);
			ofNullable(getLastRegularPeriodEndDate()).ifPresent(builder::setLastRegularPeriodEndDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getStubPeriodType()).ifPresent(builder::setStubPeriodType);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDates {" +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"meta=" + this.meta + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}
	
	//CalculationPeriodDates.CalculationPeriodDatesBuilderImpl
	class CalculationPeriodDatesBuilderImpl implements CalculationPeriodDates.CalculationPeriodDatesBuilder, GlobalKeyBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder calculationPeriodDatesAdjustments;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected Date firstCompoundingPeriodEndDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder firstPeriodStartDate;
		protected Date firstRegularPeriodStartDate;
		protected Date lastRegularPeriodEndDate;
		protected MetaFields.MetaFieldsBuilder meta;
		protected StubPeriodTypeEnum stubPeriodType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
	
		public CalculationPeriodDatesBuilderImpl() {
		}
	
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getCalculationPeriodDatesAdjustments() {
			return calculationPeriodDatesAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateCalculationPeriodDatesAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (calculationPeriodDatesAdjustments!=null) {
				result = calculationPeriodDatesAdjustments;
			}
			else {
				result = calculationPeriodDatesAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getCalculationPeriodFrequency() {
			return calculationPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateCalculationPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (calculationPeriodFrequency!=null) {
				result = calculationPeriodFrequency;
			}
			else {
				result = calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getFirstCompoundingPeriodEndDate() {
			return firstCompoundingPeriodEndDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateFirstPeriodStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (firstPeriodStartDate!=null) {
				result = firstPeriodStartDate;
			}
			else {
				result = firstPeriodStartDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getFirstRegularPeriodStartDate() {
			return firstRegularPeriodStartDate;
		}
		
		@Override
		public Date getLastRegularPeriodEndDate() {
			return lastRegularPeriodEndDate;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public StubPeriodTypeEnum getStubPeriodType() {
			return stubPeriodType;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodDatesAdjustments(BusinessDayAdjustments calculationPeriodDatesAdjustments) {
			this.calculationPeriodDatesAdjustments = calculationPeriodDatesAdjustments==null?null:calculationPeriodDatesAdjustments.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setCalculationPeriodFrequency(CalculationPeriodFrequency calculationPeriodFrequency) {
			this.calculationPeriodFrequency = calculationPeriodFrequency==null?null:calculationPeriodFrequency.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstCompoundingPeriodEndDate(Date firstCompoundingPeriodEndDate) {
			this.firstCompoundingPeriodEndDate = firstCompoundingPeriodEndDate==null?null:firstCompoundingPeriodEndDate;
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstPeriodStartDate(AdjustableOrRelativeDate firstPeriodStartDate) {
			this.firstPeriodStartDate = firstPeriodStartDate==null?null:firstPeriodStartDate.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setFirstRegularPeriodStartDate(Date firstRegularPeriodStartDate) {
			this.firstRegularPeriodStartDate = firstRegularPeriodStartDate==null?null:firstRegularPeriodStartDate;
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setLastRegularPeriodEndDate(Date lastRegularPeriodEndDate) {
			this.lastRegularPeriodEndDate = lastRegularPeriodEndDate==null?null:lastRegularPeriodEndDate;
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setStubPeriodType(StubPeriodTypeEnum stubPeriodType) {
			this.stubPeriodType = stubPeriodType==null?null:stubPeriodType;
			return this;
		}
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		
		@Override
		public CalculationPeriodDates build() {
			return new CalculationPeriodDates.CalculationPeriodDatesImpl(this);
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder prune() {
			if (calculationPeriodDatesAdjustments!=null && !calculationPeriodDatesAdjustments.prune().hasData()) calculationPeriodDatesAdjustments = null;
			if (calculationPeriodFrequency!=null && !calculationPeriodFrequency.prune().hasData()) calculationPeriodFrequency = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (firstPeriodStartDate!=null && !firstPeriodStartDate.prune().hasData()) firstPeriodStartDate = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesAdjustments()!=null && getCalculationPeriodDatesAdjustments().hasData()) return true;
			if (getCalculationPeriodFrequency()!=null && getCalculationPeriodFrequency().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getFirstCompoundingPeriodEndDate()!=null) return true;
			if (getFirstPeriodStartDate()!=null && getFirstPeriodStartDate().hasData()) return true;
			if (getFirstRegularPeriodStartDate()!=null) return true;
			if (getLastRegularPeriodEndDate()!=null) return true;
			if (getStubPeriodType()!=null) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder o = (CalculationPeriodDates.CalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesAdjustments(), o.getCalculationPeriodDatesAdjustments(), this::setCalculationPeriodDatesAdjustments);
			merger.mergeRosetta(getCalculationPeriodFrequency(), o.getCalculationPeriodFrequency(), this::setCalculationPeriodFrequency);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::setFirstPeriodStartDate);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			
			merger.mergeBasic(getFirstCompoundingPeriodEndDate(), o.getFirstCompoundingPeriodEndDate(), this::setFirstCompoundingPeriodEndDate);
			merger.mergeBasic(getFirstRegularPeriodStartDate(), o.getFirstRegularPeriodStartDate(), this::setFirstRegularPeriodStartDate);
			merger.mergeBasic(getLastRegularPeriodEndDate(), o.getLastRegularPeriodEndDate(), this::setLastRegularPeriodEndDate);
			merger.mergeBasic(getStubPeriodType(), o.getStubPeriodType(), this::setStubPeriodType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesAdjustments, _that.getCalculationPeriodDatesAdjustments())) return false;
			if (!Objects.equals(calculationPeriodFrequency, _that.getCalculationPeriodFrequency())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(firstCompoundingPeriodEndDate, _that.getFirstCompoundingPeriodEndDate())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstRegularPeriodStartDate, _that.getFirstRegularPeriodStartDate())) return false;
			if (!Objects.equals(lastRegularPeriodEndDate, _that.getLastRegularPeriodEndDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(stubPeriodType, _that.getStubPeriodType())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesAdjustments != null ? calculationPeriodDatesAdjustments.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodFrequency != null ? calculationPeriodFrequency.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (firstCompoundingPeriodEndDate != null ? firstCompoundingPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstRegularPeriodStartDate != null ? firstRegularPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPeriodEndDate != null ? lastRegularPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (stubPeriodType != null ? stubPeriodType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodDatesBuilder {" +
				"calculationPeriodDatesAdjustments=" + this.calculationPeriodDatesAdjustments + ", " +
				"calculationPeriodFrequency=" + this.calculationPeriodFrequency + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"firstCompoundingPeriodEndDate=" + this.firstCompoundingPeriodEndDate + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstRegularPeriodStartDate=" + this.firstRegularPeriodStartDate + ", " +
				"lastRegularPeriodEndDate=" + this.lastRegularPeriodEndDate + ", " +
				"meta=" + this.meta + ", " +
				"stubPeriodType=" + this.stubPeriodType + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}
}
