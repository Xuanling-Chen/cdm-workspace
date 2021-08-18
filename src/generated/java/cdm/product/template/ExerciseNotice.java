package cdm.product.template;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.meta.ExerciseNoticeMeta;
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
 * Defines to whom and where notice of execution should be given. The exerciseNoticeGiver refers to one or both of the principal parties of the trade. If present the exerciseNoticeReceiver refers to a party, other than the principal party, to whom notice should be given.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseNotice extends RosettaModelObject {
	ExerciseNotice build();
	ExerciseNotice.ExerciseNoticeBuilder toBuilder();
	
	/**
	 * Specifies the location where the exercise must be reported, e.g. where the exercise notice receiver is based.
	 */
	FieldWithMetaBusinessCenterEnum getBusinessCenter();
	/**
	 * Specifies the principal party of the trade that has the right to exercise.
	 */
	ExerciseNoticeGiverEnum getExerciseNoticeGiver();
	/**
	 * Specifies the party to which notice of exercise should be given, e.g. by the buyer of the option. Although in many cases it is the buyer of the option who sends the exercise notice to the seller of the option, this component is reused, e.g. in case of OptionEarlyTermination, either or both parties have the right to exercise.
	 */
	AncillaryRoleEnum getExerciseNoticeReceiver();
	final static ExerciseNoticeMeta metaData = new ExerciseNoticeMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseNotice> metaData() {
		return metaData;
	} 
			
	static ExerciseNotice.ExerciseNoticeBuilder builder() {
		return new ExerciseNotice.ExerciseNoticeBuilderImpl();
	}
	
	default Class<? extends ExerciseNotice> getType() {
		return ExerciseNotice.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseNoticeGiver"), ExerciseNoticeGiverEnum.class, getExerciseNoticeGiver(), this);
		processor.processBasic(path.newSubPath("exerciseNoticeReceiver"), AncillaryRoleEnum.class, getExerciseNoticeReceiver(), this);
		
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
	}
	
	
	interface ExerciseNoticeBuilder extends ExerciseNotice, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter();
		FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter();
		ExerciseNotice.ExerciseNoticeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		ExerciseNotice.ExerciseNoticeBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter);
		ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticeGiver(ExerciseNoticeGiverEnum exerciseNoticeGiver);
		ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticeReceiver(AncillaryRoleEnum exerciseNoticeReceiver);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("exerciseNoticeGiver"), ExerciseNoticeGiverEnum.class, getExerciseNoticeGiver(), this);
			processor.processBasic(path.newSubPath("exerciseNoticeReceiver"), AncillaryRoleEnum.class, getExerciseNoticeReceiver(), this);
			
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
		}
		
	}
	
	//ExerciseNotice.ExerciseNoticeImpl
	class ExerciseNoticeImpl implements ExerciseNotice {
		private final FieldWithMetaBusinessCenterEnum businessCenter;
		private final ExerciseNoticeGiverEnum exerciseNoticeGiver;
		private final AncillaryRoleEnum exerciseNoticeReceiver;
		
		protected ExerciseNoticeImpl(ExerciseNotice.ExerciseNoticeBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.exerciseNoticeGiver = builder.getExerciseNoticeGiver();
			this.exerciseNoticeReceiver = builder.getExerciseNoticeReceiver();
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public ExerciseNoticeGiverEnum getExerciseNoticeGiver() {
			return exerciseNoticeGiver;
		}
		
		@Override
		public AncillaryRoleEnum getExerciseNoticeReceiver() {
			return exerciseNoticeReceiver;
		}
		
		@Override
		public ExerciseNotice build() {
			return this;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder toBuilder() {
			ExerciseNotice.ExerciseNoticeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseNotice.ExerciseNoticeBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getExerciseNoticeGiver()).ifPresent(builder::setExerciseNoticeGiver);
			ofNullable(getExerciseNoticeReceiver()).ifPresent(builder::setExerciseNoticeReceiver);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseNotice _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exerciseNoticeGiver, _that.getExerciseNoticeGiver())) return false;
			if (!Objects.equals(exerciseNoticeReceiver, _that.getExerciseNoticeReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseNoticeGiver != null ? exerciseNoticeGiver.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseNoticeReceiver != null ? exerciseNoticeReceiver.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseNotice {" +
				"businessCenter=" + this.businessCenter + ", " +
				"exerciseNoticeGiver=" + this.exerciseNoticeGiver + ", " +
				"exerciseNoticeReceiver=" + this.exerciseNoticeReceiver +
			'}';
		}
	}
	
	//ExerciseNotice.ExerciseNoticeBuilderImpl
	class ExerciseNoticeBuilderImpl implements ExerciseNotice.ExerciseNoticeBuilder {
	
		protected FieldWithMetaBusinessCenterEnumBuilder businessCenter;
		protected ExerciseNoticeGiverEnum exerciseNoticeGiver;
		protected AncillaryRoleEnum exerciseNoticeReceiver;
	
		public ExerciseNoticeBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter() {
			FieldWithMetaBusinessCenterEnumBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = FieldWithMetaBusinessCenterEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public ExerciseNoticeGiverEnum getExerciseNoticeGiver() {
			return exerciseNoticeGiver;
		}
		
		@Override
		public AncillaryRoleEnum getExerciseNoticeReceiver() {
			return exerciseNoticeReceiver;
		}
		
	
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter) {
			this.getOrCreateBusinessCenter().setValue(businessCenter);
			return this;
		}
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticeGiver(ExerciseNoticeGiverEnum exerciseNoticeGiver) {
			this.exerciseNoticeGiver = exerciseNoticeGiver==null?null:exerciseNoticeGiver;
			return this;
		}
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder setExerciseNoticeReceiver(AncillaryRoleEnum exerciseNoticeReceiver) {
			this.exerciseNoticeReceiver = exerciseNoticeReceiver==null?null:exerciseNoticeReceiver;
			return this;
		}
		
		@Override
		public ExerciseNotice build() {
			return new ExerciseNotice.ExerciseNoticeImpl(this);
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null) return true;
			if (getExerciseNoticeGiver()!=null) return true;
			if (getExerciseNoticeReceiver()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseNotice.ExerciseNoticeBuilder o = (ExerciseNotice.ExerciseNoticeBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			merger.mergeBasic(getExerciseNoticeGiver(), o.getExerciseNoticeGiver(), this::setExerciseNoticeGiver);
			merger.mergeBasic(getExerciseNoticeReceiver(), o.getExerciseNoticeReceiver(), this::setExerciseNoticeReceiver);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseNotice _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exerciseNoticeGiver, _that.getExerciseNoticeGiver())) return false;
			if (!Objects.equals(exerciseNoticeReceiver, _that.getExerciseNoticeReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseNoticeGiver != null ? exerciseNoticeGiver.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseNoticeReceiver != null ? exerciseNoticeReceiver.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseNoticeBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"exerciseNoticeGiver=" + this.exerciseNoticeGiver + ", " +
				"exerciseNoticeReceiver=" + this.exerciseNoticeReceiver +
			'}';
		}
	}
}
