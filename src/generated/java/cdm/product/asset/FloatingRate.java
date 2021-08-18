package cdm.product.asset;

import cdm.base.math.RateSchedule;
import cdm.observable.asset.FallbackRateParameters;
import cdm.observable.asset.FloatingRateCalculationParameters;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption.ReferenceWithMetaFloatingRateOptionBuilder;
import cdm.product.asset.meta.FloatingRateMeta;
import cdm.product.template.StrikeSchedule;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining a floating interest rate through the specification of the floating rate index, the tenor, the multiplier schedule, the spread, the qualification of whether a specific rate treatment and/or a cap or floor apply.
 * @version ${project.version}
 */
@RosettaClass

public interface FloatingRate extends RosettaModelObject, GlobalKey {
	FloatingRate build();
	FloatingRate.FloatingRateBuilder toBuilder();
	
	/**
	 *  Support for modular calculated rates, such such as lockout compound calculations.  
	 */
	FloatingRateCalculationParameters getCalculationParameters();
	/**
	 * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getCapRateSchedule();
	/**
	 *  definition of any fallback rate that may be applicalble 
	 */
	FallbackRateParameters getFallbackRate();
	/**
	 * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 */
	RateSchedule getFloatingRateMultiplierSchedule();
	/**
	 * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getFloorRateSchedule();
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	ReferenceWithMetaFloatingRateOption getRateOption();
	/**
	 * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 */
	RateTreatmentEnum getRateTreatment();
	/**
	 * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();
	final static FloatingRateMeta metaData = new FloatingRateMeta();
	
	@Override
	default RosettaMetaData<? extends FloatingRate> metaData() {
		return metaData;
	} 
			
	static FloatingRate.FloatingRateBuilder builder() {
		return new FloatingRate.FloatingRateBuilderImpl();
	}
	
	default Class<? extends FloatingRate> getType() {
		return FloatingRate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		
		processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.class, getCalculationParameters());
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRateParameters.class, getFallbackRate());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, RateSchedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaFloatingRateOption.class, getRateOption());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
	}
	
	
	interface FloatingRateBuilder extends FloatingRate, RosettaModelObjectBuilder {
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters();
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule();
		FallbackRateParameters.FallbackRateParametersBuilder getOrCreateFallbackRate();
		FallbackRateParameters.FallbackRateParametersBuilder getFallbackRate();
		RateSchedule.RateScheduleBuilder getOrCreateFloatingRateMultiplierSchedule();
		RateSchedule.RateScheduleBuilder getFloatingRateMultiplierSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ReferenceWithMetaFloatingRateOptionBuilder getOrCreateRateOption();
		ReferenceWithMetaFloatingRateOptionBuilder getRateOption();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index);
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		FloatingRate.FloatingRateBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		FloatingRate.FloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		FloatingRate.FloatingRateBuilder setFallbackRate(FallbackRateParameters fallbackRate);
		FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		FloatingRate.FloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		FloatingRate.FloatingRateBuilder setMeta(MetaFields meta);
		FloatingRate.FloatingRateBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption);
		FloatingRate.FloatingRateBuilder setRateOptionValue(FloatingRateOption rateOption);
		FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		FloatingRate.FloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			
			processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder.class, getCalculationParameters());
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRateParameters.FallbackRateParametersBuilder.class, getFallbackRate());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, RateSchedule.RateScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("rateOption"), processor, ReferenceWithMetaFloatingRateOptionBuilder.class, getRateOption());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
		}
		
	}
	
	//FloatingRate.FloatingRateImpl
	class FloatingRateImpl implements FloatingRate {
		private final FloatingRateCalculationParameters calculationParameters;
		private final List<? extends StrikeSchedule> capRateSchedule;
		private final FallbackRateParameters fallbackRate;
		private final RateSchedule floatingRateMultiplierSchedule;
		private final List<? extends StrikeSchedule> floorRateSchedule;
		private final MetaFields meta;
		private final ReferenceWithMetaFloatingRateOption rateOption;
		private final RateTreatmentEnum rateTreatment;
		private final List<? extends SpreadSchedule> spreadSchedule;
		
		protected FloatingRateImpl(FloatingRate.FloatingRateBuilder builder) {
			this.calculationParameters = ofNullable(builder.getCalculationParameters()).map(f->f.build()).orElse(null);
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fallbackRate = ofNullable(builder.getFallbackRate()).map(f->f.build()).orElse(null);
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.rateOption = ofNullable(builder.getRateOption()).map(f->f.build()).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public FloatingRateCalculationParameters getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public List<? extends StrikeSchedule> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		public FallbackRateParameters getFallbackRate() {
			return fallbackRate;
		}
		
		@Override
		public RateSchedule getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public List<? extends StrikeSchedule> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ReferenceWithMetaFloatingRateOption getRateOption() {
			return rateOption;
		}
		
		@Override
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		public List<? extends SpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public FloatingRate build() {
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			FloatingRate.FloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate.FloatingRateBuilder builder) {
			ofNullable(getCalculationParameters()).ifPresent(builder::setCalculationParameters);
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFallbackRate()).ifPresent(builder::setFallbackRate);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getRateOption()).ifPresent(builder::setRateOption);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate {" +
				"calculationParameters=" + this.calculationParameters + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"fallbackRate=" + this.fallbackRate + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"meta=" + this.meta + ", " +
				"rateOption=" + this.rateOption + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}';
		}
	}
	
	//FloatingRate.FloatingRateBuilderImpl
	class FloatingRateBuilderImpl implements FloatingRate.FloatingRateBuilder, GlobalKeyBuilder {
	
		protected FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder calculationParameters;
		protected List<StrikeSchedule.StrikeScheduleBuilder> capRateSchedule = new ArrayList<>();
		protected FallbackRateParameters.FallbackRateParametersBuilder fallbackRate;
		protected RateSchedule.RateScheduleBuilder floatingRateMultiplierSchedule;
		protected List<StrikeSchedule.StrikeScheduleBuilder> floorRateSchedule = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected ReferenceWithMetaFloatingRateOptionBuilder rateOption;
		protected RateTreatmentEnum rateTreatment;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
	
		public FloatingRateBuilderImpl() {
		}
	
		@Override
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters() {
			FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder result;
			if (calculationParameters!=null) {
				result = calculationParameters;
			}
			else {
				result = calculationParameters = FloatingRateCalculationParameters.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int _index) {
		
			if (capRateSchedule==null) {
				this.capRateSchedule = new ArrayList<>();
			}
			StrikeSchedule.StrikeScheduleBuilder result;
			return getIndex(capRateSchedule, _index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newCapRateSchedule = StrikeSchedule.builder();
						return newCapRateSchedule;
					});
		}
		
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder getFallbackRate() {
			return fallbackRate;
		}
		
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder getOrCreateFallbackRate() {
			FallbackRateParameters.FallbackRateParametersBuilder result;
			if (fallbackRate!=null) {
				result = fallbackRate;
			}
			else {
				result = fallbackRate = FallbackRateParameters.builder();
			}
			
			return result;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public RateSchedule.RateScheduleBuilder getOrCreateFloatingRateMultiplierSchedule() {
			RateSchedule.RateScheduleBuilder result;
			if (floatingRateMultiplierSchedule!=null) {
				result = floatingRateMultiplierSchedule;
			}
			else {
				result = floatingRateMultiplierSchedule = RateSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int _index) {
		
			if (floorRateSchedule==null) {
				this.floorRateSchedule = new ArrayList<>();
			}
			StrikeSchedule.StrikeScheduleBuilder result;
			return getIndex(floorRateSchedule, _index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newFloorRateSchedule = StrikeSchedule.builder();
						return newFloorRateSchedule;
					});
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
		public ReferenceWithMetaFloatingRateOptionBuilder getRateOption() {
			return rateOption;
		}
		
		@Override
		public ReferenceWithMetaFloatingRateOptionBuilder getOrCreateRateOption() {
			ReferenceWithMetaFloatingRateOptionBuilder result;
			if (rateOption!=null) {
				result = rateOption;
			}
			else {
				result = rateOption = ReferenceWithMetaFloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		public List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index) {
		
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			SpreadSchedule.SpreadScheduleBuilder result;
			return getIndex(spreadSchedule, _index, () -> {
						SpreadSchedule.SpreadScheduleBuilder newSpreadSchedule = SpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
	
		@Override
		public FloatingRate.FloatingRateBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters) {
			this.calculationParameters = calculationParameters==null?null:calculationParameters.toBuilder();
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRate.FloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public FloatingRate.FloatingRateBuilder setFallbackRate(FallbackRateParameters fallbackRate) {
			this.fallbackRate = fallbackRate==null?null:fallbackRate.toBuilder();
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(RateSchedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRate.FloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public FloatingRate.FloatingRateBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder setRateOption(ReferenceWithMetaFloatingRateOption rateOption) {
			this.rateOption = rateOption==null?null:rateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder setRateOptionValue(FloatingRateOption rateOption) {
			this.getOrCreateRateOption().setValue(rateOption);
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRate.FloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public FloatingRate build() {
			return new FloatingRate.FloatingRateImpl(this);
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder prune() {
			if (calculationParameters!=null && !calculationParameters.prune().hasData()) calculationParameters = null;
			capRateSchedule = capRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fallbackRate!=null && !fallbackRate.prune().hasData()) fallbackRate = null;
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			floorRateSchedule = floorRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (rateOption!=null && !rateOption.prune().hasData()) rateOption = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationParameters()!=null && getCalculationParameters().hasData()) return true;
			if (getCapRateSchedule()!=null && getCapRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFallbackRate()!=null && getFallbackRate().hasData()) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateOption()!=null && getRateOption().hasData()) return true;
			if (getRateTreatment()!=null) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRate.FloatingRateBuilder o = (FloatingRate.FloatingRateBuilder) other;
			
			merger.mergeRosetta(getCalculationParameters(), o.getCalculationParameters(), this::setCalculationParameters);
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::getOrCreateCapRateSchedule);
			merger.mergeRosetta(getFallbackRate(), o.getFallbackRate(), this::setFallbackRate);
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::getOrCreateFloorRateSchedule);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRateOption(), o.getRateOption(), this::setRateOption);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(rateOption, _that.getRateOption())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (rateOption != null ? rateOption.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateBuilder {" +
				"calculationParameters=" + this.calculationParameters + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"fallbackRate=" + this.fallbackRate + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"meta=" + this.meta + ", " +
				"rateOption=" + this.rateOption + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}';
		}
	}
}
