package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.meta.BermudaExerciseMeta;
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
 * A class defining the Bermuda option exercise dates and the expiration date together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fee.
 * @version ${project.version}
 */
@RosettaClass

public interface BermudaExercise extends RosettaModelObject, GlobalKey {
	BermudaExercise build();
	BermudaExercise.BermudaExerciseBuilder toBuilder();
	
	/**
	 * The dates that define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
	 */
	AdjustableOrRelativeDates getBermudaExerciseDates();
	/**
	 * The earliest time at which notice of exercise can be given by the buyer to the seller (or seller&#39;s agent) on each Bermuda option exercise date and the expiration date.
	 */
	BusinessCenterTime getEarliestExerciseTime();
	/**
	 * The fees associated with an exercise date. The fees are conditional on the exercise occurring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
	 */
	ExerciseFeeSchedule getExerciseFeeSchedule();
	/**
	 * The latest time for exercise on expirationDate.
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 */
	MetaFields getMeta();
	/**
	 * As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 */
	MultipleExercise getMultipleExercise();
	/**
	 * The effective date on the underlying product if the option is exercised.  For example, for a swaption it is the swap effective date, for an option on an FX spot or forward it is the value date for settlement, and in an extendible/cancelable provision it is the swap termination date, which is the date on which the termination is effective.
	 */
	AdjustableOrRelativeDates getRelevantUnderlyingDate();
	final static BermudaExerciseMeta metaData = new BermudaExerciseMeta();
	
	@Override
	default RosettaMetaData<? extends BermudaExercise> metaData() {
		return metaData;
	} 
			
	static BermudaExercise.BermudaExerciseBuilder builder() {
		return new BermudaExercise.BermudaExerciseBuilderImpl();
	}
	
	default Class<? extends BermudaExercise> getType() {
		return BermudaExercise.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("bermudaExerciseDates"), processor, AdjustableOrRelativeDates.class, getBermudaExerciseDates());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.class, getExerciseFeeSchedule());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.class, getMultipleExercise());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
	}
	
	
	interface BermudaExerciseBuilder extends BermudaExercise, RosettaModelObjectBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateBermudaExerciseDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getBermudaExerciseDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise();
		MultipleExercise.MultipleExerciseBuilder getMultipleExercise();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BermudaExercise.BermudaExerciseBuilder setBermudaExerciseDates(AdjustableOrRelativeDates bermudaExerciseDates);
		BermudaExercise.BermudaExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		BermudaExercise.BermudaExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule);
		BermudaExercise.BermudaExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		BermudaExercise.BermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		BermudaExercise.BermudaExerciseBuilder setMeta(MetaFields meta);
		BermudaExercise.BermudaExerciseBuilder setMultipleExercise(MultipleExercise multipleExercise);
		BermudaExercise.BermudaExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("bermudaExerciseDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getBermudaExerciseDates());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.ExerciseFeeScheduleBuilder.class, getExerciseFeeSchedule());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.MultipleExerciseBuilder.class, getMultipleExercise());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
		}
		
	}
	
	//BermudaExercise.BermudaExerciseImpl
	class BermudaExerciseImpl implements BermudaExercise {
		private final AdjustableOrRelativeDates bermudaExerciseDates;
		private final BusinessCenterTime earliestExerciseTime;
		private final ExerciseFeeSchedule exerciseFeeSchedule;
		private final BusinessCenterTime expirationTime;
		private final BusinessCenterTime latestExerciseTime;
		private final MetaFields meta;
		private final MultipleExercise multipleExercise;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		
		protected BermudaExerciseImpl(BermudaExercise.BermudaExerciseBuilder builder) {
			this.bermudaExerciseDates = ofNullable(builder.getBermudaExerciseDates()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.exerciseFeeSchedule = ofNullable(builder.getExerciseFeeSchedule()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableOrRelativeDates getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		public BusinessCenterTime getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public ExerciseFeeSchedule getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public MultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public AdjustableOrRelativeDates getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public BermudaExercise build() {
			return this;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder toBuilder() {
			BermudaExercise.BermudaExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BermudaExercise.BermudaExerciseBuilder builder) {
			ofNullable(getBermudaExerciseDates()).ifPresent(builder::setBermudaExerciseDates);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getExerciseFeeSchedule()).ifPresent(builder::setExerciseFeeSchedule);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BermudaExercise {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"meta=" + this.meta + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate +
			'}';
		}
	}
	
	//BermudaExercise.BermudaExerciseBuilderImpl
	class BermudaExerciseBuilderImpl implements BermudaExercise.BermudaExerciseBuilder, GlobalKeyBuilder {
	
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder bermudaExerciseDates;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected MetaFields.MetaFieldsBuilder meta;
		protected MultipleExercise.MultipleExerciseBuilder multipleExercise;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
	
		public BermudaExerciseBuilderImpl() {
		}
	
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateBermudaExerciseDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (bermudaExerciseDates!=null) {
				result = bermudaExerciseDates;
			}
			else {
				result = bermudaExerciseDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
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
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder result;
			if (exerciseFeeSchedule!=null) {
				result = exerciseFeeSchedule;
			}
			else {
				result = exerciseFeeSchedule = ExerciseFeeSchedule.builder();
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
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = BusinessCenterTime.builder();
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
		public MultipleExercise.MultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise() {
			MultipleExercise.MultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = MultipleExercise.builder();
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
		public BermudaExercise.BermudaExerciseBuilder setBermudaExerciseDates(AdjustableOrRelativeDates bermudaExerciseDates) {
			this.bermudaExerciseDates = bermudaExerciseDates==null?null:bermudaExerciseDates.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime) {
			this.earliestExerciseTime = earliestExerciseTime==null?null:earliestExerciseTime.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule) {
			this.exerciseFeeSchedule = exerciseFeeSchedule==null?null:exerciseFeeSchedule.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setMultipleExercise(MultipleExercise multipleExercise) {
			this.multipleExercise = multipleExercise==null?null:multipleExercise.toBuilder();
			return this;
		}
		@Override
		public BermudaExercise.BermudaExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate) {
			this.relevantUnderlyingDate = relevantUnderlyingDate==null?null:relevantUnderlyingDate.toBuilder();
			return this;
		}
		
		@Override
		public BermudaExercise build() {
			return new BermudaExercise.BermudaExerciseImpl(this);
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BermudaExercise.BermudaExerciseBuilder prune() {
			if (bermudaExerciseDates!=null && !bermudaExerciseDates.prune().hasData()) bermudaExerciseDates = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (exerciseFeeSchedule!=null && !exerciseFeeSchedule.prune().hasData()) exerciseFeeSchedule = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBermudaExerciseDates()!=null && getBermudaExerciseDates().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getExerciseFeeSchedule()!=null && getExerciseFeeSchedule().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BermudaExercise.BermudaExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BermudaExercise.BermudaExerciseBuilder o = (BermudaExercise.BermudaExerciseBuilder) other;
			
			merger.mergeRosetta(getBermudaExerciseDates(), o.getBermudaExerciseDates(), this::setBermudaExerciseDates);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getExerciseFeeSchedule(), o.getExerciseFeeSchedule(), this::setExerciseFeeSchedule);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BermudaExerciseBuilder {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"meta=" + this.meta + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate +
			'}';
		}
	}
}
