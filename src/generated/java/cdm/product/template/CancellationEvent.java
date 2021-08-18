package cdm.product.template;

import cdm.product.template.meta.CancellationEventMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The adjusted dates for a specific cancellation date, including the adjusted exercise date and adjusted termination date.
 * @version ${project.version}
 */
@RosettaClass

public interface CancellationEvent extends RosettaModelObject, GlobalKey {
	CancellationEvent build();
	CancellationEvent.CancellationEventBuilder toBuilder();
	
	/**
	 * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedEarlyTerminationDate();
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 */
	MetaFields getMeta();
	final static CancellationEventMeta metaData = new CancellationEventMeta();
	
	@Override
	default RosettaMetaData<? extends CancellationEvent> metaData() {
		return metaData;
	} 
			
	static CancellationEvent.CancellationEventBuilder builder() {
		return new CancellationEvent.CancellationEventBuilderImpl();
	}
	
	default Class<? extends CancellationEvent> getType() {
		return CancellationEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface CancellationEventBuilder extends CancellationEvent, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate);
		CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		CancellationEvent.CancellationEventBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//CancellationEvent.CancellationEventImpl
	class CancellationEventImpl implements CancellationEvent {
		private final Date adjustedEarlyTerminationDate;
		private final Date adjustedExerciseDate;
		private final MetaFields meta;
		
		protected CancellationEventImpl(CancellationEvent.CancellationEventBuilder builder) {
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CancellationEvent build() {
			return this;
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			CancellationEvent.CancellationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancellationEvent.CancellationEventBuilder builder) {
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEvent {" +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//CancellationEvent.CancellationEventBuilderImpl
	class CancellationEventBuilderImpl implements CancellationEvent.CancellationEventBuilder, GlobalKeyBuilder {
	
		protected Date adjustedEarlyTerminationDate;
		protected Date adjustedExerciseDate;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public CancellationEventBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
		}
		
		@Override
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
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
		public CancellationEvent.CancellationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = adjustedEarlyTerminationDate==null?null:adjustedEarlyTerminationDate;
			return this;
		}
		@Override
		public CancellationEvent.CancellationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		public CancellationEvent.CancellationEventBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public CancellationEvent build() {
			return new CancellationEvent.CancellationEventImpl(this);
		}
		
		@Override
		public CancellationEvent.CancellationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancellationEvent.CancellationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancellationEvent.CancellationEventBuilder o = (CancellationEvent.CancellationEventBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancellationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancellationEventBuilder {" +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
