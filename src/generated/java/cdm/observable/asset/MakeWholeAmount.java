package cdm.observable.asset;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationBuilder;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationBuilderImpl;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationImpl;
import cdm.observable.asset.meta.MakeWholeAmountMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate.FieldWithMetaDateBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date (typically applicable to the convertible bond options).
 * @version ${project.version}
 */
@RosettaClass

public interface MakeWholeAmount extends SwapCurveValuation {
	MakeWholeAmount build();
	MakeWholeAmount.MakeWholeAmountBuilder toBuilder();
	
	/**
	 * Date prior to which the option buyer will have to pay a Make Whole Amount to the option seller if he/she exercises the option.
	 */
	FieldWithMetaDate getEarlyCallDate();
	/**
	 * The type of interpolation method that the calculation agent reserves the right to use.
	 */
	InterpolationMethodEnum getInterpolationMethod();
	final static MakeWholeAmountMeta metaData = new MakeWholeAmountMeta();
	
	@Override
	default RosettaMetaData<? extends MakeWholeAmount> metaData() {
		return metaData;
	} 
			
	static MakeWholeAmount.MakeWholeAmountBuilder builder() {
		return new MakeWholeAmount.MakeWholeAmountBuilderImpl();
	}
	
	default Class<? extends MakeWholeAmount> getType() {
		return MakeWholeAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.observable.asset.SwapCurveValuation.super.process(path, processor);
		processor.processBasic(path.newSubPath("interpolationMethod"), InterpolationMethodEnum.class, getInterpolationMethod(), this);
		
		processRosetta(path.newSubPath("earlyCallDate"), processor, FieldWithMetaDate.class, getEarlyCallDate(), AttributeMeta.GLOBAL_KEY_FIELD);
	}
	
	
	interface MakeWholeAmountBuilder extends MakeWholeAmount, SwapCurveValuation.SwapCurveValuationBuilder, RosettaModelObjectBuilder {
		FieldWithMetaDateBuilder getOrCreateEarlyCallDate();
		FieldWithMetaDateBuilder getEarlyCallDate();
		MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(FieldWithMetaDate earlyCallDate);
		MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDateValue(Date earlyCallDate);
		MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethodEnum interpolationMethod);
		MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex);
		MakeWholeAmount.MakeWholeAmountBuilder setIndexTenor(Period indexTenor);
		MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum side);
		MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal spread);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			SwapCurveValuation.SwapCurveValuationBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("interpolationMethod"), InterpolationMethodEnum.class, getInterpolationMethod(), this);
			
			processRosetta(path.newSubPath("earlyCallDate"), processor, FieldWithMetaDateBuilder.class, getEarlyCallDate(), AttributeMeta.GLOBAL_KEY_FIELD);
		}
		
	}
	
	//MakeWholeAmount.MakeWholeAmountImpl
	class MakeWholeAmountImpl extends SwapCurveValuation.SwapCurveValuationImpl implements MakeWholeAmount {
		private final FieldWithMetaDate earlyCallDate;
		private final InterpolationMethodEnum interpolationMethod;
		
		protected MakeWholeAmountImpl(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super(builder);
			this.earlyCallDate = ofNullable(builder.getEarlyCallDate()).map(f->f.build()).orElse(null);
			this.interpolationMethod = builder.getInterpolationMethod();
		}
		
		@Override
		public FieldWithMetaDate getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public InterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public MakeWholeAmount build() {
			return this;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			MakeWholeAmount.MakeWholeAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MakeWholeAmount.MakeWholeAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEarlyCallDate()).ifPresent(builder::setEarlyCallDate);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmount {" +
				"earlyCallDate=" + this.earlyCallDate + ", " +
				"interpolationMethod=" + this.interpolationMethod +
			'}' + " " + super.toString();
		}
	}
	
	//MakeWholeAmount.MakeWholeAmountBuilderImpl
	class MakeWholeAmountBuilderImpl extends SwapCurveValuation.SwapCurveValuationBuilderImpl  implements MakeWholeAmount.MakeWholeAmountBuilder {
	
		protected FieldWithMetaDateBuilder earlyCallDate;
		protected InterpolationMethodEnum interpolationMethod;
	
		public MakeWholeAmountBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaDateBuilder getEarlyCallDate() {
			return earlyCallDate;
		}
		
		@Override
		public FieldWithMetaDateBuilder getOrCreateEarlyCallDate() {
			FieldWithMetaDateBuilder result;
			if (earlyCallDate!=null) {
				result = earlyCallDate;
			}
			else {
				result = earlyCallDate = FieldWithMetaDate.builder();
			}
			
			return result;
		}
		
		@Override
		public InterpolationMethodEnum getInterpolationMethod() {
			return interpolationMethod;
		}
		
	
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDate(FieldWithMetaDate earlyCallDate) {
			this.earlyCallDate = earlyCallDate==null?null:earlyCallDate.toBuilder();
			return this;
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setEarlyCallDateValue(Date earlyCallDate) {
			this.getOrCreateEarlyCallDate().setValue(earlyCallDate);
			return this;
		}
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setInterpolationMethod(InterpolationMethodEnum interpolationMethod) {
			this.interpolationMethod = interpolationMethod==null?null:interpolationMethod;
			return this;
		}
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex;
			return this;
		}
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setSide(QuotationSideEnum side) {
			this.side = side==null?null:side;
			return this;
		}
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		
		@Override
		public MakeWholeAmount build() {
			return new MakeWholeAmount.MakeWholeAmountImpl(this);
		}
		
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder prune() {
			super.prune();
			if (earlyCallDate!=null && !earlyCallDate.prune().hasData()) earlyCallDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEarlyCallDate()!=null) return true;
			if (getInterpolationMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeAmount.MakeWholeAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MakeWholeAmount.MakeWholeAmountBuilder o = (MakeWholeAmount.MakeWholeAmountBuilder) other;
			
			merger.mergeRosetta(getEarlyCallDate(), o.getEarlyCallDate(), this::setEarlyCallDate);
			
			merger.mergeBasic(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MakeWholeAmount _that = getType().cast(o);
		
			if (!Objects.equals(earlyCallDate, _that.getEarlyCallDate())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyCallDate != null ? earlyCallDate.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeAmountBuilder {" +
				"earlyCallDate=" + this.earlyCallDate + ", " +
				"interpolationMethod=" + this.interpolationMethod +
			'}' + " " + super.toString();
		}
	}
}
