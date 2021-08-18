package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum.FieldWithMetaFloatingRateIndexEnumBuilder;
import cdm.observable.asset.meta.InterestRateCurveMeta;
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

public interface InterestRateCurve extends RosettaModelObject {
	InterestRateCurve build();
	InterestRateCurve.InterestRateCurveBuilder toBuilder();
	
	/**
	 */
	FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex();
	/**
	 */
	Period getTenor();
	final static InterestRateCurveMeta metaData = new InterestRateCurveMeta();
	
	@Override
	default RosettaMetaData<? extends InterestRateCurve> metaData() {
		return metaData;
	} 
			
	static InterestRateCurve.InterestRateCurveBuilder builder() {
		return new InterestRateCurve.InterestRateCurveBuilderImpl();
	}
	
	default Class<? extends InterestRateCurve> getType() {
		return InterestRateCurve.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnum.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
	}
	
	
	interface InterestRateCurveBuilder extends InterestRateCurve, RosettaModelObjectBuilder {
		FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex();
		FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateTenor();
		Period.PeriodBuilder getTenor();
		InterestRateCurve.InterestRateCurveBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex);
		InterestRateCurve.InterestRateCurveBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex);
		InterestRateCurve.InterestRateCurveBuilder setTenor(Period tenor);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FieldWithMetaFloatingRateIndexEnumBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
		}
		
	}
	
	//InterestRateCurve.InterestRateCurveImpl
	class InterestRateCurveImpl implements InterestRateCurve {
		private final FieldWithMetaFloatingRateIndexEnum floatingRateIndex;
		private final Period tenor;
		
		protected InterestRateCurveImpl(InterestRateCurve.InterestRateCurveBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		public InterestRateCurve build() {
			return this;
		}
		
		@Override
		public InterestRateCurve.InterestRateCurveBuilder toBuilder() {
			InterestRateCurve.InterestRateCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateCurve.InterestRateCurveBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getTenor()).ifPresent(builder::setTenor);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateCurve {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
	
	//InterestRateCurve.InterestRateCurveBuilderImpl
	class InterestRateCurveBuilderImpl implements InterestRateCurve.InterestRateCurveBuilder {
	
		protected FieldWithMetaFloatingRateIndexEnumBuilder floatingRateIndex;
		protected Period.PeriodBuilder tenor;
	
		public InterestRateCurveBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndexEnumBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndexEnumBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndexEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InterestRateCurve.InterestRateCurveBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateCurve.InterestRateCurveBuilder setFloatingRateIndexValue(FloatingRateIndexEnum floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(floatingRateIndex);
			return this;
		}
		@Override
		public InterestRateCurve.InterestRateCurveBuilder setTenor(Period tenor) {
			this.tenor = tenor==null?null:tenor.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateCurve build() {
			return new InterestRateCurve.InterestRateCurveImpl(this);
		}
		
		@Override
		public InterestRateCurve.InterestRateCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateCurve.InterestRateCurveBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null) return true;
			if (getTenor()!=null && getTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateCurve.InterestRateCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateCurve.InterestRateCurveBuilder o = (InterestRateCurve.InterestRateCurveBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateCurve _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateCurveBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
}
