package cdm.observable.event;

import cdm.observable.event.meta.ExtraordinaryEventsMeta;
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
 * Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 * @version ${project.version}
 */
@RosettaClass

public interface ExtraordinaryEvents extends RosettaModelObject {
	ExtraordinaryEvents build();
	ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder();
	
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Additional Disruption Events | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Additional Disruption Events means each Additional Disruption Event specified in the Confirmation Side Letter. For the avoidance of doubt, each Additional Disruption Event shall be an Extraordinary Event.
	 */
	AdditionalDisruptionEvents getAdditionalDisruptionEvents();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Composition of Combined Consideration | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Combined Consideration | If present and true, then composition of combined consideration is applicable.
	 */
	Boolean getCompositionOfCombinedConsideration();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Delisting | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Delisting means Delisting (Broad Relisting) or Delisting (Narrow Relisting), as specified in the Relationship Supplement.
	 */
	NationalizationOrInsolvencyOrDelistingEventEnum getDelisting();
	/**
	 * If true, failure to deliver is applicable.
	 */
	Boolean getFailureToDeliver();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Adjustments to Indices | 
	 */
	IndexAdjustmentEvents getIndexAdjustmentEvents();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Merger Event shall occur if a Merger occurs and the Merger Date is on or before the final Equity Valuation Date | Occurs when the underlying ceases to exist following a merger between the Issuer and another company.
	 */
	EquityCorporateEvents getMergerEvents();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Nationalization and Insolvency | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Nationalization shall occur if all the Securities or all or substantially all the assets of an Issuer are nationalized, expropriated or are otherwise required to be transferred to any governmental agency, authority, entity or instrumentality thereof. Insolvency Filing means as defined in the Confirmation Side Letter.
	 */
	NationalizationOrInsolvencyOrDelistingEventEnum getNationalizationOrInsolvency();
	/**
	 */
	Representations getRepresentations();
	/**
	 * 2002 ISDA Equity Derivatives Definitions: Tender Offers | 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Tender Offer Event
	 */
	EquityCorporateEvents getTenderOfferEvents();
	final static ExtraordinaryEventsMeta metaData = new ExtraordinaryEventsMeta();
	
	@Override
	default RosettaMetaData<? extends ExtraordinaryEvents> metaData() {
		return metaData;
	} 
			
	static ExtraordinaryEvents.ExtraordinaryEventsBuilder builder() {
		return new ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl();
	}
	
	default Class<? extends ExtraordinaryEvents> getType() {
		return ExtraordinaryEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
		processor.processBasic(path.newSubPath("delisting"), NationalizationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processor.processBasic(path.newSubPath("nationalizationOrInsolvency"), NationalizationOrInsolvencyOrDelistingEventEnum.class, getNationalizationOrInsolvency(), this);
		
		processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.class, getAdditionalDisruptionEvents());
		processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.class, getIndexAdjustmentEvents());
		processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.class, getMergerEvents());
		processRosetta(path.newSubPath("representations"), processor, Representations.class, getRepresentations());
		processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.class, getTenderOfferEvents());
	}
	
	
	interface ExtraordinaryEventsBuilder extends ExtraordinaryEvents, RosettaModelObjectBuilder {
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents();
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents();
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents();
		Representations.RepresentationsBuilder getOrCreateRepresentations();
		Representations.RepresentationsBuilder getRepresentations();
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents additionalDisruptionEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean compositionOfCombinedConsideration);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalizationOrInsolvencyOrDelistingEventEnum delisting);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents indexAdjustmentEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents mergerEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalizationOrInsolvency(NationalizationOrInsolvencyOrDelistingEventEnum nationalizationOrInsolvency);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations representations);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents tenderOfferEvents);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
			processor.processBasic(path.newSubPath("delisting"), NationalizationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processor.processBasic(path.newSubPath("nationalizationOrInsolvency"), NationalizationOrInsolvencyOrDelistingEventEnum.class, getNationalizationOrInsolvency(), this);
			
			processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder.class, getAdditionalDisruptionEvents());
			processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.IndexAdjustmentEventsBuilder.class, getIndexAdjustmentEvents());
			processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getMergerEvents());
			processRosetta(path.newSubPath("representations"), processor, Representations.RepresentationsBuilder.class, getRepresentations());
			processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getTenderOfferEvents());
		}
		
	}
	
	//ExtraordinaryEvents.ExtraordinaryEventsImpl
	class ExtraordinaryEventsImpl implements ExtraordinaryEvents {
		private final AdditionalDisruptionEvents additionalDisruptionEvents;
		private final Boolean compositionOfCombinedConsideration;
		private final NationalizationOrInsolvencyOrDelistingEventEnum delisting;
		private final Boolean failureToDeliver;
		private final IndexAdjustmentEvents indexAdjustmentEvents;
		private final EquityCorporateEvents mergerEvents;
		private final NationalizationOrInsolvencyOrDelistingEventEnum nationalizationOrInsolvency;
		private final Representations representations;
		private final EquityCorporateEvents tenderOfferEvents;
		
		protected ExtraordinaryEventsImpl(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			this.additionalDisruptionEvents = ofNullable(builder.getAdditionalDisruptionEvents()).map(f->f.build()).orElse(null);
			this.compositionOfCombinedConsideration = builder.getCompositionOfCombinedConsideration();
			this.delisting = builder.getDelisting();
			this.failureToDeliver = builder.getFailureToDeliver();
			this.indexAdjustmentEvents = ofNullable(builder.getIndexAdjustmentEvents()).map(f->f.build()).orElse(null);
			this.mergerEvents = ofNullable(builder.getMergerEvents()).map(f->f.build()).orElse(null);
			this.nationalizationOrInsolvency = builder.getNationalizationOrInsolvency();
			this.representations = ofNullable(builder.getRepresentations()).map(f->f.build()).orElse(null);
			this.tenderOfferEvents = ofNullable(builder.getTenderOfferEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdditionalDisruptionEvents getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		public NationalizationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
		}
		
		@Override
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		public IndexAdjustmentEvents getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		public EquityCorporateEvents getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		public NationalizationOrInsolvencyOrDelistingEventEnum getNationalizationOrInsolvency() {
			return nationalizationOrInsolvency;
		}
		
		@Override
		public Representations getRepresentations() {
			return representations;
		}
		
		@Override
		public EquityCorporateEvents getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			ofNullable(getAdditionalDisruptionEvents()).ifPresent(builder::setAdditionalDisruptionEvents);
			ofNullable(getCompositionOfCombinedConsideration()).ifPresent(builder::setCompositionOfCombinedConsideration);
			ofNullable(getDelisting()).ifPresent(builder::setDelisting);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getIndexAdjustmentEvents()).ifPresent(builder::setIndexAdjustmentEvents);
			ofNullable(getMergerEvents()).ifPresent(builder::setMergerEvents);
			ofNullable(getNationalizationOrInsolvency()).ifPresent(builder::setNationalizationOrInsolvency);
			ofNullable(getRepresentations()).ifPresent(builder::setRepresentations);
			ofNullable(getTenderOfferEvents()).ifPresent(builder::setTenderOfferEvents);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(nationalizationOrInsolvency, _that.getNationalizationOrInsolvency())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (nationalizationOrInsolvency != null ? nationalizationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEvents {" +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"delisting=" + this.delisting + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"mergerEvents=" + this.mergerEvents + ", " +
				"nationalizationOrInsolvency=" + this.nationalizationOrInsolvency + ", " +
				"representations=" + this.representations + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents +
			'}';
		}
	}
	
	//ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl
	class ExtraordinaryEventsBuilderImpl implements ExtraordinaryEvents.ExtraordinaryEventsBuilder {
	
		protected AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEvents;
		protected Boolean compositionOfCombinedConsideration;
		protected NationalizationOrInsolvencyOrDelistingEventEnum delisting;
		protected Boolean failureToDeliver;
		protected IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEvents;
		protected EquityCorporateEvents.EquityCorporateEventsBuilder mergerEvents;
		protected NationalizationOrInsolvencyOrDelistingEventEnum nationalizationOrInsolvency;
		protected Representations.RepresentationsBuilder representations;
		protected EquityCorporateEvents.EquityCorporateEventsBuilder tenderOfferEvents;
	
		public ExtraordinaryEventsBuilderImpl() {
		}
	
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder result;
			if (additionalDisruptionEvents!=null) {
				result = additionalDisruptionEvents;
			}
			else {
				result = additionalDisruptionEvents = AdditionalDisruptionEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		public NationalizationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
		}
		
		@Override
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder result;
			if (indexAdjustmentEvents!=null) {
				result = indexAdjustmentEvents;
			}
			else {
				result = indexAdjustmentEvents = IndexAdjustmentEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (mergerEvents!=null) {
				result = mergerEvents;
			}
			else {
				result = mergerEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public NationalizationOrInsolvencyOrDelistingEventEnum getNationalizationOrInsolvency() {
			return nationalizationOrInsolvency;
		}
		
		@Override
		public Representations.RepresentationsBuilder getRepresentations() {
			return representations;
		}
		
		@Override
		public Representations.RepresentationsBuilder getOrCreateRepresentations() {
			Representations.RepresentationsBuilder result;
			if (representations!=null) {
				result = representations;
			}
			else {
				result = representations = Representations.builder();
			}
			
			return result;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (tenderOfferEvents!=null) {
				result = tenderOfferEvents;
			}
			else {
				result = tenderOfferEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents additionalDisruptionEvents) {
			this.additionalDisruptionEvents = additionalDisruptionEvents==null?null:additionalDisruptionEvents.toBuilder();
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean compositionOfCombinedConsideration) {
			this.compositionOfCombinedConsideration = compositionOfCombinedConsideration==null?null:compositionOfCombinedConsideration;
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalizationOrInsolvencyOrDelistingEventEnum delisting) {
			this.delisting = delisting==null?null:delisting;
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean failureToDeliver) {
			this.failureToDeliver = failureToDeliver==null?null:failureToDeliver;
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents indexAdjustmentEvents) {
			this.indexAdjustmentEvents = indexAdjustmentEvents==null?null:indexAdjustmentEvents.toBuilder();
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents mergerEvents) {
			this.mergerEvents = mergerEvents==null?null:mergerEvents.toBuilder();
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalizationOrInsolvency(NationalizationOrInsolvencyOrDelistingEventEnum nationalizationOrInsolvency) {
			this.nationalizationOrInsolvency = nationalizationOrInsolvency==null?null:nationalizationOrInsolvency;
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations representations) {
			this.representations = representations==null?null:representations.toBuilder();
			return this;
		}
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents tenderOfferEvents) {
			this.tenderOfferEvents = tenderOfferEvents==null?null:tenderOfferEvents.toBuilder();
			return this;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return new ExtraordinaryEvents.ExtraordinaryEventsImpl(this);
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder prune() {
			if (additionalDisruptionEvents!=null && !additionalDisruptionEvents.prune().hasData()) additionalDisruptionEvents = null;
			if (indexAdjustmentEvents!=null && !indexAdjustmentEvents.prune().hasData()) indexAdjustmentEvents = null;
			if (mergerEvents!=null && !mergerEvents.prune().hasData()) mergerEvents = null;
			if (representations!=null && !representations.prune().hasData()) representations = null;
			if (tenderOfferEvents!=null && !tenderOfferEvents.prune().hasData()) tenderOfferEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalDisruptionEvents()!=null && getAdditionalDisruptionEvents().hasData()) return true;
			if (getCompositionOfCombinedConsideration()!=null) return true;
			if (getDelisting()!=null) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getIndexAdjustmentEvents()!=null && getIndexAdjustmentEvents().hasData()) return true;
			if (getMergerEvents()!=null && getMergerEvents().hasData()) return true;
			if (getNationalizationOrInsolvency()!=null) return true;
			if (getRepresentations()!=null && getRepresentations().hasData()) return true;
			if (getTenderOfferEvents()!=null && getTenderOfferEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder o = (ExtraordinaryEvents.ExtraordinaryEventsBuilder) other;
			
			merger.mergeRosetta(getAdditionalDisruptionEvents(), o.getAdditionalDisruptionEvents(), this::setAdditionalDisruptionEvents);
			merger.mergeRosetta(getIndexAdjustmentEvents(), o.getIndexAdjustmentEvents(), this::setIndexAdjustmentEvents);
			merger.mergeRosetta(getMergerEvents(), o.getMergerEvents(), this::setMergerEvents);
			merger.mergeRosetta(getRepresentations(), o.getRepresentations(), this::setRepresentations);
			merger.mergeRosetta(getTenderOfferEvents(), o.getTenderOfferEvents(), this::setTenderOfferEvents);
			
			merger.mergeBasic(getCompositionOfCombinedConsideration(), o.getCompositionOfCombinedConsideration(), this::setCompositionOfCombinedConsideration);
			merger.mergeBasic(getDelisting(), o.getDelisting(), this::setDelisting);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getNationalizationOrInsolvency(), o.getNationalizationOrInsolvency(), this::setNationalizationOrInsolvency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(nationalizationOrInsolvency, _that.getNationalizationOrInsolvency())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (nationalizationOrInsolvency != null ? nationalizationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEventsBuilder {" +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"delisting=" + this.delisting + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"mergerEvents=" + this.mergerEvents + ", " +
				"nationalizationOrInsolvency=" + this.nationalizationOrInsolvency + ", " +
				"representations=" + this.representations + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents +
			'}';
		}
	}
}
