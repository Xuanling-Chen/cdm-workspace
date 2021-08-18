package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.meta.EuropeanExerciseMeta;
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
 * A class defining the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 * @version ${project.version}
 */
@RosettaClass

public interface EuropeanExercise extends RosettaModelObject, GlobalKey {
	EuropeanExercise build();
	EuropeanExercise.EuropeanExerciseBuilder toBuilder();
	
	/**
	 * The earliest time at which notice of exercise can be given by the buyer to the seller (or seller&#39;s agent) on the expiration date.
	 */
	BusinessCenterTime getEarliestExerciseTime();
	/**
	 * A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
	 */
	ExerciseFee getExerciseFee();
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 */
	AdjustableOrRelativeDate getExpirationDate();
	/**
	 * The latest time for exercise on expirationDate.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 */
	MetaFields getMeta();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 */
	PartialExercise getPartialExercise();
	/**
	 * The effective date on the underlying product if the option is exercised.  For example, for a swaption it is the swap effective date, for an option on an FX spot or forward it is the value date for settlement, and in an extendible/cancelable provision it is the swap termination date, which is the date on which the termination is effective.
	 */
	AdjustableOrRelativeDates getRelevantUnderlyingDate();
	final static EuropeanExerciseMeta metaData = new EuropeanExerciseMeta();
	
	@Override
	default RosettaMetaData<? extends EuropeanExercise> metaData() {
		return metaData;
	} 
			
	static EuropeanExercise.EuropeanExerciseBuilder builder() {
		return new EuropeanExercise.EuropeanExerciseBuilderImpl();
	}
	
	default Class<? extends EuropeanExercise> getType() {
		return EuropeanExercise.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.class, getExerciseFee());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.class, getPartialExercise());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
	}
	
	
	interface EuropeanExerciseBuilder extends EuropeanExercise, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee();
		ExerciseFee.ExerciseFeeBuilder getExerciseFee();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise();
		PartialExercise.PartialExerciseBuilder getPartialExercise();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee exerciseFee);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		EuropeanExercise.EuropeanExerciseBuilder setMeta(MetaFields meta);
		EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise partialExercise);
		EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.ExerciseFeeBuilder.class, getExerciseFee());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.PartialExerciseBuilder.class, getPartialExercise());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
		}
		
	}
	
	//EuropeanExercise.EuropeanExerciseImpl
	class EuropeanExerciseImpl implements EuropeanExercise {
		private final BusinessCenterTime earliestExerciseTime;
		private final ExerciseFee exerciseFee;
		private final AdjustableOrRelativeDate expirationDate;
		private final BusinessCenterTime expirationTime;
		private final MetaFields meta;
		private final PartialExercise partialExercise;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		
		protected EuropeanExerciseImpl(EuropeanExercise.EuropeanExerciseBuilder builder) {
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.exerciseFee = ofNullable(builder.getExerciseFee()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.partialExercise = ofNullable(builder.getPartialExercise()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessCenterTime getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public ExerciseFee getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PartialExercise getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		public AdjustableOrRelativeDates getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public EuropeanExercise build() {
			return this;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			EuropeanExercise.EuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EuropeanExercise.EuropeanExerciseBuilder builder) {
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getExerciseFee()).ifPresent(builder::setExerciseFee);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPartialExercise()).ifPresent(builder::setPartialExercise);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExercise {" +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"exerciseFee=" + this.exerciseFee + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"meta=" + this.meta + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate +
			'}';
		}
	}
	
	//EuropeanExercise.EuropeanExerciseBuilderImpl
	class EuropeanExerciseBuilderImpl implements EuropeanExercise.EuropeanExerciseBuilder, GlobalKeyBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected ExerciseFee.ExerciseFeeBuilder exerciseFee;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PartialExercise.PartialExerciseBuilder partialExercise;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
	
		public EuropeanExerciseBuilderImpl() {
		}
	
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExerciseTime!=null) {
				result = earliestExerciseTime;
			}
			else {
				result = earliestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee() {
			ExerciseFee.ExerciseFeeBuilder result;
			if (exerciseFee!=null) {
				result = exerciseFee;
			}
			else {
				result = exerciseFee = ExerciseFee.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = BusinessCenterTime.builder();
			}
			
			return result;
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
		public PartialExercise.PartialExerciseBuilder getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise() {
			PartialExercise.PartialExerciseBuilder result;
			if (partialExercise!=null) {
				result = partialExercise;
			}
			else {
				result = partialExercise = PartialExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDate!=null) {
				result = relevantUnderlyingDate;
			}
			else {
				result = relevantUnderlyingDate = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
	
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime) {
			this.earliestExerciseTime = earliestExerciseTime==null?null:earliestExerciseTime.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee exerciseFee) {
			this.exerciseFee = exerciseFee==null?null:exerciseFee.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise partialExercise) {
			this.partialExercise = partialExercise==null?null:partialExercise.toBuilder();
			return this;
		}
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate) {
			this.relevantUnderlyingDate = relevantUnderlyingDate==null?null:relevantUnderlyingDate.toBuilder();
			return this;
		}
		
		@Override
		public EuropeanExercise build() {
			return new EuropeanExercise.EuropeanExerciseImpl(this);
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder prune() {
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (exerciseFee!=null && !exerciseFee.prune().hasData()) exerciseFee = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (partialExercise!=null && !partialExercise.prune().hasData()) partialExercise = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getExerciseFee()!=null && getExerciseFee().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getPartialExercise()!=null && getPartialExercise().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EuropeanExercise.EuropeanExerciseBuilder o = (EuropeanExercise.EuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getExerciseFee(), o.getExerciseFee(), this::setExerciseFee);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPartialExercise(), o.getPartialExercise(), this::setPartialExercise);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExerciseBuilder {" +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"exerciseFee=" + this.exerciseFee + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"meta=" + this.meta + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate +
			'}';
		}
	}
}
