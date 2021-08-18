package cdm.product.common.schedule;

import cdm.product.asset.StubValue;
import cdm.product.common.schedule.meta.StubCalculationPeriodAmountMeta;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates.ReferenceWithMetaCalculationPeriodDatesBuilder;
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
 * A data defining:  how the initial or final stub calculation period amounts is calculated. For example, the rate to be applied to the initial or final stub calculation period may be the linear interpolation of two different tenors for the floating rate index specified in the calculation period amount component, e.g. A two month stub period may used the linear interpolation of a one month and three month floating rate. The different rate tenors would be specified in this component. Note that a maximum of two rate tenors can be specified. If a stub period uses a single index tenor and this is the same as that specified in the calculation period amount component then the initial stub or final stub component, as the case may be, must not be included.
 * @version ${project.version}
 */
@RosettaClass

public interface StubCalculationPeriodAmount extends RosettaModelObject {
	StubCalculationPeriodAmount build();
	StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder toBuilder();
	
	/**
	 * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 */
	ReferenceWithMetaCalculationPeriodDates getCalculationPeriodDatesReference();
	/**
	 * Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
	 */
	StubValue getFinalStub();
	/**
	 * Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
	 */
	StubValue getInitialStub();
	final static StubCalculationPeriodAmountMeta metaData = new StubCalculationPeriodAmountMeta();
	
	@Override
	default RosettaMetaData<? extends StubCalculationPeriodAmount> metaData() {
		return metaData;
	} 
			
	static StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder builder() {
		return new StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilderImpl();
	}
	
	default Class<? extends StubCalculationPeriodAmount> getType() {
		return StubCalculationPeriodAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDates.class, getCalculationPeriodDatesReference());
		processRosetta(path.newSubPath("finalStub"), processor, StubValue.class, getFinalStub());
		processRosetta(path.newSubPath("initialStub"), processor, StubValue.class, getInitialStub());
	}
	
	
	interface StubCalculationPeriodAmountBuilder extends StubCalculationPeriodAmount, RosettaModelObjectBuilder {
		ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference();
		ReferenceWithMetaCalculationPeriodDatesBuilder getCalculationPeriodDatesReference();
		StubValue.StubValueBuilder getOrCreateFinalStub();
		StubValue.StubValueBuilder getFinalStub();
		StubValue.StubValueBuilder getOrCreateInitialStub();
		StubValue.StubValueBuilder getInitialStub();
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference);
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference);
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setFinalStub(StubValue finalStub);
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setInitialStub(StubValue initialStub);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, ReferenceWithMetaCalculationPeriodDatesBuilder.class, getCalculationPeriodDatesReference());
			processRosetta(path.newSubPath("finalStub"), processor, StubValue.StubValueBuilder.class, getFinalStub());
			processRosetta(path.newSubPath("initialStub"), processor, StubValue.StubValueBuilder.class, getInitialStub());
		}
		
	}
	
	//StubCalculationPeriodAmount.StubCalculationPeriodAmountImpl
	class StubCalculationPeriodAmountImpl implements StubCalculationPeriodAmount {
		private final ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference;
		private final StubValue finalStub;
		private final StubValue initialStub;
		
		protected StubCalculationPeriodAmountImpl(StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.finalStub = ofNullable(builder.getFinalStub()).map(f->f.build()).orElse(null);
			this.initialStub = ofNullable(builder.getInitialStub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaCalculationPeriodDates getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public StubValue getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubValue getInitialStub() {
			return initialStub;
		}
		
		@Override
		public StubCalculationPeriodAmount build() {
			return this;
		}
		
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder toBuilder() {
			StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getFinalStub()).ifPresent(builder::setFinalStub);
			ofNullable(getInitialStub()).ifPresent(builder::setInitialStub);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodAmount {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"finalStub=" + this.finalStub + ", " +
				"initialStub=" + this.initialStub +
			'}';
		}
	}
	
	//StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilderImpl
	class StubCalculationPeriodAmountBuilderImpl implements StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder {
	
		protected ReferenceWithMetaCalculationPeriodDatesBuilder calculationPeriodDatesReference;
		protected StubValue.StubValueBuilder finalStub;
		protected StubValue.StubValueBuilder initialStub;
	
		public StubCalculationPeriodAmountBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaCalculationPeriodDatesBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public ReferenceWithMetaCalculationPeriodDatesBuilder getOrCreateCalculationPeriodDatesReference() {
			ReferenceWithMetaCalculationPeriodDatesBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = ReferenceWithMetaCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		public StubValue.StubValueBuilder getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubValue.StubValueBuilder getOrCreateFinalStub() {
			StubValue.StubValueBuilder result;
			if (finalStub!=null) {
				result = finalStub;
			}
			else {
				result = finalStub = StubValue.builder();
			}
			
			return result;
		}
		
		@Override
		public StubValue.StubValueBuilder getInitialStub() {
			return initialStub;
		}
		
		@Override
		public StubValue.StubValueBuilder getOrCreateInitialStub() {
			StubValue.StubValueBuilder result;
			if (initialStub!=null) {
				result = initialStub;
			}
			else {
				result = initialStub = StubValue.builder();
			}
			
			return result;
		}
		
	
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setCalculationPeriodDatesReference(ReferenceWithMetaCalculationPeriodDates calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = calculationPeriodDatesReference==null?null:calculationPeriodDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setCalculationPeriodDatesReferenceValue(CalculationPeriodDates calculationPeriodDatesReference) {
			this.getOrCreateCalculationPeriodDatesReference().setValue(calculationPeriodDatesReference);
			return this;
		}
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setFinalStub(StubValue finalStub) {
			this.finalStub = finalStub==null?null:finalStub.toBuilder();
			return this;
		}
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder setInitialStub(StubValue initialStub) {
			this.initialStub = initialStub==null?null:initialStub.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriodAmount build() {
			return new StubCalculationPeriodAmount.StubCalculationPeriodAmountImpl(this);
		}
		
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (finalStub!=null && !finalStub.prune().hasData()) finalStub = null;
			if (initialStub!=null && !initialStub.prune().hasData()) initialStub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getFinalStub()!=null && getFinalStub().hasData()) return true;
			if (getInitialStub()!=null && getInitialStub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder o = (StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getFinalStub(), o.getFinalStub(), this::setFinalStub);
			merger.mergeRosetta(getInitialStub(), o.getInitialStub(), this::setInitialStub);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodAmountBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"finalStub=" + this.finalStub + ", " +
				"initialStub=" + this.initialStub +
			'}';
		}
	}
}
