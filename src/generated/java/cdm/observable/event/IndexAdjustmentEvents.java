package cdm.observable.event;

import cdm.observable.event.meta.IndexAdjustmentEventsMeta;
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
 * Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 * @version ${project.version}
 */
@RosettaClass

public interface IndexAdjustmentEvents extends RosettaModelObject {
	IndexAdjustmentEvents build();
	IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder();
	
	/**
	 * Consequence of index cancellation.
	 */
	IndexEventConsequenceEnum getIndexCancellation();
	/**
	 * Consequence of index disruption.
	 */
	IndexEventConsequenceEnum getIndexDisruption();
	/**
	 * Consequence of index modification.
	 */
	IndexEventConsequenceEnum getIndexModification();
	final static IndexAdjustmentEventsMeta metaData = new IndexAdjustmentEventsMeta();
	
	@Override
	default RosettaMetaData<? extends IndexAdjustmentEvents> metaData() {
		return metaData;
	} 
			
	static IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder() {
		return new IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl();
	}
	
	default Class<? extends IndexAdjustmentEvents> getType() {
		return IndexAdjustmentEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
		processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
		processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
		
	}
	
	
	interface IndexAdjustmentEventsBuilder extends IndexAdjustmentEvents, RosettaModelObjectBuilder {
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum indexCancellation);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum indexDisruption);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum indexModification);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
			processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
			processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
			
		}
		
	}
	
	//IndexAdjustmentEvents.IndexAdjustmentEventsImpl
	class IndexAdjustmentEventsImpl implements IndexAdjustmentEvents {
		private final IndexEventConsequenceEnum indexCancellation;
		private final IndexEventConsequenceEnum indexDisruption;
		private final IndexEventConsequenceEnum indexModification;
		
		protected IndexAdjustmentEventsImpl(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			this.indexCancellation = builder.getIndexCancellation();
			this.indexDisruption = builder.getIndexDisruption();
			this.indexModification = builder.getIndexModification();
		}
		
		@Override
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@Override
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			ofNullable(getIndexCancellation()).ifPresent(builder::setIndexCancellation);
			ofNullable(getIndexDisruption()).ifPresent(builder::setIndexDisruption);
			ofNullable(getIndexModification()).ifPresent(builder::setIndexModification);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEvents {" +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption + ", " +
				"indexModification=" + this.indexModification +
			'}';
		}
	}
	
	//IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl
	class IndexAdjustmentEventsBuilderImpl implements IndexAdjustmentEvents.IndexAdjustmentEventsBuilder {
	
		protected IndexEventConsequenceEnum indexCancellation;
		protected IndexEventConsequenceEnum indexDisruption;
		protected IndexEventConsequenceEnum indexModification;
	
		public IndexAdjustmentEventsBuilderImpl() {
		}
	
		@Override
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@Override
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
	
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum indexCancellation) {
			this.indexCancellation = indexCancellation==null?null:indexCancellation;
			return this;
		}
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum indexDisruption) {
			this.indexDisruption = indexDisruption==null?null:indexDisruption;
			return this;
		}
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum indexModification) {
			this.indexModification = indexModification==null?null:indexModification;
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return new IndexAdjustmentEvents.IndexAdjustmentEventsImpl(this);
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexCancellation()!=null) return true;
			if (getIndexDisruption()!=null) return true;
			if (getIndexModification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder o = (IndexAdjustmentEvents.IndexAdjustmentEventsBuilder) other;
			
			
			merger.mergeBasic(getIndexCancellation(), o.getIndexCancellation(), this::setIndexCancellation);
			merger.mergeBasic(getIndexDisruption(), o.getIndexDisruption(), this::setIndexDisruption);
			merger.mergeBasic(getIndexModification(), o.getIndexModification(), this::setIndexModification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEventsBuilder {" +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption + ", " +
				"indexModification=" + this.indexModification +
			'}';
		}
	}
}
