package cdm.product.asset;

import cdm.base.datetime.Offset;
import cdm.base.math.AveragingMethodEnum;
import cdm.base.math.RateSchedule;
import cdm.base.math.Rounding;
import cdm.observable.asset.FallbackRateParameters;
import cdm.observable.asset.FloatingRateCalculationParameters;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.observable.asset.InterpolationMethodEnum;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterpolationMethodEnum.FieldWithMetaInterpolationMethodEnumBuilder;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilder;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilderImpl;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationImpl;
import cdm.product.asset.meta.InflationRateSpecificationMeta;
import cdm.product.template.StrikeSchedule;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data to:  specify the inflation rate.
 * @version ${project.version}
 */
@RosettaClass

public interface InflationRateSpecification extends FloatingRateSpecification {
	InflationRateSpecification build();
	InflationRateSpecification.InflationRateSpecificationBuilder toBuilder();
	
	/**
	 * The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
	 */
	Boolean getFallbackBondApplicable();
	/**
	 * The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
	 */
	FieldWithMetaString getIndexSource();
	/**
	 * An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
	 */
	Offset getInflationLag();
	/**
	 * Initial known index level for the first calculation period.
	 */
	BigDecimal getInitialIndexLevel();
	/**
	 * The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
	 */
	FieldWithMetaInterpolationMethodEnum getInterpolationMethod();
	/**
	 * The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
	 */
	FieldWithMetaString getMainPublication();
	final static InflationRateSpecificationMeta metaData = new InflationRateSpecificationMeta();
	
	@Override
	default RosettaMetaData<? extends InflationRateSpecification> metaData() {
		return metaData;
	} 
			
	static InflationRateSpecification.InflationRateSpecificationBuilder builder() {
		return new InflationRateSpecification.InflationRateSpecificationBuilderImpl();
	}
	
	default Class<? extends InflationRateSpecification> getType() {
		return InflationRateSpecification.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.asset.FloatingRateSpecification.super.process(path, processor);
		processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
		processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
		
		processRosetta(path.newSubPath("indexSource"), processor, FieldWithMetaString.class, getIndexSource());
		processRosetta(path.newSubPath("inflationLag"), processor, Offset.class, getInflationLag());
		processRosetta(path.newSubPath("interpolationMethod"), processor, FieldWithMetaInterpolationMethodEnum.class, getInterpolationMethod());
		processRosetta(path.newSubPath("mainPublication"), processor, FieldWithMetaString.class, getMainPublication());
	}
	
	
	interface InflationRateSpecificationBuilder extends InflationRateSpecification, FloatingRateSpecification.FloatingRateSpecificationBuilder, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIndexSource();
		FieldWithMetaStringBuilder getIndexSource();
		Offset.OffsetBuilder getOrCreateInflationLag();
		Offset.OffsetBuilder getInflationLag();
		FieldWithMetaInterpolationMethodEnumBuilder getOrCreateInterpolationMethod();
		FieldWithMetaInterpolationMethodEnumBuilder getInterpolationMethod();
		FieldWithMetaStringBuilder getOrCreateMainPublication();
		FieldWithMetaStringBuilder getMainPublication();
		InflationRateSpecification.InflationRateSpecificationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable);
		InflationRateSpecification.InflationRateSpecificationBuilder setIndexSource(FieldWithMetaString indexSource);
		InflationRateSpecification.InflationRateSpecificationBuilder setIndexSourceValue(String indexSource);
		InflationRateSpecification.InflationRateSpecificationBuilder setInflationLag(Offset inflationLag);
		InflationRateSpecification.InflationRateSpecificationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel);
		InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethod(FieldWithMetaInterpolationMethodEnum interpolationMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethodValue(InterpolationMethodEnum interpolationMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setMainPublication(FieldWithMetaString mainPublication);
		InflationRateSpecification.InflationRateSpecificationBuilder setMainPublicationValue(String mainPublication);
		InflationRateSpecification.InflationRateSpecificationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		InflationRateSpecification.InflationRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding);
		InflationRateSpecification.InflationRateSpecificationBuilder setInitialRate(Price initialRate);
		InflationRateSpecification.InflationRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);
		InflationRateSpecification.InflationRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx);
		InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate);
		InflationRateSpecification.InflationRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx);
		InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder setMeta(MetaFields meta);
		InflationRateSpecification.InflationRateSpecificationBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption);
		InflationRateSpecification.InflationRateSpecificationBuilder setRateOptionValue(FloatingRateOption rateOption);
		InflationRateSpecification.InflationRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx);
		InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		InflationRateSpecification.InflationRateSpecificationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			FloatingRateSpecification.FloatingRateSpecificationBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
			processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
			
			processRosetta(path.newSubPath("indexSource"), processor, FieldWithMetaStringBuilder.class, getIndexSource());
			processRosetta(path.newSubPath("inflationLag"), processor, Offset.OffsetBuilder.class, getInflationLag());
			processRosetta(path.newSubPath("interpolationMethod"), processor, FieldWithMetaInterpolationMethodEnumBuilder.class, getInterpolationMethod());
			processRosetta(path.newSubPath("mainPublication"), processor, FieldWithMetaStringBuilder.class, getMainPublication());
		}
		
	}
	
	//InflationRateSpecification.InflationRateSpecificationImpl
	class InflationRateSpecificationImpl extends FloatingRateSpecification.FloatingRateSpecificationImpl implements InflationRateSpecification {
		private final Boolean fallbackBondApplicable;
		private final FieldWithMetaString indexSource;
		private final Offset inflationLag;
		private final BigDecimal initialIndexLevel;
		private final FieldWithMetaInterpolationMethodEnum interpolationMethod;
		private final FieldWithMetaString mainPublication;
		
		protected InflationRateSpecificationImpl(InflationRateSpecification.InflationRateSpecificationBuilder builder) {
			super(builder);
			this.fallbackBondApplicable = builder.getFallbackBondApplicable();
			this.indexSource = ofNullable(builder.getIndexSource()).map(f->f.build()).orElse(null);
			this.inflationLag = ofNullable(builder.getInflationLag()).map(f->f.build()).orElse(null);
			this.initialIndexLevel = builder.getInitialIndexLevel();
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.mainPublication = ofNullable(builder.getMainPublication()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		public FieldWithMetaString getIndexSource() {
			return indexSource;
		}
		
		@Override
		public Offset getInflationLag() {
			return inflationLag;
		}
		
		@Override
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public FieldWithMetaString getMainPublication() {
			return mainPublication;
		}
		
		@Override
		public InflationRateSpecification build() {
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder toBuilder() {
			InflationRateSpecification.InflationRateSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRateSpecification.InflationRateSpecificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFallbackBondApplicable()).ifPresent(builder::setFallbackBondApplicable);
			ofNullable(getIndexSource()).ifPresent(builder::setIndexSource);
			ofNullable(getInflationLag()).ifPresent(builder::setInflationLag);
			ofNullable(getInitialIndexLevel()).ifPresent(builder::setInitialIndexLevel);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getMainPublication()).ifPresent(builder::setMainPublication);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateSpecification {" +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"indexSource=" + this.indexSource + ", " +
				"inflationLag=" + this.inflationLag + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"mainPublication=" + this.mainPublication +
			'}' + " " + super.toString();
		}
	}
	
	//InflationRateSpecification.InflationRateSpecificationBuilderImpl
	class InflationRateSpecificationBuilderImpl extends FloatingRateSpecification.FloatingRateSpecificationBuilderImpl  implements InflationRateSpecification.InflationRateSpecificationBuilder {
	
		protected Boolean fallbackBondApplicable;
		protected FieldWithMetaStringBuilder indexSource;
		protected Offset.OffsetBuilder inflationLag;
		protected BigDecimal initialIndexLevel;
		protected FieldWithMetaInterpolationMethodEnumBuilder interpolationMethod;
		protected FieldWithMetaStringBuilder mainPublication;
	
		public InflationRateSpecificationBuilderImpl() {
		}
	
		@Override
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		public FieldWithMetaStringBuilder getIndexSource() {
			return indexSource;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIndexSource() {
			FieldWithMetaStringBuilder result;
			if (indexSource!=null) {
				result = indexSource;
			}
			else {
				result = indexSource = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Offset.OffsetBuilder getInflationLag() {
			return inflationLag;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateInflationLag() {
			Offset.OffsetBuilder result;
			if (inflationLag!=null) {
				result = inflationLag;
			}
			else {
				result = inflationLag = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnumBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public FieldWithMetaInterpolationMethodEnumBuilder getOrCreateInterpolationMethod() {
			FieldWithMetaInterpolationMethodEnumBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = FieldWithMetaInterpolationMethodEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getMainPublication() {
			return mainPublication;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateMainPublication() {
			FieldWithMetaStringBuilder result;
			if (mainPublication!=null) {
				result = mainPublication;
			}
			else {
				result = mainPublication = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable) {
			this.fallbackBondApplicable = fallbackBondApplicable==null?null:fallbackBondApplicable;
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setIndexSource(FieldWithMetaString indexSource) {
			this.indexSource = indexSource==null?null:indexSource.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setIndexSourceValue(String indexSource) {
			this.getOrCreateIndexSource().setValue(indexSource);
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInflationLag(Offset inflationLag) {
			this.inflationLag = inflationLag==null?null:inflationLag.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel) {
			this.initialIndexLevel = initialIndexLevel==null?null:initialIndexLevel;
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethod(FieldWithMetaInterpolationMethodEnum interpolationMethod) {
			this.interpolationMethod = interpolationMethod==null?null:interpolationMethod.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInterpolationMethodValue(InterpolationMethodEnum interpolationMethod) {
			this.getOrCreateInterpolationMethod().setValue(interpolationMethod);
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setMainPublication(FieldWithMetaString mainPublication) {
			this.mainPublication = mainPublication==null?null:mainPublication.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setMainPublicationValue(String mainPublication) {
			this.getOrCreateMainPublication().setValue(mainPublication);
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setFinalRateRounding(Rounding finalRateRounding) {
			this.finalRateRounding = finalRateRounding==null?null:finalRateRounding.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setInitialRate(Price initialRate) {
			this.initialRate = initialRate==null?null:initialRate.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = negativeInterestRateTreatment==null?null:negativeInterestRateTreatment;
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters) {
			this.calculationParameters = calculationParameters==null?null:calculationParameters.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public InflationRateSpecification.InflationRateSpecificationBuilder setFallbackRate(FallbackRateParameters fallbackRate) {
			this.fallbackRate = fallbackRate==null?null:fallbackRate.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public InflationRateSpecification.InflationRateSpecificationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption) {
			this.rateOption = rateOption==null?null:rateOption.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateOptionValue(FloatingRateOption rateOption) {
			this.getOrCreateRateOption().setValue(rateOption);
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateSpecification.InflationRateSpecificationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public InflationRateSpecification build() {
			return new InflationRateSpecification.InflationRateSpecificationImpl(this);
		}
		
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder prune() {
			super.prune();
			if (indexSource!=null && !indexSource.prune().hasData()) indexSource = null;
			if (inflationLag!=null && !inflationLag.prune().hasData()) inflationLag = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			if (mainPublication!=null && !mainPublication.prune().hasData()) mainPublication = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFallbackBondApplicable()!=null) return true;
			if (getIndexSource()!=null) return true;
			if (getInflationLag()!=null && getInflationLag().hasData()) return true;
			if (getInitialIndexLevel()!=null) return true;
			if (getInterpolationMethod()!=null) return true;
			if (getMainPublication()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateSpecification.InflationRateSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InflationRateSpecification.InflationRateSpecificationBuilder o = (InflationRateSpecification.InflationRateSpecificationBuilder) other;
			
			merger.mergeRosetta(getIndexSource(), o.getIndexSource(), this::setIndexSource);
			merger.mergeRosetta(getInflationLag(), o.getInflationLag(), this::setInflationLag);
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			merger.mergeRosetta(getMainPublication(), o.getMainPublication(), this::setMainPublication);
			
			merger.mergeBasic(getFallbackBondApplicable(), o.getFallbackBondApplicable(), this::setFallbackBondApplicable);
			merger.mergeBasic(getInitialIndexLevel(), o.getInitialIndexLevel(), this::setInitialIndexLevel);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateSpecification _that = getType().cast(o);
		
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateSpecificationBuilder {" +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"indexSource=" + this.indexSource + ", " +
				"inflationLag=" + this.inflationLag + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"mainPublication=" + this.mainPublication +
			'}' + " " + super.toString();
		}
	}
}
