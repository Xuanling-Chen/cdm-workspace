package cdm.observable.asset;

import cdm.observable.asset.meta.RateObservationMeta;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining parameters associated with an individual observation or fixing. This class forms part of the cashflow representation of a stream.
 * @version ${project.version}
 */
@RosettaClass

public interface RateObservation extends RosettaModelObject, GlobalKey {
	RateObservation build();
	RateObservation.RateObservationBuilder toBuilder();
	
	/**
	 * The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedFixingDate();
	/**
	 * The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.
	 */
	BigDecimal getForecastRate();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.
	 */
	Integer getObservationWeight();
	/**
	 * The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.
	 */
	BigDecimal getObservedRate();
	/**
	 * A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.
	 */
	ReferenceWithMetaRateObservation getRateReference();
	/**
	 * The reset date.
	 */
	Date getResetDate();
	/**
	 * The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.
	 */
	BigDecimal getTreatedForecastRate();
	/**
	 * The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.
	 */
	BigDecimal getTreatedRate();
	final static RateObservationMeta metaData = new RateObservationMeta();
	
	@Override
	default RosettaMetaData<? extends RateObservation> metaData() {
		return metaData;
	} 
			
	static RateObservation.RateObservationBuilder builder() {
		return new RateObservation.RateObservationBuilderImpl();
	}
	
	default Class<? extends RateObservation> getType() {
		return RateObservation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedFixingDate"), Date.class, getAdjustedFixingDate(), this);
		processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
		processor.processBasic(path.newSubPath("observationWeight"), Integer.class, getObservationWeight(), this);
		processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		processor.processBasic(path.newSubPath("treatedForecastRate"), BigDecimal.class, getTreatedForecastRate(), this);
		processor.processBasic(path.newSubPath("treatedRate"), BigDecimal.class, getTreatedRate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("rateReference"), processor, ReferenceWithMetaRateObservation.class, getRateReference());
	}
	
	
	interface RateObservationBuilder extends RateObservation, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ReferenceWithMetaRateObservationBuilder getOrCreateRateReference();
		ReferenceWithMetaRateObservationBuilder getRateReference();
		RateObservation.RateObservationBuilder setAdjustedFixingDate(Date adjustedFixingDate);
		RateObservation.RateObservationBuilder setForecastRate(BigDecimal forecastRate);
		RateObservation.RateObservationBuilder setMeta(MetaFields meta);
		RateObservation.RateObservationBuilder setObservationWeight(Integer observationWeight);
		RateObservation.RateObservationBuilder setObservedRate(BigDecimal observedRate);
		RateObservation.RateObservationBuilder setRateReference(ReferenceWithMetaRateObservation rateReference);
		RateObservation.RateObservationBuilder setRateReferenceValue(RateObservation rateReference);
		RateObservation.RateObservationBuilder setResetDate(Date resetDate);
		RateObservation.RateObservationBuilder setTreatedForecastRate(BigDecimal treatedForecastRate);
		RateObservation.RateObservationBuilder setTreatedRate(BigDecimal treatedRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedFixingDate"), Date.class, getAdjustedFixingDate(), this);
			processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
			processor.processBasic(path.newSubPath("observationWeight"), Integer.class, getObservationWeight(), this);
			processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			processor.processBasic(path.newSubPath("treatedForecastRate"), BigDecimal.class, getTreatedForecastRate(), this);
			processor.processBasic(path.newSubPath("treatedRate"), BigDecimal.class, getTreatedRate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("rateReference"), processor, ReferenceWithMetaRateObservationBuilder.class, getRateReference());
		}
		
	}
	
	//RateObservation.RateObservationImpl
	class RateObservationImpl implements RateObservation {
		private final Date adjustedFixingDate;
		private final BigDecimal forecastRate;
		private final MetaFields meta;
		private final Integer observationWeight;
		private final BigDecimal observedRate;
		private final ReferenceWithMetaRateObservation rateReference;
		private final Date resetDate;
		private final BigDecimal treatedForecastRate;
		private final BigDecimal treatedRate;
		
		protected RateObservationImpl(RateObservation.RateObservationBuilder builder) {
			this.adjustedFixingDate = builder.getAdjustedFixingDate();
			this.forecastRate = builder.getForecastRate();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.observationWeight = builder.getObservationWeight();
			this.observedRate = builder.getObservedRate();
			this.rateReference = ofNullable(builder.getRateReference()).map(f->f.build()).orElse(null);
			this.resetDate = builder.getResetDate();
			this.treatedForecastRate = builder.getTreatedForecastRate();
			this.treatedRate = builder.getTreatedRate();
		}
		
		@Override
		public Date getAdjustedFixingDate() {
			return adjustedFixingDate;
		}
		
		@Override
		public BigDecimal getForecastRate() {
			return forecastRate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Integer getObservationWeight() {
			return observationWeight;
		}
		
		@Override
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		public ReferenceWithMetaRateObservation getRateReference() {
			return rateReference;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public BigDecimal getTreatedForecastRate() {
			return treatedForecastRate;
		}
		
		@Override
		public BigDecimal getTreatedRate() {
			return treatedRate;
		}
		
		@Override
		public RateObservation build() {
			return this;
		}
		
		@Override
		public RateObservation.RateObservationBuilder toBuilder() {
			RateObservation.RateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateObservation.RateObservationBuilder builder) {
			ofNullable(getAdjustedFixingDate()).ifPresent(builder::setAdjustedFixingDate);
			ofNullable(getForecastRate()).ifPresent(builder::setForecastRate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getObservationWeight()).ifPresent(builder::setObservationWeight);
			ofNullable(getObservedRate()).ifPresent(builder::setObservedRate);
			ofNullable(getRateReference()).ifPresent(builder::setRateReference);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
			ofNullable(getTreatedForecastRate()).ifPresent(builder::setTreatedForecastRate);
			ofNullable(getTreatedRate()).ifPresent(builder::setTreatedRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateObservation _that = getType().cast(o);
		
			if (!Objects.equals(adjustedFixingDate, _that.getAdjustedFixingDate())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observationWeight, _that.getObservationWeight())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(rateReference, _that.getRateReference())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(treatedForecastRate, _that.getTreatedForecastRate())) return false;
			if (!Objects.equals(treatedRate, _that.getTreatedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedFixingDate != null ? adjustedFixingDate.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observationWeight != null ? observationWeight.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (rateReference != null ? rateReference.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (treatedForecastRate != null ? treatedForecastRate.hashCode() : 0);
			_result = 31 * _result + (treatedRate != null ? treatedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateObservation {" +
				"adjustedFixingDate=" + this.adjustedFixingDate + ", " +
				"forecastRate=" + this.forecastRate + ", " +
				"meta=" + this.meta + ", " +
				"observationWeight=" + this.observationWeight + ", " +
				"observedRate=" + this.observedRate + ", " +
				"rateReference=" + this.rateReference + ", " +
				"resetDate=" + this.resetDate + ", " +
				"treatedForecastRate=" + this.treatedForecastRate + ", " +
				"treatedRate=" + this.treatedRate +
			'}';
		}
	}
	
	//RateObservation.RateObservationBuilderImpl
	class RateObservationBuilderImpl implements RateObservation.RateObservationBuilder, GlobalKeyBuilder {
	
		protected Date adjustedFixingDate;
		protected BigDecimal forecastRate;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Integer observationWeight;
		protected BigDecimal observedRate;
		protected ReferenceWithMetaRateObservationBuilder rateReference;
		protected Date resetDate;
		protected BigDecimal treatedForecastRate;
		protected BigDecimal treatedRate;
	
		public RateObservationBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedFixingDate() {
			return adjustedFixingDate;
		}
		
		@Override
		public BigDecimal getForecastRate() {
			return forecastRate;
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
		public Integer getObservationWeight() {
			return observationWeight;
		}
		
		@Override
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		public ReferenceWithMetaRateObservationBuilder getRateReference() {
			return rateReference;
		}
		
		@Override
		public ReferenceWithMetaRateObservationBuilder getOrCreateRateReference() {
			ReferenceWithMetaRateObservationBuilder result;
			if (rateReference!=null) {
				result = rateReference;
			}
			else {
				result = rateReference = ReferenceWithMetaRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public BigDecimal getTreatedForecastRate() {
			return treatedForecastRate;
		}
		
		@Override
		public BigDecimal getTreatedRate() {
			return treatedRate;
		}
		
	
		@Override
		public RateObservation.RateObservationBuilder setAdjustedFixingDate(Date adjustedFixingDate) {
			this.adjustedFixingDate = adjustedFixingDate==null?null:adjustedFixingDate;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setForecastRate(BigDecimal forecastRate) {
			this.forecastRate = forecastRate==null?null:forecastRate;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setObservationWeight(Integer observationWeight) {
			this.observationWeight = observationWeight==null?null:observationWeight;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setObservedRate(BigDecimal observedRate) {
			this.observedRate = observedRate==null?null:observedRate;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setRateReference(ReferenceWithMetaRateObservation rateReference) {
			this.rateReference = rateReference==null?null:rateReference.toBuilder();
			return this;
		}
		
		@Override
		public RateObservation.RateObservationBuilder setRateReferenceValue(RateObservation rateReference) {
			this.getOrCreateRateReference().setValue(rateReference);
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setResetDate(Date resetDate) {
			this.resetDate = resetDate==null?null:resetDate;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setTreatedForecastRate(BigDecimal treatedForecastRate) {
			this.treatedForecastRate = treatedForecastRate==null?null:treatedForecastRate;
			return this;
		}
		@Override
		public RateObservation.RateObservationBuilder setTreatedRate(BigDecimal treatedRate) {
			this.treatedRate = treatedRate==null?null:treatedRate;
			return this;
		}
		
		@Override
		public RateObservation build() {
			return new RateObservation.RateObservationImpl(this);
		}
		
		@Override
		public RateObservation.RateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateObservation.RateObservationBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (rateReference!=null && !rateReference.prune().hasData()) rateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedFixingDate()!=null) return true;
			if (getForecastRate()!=null) return true;
			if (getObservationWeight()!=null) return true;
			if (getObservedRate()!=null) return true;
			if (getRateReference()!=null && getRateReference().hasData()) return true;
			if (getResetDate()!=null) return true;
			if (getTreatedForecastRate()!=null) return true;
			if (getTreatedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateObservation.RateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateObservation.RateObservationBuilder o = (RateObservation.RateObservationBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getRateReference(), o.getRateReference(), this::setRateReference);
			
			merger.mergeBasic(getAdjustedFixingDate(), o.getAdjustedFixingDate(), this::setAdjustedFixingDate);
			merger.mergeBasic(getForecastRate(), o.getForecastRate(), this::setForecastRate);
			merger.mergeBasic(getObservationWeight(), o.getObservationWeight(), this::setObservationWeight);
			merger.mergeBasic(getObservedRate(), o.getObservedRate(), this::setObservedRate);
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			merger.mergeBasic(getTreatedForecastRate(), o.getTreatedForecastRate(), this::setTreatedForecastRate);
			merger.mergeBasic(getTreatedRate(), o.getTreatedRate(), this::setTreatedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateObservation _that = getType().cast(o);
		
			if (!Objects.equals(adjustedFixingDate, _that.getAdjustedFixingDate())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observationWeight, _that.getObservationWeight())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(rateReference, _that.getRateReference())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(treatedForecastRate, _that.getTreatedForecastRate())) return false;
			if (!Objects.equals(treatedRate, _that.getTreatedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedFixingDate != null ? adjustedFixingDate.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observationWeight != null ? observationWeight.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (rateReference != null ? rateReference.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (treatedForecastRate != null ? treatedForecastRate.hashCode() : 0);
			_result = 31 * _result + (treatedRate != null ? treatedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateObservationBuilder {" +
				"adjustedFixingDate=" + this.adjustedFixingDate + ", " +
				"forecastRate=" + this.forecastRate + ", " +
				"meta=" + this.meta + ", " +
				"observationWeight=" + this.observationWeight + ", " +
				"observedRate=" + this.observedRate + ", " +
				"rateReference=" + this.rateReference + ", " +
				"resetDate=" + this.resetDate + ", " +
				"treatedForecastRate=" + this.treatedForecastRate + ", " +
				"treatedRate=" + this.treatedRate +
			'}';
		}
	}
}
