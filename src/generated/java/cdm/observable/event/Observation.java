package cdm.observable.event;

import cdm.observable.asset.Price;
import cdm.observable.event.meta.ObservationMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a single, numerical value that was observed in the marketplace. Observations of market data are made independently to business events or trade life-cycle events, so data instances of Observation can be created independently of any other model type, hence it is annotated as a root type. Observations will be broadly reused in many situations, so references to Observation are supported via the &#39;key&#39; annotation.
 * @version ${project.version}
 */
@RosettaClass

public interface Observation extends RosettaModelObject, GlobalKey {
	Observation build();
	Observation.ObservationBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 * Represents the observation was made i.e. how to uniquely identify the observed value among the population of all available market data.
	 */
	ObservationIdentifier getObservationIdentifier();
	/**
	 * Specifies the observed value as a number.
	 */
	Price getObservedValue();
	final static ObservationMeta metaData = new ObservationMeta();
	
	@Override
	default RosettaMetaData<? extends Observation> metaData() {
		return metaData;
	} 
			
	static Observation.ObservationBuilder builder() {
		return new Observation.ObservationBuilderImpl();
	}
	
	default Class<? extends Observation> getType() {
		return Observation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("observationIdentifier"), processor, ObservationIdentifier.class, getObservationIdentifier());
		processRosetta(path.newSubPath("observedValue"), processor, Price.class, getObservedValue());
	}
	
	
	interface ObservationBuilder extends Observation, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ObservationIdentifier.ObservationIdentifierBuilder getOrCreateObservationIdentifier();
		ObservationIdentifier.ObservationIdentifierBuilder getObservationIdentifier();
		Price.PriceBuilder getOrCreateObservedValue();
		Price.PriceBuilder getObservedValue();
		Observation.ObservationBuilder setMeta(MetaFields meta);
		Observation.ObservationBuilder setObservationIdentifier(ObservationIdentifier observationIdentifier);
		Observation.ObservationBuilder setObservedValue(Price observedValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("observationIdentifier"), processor, ObservationIdentifier.ObservationIdentifierBuilder.class, getObservationIdentifier());
			processRosetta(path.newSubPath("observedValue"), processor, Price.PriceBuilder.class, getObservedValue());
		}
		
	}
	
	//Observation.ObservationImpl
	class ObservationImpl implements Observation {
		private final MetaFields meta;
		private final ObservationIdentifier observationIdentifier;
		private final Price observedValue;
		
		protected ObservationImpl(Observation.ObservationBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.observationIdentifier = ofNullable(builder.getObservationIdentifier()).map(f->f.build()).orElse(null);
			this.observedValue = ofNullable(builder.getObservedValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ObservationIdentifier getObservationIdentifier() {
			return observationIdentifier;
		}
		
		@Override
		public Price getObservedValue() {
			return observedValue;
		}
		
		@Override
		public Observation build() {
			return this;
		}
		
		@Override
		public Observation.ObservationBuilder toBuilder() {
			Observation.ObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Observation.ObservationBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getObservationIdentifier()).ifPresent(builder::setObservationIdentifier);
			ofNullable(getObservedValue()).ifPresent(builder::setObservedValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observation _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observationIdentifier, _that.getObservationIdentifier())) return false;
			if (!Objects.equals(observedValue, _that.getObservedValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observationIdentifier != null ? observationIdentifier.hashCode() : 0);
			_result = 31 * _result + (observedValue != null ? observedValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Observation {" +
				"meta=" + this.meta + ", " +
				"observationIdentifier=" + this.observationIdentifier + ", " +
				"observedValue=" + this.observedValue +
			'}';
		}
	}
	
	//Observation.ObservationBuilderImpl
	class ObservationBuilderImpl implements Observation.ObservationBuilder, GlobalKeyBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected ObservationIdentifier.ObservationIdentifierBuilder observationIdentifier;
		protected Price.PriceBuilder observedValue;
	
		public ObservationBuilderImpl() {
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
		public ObservationIdentifier.ObservationIdentifierBuilder getObservationIdentifier() {
			return observationIdentifier;
		}
		
		@Override
		public ObservationIdentifier.ObservationIdentifierBuilder getOrCreateObservationIdentifier() {
			ObservationIdentifier.ObservationIdentifierBuilder result;
			if (observationIdentifier!=null) {
				result = observationIdentifier;
			}
			else {
				result = observationIdentifier = ObservationIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		public Price.PriceBuilder getObservedValue() {
			return observedValue;
		}
		
		@Override
		public Price.PriceBuilder getOrCreateObservedValue() {
			Price.PriceBuilder result;
			if (observedValue!=null) {
				result = observedValue;
			}
			else {
				result = observedValue = Price.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Observation.ObservationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public Observation.ObservationBuilder setObservationIdentifier(ObservationIdentifier observationIdentifier) {
			this.observationIdentifier = observationIdentifier==null?null:observationIdentifier.toBuilder();
			return this;
		}
		@Override
		public Observation.ObservationBuilder setObservedValue(Price observedValue) {
			this.observedValue = observedValue==null?null:observedValue.toBuilder();
			return this;
		}
		
		@Override
		public Observation build() {
			return new Observation.ObservationImpl(this);
		}
		
		@Override
		public Observation.ObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observation.ObservationBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (observationIdentifier!=null && !observationIdentifier.prune().hasData()) observationIdentifier = null;
			if (observedValue!=null && !observedValue.prune().hasData()) observedValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationIdentifier()!=null && getObservationIdentifier().hasData()) return true;
			if (getObservedValue()!=null && getObservedValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Observation.ObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Observation.ObservationBuilder o = (Observation.ObservationBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getObservationIdentifier(), o.getObservationIdentifier(), this::setObservationIdentifier);
			merger.mergeRosetta(getObservedValue(), o.getObservedValue(), this::setObservedValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Observation _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(observationIdentifier, _that.getObservationIdentifier())) return false;
			if (!Objects.equals(observedValue, _that.getObservedValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (observationIdentifier != null ? observationIdentifier.hashCode() : 0);
			_result = 31 * _result + (observedValue != null ? observedValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationBuilder {" +
				"meta=" + this.meta + ", " +
				"observationIdentifier=" + this.observationIdentifier + ", " +
				"observedValue=" + this.observedValue +
			'}';
		}
	}
}
