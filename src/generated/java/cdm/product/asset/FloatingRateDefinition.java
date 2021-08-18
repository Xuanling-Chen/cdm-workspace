package cdm.product.asset;

import cdm.observable.asset.RateObservation;
import cdm.product.asset.meta.FloatingRateDefinitionMeta;
import cdm.product.template.Strike;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  parameters associated with a floating rate reset. This data forms:  part of the cashflows representation of a stream.
 * @version ${project.version}
 */
@RosettaClass

public interface FloatingRateDefinition extends RosettaModelObject {
	FloatingRateDefinition build();
	FloatingRateDefinition.FloatingRateDefinitionBuilder toBuilder();
	
	/**
	 * The final calculated rate for a calculation period after any required averaging of rates A calculated rate of 5% would be represented as 0.05.
	 */
	BigDecimal getCalculatedRate();
	/**
	 * The cap rate, if any, which applies to the floating rate for the calculation period. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain strike level. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 */
	List<? extends Strike> getCapRate();
	/**
	 * A rate multiplier to apply to the floating rate. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one).
	 */
	BigDecimal getFloatingRateMultiplier();
	/**
	 * The floor rate, if any, which applies to the floating rate for the calculation period. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. The floor rate of 5% would be represented as 0.05.
	 */
	List<? extends Strike> getFloorRate();
	/**
	 * The details of a particular rate observation, including the fixing date and observed rate. A list of rate observation elements may be ordered in the document by ascending adjusted fixing date. An FpML document containing an unordered list of rate observations is still regarded as a conformant document.
	 */
	List<? extends RateObservation> getRateObservation();
	/**
	 * The ISDA Spread, if any, which applies for the calculation period. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	BigDecimal getSpread();
	final static FloatingRateDefinitionMeta metaData = new FloatingRateDefinitionMeta();
	
	@Override
	default RosettaMetaData<? extends FloatingRateDefinition> metaData() {
		return metaData;
	} 
			
	static FloatingRateDefinition.FloatingRateDefinitionBuilder builder() {
		return new FloatingRateDefinition.FloatingRateDefinitionBuilderImpl();
	}
	
	default Class<? extends FloatingRateDefinition> getType() {
		return FloatingRateDefinition.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculatedRate"), BigDecimal.class, getCalculatedRate(), this);
		processor.processBasic(path.newSubPath("floatingRateMultiplier"), BigDecimal.class, getFloatingRateMultiplier(), this);
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		
		processRosetta(path.newSubPath("capRate"), processor, Strike.class, getCapRate());
		processRosetta(path.newSubPath("floorRate"), processor, Strike.class, getFloorRate());
		processRosetta(path.newSubPath("rateObservation"), processor, RateObservation.class, getRateObservation());
	}
	
	
	interface FloatingRateDefinitionBuilder extends FloatingRateDefinition, RosettaModelObjectBuilder {
		Strike.StrikeBuilder getOrCreateCapRate(int _index);
		List<? extends Strike.StrikeBuilder> getCapRate();
		Strike.StrikeBuilder getOrCreateFloorRate(int _index);
		List<? extends Strike.StrikeBuilder> getFloorRate();
		RateObservation.RateObservationBuilder getOrCreateRateObservation(int _index);
		List<? extends RateObservation.RateObservationBuilder> getRateObservation();
		FloatingRateDefinition.FloatingRateDefinitionBuilder setCalculatedRate(BigDecimal calculatedRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(Strike capRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(Strike capRate, int _idx);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(List<? extends Strike> capRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder setCapRate(List<? extends Strike> capRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder setFloatingRateMultiplier(BigDecimal floatingRateMultiplier);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(Strike floorRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(Strike floorRate, int _idx);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(List<? extends Strike> floorRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder setFloorRate(List<? extends Strike> floorRate);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(RateObservation rateObservation);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(RateObservation rateObservation, int _idx);
		FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(List<? extends RateObservation> rateObservation);
		FloatingRateDefinition.FloatingRateDefinitionBuilder setRateObservation(List<? extends RateObservation> rateObservation);
		FloatingRateDefinition.FloatingRateDefinitionBuilder setSpread(BigDecimal spread);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculatedRate"), BigDecimal.class, getCalculatedRate(), this);
			processor.processBasic(path.newSubPath("floatingRateMultiplier"), BigDecimal.class, getFloatingRateMultiplier(), this);
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			
			processRosetta(path.newSubPath("capRate"), processor, Strike.StrikeBuilder.class, getCapRate());
			processRosetta(path.newSubPath("floorRate"), processor, Strike.StrikeBuilder.class, getFloorRate());
			processRosetta(path.newSubPath("rateObservation"), processor, RateObservation.RateObservationBuilder.class, getRateObservation());
		}
		
	}
	
	//FloatingRateDefinition.FloatingRateDefinitionImpl
	class FloatingRateDefinitionImpl implements FloatingRateDefinition {
		private final BigDecimal calculatedRate;
		private final List<? extends Strike> capRate;
		private final BigDecimal floatingRateMultiplier;
		private final List<? extends Strike> floorRate;
		private final List<? extends RateObservation> rateObservation;
		private final BigDecimal spread;
		
		protected FloatingRateDefinitionImpl(FloatingRateDefinition.FloatingRateDefinitionBuilder builder) {
			this.calculatedRate = builder.getCalculatedRate();
			this.capRate = ofNullable(builder.getCapRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floatingRateMultiplier = builder.getFloatingRateMultiplier();
			this.floorRate = ofNullable(builder.getFloorRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateObservation = ofNullable(builder.getRateObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spread = builder.getSpread();
		}
		
		@Override
		public BigDecimal getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		public List<? extends Strike> getCapRate() {
			return capRate;
		}
		
		@Override
		public BigDecimal getFloatingRateMultiplier() {
			return floatingRateMultiplier;
		}
		
		@Override
		public List<? extends Strike> getFloorRate() {
			return floorRate;
		}
		
		@Override
		public List<? extends RateObservation> getRateObservation() {
			return rateObservation;
		}
		
		@Override
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		public FloatingRateDefinition build() {
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder toBuilder() {
			FloatingRateDefinition.FloatingRateDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateDefinition.FloatingRateDefinitionBuilder builder) {
			ofNullable(getCalculatedRate()).ifPresent(builder::setCalculatedRate);
			ofNullable(getCapRate()).ifPresent(builder::setCapRate);
			ofNullable(getFloatingRateMultiplier()).ifPresent(builder::setFloatingRateMultiplier);
			ofNullable(getFloorRate()).ifPresent(builder::setFloorRate);
			ofNullable(getRateObservation()).ifPresent(builder::setRateObservation);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateDefinition _that = getType().cast(o);
		
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			if (!ListEquals.listEquals(capRate, _that.getCapRate())) return false;
			if (!Objects.equals(floatingRateMultiplier, _that.getFloatingRateMultiplier())) return false;
			if (!ListEquals.listEquals(floorRate, _that.getFloorRate())) return false;
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			_result = 31 * _result + (capRate != null ? capRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplier != null ? floatingRateMultiplier.hashCode() : 0);
			_result = 31 * _result + (floorRate != null ? floorRate.hashCode() : 0);
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateDefinition {" +
				"calculatedRate=" + this.calculatedRate + ", " +
				"capRate=" + this.capRate + ", " +
				"floatingRateMultiplier=" + this.floatingRateMultiplier + ", " +
				"floorRate=" + this.floorRate + ", " +
				"rateObservation=" + this.rateObservation + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
	
	//FloatingRateDefinition.FloatingRateDefinitionBuilderImpl
	class FloatingRateDefinitionBuilderImpl implements FloatingRateDefinition.FloatingRateDefinitionBuilder {
	
		protected BigDecimal calculatedRate;
		protected List<Strike.StrikeBuilder> capRate = new ArrayList<>();
		protected BigDecimal floatingRateMultiplier;
		protected List<Strike.StrikeBuilder> floorRate = new ArrayList<>();
		protected List<RateObservation.RateObservationBuilder> rateObservation = new ArrayList<>();
		protected BigDecimal spread;
	
		public FloatingRateDefinitionBuilderImpl() {
		}
	
		@Override
		public BigDecimal getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		public List<? extends Strike.StrikeBuilder> getCapRate() {
			return capRate;
		}
		
		public Strike.StrikeBuilder getOrCreateCapRate(int _index) {
		
			if (capRate==null) {
				this.capRate = new ArrayList<>();
			}
			Strike.StrikeBuilder result;
			return getIndex(capRate, _index, () -> {
						Strike.StrikeBuilder newCapRate = Strike.builder();
						return newCapRate;
					});
		}
		
		@Override
		public BigDecimal getFloatingRateMultiplier() {
			return floatingRateMultiplier;
		}
		
		@Override
		public List<? extends Strike.StrikeBuilder> getFloorRate() {
			return floorRate;
		}
		
		public Strike.StrikeBuilder getOrCreateFloorRate(int _index) {
		
			if (floorRate==null) {
				this.floorRate = new ArrayList<>();
			}
			Strike.StrikeBuilder result;
			return getIndex(floorRate, _index, () -> {
						Strike.StrikeBuilder newFloorRate = Strike.builder();
						return newFloorRate;
					});
		}
		
		@Override
		public List<? extends RateObservation.RateObservationBuilder> getRateObservation() {
			return rateObservation;
		}
		
		public RateObservation.RateObservationBuilder getOrCreateRateObservation(int _index) {
		
			if (rateObservation==null) {
				this.rateObservation = new ArrayList<>();
			}
			RateObservation.RateObservationBuilder result;
			return getIndex(rateObservation, _index, () -> {
						RateObservation.RateObservationBuilder newRateObservation = RateObservation.builder();
						return newRateObservation;
					});
		}
		
		@Override
		public BigDecimal getSpread() {
			return spread;
		}
		
	
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setCalculatedRate(BigDecimal calculatedRate) {
			this.calculatedRate = calculatedRate==null?null:calculatedRate;
			return this;
		}
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(Strike capRate) {
			if (capRate!=null) this.capRate.add(capRate.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(Strike capRate, int _idx) {
			getIndex(this.capRate, _idx, () -> capRate.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addCapRate(List<? extends Strike> capRates) {
			if (capRates != null) {
				for (Strike toAdd : capRates) {
					this.capRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setCapRate(List<? extends Strike> capRates) {
			if (capRates == null)  {
				this.capRate = new ArrayList<>();
			}
			else {
				this.capRate = capRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setFloatingRateMultiplier(BigDecimal floatingRateMultiplier) {
			this.floatingRateMultiplier = floatingRateMultiplier==null?null:floatingRateMultiplier;
			return this;
		}
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(Strike floorRate) {
			if (floorRate!=null) this.floorRate.add(floorRate.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(Strike floorRate, int _idx) {
			getIndex(this.floorRate, _idx, () -> floorRate.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addFloorRate(List<? extends Strike> floorRates) {
			if (floorRates != null) {
				for (Strike toAdd : floorRates) {
					this.floorRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setFloorRate(List<? extends Strike> floorRates) {
			if (floorRates == null)  {
				this.floorRate = new ArrayList<>();
			}
			else {
				this.floorRate = floorRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(RateObservation rateObservation) {
			if (rateObservation!=null) this.rateObservation.add(rateObservation.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(RateObservation rateObservation, int _idx) {
			getIndex(this.rateObservation, _idx, () -> rateObservation.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder addRateObservation(List<? extends RateObservation> rateObservations) {
			if (rateObservations != null) {
				for (RateObservation toAdd : rateObservations) {
					this.rateObservation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setRateObservation(List<? extends RateObservation> rateObservations) {
			if (rateObservations == null)  {
				this.rateObservation = new ArrayList<>();
			}
			else {
				this.rateObservation = rateObservations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		
		@Override
		public FloatingRateDefinition build() {
			return new FloatingRateDefinition.FloatingRateDefinitionImpl(this);
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder prune() {
			capRate = capRate.stream().filter(b->b!=null).<Strike.StrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			floorRate = floorRate.stream().filter(b->b!=null).<Strike.StrikeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rateObservation = rateObservation.stream().filter(b->b!=null).<RateObservation.RateObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculatedRate()!=null) return true;
			if (getCapRate()!=null && getCapRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloatingRateMultiplier()!=null) return true;
			if (getFloorRate()!=null && getFloorRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateObservation()!=null && getRateObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateDefinition.FloatingRateDefinitionBuilder o = (FloatingRateDefinition.FloatingRateDefinitionBuilder) other;
			
			merger.mergeRosetta(getCapRate(), o.getCapRate(), this::getOrCreateCapRate);
			merger.mergeRosetta(getFloorRate(), o.getFloorRate(), this::getOrCreateFloorRate);
			merger.mergeRosetta(getRateObservation(), o.getRateObservation(), this::getOrCreateRateObservation);
			
			merger.mergeBasic(getCalculatedRate(), o.getCalculatedRate(), this::setCalculatedRate);
			merger.mergeBasic(getFloatingRateMultiplier(), o.getFloatingRateMultiplier(), this::setFloatingRateMultiplier);
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateDefinition _that = getType().cast(o);
		
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			if (!ListEquals.listEquals(capRate, _that.getCapRate())) return false;
			if (!Objects.equals(floatingRateMultiplier, _that.getFloatingRateMultiplier())) return false;
			if (!ListEquals.listEquals(floorRate, _that.getFloorRate())) return false;
			if (!ListEquals.listEquals(rateObservation, _that.getRateObservation())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			_result = 31 * _result + (capRate != null ? capRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplier != null ? floatingRateMultiplier.hashCode() : 0);
			_result = 31 * _result + (floorRate != null ? floorRate.hashCode() : 0);
			_result = 31 * _result + (rateObservation != null ? rateObservation.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateDefinitionBuilder {" +
				"calculatedRate=" + this.calculatedRate + ", " +
				"capRate=" + this.capRate + ", " +
				"floatingRateMultiplier=" + this.floatingRateMultiplier + ", " +
				"floorRate=" + this.floorRate + ", " +
				"rateObservation=" + this.rateObservation + ", " +
				"spread=" + this.spread +
			'}';
		}
	}
}
