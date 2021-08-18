package cdm.product.asset;

import cdm.base.math.RateSchedule;
import cdm.base.math.RateSchedule.RateScheduleBuilder;
import cdm.base.math.RateSchedule.RateScheduleBuilderImpl;
import cdm.base.math.RateSchedule.RateScheduleImpl;
import cdm.base.math.Step;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price;
import cdm.observable.asset.metafields.ReferenceWithMetaPrice;
import cdm.product.asset.meta.SpreadScheduleMeta;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum;
import cdm.product.asset.metafields.FieldWithMetaSpreadScheduleTypeEnum.FieldWithMetaSpreadScheduleTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Adds an optional spread type element to the Schedule to identify a long or short spread value.
 * @version ${project.version}
 */
@RosettaClass

public interface SpreadSchedule extends RateSchedule {
	SpreadSchedule build();
	SpreadSchedule.SpreadScheduleBuilder toBuilder();
	
	/**
	 * An element which purpose is to identify a long or short spread value.
	 */
	FieldWithMetaSpreadScheduleTypeEnum getSpreadScheduleType();
	final static SpreadScheduleMeta metaData = new SpreadScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends SpreadSchedule> metaData() {
		return metaData;
	} 
			
	static SpreadSchedule.SpreadScheduleBuilder builder() {
		return new SpreadSchedule.SpreadScheduleBuilderImpl();
	}
	
	default Class<? extends SpreadSchedule> getType() {
		return SpreadSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.math.RateSchedule.super.process(path, processor);
		
		processRosetta(path.newSubPath("spreadScheduleType"), processor, FieldWithMetaSpreadScheduleTypeEnum.class, getSpreadScheduleType());
	}
	
	
	interface SpreadScheduleBuilder extends SpreadSchedule, RateSchedule.RateScheduleBuilder, RosettaModelObjectBuilder {
		FieldWithMetaSpreadScheduleTypeEnumBuilder getOrCreateSpreadScheduleType();
		FieldWithMetaSpreadScheduleTypeEnumBuilder getSpreadScheduleType();
		SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleType(FieldWithMetaSpreadScheduleTypeEnum spreadScheduleType);
		SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleTypeValue(SpreadScheduleTypeEnum spreadScheduleType);
		SpreadSchedule.SpreadScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue);
		SpreadSchedule.SpreadScheduleBuilder setInitialValueValue(Price initialValue);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step);
		SpreadSchedule.SpreadScheduleBuilder addStep(Step step, int _idx);
		SpreadSchedule.SpreadScheduleBuilder addStep(List<? extends Step> step);
		SpreadSchedule.SpreadScheduleBuilder setStep(List<? extends Step> step);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			RateSchedule.RateScheduleBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("spreadScheduleType"), processor, FieldWithMetaSpreadScheduleTypeEnumBuilder.class, getSpreadScheduleType());
		}
		
	}
	
	//SpreadSchedule.SpreadScheduleImpl
	class SpreadScheduleImpl extends RateSchedule.RateScheduleImpl implements SpreadSchedule {
		private final FieldWithMetaSpreadScheduleTypeEnum spreadScheduleType;
		
		protected SpreadScheduleImpl(SpreadSchedule.SpreadScheduleBuilder builder) {
			super(builder);
			this.spreadScheduleType = ofNullable(builder.getSpreadScheduleType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnum getSpreadScheduleType() {
			return spreadScheduleType;
		}
		
		@Override
		public SpreadSchedule build() {
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			SpreadSchedule.SpreadScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadSchedule.SpreadScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSpreadScheduleType()).ifPresent(builder::setSpreadScheduleType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(spreadScheduleType, _that.getSpreadScheduleType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadScheduleType != null ? spreadScheduleType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadSchedule {" +
				"spreadScheduleType=" + this.spreadScheduleType +
			'}' + " " + super.toString();
		}
	}
	
	//SpreadSchedule.SpreadScheduleBuilderImpl
	class SpreadScheduleBuilderImpl extends RateSchedule.RateScheduleBuilderImpl  implements SpreadSchedule.SpreadScheduleBuilder {
	
		protected FieldWithMetaSpreadScheduleTypeEnumBuilder spreadScheduleType;
	
		public SpreadScheduleBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaSpreadScheduleTypeEnumBuilder getSpreadScheduleType() {
			return spreadScheduleType;
		}
		
		@Override
		public FieldWithMetaSpreadScheduleTypeEnumBuilder getOrCreateSpreadScheduleType() {
			FieldWithMetaSpreadScheduleTypeEnumBuilder result;
			if (spreadScheduleType!=null) {
				result = spreadScheduleType;
			}
			else {
				result = spreadScheduleType = FieldWithMetaSpreadScheduleTypeEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleType(FieldWithMetaSpreadScheduleTypeEnum spreadScheduleType) {
			this.spreadScheduleType = spreadScheduleType==null?null:spreadScheduleType.toBuilder();
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setSpreadScheduleTypeValue(SpreadScheduleTypeEnum spreadScheduleType) {
			this.getOrCreateSpreadScheduleType().setValue(spreadScheduleType);
			return this;
		}
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setInitialValue(ReferenceWithMetaPrice initialValue) {
			this.initialValue = initialValue==null?null:initialValue.toBuilder();
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder setInitialValueValue(Price initialValue) {
			this.getOrCreateInitialValue().setValue(initialValue);
			return this;
		}
		@Override
		public SpreadSchedule.SpreadScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public SpreadSchedule.SpreadScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SpreadSchedule.SpreadScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SpreadSchedule build() {
			return new SpreadSchedule.SpreadScheduleImpl(this);
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder prune() {
			super.prune();
			if (spreadScheduleType!=null && !spreadScheduleType.prune().hasData()) spreadScheduleType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSpreadScheduleType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadSchedule.SpreadScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpreadSchedule.SpreadScheduleBuilder o = (SpreadSchedule.SpreadScheduleBuilder) other;
			
			merger.mergeRosetta(getSpreadScheduleType(), o.getSpreadScheduleType(), this::setSpreadScheduleType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadSchedule _that = getType().cast(o);
		
			if (!Objects.equals(spreadScheduleType, _that.getSpreadScheduleType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadScheduleType != null ? spreadScheduleType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleBuilder {" +
				"spreadScheduleType=" + this.spreadScheduleType +
			'}' + " " + super.toString();
		}
	}
}
