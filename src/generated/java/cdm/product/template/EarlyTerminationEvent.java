package cdm.product.template;

import cdm.product.template.meta.EarlyTerminationEventMeta;
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
 * A data to:  define the adjusted dates associated with an early termination provision.
 * @version ${project.version}
 */
@RosettaClass

public interface EarlyTerminationEvent extends RosettaModelObject, GlobalKey {
	EarlyTerminationEvent build();
	EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder();
	
	/**
	 * The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business date convention.
	 */
	Date getAdjustedCashSettlementPaymentDate();
	/**
	 * The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedCashSettlementValuationDate();
	/**
	 * The early termination date that is applicable if an early termination provision is exercised. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedEarlyTerminationDate();
	/**
	 * The date on which option exercise takes place. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseDate();
	/**
	 * The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedExerciseFeePaymentDate();
	/**
	 */
	MetaFields getMeta();
	final static EarlyTerminationEventMeta metaData = new EarlyTerminationEventMeta();
	
	@Override
	default RosettaMetaData<? extends EarlyTerminationEvent> metaData() {
		return metaData;
	} 
			
	static EarlyTerminationEvent.EarlyTerminationEventBuilder builder() {
		return new EarlyTerminationEvent.EarlyTerminationEventBuilderImpl();
	}
	
	default Class<? extends EarlyTerminationEvent> getType() {
		return EarlyTerminationEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
		processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
		processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface EarlyTerminationEventBuilder extends EarlyTerminationEvent, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate);
		EarlyTerminationEvent.EarlyTerminationEventBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedCashSettlementPaymentDate"), Date.class, getAdjustedCashSettlementPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedCashSettlementValuationDate"), Date.class, getAdjustedCashSettlementValuationDate(), this);
			processor.processBasic(path.newSubPath("adjustedEarlyTerminationDate"), Date.class, getAdjustedEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseDate"), Date.class, getAdjustedExerciseDate(), this);
			processor.processBasic(path.newSubPath("adjustedExerciseFeePaymentDate"), Date.class, getAdjustedExerciseFeePaymentDate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//EarlyTerminationEvent.EarlyTerminationEventImpl
	class EarlyTerminationEventImpl implements EarlyTerminationEvent {
		private final Date adjustedCashSettlementPaymentDate;
		private final Date adjustedCashSettlementValuationDate;
		private final Date adjustedEarlyTerminationDate;
		private final Date adjustedExerciseDate;
		private final Date adjustedExerciseFeePaymentDate;
		private final MetaFields meta;
		
		protected EarlyTerminationEventImpl(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			this.adjustedCashSettlementPaymentDate = builder.getAdjustedCashSettlementPaymentDate();
			this.adjustedCashSettlementValuationDate = builder.getAdjustedCashSettlementValuationDate();
			this.adjustedEarlyTerminationDate = builder.getAdjustedEarlyTerminationDate();
			this.adjustedExerciseDate = builder.getAdjustedExerciseDate();
			this.adjustedExerciseFeePaymentDate = builder.getAdjustedExerciseFeePaymentDate();
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
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
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
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public EarlyTerminationEvent build() {
			return this;
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			EarlyTerminationEvent.EarlyTerminationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationEvent.EarlyTerminationEventBuilder builder) {
			ofNullable(getAdjustedCashSettlementPaymentDate()).ifPresent(builder::setAdjustedCashSettlementPaymentDate);
			ofNullable(getAdjustedCashSettlementValuationDate()).ifPresent(builder::setAdjustedCashSettlementValuationDate);
			ofNullable(getAdjustedEarlyTerminationDate()).ifPresent(builder::setAdjustedEarlyTerminationDate);
			ofNullable(getAdjustedExerciseDate()).ifPresent(builder::setAdjustedExerciseDate);
			ofNullable(getAdjustedExerciseFeePaymentDate()).ifPresent(builder::setAdjustedExerciseFeePaymentDate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEvent {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//EarlyTerminationEvent.EarlyTerminationEventBuilderImpl
	class EarlyTerminationEventBuilderImpl implements EarlyTerminationEvent.EarlyTerminationEventBuilder, GlobalKeyBuilder {
	
		protected Date adjustedCashSettlementPaymentDate;
		protected Date adjustedCashSettlementValuationDate;
		protected Date adjustedEarlyTerminationDate;
		protected Date adjustedExerciseDate;
		protected Date adjustedExerciseFeePaymentDate;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public EarlyTerminationEventBuilderImpl() {
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
		public Date getAdjustedEarlyTerminationDate() {
			return adjustedEarlyTerminationDate;
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
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementPaymentDate(Date adjustedCashSettlementPaymentDate) {
			this.adjustedCashSettlementPaymentDate = adjustedCashSettlementPaymentDate==null?null:adjustedCashSettlementPaymentDate;
			return this;
		}
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedCashSettlementValuationDate(Date adjustedCashSettlementValuationDate) {
			this.adjustedCashSettlementValuationDate = adjustedCashSettlementValuationDate==null?null:adjustedCashSettlementValuationDate;
			return this;
		}
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedEarlyTerminationDate(Date adjustedEarlyTerminationDate) {
			this.adjustedEarlyTerminationDate = adjustedEarlyTerminationDate==null?null:adjustedEarlyTerminationDate;
			return this;
		}
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseDate(Date adjustedExerciseDate) {
			this.adjustedExerciseDate = adjustedExerciseDate==null?null:adjustedExerciseDate;
			return this;
		}
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setAdjustedExerciseFeePaymentDate(Date adjustedExerciseFeePaymentDate) {
			this.adjustedExerciseFeePaymentDate = adjustedExerciseFeePaymentDate==null?null:adjustedExerciseFeePaymentDate;
			return this;
		}
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public EarlyTerminationEvent build() {
			return new EarlyTerminationEvent.EarlyTerminationEventImpl(this);
		}
		
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedCashSettlementPaymentDate()!=null) return true;
			if (getAdjustedCashSettlementValuationDate()!=null) return true;
			if (getAdjustedEarlyTerminationDate()!=null) return true;
			if (getAdjustedExerciseDate()!=null) return true;
			if (getAdjustedExerciseFeePaymentDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationEvent.EarlyTerminationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationEvent.EarlyTerminationEventBuilder o = (EarlyTerminationEvent.EarlyTerminationEventBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getAdjustedCashSettlementPaymentDate(), o.getAdjustedCashSettlementPaymentDate(), this::setAdjustedCashSettlementPaymentDate);
			merger.mergeBasic(getAdjustedCashSettlementValuationDate(), o.getAdjustedCashSettlementValuationDate(), this::setAdjustedCashSettlementValuationDate);
			merger.mergeBasic(getAdjustedEarlyTerminationDate(), o.getAdjustedEarlyTerminationDate(), this::setAdjustedEarlyTerminationDate);
			merger.mergeBasic(getAdjustedExerciseDate(), o.getAdjustedExerciseDate(), this::setAdjustedExerciseDate);
			merger.mergeBasic(getAdjustedExerciseFeePaymentDate(), o.getAdjustedExerciseFeePaymentDate(), this::setAdjustedExerciseFeePaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(adjustedCashSettlementPaymentDate, _that.getAdjustedCashSettlementPaymentDate())) return false;
			if (!Objects.equals(adjustedCashSettlementValuationDate, _that.getAdjustedCashSettlementValuationDate())) return false;
			if (!Objects.equals(adjustedEarlyTerminationDate, _that.getAdjustedEarlyTerminationDate())) return false;
			if (!Objects.equals(adjustedExerciseDate, _that.getAdjustedExerciseDate())) return false;
			if (!Objects.equals(adjustedExerciseFeePaymentDate, _that.getAdjustedExerciseFeePaymentDate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedCashSettlementPaymentDate != null ? adjustedCashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedCashSettlementValuationDate != null ? adjustedCashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEarlyTerminationDate != null ? adjustedEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseDate != null ? adjustedExerciseDate.hashCode() : 0);
			_result = 31 * _result + (adjustedExerciseFeePaymentDate != null ? adjustedExerciseFeePaymentDate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationEventBuilder {" +
				"adjustedCashSettlementPaymentDate=" + this.adjustedCashSettlementPaymentDate + ", " +
				"adjustedCashSettlementValuationDate=" + this.adjustedCashSettlementValuationDate + ", " +
				"adjustedEarlyTerminationDate=" + this.adjustedEarlyTerminationDate + ", " +
				"adjustedExerciseDate=" + this.adjustedExerciseDate + ", " +
				"adjustedExerciseFeePaymentDate=" + this.adjustedExerciseFeePaymentDate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
