package cdm.observable.asset;

import cdm.base.datetime.BusinessCenters;
import cdm.observable.asset.meta.ObservationShiftCalculationMeta;
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
 * Parameters to describe the observation shift for a daily compounded or averaged floating rate. This type is used to represent modular computed rates in interestRatePayouts.
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationShiftCalculation extends RosettaModelObject {
	ObservationShiftCalculation build();
	ObservationShiftCalculation.ObservationShiftCalculationBuilder toBuilder();
	
	/**
	 * Any additional business days that be applicable.
	 */
	BusinessCenters getAdditionalBusinessDays();
	/**
	 * Whether the rate is calculated in advance, in arrears, or relative to a reset date.
	 */
	ObservationPeriodDatesEnum getCalculationBase();
	/**
	 * The number of days of observation shift.
	 */
	Integer getOffsetDays();
	final static ObservationShiftCalculationMeta metaData = new ObservationShiftCalculationMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationShiftCalculation> metaData() {
		return metaData;
	} 
			
	static ObservationShiftCalculation.ObservationShiftCalculationBuilder builder() {
		return new ObservationShiftCalculation.ObservationShiftCalculationBuilderImpl();
	}
	
	default Class<? extends ObservationShiftCalculation> getType() {
		return ObservationShiftCalculation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationBase"), ObservationPeriodDatesEnum.class, getCalculationBase(), this);
		processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
		
		processRosetta(path.newSubPath("additionalBusinessDays"), processor, BusinessCenters.class, getAdditionalBusinessDays());
	}
	
	
	interface ObservationShiftCalculationBuilder extends ObservationShiftCalculation, RosettaModelObjectBuilder {
		BusinessCenters.BusinessCentersBuilder getOrCreateAdditionalBusinessDays();
		BusinessCenters.BusinessCentersBuilder getAdditionalBusinessDays();
		ObservationShiftCalculation.ObservationShiftCalculationBuilder setAdditionalBusinessDays(BusinessCenters additionalBusinessDays);
		ObservationShiftCalculation.ObservationShiftCalculationBuilder setCalculationBase(ObservationPeriodDatesEnum calculationBase);
		ObservationShiftCalculation.ObservationShiftCalculationBuilder setOffsetDays(Integer offsetDays);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationBase"), ObservationPeriodDatesEnum.class, getCalculationBase(), this);
			processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
			
			processRosetta(path.newSubPath("additionalBusinessDays"), processor, BusinessCenters.BusinessCentersBuilder.class, getAdditionalBusinessDays());
		}
		
	}
	
	//ObservationShiftCalculation.ObservationShiftCalculationImpl
	class ObservationShiftCalculationImpl implements ObservationShiftCalculation {
		private final BusinessCenters additionalBusinessDays;
		private final ObservationPeriodDatesEnum calculationBase;
		private final Integer offsetDays;
		
		protected ObservationShiftCalculationImpl(ObservationShiftCalculation.ObservationShiftCalculationBuilder builder) {
			this.additionalBusinessDays = ofNullable(builder.getAdditionalBusinessDays()).map(f->f.build()).orElse(null);
			this.calculationBase = builder.getCalculationBase();
			this.offsetDays = builder.getOffsetDays();
		}
		
		@Override
		public BusinessCenters getAdditionalBusinessDays() {
			return additionalBusinessDays;
		}
		
		@Override
		public ObservationPeriodDatesEnum getCalculationBase() {
			return calculationBase;
		}
		
		@Override
		public Integer getOffsetDays() {
			return offsetDays;
		}
		
		@Override
		public ObservationShiftCalculation build() {
			return this;
		}
		
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder toBuilder() {
			ObservationShiftCalculation.ObservationShiftCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationShiftCalculation.ObservationShiftCalculationBuilder builder) {
			ofNullable(getAdditionalBusinessDays()).ifPresent(builder::setAdditionalBusinessDays);
			ofNullable(getCalculationBase()).ifPresent(builder::setCalculationBase);
			ofNullable(getOffsetDays()).ifPresent(builder::setOffsetDays);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationShiftCalculation _that = getType().cast(o);
		
			if (!Objects.equals(additionalBusinessDays, _that.getAdditionalBusinessDays())) return false;
			if (!Objects.equals(calculationBase, _that.getCalculationBase())) return false;
			if (!Objects.equals(offsetDays, _that.getOffsetDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalBusinessDays != null ? additionalBusinessDays.hashCode() : 0);
			_result = 31 * _result + (calculationBase != null ? calculationBase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offsetDays != null ? offsetDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationShiftCalculation {" +
				"additionalBusinessDays=" + this.additionalBusinessDays + ", " +
				"calculationBase=" + this.calculationBase + ", " +
				"offsetDays=" + this.offsetDays +
			'}';
		}
	}
	
	//ObservationShiftCalculation.ObservationShiftCalculationBuilderImpl
	class ObservationShiftCalculationBuilderImpl implements ObservationShiftCalculation.ObservationShiftCalculationBuilder {
	
		protected BusinessCenters.BusinessCentersBuilder additionalBusinessDays;
		protected ObservationPeriodDatesEnum calculationBase;
		protected Integer offsetDays;
	
		public ObservationShiftCalculationBuilderImpl() {
		}
	
		@Override
		public BusinessCenters.BusinessCentersBuilder getAdditionalBusinessDays() {
			return additionalBusinessDays;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateAdditionalBusinessDays() {
			BusinessCenters.BusinessCentersBuilder result;
			if (additionalBusinessDays!=null) {
				result = additionalBusinessDays;
			}
			else {
				result = additionalBusinessDays = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		public ObservationPeriodDatesEnum getCalculationBase() {
			return calculationBase;
		}
		
		@Override
		public Integer getOffsetDays() {
			return offsetDays;
		}
		
	
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder setAdditionalBusinessDays(BusinessCenters additionalBusinessDays) {
			this.additionalBusinessDays = additionalBusinessDays==null?null:additionalBusinessDays.toBuilder();
			return this;
		}
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder setCalculationBase(ObservationPeriodDatesEnum calculationBase) {
			this.calculationBase = calculationBase==null?null:calculationBase;
			return this;
		}
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder setOffsetDays(Integer offsetDays) {
			this.offsetDays = offsetDays==null?null:offsetDays;
			return this;
		}
		
		@Override
		public ObservationShiftCalculation build() {
			return new ObservationShiftCalculation.ObservationShiftCalculationImpl(this);
		}
		
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder prune() {
			if (additionalBusinessDays!=null && !additionalBusinessDays.prune().hasData()) additionalBusinessDays = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalBusinessDays()!=null && getAdditionalBusinessDays().hasData()) return true;
			if (getCalculationBase()!=null) return true;
			if (getOffsetDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationShiftCalculation.ObservationShiftCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationShiftCalculation.ObservationShiftCalculationBuilder o = (ObservationShiftCalculation.ObservationShiftCalculationBuilder) other;
			
			merger.mergeRosetta(getAdditionalBusinessDays(), o.getAdditionalBusinessDays(), this::setAdditionalBusinessDays);
			
			merger.mergeBasic(getCalculationBase(), o.getCalculationBase(), this::setCalculationBase);
			merger.mergeBasic(getOffsetDays(), o.getOffsetDays(), this::setOffsetDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationShiftCalculation _that = getType().cast(o);
		
			if (!Objects.equals(additionalBusinessDays, _that.getAdditionalBusinessDays())) return false;
			if (!Objects.equals(calculationBase, _that.getCalculationBase())) return false;
			if (!Objects.equals(offsetDays, _that.getOffsetDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalBusinessDays != null ? additionalBusinessDays.hashCode() : 0);
			_result = 31 * _result + (calculationBase != null ? calculationBase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offsetDays != null ? offsetDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationShiftCalculationBuilder {" +
				"additionalBusinessDays=" + this.additionalBusinessDays + ", " +
				"calculationBase=" + this.calculationBase + ", " +
				"offsetDays=" + this.offsetDays +
			'}';
		}
	}
}
