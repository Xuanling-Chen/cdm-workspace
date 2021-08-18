package cdm.observable.asset;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.observable.asset.meta.FallbackRateParametersMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure needed to represent fallback rate paramters. This type is used to represent modular computed rates in interestRatePayouts.
 * @version ${project.version}
 */
@RosettaClass

public interface FallbackRateParameters extends RosettaModelObject {
	FallbackRateParameters build();
	FallbackRateParameters.FallbackRateParametersBuilder toBuilder();
	
	/**
	 * Support for modular calculated rates, such such as lockout compound calculations.
	 */
	FloatingRateCalculationParameters getCalculationParameters();
	/**
	 * The date the fallback rate takes effect.
	 */
	Date getEffectiveDate();
	/**
	 * The floating rate index that is used as the basis of the fallback rate.
	 */
	FloatingRateIndexEnum getFloatingRateIndex();
	/**
	 * The economic spread applied to the underlying fallback rate to replicate the original risky rate.
	 */
	BigDecimal getSpreadAdjustment();
	final static FallbackRateParametersMeta metaData = new FallbackRateParametersMeta();
	
	@Override
	default RosettaMetaData<? extends FallbackRateParameters> metaData() {
		return metaData;
	} 
			
	static FallbackRateParameters.FallbackRateParametersBuilder builder() {
		return new FallbackRateParameters.FallbackRateParametersBuilderImpl();
	}
	
	default Class<? extends FallbackRateParameters> getType() {
		return FallbackRateParameters.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
		processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
		
		processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.class, getCalculationParameters());
	}
	
	
	interface FallbackRateParametersBuilder extends FallbackRateParameters, RosettaModelObjectBuilder {
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters();
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters();
		FallbackRateParameters.FallbackRateParametersBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters);
		FallbackRateParameters.FallbackRateParametersBuilder setEffectiveDate(Date effectiveDate);
		FallbackRateParameters.FallbackRateParametersBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex);
		FallbackRateParameters.FallbackRateParametersBuilder setSpreadAdjustment(BigDecimal spreadAdjustment);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("floatingRateIndex"), FloatingRateIndexEnum.class, getFloatingRateIndex(), this);
			processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
			
			processRosetta(path.newSubPath("calculationParameters"), processor, FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder.class, getCalculationParameters());
		}
		
	}
	
	//FallbackRateParameters.FallbackRateParametersImpl
	class FallbackRateParametersImpl implements FallbackRateParameters {
		private final FloatingRateCalculationParameters calculationParameters;
		private final Date effectiveDate;
		private final FloatingRateIndexEnum floatingRateIndex;
		private final BigDecimal spreadAdjustment;
		
		protected FallbackRateParametersImpl(FallbackRateParameters.FallbackRateParametersBuilder builder) {
			this.calculationParameters = ofNullable(builder.getCalculationParameters()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.floatingRateIndex = builder.getFloatingRateIndex();
			this.spreadAdjustment = builder.getSpreadAdjustment();
		}
		
		@Override
		public FloatingRateCalculationParameters getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public FloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		public FallbackRateParameters build() {
			return this;
		}
		
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder toBuilder() {
			FallbackRateParameters.FallbackRateParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackRateParameters.FallbackRateParametersBuilder builder) {
			ofNullable(getCalculationParameters()).ifPresent(builder::setCalculationParameters);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getSpreadAdjustment()).ifPresent(builder::setSpreadAdjustment);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRateParameters _that = getType().cast(o);
		
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRateParameters {" +
				"calculationParameters=" + this.calculationParameters + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}';
		}
	}
	
	//FallbackRateParameters.FallbackRateParametersBuilderImpl
	class FallbackRateParametersBuilderImpl implements FallbackRateParameters.FallbackRateParametersBuilder {
	
		protected FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder calculationParameters;
		protected Date effectiveDate;
		protected FloatingRateIndexEnum floatingRateIndex;
		protected BigDecimal spreadAdjustment;
	
		public FallbackRateParametersBuilderImpl() {
		}
	
		@Override
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder getOrCreateCalculationParameters() {
			FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder result;
			if (calculationParameters!=null) {
				result = calculationParameters;
			}
			else {
				result = calculationParameters = FloatingRateCalculationParameters.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public FloatingRateIndexEnum getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
	
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder setCalculationParameters(FloatingRateCalculationParameters calculationParameters) {
			this.calculationParameters = calculationParameters==null?null:calculationParameters.toBuilder();
			return this;
		}
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder setFloatingRateIndex(FloatingRateIndexEnum floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex;
			return this;
		}
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder setSpreadAdjustment(BigDecimal spreadAdjustment) {
			this.spreadAdjustment = spreadAdjustment==null?null:spreadAdjustment;
			return this;
		}
		
		@Override
		public FallbackRateParameters build() {
			return new FallbackRateParameters.FallbackRateParametersImpl(this);
		}
		
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder prune() {
			if (calculationParameters!=null && !calculationParameters.prune().hasData()) calculationParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationParameters()!=null && getCalculationParameters().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getFloatingRateIndex()!=null) return true;
			if (getSpreadAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRateParameters.FallbackRateParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackRateParameters.FallbackRateParametersBuilder o = (FallbackRateParameters.FallbackRateParametersBuilder) other;
			
			merger.mergeRosetta(getCalculationParameters(), o.getCalculationParameters(), this::setCalculationParameters);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeBasic(getSpreadAdjustment(), o.getSpreadAdjustment(), this::setSpreadAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRateParameters _that = getType().cast(o);
		
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRateParametersBuilder {" +
				"calculationParameters=" + this.calculationParameters + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}';
		}
	}
}
