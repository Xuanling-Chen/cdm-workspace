package cdm.observable.event;

import cdm.base.datetime.TimeZone;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.Observable;
import cdm.observable.event.meta.ObservationIdentifierMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the parameters needed to uniquely identify a piece of data among the population of all available market data.
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationIdentifier extends RosettaModelObject {
	ObservationIdentifier build();
	ObservationIdentifier.ObservationIdentifierBuilder toBuilder();
	
	/**
	 */
	DeterminationMethodology getDeterminationMethodology();
	/**
	 * Represents where the market data published and should be observed.
	 */
	InformationSource getInformationSource();
	/**
	 * Represents the asset or rate to which the observation relates.
	 */
	Observable getObservable();
	/**
	 * Specifies the date value to use when resolving the market data.
	 */
	Date getObservationDate();
	/**
	 * Represents the time and time-zone.
	 */
	TimeZone getObservationTime();
	final static ObservationIdentifierMeta metaData = new ObservationIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationIdentifier> metaData() {
		return metaData;
	} 
			
	static ObservationIdentifier.ObservationIdentifierBuilder builder() {
		return new ObservationIdentifier.ObservationIdentifierBuilderImpl();
	}
	
	default Class<? extends ObservationIdentifier> getType() {
		return ObservationIdentifier.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
		
		processRosetta(path.newSubPath("determinationMethodology"), processor, DeterminationMethodology.class, getDeterminationMethodology());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("observable"), processor, Observable.class, getObservable());
		processRosetta(path.newSubPath("observationTime"), processor, TimeZone.class, getObservationTime());
	}
	
	
	interface ObservationIdentifierBuilder extends ObservationIdentifier, RosettaModelObjectBuilder {
		DeterminationMethodology.DeterminationMethodologyBuilder getOrCreateDeterminationMethodology();
		DeterminationMethodology.DeterminationMethodologyBuilder getDeterminationMethodology();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		InformationSource.InformationSourceBuilder getInformationSource();
		Observable.ObservableBuilder getOrCreateObservable();
		Observable.ObservableBuilder getObservable();
		TimeZone.TimeZoneBuilder getOrCreateObservationTime();
		TimeZone.TimeZoneBuilder getObservationTime();
		ObservationIdentifier.ObservationIdentifierBuilder setDeterminationMethodology(DeterminationMethodology determinationMethodology);
		ObservationIdentifier.ObservationIdentifierBuilder setInformationSource(InformationSource informationSource);
		ObservationIdentifier.ObservationIdentifierBuilder setObservable(Observable observable);
		ObservationIdentifier.ObservationIdentifierBuilder setObservationDate(Date observationDate);
		ObservationIdentifier.ObservationIdentifierBuilder setObservationTime(TimeZone observationTime);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("observationDate"), Date.class, getObservationDate(), this);
			
			processRosetta(path.newSubPath("determinationMethodology"), processor, DeterminationMethodology.DeterminationMethodologyBuilder.class, getDeterminationMethodology());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("observable"), processor, Observable.ObservableBuilder.class, getObservable());
			processRosetta(path.newSubPath("observationTime"), processor, TimeZone.TimeZoneBuilder.class, getObservationTime());
		}
		
	}
	
	//ObservationIdentifier.ObservationIdentifierImpl
	class ObservationIdentifierImpl implements ObservationIdentifier {
		private final DeterminationMethodology determinationMethodology;
		private final InformationSource informationSource;
		private final Observable observable;
		private final Date observationDate;
		private final TimeZone observationTime;
		
		protected ObservationIdentifierImpl(ObservationIdentifier.ObservationIdentifierBuilder builder) {
			this.determinationMethodology = ofNullable(builder.getDeterminationMethodology()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.observable = ofNullable(builder.getObservable()).map(f->f.build()).orElse(null);
			this.observationDate = builder.getObservationDate();
			this.observationTime = ofNullable(builder.getObservationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DeterminationMethodology getDeterminationMethodology() {
			return determinationMethodology;
		}
		
		@Override
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		public Observable getObservable() {
			return observable;
		}
		
		@Override
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		public TimeZone getObservationTime() {
			return observationTime;
		}
		
		@Override
		public ObservationIdentifier build() {
			return this;
		}
		
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder toBuilder() {
			ObservationIdentifier.ObservationIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationIdentifier.ObservationIdentifierBuilder builder) {
			ofNullable(getDeterminationMethodology()).ifPresent(builder::setDeterminationMethodology);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getObservable()).ifPresent(builder::setObservable);
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getObservationTime()).ifPresent(builder::setObservationTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethodology, _that.getDeterminationMethodology())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethodology != null ? determinationMethodology.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationIdentifier {" +
				"determinationMethodology=" + this.determinationMethodology + ", " +
				"informationSource=" + this.informationSource + ", " +
				"observable=" + this.observable + ", " +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime +
			'}';
		}
	}
	
	//ObservationIdentifier.ObservationIdentifierBuilderImpl
	class ObservationIdentifierBuilderImpl implements ObservationIdentifier.ObservationIdentifierBuilder {
	
		protected DeterminationMethodology.DeterminationMethodologyBuilder determinationMethodology;
		protected InformationSource.InformationSourceBuilder informationSource;
		protected Observable.ObservableBuilder observable;
		protected Date observationDate;
		protected TimeZone.TimeZoneBuilder observationTime;
	
		public ObservationIdentifierBuilderImpl() {
		}
	
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder getDeterminationMethodology() {
			return determinationMethodology;
		}
		
		@Override
		public DeterminationMethodology.DeterminationMethodologyBuilder getOrCreateDeterminationMethodology() {
			DeterminationMethodology.DeterminationMethodologyBuilder result;
			if (determinationMethodology!=null) {
				result = determinationMethodology;
			}
			else {
				result = determinationMethodology = DeterminationMethodology.builder();
			}
			
			return result;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		public Observable.ObservableBuilder getObservable() {
			return observable;
		}
		
		@Override
		public Observable.ObservableBuilder getOrCreateObservable() {
			Observable.ObservableBuilder result;
			if (observable!=null) {
				result = observable;
			}
			else {
				result = observable = Observable.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getObservationDate() {
			return observationDate;
		}
		
		@Override
		public TimeZone.TimeZoneBuilder getObservationTime() {
			return observationTime;
		}
		
		@Override
		public TimeZone.TimeZoneBuilder getOrCreateObservationTime() {
			TimeZone.TimeZoneBuilder result;
			if (observationTime!=null) {
				result = observationTime;
			}
			else {
				result = observationTime = TimeZone.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder setDeterminationMethodology(DeterminationMethodology determinationMethodology) {
			this.determinationMethodology = determinationMethodology==null?null:determinationMethodology.toBuilder();
			return this;
		}
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder setInformationSource(InformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder setObservable(Observable observable) {
			this.observable = observable==null?null:observable.toBuilder();
			return this;
		}
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder setObservationDate(Date observationDate) {
			this.observationDate = observationDate==null?null:observationDate;
			return this;
		}
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder setObservationTime(TimeZone observationTime) {
			this.observationTime = observationTime==null?null:observationTime.toBuilder();
			return this;
		}
		
		@Override
		public ObservationIdentifier build() {
			return new ObservationIdentifier.ObservationIdentifierImpl(this);
		}
		
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder prune() {
			if (determinationMethodology!=null && !determinationMethodology.prune().hasData()) determinationMethodology = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (observable!=null && !observable.prune().hasData()) observable = null;
			if (observationTime!=null && !observationTime.prune().hasData()) observationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationMethodology()!=null && getDeterminationMethodology().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getObservable()!=null && getObservable().hasData()) return true;
			if (getObservationDate()!=null) return true;
			if (getObservationTime()!=null && getObservationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationIdentifier.ObservationIdentifierBuilder o = (ObservationIdentifier.ObservationIdentifierBuilder) other;
			
			merger.mergeRosetta(getDeterminationMethodology(), o.getDeterminationMethodology(), this::setDeterminationMethodology);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getObservable(), o.getObservable(), this::setObservable);
			merger.mergeRosetta(getObservationTime(), o.getObservationTime(), this::setObservationTime);
			
			merger.mergeBasic(getObservationDate(), o.getObservationDate(), this::setObservationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(determinationMethodology, _that.getDeterminationMethodology())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(observable, _that.getObservable())) return false;
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationMethodology != null ? determinationMethodology.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (observable != null ? observable.hashCode() : 0);
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationIdentifierBuilder {" +
				"determinationMethodology=" + this.determinationMethodology + ", " +
				"informationSource=" + this.informationSource + ", " +
				"observable=" + this.observable + ", " +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime +
			'}';
		}
	}
}
