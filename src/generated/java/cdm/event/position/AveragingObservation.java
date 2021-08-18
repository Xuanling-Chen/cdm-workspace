package cdm.event.position;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.math.Rounding;
import cdm.base.staticdata.asset.common.AveragingCalculationMethodEnum;
import cdm.event.position.meta.AveragingObservationMeta;
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
 * Defines parameters for use in cases when a valuation or other term is based on an average of market observations.
 * @version ${project.version}
 */
@RosettaClass

public interface AveragingObservation extends RosettaModelObject {
	AveragingObservation build();
	AveragingObservation.AveragingObservationBuilder toBuilder();
	
	/**
	 * Specifies enumerations for the type of averaging calculation.
	 */
	AveragingCalculationMethodEnum getCalculationMethod();
	/**
	 * Defines foreign exchange (FX) asset class specific parameters.
	 */
	FxRateObservable getFxRateObservable();
	/**
	 * Specifies the date details at which a market observation will take place.
	 */
	ObservationDates getObservationDates();
	/**
	 * Specifies the time details at which a market observation will take place.
	 */
	BusinessCenterTime getObservationTime();
	/**
	 * Specifies details of any rounding applied when averaging market observations.
	 */
	Rounding getPrecision();
	final static AveragingObservationMeta metaData = new AveragingObservationMeta();
	
	@Override
	default RosettaMetaData<? extends AveragingObservation> metaData() {
		return metaData;
	} 
			
	static AveragingObservation.AveragingObservationBuilder builder() {
		return new AveragingObservation.AveragingObservationBuilderImpl();
	}
	
	default Class<? extends AveragingObservation> getType() {
		return AveragingObservation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationMethod"), AveragingCalculationMethodEnum.class, getCalculationMethod(), this);
		
		processRosetta(path.newSubPath("fxRateObservable"), processor, FxRateObservable.class, getFxRateObservable());
		processRosetta(path.newSubPath("observationDates"), processor, ObservationDates.class, getObservationDates());
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("precision"), processor, Rounding.class, getPrecision());
	}
	
	
	interface AveragingObservationBuilder extends AveragingObservation, RosettaModelObjectBuilder {
		FxRateObservable.FxRateObservableBuilder getOrCreateFxRateObservable();
		FxRateObservable.FxRateObservableBuilder getFxRateObservable();
		ObservationDates.ObservationDatesBuilder getOrCreateObservationDates();
		ObservationDates.ObservationDatesBuilder getObservationDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime();
		Rounding.RoundingBuilder getOrCreatePrecision();
		Rounding.RoundingBuilder getPrecision();
		AveragingObservation.AveragingObservationBuilder setCalculationMethod(AveragingCalculationMethodEnum calculationMethod);
		AveragingObservation.AveragingObservationBuilder setFxRateObservable(FxRateObservable fxRateObservable);
		AveragingObservation.AveragingObservationBuilder setObservationDates(ObservationDates observationDates);
		AveragingObservation.AveragingObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		AveragingObservation.AveragingObservationBuilder setPrecision(Rounding precision);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationMethod"), AveragingCalculationMethodEnum.class, getCalculationMethod(), this);
			
			processRosetta(path.newSubPath("fxRateObservable"), processor, FxRateObservable.FxRateObservableBuilder.class, getFxRateObservable());
			processRosetta(path.newSubPath("observationDates"), processor, ObservationDates.ObservationDatesBuilder.class, getObservationDates());
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("precision"), processor, Rounding.RoundingBuilder.class, getPrecision());
		}
		
	}
	
	//AveragingObservation.AveragingObservationImpl
	class AveragingObservationImpl implements AveragingObservation {
		private final AveragingCalculationMethodEnum calculationMethod;
		private final FxRateObservable fxRateObservable;
		private final ObservationDates observationDates;
		private final BusinessCenterTime observationTime;
		private final Rounding precision;
		
		protected AveragingObservationImpl(AveragingObservation.AveragingObservationBuilder builder) {
			this.calculationMethod = builder.getCalculationMethod();
			this.fxRateObservable = ofNullable(builder.getFxRateObservable()).map(f->f.build()).orElse(null);
			this.observationDates = ofNullable(builder.getObservationDates()).map(f->f.build()).orElse(null);
			this.observationTime = ofNullable(builder.getObservationTime()).map(f->f.build()).orElse(null);
			this.precision = ofNullable(builder.getPrecision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AveragingCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		public FxRateObservable getFxRateObservable() {
			return fxRateObservable;
		}
		
		@Override
		public ObservationDates getObservationDates() {
			return observationDates;
		}
		
		@Override
		public BusinessCenterTime getObservationTime() {
			return observationTime;
		}
		
		@Override
		public Rounding getPrecision() {
			return precision;
		}
		
		@Override
		public AveragingObservation build() {
			return this;
		}
		
		@Override
		public AveragingObservation.AveragingObservationBuilder toBuilder() {
			AveragingObservation.AveragingObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragingObservation.AveragingObservationBuilder builder) {
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getFxRateObservable()).ifPresent(builder::setFxRateObservable);
			ofNullable(getObservationDates()).ifPresent(builder::setObservationDates);
			ofNullable(getObservationTime()).ifPresent(builder::setObservationTime);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingObservation _that = getType().cast(o);
		
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(fxRateObservable, _that.getFxRateObservable())) return false;
			if (!Objects.equals(observationDates, _that.getObservationDates())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxRateObservable != null ? fxRateObservable.hashCode() : 0);
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingObservation {" +
				"calculationMethod=" + this.calculationMethod + ", " +
				"fxRateObservable=" + this.fxRateObservable + ", " +
				"observationDates=" + this.observationDates + ", " +
				"observationTime=" + this.observationTime + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
	
	//AveragingObservation.AveragingObservationBuilderImpl
	class AveragingObservationBuilderImpl implements AveragingObservation.AveragingObservationBuilder {
	
		protected AveragingCalculationMethodEnum calculationMethod;
		protected FxRateObservable.FxRateObservableBuilder fxRateObservable;
		protected ObservationDates.ObservationDatesBuilder observationDates;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationTime;
		protected Rounding.RoundingBuilder precision;
	
		public AveragingObservationBuilderImpl() {
		}
	
		@Override
		public AveragingCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder getFxRateObservable() {
			return fxRateObservable;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder getOrCreateFxRateObservable() {
			FxRateObservable.FxRateObservableBuilder result;
			if (fxRateObservable!=null) {
				result = fxRateObservable;
			}
			else {
				result = fxRateObservable = FxRateObservable.builder();
			}
			
			return result;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder getObservationDates() {
			return observationDates;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder getOrCreateObservationDates() {
			ObservationDates.ObservationDatesBuilder result;
			if (observationDates!=null) {
				result = observationDates;
			}
			else {
				result = observationDates = ObservationDates.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime() {
			return observationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationTime!=null) {
				result = observationTime;
			}
			else {
				result = observationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public Rounding.RoundingBuilder getPrecision() {
			return precision;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreatePrecision() {
			Rounding.RoundingBuilder result;
			if (precision!=null) {
				result = precision;
			}
			else {
				result = precision = Rounding.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AveragingObservation.AveragingObservationBuilder setCalculationMethod(AveragingCalculationMethodEnum calculationMethod) {
			this.calculationMethod = calculationMethod==null?null:calculationMethod;
			return this;
		}
		@Override
		public AveragingObservation.AveragingObservationBuilder setFxRateObservable(FxRateObservable fxRateObservable) {
			this.fxRateObservable = fxRateObservable==null?null:fxRateObservable.toBuilder();
			return this;
		}
		@Override
		public AveragingObservation.AveragingObservationBuilder setObservationDates(ObservationDates observationDates) {
			this.observationDates = observationDates==null?null:observationDates.toBuilder();
			return this;
		}
		@Override
		public AveragingObservation.AveragingObservationBuilder setObservationTime(BusinessCenterTime observationTime) {
			this.observationTime = observationTime==null?null:observationTime.toBuilder();
			return this;
		}
		@Override
		public AveragingObservation.AveragingObservationBuilder setPrecision(Rounding precision) {
			this.precision = precision==null?null:precision.toBuilder();
			return this;
		}
		
		@Override
		public AveragingObservation build() {
			return new AveragingObservation.AveragingObservationImpl(this);
		}
		
		@Override
		public AveragingObservation.AveragingObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingObservation.AveragingObservationBuilder prune() {
			if (fxRateObservable!=null && !fxRateObservable.prune().hasData()) fxRateObservable = null;
			if (observationDates!=null && !observationDates.prune().hasData()) observationDates = null;
			if (observationTime!=null && !observationTime.prune().hasData()) observationTime = null;
			if (precision!=null && !precision.prune().hasData()) precision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationMethod()!=null) return true;
			if (getFxRateObservable()!=null && getFxRateObservable().hasData()) return true;
			if (getObservationDates()!=null && getObservationDates().hasData()) return true;
			if (getObservationTime()!=null && getObservationTime().hasData()) return true;
			if (getPrecision()!=null && getPrecision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingObservation.AveragingObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AveragingObservation.AveragingObservationBuilder o = (AveragingObservation.AveragingObservationBuilder) other;
			
			merger.mergeRosetta(getFxRateObservable(), o.getFxRateObservable(), this::setFxRateObservable);
			merger.mergeRosetta(getObservationDates(), o.getObservationDates(), this::setObservationDates);
			merger.mergeRosetta(getObservationTime(), o.getObservationTime(), this::setObservationTime);
			merger.mergeRosetta(getPrecision(), o.getPrecision(), this::setPrecision);
			
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingObservation _that = getType().cast(o);
		
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(fxRateObservable, _that.getFxRateObservable())) return false;
			if (!Objects.equals(observationDates, _that.getObservationDates())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fxRateObservable != null ? fxRateObservable.hashCode() : 0);
			_result = 31 * _result + (observationDates != null ? observationDates.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingObservationBuilder {" +
				"calculationMethod=" + this.calculationMethod + ", " +
				"fxRateObservable=" + this.fxRateObservable + ", " +
				"observationDates=" + this.observationDates + ", " +
				"observationTime=" + this.observationTime + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
}
