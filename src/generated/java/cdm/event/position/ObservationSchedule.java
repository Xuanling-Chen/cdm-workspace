package cdm.event.position;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.event.position.meta.ObservationScheduleMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationSchedule extends RosettaModelObject {
	ObservationSchedule build();
	ObservationSchedule.ObservationScheduleBuilder toBuilder();
	
	/**
	 * Specifies an adjusted or unadjusted date for a market observation.
	 */
	AdjustableOrAdjustedDate getDate();
	/**
	 * Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
	 */
	String getObservationReference();
	/**
	 * Specifies the degree of importance of the observation.
	 */
	BigDecimal getWeight();
	final static ObservationScheduleMeta metaData = new ObservationScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationSchedule> metaData() {
		return metaData;
	} 
			
	static ObservationSchedule.ObservationScheduleBuilder builder() {
		return new ObservationSchedule.ObservationScheduleBuilderImpl();
	}
	
	default Class<? extends ObservationSchedule> getType() {
		return ObservationSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationReference"), String.class, getObservationReference(), this);
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		
		processRosetta(path.newSubPath("date"), processor, AdjustableOrAdjustedDate.class, getDate());
	}
	
	
	interface ObservationScheduleBuilder extends ObservationSchedule, RosettaModelObjectBuilder {
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getDate();
		ObservationSchedule.ObservationScheduleBuilder setDate(AdjustableOrAdjustedDate date);
		ObservationSchedule.ObservationScheduleBuilder setObservationReference(String observationReference);
		ObservationSchedule.ObservationScheduleBuilder setWeight(BigDecimal weight);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("observationReference"), String.class, getObservationReference(), this);
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
			
			processRosetta(path.newSubPath("date"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getDate());
		}
		
	}
	
	//ObservationSchedule.ObservationScheduleImpl
	class ObservationScheduleImpl implements ObservationSchedule {
		private final AdjustableOrAdjustedDate date;
		private final String observationReference;
		private final BigDecimal weight;
		
		protected ObservationScheduleImpl(ObservationSchedule.ObservationScheduleBuilder builder) {
			this.date = ofNullable(builder.getDate()).map(f->f.build()).orElse(null);
			this.observationReference = builder.getObservationReference();
			this.weight = builder.getWeight();
		}
		
		@Override
		public AdjustableOrAdjustedDate getDate() {
			return date;
		}
		
		@Override
		public String getObservationReference() {
			return observationReference;
		}
		
		@Override
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		public ObservationSchedule build() {
			return this;
		}
		
		@Override
		public ObservationSchedule.ObservationScheduleBuilder toBuilder() {
			ObservationSchedule.ObservationScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationSchedule.ObservationScheduleBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getObservationReference()).ifPresent(builder::setObservationReference);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSchedule _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationSchedule {" +
				"date=" + this.date + ", " +
				"observationReference=" + this.observationReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
	
	//ObservationSchedule.ObservationScheduleBuilderImpl
	class ObservationScheduleBuilderImpl implements ObservationSchedule.ObservationScheduleBuilder {
	
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder date;
		protected String observationReference;
		protected BigDecimal weight;
	
		public ObservationScheduleBuilderImpl() {
		}
	
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getDate() {
			return date;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (date!=null) {
				result = date;
			}
			else {
				result = date = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		public String getObservationReference() {
			return observationReference;
		}
		
		@Override
		public BigDecimal getWeight() {
			return weight;
		}
		
	
		@Override
		public ObservationSchedule.ObservationScheduleBuilder setDate(AdjustableOrAdjustedDate date) {
			this.date = date==null?null:date.toBuilder();
			return this;
		}
		@Override
		public ObservationSchedule.ObservationScheduleBuilder setObservationReference(String observationReference) {
			this.observationReference = observationReference==null?null:observationReference;
			return this;
		}
		@Override
		public ObservationSchedule.ObservationScheduleBuilder setWeight(BigDecimal weight) {
			this.weight = weight==null?null:weight;
			return this;
		}
		
		@Override
		public ObservationSchedule build() {
			return new ObservationSchedule.ObservationScheduleImpl(this);
		}
		
		@Override
		public ObservationSchedule.ObservationScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSchedule.ObservationScheduleBuilder prune() {
			if (date!=null && !date.prune().hasData()) date = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null && getDate().hasData()) return true;
			if (getObservationReference()!=null) return true;
			if (getWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationSchedule.ObservationScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationSchedule.ObservationScheduleBuilder o = (ObservationSchedule.ObservationScheduleBuilder) other;
			
			merger.mergeRosetta(getDate(), o.getDate(), this::setDate);
			
			merger.mergeBasic(getObservationReference(), o.getObservationReference(), this::setObservationReference);
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationSchedule _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationScheduleBuilder {" +
				"date=" + this.date + ", " +
				"observationReference=" + this.observationReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
}
