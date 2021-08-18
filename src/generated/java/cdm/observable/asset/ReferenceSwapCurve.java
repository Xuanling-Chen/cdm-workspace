package cdm.observable.asset;

import cdm.observable.asset.meta.ReferenceSwapCurveMeta;
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
 * A complex type used to specify the option and convertible bond option strike when expressed in reference to a swap curve.
 * @version ${project.version}
 */
@RosettaClass

public interface ReferenceSwapCurve extends RosettaModelObject {
	ReferenceSwapCurve build();
	ReferenceSwapCurve.ReferenceSwapCurveBuilder toBuilder();
	
	/**
	 * Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)
	 */
	MakeWholeAmount getMakeWholeAmount();
	/**
	 */
	SwapCurveValuation getSwapUnwindValue();
	final static ReferenceSwapCurveMeta metaData = new ReferenceSwapCurveMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceSwapCurve> metaData() {
		return metaData;
	} 
			
	static ReferenceSwapCurve.ReferenceSwapCurveBuilder builder() {
		return new ReferenceSwapCurve.ReferenceSwapCurveBuilderImpl();
	}
	
	default Class<? extends ReferenceSwapCurve> getType() {
		return ReferenceSwapCurve.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("makeWholeAmount"), processor, MakeWholeAmount.class, getMakeWholeAmount());
		processRosetta(path.newSubPath("swapUnwindValue"), processor, SwapCurveValuation.class, getSwapUnwindValue());
	}
	
	
	interface ReferenceSwapCurveBuilder extends ReferenceSwapCurve, RosettaModelObjectBuilder {
		MakeWholeAmount.MakeWholeAmountBuilder getOrCreateMakeWholeAmount();
		MakeWholeAmount.MakeWholeAmountBuilder getMakeWholeAmount();
		SwapCurveValuation.SwapCurveValuationBuilder getOrCreateSwapUnwindValue();
		SwapCurveValuation.SwapCurveValuationBuilder getSwapUnwindValue();
		ReferenceSwapCurve.ReferenceSwapCurveBuilder setMakeWholeAmount(MakeWholeAmount makeWholeAmount);
		ReferenceSwapCurve.ReferenceSwapCurveBuilder setSwapUnwindValue(SwapCurveValuation swapUnwindValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("makeWholeAmount"), processor, MakeWholeAmount.MakeWholeAmountBuilder.class, getMakeWholeAmount());
			processRosetta(path.newSubPath("swapUnwindValue"), processor, SwapCurveValuation.SwapCurveValuationBuilder.class, getSwapUnwindValue());
		}
		
	}
	
	//ReferenceSwapCurve.ReferenceSwapCurveImpl
	class ReferenceSwapCurveImpl implements ReferenceSwapCurve {
		private final MakeWholeAmount makeWholeAmount;
		private final SwapCurveValuation swapUnwindValue;
		
		protected ReferenceSwapCurveImpl(ReferenceSwapCurve.ReferenceSwapCurveBuilder builder) {
			this.makeWholeAmount = ofNullable(builder.getMakeWholeAmount()).map(f->f.build()).orElse(null);
			this.swapUnwindValue = ofNullable(builder.getSwapUnwindValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MakeWholeAmount getMakeWholeAmount() {
			return makeWholeAmount;
		}
		
		@Override
		public SwapCurveValuation getSwapUnwindValue() {
			return swapUnwindValue;
		}
		
		@Override
		public ReferenceSwapCurve build() {
			return this;
		}
		
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder toBuilder() {
			ReferenceSwapCurve.ReferenceSwapCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceSwapCurve.ReferenceSwapCurveBuilder builder) {
			ofNullable(getMakeWholeAmount()).ifPresent(builder::setMakeWholeAmount);
			ofNullable(getSwapUnwindValue()).ifPresent(builder::setSwapUnwindValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceSwapCurve _that = getType().cast(o);
		
			if (!Objects.equals(makeWholeAmount, _that.getMakeWholeAmount())) return false;
			if (!Objects.equals(swapUnwindValue, _that.getSwapUnwindValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (makeWholeAmount != null ? makeWholeAmount.hashCode() : 0);
			_result = 31 * _result + (swapUnwindValue != null ? swapUnwindValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceSwapCurve {" +
				"makeWholeAmount=" + this.makeWholeAmount + ", " +
				"swapUnwindValue=" + this.swapUnwindValue +
			'}';
		}
	}
	
	//ReferenceSwapCurve.ReferenceSwapCurveBuilderImpl
	class ReferenceSwapCurveBuilderImpl implements ReferenceSwapCurve.ReferenceSwapCurveBuilder {
	
		protected MakeWholeAmount.MakeWholeAmountBuilder makeWholeAmount;
		protected SwapCurveValuation.SwapCurveValuationBuilder swapUnwindValue;
	
		public ReferenceSwapCurveBuilderImpl() {
		}
	
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder getMakeWholeAmount() {
			return makeWholeAmount;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder getOrCreateMakeWholeAmount() {
			MakeWholeAmount.MakeWholeAmountBuilder result;
			if (makeWholeAmount!=null) {
				result = makeWholeAmount;
			}
			else {
				result = makeWholeAmount = MakeWholeAmount.builder();
			}
			
			return result;
		}
		
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder getSwapUnwindValue() {
			return swapUnwindValue;
		}
		
		@Override
		public SwapCurveValuation.SwapCurveValuationBuilder getOrCreateSwapUnwindValue() {
			SwapCurveValuation.SwapCurveValuationBuilder result;
			if (swapUnwindValue!=null) {
				result = swapUnwindValue;
			}
			else {
				result = swapUnwindValue = SwapCurveValuation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder setMakeWholeAmount(MakeWholeAmount makeWholeAmount) {
			this.makeWholeAmount = makeWholeAmount==null?null:makeWholeAmount.toBuilder();
			return this;
		}
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder setSwapUnwindValue(SwapCurveValuation swapUnwindValue) {
			this.swapUnwindValue = swapUnwindValue==null?null:swapUnwindValue.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceSwapCurve build() {
			return new ReferenceSwapCurve.ReferenceSwapCurveImpl(this);
		}
		
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder prune() {
			if (makeWholeAmount!=null && !makeWholeAmount.prune().hasData()) makeWholeAmount = null;
			if (swapUnwindValue!=null && !swapUnwindValue.prune().hasData()) swapUnwindValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMakeWholeAmount()!=null && getMakeWholeAmount().hasData()) return true;
			if (getSwapUnwindValue()!=null && getSwapUnwindValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceSwapCurve.ReferenceSwapCurveBuilder o = (ReferenceSwapCurve.ReferenceSwapCurveBuilder) other;
			
			merger.mergeRosetta(getMakeWholeAmount(), o.getMakeWholeAmount(), this::setMakeWholeAmount);
			merger.mergeRosetta(getSwapUnwindValue(), o.getSwapUnwindValue(), this::setSwapUnwindValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceSwapCurve _that = getType().cast(o);
		
			if (!Objects.equals(makeWholeAmount, _that.getMakeWholeAmount())) return false;
			if (!Objects.equals(swapUnwindValue, _that.getSwapUnwindValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (makeWholeAmount != null ? makeWholeAmount.hashCode() : 0);
			_result = 31 * _result + (swapUnwindValue != null ? swapUnwindValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceSwapCurveBuilder {" +
				"makeWholeAmount=" + this.makeWholeAmount + ", " +
				"swapUnwindValue=" + this.swapUnwindValue +
			'}';
		}
	}
}
