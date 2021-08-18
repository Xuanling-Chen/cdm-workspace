package cdm.product.template;

import cdm.event.position.AveragingObservation;
import cdm.product.template.meta.OptionFeatureMeta;
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
 * Defines additional optional features that can be included in an option contract.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionFeature extends RosettaModelObject {
	OptionFeature build();
	OptionFeature.OptionFeatureBuilder toBuilder();
	
	/**
	 * Defines an option feature in which an average market observation price is determined on valuation and compared to the strike to determine a settlement amount.
	 */
	AveragingObservation getAveragingRateFeature();
	/**
	 * Specifies a barrier feature.
	 */
	Barrier getBarrier();
	/**
	 * Describes a quanto or composite FX feature.
	 */
	FxFeature getFxFeature();
	/**
	 * Specifies a knock in or knock out feature.
	 */
	Knock getKnock();
	/**
	 * Specifies the rules for pass-through payments from the underlier, such as dividends.
	 */
	PassThrough getPassThrough();
	/**
	 * Defines a simple strategy feature.
	 */
	StrategyFeature getStrategyFeature();
	final static OptionFeatureMeta metaData = new OptionFeatureMeta();
	
	@Override
	default RosettaMetaData<? extends OptionFeature> metaData() {
		return metaData;
	} 
			
	static OptionFeature.OptionFeatureBuilder builder() {
		return new OptionFeature.OptionFeatureBuilderImpl();
	}
	
	default Class<? extends OptionFeature> getType() {
		return OptionFeature.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("averagingRateFeature"), processor, AveragingObservation.class, getAveragingRateFeature());
		processRosetta(path.newSubPath("barrier"), processor, Barrier.class, getBarrier());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("knock"), processor, Knock.class, getKnock());
		processRosetta(path.newSubPath("passThrough"), processor, PassThrough.class, getPassThrough());
		processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.class, getStrategyFeature());
	}
	
	
	interface OptionFeatureBuilder extends OptionFeature, RosettaModelObjectBuilder {
		AveragingObservation.AveragingObservationBuilder getOrCreateAveragingRateFeature();
		AveragingObservation.AveragingObservationBuilder getAveragingRateFeature();
		Barrier.BarrierBuilder getOrCreateBarrier();
		Barrier.BarrierBuilder getBarrier();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		Knock.KnockBuilder getOrCreateKnock();
		Knock.KnockBuilder getKnock();
		PassThrough.PassThroughBuilder getOrCreatePassThrough();
		PassThrough.PassThroughBuilder getPassThrough();
		StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature();
		StrategyFeature.StrategyFeatureBuilder getStrategyFeature();
		OptionFeature.OptionFeatureBuilder setAveragingRateFeature(AveragingObservation averagingRateFeature);
		OptionFeature.OptionFeatureBuilder setBarrier(Barrier barrier);
		OptionFeature.OptionFeatureBuilder setFxFeature(FxFeature fxFeature);
		OptionFeature.OptionFeatureBuilder setKnock(Knock knock);
		OptionFeature.OptionFeatureBuilder setPassThrough(PassThrough passThrough);
		OptionFeature.OptionFeatureBuilder setStrategyFeature(StrategyFeature strategyFeature);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("averagingRateFeature"), processor, AveragingObservation.AveragingObservationBuilder.class, getAveragingRateFeature());
			processRosetta(path.newSubPath("barrier"), processor, Barrier.BarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("knock"), processor, Knock.KnockBuilder.class, getKnock());
			processRosetta(path.newSubPath("passThrough"), processor, PassThrough.PassThroughBuilder.class, getPassThrough());
			processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.StrategyFeatureBuilder.class, getStrategyFeature());
		}
		
	}
	
	//OptionFeature.OptionFeatureImpl
	class OptionFeatureImpl implements OptionFeature {
		private final AveragingObservation averagingRateFeature;
		private final Barrier barrier;
		private final FxFeature fxFeature;
		private final Knock knock;
		private final PassThrough passThrough;
		private final StrategyFeature strategyFeature;
		
		protected OptionFeatureImpl(OptionFeature.OptionFeatureBuilder builder) {
			this.averagingRateFeature = ofNullable(builder.getAveragingRateFeature()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.knock = ofNullable(builder.getKnock()).map(f->f.build()).orElse(null);
			this.passThrough = ofNullable(builder.getPassThrough()).map(f->f.build()).orElse(null);
			this.strategyFeature = ofNullable(builder.getStrategyFeature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AveragingObservation getAveragingRateFeature() {
			return averagingRateFeature;
		}
		
		@Override
		public Barrier getBarrier() {
			return barrier;
		}
		
		@Override
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public Knock getKnock() {
			return knock;
		}
		
		@Override
		public PassThrough getPassThrough() {
			return passThrough;
		}
		
		@Override
		public StrategyFeature getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public OptionFeature build() {
			return this;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			OptionFeature.OptionFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionFeature.OptionFeatureBuilder builder) {
			ofNullable(getAveragingRateFeature()).ifPresent(builder::setAveragingRateFeature);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getPassThrough()).ifPresent(builder::setPassThrough);
			ofNullable(getStrategyFeature()).ifPresent(builder::setStrategyFeature);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(averagingRateFeature, _that.getAveragingRateFeature())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingRateFeature != null ? averagingRateFeature.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeature {" +
				"averagingRateFeature=" + this.averagingRateFeature + ", " +
				"barrier=" + this.barrier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}';
		}
	}
	
	//OptionFeature.OptionFeatureBuilderImpl
	class OptionFeatureBuilderImpl implements OptionFeature.OptionFeatureBuilder {
	
		protected AveragingObservation.AveragingObservationBuilder averagingRateFeature;
		protected Barrier.BarrierBuilder barrier;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected Knock.KnockBuilder knock;
		protected PassThrough.PassThroughBuilder passThrough;
		protected StrategyFeature.StrategyFeatureBuilder strategyFeature;
	
		public OptionFeatureBuilderImpl() {
		}
	
		@Override
		public AveragingObservation.AveragingObservationBuilder getAveragingRateFeature() {
			return averagingRateFeature;
		}
		
		@Override
		public AveragingObservation.AveragingObservationBuilder getOrCreateAveragingRateFeature() {
			AveragingObservation.AveragingObservationBuilder result;
			if (averagingRateFeature!=null) {
				result = averagingRateFeature;
			}
			else {
				result = averagingRateFeature = AveragingObservation.builder();
			}
			
			return result;
		}
		
		@Override
		public Barrier.BarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public Barrier.BarrierBuilder getOrCreateBarrier() {
			Barrier.BarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = Barrier.builder();
			}
			
			return result;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		public Knock.KnockBuilder getKnock() {
			return knock;
		}
		
		@Override
		public Knock.KnockBuilder getOrCreateKnock() {
			Knock.KnockBuilder result;
			if (knock!=null) {
				result = knock;
			}
			else {
				result = knock = Knock.builder();
			}
			
			return result;
		}
		
		@Override
		public PassThrough.PassThroughBuilder getPassThrough() {
			return passThrough;
		}
		
		@Override
		public PassThrough.PassThroughBuilder getOrCreatePassThrough() {
			PassThrough.PassThroughBuilder result;
			if (passThrough!=null) {
				result = passThrough;
			}
			else {
				result = passThrough = PassThrough.builder();
			}
			
			return result;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature() {
			StrategyFeature.StrategyFeatureBuilder result;
			if (strategyFeature!=null) {
				result = strategyFeature;
			}
			else {
				result = strategyFeature = StrategyFeature.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionFeature.OptionFeatureBuilder setAveragingRateFeature(AveragingObservation averagingRateFeature) {
			this.averagingRateFeature = averagingRateFeature==null?null:averagingRateFeature.toBuilder();
			return this;
		}
		@Override
		public OptionFeature.OptionFeatureBuilder setBarrier(Barrier barrier) {
			this.barrier = barrier==null?null:barrier.toBuilder();
			return this;
		}
		@Override
		public OptionFeature.OptionFeatureBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		public OptionFeature.OptionFeatureBuilder setKnock(Knock knock) {
			this.knock = knock==null?null:knock.toBuilder();
			return this;
		}
		@Override
		public OptionFeature.OptionFeatureBuilder setPassThrough(PassThrough passThrough) {
			this.passThrough = passThrough==null?null:passThrough.toBuilder();
			return this;
		}
		@Override
		public OptionFeature.OptionFeatureBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		
		@Override
		public OptionFeature build() {
			return new OptionFeature.OptionFeatureImpl(this);
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder prune() {
			if (averagingRateFeature!=null && !averagingRateFeature.prune().hasData()) averagingRateFeature = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (knock!=null && !knock.prune().hasData()) knock = null;
			if (passThrough!=null && !passThrough.prune().hasData()) passThrough = null;
			if (strategyFeature!=null && !strategyFeature.prune().hasData()) strategyFeature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAveragingRateFeature()!=null && getAveragingRateFeature().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getKnock()!=null && getKnock().hasData()) return true;
			if (getPassThrough()!=null && getPassThrough().hasData()) return true;
			if (getStrategyFeature()!=null && getStrategyFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionFeature.OptionFeatureBuilder o = (OptionFeature.OptionFeatureBuilder) other;
			
			merger.mergeRosetta(getAveragingRateFeature(), o.getAveragingRateFeature(), this::setAveragingRateFeature);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getKnock(), o.getKnock(), this::setKnock);
			merger.mergeRosetta(getPassThrough(), o.getPassThrough(), this::setPassThrough);
			merger.mergeRosetta(getStrategyFeature(), o.getStrategyFeature(), this::setStrategyFeature);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(averagingRateFeature, _that.getAveragingRateFeature())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (averagingRateFeature != null ? averagingRateFeature.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatureBuilder {" +
				"averagingRateFeature=" + this.averagingRateFeature + ", " +
				"barrier=" + this.barrier + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}';
		}
	}
}
