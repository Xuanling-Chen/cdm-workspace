package cdm.event.common;

import cdm.event.common.meta.ExerciseEventMeta;
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
 * A data defining:  the adjusted dates associated with a particular exercise event.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseEvent extends RosettaModelObject, GlobalKey {
	ExerciseEvent build();
	ExerciseEvent.ExerciseEventBuilder toBuilder();
	
	/**
	 * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedCashSettlementPaymentDate();
	/**
	 * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedCashSettlementValuationDate();
	/**
	 * The date on which the option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseFeePaymentDate();
	/**
	 * The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedRelevantSwapEffectiveDate();
	/**
	 */
	MetaFields getMeta();
	final static ExerciseEventMeta metaData = new ExerciseEventMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseEvent> metaData() {
		return metaData;
	} 
			
	static ExerciseEvent.ExerciseEventBuilder builder() {
		return new ExerciseEvent.ExerciseEventBuilderImpl();
	}
	
	default Class<? extends ExerciseEvent> getType() {
		return ExerciseEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), Date.class, getAdjustedRelevantSwapEffectiveDate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface ExerciseEventBuilder extends ExerciseEvent, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate);
		ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(Date adjustedRelevantSwapEffectiveDate);
		ExerciseEvent.ExerciseEventBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedRelevantSwapEffectiveDate"), Date.class, getAdjustedRelevantSwapEffectiveDate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//ExerciseEvent.ExerciseEventImpl
	class ExerciseEventImpl implements ExerciseEvent {
		private final Date adjustedCashSettlementPaymentDate;
		private final Date adjustedCashSettlementValuationDate;
		private final Date adjustedExerciseDate;
		private final Date adjustedExerciseFeePaymentDate;
		private final Date adjustedRelevantSwapEffectiveDate;
		private final MetaFields meta;
		
		protected ExerciseEventImpl(ExerciseEvent.ExerciseEventBuilder builder) {
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedExerciseFeePaymentDate = builder.getAdjustedExerciseFeePaymentDate();
			this.adjustedRelevantSwapEffectiveDate = builder.getAdjustedRelevantSwapEffectiveDate();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		public Date getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@Override
		public Date getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ExerciseEvent build() {
			return this;
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			ExerciseEvent.ExerciseEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseEvent.ExerciseEventBuilder builder) {
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
			ofNullable(getAdjustedRelevantSwapEffectiveDate()).ifPresent(builder::setAdjustedRelevantSwapEffectiveDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEvent {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//ExerciseEvent.ExerciseEventBuilderImpl
	class ExerciseEventBuilderImpl implements ExerciseEvent.ExerciseEventBuilder, GlobalKeyBuilder {
	
		protected Date adjustedCashSettlementPaymentDate;
		protected Date adjustedCashSettlementValuationDate;
		protected Date adjustedExerciseDate;
		protected Date adjustedExerciseFeePaymentDate;
		protected Date adjustedRelevantSwapEffectiveDate;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public ExerciseEventBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedCashSettlementPaymentDate() {
			return adjustedCashSettlementPaymentDate;
		}
		
		@Override
		public Date getAdjustedCashSettlementValuationDate() {
			return adjustedCashSettlementValuationDate;
		}
		
		@Override
		public Date getAdjustedExerciseDate() {
			return adjustedExerciseDate;
		}
		
		@Override
		public Date getAdjustedExerciseFeePaymentDate() {
			return adjustedExerciseFeePaymentDate;
		}
		
		@Override
		public Date getAdjustedRelevantSwapEffectiveDate() {
			return adjustedRelevantSwapEffectiveDate;
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
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = adjustedCashSettlementPaymentDate==null?null:adjustedCashSettlementPaymentDate;
			return this;
		}
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = adjustedCashSettlementValuationDate==null?null:adjustedCashSettlementValuationDate;
			return this;
		}
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = adjustedExerciseFeePaymentDate==null?null:adjustedExerciseFeePaymentDate;
			return this;
		}
		@Override
		public ExerciseEvent.ExerciseEventBuilder setAdjustedRelevantSwapEffectiveDate(Date adjustedRelevantSwapEffectiveDate) {
			this.adjustedRelevantSwapEffectiveDate = adjustedRelevantSwapEffectiveDate==null?null:adjustedRelevantSwapEffectiveDate;
			return this;
		}
		@Override
		public ExerciseEvent.ExerciseEventBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseEvent build() {
			return new ExerciseEvent.ExerciseEventImpl(this);
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			if (getAdjustedRelevantSwapEffectiveDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseEvent.ExerciseEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseEvent.ExerciseEventBuilder o = (ExerciseEvent.ExerciseEventBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedExerciseFeePaymentDate(), o.getAdjustedExerciseFeePaymentDate(), this::setAdjustedExerciseFeePaymentDate);
			merger.mergeBasic(getAdjustedRelevantSwapEffectiveDate(), o.getAdjustedRelevantSwapEffectiveDate(), this::setAdjustedRelevantSwapEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(adjustedRelevantSwapEffectiveDate, _that.getAdjustedRelevantSwapEffectiveDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedRelevantSwapEffectiveDate != null ? adjustedRelevantSwapEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseEventBuilder {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"adjustedRelevantSwapEffectiveDate=" + this.adjustedRelevantSwapEffectiveDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
