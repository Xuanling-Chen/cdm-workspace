package cdm.product.asset;

import cdm.base.math.AveragingMethodEnum;
import cdm.base.math.RateSchedule;
import cdm.base.math.Rounding;
import cdm.observable.asset.FallbackRateParameters;
import cdm.observable.asset.FloatingRateCalculationParameters;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption;
import cdm.product.asset.FloatingRate.FloatingRateBuilder;
import cdm.product.asset.FloatingRate.FloatingRateBuilderImpl;
import cdm.product.asset.FloatingRate.FloatingRateImpl;
import cdm.product.asset.meta.FloatingRateSpecificationMeta;
import cdm.product.template.StrikeSchedule;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the floating interest rate by extending the floating rate definition with a set of attributes that specify such rate: the initial value specified as part of the trade, the rounding convention, the averaging method and the negative interest rate treatment.
 * @version ${project.version}
 */
@RosettaClass

public interface FloatingRateSpecification extends FloatingRate {
	FloatingRateSpecification build();
	FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder();
	
	/**
	 * If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 * The rounding convention to apply to the final rate used in determination of a calculation period amount.
	 */
	Rounding getFinalRateRounding();
	/**
	 * The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
	 */
	Price getInitialRate();
	/**
	 * The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
	 */
	NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment();
	final static FloatingRateSpecificationMeta metaData = new FloatingRateSpecificationMeta();
	
	@Override
	default RosettaMetaData<? extends FloatingRateSpecification> metaData() {
		return metaData;
	} 
			
	static FloatingRateSpecification.FloatingRateSpecificationBuilder builder() {
		return new FloatingRateSpecification.FloatingRateSpecificationBuilderImpl();
	}
	
	default Class<? extends FloatingRateSpecification> getType() {
		return FloatingRateSpecification.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.asset.FloatingRate.super.process(path, processor);
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
		
		processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.class, getFinalRateRounding());
		processRosetta(path.newSubPath("initialRate"), processor, Price.class, getInitialRate());
	}
	
	
	interface FloatingRateSpecificationBuilder extends FloatingRateSpecification, FloatingRate.FloatingRateBuilder, RosettaModelObjectBuilder {
		Rounding.RoundingBuilder getOrCreateFinalRateRounding();
		Rounding.RoundingBuilder getFinalRateRounding();
		Price.PriceBuilder getOrCreateInitialRate();
		Price.PriceBuilder getInitialRate();
		FloatingRateSpecification.FloatingRateSpecificationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setInitialRate(Price initialRate);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setMeta(MetaFields meta);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOptionValue(FloatingRateOption rateOption);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx);
		FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		FloatingRateSpecification.FloatingRateSpecificationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			FloatingRate.FloatingRateBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
			
			processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.RoundingBuilder.class, getFinalRateRounding());
			processRosetta(path.newSubPath("initialRate"), processor, Price.PriceBuilder.class, getInitialRate());
		}
		
	}
	
	//FloatingRateSpecification.FloatingRateSpecificationImpl
	class FloatingRateSpecificationImpl extends FloatingRate.FloatingRateImpl implements FloatingRateSpecification {
		private final AveragingMethodEnum averagingMethod;
		private final Rounding finalRateRounding;
		private final Price initialRate;
		private final NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		protected FloatingRateSpecificationImpl(FloatingRateSpecification.FloatingRateSpecificationBuilder builder) {
			super(builder);
			this.averagingMethod = builder.getAveragingMethod();
			this.finalRateRounding = ofNullable(builder.getFinalRateRounding()).map(f->f.build()).orElse(null);
			this.initialRate = ofNullable(builder.getInitialRate()).map(f->f.build()).orElse(null);
			this.negativeInterestRateTreatment = builder.getNegativeInterestRateTreatment();
		}
		
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public Rounding getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		public Price getInitialRate() {
			return initialRate;
		}
		
		@Override
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		public FloatingRateSpecification build() {
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder() {
			FloatingRateSpecification.FloatingRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateSpecification.FloatingRateSpecificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getFinalRateRounding()).ifPresent(builder::setFinalRateRounding);
			ofNullable(getInitialRate()).ifPresent(builder::setInitialRate);
			ofNullable(getNegativeInterestRateTreatment()).ifPresent(builder::setNegativeInterestRateTreatment);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSpecification {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"initialRate=" + this.initialRate + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
	
	//FloatingRateSpecification.FloatingRateSpecificationBuilderImpl
	class FloatingRateSpecificationBuilderImpl extends FloatingRate.FloatingRateBuilderImpl  implements FloatingRateSpecification.FloatingRateSpecificationBuilder {
	
		protected AveragingMethodEnum averagingMethod;
		protected Rounding.RoundingBuilder finalRateRounding;
		protected Price.PriceBuilder initialRate;
		protected NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
	
		public FloatingRateSpecificationBuilderImpl() {
		}
	
		@Override
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public Rounding.RoundingBuilder getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateFinalRateRounding() {
			Rounding.RoundingBuilder result;
			if (finalRateRounding!=null) {
				result = finalRateRounding;
			}
			else {
				result = finalRateRounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		public Price.PriceBuilder getInitialRate() {
			return initialRate;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateInitialRate() {
			Price.PriceBuilder result;
			if (initialRate!=null) {
				result = initialRate;
			}
			else {
				result = initialRate = Price.builder();
			}
			
			return result;
		}
		
		@Override
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
	
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding) {
			this.finalRateRounding = finalRateRounding==null?null:finalRateRounding.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setInitialRate(Price initialRate) {
			this.initialRate = initialRate==null?null:initialRate.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = negativeInterestRateTreatment==null?null:negativeInterestRateTreatment;
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters) {
			this.calculationParameters = calculationParameters==null?null:calculationParameters.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules == null)  {
				this.capRateSchedule = new ArrayList<>();
			}
			else {
				this.capRateSchedule = capRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate) {
			this.fallbackRate = fallbackRate==null?null:fallbackRate.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null)  {
				this.floorRateSchedule = new ArrayList<>();
			}
			else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption) {
			this.rateOption = rateOption==null?null:rateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateOptionValue(FloatingRateOption rateOption) {
			this.getOrCreateRateOption().setValue(rateOption);
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateSpecification.FloatingRateSpecificationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null)  {
				this.spreadSchedule = new ArrayList<>();
			}
			else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FloatingRateSpecification build() {
			return new FloatingRateSpecification.FloatingRateSpecificationImpl(this);
		}
		
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder prune() {
			super.prune();
			if (finalRateRounding!=null && !finalRateRounding.prune().hasData()) finalRateRounding = null;
			if (initialRate!=null && !initialRate.prune().hasData()) initialRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getFinalRateRounding()!=null && getFinalRateRounding().hasData()) return true;
			if (getInitialRate()!=null && getInitialRate().hasData()) return true;
			if (getNegativeInterestRateTreatment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateSpecification.FloatingRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateSpecification.FloatingRateSpecificationBuilder o = (FloatingRateSpecification.FloatingRateSpecificationBuilder) other;
			
			merger.mergeRosetta(getFinalRateRounding(), o.getFinalRateRounding(), this::setFinalRateRounding);
			merger.mergeRosetta(getInitialRate(), o.getInitialRate(), this::setInitialRate);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getNegativeInterestRateTreatment(), o.getNegativeInterestRateTreatment(), this::setNegativeInterestRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateSpecificationBuilder {" +
				"averagingMethod=" + this.averagingMethod + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"initialRate=" + this.initialRate + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
}
