package cdm.event.common;

import cdm.event.common.meta.ResetMeta;
import cdm.observable.asset.Price;
import cdm.observable.event.Observation;
import cdm.observable.event.Observation;
import cdm.observable.event.metafields.ReferenceWithMetaObservation;
import cdm.observable.event.metafields.ReferenceWithMetaObservation.ReferenceWithMetaObservationBuilder;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the reset value or fixing value produced in cashflow calculations, during the life-cycle of a financial instrument. The reset process defined in Create_Reset function joins product definition details with observations to compute the reset value.
 * @version ${project.version}
 */
@RosettaClass

public interface Reset extends RosettaModelObject {
	Reset build();
	Reset.ResetBuilder toBuilder();
	
	/**
	 * Identifies the aggregation method to use in the case where multiple observations are used to compute the reset value and the method is not defined in a payout.
	 */
	AggregationMethod getAggregationMethodology();
	/**
	 * Represents an audit of the observations used to produce the reset value. If multiple observations were necessary to produce the reset value, the aggregation method should be defined on the payout.
	 */
	List<? extends ReferenceWithMetaObservation> getObservations();
	/**
	 * Specifies the &#39;Rate Record Day&#39; for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset-&gt;resetDate occurs at the end of the interest period, and the Reset-&gt;rateRecordDate occurs near the start of the interest period.  The Reset-&gt;rateRecordDate and Reset-&gt;observations-&gt;observationIdentifier-&gt;observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
	 */
	Date getRateRecordDate();
	/**
	 * Specifies the date on which the reset occurred.
	 */
	Date getResetDate();
	/**
	 * Specifies the reset or fixing value. The fixing value could be a cash price, interest rate, or other value.
	 */
	Price getResetValue();
	final static ResetMeta metaData = new ResetMeta();
	
	@Override
	default RosettaMetaData<? extends Reset> metaData() {
		return metaData;
	} 
			
	static Reset.ResetBuilder builder() {
		return new Reset.ResetBuilderImpl();
	}
	
	default Class<? extends Reset> getType() {
		return Reset.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		
		processRosetta(path.newSubPath("aggregationMethodology"), processor, AggregationMethod.class, getAggregationMethodology());
		processRosetta(path.newSubPath("observations"), processor, ReferenceWithMetaObservation.class, getObservations());
		processRosetta(path.newSubPath("resetValue"), processor, Price.class, getResetValue());
	}
	
	
	interface ResetBuilder extends Reset, RosettaModelObjectBuilder {
		AggregationMethod.AggregationMethodBuilder getOrCreateAggregationMethodology();
		AggregationMethod.AggregationMethodBuilder getAggregationMethodology();
		ReferenceWithMetaObservationBuilder getOrCreateObservations(int _index);
		List<? extends ReferenceWithMetaObservationBuilder> getObservations();
		Price.PriceBuilder getOrCreateResetValue();
		Price.PriceBuilder getResetValue();
		Reset.ResetBuilder setAggregationMethodology(AggregationMethod aggregationMethodology);
		Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations);
		Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations, int _idx);
		Reset.ResetBuilder addObservationsValue(Observation observations);
		Reset.ResetBuilder addObservationsValue(Observation observations, int _idx);
		Reset.ResetBuilder addObservations(List<? extends ReferenceWithMetaObservation> observations);
		Reset.ResetBuilder setObservations(List<? extends ReferenceWithMetaObservation> observations);
		Reset.ResetBuilder addObservationsValue(List<? extends Observation> observations);
		Reset.ResetBuilder setObservationsValue(List<? extends Observation> observations);
		Reset.ResetBuilder setRateRecordDate(Date rateRecordDate);
		Reset.ResetBuilder setResetDate(Date resetDate);
		Reset.ResetBuilder setResetValue(Price resetValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			
			processRosetta(path.newSubPath("aggregationMethodology"), processor, AggregationMethod.AggregationMethodBuilder.class, getAggregationMethodology());
			processRosetta(path.newSubPath("observations"), processor, ReferenceWithMetaObservationBuilder.class, getObservations());
			processRosetta(path.newSubPath("resetValue"), processor, Price.PriceBuilder.class, getResetValue());
		}
		
	}
	
	//Reset.ResetImpl
	class ResetImpl implements Reset {
		private final AggregationMethod aggregationMethodology;
		private final List<? extends ReferenceWithMetaObservation> observations;
		private final Date rateRecordDate;
		private final Date resetDate;
		private final Price resetValue;
		
		protected ResetImpl(Reset.ResetBuilder builder) {
			this.aggregationMethodology = ofNullable(builder.getAggregationMethodology()).map(f->f.build()).orElse(null);
			this.observations = ofNullable(builder.getObservations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateRecordDate = builder.getRateRecordDate();
			this.resetDate = builder.getResetDate();
			this.resetValue = ofNullable(builder.getResetValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AggregationMethod getAggregationMethodology() {
			return aggregationMethodology;
		}
		
		@Override
		public List<? extends ReferenceWithMetaObservation> getObservations() {
			return observations;
		}
		
		@Override
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public Price getResetValue() {
			return resetValue;
		}
		
		@Override
		public Reset build() {
			return this;
		}
		
		@Override
		public Reset.ResetBuilder toBuilder() {
			Reset.ResetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reset.ResetBuilder builder) {
			ofNullable(getAggregationMethodology()).ifPresent(builder::setAggregationMethodology);
			ofNullable(getObservations()).ifPresent(builder::setObservations);
			ofNullable(getRateRecordDate()).ifPresent(builder::setRateRecordDate);
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
			ofNullable(getResetValue()).ifPresent(builder::setResetValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reset _that = getType().cast(o);
		
			if (!Objects.equals(aggregationMethodology, _that.getAggregationMethodology())) return false;
			if (!ListEquals.listEquals(observations, _that.getObservations())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aggregationMethodology != null ? aggregationMethodology.hashCode() : 0);
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Reset {" +
				"aggregationMethodology=" + this.aggregationMethodology + ", " +
				"observations=" + this.observations + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"resetDate=" + this.resetDate + ", " +
				"resetValue=" + this.resetValue +
			'}';
		}
	}
	
	//Reset.ResetBuilderImpl
	class ResetBuilderImpl implements Reset.ResetBuilder {
	
		protected AggregationMethod.AggregationMethodBuilder aggregationMethodology;
		protected List<ReferenceWithMetaObservationBuilder> observations = new ArrayList<>();
		protected Date rateRecordDate;
		protected Date resetDate;
		protected Price.PriceBuilder resetValue;
	
		public ResetBuilderImpl() {
		}
	
		@Override
		public AggregationMethod.AggregationMethodBuilder getAggregationMethodology() {
			return aggregationMethodology;
		}
		
		@Override
		public AggregationMethod.AggregationMethodBuilder getOrCreateAggregationMethodology() {
			AggregationMethod.AggregationMethodBuilder result;
			if (aggregationMethodology!=null) {
				result = aggregationMethodology;
			}
			else {
				result = aggregationMethodology = AggregationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ReferenceWithMetaObservationBuilder> getObservations() {
			return observations;
		}
		
		public ReferenceWithMetaObservationBuilder getOrCreateObservations(int _index) {
		
			if (observations==null) {
				this.observations = new ArrayList<>();
			}
			ReferenceWithMetaObservationBuilder result;
			return getIndex(observations, _index, () -> {
						ReferenceWithMetaObservationBuilder newObservations = ReferenceWithMetaObservation.builder();
						return newObservations;
					});
		}
		
		@Override
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		public Price.PriceBuilder getResetValue() {
			return resetValue;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateResetValue() {
			Price.PriceBuilder result;
			if (resetValue!=null) {
				result = resetValue;
			}
			else {
				result = resetValue = Price.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Reset.ResetBuilder setAggregationMethodology(AggregationMethod aggregationMethodology) {
			this.aggregationMethodology = aggregationMethodology==null?null:aggregationMethodology.toBuilder();
			return this;
		}
		@Override
		public Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations) {
			if (observations!=null) this.observations.add(observations.toBuilder());
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservations(ReferenceWithMetaObservation observations, int _idx) {
			getIndex(this.observations, _idx, () -> observations.toBuilder());
			return this;
		}
		
			@Override
			public Reset.ResetBuilder addObservationsValue(Observation observations) {
				this.getOrCreateObservations(-1).setValue(observations.toBuilder());
				return this;
			}
			
			@Override
			public Reset.ResetBuilder addObservationsValue(Observation observations, int _idx) {
				this.getOrCreateObservations(_idx).setValue(observations.toBuilder());
				return this;
			}
		@Override 
		public Reset.ResetBuilder addObservations(List<? extends ReferenceWithMetaObservation> observationss) {
			if (observationss != null) {
				for (ReferenceWithMetaObservation toAdd : observationss) {
					this.observations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Reset.ResetBuilder setObservations(List<? extends ReferenceWithMetaObservation> observationss) {
			if (observationss == null)  {
				this.observations = new ArrayList<>();
			}
			else {
				this.observations = observationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder addObservationsValue(List<? extends Observation> observationss) {
			if (observationss != null) {
				for (Observation toAdd : observationss) {
					this.addObservationsValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder setObservationsValue(List<? extends Observation> observationss) {
			this.observations.clear();
			if (observationss!=null) {
				observationss.forEach(this::addObservationsValue);
			}
			return this;
		}
		
		@Override
		public Reset.ResetBuilder setRateRecordDate(Date rateRecordDate) {
			this.rateRecordDate = rateRecordDate==null?null:rateRecordDate;
			return this;
		}
		@Override
		public Reset.ResetBuilder setResetDate(Date resetDate) {
			this.resetDate = resetDate==null?null:resetDate;
			return this;
		}
		@Override
		public Reset.ResetBuilder setResetValue(Price resetValue) {
			this.resetValue = resetValue==null?null:resetValue.toBuilder();
			return this;
		}
		
		@Override
		public Reset build() {
			return new Reset.ResetImpl(this);
		}
		
		@Override
		public Reset.ResetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reset.ResetBuilder prune() {
			if (aggregationMethodology!=null && !aggregationMethodology.prune().hasData()) aggregationMethodology = null;
			observations = observations.stream().filter(b->b!=null).<ReferenceWithMetaObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (resetValue!=null && !resetValue.prune().hasData()) resetValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAggregationMethodology()!=null && getAggregationMethodology().hasData()) return true;
			if (getObservations()!=null && getObservations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateRecordDate()!=null) return true;
			if (getResetDate()!=null) return true;
			if (getResetValue()!=null && getResetValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reset.ResetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Reset.ResetBuilder o = (Reset.ResetBuilder) other;
			
			merger.mergeRosetta(getAggregationMethodology(), o.getAggregationMethodology(), this::setAggregationMethodology);
			merger.mergeRosetta(getObservations(), o.getObservations(), this::getOrCreateObservations);
			merger.mergeRosetta(getResetValue(), o.getResetValue(), this::setResetValue);
			
			merger.mergeBasic(getRateRecordDate(), o.getRateRecordDate(), this::setRateRecordDate);
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reset _that = getType().cast(o);
		
			if (!Objects.equals(aggregationMethodology, _that.getAggregationMethodology())) return false;
			if (!ListEquals.listEquals(observations, _that.getObservations())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aggregationMethodology != null ? aggregationMethodology.hashCode() : 0);
			_result = 31 * _result + (observations != null ? observations.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetBuilder {" +
				"aggregationMethodology=" + this.aggregationMethodology + ", " +
				"observations=" + this.observations + ", " +
				"rateRecordDate=" + this.rateRecordDate + ", " +
				"resetDate=" + this.resetDate + ", " +
				"resetValue=" + this.resetValue +
			'}';
		}
	}
}
