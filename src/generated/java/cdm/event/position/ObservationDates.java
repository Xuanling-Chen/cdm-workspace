package cdm.event.position;

import cdm.base.datetime.PeriodicDates;
import cdm.event.position.meta.ObservationDatesMeta;
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
 * Describes date details for a set of observation dates in parametric or non-parametric form.
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationDates extends RosettaModelObject {
	ObservationDates build();
	ObservationDates.ObservationDatesBuilder toBuilder();
	
	/**
	 * Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable.  When no weight is specified, then weight of each date is assumed to be 1.0
	 */
	List<? extends ObservationSchedule> getObservationSchedule();
	/**
	 * Specifies the date range and frequency on which market observations take place.  Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule. 
	 */
	PeriodicDates getParametricSchedule();
	final static ObservationDatesMeta metaData = new ObservationDatesMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationDates> metaData() {
		return metaData;
	} 
			
	static ObservationDates.ObservationDatesBuilder builder() {
		return new ObservationDates.ObservationDatesBuilderImpl();
	}
	
	default Class<? extends ObservationDates> getType() {
		return ObservationDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("observationSchedule"), processor, ObservationSchedule.class, getObservationSchedule());
		processRosetta(path.newSubPath("parametricSchedule"), processor, PeriodicDates.class, getParametricSchedule());
	}
	
	
	interface ObservationDatesBuilder extends ObservationDates, RosettaModelObjectBuilder {
		ObservationSchedule.ObservationScheduleBuilder getOrCreateObservationSchedule(int _index);
		List<? extends ObservationSchedule.ObservationScheduleBuilder> getObservationSchedule();
		PeriodicDates.PeriodicDatesBuilder getOrCreateParametricSchedule();
		PeriodicDates.PeriodicDatesBuilder getParametricSchedule();
		ObservationDates.ObservationDatesBuilder addObservationSchedule(ObservationSchedule observationSchedule);
		ObservationDates.ObservationDatesBuilder addObservationSchedule(ObservationSchedule observationSchedule, int _idx);
		ObservationDates.ObservationDatesBuilder addObservationSchedule(List<? extends ObservationSchedule> observationSchedule);
		ObservationDates.ObservationDatesBuilder setObservationSchedule(List<? extends ObservationSchedule> observationSchedule);
		ObservationDates.ObservationDatesBuilder setParametricSchedule(PeriodicDates parametricSchedule);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("observationSchedule"), processor, ObservationSchedule.ObservationScheduleBuilder.class, getObservationSchedule());
			processRosetta(path.newSubPath("parametricSchedule"), processor, PeriodicDates.PeriodicDatesBuilder.class, getParametricSchedule());
		}
		
	}
	
	//ObservationDates.ObservationDatesImpl
	class ObservationDatesImpl implements ObservationDates {
		private final List<? extends ObservationSchedule> observationSchedule;
		private final PeriodicDates parametricSchedule;
		
		protected ObservationDatesImpl(ObservationDates.ObservationDatesBuilder builder) {
			this.observationSchedule = ofNullable(builder.getObservationSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parametricSchedule = ofNullable(builder.getParametricSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends ObservationSchedule> getObservationSchedule() {
			return observationSchedule;
		}
		
		@Override
		public PeriodicDates getParametricSchedule() {
			return parametricSchedule;
		}
		
		@Override
		public ObservationDates build() {
			return this;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder toBuilder() {
			ObservationDates.ObservationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationDates.ObservationDatesBuilder builder) {
			ofNullable(getObservationSchedule()).ifPresent(builder::setObservationSchedule);
			ofNullable(getParametricSchedule()).ifPresent(builder::setParametricSchedule);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!Objects.equals(parametricSchedule, _that.getParametricSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (parametricSchedule != null ? parametricSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationDates {" +
				"observationSchedule=" + this.observationSchedule + ", " +
				"parametricSchedule=" + this.parametricSchedule +
			'}';
		}
	}
	
	//ObservationDates.ObservationDatesBuilderImpl
	class ObservationDatesBuilderImpl implements ObservationDates.ObservationDatesBuilder {
	
		protected List<ObservationSchedule.ObservationScheduleBuilder> observationSchedule = new ArrayList<>();
		protected PeriodicDates.PeriodicDatesBuilder parametricSchedule;
	
		public ObservationDatesBuilderImpl() {
		}
	
		@Override
		public List<? extends ObservationSchedule.ObservationScheduleBuilder> getObservationSchedule() {
			return observationSchedule;
		}
		
		public ObservationSchedule.ObservationScheduleBuilder getOrCreateObservationSchedule(int _index) {
		
			if (observationSchedule==null) {
				this.observationSchedule = new ArrayList<>();
			}
			ObservationSchedule.ObservationScheduleBuilder result;
			return getIndex(observationSchedule, _index, () -> {
						ObservationSchedule.ObservationScheduleBuilder newObservationSchedule = ObservationSchedule.builder();
						return newObservationSchedule;
					});
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getParametricSchedule() {
			return parametricSchedule;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getOrCreateParametricSchedule() {
			PeriodicDates.PeriodicDatesBuilder result;
			if (parametricSchedule!=null) {
				result = parametricSchedule;
			}
			else {
				result = parametricSchedule = PeriodicDates.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ObservationDates.ObservationDatesBuilder addObservationSchedule(ObservationSchedule observationSchedule) {
			if (observationSchedule!=null) this.observationSchedule.add(observationSchedule.toBuilder());
			return this;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder addObservationSchedule(ObservationSchedule observationSchedule, int _idx) {
			getIndex(this.observationSchedule, _idx, () -> observationSchedule.toBuilder());
			return this;
		}
		@Override 
		public ObservationDates.ObservationDatesBuilder addObservationSchedule(List<? extends ObservationSchedule> observationSchedules) {
			if (observationSchedules != null) {
				for (ObservationSchedule toAdd : observationSchedules) {
					this.observationSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ObservationDates.ObservationDatesBuilder setObservationSchedule(List<? extends ObservationSchedule> observationSchedules) {
			if (observationSchedules == null)  {
				this.observationSchedule = new ArrayList<>();
			}
			else {
				this.observationSchedule = observationSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder setParametricSchedule(PeriodicDates parametricSchedule) {
			this.parametricSchedule = parametricSchedule==null?null:parametricSchedule.toBuilder();
			return this;
		}
		
		@Override
		public ObservationDates build() {
			return new ObservationDates.ObservationDatesImpl(this);
		}
		
		@Override
		public ObservationDates.ObservationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationDates.ObservationDatesBuilder prune() {
			observationSchedule = observationSchedule.stream().filter(b->b!=null).<ObservationSchedule.ObservationScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parametricSchedule!=null && !parametricSchedule.prune().hasData()) parametricSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationSchedule()!=null && getObservationSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParametricSchedule()!=null && getParametricSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationDates.ObservationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationDates.ObservationDatesBuilder o = (ObservationDates.ObservationDatesBuilder) other;
			
			merger.mergeRosetta(getObservationSchedule(), o.getObservationSchedule(), this::getOrCreateObservationSchedule);
			merger.mergeRosetta(getParametricSchedule(), o.getParametricSchedule(), this::setParametricSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observationSchedule, _that.getObservationSchedule())) return false;
			if (!Objects.equals(parametricSchedule, _that.getParametricSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationSchedule != null ? observationSchedule.hashCode() : 0);
			_result = 31 * _result + (parametricSchedule != null ? parametricSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationDatesBuilder {" +
				"observationSchedule=" + this.observationSchedule + ", " +
				"parametricSchedule=" + this.parametricSchedule +
			'}';
		}
	}
}
