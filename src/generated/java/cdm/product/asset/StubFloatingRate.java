package cdm.product.asset;

import cdm.base.datetime.Period;
import cdm.base.math.Schedule;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.product.asset.meta.StubFloatingRateMeta;
import cdm.product.template.StrikeSchedule;
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
 * A class defining a floating rate.
 * @version ${project.version}
 */
@RosettaClass

public interface StubFloatingRate extends RosettaModelObject {
	StubFloatingRate build();
	StubFloatingRate.StubFloatingRateBuilder toBuilder();
	
	/**
	 * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getCapRateSchedule();
	/**
	 * The floating rate index.
	 */
	FloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 */
	Schedule getFloatingRateMultiplierSchedule();
	/**
	 * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getFloorRateSchedule();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 */
	Period getIndexTenor();
	/**
	 * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 */
	RateTreatmentEnum getRateTreatment();
	/**
	 * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();
	final static StubFloatingRateMeta metaData = new StubFloatingRateMeta();
	
	@Override
	default RosettaMetaData<? extends StubFloatingRate> metaData() {
		return metaData;
	} 
			
	static StubFloatingRate.StubFloatingRateBuilder builder() {
		return new StubFloatingRate.StubFloatingRateBuilderImpl();
	}
	
	default Class<? extends StubFloatingRate> getType() {
		return StubFloatingRate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
	}
	
	
	interface StubFloatingRateBuilder extends StubFloatingRate, RosettaModelObjectBuilder {
		StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule();
		Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule();
		Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index);
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx);
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex);
		StubFloatingRate.StubFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setIndexTenor(Period indexTenor);
		StubFloatingRate.StubFloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		StubFloatingRate.StubFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
		}
		
	}
	
	//StubFloatingRate.StubFloatingRateImpl
	class StubFloatingRateImpl implements StubFloatingRate {
		private final List<? extends StrikeSchedule> capRateSchedule;
		private final FloatingRateIndexEnum floatingRateIndex;
		private final Schedule floatingRateMultiplierSchedule;
		private final List<? extends StrikeSchedule> floorRateSchedule;
		private final Period indexTenor;
		private final RateTreatmentEnum rateTreatment;
		private final List<? extends SpreadSchedule> spreadSchedule;
		
		protected StubFloatingRateImpl(StubFloatingRate.StubFloatingRateBuilder builder) {
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floatingRateIndex = builder.getFloatingRateIndex();
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends StrikeSchedule> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		public FloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public Schedule getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public List<? extends StrikeSchedule> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		public Period getIndexTenor() {
			return indexTenor;
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
		public StubFloatingRate build() {
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder toBuilder() {
			StubFloatingRate.StubFloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubFloatingRate.StubFloatingRateBuilder builder) {
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubFloatingRate _that = getType().cast(o);
		
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubFloatingRate {" +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}';
		}
	}
	
	//StubFloatingRate.StubFloatingRateBuilderImpl
	class StubFloatingRateBuilderImpl implements StubFloatingRate.StubFloatingRateBuilder {
	
		protected List<StrikeSchedule.StrikeScheduleBuilder> capRateSchedule = new ArrayList<>();
		protected FloatingRateIndexEnum floatingRateIndex;
		protected Schedule.ScheduleBuilder floatingRateMultiplierSchedule;
		protected List<StrikeSchedule.StrikeScheduleBuilder> floorRateSchedule = new ArrayList<>();
		protected Period.PeriodBuilder indexTenor;
		protected RateTreatmentEnum rateTreatment;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
	
		public StubFloatingRateBuilderImpl() {
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
		public FloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule() {
			Schedule.ScheduleBuilder result;
			if (floatingRateMultiplierSchedule!=null) {
				result = floatingRateMultiplierSchedule;
			}
			else {
				result = floatingRateMultiplierSchedule = Schedule.builder();
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
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
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
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex;
			return this;
		}
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public StubFloatingRate.StubFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public StubFloatingRate build() {
			return new StubFloatingRate.StubFloatingRateImpl(this);
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder prune() {
			capRateSchedule = capRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			floorRateSchedule = floorRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCapRateSchedule()!=null && getCapRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloatingRateIndex()!=null) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			if (getRateTreatment()!=null) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubFloatingRate.StubFloatingRateBuilder o = (StubFloatingRate.StubFloatingRateBuilder) other;
			
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::getOrCreateCapRateSchedule);
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::getOrCreateFloorRateSchedule);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			
			merger.mergeBasic(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubFloatingRate _that = getType().cast(o);
		
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubFloatingRateBuilder {" +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"spreadSchedule=" + this.spreadSchedule +
			'}';
		}
	}
}
