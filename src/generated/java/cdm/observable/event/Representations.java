package cdm.observable.event;

import cdm.observable.event.meta.RepresentationsMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface Representations extends RosettaModelObject {
	Representations build();
	Representations.RepresentationsBuilder toBuilder();
	
	/**
	 * If true, then additional acknowledgements are applicable.
	 */
	Boolean getAdditionalAcknowledgements();
	/**
	 * If true, then agreements regarding hedging are applicable.
	 */
	Boolean getAgreementsRegardingHedging();
	/**
	 * If present and true, then index disclaimer is applicable.
	 */
	Boolean getIndexDisclaimer();
	/**
	 * If true, then non reliance is applicable.
	 */
	Boolean getNonReliance();
	final static RepresentationsMeta metaData = new RepresentationsMeta();
	
	@Override
	default RosettaMetaData<? extends Representations> metaData() {
		return metaData;
	} 
			
	static Representations.RepresentationsBuilder builder() {
		return new Representations.RepresentationsBuilderImpl();
	}
	
	default Class<? extends Representations> getType() {
		return Representations.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
		processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
		processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
		processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
		
	}
	
	
	interface RepresentationsBuilder extends Representations, RosettaModelObjectBuilder {
		Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean additionalAcknowledgements);
		Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean agreementsRegardingHedging);
		Representations.RepresentationsBuilder setIndexDisclaimer(Boolean indexDisclaimer);
		Representations.RepresentationsBuilder setNonReliance(Boolean nonReliance);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("additionalAcknowledgements"), Boolean.class, getAdditionalAcknowledgements(), this);
			processor.processBasic(path.newSubPath("agreementsRegardingHedging"), Boolean.class, getAgreementsRegardingHedging(), this);
			processor.processBasic(path.newSubPath("indexDisclaimer"), Boolean.class, getIndexDisclaimer(), this);
			processor.processBasic(path.newSubPath("nonReliance"), Boolean.class, getNonReliance(), this);
			
		}
		
	}
	
	//Representations.RepresentationsImpl
	class RepresentationsImpl implements Representations {
		private final Boolean additionalAcknowledgements;
		private final Boolean agreementsRegardingHedging;
		private final Boolean indexDisclaimer;
		private final Boolean nonReliance;
		
		protected RepresentationsImpl(Representations.RepresentationsBuilder builder) {
			this.additionalAcknowledgements = builder.getAdditionalAcknowledgements();
			this.agreementsRegardingHedging = builder.getAgreementsRegardingHedging();
			this.indexDisclaimer = builder.getIndexDisclaimer();
			this.nonReliance = builder.getNonReliance();
		}
		
		@Override
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
		@Override
		public Representations build() {
			return this;
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			Representations.RepresentationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Representations.RepresentationsBuilder builder) {
			ofNullable(getAdditionalAcknowledgements()).ifPresent(builder::setAdditionalAcknowledgements);
			ofNullable(getAgreementsRegardingHedging()).ifPresent(builder::setAgreementsRegardingHedging);
			ofNullable(getIndexDisclaimer()).ifPresent(builder::setIndexDisclaimer);
			ofNullable(getNonReliance()).ifPresent(builder::setNonReliance);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Representations {" +
				"additionalAcknowledgements=" + this.additionalAcknowledgements + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"nonReliance=" + this.nonReliance +
			'}';
		}
	}
	
	//Representations.RepresentationsBuilderImpl
	class RepresentationsBuilderImpl implements Representations.RepresentationsBuilder {
	
		protected Boolean additionalAcknowledgements;
		protected Boolean agreementsRegardingHedging;
		protected Boolean indexDisclaimer;
		protected Boolean nonReliance;
	
		public RepresentationsBuilderImpl() {
		}
	
		@Override
		public Boolean getAdditionalAcknowledgements() {
			return additionalAcknowledgements;
		}
		
		@Override
		public Boolean getAgreementsRegardingHedging() {
			return agreementsRegardingHedging;
		}
		
		@Override
		public Boolean getIndexDisclaimer() {
			return indexDisclaimer;
		}
		
		@Override
		public Boolean getNonReliance() {
			return nonReliance;
		}
		
	
		@Override
		public Representations.RepresentationsBuilder setAdditionalAcknowledgements(Boolean additionalAcknowledgements) {
			this.additionalAcknowledgements = additionalAcknowledgements==null?null:additionalAcknowledgements;
			return this;
		}
		@Override
		public Representations.RepresentationsBuilder setAgreementsRegardingHedging(Boolean agreementsRegardingHedging) {
			this.agreementsRegardingHedging = agreementsRegardingHedging==null?null:agreementsRegardingHedging;
			return this;
		}
		@Override
		public Representations.RepresentationsBuilder setIndexDisclaimer(Boolean indexDisclaimer) {
			this.indexDisclaimer = indexDisclaimer==null?null:indexDisclaimer;
			return this;
		}
		@Override
		public Representations.RepresentationsBuilder setNonReliance(Boolean nonReliance) {
			this.nonReliance = nonReliance==null?null:nonReliance;
			return this;
		}
		
		@Override
		public Representations build() {
			return new Representations.RepresentationsImpl(this);
		}
		
		@Override
		public Representations.RepresentationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalAcknowledgements()!=null) return true;
			if (getAgreementsRegardingHedging()!=null) return true;
			if (getIndexDisclaimer()!=null) return true;
			if (getNonReliance()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Representations.RepresentationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Representations.RepresentationsBuilder o = (Representations.RepresentationsBuilder) other;
			
			
			merger.mergeBasic(getAdditionalAcknowledgements(), o.getAdditionalAcknowledgements(), this::setAdditionalAcknowledgements);
			merger.mergeBasic(getAgreementsRegardingHedging(), o.getAgreementsRegardingHedging(), this::setAgreementsRegardingHedging);
			merger.mergeBasic(getIndexDisclaimer(), o.getIndexDisclaimer(), this::setIndexDisclaimer);
			merger.mergeBasic(getNonReliance(), o.getNonReliance(), this::setNonReliance);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Representations _that = getType().cast(o);
		
			if (!Objects.equals(additionalAcknowledgements, _that.getAdditionalAcknowledgements())) return false;
			if (!Objects.equals(agreementsRegardingHedging, _that.getAgreementsRegardingHedging())) return false;
			if (!Objects.equals(indexDisclaimer, _that.getIndexDisclaimer())) return false;
			if (!Objects.equals(nonReliance, _that.getNonReliance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalAcknowledgements != null ? additionalAcknowledgements.hashCode() : 0);
			_result = 31 * _result + (agreementsRegardingHedging != null ? agreementsRegardingHedging.hashCode() : 0);
			_result = 31 * _result + (indexDisclaimer != null ? indexDisclaimer.hashCode() : 0);
			_result = 31 * _result + (nonReliance != null ? nonReliance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepresentationsBuilder {" +
				"additionalAcknowledgements=" + this.additionalAcknowledgements + ", " +
				"agreementsRegardingHedging=" + this.agreementsRegardingHedging + ", " +
				"indexDisclaimer=" + this.indexDisclaimer + ", " +
				"nonReliance=" + this.nonReliance +
			'}';
		}
	}
}
